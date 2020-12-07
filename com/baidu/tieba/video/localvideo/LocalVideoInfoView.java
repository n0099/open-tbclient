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
    public static final Object nFY = new Object();
    private static long nFZ = BdKVCache.MILLS_1Hour;
    private ImageView fqN;
    private Context mContext;
    private View mRootView;
    private TextView nFX;
    private SimpleDateFormat nGa;
    private SimpleDateFormat nGb;
    private boolean nGc;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.nGc = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nGc = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nGc = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.fqN = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.fqN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.nFX = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.nGb = new SimpleDateFormat("mm:ss");
        this.nGa = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nGb.setTimeZone(timeZone);
        this.nGa.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.nGc) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.fqN.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.fqN.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(hK(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.fqN.setScaleType(ImageView.ScaleType.CENTER);
            this.fqN.setImageBitmap(null);
            this.fqN.setImageResource(R.drawable.img_default_100);
            this.fqN.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void yK(boolean z) {
        this.nGc = true;
        if (z) {
            this.fqN.setScaleType(ImageView.ScaleType.CENTER);
            this.fqN.setImageBitmap(null);
            this.fqN.setImageResource(0);
            this.fqN.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.nFX.setVisibility(0);
            return;
        }
        this.fqN.setScaleType(ImageView.ScaleType.CENTER);
        this.fqN.setImageResource(0);
        this.fqN.setImageBitmap(null);
        this.fqN.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.nFX.setVisibility(8);
    }

    public void a(d dVar) {
        this.nGc = false;
        this.nFX.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dVt()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String hK(long j) {
        return j > nFZ ? this.nGa.format(Long.valueOf(j)) : this.nGb.format(Long.valueOf(j));
    }
}
