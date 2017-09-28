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
    private TbPageContext<?> abz;
    private bm bhF;
    private View dUh;
    private HeadImageView eSR;
    private TextView eSS;
    private RelativeLayout eST;
    private TextView eSU;
    private TextView eSV;
    private ImageView eSW;
    private ImageView eSX;
    private PbVideoFullUserInfoLikeButton eSY;
    public int eTa;
    private f eTb;
    private View.OnClickListener eTc;
    private View.OnClickListener eTd;
    private LinearLayout eTe;
    private View eTf;
    private bh eTg;
    private boolean eSZ = false;
    private View.OnClickListener aTG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eSW) {
                g.this.bp(view);
            } else if (view == g.this.eSR || view == g.this.eSS || view == g.this.eSX) {
                g.this.bq(view);
            } else if (view == g.this.eSU) {
                g.this.aUd();
            }
        }
    };
    private CustomMessageListener anz = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.k) && g.this.eTg != null && g.this.eTg.getId() != null) {
                com.baidu.tieba.pb.data.k kVar = (com.baidu.tieba.pb.data.k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.eTg.rL())) {
                    g.this.a(kVar.ezf == 0, kVar.ezg.getPraiseNum());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.abz = tbPageContext;
        this.dUh = q(tbPageContext);
        initView();
        p(this.abz.getUniqueId());
        frameLayout.addView(this.dUh);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eST = (RelativeLayout) this.dUh.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eSR = (HeadImageView) this.dUh.findViewById(d.h.pbVideoFullPhoto);
        this.eSR.setOnClickListener(this.aTG);
        this.eTe = (LinearLayout) this.dUh.findViewById(d.h.pbVideoFullNameLayout);
        this.eTf = com.baidu.tbadk.ala.b.nz().h(this.abz.getPageActivity(), 6);
        if (this.eTf != null) {
            this.eTf.setVisibility(8);
            this.eTe.addView(this.eTf);
        }
        this.eSS = (TextView) this.dUh.findViewById(d.h.pbVideoFullUserName);
        this.eSS.setOnClickListener(this.aTG);
        this.eSU = (TextView) this.dUh.findViewById(d.h.pbVideoFullAttention);
        this.eSU.setOnClickListener(this.aTG);
        this.eSV = (TextView) this.dUh.findViewById(d.h.pbVideoFullZanCount);
        this.eSW = (ImageView) this.dUh.findViewById(d.h.pbVideoFullZanLabel);
        this.eSW.setOnClickListener(this.aTG);
        this.eSX = (ImageView) this.dUh.findViewById(d.h.pbVideoFullChannelIcon);
        this.eSY = (PbVideoFullUserInfoLikeButton) this.dUh.findViewById(d.h.pbVideoFullLikeButton);
        this.eTb = new f(this.abz, this.eSY);
        this.eSR.setRadius(com.baidu.adp.lib.util.l.f(this.abz.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
        if (this.eTd != null) {
            this.eTd.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(View view) {
        if (this.eSZ) {
            if (this.bhF != null) {
                this.abz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.abz.getPageActivity(), this.bhF.channelId, 2)));
            }
        } else if (this.eTc != null) {
            this.eTc.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUd() {
        if (this.eSZ) {
            if (!com.baidu.adp.lib.util.l.hy()) {
                this.abz.showToast(d.l.no_network_guide);
            } else if (this.bhF != null && this.bhF.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aT(this.abz.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(this.bhF.channelId, this.abz.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, com.baidu.tieba.pb.data.l lVar) {
        this.eTg = bhVar;
        a(lVar.aNF(), lVar.getPraiseNum());
        if (bhVar.sz() != null) {
            this.eSZ = true;
            this.eSY.setVisibility(8);
            this.eSU.setVisibility(0);
            Z(bhVar);
        } else {
            this.eSZ = false;
            this.eSY.setVisibility(0);
            this.eSU.setVisibility(8);
            p(postData);
        }
        if (N(bhVar)) {
            this.eSU.setVisibility(8);
            this.eSY.setVisibility(8);
        }
    }

    private boolean N(bh bhVar) {
        if (bhVar == null || bhVar.getAuthor() == null || bhVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.getAuthor().getUserId());
    }

    private void p(PostData postData) {
        this.eSX.setVisibility(8);
        this.eSR.setUserId(postData.getAuthor().getUserId());
        this.eSR.setUserName(postData.getAuthor().getUserName());
        this.eSR.setIsBigV(postData.getAuthor().isBigV());
        this.eSS.setText(postData.getAuthor().getUserName());
        this.eSS.setTag(postData.getAuthor().getUserId());
        this.eSR.c(postData.getAuthor().getPortrait(), 28, false);
        this.eTb.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eTf != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eTf.setVisibility(8);
                return;
            }
            this.eTf.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.QH = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eTf.setTag(aVar);
        }
    }

    private void Z(bh bhVar) {
        this.eSX.setVisibility(0);
        this.bhF = bhVar.sz();
        if (this.bhF.aas == 1) {
            this.eTa = 0;
        } else {
            this.eTa = this.bhF.aas;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eTa = 2;
        }
        this.eSS.setText(this.bhF.channelName);
        this.eSR.c(this.bhF.channelAvatar, 10, false);
        k(this.eTa, this.bhF.channelId);
    }

    public void k(int i, long j) {
        if (this.bhF != null && j > 0 && j == this.bhF.channelId) {
            if (i == 1) {
                this.eSU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eSU, d.e.cp_bg_line_d_alpha80);
                this.eSU.setClickable(false);
                this.eSU.setText(d.l.has_ordered_channel);
                return;
            }
            this.eSU.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSU, d.e.cp_cont_i);
            this.eSU.setClickable(true);
            this.eSU.setText(d.l.order_video_channel);
        }
    }

    public void Y(float f) {
        this.eST.setAlpha(f);
    }

    public View aUe() {
        return this.eST;
    }

    public void dE(int i) {
        if (this.eSY != null) {
            this.eSY.onChangeSkinType(i);
        }
        if (this.eSV != null) {
            aj.i(this.eSV, d.e.cp_cont_i);
        }
        if (this.eTa == 1) {
            aj.i(this.eSU, d.e.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.eSU, d.e.cp_cont_i);
        }
        if (this.eSS != null) {
            aj.i(this.eSS, d.e.cp_cont_i);
        }
        if (this.eSX != null) {
            aj.j(this.eSX, d.g.icon_weiba);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        this.eTc = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eTd = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anz != null) {
            this.anz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eSV.setText(am.v(j));
        if (z) {
            this.eSW.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eSW.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anz);
    }
}
