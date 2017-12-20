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
    public static final Object gUD = new Object();
    private static long gUE = 3600000;
    private TextView axY;
    private ImageView ayd;
    private TextView gUC;
    private SimpleDateFormat gUF;
    private SimpleDateFormat gUG;
    private boolean gUH;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gUH = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUH = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gUH = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.ayd = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.ayd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.axY = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.gUC = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gUG = new SimpleDateFormat("mm:ss");
        this.gUF = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gUG.setTimeZone(timeZone);
        this.gUF.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gUH) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ayd.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ayd.setImageBitmap(dVar.bCR());
                    this.axY.setText(dc(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ayd.setScaleType(ImageView.ScaleType.CENTER);
            this.ayd.setImageBitmap(null);
            this.ayd.setImageResource(d.f.img_default_100);
            this.ayd.setBackgroundColor(getResources().getColor(d.C0096d.common_color_10304));
            this.axY.setText("");
        }
    }

    public void lJ(boolean z) {
        this.gUH = true;
        if (z) {
            this.ayd.setScaleType(ImageView.ScaleType.CENTER);
            this.ayd.setImageBitmap(null);
            this.ayd.setImageResource(0);
            this.ayd.setBackgroundColor(getResources().getColor(d.C0096d.cp_bg_line_d));
            this.gUC.setVisibility(0);
            return;
        }
        this.ayd.setScaleType(ImageView.ScaleType.CENTER);
        this.ayd.setImageResource(0);
        this.ayd.setImageBitmap(null);
        this.ayd.setBackgroundColor(getResources().getColor(d.C0096d.white_alpha50));
        this.axY.setText("");
        this.gUC.setVisibility(8);
    }

    public void a(d dVar) {
        this.gUH = false;
        this.gUC.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bCS()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dc(long j) {
        return j > gUE ? this.gUF.format(Long.valueOf(j)) : this.gUG.format(Long.valueOf(j));
    }
}
