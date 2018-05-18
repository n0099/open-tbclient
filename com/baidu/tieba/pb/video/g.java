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
    private bd bHt;
    private bj brz;
    private HeadImageView fwT;
    private TextView fwU;
    private RelativeLayout fwV;
    private TextView fwW;
    private TextView fwX;
    private ImageView fwY;
    private ImageView fwZ;
    private PbVideoFullUserInfoLikeButton fxa;
    public int fxc;
    private f fxd;
    private View.OnClickListener fxe;
    private View.OnClickListener fxf;
    private LinearLayout fxg;
    private TbPageContext<?> mContext;
    private View mMainView;
    private boolean fxb = false;
    private View.OnClickListener bfJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == g.this.fwY) {
                g.this.bj(view2);
            } else if (view2 == g.this.fwT || view2 == g.this.fwU || view2 == g.this.fwZ) {
                g.this.bk(view2);
            } else if (view2 == g.this.fwW) {
                g.this.bcl();
            }
        }
    };
    private CustomMessageListener apd = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.bHt != null && g.this.bHt.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.bHt.sf())) {
                    g.this.c(iVar.fdK == 0, iVar.fdL.aVU());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.mMainView = q(tbPageContext);
        initView();
        o(this.mContext.getUniqueId());
        frameLayout.addView(this.mMainView);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fwV = (RelativeLayout) this.mMainView.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fwT = (HeadImageView) this.mMainView.findViewById(d.g.pbVideoFullPhoto);
        this.fwT.setOnClickListener(this.bfJ);
        this.fxg = (LinearLayout) this.mMainView.findViewById(d.g.pbVideoFullNameLayout);
        ak.i(this.fxg, d.f.video_author_bg);
        this.fwU = (TextView) this.mMainView.findViewById(d.g.pbVideoFullUserName);
        this.fwU.setOnClickListener(this.bfJ);
        this.fwW = (TextView) this.mMainView.findViewById(d.g.pbVideoFullAttention);
        this.fwW.setOnClickListener(this.bfJ);
        this.fwX = (TextView) this.mMainView.findViewById(d.g.pbVideoFullZanCount);
        this.fwY = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullZanLabel);
        this.fwY.setOnClickListener(this.bfJ);
        this.fwZ = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullChannelIcon);
        this.fxa = (PbVideoFullUserInfoLikeButton) this.mMainView.findViewById(d.g.pbVideoFullLikeButton);
        this.fxa.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.tbds30));
        this.fxd = new f(this.mContext, this.fxa);
        this.fwT.setRadius(l.e(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view2) {
        if (this.fxf != null) {
            this.fxf.onClick(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view2) {
        if (this.fxb) {
            if (this.brz != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.brz.channelId, 2)));
            }
        } else if (this.fxe != null) {
            this.fxe.onClick(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        if (this.fxb) {
            if (!l.hg()) {
                this.mContext.showToast(d.k.no_network_guide);
            } else if (this.brz != null && this.brz.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    az.aJ(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0084a.a(this.brz.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, j jVar) {
        this.bHt = bdVar;
        c(jVar.aVW(), jVar.aVU());
        if (bdVar.sP() != null) {
            this.fxb = true;
            this.fxa.setVisibility(8);
            this.fwW.setVisibility(0);
            ag(bdVar);
        } else {
            this.fxb = false;
            this.fxa.setVisibility(0);
            this.fwW.setVisibility(8);
            n(postData);
        }
        if (ad(bdVar)) {
            this.fwW.setVisibility(8);
            this.fxa.setVisibility(8);
        }
    }

    private boolean ad(bd bdVar) {
        if (bdVar == null || bdVar.rP() == null || bdVar.rP().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rP().getUserId());
    }

    private void n(PostData postData) {
        this.fwZ.setVisibility(8);
        this.fwT.setUserId(postData.rP().getUserId());
        this.fwT.setUserName(postData.rP().getUserName());
        this.fwT.setIsBigV(postData.rP().isBigV());
        this.fwU.setText(postData.rP().getUserName());
        this.fwU.setTag(postData.rP().getUserId());
        this.fwT.startLoad(postData.rP().getPortrait(), 28, false);
        this.fxd.a(postData.rP());
    }

    private void ag(bd bdVar) {
        this.fwZ.setVisibility(0);
        this.brz = bdVar.sP();
        if (this.brz.aci == 1) {
            this.fxc = 0;
        } else {
            this.fxc = this.brz.aci;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fxc = 2;
        }
        this.fwU.setText(this.brz.channelName);
        this.fwT.startLoad(this.brz.channelAvatar, 10, false);
        l(this.fxc, this.brz.channelId);
    }

    public void l(int i, long j) {
        if (this.brz != null && j > 0 && j == this.brz.channelId) {
            if (i == 1) {
                this.fwW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.fwW, d.C0126d.cp_bg_line_d_alpha80);
                this.fwW.setClickable(false);
                this.fwW.setText(d.k.has_ordered_channel);
                return;
            }
            this.fwW.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fwW, d.C0126d.cp_cont_i);
            this.fwW.setClickable(true);
            this.fwW.setText(d.k.order_video_channel);
        }
    }

    public void ah(float f) {
        this.fwV.setAlpha(f);
    }

    public View bcm() {
        return this.fwV;
    }

    public void dA(int i) {
        if (this.fxa != null) {
            this.fxa.onChangeSkinType(i);
        }
        if (this.fwX != null) {
            ak.h(this.fwX, d.C0126d.cp_cont_i);
        }
        if (this.fxc == 1) {
            ak.h(this.fwW, d.C0126d.cp_bg_line_d_alpha80);
        } else {
            ak.h(this.fwW, d.C0126d.cp_cont_i);
        }
        if (this.fwU != null) {
            ak.h(this.fwU, d.C0126d.cp_cont_i);
        }
        if (this.fwZ != null) {
            ak.i(this.fwZ, d.f.icon_weiba);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.fxe = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fxf = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.apd != null) {
            this.apd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.apd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, long j) {
        this.fwX.setText(an.y(j));
        if (z) {
            this.fwY.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fwY.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.apd);
    }
}
