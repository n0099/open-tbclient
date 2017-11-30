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
    private TbPageContext<?> acd;
    private bj boY;
    private View ehB;
    private TextView fiA;
    private RelativeLayout fiB;
    private TextView fiC;
    private TextView fiD;
    private ImageView fiE;
    private ImageView fiF;
    private PbVideoFullUserInfoLikeButton fiG;
    public int fiI;
    private f fiJ;
    private View.OnClickListener fiK;
    private View.OnClickListener fiL;
    private LinearLayout fiM;
    private bd fiN;
    private HeadImageView fiz;
    private boolean fiH = false;
    private View.OnClickListener aWG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fiE) {
                g.this.bn(view);
            } else if (view == g.this.fiz || view == g.this.fiA || view == g.this.fiF) {
                g.this.bo(view);
            } else if (view == g.this.fiC) {
                g.this.aYh();
            }
        }
    };
    private CustomMessageListener anU = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fiN != null && g.this.fiN.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fiN.rO())) {
                    g.this.a(kVar.eOX == 0, kVar.eOY.aRM());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.acd = tbPageContext;
        this.ehB = p(tbPageContext);
        initView();
        q(this.acd.getUniqueId());
        frameLayout.addView(this.ehB);
    }

    private View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fiB = (RelativeLayout) this.ehB.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fiz = (HeadImageView) this.ehB.findViewById(d.g.pbVideoFullPhoto);
        this.fiz.setOnClickListener(this.aWG);
        this.fiM = (LinearLayout) this.ehB.findViewById(d.g.pbVideoFullNameLayout);
        aj.j(this.fiM, d.f.video_author_bg);
        this.fiA = (TextView) this.ehB.findViewById(d.g.pbVideoFullUserName);
        this.fiA.setOnClickListener(this.aWG);
        this.fiC = (TextView) this.ehB.findViewById(d.g.pbVideoFullAttention);
        this.fiC.setOnClickListener(this.aWG);
        this.fiD = (TextView) this.ehB.findViewById(d.g.pbVideoFullZanCount);
        this.fiE = (ImageView) this.ehB.findViewById(d.g.pbVideoFullZanLabel);
        this.fiE.setOnClickListener(this.aWG);
        this.fiF = (ImageView) this.ehB.findViewById(d.g.pbVideoFullChannelIcon);
        this.fiG = (PbVideoFullUserInfoLikeButton) this.ehB.findViewById(d.g.pbVideoFullLikeButton);
        this.fiG.setTextSize(0, l.f(this.acd.getPageActivity(), d.e.tbds30));
        this.fiJ = new f(this.acd, this.fiG);
        this.fiz.setRadius(l.f(this.acd.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(View view) {
        if (this.fiL != null) {
            this.fiL.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(View view) {
        if (this.fiH) {
            if (this.boY != null) {
                this.acd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.acd.getPageActivity(), this.boY.channelId, 2)));
            }
        } else if (this.fiK != null) {
            this.fiK.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYh() {
        if (this.fiH) {
            if (!l.hy()) {
                this.acd.showToast(d.j.no_network_guide);
            } else if (this.boY != null && this.boY.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aU(this.acd.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(this.boY.channelId, this.acd.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, com.baidu.tieba.pb.data.l lVar) {
        this.fiN = bdVar;
        a(lVar.aRN(), lVar.aRM());
        if (bdVar.sC() != null) {
            this.fiH = true;
            this.fiG.setVisibility(8);
            this.fiC.setVisibility(0);
            aa(bdVar);
        } else {
            this.fiH = false;
            this.fiG.setVisibility(0);
            this.fiC.setVisibility(8);
            o(postData);
        }
        if (N(bdVar)) {
            this.fiC.setVisibility(8);
            this.fiG.setVisibility(8);
        }
    }

    private boolean N(bd bdVar) {
        if (bdVar == null || bdVar.rx() == null || bdVar.rx().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rx().getUserId());
    }

    private void o(PostData postData) {
        this.fiF.setVisibility(8);
        this.fiz.setUserId(postData.rx().getUserId());
        this.fiz.setUserName(postData.rx().getUserName());
        this.fiz.setIsBigV(postData.rx().isBigV());
        this.fiA.setText(postData.rx().getUserName());
        this.fiA.setTag(postData.rx().getUserId());
        this.fiz.startLoad(postData.rx().getPortrait(), 28, false);
        this.fiJ.a(postData.rx());
    }

    private void aa(bd bdVar) {
        this.fiF.setVisibility(0);
        this.boY = bdVar.sC();
        if (this.boY.aaY == 1) {
            this.fiI = 0;
        } else {
            this.fiI = this.boY.aaY;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fiI = 2;
        }
        this.fiA.setText(this.boY.channelName);
        this.fiz.startLoad(this.boY.channelAvatar, 10, false);
        l(this.fiI, this.boY.channelId);
    }

    public void l(int i, long j) {
        if (this.boY != null && j > 0 && j == this.boY.channelId) {
            if (i == 1) {
                this.fiC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fiC, d.C0082d.cp_bg_line_d_alpha80);
                this.fiC.setClickable(false);
                this.fiC.setText(d.j.has_ordered_channel);
                return;
            }
            this.fiC.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fiC, d.C0082d.cp_cont_i);
            this.fiC.setClickable(true);
            this.fiC.setText(d.j.order_video_channel);
        }
    }

    public void Y(float f) {
        this.fiB.setAlpha(f);
    }

    public View aYi() {
        return this.fiB;
    }

    public void dE(int i) {
        if (this.fiG != null) {
            this.fiG.onChangeSkinType(i);
        }
        if (this.fiD != null) {
            aj.i(this.fiD, d.C0082d.cp_cont_i);
        }
        if (this.fiI == 1) {
            aj.i(this.fiC, d.C0082d.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.fiC, d.C0082d.cp_cont_i);
        }
        if (this.fiA != null) {
            aj.i(this.fiA, d.C0082d.cp_cont_i);
        }
        if (this.fiF != null) {
            aj.j(this.fiF, d.f.icon_weiba);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.fiK = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fiL = onClickListener;
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anU != null) {
            this.anU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fiD.setText(am.w(j));
        if (z) {
            this.fiE.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fiE.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anU);
    }
}
