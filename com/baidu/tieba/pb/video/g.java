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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private TbPageContext<?> adf;
    private bd bGK;
    private bj brk;
    private HeadImageView fvN;
    private TextView fvO;
    private RelativeLayout fvP;
    private TextView fvQ;
    private TextView fvR;
    private ImageView fvS;
    private ImageView fvT;
    private PbVideoFullUserInfoLikeButton fvU;
    public int fvW;
    private f fvX;
    private View.OnClickListener fvY;
    private View.OnClickListener fvZ;
    private LinearLayout fwa;
    private View mMainView;
    private boolean fvV = false;
    private View.OnClickListener bfI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == g.this.fvS) {
                g.this.bj(view2);
            } else if (view2 == g.this.fvN || view2 == g.this.fvO || view2 == g.this.fvT) {
                g.this.bk(view2);
            } else if (view2 == g.this.fvQ) {
                g.this.bcl();
            }
        }
    };
    private CustomMessageListener apd = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.bGK != null && g.this.bGK.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.bGK.sg())) {
                    g.this.c(iVar.fcD == 0, iVar.fcE.aVU());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.adf = tbPageContext;
        this.mMainView = p(tbPageContext);
        initView();
        o(this.adf.getUniqueId());
        frameLayout.addView(this.mMainView);
    }

    private View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fvP = (RelativeLayout) this.mMainView.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fvN = (HeadImageView) this.mMainView.findViewById(d.g.pbVideoFullPhoto);
        this.fvN.setOnClickListener(this.bfI);
        this.fwa = (LinearLayout) this.mMainView.findViewById(d.g.pbVideoFullNameLayout);
        ak.i(this.fwa, d.f.video_author_bg);
        this.fvO = (TextView) this.mMainView.findViewById(d.g.pbVideoFullUserName);
        this.fvO.setOnClickListener(this.bfI);
        this.fvQ = (TextView) this.mMainView.findViewById(d.g.pbVideoFullAttention);
        this.fvQ.setOnClickListener(this.bfI);
        this.fvR = (TextView) this.mMainView.findViewById(d.g.pbVideoFullZanCount);
        this.fvS = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullZanLabel);
        this.fvS.setOnClickListener(this.bfI);
        this.fvT = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullChannelIcon);
        this.fvU = (PbVideoFullUserInfoLikeButton) this.mMainView.findViewById(d.g.pbVideoFullLikeButton);
        this.fvU.setTextSize(0, l.e(this.adf.getPageActivity(), d.e.tbds30));
        this.fvX = new f(this.adf, this.fvU);
        this.fvN.setRadius(l.e(this.adf.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view2) {
        if (this.fvZ != null) {
            this.fvZ.onClick(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view2) {
        if (this.fvV) {
            if (this.brk != null) {
                this.adf.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.adf.getPageActivity(), this.brk.channelId, 2)));
            }
        } else if (this.fvY != null) {
            this.fvY.onClick(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        if (this.fvV) {
            if (!l.hg()) {
                this.adf.showToast(d.k.no_network_guide);
            } else if (this.brk != null && this.brk.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    az.aJ(this.adf.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0084a.a(this.brk.channelId, this.adf.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, j jVar) {
        this.bGK = bdVar;
        c(jVar.aVW(), jVar.aVU());
        if (bdVar.sQ() != null) {
            this.fvV = true;
            this.fvU.setVisibility(8);
            this.fvQ.setVisibility(0);
            ag(bdVar);
        } else {
            this.fvV = false;
            this.fvU.setVisibility(0);
            this.fvQ.setVisibility(8);
            n(postData);
        }
        if (ad(bdVar)) {
            this.fvQ.setVisibility(8);
            this.fvU.setVisibility(8);
        }
    }

    private boolean ad(bd bdVar) {
        if (bdVar == null || bdVar.rQ() == null || bdVar.rQ().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rQ().getUserId());
    }

    private void n(PostData postData) {
        this.fvT.setVisibility(8);
        this.fvN.setUserId(postData.rQ().getUserId());
        this.fvN.setUserName(postData.rQ().getUserName());
        this.fvN.setIsBigV(postData.rQ().isBigV());
        this.fvO.setText(postData.rQ().getUserName());
        this.fvO.setTag(postData.rQ().getUserId());
        this.fvN.startLoad(postData.rQ().getPortrait(), 28, false);
        this.fvX.a(postData.rQ());
    }

    private void ag(bd bdVar) {
        this.fvT.setVisibility(0);
        this.brk = bdVar.sQ();
        if (this.brk.ach == 1) {
            this.fvW = 0;
        } else {
            this.fvW = this.brk.ach;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fvW = 2;
        }
        this.fvO.setText(this.brk.channelName);
        this.fvN.startLoad(this.brk.channelAvatar, 10, false);
        n(this.fvW, this.brk.channelId);
    }

    public void n(int i, long j) {
        if (this.brk != null && j > 0 && j == this.brk.channelId) {
            if (i == 1) {
                this.fvQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.fvQ, d.C0126d.cp_bg_line_d_alpha80);
                this.fvQ.setClickable(false);
                this.fvQ.setText(d.k.has_ordered_channel);
                return;
            }
            this.fvQ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fvQ, d.C0126d.cp_cont_i);
            this.fvQ.setClickable(true);
            this.fvQ.setText(d.k.order_video_channel);
        }
    }

    public void ah(float f) {
        this.fvP.setAlpha(f);
    }

    public View bcm() {
        return this.fvP;
    }

    public void dz(int i) {
        if (this.fvU != null) {
            this.fvU.onChangeSkinType(i);
        }
        if (this.fvR != null) {
            ak.h(this.fvR, d.C0126d.cp_cont_i);
        }
        if (this.fvW == 1) {
            ak.h(this.fvQ, d.C0126d.cp_bg_line_d_alpha80);
        } else {
            ak.h(this.fvQ, d.C0126d.cp_cont_i);
        }
        if (this.fvO != null) {
            ak.h(this.fvO, d.C0126d.cp_cont_i);
        }
        if (this.fvT != null) {
            ak.i(this.fvT, d.f.icon_weiba);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.fvY = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fvZ = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.apd != null) {
            this.apd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.apd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, long j) {
        this.fvR.setText(an.y(j));
        if (z) {
            this.fvS.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fvS.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.apd);
    }
}
