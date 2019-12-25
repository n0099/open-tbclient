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
/* loaded from: classes7.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object kuW = new Object();
    private static long kuX = BdKVCache.MILLS_1Hour;
    private ImageView doU;
    private TextView kuV;
    private SimpleDateFormat kuY;
    private SimpleDateFormat kuZ;
    private boolean kva;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.kva = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kva = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kva = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.doU = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.doU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.kuV = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.kuZ = new SimpleDateFormat("mm:ss");
        this.kuY = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kuZ.setTimeZone(timeZone);
        this.kuY.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.kva) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.doU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.doU.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(eE(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.doU.setScaleType(ImageView.ScaleType.CENTER);
            this.doU.setImageBitmap(null);
            this.doU.setImageResource(R.drawable.img_default_100);
            this.doU.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void ta(boolean z) {
        this.kva = true;
        if (z) {
            this.doU.setScaleType(ImageView.ScaleType.CENTER);
            this.doU.setImageBitmap(null);
            this.doU.setImageResource(0);
            this.doU.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.kuV.setVisibility(0);
            return;
        }
        this.doU.setScaleType(ImageView.ScaleType.CENTER);
        this.doU.setImageResource(0);
        this.doU.setImageBitmap(null);
        this.doU.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.kuV.setVisibility(8);
    }

    public void a(d dVar) {
        this.kva = false;
        this.kuV.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.hasLoaded()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eE(long j) {
        return j > kuX ? this.kuY.format(Long.valueOf(j)) : this.kuZ.format(Long.valueOf(j));
    }
}
