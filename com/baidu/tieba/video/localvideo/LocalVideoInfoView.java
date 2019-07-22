package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object jyB = new Object();
    private static long jyC = 3600000;
    private ImageView ahs;
    private TextView jyA;
    private SimpleDateFormat jyD;
    private SimpleDateFormat jyE;
    private boolean jyF;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.jyF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jyF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jyF = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.ahs = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.ahs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.jyA = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.jyE = new SimpleDateFormat("mm:ss");
        this.jyD = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jyE.setTimeZone(timeZone);
        this.jyD.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.jyF) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ahs.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ahs.setImageBitmap(dVar.cvt());
                    this.textView.setText(eC(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ahs.setScaleType(ImageView.ScaleType.CENTER);
            this.ahs.setImageBitmap(null);
            this.ahs.setImageResource(R.drawable.img_default_100);
            this.ahs.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void rG(boolean z) {
        this.jyF = true;
        if (z) {
            this.ahs.setScaleType(ImageView.ScaleType.CENTER);
            this.ahs.setImageBitmap(null);
            this.ahs.setImageResource(0);
            this.ahs.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.jyA.setVisibility(0);
            return;
        }
        this.ahs.setScaleType(ImageView.ScaleType.CENTER);
        this.ahs.setImageResource(0);
        this.ahs.setImageBitmap(null);
        this.ahs.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.jyA.setVisibility(8);
    }

    public void a(d dVar) {
        this.jyF = false;
        this.jyA.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.cvu()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eC(long j) {
        return j > jyC ? this.jyD.format(Long.valueOf(j)) : this.jyE.format(Long.valueOf(j));
    }
}
