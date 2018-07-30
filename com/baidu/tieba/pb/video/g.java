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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private bh bBQ;
    private bb bSB;
    private View eQX;
    private HeadImageView fMD;
    private TextView fME;
    private RelativeLayout fMF;
    private TextView fMG;
    private TextView fMH;
    private ImageView fMI;
    private ImageView fMJ;
    private PbVideoFullUserInfoLikeButton fMK;
    public int fMM;
    private f fMN;
    private View.OnClickListener fMO;
    private View.OnClickListener fMP;
    private LinearLayout fMQ;
    private TbPageContext<?> mContext;
    private boolean fML = false;
    private View.OnClickListener bpX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fMI) {
                g.this.bq(view);
            } else if (view == g.this.fMD || view == g.this.fME || view == g.this.fMJ) {
                g.this.br(view);
            } else if (view == g.this.fMG) {
                g.this.bgk();
            }
        }
    };
    private CustomMessageListener axI = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.bSB != null && g.this.bSB.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.bSB.vB())) {
                    g.this.a(iVar.ftm == 0, iVar.ftn.aZR());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.eQX = q(tbPageContext);
        initView();
        p(this.mContext.getUniqueId());
        frameLayout.addView(this.eQX);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fMF = (RelativeLayout) this.eQX.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fMD = (HeadImageView) this.eQX.findViewById(d.g.pbVideoFullPhoto);
        this.fMD.setOnClickListener(this.bpX);
        this.fMQ = (LinearLayout) this.eQX.findViewById(d.g.pbVideoFullNameLayout);
        am.i(this.fMQ, d.f.video_author_bg);
        this.fME = (TextView) this.eQX.findViewById(d.g.pbVideoFullUserName);
        this.fME.setOnClickListener(this.bpX);
        this.fMG = (TextView) this.eQX.findViewById(d.g.pbVideoFullAttention);
        this.fMG.setOnClickListener(this.bpX);
        this.fMH = (TextView) this.eQX.findViewById(d.g.pbVideoFullZanCount);
        this.fMI = (ImageView) this.eQX.findViewById(d.g.pbVideoFullZanLabel);
        this.fMI.setOnClickListener(this.bpX);
        this.fMJ = (ImageView) this.eQX.findViewById(d.g.pbVideoFullChannelIcon);
        this.fMK = (PbVideoFullUserInfoLikeButton) this.eQX.findViewById(d.g.pbVideoFullLikeButton);
        this.fMK.setTextSize(0, l.f(this.mContext.getPageActivity(), d.e.tbds30));
        this.fMN = new f(this.mContext, this.fMK);
        this.fMD.setRadius(l.f(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(View view) {
        if (this.fMP != null) {
            this.fMP.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(View view) {
        if (this.fML) {
            if (this.bBQ != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bBQ.channelId, 2)));
            }
        } else if (this.fMO != null) {
            this.fMO.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgk() {
        if (this.fML) {
            if (!l.jV()) {
                this.mContext.showToast(d.j.no_network_guide);
            } else if (this.bBQ != null && this.bBQ.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.aU(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0099a.a(this.bBQ.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, j jVar) {
        this.bSB = bbVar;
        a(jVar.aZT(), jVar.aZR());
        if (bbVar.wl() != null) {
            this.fML = true;
            this.fMK.setVisibility(8);
            this.fMG.setVisibility(0);
            ao(bbVar);
        } else {
            this.fML = false;
            this.fMK.setVisibility(0);
            this.fMG.setVisibility(8);
            n(postData);
        }
        if (al(bbVar)) {
            this.fMG.setVisibility(8);
            this.fMK.setVisibility(8);
        }
    }

    private boolean al(bb bbVar) {
        if (bbVar == null || bbVar.vk() == null || bbVar.vk().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.vk().getUserId());
    }

    private void n(PostData postData) {
        this.fMJ.setVisibility(8);
        this.fMD.setUserId(postData.vk().getUserId());
        this.fMD.setUserName(postData.vk().getUserName());
        this.fMD.setIsBigV(postData.vk().isBigV());
        this.fME.setText(postData.vk().getName_show());
        this.fME.setTag(postData.vk().getUserId());
        this.fMD.startLoad(postData.vk().getPortrait(), 28, false);
        this.fMN.a(postData.vk());
    }

    private void ao(bb bbVar) {
        this.fMJ.setVisibility(0);
        this.bBQ = bbVar.wl();
        if (this.bBQ.akk == 1) {
            this.fMM = 0;
        } else {
            this.fMM = this.bBQ.akk;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fMM = 2;
        }
        this.fME.setText(this.bBQ.channelName);
        this.fMD.startLoad(this.bBQ.channelAvatar, 10, false);
        l(this.fMM, this.bBQ.channelId);
    }

    public void l(int i, long j) {
        if (this.bBQ != null && j > 0 && j == this.bBQ.channelId) {
            if (i == 1) {
                this.fMG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.fMG, d.C0140d.cp_bg_line_d_alpha80);
                this.fMG.setClickable(false);
                this.fMG.setText(d.j.has_ordered_channel);
                return;
            }
            this.fMG.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMG, d.C0140d.cp_cont_i);
            this.fMG.setClickable(true);
            this.fMG.setText(d.j.order_video_channel);
        }
    }

    public void as(float f) {
        this.fMF.setAlpha(f);
    }

    public View bgl() {
        return this.fMF;
    }

    public void dG(int i) {
        if (this.fMK != null) {
            this.fMK.onChangeSkinType(i);
        }
        if (this.fMH != null) {
            am.h(this.fMH, d.C0140d.cp_cont_i);
        }
        if (this.fMM == 1) {
            am.h(this.fMG, d.C0140d.cp_bg_line_d_alpha80);
        } else {
            am.h(this.fMG, d.C0140d.cp_cont_i);
        }
        if (this.fME != null) {
            am.h(this.fME, d.C0140d.cp_cont_i);
        }
        if (this.fMJ != null) {
            am.i(this.fMJ, d.f.icon_weiba);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        this.fMO = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.fMP = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.axI != null) {
            this.axI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.axI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fMH.setText(ap.D(j));
        if (z) {
            this.fMI.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fMI.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.axI);
    }
}
