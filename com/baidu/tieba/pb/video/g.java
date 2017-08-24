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
    private bq bfU;
    private View dQt;
    private HeadImageView eZe;
    private TextView eZf;
    private RelativeLayout eZg;
    private TextView eZh;
    private TextView eZi;
    private ImageView eZj;
    private ImageView eZk;
    private PbVideoFullUserInfoLikeButton eZl;
    public int eZn;
    private f eZo;
    private View.OnClickListener eZp;
    private View.OnClickListener eZq;
    private LinearLayout eZr;
    private View eZs;
    private bl eZt;
    private boolean eZm = false;
    private View.OnClickListener aTa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.eZj) {
                g.this.bk(view);
            } else if (view == g.this.eZe || view == g.this.eZf || view == g.this.eZk) {
                g.this.bl(view);
            } else if (view == g.this.eZh) {
                g.this.aWv();
            }
        }
    };
    private CustomMessageListener aoQ = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.l) && g.this.eZt != null && g.this.eZt.getId() != null) {
                com.baidu.tieba.pb.data.l lVar = (com.baidu.tieba.pb.data.l) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(lVar.pid) && lVar.pid.equals(g.this.eZt.rW())) {
                    g.this.a(lVar.eGw == 0, lVar.eGx.getPraiseNum());
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
        this.eZg = (RelativeLayout) this.dQt.findViewById(d.h.pbVideoFullUserInfoPanel);
        this.eZe = (HeadImageView) this.dQt.findViewById(d.h.pbVideoFullPhoto);
        this.eZe.setOnClickListener(this.aTa);
        this.eZr = (LinearLayout) this.dQt.findViewById(d.h.pbVideoFullNameLayout);
        this.eZs = com.baidu.tbadk.ala.b.nD().h(this.acr.getPageActivity(), 6);
        if (this.eZs != null) {
            this.eZs.setVisibility(8);
            this.eZr.addView(this.eZs);
        }
        this.eZf = (TextView) this.dQt.findViewById(d.h.pbVideoFullUserName);
        this.eZf.setOnClickListener(this.aTa);
        this.eZh = (TextView) this.dQt.findViewById(d.h.pbVideoFullAttention);
        this.eZh.setOnClickListener(this.aTa);
        this.eZi = (TextView) this.dQt.findViewById(d.h.pbVideoFullZanCount);
        this.eZj = (ImageView) this.dQt.findViewById(d.h.pbVideoFullZanLabel);
        this.eZj.setOnClickListener(this.aTa);
        this.eZk = (ImageView) this.dQt.findViewById(d.h.pbVideoFullChannelIcon);
        this.eZl = (PbVideoFullUserInfoLikeButton) this.dQt.findViewById(d.h.pbVideoFullLikeButton);
        this.eZo = new f(this.acr, this.eZl);
        this.eZe.setRadius(com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view) {
        if (this.eZq != null) {
            this.eZq.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(View view) {
        if (this.eZm) {
            if (this.bfU != null) {
                this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.acr.getPageActivity(), this.bfU.channelId, 2)));
            }
        } else if (this.eZp != null) {
            this.eZp.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWv() {
        if (this.eZm) {
            if (!com.baidu.adp.lib.util.k.hI()) {
                this.acr.showToast(d.l.no_network_guide);
            } else if (this.bfU != null && this.bfU.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    aw.aN(this.acr.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0041a.a(this.bfU.channelId, this.acr.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bl blVar, com.baidu.tieba.pb.data.m mVar) {
        this.eZt = blVar;
        a(mVar.aQo(), mVar.getPraiseNum());
        if (blVar.sK() != null) {
            this.eZm = true;
            this.eZl.setVisibility(8);
            this.eZh.setVisibility(0);
            Y(blVar);
        } else {
            this.eZm = false;
            this.eZl.setVisibility(0);
            this.eZh.setVisibility(8);
            o(postData);
        }
        if (O(blVar)) {
            this.eZh.setVisibility(8);
            this.eZl.setVisibility(8);
        }
    }

    private boolean O(bl blVar) {
        if (blVar == null || blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), blVar.getAuthor().getUserId());
    }

    private void o(PostData postData) {
        this.eZk.setVisibility(8);
        this.eZe.setUserId(postData.getAuthor().getUserId());
        this.eZe.setUserName(postData.getAuthor().getUserName());
        this.eZe.setIsBigV(postData.getAuthor().isBigV());
        this.eZf.setText(postData.getAuthor().getUserName());
        this.eZf.setTag(postData.getAuthor().getUserId());
        this.eZe.c(postData.getAuthor().getPortrait(), 28, false);
        this.eZo.a(postData.getAuthor());
        if (postData.getAuthor() != null && postData.getAuthor().getAlaUserData() != null && this.eZs != null) {
            if (postData.getAuthor().getAlaUserData().anchor_live == 0) {
                this.eZs.setVisibility(8);
                return;
            }
            this.eZs.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.Rq = postData.getAuthor().getAlaUserData();
            aVar.type = 6;
            this.eZs.setTag(aVar);
        }
    }

    private void Y(bl blVar) {
        this.eZk.setVisibility(0);
        this.bfU = blVar.sK();
        if (this.bfU.abn == 1) {
            this.eZn = 0;
        } else {
            this.eZn = this.bfU.abn;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.eZn = 2;
        }
        this.eZf.setText(this.bfU.channelName);
        this.eZe.c(this.bfU.channelAvatar, 10, false);
        j(this.eZn, this.bfU.channelId);
    }

    public void j(int i, long j) {
        if (this.bfU != null && j > 0 && j == this.bfU.channelId) {
            if (i == 1) {
                this.eZh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ai.i(this.eZh, d.e.cp_bg_line_d_alpha80);
                this.eZh.setClickable(false);
                this.eZh.setText(d.l.has_ordered_channel);
                return;
            }
            this.eZh.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eZh, d.e.cp_cont_i);
            this.eZh.setClickable(true);
            this.eZh.setText(d.l.order_video_channel);
        }
    }

    public void ah(float f) {
        this.eZg.setAlpha(f);
    }

    public View aWw() {
        return this.eZg;
    }

    public void dt(int i) {
        if (this.eZl != null) {
            this.eZl.onChangeSkinType(i);
        }
        if (this.eZi != null) {
            ai.i(this.eZi, d.e.cp_cont_i);
        }
        if (this.eZn == 1) {
            ai.i(this.eZh, d.e.cp_bg_line_d_alpha80);
        } else {
            ai.i(this.eZh, d.e.cp_cont_i);
        }
        if (this.eZf != null) {
            ai.i(this.eZf, d.e.cp_cont_i);
        }
        if (this.eZk != null) {
            ai.j(this.eZk, d.g.icon_weiba);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        this.eZp = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eZq = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aoQ != null) {
            this.aoQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.eZi.setText(al.x(j));
        if (z) {
            this.eZj.setImageResource(d.g.icon_floor_praised);
        } else {
            this.eZj.setImageResource(d.g.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aoQ);
    }
}
