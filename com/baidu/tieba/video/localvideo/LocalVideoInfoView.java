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
    public static final Object jCe = new Object();
    private static long jCf = 3600000;
    private ImageView ahO;
    private TextView ajd;
    private TextView jCd;
    private SimpleDateFormat jCg;
    private SimpleDateFormat jCh;
    private boolean jCi;
    private Context mContext;
    private View mRootView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.jCi = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCi = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCi = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.ahO = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.ahO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajd = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.jCd = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.jCh = new SimpleDateFormat("mm:ss");
        this.jCg = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jCh.setTimeZone(timeZone);
        this.jCg.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.jCi) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ahO.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ahO.setImageBitmap(dVar.cwD());
                    this.ajd.setText(eF(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ahO.setScaleType(ImageView.ScaleType.CENTER);
            this.ahO.setImageBitmap(null);
            this.ahO.setImageResource(R.drawable.img_default_100);
            this.ahO.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.ajd.setText("");
        }
    }

    public void rK(boolean z) {
        this.jCi = true;
        if (z) {
            this.ahO.setScaleType(ImageView.ScaleType.CENTER);
            this.ahO.setImageBitmap(null);
            this.ahO.setImageResource(0);
            this.ahO.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.jCd.setVisibility(0);
            return;
        }
        this.ahO.setScaleType(ImageView.ScaleType.CENTER);
        this.ahO.setImageResource(0);
        this.ahO.setImageBitmap(null);
        this.ahO.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.ajd.setText("");
        this.jCd.setVisibility(8);
    }

    public void a(d dVar) {
        this.jCi = false;
        this.jCd.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.cwE()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eF(long j) {
        return j > jCf ? this.jCg.format(Long.valueOf(j)) : this.jCh.format(Long.valueOf(j));
    }
}
