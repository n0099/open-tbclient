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
    public static final Object lZB = new Object();
    private static long lZC = BdKVCache.MILLS_1Hour;
    private ImageView eqH;
    private TextView lZA;
    private SimpleDateFormat lZD;
    private SimpleDateFormat lZE;
    private boolean lZF;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.lZF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lZF = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lZF = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.eqH = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.eqH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.lZA = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.lZE = new SimpleDateFormat("mm:ss");
        this.lZD = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.lZE.setTimeZone(timeZone);
        this.lZD.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.lZF) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.eqH.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.eqH.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(fy(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.eqH.setScaleType(ImageView.ScaleType.CENTER);
            this.eqH.setImageBitmap(null);
            this.eqH.setImageResource(R.drawable.img_default_100);
            this.eqH.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void vn(boolean z) {
        this.lZF = true;
        if (z) {
            this.eqH.setScaleType(ImageView.ScaleType.CENTER);
            this.eqH.setImageBitmap(null);
            this.eqH.setImageResource(0);
            this.eqH.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.lZA.setVisibility(0);
            return;
        }
        this.eqH.setScaleType(ImageView.ScaleType.CENTER);
        this.eqH.setImageResource(0);
        this.eqH.setImageBitmap(null);
        this.eqH.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.lZA.setVisibility(8);
    }

    public void a(d dVar) {
        this.lZF = false;
        this.lZA.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dnW()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fy(long j) {
        return j > lZC ? this.lZD.format(Long.valueOf(j)) : this.lZE.format(Long.valueOf(j));
    }
}
