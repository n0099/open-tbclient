package com.baidu.tieba.video.localvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object jBW = new Object();
    private static long jBX = BdKVCache.MILLS_1Hour;
    private ImageView aBm;
    private TextView jBV;
    private SimpleDateFormat jBY;
    private SimpleDateFormat jBZ;
    private boolean jCa;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.jCa = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCa = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCa = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.aBm = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.aBm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.jBV = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.jBZ = new SimpleDateFormat("mm:ss");
        this.jBY = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jBZ.setTimeZone(timeZone);
        this.jBY.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.jCa) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aBm.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aBm.setImageBitmap(dVar.cur());
                    this.textView.setText(dZ(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aBm.setScaleType(ImageView.ScaleType.CENTER);
            this.aBm.setImageBitmap(null);
            this.aBm.setImageResource(R.drawable.img_default_100);
            this.aBm.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void rt(boolean z) {
        this.jCa = true;
        if (z) {
            this.aBm.setScaleType(ImageView.ScaleType.CENTER);
            this.aBm.setImageBitmap(null);
            this.aBm.setImageResource(0);
            this.aBm.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.jBV.setVisibility(0);
            return;
        }
        this.aBm.setScaleType(ImageView.ScaleType.CENTER);
        this.aBm.setImageResource(0);
        this.aBm.setImageBitmap(null);
        this.aBm.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.jBV.setVisibility(8);
    }

    public void a(d dVar) {
        this.jCa = false;
        this.jBV.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.cus()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dZ(long j) {
        return j > jBX ? this.jBY.format(Long.valueOf(j)) : this.jBZ.format(Long.valueOf(j));
    }
}
