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
    private ImageView dpf;
    private SimpleDateFormat kyB;
    private SimpleDateFormat kyC;
    private boolean kyD;
    private TextView kyy;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;
    public static final Object kyz = new Object();
    private static long kyA = BdKVCache.MILLS_1Hour;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.kyD = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kyD = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kyD = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dpf = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dpf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.kyy = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.kyC = new SimpleDateFormat("mm:ss");
        this.kyB = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kyC.setTimeZone(timeZone);
        this.kyB.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.kyD) {
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
        this.kyD = true;
        if (z) {
            this.dpf.setScaleType(ImageView.ScaleType.CENTER);
            this.dpf.setImageBitmap(null);
            this.dpf.setImageResource(0);
            this.dpf.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.kyy.setVisibility(0);
            return;
        }
        this.dpf.setScaleType(ImageView.ScaleType.CENTER);
        this.dpf.setImageResource(0);
        this.dpf.setImageBitmap(null);
        this.dpf.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.kyy.setVisibility(8);
    }

    public void a(d dVar) {
        this.kyD = false;
        this.kyy.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.hasLoaded()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eJ(long j) {
        return j > kyA ? this.kyB.format(Long.valueOf(j)) : this.kyC.format(Long.valueOf(j));
    }
}
