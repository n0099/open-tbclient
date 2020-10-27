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
    public TextView aEK;
    public HeadImageView grA;
    public TbImageView grB;
    public TextView grD;
    public YuyinALALevelView nLZ;

    public OnlineAudienceItemView(Context context) {
        this(context, null);
    }

    public OnlineAudienceItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, String str, String str2, long j, int i2) {
        if (i >= 1 && i <= 3 && j > 0) {
            this.grB.setVisibility(0);
        } else {
            this.grB.setVisibility(8);
        }
        l.a(this.grA, str2, true, false);
        if (i2 == 7) {
            this.grB.setVisibility(0);
            this.grB.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.grB.setVisibility(0);
            this.grB.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.grB.setVisibility(0);
            this.grB.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.grB.setVisibility(0);
            this.grB.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
        } else {
            this.grB.setVisibility(8);
        }
        this.aEK.setText(str);
        if (j > 0) {
            this.grD.setText(String.format("%s", StringHelper.formatYuyinValue(j)));
        } else {
            this.grD.setText("");
        }
        this.aEK.setMaxWidth(ScreenHelper.getScreenWidth(getContext()) - BdUtilHelper.dip2px(getContext(), 230.0f));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.yuyin_online_audience_list_item, (ViewGroup) this, true);
        setOrientation(0);
        Hy();
        initView();
    }

    private void Hy() {
        this.grA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.grB = (TbImageView) findViewById(a.g.iv_pendant);
        this.nLZ = (YuyinALALevelView) findViewById(a.g.level);
        this.aEK = (TextView) findViewById(a.g.tv_name);
        this.grD = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.grA.setAutoChangeStyle(false);
        this.grA.setDrawBorder(false);
        this.grA.setIsRound(true);
        this.grB.setDefaultBgResource(a.d.sdk_transparent);
        this.grB.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}
