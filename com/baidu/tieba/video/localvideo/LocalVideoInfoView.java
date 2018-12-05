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
/* loaded from: classes5.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object hEO = new Object();
    private static long hEP = 3600000;
    private ImageView ahQ;
    private TextView aiY;
    private TextView hEN;
    private SimpleDateFormat hEQ;
    private SimpleDateFormat hER;
    private boolean hES;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hES = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hES = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hES = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(e.h.local_video_info_view, (ViewGroup) null);
        this.ahQ = (ImageView) this.mRootView.findViewById(e.g.local_video_selet_thumb);
        this.ahQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aiY = (TextView) this.mRootView.findViewById(e.g.local_video_select_duration);
        this.hEN = (TextView) this.mRootView.findViewById(e.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hER = new SimpleDateFormat("mm:ss");
        this.hEQ = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hER.setTimeZone(timeZone);
        this.hEQ.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hES) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ahQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ahQ.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aiY.setText(dk(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ahQ.setScaleType(ImageView.ScaleType.CENTER);
            this.ahQ.setImageBitmap(null);
            this.ahQ.setImageResource(e.f.img_default_100);
            this.ahQ.setBackgroundColor(getResources().getColor(e.d.common_color_10304));
            this.aiY.setText("");
        }
    }

    public void nZ(boolean z) {
        this.hES = true;
        if (z) {
            this.ahQ.setScaleType(ImageView.ScaleType.CENTER);
            this.ahQ.setImageBitmap(null);
            this.ahQ.setImageResource(0);
            this.ahQ.setBackgroundColor(getResources().getColor(e.d.cp_bg_line_d));
            this.hEN.setVisibility(0);
            return;
        }
        this.ahQ.setScaleType(ImageView.ScaleType.CENTER);
        this.ahQ.setImageResource(0);
        this.ahQ.setImageBitmap(null);
        this.ahQ.setBackgroundColor(getResources().getColor(e.d.white_alpha50));
        this.aiY.setText("");
        this.hEN.setVisibility(8);
    }

    public void a(d dVar) {
        this.hES = false;
        this.hEN.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bJE()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dk(long j) {
        return j > hEP ? this.hEQ.format(Long.valueOf(j)) : this.hER.format(Long.valueOf(j));
    }
}
