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
    public static final Object hfx = new Object();
    private static long hfy = 3600000;
    private TextView aIt;
    private ImageView aIy;
    private SimpleDateFormat hfA;
    private boolean hfB;
    private TextView hfw;
    private SimpleDateFormat hfz;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hfB = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hfB = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hfB = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.i.local_video_info_view, (ViewGroup) null);
        this.aIy = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.aIy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aIt = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hfw = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hfA = new SimpleDateFormat("mm:ss");
        this.hfz = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hfA.setTimeZone(timeZone);
        this.hfz.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hfB) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aIy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aIy.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aIt.setText(dc(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aIy.setScaleType(ImageView.ScaleType.CENTER);
            this.aIy.setImageBitmap(null);
            this.aIy.setImageResource(d.f.img_default_100);
            this.aIy.setBackgroundColor(getResources().getColor(d.C0142d.common_color_10304));
            this.aIt.setText("");
        }
    }

    public void nj(boolean z) {
        this.hfB = true;
        if (z) {
            this.aIy.setScaleType(ImageView.ScaleType.CENTER);
            this.aIy.setImageBitmap(null);
            this.aIy.setImageResource(0);
            this.aIy.setBackgroundColor(getResources().getColor(d.C0142d.cp_bg_line_d));
            this.hfw.setVisibility(0);
            return;
        }
        this.aIy.setScaleType(ImageView.ScaleType.CENTER);
        this.aIy.setImageResource(0);
        this.aIy.setImageBitmap(null);
        this.aIy.setBackgroundColor(getResources().getColor(d.C0142d.white_alpha50));
        this.aIt.setText("");
        this.hfw.setVisibility(8);
    }

    public void a(d dVar) {
        this.hfB = false;
        this.hfw.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bDl()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dc(long j) {
        return j > hfy ? this.hfz.format(Long.valueOf(j)) : this.hfA.format(Long.valueOf(j));
    }
}
