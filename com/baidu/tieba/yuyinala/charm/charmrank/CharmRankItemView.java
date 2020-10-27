package com.baidu.tieba.yuyinala.charm.charmrank;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.YuyinALALevelView;
/* loaded from: classes4.dex */
public class CharmRankItemView extends LinearLayout {
    public TextView aEK;
    public HeadImageView grA;
    public TextView grD;
    public TextView gry;
    public ImageView grz;
    public YuyinALALevelView nLZ;
    public TbImageView nMM;
    private TextView nMN;
    private i.b nMO;
    private a nMP;

    /* loaded from: classes4.dex */
    public interface a {
        void dUN();
    }

    public CharmRankItemView(Context context) {
        this(context, null);
        init();
    }

    public CharmRankItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, i.b bVar) {
        int i2;
        this.nMO = bVar;
        if (i == 1) {
            this.gry.setVisibility(8);
            this.grz.setVisibility(0);
            this.grz.setImageResource(a.f.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gry.setVisibility(8);
            this.grz.setVisibility(0);
            this.grz.setImageResource(a.f.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gry.setVisibility(8);
            this.grz.setVisibility(0);
            this.grz.setImageResource(a.f.yuyin_icon_live_list_thrid);
        } else {
            this.gry.setVisibility(0);
            this.grz.setVisibility(8);
            this.gry.setText(i + "");
        }
        this.aEK.setText(this.nMO.user_nickname);
        l.a(this.grA, bVar.bd_portrait, true, false);
        if (bVar.point != 0) {
            this.grD.setText("魅力值：" + StringHelper.formatYuyinValue(bVar.point));
        } else {
            this.grD.setText("");
        }
        BdUtilHelper.getDimens(getContext(), a.e.sdk_ds8);
        try {
            i2 = Integer.valueOf(bVar.aHr).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.nMM.setVisibility(0);
            this.nMM.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.nMM.setVisibility(0);
            this.nMM.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.nMM.setVisibility(0);
            this.nMM.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.nMM.setVisibility(0);
            this.nMM.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
        } else {
            this.nMM.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.nMN.setVisibility(8);
            return;
        }
        this.nMN.setVisibility(0);
        bU(bVar.DO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgU() {
        if (this.nMP != null) {
            this.nMP.dUN();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Hy();
        initView();
    }

    private void Hy() {
        this.gry = (TextView) findViewById(a.g.tv_rank);
        this.grz = (ImageView) findViewById(a.g.iv_rank);
        this.grA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.nMM = (TbImageView) findViewById(a.g.iv_pendant);
        this.nLZ = (YuyinALALevelView) findViewById(a.g.level);
        this.aEK = (TextView) findViewById(a.g.tv_name);
        this.grD = (TextView) findViewById(a.g.tv_value);
        this.nMN = (TextView) findViewById(a.g.tv_attention);
    }

    private void initView() {
        this.grA.setAutoChangeStyle(false);
        this.grA.setDrawBorder(false);
        this.grA.setIsRound(true);
        this.nMM.setDefaultBgResource(a.d.sdk_transparent);
        this.nMM.setDefaultErrorResource(a.f.sdk_shape_transparent);
        this.nMN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cgU();
            }
        });
    }

    private void bU(boolean z) {
        this.nMN.setVisibility(0);
        if (z) {
            this.nMN.setBackgroundResource(a.d.sdk_white_alpha100);
            this.nMN.setText("已关注");
            this.nMN.setTextColor(getResources().getColor(a.d.sdk_color_858585));
            return;
        }
        this.nMN.setBackgroundResource(a.f.yuyin_round_charm_item_attention_bg);
        this.nMN.setText("关注");
        this.nMN.setTextColor(getResources().getColor(a.d.sdk_color_ff1e66));
    }

    public void setmCallBack(a aVar) {
        this.nMP = aVar;
    }
}
