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
/* loaded from: classes22.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object mIM = new Object();
    private static long mIN = BdKVCache.MILLS_1Hour;
    private ImageView eJL;
    private Context mContext;
    private TextView mIL;
    private SimpleDateFormat mIO;
    private SimpleDateFormat mIP;
    private boolean mIQ;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.mIQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIQ = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIQ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.eJL = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.eJL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.mIL = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.mIP = new SimpleDateFormat("mm:ss");
        this.mIO = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.mIP.setTimeZone(timeZone);
        this.mIO.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.mIQ) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.eJL.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.eJL.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(gn(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.eJL.setScaleType(ImageView.ScaleType.CENTER);
            this.eJL.setImageBitmap(null);
            this.eJL.setImageResource(R.drawable.img_default_100);
            this.eJL.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void wR(boolean z) {
        this.mIQ = true;
        if (z) {
            this.eJL.setScaleType(ImageView.ScaleType.CENTER);
            this.eJL.setImageBitmap(null);
            this.eJL.setImageResource(0);
            this.eJL.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.mIL.setVisibility(0);
            return;
        }
        this.eJL.setScaleType(ImageView.ScaleType.CENTER);
        this.eJL.setImageResource(0);
        this.eJL.setImageBitmap(null);
        this.eJL.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.mIL.setVisibility(8);
    }

    public void a(d dVar) {
        this.mIQ = false;
        this.mIL.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dGE()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String gn(long j) {
        return j > mIN ? this.mIO.format(Long.valueOf(j)) : this.mIP.format(Long.valueOf(j));
    }
}
