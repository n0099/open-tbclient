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
    public static final Object hgM = new Object();
    private static long hgN = 3600000;
    private TextView aIt;
    private ImageView aIy;
    private TextView hgL;
    private SimpleDateFormat hgO;
    private SimpleDateFormat hgP;
    private boolean hgQ;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.hgQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hgQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hgQ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.local_video_info_view, (ViewGroup) null);
        this.aIy = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.aIy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aIt = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.hgL = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.hgP = new SimpleDateFormat("mm:ss");
        this.hgO = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.hgP.setTimeZone(timeZone);
        this.hgO.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.hgQ) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aIy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aIy.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aIt.setText(cZ(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aIy.setScaleType(ImageView.ScaleType.CENTER);
            this.aIy.setImageBitmap(null);
            this.aIy.setImageResource(d.f.img_default_100);
            this.aIy.setBackgroundColor(getResources().getColor(d.C0140d.common_color_10304));
            this.aIt.setText("");
        }
    }

    public void mV(boolean z) {
        this.hgQ = true;
        if (z) {
            this.aIy.setScaleType(ImageView.ScaleType.CENTER);
            this.aIy.setImageBitmap(null);
            this.aIy.setImageResource(0);
            this.aIy.setBackgroundColor(getResources().getColor(d.C0140d.cp_bg_line_d));
            this.hgL.setVisibility(0);
            return;
        }
        this.aIy.setScaleType(ImageView.ScaleType.CENTER);
        this.aIy.setImageResource(0);
        this.aIy.setImageBitmap(null);
        this.aIy.setBackgroundColor(getResources().getColor(d.C0140d.white_alpha50));
        this.aIt.setText("");
        this.hgL.setVisibility(8);
    }

    public void a(d dVar) {
        this.hgQ = false;
        this.hgL.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bBW()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cZ(long j) {
        return j > hgN ? this.hgO.format(Long.valueOf(j)) : this.hgP.format(Long.valueOf(j));
    }
}
