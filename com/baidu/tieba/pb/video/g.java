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
    private bg dLd;
    private bm dvj;
    private View gZi;
    private HeadImageView hWa;
    private TextView hWb;
    private RelativeLayout hWc;
    private TextView hWd;
    private ImageView hWe;
    private PbVideoFullUserInfoLikeButton hWf;
    public int hWh;
    private f hWi;
    private View.OnClickListener hWj;
    private LinearLayout hWk;
    private TbPageContext<?> mContext;
    private boolean hWg = false;
    private View.OnClickListener cYk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hWa || view == g.this.hWb || view == g.this.hWe) {
                g.this.cF(view);
            } else if (view == g.this.hWd) {
                g.this.bWT();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.gZi = q(tbPageContext);
        initView();
        frameLayout.addView(this.gZi);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.hWc = (RelativeLayout) this.gZi.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.hWa = (HeadImageView) this.gZi.findViewById(R.id.pbVideoFullPhoto);
        this.hWa.setOnClickListener(this.cYk);
        this.hWk = (LinearLayout) this.gZi.findViewById(R.id.pbVideoFullNameLayout);
        al.k(this.hWk, R.drawable.video_author_bg);
        this.hWb = (TextView) this.gZi.findViewById(R.id.pbVideoFullUserName);
        this.hWb.setOnClickListener(this.cYk);
        this.hWd = (TextView) this.gZi.findViewById(R.id.pbVideoFullAttention);
        this.hWd.setOnClickListener(this.cYk);
        this.hWe = (ImageView) this.gZi.findViewById(R.id.pbVideoFullChannelIcon);
        this.hWf = (PbVideoFullUserInfoLikeButton) this.gZi.findViewById(R.id.pbVideoFullLikeButton);
        this.hWf.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds30));
        this.hWi = new f(this.mContext, this.hWf);
        this.hWa.setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.hWg) {
            if (this.dvj != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dvj.channelId, 2)));
            }
        } else if (this.hWj != null) {
            this.hWj.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWT() {
        if (this.hWg) {
            if (!l.ki()) {
                this.mContext.showToast((int) R.string.no_network_guide);
            } else if (this.dvj != null && this.dvj.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cD(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0238a.a(this.dvj.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bg bgVar, j jVar) {
        this.dLd = bgVar;
        if (bgVar.aeF() != null) {
            this.hWg = true;
            this.hWf.setVisibility(8);
            this.hWd.setVisibility(0);
            ay(bgVar);
        } else {
            this.hWg = false;
            this.hWf.setVisibility(0);
            this.hWd.setVisibility(8);
            q(postData);
        }
        if (av(bgVar)) {
            this.hWd.setVisibility(8);
            this.hWf.setVisibility(8);
        }
    }

    private boolean av(bg bgVar) {
        if (bgVar == null || bgVar.adv() == null || bgVar.adv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.adv().getUserId());
    }

    private void q(PostData postData) {
        this.hWe.setVisibility(8);
        this.hWa.setUserId(postData.adv().getUserId());
        this.hWa.setUserName(postData.adv().getUserName());
        this.hWa.setIsBigV(postData.adv().isBigV());
        this.hWb.setText(postData.adv().getName_show());
        this.hWb.setTag(postData.adv().getUserId());
        this.hWa.startLoad(postData.adv().getPortrait(), 28, false);
        this.hWi.a(postData.adv());
    }

    private void ay(bg bgVar) {
        this.hWe.setVisibility(0);
        this.dvj = bgVar.aeF();
        if (this.dvj.bLG == 1) {
            this.hWh = 0;
        } else {
            this.hWh = this.dvj.bLG;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hWh = 2;
        }
        this.hWb.setText(this.dvj.channelName);
        this.hWa.startLoad(this.dvj.channelAvatar, 10, false);
        w(this.hWh, this.dvj.channelId);
    }

    public void w(int i, long j) {
        if (this.dvj != null && j > 0 && j == this.dvj.channelId) {
            if (i == 1) {
                this.hWd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hWd, R.color.cp_bg_line_d_alpha80);
                this.hWd.setClickable(false);
                this.hWd.setText(R.string.has_ordered_channel);
                return;
            }
            this.hWd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hWd, R.color.cp_btn_a);
            this.hWd.setClickable(true);
            this.hWd.setText(R.string.order_video_channel);
        }
    }

    public void aN(float f) {
        this.hWc.setAlpha(f);
    }

    public View bWU() {
        return this.hWc;
    }

    public void iW(int i) {
        if (this.hWf != null) {
            this.hWf.onChangeSkinType(i);
        }
        if (this.hWh == 1) {
            al.j(this.hWd, R.color.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hWd, R.color.cp_btn_a);
        }
        if (this.hWb != null) {
            al.j(this.hWb, R.color.cp_btn_a);
        }
        if (this.hWe != null) {
            al.k(this.hWe, R.drawable.icon_weiba);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        this.hWj = onClickListener;
    }

    public void onDestroy() {
    }
}
