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
    private TbPageContext<?> aQs;
    private bj ccN;
    private View eWL;
    private ImageView fYA;
    private PbVideoFullUserInfoLikeButton fYB;
    public int fYD;
    private f fYE;
    private View.OnClickListener fYF;
    private View.OnClickListener fYG;
    private LinearLayout fYH;
    private bd fYI;
    private HeadImageView fYu;
    private TextView fYv;
    private RelativeLayout fYw;
    private TextView fYx;
    private TextView fYy;
    private ImageView fYz;
    private boolean fYC = false;
    private View.OnClickListener bKR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fYz) {
                g.this.cE(view);
            } else if (view == g.this.fYu || view == g.this.fYv || view == g.this.fYA) {
                g.this.cF(view);
            } else if (view == g.this.fYx) {
                g.this.bfL();
            }
        }
    };
    private CustomMessageListener bcf = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fYI != null && g.this.fYI.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fYI.zk())) {
                    g.this.a(kVar.fEA == 0, kVar.fEB.aZq());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aQs = tbPageContext;
        this.eWL = o(tbPageContext);
        initView();
        o(this.aQs.getUniqueId());
        frameLayout.addView(this.eWL);
    }

    private View o(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fYw = (RelativeLayout) this.eWL.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fYu = (HeadImageView) this.eWL.findViewById(d.g.pbVideoFullPhoto);
        this.fYu.setOnClickListener(this.bKR);
        this.fYH = (LinearLayout) this.eWL.findViewById(d.g.pbVideoFullNameLayout);
        aj.s(this.fYH, d.f.video_author_bg);
        this.fYv = (TextView) this.eWL.findViewById(d.g.pbVideoFullUserName);
        this.fYv.setOnClickListener(this.bKR);
        this.fYx = (TextView) this.eWL.findViewById(d.g.pbVideoFullAttention);
        this.fYx.setOnClickListener(this.bKR);
        this.fYy = (TextView) this.eWL.findViewById(d.g.pbVideoFullZanCount);
        this.fYz = (ImageView) this.eWL.findViewById(d.g.pbVideoFullZanLabel);
        this.fYz.setOnClickListener(this.bKR);
        this.fYA = (ImageView) this.eWL.findViewById(d.g.pbVideoFullChannelIcon);
        this.fYB = (PbVideoFullUserInfoLikeButton) this.eWL.findViewById(d.g.pbVideoFullLikeButton);
        this.fYB.setTextSize(0, l.s(this.aQs.getPageActivity(), d.e.tbds30));
        this.fYE = new f(this.aQs, this.fYB);
        this.fYu.setRadius(l.s(this.aQs.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(View view) {
        if (this.fYG != null) {
            this.fYG.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.fYC) {
            if (this.ccN != null) {
                this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aQs.getPageActivity(), this.ccN.channelId, 2)));
            }
        } else if (this.fYF != null) {
            this.fYF.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfL() {
        if (this.fYC) {
            if (!l.pa()) {
                this.aQs.showToast(d.j.no_network_guide);
            } else if (this.ccN != null && this.ccN.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.ba(this.aQs.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0071a.a(this.ccN.channelId, this.aQs.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, com.baidu.tieba.pb.data.l lVar) {
        this.fYI = bdVar;
        a(lVar.aZs(), lVar.aZq());
        if (bdVar.zV() != null) {
            this.fYC = true;
            this.fYB.setVisibility(8);
            this.fYx.setVisibility(0);
            ab(bdVar);
        } else {
            this.fYC = false;
            this.fYB.setVisibility(0);
            this.fYx.setVisibility(8);
            o(postData);
        }
        if (Y(bdVar)) {
            this.fYx.setVisibility(8);
            this.fYB.setVisibility(8);
        }
    }

    private boolean Y(bd bdVar) {
        if (bdVar == null || bdVar.yT() == null || bdVar.yT().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.yT().getUserId());
    }

    private void o(PostData postData) {
        this.fYA.setVisibility(8);
        this.fYu.setUserId(postData.yT().getUserId());
        this.fYu.setUserName(postData.yT().getUserName());
        this.fYu.setIsBigV(postData.yT().isBigV());
        this.fYv.setText(postData.yT().getUserName());
        this.fYv.setTag(postData.yT().getUserId());
        this.fYu.startLoad(postData.yT().getPortrait(), 28, false);
        this.fYE.a(postData.yT());
    }

    private void ab(bd bdVar) {
        this.fYA.setVisibility(0);
        this.ccN = bdVar.zV();
        if (this.ccN.aPt == 1) {
            this.fYD = 0;
        } else {
            this.fYD = this.ccN.aPt;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fYD = 2;
        }
        this.fYv.setText(this.ccN.channelName);
        this.fYu.startLoad(this.ccN.channelAvatar, 10, false);
        j(this.fYD, this.ccN.channelId);
    }

    public void j(int i, long j) {
        if (this.ccN != null && j > 0 && j == this.ccN.channelId) {
            if (i == 1) {
                this.fYx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.fYx, d.C0108d.cp_bg_line_d_alpha80);
                this.fYx.setClickable(false);
                this.fYx.setText(d.j.has_ordered_channel);
                return;
            }
            this.fYx.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fYx, d.C0108d.cp_cont_i);
            this.fYx.setClickable(true);
            this.fYx.setText(d.j.order_video_channel);
        }
    }

    public void an(float f) {
        this.fYw.setAlpha(f);
    }

    public View bfM() {
        return this.fYw;
    }

    public void gz(int i) {
        if (this.fYB != null) {
            this.fYB.onChangeSkinType(i);
        }
        if (this.fYy != null) {
            aj.r(this.fYy, d.C0108d.cp_cont_i);
        }
        if (this.fYD == 1) {
            aj.r(this.fYx, d.C0108d.cp_bg_line_d_alpha80);
        } else {
            aj.r(this.fYx, d.C0108d.cp_cont_i);
        }
        if (this.fYv != null) {
            aj.r(this.fYv, d.C0108d.cp_cont_i);
        }
        if (this.fYA != null) {
            aj.s(this.fYA, d.f.icon_weiba);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.fYF = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.fYG = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bcf != null) {
            this.bcf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bcf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fYy.setText(am.F(j));
        if (z) {
            this.fYz.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fYz.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bcf);
    }
}
