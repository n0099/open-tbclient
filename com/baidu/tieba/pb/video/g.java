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
    private bh bVA;
    private bb clJ;
    private View frU;
    private HeadImageView goe;
    private TextView gof;
    private RelativeLayout gog;
    private TextView goh;
    private ImageView goi;
    private PbVideoFullUserInfoLikeButton goj;
    public int gol;
    private f gom;
    private View.OnClickListener gon;
    private LinearLayout goo;
    private TbPageContext<?> mContext;
    private boolean gok = false;
    private View.OnClickListener bEQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.goe || view == g.this.gof || view == g.this.goi) {
                g.this.bK(view);
            } else if (view == g.this.goh) {
                g.this.boC();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.frU = q(tbPageContext);
        initView();
        frameLayout.addView(this.frU);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gog = (RelativeLayout) this.frU.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.goe = (HeadImageView) this.frU.findViewById(e.g.pbVideoFullPhoto);
        this.goe.setOnClickListener(this.bEQ);
        this.goo = (LinearLayout) this.frU.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.goo, e.f.video_author_bg);
        this.gof = (TextView) this.frU.findViewById(e.g.pbVideoFullUserName);
        this.gof.setOnClickListener(this.bEQ);
        this.goh = (TextView) this.frU.findViewById(e.g.pbVideoFullAttention);
        this.goh.setOnClickListener(this.bEQ);
        this.goi = (ImageView) this.frU.findViewById(e.g.pbVideoFullChannelIcon);
        this.goj = (PbVideoFullUserInfoLikeButton) this.frU.findViewById(e.g.pbVideoFullLikeButton);
        this.goj.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds30));
        this.gom = new f(this.mContext, this.goj);
        this.goe.setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(View view) {
        if (this.gok) {
            if (this.bVA != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bVA.channelId, 2)));
            }
        } else if (this.gon != null) {
            this.gon.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boC() {
        if (this.gok) {
            if (!l.ll()) {
                this.mContext.showToast(e.j.no_network_guide);
            } else if (this.bVA != null && this.bVA.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.bI(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(this.bVA.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        this.clJ = bbVar;
        if (bbVar.AW() != null) {
            this.gok = true;
            this.goj.setVisibility(8);
            this.goh.setVisibility(0);
            ap(bbVar);
        } else {
            this.gok = false;
            this.goj.setVisibility(0);
            this.goh.setVisibility(8);
            q(postData);
        }
        if (am(bbVar)) {
            this.goh.setVisibility(8);
            this.goj.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.zT() == null || bbVar.zT().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.zT().getUserId());
    }

    private void q(PostData postData) {
        this.goi.setVisibility(8);
        this.goe.setUserId(postData.zT().getUserId());
        this.goe.setUserName(postData.zT().getUserName());
        this.goe.setIsBigV(postData.zT().isBigV());
        this.gof.setText(postData.zT().getName_show());
        this.gof.setTag(postData.zT().getUserId());
        this.goe.startLoad(postData.zT().getPortrait(), 28, false);
        this.gom.a(postData.zT());
    }

    private void ap(bb bbVar) {
        this.goi.setVisibility(0);
        this.bVA = bbVar.AW();
        if (this.bVA.awC == 1) {
            this.gol = 0;
        } else {
            this.gol = this.bVA.awC;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gol = 2;
        }
        this.gof.setText(this.bVA.channelName);
        this.goe.startLoad(this.bVA.channelAvatar, 10, false);
        o(this.gol, this.bVA.channelId);
    }

    public void o(int i, long j) {
        if (this.bVA != null && j > 0 && j == this.bVA.channelId) {
            if (i == 1) {
                this.goh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.goh, e.d.cp_bg_line_d_alpha80);
                this.goh.setClickable(false);
                this.goh.setText(e.j.has_ordered_channel);
                return;
            }
            this.goh.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.goh, e.d.cp_cont_i);
            this.goh.setClickable(true);
            this.goh.setText(e.j.order_video_channel);
        }
    }

    public void aw(float f) {
        this.gog.setAlpha(f);
    }

    public View boD() {
        return this.gog;
    }

    public void eD(int i) {
        if (this.goj != null) {
            this.goj.onChangeSkinType(i);
        }
        if (this.gol == 1) {
            al.h(this.goh, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.goh, e.d.cp_cont_i);
        }
        if (this.gof != null) {
            al.h(this.gof, e.d.cp_cont_i);
        }
        if (this.goi != null) {
            al.i(this.goi, e.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.gon = onClickListener;
    }

    public void onDestroy() {
    }
}
