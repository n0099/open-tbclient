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
    public static final Object gwS = new Object();
    private static long gwT = 3600000;
    private TextView awZ;
    private ImageView axe;
    private TextView gwR;
    private SimpleDateFormat gwU;
    private SimpleDateFormat gwV;
    private boolean gwW;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gwW = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwW = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwW = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.j.local_video_info_view, (ViewGroup) null);
        this.axe = (ImageView) this.mRootView.findViewById(d.h.local_video_selet_thumb);
        this.axe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.awZ = (TextView) this.mRootView.findViewById(d.h.local_video_select_duration);
        this.gwR = (TextView) this.mRootView.findViewById(d.h.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gwV = new SimpleDateFormat("mm:ss");
        this.gwU = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gwV.setTimeZone(timeZone);
        this.gwU.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gwW) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.axe.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.axe.setImageBitmap(dVar.bwx());
                    this.awZ.setText(cS(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.axe.setScaleType(ImageView.ScaleType.CENTER);
            this.axe.setImageBitmap(null);
            this.axe.setImageResource(d.g.img_default_100);
            this.axe.setBackgroundColor(getResources().getColor(d.e.common_color_10304));
            this.awZ.setText("");
        }
    }

    public void lk(boolean z) {
        this.gwW = true;
        if (z) {
            this.axe.setScaleType(ImageView.ScaleType.CENTER);
            this.axe.setImageBitmap(null);
            this.axe.setImageResource(0);
            this.axe.setBackgroundColor(getResources().getColor(d.e.cp_bg_line_d));
            this.gwR.setVisibility(0);
            return;
        }
        this.axe.setScaleType(ImageView.ScaleType.CENTER);
        this.axe.setImageResource(0);
        this.axe.setImageBitmap(null);
        this.axe.setBackgroundColor(getResources().getColor(d.e.white_alpha50));
        this.awZ.setText("");
        this.gwR.setVisibility(8);
    }

    public void a(d dVar) {
        this.gwW = false;
        this.gwR.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bwy()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cS(long j) {
        return j > gwT ? this.gwU.format(Long.valueOf(j)) : this.gwV.format(Long.valueOf(j));
    }
}
