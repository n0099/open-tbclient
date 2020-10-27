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
    public static final Object nkT = new Object();
    private static long nkU = BdKVCache.MILLS_1Hour;
    private ImageView feo;
    private Context mContext;
    private View mRootView;
    private TextView nkS;
    private SimpleDateFormat nkV;
    private SimpleDateFormat nkW;
    private boolean nkX;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.nkX = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nkX = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nkX = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.feo = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.feo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.nkS = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.nkW = new SimpleDateFormat("mm:ss");
        this.nkV = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nkW.setTimeZone(timeZone);
        this.nkV.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.nkX) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.feo.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.feo.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(gG(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.feo.setScaleType(ImageView.ScaleType.CENTER);
            this.feo.setImageBitmap(null);
            this.feo.setImageResource(R.drawable.img_default_100);
            this.feo.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void xP(boolean z) {
        this.nkX = true;
        if (z) {
            this.feo.setScaleType(ImageView.ScaleType.CENTER);
            this.feo.setImageBitmap(null);
            this.feo.setImageResource(0);
            this.feo.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.nkS.setVisibility(0);
            return;
        }
        this.feo.setScaleType(ImageView.ScaleType.CENTER);
        this.feo.setImageResource(0);
        this.feo.setImageBitmap(null);
        this.feo.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.nkS.setVisibility(8);
    }

    public void a(d dVar) {
        this.nkX = false;
        this.nkS.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dNy()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String gG(long j) {
        return j > nkU ? this.nkV.format(Long.valueOf(j)) : this.nkW.format(Long.valueOf(j));
    }
}
