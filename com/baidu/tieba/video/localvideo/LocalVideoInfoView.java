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
/* loaded from: classes10.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object kzB = new Object();
    private static long kzC = BdKVCache.MILLS_1Hour;
    private ImageView dto;
    private TextView kzA;
    private SimpleDateFormat kzD;
    private SimpleDateFormat kzE;
    private boolean kzF;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.kzF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kzF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzF = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dto = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.kzA = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.kzE = new SimpleDateFormat("mm:ss");
        this.kzD = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kzE.setTimeZone(timeZone);
        this.kzD.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.kzF) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.dto.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.dto.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(eH(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.dto.setScaleType(ImageView.ScaleType.CENTER);
            this.dto.setImageBitmap(null);
            this.dto.setImageResource(R.drawable.img_default_100);
            this.dto.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void tq(boolean z) {
        this.kzF = true;
        if (z) {
            this.dto.setScaleType(ImageView.ScaleType.CENTER);
            this.dto.setImageBitmap(null);
            this.dto.setImageResource(0);
            this.dto.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.kzA.setVisibility(0);
            return;
        }
        this.dto.setScaleType(ImageView.ScaleType.CENTER);
        this.dto.setImageResource(0);
        this.dto.setImageBitmap(null);
        this.dto.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.kzA.setVisibility(8);
    }

    public void a(d dVar) {
        this.kzF = false;
        this.kzA.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.hasLoaded()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eH(long j) {
        return j > kzC ? this.kzD.format(Long.valueOf(j)) : this.kzE.format(Long.valueOf(j));
    }
}
