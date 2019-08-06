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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class g {
    private bh dOS;
    private bn dxy;
    private View hgm;
    private HeadImageView idk;
    private TextView idm;
    private RelativeLayout idn;
    private TextView ido;
    private ImageView idp;
    private PbVideoFullUserInfoLikeButton idq;
    public int idu;
    private f idv;
    private View.OnClickListener idw;
    private LinearLayout idx;
    private TbPageContext<?> mContext;
    private boolean idr = false;
    private View.OnClickListener cZN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.idk || view == g.this.idm || view == g.this.idp) {
                g.this.cK(view);
            } else if (view == g.this.ido) {
                g.this.bZZ();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.hgm = s(tbPageContext);
        initView();
        frameLayout.addView(this.hgm);
    }

    private View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.idn = (RelativeLayout) this.hgm.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.idk = (HeadImageView) this.hgm.findViewById(R.id.pbVideoFullPhoto);
        this.idk.setOnClickListener(this.cZN);
        this.idx = (LinearLayout) this.hgm.findViewById(R.id.pbVideoFullNameLayout);
        am.k(this.idx, R.drawable.video_author_bg);
        this.idm = (TextView) this.hgm.findViewById(R.id.pbVideoFullUserName);
        this.idm.setOnClickListener(this.cZN);
        this.ido = (TextView) this.hgm.findViewById(R.id.pbVideoFullAttention);
        this.ido.setOnClickListener(this.cZN);
        this.idp = (ImageView) this.hgm.findViewById(R.id.pbVideoFullChannelIcon);
        this.idq = (PbVideoFullUserInfoLikeButton) this.hgm.findViewById(R.id.pbVideoFullLikeButton);
        this.idq.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds30));
        this.idv = new f(this.mContext, this.idq);
        this.idk.setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(View view) {
        if (this.idr) {
            if (this.dxy != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dxy.channelId, 2)));
            }
        } else if (this.idw != null) {
            this.idw.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZZ() {
        if (this.idr) {
            if (!l.kt()) {
                this.mContext.showToast((int) R.string.no_network_guide);
            } else if (this.dxy != null && this.dxy.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bd.cE(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0240a.a(this.dxy.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, j jVar) {
        this.dOS = bhVar;
        if (bhVar.afI() != null) {
            this.idr = true;
            this.idq.setVisibility(8);
            this.ido.setVisibility(0);
            az(bhVar);
        } else {
            this.idr = false;
            this.idq.setVisibility(0);
            this.ido.setVisibility(8);
            q(postData);
        }
        if (aw(bhVar)) {
            this.ido.setVisibility(8);
            this.idq.setVisibility(8);
        }
    }

    private boolean aw(bh bhVar) {
        if (bhVar == null || bhVar.aey() == null || bhVar.aey().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aey().getUserId());
    }

    private void q(PostData postData) {
        this.idp.setVisibility(8);
        this.idk.setUserId(postData.aey().getUserId());
        this.idk.setUserName(postData.aey().getUserName());
        this.idk.setIsBigV(postData.aey().isBigV());
        this.idm.setText(postData.aey().getName_show());
        this.idm.setTag(postData.aey().getUserId());
        this.idk.startLoad(postData.aey().getPortrait(), 28, false);
        this.idv.a(postData.aey());
    }

    private void az(bh bhVar) {
        this.idp.setVisibility(0);
        this.dxy = bhVar.afI();
        if (this.dxy.bML == 1) {
            this.idu = 0;
        } else {
            this.idu = this.dxy.bML;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.idu = 2;
        }
        this.idm.setText(this.dxy.channelName);
        this.idk.startLoad(this.dxy.channelAvatar, 10, false);
        w(this.idu, this.dxy.channelId);
    }

    public void w(int i, long j) {
        if (this.dxy != null && j > 0 && j == this.dxy.channelId) {
            if (i == 1) {
                this.ido.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.ido, R.color.cp_bg_line_d_alpha80);
                this.ido.setClickable(false);
                this.ido.setText(R.string.has_ordered_channel);
                return;
            }
            this.ido.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ido, R.color.cp_btn_a);
            this.ido.setClickable(true);
            this.ido.setText(R.string.order_video_channel);
        }
    }

    public void aO(float f) {
        this.idn.setAlpha(f);
    }

    public View caa() {
        return this.idn;
    }

    public void jd(int i) {
        if (this.idq != null) {
            this.idq.onChangeSkinType(i);
        }
        if (this.idu == 1) {
            am.j(this.ido, R.color.cp_bg_line_d_alpha80);
        } else {
            am.j(this.ido, R.color.cp_btn_a);
        }
        if (this.idm != null) {
            am.j(this.idm, R.color.cp_btn_a);
        }
        if (this.idp != null) {
            am.k(this.idp, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.idw = onClickListener;
    }

    public void onDestroy() {
    }
}
