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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
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
    private TbPageContext<?> aby;
    private bo bfS;
    private View dXZ;
    private HeadImageView eYI;
    private TextView eYJ;
    private RelativeLayout eYK;
    private TextView eYL;
    private TextView eYM;
    private ImageView eYN;
    private ImageView eYO;
    private PbVideoFullUserInfoLikeButton eYP;
    public int eYR;
    private f eYS;
    private View.OnClickListener eYT;
    private View.OnClickListener eYU;
    private LinearLayout eYV;
    private View eYW;
    private bj eYX;
    private boolean eYQ = false;
    private View.OnClickListener aSH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eYN) {
                g.this.br(view);
            } else if (view == g.this.eYI || view == g.this.eYJ || view == g.this.eYO) {
                g.this.bs(view);
            } else if (view == g.this.eYL) {
                g.this.aVU();
            }
        }
    };
    private CustomMessageListener aok = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.k) && g.this.eYX != null && g.this.eYX.getId() != null) {
                com.baidu.tieba.pb.data.k kVar = (com.baidu.tieba.pb.data.k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.eYX.rR())) {
                    g.this.a(kVar.eFJ == 0, kVar.eFK.getPraiseNum());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aby = tbPageContext;
        this.dXZ = t(tbPageContext);
        initView();
        q(this.aby.getUniqueId());
        frameLayout.addView(this.dXZ);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eYK = (RelativeLayout) this.dXZ.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eYI = (HeadImageView) this.dXZ.findViewById(d.h.pbVideoFullPhoto);
        this.eYI.setOnClickListener(this.aSH);
        this.eYV = (LinearLayout) this.dXZ.findViewById(d.h.pbVideoFullNameLayout);
        this.eYW = com.baidu.tbadk.ala.b.nw().h(this.aby.getPageActivity(), 6);
        if (this.eYW != null) {
            this.eYW.setVisibility(8);
            this.eYV.addView(this.eYW);
        }
        this.eYJ = (TextView) this.dXZ.findViewById(d.h.pbVideoFullUserName);
        this.eYJ.setOnClickListener(this.aSH);
        this.eYL = (TextView) this.dXZ.findViewById(d.h.pbVideoFullAttention);
        this.eYL.setOnClickListener(this.aSH);
        this.eYM = (TextView) this.dXZ.findViewById(d.h.pbVideoFullZanCount);
        this.eYN = (ImageView) this.dXZ.findViewById(d.h.pbVideoFullZanLabel);
        this.eYN.setOnClickListener(this.aSH);
        this.eYO = (ImageView) this.dXZ.findViewById(d.h.pbVideoFullChannelIcon);
        this.eYP = (PbVideoFullUserInfoLikeButton) this.dXZ.findViewById(d.h.pbVideoFullLikeButton);
        this.eYS = new f(this.aby, this.eYP);
        this.eYI.setRadius(com.baidu.adp.lib.util.k.f(this.aby.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(View view) {
        if (this.eYU != null) {
            this.eYU.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        if (this.eYQ) {
            if (this.bfS != null) {
                this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aby.getPageActivity(), this.bfS.channelId, 2)));
            }
        } else if (this.eYT != null) {
            this.eYT.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVU() {
        if (this.eYQ) {
            if (!com.baidu.adp.lib.util.k.hz()) {
                this.aby.showToast(d.l.no_network_guide);
            } else if (this.bfS != null && this.bfS.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aT(this.aby.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0044a.a(this.bfS.channelId, this.aby.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bj bjVar, com.baidu.tieba.pb.data.l lVar) {
        this.eYX = bjVar;
        a(lVar.aPL(), lVar.getPraiseNum());
        if (bjVar.sF() != null) {
            this.eYQ = true;
            this.eYP.setVisibility(8);
            this.eYL.setVisibility(0);
            ae(bjVar);
        } else {
            this.eYQ = false;
            this.eYP.setVisibility(0);
            this.eYL.setVisibility(8);
            o(postData);
        }
        if (S(bjVar)) {
            this.eYL.setVisibility(8);
            this.eYP.setVisibility(8);
        }
    }

    private boolean S(bj bjVar) {
        if (bjVar == null || bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.getAuthor().getUserId());
    }

    private void o(PostData postData) {
        this.eYO.setVisibility(8);
        this.eYI.setUserId(postData.getAuthor().getUserId());
        this.eYI.setUserName(postData.getAuthor().getUserName());
        this.eYI.setIsBigV(postData.getAuthor().isBigV());
        this.eYJ.setText(postData.getAuthor().getUserName());
        this.eYJ.setTag(postData.getAuthor().getUserId());
        this.eYI.c(postData.getAuthor().getPortrait(), 28, false);
        this.eYS.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eYW != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eYW.setVisibility(8);
                return;
            }
            this.eYW.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.Qs = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eYW.setTag(aVar);
        }
    }

    private void ae(bj bjVar) {
        this.eYO.setVisibility(0);
        this.bfS = bjVar.sF();
        if (this.bfS.aas == 1) {
            this.eYR = 0;
        } else {
            this.eYR = this.bfS.aas;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eYR = 2;
        }
        this.eYJ.setText(this.bfS.channelName);
        this.eYI.c(this.bfS.channelAvatar, 10, false);
        k(this.eYR, this.bfS.channelId);
    }

    public void k(int i, long j) {
        if (this.bfS != null && j > 0 && j == this.bfS.channelId) {
            if (i == 1) {
                this.eYL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eYL, d.e.cp_bg_line_d_alpha80);
                this.eYL.setClickable(false);
                this.eYL.setText(d.l.has_ordered_channel);
                return;
            }
            this.eYL.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eYL, d.e.cp_cont_i);
            this.eYL.setClickable(true);
            this.eYL.setText(d.l.order_video_channel);
        }
    }

    public void W(float f) {
        this.eYK.setAlpha(f);
    }

    public View aVV() {
        return this.eYK;
    }

    public void du(int i) {
        if (this.eYP != null) {
            this.eYP.onChangeSkinType(i);
        }
        if (this.eYM != null) {
            aj.i(this.eYM, d.e.cp_cont_i);
        }
        if (this.eYR == 1) {
            aj.i(this.eYL, d.e.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.eYL, d.e.cp_cont_i);
        }
        if (this.eYJ != null) {
            aj.i(this.eYJ, d.e.cp_cont_i);
        }
        if (this.eYO != null) {
            aj.j(this.eYO, d.g.icon_weiba);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.eYT = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.eYU = onClickListener;
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aok != null) {
            this.aok.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aok);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eYM.setText(am.w(j));
        if (z) {
            this.eYN.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eYN.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aok);
    }
}
