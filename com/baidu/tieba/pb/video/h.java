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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    private TbPageContext<?> aas;
    private bs baU;
    private View dvQ;
    private TextView eAa;
    private RelativeLayout eAb;
    private TextView eAc;
    private TextView eAd;
    private ImageView eAe;
    private ImageView eAf;
    private PbVideoFullUserInfoLikeButton eAg;
    public int eAi;
    private g eAj;
    private View.OnClickListener eAk;
    private View.OnClickListener eAl;
    private LinearLayout eAm;
    private View eAn;
    private bl eAo;
    private HeadImageView ezZ;
    private boolean eAh = false;
    private View.OnClickListener aPl = new i(this);
    private CustomMessageListener alT = new j(this, CmdConfigCustom.CMD_PB_AGREE_CHANGED);

    public h(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aas = tbPageContext;
        this.dvQ = s(tbPageContext);
        initView();
        o(this.aas.getUniqueId());
        frameLayout.addView(this.dvQ);
    }

    private View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eAb = (RelativeLayout) this.dvQ.findViewById(w.h.pbVideoFullUserInfoPanel);
        this.ezZ = (HeadImageView) this.dvQ.findViewById(w.h.pbVideoFullPhoto);
        this.ezZ.setOnClickListener(this.aPl);
        this.eAm = (LinearLayout) this.dvQ.findViewById(w.h.pbVideoFullNameLayout);
        this.eAn = com.baidu.tbadk.ala.b.nz().h(this.aas.getPageActivity(), 6);
        if (this.eAn != null) {
            this.eAn.setVisibility(8);
            if (this.eAn instanceof TextView) {
                ((TextView) this.eAn).setTextColor(this.aas.getPageActivity().getResources().getColor(w.e.cp_cont_i));
            }
            this.eAm.addView(this.eAn);
        }
        this.eAa = (TextView) this.dvQ.findViewById(w.h.pbVideoFullUserName);
        this.eAa.setOnClickListener(this.aPl);
        this.eAc = (TextView) this.dvQ.findViewById(w.h.pbVideoFullAttention);
        this.eAc.setOnClickListener(this.aPl);
        this.eAd = (TextView) this.dvQ.findViewById(w.h.pbVideoFullZanCount);
        this.eAe = (ImageView) this.dvQ.findViewById(w.h.pbVideoFullZanLabel);
        this.eAe.setOnClickListener(this.aPl);
        this.eAf = (ImageView) this.dvQ.findViewById(w.h.pbVideoFullChannelIcon);
        this.eAg = (PbVideoFullUserInfoLikeButton) this.dvQ.findViewById(w.h.pbVideoFullLikeButton);
        this.eAj = new g(this.aas, this.eAg);
        this.ezZ.setRadius(com.baidu.adp.lib.util.k.g(this.aas.getPageActivity(), w.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(View view) {
        if (this.eAl != null) {
            this.eAl.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(View view) {
        if (this.eAh) {
            if (this.baU != null) {
                this.aas.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aas.getPageActivity(), this.baU.channelId, 2)));
            }
        } else if (this.eAk != null) {
            this.eAk.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOM() {
        if (this.eAh) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                this.aas.showToast(w.l.no_network_guide);
            } else if (this.baU != null && this.baU.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bh.aM(this.aas.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0036a.a(this.baU.channelId, this.aas.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        this.eAo = blVar;
        a(mVar.aJe(), mVar.getPraiseNum());
        if (blVar.sx() != null) {
            this.eAh = true;
            this.eAg.setVisibility(8);
            this.eAc.setVisibility(0);
            R(blVar);
        } else {
            this.eAh = false;
            this.eAg.setVisibility(0);
            this.eAc.setVisibility(8);
            m(postData);
        }
        if (J(blVar)) {
            this.eAc.setVisibility(8);
            this.eAg.setVisibility(8);
        }
    }

    private boolean J(bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    private void m(PostData postData) {
        this.eAf.setVisibility(8);
        this.ezZ.setUserId(postData.getAuthor().getUserId());
        this.ezZ.setUserName(postData.getAuthor().getUserName());
        this.ezZ.setIsBigV(postData.getAuthor().isBigV());
        this.eAa.setText(postData.getAuthor().getUserName());
        this.eAa.setTag(postData.getAuthor().getUserId());
        this.ezZ.c(postData.getAuthor().getPortrait(), 28, false);
        this.eAj.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eAn != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0 && postData.getAuthor().getAlaUserData().enter_live == 0) {
                this.eAn.setVisibility(8);
                return;
            }
            this.eAn.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.PW = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eAn.setTag(aVar);
        }
    }

    private void R(bl blVar) {
        this.eAf.setVisibility(0);
        this.baU = blVar.sx();
        if (this.baU.Zs == 1) {
            this.eAi = 0;
        } else {
            this.eAi = this.baU.Zs;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eAi = 2;
        }
        this.eAa.setText(this.baU.channelName);
        this.ezZ.c(this.baU.channelAvatar, 10, false);
        j(this.eAi, this.baU.channelId);
    }

    public void j(int i, long j) {
        if (this.baU != null && j > 0 && j == this.baU.channelId) {
            if (i == 1) {
                this.eAc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aq.i(this.eAc, w.e.cp_bg_line_d_alpha80);
                this.eAc.setClickable(false);
                this.eAc.setText(w.l.has_ordered_channel);
                return;
            }
            this.eAc.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.i(this.eAc, w.e.cp_cont_i);
            this.eAc.setClickable(true);
            this.eAc.setText(w.l.order_video_channel);
        }
    }

    public void ab(float f) {
        this.eAb.setAlpha(f);
    }

    public View aON() {
        return this.eAb;
    }

    public void dn(int i) {
        if (this.eAg != null) {
            this.eAg.onChangeSkinType(i);
        }
        if (this.eAd != null) {
            aq.i(this.eAd, w.e.cp_cont_i);
        }
        if (this.eAi == 1) {
            aq.i(this.eAc, w.e.cp_bg_line_d_alpha80);
        } else {
            aq.i(this.eAc, w.e.cp_cont_i);
        }
        if (this.eAa != null) {
            aq.i(this.eAa, w.e.cp_cont_i);
        }
        if (this.eAf != null) {
            aq.j(this.eAf, w.g.icon_weiba);
        }
    }

    public void K(View.OnClickListener onClickListener) {
        this.eAk = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.eAl = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.alT != null) {
            this.alT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.alT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eAd.setText(au.v(j));
        if (z) {
            this.eAe.setImageResource(w.g.icon_floor_praised);
        } else {
            this.eAe.setImageResource(w.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.alT);
    }
}
