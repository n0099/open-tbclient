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
    public int aPt;
    private View.OnClickListener bKR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fYk || view == e.this.fYl || view == e.this.fYm) {
                    if (e.this.ccN != null) {
                        e.this.cmZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.cmZ.getActivity(), e.this.ccN.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").s("obj_id", 1));
                } else if (view == e.this.fYr) {
                    if (l.pa()) {
                        if (e.this.ccN != null && e.this.ccN.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.ba(e.this.cmZ.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0071a.a(e.this.ccN.channelId, e.this.cmZ.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cmZ.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    private bj ccN;
    public BaseActivity cmZ;
    public HeadImageView fYk;
    public TextView fYl;
    public ImageView fYm;
    public LinearLayout fYn;
    public TextView fYo;
    public TextView fYp;
    public LinearLayout fYq;
    public TextView fYr;
    public RelativeLayout fYs;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cmZ = baseActivity;
            this.rootView = view;
            this.fYk = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fYl = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fYm = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fYn = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fYo = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fYp = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fYq = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fYr = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fYs = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fYk.setImageDrawable(null);
            this.fYk.setRadius(l.s(baseActivity.getActivity(), d.e.ds40));
            this.fYk.setOnClickListener(this.bKR);
            this.fYm.setOnClickListener(this.bKR);
            this.fYr.setOnClickListener(this.bKR);
            this.fYl.setOnClickListener(this.bKR);
        }
    }

    public void aa(bd bdVar) {
        if (bdVar != null && bdVar.zV() != null && this.rootView != null) {
            this.ccN = bdVar.zV();
            this.fYo.setText(am.z(bdVar.getCreateTime()));
            this.fYp.setText(bdVar.getAddress());
            this.fYl.setText(this.ccN.channelName);
            this.fYk.startLoad(this.ccN.channelAvatar, 10, false);
            if (this.ccN.aPt == 1) {
                this.aPt = 0;
            } else {
                this.aPt = this.ccN.aPt;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aPt = 2;
            }
            j(this.aPt, this.ccN.channelId);
            Iv();
        }
    }

    public void Iv() {
        this.cmZ.getLayoutMode().aM(this.rootView);
        if (this.aPt == 1) {
            this.fYr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fYr, d.C0108d.cp_cont_d);
            this.fYr.setText(d.j.has_ordered_channel);
            this.fYr.setVisibility(0);
        } else if (this.aPt == 2) {
            this.fYr.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fYr, d.C0108d.btn_forum_focus_color);
            this.fYr.setVisibility(0);
            this.fYr.setText(d.j.order_video_channel);
        } else {
            this.fYr.setVisibility(8);
        }
        aj.r(this.fYl, d.C0108d.cp_cont_f);
        aj.r(this.fYo, d.C0108d.cp_cont_f);
        aj.r(this.fYp, d.C0108d.cp_cont_f);
        aj.s(this.fYm, d.f.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.ccN != null && j > 0 && j == this.ccN.channelId) {
            if (i == 1) {
                this.fYr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.fYr, d.C0108d.cp_cont_d);
                this.fYr.setClickable(false);
                this.fYr.setText(d.j.has_ordered_channel);
                return;
            }
            this.fYr.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fYr, d.C0108d.btn_forum_focus_color);
            this.fYr.setClickable(true);
            this.fYr.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bfK() {
        return this.fYr;
    }
}
