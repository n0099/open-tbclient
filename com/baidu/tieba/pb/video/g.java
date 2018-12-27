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
    private bh bUO;
    private bb ckX;
    private View fqY;
    private HeadImageView gna;
    private TextView gnb;
    private RelativeLayout gnc;
    private TextView gnd;
    private ImageView gne;
    private PbVideoFullUserInfoLikeButton gnf;
    public int gnh;
    private f gni;
    private View.OnClickListener gnj;
    private LinearLayout gnk;
    private TbPageContext<?> mContext;
    private boolean gng = false;
    private View.OnClickListener bEc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gna || view == g.this.gnb || view == g.this.gne) {
                g.this.bK(view);
            } else if (view == g.this.gnd) {
                g.this.bnU();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.fqY = q(tbPageContext);
        initView();
        frameLayout.addView(this.fqY);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gnc = (RelativeLayout) this.fqY.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.gna = (HeadImageView) this.fqY.findViewById(e.g.pbVideoFullPhoto);
        this.gna.setOnClickListener(this.bEc);
        this.gnk = (LinearLayout) this.fqY.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.gnk, e.f.video_author_bg);
        this.gnb = (TextView) this.fqY.findViewById(e.g.pbVideoFullUserName);
        this.gnb.setOnClickListener(this.bEc);
        this.gnd = (TextView) this.fqY.findViewById(e.g.pbVideoFullAttention);
        this.gnd.setOnClickListener(this.bEc);
        this.gne = (ImageView) this.fqY.findViewById(e.g.pbVideoFullChannelIcon);
        this.gnf = (PbVideoFullUserInfoLikeButton) this.fqY.findViewById(e.g.pbVideoFullLikeButton);
        this.gnf.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds30));
        this.gni = new f(this.mContext, this.gnf);
        this.gna.setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(View view) {
        if (this.gng) {
            if (this.bUO != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bUO.channelId, 2)));
            }
        } else if (this.gnj != null) {
            this.gnj.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnU() {
        if (this.gng) {
            if (!l.ll()) {
                this.mContext.showToast(e.j.no_network_guide);
            } else if (this.bUO != null && this.bUO.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.bI(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(this.bUO.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        this.ckX = bbVar;
        if (bbVar.AJ() != null) {
            this.gng = true;
            this.gnf.setVisibility(8);
            this.gnd.setVisibility(0);
            ap(bbVar);
        } else {
            this.gng = false;
            this.gnf.setVisibility(0);
            this.gnd.setVisibility(8);
            o(postData);
        }
        if (am(bbVar)) {
            this.gnd.setVisibility(8);
            this.gnf.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.zG() == null || bbVar.zG().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.zG().getUserId());
    }

    private void o(PostData postData) {
        this.gne.setVisibility(8);
        this.gna.setUserId(postData.zG().getUserId());
        this.gna.setUserName(postData.zG().getUserName());
        this.gna.setIsBigV(postData.zG().isBigV());
        this.gnb.setText(postData.zG().getName_show());
        this.gnb.setTag(postData.zG().getUserId());
        this.gna.startLoad(postData.zG().getPortrait(), 28, false);
        this.gni.a(postData.zG());
    }

    private void ap(bb bbVar) {
        this.gne.setVisibility(0);
        this.bUO = bbVar.AJ();
        if (this.bUO.avZ == 1) {
            this.gnh = 0;
        } else {
            this.gnh = this.bUO.avZ;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gnh = 2;
        }
        this.gnb.setText(this.bUO.channelName);
        this.gna.startLoad(this.bUO.channelAvatar, 10, false);
        o(this.gnh, this.bUO.channelId);
    }

    public void o(int i, long j) {
        if (this.bUO != null && j > 0 && j == this.bUO.channelId) {
            if (i == 1) {
                this.gnd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gnd, e.d.cp_bg_line_d_alpha80);
                this.gnd.setClickable(false);
                this.gnd.setText(e.j.has_ordered_channel);
                return;
            }
            this.gnd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gnd, e.d.cp_cont_i);
            this.gnd.setClickable(true);
            this.gnd.setText(e.j.order_video_channel);
        }
    }

    public void aw(float f) {
        this.gnc.setAlpha(f);
    }

    public View bnV() {
        return this.gnc;
    }

    public void eD(int i) {
        if (this.gnf != null) {
            this.gnf.onChangeSkinType(i);
        }
        if (this.gnh == 1) {
            al.h(this.gnd, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.gnd, e.d.cp_cont_i);
        }
        if (this.gnb != null) {
            al.h(this.gnb, e.d.cp_cont_i);
        }
        if (this.gne != null) {
            al.i(this.gne, e.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.gnj = onClickListener;
    }

    public void onDestroy() {
    }
}
