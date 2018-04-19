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
    private bd bGL;
    private bj brk;
    private HeadImageView fvQ;
    private TextView fvR;
    private RelativeLayout fvS;
    private TextView fvT;
    private TextView fvU;
    private ImageView fvV;
    private ImageView fvW;
    private PbVideoFullUserInfoLikeButton fvX;
    public int fvZ;
    private f fwa;
    private View.OnClickListener fwb;
    private View.OnClickListener fwc;
    private LinearLayout fwd;
    private View mMainView;
    private boolean fvY = false;
    private View.OnClickListener bfI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == g.this.fvV) {
                g.this.bj(view2);
            } else if (view2 == g.this.fvQ || view2 == g.this.fvR || view2 == g.this.fvW) {
                g.this.bk(view2);
            } else if (view2 == g.this.fvT) {
                g.this.bcl();
            }
        }
    };
    private CustomMessageListener apd = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.bGL != null && g.this.bGL.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.bGL.sg())) {
                    g.this.c(iVar.fcG == 0, iVar.fcH.aVU());
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
        this.fvS = (RelativeLayout) this.mMainView.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fvQ = (HeadImageView) this.mMainView.findViewById(d.g.pbVideoFullPhoto);
        this.fvQ.setOnClickListener(this.bfI);
        this.fwd = (LinearLayout) this.mMainView.findViewById(d.g.pbVideoFullNameLayout);
        ak.i(this.fwd, d.f.video_author_bg);
        this.fvR = (TextView) this.mMainView.findViewById(d.g.pbVideoFullUserName);
        this.fvR.setOnClickListener(this.bfI);
        this.fvT = (TextView) this.mMainView.findViewById(d.g.pbVideoFullAttention);
        this.fvT.setOnClickListener(this.bfI);
        this.fvU = (TextView) this.mMainView.findViewById(d.g.pbVideoFullZanCount);
        this.fvV = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullZanLabel);
        this.fvV.setOnClickListener(this.bfI);
        this.fvW = (ImageView) this.mMainView.findViewById(d.g.pbVideoFullChannelIcon);
        this.fvX = (PbVideoFullUserInfoLikeButton) this.mMainView.findViewById(d.g.pbVideoFullLikeButton);
        this.fvX.setTextSize(0, l.e(this.adf.getPageActivity(), d.e.tbds30));
        this.fwa = new f(this.adf, this.fvX);
        this.fvQ.setRadius(l.e(this.adf.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(View view2) {
        if (this.fwc != null) {
            this.fwc.onClick(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(View view2) {
        if (this.fvY) {
            if (this.brk != null) {
                this.adf.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.adf.getPageActivity(), this.brk.channelId, 2)));
            }
        } else if (this.fwb != null) {
            this.fwb.onClick(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        if (this.fvY) {
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
        this.bGL = bdVar;
        c(jVar.aVW(), jVar.aVU());
        if (bdVar.sQ() != null) {
            this.fvY = true;
            this.fvX.setVisibility(8);
            this.fvT.setVisibility(0);
            ag(bdVar);
        } else {
            this.fvY = false;
            this.fvX.setVisibility(0);
            this.fvT.setVisibility(8);
            n(postData);
        }
        if (ad(bdVar)) {
            this.fvT.setVisibility(8);
            this.fvX.setVisibility(8);
        }
    }

    private boolean ad(bd bdVar) {
        if (bdVar == null || bdVar.rQ() == null || bdVar.rQ().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.rQ().getUserId());
    }

    private void n(PostData postData) {
        this.fvW.setVisibility(8);
        this.fvQ.setUserId(postData.rQ().getUserId());
        this.fvQ.setUserName(postData.rQ().getUserName());
        this.fvQ.setIsBigV(postData.rQ().isBigV());
        this.fvR.setText(postData.rQ().getUserName());
        this.fvR.setTag(postData.rQ().getUserId());
        this.fvQ.startLoad(postData.rQ().getPortrait(), 28, false);
        this.fwa.a(postData.rQ());
    }

    private void ag(bd bdVar) {
        this.fvW.setVisibility(0);
        this.brk = bdVar.sQ();
        if (this.brk.ach == 1) {
            this.fvZ = 0;
        } else {
            this.fvZ = this.brk.ach;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fvZ = 2;
        }
        this.fvR.setText(this.brk.channelName);
        this.fvQ.startLoad(this.brk.channelAvatar, 10, false);
        n(this.fvZ, this.brk.channelId);
    }

    public void n(int i, long j) {
        if (this.brk != null && j > 0 && j == this.brk.channelId) {
            if (i == 1) {
                this.fvT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.fvT, d.C0126d.cp_bg_line_d_alpha80);
                this.fvT.setClickable(false);
                this.fvT.setText(d.k.has_ordered_channel);
                return;
            }
            this.fvT.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fvT, d.C0126d.cp_cont_i);
            this.fvT.setClickable(true);
            this.fvT.setText(d.k.order_video_channel);
        }
    }

    public void ah(float f) {
        this.fvS.setAlpha(f);
    }

    public View bcm() {
        return this.fvS;
    }

    public void dz(int i) {
        if (this.fvX != null) {
            this.fvX.onChangeSkinType(i);
        }
        if (this.fvU != null) {
            ak.h(this.fvU, d.C0126d.cp_cont_i);
        }
        if (this.fvZ == 1) {
            ak.h(this.fvT, d.C0126d.cp_bg_line_d_alpha80);
        } else {
            ak.h(this.fvT, d.C0126d.cp_cont_i);
        }
        if (this.fvR != null) {
            ak.h(this.fvR, d.C0126d.cp_cont_i);
        }
        if (this.fvW != null) {
            ak.i(this.fvW, d.f.icon_weiba);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.fwb = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.fwc = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.apd != null) {
            this.apd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.apd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, long j) {
        this.fvU.setText(an.y(j));
        if (z) {
            this.fvV.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fvV.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.apd);
    }
}
