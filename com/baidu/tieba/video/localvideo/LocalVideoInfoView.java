package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.f;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object hgN = new Object();
    private static long hgO = 3600000;
    private TextView aIr;
    private ImageView aIv;
    private TextView hgM;
    private SimpleDateFormat hgP;
    private SimpleDateFormat hgQ;
    private boolean hgR;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hgR = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hgR = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hgR = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(f.h.local_video_info_view, (ViewGroup) null);
        this.aIv = (ImageView) this.mRootView.findViewById(f.g.local_video_selet_thumb);
        this.aIv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aIr = (TextView) this.mRootView.findViewById(f.g.local_video_select_duration);
        this.hgM = (TextView) this.mRootView.findViewById(f.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hgQ = new SimpleDateFormat("mm:ss");
        this.hgP = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hgQ.setTimeZone(timeZone);
        this.hgP.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hgR) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aIv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aIv.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aIr.setText(cZ(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aIv.setScaleType(ImageView.ScaleType.CENTER);
            this.aIv.setImageBitmap(null);
            this.aIv.setImageResource(f.C0146f.img_default_100);
            this.aIv.setBackgroundColor(getResources().getColor(f.d.common_color_10304));
            this.aIr.setText("");
        }
    }

    public void mV(boolean z) {
        this.hgR = true;
        if (z) {
            this.aIv.setScaleType(ImageView.ScaleType.CENTER);
            this.aIv.setImageBitmap(null);
            this.aIv.setImageResource(0);
            this.aIv.setBackgroundColor(getResources().getColor(f.d.cp_bg_line_d));
            this.hgM.setVisibility(0);
            return;
        }
        this.aIv.setScaleType(ImageView.ScaleType.CENTER);
        this.aIv.setImageResource(0);
        this.aIv.setImageBitmap(null);
        this.aIv.setBackgroundColor(getResources().getColor(f.d.white_alpha50));
        this.aIr.setText("");
        this.hgM.setVisibility(8);
    }

    public void a(d dVar) {
        this.hgR = false;
        this.hgM.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bBY()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cZ(long j) {
        return j > hgO ? this.hgP.format(Long.valueOf(j)) : this.hgQ.format(Long.valueOf(j));
    }
}
