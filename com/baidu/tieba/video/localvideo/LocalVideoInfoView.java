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
    public static final Object gwT = new Object();
    private static long gwU = 3600000;
    private TextView awZ;
    private ImageView axe;
    private TextView gwS;
    private SimpleDateFormat gwV;
    private SimpleDateFormat gwW;
    private boolean gwX;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gwX = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwX = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwX = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.j.local_video_info_view, (ViewGroup) null);
        this.axe = (ImageView) this.mRootView.findViewById(d.h.local_video_selet_thumb);
        this.axe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.awZ = (TextView) this.mRootView.findViewById(d.h.local_video_select_duration);
        this.gwS = (TextView) this.mRootView.findViewById(d.h.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gwW = new SimpleDateFormat("mm:ss");
        this.gwV = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gwW.setTimeZone(timeZone);
        this.gwV.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gwX) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.axe.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.axe.setImageBitmap(dVar.bwy());
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
        this.gwX = true;
        if (z) {
            this.axe.setScaleType(ImageView.ScaleType.CENTER);
            this.axe.setImageBitmap(null);
            this.axe.setImageResource(0);
            this.axe.setBackgroundColor(getResources().getColor(d.e.cp_bg_line_d));
            this.gwS.setVisibility(0);
            return;
        }
        this.axe.setScaleType(ImageView.ScaleType.CENTER);
        this.axe.setImageResource(0);
        this.axe.setImageBitmap(null);
        this.axe.setBackgroundColor(getResources().getColor(d.e.white_alpha50));
        this.awZ.setText("");
        this.gwS.setVisibility(8);
    }

    public void a(d dVar) {
        this.gwX = false;
        this.gwS.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bwz()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cS(long j) {
        return j > gwU ? this.gwV.format(Long.valueOf(j)) : this.gwW.format(Long.valueOf(j));
    }
}
