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
    public TextView aGM;
    public TextView gRr;
    public ImageView gRs;
    public HeadImageView gRt;
    public TextView gRw;
    public TbImageView okT;
    public TbImageView okU;
    private TBLottieAnimationView okV;
    private j.b okW;
    private a okX;
    public YuyinALALevelView okf;

    /* loaded from: classes11.dex */
    public interface a {
        void ebO();
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
        this.okW = bVar;
        if (i == 1) {
            this.gRr.setVisibility(8);
            this.gRs.setVisibility(0);
            this.gRs.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gRr.setVisibility(8);
            this.gRs.setVisibility(0);
            this.gRs.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gRr.setVisibility(8);
            this.gRs.setVisibility(0);
            this.gRs.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gRr.setVisibility(0);
            this.gRs.setVisibility(8);
            this.gRr.setText(i + "");
        }
        this.aGM.setText(this.okW.user_nickname);
        m.a(this.gRt, bVar.bd_portrait, true, false);
        this.gRw.setText(bVar.aJF);
        try {
            i2 = Integer.valueOf(bVar.aJG).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.okU.setVisibility(0);
            this.okT.setVisibility(8);
            this.okU.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.okU.setVisibility(0);
            this.okT.setVisibility(8);
            this.okU.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.okU.setVisibility(0);
            this.okT.setVisibility(8);
            this.okU.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.okU.setVisibility(0);
            this.okT.setVisibility(8);
            this.okU.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else if (i == 1) {
            this.okT.setVisibility(0);
            this.okU.setVisibility(8);
            this.okT.setImageResource(a.e.yuyin_pic_live_list_top1);
        } else if (i == 2) {
            this.okT.setVisibility(0);
            this.okU.setVisibility(8);
            this.okT.setImageResource(a.e.yuyin_pic_live_list_top2);
        } else if (i == 3) {
            this.okT.setVisibility(0);
            this.okU.setVisibility(8);
            this.okT.setImageResource(a.e.yuyin_pic_live_list_top3);
        } else {
            this.okT.setVisibility(8);
            this.okU.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.okV.setVisibility(4);
        } else {
            aE(bVar.Ez(), false);
        }
    }

    public j.b getData() {
        return this.okW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpD() {
        if (this.okX != null) {
            this.okX.ebO();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        IJ();
        initView();
    }

    private void IJ() {
        this.gRr = (TextView) findViewById(a.f.tv_rank);
        this.gRs = (ImageView) findViewById(a.f.iv_rank);
        this.gRt = (HeadImageView) findViewById(a.f.iv_avatar);
        this.okT = (TbImageView) findViewById(a.f.iv_pendant);
        this.okU = (TbImageView) findViewById(a.f.iv_noble);
        this.okf = (YuyinALALevelView) findViewById(a.f.level);
        this.aGM = (TextView) findViewById(a.f.tv_name);
        this.gRw = (TextView) findViewById(a.f.tv_value);
        this.okV = (TBLottieAnimationView) findViewById(a.f.anim_follow);
    }

    private void initView() {
        this.gRt.setAutoChangeStyle(false);
        this.gRt.setDrawBorder(false);
        this.gRt.setIsRound(true);
        this.okT.setDefaultBgResource(a.c.sdk_transparent);
        this.okT.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.okV.enableMergePathsForKitKatAndAbove(true);
        this.okV.setAnimation("charm_rank_item_follow.json");
        this.okV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cpD();
            }
        });
    }

    public void aE(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.okV.playAnimation();
                return;
            } else {
                this.okV.setVisibility(4);
                return;
            }
        }
        this.okV.setVisibility(0);
        this.okV.setProgress(0.0f);
    }

    public void setmCallBack(a aVar) {
        this.okX = aVar;
    }
}
