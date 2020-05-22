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
    public static final Object lEB = new Object();
    private static long lEC = BdKVCache.MILLS_1Hour;
    private ImageView ehX;
    private TextView lEA;
    private SimpleDateFormat lED;
    private SimpleDateFormat lEE;
    private boolean lEF;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.lEF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lEF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lEF = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.ehX = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.ehX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.lEA = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.lEE = new SimpleDateFormat("mm:ss");
        this.lED = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.lEE.setTimeZone(timeZone);
        this.lED.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.lEF) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ehX.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ehX.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(fu(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ehX.setScaleType(ImageView.ScaleType.CENTER);
            this.ehX.setImageBitmap(null);
            this.ehX.setImageResource(R.drawable.img_default_100);
            this.ehX.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void uV(boolean z) {
        this.lEF = true;
        if (z) {
            this.ehX.setScaleType(ImageView.ScaleType.CENTER);
            this.ehX.setImageBitmap(null);
            this.ehX.setImageResource(0);
            this.ehX.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.lEA.setVisibility(0);
            return;
        }
        this.ehX.setScaleType(ImageView.ScaleType.CENTER);
        this.ehX.setImageResource(0);
        this.ehX.setImageBitmap(null);
        this.ehX.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.lEA.setVisibility(8);
    }

    public void a(d dVar) {
        this.lEF = false;
        this.lEA.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.djr()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fu(long j) {
        return j > lEC ? this.lED.format(Long.valueOf(j)) : this.lEE.format(Long.valueOf(j));
    }
}
