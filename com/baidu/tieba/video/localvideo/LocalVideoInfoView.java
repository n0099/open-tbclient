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
    public static final Object hJg = new Object();
    private static long hJh = 3600000;
    private ImageView ahZ;
    private TextView ajh;
    private TextView hJf;
    private SimpleDateFormat hJi;
    private SimpleDateFormat hJj;
    private boolean hJk;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hJk = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hJk = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hJk = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(e.h.local_video_info_view, (ViewGroup) null);
        this.ahZ = (ImageView) this.mRootView.findViewById(e.g.local_video_selet_thumb);
        this.ahZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajh = (TextView) this.mRootView.findViewById(e.g.local_video_select_duration);
        this.hJf = (TextView) this.mRootView.findViewById(e.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hJj = new SimpleDateFormat("mm:ss");
        this.hJi = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hJj.setTimeZone(timeZone);
        this.hJi.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hJk) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ahZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ahZ.setImageBitmap(dVar.getThumbnailBitmap());
                    this.ajh.setText(dp(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ahZ.setScaleType(ImageView.ScaleType.CENTER);
            this.ahZ.setImageBitmap(null);
            this.ahZ.setImageResource(e.f.img_default_100);
            this.ahZ.setBackgroundColor(getResources().getColor(e.d.common_color_10304));
            this.ajh.setText("");
        }
    }

    public void od(boolean z) {
        this.hJk = true;
        if (z) {
            this.ahZ.setScaleType(ImageView.ScaleType.CENTER);
            this.ahZ.setImageBitmap(null);
            this.ahZ.setImageResource(0);
            this.ahZ.setBackgroundColor(getResources().getColor(e.d.cp_bg_line_d));
            this.hJf.setVisibility(0);
            return;
        }
        this.ahZ.setScaleType(ImageView.ScaleType.CENTER);
        this.ahZ.setImageResource(0);
        this.ahZ.setImageBitmap(null);
        this.ahZ.setBackgroundColor(getResources().getColor(e.d.white_alpha50));
        this.ajh.setText("");
        this.hJf.setVisibility(8);
    }

    public void a(d dVar) {
        this.hJk = false;
        this.hJf.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bLc()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dp(long j) {
        return j > hJh ? this.hJi.format(Long.valueOf(j)) : this.hJj.format(Long.valueOf(j));
    }
}
