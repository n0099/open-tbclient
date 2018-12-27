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
    public static final Object hHZ = new Object();
    private static long hIa = 3600000;
    private ImageView ahQ;
    private TextView aiY;
    private TextView hHY;
    private SimpleDateFormat hIb;
    private SimpleDateFormat hIc;
    private boolean hId;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hId = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hId = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hId = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(e.h.local_video_info_view, (ViewGroup) null);
        this.ahQ = (ImageView) this.mRootView.findViewById(e.g.local_video_selet_thumb);
        this.ahQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aiY = (TextView) this.mRootView.findViewById(e.g.local_video_select_duration);
        this.hHY = (TextView) this.mRootView.findViewById(e.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hIc = new SimpleDateFormat("mm:ss");
        this.hIb = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hIc.setTimeZone(timeZone);
        this.hIb.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hId) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ahQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ahQ.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aiY.setText(dp(dVar.getDuration()));
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

    public void oc(boolean z) {
        this.hId = true;
        if (z) {
            this.ahQ.setScaleType(ImageView.ScaleType.CENTER);
            this.ahQ.setImageBitmap(null);
            this.ahQ.setImageResource(0);
            this.ahQ.setBackgroundColor(getResources().getColor(e.d.cp_bg_line_d));
            this.hHY.setVisibility(0);
            return;
        }
        this.ahQ.setScaleType(ImageView.ScaleType.CENTER);
        this.ahQ.setImageResource(0);
        this.ahQ.setImageBitmap(null);
        this.ahQ.setBackgroundColor(getResources().getColor(e.d.white_alpha50));
        this.aiY.setText("");
        this.hHY.setVisibility(8);
    }

    public void a(d dVar) {
        this.hId = false;
        this.hHY.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bKt()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dp(long j) {
        return j > hIa ? this.hIb.format(Long.valueOf(j)) : this.hIc.format(Long.valueOf(j));
    }
}
