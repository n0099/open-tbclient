package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object hoD = new Object();
    private static long hoE = 3600000;
    private TextView aLH;
    private ImageView aLL;
    private TextView hoC;
    private SimpleDateFormat hoF;
    private SimpleDateFormat hoG;
    private boolean hoH;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hoH = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hoH = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hoH = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(e.h.local_video_info_view, (ViewGroup) null);
        this.aLL = (ImageView) this.mRootView.findViewById(e.g.local_video_selet_thumb);
        this.aLL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aLH = (TextView) this.mRootView.findViewById(e.g.local_video_select_duration);
        this.hoC = (TextView) this.mRootView.findViewById(e.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hoG = new SimpleDateFormat("mm:ss");
        this.hoF = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hoG.setTimeZone(timeZone);
        this.hoF.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hoH) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aLL.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aLL.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aLH.setText(db(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aLL.setScaleType(ImageView.ScaleType.CENTER);
            this.aLL.setImageBitmap(null);
            this.aLL.setImageResource(e.f.img_default_100);
            this.aLL.setBackgroundColor(getResources().getColor(e.d.common_color_10304));
            this.aLH.setText("");
        }
    }

    public void ns(boolean z) {
        this.hoH = true;
        if (z) {
            this.aLL.setScaleType(ImageView.ScaleType.CENTER);
            this.aLL.setImageBitmap(null);
            this.aLL.setImageResource(0);
            this.aLL.setBackgroundColor(getResources().getColor(e.d.cp_bg_line_d));
            this.hoC.setVisibility(0);
            return;
        }
        this.aLL.setScaleType(ImageView.ScaleType.CENTER);
        this.aLL.setImageResource(0);
        this.aLL.setImageBitmap(null);
        this.aLL.setBackgroundColor(getResources().getColor(e.d.white_alpha50));
        this.aLH.setText("");
        this.hoC.setVisibility(8);
    }

    public void a(d dVar) {
        this.hoH = false;
        this.hoC.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bEN()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String db(long j) {
        return j > hoE ? this.hoF.format(Long.valueOf(j)) : this.hoG.format(Long.valueOf(j));
    }
}
