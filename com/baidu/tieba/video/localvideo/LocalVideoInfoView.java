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
    public static final Object llN = new Object();
    private static long llO = BdKVCache.MILLS_1Hour;
    private ImageView dTJ;
    private TextView llM;
    private SimpleDateFormat llP;
    private SimpleDateFormat llQ;
    private boolean llR;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.llR = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.llR = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.llR = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dTJ = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dTJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.llM = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.llQ = new SimpleDateFormat("mm:ss");
        this.llP = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.llQ.setTimeZone(timeZone);
        this.llP.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.llR) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.dTJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.dTJ.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(fu(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.dTJ.setScaleType(ImageView.ScaleType.CENTER);
            this.dTJ.setImageBitmap(null);
            this.dTJ.setImageResource(R.drawable.img_default_100);
            this.dTJ.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void ux(boolean z) {
        this.llR = true;
        if (z) {
            this.dTJ.setScaleType(ImageView.ScaleType.CENTER);
            this.dTJ.setImageBitmap(null);
            this.dTJ.setImageResource(0);
            this.dTJ.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.llM.setVisibility(0);
            return;
        }
        this.dTJ.setScaleType(ImageView.ScaleType.CENTER);
        this.dTJ.setImageResource(0);
        this.dTJ.setImageBitmap(null);
        this.dTJ.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.llM.setVisibility(8);
    }

    public void a(d dVar) {
        this.llR = false;
        this.llM.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dcf()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fu(long j) {
        return j > llO ? this.llP.format(Long.valueOf(j)) : this.llQ.format(Long.valueOf(j));
    }
}
