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
    public static final Object gGi = new Object();
    private static long gGj = 3600000;
    private TextView axk;
    private ImageView axp;
    private TextView gGh;
    private SimpleDateFormat gGk;
    private SimpleDateFormat gGl;
    private boolean gGm;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gGm = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gGm = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gGm = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.axp = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.axp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.axk = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.gGh = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gGl = new SimpleDateFormat("mm:ss");
        this.gGk = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gGl.setTimeZone(timeZone);
        this.gGk.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gGm) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.axp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.axp.setImageBitmap(dVar.bzC());
                    this.axk.setText(cU(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.axp.setScaleType(ImageView.ScaleType.CENTER);
            this.axp.setImageBitmap(null);
            this.axp.setImageResource(d.f.img_default_100);
            this.axp.setBackgroundColor(getResources().getColor(d.C0080d.common_color_10304));
            this.axk.setText("");
        }
    }

    public void ld(boolean z) {
        this.gGm = true;
        if (z) {
            this.axp.setScaleType(ImageView.ScaleType.CENTER);
            this.axp.setImageBitmap(null);
            this.axp.setImageResource(0);
            this.axp.setBackgroundColor(getResources().getColor(d.C0080d.cp_bg_line_d));
            this.gGh.setVisibility(0);
            return;
        }
        this.axp.setScaleType(ImageView.ScaleType.CENTER);
        this.axp.setImageResource(0);
        this.axp.setImageBitmap(null);
        this.axp.setBackgroundColor(getResources().getColor(d.C0080d.white_alpha50));
        this.axk.setText("");
        this.gGh.setVisibility(8);
    }

    public void a(d dVar) {
        this.gGm = false;
        this.gGh.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bzD()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cU(long j) {
        return j > gGj ? this.gGk.format(Long.valueOf(j)) : this.gGl.format(Long.valueOf(j));
    }
}
