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
/* loaded from: classes11.dex */
public class OnlineAudienceItemView extends LinearLayout {
    public TextView aDM;
    public HeadImageView gPH;
    public TbImageView gPI;
    public TextView gPK;
    public YuyinALALevelView opU;

    public OnlineAudienceItemView(Context context) {
        this(context, null);
    }

    public OnlineAudienceItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, String str, String str2, long j, String str3, int i2) {
        if (i >= 1 && i <= 3 && j > 0) {
            this.gPI.setVisibility(0);
        } else {
            this.gPI.setVisibility(8);
        }
        m.a(this.gPH, str2, true, false);
        if (i2 == 7) {
            this.gPI.setVisibility(0);
            this.gPI.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.gPI.setVisibility(0);
            this.gPI.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.gPI.setVisibility(0);
            this.gPI.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.gPI.setVisibility(0);
            this.gPI.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.gPI.setVisibility(8);
        }
        this.aDM.setText(str);
        if (j > 0) {
            this.gPK.setText(str3 + "魅力");
        } else {
            this.gPK.setText("");
        }
        this.aDM.setMaxWidth(ScreenHelper.getScreenWidth(getContext()) - BdUtilHelper.dip2px(getContext(), 230.0f));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_online_audience_list_item, (ViewGroup) this, true);
        setOrientation(0);
        Ge();
        initView();
    }

    private void Ge() {
        this.gPH = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gPI = (TbImageView) findViewById(a.f.iv_pendant);
        this.opU = (YuyinALALevelView) findViewById(a.f.level);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.gPK = (TextView) findViewById(a.f.tv_value);
    }

    private void initView() {
        this.gPH.setAutoChangeStyle(false);
        this.gPH.setDrawBorder(false);
        this.gPH.setIsRound(true);
        this.gPI.setDefaultBgResource(a.c.sdk_transparent);
        this.gPI.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
