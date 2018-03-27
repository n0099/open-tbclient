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
    public static final Object htk = new Object();
    private static long htl = 3600000;
    private TextView boB;
    private ImageView boG;
    private TextView htj;
    private SimpleDateFormat htm;
    private SimpleDateFormat htn;
    private boolean hto;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hto = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hto = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hto = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.boG = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.boG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.boB = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.htj = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.htn = new SimpleDateFormat("mm:ss");
        this.htm = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.htn.setTimeZone(timeZone);
        this.htm.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hto) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.boG.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.boG.setImageBitmap(dVar.bCB());
                    this.boB.setText(cT(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.boG.setScaleType(ImageView.ScaleType.CENTER);
            this.boG.setImageBitmap(null);
            this.boG.setImageResource(d.f.img_default_100);
            this.boG.setBackgroundColor(getResources().getColor(d.C0141d.common_color_10304));
            this.boB.setText("");
        }
    }

    public void ns(boolean z) {
        this.hto = true;
        if (z) {
            this.boG.setScaleType(ImageView.ScaleType.CENTER);
            this.boG.setImageBitmap(null);
            this.boG.setImageResource(0);
            this.boG.setBackgroundColor(getResources().getColor(d.C0141d.cp_bg_line_d));
            this.htj.setVisibility(0);
            return;
        }
        this.boG.setScaleType(ImageView.ScaleType.CENTER);
        this.boG.setImageResource(0);
        this.boG.setImageBitmap(null);
        this.boG.setBackgroundColor(getResources().getColor(d.C0141d.white_alpha50));
        this.boB.setText("");
        this.htj.setVisibility(8);
    }

    public void a(d dVar) {
        this.hto = false;
        this.htj.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bCC()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cT(long j) {
        return j > htl ? this.htm.format(Long.valueOf(j)) : this.htn.format(Long.valueOf(j));
    }
}
