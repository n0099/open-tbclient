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
    private TbPageContext<?> acp;
    private bq bfT;
    private View dOx;
    private HeadImageView eXj;
    private TextView eXk;
    private RelativeLayout eXl;
    private TextView eXm;
    private TextView eXn;
    private ImageView eXo;
    private ImageView eXp;
    private PbVideoFullUserInfoLikeButton eXq;
    public int eXs;
    private f eXt;
    private View.OnClickListener eXu;
    private View.OnClickListener eXv;
    private LinearLayout eXw;
    private View eXx;
    private bl eXy;
    private boolean eXr = false;
    private View.OnClickListener aSY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eXo) {
                g.this.bj(view);
            } else if (view == g.this.eXj || view == g.this.eXk || view == g.this.eXp) {
                g.this.bk(view);
            } else if (view == g.this.eXm) {
                g.this.aVT();
            }
        }
    };
    private CustomMessageListener aoP = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.l) && g.this.eXy != null && g.this.eXy.getId() != null) {
                com.baidu.tieba.pb.data.l lVar = (com.baidu.tieba.pb.data.l) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(lVar.pid) && lVar.pid.equals(g.this.eXy.rV())) {
                    g.this.a(lVar.eEA == 0, lVar.eEB.getPraiseNum());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.acp = tbPageContext;
        this.dOx = t(tbPageContext);
        initView();
        o(this.acp.getUniqueId());
        frameLayout.addView(this.dOx);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eXl = (RelativeLayout) this.dOx.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eXj = (HeadImageView) this.dOx.findViewById(d.h.pbVideoFullPhoto);
        this.eXj.setOnClickListener(this.aSY);
        this.eXw = (LinearLayout) this.dOx.findViewById(d.h.pbVideoFullNameLayout);
        this.eXx = com.baidu.tbadk.ala.b.nC().h(this.acp.getPageActivity(), 6);
        if (this.eXx != null) {
            this.eXx.setVisibility(8);
            this.eXw.addView(this.eXx);
        }
        this.eXk = (TextView) this.dOx.findViewById(d.h.pbVideoFullUserName);
        this.eXk.setOnClickListener(this.aSY);
        this.eXm = (TextView) this.dOx.findViewById(d.h.pbVideoFullAttention);
        this.eXm.setOnClickListener(this.aSY);
        this.eXn = (TextView) this.dOx.findViewById(d.h.pbVideoFullZanCount);
        this.eXo = (ImageView) this.dOx.findViewById(d.h.pbVideoFullZanLabel);
        this.eXo.setOnClickListener(this.aSY);
        this.eXp = (ImageView) this.dOx.findViewById(d.h.pbVideoFullChannelIcon);
        this.eXq = (PbVideoFullUserInfoLikeButton) this.dOx.findViewById(d.h.pbVideoFullLikeButton);
        this.eXt = new f(this.acp, this.eXq);
        this.eXj.setRadius(com.baidu.adp.lib.util.k.g(this.acp.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view) {
        if (this.eXv != null) {
            this.eXv.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view) {
        if (this.eXr) {
            if (this.bfT != null) {
                this.acp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.acp.getPageActivity(), this.bfT.channelId, 2)));
            }
        } else if (this.eXu != null) {
            this.eXu.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVT() {
        if (this.eXr) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                this.acp.showToast(d.l.no_network_guide);
            } else if (this.bfT != null && this.bfT.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    aw.aN(this.acp.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0041a.a(this.bfT.channelId, this.acp.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        this.eXy = blVar;
        a(mVar.aPM(), mVar.getPraiseNum());
        if (blVar.sJ() != null) {
            this.eXr = true;
            this.eXq.setVisibility(8);
            this.eXm.setVisibility(0);
            Y(blVar);
        } else {
            this.eXr = false;
            this.eXq.setVisibility(0);
            this.eXm.setVisibility(8);
            o(postData);
        }
        if (O(blVar)) {
            this.eXm.setVisibility(8);
            this.eXq.setVisibility(8);
        }
    }

    private boolean O(bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    private void o(PostData postData) {
        this.eXp.setVisibility(8);
        this.eXj.setUserId(postData.getAuthor().getUserId());
        this.eXj.setUserName(postData.getAuthor().getUserName());
        this.eXj.setIsBigV(postData.getAuthor().isBigV());
        this.eXk.setText(postData.getAuthor().getUserName());
        this.eXk.setTag(postData.getAuthor().getUserId());
        this.eXj.c(postData.getAuthor().getPortrait(), 28, false);
        this.eXt.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eXx != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eXx.setVisibility(8);
                return;
            }
            this.eXx.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.Ro = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eXx.setTag(aVar);
        }
    }

    private void Y(bl blVar) {
        this.eXp.setVisibility(0);
        this.bfT = blVar.sJ();
        if (this.bfT.abl == 1) {
            this.eXs = 0;
        } else {
            this.eXs = this.bfT.abl;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eXs = 2;
        }
        this.eXk.setText(this.bfT.channelName);
        this.eXj.c(this.bfT.channelAvatar, 10, false);
        j(this.eXs, this.bfT.channelId);
    }

    public void j(int i, long j) {
        if (this.bfT != null && j > 0 && j == this.bfT.channelId) {
            if (i == 1) {
                this.eXm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ai.i(this.eXm, d.e.cp_bg_line_d_alpha80);
                this.eXm.setClickable(false);
                this.eXm.setText(d.l.has_ordered_channel);
                return;
            }
            this.eXm.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eXm, d.e.cp_cont_i);
            this.eXm.setClickable(true);
            this.eXm.setText(d.l.order_video_channel);
        }
    }

    public void ah(float f) {
        this.eXl.setAlpha(f);
    }

    public View aVU() {
        return this.eXl;
    }

    public void dt(int i) {
        if (this.eXq != null) {
            this.eXq.onChangeSkinType(i);
        }
        if (this.eXn != null) {
            ai.i(this.eXn, d.e.cp_cont_i);
        }
        if (this.eXs == 1) {
            ai.i(this.eXm, d.e.cp_bg_line_d_alpha80);
        } else {
            ai.i(this.eXm, d.e.cp_cont_i);
        }
        if (this.eXk != null) {
            ai.i(this.eXk, d.e.cp_cont_i);
        }
        if (this.eXp != null) {
            ai.j(this.eXp, d.g.icon_weiba);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.eXu = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.eXv = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aoP != null) {
            this.aoP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eXn.setText(al.x(j));
        if (z) {
            this.eXo.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eXo.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aoP);
    }
}
