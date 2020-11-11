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
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.YuyinALALevelView;
/* loaded from: classes4.dex */
public class CharmRankItemView extends LinearLayout {
    public TextView aFA;
    public TextView gxm;
    public ImageView gxn;
    public HeadImageView gxo;
    public TextView gxr;
    public YuyinALALevelView nRT;
    public TbImageView nSG;
    private TextView nSH;
    private i.b nSI;
    private a nSJ;

    /* loaded from: classes4.dex */
    public interface a {
        void dXn();
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
        this.nSI = bVar;
        if (i == 1) {
            this.gxm.setVisibility(8);
            this.gxn.setVisibility(0);
            this.gxn.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gxm.setVisibility(8);
            this.gxn.setVisibility(0);
            this.gxn.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gxm.setVisibility(8);
            this.gxn.setVisibility(0);
            this.gxn.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gxm.setVisibility(0);
            this.gxn.setVisibility(8);
            this.gxm.setText(i + "");
        }
        this.aFA.setText(this.nSI.user_nickname);
        l.a(this.gxo, bVar.bd_portrait, true, false);
        this.gxr.setText(bVar.aIi);
        try {
            i2 = Integer.valueOf(bVar.aIj).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.nSG.setVisibility(0);
            this.nSG.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.nSG.setVisibility(0);
            this.nSG.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.nSG.setVisibility(0);
            this.nSG.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.nSG.setVisibility(0);
            this.nSG.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.nSG.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.nSH.setVisibility(8);
            return;
        }
        this.nSH.setVisibility(0);
        bV(bVar.Eh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjw() {
        if (this.nSJ != null) {
            this.nSJ.dXn();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        HZ();
        initView();
    }

    private void HZ() {
        this.gxm = (TextView) findViewById(a.f.tv_rank);
        this.gxn = (ImageView) findViewById(a.f.iv_rank);
        this.gxo = (HeadImageView) findViewById(a.f.iv_avatar);
        this.nSG = (TbImageView) findViewById(a.f.iv_pendant);
        this.nRT = (YuyinALALevelView) findViewById(a.f.level);
        this.aFA = (TextView) findViewById(a.f.tv_name);
        this.gxr = (TextView) findViewById(a.f.tv_value);
        this.nSH = (TextView) findViewById(a.f.tv_attention);
    }

    private void initView() {
        this.gxo.setAutoChangeStyle(false);
        this.gxo.setDrawBorder(false);
        this.gxo.setIsRound(true);
        this.nSG.setDefaultBgResource(a.c.sdk_transparent);
        this.nSG.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.nSH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cjw();
            }
        });
    }

    private void bV(boolean z) {
        this.nSH.setVisibility(0);
        if (z) {
            this.nSH.setBackgroundResource(a.c.sdk_white_alpha100);
            this.nSH.setText("已关注");
            this.nSH.setTextColor(getResources().getColor(a.c.sdk_color_858585));
            return;
        }
        this.nSH.setBackgroundResource(a.e.yuyin_round_charm_item_attention_bg);
        this.nSH.setText("关注");
        this.nSH.setTextColor(getResources().getColor(a.c.sdk_color_ff1e66));
    }

    public void setmCallBack(a aVar) {
        this.nSJ = aVar;
    }
}
