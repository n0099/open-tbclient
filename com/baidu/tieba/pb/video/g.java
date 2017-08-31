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
    private bo bfV;
    private View dXf;
    private HeadImageView eXO;
    private TextView eXP;
    private RelativeLayout eXQ;
    private TextView eXR;
    private TextView eXS;
    private ImageView eXT;
    private ImageView eXU;
    private PbVideoFullUserInfoLikeButton eXV;
    public int eXX;
    private f eXY;
    private View.OnClickListener eXZ;
    private View.OnClickListener eYa;
    private LinearLayout eYb;
    private View eYc;
    private bj eYd;
    private boolean eXW = false;
    private View.OnClickListener aSK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eXT) {
                g.this.br(view);
            } else if (view == g.this.eXO || view == g.this.eXP || view == g.this.eXU) {
                g.this.bs(view);
            } else if (view == g.this.eXR) {
                g.this.aVJ();
            }
        }
    };
    private CustomMessageListener aom = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.k) && g.this.eYd != null && g.this.eYd.getId() != null) {
                com.baidu.tieba.pb.data.k kVar = (com.baidu.tieba.pb.data.k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.eYd.rR())) {
                    g.this.a(kVar.eEP == 0, kVar.eEQ.getPraiseNum());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aby = tbPageContext;
        this.dXf = t(tbPageContext);
        initView();
        q(this.aby.getUniqueId());
        frameLayout.addView(this.dXf);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eXQ = (RelativeLayout) this.dXf.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eXO = (HeadImageView) this.dXf.findViewById(d.h.pbVideoFullPhoto);
        this.eXO.setOnClickListener(this.aSK);
        this.eYb = (LinearLayout) this.dXf.findViewById(d.h.pbVideoFullNameLayout);
        this.eYc = com.baidu.tbadk.ala.b.nw().i(this.aby.getPageActivity(), 6);
        if (this.eYc != null) {
            this.eYc.setVisibility(8);
            this.eYb.addView(this.eYc);
        }
        this.eXP = (TextView) this.dXf.findViewById(d.h.pbVideoFullUserName);
        this.eXP.setOnClickListener(this.aSK);
        this.eXR = (TextView) this.dXf.findViewById(d.h.pbVideoFullAttention);
        this.eXR.setOnClickListener(this.aSK);
        this.eXS = (TextView) this.dXf.findViewById(d.h.pbVideoFullZanCount);
        this.eXT = (ImageView) this.dXf.findViewById(d.h.pbVideoFullZanLabel);
        this.eXT.setOnClickListener(this.aSK);
        this.eXU = (ImageView) this.dXf.findViewById(d.h.pbVideoFullChannelIcon);
        this.eXV = (PbVideoFullUserInfoLikeButton) this.dXf.findViewById(d.h.pbVideoFullLikeButton);
        this.eXY = new f(this.aby, this.eXV);
        this.eXO.setRadius(com.baidu.adp.lib.util.k.g(this.aby.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(View view) {
        if (this.eYa != null) {
            this.eYa.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        if (this.eXW) {
            if (this.bfV != null) {
                this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aby.getPageActivity(), this.bfV.channelId, 2)));
            }
        } else if (this.eXZ != null) {
            this.eXZ.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVJ() {
        if (this.eXW) {
            if (!com.baidu.adp.lib.util.k.hz()) {
                this.aby.showToast(d.l.no_network_guide);
            } else if (this.bfV != null && this.bfV.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aS(this.aby.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(this.bfV.channelId, this.aby.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bj bjVar, com.baidu.tieba.pb.data.l lVar) {
        this.eYd = bjVar;
        a(lVar.aPA(), lVar.getPraiseNum());
        if (bjVar.sF() != null) {
            this.eXW = true;
            this.eXV.setVisibility(8);
            this.eXR.setVisibility(0);
            ae(bjVar);
        } else {
            this.eXW = false;
            this.eXV.setVisibility(0);
            this.eXR.setVisibility(8);
            o(postData);
        }
        if (S(bjVar)) {
            this.eXR.setVisibility(8);
            this.eXV.setVisibility(8);
        }
    }

    private boolean S(bj bjVar) {
        if (bjVar == null || bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.getAuthor().getUserId());
    }

    private void o(PostData postData) {
        this.eXU.setVisibility(8);
        this.eXO.setUserId(postData.getAuthor().getUserId());
        this.eXO.setUserName(postData.getAuthor().getUserName());
        this.eXO.setIsBigV(postData.getAuthor().isBigV());
        this.eXP.setText(postData.getAuthor().getUserName());
        this.eXP.setTag(postData.getAuthor().getUserId());
        this.eXO.c(postData.getAuthor().getPortrait(), 28, false);
        this.eXY.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eYc != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eYc.setVisibility(8);
                return;
            }
            this.eYc.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.Qs = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eYc.setTag(aVar);
        }
    }

    private void ae(bj bjVar) {
        this.eXU.setVisibility(0);
        this.bfV = bjVar.sF();
        if (this.bfV.aas == 1) {
            this.eXX = 0;
        } else {
            this.eXX = this.bfV.aas;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eXX = 2;
        }
        this.eXP.setText(this.bfV.channelName);
        this.eXO.c(this.bfV.channelAvatar, 10, false);
        k(this.eXX, this.bfV.channelId);
    }

    public void k(int i, long j) {
        if (this.bfV != null && j > 0 && j == this.bfV.channelId) {
            if (i == 1) {
                this.eXR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eXR, d.e.cp_bg_line_d_alpha80);
                this.eXR.setClickable(false);
                this.eXR.setText(d.l.has_ordered_channel);
                return;
            }
            this.eXR.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eXR, d.e.cp_cont_i);
            this.eXR.setClickable(true);
            this.eXR.setText(d.l.order_video_channel);
        }
    }

    public void W(float f) {
        this.eXQ.setAlpha(f);
    }

    public View aVK() {
        return this.eXQ;
    }

    public void du(int i) {
        if (this.eXV != null) {
            this.eXV.onChangeSkinType(i);
        }
        if (this.eXS != null) {
            aj.i(this.eXS, d.e.cp_cont_i);
        }
        if (this.eXX == 1) {
            aj.i(this.eXR, d.e.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.eXR, d.e.cp_cont_i);
        }
        if (this.eXP != null) {
            aj.i(this.eXP, d.e.cp_cont_i);
        }
        if (this.eXU != null) {
            aj.j(this.eXU, d.g.icon_weiba);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.eXZ = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.eYa = onClickListener;
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aom != null) {
            this.aom.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eXS.setText(am.w(j));
        if (z) {
            this.eXT.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eXT.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aom);
    }
}
