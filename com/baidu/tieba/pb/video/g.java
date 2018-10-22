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
/* loaded from: classes6.dex */
public class g {
    private bh bQk;
    private bb cgP;
    private View ffV;
    private HeadImageView gbU;
    private TextView gbV;
    private RelativeLayout gbW;
    private TextView gbX;
    private ImageView gbY;
    private PbVideoFullUserInfoLikeButton gbZ;
    public int gcb;
    private f gcc;
    private View.OnClickListener gcd;
    private LinearLayout gce;
    private TbPageContext<?> mContext;
    private boolean gca = false;
    private View.OnClickListener bzR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gbU || view == g.this.gbV || view == g.this.gbY) {
                g.this.bF(view);
            } else if (view == g.this.gbX) {
                g.this.blU();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.ffV = q(tbPageContext);
        initView();
        frameLayout.addView(this.ffV);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gbW = (RelativeLayout) this.ffV.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.gbU = (HeadImageView) this.ffV.findViewById(e.g.pbVideoFullPhoto);
        this.gbU.setOnClickListener(this.bzR);
        this.gce = (LinearLayout) this.ffV.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.gce, e.f.video_author_bg);
        this.gbV = (TextView) this.ffV.findViewById(e.g.pbVideoFullUserName);
        this.gbV.setOnClickListener(this.bzR);
        this.gbX = (TextView) this.ffV.findViewById(e.g.pbVideoFullAttention);
        this.gbX.setOnClickListener(this.bzR);
        this.gbY = (ImageView) this.ffV.findViewById(e.g.pbVideoFullChannelIcon);
        this.gbZ = (PbVideoFullUserInfoLikeButton) this.ffV.findViewById(e.g.pbVideoFullLikeButton);
        this.gbZ.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0175e.tbds30));
        this.gcc = new f(this.mContext, this.gbZ);
        this.gbU.setRadius(l.h(this.mContext.getPageActivity(), e.C0175e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(View view) {
        if (this.gca) {
            if (this.bQk != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bQk.channelId, 2)));
            }
        } else if (this.gcd != null) {
            this.gcd.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blU() {
        if (this.gca) {
            if (!l.lo()) {
                this.mContext.showToast(e.j.no_network_guide);
            } else if (this.bQk != null && this.bQk.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.bH(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0122a.a(this.bQk.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        this.cgP = bbVar;
        if (bbVar.zy() != null) {
            this.gca = true;
            this.gbZ.setVisibility(8);
            this.gbX.setVisibility(0);
            ap(bbVar);
        } else {
            this.gca = false;
            this.gbZ.setVisibility(0);
            this.gbX.setVisibility(8);
            o(postData);
        }
        if (am(bbVar)) {
            this.gbX.setVisibility(8);
            this.gbZ.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.yv() == null || bbVar.yv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.yv().getUserId());
    }

    private void o(PostData postData) {
        this.gbY.setVisibility(8);
        this.gbU.setUserId(postData.yv().getUserId());
        this.gbU.setUserName(postData.yv().getUserName());
        this.gbU.setIsBigV(postData.yv().isBigV());
        this.gbV.setText(postData.yv().getName_show());
        this.gbV.setTag(postData.yv().getUserId());
        this.gbU.startLoad(postData.yv().getPortrait(), 28, false);
        this.gcc.a(postData.yv());
    }

    private void ap(bb bbVar) {
        this.gbY.setVisibility(0);
        this.bQk = bbVar.zy();
        if (this.bQk.arL == 1) {
            this.gcb = 0;
        } else {
            this.gcb = this.bQk.arL;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gcb = 2;
        }
        this.gbV.setText(this.bQk.channelName);
        this.gbU.startLoad(this.bQk.channelAvatar, 10, false);
        l(this.gcb, this.bQk.channelId);
    }

    public void l(int i, long j) {
        if (this.bQk != null && j > 0 && j == this.bQk.channelId) {
            if (i == 1) {
                this.gbX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gbX, e.d.cp_bg_line_d_alpha80);
                this.gbX.setClickable(false);
                this.gbX.setText(e.j.has_ordered_channel);
                return;
            }
            this.gbX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbX, e.d.cp_cont_i);
            this.gbX.setClickable(true);
            this.gbX.setText(e.j.order_video_channel);
        }
    }

    public void au(float f) {
        this.gbW.setAlpha(f);
    }

    public View blV() {
        return this.gbW;
    }

    public void ea(int i) {
        if (this.gbZ != null) {
            this.gbZ.onChangeSkinType(i);
        }
        if (this.gcb == 1) {
            al.h(this.gbX, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.gbX, e.d.cp_cont_i);
        }
        if (this.gbV != null) {
            al.h(this.gbV, e.d.cp_cont_i);
        }
        if (this.gbY != null) {
            al.i(this.gbY, e.f.icon_weiba);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        this.gcd = onClickListener;
    }

    public void onDestroy() {
    }
}
