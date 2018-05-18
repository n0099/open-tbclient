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
    public static final Object gPQ = new Object();
    private static long gPR = 3600000;
    private TextView azb;
    private ImageView azg;
    private TextView gPP;
    private SimpleDateFormat gPS;
    private SimpleDateFormat gPT;
    private boolean gPU;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gPU = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gPU = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gPU = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.i.local_video_info_view, (ViewGroup) null);
        this.azg = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.azg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.azb = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.gPP = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gPT = new SimpleDateFormat("mm:ss");
        this.gPS = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gPT.setTimeZone(timeZone);
        this.gPS.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gPU) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.azg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.azg.setImageBitmap(dVar.bxE());
                    this.azb.setText(cX(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.azg.setScaleType(ImageView.ScaleType.CENTER);
            this.azg.setImageBitmap(null);
            this.azg.setImageResource(d.f.img_default_100);
            this.azg.setBackgroundColor(getResources().getColor(d.C0126d.common_color_10304));
            this.azb.setText("");
        }
    }

    public void mV(boolean z) {
        this.gPU = true;
        if (z) {
            this.azg.setScaleType(ImageView.ScaleType.CENTER);
            this.azg.setImageBitmap(null);
            this.azg.setImageResource(0);
            this.azg.setBackgroundColor(getResources().getColor(d.C0126d.cp_bg_line_d));
            this.gPP.setVisibility(0);
            return;
        }
        this.azg.setScaleType(ImageView.ScaleType.CENTER);
        this.azg.setImageResource(0);
        this.azg.setImageBitmap(null);
        this.azg.setBackgroundColor(getResources().getColor(d.C0126d.white_alpha50));
        this.azb.setText("");
        this.gPP.setVisibility(8);
    }

    public void a(d dVar) {
        this.gPU = false;
        this.gPP.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bxF()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cX(long j) {
        return j > gPR ? this.gPS.format(Long.valueOf(j)) : this.gPT.format(Long.valueOf(j));
    }
}
