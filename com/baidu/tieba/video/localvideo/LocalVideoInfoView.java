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
/* loaded from: classes5.dex */
public class LocalVideoInfoView extends RelativeLayout {
    public static final Object jBf = new Object();
    private static long jBg = BdKVCache.MILLS_1Hour;
    private ImageView aAU;
    private TextView jBe;
    private SimpleDateFormat jBh;
    private SimpleDateFormat jBi;
    private boolean jBj;
    private Context mContext;
    private View mRootView;
    private TextView textView;
    private String videoPath;

    public LocalVideoInfoView(Context context) {
        super(context);
        this.jBj = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBj = false;
        init(context);
    }

    public LocalVideoInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBj = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.local_video_info_view, (ViewGroup) null);
        this.aAU = (ImageView) this.mRootView.findViewById(R.id.local_video_selet_thumb);
        this.aAU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.textView = (TextView) this.mRootView.findViewById(R.id.local_video_select_duration);
        this.jBe = (TextView) this.mRootView.findViewById(R.id.no_video_title);
        addView(this.mRootView, -1, -1);
        this.jBi = new SimpleDateFormat("mm:ss");
        this.jBh = new SimpleDateFormat("HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        this.jBi.setTimeZone(timeZone);
        this.jBh.setTimeZone(timeZone);
    }

    public void setDataToView(d dVar) {
        if (!this.jBj) {
            if (dVar != null) {
                if (dVar.getVideoPath().equals(this.videoPath)) {
                    this.aAU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.aAU.setImageBitmap(dVar.cup());
                    this.textView.setText(dY(dVar.getDuration()));
                    return;
                }
                return;
            }
            this.aAU.setScaleType(ImageView.ScaleType.CENTER);
            this.aAU.setImageBitmap(null);
            this.aAU.setImageResource(R.drawable.img_default_100);
            this.aAU.setBackgroundColor(getResources().getColor(R.color.common_color_10304));
            this.textView.setText("");
        }
    }

    public void rt(boolean z) {
        this.jBj = true;
        if (z) {
            this.aAU.setScaleType(ImageView.ScaleType.CENTER);
            this.aAU.setImageBitmap(null);
            this.aAU.setImageResource(0);
            this.aAU.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.jBe.setVisibility(0);
            return;
        }
        this.aAU.setScaleType(ImageView.ScaleType.CENTER);
        this.aAU.setImageResource(0);
        this.aAU.setImageBitmap(null);
        this.aAU.setBackgroundColor(getResources().getColor(R.color.white_alpha50));
        this.textView.setText("");
        this.jBe.setVisibility(8);
    }

    public void a(d dVar) {
        this.jBj = false;
        this.jBe.setVisibility(8);
        this.videoPath = dVar.getVideoPath();
        if (dVar != null && dVar.cuq()) {
            setDataToView(dVar);
        } else {
            setDataToView(null);
        }
    }

    private String dY(long j) {
        return j > jBg ? this.jBh.format(Long.valueOf(j)) : this.jBi.format(Long.valueOf(j));
    }
}
