package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object hvS = new Object();
    private static long hvT = 3600000;
    private TextView aQj;
    private ImageView aQn;
    private TextView hvR;
    private SimpleDateFormat hvU;
    private SimpleDateFormat hvV;
    private boolean hvW;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hvW = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvW = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvW = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(e.h.local_video_info_view, (ViewGroup) null);
        this.aQn = (ImageView) this.mRootView.findViewById(e.g.local_video_selet_thumb);
        this.aQn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aQj = (TextView) this.mRootView.findViewById(e.g.local_video_select_duration);
        this.hvR = (TextView) this.mRootView.findViewById(e.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hvV = new SimpleDateFormat("mm:ss");
        this.hvU = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hvV.setTimeZone(timeZone);
        this.hvU.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hvW) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aQn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aQn.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aQj.setText(di(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aQn.setScaleType(ImageView.ScaleType.CENTER);
            this.aQn.setImageBitmap(null);
            this.aQn.setImageResource(e.f.img_default_100);
            this.aQn.setBackgroundColor(getResources().getColor(e.d.common_color_10304));
            this.aQj.setText("");
        }
    }

    public void nJ(boolean z) {
        this.hvW = true;
        if (z) {
            this.aQn.setScaleType(ImageView.ScaleType.CENTER);
            this.aQn.setImageBitmap(null);
            this.aQn.setImageResource(0);
            this.aQn.setBackgroundColor(getResources().getColor(e.d.cp_bg_line_d));
            this.hvR.setVisibility(0);
            return;
        }
        this.aQn.setScaleType(ImageView.ScaleType.CENTER);
        this.aQn.setImageResource(0);
        this.aQn.setImageBitmap(null);
        this.aQn.setBackgroundColor(getResources().getColor(e.d.white_alpha50));
        this.aQj.setText("");
        this.hvR.setVisibility(8);
    }

    public void a(d dVar) {
        this.hvW = false;
        this.hvR.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bIa()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String di(long j) {
        return j > hvT ? this.hvU.format(Long.valueOf(j)) : this.hvV.format(Long.valueOf(j));
    }
}
