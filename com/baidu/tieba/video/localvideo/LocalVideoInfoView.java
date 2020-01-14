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
/* loaded from: classes8.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object kyE = new Object();
    private static long kyF = BdKVCache.MILLS_1Hour;
    private ImageView dpf;
    private TextView kyD;
    private SimpleDateFormat kyG;
    private SimpleDateFormat kyH;
    private boolean kyI;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.kyI = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kyI = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kyI = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dpf = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dpf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.kyD = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.kyH = new SimpleDateFormat("mm:ss");
        this.kyG = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kyH.setTimeZone(timeZone);
        this.kyG.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.kyI) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.dpf.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.dpf.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(eJ(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.dpf.setScaleType(ImageView.ScaleType.CENTER);
            this.dpf.setImageBitmap(null);
            this.dpf.setImageResource(R.drawable.img_default_100);
            this.dpf.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void tm(boolean z) {
        this.kyI = true;
        if (z) {
            this.dpf.setScaleType(ImageView.ScaleType.CENTER);
            this.dpf.setImageBitmap(null);
            this.dpf.setImageResource(0);
            this.dpf.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.kyD.setVisibility(0);
            return;
        }
        this.dpf.setScaleType(ImageView.ScaleType.CENTER);
        this.dpf.setImageResource(0);
        this.dpf.setImageBitmap(null);
        this.dpf.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.kyD.setVisibility(8);
    }

    public void a(d dVar) {
        this.kyI = false;
        this.kyD.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.hasLoaded()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eJ(long j) {
        return j > kyF ? this.kyG.format(Long.valueOf(j)) : this.kyH.format(Long.valueOf(j));
    }
}
