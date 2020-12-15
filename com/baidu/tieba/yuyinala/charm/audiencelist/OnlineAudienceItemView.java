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
    public TextView aGv;
    public HeadImageView gFI;
    public TbImageView gFJ;
    public TextView gFL;
    public YuyinALALevelView oiw;

    public OnlineAudienceItemView(Context context) {
        this(context, null);
    }

    public OnlineAudienceItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, String str, String str2, long j, int i2) {
        if (i >= 1 && i <= 3 && j > 0) {
            this.gFJ.setVisibility(0);
        } else {
            this.gFJ.setVisibility(8);
        }
        l.a(this.gFI, str2, true, false);
        if (i2 == 7) {
            this.gFJ.setVisibility(0);
            this.gFJ.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.gFJ.setVisibility(0);
            this.gFJ.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.gFJ.setVisibility(0);
            this.gFJ.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.gFJ.setVisibility(0);
            this.gFJ.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.gFJ.setVisibility(8);
        }
        this.aGv.setText(str);
        if (j > 0) {
            this.gFL.setText(String.format("%s", StringHelper.formatYuyinValue(j)));
        } else {
            this.gFL.setText("");
        }
        this.aGv.setMaxWidth(ScreenHelper.getScreenWidth(getContext()) - BdUtilHelper.dip2px(getContext(), 230.0f));
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_online_audience_list_item, (ViewGroup) this, true);
        setOrientation(0);
        Jh();
        initView();
    }

    private void Jh() {
        this.gFI = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gFJ = (TbImageView) findViewById(a.f.iv_pendant);
        this.oiw = (YuyinALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFL = (TextView) findViewById(a.f.tv_value);
    }

    private void initView() {
        this.gFI.setAutoChangeStyle(false);
        this.gFI.setDrawBorder(false);
        this.gFI.setIsRound(true);
        this.gFJ.setDefaultBgResource(a.c.sdk_transparent);
        this.gFJ.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
