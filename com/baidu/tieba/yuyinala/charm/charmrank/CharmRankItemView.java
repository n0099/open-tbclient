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
/* loaded from: classes11.dex */
public class CharmRankItemView extends LinearLayout {
    public TextView aDM;
    public TextView gPF;
    public ImageView gPG;
    public HeadImageView gPH;
    public TextView gPK;
    public YuyinALALevelView opU;
    public TbImageView oqI;
    public TbImageView oqJ;
    private TBLottieAnimationView oqK;
    private j.b oqL;
    private a oqM;

    /* loaded from: classes11.dex */
    public interface a {
        void eap();
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
        this.oqL = bVar;
        if (i == 1) {
            this.gPF.setVisibility(8);
            this.gPG.setVisibility(0);
            this.gPG.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gPF.setVisibility(8);
            this.gPG.setVisibility(0);
            this.gPG.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gPF.setVisibility(8);
            this.gPG.setVisibility(0);
            this.gPG.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gPF.setVisibility(0);
            this.gPG.setVisibility(8);
            this.gPF.setText(i + "");
        }
        this.aDM.setText(this.oqL.user_nickname);
        m.a(this.gPH, bVar.bd_portrait, true, false);
        this.gPK.setText(bVar.aGF);
        try {
            i2 = Integer.valueOf(bVar.aGG).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.oqJ.setVisibility(0);
            this.oqI.setVisibility(8);
            this.oqJ.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.oqJ.setVisibility(0);
            this.oqI.setVisibility(8);
            this.oqJ.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.oqJ.setVisibility(0);
            this.oqI.setVisibility(8);
            this.oqJ.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.oqJ.setVisibility(0);
            this.oqI.setVisibility(8);
            this.oqJ.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else if (i == 1) {
            this.oqI.setVisibility(0);
            this.oqJ.setVisibility(8);
            this.oqI.setImageResource(a.e.yuyin_pic_live_list_top1);
        } else if (i == 2) {
            this.oqI.setVisibility(0);
            this.oqJ.setVisibility(8);
            this.oqI.setImageResource(a.e.yuyin_pic_live_list_top2);
        } else if (i == 3) {
            this.oqI.setVisibility(0);
            this.oqJ.setVisibility(8);
            this.oqI.setImageResource(a.e.yuyin_pic_live_list_top3);
        } else {
            this.oqI.setVisibility(8);
            this.oqJ.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.oqK.setVisibility(4);
        } else {
            aE(bVar.Bo(), false);
        }
    }

    public j.b getData() {
        return this.oqL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmQ() {
        if (this.oqM != null) {
            this.oqM.eap();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Ge();
        initView();
    }

    private void Ge() {
        this.gPF = (TextView) findViewById(a.f.tv_rank);
        this.gPG = (ImageView) findViewById(a.f.iv_rank);
        this.gPH = (HeadImageView) findViewById(a.f.iv_avatar);
        this.oqI = (TbImageView) findViewById(a.f.iv_pendant);
        this.oqJ = (TbImageView) findViewById(a.f.iv_noble);
        this.opU = (YuyinALALevelView) findViewById(a.f.level);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.gPK = (TextView) findViewById(a.f.tv_value);
        this.oqK = (TBLottieAnimationView) findViewById(a.f.anim_follow);
    }

    private void initView() {
        this.gPH.setAutoChangeStyle(false);
        this.gPH.setDrawBorder(false);
        this.gPH.setIsRound(true);
        this.oqI.setDefaultBgResource(a.c.sdk_transparent);
        this.oqI.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.oqK.enableMergePathsForKitKatAndAbove(true);
        this.oqK.setAnimation("charm_rank_item_follow.json");
        this.oqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cmQ();
            }
        });
    }

    public void aE(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.oqK.playAnimation();
                return;
            } else {
                this.oqK.setVisibility(4);
                return;
            }
        }
        this.oqK.setVisibility(0);
        this.oqK.setProgress(0.0f);
    }

    public void setmCallBack(a aVar) {
        this.oqM = aVar;
    }
}
