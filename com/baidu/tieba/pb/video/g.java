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
    private TbPageContext<?> abX;
    private bj boZ;
    private View eiG;
    private TextView fjA;
    private TextView fjB;
    private ImageView fjC;
    private ImageView fjD;
    private PbVideoFullUserInfoLikeButton fjE;
    public int fjG;
    private f fjH;
    private View.OnClickListener fjI;
    private View.OnClickListener fjJ;
    private LinearLayout fjK;
    private bd fjL;
    private HeadImageView fjx;
    private TextView fjy;
    private RelativeLayout fjz;
    private boolean fjF = false;
    private View.OnClickListener aWI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fjC) {
                g.this.br(view);
            } else if (view == g.this.fjx || view == g.this.fjy || view == g.this.fjD) {
                g.this.bs(view);
            } else if (view == g.this.fjA) {
                g.this.aYo();
            }
        }
    };
    private CustomMessageListener anW = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fjL != null && g.this.fjL.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fjL.rM())) {
                    g.this.a(kVar.eQa == 0, kVar.eQb.aRU());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.abX = tbPageContext;
        this.eiG = p(tbPageContext);
        initView();
        q(this.abX.getUniqueId());
        frameLayout.addView(this.eiG);
    }

    private View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fjz = (RelativeLayout) this.eiG.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fjx = (HeadImageView) this.eiG.findViewById(d.g.pbVideoFullPhoto);
        this.fjx.setOnClickListener(this.aWI);
        this.fjK = (LinearLayout) this.eiG.findViewById(d.g.pbVideoFullNameLayout);
        aj.j(this.fjK, d.f.video_author_bg);
        this.fjy = (TextView) this.eiG.findViewById(d.g.pbVideoFullUserName);
        this.fjy.setOnClickListener(this.aWI);
        this.fjA = (TextView) this.eiG.findViewById(d.g.pbVideoFullAttention);
        this.fjA.setOnClickListener(this.aWI);
        this.fjB = (TextView) this.eiG.findViewById(d.g.pbVideoFullZanCount);
        this.fjC = (ImageView) this.eiG.findViewById(d.g.pbVideoFullZanLabel);
        this.fjC.setOnClickListener(this.aWI);
        this.fjD = (ImageView) this.eiG.findViewById(d.g.pbVideoFullChannelIcon);
        this.fjE = (PbVideoFullUserInfoLikeButton) this.eiG.findViewById(d.g.pbVideoFullLikeButton);
        this.fjE.setTextSize(0, l.f(this.abX.getPageActivity(), d.e.tbds30));
        this.fjH = new f(this.abX, this.fjE);
        this.fjx.setRadius(l.f(this.abX.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(View view) {
        if (this.fjJ != null) {
            this.fjJ.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        if (this.fjF) {
            if (this.boZ != null) {
                this.abX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.abX.getPageActivity(), this.boZ.channelId, 2)));
            }
        } else if (this.fjI != null) {
            this.fjI.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYo() {
        if (this.fjF) {
            if (!l.hy()) {
                this.abX.showToast(d.j.no_network_guide);
            } else if (this.boZ != null && this.boZ.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aR(this.abX.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0059a.a(this.boZ.channelId, this.abX.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, com.baidu.tieba.pb.data.l lVar) {
        this.fjL = bdVar;
        a(lVar.aRV(), lVar.aRU());
        if (bdVar.sA() != null) {
            this.fjF = true;
            this.fjE.setVisibility(8);
            this.fjA.setVisibility(0);
            ac(bdVar);
        } else {
            this.fjF = false;
            this.fjE.setVisibility(0);
            this.fjA.setVisibility(8);
            o(postData);
        }
        if (P(bdVar)) {
            this.fjA.setVisibility(8);
            this.fjE.setVisibility(8);
        }
    }

    private boolean P(bd bdVar) {
        if (bdVar == null || bdVar.rv() == null || bdVar.rv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rv().getUserId());
    }

    private void o(PostData postData) {
        this.fjD.setVisibility(8);
        this.fjx.setUserId(postData.rv().getUserId());
        this.fjx.setUserName(postData.rv().getUserName());
        this.fjx.setIsBigV(postData.rv().isBigV());
        this.fjy.setText(postData.rv().getUserName());
        this.fjy.setTag(postData.rv().getUserId());
        this.fjx.startLoad(postData.rv().getPortrait(), 28, false);
        this.fjH.a(postData.rv());
    }

    private void ac(bd bdVar) {
        this.fjD.setVisibility(0);
        this.boZ = bdVar.sA();
        if (this.boZ.aaS == 1) {
            this.fjG = 0;
        } else {
            this.fjG = this.boZ.aaS;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fjG = 2;
        }
        this.fjy.setText(this.boZ.channelName);
        this.fjx.startLoad(this.boZ.channelAvatar, 10, false);
        l(this.fjG, this.boZ.channelId);
    }

    public void l(int i, long j) {
        if (this.boZ != null && j > 0 && j == this.boZ.channelId) {
            if (i == 1) {
                this.fjA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fjA, d.C0096d.cp_bg_line_d_alpha80);
                this.fjA.setClickable(false);
                this.fjA.setText(d.j.has_ordered_channel);
                return;
            }
            this.fjA.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fjA, d.C0096d.cp_cont_i);
            this.fjA.setClickable(true);
            this.fjA.setText(d.j.order_video_channel);
        }
    }

    public void Y(float f) {
        this.fjz.setAlpha(f);
    }

    public View aYp() {
        return this.fjz;
    }

    public void dE(int i) {
        if (this.fjE != null) {
            this.fjE.onChangeSkinType(i);
        }
        if (this.fjB != null) {
            aj.i(this.fjB, d.C0096d.cp_cont_i);
        }
        if (this.fjG == 1) {
            aj.i(this.fjA, d.C0096d.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.fjA, d.C0096d.cp_cont_i);
        }
        if (this.fjy != null) {
            aj.i(this.fjy, d.C0096d.cp_cont_i);
        }
        if (this.fjD != null) {
            aj.j(this.fjD, d.f.icon_weiba);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.fjI = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fjJ = onClickListener;
    }

    public void q(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anW != null) {
            this.anW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fjB.setText(am.w(j));
        if (z) {
            this.fjC.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fjC.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anW);
    }
}
