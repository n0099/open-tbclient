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
    private bh bQU;
    private bb cgY;
    private View fho;
    private View.OnClickListener gdA;
    private LinearLayout gdB;
    private HeadImageView gdr;
    private TextView gds;
    private RelativeLayout gdt;
    private TextView gdu;
    private ImageView gdv;
    private PbVideoFullUserInfoLikeButton gdw;
    public int gdy;
    private f gdz;
    private TbPageContext<?> mContext;
    private boolean gdx = false;
    private View.OnClickListener bAC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.gdr || view == g.this.gds || view == g.this.gdv) {
                g.this.bH(view);
            } else if (view == g.this.gdu) {
                g.this.blq();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.fho = q(tbPageContext);
        initView();
        frameLayout.addView(this.fho);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gdt = (RelativeLayout) this.fho.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.gdr = (HeadImageView) this.fho.findViewById(e.g.pbVideoFullPhoto);
        this.gdr.setOnClickListener(this.bAC);
        this.gdB = (LinearLayout) this.fho.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.gdB, e.f.video_author_bg);
        this.gds = (TextView) this.fho.findViewById(e.g.pbVideoFullUserName);
        this.gds.setOnClickListener(this.bAC);
        this.gdu = (TextView) this.fho.findViewById(e.g.pbVideoFullAttention);
        this.gdu.setOnClickListener(this.bAC);
        this.gdv = (ImageView) this.fho.findViewById(e.g.pbVideoFullChannelIcon);
        this.gdw = (PbVideoFullUserInfoLikeButton) this.fho.findViewById(e.g.pbVideoFullLikeButton);
        this.gdw.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0200e.tbds30));
        this.gdz = new f(this.mContext, this.gdw);
        this.gdr.setRadius(l.h(this.mContext.getPageActivity(), e.C0200e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(View view) {
        if (this.gdx) {
            if (this.bQU != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bQU.channelId, 2)));
            }
        } else if (this.gdA != null) {
            this.gdA.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blq() {
        if (this.gdx) {
            if (!l.lm()) {
                this.mContext.showToast(e.j.no_network_guide);
            } else if (this.bQU != null && this.bQU.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.bF(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0146a.a(this.bQU.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        this.cgY = bbVar;
        if (bbVar.zF() != null) {
            this.gdx = true;
            this.gdw.setVisibility(8);
            this.gdu.setVisibility(0);
            ap(bbVar);
        } else {
            this.gdx = false;
            this.gdw.setVisibility(0);
            this.gdu.setVisibility(8);
            o(postData);
        }
        if (am(bbVar)) {
            this.gdu.setVisibility(8);
            this.gdw.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.yC() == null || bbVar.yC().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.yC().getUserId());
    }

    private void o(PostData postData) {
        this.gdv.setVisibility(8);
        this.gdr.setUserId(postData.yC().getUserId());
        this.gdr.setUserName(postData.yC().getUserName());
        this.gdr.setIsBigV(postData.yC().isBigV());
        this.gds.setText(postData.yC().getName_show());
        this.gds.setTag(postData.yC().getUserId());
        this.gdr.startLoad(postData.yC().getPortrait(), 28, false);
        this.gdz.a(postData.yC());
    }

    private void ap(bb bbVar) {
        this.gdv.setVisibility(0);
        this.bQU = bbVar.zF();
        if (this.bQU.asy == 1) {
            this.gdy = 0;
        } else {
            this.gdy = this.bQU.asy;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gdy = 2;
        }
        this.gds.setText(this.bQU.channelName);
        this.gdr.startLoad(this.bQU.channelAvatar, 10, false);
        l(this.gdy, this.bQU.channelId);
    }

    public void l(int i, long j) {
        if (this.bQU != null && j > 0 && j == this.bQU.channelId) {
            if (i == 1) {
                this.gdu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gdu, e.d.cp_bg_line_d_alpha80);
                this.gdu.setClickable(false);
                this.gdu.setText(e.j.has_ordered_channel);
                return;
            }
            this.gdu.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gdu, e.d.cp_cont_i);
            this.gdu.setClickable(true);
            this.gdu.setText(e.j.order_video_channel);
        }
    }

    public void aw(float f) {
        this.gdt.setAlpha(f);
    }

    public View blr() {
        return this.gdt;
    }

    public void eo(int i) {
        if (this.gdw != null) {
            this.gdw.onChangeSkinType(i);
        }
        if (this.gdy == 1) {
            al.h(this.gdu, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.gdu, e.d.cp_cont_i);
        }
        if (this.gds != null) {
            al.h(this.gds, e.d.cp_cont_i);
        }
        if (this.gdv != null) {
            al.i(this.gdv, e.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.gdA = onClickListener;
    }

    public void onDestroy() {
    }
}
