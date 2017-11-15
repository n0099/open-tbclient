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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private View.OnClickListener aTF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fbu || view == e.this.fbv || view == e.this.fbw) {
                    if (e.this.bio != null) {
                        e.this.brT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.brT.getActivity(), e.this.bio.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.fbB) {
                    if (l.hy()) {
                        if (e.this.bio != null && e.this.bio.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aS(e.this.brT.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(e.this.bio.channelId, e.this.brT.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.brT.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public int aaD;
    private bm bio;
    public BaseActivity brT;
    public LinearLayout fbA;
    public TextView fbB;
    public RelativeLayout fbC;
    public HeadImageView fbu;
    public TextView fbv;
    public ImageView fbw;
    public LinearLayout fbx;
    public TextView fby;
    public TextView fbz;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.brT = baseActivity;
            this.rootView = view;
            this.fbu = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fbv = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fbw = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fbx = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fby = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fbz = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fbA = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fbB = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fbC = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fbu.setImageDrawable(null);
            this.fbu.setRadius(l.f(baseActivity.getActivity(), d.e.ds40));
            this.fbu.setOnClickListener(this.aTF);
            this.fbw.setOnClickListener(this.aTF);
            this.fbB.setOnClickListener(this.aTF);
            this.fbv.setOnClickListener(this.aTF);
        }
    }

    public void Y(bh bhVar) {
        if (bhVar != null && bhVar.sz() != null && this.rootView != null) {
            this.bio = bhVar.sz();
            this.fby.setText(am.r(bhVar.getCreateTime()));
            this.fbz.setText(bhVar.getAddress());
            this.fbv.setText(this.bio.channelName);
            this.fbu.startLoad(this.bio.channelAvatar, 10, false);
            if (this.bio.aaD == 1) {
                this.aaD = 0;
            } else {
                this.aaD = this.bio.aaD;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aaD = 2;
            }
            l(this.aaD, this.bio.channelId);
            AN();
        }
    }

    public void AN() {
        this.brT.getLayoutMode().t(this.rootView);
        if (this.aaD == 1) {
            this.fbB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbB, d.C0080d.cp_cont_d);
            this.fbB.setText(d.j.has_ordered_channel);
            this.fbB.setVisibility(0);
        } else if (this.aaD == 2) {
            this.fbB.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbB, d.C0080d.btn_forum_focus_color);
            this.fbB.setVisibility(0);
            this.fbB.setText(d.j.order_video_channel);
        } else {
            this.fbB.setVisibility(8);
        }
        aj.i(this.fbv, d.C0080d.cp_cont_f);
        aj.i(this.fby, d.C0080d.cp_cont_f);
        aj.i(this.fbz, d.C0080d.cp_cont_f);
        aj.j(this.fbw, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bio != null && j > 0 && j == this.bio.channelId) {
            if (i == 1) {
                this.fbB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fbB, d.C0080d.cp_cont_d);
                this.fbB.setClickable(false);
                this.fbB.setText(d.j.has_ordered_channel);
                return;
            }
            this.fbB.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbB, d.C0080d.btn_forum_focus_color);
            this.fbB.setClickable(true);
            this.fbB.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aXh() {
        return this.fbB;
    }
}
