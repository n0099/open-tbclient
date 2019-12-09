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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private TbPageContext<?> ceu;
    private View hfu;
    private bn icZ;
    private HeadImageView idb;
    private TextView idc;
    private RelativeLayout idd;
    private TextView ide;
    private ImageView idf;
    private PbVideoFullUserInfoLikeButton idg;
    public int idi;
    private f idj;
    private View.OnClickListener idk;
    private LinearLayout idm;
    private bh idn;
    private boolean idh = false;
    private View.OnClickListener dkf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.idb || view == g.this.idc || view == g.this.idf) {
                g.this.cG(view);
            } else if (view == g.this.ide) {
                g.this.bXO();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.ceu = tbPageContext;
        this.hfu = s(tbPageContext);
        initView();
        frameLayout.addView(this.hfu);
    }

    private View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.idd = (RelativeLayout) this.hfu.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.idb = (HeadImageView) this.hfu.findViewById(R.id.pbVideoFullPhoto);
        this.idb.setOnClickListener(this.dkf);
        this.idm = (LinearLayout) this.hfu.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.idm, R.drawable.video_author_bg);
        this.idc = (TextView) this.hfu.findViewById(R.id.pbVideoFullUserName);
        this.idc.setOnClickListener(this.dkf);
        this.ide = (TextView) this.hfu.findViewById(R.id.pbVideoFullAttention);
        this.ide.setOnClickListener(this.dkf);
        this.idf = (ImageView) this.hfu.findViewById(R.id.pbVideoFullChannelIcon);
        this.idg = (PbVideoFullUserInfoLikeButton) this.hfu.findViewById(R.id.pbVideoFullLikeButton);
        this.idg.setTextSize(0, l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds30));
        this.idj = new f(this.ceu, this.idg);
        this.idb.setRadius(l.getDimens(this.ceu.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(View view) {
        if (this.idh) {
            if (this.icZ != null) {
                this.ceu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.ceu.getPageActivity(), this.icZ.channelId, 2)));
            }
        } else if (this.idk != null) {
            this.idk.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXO() {
        if (this.idh) {
            if (!l.isNetOk()) {
                this.ceu.showToast((int) R.string.no_network_guide);
            } else if (this.icZ != null && this.icZ.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.ceu.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0276a.a(this.icZ.channelId, this.ceu.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, j jVar) {
        this.idn = bhVar;
        if (bhVar.ajN() != null) {
            this.idh = true;
            this.idg.setVisibility(8);
            this.ide.setVisibility(0);
            ay(bhVar);
        } else {
            this.idh = false;
            this.idg.setVisibility(0);
            this.ide.setVisibility(8);
            q(postData);
        }
        if (av(bhVar)) {
            this.ide.setVisibility(8);
            this.idg.setVisibility(8);
        }
    }

    private boolean av(bh bhVar) {
        if (bhVar == null || bhVar.aiE() == null || bhVar.aiE().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aiE().getUserId());
    }

    private void q(PostData postData) {
        this.idf.setVisibility(8);
        this.idb.setUserId(postData.aiE().getUserId());
        this.idb.setUserName(postData.aiE().getUserName());
        this.idb.setIsBigV(postData.aiE().isBigV());
        this.idc.setText(postData.aiE().getName_show());
        this.idc.setTag(postData.aiE().getUserId());
        this.idb.startLoad(postData.aiE().getPortrait(), 28, false);
        this.idj.a(postData.aiE());
    }

    private void ay(bh bhVar) {
        this.idf.setVisibility(0);
        this.icZ = bhVar.ajN();
        if (this.icZ.cec == 1) {
            this.idi = 0;
        } else {
            this.idi = this.icZ.cec;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.idi = 2;
        }
        this.idc.setText(this.icZ.channelName);
        this.idb.startLoad(this.icZ.channelAvatar, 10, false);
        u(this.idi, this.icZ.channelId);
    }

    public void u(int i, long j) {
        if (this.icZ != null && j > 0 && j == this.icZ.channelId) {
            if (i == 1) {
                this.ide.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.ide, (int) R.color.cp_bg_line_d_alpha80);
                this.ide.setClickable(false);
                this.ide.setText(R.string.has_ordered_channel);
                return;
            }
            this.ide.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.ide, (int) R.color.cp_cont_a);
            this.ide.setClickable(true);
            this.ide.setText(R.string.order_video_channel);
        }
    }

    public void as(float f) {
        this.idd.setAlpha(f);
    }

    public View bXP() {
        return this.idd;
    }

    public void onChangeSkin(int i) {
        if (this.idg != null) {
            this.idg.onChangeSkinType(i);
        }
        if (this.idi == 1) {
            am.setViewTextColor(this.ide, (int) R.color.cp_bg_line_d_alpha80);
        } else {
            am.setViewTextColor(this.ide, (int) R.color.cp_cont_a);
        }
        if (this.idc != null) {
            am.setViewTextColor(this.idc, (int) R.color.cp_cont_a);
        }
        if (this.idf != null) {
            am.setBackgroundResource(this.idf, R.drawable.icon_weiba);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.idk = onClickListener;
    }

    public void onDestroy() {
    }
}
