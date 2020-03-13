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
    public static final Object kzN = new Object();
    private static long kzO = BdKVCache.MILLS_1Hour;
    private ImageView dtB;
    private TextView kzM;
    private SimpleDateFormat kzP;
    private SimpleDateFormat kzQ;
    private boolean kzR;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.kzR = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kzR = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzR = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dtB = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dtB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.kzM = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.kzQ = new SimpleDateFormat("mm:ss");
        this.kzP = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kzQ.setTimeZone(timeZone);
        this.kzP.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.kzR) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.dtB.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.dtB.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(eH(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.dtB.setScaleType(ImageView.ScaleType.CENTER);
            this.dtB.setImageBitmap(null);
            this.dtB.setImageResource(R.drawable.img_default_100);
            this.dtB.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void tq(boolean z) {
        this.kzR = true;
        if (z) {
            this.dtB.setScaleType(ImageView.ScaleType.CENTER);
            this.dtB.setImageBitmap(null);
            this.dtB.setImageResource(0);
            this.dtB.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.kzM.setVisibility(0);
            return;
        }
        this.dtB.setScaleType(ImageView.ScaleType.CENTER);
        this.dtB.setImageResource(0);
        this.dtB.setImageBitmap(null);
        this.dtB.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.kzM.setVisibility(8);
    }

    public void a(d dVar) {
        this.kzR = false;
        this.kzM.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.hasLoaded()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eH(long j) {
        return j > kzO ? this.kzP.format(Long.valueOf(j)) : this.kzQ.format(Long.valueOf(j));
    }
}
