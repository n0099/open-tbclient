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
    public static final Object lZy = new Object();
    private static long lZz = BdKVCache.MILLS_1Hour;
    private ImageView eqH;
    private SimpleDateFormat lZA;
    private SimpleDateFormat lZB;
    private boolean lZC;
    private TextView lZx;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.lZC = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lZC = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lZC = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.eqH = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.eqH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.lZx = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.lZB = new SimpleDateFormat("mm:ss");
        this.lZA = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.lZB.setTimeZone(timeZone);
        this.lZA.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.lZC) {
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
        this.lZC = true;
        if (z) {
            this.eqH.setScaleType(ImageView.ScaleType.CENTER);
            this.eqH.setImageBitmap(null);
            this.eqH.setImageResource(0);
            this.eqH.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.lZx.setVisibility(0);
            return;
        }
        this.eqH.setScaleType(ImageView.ScaleType.CENTER);
        this.eqH.setImageResource(0);
        this.eqH.setImageBitmap(null);
        this.eqH.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.lZx.setVisibility(8);
    }

    public void a(d dVar) {
        this.lZC = false;
        this.lZx.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dnS()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fy(long j) {
        return j > lZz ? this.lZA.format(Long.valueOf(j)) : this.lZB.format(Long.valueOf(j));
    }
}
