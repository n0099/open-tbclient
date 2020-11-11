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
    public static final Object nqQ = new Object();
    private static long nqR = BdKVCache.MILLS_1Hour;
    private ImageView fkh;
    private Context mContext;
    private View mRootView;
    private TextView nqP;
    private SimpleDateFormat nqS;
    private SimpleDateFormat nqT;
    private boolean nqU;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.nqU = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nqU = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nqU = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.fkh = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.fkh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.nqP = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.nqT = new SimpleDateFormat("mm:ss");
        this.nqS = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.nqT.setTimeZone(timeZone);
        this.nqS.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.nqU) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.fkh.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.fkh.setImageBitmap(dVar.getThumbnailBitmap());
                    this.textView.setText(hc(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.fkh.setScaleType(ImageView.ScaleType.CENTER);
            this.fkh.setImageBitmap(null);
            this.fkh.setImageResource(R.drawable.img_default_100);
            this.fkh.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void xY(boolean z) {
        this.nqU = true;
        if (z) {
            this.fkh.setScaleType(ImageView.ScaleType.CENTER);
            this.fkh.setImageBitmap(null);
            this.fkh.setImageResource(0);
            this.fkh.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.nqP.setVisibility(0);
            return;
        }
        this.fkh.setScaleType(ImageView.ScaleType.CENTER);
        this.fkh.setImageResource(0);
        this.fkh.setImageBitmap(null);
        this.fkh.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.nqP.setVisibility(8);
    }

    public void a(d dVar) {
        this.nqU = false;
        this.nqP.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.dQa()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String hc(long j) {
        return j > nqR ? this.nqS.format(Long.valueOf(j)) : this.nqT.format(Long.valueOf(j));
    }
}
