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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class g {
    private TbPageContext<?> abm;
    private bm bhr;
    private View dTT;
    private HeadImageView eSD;
    private TextView eSE;
    private RelativeLayout eSF;
    private TextView eSG;
    private TextView eSH;
    private ImageView eSI;
    private ImageView eSJ;
    private PbVideoFullUserInfoLikeButton eSK;
    public int eSM;
    private f eSN;
    private View.OnClickListener eSO;
    private View.OnClickListener eSP;
    private LinearLayout eSQ;
    private View eSR;
    private bh eSS;
    private boolean eSL = false;
    private View.OnClickListener aTt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eSI) {
                g.this.bp(view);
            } else if (view == g.this.eSD || view == g.this.eSE || view == g.this.eSJ) {
                g.this.bq(view);
            } else if (view == g.this.eSG) {
                g.this.aTY();
            }
        }
    };
    private CustomMessageListener ann = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.k) && g.this.eSS != null && g.this.eSS.getId() != null) {
                com.baidu.tieba.pb.data.k kVar = (com.baidu.tieba.pb.data.k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.eSS.rE())) {
                    g.this.a(kVar.eyR == 0, kVar.eyS.getPraiseNum());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.abm = tbPageContext;
        this.dTT = q(tbPageContext);
        initView();
        p(this.abm.getUniqueId());
        frameLayout.addView(this.dTT);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eSF = (RelativeLayout) this.dTT.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eSD = (HeadImageView) this.dTT.findViewById(d.h.pbVideoFullPhoto);
        this.eSD.setOnClickListener(this.aTt);
        this.eSQ = (LinearLayout) this.dTT.findViewById(d.h.pbVideoFullNameLayout);
        this.eSR = com.baidu.tbadk.ala.b.nr().g(this.abm.getPageActivity(), 6);
        if (this.eSR != null) {
            this.eSR.setVisibility(8);
            this.eSQ.addView(this.eSR);
        }
        this.eSE = (TextView) this.dTT.findViewById(d.h.pbVideoFullUserName);
        this.eSE.setOnClickListener(this.aTt);
        this.eSG = (TextView) this.dTT.findViewById(d.h.pbVideoFullAttention);
        this.eSG.setOnClickListener(this.aTt);
        this.eSH = (TextView) this.dTT.findViewById(d.h.pbVideoFullZanCount);
        this.eSI = (ImageView) this.dTT.findViewById(d.h.pbVideoFullZanLabel);
        this.eSI.setOnClickListener(this.aTt);
        this.eSJ = (ImageView) this.dTT.findViewById(d.h.pbVideoFullChannelIcon);
        this.eSK = (PbVideoFullUserInfoLikeButton) this.dTT.findViewById(d.h.pbVideoFullLikeButton);
        this.eSN = new f(this.abm, this.eSK);
        this.eSD.setRadius(com.baidu.adp.lib.util.l.f(this.abm.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
        if (this.eSP != null) {
            this.eSP.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(View view) {
        if (this.eSL) {
            if (this.bhr != null) {
                this.abm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.abm.getPageActivity(), this.bhr.channelId, 2)));
            }
        } else if (this.eSO != null) {
            this.eSO.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTY() {
        if (this.eSL) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                this.abm.showToast(d.l.no_network_guide);
            } else if (this.bhr != null && this.bhr.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aS(this.abm.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(this.bhr.channelId, this.abm.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, com.baidu.tieba.pb.data.l lVar) {
        this.eSS = bhVar;
        a(lVar.aNA(), lVar.getPraiseNum());
        if (bhVar.ss() != null) {
            this.eSL = true;
            this.eSK.setVisibility(8);
            this.eSG.setVisibility(0);
            Z(bhVar);
        } else {
            this.eSL = false;
            this.eSK.setVisibility(0);
            this.eSG.setVisibility(8);
            p(postData);
        }
        if (N(bhVar)) {
            this.eSG.setVisibility(8);
            this.eSK.setVisibility(8);
        }
    }

    private boolean N(bh bhVar) {
        if (bhVar == null || bhVar.getAuthor() == null || bhVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.getAuthor().getUserId());
    }

    private void p(PostData postData) {
        this.eSJ.setVisibility(8);
        this.eSD.setUserId(postData.getAuthor().getUserId());
        this.eSD.setUserName(postData.getAuthor().getUserName());
        this.eSD.setIsBigV(postData.getAuthor().isBigV());
        this.eSE.setText(postData.getAuthor().getUserName());
        this.eSE.setTag(postData.getAuthor().getUserId());
        this.eSD.c(postData.getAuthor().getPortrait(), 28, false);
        this.eSN.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eSR != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eSR.setVisibility(8);
                return;
            }
            this.eSR.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.Qv = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eSR.setTag(aVar);
        }
    }

    private void Z(bh bhVar) {
        this.eSJ.setVisibility(0);
        this.bhr = bhVar.ss();
        if (this.bhr.aag == 1) {
            this.eSM = 0;
        } else {
            this.eSM = this.bhr.aag;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eSM = 2;
        }
        this.eSE.setText(this.bhr.channelName);
        this.eSD.c(this.bhr.channelAvatar, 10, false);
        k(this.eSM, this.bhr.channelId);
    }

    public void k(int i, long j) {
        if (this.bhr != null && j > 0 && j == this.bhr.channelId) {
            if (i == 1) {
                this.eSG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eSG, d.e.cp_bg_line_d_alpha80);
                this.eSG.setClickable(false);
                this.eSG.setText(d.l.has_ordered_channel);
                return;
            }
            this.eSG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSG, d.e.cp_cont_i);
            this.eSG.setClickable(true);
            this.eSG.setText(d.l.order_video_channel);
        }
    }

    public void Y(float f) {
        this.eSF.setAlpha(f);
    }

    public View aTZ() {
        return this.eSF;
    }

    public void dD(int i) {
        if (this.eSK != null) {
            this.eSK.onChangeSkinType(i);
        }
        if (this.eSH != null) {
            aj.i(this.eSH, d.e.cp_cont_i);
        }
        if (this.eSM == 1) {
            aj.i(this.eSG, d.e.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.eSG, d.e.cp_cont_i);
        }
        if (this.eSE != null) {
            aj.i(this.eSE, d.e.cp_cont_i);
        }
        if (this.eSJ != null) {
            aj.j(this.eSJ, d.g.icon_weiba);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        this.eSO = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eSP = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ann != null) {
            this.ann.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ann);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eSH.setText(am.w(j));
        if (z) {
            this.eSI.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eSI.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ann);
    }
}
