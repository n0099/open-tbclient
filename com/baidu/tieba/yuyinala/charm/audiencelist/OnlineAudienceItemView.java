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
    public TextView aBZ;
    public HeadImageView gMN;
    public TbImageView gMO;
    public TextView gMQ;
    public YuyinALALevelView ofB;

    public OnlineAudienceItemView(Context context) {
        this(context, null);
    }

    public OnlineAudienceItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, String str, String str2, long j, String str3, int i2) {
        if (i >= 1 && i <= 3 && j > 0) {
            this.gMO.setVisibility(0);
        } else {
            this.gMO.setVisibility(8);
        }
        m.a(this.gMN, str2, true, false);
        if (i2 == 7) {
            this.gMO.setVisibility(0);
            this.gMO.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.gMO.setVisibility(0);
            this.gMO.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.gMO.setVisibility(0);
            this.gMO.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.gMO.setVisibility(0);
            this.gMO.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.gMO.setVisibility(8);
        }
        this.aBZ.setText(str);
        if (j > 0) {
            this.gMQ.setText(str3 + "魅力");
        } else {
            this.gMQ.setText("");
        }
        this.aBZ.setMaxWidth(ScreenHelper.getScreenWidth(getContext()) - BdUtilHelper.dip2px(getContext(), 230.0f));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_online_audience_list_item, (ViewGroup) this, true);
        setOrientation(0);
        EO();
        initView();
    }

    private void EO() {
        this.gMN = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gMO = (TbImageView) findViewById(a.f.iv_pendant);
        this.ofB = (YuyinALALevelView) findViewById(a.f.level);
        this.aBZ = (TextView) findViewById(a.f.tv_name);
        this.gMQ = (TextView) findViewById(a.f.tv_value);
    }

    private void initView() {
        this.gMN.setAutoChangeStyle(false);
        this.gMN.setDrawBorder(false);
        this.gMN.setIsRound(true);
        this.gMO.setDefaultBgResource(a.c.sdk_transparent);
        this.gMO.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
