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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class g {
    private TbPageContext<?> abI;
    private bm bie;
    private View ebG;
    private HeadImageView fbj;
    private TextView fbk;
    private RelativeLayout fbl;
    private TextView fbm;
    private TextView fbn;
    private ImageView fbo;
    private ImageView fbp;
    private PbVideoFullUserInfoLikeButton fbq;
    public int fbs;
    private f fbt;
    private View.OnClickListener fbu;
    private View.OnClickListener fbv;
    private LinearLayout fbw;
    private View fbx;
    private bh fby;
    private boolean fbr = false;
    private View.OnClickListener aTx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fbo) {
                g.this.bs(view);
            } else if (view == g.this.fbj || view == g.this.fbk || view == g.this.fbp) {
                g.this.bt(view);
            } else if (view == g.this.fbm) {
                g.this.aXa();
            }
        }
    };
    private CustomMessageListener anI = new CustomMessageListener(CmdConfigCustom.CMD_PB_AGREE_CHANGED) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && g.this.fby != null && g.this.fby.getId() != null) {
                k kVar = (k) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(kVar.pid) && kVar.pid.equals(g.this.fby.rK())) {
                    g.this.a(kVar.eGT == 0, kVar.eGU.aQs());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.abI = tbPageContext;
        this.ebG = q(tbPageContext);
        initView();
        p(this.abI.getUniqueId());
        frameLayout.addView(this.ebG);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fbl = (RelativeLayout) this.ebG.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.fbj = (HeadImageView) this.ebG.findViewById(d.g.pbVideoFullPhoto);
        this.fbj.setOnClickListener(this.aTx);
        this.fbw = (LinearLayout) this.ebG.findViewById(d.g.pbVideoFullNameLayout);
        this.fbx = com.baidu.tbadk.ala.b.nu().g(this.abI.getPageActivity(), 6);
        if (this.fbx != null) {
            this.fbx.setVisibility(8);
            this.fbw.addView(this.fbx);
        }
        this.fbk = (TextView) this.ebG.findViewById(d.g.pbVideoFullUserName);
        this.fbk.setOnClickListener(this.aTx);
        this.fbm = (TextView) this.ebG.findViewById(d.g.pbVideoFullAttention);
        this.fbm.setOnClickListener(this.aTx);
        this.fbn = (TextView) this.ebG.findViewById(d.g.pbVideoFullZanCount);
        this.fbo = (ImageView) this.ebG.findViewById(d.g.pbVideoFullZanLabel);
        this.fbo.setOnClickListener(this.aTx);
        this.fbp = (ImageView) this.ebG.findViewById(d.g.pbVideoFullChannelIcon);
        this.fbq = (PbVideoFullUserInfoLikeButton) this.ebG.findViewById(d.g.pbVideoFullLikeButton);
        this.fbt = new f(this.abI, this.fbq);
        this.fbj.setRadius(l.f(this.abI.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(View view) {
        if (this.fbv != null) {
            this.fbv.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(View view) {
        if (this.fbr) {
            if (this.bie != null) {
                this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.abI.getPageActivity(), this.bie.channelId, 2)));
            }
        } else if (this.fbu != null) {
            this.fbu.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXa() {
        if (this.fbr) {
            if (!l.hy()) {
                this.abI.showToast(d.j.no_network_guide);
            } else if (this.bie != null && this.bie.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ax.aS(this.abI.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(this.bie.channelId, this.abI.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, com.baidu.tieba.pb.data.l lVar) {
        this.fby = bhVar;
        a(lVar.aQt(), lVar.aQs());
        if (bhVar.sz() != null) {
            this.fbr = true;
            this.fbq.setVisibility(8);
            this.fbm.setVisibility(0);
            Z(bhVar);
        } else {
            this.fbr = false;
            this.fbq.setVisibility(0);
            this.fbm.setVisibility(8);
            o(postData);
        }
        if (P(bhVar)) {
            this.fbm.setVisibility(8);
            this.fbq.setVisibility(8);
        }
    }

    private boolean P(bh bhVar) {
        if (bhVar == null || bhVar.rt() == null || bhVar.rt().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.rt().getUserId());
    }

    private void o(PostData postData) {
        this.fbp.setVisibility(8);
        this.fbj.setUserId(postData.rt().getUserId());
        this.fbj.setUserName(postData.rt().getUserName());
        this.fbj.setIsBigV(postData.rt().isBigV());
        this.fbk.setText(postData.rt().getUserName());
        this.fbk.setTag(postData.rt().getUserId());
        this.fbj.startLoad(postData.rt().getPortrait(), 28, false);
        this.fbt.a(postData.rt());
        if (postData.rt() != null && postData.rt().getAlaUserData() != null && this.fbx != null) {
            if (postData.rt().getAlaUserData().anchor_live == 0) {
                this.fbx.setVisibility(8);
                return;
            }
            this.fbx.setVisibility(0);
            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
            aVar.QK = postData.rt().getAlaUserData();
            aVar.type = 6;
            this.fbx.setTag(aVar);
        }
    }

    private void Z(bh bhVar) {
        this.fbp.setVisibility(0);
        this.bie = bhVar.sz();
        if (this.bie.aaD == 1) {
            this.fbs = 0;
        } else {
            this.fbs = this.bie.aaD;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fbs = 2;
        }
        this.fbk.setText(this.bie.channelName);
        this.fbj.startLoad(this.bie.channelAvatar, 10, false);
        l(this.fbs, this.bie.channelId);
    }

    public void l(int i, long j) {
        if (this.bie != null && j > 0 && j == this.bie.channelId) {
            if (i == 1) {
                this.fbm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fbm, d.C0080d.cp_bg_line_d_alpha80);
                this.fbm.setClickable(false);
                this.fbm.setText(d.j.has_ordered_channel);
                return;
            }
            this.fbm.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbm, d.C0080d.cp_cont_i);
            this.fbm.setClickable(true);
            this.fbm.setText(d.j.order_video_channel);
        }
    }

    public void X(float f) {
        this.fbl.setAlpha(f);
    }

    public View aXb() {
        return this.fbl;
    }

    public void dE(int i) {
        if (this.fbq != null) {
            this.fbq.onChangeSkinType(i);
        }
        if (this.fbn != null) {
            aj.i(this.fbn, d.C0080d.cp_cont_i);
        }
        if (this.fbs == 1) {
            aj.i(this.fbm, d.C0080d.cp_bg_line_d_alpha80);
        } else {
            aj.i(this.fbm, d.C0080d.cp_cont_i);
        }
        if (this.fbk != null) {
            aj.i(this.fbk, d.C0080d.cp_cont_i);
        }
        if (this.fbp != null) {
            aj.j(this.fbp, d.f.icon_weiba);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        this.fbu = onClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.fbv = onClickListener;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anI != null) {
            this.anI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.fbn.setText(am.w(j));
        if (z) {
            this.fbo.setImageResource(d.f.icon_floor_praised);
        } else {
            this.fbo.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anI);
    }
}
