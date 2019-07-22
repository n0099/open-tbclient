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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class g {
    private bg dOL;
    private bm dxr;
    private View hfu;
    private HeadImageView icn;
    private TextView ico;
    private RelativeLayout icp;
    private TextView icq;
    private ImageView icr;
    private PbVideoFullUserInfoLikeButton ics;
    public int icu;
    private f icv;
    private View.OnClickListener icw;
    private LinearLayout icx;
    private TbPageContext<?> mContext;
    private boolean ict = false;
    private View.OnClickListener cZG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.icn || view == g.this.ico || view == g.this.icr) {
                g.this.cI(view);
            } else if (view == g.this.icq) {
                g.this.bZI();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.hfu = s(tbPageContext);
        initView();
        frameLayout.addView(this.hfu);
    }

    private View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.icp = (RelativeLayout) this.hfu.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.icn = (HeadImageView) this.hfu.findViewById(R.id.pbVideoFullPhoto);
        this.icn.setOnClickListener(this.cZG);
        this.icx = (LinearLayout) this.hfu.findViewById(R.id.pbVideoFullNameLayout);
        am.k(this.icx, R.drawable.video_author_bg);
        this.ico = (TextView) this.hfu.findViewById(R.id.pbVideoFullUserName);
        this.ico.setOnClickListener(this.cZG);
        this.icq = (TextView) this.hfu.findViewById(R.id.pbVideoFullAttention);
        this.icq.setOnClickListener(this.cZG);
        this.icr = (ImageView) this.hfu.findViewById(R.id.pbVideoFullChannelIcon);
        this.ics = (PbVideoFullUserInfoLikeButton) this.hfu.findViewById(R.id.pbVideoFullLikeButton);
        this.ics.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds30));
        this.icv = new f(this.mContext, this.ics);
        this.icn.setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(View view) {
        if (this.ict) {
            if (this.dxr != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dxr.channelId, 2)));
            }
        } else if (this.icw != null) {
            this.icw.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZI() {
        if (this.ict) {
            if (!l.kt()) {
                this.mContext.showToast((int) R.string.no_network_guide);
            } else if (this.dxr != null && this.dxr.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bd.cE(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0235a.a(this.dxr.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bg bgVar, j jVar) {
        this.dOL = bgVar;
        if (bgVar.afH() != null) {
            this.ict = true;
            this.ics.setVisibility(8);
            this.icq.setVisibility(0);
            ay(bgVar);
        } else {
            this.ict = false;
            this.ics.setVisibility(0);
            this.icq.setVisibility(8);
            q(postData);
        }
        if (av(bgVar)) {
            this.icq.setVisibility(8);
            this.ics.setVisibility(8);
        }
    }

    private boolean av(bg bgVar) {
        if (bgVar == null || bgVar.aex() == null || bgVar.aex().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.aex().getUserId());
    }

    private void q(PostData postData) {
        this.icr.setVisibility(8);
        this.icn.setUserId(postData.aex().getUserId());
        this.icn.setUserName(postData.aex().getUserName());
        this.icn.setIsBigV(postData.aex().isBigV());
        this.ico.setText(postData.aex().getName_show());
        this.ico.setTag(postData.aex().getUserId());
        this.icn.startLoad(postData.aex().getPortrait(), 28, false);
        this.icv.a(postData.aex());
    }

    private void ay(bg bgVar) {
        this.icr.setVisibility(0);
        this.dxr = bgVar.afH();
        if (this.dxr.bMG == 1) {
            this.icu = 0;
        } else {
            this.icu = this.dxr.bMG;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.icu = 2;
        }
        this.ico.setText(this.dxr.channelName);
        this.icn.startLoad(this.dxr.channelAvatar, 10, false);
        w(this.icu, this.dxr.channelId);
    }

    public void w(int i, long j) {
        if (this.dxr != null && j > 0 && j == this.dxr.channelId) {
            if (i == 1) {
                this.icq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.icq, R.color.cp_bg_line_d_alpha80);
                this.icq.setClickable(false);
                this.icq.setText(R.string.has_ordered_channel);
                return;
            }
            this.icq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.icq, R.color.cp_btn_a);
            this.icq.setClickable(true);
            this.icq.setText(R.string.order_video_channel);
        }
    }

    public void aO(float f) {
        this.icp.setAlpha(f);
    }

    public View bZJ() {
        return this.icp;
    }

    public void jc(int i) {
        if (this.ics != null) {
            this.ics.onChangeSkinType(i);
        }
        if (this.icu == 1) {
            am.j(this.icq, R.color.cp_bg_line_d_alpha80);
        } else {
            am.j(this.icq, R.color.cp_btn_a);
        }
        if (this.ico != null) {
            am.j(this.ico, R.color.cp_btn_a);
        }
        if (this.icr != null) {
            am.k(this.icr, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.icw = onClickListener;
    }

    public void onDestroy() {
    }
}
