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
    public int cec;
    private View.OnClickListener dkf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.icQ || view == e.this.icR || view == e.this.icS) {
                    if (e.this.icZ != null) {
                        e.this.mActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.mActivity.getActivity(), e.this.icZ.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").O("obj_id", 1));
                } else if (view == e.this.icX) {
                    if (l.isNetOk()) {
                        if (e.this.icZ != null && e.this.icZ.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.skipToLoginActivity(e.this.mActivity.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0276a.a(e.this.icZ.channelId, e.this.mActivity.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.mActivity.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    public HeadImageView icQ;
    public TextView icR;
    public ImageView icS;
    public LinearLayout icT;
    public TextView icU;
    public TextView icV;
    public LinearLayout icW;
    public TextView icX;
    public RelativeLayout icY;
    private bn icZ;
    public BaseActivity mActivity;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.mActivity = baseActivity;
            this.rootView = view;
            this.icQ = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.icR = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.icS = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.icT = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.icU = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.icV = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.icW = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.icX = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.icY = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.icQ.setImageDrawable(null);
            this.icQ.setRadius(l.getDimens(baseActivity.getActivity(), R.dimen.ds40));
            this.icQ.setOnClickListener(this.dkf);
            this.icS.setOnClickListener(this.dkf);
            this.icX.setOnClickListener(this.dkf);
            this.icR.setOnClickListener(this.dkf);
        }
    }

    public void ax(bh bhVar) {
        if (bhVar != null && bhVar.ajN() != null && this.rootView != null) {
            this.icZ = bhVar.ajN();
            this.icU.setText(aq.getFormatTime(bhVar.getCreateTime()));
            this.icV.setText(bhVar.getAddress());
            this.icR.setText(this.icZ.channelName);
            this.icQ.startLoad(this.icZ.channelAvatar, 10, false);
            if (this.icZ.cec == 1) {
                this.cec = 0;
            } else {
                this.cec = this.icZ.cec;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.cec = 2;
            }
            u(this.cec, this.icZ.channelId);
            ask();
        }
    }

    public void ask() {
        this.mActivity.getLayoutMode().onModeChanged(this.rootView);
        if (this.cec == 1) {
            this.icX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.icX, (int) R.color.cp_cont_d);
            this.icX.setText(R.string.has_ordered_channel);
            this.icX.setVisibility(0);
        } else if (this.cec == 2) {
            this.icX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.icX, (int) R.color.btn_forum_focus_color);
            this.icX.setVisibility(0);
            this.icX.setText(R.string.order_video_channel);
        } else {
            this.icX.setVisibility(8);
        }
        am.setViewTextColor(this.icR, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.icU, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.icV, (int) R.color.cp_cont_f);
        am.setBackgroundResource(this.icS, R.drawable.icon_weiba);
    }

    public void u(int i, long j) {
        if (this.icZ != null && j > 0 && j == this.icZ.channelId) {
            if (i == 1) {
                this.icX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(this.icX, (int) R.color.cp_cont_d);
                this.icX.setClickable(false);
                this.icX.setText(R.string.has_ordered_channel);
                return;
            }
            this.icX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.icX, (int) R.color.btn_forum_focus_color);
            this.icX.setClickable(true);
            this.icX.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bXN() {
        return this.icX;
    }
}
