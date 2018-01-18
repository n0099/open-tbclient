package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object hrp = new Object();
    private static long hrq = 3600000;
    private TextView bmp;
    private ImageView bmu;
    private TextView hro;
    private SimpleDateFormat hrr;
    private SimpleDateFormat hrs;
    private boolean hrt;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hrt = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrt = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hrt = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.bmu = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.bmu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bmp = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hro = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hrs = new SimpleDateFormat("mm:ss");
        this.hrr = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hrs.setTimeZone(timeZone);
        this.hrr.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hrt) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.bmu.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.bmu.setImageBitmap(dVar.bBM());
                    this.bmp.setText(cU(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.bmu.setScaleType(ImageView.ScaleType.CENTER);
            this.bmu.setImageBitmap(null);
            this.bmu.setImageResource(d.f.img_default_100);
            this.bmu.setBackgroundColor(getResources().getColor(d.C0107d.common_color_10304));
            this.bmp.setText("");
        }
    }

    public void nd(boolean z) {
        this.hrt = true;
        if (z) {
            this.bmu.setScaleType(ImageView.ScaleType.CENTER);
            this.bmu.setImageBitmap(null);
            this.bmu.setImageResource(0);
            this.bmu.setBackgroundColor(getResources().getColor(d.C0107d.cp_bg_line_d));
            this.hro.setVisibility(0);
            return;
        }
        this.bmu.setScaleType(ImageView.ScaleType.CENTER);
        this.bmu.setImageResource(0);
        this.bmu.setImageBitmap(null);
        this.bmu.setBackgroundColor(getResources().getColor(d.C0107d.white_alpha50));
        this.bmp.setText("");
        this.hro.setVisibility(8);
    }

    public void a(d dVar) {
        this.hrt = false;
        this.hro.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bBN()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cU(long j) {
        return j > hrq ? this.hrr.format(Long.valueOf(j)) : this.hrs.format(Long.valueOf(j));
    }
}
