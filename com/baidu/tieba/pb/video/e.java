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
    private View.OnClickListener aTx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.faZ || view == e.this.fba || view == e.this.fbb) {
                    if (e.this.bie != null) {
                        e.this.brJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.brJ.getActivity(), e.this.bie.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.fbg) {
                    if (l.hy()) {
                        if (e.this.bie != null && e.this.bie.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aS(e.this.brJ.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(e.this.bie.channelId, e.this.brJ.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.brJ.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public int aaD;
    private bm bie;
    public BaseActivity brJ;
    public HeadImageView faZ;
    public TextView fba;
    public ImageView fbb;
    public LinearLayout fbc;
    public TextView fbd;
    public TextView fbe;
    public LinearLayout fbf;
    public TextView fbg;
    public RelativeLayout fbh;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.brJ = baseActivity;
            this.rootView = view;
            this.faZ = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fba = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fbb = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fbc = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fbd = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fbe = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fbf = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fbg = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fbh = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.faZ.setImageDrawable(null);
            this.faZ.setRadius(l.f(baseActivity.getActivity(), d.e.ds40));
            this.faZ.setOnClickListener(this.aTx);
            this.fbb.setOnClickListener(this.aTx);
            this.fbg.setOnClickListener(this.aTx);
            this.fba.setOnClickListener(this.aTx);
        }
    }

    public void Y(bh bhVar) {
        if (bhVar != null && bhVar.sz() != null && this.rootView != null) {
            this.bie = bhVar.sz();
            this.fbd.setText(am.r(bhVar.getCreateTime()));
            this.fbe.setText(bhVar.getAddress());
            this.fba.setText(this.bie.channelName);
            this.faZ.startLoad(this.bie.channelAvatar, 10, false);
            if (this.bie.aaD == 1) {
                this.aaD = 0;
            } else {
                this.aaD = this.bie.aaD;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aaD = 2;
            }
            l(this.aaD, this.bie.channelId);
            AB();
        }
    }

    public void AB() {
        this.brJ.getLayoutMode().t(this.rootView);
        if (this.aaD == 1) {
            this.fbg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbg, d.C0080d.cp_cont_d);
            this.fbg.setText(d.j.has_ordered_channel);
            this.fbg.setVisibility(0);
        } else if (this.aaD == 2) {
            this.fbg.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbg, d.C0080d.btn_forum_focus_color);
            this.fbg.setVisibility(0);
            this.fbg.setText(d.j.order_video_channel);
        } else {
            this.fbg.setVisibility(8);
        }
        aj.i(this.fba, d.C0080d.cp_cont_f);
        aj.i(this.fbd, d.C0080d.cp_cont_f);
        aj.i(this.fbe, d.C0080d.cp_cont_f);
        aj.j(this.fbb, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bie != null && j > 0 && j == this.bie.channelId) {
            if (i == 1) {
                this.fbg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fbg, d.C0080d.cp_cont_d);
                this.fbg.setClickable(false);
                this.fbg.setText(d.j.has_ordered_channel);
                return;
            }
            this.fbg.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fbg, d.C0080d.btn_forum_focus_color);
            this.fbg.setClickable(true);
            this.fbg.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aWZ() {
        return this.fbg;
    }
}
