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
    public static final Object gHq = new Object();
    private static long gHr = 3600000;
    private TextView axs;
    private ImageView axx;
    private TextView gHp;
    private SimpleDateFormat gHs;
    private SimpleDateFormat gHt;
    private boolean gHu;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gHu = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHu = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHu = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.axx = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.axx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.axs = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.gHp = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gHt = new SimpleDateFormat("mm:ss");
        this.gHs = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gHt.setTimeZone(timeZone);
        this.gHs.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gHu) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.axx.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.axx.setImageBitmap(dVar.bzO());
                    this.axs.setText(cW(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.axx.setScaleType(ImageView.ScaleType.CENTER);
            this.axx.setImageBitmap(null);
            this.axx.setImageResource(d.f.img_default_100);
            this.axx.setBackgroundColor(getResources().getColor(d.C0080d.common_color_10304));
            this.axs.setText("");
        }
    }

    public void lj(boolean z) {
        this.gHu = true;
        if (z) {
            this.axx.setScaleType(ImageView.ScaleType.CENTER);
            this.axx.setImageBitmap(null);
            this.axx.setImageResource(0);
            this.axx.setBackgroundColor(getResources().getColor(d.C0080d.cp_bg_line_d));
            this.gHp.setVisibility(0);
            return;
        }
        this.axx.setScaleType(ImageView.ScaleType.CENTER);
        this.axx.setImageResource(0);
        this.axx.setImageBitmap(null);
        this.axx.setBackgroundColor(getResources().getColor(d.C0080d.white_alpha50));
        this.axs.setText("");
        this.gHp.setVisibility(8);
    }

    public void a(d dVar) {
        this.gHu = false;
        this.gHp.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bzP()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cW(long j) {
        return j > gHr ? this.gHs.format(Long.valueOf(j)) : this.gHt.format(Long.valueOf(j));
    }
}
