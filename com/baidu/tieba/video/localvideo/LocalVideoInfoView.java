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
/* loaded from: classes5.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object iZu = new Object();
    private static long iZv = 3600000;
    private ImageView agK;
    private TextView ahO;
    private TextView iZt;
    private SimpleDateFormat iZw;
    private SimpleDateFormat iZx;
    private boolean iZy;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.iZy = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZy = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZy = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.agK = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.agK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahO = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.iZt = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.iZx = new SimpleDateFormat("mm:ss");
        this.iZw = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.iZx.setTimeZone(timeZone);
        this.iZw.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.iZy) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.agK.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.agK.setImageBitmap(dVar.getThumbnailBitmap());
                    this.ahO.setText(dW(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.agK.setScaleType(ImageView.ScaleType.CENTER);
            this.agK.setImageBitmap(null);
            this.agK.setImageResource(d.f.img_default_100);
            this.agK.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10304));
            this.ahO.setText("");
        }
    }

    public void qD(boolean z) {
        this.iZy = true;
        if (z) {
            this.agK.setScaleType(ImageView.ScaleType.CENTER);
            this.agK.setImageBitmap(null);
            this.agK.setImageResource(0);
            this.agK.setBackgroundColor(getResources().getColor(d.C0277d.cp_bg_line_d));
            this.iZt.setVisibility(0);
            return;
        }
        this.agK.setScaleType(ImageView.ScaleType.CENTER);
        this.agK.setImageResource(0);
        this.agK.setImageBitmap(null);
        this.agK.setBackgroundColor(getResources().getColor(d.C0277d.white_alpha50));
        this.ahO.setText("");
        this.iZt.setVisibility(8);
    }

    public void a(d dVar) {
        this.iZy = false;
        this.iZt.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.ckB()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dW(long j) {
        return j > iZv ? this.iZw.format(Long.valueOf(j)) : this.iZx.format(Long.valueOf(j));
    }
}
