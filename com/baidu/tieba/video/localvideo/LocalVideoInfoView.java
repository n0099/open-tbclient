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
/* loaded from: classes17.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object mgU = new Object();
    private static long mgV = BdKVCache.MILLS_1Hour;
    private ImageView ewZ;
    private Context mContext;
    private View mRootView;
    private TextView mgT;
    private SimpleDateFormat mgW;
    private SimpleDateFormat mgX;
    private boolean mgY;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.mgY = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mgY = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mgY = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.ewZ = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.ewZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.mgT = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.mgX = new SimpleDateFormat("mm:ss");
        this.mgW = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.mgX.setTimeZone(timeZone);
        this.mgW.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.mgY) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.ewZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.ewZ.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(fL(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.ewZ.setScaleType(ImageView.ScaleType.CENTER);
            this.ewZ.setImageBitmap(null);
            this.ewZ.setImageResource(R.drawable.img_default_100);
            this.ewZ.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void vR(boolean z) {
        this.mgY = true;
        if (z) {
            this.ewZ.setScaleType(ImageView.ScaleType.CENTER);
            this.ewZ.setImageBitmap(null);
            this.ewZ.setImageResource(0);
            this.ewZ.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.mgT.setVisibility(0);
            return;
        }
        this.ewZ.setScaleType(ImageView.ScaleType.CENTER);
        this.ewZ.setImageResource(0);
        this.ewZ.setImageBitmap(null);
        this.ewZ.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.mgT.setVisibility(8);
    }

    public void a(d dVar) {
        this.mgY = false;
        this.mgT.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.drg()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fL(long j) {
        return j > mgV ? this.mgW.format(Long.valueOf(j)) : this.mgX.format(Long.valueOf(j));
    }
}
