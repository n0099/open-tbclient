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
    private TbPageContext<?> acr;
    private bq bfT;
    private View dQt;
    private HeadImageView eZc;
    private TextView eZd;
    private RelativeLayout eZe;
    private TextView eZf;
    private TextView eZg;
    private ImageView eZh;
    private ImageView eZi;
    private PbVideoFullUserInfoLikeButton eZj;
    public int eZl;
    private f eZm;
    private View.OnClickListener eZn;
    private View.OnClickListener eZo;
    private LinearLayout eZp;
    private View eZq;
    private bl eZr;
    private boolean eZk = false;
    private View.OnClickListener aSZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eZh) {
                g.this.bl(view);
            } else if (view == g.this.eZc || view == g.this.eZd || view == g.this.eZi) {
                g.this.bm(view);
            } else if (view == g.this.eZf) {
                g.this.aWA();
            }
        }
    };
    private CustomMessageListener aoQ = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.l) && g.this.eZr != null && g.this.eZr.getId() != null) {
                com.baidu.tieba.pb.data.l lVar = (com.baidu.tieba.pb.data.l) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(lVar.pid) && lVar.pid.equals(g.this.eZr.rV())) {
                    g.this.a(lVar.eGu == 0, lVar.eGv.getPraiseNum());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.acr = tbPageContext;
        this.dQt = t(tbPageContext);
        initView();
        o(this.acr.getUniqueId());
        frameLayout.addView(this.dQt);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.eZe = (RelativeLayout) this.dQt.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eZc = (HeadImageView) this.dQt.findViewById(d.h.pbVideoFullPhoto);
        this.eZc.setOnClickListener(this.aSZ);
        this.eZp = (LinearLayout) this.dQt.findViewById(d.h.pbVideoFullNameLayout);
        this.eZq = com.baidu.tbadk.ala.b.nC().h(this.acr.getPageActivity(), 6);
        if (this.eZq != null) {
            this.eZq.setVisibility(8);
            this.eZp.addView(this.eZq);
        }
        this.eZd = (TextView) this.dQt.findViewById(d.h.pbVideoFullUserName);
        this.eZd.setOnClickListener(this.aSZ);
        this.eZf = (TextView) this.dQt.findViewById(d.h.pbVideoFullAttention);
        this.eZf.setOnClickListener(this.aSZ);
        this.eZg = (TextView) this.dQt.findViewById(d.h.pbVideoFullZanCount);
        this.eZh = (ImageView) this.dQt.findViewById(d.h.pbVideoFullZanLabel);
        this.eZh.setOnClickListener(this.aSZ);
        this.eZi = (ImageView) this.dQt.findViewById(d.h.pbVideoFullChannelIcon);
        this.eZj = (PbVideoFullUserInfoLikeButton) this.dQt.findViewById(d.h.pbVideoFullLikeButton);
        this.eZm = new f(this.acr, this.eZj);
        this.eZc.setRadius(com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(View view) {
        if (this.eZo != null) {
            this.eZo.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(View view) {
        if (this.eZk) {
            if (this.bfT != null) {
                this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.acr.getPageActivity(), this.bfT.channelId, 2)));
            }
        } else if (this.eZn != null) {
            this.eZn.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWA() {
        if (this.eZk) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                this.acr.showToast(d.l.no_network_guide);
            } else if (this.bfT != null && this.bfT.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    aw.aN(this.acr.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0041a.a(this.bfT.channelId, this.acr.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        this.eZr = blVar;
        a(mVar.aQt(), mVar.getPraiseNum());
        if (blVar.sJ() != null) {
            this.eZk = true;
            this.eZj.setVisibility(8);
            this.eZf.setVisibility(0);
            Y(blVar);
        } else {
            this.eZk = false;
            this.eZj.setVisibility(0);
            this.eZf.setVisibility(8);
            o(postData);
        }
        if (O(blVar)) {
            this.eZf.setVisibility(8);
            this.eZj.setVisibility(8);
        }
    }

    private boolean O(bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    private void o(PostData postData) {
        this.eZi.setVisibility(8);
        this.eZc.setUserId(postData.getAuthor().getUserId());
        this.eZc.setUserName(postData.getAuthor().getUserName());
        this.eZc.setIsBigV(postData.getAuthor().isBigV());
        this.eZd.setText(postData.getAuthor().getUserName());
        this.eZd.setTag(postData.getAuthor().getUserId());
        this.eZc.c(postData.getAuthor().getPortrait(), 28, false);
        this.eZm.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eZq != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eZq.setVisibility(8);
                return;
            }
            this.eZq.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.Rq = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eZq.setTag(aVar);
        }
    }

    private void Y(bl blVar) {
        this.eZi.setVisibility(0);
        this.bfT = blVar.sJ();
        if (this.bfT.abn == 1) {
            this.eZl = 0;
        } else {
            this.eZl = this.bfT.abn;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eZl = 2;
        }
        this.eZd.setText(this.bfT.channelName);
        this.eZc.c(this.bfT.channelAvatar, 10, false);
        j(this.eZl, this.bfT.channelId);
    }

    public void j(int i, long j) {
        if (this.bfT != null && j > 0 && j == this.bfT.channelId) {
            if (i == 1) {
                this.eZf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ai.i(this.eZf, d.e.cp_bg_line_d_alpha80);
                this.eZf.setClickable(false);
                this.eZf.setText(d.l.has_ordered_channel);
                return;
            }
            this.eZf.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eZf, d.e.cp_cont_i);
            this.eZf.setClickable(true);
            this.eZf.setText(d.l.order_video_channel);
        }
    }

    public void ah(float f) {
        this.eZe.setAlpha(f);
    }

    public View aWB() {
        return this.eZe;
    }

    public void dt(int i) {
        if (this.eZj != null) {
            this.eZj.onChangeSkinType(i);
        }
        if (this.eZg != null) {
            ai.i(this.eZg, d.e.cp_cont_i);
        }
        if (this.eZl == 1) {
            ai.i(this.eZf, d.e.cp_bg_line_d_alpha80);
        } else {
            ai.i(this.eZf, d.e.cp_cont_i);
        }
        if (this.eZd != null) {
            ai.i(this.eZd, d.e.cp_cont_i);
        }
        if (this.eZi != null) {
            ai.j(this.eZi, d.g.icon_weiba);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.eZn = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.eZo = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aoQ != null) {
            this.aoQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eZg.setText(al.x(j));
        if (z) {
            this.eZh.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eZh.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aoQ);
    }
}
