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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private TbPageContext<?> aRG;
    private bj chb;
    private bd cqE;
    private View fbO;
    public int gbA;
    private f gbB;
    private View.OnClickListener gbC;
    private View.OnClickListener gbD;
    private LinearLayout gbE;
    private HeadImageView gbr;
    private TextView gbs;
    private RelativeLayout gbt;
    private TextView gbu;
    private TextView gbv;
    private ImageView gbw;
    private ImageView gbx;
    private PbVideoFullUserInfoLikeButton gby;
    private boolean gbz = false;
    private View.OnClickListener bMI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gbw) {
                g.this.cD(view);
            } else if (view == g.this.gbr || view == g.this.gbs || view == g.this.gbx) {
                g.this.cE(view);
            } else if (view == g.this.gbu) {
                g.this.bhk();
            }
        }
    };
    private CustomMessageListener bdJ = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.cqE != null && g.this.cqE.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.cqE.zE())) {
                    g.this.a(iVar.fHM == 0, iVar.fHN.baU());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aRG = tbPageContext;
        this.fbO = p(tbPageContext);
        initView();
        o(this.aRG.getUniqueId());
        frameLayout.addView(this.fbO);
    }

    private View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gbt = (RelativeLayout) this.fbO.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.gbr = (HeadImageView) this.fbO.findViewById(d.g.pbVideoFullPhoto);
        this.gbr.setOnClickListener(this.bMI);
        this.gbE = (LinearLayout) this.fbO.findViewById(d.g.pbVideoFullNameLayout);
        aj.s(this.gbE, d.f.video_author_bg);
        this.gbs = (TextView) this.fbO.findViewById(d.g.pbVideoFullUserName);
        this.gbs.setOnClickListener(this.bMI);
        this.gbu = (TextView) this.fbO.findViewById(d.g.pbVideoFullAttention);
        this.gbu.setOnClickListener(this.bMI);
        this.gbv = (TextView) this.fbO.findViewById(d.g.pbVideoFullZanCount);
        this.gbw = (ImageView) this.fbO.findViewById(d.g.pbVideoFullZanLabel);
        this.gbw.setOnClickListener(this.bMI);
        this.gbx = (ImageView) this.fbO.findViewById(d.g.pbVideoFullChannelIcon);
        this.gby = (PbVideoFullUserInfoLikeButton) this.fbO.findViewById(d.g.pbVideoFullLikeButton);
        this.gby.setTextSize(0, l.t(this.aRG.getPageActivity(), d.e.tbds30));
        this.gbB = new f(this.aRG, this.gby);
        this.gbr.setRadius(l.t(this.aRG.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
        if (this.gbD != null) {
            this.gbD.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(View view) {
        if (this.gbz) {
            if (this.chb != null) {
                this.aRG.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.aRG.getPageActivity(), this.chb.channelId, 2)));
            }
        } else if (this.gbC != null) {
            this.gbC.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhk() {
        if (this.gbz) {
            if (!l.pa()) {
                this.aRG.showToast(d.j.no_network_guide);
            } else if (this.chb != null && this.chb.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ay.aZ(this.aRG.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0095a.a(this.chb.channelId, this.aRG.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, j jVar) {
        this.cqE = bdVar;
        a(jVar.baW(), jVar.baU());
        if (bdVar.Ao() != null) {
            this.gbz = true;
            this.gby.setVisibility(8);
            this.gbu.setVisibility(0);
            ae(bdVar);
        } else {
            this.gbz = false;
            this.gby.setVisibility(0);
            this.gbu.setVisibility(8);
            o(postData);
        }
        if (ab(bdVar)) {
            this.gbu.setVisibility(8);
            this.gby.setVisibility(8);
        }
    }

    private boolean ab(bd bdVar) {
        if (bdVar == null || bdVar.zn() == null || bdVar.zn().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.zn().getUserId());
    }

    private void o(PostData postData) {
        this.gbx.setVisibility(8);
        this.gbr.setUserId(postData.zn().getUserId());
        this.gbr.setUserName(postData.zn().getUserName());
        this.gbr.setIsBigV(postData.zn().isBigV());
        this.gbs.setText(postData.zn().getUserName());
        this.gbs.setTag(postData.zn().getUserId());
        this.gbr.startLoad(postData.zn().getPortrait(), 28, false);
        this.gbB.a(postData.zn());
    }

    private void ae(bd bdVar) {
        this.gbx.setVisibility(0);
        this.chb = bdVar.Ao();
        if (this.chb.aQF == 1) {
            this.gbA = 0;
        } else {
            this.gbA = this.chb.aQF;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gbA = 2;
        }
        this.gbs.setText(this.chb.channelName);
        this.gbr.startLoad(this.chb.channelAvatar, 10, false);
        i(this.gbA, this.chb.channelId);
    }

    public void i(int i, long j) {
        if (this.chb != null && j > 0 && j == this.chb.channelId) {
            if (i == 1) {
                this.gbu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.gbu, d.C0141d.cp_bg_line_d_alpha80);
                this.gbu.setClickable(false);
                this.gbu.setText(d.j.has_ordered_channel);
                return;
            }
            this.gbu.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbu, d.C0141d.cp_cont_i);
            this.gbu.setClickable(true);
            this.gbu.setText(d.j.order_video_channel);
        }
    }

    public void at(float f) {
        this.gbt.setAlpha(f);
    }

    public View bhl() {
        return this.gbt;
    }

    public void gB(int i) {
        if (this.gby != null) {
            this.gby.onChangeSkinType(i);
        }
        if (this.gbv != null) {
            aj.r(this.gbv, d.C0141d.cp_cont_i);
        }
        if (this.gbA == 1) {
            aj.r(this.gbu, d.C0141d.cp_bg_line_d_alpha80);
        } else {
            aj.r(this.gbu, d.C0141d.cp_cont_i);
        }
        if (this.gbs != null) {
            aj.r(this.gbs, d.C0141d.cp_cont_i);
        }
        if (this.gbx != null) {
            aj.s(this.gbx, d.f.icon_weiba);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.gbC = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.gbD = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdJ != null) {
            this.bdJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.gbv.setText(am.F(j));
        if (z) {
            this.gbw.setImageResource(d.f.icon_floor_praised);
        } else {
            this.gbw.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bdJ);
    }
}
