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
    public TextView aDP;
    public TextView gwT;
    public ImageView gwU;
    public HeadImageView gwV;
    public TextView gwY;
    public YuyinALALevelView nTw;
    public TbImageView nUj;
    private TextView nUk;
    private i.b nUl;
    private a nUm;

    /* loaded from: classes4.dex */
    public interface a {
        void dXm();
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
        this.nUl = bVar;
        if (i == 1) {
            this.gwT.setVisibility(8);
            this.gwU.setVisibility(0);
            this.gwU.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gwT.setVisibility(8);
            this.gwU.setVisibility(0);
            this.gwU.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gwT.setVisibility(8);
            this.gwU.setVisibility(0);
            this.gwU.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gwT.setVisibility(0);
            this.gwU.setVisibility(8);
            this.gwT.setText(i + "");
        }
        this.aDP.setText(this.nUl.user_nickname);
        l.a(this.gwV, bVar.bd_portrait, true, false);
        this.gwY.setText(bVar.aGx);
        try {
            i2 = Integer.valueOf(bVar.aGy).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.nUj.setVisibility(0);
            this.nUj.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.nUj.setVisibility(0);
            this.nUj.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.nUj.setVisibility(0);
            this.nUj.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.nUj.setVisibility(0);
            this.nUj.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.nUj.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.nUk.setVisibility(8);
            return;
        }
        this.nUk.setVisibility(0);
        bX(bVar.Dy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciP() {
        if (this.nUm != null) {
            this.nUm.dXm();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Hq();
        initView();
    }

    private void Hq() {
        this.gwT = (TextView) findViewById(a.f.tv_rank);
        this.gwU = (ImageView) findViewById(a.f.iv_rank);
        this.gwV = (HeadImageView) findViewById(a.f.iv_avatar);
        this.nUj = (TbImageView) findViewById(a.f.iv_pendant);
        this.nTw = (YuyinALALevelView) findViewById(a.f.level);
        this.aDP = (TextView) findViewById(a.f.tv_name);
        this.gwY = (TextView) findViewById(a.f.tv_value);
        this.nUk = (TextView) findViewById(a.f.tv_attention);
    }

    private void initView() {
        this.gwV.setAutoChangeStyle(false);
        this.gwV.setDrawBorder(false);
        this.gwV.setIsRound(true);
        this.nUj.setDefaultBgResource(a.c.sdk_transparent);
        this.nUj.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.nUk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.ciP();
            }
        });
    }

    private void bX(boolean z) {
        this.nUk.setVisibility(0);
        if (z) {
            this.nUk.setBackgroundResource(a.c.sdk_white_alpha100);
            this.nUk.setText("已关注");
            this.nUk.setTextColor(getResources().getColor(a.c.sdk_color_858585));
            return;
        }
        this.nUk.setBackgroundResource(a.e.yuyin_round_charm_item_attention_bg);
        this.nUk.setText("关注");
        this.nUk.setTextColor(getResources().getColor(a.c.sdk_color_ff1e66));
    }

    public void setmCallBack(a aVar) {
        this.nUm = aVar;
    }
}
