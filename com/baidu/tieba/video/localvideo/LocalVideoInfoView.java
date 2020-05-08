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
    public static final Object llR = new Object();
    private static long llS = BdKVCache.MILLS_1Hour;
    private ImageView dTO;
    private TextView llQ;
    private SimpleDateFormat llT;
    private SimpleDateFormat llU;
    private boolean llV;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.llV = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.llV = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.llV = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dTO = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dTO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.llQ = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.llU = new SimpleDateFormat("mm:ss");
        this.llT = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.llU.setTimeZone(timeZone);
        this.llT.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.llV) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.dTO.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.dTO.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(fu(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.dTO.setScaleType(ImageView.ScaleType.CENTER);
            this.dTO.setImageBitmap(null);
            this.dTO.setImageResource(R.drawable.img_default_100);
            this.dTO.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void ux(boolean z) {
        this.llV = true;
        if (z) {
            this.dTO.setScaleType(ImageView.ScaleType.CENTER);
            this.dTO.setImageBitmap(null);
            this.dTO.setImageResource(0);
            this.dTO.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.llQ.setVisibility(0);
            return;
        }
        this.dTO.setScaleType(ImageView.ScaleType.CENTER);
        this.dTO.setImageResource(0);
        this.dTO.setImageBitmap(null);
        this.dTO.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.llQ.setVisibility(8);
    }

    public void a(d dVar) {
        this.llV = false;
        this.llQ.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dcc()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fu(long j) {
        return j > llS ? this.llT.format(Long.valueOf(j)) : this.llU.format(Long.valueOf(j));
    }
}
