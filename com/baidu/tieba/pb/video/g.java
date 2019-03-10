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
    private bg dAK;
    private bm dkC;
    private View gHX;
    private HeadImageView hEp;
    private TextView hEq;
    private RelativeLayout hEr;
    private TextView hEs;
    private ImageView hEt;
    private PbVideoFullUserInfoLikeButton hEu;
    public int hEw;
    private f hEx;
    private View.OnClickListener hEy;
    private LinearLayout hEz;
    private TbPageContext<?> mContext;
    private boolean hEv = false;
    private View.OnClickListener cPX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hEp || view == g.this.hEq || view == g.this.hEt) {
                g.this.cx(view);
            } else if (view == g.this.hEs) {
                g.this.bOZ();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.gHX = r(tbPageContext);
        initView();
        frameLayout.addView(this.gHX);
    }

    private View r(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.hEr = (RelativeLayout) this.gHX.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.hEp = (HeadImageView) this.gHX.findViewById(d.g.pbVideoFullPhoto);
        this.hEp.setOnClickListener(this.cPX);
        this.hEz = (LinearLayout) this.gHX.findViewById(d.g.pbVideoFullNameLayout);
        al.k(this.hEz, d.f.video_author_bg);
        this.hEq = (TextView) this.gHX.findViewById(d.g.pbVideoFullUserName);
        this.hEq.setOnClickListener(this.cPX);
        this.hEs = (TextView) this.gHX.findViewById(d.g.pbVideoFullAttention);
        this.hEs.setOnClickListener(this.cPX);
        this.hEt = (ImageView) this.gHX.findViewById(d.g.pbVideoFullChannelIcon);
        this.hEu = (PbVideoFullUserInfoLikeButton) this.gHX.findViewById(d.g.pbVideoFullLikeButton);
        this.hEu.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds30));
        this.hEx = new f(this.mContext, this.hEu);
        this.hEp.setRadius(l.h(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(View view) {
        if (this.hEv) {
            if (this.dkC != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dkC.channelId, 2)));
            }
        } else if (this.hEy != null) {
            this.hEy.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOZ() {
        if (this.hEv) {
            if (!l.lo()) {
                this.mContext.showToast(d.j.no_network_guide);
            } else if (this.dkC != null && this.dkC.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0189a.a(this.dkC.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        this.dAK = bgVar;
        if (bgVar.aab() != null) {
            this.hEv = true;
            this.hEu.setVisibility(8);
            this.hEs.setVisibility(0);
            aB(bgVar);
        } else {
            this.hEv = false;
            this.hEu.setVisibility(0);
            this.hEs.setVisibility(8);
            q(postData);
        }
        if (ay(bgVar)) {
            this.hEs.setVisibility(8);
            this.hEu.setVisibility(8);
        }
    }

    private boolean ay(bg bgVar) {
        if (bgVar == null || bgVar.YR() == null || bgVar.YR().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.YR().getUserId());
    }

    private void q(PostData postData) {
        this.hEt.setVisibility(8);
        this.hEp.setUserId(postData.YR().getUserId());
        this.hEp.setUserName(postData.YR().getUserName());
        this.hEp.setIsBigV(postData.YR().isBigV());
        this.hEq.setText(postData.YR().getName_show());
        this.hEq.setTag(postData.YR().getUserId());
        this.hEp.startLoad(postData.YR().getPortrait(), 28, false);
        this.hEx.a(postData.YR());
    }

    private void aB(bg bgVar) {
        this.hEt.setVisibility(0);
        this.dkC = bgVar.aab();
        if (this.dkC.bEg == 1) {
            this.hEw = 0;
        } else {
            this.hEw = this.dkC.bEg;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hEw = 2;
        }
        this.hEq.setText(this.dkC.channelName);
        this.hEp.startLoad(this.dkC.channelAvatar, 10, false);
        o(this.hEw, this.dkC.channelId);
    }

    public void o(int i, long j) {
        if (this.dkC != null && j > 0 && j == this.dkC.channelId) {
            if (i == 1) {
                this.hEs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hEs, d.C0236d.cp_bg_line_d_alpha80);
                this.hEs.setClickable(false);
                this.hEs.setText(d.j.has_ordered_channel);
                return;
            }
            this.hEs.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEs, d.C0236d.cp_btn_a);
            this.hEs.setClickable(true);
            this.hEs.setText(d.j.order_video_channel);
        }
    }

    public void aJ(float f) {
        this.hEr.setAlpha(f);
    }

    public View bPa() {
        return this.hEr;
    }

    public void ij(int i) {
        if (this.hEu != null) {
            this.hEu.onChangeSkinType(i);
        }
        if (this.hEw == 1) {
            al.j(this.hEs, d.C0236d.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hEs, d.C0236d.cp_btn_a);
        }
        if (this.hEq != null) {
            al.j(this.hEq, d.C0236d.cp_btn_a);
        }
        if (this.hEt != null) {
            al.k(this.hEt, d.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.hEy = onClickListener;
    }

    public void onDestroy() {
    }
}
