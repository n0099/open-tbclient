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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class g {
    private TbPageContext<?> abI;
    private bm bio;
    private View ebK;
    private HeadImageView fbE;
    private TextView fbF;
    private RelativeLayout fbG;
    private TextView fbH;
    private TextView fbI;
    private ImageView fbJ;
    private ImageView fbK;
    private PbVideoFullUserInfoLikeButton fbL;
    public int fbN;
    private f fbO;
    private View.OnClickListener fbP;
    private View.OnClickListener fbQ;
    private LinearLayout fbR;
    private View fbS;
    private bh fbT;
    private boolean fbM = false;
    private View.OnClickListener aTF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fbJ) {
                g.this.bt(view);
            } else if (view == g.this.fbE || view == g.this.fbF || view == g.this.fbK) {
                g.this.bu(view);
            } else if (view == g.this.fbH) {
                g.this.aXi();
            }
        }
    };
    private CustomMessageListener anH = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fbT != null && g.this.fbT.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fbT.rK())) {
                    g.this.a(kVar.eHn == 0, kVar.eHo.aQA());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.abI = tbPageContext;
        this.ebK = q(tbPageContext);
        initView();
        p(this.abI.getUniqueId());
        frameLayout.addView(this.ebK);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fbG = (RelativeLayout) this.ebK.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fbE = (HeadImageView) this.ebK.findViewById(d.g.pbVideoFullPhoto);
        this.fbE.setOnClickListener(this.aTF);
        this.fbR = (LinearLayout) this.ebK.findViewById(d.g.pbVideoFullNameLayout);
        this.fbS = com.baidu.tbadk.ala.b.nu().g(this.abI.getPageActivity(), 6);
        if (this.fbS != null) {
            this.fbS.setVisibility(8);
            this.fbR.addView(this.fbS);
        }
        this.fbF = (TextView) this.ebK.findViewById(d.g.pbVideoFullUserName);
        this.fbF.setOnClickListener(this.aTF);
        this.fbH = (TextView) this.ebK.findViewById(d.g.pbVideoFullAttention);
        this.fbH.setOnClickListener(this.aTF);
        this.fbI = (TextView) this.ebK.findViewById(d.g.pbVideoFullZanCount);
        this.fbJ = (ImageView) this.ebK.findViewById(d.g.pbVideoFullZanLabel);
        this.fbJ.setOnClickListener(this.aTF);
        this.fbK = (ImageView) this.ebK.findViewById(d.g.pbVideoFullChannelIcon);
        this.fbL = (PbVideoFullUserInfoLikeButton) this.ebK.findViewById(d.g.pbVideoFullLikeButton);
        this.fbO = new f(this.abI, this.fbL);
        this.fbE.setRadius(l.f(this.abI.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(View view) {
        if (this.fbQ != null) {
            this.fbQ.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(View view) {
        if (this.fbM) {
            if (this.bio != null) {
                this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.abI.getPageActivity(), this.bio.channelId, 2)));
            }
        } else if (this.fbP != null) {
            this.fbP.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXi() {
        if (this.fbM) {
            if (!l.hy()) {
                this.abI.showToast(d.j.no_network_guide);
            } else if (this.bio != null && this.bio.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aS(this.abI.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(this.bio.channelId, this.abI.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, com.baidu.tieba.pb.data.l lVar) {
        this.fbT = bhVar;
        a(lVar.aQB(), lVar.aQA());
        if (bhVar.sz() != null) {
            this.fbM = true;
            this.fbL.setVisibility(8);
            this.fbH.setVisibility(0);
            Z(bhVar);
        } else {
            this.fbM = false;
            this.fbL.setVisibility(0);
            this.fbH.setVisibility(8);
            o(postData);
        }
        if (P(bhVar)) {
            this.fbH.setVisibility(8);
            this.fbL.setVisibility(8);
        }
    }

    private boolean P(bh bhVar) {
        if (bhVar == null || bhVar.rt() == null || bhVar.rt().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.rt().getUserId());
    }

    private void o(PostData postData) {
        this.fbK.setVisibility(8);
        this.fbE.setUserId(postData.rt().getUserId());
        this.fbE.setUserName(postData.rt().getUserName());
        this.fbE.setIsBigV(postData.rt().isBigV());
        this.fbF.setText(postData.rt().getUserName());
        this.fbF.setTag(postData.rt().getUserId());
        this.fbE.startLoad(postData.rt().getPortrait(), 28, false);
        this.fbO.a(postData.rt());
        if (postData.rt() != null && postData.rt().getAlaUserData() != null && this.fbS != null) {
            if (postData.rt().getAlaUserData().anchor_live == 0) {
                this.fbS.setVisibility(8);
                return;
            }
            this.fbS.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.QK = postData.rt().getAlaUserData();
            aVar.type = 6;
            this.fbS.setTag(aVar);
        }
    }

    private void Z(bh bhVar) {
        this.fbK.setVisibility(0);
        this.bio = bhVar.sz();
        if (this.bio.aaD == 1) {
            this.fbN = 0;
        } else {
            this.fbN = this.bio.aaD;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fbN = 2;
        }
        this.fbF.setText(this.bio.channelName);
        this.fbE.startLoad(this.bio.channelAvatar, 10, false);
        l(this.fbN, this.bio.channelId);
    }

    public void l(int i, long j) {
        if (this.bio != null && j > 0 && j == this.bio.channelId) {
            if (i == 1) {
                this.fbH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fbH, d.C0080d.cp_bg_line_d_alpha80);
                this.fbH.setClickable(false);
                this.fbH.setText(d.j.has_ordered_channel);
                return;
            }
            this.fbH.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbH, d.C0080d.cp_cont_i);
            this.fbH.setClickable(true);
            this.fbH.setText(d.j.order_video_channel);
        }
    }

    public void X(float f) {
        this.fbG.setAlpha(f);
    }

    public View aXj() {
        return this.fbG;
    }

    public void dD(int i) {
        if (this.fbL != null) {
            this.fbL.onChangeSkinType(i);
        }
        if (this.fbI != null) {
            aj.i(this.fbI, d.C0080d.cp_cont_i);
        }
        if (this.fbN == 1) {
            aj.i(this.fbH, d.C0080d.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.fbH, d.C0080d.cp_cont_i);
        }
        if (this.fbF != null) {
            aj.i(this.fbF, d.C0080d.cp_cont_i);
        }
        if (this.fbK != null) {
            aj.j(this.fbK, d.f.icon_weiba);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        this.fbP = onClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.fbQ = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anH != null) {
            this.anH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fbI.setText(am.w(j));
        if (z) {
            this.fbJ.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fbJ.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anH);
    }
}
