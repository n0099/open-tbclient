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
    public static final Object kBu = new Object();
    private static long kBv = BdKVCache.MILLS_1Hour;
    private ImageView dtO;
    private TextView kBt;
    private SimpleDateFormat kBw;
    private SimpleDateFormat kBx;
    private boolean kBy;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.kBy = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kBy = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kBy = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.dtO = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.dtO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.kBt = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.kBx = new SimpleDateFormat("mm:ss");
        this.kBw = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.kBx.setTimeZone(timeZone);
        this.kBw.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.kBy) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.dtO.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.dtO.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(eI(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.dtO.setScaleType(ImageView.ScaleType.CENTER);
            this.dtO.setImageBitmap(null);
            this.dtO.setImageResource(R.drawable.img_default_100);
            this.dtO.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void tw(boolean z) {
        this.kBy = true;
        if (z) {
            this.dtO.setScaleType(ImageView.ScaleType.CENTER);
            this.dtO.setImageBitmap(null);
            this.dtO.setImageResource(0);
            this.dtO.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.kBt.setVisibility(0);
            return;
        }
        this.dtO.setScaleType(ImageView.ScaleType.CENTER);
        this.dtO.setImageResource(0);
        this.dtO.setImageBitmap(null);
        this.dtO.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.kBt.setVisibility(8);
    }

    public void a(d dVar) {
        this.kBy = false;
        this.kBt.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.hasLoaded()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String eI(long j) {
        return j > kBv ? this.kBw.format(Long.valueOf(j)) : this.kBx.format(Long.valueOf(j));
    }
}
