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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private bi bBj;
    private bc bRG;
    private View.OnClickListener fMA;
    private View.OnClickListener fMB;
    private LinearLayout fMC;
    private HeadImageView fMp;
    private TextView fMq;
    private RelativeLayout fMr;
    private TextView fMs;
    private TextView fMt;
    private ImageView fMu;
    private ImageView fMv;
    private PbVideoFullUserInfoLikeButton fMw;
    public int fMy;
    private f fMz;
    private TbPageContext<?> mContext;
    private View mMainView;
    private boolean fMx = false;
    private View.OnClickListener bpq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fMu) {
                g.this.bn(view);
            } else if (view == g.this.fMp || view == g.this.fMq || view == g.this.fMv) {
                g.this.bo(view);
            } else if (view == g.this.fMs) {
                g.this.bhR();
            }
        }
    };
    private CustomMessageListener ayc = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.bRG != null && g.this.bRG.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.bRG.vM())) {
                    g.this.c(iVar.fta == 0, iVar.ftb.bby());
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
        this.fMr = (RelativeLayout) this.mMainView.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fMp = (HeadImageView) this.mMainView.findViewById(d.g.pbVideoFullPhoto);
        this.fMp.setOnClickListener(this.bpq);
        this.fMC = (LinearLayout) this.mMainView.findViewById(d.g.pbVideoFullNameLayout);
        am.i(this.fMC, d.f.video_author_bg);
        this.fMq = (TextView) this.mMainView.findViewById(d.g.pbVideoFullUserName);
        this.fMq.setOnClickListener(this.bpq);
        this.fMs = (TextView) this.mMainView.findViewById(d.g.pbVideoFullAttention);
        this.fMs.setOnClickListener(this.bpq);
        this.fMt = (TextView) this.mMainView.findViewById(d.g.pbVideoFullZanCount);
        this.fMu = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullZanLabel);
        this.fMu.setOnClickListener(this.bpq);
        this.fMv = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullChannelIcon);
        this.fMw = (PbVideoFullUserInfoLikeButton) this.mMainView.findViewById(d.g.pbVideoFullLikeButton);
        this.fMw.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.tbds30));
        this.fMz = new f(this.mContext, this.fMw);
        this.fMp.setRadius(l.e(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(View view) {
        if (this.fMB != null) {
            this.fMB.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(View view) {
        if (this.fMx) {
            if (this.bBj != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bBj.channelId, 2)));
            }
        } else if (this.fMA != null) {
            this.fMA.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhR() {
        if (this.fMx) {
            if (!l.jU()) {
                this.mContext.showToast(d.k.no_network_guide);
            } else if (this.bBj != null && this.bBj.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bb.aT(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0102a.a(this.bBj.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bc bcVar, j jVar) {
        this.bRG = bcVar;
        c(jVar.bbA(), jVar.bby());
        if (bcVar.ww() != null) {
            this.fMx = true;
            this.fMw.setVisibility(8);
            this.fMs.setVisibility(0);
            an(bcVar);
        } else {
            this.fMx = false;
            this.fMw.setVisibility(0);
            this.fMs.setVisibility(8);
            n(postData);
        }
        if (ak(bcVar)) {
            this.fMs.setVisibility(8);
            this.fMw.setVisibility(8);
        }
    }

    private boolean ak(bc bcVar) {
        if (bcVar == null || bcVar.vw() == null || bcVar.vw().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bcVar.vw().getUserId());
    }

    private void n(PostData postData) {
        this.fMv.setVisibility(8);
        this.fMp.setUserId(postData.vw().getUserId());
        this.fMp.setUserName(postData.vw().getUserName());
        this.fMp.setIsBigV(postData.vw().isBigV());
        this.fMq.setText(postData.vw().getUserName());
        this.fMq.setTag(postData.vw().getUserId());
        this.fMp.startLoad(postData.vw().getPortrait(), 28, false);
        this.fMz.a(postData.vw());
    }

    private void an(bc bcVar) {
        this.fMv.setVisibility(0);
        this.bBj = bcVar.ww();
        if (this.bBj.akL == 1) {
            this.fMy = 0;
        } else {
            this.fMy = this.bBj.akL;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fMy = 2;
        }
        this.fMq.setText(this.bBj.channelName);
        this.fMp.startLoad(this.bBj.channelAvatar, 10, false);
        l(this.fMy, this.bBj.channelId);
    }

    public void l(int i, long j) {
        if (this.bBj != null && j > 0 && j == this.bBj.channelId) {
            if (i == 1) {
                this.fMs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.fMs, d.C0142d.cp_bg_line_d_alpha80);
                this.fMs.setClickable(false);
                this.fMs.setText(d.k.has_ordered_channel);
                return;
            }
            this.fMs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMs, d.C0142d.cp_cont_i);
            this.fMs.setClickable(true);
            this.fMs.setText(d.k.order_video_channel);
        }
    }

    public void ar(float f) {
        this.fMr.setAlpha(f);
    }

    public View bhS() {
        return this.fMr;
    }

    public void dD(int i) {
        if (this.fMw != null) {
            this.fMw.onChangeSkinType(i);
        }
        if (this.fMt != null) {
            am.h(this.fMt, d.C0142d.cp_cont_i);
        }
        if (this.fMy == 1) {
            am.h(this.fMs, d.C0142d.cp_bg_line_d_alpha80);
        } else {
            am.h(this.fMs, d.C0142d.cp_cont_i);
        }
        if (this.fMq != null) {
            am.h(this.fMq, d.C0142d.cp_cont_i);
        }
        if (this.fMv != null) {
            am.i(this.fMv, d.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.fMA = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.fMB = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ayc != null) {
            this.ayc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ayc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, long j) {
        this.fMt.setText(ap.C(j));
        if (z) {
            this.fMu.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fMu.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ayc);
    }
}
