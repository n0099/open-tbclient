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
    public static final Object jsp = new Object();
    private static long jsq = 3600000;
    private ImageView agT;
    private TextView aif;
    private TextView jso;
    private SimpleDateFormat jsr;
    private SimpleDateFormat jss;
    private boolean jst;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.jst = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jst = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jst = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.agT = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.agT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aif = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.jso = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.jss = new SimpleDateFormat("mm:ss");
        this.jsr = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jss.setTimeZone(timeZone);
        this.jsr.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.jst) {
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
        this.jst = true;
        if (z) {
            this.agT.setScaleType(ImageView.ScaleType.CENTER);
            this.agT.setImageBitmap(null);
            this.agT.setImageResource(0);
            this.agT.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.jso.setVisibility(0);
            return;
        }
        this.agT.setScaleType(ImageView.ScaleType.CENTER);
        this.agT.setImageResource(0);
        this.agT.setImageBitmap(null);
        this.agT.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.aif.setText("");
        this.jso.setVisibility(8);
    }

    public void a(d dVar) {
        this.jst = false;
        this.jso.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.csE()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eu(long j) {
        return j > jsq ? this.jsr.format(Long.valueOf(j)) : this.jss.format(Long.valueOf(j));
    }
}
