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
    private View ffU;
    private HeadImageView gbT;
    private TextView gbU;
    private RelativeLayout gbV;
    private TextView gbW;
    private ImageView gbX;
    private PbVideoFullUserInfoLikeButton gbY;
    public int gca;
    private f gcb;
    private View.OnClickListener gcc;
    private LinearLayout gcd;
    private TbPageContext<?> mContext;
    private boolean gbZ = false;
    private View.OnClickListener bzR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gbT || view == g.this.gbU || view == g.this.gbX) {
                g.this.bF(view);
            } else if (view == g.this.gbW) {
                g.this.blU();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.ffU = q(tbPageContext);
        initView();
        frameLayout.addView(this.ffU);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gbV = (RelativeLayout) this.ffU.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.gbT = (HeadImageView) this.ffU.findViewById(e.g.pbVideoFullPhoto);
        this.gbT.setOnClickListener(this.bzR);
        this.gcd = (LinearLayout) this.ffU.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.gcd, e.f.video_author_bg);
        this.gbU = (TextView) this.ffU.findViewById(e.g.pbVideoFullUserName);
        this.gbU.setOnClickListener(this.bzR);
        this.gbW = (TextView) this.ffU.findViewById(e.g.pbVideoFullAttention);
        this.gbW.setOnClickListener(this.bzR);
        this.gbX = (ImageView) this.ffU.findViewById(e.g.pbVideoFullChannelIcon);
        this.gbY = (PbVideoFullUserInfoLikeButton) this.ffU.findViewById(e.g.pbVideoFullLikeButton);
        this.gbY.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0175e.tbds30));
        this.gcb = new f(this.mContext, this.gbY);
        this.gbT.setRadius(l.h(this.mContext.getPageActivity(), e.C0175e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(View view) {
        if (this.gbZ) {
            if (this.bQk != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bQk.channelId, 2)));
            }
        } else if (this.gcc != null) {
            this.gcc.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blU() {
        if (this.gbZ) {
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
            this.gbZ = true;
            this.gbY.setVisibility(8);
            this.gbW.setVisibility(0);
            ap(bbVar);
        } else {
            this.gbZ = false;
            this.gbY.setVisibility(0);
            this.gbW.setVisibility(8);
            o(postData);
        }
        if (am(bbVar)) {
            this.gbW.setVisibility(8);
            this.gbY.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.yv() == null || bbVar.yv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.yv().getUserId());
    }

    private void o(PostData postData) {
        this.gbX.setVisibility(8);
        this.gbT.setUserId(postData.yv().getUserId());
        this.gbT.setUserName(postData.yv().getUserName());
        this.gbT.setIsBigV(postData.yv().isBigV());
        this.gbU.setText(postData.yv().getName_show());
        this.gbU.setTag(postData.yv().getUserId());
        this.gbT.startLoad(postData.yv().getPortrait(), 28, false);
        this.gcb.a(postData.yv());
    }

    private void ap(bb bbVar) {
        this.gbX.setVisibility(0);
        this.bQk = bbVar.zy();
        if (this.bQk.arL == 1) {
            this.gca = 0;
        } else {
            this.gca = this.bQk.arL;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gca = 2;
        }
        this.gbU.setText(this.bQk.channelName);
        this.gbT.startLoad(this.bQk.channelAvatar, 10, false);
        l(this.gca, this.bQk.channelId);
    }

    public void l(int i, long j) {
        if (this.bQk != null && j > 0 && j == this.bQk.channelId) {
            if (i == 1) {
                this.gbW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gbW, e.d.cp_bg_line_d_alpha80);
                this.gbW.setClickable(false);
                this.gbW.setText(e.j.has_ordered_channel);
                return;
            }
            this.gbW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbW, e.d.cp_cont_i);
            this.gbW.setClickable(true);
            this.gbW.setText(e.j.order_video_channel);
        }
    }

    public void au(float f) {
        this.gbV.setAlpha(f);
    }

    public View blV() {
        return this.gbV;
    }

    public void ea(int i) {
        if (this.gbY != null) {
            this.gbY.onChangeSkinType(i);
        }
        if (this.gca == 1) {
            al.h(this.gbW, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.gbW, e.d.cp_cont_i);
        }
        if (this.gbU != null) {
            al.h(this.gbU, e.d.cp_cont_i);
        }
        if (this.gbX != null) {
            al.i(this.gbX, e.f.icon_weiba);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        this.gcc = onClickListener;
    }

    public void onDestroy() {
    }
}
