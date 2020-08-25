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
    public static final Object myE = new Object();
    private static long myF = BdKVCache.MILLS_1Hour;
    private ImageView eHA;
    private Context mContext;
    private View mRootView;
    private TextView myD;
    private SimpleDateFormat myG;
    private SimpleDateFormat myH;
    private boolean myI;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.myI = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myI = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.myI = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.eHA = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.eHA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.myD = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.myH = new SimpleDateFormat("mm:ss");
        this.myG = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.myH.setTimeZone(timeZone);
        this.myG.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.myI) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.eHA.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.eHA.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(fX(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.eHA.setScaleType(ImageView.ScaleType.CENTER);
            this.eHA.setImageBitmap(null);
            this.eHA.setImageResource(R.drawable.img_default_100);
            this.eHA.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void wG(boolean z) {
        this.myI = true;
        if (z) {
            this.eHA.setScaleType(ImageView.ScaleType.CENTER);
            this.eHA.setImageBitmap(null);
            this.eHA.setImageResource(0);
            this.eHA.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.myD.setVisibility(0);
            return;
        }
        this.eHA.setScaleType(ImageView.ScaleType.CENTER);
        this.eHA.setImageResource(0);
        this.eHA.setImageBitmap(null);
        this.eHA.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.myD.setVisibility(8);
    }

    public void a(d dVar) {
        this.myI = false;
        this.myD.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dCB()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fX(long j) {
        return j > myF ? this.myG.format(Long.valueOf(j)) : this.myH.format(Long.valueOf(j));
    }
}
