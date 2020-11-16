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
/* loaded from: classes22.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object nrX = new Object();
    private static long nrY = BdKVCache.MILLS_1Hour;
    private ImageView fjp;
    private Context mContext;
    private View mRootView;
    private TextView nrW;
    private SimpleDateFormat nrZ;
    private SimpleDateFormat nsa;
    private boolean nsb;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.nsb = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nsb = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nsb = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.fjp = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.fjp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.nrW = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.nsa = new SimpleDateFormat("mm:ss");
        this.nrZ = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nsa.setTimeZone(timeZone);
        this.nrZ.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.nsb) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.fjp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.fjp.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(hf(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.fjp.setScaleType(ImageView.ScaleType.CENTER);
            this.fjp.setImageBitmap(null);
            this.fjp.setImageResource(R.drawable.img_default_100);
            this.fjp.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void yf(boolean z) {
        this.nsb = true;
        if (z) {
            this.fjp.setScaleType(ImageView.ScaleType.CENTER);
            this.fjp.setImageBitmap(null);
            this.fjp.setImageResource(0);
            this.fjp.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.nrW.setVisibility(0);
            return;
        }
        this.fjp.setScaleType(ImageView.ScaleType.CENTER);
        this.fjp.setImageResource(0);
        this.fjp.setImageBitmap(null);
        this.fjp.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.nrW.setVisibility(8);
    }

    public void a(d dVar) {
        this.nsb = false;
        this.nrW.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dPZ()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String hf(long j) {
        return j > nrY ? this.nrZ.format(Long.valueOf(j)) : this.nsa.format(Long.valueOf(j));
    }
}
