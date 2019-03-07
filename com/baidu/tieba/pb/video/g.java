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
    private View gHW;
    private HeadImageView hEo;
    private TextView hEp;
    private RelativeLayout hEq;
    private TextView hEr;
    private ImageView hEs;
    private PbVideoFullUserInfoLikeButton hEt;
    public int hEv;
    private f hEw;
    private View.OnClickListener hEx;
    private LinearLayout hEy;
    private TbPageContext<?> mContext;
    private boolean hEu = false;
    private View.OnClickListener cPX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hEo || view == g.this.hEp || view == g.this.hEs) {
                g.this.cx(view);
            } else if (view == g.this.hEr) {
                g.this.bOY();
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
        this.hEq = (RelativeLayout) this.gHW.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.hEo = (HeadImageView) this.gHW.findViewById(d.g.pbVideoFullPhoto);
        this.hEo.setOnClickListener(this.cPX);
        this.hEy = (LinearLayout) this.gHW.findViewById(d.g.pbVideoFullNameLayout);
        al.k(this.hEy, d.f.video_author_bg);
        this.hEp = (TextView) this.gHW.findViewById(d.g.pbVideoFullUserName);
        this.hEp.setOnClickListener(this.cPX);
        this.hEr = (TextView) this.gHW.findViewById(d.g.pbVideoFullAttention);
        this.hEr.setOnClickListener(this.cPX);
        this.hEs = (ImageView) this.gHW.findViewById(d.g.pbVideoFullChannelIcon);
        this.hEt = (PbVideoFullUserInfoLikeButton) this.gHW.findViewById(d.g.pbVideoFullLikeButton);
        this.hEt.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds30));
        this.hEw = new f(this.mContext, this.hEt);
        this.hEo.setRadius(l.h(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(View view) {
        if (this.hEu) {
            if (this.dkC != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dkC.channelId, 2)));
            }
        } else if (this.hEx != null) {
            this.hEx.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOY() {
        if (this.hEu) {
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
            this.hEu = true;
            this.hEt.setVisibility(8);
            this.hEr.setVisibility(0);
            aB(bgVar);
        } else {
            this.hEu = false;
            this.hEt.setVisibility(0);
            this.hEr.setVisibility(8);
            q(postData);
        }
        if (ay(bgVar)) {
            this.hEr.setVisibility(8);
            this.hEt.setVisibility(8);
        }
    }

    private boolean ay(bg bgVar) {
        if (bgVar == null || bgVar.YR() == null || bgVar.YR().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.YR().getUserId());
    }

    private void q(PostData postData) {
        this.hEs.setVisibility(8);
        this.hEo.setUserId(postData.YR().getUserId());
        this.hEo.setUserName(postData.YR().getUserName());
        this.hEo.setIsBigV(postData.YR().isBigV());
        this.hEp.setText(postData.YR().getName_show());
        this.hEp.setTag(postData.YR().getUserId());
        this.hEo.startLoad(postData.YR().getPortrait(), 28, false);
        this.hEw.a(postData.YR());
    }

    private void aB(bg bgVar) {
        this.hEs.setVisibility(0);
        this.dkC = bgVar.aab();
        if (this.dkC.bEg == 1) {
            this.hEv = 0;
        } else {
            this.hEv = this.dkC.bEg;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hEv = 2;
        }
        this.hEp.setText(this.dkC.channelName);
        this.hEo.startLoad(this.dkC.channelAvatar, 10, false);
        o(this.hEv, this.dkC.channelId);
    }

    public void o(int i, long j) {
        if (this.dkC != null && j > 0 && j == this.dkC.channelId) {
            if (i == 1) {
                this.hEr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hEr, d.C0236d.cp_bg_line_d_alpha80);
                this.hEr.setClickable(false);
                this.hEr.setText(d.j.has_ordered_channel);
                return;
            }
            this.hEr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEr, d.C0236d.cp_btn_a);
            this.hEr.setClickable(true);
            this.hEr.setText(d.j.order_video_channel);
        }
    }

    public void aJ(float f) {
        this.hEq.setAlpha(f);
    }

    public View bOZ() {
        return this.hEq;
    }

    public void ij(int i) {
        if (this.hEt != null) {
            this.hEt.onChangeSkinType(i);
        }
        if (this.hEv == 1) {
            al.j(this.hEr, d.C0236d.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hEr, d.C0236d.cp_btn_a);
        }
        if (this.hEp != null) {
            al.j(this.hEp, d.C0236d.cp_btn_a);
        }
        if (this.hEs != null) {
            al.k(this.hEs, d.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.hEx = onClickListener;
    }

    public void onDestroy() {
    }
}
