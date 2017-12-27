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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private TbPageContext<?> aQq;
    private bk ccy;
    private View eUQ;
    private RelativeLayout fWA;
    private TextView fWB;
    private TextView fWC;
    private ImageView fWD;
    private ImageView fWE;
    private PbVideoFullUserInfoLikeButton fWF;
    public int fWH;
    private f fWI;
    private View.OnClickListener fWJ;
    private View.OnClickListener fWK;
    private LinearLayout fWL;
    private be fWM;
    private HeadImageView fWy;
    private TextView fWz;
    private boolean fWG = false;
    private View.OnClickListener bKB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fWD) {
                g.this.cC(view);
            } else if (view == g.this.fWy || view == g.this.fWz || view == g.this.fWE) {
                g.this.cD(view);
            } else if (view == g.this.fWB) {
                g.this.bfF();
            }
        }
    };
    private CustomMessageListener bbX = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fWM != null && g.this.fWM.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fWM.zo())) {
                    g.this.a(kVar.fCF == 0, kVar.fCG.aZh());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aQq = tbPageContext;
        this.eUQ = o(tbPageContext);
        initView();
        o(this.aQq.getUniqueId());
        frameLayout.addView(this.eUQ);
    }

    private View o(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fWA = (RelativeLayout) this.eUQ.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fWy = (HeadImageView) this.eUQ.findViewById(d.g.pbVideoFullPhoto);
        this.fWy.setOnClickListener(this.bKB);
        this.fWL = (LinearLayout) this.eUQ.findViewById(d.g.pbVideoFullNameLayout);
        aj.s(this.fWL, d.f.video_author_bg);
        this.fWz = (TextView) this.eUQ.findViewById(d.g.pbVideoFullUserName);
        this.fWz.setOnClickListener(this.bKB);
        this.fWB = (TextView) this.eUQ.findViewById(d.g.pbVideoFullAttention);
        this.fWB.setOnClickListener(this.bKB);
        this.fWC = (TextView) this.eUQ.findViewById(d.g.pbVideoFullZanCount);
        this.fWD = (ImageView) this.eUQ.findViewById(d.g.pbVideoFullZanLabel);
        this.fWD.setOnClickListener(this.bKB);
        this.fWE = (ImageView) this.eUQ.findViewById(d.g.pbVideoFullChannelIcon);
        this.fWF = (PbVideoFullUserInfoLikeButton) this.eUQ.findViewById(d.g.pbVideoFullLikeButton);
        this.fWF.setTextSize(0, l.s(this.aQq.getPageActivity(), d.e.tbds30));
        this.fWI = new f(this.aQq, this.fWF);
        this.fWy.setRadius(l.s(this.aQq.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
        if (this.fWK != null) {
            this.fWK.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
        if (this.fWG) {
            if (this.ccy != null) {
                this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aQq.getPageActivity(), this.ccy.channelId, 2)));
            }
        } else if (this.fWJ != null) {
            this.fWJ.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfF() {
        if (this.fWG) {
            if (!l.oZ()) {
                this.aQq.showToast(d.j.no_network_guide);
            } else if (this.ccy != null && this.ccy.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.bd(this.aQq.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0072a.a(this.ccy.channelId, this.aQq.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, be beVar, com.baidu.tieba.pb.data.l lVar) {
        this.fWM = beVar;
        a(lVar.aZj(), lVar.aZh());
        if (beVar.Ac() != null) {
            this.fWG = true;
            this.fWF.setVisibility(8);
            this.fWB.setVisibility(0);
            ab(beVar);
        } else {
            this.fWG = false;
            this.fWF.setVisibility(0);
            this.fWB.setVisibility(8);
            o(postData);
        }
        if (Y(beVar)) {
            this.fWB.setVisibility(8);
            this.fWF.setVisibility(8);
        }
    }

    private boolean Y(be beVar) {
        if (beVar == null || beVar.yX() == null || beVar.yX().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), beVar.yX().getUserId());
    }

    private void o(PostData postData) {
        this.fWE.setVisibility(8);
        this.fWy.setUserId(postData.yX().getUserId());
        this.fWy.setUserName(postData.yX().getUserName());
        this.fWy.setIsBigV(postData.yX().isBigV());
        this.fWz.setText(postData.yX().getUserName());
        this.fWz.setTag(postData.yX().getUserId());
        this.fWy.startLoad(postData.yX().getPortrait(), 28, false);
        this.fWI.a(postData.yX());
    }

    private void ab(be beVar) {
        this.fWE.setVisibility(0);
        this.ccy = beVar.Ac();
        if (this.ccy.aPr == 1) {
            this.fWH = 0;
        } else {
            this.fWH = this.ccy.aPr;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fWH = 2;
        }
        this.fWz.setText(this.ccy.channelName);
        this.fWy.startLoad(this.ccy.channelAvatar, 10, false);
        l(this.fWH, this.ccy.channelId);
    }

    public void l(int i, long j) {
        if (this.ccy != null && j > 0 && j == this.ccy.channelId) {
            if (i == 1) {
                this.fWB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.fWB, d.C0108d.cp_bg_line_d_alpha80);
                this.fWB.setClickable(false);
                this.fWB.setText(d.j.has_ordered_channel);
                return;
            }
            this.fWB.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fWB, d.C0108d.cp_cont_i);
            this.fWB.setClickable(true);
            this.fWB.setText(d.j.order_video_channel);
        }
    }

    public void ao(float f) {
        this.fWA.setAlpha(f);
    }

    public View bfG() {
        return this.fWA;
    }

    public void gC(int i) {
        if (this.fWF != null) {
            this.fWF.onChangeSkinType(i);
        }
        if (this.fWC != null) {
            aj.r(this.fWC, d.C0108d.cp_cont_i);
        }
        if (this.fWH == 1) {
            aj.r(this.fWB, d.C0108d.cp_bg_line_d_alpha80);
        } else {
            aj.r(this.fWB, d.C0108d.cp_cont_i);
        }
        if (this.fWz != null) {
            aj.r(this.fWz, d.C0108d.cp_cont_i);
        }
        if (this.fWE != null) {
            aj.s(this.fWE, d.f.icon_weiba);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.fWJ = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fWK = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbX != null) {
            this.bbX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bbX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fWC.setText(am.E(j));
        if (z) {
            this.fWD.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fWD.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bbX);
    }
}
