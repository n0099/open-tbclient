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
    public TextView gFG;
    public ImageView gFH;
    public HeadImageView gFI;
    public TextView gFL;
    public YuyinALALevelView oiw;
    public TbImageView ojj;
    private TextView ojk;
    private i.b ojl;
    private a ojm;

    /* loaded from: classes4.dex */
    public interface a {
        void ecR();
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
        this.ojl = bVar;
        if (i == 1) {
            this.gFG.setVisibility(8);
            this.gFH.setVisibility(0);
            this.gFH.setImageResource(a.e.yuyin_icon_live_list_first);
        } else if (i == 2) {
            this.gFG.setVisibility(8);
            this.gFH.setVisibility(0);
            this.gFH.setImageResource(a.e.yuyin_icon_live_list_second);
        } else if (i == 3) {
            this.gFG.setVisibility(8);
            this.gFH.setVisibility(0);
            this.gFH.setImageResource(a.e.yuyin_icon_live_list_thrid);
        } else {
            this.gFG.setVisibility(0);
            this.gFH.setVisibility(8);
            this.gFG.setText(i + "");
        }
        this.aGv.setText(this.ojl.user_nickname);
        l.a(this.gFI, bVar.bd_portrait, true, false);
        this.gFL.setText(bVar.aJh);
        try {
            i2 = Integer.valueOf(bVar.aJi).intValue();
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 == 7) {
            this.ojj.setVisibility(0);
            this.ojj.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
        } else if (i2 == 6) {
            this.ojj.setVisibility(0);
            this.ojj.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
        } else if (i2 == 5) {
            this.ojj.setVisibility(0);
            this.ojj.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
        } else if (i2 == 4) {
            this.ojj.setVisibility(0);
            this.ojj.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
        } else {
            this.ojj.setVisibility(8);
        }
        if (ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())).equals(bVar.user_uk)) {
            this.ojk.setVisibility(8);
            return;
        }
        this.ojk.setVisibility(0);
        cg(bVar.Fj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmK() {
        if (this.ojm != null) {
            this.ojm.ecR();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_sdk_charm_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Jh();
        initView();
    }

    private void Jh() {
        this.gFG = (TextView) findViewById(a.f.tv_rank);
        this.gFH = (ImageView) findViewById(a.f.iv_rank);
        this.gFI = (HeadImageView) findViewById(a.f.iv_avatar);
        this.ojj = (TbImageView) findViewById(a.f.iv_pendant);
        this.oiw = (YuyinALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFL = (TextView) findViewById(a.f.tv_value);
        this.ojk = (TextView) findViewById(a.f.tv_attention);
    }

    private void initView() {
        this.gFI.setAutoChangeStyle(false);
        this.gFI.setDrawBorder(false);
        this.gFI.setIsRound(true);
        this.ojj.setDefaultBgResource(a.c.sdk_transparent);
        this.ojj.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.ojk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CharmRankItemView.this.cmK();
            }
        });
    }

    private void cg(boolean z) {
        this.ojk.setVisibility(0);
        if (z) {
            this.ojk.setBackgroundResource(a.c.sdk_white_alpha100);
            this.ojk.setText("已关注");
            this.ojk.setTextColor(getResources().getColor(a.c.sdk_color_858585));
            return;
        }
        this.ojk.setBackgroundResource(a.e.yuyin_round_charm_item_attention_bg);
        this.ojk.setText("关注");
        this.ojk.setTextColor(getResources().getColor(a.c.sdk_color_ff1e66));
    }

    public void setmCallBack(a aVar) {
        this.ojm = aVar;
    }
}
