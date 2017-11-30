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
/* loaded from: classes.dex */
public class e {
    private View.OnClickListener aWG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fio || view == e.this.fip || view == e.this.fiq) {
                    if (e.this.boY != null) {
                        e.this.byz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.byz.getActivity(), e.this.boY.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.fiv) {
                    if (l.hy()) {
                        if (e.this.boY != null && e.this.boY.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aU(e.this.byz.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(e.this.boY.channelId, e.this.byz.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.byz.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public int aaY;
    private bj boY;
    public BaseActivity byz;
    public HeadImageView fio;
    public TextView fip;
    public ImageView fiq;
    public LinearLayout fir;
    public TextView fis;
    public TextView fit;
    public LinearLayout fiu;
    public TextView fiv;
    public RelativeLayout fiw;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.byz = baseActivity;
            this.rootView = view;
            this.fio = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fip = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fiq = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fir = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fis = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fit = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fiu = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fiv = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fiw = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fio.setImageDrawable(null);
            this.fio.setRadius(l.f(baseActivity.getActivity(), d.e.ds40));
            this.fio.setOnClickListener(this.aWG);
            this.fiq.setOnClickListener(this.aWG);
            this.fiv.setOnClickListener(this.aWG);
            this.fip.setOnClickListener(this.aWG);
        }
    }

    public void Z(bd bdVar) {
        if (bdVar != null && bdVar.sC() != null && this.rootView != null) {
            this.boY = bdVar.sC();
            this.fis.setText(am.r(bdVar.getCreateTime()));
            this.fit.setText(bdVar.getAddress());
            this.fip.setText(this.boY.channelName);
            this.fio.startLoad(this.boY.channelAvatar, 10, false);
            if (this.boY.aaY == 1) {
                this.aaY = 0;
            } else {
                this.aaY = this.boY.aaY;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aaY = 2;
            }
            l(this.aaY, this.boY.channelId);
            AX();
        }
    }

    public void AX() {
        this.byz.getLayoutMode().t(this.rootView);
        if (this.aaY == 1) {
            this.fiv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fiv, d.C0082d.cp_cont_d);
            this.fiv.setText(d.j.has_ordered_channel);
            this.fiv.setVisibility(0);
        } else if (this.aaY == 2) {
            this.fiv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fiv, d.C0082d.btn_forum_focus_color);
            this.fiv.setVisibility(0);
            this.fiv.setText(d.j.order_video_channel);
        } else {
            this.fiv.setVisibility(8);
        }
        aj.i(this.fip, d.C0082d.cp_cont_f);
        aj.i(this.fis, d.C0082d.cp_cont_f);
        aj.i(this.fit, d.C0082d.cp_cont_f);
        aj.j(this.fiq, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.boY != null && j > 0 && j == this.boY.channelId) {
            if (i == 1) {
                this.fiv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fiv, d.C0082d.cp_cont_d);
                this.fiv.setClickable(false);
                this.fiv.setText(d.j.has_ordered_channel);
                return;
            }
            this.fiv.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fiv, d.C0082d.btn_forum_focus_color);
            this.fiv.setClickable(true);
            this.fiv.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aYg() {
        return this.fiv;
    }
}
