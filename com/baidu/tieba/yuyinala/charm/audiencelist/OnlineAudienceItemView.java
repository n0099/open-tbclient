package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.YuyinALALevelView;
/* loaded from: classes10.dex */
public class OnlineAudienceItemView extends LinearLayout {
    public TextView aFm;
    public HeadImageView gRq;
    public TbImageView gRr;
    public TextView gRt;
    public YuyinALALevelView osa;

    public OnlineAudienceItemView(Context context) {
        this(context, null);
    }

    public OnlineAudienceItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, String str, String str2, long j, String str3, int i2) {
        if (i >= 1 && i <= 3 && j > 0) {
            this.gRr.setVisibility(0);
        } else {
            this.gRr.setVisibility(8);
        }
        m.a(this.gRq, str2, true, false);
        if (i2 == 7) {
            this.gRr.setVisibility(0);
            this.gRr.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.gRr.setVisibility(0);
            this.gRr.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.gRr.setVisibility(0);
            this.gRr.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.gRr.setVisibility(0);
            this.gRr.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.gRr.setVisibility(8);
        }
        this.aFm.setText(str);
        if (j > 0) {
            this.gRt.setText(str3 + "魅力");
        } else {
            this.gRt.setText("");
        }
        this.aFm.setMaxWidth(ScreenHelper.getScreenWidth(getContext()) - BdUtilHelper.dip2px(getContext(), 230.0f));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_online_audience_list_item, (ViewGroup) this, true);
        setOrientation(0);
        Gh();
        initView();
    }

    private void Gh() {
        this.gRq = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gRr = (TbImageView) findViewById(a.f.iv_pendant);
        this.osa = (YuyinALALevelView) findViewById(a.f.level);
        this.aFm = (TextView) findViewById(a.f.tv_name);
        this.gRt = (TextView) findViewById(a.f.tv_value);
    }

    private void initView() {
        this.gRq.setAutoChangeStyle(false);
        this.gRq.setDrawBorder(false);
        this.gRq.setIsRound(true);
        this.gRr.setDefaultBgResource(a.c.sdk_transparent);
        this.gRr.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
