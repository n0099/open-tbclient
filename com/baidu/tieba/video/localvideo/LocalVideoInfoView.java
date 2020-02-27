package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* loaded from: classes10.dex */
public class LocalVideoInfoView extends RelativeLayout {
    private ImageView dtn;
    private SimpleDateFormat kzB;
    private SimpleDateFormat kzC;
    private boolean kzD;
    private TextView kzy;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;
    public static final Object kzz = new Object();
    private static long kzA = BdKVCache.MILLS_1Hour;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.kzD = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kzD = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzD = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dtn = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dtn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.kzy = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.kzC = new SimpleDateFormat("mm:ss");
        this.kzB = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kzC.setTimeZone(timeZone);
        this.kzB.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.kzD) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.dtn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.dtn.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(eH(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.dtn.setScaleType(ImageView.ScaleType.CENTER);
            this.dtn.setImageBitmap(null);
            this.dtn.setImageResource(R.drawable.img_default_100);
            this.dtn.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void tq(boolean z) {
        this.kzD = true;
        if (z) {
            this.dtn.setScaleType(ImageView.ScaleType.CENTER);
            this.dtn.setImageBitmap(null);
            this.dtn.setImageResource(0);
            this.dtn.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.kzy.setVisibility(0);
            return;
        }
        this.dtn.setScaleType(ImageView.ScaleType.CENTER);
        this.dtn.setImageResource(0);
        this.dtn.setImageBitmap(null);
        this.dtn.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.kzy.setVisibility(8);
    }

    public void a(d dVar) {
        this.kzD = false;
        this.kzy.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.hasLoaded()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eH(long j) {
        return j > kzA ? this.kzB.format(Long.valueOf(j)) : this.kzC.format(Long.valueOf(j));
    }
}
