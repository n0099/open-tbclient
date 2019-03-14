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
/* loaded from: classes5.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object iZF = new Object();
    private static long iZG = 3600000;
    private ImageView agE;
    private TextView ahI;
    private TextView iZE;
    private SimpleDateFormat iZH;
    private SimpleDateFormat iZI;
    private boolean iZJ;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.iZJ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZJ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZJ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.agE = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.agE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahI = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.iZE = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.iZI = new SimpleDateFormat("mm:ss");
        this.iZH = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.iZI.setTimeZone(timeZone);
        this.iZH.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.iZJ) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.agE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.agE.setImageBitmap(dVar.getThumbnailBitmap());
                    this.ahI.setText(dV(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.agE.setScaleType(ImageView.ScaleType.CENTER);
            this.agE.setImageBitmap(null);
            this.agE.setImageResource(d.f.img_default_100);
            this.agE.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10304));
            this.ahI.setText("");
        }
    }

    public void qD(boolean z) {
        this.iZJ = true;
        if (z) {
            this.agE.setScaleType(ImageView.ScaleType.CENTER);
            this.agE.setImageBitmap(null);
            this.agE.setImageResource(0);
            this.agE.setBackgroundColor(getResources().getColor(d.C0277d.cp_bg_line_d));
            this.iZE.setVisibility(0);
            return;
        }
        this.agE.setScaleType(ImageView.ScaleType.CENTER);
        this.agE.setImageResource(0);
        this.agE.setImageBitmap(null);
        this.agE.setBackgroundColor(getResources().getColor(d.C0277d.white_alpha50));
        this.ahI.setText("");
        this.iZE.setVisibility(8);
    }

    public void a(d dVar) {
        this.iZJ = false;
        this.iZE.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.ckD()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dV(long j) {
        return j > iZG ? this.iZH.format(Long.valueOf(j)) : this.iZI.format(Long.valueOf(j));
    }
}
