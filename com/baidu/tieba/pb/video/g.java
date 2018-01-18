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
/* loaded from: classes2.dex */
public class g {
    private TbPageContext<?> aQp;
    private bj ccF;
    private View eWq;
    private HeadImageView fXZ;
    private TextView fYa;
    private RelativeLayout fYb;
    private TextView fYc;
    private TextView fYd;
    private ImageView fYe;
    private ImageView fYf;
    private PbVideoFullUserInfoLikeButton fYg;
    public int fYi;
    private f fYj;
    private View.OnClickListener fYk;
    private View.OnClickListener fYl;
    private LinearLayout fYm;
    private bd fYn;
    private boolean fYh = false;
    private View.OnClickListener bKJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fYe) {
                g.this.cE(view);
            } else if (view == g.this.fXZ || view == g.this.fYa || view == g.this.fYf) {
                g.this.cF(view);
            } else if (view == g.this.fYc) {
                g.this.bfG();
            }
        }
    };
    private CustomMessageListener bbX = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fYn != null && g.this.fYn.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fYn.zj())) {
                    g.this.a(kVar.fEf == 0, kVar.fEg.aZl());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aQp = tbPageContext;
        this.eWq = o(tbPageContext);
        initView();
        o(this.aQp.getUniqueId());
        frameLayout.addView(this.eWq);
    }

    private View o(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fYb = (RelativeLayout) this.eWq.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fXZ = (HeadImageView) this.eWq.findViewById(d.g.pbVideoFullPhoto);
        this.fXZ.setOnClickListener(this.bKJ);
        this.fYm = (LinearLayout) this.eWq.findViewById(d.g.pbVideoFullNameLayout);
        aj.s(this.fYm, d.f.video_author_bg);
        this.fYa = (TextView) this.eWq.findViewById(d.g.pbVideoFullUserName);
        this.fYa.setOnClickListener(this.bKJ);
        this.fYc = (TextView) this.eWq.findViewById(d.g.pbVideoFullAttention);
        this.fYc.setOnClickListener(this.bKJ);
        this.fYd = (TextView) this.eWq.findViewById(d.g.pbVideoFullZanCount);
        this.fYe = (ImageView) this.eWq.findViewById(d.g.pbVideoFullZanLabel);
        this.fYe.setOnClickListener(this.bKJ);
        this.fYf = (ImageView) this.eWq.findViewById(d.g.pbVideoFullChannelIcon);
        this.fYg = (PbVideoFullUserInfoLikeButton) this.eWq.findViewById(d.g.pbVideoFullLikeButton);
        this.fYg.setTextSize(0, l.s(this.aQp.getPageActivity(), d.e.tbds30));
        this.fYj = new f(this.aQp, this.fYg);
        this.fXZ.setRadius(l.s(this.aQp.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(View view) {
        if (this.fYl != null) {
            this.fYl.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.fYh) {
            if (this.ccF != null) {
                this.aQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aQp.getPageActivity(), this.ccF.channelId, 2)));
            }
        } else if (this.fYk != null) {
            this.fYk.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        if (this.fYh) {
            if (!l.oZ()) {
                this.aQp.showToast(d.j.no_network_guide);
            } else if (this.ccF != null && this.ccF.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.bd(this.aQp.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0071a.a(this.ccF.channelId, this.aQp.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, com.baidu.tieba.pb.data.l lVar) {
        this.fYn = bdVar;
        a(lVar.aZn(), lVar.aZl());
        if (bdVar.zU() != null) {
            this.fYh = true;
            this.fYg.setVisibility(8);
            this.fYc.setVisibility(0);
            ab(bdVar);
        } else {
            this.fYh = false;
            this.fYg.setVisibility(0);
            this.fYc.setVisibility(8);
            o(postData);
        }
        if (Y(bdVar)) {
            this.fYc.setVisibility(8);
            this.fYg.setVisibility(8);
        }
    }

    private boolean Y(bd bdVar) {
        if (bdVar == null || bdVar.yS() == null || bdVar.yS().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.yS().getUserId());
    }

    private void o(PostData postData) {
        this.fYf.setVisibility(8);
        this.fXZ.setUserId(postData.yS().getUserId());
        this.fXZ.setUserName(postData.yS().getUserName());
        this.fXZ.setIsBigV(postData.yS().isBigV());
        this.fYa.setText(postData.yS().getUserName());
        this.fYa.setTag(postData.yS().getUserId());
        this.fXZ.startLoad(postData.yS().getPortrait(), 28, false);
        this.fYj.a(postData.yS());
    }

    private void ab(bd bdVar) {
        this.fYf.setVisibility(0);
        this.ccF = bdVar.zU();
        if (this.ccF.aPq == 1) {
            this.fYi = 0;
        } else {
            this.fYi = this.ccF.aPq;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fYi = 2;
        }
        this.fYa.setText(this.ccF.channelName);
        this.fXZ.startLoad(this.ccF.channelAvatar, 10, false);
        j(this.fYi, this.ccF.channelId);
    }

    public void j(int i, long j) {
        if (this.ccF != null && j > 0 && j == this.ccF.channelId) {
            if (i == 1) {
                this.fYc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.fYc, d.C0107d.cp_bg_line_d_alpha80);
                this.fYc.setClickable(false);
                this.fYc.setText(d.j.has_ordered_channel);
                return;
            }
            this.fYc.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fYc, d.C0107d.cp_cont_i);
            this.fYc.setClickable(true);
            this.fYc.setText(d.j.order_video_channel);
        }
    }

    public void an(float f) {
        this.fYb.setAlpha(f);
    }

    public View bfH() {
        return this.fYb;
    }

    public void gz(int i) {
        if (this.fYg != null) {
            this.fYg.onChangeSkinType(i);
        }
        if (this.fYd != null) {
            aj.r(this.fYd, d.C0107d.cp_cont_i);
        }
        if (this.fYi == 1) {
            aj.r(this.fYc, d.C0107d.cp_bg_line_d_alpha80);
        } else {
            aj.r(this.fYc, d.C0107d.cp_cont_i);
        }
        if (this.fYa != null) {
            aj.r(this.fYa, d.C0107d.cp_cont_i);
        }
        if (this.fYf != null) {
            aj.s(this.fYf, d.f.icon_weiba);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.fYk = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.fYl = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbX != null) {
            this.bbX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bbX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fYd.setText(am.F(j));
        if (z) {
            this.fYe.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fYe.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bbX);
    }
}
