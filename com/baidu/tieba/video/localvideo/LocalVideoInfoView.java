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
    public static final Object hrJ = new Object();
    private static long hrK = 3600000;
    private ImageView bmC;
    private TextView bmx;
    private TextView hrI;
    private SimpleDateFormat hrL;
    private SimpleDateFormat hrM;
    private boolean hrN;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hrN = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrN = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hrN = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.bmC = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.bmC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bmx = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hrI = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hrM = new SimpleDateFormat("mm:ss");
        this.hrL = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hrM.setTimeZone(timeZone);
        this.hrL.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hrN) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.bmC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.bmC.setImageBitmap(dVar.bBO());
                    this.bmx.setText(cW(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.bmC.setScaleType(ImageView.ScaleType.CENTER);
            this.bmC.setImageBitmap(null);
            this.bmC.setImageResource(d.f.img_default_100);
            this.bmC.setBackgroundColor(getResources().getColor(d.C0108d.common_color_10304));
            this.bmx.setText("");
        }
    }

    public void ng(boolean z) {
        this.hrN = true;
        if (z) {
            this.bmC.setScaleType(ImageView.ScaleType.CENTER);
            this.bmC.setImageBitmap(null);
            this.bmC.setImageResource(0);
            this.bmC.setBackgroundColor(getResources().getColor(d.C0108d.cp_bg_line_d));
            this.hrI.setVisibility(0);
            return;
        }
        this.bmC.setScaleType(ImageView.ScaleType.CENTER);
        this.bmC.setImageResource(0);
        this.bmC.setImageBitmap(null);
        this.bmC.setBackgroundColor(getResources().getColor(d.C0108d.white_alpha50));
        this.bmx.setText("");
        this.hrI.setVisibility(8);
    }

    public void a(d dVar) {
        this.hrN = false;
        this.hrI.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bBP()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cW(long j) {
        return j > hrK ? this.hrL.format(Long.valueOf(j)) : this.hrM.format(Long.valueOf(j));
    }
}
