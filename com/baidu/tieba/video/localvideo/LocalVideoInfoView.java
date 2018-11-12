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
    public static final Object hxC = new Object();
    private static long hxD = 3600000;
    private TextView aQZ;
    private ImageView aRd;
    private TextView hxB;
    private SimpleDateFormat hxE;
    private SimpleDateFormat hxF;
    private boolean hxG;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hxG = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxG = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxG = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(e.h.local_video_info_view, (ViewGroup) null);
        this.aRd = (ImageView) this.mRootView.findViewById(e.g.local_video_selet_thumb);
        this.aRd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aQZ = (TextView) this.mRootView.findViewById(e.g.local_video_select_duration);
        this.hxB = (TextView) this.mRootView.findViewById(e.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hxF = new SimpleDateFormat("mm:ss");
        this.hxE = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hxF.setTimeZone(timeZone);
        this.hxE.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hxG) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aRd.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aRd.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aQZ.setText(dd(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aRd.setScaleType(ImageView.ScaleType.CENTER);
            this.aRd.setImageBitmap(null);
            this.aRd.setImageResource(e.f.img_default_100);
            this.aRd.setBackgroundColor(getResources().getColor(e.d.common_color_10304));
            this.aQZ.setText("");
        }
    }

    public void nX(boolean z) {
        this.hxG = true;
        if (z) {
            this.aRd.setScaleType(ImageView.ScaleType.CENTER);
            this.aRd.setImageBitmap(null);
            this.aRd.setImageResource(0);
            this.aRd.setBackgroundColor(getResources().getColor(e.d.cp_bg_line_d));
            this.hxB.setVisibility(0);
            return;
        }
        this.aRd.setScaleType(ImageView.ScaleType.CENTER);
        this.aRd.setImageResource(0);
        this.aRd.setImageBitmap(null);
        this.aRd.setBackgroundColor(getResources().getColor(e.d.white_alpha50));
        this.aQZ.setText("");
        this.hxB.setVisibility(8);
    }

    public void a(d dVar) {
        this.hxG = false;
        this.hxB.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bHz()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dd(long j) {
        return j > hxD ? this.hxE.format(Long.valueOf(j)) : this.hxF.format(Long.valueOf(j));
    }
}
