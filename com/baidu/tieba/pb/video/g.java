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
    private View gZh;
    private HeadImageView hVZ;
    private TextView hWa;
    private RelativeLayout hWb;
    private TextView hWc;
    private ImageView hWd;
    private PbVideoFullUserInfoLikeButton hWe;
    public int hWg;
    private f hWh;
    private View.OnClickListener hWi;
    private LinearLayout hWj;
    private TbPageContext<?> mContext;
    private boolean hWf = false;
    private View.OnClickListener cYj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.hVZ || view == g.this.hWa || view == g.this.hWd) {
                g.this.cF(view);
            } else if (view == g.this.hWc) {
                g.this.bWS();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.gZh = q(tbPageContext);
        initView();
        frameLayout.addView(this.gZh);
    }

    private View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.hWb = (RelativeLayout) this.gZh.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.hVZ = (HeadImageView) this.gZh.findViewById(R.id.pbVideoFullPhoto);
        this.hVZ.setOnClickListener(this.cYj);
        this.hWj = (LinearLayout) this.gZh.findViewById(R.id.pbVideoFullNameLayout);
        al.k(this.hWj, R.drawable.video_author_bg);
        this.hWa = (TextView) this.gZh.findViewById(R.id.pbVideoFullUserName);
        this.hWa.setOnClickListener(this.cYj);
        this.hWc = (TextView) this.gZh.findViewById(R.id.pbVideoFullAttention);
        this.hWc.setOnClickListener(this.cYj);
        this.hWd = (ImageView) this.gZh.findViewById(R.id.pbVideoFullChannelIcon);
        this.hWe = (PbVideoFullUserInfoLikeButton) this.gZh.findViewById(R.id.pbVideoFullLikeButton);
        this.hWe.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds30));
        this.hWh = new f(this.mContext, this.hWe);
        this.hVZ.setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.hWf) {
            if (this.dvj != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dvj.channelId, 2)));
            }
        } else if (this.hWi != null) {
            this.hWi.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWS() {
        if (this.hWf) {
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
            this.hWf = true;
            this.hWe.setVisibility(8);
            this.hWc.setVisibility(0);
            ay(bgVar);
        } else {
            this.hWf = false;
            this.hWe.setVisibility(0);
            this.hWc.setVisibility(8);
            q(postData);
        }
        if (av(bgVar)) {
            this.hWc.setVisibility(8);
            this.hWe.setVisibility(8);
        }
    }

    private boolean av(bg bgVar) {
        if (bgVar == null || bgVar.adv() == null || bgVar.adv().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.adv().getUserId());
    }

    private void q(PostData postData) {
        this.hWd.setVisibility(8);
        this.hVZ.setUserId(postData.adv().getUserId());
        this.hVZ.setUserName(postData.adv().getUserName());
        this.hVZ.setIsBigV(postData.adv().isBigV());
        this.hWa.setText(postData.adv().getName_show());
        this.hWa.setTag(postData.adv().getUserId());
        this.hVZ.startLoad(postData.adv().getPortrait(), 28, false);
        this.hWh.a(postData.adv());
    }

    private void ay(bg bgVar) {
        this.hWd.setVisibility(0);
        this.dvj = bgVar.aeF();
        if (this.dvj.bLF == 1) {
            this.hWg = 0;
        } else {
            this.hWg = this.dvj.bLF;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.hWg = 2;
        }
        this.hWa.setText(this.dvj.channelName);
        this.hVZ.startLoad(this.dvj.channelAvatar, 10, false);
        w(this.hWg, this.dvj.channelId);
    }

    public void w(int i, long j) {
        if (this.dvj != null && j > 0 && j == this.dvj.channelId) {
            if (i == 1) {
                this.hWc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hWc, R.color.cp_bg_line_d_alpha80);
                this.hWc.setClickable(false);
                this.hWc.setText(R.string.has_ordered_channel);
                return;
            }
            this.hWc.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hWc, R.color.cp_btn_a);
            this.hWc.setClickable(true);
            this.hWc.setText(R.string.order_video_channel);
        }
    }

    public void aN(float f) {
        this.hWb.setAlpha(f);
    }

    public View bWT() {
        return this.hWb;
    }

    public void iW(int i) {
        if (this.hWe != null) {
            this.hWe.onChangeSkinType(i);
        }
        if (this.hWg == 1) {
            al.j(this.hWc, R.color.cp_bg_line_d_alpha80);
        } else {
            al.j(this.hWc, R.color.cp_btn_a);
        }
        if (this.hWa != null) {
            al.j(this.hWa, R.color.cp_btn_a);
        }
        if (this.hWd != null) {
            al.k(this.hWd, R.drawable.icon_weiba);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        this.hWi = onClickListener;
    }

    public void onDestroy() {
    }
}
