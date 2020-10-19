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
/* loaded from: classes23.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object mYt = new Object();
    private static long mYu = BdKVCache.MILLS_1Hour;
    private ImageView eVS;
    private Context mContext;
    private View mRootView;
    private TextView mYs;
    private SimpleDateFormat mYv;
    private SimpleDateFormat mYw;
    private boolean mYx;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.mYx = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mYx = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mYx = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.eVS = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.eVS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.mYs = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.mYw = new SimpleDateFormat("mm:ss");
        this.mYv = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.mYw.setTimeZone(timeZone);
        this.mYv.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.mYx) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.eVS.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.eVS.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(gF(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.eVS.setScaleType(ImageView.ScaleType.CENTER);
            this.eVS.setImageBitmap(null);
            this.eVS.setImageResource(R.drawable.img_default_100);
            this.eVS.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void xy(boolean z) {
        this.mYx = true;
        if (z) {
            this.eVS.setScaleType(ImageView.ScaleType.CENTER);
            this.eVS.setImageBitmap(null);
            this.eVS.setImageResource(0);
            this.eVS.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.mYs.setVisibility(0);
            return;
        }
        this.eVS.setScaleType(ImageView.ScaleType.CENTER);
        this.eVS.setImageResource(0);
        this.eVS.setImageBitmap(null);
        this.eVS.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.mYs.setVisibility(8);
    }

    public void a(d dVar) {
        this.mYx = false;
        this.mYs.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dKq()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String gF(long j) {
        return j > mYu ? this.mYv.format(Long.valueOf(j)) : this.mYw.format(Long.valueOf(j));
    }
}
