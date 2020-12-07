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
    public TextView aGv;
    public TextView gFE;
    public ImageView gFF;
    public HeadImageView gFG;
    public TextView gFJ;
    public YuyinALALevelView oiu;
    public TbImageView ojh;
    private TextView oji;
    private i.b ojj;
    private a ojk;

    /* loaded from: classes4.dex */
    public interface a {
        void ecQ();
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
        this.ojj = bVar;
        if (i == 1) {
            this.gFE.setVisibility(8);
            this.gFF.setVisibility(0);
            this.gFF.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gFE.setVisibility(8);
            this.gFF.setVisibility(0);
            this.gFF.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gFE.setVisibility(8);
            this.gFF.setVisibility(0);
            this.gFF.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gFE.setVisibility(0);
            this.gFF.setVisibility(8);
            this.gFE.setText(i + "");
        }
        this.aGv.setText(this.ojj.user_nickname);
        l.a(this.gFG, bVar.bd_portrait, true, false);
        this.gFJ.setText(bVar.aJh);
        try {
            i2 = Integer.valueOf(bVar.aJi).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.ojh.setVisibility(0);
            this.ojh.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.ojh.setVisibility(0);
            this.ojh.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.ojh.setVisibility(0);
            this.ojh.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.ojh.setVisibility(0);
            this.ojh.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.ojh.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.oji.setVisibility(8);
            return;
        }
        this.oji.setVisibility(0);
        cg(bVar.Fj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmJ() {
        if (this.ojk != null) {
            this.ojk.ecQ();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Jh();
        initView();
    }

    private void Jh() {
        this.gFE = (TextView) findViewById(a.f.tv_rank);
        this.gFF = (ImageView) findViewById(a.f.iv_rank);
        this.gFG = (HeadImageView) findViewById(a.f.iv_avatar);
        this.ojh = (TbImageView) findViewById(a.f.iv_pendant);
        this.oiu = (YuyinALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFJ = (TextView) findViewById(a.f.tv_value);
        this.oji = (TextView) findViewById(a.f.tv_attention);
    }

    private void initView() {
        this.gFG.setAutoChangeStyle(false);
        this.gFG.setDrawBorder(false);
        this.gFG.setIsRound(true);
        this.ojh.setDefaultBgResource(a.c.sdk_transparent);
        this.ojh.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.oji.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cmJ();
            }
        });
    }

    private void cg(boolean z) {
        this.oji.setVisibility(0);
        if (z) {
            this.oji.setBackgroundResource(a.c.sdk_white_alpha100);
            this.oji.setText("已关注");
            this.oji.setTextColor(getResources().getColor(a.c.sdk_color_858585));
            return;
        }
        this.oji.setBackgroundResource(a.e.yuyin_round_charm_item_attention_bg);
        this.oji.setText("关注");
        this.oji.setTextColor(getResources().getColor(a.c.sdk_color_ff1e66));
    }

    public void setmCallBack(a aVar) {
        this.ojk = aVar;
    }
}
