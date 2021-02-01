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
    public TextView gPr;
    public ImageView gPs;
    public HeadImageView gPt;
    public TextView gPw;
    public YuyinALALevelView opu;
    public TbImageView oqi;
    public TbImageView oqj;
    private TBLottieAnimationView oqk;
    private j.b oql;
    private a oqm;

    /* loaded from: classes11.dex */
    public interface a {
        void eah();
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
        this.oql = bVar;
        if (i == 1) {
            this.gPr.setVisibility(8);
            this.gPs.setVisibility(0);
            this.gPs.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gPr.setVisibility(8);
            this.gPs.setVisibility(0);
            this.gPs.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gPr.setVisibility(8);
            this.gPs.setVisibility(0);
            this.gPs.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gPr.setVisibility(0);
            this.gPs.setVisibility(8);
            this.gPr.setText(i + "");
        }
        this.aDM.setText(this.oql.user_nickname);
        m.a(this.gPt, bVar.bd_portrait, true, false);
        this.gPw.setText(bVar.aGF);
        try {
            i2 = Integer.valueOf(bVar.aGG).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.oqj.setVisibility(0);
            this.oqi.setVisibility(8);
            this.oqj.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.oqj.setVisibility(0);
            this.oqi.setVisibility(8);
            this.oqj.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.oqj.setVisibility(0);
            this.oqi.setVisibility(8);
            this.oqj.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.oqj.setVisibility(0);
            this.oqi.setVisibility(8);
            this.oqj.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else if (i == 1) {
            this.oqi.setVisibility(0);
            this.oqj.setVisibility(8);
            this.oqi.setImageResource(a.e.yuyin_pic_live_list_top1);
        } else if (i == 2) {
            this.oqi.setVisibility(0);
            this.oqj.setVisibility(8);
            this.oqi.setImageResource(a.e.yuyin_pic_live_list_top2);
        } else if (i == 3) {
            this.oqi.setVisibility(0);
            this.oqj.setVisibility(8);
            this.oqi.setImageResource(a.e.yuyin_pic_live_list_top3);
        } else {
            this.oqi.setVisibility(8);
            this.oqj.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.oqk.setVisibility(4);
        } else {
            aE(bVar.Bo(), false);
        }
    }

    public j.b getData() {
        return this.oql;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmJ() {
        if (this.oqm != null) {
            this.oqm.eah();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Ge();
        initView();
    }

    private void Ge() {
        this.gPr = (TextView) findViewById(a.f.tv_rank);
        this.gPs = (ImageView) findViewById(a.f.iv_rank);
        this.gPt = (HeadImageView) findViewById(a.f.iv_avatar);
        this.oqi = (TbImageView) findViewById(a.f.iv_pendant);
        this.oqj = (TbImageView) findViewById(a.f.iv_noble);
        this.opu = (YuyinALALevelView) findViewById(a.f.level);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.gPw = (TextView) findViewById(a.f.tv_value);
        this.oqk = (TBLottieAnimationView) findViewById(a.f.anim_follow);
    }

    private void initView() {
        this.gPt.setAutoChangeStyle(false);
        this.gPt.setDrawBorder(false);
        this.gPt.setIsRound(true);
        this.oqi.setDefaultBgResource(a.c.sdk_transparent);
        this.oqi.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.oqk.enableMergePathsForKitKatAndAbove(true);
        this.oqk.setAnimation("charm_rank_item_follow.json");
        this.oqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cmJ();
            }
        });
    }

    public void aE(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.oqk.playAnimation();
                return;
            } else {
                this.oqk.setVisibility(4);
                return;
            }
        }
        this.oqk.setVisibility(0);
        this.oqk.setProgress(0.0f);
    }

    public void setmCallBack(a aVar) {
        this.oqm = aVar;
    }
}
