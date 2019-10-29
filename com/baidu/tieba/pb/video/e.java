package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e {
    public int ceT;
    private View.OnClickListener dkW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.idK || view == e.this.idL || view == e.this.idM) {
                    if (e.this.idT != null) {
                        e.this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.mActivity.getActivity(), e.this.idT.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").O("obj_id", 1));
                } else if (view == e.this.idR) {
                    if (l.isNetOk()) {
                        if (e.this.idT != null && e.this.idT.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.skipToLoginActivity(e.this.mActivity.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0281a.a(e.this.idT.channelId, e.this.mActivity.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.mActivity.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    public HeadImageView idK;
    public TextView idL;
    public ImageView idM;
    public LinearLayout idN;
    public TextView idO;
    public TextView idP;
    public LinearLayout idQ;
    public TextView idR;
    public RelativeLayout idS;
    private bn idT;
    public BaseActivity mActivity;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.mActivity = baseActivity;
            this.rootView = view;
            this.idK = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.idL = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.idM = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.idN = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.idO = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.idP = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.idQ = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.idR = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.idS = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.idK.setImageDrawable(null);
            this.idK.setRadius(l.getDimens(baseActivity.getActivity(), R.dimen.ds40));
            this.idK.setOnClickListener(this.dkW);
            this.idM.setOnClickListener(this.dkW);
            this.idR.setOnClickListener(this.dkW);
            this.idL.setOnClickListener(this.dkW);
        }
    }

    public void ax(bh bhVar) {
        if (bhVar != null && bhVar.ajP() != null && this.rootView != null) {
            this.idT = bhVar.ajP();
            this.idO.setText(aq.getFormatTime(bhVar.getCreateTime()));
            this.idP.setText(bhVar.getAddress());
            this.idL.setText(this.idT.channelName);
            this.idK.startLoad(this.idT.channelAvatar, 10, false);
            if (this.idT.ceT == 1) {
                this.ceT = 0;
            } else {
                this.ceT = this.idT.ceT;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.ceT = 2;
            }
            w(this.ceT, this.idT.channelId);
            asm();
        }
    }

    public void asm() {
        this.mActivity.getLayoutMode().onModeChanged(this.rootView);
        if (this.ceT == 1) {
            this.idR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.idR, (int) R.color.cp_cont_d);
            this.idR.setText(R.string.has_ordered_channel);
            this.idR.setVisibility(0);
        } else if (this.ceT == 2) {
            this.idR.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.idR, (int) R.color.btn_forum_focus_color);
            this.idR.setVisibility(0);
            this.idR.setText(R.string.order_video_channel);
        } else {
            this.idR.setVisibility(8);
        }
        am.setViewTextColor(this.idL, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.idO, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.idP, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.idM, R.drawable.icon_weiba);
    }

    public void w(int i, long j) {
        if (this.idT != null && j > 0 && j == this.idT.channelId) {
            if (i == 1) {
                this.idR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.idR, (int) R.color.cp_cont_d);
                this.idR.setClickable(false);
                this.idR.setText(R.string.has_ordered_channel);
                return;
            }
            this.idR.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.idR, (int) R.color.btn_forum_focus_color);
            this.idR.setClickable(true);
            this.idR.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bXP() {
        return this.idR;
    }
}
