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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class g {
    private bh bHH;
    private bb bYp;
    private View eYn;
    public int fUA;
    private f fUB;
    private View.OnClickListener fUC;
    private LinearLayout fUD;
    private HeadImageView fUt;
    private TextView fUu;
    private RelativeLayout fUv;
    private TextView fUw;
    private ImageView fUx;
    private PbVideoFullUserInfoLikeButton fUy;
    private TbPageContext<?> mContext;
    private boolean fUz = false;
    private View.OnClickListener bvP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.fUt || view == g.this.fUu || view == g.this.fUx) {
                g.this.bF(view);
            } else if (view == g.this.fUw) {
                g.this.biI();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.eYn = q(tbPageContext);
        initView();
        frameLayout.addView(this.eYn);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.fUv = (RelativeLayout) this.eYn.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.fUt = (HeadImageView) this.eYn.findViewById(e.g.pbVideoFullPhoto);
        this.fUt.setOnClickListener(this.bvP);
        this.fUD = (LinearLayout) this.eYn.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.fUD, e.f.video_author_bg);
        this.fUu = (TextView) this.eYn.findViewById(e.g.pbVideoFullUserName);
        this.fUu.setOnClickListener(this.bvP);
        this.fUw = (TextView) this.eYn.findViewById(e.g.pbVideoFullAttention);
        this.fUw.setOnClickListener(this.bvP);
        this.fUx = (ImageView) this.eYn.findViewById(e.g.pbVideoFullChannelIcon);
        this.fUy = (PbVideoFullUserInfoLikeButton) this.eYn.findViewById(e.g.pbVideoFullLikeButton);
        this.fUy.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0141e.tbds30));
        this.fUB = new f(this.mContext, this.fUy);
        this.fUt.setRadius(l.h(this.mContext.getPageActivity(), e.C0141e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(View view) {
        if (this.fUz) {
            if (this.bHH != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bHH.channelId, 2)));
            }
        } else if (this.fUC != null) {
            this.fUC.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biI() {
        if (this.fUz) {
            if (!l.lb()) {
                this.mContext.showToast(e.j.no_network_guide);
            } else if (this.bHH != null && this.bHH.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.bz(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0098a.a(this.bHH.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        this.bYp = bbVar;
        if (bbVar.xp() != null) {
            this.fUz = true;
            this.fUy.setVisibility(8);
            this.fUw.setVisibility(0);
            ap(bbVar);
        } else {
            this.fUz = false;
            this.fUy.setVisibility(0);
            this.fUw.setVisibility(8);
            o(postData);
        }
        if (am(bbVar)) {
            this.fUw.setVisibility(8);
            this.fUy.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.wm() == null || bbVar.wm().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.wm().getUserId());
    }

    private void o(PostData postData) {
        this.fUx.setVisibility(8);
        this.fUt.setUserId(postData.wm().getUserId());
        this.fUt.setUserName(postData.wm().getUserName());
        this.fUt.setIsBigV(postData.wm().isBigV());
        this.fUu.setText(postData.wm().getName_show());
        this.fUu.setTag(postData.wm().getUserId());
        this.fUt.startLoad(postData.wm().getPortrait(), 28, false);
        this.fUB.a(postData.wm());
    }

    private void ap(bb bbVar) {
        this.fUx.setVisibility(0);
        this.bHH = bbVar.xp();
        if (this.bHH.amQ == 1) {
            this.fUA = 0;
        } else {
            this.fUA = this.bHH.amQ;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.fUA = 2;
        }
        this.fUu.setText(this.bHH.channelName);
        this.fUt.startLoad(this.bHH.channelAvatar, 10, false);
        l(this.fUA, this.bHH.channelId);
    }

    public void l(int i, long j) {
        if (this.bHH != null && j > 0 && j == this.bHH.channelId) {
            if (i == 1) {
                this.fUw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.fUw, e.d.cp_bg_line_d_alpha80);
                this.fUw.setClickable(false);
                this.fUw.setText(e.j.has_ordered_channel);
                return;
            }
            this.fUw.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fUw, e.d.cp_cont_i);
            this.fUw.setClickable(true);
            this.fUw.setText(e.j.order_video_channel);
        }
    }

    public void at(float f) {
        this.fUv.setAlpha(f);
    }

    public View biJ() {
        return this.fUv;
    }

    public void dQ(int i) {
        if (this.fUy != null) {
            this.fUy.onChangeSkinType(i);
        }
        if (this.fUA == 1) {
            al.h(this.fUw, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.fUw, e.d.cp_cont_i);
        }
        if (this.fUu != null) {
            al.h(this.fUu, e.d.cp_cont_i);
        }
        if (this.fUx != null) {
            al.i(this.fUx, e.f.icon_weiba);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        this.fUC = onClickListener;
    }

    public void onDestroy() {
    }
}
