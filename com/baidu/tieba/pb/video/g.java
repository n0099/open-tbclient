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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private TbPageContext<?> aRR;
    private bj chn;
    private bd cqQ;
    private View fca;
    private HeadImageView gbC;
    private TextView gbD;
    private RelativeLayout gbE;
    private TextView gbF;
    private TextView gbG;
    private ImageView gbH;
    private ImageView gbI;
    private PbVideoFullUserInfoLikeButton gbJ;
    public int gbL;
    private f gbM;
    private View.OnClickListener gbN;
    private View.OnClickListener gbO;
    private LinearLayout gbP;
    private boolean gbK = false;
    private View.OnClickListener bMV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gbH) {
                g.this.cD(view);
            } else if (view == g.this.gbC || view == g.this.gbD || view == g.this.gbI) {
                g.this.cE(view);
            } else if (view == g.this.gbF) {
                g.this.bhl();
            }
        }
    };
    private CustomMessageListener bdV = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.cqQ != null && g.this.cqQ.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.cqQ.zE())) {
                    g.this.a(iVar.fHX == 0, iVar.fHY.baV());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aRR = tbPageContext;
        this.fca = p(tbPageContext);
        initView();
        o(this.aRR.getUniqueId());
        frameLayout.addView(this.fca);
    }

    private View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gbE = (RelativeLayout) this.fca.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.gbC = (HeadImageView) this.fca.findViewById(d.g.pbVideoFullPhoto);
        this.gbC.setOnClickListener(this.bMV);
        this.gbP = (LinearLayout) this.fca.findViewById(d.g.pbVideoFullNameLayout);
        aj.s(this.gbP, d.f.video_author_bg);
        this.gbD = (TextView) this.fca.findViewById(d.g.pbVideoFullUserName);
        this.gbD.setOnClickListener(this.bMV);
        this.gbF = (TextView) this.fca.findViewById(d.g.pbVideoFullAttention);
        this.gbF.setOnClickListener(this.bMV);
        this.gbG = (TextView) this.fca.findViewById(d.g.pbVideoFullZanCount);
        this.gbH = (ImageView) this.fca.findViewById(d.g.pbVideoFullZanLabel);
        this.gbH.setOnClickListener(this.bMV);
        this.gbI = (ImageView) this.fca.findViewById(d.g.pbVideoFullChannelIcon);
        this.gbJ = (PbVideoFullUserInfoLikeButton) this.fca.findViewById(d.g.pbVideoFullLikeButton);
        this.gbJ.setTextSize(0, l.t(this.aRR.getPageActivity(), d.e.tbds30));
        this.gbM = new f(this.aRR, this.gbJ);
        this.gbC.setRadius(l.t(this.aRR.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
        if (this.gbO != null) {
            this.gbO.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(View view) {
        if (this.gbK) {
            if (this.chn != null) {
                this.aRR.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.aRR.getPageActivity(), this.chn.channelId, 2)));
            }
        } else if (this.gbN != null) {
            this.gbN.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        if (this.gbK) {
            if (!l.pa()) {
                this.aRR.showToast(d.j.no_network_guide);
            } else if (this.chn != null && this.chn.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ay.aZ(this.aRR.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0094a.a(this.chn.channelId, this.aRR.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, j jVar) {
        this.cqQ = bdVar;
        a(jVar.baX(), jVar.baV());
        if (bdVar.Ao() != null) {
            this.gbK = true;
            this.gbJ.setVisibility(8);
            this.gbF.setVisibility(0);
            ae(bdVar);
        } else {
            this.gbK = false;
            this.gbJ.setVisibility(0);
            this.gbF.setVisibility(8);
            o(postData);
        }
        if (ab(bdVar)) {
            this.gbF.setVisibility(8);
            this.gbJ.setVisibility(8);
        }
    }

    private boolean ab(bd bdVar) {
        if (bdVar == null || bdVar.zn() == null || bdVar.zn().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.zn().getUserId());
    }

    private void o(PostData postData) {
        this.gbI.setVisibility(8);
        this.gbC.setUserId(postData.zn().getUserId());
        this.gbC.setUserName(postData.zn().getUserName());
        this.gbC.setIsBigV(postData.zn().isBigV());
        this.gbD.setText(postData.zn().getUserName());
        this.gbD.setTag(postData.zn().getUserId());
        this.gbC.startLoad(postData.zn().getPortrait(), 28, false);
        this.gbM.a(postData.zn());
    }

    private void ae(bd bdVar) {
        this.gbI.setVisibility(0);
        this.chn = bdVar.Ao();
        if (this.chn.aQQ == 1) {
            this.gbL = 0;
        } else {
            this.gbL = this.chn.aQQ;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gbL = 2;
        }
        this.gbD.setText(this.chn.channelName);
        this.gbC.startLoad(this.chn.channelAvatar, 10, false);
        i(this.gbL, this.chn.channelId);
    }

    public void i(int i, long j) {
        if (this.chn != null && j > 0 && j == this.chn.channelId) {
            if (i == 1) {
                this.gbF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.gbF, d.C0140d.cp_bg_line_d_alpha80);
                this.gbF.setClickable(false);
                this.gbF.setText(d.j.has_ordered_channel);
                return;
            }
            this.gbF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbF, d.C0140d.cp_cont_i);
            this.gbF.setClickable(true);
            this.gbF.setText(d.j.order_video_channel);
        }
    }

    public void at(float f) {
        this.gbE.setAlpha(f);
    }

    public View bhm() {
        return this.gbE;
    }

    public void gB(int i) {
        if (this.gbJ != null) {
            this.gbJ.onChangeSkinType(i);
        }
        if (this.gbG != null) {
            aj.r(this.gbG, d.C0140d.cp_cont_i);
        }
        if (this.gbL == 1) {
            aj.r(this.gbF, d.C0140d.cp_bg_line_d_alpha80);
        } else {
            aj.r(this.gbF, d.C0140d.cp_cont_i);
        }
        if (this.gbD != null) {
            aj.r(this.gbD, d.C0140d.cp_cont_i);
        }
        if (this.gbI != null) {
            aj.s(this.gbI, d.f.icon_weiba);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.gbN = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.gbO = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdV != null) {
            this.bdV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.gbG.setText(am.F(j));
        if (z) {
            this.gbH.setImageResource(d.f.icon_floor_praised);
        } else {
            this.gbH.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bdV);
    }
}
