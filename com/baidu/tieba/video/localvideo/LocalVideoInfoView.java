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
    public static final Object gwE = new Object();
    private static long gwF = 3600000;
    private TextView awN;
    private ImageView awS;
    private TextView gwD;
    private SimpleDateFormat gwG;
    private SimpleDateFormat gwH;
    private boolean gwI;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gwI = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwI = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwI = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.j.local_video_info_view, (ViewGroup) null);
        this.awS = (ImageView) this.mRootView.findViewById(d.h.local_video_selet_thumb);
        this.awS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.awN = (TextView) this.mRootView.findViewById(d.h.local_video_select_duration);
        this.gwD = (TextView) this.mRootView.findViewById(d.h.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gwH = new SimpleDateFormat("mm:ss");
        this.gwG = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gwH.setTimeZone(timeZone);
        this.gwG.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gwI) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.awS.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.awS.setImageBitmap(dVar.bwp());
                    this.awN.setText(cT(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.awS.setScaleType(ImageView.ScaleType.CENTER);
            this.awS.setImageBitmap(null);
            this.awS.setImageResource(d.g.img_default_100);
            this.awS.setBackgroundColor(getResources().getColor(d.e.common_color_10304));
            this.awN.setText("");
        }
    }

    public void lj(boolean z) {
        this.gwI = true;
        if (z) {
            this.awS.setScaleType(ImageView.ScaleType.CENTER);
            this.awS.setImageBitmap(null);
            this.awS.setImageResource(0);
            this.awS.setBackgroundColor(getResources().getColor(d.e.cp_bg_line_d));
            this.gwD.setVisibility(0);
            return;
        }
        this.awS.setScaleType(ImageView.ScaleType.CENTER);
        this.awS.setImageResource(0);
        this.awS.setImageBitmap(null);
        this.awS.setBackgroundColor(getResources().getColor(d.e.white_alpha50));
        this.awN.setText("");
        this.gwD.setVisibility(8);
    }

    public void a(d dVar) {
        this.gwI = false;
        this.gwD.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bwq()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cT(long j) {
        return j > gwF ? this.gwG.format(Long.valueOf(j)) : this.gwH.format(Long.valueOf(j));
    }
}
