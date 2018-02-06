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
    public static final Object hsZ = new Object();
    private static long hta = 3600000;
    private TextView boL;
    private ImageView boQ;
    private TextView hsY;
    private SimpleDateFormat htb;
    private SimpleDateFormat htc;
    private boolean htd;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.htd = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.htd = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.htd = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.boQ = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.boQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.boL = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hsY = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.htc = new SimpleDateFormat("mm:ss");
        this.htb = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.htc.setTimeZone(timeZone);
        this.htb.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.htd) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.boQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.boQ.setImageBitmap(dVar.bCx());
                    this.boL.setText(cT(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.boQ.setScaleType(ImageView.ScaleType.CENTER);
            this.boQ.setImageBitmap(null);
            this.boQ.setImageResource(d.f.img_default_100);
            this.boQ.setBackgroundColor(getResources().getColor(d.C0140d.common_color_10304));
            this.boL.setText("");
        }
    }

    public void nn(boolean z) {
        this.htd = true;
        if (z) {
            this.boQ.setScaleType(ImageView.ScaleType.CENTER);
            this.boQ.setImageBitmap(null);
            this.boQ.setImageResource(0);
            this.boQ.setBackgroundColor(getResources().getColor(d.C0140d.cp_bg_line_d));
            this.hsY.setVisibility(0);
            return;
        }
        this.boQ.setScaleType(ImageView.ScaleType.CENTER);
        this.boQ.setImageResource(0);
        this.boQ.setImageBitmap(null);
        this.boQ.setBackgroundColor(getResources().getColor(d.C0140d.white_alpha50));
        this.boL.setText("");
        this.hsY.setVisibility(8);
    }

    public void a(d dVar) {
        this.htd = false;
        this.hsY.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bCy()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cT(long j) {
        return j > hta ? this.htb.format(Long.valueOf(j)) : this.htc.format(Long.valueOf(j));
    }
}
