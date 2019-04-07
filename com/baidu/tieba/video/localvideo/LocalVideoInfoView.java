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
    public static final Object iZt = new Object();
    private static long iZu = 3600000;
    private ImageView agJ;
    private TextView ahN;
    private TextView iZs;
    private SimpleDateFormat iZv;
    private SimpleDateFormat iZw;
    private boolean iZx;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.iZx = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZx = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZx = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.agJ = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.agJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahN = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.iZs = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.iZw = new SimpleDateFormat("mm:ss");
        this.iZv = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.iZw.setTimeZone(timeZone);
        this.iZv.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.iZx) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.agJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.agJ.setImageBitmap(dVar.getThumbnailBitmap());
                    this.ahN.setText(dW(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.agJ.setScaleType(ImageView.ScaleType.CENTER);
            this.agJ.setImageBitmap(null);
            this.agJ.setImageResource(d.f.img_default_100);
            this.agJ.setBackgroundColor(getResources().getColor(d.C0277d.common_color_10304));
            this.ahN.setText("");
        }
    }

    public void qD(boolean z) {
        this.iZx = true;
        if (z) {
            this.agJ.setScaleType(ImageView.ScaleType.CENTER);
            this.agJ.setImageBitmap(null);
            this.agJ.setImageResource(0);
            this.agJ.setBackgroundColor(getResources().getColor(d.C0277d.cp_bg_line_d));
            this.iZs.setVisibility(0);
            return;
        }
        this.agJ.setScaleType(ImageView.ScaleType.CENTER);
        this.agJ.setImageResource(0);
        this.agJ.setImageBitmap(null);
        this.agJ.setBackgroundColor(getResources().getColor(d.C0277d.white_alpha50));
        this.ahN.setText("");
        this.iZs.setVisibility(8);
    }

    public void a(d dVar) {
        this.iZx = false;
        this.iZs.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.ckB()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dW(long j) {
        return j > iZu ? this.iZv.format(Long.valueOf(j)) : this.iZw.format(Long.valueOf(j));
    }
}
