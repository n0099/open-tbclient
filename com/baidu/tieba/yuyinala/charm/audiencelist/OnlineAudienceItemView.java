package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.YuyinALALevelView;
/* loaded from: classes4.dex */
public class OnlineAudienceItemView extends LinearLayout {
    public TextView aDP;
    public HeadImageView gwV;
    public TbImageView gwW;
    public TextView gwY;
    public YuyinALALevelView nTw;

    public OnlineAudienceItemView(Context context) {
        this(context, null);
    }

    public OnlineAudienceItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, String str, String str2, long j, int i2) {
        if (i >= 1 && i <= 3 && j > 0) {
            this.gwW.setVisibility(0);
        } else {
            this.gwW.setVisibility(8);
        }
        l.a(this.gwV, str2, true, false);
        if (i2 == 7) {
            this.gwW.setVisibility(0);
            this.gwW.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.gwW.setVisibility(0);
            this.gwW.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.gwW.setVisibility(0);
            this.gwW.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.gwW.setVisibility(0);
            this.gwW.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.gwW.setVisibility(8);
        }
        this.aDP.setText(str);
        if (j > 0) {
            this.gwY.setText(String.format("%s", StringHelper.formatYuyinValue(j)));
        } else {
            this.gwY.setText("");
        }
        this.aDP.setMaxWidth(ScreenHelper.getScreenWidth(getContext()) - BdUtilHelper.dip2px(getContext(), 230.0f));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_online_audience_list_item, (ViewGroup) this, true);
        setOrientation(0);
        Hq();
        initView();
    }

    private void Hq() {
        this.gwV = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gwW = (TbImageView) findViewById(a.f.iv_pendant);
        this.nTw = (YuyinALALevelView) findViewById(a.f.level);
        this.aDP = (TextView) findViewById(a.f.tv_name);
        this.gwY = (TextView) findViewById(a.f.tv_value);
    }

    private void initView() {
        this.gwV.setAutoChangeStyle(false);
        this.gwV.setDrawBorder(false);
        this.gwV.setIsRound(true);
        this.gwW.setDefaultBgResource(a.c.sdk_transparent);
        this.gwW.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
