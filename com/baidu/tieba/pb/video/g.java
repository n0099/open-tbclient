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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
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
    private TbPageContext<?> aca;
    private bj bpd;
    private View eiK;
    private HeadImageView fjC;
    private TextView fjD;
    private RelativeLayout fjE;
    private TextView fjF;
    private TextView fjG;
    private ImageView fjH;
    private ImageView fjI;
    private PbVideoFullUserInfoLikeButton fjJ;
    public int fjL;
    private f fjM;
    private View.OnClickListener fjN;
    private View.OnClickListener fjO;
    private LinearLayout fjP;
    private bd fjQ;
    private boolean fjK = false;
    private View.OnClickListener aWM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fjH) {
                g.this.br(view);
            } else if (view == g.this.fjC || view == g.this.fjD || view == g.this.fjI) {
                g.this.bs(view);
            } else if (view == g.this.fjF) {
                g.this.aYp();
            }
        }
    };
    private CustomMessageListener anZ = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fjQ != null && g.this.fjQ.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fjQ.rM())) {
                    g.this.a(kVar.eQf == 0, kVar.eQg.aRV());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aca = tbPageContext;
        this.eiK = p(tbPageContext);
        initView();
        q(this.aca.getUniqueId());
        frameLayout.addView(this.eiK);
    }

    private View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fjE = (RelativeLayout) this.eiK.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fjC = (HeadImageView) this.eiK.findViewById(d.g.pbVideoFullPhoto);
        this.fjC.setOnClickListener(this.aWM);
        this.fjP = (LinearLayout) this.eiK.findViewById(d.g.pbVideoFullNameLayout);
        aj.j(this.fjP, d.f.video_author_bg);
        this.fjD = (TextView) this.eiK.findViewById(d.g.pbVideoFullUserName);
        this.fjD.setOnClickListener(this.aWM);
        this.fjF = (TextView) this.eiK.findViewById(d.g.pbVideoFullAttention);
        this.fjF.setOnClickListener(this.aWM);
        this.fjG = (TextView) this.eiK.findViewById(d.g.pbVideoFullZanCount);
        this.fjH = (ImageView) this.eiK.findViewById(d.g.pbVideoFullZanLabel);
        this.fjH.setOnClickListener(this.aWM);
        this.fjI = (ImageView) this.eiK.findViewById(d.g.pbVideoFullChannelIcon);
        this.fjJ = (PbVideoFullUserInfoLikeButton) this.eiK.findViewById(d.g.pbVideoFullLikeButton);
        this.fjJ.setTextSize(0, l.f(this.aca.getPageActivity(), d.e.tbds30));
        this.fjM = new f(this.aca, this.fjJ);
        this.fjC.setRadius(l.f(this.aca.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(View view) {
        if (this.fjO != null) {
            this.fjO.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        if (this.fjK) {
            if (this.bpd != null) {
                this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aca.getPageActivity(), this.bpd.channelId, 2)));
            }
        } else if (this.fjN != null) {
            this.fjN.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYp() {
        if (this.fjK) {
            if (!l.hy()) {
                this.aca.showToast(d.j.no_network_guide);
            } else if (this.bpd != null && this.bpd.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aR(this.aca.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0058a.a(this.bpd.channelId, this.aca.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, com.baidu.tieba.pb.data.l lVar) {
        this.fjQ = bdVar;
        a(lVar.aRW(), lVar.aRV());
        if (bdVar.sA() != null) {
            this.fjK = true;
            this.fjJ.setVisibility(8);
            this.fjF.setVisibility(0);
            ac(bdVar);
        } else {
            this.fjK = false;
            this.fjJ.setVisibility(0);
            this.fjF.setVisibility(8);
            o(postData);
        }
        if (P(bdVar)) {
            this.fjF.setVisibility(8);
            this.fjJ.setVisibility(8);
        }
    }

    private boolean P(bd bdVar) {
        if (bdVar == null || bdVar.rv() == null || bdVar.rv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rv().getUserId());
    }

    private void o(PostData postData) {
        this.fjI.setVisibility(8);
        this.fjC.setUserId(postData.rv().getUserId());
        this.fjC.setUserName(postData.rv().getUserName());
        this.fjC.setIsBigV(postData.rv().isBigV());
        this.fjD.setText(postData.rv().getUserName());
        this.fjD.setTag(postData.rv().getUserId());
        this.fjC.startLoad(postData.rv().getPortrait(), 28, false);
        this.fjM.a(postData.rv());
    }

    private void ac(bd bdVar) {
        this.fjI.setVisibility(0);
        this.bpd = bdVar.sA();
        if (this.bpd.aaV == 1) {
            this.fjL = 0;
        } else {
            this.fjL = this.bpd.aaV;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fjL = 2;
        }
        this.fjD.setText(this.bpd.channelName);
        this.fjC.startLoad(this.bpd.channelAvatar, 10, false);
        l(this.fjL, this.bpd.channelId);
    }

    public void l(int i, long j) {
        if (this.bpd != null && j > 0 && j == this.bpd.channelId) {
            if (i == 1) {
                this.fjF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fjF, d.C0095d.cp_bg_line_d_alpha80);
                this.fjF.setClickable(false);
                this.fjF.setText(d.j.has_ordered_channel);
                return;
            }
            this.fjF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fjF, d.C0095d.cp_cont_i);
            this.fjF.setClickable(true);
            this.fjF.setText(d.j.order_video_channel);
        }
    }

    public void Y(float f) {
        this.fjE.setAlpha(f);
    }

    public View aYq() {
        return this.fjE;
    }

    public void dE(int i) {
        if (this.fjJ != null) {
            this.fjJ.onChangeSkinType(i);
        }
        if (this.fjG != null) {
            aj.i(this.fjG, d.C0095d.cp_cont_i);
        }
        if (this.fjL == 1) {
            aj.i(this.fjF, d.C0095d.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.fjF, d.C0095d.cp_cont_i);
        }
        if (this.fjD != null) {
            aj.i(this.fjD, d.C0095d.cp_cont_i);
        }
        if (this.fjI != null) {
            aj.j(this.fjI, d.f.icon_weiba);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.fjN = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fjO = onClickListener;
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anZ != null) {
            this.anZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fjG.setText(am.w(j));
        if (z) {
            this.fjH.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fjH.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anZ);
    }
}
