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
    private TbPageContext<?> cfl;
    private View hgl;
    private bn idT;
    private HeadImageView idV;
    private TextView idW;
    private RelativeLayout idX;
    private TextView idY;
    private ImageView idZ;
    private PbVideoFullUserInfoLikeButton iea;
    public int iec;
    private f ied;
    private View.OnClickListener iee;
    private LinearLayout ief;
    private bh ieg;
    private boolean ieb = false;
    private View.OnClickListener dkW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == g.this.idV || view == g.this.idW || view == g.this.idZ) {
                g.this.cG(view);
            } else if (view == g.this.idY) {
                g.this.bXQ();
            }
        }
    };

    public g(TbPageContext<PbActivity> tbPageContext, FrameLayout frameLayout) {
        this.cfl = tbPageContext;
        this.hgl = s(tbPageContext);
        initView();
        frameLayout.addView(this.hgl);
    }

    private View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.idX = (RelativeLayout) this.hgl.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.idV = (HeadImageView) this.hgl.findViewById(R.id.pbVideoFullPhoto);
        this.idV.setOnClickListener(this.dkW);
        this.ief = (LinearLayout) this.hgl.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.ief, R.drawable.video_author_bg);
        this.idW = (TextView) this.hgl.findViewById(R.id.pbVideoFullUserName);
        this.idW.setOnClickListener(this.dkW);
        this.idY = (TextView) this.hgl.findViewById(R.id.pbVideoFullAttention);
        this.idY.setOnClickListener(this.dkW);
        this.idZ = (ImageView) this.hgl.findViewById(R.id.pbVideoFullChannelIcon);
        this.iea = (PbVideoFullUserInfoLikeButton) this.hgl.findViewById(R.id.pbVideoFullLikeButton);
        this.iea.setTextSize(0, l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds30));
        this.ied = new f(this.cfl, this.iea);
        this.idV.setRadius(l.getDimens(this.cfl.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(View view) {
        if (this.ieb) {
            if (this.idT != null) {
                this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.cfl.getPageActivity(), this.idT.channelId, 2)));
            }
        } else if (this.iee != null) {
            this.iee.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXQ() {
        if (this.ieb) {
            if (!l.isNetOk()) {
                this.cfl.showToast((int) R.string.no_network_guide);
            } else if (this.idT != null && this.idT.channelId > 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.cfl.getPageActivity());
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0281a.a(this.idT.channelId, this.cfl.getUniqueId())));
            }
        }
    }

    public void a(PostData postData, bh bhVar, j jVar) {
        this.ieg = bhVar;
        if (bhVar.ajP() != null) {
            this.ieb = true;
            this.iea.setVisibility(8);
            this.idY.setVisibility(0);
            ay(bhVar);
        } else {
            this.ieb = false;
            this.iea.setVisibility(0);
            this.idY.setVisibility(8);
            q(postData);
        }
        if (av(bhVar)) {
            this.idY.setVisibility(8);
            this.iea.setVisibility(8);
        }
    }

    private boolean av(bh bhVar) {
        if (bhVar == null || bhVar.aiG() == null || bhVar.aiG().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bhVar.aiG().getUserId());
    }

    private void q(PostData postData) {
        this.idZ.setVisibility(8);
        this.idV.setUserId(postData.aiG().getUserId());
        this.idV.setUserName(postData.aiG().getUserName());
        this.idV.setIsBigV(postData.aiG().isBigV());
        this.idW.setText(postData.aiG().getName_show());
        this.idW.setTag(postData.aiG().getUserId());
        this.idV.startLoad(postData.aiG().getPortrait(), 28, false);
        this.ied.a(postData.aiG());
    }

    private void ay(bh bhVar) {
        this.idZ.setVisibility(0);
        this.idT = bhVar.ajP();
        if (this.idT.ceT == 1) {
            this.iec = 0;
        } else {
            this.iec = this.idT.ceT;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.iec = 2;
        }
        this.idW.setText(this.idT.channelName);
        this.idV.startLoad(this.idT.channelAvatar, 10, false);
        w(this.iec, this.idT.channelId);
    }

    public void w(int i, long j) {
        if (this.idT != null && j > 0 && j == this.idT.channelId) {
            if (i == 1) {
                this.idY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.idY, (int) R.color.cp_bg_line_d_alpha80);
                this.idY.setClickable(false);
                this.idY.setText(R.string.has_ordered_channel);
                return;
            }
            this.idY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.idY, (int) R.color.cp_cont_a);
            this.idY.setClickable(true);
            this.idY.setText(R.string.order_video_channel);
        }
    }

    public void as(float f) {
        this.idX.setAlpha(f);
    }

    public View bXR() {
        return this.idX;
    }

    public void onChangeSkin(int i) {
        if (this.iea != null) {
            this.iea.onChangeSkinType(i);
        }
        if (this.iec == 1) {
            am.setViewTextColor(this.idY, (int) R.color.cp_bg_line_d_alpha80);
        } else {
            am.setViewTextColor(this.idY, (int) R.color.cp_cont_a);
        }
        if (this.idW != null) {
            am.setViewTextColor(this.idW, (int) R.color.cp_cont_a);
        }
        if (this.idZ != null) {
            am.setBackgroundResource(this.idZ, R.drawable.icon_weiba);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.iee = onClickListener;
    }

    public void onDestroy() {
    }
}
