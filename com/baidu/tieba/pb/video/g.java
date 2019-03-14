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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class g {
    private bg dAG;
    private bm dky;
    private View gHW;
    private HeadImageView hEj;
    private TextView hEk;
    private RelativeLayout hEl;
    private TextView hEm;
    private ImageView hEn;
    private PbVideoFullUserInfoLikeButton hEo;
    public int hEq;
    private f hEr;
    private View.OnClickListener hEs;
    private LinearLayout hEt;
    private TbPageContext<?> mContext;
    private boolean hEp = false;
    private View.OnClickListener cPU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hEj || view == g.this.hEk || view == g.this.hEn) {
                g.this.cx(view);
            } else if (view == g.this.hEm) {
                g.this.bOZ();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.gHW = r(tbPageContext);
        initView();
        frameLayout.addView(this.gHW);
    }

    private View r(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.hEl = (RelativeLayout) this.gHW.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.hEj = (HeadImageView) this.gHW.findViewById(d.g.pbVideoFullPhoto);
        this.hEj.setOnClickListener(this.cPU);
        this.hEt = (LinearLayout) this.gHW.findViewById(d.g.pbVideoFullNameLayout);
        al.k(this.hEt, d.f.video_author_bg);
        this.hEk = (TextView) this.gHW.findViewById(d.g.pbVideoFullUserName);
        this.hEk.setOnClickListener(this.cPU);
        this.hEm = (TextView) this.gHW.findViewById(d.g.pbVideoFullAttention);
        this.hEm.setOnClickListener(this.cPU);
        this.hEn = (ImageView) this.gHW.findViewById(d.g.pbVideoFullChannelIcon);
        this.hEo = (PbVideoFullUserInfoLikeButton) this.gHW.findViewById(d.g.pbVideoFullLikeButton);
        this.hEo.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds30));
        this.hEr = new f(this.mContext, this.hEo);
        this.hEj.setRadius(l.h(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(View view) {
        if (this.hEp) {
            if (this.dky != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dky.channelId, 2)));
            }
        } else if (this.hEs != null) {
            this.hEs.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOZ() {
        if (this.hEp) {
            if (!l.lo()) {
                this.mContext.showToast(d.j.no_network_guide);
            } else if (this.dky != null && this.dky.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0223a.a(this.dky.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        this.dAG = bgVar;
        if (bgVar.aab() != null) {
            this.hEp = true;
            this.hEo.setVisibility(8);
            this.hEm.setVisibility(0);
            aB(bgVar);
        } else {
            this.hEp = false;
            this.hEo.setVisibility(0);
            this.hEm.setVisibility(8);
            q(postData);
        }
        if (ay(bgVar)) {
            this.hEm.setVisibility(8);
            this.hEo.setVisibility(8);
        }
    }

    private boolean ay(bg bgVar) {
        if (bgVar == null || bgVar.YR() == null || bgVar.YR().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.YR().getUserId());
    }

    private void q(PostData postData) {
        this.hEn.setVisibility(8);
        this.hEj.setUserId(postData.YR().getUserId());
        this.hEj.setUserName(postData.YR().getUserName());
        this.hEj.setIsBigV(postData.YR().isBigV());
        this.hEk.setText(postData.YR().getName_show());
        this.hEk.setTag(postData.YR().getUserId());
        this.hEj.startLoad(postData.YR().getPortrait(), 28, false);
        this.hEr.a(postData.YR());
    }

    private void aB(bg bgVar) {
        this.hEn.setVisibility(0);
        this.dky = bgVar.aab();
        if (this.dky.bEi == 1) {
            this.hEq = 0;
        } else {
            this.hEq = this.dky.bEi;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hEq = 2;
        }
        this.hEk.setText(this.dky.channelName);
        this.hEj.startLoad(this.dky.channelAvatar, 10, false);
        o(this.hEq, this.dky.channelId);
    }

    public void o(int i, long j) {
        if (this.dky != null && j > 0 && j == this.dky.channelId) {
            if (i == 1) {
                this.hEm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hEm, d.C0277d.cp_bg_line_d_alpha80);
                this.hEm.setClickable(false);
                this.hEm.setText(d.j.has_ordered_channel);
                return;
            }
            this.hEm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEm, d.C0277d.cp_btn_a);
            this.hEm.setClickable(true);
            this.hEm.setText(d.j.order_video_channel);
        }
    }

    public void aJ(float f) {
        this.hEl.setAlpha(f);
    }

    public View bPa() {
        return this.hEl;
    }

    public void ij(int i) {
        if (this.hEo != null) {
            this.hEo.onChangeSkinType(i);
        }
        if (this.hEq == 1) {
            al.j(this.hEm, d.C0277d.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hEm, d.C0277d.cp_btn_a);
        }
        if (this.hEk != null) {
            al.j(this.hEk, d.C0277d.cp_btn_a);
        }
        if (this.hEn != null) {
            al.k(this.hEn, d.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.hEs = onClickListener;
    }

    public void onDestroy() {
    }
}
