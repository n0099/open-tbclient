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
    public static final Object hbs = new Object();
    private static long hbt = 3600000;
    private ImageView aHB;
    private TextView aHw;
    private TextView hbr;
    private SimpleDateFormat hbu;
    private SimpleDateFormat hbv;
    private boolean hbw;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hbw = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hbw = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hbw = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.i.local_video_info_view, (ViewGroup) null);
        this.aHB = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.aHB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aHw = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hbr = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hbv = new SimpleDateFormat("mm:ss");
        this.hbu = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hbv.setTimeZone(timeZone);
        this.hbu.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hbw) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aHB.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aHB.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aHw.setText(de(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aHB.setScaleType(ImageView.ScaleType.CENTER);
            this.aHB.setImageBitmap(null);
            this.aHB.setImageResource(d.f.img_default_100);
            this.aHB.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10304));
            this.aHw.setText("");
        }
    }

    public void nb(boolean z) {
        this.hbw = true;
        if (z) {
            this.aHB.setScaleType(ImageView.ScaleType.CENTER);
            this.aHB.setImageBitmap(null);
            this.aHB.setImageResource(0);
            this.aHB.setBackgroundColor(getResources().getColor(d.C0141d.cp_bg_line_d));
            this.hbr.setVisibility(0);
            return;
        }
        this.aHB.setScaleType(ImageView.ScaleType.CENTER);
        this.aHB.setImageResource(0);
        this.aHB.setImageBitmap(null);
        this.aHB.setBackgroundColor(getResources().getColor(d.C0141d.white_alpha50));
        this.aHw.setText("");
        this.hbr.setVisibility(8);
    }

    public void a(d dVar) {
        this.hbw = false;
        this.hbr.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bCL()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String de(long j) {
        return j > hbt ? this.hbu.format(Long.valueOf(j)) : this.hbv.format(Long.valueOf(j));
    }
}
