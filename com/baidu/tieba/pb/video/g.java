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
    private bh bUL;
    private bb ckQ;
    private View fog;
    private HeadImageView gkj;
    private TextView gkk;
    private RelativeLayout gkl;
    private TextView gkm;
    private ImageView gkn;
    private PbVideoFullUserInfoLikeButton gko;
    public int gkq;
    private f gkr;
    private View.OnClickListener gks;
    private LinearLayout gkt;
    private TbPageContext<?> mContext;
    private boolean gkp = false;
    private View.OnClickListener bDZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gkj || view == g.this.gkk || view == g.this.gkn) {
                g.this.bH(view);
            } else if (view == g.this.gkm) {
                g.this.bnj();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.fog = q(tbPageContext);
        initView();
        frameLayout.addView(this.fog);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gkl = (RelativeLayout) this.fog.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.gkj = (HeadImageView) this.fog.findViewById(e.g.pbVideoFullPhoto);
        this.gkj.setOnClickListener(this.bDZ);
        this.gkt = (LinearLayout) this.fog.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.gkt, e.f.video_author_bg);
        this.gkk = (TextView) this.fog.findViewById(e.g.pbVideoFullUserName);
        this.gkk.setOnClickListener(this.bDZ);
        this.gkm = (TextView) this.fog.findViewById(e.g.pbVideoFullAttention);
        this.gkm.setOnClickListener(this.bDZ);
        this.gkn = (ImageView) this.fog.findViewById(e.g.pbVideoFullChannelIcon);
        this.gko = (PbVideoFullUserInfoLikeButton) this.fog.findViewById(e.g.pbVideoFullLikeButton);
        this.gko.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds30));
        this.gkr = new f(this.mContext, this.gko);
        this.gkj.setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(View view) {
        if (this.gkp) {
            if (this.bUL != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bUL.channelId, 2)));
            }
        } else if (this.gks != null) {
            this.gks.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnj() {
        if (this.gkp) {
            if (!l.ll()) {
                this.mContext.showToast(e.j.no_network_guide);
            } else if (this.bUL != null && this.bUL.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.bI(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(this.bUL.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        this.ckQ = bbVar;
        if (bbVar.AJ() != null) {
            this.gkp = true;
            this.gko.setVisibility(8);
            this.gkm.setVisibility(0);
            ap(bbVar);
        } else {
            this.gkp = false;
            this.gko.setVisibility(0);
            this.gkm.setVisibility(8);
            o(postData);
        }
        if (am(bbVar)) {
            this.gkm.setVisibility(8);
            this.gko.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.zG() == null || bbVar.zG().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.zG().getUserId());
    }

    private void o(PostData postData) {
        this.gkn.setVisibility(8);
        this.gkj.setUserId(postData.zG().getUserId());
        this.gkj.setUserName(postData.zG().getUserName());
        this.gkj.setIsBigV(postData.zG().isBigV());
        this.gkk.setText(postData.zG().getName_show());
        this.gkk.setTag(postData.zG().getUserId());
        this.gkj.startLoad(postData.zG().getPortrait(), 28, false);
        this.gkr.a(postData.zG());
    }

    private void ap(bb bbVar) {
        this.gkn.setVisibility(0);
        this.bUL = bbVar.AJ();
        if (this.bUL.avY == 1) {
            this.gkq = 0;
        } else {
            this.gkq = this.bUL.avY;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gkq = 2;
        }
        this.gkk.setText(this.bUL.channelName);
        this.gkj.startLoad(this.bUL.channelAvatar, 10, false);
        o(this.gkq, this.bUL.channelId);
    }

    public void o(int i, long j) {
        if (this.bUL != null && j > 0 && j == this.bUL.channelId) {
            if (i == 1) {
                this.gkm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gkm, e.d.cp_bg_line_d_alpha80);
                this.gkm.setClickable(false);
                this.gkm.setText(e.j.has_ordered_channel);
                return;
            }
            this.gkm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gkm, e.d.cp_cont_i);
            this.gkm.setClickable(true);
            this.gkm.setText(e.j.order_video_channel);
        }
    }

    public void aw(float f) {
        this.gkl.setAlpha(f);
    }

    public View bnk() {
        return this.gkl;
    }

    public void eC(int i) {
        if (this.gko != null) {
            this.gko.onChangeSkinType(i);
        }
        if (this.gkq == 1) {
            al.h(this.gkm, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.gkm, e.d.cp_cont_i);
        }
        if (this.gkk != null) {
            al.h(this.gkk, e.d.cp_cont_i);
        }
        if (this.gkn != null) {
            al.i(this.gkn, e.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.gks = onClickListener;
    }

    public void onDestroy() {
    }
}
