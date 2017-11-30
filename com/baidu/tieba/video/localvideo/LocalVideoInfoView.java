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
    public static final Object gRU = new Object();
    private static long gRV = 3600000;
    private TextView axT;
    private ImageView axY;
    private TextView gRT;
    private SimpleDateFormat gRW;
    private SimpleDateFormat gRX;
    private boolean gRY;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gRY = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRY = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRY = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.axY = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.axY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.axT = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.gRT = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gRX = new SimpleDateFormat("mm:ss");
        this.gRW = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gRX.setTimeZone(timeZone);
        this.gRW.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gRY) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.axY.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.axY.setImageBitmap(dVar.bCm());
                    this.axT.setText(db(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.axY.setScaleType(ImageView.ScaleType.CENTER);
            this.axY.setImageBitmap(null);
            this.axY.setImageResource(d.f.img_default_100);
            this.axY.setBackgroundColor(getResources().getColor(d.C0082d.common_color_10304));
            this.axT.setText("");
        }
    }

    public void lI(boolean z) {
        this.gRY = true;
        if (z) {
            this.axY.setScaleType(ImageView.ScaleType.CENTER);
            this.axY.setImageBitmap(null);
            this.axY.setImageResource(0);
            this.axY.setBackgroundColor(getResources().getColor(d.C0082d.cp_bg_line_d));
            this.gRT.setVisibility(0);
            return;
        }
        this.axY.setScaleType(ImageView.ScaleType.CENTER);
        this.axY.setImageResource(0);
        this.axY.setImageBitmap(null);
        this.axY.setBackgroundColor(getResources().getColor(d.C0082d.white_alpha50));
        this.axT.setText("");
        this.gRT.setVisibility(8);
    }

    public void a(d dVar) {
        this.gRY = false;
        this.gRT.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bCn()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String db(long j) {
        return j > gRV ? this.gRW.format(Long.valueOf(j)) : this.gRX.format(Long.valueOf(j));
    }
}
