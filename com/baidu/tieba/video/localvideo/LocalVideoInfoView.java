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
    public static final Object nGa = new Object();
    private static long nGb = BdKVCache.MILLS_1Hour;
    private ImageView fqN;
    private Context mContext;
    private View mRootView;
    private TextView nFZ;
    private SimpleDateFormat nGc;
    private SimpleDateFormat nGd;
    private boolean nGe;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.nGe = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nGe = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nGe = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.fqN = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.fqN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.nFZ = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.nGd = new SimpleDateFormat("mm:ss");
        this.nGc = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nGd.setTimeZone(timeZone);
        this.nGc.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.nGe) {
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
        this.nGe = true;
        if (z) {
            this.fqN.setScaleType(ImageView.ScaleType.CENTER);
            this.fqN.setImageBitmap(null);
            this.fqN.setImageResource(0);
            this.fqN.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.nFZ.setVisibility(0);
            return;
        }
        this.fqN.setScaleType(ImageView.ScaleType.CENTER);
        this.fqN.setImageResource(0);
        this.fqN.setImageBitmap(null);
        this.fqN.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.nFZ.setVisibility(8);
    }

    public void a(d dVar) {
        this.nGe = false;
        this.nFZ.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dVu()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String hK(long j) {
        return j > nGb ? this.nGc.format(Long.valueOf(j)) : this.nGd.format(Long.valueOf(j));
    }
}
