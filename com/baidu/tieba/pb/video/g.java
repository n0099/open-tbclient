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
    private TbPageContext<?> aRI;
    private bj che;
    private bd cqH;
    private View fcc;
    private HeadImageView gbH;
    private TextView gbI;
    private RelativeLayout gbJ;
    private TextView gbK;
    private TextView gbL;
    private ImageView gbM;
    private ImageView gbN;
    private PbVideoFullUserInfoLikeButton gbO;
    public int gbQ;
    private f gbR;
    private View.OnClickListener gbS;
    private View.OnClickListener gbT;
    private LinearLayout gbU;
    private boolean gbP = false;
    private View.OnClickListener bML = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gbM) {
                g.this.cD(view);
            } else if (view == g.this.gbH || view == g.this.gbI || view == g.this.gbN) {
                g.this.cE(view);
            } else if (view == g.this.gbK) {
                g.this.bhl();
            }
        }
    };
    private CustomMessageListener bdM = new CustomMessageListener(2016551) { // from class: com.baidu.tieba.pb.video.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.pb.data.i) && g.this.cqH != null && g.this.cqH.getId() != null) {
                com.baidu.tieba.pb.data.i iVar = (com.baidu.tieba.pb.data.i) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(iVar.pid) && iVar.pid.equals(g.this.cqH.zE())) {
                    g.this.a(iVar.fIc == 0, iVar.fId.baV());
                }
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.aRI = tbPageContext;
        this.fcc = p(tbPageContext);
        initView();
        o(this.aRI.getUniqueId());
        frameLayout.addView(this.fcc);
    }

    private View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gbJ = (RelativeLayout) this.fcc.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.gbH = (HeadImageView) this.fcc.findViewById(d.g.pbVideoFullPhoto);
        this.gbH.setOnClickListener(this.bML);
        this.gbU = (LinearLayout) this.fcc.findViewById(d.g.pbVideoFullNameLayout);
        aj.s(this.gbU, d.f.video_author_bg);
        this.gbI = (TextView) this.fcc.findViewById(d.g.pbVideoFullUserName);
        this.gbI.setOnClickListener(this.bML);
        this.gbK = (TextView) this.fcc.findViewById(d.g.pbVideoFullAttention);
        this.gbK.setOnClickListener(this.bML);
        this.gbL = (TextView) this.fcc.findViewById(d.g.pbVideoFullZanCount);
        this.gbM = (ImageView) this.fcc.findViewById(d.g.pbVideoFullZanLabel);
        this.gbM.setOnClickListener(this.bML);
        this.gbN = (ImageView) this.fcc.findViewById(d.g.pbVideoFullChannelIcon);
        this.gbO = (PbVideoFullUserInfoLikeButton) this.fcc.findViewById(d.g.pbVideoFullLikeButton);
        this.gbO.setTextSize(0, l.t(this.aRI.getPageActivity(), d.e.tbds30));
        this.gbR = new f(this.aRI, this.gbO);
        this.gbH.setRadius(l.t(this.aRI.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
        if (this.gbT != null) {
            this.gbT.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(View view) {
        if (this.gbP) {
            if (this.che != null) {
                this.aRI.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.aRI.getPageActivity(), this.che.channelId, 2)));
            }
        } else if (this.gbS != null) {
            this.gbS.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        if (this.gbP) {
            if (!l.pa()) {
                this.aRI.showToast(d.j.no_network_guide);
            } else if (this.che != null && this.che.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ay.aZ(this.aRI.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0095a.a(this.che.channelId, this.aRI.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bd bdVar, j jVar) {
        this.cqH = bdVar;
        a(jVar.baX(), jVar.baV());
        if (bdVar.Ao() != null) {
            this.gbP = true;
            this.gbO.setVisibility(8);
            this.gbK.setVisibility(0);
            ae(bdVar);
        } else {
            this.gbP = false;
            this.gbO.setVisibility(0);
            this.gbK.setVisibility(8);
            o(postData);
        }
        if (ab(bdVar)) {
            this.gbK.setVisibility(8);
            this.gbO.setVisibility(8);
        }
    }

    private boolean ab(bd bdVar) {
        if (bdVar == null || bdVar.zn() == null || bdVar.zn().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bdVar.zn().getUserId());
    }

    private void o(PostData postData) {
        this.gbN.setVisibility(8);
        this.gbH.setUserId(postData.zn().getUserId());
        this.gbH.setUserName(postData.zn().getUserName());
        this.gbH.setIsBigV(postData.zn().isBigV());
        this.gbI.setText(postData.zn().getUserName());
        this.gbI.setTag(postData.zn().getUserId());
        this.gbH.startLoad(postData.zn().getPortrait(), 28, false);
        this.gbR.a(postData.zn());
    }

    private void ae(bd bdVar) {
        this.gbN.setVisibility(0);
        this.che = bdVar.Ao();
        if (this.che.aQH == 1) {
            this.gbQ = 0;
        } else {
            this.gbQ = this.che.aQH;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gbQ = 2;
        }
        this.gbI.setText(this.che.channelName);
        this.gbH.startLoad(this.che.channelAvatar, 10, false);
        i(this.gbQ, this.che.channelId);
    }

    public void i(int i, long j) {
        if (this.che != null && j > 0 && j == this.che.channelId) {
            if (i == 1) {
                this.gbK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.gbK, d.C0141d.cp_bg_line_d_alpha80);
                this.gbK.setClickable(false);
                this.gbK.setText(d.j.has_ordered_channel);
                return;
            }
            this.gbK.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbK, d.C0141d.cp_cont_i);
            this.gbK.setClickable(true);
            this.gbK.setText(d.j.order_video_channel);
        }
    }

    public void at(float f) {
        this.gbJ.setAlpha(f);
    }

    public View bhm() {
        return this.gbJ;
    }

    public void gB(int i) {
        if (this.gbO != null) {
            this.gbO.onChangeSkinType(i);
        }
        if (this.gbL != null) {
            aj.r(this.gbL, d.C0141d.cp_cont_i);
        }
        if (this.gbQ == 1) {
            aj.r(this.gbK, d.C0141d.cp_bg_line_d_alpha80);
        } else {
            aj.r(this.gbK, d.C0141d.cp_cont_i);
        }
        if (this.gbI != null) {
            aj.r(this.gbI, d.C0141d.cp_cont_i);
        }
        if (this.gbN != null) {
            aj.s(this.gbN, d.f.icon_weiba);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.gbS = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.gbT = onClickListener;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdM != null) {
            this.bdM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        this.gbL.setText(am.F(j));
        if (z) {
            this.gbM.setImageResource(d.f.icon_floor_praised);
        } else {
            this.gbM.setImageResource(d.f.icon_video_recommend_like_n);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bdM);
    }
}
