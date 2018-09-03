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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private bh bBS;
    private bb bSA;
    private View eQS;
    private TextView fMA;
    private ImageView fMB;
    private ImageView fMC;
    private PbVideoFullUserInfoLikeButton fMD;
    public int fMF;
    private f fMG;
    private View.OnClickListener fMH;
    private View.OnClickListener fMI;
    private LinearLayout fMJ;
    private HeadImageView fMw;
    private TextView fMx;
    private RelativeLayout fMy;
    private TextView fMz;
    private TbPageContext<?> mContext;
    private boolean fME = false;
    private View.OnClickListener bpZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fMB) {
                g.this.bq(view);
            } else if (view == g.this.fMw || view == g.this.fMx || view == g.this.fMC) {
                g.this.br(view);
            } else if (view == g.this.fMz) {
                g.this.bgf();
            }
        }
    };
    private CustomMessageListener axF = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.bSA != null && g.this.bSA.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.bSA.vA())) {
                    g.this.a(iVar.ftf == 0, iVar.ftg.aZM());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.eQS = q(tbPageContext);
        initView();
        p(this.mContext.getUniqueId());
        frameLayout.addView(this.eQS);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fMy = (RelativeLayout) this.eQS.findViewById(f.g.pbVideoFullUserInfoPanel);
        this.fMw = (HeadImageView) this.eQS.findViewById(f.g.pbVideoFullPhoto);
        this.fMw.setOnClickListener(this.bpZ);
        this.fMJ = (LinearLayout) this.eQS.findViewById(f.g.pbVideoFullNameLayout);
        am.i(this.fMJ, f.C0146f.video_author_bg);
        this.fMx = (TextView) this.eQS.findViewById(f.g.pbVideoFullUserName);
        this.fMx.setOnClickListener(this.bpZ);
        this.fMz = (TextView) this.eQS.findViewById(f.g.pbVideoFullAttention);
        this.fMz.setOnClickListener(this.bpZ);
        this.fMA = (TextView) this.eQS.findViewById(f.g.pbVideoFullZanCount);
        this.fMB = (ImageView) this.eQS.findViewById(f.g.pbVideoFullZanLabel);
        this.fMB.setOnClickListener(this.bpZ);
        this.fMC = (ImageView) this.eQS.findViewById(f.g.pbVideoFullChannelIcon);
        this.fMD = (PbVideoFullUserInfoLikeButton) this.eQS.findViewById(f.g.pbVideoFullLikeButton);
        this.fMD.setTextSize(0, l.f(this.mContext.getPageActivity(), f.e.tbds30));
        this.fMG = new f(this.mContext, this.fMD);
        this.fMw.setRadius(l.f(this.mContext.getPageActivity(), f.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(View view) {
        if (this.fMI != null) {
            this.fMI.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(View view) {
        if (this.fME) {
            if (this.bBS != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bBS.channelId, 2)));
            }
        } else if (this.fMH != null) {
            this.fMH.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgf() {
        if (this.fME) {
            if (!l.jV()) {
                this.mContext.showToast(f.j.no_network_guide);
            } else if (this.bBS != null && this.bBS.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    com.baidu.tbadk.core.util.bb.aT(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0099a.a(this.bBS.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, j jVar) {
        this.bSA = bbVar;
        a(jVar.aZO(), jVar.aZM());
        if (bbVar.wk() != null) {
            this.fME = true;
            this.fMD.setVisibility(8);
            this.fMz.setVisibility(0);
            ao(bbVar);
        } else {
            this.fME = false;
            this.fMD.setVisibility(0);
            this.fMz.setVisibility(8);
            n(postData);
        }
        if (al(bbVar)) {
            this.fMz.setVisibility(8);
            this.fMD.setVisibility(8);
        }
    }

    private boolean al(bb bbVar) {
        if (bbVar == null || bbVar.vj() == null || bbVar.vj().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.vj().getUserId());
    }

    private void n(PostData postData) {
        this.fMC.setVisibility(8);
        this.fMw.setUserId(postData.vj().getUserId());
        this.fMw.setUserName(postData.vj().getUserName());
        this.fMw.setIsBigV(postData.vj().isBigV());
        this.fMx.setText(postData.vj().getName_show());
        this.fMx.setTag(postData.vj().getUserId());
        this.fMw.startLoad(postData.vj().getPortrait(), 28, false);
        this.fMG.a(postData.vj());
    }

    private void ao(bb bbVar) {
        this.fMC.setVisibility(0);
        this.bBS = bbVar.wk();
        if (this.bBS.akk == 1) {
            this.fMF = 0;
        } else {
            this.fMF = this.bBS.akk;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fMF = 2;
        }
        this.fMx.setText(this.bBS.channelName);
        this.fMw.startLoad(this.bBS.channelAvatar, 10, false);
        l(this.fMF, this.bBS.channelId);
    }

    public void l(int i, long j) {
        if (this.bBS != null && j > 0 && j == this.bBS.channelId) {
            if (i == 1) {
                this.fMz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.fMz, f.d.cp_bg_line_d_alpha80);
                this.fMz.setClickable(false);
                this.fMz.setText(f.j.has_ordered_channel);
                return;
            }
            this.fMz.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMz, f.d.cp_cont_i);
            this.fMz.setClickable(true);
            this.fMz.setText(f.j.order_video_channel);
        }
    }

    public void ar(float f) {
        this.fMy.setAlpha(f);
    }

    public View bgg() {
        return this.fMy;
    }

    public void dF(int i) {
        if (this.fMD != null) {
            this.fMD.onChangeSkinType(i);
        }
        if (this.fMA != null) {
            am.h(this.fMA, f.d.cp_cont_i);
        }
        if (this.fMF == 1) {
            am.h(this.fMz, f.d.cp_bg_line_d_alpha80);
        } else {
            am.h(this.fMz, f.d.cp_cont_i);
        }
        if (this.fMx != null) {
            am.h(this.fMx, f.d.cp_cont_i);
        }
        if (this.fMC != null) {
            am.i(this.fMC, f.C0146f.icon_weiba);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        this.fMH = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.fMI = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.axF != null) {
            this.axF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.axF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fMA.setText(ap.D(j));
        if (z) {
            this.fMB.setImageResource(f.C0146f.icon_floor_praised);
        } else {
            this.fMB.setImageResource(f.C0146f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.axF);
    }
}
