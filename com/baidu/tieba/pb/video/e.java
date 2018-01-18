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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e {
    public int aPq;
    private View.OnClickListener bKJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fXP || view == e.this.fXQ || view == e.this.fXR) {
                    if (e.this.ccF != null) {
                        e.this.cmR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.cmR.getActivity(), e.this.ccF.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").s("obj_id", 1));
                } else if (view == e.this.fXW) {
                    if (l.oZ()) {
                        if (e.this.ccF != null && e.this.ccF.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.bd(e.this.cmR.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0071a.a(e.this.ccF.channelId, e.this.cmR.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cmR.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    private bj ccF;
    public BaseActivity cmR;
    public HeadImageView fXP;
    public TextView fXQ;
    public ImageView fXR;
    public LinearLayout fXS;
    public TextView fXT;
    public TextView fXU;
    public LinearLayout fXV;
    public TextView fXW;
    public RelativeLayout fXX;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cmR = baseActivity;
            this.rootView = view;
            this.fXP = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fXQ = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fXR = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fXS = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fXT = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fXU = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fXV = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fXW = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fXX = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fXP.setImageDrawable(null);
            this.fXP.setRadius(l.s(baseActivity.getActivity(), d.e.ds40));
            this.fXP.setOnClickListener(this.bKJ);
            this.fXR.setOnClickListener(this.bKJ);
            this.fXW.setOnClickListener(this.bKJ);
            this.fXQ.setOnClickListener(this.bKJ);
        }
    }

    public void aa(bd bdVar) {
        if (bdVar != null && bdVar.zU() != null && this.rootView != null) {
            this.ccF = bdVar.zU();
            this.fXT.setText(am.z(bdVar.getCreateTime()));
            this.fXU.setText(bdVar.getAddress());
            this.fXQ.setText(this.ccF.channelName);
            this.fXP.startLoad(this.ccF.channelAvatar, 10, false);
            if (this.ccF.aPq == 1) {
                this.aPq = 0;
            } else {
                this.aPq = this.ccF.aPq;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aPq = 2;
            }
            j(this.aPq, this.ccF.channelId);
            It();
        }
    }

    public void It() {
        this.cmR.getLayoutMode().aM(this.rootView);
        if (this.aPq == 1) {
            this.fXW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fXW, d.C0107d.cp_cont_d);
            this.fXW.setText(d.j.has_ordered_channel);
            this.fXW.setVisibility(0);
        } else if (this.aPq == 2) {
            this.fXW.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fXW, d.C0107d.btn_forum_focus_color);
            this.fXW.setVisibility(0);
            this.fXW.setText(d.j.order_video_channel);
        } else {
            this.fXW.setVisibility(8);
        }
        aj.r(this.fXQ, d.C0107d.cp_cont_f);
        aj.r(this.fXT, d.C0107d.cp_cont_f);
        aj.r(this.fXU, d.C0107d.cp_cont_f);
        aj.s(this.fXR, d.f.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.ccF != null && j > 0 && j == this.ccF.channelId) {
            if (i == 1) {
                this.fXW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.fXW, d.C0107d.cp_cont_d);
                this.fXW.setClickable(false);
                this.fXW.setText(d.j.has_ordered_channel);
                return;
            }
            this.fXW.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fXW, d.C0107d.btn_forum_focus_color);
            this.fXW.setClickable(true);
            this.fXW.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bfF() {
        return this.fXW;
    }
}
