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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class g {
    private TbPageContext<?> aaS;
    private bq beI;
    private View dNg;
    private HeadImageView eVX;
    private TextView eVY;
    private RelativeLayout eVZ;
    private TextView eWa;
    private TextView eWb;
    private ImageView eWc;
    private ImageView eWd;
    private PbVideoFullUserInfoLikeButton eWe;
    public int eWg;
    private f eWh;
    private View.OnClickListener eWi;
    private View.OnClickListener eWj;
    private LinearLayout eWk;
    private View eWl;
    private bl eWm;
    private boolean eWf = false;
    private View.OnClickListener aRM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eWc) {
                g.this.bj(view);
            } else if (view == g.this.eVX || view == g.this.eVY || view == g.this.eWd) {
                g.this.bk(view);
            } else if (view == g.this.eWa) {
                g.this.aVI();
            }
        }
    };
    private CustomMessageListener anw = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.l) && g.this.eWm != null && g.this.eWm.getId() != null) {
                com.baidu.tieba.pb.data.l lVar = (com.baidu.tieba.pb.data.l) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(lVar.pid) && lVar.pid.equals(g.this.eWm.rL())) {
                    g.this.a(lVar.eDn == 0, lVar.eDo.getPraiseNum());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aaS = tbPageContext;
        this.dNg = t(tbPageContext);
        initView();
        o(this.aaS.getUniqueId());
        frameLayout.addView(this.dNg);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eVZ = (RelativeLayout) this.dNg.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eVX = (HeadImageView) this.dNg.findViewById(d.h.pbVideoFullPhoto);
        this.eVX.setOnClickListener(this.aRM);
        this.eWk = (LinearLayout) this.dNg.findViewById(d.h.pbVideoFullNameLayout);
        this.eWl = com.baidu.tbadk.ala.b.ns().h(this.aaS.getPageActivity(), 6);
        if (this.eWl != null) {
            this.eWl.setVisibility(8);
            this.eWk.addView(this.eWl);
        }
        this.eVY = (TextView) this.dNg.findViewById(d.h.pbVideoFullUserName);
        this.eVY.setOnClickListener(this.aRM);
        this.eWa = (TextView) this.dNg.findViewById(d.h.pbVideoFullAttention);
        this.eWa.setOnClickListener(this.aRM);
        this.eWb = (TextView) this.dNg.findViewById(d.h.pbVideoFullZanCount);
        this.eWc = (ImageView) this.dNg.findViewById(d.h.pbVideoFullZanLabel);
        this.eWc.setOnClickListener(this.aRM);
        this.eWd = (ImageView) this.dNg.findViewById(d.h.pbVideoFullChannelIcon);
        this.eWe = (PbVideoFullUserInfoLikeButton) this.dNg.findViewById(d.h.pbVideoFullLikeButton);
        this.eWh = new f(this.aaS, this.eWe);
        this.eVX.setRadius(com.baidu.adp.lib.util.k.g(this.aaS.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view) {
        if (this.eWj != null) {
            this.eWj.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view) {
        if (this.eWf) {
            if (this.beI != null) {
                this.aaS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.aaS.getPageActivity(), this.beI.channelId, 2)));
            }
        } else if (this.eWi != null) {
            this.eWi.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVI() {
        if (this.eWf) {
            if (!com.baidu.adp.lib.util.k.hy()) {
                this.aaS.showToast(d.l.no_network_guide);
            } else if (this.beI != null && this.beI.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    aw.aM(this.aaS.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0041a.a(this.beI.channelId, this.aaS.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        this.eWm = blVar;
        a(mVar.aPB(), mVar.getPraiseNum());
        if (blVar.sz() != null) {
            this.eWf = true;
            this.eWe.setVisibility(8);
            this.eWa.setVisibility(0);
            Y(blVar);
        } else {
            this.eWf = false;
            this.eWe.setVisibility(0);
            this.eWa.setVisibility(8);
            o(postData);
        }
        if (O(blVar)) {
            this.eWa.setVisibility(8);
            this.eWe.setVisibility(8);
        }
    }

    private boolean O(bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    private void o(PostData postData) {
        this.eWd.setVisibility(8);
        this.eVX.setUserId(postData.getAuthor().getUserId());
        this.eVX.setUserName(postData.getAuthor().getUserName());
        this.eVX.setIsBigV(postData.getAuthor().isBigV());
        this.eVY.setText(postData.getAuthor().getUserName());
        this.eVY.setTag(postData.getAuthor().getUserId());
        this.eVX.c(postData.getAuthor().getPortrait(), 28, false);
        this.eWh.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eWl != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eWl.setVisibility(8);
                return;
            }
            this.eWl.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.PQ = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eWl.setTag(aVar);
        }
    }

    private void Y(bl blVar) {
        this.eWd.setVisibility(0);
        this.beI = blVar.sz();
        if (this.beI.ZP == 1) {
            this.eWg = 0;
        } else {
            this.eWg = this.beI.ZP;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eWg = 2;
        }
        this.eVY.setText(this.beI.channelName);
        this.eVX.c(this.beI.channelAvatar, 10, false);
        j(this.eWg, this.beI.channelId);
    }

    public void j(int i, long j) {
        if (this.beI != null && j > 0 && j == this.beI.channelId) {
            if (i == 1) {
                this.eWa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ai.i(this.eWa, d.e.cp_bg_line_d_alpha80);
                this.eWa.setClickable(false);
                this.eWa.setText(d.l.has_ordered_channel);
                return;
            }
            this.eWa.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eWa, d.e.cp_cont_i);
            this.eWa.setClickable(true);
            this.eWa.setText(d.l.order_video_channel);
        }
    }

    public void ah(float f) {
        this.eVZ.setAlpha(f);
    }

    public View aVJ() {
        return this.eVZ;
    }

    public void dr(int i) {
        if (this.eWe != null) {
            this.eWe.onChangeSkinType(i);
        }
        if (this.eWb != null) {
            ai.i(this.eWb, d.e.cp_cont_i);
        }
        if (this.eWg == 1) {
            ai.i(this.eWa, d.e.cp_bg_line_d_alpha80);
        } else {
            ai.i(this.eWa, d.e.cp_cont_i);
        }
        if (this.eVY != null) {
            ai.i(this.eVY, d.e.cp_cont_i);
        }
        if (this.eWd != null) {
            ai.j(this.eWd, d.g.icon_weiba);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.eWi = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.eWj = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anw != null) {
            this.anw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eWb.setText(al.x(j));
        if (z) {
            this.eWc.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eWc.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anw);
    }
}
