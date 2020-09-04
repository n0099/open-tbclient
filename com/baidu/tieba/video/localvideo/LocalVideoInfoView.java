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
    public static final Object myW = new Object();
    private static long myX = BdKVCache.MILLS_1Hour;
    private ImageView eHE;
    private Context mContext;
    private View mRootView;
    private TextView myV;
    private SimpleDateFormat myY;
    private SimpleDateFormat myZ;
    private boolean mza;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.mza = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mza = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mza = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.eHE = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.eHE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.myV = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.myZ = new SimpleDateFormat("mm:ss");
        this.myY = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.myZ.setTimeZone(timeZone);
        this.myY.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.mza) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.eHE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.eHE.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(fZ(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.eHE.setScaleType(ImageView.ScaleType.CENTER);
            this.eHE.setImageBitmap(null);
            this.eHE.setImageResource(R.drawable.img_default_100);
            this.eHE.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void wI(boolean z) {
        this.mza = true;
        if (z) {
            this.eHE.setScaleType(ImageView.ScaleType.CENTER);
            this.eHE.setImageBitmap(null);
            this.eHE.setImageResource(0);
            this.eHE.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.myV.setVisibility(0);
            return;
        }
        this.eHE.setScaleType(ImageView.ScaleType.CENTER);
        this.eHE.setImageResource(0);
        this.eHE.setImageBitmap(null);
        this.eHE.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.myV.setVisibility(8);
    }

    public void a(d dVar) {
        this.mza = false;
        this.myV.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dCK()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String fZ(long j) {
        return j > myX ? this.myY.format(Long.valueOf(j)) : this.myZ.format(Long.valueOf(j));
    }
}
