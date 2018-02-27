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
    public static final Object hsM = new Object();
    private static long hsN = 3600000;
    private ImageView boD;
    private TextView boy;
    private TextView hsL;
    private SimpleDateFormat hsO;
    private SimpleDateFormat hsP;
    private boolean hsQ;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hsQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hsQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hsQ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.boD = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.boD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.boy = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hsL = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hsP = new SimpleDateFormat("mm:ss");
        this.hsO = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hsP.setTimeZone(timeZone);
        this.hsO.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hsQ) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.boD.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.boD.setImageBitmap(dVar.bCw());
                    this.boy.setText(cT(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.boD.setScaleType(ImageView.ScaleType.CENTER);
            this.boD.setImageBitmap(null);
            this.boD.setImageResource(d.f.img_default_100);
            this.boD.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10304));
            this.boy.setText("");
        }
    }

    public void nn(boolean z) {
        this.hsQ = true;
        if (z) {
            this.boD.setScaleType(ImageView.ScaleType.CENTER);
            this.boD.setImageBitmap(null);
            this.boD.setImageResource(0);
            this.boD.setBackgroundColor(getResources().getColor(d.C0141d.cp_bg_line_d));
            this.hsL.setVisibility(0);
            return;
        }
        this.boD.setScaleType(ImageView.ScaleType.CENTER);
        this.boD.setImageResource(0);
        this.boD.setImageBitmap(null);
        this.boD.setBackgroundColor(getResources().getColor(d.C0141d.white_alpha50));
        this.boy.setText("");
        this.hsL.setVisibility(8);
    }

    public void a(d dVar) {
        this.hsQ = false;
        this.hsL.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bCx()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cT(long j) {
        return j > hsN ? this.hsO.format(Long.valueOf(j)) : this.hsP.format(Long.valueOf(j));
    }
}
