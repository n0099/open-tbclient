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
    public static final Object gUI = new Object();
    private static long gUJ = 3600000;
    private TextView ayb;
    private ImageView ayg;
    private TextView gUH;
    private SimpleDateFormat gUK;
    private SimpleDateFormat gUL;
    private boolean gUM;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gUM = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUM = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gUM = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.ayg = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.ayg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ayb = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.gUH = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gUL = new SimpleDateFormat("mm:ss");
        this.gUK = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gUL.setTimeZone(timeZone);
        this.gUK.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gUM) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ayg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ayg.setImageBitmap(dVar.bCS());
                    this.ayb.setText(dc(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ayg.setScaleType(ImageView.ScaleType.CENTER);
            this.ayg.setImageBitmap(null);
            this.ayg.setImageResource(d.f.img_default_100);
            this.ayg.setBackgroundColor(getResources().getColor(d.C0095d.common_color_10304));
            this.ayb.setText("");
        }
    }

    public void lJ(boolean z) {
        this.gUM = true;
        if (z) {
            this.ayg.setScaleType(ImageView.ScaleType.CENTER);
            this.ayg.setImageBitmap(null);
            this.ayg.setImageResource(0);
            this.ayg.setBackgroundColor(getResources().getColor(d.C0095d.cp_bg_line_d));
            this.gUH.setVisibility(0);
            return;
        }
        this.ayg.setScaleType(ImageView.ScaleType.CENTER);
        this.ayg.setImageResource(0);
        this.ayg.setImageBitmap(null);
        this.ayg.setBackgroundColor(getResources().getColor(d.C0095d.white_alpha50));
        this.ayb.setText("");
        this.gUH.setVisibility(8);
    }

    public void a(d dVar) {
        this.gUM = false;
        this.gUH.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bCT()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dc(long j) {
        return j > gUJ ? this.gUK.format(Long.valueOf(j)) : this.gUL.format(Long.valueOf(j));
    }
}
