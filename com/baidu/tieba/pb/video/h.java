package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    private TbPageContext<?> aat;
    private bt bcX;
    private View dED;
    private TextView eJA;
    private TextView eJB;
    private ImageView eJC;
    private ImageView eJD;
    private PbVideoFullUserInfoLikeButton eJE;
    public int eJG;
    private g eJH;
    private View.OnClickListener eJI;
    private View.OnClickListener eJJ;
    private LinearLayout eJK;
    private View eJL;
    private bm eJM;
    private HeadImageView eJx;
    private TextView eJy;
    private RelativeLayout eJz;
    private boolean eJF = false;
    private View.OnClickListener aQD = new i(this);
    private CustomMessageListener amL = new j(this, CmdConfigCustom.CMD_PB_AGREE_CHANGED);

    public h(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aat = tbPageContext;
        this.dED = s(tbPageContext);
        initView();
        o(this.aat.getUniqueId());
        frameLayout.addView(this.dED);
    }

    private View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eJz = (RelativeLayout) this.dED.findViewById(w.h.pbVideoFullUserInfoPanel);
        this.eJx = (HeadImageView) this.dED.findViewById(w.h.pbVideoFullPhoto);
        this.eJx.setOnClickListener(this.aQD);
        this.eJK = (LinearLayout) this.dED.findViewById(w.h.pbVideoFullNameLayout);
        this.eJL = com.baidu.tbadk.ala.b.nv().h(this.aat.getPageActivity(), 6);
        if (this.eJL != null) {
            this.eJL.setVisibility(8);
            if (this.eJL instanceof TextView) {
                ((TextView) this.eJL).setTextColor(this.aat.getPageActivity().getResources().getColor(w.e.cp_cont_i));
            }
            this.eJK.addView(this.eJL);
        }
        this.eJy = (TextView) this.dED.findViewById(w.h.pbVideoFullUserName);
        this.eJy.setOnClickListener(this.aQD);
        this.eJA = (TextView) this.dED.findViewById(w.h.pbVideoFullAttention);
        this.eJA.setOnClickListener(this.aQD);
        this.eJB = (TextView) this.dED.findViewById(w.h.pbVideoFullZanCount);
        this.eJC = (ImageView) this.dED.findViewById(w.h.pbVideoFullZanLabel);
        this.eJC.setOnClickListener(this.aQD);
        this.eJD = (ImageView) this.dED.findViewById(w.h.pbVideoFullChannelIcon);
        this.eJE = (PbVideoFullUserInfoLikeButton) this.dED.findViewById(w.h.pbVideoFullLikeButton);
        this.eJH = new g(this.aat, this.eJE);
        this.eJx.setRadius(com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(View view) {
        if (this.eJJ != null) {
            this.eJJ.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(View view) {
        if (this.eJF) {
            if (this.bcX != null) {
                this.aat.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aat.getPageActivity(), this.bcX.channelId, 2)));
            }
        } else if (this.eJI != null) {
            this.eJI.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSL() {
        if (this.eJF) {
            if (!com.baidu.adp.lib.util.k.hA()) {
                this.aat.showToast(w.l.no_network_guide);
            } else if (this.bcX != null && this.bcX.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bl.aM(this.aat.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0038a.a(this.bcX.channelId, this.aat.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bm bmVar, com.baidu.tieba.pb.data.m mVar) {
        this.eJM = bmVar;
        a(mVar.aMY(), mVar.getPraiseNum());
        if (bmVar.sv() != null) {
            this.eJF = true;
            this.eJE.setVisibility(8);
            this.eJA.setVisibility(0);
            S(bmVar);
        } else {
            this.eJF = false;
            this.eJE.setVisibility(0);
            this.eJA.setVisibility(8);
            o(postData);
        }
        if (K(bmVar)) {
            this.eJA.setVisibility(8);
            this.eJE.setVisibility(8);
        }
    }

    private boolean K(bm bmVar) {
        if (bmVar == null || bmVar.getAuthor() == null || bmVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bmVar.getAuthor().getUserId());
    }

    private void o(PostData postData) {
        this.eJD.setVisibility(8);
        this.eJx.setUserId(postData.getAuthor().getUserId());
        this.eJx.setUserName(postData.getAuthor().getUserName());
        this.eJx.setIsBigV(postData.getAuthor().isBigV());
        this.eJy.setText(postData.getAuthor().getUserName());
        this.eJy.setTag(postData.getAuthor().getUserId());
        this.eJx.c(postData.getAuthor().getPortrait(), 28, false);
        this.eJH.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eJL != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eJL.setVisibility(8);
                return;
            }
            this.eJL.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.PQ = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eJL.setTag(aVar);
        }
    }

    private void S(bm bmVar) {
        this.eJD.setVisibility(0);
        this.bcX = bmVar.sv();
        if (this.bcX.Zu == 1) {
            this.eJG = 0;
        } else {
            this.eJG = this.bcX.Zu;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eJG = 2;
        }
        this.eJy.setText(this.bcX.channelName);
        this.eJx.c(this.bcX.channelAvatar, 10, false);
        j(this.eJG, this.bcX.channelId);
    }

    public void j(int i, long j) {
        if (this.bcX != null && j > 0 && j == this.bcX.channelId) {
            if (i == 1) {
                this.eJA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                as.i(this.eJA, w.e.cp_bg_line_d_alpha80);
                this.eJA.setClickable(false);
                this.eJA.setText(w.l.has_ordered_channel);
                return;
            }
            this.eJA.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            as.i(this.eJA, w.e.cp_cont_i);
            this.eJA.setClickable(true);
            this.eJA.setText(w.l.order_video_channel);
        }
    }

    public void ah(float f) {
        this.eJz.setAlpha(f);
    }

    public View aSM() {
        return this.eJz;
    }

    public void dp(int i) {
        if (this.eJE != null) {
            this.eJE.onChangeSkinType(i);
        }
        if (this.eJB != null) {
            as.i(this.eJB, w.e.cp_cont_i);
        }
        if (this.eJG == 1) {
            as.i(this.eJA, w.e.cp_bg_line_d_alpha80);
        } else {
            as.i(this.eJA, w.e.cp_cont_i);
        }
        if (this.eJy != null) {
            as.i(this.eJy, w.e.cp_cont_i);
        }
        if (this.eJD != null) {
            as.j(this.eJD, w.g.icon_weiba);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        this.eJI = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.eJJ = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.amL != null) {
            this.amL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eJB.setText(aw.w(j));
        if (z) {
            this.eJC.setImageResource(w.g.icon_floor_praised);
        } else {
            this.eJC.setImageResource(w.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.amL);
    }
}
