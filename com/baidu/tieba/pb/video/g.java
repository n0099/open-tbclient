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
    private bg dAD;
    private bm dkC;
    private View gHK;
    private HeadImageView hDW;
    private TextView hDX;
    private RelativeLayout hDY;
    private TextView hDZ;
    private ImageView hEa;
    private PbVideoFullUserInfoLikeButton hEb;
    public int hEd;
    private f hEe;
    private View.OnClickListener hEf;
    private LinearLayout hEg;
    private TbPageContext<?> mContext;
    private boolean hEc = false;
    private View.OnClickListener cPX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hDW || view == g.this.hDX || view == g.this.hEa) {
                g.this.cx(view);
            } else if (view == g.this.hDZ) {
                g.this.bOW();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.gHK = q(tbPageContext);
        initView();
        frameLayout.addView(this.gHK);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.hDY = (RelativeLayout) this.gHK.findViewById(d.g.pbVideoFullUserInfoPanel);
        this.hDW = (HeadImageView) this.gHK.findViewById(d.g.pbVideoFullPhoto);
        this.hDW.setOnClickListener(this.cPX);
        this.hEg = (LinearLayout) this.gHK.findViewById(d.g.pbVideoFullNameLayout);
        al.k(this.hEg, d.f.video_author_bg);
        this.hDX = (TextView) this.gHK.findViewById(d.g.pbVideoFullUserName);
        this.hDX.setOnClickListener(this.cPX);
        this.hDZ = (TextView) this.gHK.findViewById(d.g.pbVideoFullAttention);
        this.hDZ.setOnClickListener(this.cPX);
        this.hEa = (ImageView) this.gHK.findViewById(d.g.pbVideoFullChannelIcon);
        this.hEb = (PbVideoFullUserInfoLikeButton) this.gHK.findViewById(d.g.pbVideoFullLikeButton);
        this.hEb.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds30));
        this.hEe = new f(this.mContext, this.hEb);
        this.hDW.setRadius(l.h(this.mContext.getPageActivity(), d.e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(View view) {
        if (this.hEc) {
            if (this.dkC != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dkC.channelId, 2)));
            }
        } else if (this.hEf != null) {
            this.hEf.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOW() {
        if (this.hEc) {
            if (!l.lo()) {
                this.mContext.showToast(d.j.no_network_guide);
            } else if (this.dkC != null && this.dkC.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cY(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0223a.a(this.dkC.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bg bgVar, com.baidu.tieba.pb.data.i iVar) {
        this.dAD = bgVar;
        if (bgVar.ZY() != null) {
            this.hEc = true;
            this.hEb.setVisibility(8);
            this.hDZ.setVisibility(0);
            aA(bgVar);
        } else {
            this.hEc = false;
            this.hEb.setVisibility(0);
            this.hDZ.setVisibility(8);
            q(postData);
        }
        if (ax(bgVar)) {
            this.hDZ.setVisibility(8);
            this.hEb.setVisibility(8);
        }
    }

    private boolean ax(bg bgVar) {
        if (bgVar == null || bgVar.YO() == null || bgVar.YO().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.YO().getUserId());
    }

    private void q(PostData postData) {
        this.hEa.setVisibility(8);
        this.hDW.setUserId(postData.YO().getUserId());
        this.hDW.setUserName(postData.YO().getUserName());
        this.hDW.setIsBigV(postData.YO().isBigV());
        this.hDX.setText(postData.YO().getName_show());
        this.hDX.setTag(postData.YO().getUserId());
        this.hDW.startLoad(postData.YO().getPortrait(), 28, false);
        this.hEe.a(postData.YO());
    }

    private void aA(bg bgVar) {
        this.hEa.setVisibility(0);
        this.dkC = bgVar.ZY();
        if (this.dkC.bEm == 1) {
            this.hEd = 0;
        } else {
            this.hEd = this.dkC.bEm;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hEd = 2;
        }
        this.hDX.setText(this.dkC.channelName);
        this.hDW.startLoad(this.dkC.channelAvatar, 10, false);
        o(this.hEd, this.dkC.channelId);
    }

    public void o(int i, long j) {
        if (this.dkC != null && j > 0 && j == this.dkC.channelId) {
            if (i == 1) {
                this.hDZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hDZ, d.C0277d.cp_bg_line_d_alpha80);
                this.hDZ.setClickable(false);
                this.hDZ.setText(d.j.has_ordered_channel);
                return;
            }
            this.hDZ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDZ, d.C0277d.cp_btn_a);
            this.hDZ.setClickable(true);
            this.hDZ.setText(d.j.order_video_channel);
        }
    }

    public void aJ(float f) {
        this.hDY.setAlpha(f);
    }

    public View bOX() {
        return this.hDY;
    }

    public void ii(int i) {
        if (this.hEb != null) {
            this.hEb.onChangeSkinType(i);
        }
        if (this.hEd == 1) {
            al.j(this.hDZ, d.C0277d.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hDZ, d.C0277d.cp_btn_a);
        }
        if (this.hDX != null) {
            al.j(this.hDX, d.C0277d.cp_btn_a);
        }
        if (this.hEa != null) {
            al.k(this.hEa, d.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.hEf = onClickListener;
    }

    public void onDestroy() {
    }
}
