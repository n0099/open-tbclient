package com.baidu.tieba.yuyinala.charm.charmrank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.utils.m;
import com.baidu.live.view.YuyinALALevelView;
/* loaded from: classes10.dex */
public class CharmRankItemView extends LinearLayout {
    public TextView aBZ;
    public TextView gML;
    public ImageView gMM;
    public HeadImageView gMN;
    public TextView gMQ;
    public YuyinALALevelView ofB;
    public TbImageView ogp;
    public TbImageView ogq;
    private TBLottieAnimationView ogr;
    private j.b ogs;
    private a ogt;

    /* loaded from: classes10.dex */
    public interface a {
        void dXW();
    }

    public CharmRankItemView(Context context) {
        this(context, null);
        init();
    }

    public CharmRankItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, j.b bVar) {
        int i2;
        this.ogs = bVar;
        if (i == 1) {
            this.gML.setVisibility(8);
            this.gMM.setVisibility(0);
            this.gMM.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gML.setVisibility(8);
            this.gMM.setVisibility(0);
            this.gMM.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gML.setVisibility(8);
            this.gMM.setVisibility(0);
            this.gMM.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gML.setVisibility(0);
            this.gMM.setVisibility(8);
            this.gML.setText(i + "");
        }
        this.aBZ.setText(this.ogs.user_nickname);
        m.a(this.gMN, bVar.bd_portrait, true, false);
        this.gMQ.setText(bVar.aES);
        try {
            i2 = Integer.valueOf(bVar.aET).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.ogq.setVisibility(0);
            this.ogp.setVisibility(8);
            this.ogq.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.ogq.setVisibility(0);
            this.ogp.setVisibility(8);
            this.ogq.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.ogq.setVisibility(0);
            this.ogp.setVisibility(8);
            this.ogq.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.ogq.setVisibility(0);
            this.ogp.setVisibility(8);
            this.ogq.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else if (i == 1) {
            this.ogp.setVisibility(0);
            this.ogq.setVisibility(8);
            this.ogp.setImageResource(a.e.yuyin_pic_live_list_top1);
        } else if (i == 2) {
            this.ogp.setVisibility(0);
            this.ogq.setVisibility(8);
            this.ogp.setImageResource(a.e.yuyin_pic_live_list_top2);
        } else if (i == 3) {
            this.ogp.setVisibility(0);
            this.ogq.setVisibility(8);
            this.ogp.setImageResource(a.e.yuyin_pic_live_list_top3);
        } else {
            this.ogp.setVisibility(8);
            this.ogq.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.ogr.setVisibility(4);
        } else {
            aE(bVar.AE(), false);
        }
    }

    public j.b getData() {
        return this.ogs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clL() {
        if (this.ogt != null) {
            this.ogt.dXW();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        EO();
        initView();
    }

    private void EO() {
        this.gML = (TextView) findViewById(a.f.tv_rank);
        this.gMM = (ImageView) findViewById(a.f.iv_rank);
        this.gMN = (HeadImageView) findViewById(a.f.iv_avatar);
        this.ogp = (TbImageView) findViewById(a.f.iv_pendant);
        this.ogq = (TbImageView) findViewById(a.f.iv_noble);
        this.ofB = (YuyinALALevelView) findViewById(a.f.level);
        this.aBZ = (TextView) findViewById(a.f.tv_name);
        this.gMQ = (TextView) findViewById(a.f.tv_value);
        this.ogr = (TBLottieAnimationView) findViewById(a.f.anim_follow);
    }

    private void initView() {
        this.gMN.setAutoChangeStyle(false);
        this.gMN.setDrawBorder(false);
        this.gMN.setIsRound(true);
        this.ogp.setDefaultBgResource(a.c.sdk_transparent);
        this.ogp.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.ogr.enableMergePathsForKitKatAndAbove(true);
        this.ogr.setAnimation("charm_rank_item_follow.json");
        this.ogr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.clL();
            }
        });
    }

    public void aE(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.ogr.playAnimation();
                return;
            } else {
                this.ogr.setVisibility(4);
                return;
            }
        }
        this.ogr.setVisibility(0);
        this.ogr.setProgress(0.0f);
    }

    public void setmCallBack(a aVar) {
        this.ogt = aVar;
    }
}
