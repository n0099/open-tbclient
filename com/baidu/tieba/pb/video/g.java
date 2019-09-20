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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class g {
    private bh dQD;
    private bn dzj;
    private View hih;
    private HeadImageView ifm;
    private TextView ifn;
    private RelativeLayout ifo;
    private TextView ifp;
    private ImageView ifq;
    private PbVideoFullUserInfoLikeButton ifr;
    public int ift;
    private f ifu;
    private View.OnClickListener ifv;
    private LinearLayout ifw;
    private TbPageContext<?> mContext;
    private boolean ifs = false;
    private View.OnClickListener dbz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.ifm || view == g.this.ifn || view == g.this.ifq) {
                g.this.cK(view);
            } else if (view == g.this.ifp) {
                g.this.caN();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.mContext = tbPageContext;
        this.hih = s(tbPageContext);
        initView();
        frameLayout.addView(this.hih);
    }

    private View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.ifo = (RelativeLayout) this.hih.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.ifm = (HeadImageView) this.hih.findViewById(R.id.pbVideoFullPhoto);
        this.ifm.setOnClickListener(this.dbz);
        this.ifw = (LinearLayout) this.hih.findViewById(R.id.pbVideoFullNameLayout);
        am.k(this.ifw, R.drawable.video_author_bg);
        this.ifn = (TextView) this.hih.findViewById(R.id.pbVideoFullUserName);
        this.ifn.setOnClickListener(this.dbz);
        this.ifp = (TextView) this.hih.findViewById(R.id.pbVideoFullAttention);
        this.ifp.setOnClickListener(this.dbz);
        this.ifq = (ImageView) this.hih.findViewById(R.id.pbVideoFullChannelIcon);
        this.ifr = (PbVideoFullUserInfoLikeButton) this.hih.findViewById(R.id.pbVideoFullLikeButton);
        this.ifr.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds30));
        this.ifu = new f(this.mContext, this.ifr);
        this.ifm.setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(View view) {
        if (this.ifs) {
            if (this.dzj != null) {
                this.mContext.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mContext.getPageActivity(), this.dzj.channelId, 2)));
            }
        } else if (this.ifv != null) {
            this.ifv.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caN() {
        if (this.ifs) {
            if (!l.kt()) {
                this.mContext.showToast((int) R.string.no_network_guide);
            } else if (this.dzj != null && this.dzj.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.cE(this.mContext.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0249a.a(this.dzj.channelId, this.mContext.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, j jVar) {
        this.dQD = bhVar;
        if (bhVar.afM() != null) {
            this.ifs = true;
            this.ifr.setVisibility(8);
            this.ifp.setVisibility(0);
            aA(bhVar);
        } else {
            this.ifs = false;
            this.ifr.setVisibility(0);
            this.ifp.setVisibility(8);
            q(postData);
        }
        if (ax(bhVar)) {
            this.ifp.setVisibility(8);
            this.ifr.setVisibility(8);
        }
    }

    private boolean ax(bh bhVar) {
        if (bhVar == null || bhVar.aeC() == null || bhVar.aeC().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aeC().getUserId());
    }

    private void q(PostData postData) {
        this.ifq.setVisibility(8);
        this.ifm.setUserId(postData.aeC().getUserId());
        this.ifm.setUserName(postData.aeC().getUserName());
        this.ifm.setIsBigV(postData.aeC().isBigV());
        this.ifn.setText(postData.aeC().getName_show());
        this.ifn.setTag(postData.aeC().getUserId());
        this.ifm.startLoad(postData.aeC().getPortrait(), 28, false);
        this.ifu.a(postData.aeC());
    }

    private void aA(bh bhVar) {
        this.ifq.setVisibility(0);
        this.dzj = bhVar.afM();
        if (this.dzj.bNk == 1) {
            this.ift = 0;
        } else {
            this.ift = this.dzj.bNk;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.ift = 2;
        }
        this.ifn.setText(this.dzj.channelName);
        this.ifm.startLoad(this.dzj.channelAvatar, 10, false);
        w(this.ift, this.dzj.channelId);
    }

    public void w(int i, long j) {
        if (this.dzj != null && j > 0 && j == this.dzj.channelId) {
            if (i == 1) {
                this.ifp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.ifp, R.color.cp_bg_line_d_alpha80);
                this.ifp.setClickable(false);
                this.ifp.setText(R.string.has_ordered_channel);
                return;
            }
            this.ifp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ifp, R.color.cp_cont_a);
            this.ifp.setClickable(true);
            this.ifp.setText(R.string.order_video_channel);
        }
    }

    public void aP(float f) {
        this.ifo.setAlpha(f);
    }

    public View caO() {
        return this.ifo;
    }

    public void jg(int i) {
        if (this.ifr != null) {
            this.ifr.onChangeSkinType(i);
        }
        if (this.ift == 1) {
            am.j(this.ifp, R.color.cp_bg_line_d_alpha80);
        } else {
            am.j(this.ifp, R.color.cp_cont_a);
        }
        if (this.ifn != null) {
            am.j(this.ifn, R.color.cp_cont_a);
        }
        if (this.ifq != null) {
            am.k(this.ifq, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.ifv = onClickListener;
    }

    public void onDestroy() {
    }
}
