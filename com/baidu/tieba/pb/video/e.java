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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bk;
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
    public int aPr;
    private View.OnClickListener bKB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fWo || view == e.this.fWp || view == e.this.fWq) {
                    if (e.this.ccy != null) {
                        e.this.cmI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.cmI.getActivity(), e.this.ccy.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").s("obj_id", 1));
                } else if (view == e.this.fWv) {
                    if (l.oZ()) {
                        if (e.this.ccy != null && e.this.ccy.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.bd(e.this.cmI.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0072a.a(e.this.ccy.channelId, e.this.cmI.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cmI.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    private bk ccy;
    public BaseActivity cmI;
    public HeadImageView fWo;
    public TextView fWp;
    public ImageView fWq;
    public LinearLayout fWr;
    public TextView fWs;
    public TextView fWt;
    public LinearLayout fWu;
    public TextView fWv;
    public RelativeLayout fWw;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cmI = baseActivity;
            this.rootView = view;
            this.fWo = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fWp = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fWq = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fWr = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fWs = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fWt = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fWu = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fWv = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fWw = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fWo.setImageDrawable(null);
            this.fWo.setRadius(l.s(baseActivity.getActivity(), d.e.ds40));
            this.fWo.setOnClickListener(this.bKB);
            this.fWq.setOnClickListener(this.bKB);
            this.fWv.setOnClickListener(this.bKB);
            this.fWp.setOnClickListener(this.bKB);
        }
    }

    public void aa(be beVar) {
        if (beVar != null && beVar.Ac() != null && this.rootView != null) {
            this.ccy = beVar.Ac();
            this.fWs.setText(am.z(beVar.getCreateTime()));
            this.fWt.setText(beVar.getAddress());
            this.fWp.setText(this.ccy.channelName);
            this.fWo.startLoad(this.ccy.channelAvatar, 10, false);
            if (this.ccy.aPr == 1) {
                this.aPr = 0;
            } else {
                this.aPr = this.ccy.aPr;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aPr = 2;
            }
            l(this.aPr, this.ccy.channelId);
            IA();
        }
    }

    public void IA() {
        this.cmI.getLayoutMode().aM(this.rootView);
        if (this.aPr == 1) {
            this.fWv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fWv, d.C0108d.cp_cont_d);
            this.fWv.setText(d.j.has_ordered_channel);
            this.fWv.setVisibility(0);
        } else if (this.aPr == 2) {
            this.fWv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fWv, d.C0108d.btn_forum_focus_color);
            this.fWv.setVisibility(0);
            this.fWv.setText(d.j.order_video_channel);
        } else {
            this.fWv.setVisibility(8);
        }
        aj.r(this.fWp, d.C0108d.cp_cont_f);
        aj.r(this.fWs, d.C0108d.cp_cont_f);
        aj.r(this.fWt, d.C0108d.cp_cont_f);
        aj.s(this.fWq, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.ccy != null && j > 0 && j == this.ccy.channelId) {
            if (i == 1) {
                this.fWv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.fWv, d.C0108d.cp_cont_d);
                this.fWv.setClickable(false);
                this.fWv.setText(d.j.has_ordered_channel);
                return;
            }
            this.fWv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.fWv, d.C0108d.btn_forum_focus_color);
            this.fWv.setClickable(true);
            this.fWv.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bfE() {
        return this.fWv;
    }
}
