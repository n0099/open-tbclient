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
    private View.OnClickListener aWM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fjs || view == e.this.fjt || view == e.this.fju) {
                    if (e.this.bpd != null) {
                        e.this.byF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.byF.getActivity(), e.this.bpd.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.fjz) {
                    if (l.hy()) {
                        if (e.this.bpd != null && e.this.bpd.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aR(e.this.byF.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0058a.a(e.this.bpd.channelId, e.this.byF.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.byF.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public int aaV;
    private bj bpd;
    public BaseActivity byF;
    public RelativeLayout fjA;
    public HeadImageView fjs;
    public TextView fjt;
    public ImageView fju;
    public LinearLayout fjv;
    public TextView fjw;
    public TextView fjx;
    public LinearLayout fjy;
    public TextView fjz;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.byF = baseActivity;
            this.rootView = view;
            this.fjs = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fjt = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fju = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fjv = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fjw = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fjx = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fjy = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fjz = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fjA = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fjs.setImageDrawable(null);
            this.fjs.setRadius(l.f(baseActivity.getActivity(), d.e.ds40));
            this.fjs.setOnClickListener(this.aWM);
            this.fju.setOnClickListener(this.aWM);
            this.fjz.setOnClickListener(this.aWM);
            this.fjt.setOnClickListener(this.aWM);
        }
    }

    public void ab(bd bdVar) {
        if (bdVar != null && bdVar.sA() != null && this.rootView != null) {
            this.bpd = bdVar.sA();
            this.fjw.setText(am.r(bdVar.getCreateTime()));
            this.fjx.setText(bdVar.getAddress());
            this.fjt.setText(this.bpd.channelName);
            this.fjs.startLoad(this.bpd.channelAvatar, 10, false);
            if (this.bpd.aaV == 1) {
                this.aaV = 0;
            } else {
                this.aaV = this.bpd.aaV;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aaV = 2;
            }
            l(this.aaV, this.bpd.channelId);
            AY();
        }
    }

    public void AY() {
        this.byF.getLayoutMode().t(this.rootView);
        if (this.aaV == 1) {
            this.fjz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fjz, d.C0095d.cp_cont_d);
            this.fjz.setText(d.j.has_ordered_channel);
            this.fjz.setVisibility(0);
        } else if (this.aaV == 2) {
            this.fjz.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fjz, d.C0095d.btn_forum_focus_color);
            this.fjz.setVisibility(0);
            this.fjz.setText(d.j.order_video_channel);
        } else {
            this.fjz.setVisibility(8);
        }
        aj.i(this.fjt, d.C0095d.cp_cont_f);
        aj.i(this.fjw, d.C0095d.cp_cont_f);
        aj.i(this.fjx, d.C0095d.cp_cont_f);
        aj.j(this.fju, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bpd != null && j > 0 && j == this.bpd.channelId) {
            if (i == 1) {
                this.fjz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fjz, d.C0095d.cp_cont_d);
                this.fjz.setClickable(false);
                this.fjz.setText(d.j.has_ordered_channel);
                return;
            }
            this.fjz.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fjz, d.C0095d.btn_forum_focus_color);
            this.fjz.setClickable(true);
            this.fjz.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aYo() {
        return this.fjz;
    }
}
