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
    public static final Object hBM = new Object();
    private static long hBN = 3600000;
    private TextView bmg;
    private ImageView bml;
    private TextView hBL;
    private SimpleDateFormat hBO;
    private SimpleDateFormat hBP;
    private boolean hBQ;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hBQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hBQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hBQ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.bml = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.bml.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bmg = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hBL = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hBP = new SimpleDateFormat("mm:ss");
        this.hBO = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hBP.setTimeZone(timeZone);
        this.hBO.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hBQ) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.bml.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.bml.setImageBitmap(dVar.bIp());
                    this.bmg.setText(dc(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.bml.setScaleType(ImageView.ScaleType.CENTER);
            this.bml.setImageBitmap(null);
            this.bml.setImageResource(d.f.img_default_100);
            this.bml.setBackgroundColor(getResources().getColor(d.C0108d.common_color_10304));
            this.bmg.setText("");
        }
    }

    public void mn(boolean z) {
        this.hBQ = true;
        if (z) {
            this.bml.setScaleType(ImageView.ScaleType.CENTER);
            this.bml.setImageBitmap(null);
            this.bml.setImageResource(0);
            this.bml.setBackgroundColor(getResources().getColor(d.C0108d.cp_bg_line_d));
            this.hBL.setVisibility(0);
            return;
        }
        this.bml.setScaleType(ImageView.ScaleType.CENTER);
        this.bml.setImageResource(0);
        this.bml.setImageBitmap(null);
        this.bml.setBackgroundColor(getResources().getColor(d.C0108d.white_alpha50));
        this.bmg.setText("");
        this.hBL.setVisibility(8);
    }

    public void a(d dVar) {
        this.hBQ = false;
        this.hBL.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bIq()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dc(long j) {
        return j > hBN ? this.hBO.format(Long.valueOf(j)) : this.hBP.format(Long.valueOf(j));
    }
}
