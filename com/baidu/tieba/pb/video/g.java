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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private bd bPv;
    private bj bzE;
    private LinearLayout fIA;
    private HeadImageView fIn;
    private TextView fIo;
    private RelativeLayout fIp;
    private TextView fIq;
    private TextView fIr;
    private ImageView fIs;
    private ImageView fIt;
    private PbVideoFullUserInfoLikeButton fIu;
    public int fIw;
    private f fIx;
    private View.OnClickListener fIy;
    private View.OnClickListener fIz;
    private TbPageContext<?> mContext;
    private View mMainView;
    private boolean fIv = false;
    private View.OnClickListener bnQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fIs) {
                g.this.bm(view);
            } else if (view == g.this.fIn || view == g.this.fIo || view == g.this.fIt) {
                g.this.bn(view);
            } else if (view == g.this.fIq) {
                g.this.bhl();
            }
        }
    };
    private CustomMessageListener axl = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.bPv != null && g.this.bPv.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.bPv.vC())) {
                    g.this.c(iVar.fpg == 0, iVar.fph.baQ());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.mMainView = q(tbPageContext);
        initView();
        p(this.mContext.getUniqueId());
        frameLayout.addView(this.mMainView);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fIp = (RelativeLayout) this.mMainView.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fIn = (HeadImageView) this.mMainView.findViewById(d.g.pbVideoFullPhoto);
        this.fIn.setOnClickListener(this.bnQ);
        this.fIA = (LinearLayout) this.mMainView.findViewById(d.g.pbVideoFullNameLayout);
        al.i(this.fIA, d.f.video_author_bg);
        this.fIo = (TextView) this.mMainView.findViewById(d.g.pbVideoFullUserName);
        this.fIo.setOnClickListener(this.bnQ);
        this.fIq = (TextView) this.mMainView.findViewById(d.g.pbVideoFullAttention);
        this.fIq.setOnClickListener(this.bnQ);
        this.fIr = (TextView) this.mMainView.findViewById(d.g.pbVideoFullZanCount);
        this.fIs = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullZanLabel);
        this.fIs.setOnClickListener(this.bnQ);
        this.fIt = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullChannelIcon);
        this.fIu = (PbVideoFullUserInfoLikeButton) this.mMainView.findViewById(d.g.pbVideoFullLikeButton);
        this.fIu.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.tbds30));
        this.fIx = new f(this.mContext, this.fIu);
        this.fIn.setRadius(l.e(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(View view) {
        if (this.fIz != null) {
            this.fIz.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(View view) {
        if (this.fIv) {
            if (this.bzE != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bzE.channelId, 2)));
            }
        } else if (this.fIy != null) {
            this.fIy.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        if (this.fIv) {
            if (!l.jU()) {
                this.mContext.showToast(d.k.no_network_guide);
            } else if (this.bzE != null && this.bzE.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.aT(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0101a.a(this.bzE.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, j jVar) {
        this.bPv = bdVar;
        c(jVar.baS(), jVar.baQ());
        if (bdVar.wm() != null) {
            this.fIv = true;
            this.fIu.setVisibility(8);
            this.fIq.setVisibility(0);
            ai(bdVar);
        } else {
            this.fIv = false;
            this.fIu.setVisibility(0);
            this.fIq.setVisibility(8);
            n(postData);
        }
        if (af(bdVar)) {
            this.fIq.setVisibility(8);
            this.fIu.setVisibility(8);
        }
    }

    private boolean af(bd bdVar) {
        if (bdVar == null || bdVar.vm() == null || bdVar.vm().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.vm().getUserId());
    }

    private void n(PostData postData) {
        this.fIt.setVisibility(8);
        this.fIn.setUserId(postData.vm().getUserId());
        this.fIn.setUserName(postData.vm().getUserName());
        this.fIn.setIsBigV(postData.vm().isBigV());
        this.fIo.setText(postData.vm().getUserName());
        this.fIo.setTag(postData.vm().getUserId());
        this.fIn.startLoad(postData.vm().getPortrait(), 28, false);
        this.fIx.a(postData.vm());
    }

    private void ai(bd bdVar) {
        this.fIt.setVisibility(0);
        this.bzE = bdVar.wm();
        if (this.bzE.akm == 1) {
            this.fIw = 0;
        } else {
            this.fIw = this.bzE.akm;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fIw = 2;
        }
        this.fIo.setText(this.bzE.channelName);
        this.fIn.startLoad(this.bzE.channelAvatar, 10, false);
        l(this.fIw, this.bzE.channelId);
    }

    public void l(int i, long j) {
        if (this.bzE != null && j > 0 && j == this.bzE.channelId) {
            if (i == 1) {
                this.fIq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.fIq, d.C0141d.cp_bg_line_d_alpha80);
                this.fIq.setClickable(false);
                this.fIq.setText(d.k.has_ordered_channel);
                return;
            }
            this.fIq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fIq, d.C0141d.cp_cont_i);
            this.fIq.setClickable(true);
            this.fIq.setText(d.k.order_video_channel);
        }
    }

    public void ar(float f) {
        this.fIp.setAlpha(f);
    }

    public View bhm() {
        return this.fIp;
    }

    public void dC(int i) {
        if (this.fIu != null) {
            this.fIu.onChangeSkinType(i);
        }
        if (this.fIr != null) {
            al.h(this.fIr, d.C0141d.cp_cont_i);
        }
        if (this.fIw == 1) {
            al.h(this.fIq, d.C0141d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.fIq, d.C0141d.cp_cont_i);
        }
        if (this.fIo != null) {
            al.h(this.fIo, d.C0141d.cp_cont_i);
        }
        if (this.fIt != null) {
            al.i(this.fIt, d.f.icon_weiba);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.fIy = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fIz = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.axl != null) {
            this.axl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.axl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, long j) {
        this.fIr.setText(ao.B(j));
        if (z) {
            this.fIs.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fIs.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.axl);
    }
}
