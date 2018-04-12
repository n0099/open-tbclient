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
    public static final Object gOQ = new Object();
    private static long gOR = 3600000;
    private TextView aza;
    private ImageView azf;
    private TextView gOP;
    private SimpleDateFormat gOS;
    private SimpleDateFormat gOT;
    private boolean gOU;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.gOU = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gOU = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gOU = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.i.local_video_info_view, (ViewGroup) null);
        this.azf = (ImageView) this.mRootView.findViewById(d.g.local_video_selet_thumb);
        this.azf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aza = (TextView) this.mRootView.findViewById(d.g.local_video_select_duration);
        this.gOP = (TextView) this.mRootView.findViewById(d.g.no_video_title);
        addView(this.mRootView, -1, -1);
        this.gOT = new SimpleDateFormat("mm:ss");
        this.gOS = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.gOT.setTimeZone(timeZone);
        this.gOS.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.gOU) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.azf.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.azf.setImageBitmap(dVar.bxG());
                    this.aza.setText(cX(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.azf.setScaleType(ImageView.ScaleType.CENTER);
            this.azf.setImageBitmap(null);
            this.azf.setImageResource(d.f.img_default_100);
            this.azf.setBackgroundColor(getResources().getColor(d.C0126d.common_color_10304));
            this.aza.setText("");
        }
    }

    public void mU(boolean z) {
        this.gOU = true;
        if (z) {
            this.azf.setScaleType(ImageView.ScaleType.CENTER);
            this.azf.setImageBitmap(null);
            this.azf.setImageResource(0);
            this.azf.setBackgroundColor(getResources().getColor(d.C0126d.cp_bg_line_d));
            this.gOP.setVisibility(0);
            return;
        }
        this.azf.setScaleType(ImageView.ScaleType.CENTER);
        this.azf.setImageResource(0);
        this.azf.setImageBitmap(null);
        this.azf.setBackgroundColor(getResources().getColor(d.C0126d.white_alpha50));
        this.aza.setText("");
        this.gOP.setVisibility(8);
    }

    public void a(d dVar) {
        this.gOU = false;
        this.gOP.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.bxH()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String cX(long j) {
        return j > gOR ? this.gOS.format(Long.valueOf(j)) : this.gOT.format(Long.valueOf(j));
    }
}
