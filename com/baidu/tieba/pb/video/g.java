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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class g {
    private bg dLc;
    private bm dvi;
    private View gZe;
    private HeadImageView hVW;
    private TextView hVX;
    private RelativeLayout hVY;
    private TextView hVZ;
    private ImageView hWa;
    private PbVideoFullUserInfoLikeButton hWb;
    public int hWd;
    private f hWe;
    private View.OnClickListener hWf;
    private LinearLayout hWg;
    private TbPageContext<?> mContext;
    private boolean hWc = false;
    private View.OnClickListener cYi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hVW || view == g.this.hVX || view == g.this.hWa) {
                g.this.cF(view);
            } else if (view == g.this.hVZ) {
                g.this.bWP();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.gZe = q(tbPageContext);
        initView();
        frameLayout.addView(this.gZe);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.hVY = (RelativeLayout) this.gZe.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.hVW = (HeadImageView) this.gZe.findViewById(R.id.pbVideoFullPhoto);
        this.hVW.setOnClickListener(this.cYi);
        this.hWg = (LinearLayout) this.gZe.findViewById(R.id.pbVideoFullNameLayout);
        al.k(this.hWg, R.drawable.video_author_bg);
        this.hVX = (TextView) this.gZe.findViewById(R.id.pbVideoFullUserName);
        this.hVX.setOnClickListener(this.cYi);
        this.hVZ = (TextView) this.gZe.findViewById(R.id.pbVideoFullAttention);
        this.hVZ.setOnClickListener(this.cYi);
        this.hWa = (ImageView) this.gZe.findViewById(R.id.pbVideoFullChannelIcon);
        this.hWb = (PbVideoFullUserInfoLikeButton) this.gZe.findViewById(R.id.pbVideoFullLikeButton);
        this.hWb.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds30));
        this.hWe = new f(this.mContext, this.hWb);
        this.hVW.setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.hWc) {
            if (this.dvi != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dvi.channelId, 2)));
            }
        } else if (this.hWf != null) {
            this.hWf.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWP() {
        if (this.hWc) {
            if (!l.ki()) {
                this.mContext.showToast((int) R.string.no_network_guide);
            } else if (this.dvi != null && this.dvi.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cD(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0238a.a(this.dvi.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bg bgVar, j jVar) {
        this.dLc = bgVar;
        if (bgVar.aeF() != null) {
            this.hWc = true;
            this.hWb.setVisibility(8);
            this.hVZ.setVisibility(0);
            ay(bgVar);
        } else {
            this.hWc = false;
            this.hWb.setVisibility(0);
            this.hVZ.setVisibility(8);
            q(postData);
        }
        if (av(bgVar)) {
            this.hVZ.setVisibility(8);
            this.hWb.setVisibility(8);
        }
    }

    private boolean av(bg bgVar) {
        if (bgVar == null || bgVar.adv() == null || bgVar.adv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.adv().getUserId());
    }

    private void q(PostData postData) {
        this.hWa.setVisibility(8);
        this.hVW.setUserId(postData.adv().getUserId());
        this.hVW.setUserName(postData.adv().getUserName());
        this.hVW.setIsBigV(postData.adv().isBigV());
        this.hVX.setText(postData.adv().getName_show());
        this.hVX.setTag(postData.adv().getUserId());
        this.hVW.startLoad(postData.adv().getPortrait(), 28, false);
        this.hWe.a(postData.adv());
    }

    private void ay(bg bgVar) {
        this.hWa.setVisibility(0);
        this.dvi = bgVar.aeF();
        if (this.dvi.bLF == 1) {
            this.hWd = 0;
        } else {
            this.hWd = this.dvi.bLF;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hWd = 2;
        }
        this.hVX.setText(this.dvi.channelName);
        this.hVW.startLoad(this.dvi.channelAvatar, 10, false);
        w(this.hWd, this.dvi.channelId);
    }

    public void w(int i, long j) {
        if (this.dvi != null && j > 0 && j == this.dvi.channelId) {
            if (i == 1) {
                this.hVZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hVZ, R.color.cp_bg_line_d_alpha80);
                this.hVZ.setClickable(false);
                this.hVZ.setText(R.string.has_ordered_channel);
                return;
            }
            this.hVZ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVZ, R.color.cp_btn_a);
            this.hVZ.setClickable(true);
            this.hVZ.setText(R.string.order_video_channel);
        }
    }

    public void aN(float f) {
        this.hVY.setAlpha(f);
    }

    public View bWQ() {
        return this.hVY;
    }

    public void iW(int i) {
        if (this.hWb != null) {
            this.hWb.onChangeSkinType(i);
        }
        if (this.hWd == 1) {
            al.j(this.hVZ, R.color.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hVZ, R.color.cp_btn_a);
        }
        if (this.hVX != null) {
            al.j(this.hVX, R.color.cp_btn_a);
        }
        if (this.hWa != null) {
            al.k(this.hWa, R.drawable.icon_weiba);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        this.hWf = onClickListener;
    }

    public void onDestroy() {
    }
}
