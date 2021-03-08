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
    public TextView aFm;
    public TextView gRo;
    public ImageView gRp;
    public HeadImageView gRq;
    public TextView gRt;
    public TbImageView osO;
    public TbImageView osP;
    private TBLottieAnimationView osQ;
    private j.b osR;
    private a osS;
    public YuyinALALevelView osa;

    /* loaded from: classes10.dex */
    public interface a {
        void eax();
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
        this.osR = bVar;
        if (i == 1) {
            this.gRo.setVisibility(8);
            this.gRp.setVisibility(0);
            this.gRp.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gRo.setVisibility(8);
            this.gRp.setVisibility(0);
            this.gRp.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gRo.setVisibility(8);
            this.gRp.setVisibility(0);
            this.gRp.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gRo.setVisibility(0);
            this.gRp.setVisibility(8);
            this.gRo.setText(i + "");
        }
        this.aFm.setText(this.osR.user_nickname);
        m.a(this.gRq, bVar.bd_portrait, true, false);
        this.gRt.setText(bVar.aIf);
        try {
            i2 = Integer.valueOf(bVar.aIg).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.osP.setVisibility(0);
            this.osO.setVisibility(8);
            this.osP.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.osP.setVisibility(0);
            this.osO.setVisibility(8);
            this.osP.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.osP.setVisibility(0);
            this.osO.setVisibility(8);
            this.osP.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.osP.setVisibility(0);
            this.osO.setVisibility(8);
            this.osP.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else if (i == 1) {
            this.osO.setVisibility(0);
            this.osP.setVisibility(8);
            this.osO.setImageResource(a.e.yuyin_pic_live_list_top1);
        } else if (i == 2) {
            this.osO.setVisibility(0);
            this.osP.setVisibility(8);
            this.osO.setImageResource(a.e.yuyin_pic_live_list_top2);
        } else if (i == 3) {
            this.osO.setVisibility(0);
            this.osP.setVisibility(8);
            this.osO.setImageResource(a.e.yuyin_pic_live_list_top3);
        } else {
            this.osO.setVisibility(8);
            this.osP.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.osQ.setVisibility(4);
        } else {
            aE(bVar.Br(), false);
        }
    }

    public j.b getData() {
        return this.osR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmW() {
        if (this.osS != null) {
            this.osS.eax();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Gh();
        initView();
    }

    private void Gh() {
        this.gRo = (TextView) findViewById(a.f.tv_rank);
        this.gRp = (ImageView) findViewById(a.f.iv_rank);
        this.gRq = (HeadImageView) findViewById(a.f.iv_avatar);
        this.osO = (TbImageView) findViewById(a.f.iv_pendant);
        this.osP = (TbImageView) findViewById(a.f.iv_noble);
        this.osa = (YuyinALALevelView) findViewById(a.f.level);
        this.aFm = (TextView) findViewById(a.f.tv_name);
        this.gRt = (TextView) findViewById(a.f.tv_value);
        this.osQ = (TBLottieAnimationView) findViewById(a.f.anim_follow);
    }

    private void initView() {
        this.gRq.setAutoChangeStyle(false);
        this.gRq.setDrawBorder(false);
        this.gRq.setIsRound(true);
        this.osO.setDefaultBgResource(a.c.sdk_transparent);
        this.osO.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.osQ.enableMergePathsForKitKatAndAbove(true);
        this.osQ.setAnimation("charm_rank_item_follow.json");
        this.osQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cmW();
            }
        });
    }

    public void aE(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.osQ.playAnimation();
                return;
            } else {
                this.osQ.setVisibility(4);
                return;
            }
        }
        this.osQ.setVisibility(0);
        this.osQ.setProgress(0.0f);
    }

    public void setmCallBack(a aVar) {
        this.osS = aVar;
    }
}
