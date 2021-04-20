package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class PbVideoWifiTipLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20184e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20185f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20186g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20187h;
    public TextView i;
    public View.OnClickListener j;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.l.a.u(true, PbVideoWifiTipLayout.this.getContext(), PbVideoWifiTipLayout.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            if (PbVideoWifiTipLayout.this.j != null) {
                PbVideoWifiTipLayout.this.j.onClick(view);
            }
        }
    }

    public PbVideoWifiTipLayout(Context context) {
        super(context);
        b();
    }

    public final void b() {
        LinearLayout.inflate(getContext(), R.layout.layout_video_wifi_tip, this);
        this.f20184e = (TextView) findViewById(R.id.tv_video_duration);
        this.f20185f = (TextView) findViewById(R.id.tv_video_data);
        this.f20186g = (TextView) findViewById(R.id.tv_play);
        this.f20187h = (TextView) findViewById(R.id.tv_divider);
        TextView textView = (TextView) findViewById(R.id.tv_open_free_data);
        this.i = textView;
        textView.setOnClickListener(new a());
    }

    public TextView getTvOpenFreeData() {
        return this.i;
    }

    public TextView getTvPlay() {
        return this.f20186g;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        this.f20186g.setOnClickListener(onClickListener);
    }

    public void setData(int i, int i2) {
        if (i > 0) {
            this.f20184e.setText(String.format(getResources().getString(R.string.pb_video_duration), StringHelper.stringForVideoTime(i * 1000)));
        } else {
            this.f20184e.setVisibility(8);
            this.f20187h.setVisibility(8);
        }
        if (i2 > 0) {
            this.f20185f.setText(String.format(getResources().getString(R.string.pb_video_data), new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT).format(i2 / 1048576.0f)));
        } else {
            this.f20185f.setVisibility(8);
            this.f20187h.setVisibility(8);
        }
        this.i.setVisibility(0);
    }

    public PbVideoWifiTipLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public PbVideoWifiTipLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
