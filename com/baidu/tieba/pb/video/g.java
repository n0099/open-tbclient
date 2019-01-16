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
    private bh bVz;
    private bb clI;
    private View frT;
    private HeadImageView god;
    private TextView goe;
    private RelativeLayout gof;
    private TextView gog;
    private ImageView goh;
    private PbVideoFullUserInfoLikeButton goi;
    public int gok;
    private f gol;
    private View.OnClickListener gom;
    private LinearLayout gon;
    private TbPageContext<?> mContext;
    private boolean goj = false;
    private View.OnClickListener bEP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.god || view == g.this.goe || view == g.this.goh) {
                g.this.bK(view);
            } else if (view == g.this.gog) {
                g.this.boC();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.frT = q(tbPageContext);
        initView();
        frameLayout.addView(this.frT);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.gof = (RelativeLayout) this.frT.findViewById(e.g.pbVideoFullUserInfoPanel);
        this.god = (HeadImageView) this.frT.findViewById(e.g.pbVideoFullPhoto);
        this.god.setOnClickListener(this.bEP);
        this.gon = (LinearLayout) this.frT.findViewById(e.g.pbVideoFullNameLayout);
        al.i(this.gon, e.f.video_author_bg);
        this.goe = (TextView) this.frT.findViewById(e.g.pbVideoFullUserName);
        this.goe.setOnClickListener(this.bEP);
        this.gog = (TextView) this.frT.findViewById(e.g.pbVideoFullAttention);
        this.gog.setOnClickListener(this.bEP);
        this.goh = (ImageView) this.frT.findViewById(e.g.pbVideoFullChannelIcon);
        this.goi = (PbVideoFullUserInfoLikeButton) this.frT.findViewById(e.g.pbVideoFullLikeButton);
        this.goi.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.tbds30));
        this.gol = new f(this.mContext, this.goi);
        this.god.setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(View view) {
        if (this.goj) {
            if (this.bVz != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.bVz.channelId, 2)));
            }
        } else if (this.gom != null) {
            this.gom.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boC() {
        if (this.goj) {
            if (!l.ll()) {
                this.mContext.showToast(e.j.no_network_guide);
            } else if (this.bVz != null && this.bVz.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    ba.bI(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(this.bVz.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bb bbVar, com.baidu.tieba.pb.data.i iVar) {
        this.clI = bbVar;
        if (bbVar.AW() != null) {
            this.goj = true;
            this.goi.setVisibility(8);
            this.gog.setVisibility(0);
            ap(bbVar);
        } else {
            this.goj = false;
            this.goi.setVisibility(0);
            this.gog.setVisibility(8);
            q(postData);
        }
        if (am(bbVar)) {
            this.gog.setVisibility(8);
            this.goi.setVisibility(8);
        }
    }

    private boolean am(bb bbVar) {
        if (bbVar == null || bbVar.zT() == null || bbVar.zT().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bbVar.zT().getUserId());
    }

    private void q(PostData postData) {
        this.goh.setVisibility(8);
        this.god.setUserId(postData.zT().getUserId());
        this.god.setUserName(postData.zT().getUserName());
        this.god.setIsBigV(postData.zT().isBigV());
        this.goe.setText(postData.zT().getName_show());
        this.goe.setTag(postData.zT().getUserId());
        this.god.startLoad(postData.zT().getPortrait(), 28, false);
        this.gol.a(postData.zT());
    }

    private void ap(bb bbVar) {
        this.goh.setVisibility(0);
        this.bVz = bbVar.AW();
        if (this.bVz.awB == 1) {
            this.gok = 0;
        } else {
            this.gok = this.bVz.awB;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.gok = 2;
        }
        this.goe.setText(this.bVz.channelName);
        this.god.startLoad(this.bVz.channelAvatar, 10, false);
        o(this.gok, this.bVz.channelId);
    }

    public void o(int i, long j) {
        if (this.bVz != null && j > 0 && j == this.bVz.channelId) {
            if (i == 1) {
                this.gog.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gog, e.d.cp_bg_line_d_alpha80);
                this.gog.setClickable(false);
                this.gog.setText(e.j.has_ordered_channel);
                return;
            }
            this.gog.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gog, e.d.cp_cont_i);
            this.gog.setClickable(true);
            this.gog.setText(e.j.order_video_channel);
        }
    }

    public void aw(float f) {
        this.gof.setAlpha(f);
    }

    public View boD() {
        return this.gof;
    }

    public void eD(int i) {
        if (this.goi != null) {
            this.goi.onChangeSkinType(i);
        }
        if (this.gok == 1) {
            al.h(this.gog, e.d.cp_bg_line_d_alpha80);
        } else {
            al.h(this.gog, e.d.cp_cont_i);
        }
        if (this.goe != null) {
            al.h(this.goe, e.d.cp_cont_i);
        }
        if (this.goh != null) {
            al.i(this.goh, e.f.icon_weiba);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.gom = onClickListener;
    }

    public void onDestroy() {
    }
}
