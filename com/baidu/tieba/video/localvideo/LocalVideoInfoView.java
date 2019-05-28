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
    public static final Object jsq = new Object();
    private static long jsr = 3600000;
    private ImageView agT;
    private TextView aif;
    private TextView jsp;
    private SimpleDateFormat jss;
    private SimpleDateFormat jst;
    private boolean jsu;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.jsu = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jsu = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jsu = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.agT = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.agT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aif = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.jsp = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.jst = new SimpleDateFormat("mm:ss");
        this.jss = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jst.setTimeZone(timeZone);
        this.jss.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.jsu) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.agT.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.agT.setImageBitmap(dVar.getThumbnailBitmap());
                    this.aif.setText(eu(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.agT.setScaleType(ImageView.ScaleType.CENTER);
            this.agT.setImageBitmap(null);
            this.agT.setImageResource(R.drawable.img_default_100);
            this.agT.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.aif.setText("");
        }
    }

    public void rs(boolean z) {
        this.jsu = true;
        if (z) {
            this.agT.setScaleType(ImageView.ScaleType.CENTER);
            this.agT.setImageBitmap(null);
            this.agT.setImageResource(0);
            this.agT.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.jsp.setVisibility(0);
            return;
        }
        this.agT.setScaleType(ImageView.ScaleType.CENTER);
        this.agT.setImageResource(0);
        this.agT.setImageBitmap(null);
        this.agT.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.aif.setText("");
        this.jsp.setVisibility(8);
    }

    public void a(d dVar) {
        this.jsu = false;
        this.jsp.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.csG()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eu(long j) {
        return j > jsr ? this.jss.format(Long.valueOf(j)) : this.jst.format(Long.valueOf(j));
    }
}
