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
    private bg dAC;
    private bm dkB;
    private View gHJ;
    private HeadImageView hDV;
    private TextView hDW;
    private RelativeLayout hDX;
    private TextView hDY;
    private ImageView hDZ;
    private PbVideoFullUserInfoLikeButton hEa;
    public int hEc;
    private f hEd;
    private View.OnClickListener hEe;
    private LinearLayout hEf;
    private TbPageContext<?> mContext;
    private boolean hEb = false;
    private View.OnClickListener cPW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hDV || view == g.this.hDW || view == g.this.hDZ) {
                g.this.cx(view);
            } else if (view == g.this.hDY) {
                g.this.bOW();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.gHJ = q(tbPageContext);
        initView();
        frameLayout.addView(this.gHJ);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.hDX = (RelativeLayout) this.gHJ.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.hDV = (HeadImageView) this.gHJ.findViewById(d.g.pbVideoFullPhoto);
        this.hDV.setOnClickListener(this.cPW);
        this.hEf = (LinearLayout) this.gHJ.findViewById(d.g.pbVideoFullNameLayout);
        al.k(this.hEf, d.f.video_author_bg);
        this.hDW = (TextView) this.gHJ.findViewById(d.g.pbVideoFullUserName);
        this.hDW.setOnClickListener(this.cPW);
        this.hDY = (TextView) this.gHJ.findViewById(d.g.pbVideoFullAttention);
        this.hDY.setOnClickListener(this.cPW);
        this.hDZ = (ImageView) this.gHJ.findViewById(d.g.pbVideoFullChannelIcon);
        this.hEa = (PbVideoFullUserInfoLikeButton) this.gHJ.findViewById(d.g.pbVideoFullLikeButton);
        this.hEa.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds30));
        this.hEd = new f(this.mContext, this.hEa);
        this.hDV.setRadius(l.h(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(View view) {
        if (this.hEb) {
            if (this.dkB != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dkB.channelId, 2)));
            }
        } else if (this.hEe != null) {
            this.hEe.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOW() {
        if (this.hEb) {
            if (!l.lo()) {
                this.mContext.showToast(d.j.no_network_guide);
            } else if (this.dkB != null && this.dkB.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0223a.a(this.dkB.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        this.dAC = bgVar;
        if (bgVar.ZY() != null) {
            this.hEb = true;
            this.hEa.setVisibility(8);
            this.hDY.setVisibility(0);
            aA(bgVar);
        } else {
            this.hEb = false;
            this.hEa.setVisibility(0);
            this.hDY.setVisibility(8);
            q(postData);
        }
        if (ax(bgVar)) {
            this.hDY.setVisibility(8);
            this.hEa.setVisibility(8);
        }
    }

    private boolean ax(bg bgVar) {
        if (bgVar == null || bgVar.YO() == null || bgVar.YO().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.YO().getUserId());
    }

    private void q(PostData postData) {
        this.hDZ.setVisibility(8);
        this.hDV.setUserId(postData.YO().getUserId());
        this.hDV.setUserName(postData.YO().getUserName());
        this.hDV.setIsBigV(postData.YO().isBigV());
        this.hDW.setText(postData.YO().getName_show());
        this.hDW.setTag(postData.YO().getUserId());
        this.hDV.startLoad(postData.YO().getPortrait(), 28, false);
        this.hEd.a(postData.YO());
    }

    private void aA(bg bgVar) {
        this.hDZ.setVisibility(0);
        this.dkB = bgVar.ZY();
        if (this.dkB.bEl == 1) {
            this.hEc = 0;
        } else {
            this.hEc = this.dkB.bEl;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hEc = 2;
        }
        this.hDW.setText(this.dkB.channelName);
        this.hDV.startLoad(this.dkB.channelAvatar, 10, false);
        o(this.hEc, this.dkB.channelId);
    }

    public void o(int i, long j) {
        if (this.dkB != null && j > 0 && j == this.dkB.channelId) {
            if (i == 1) {
                this.hDY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hDY, d.C0277d.cp_bg_line_d_alpha80);
                this.hDY.setClickable(false);
                this.hDY.setText(d.j.has_ordered_channel);
                return;
            }
            this.hDY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDY, d.C0277d.cp_btn_a);
            this.hDY.setClickable(true);
            this.hDY.setText(d.j.order_video_channel);
        }
    }

    public void aJ(float f) {
        this.hDX.setAlpha(f);
    }

    public View bOX() {
        return this.hDX;
    }

    public void ii(int i) {
        if (this.hEa != null) {
            this.hEa.onChangeSkinType(i);
        }
        if (this.hEc == 1) {
            al.j(this.hDY, d.C0277d.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hDY, d.C0277d.cp_btn_a);
        }
        if (this.hDW != null) {
            al.j(this.hDW, d.C0277d.cp_btn_a);
        }
        if (this.hDZ != null) {
            al.k(this.hDZ, d.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.hEe = onClickListener;
    }

    public void onDestroy() {
    }
}
