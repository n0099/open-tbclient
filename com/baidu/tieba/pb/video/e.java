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
    private View.OnClickListener aWI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fjn || view == e.this.fjo || view == e.this.fjp) {
                    if (e.this.boZ != null) {
                        e.this.byB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.byB.getActivity(), e.this.boZ.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.fju) {
                    if (l.hy()) {
                        if (e.this.boZ != null && e.this.boZ.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aR(e.this.byB.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0059a.a(e.this.boZ.channelId, e.this.byB.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.byB.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public int aaS;
    private bj boZ;
    public BaseActivity byB;
    public HeadImageView fjn;
    public TextView fjo;
    public ImageView fjp;
    public LinearLayout fjq;
    public TextView fjr;
    public TextView fjs;
    public LinearLayout fjt;
    public TextView fju;
    public RelativeLayout fjv;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.byB = baseActivity;
            this.rootView = view;
            this.fjn = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fjo = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fjp = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fjq = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fjr = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fjs = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fjt = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fju = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fjv = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fjn.setImageDrawable(null);
            this.fjn.setRadius(l.f(baseActivity.getActivity(), d.e.ds40));
            this.fjn.setOnClickListener(this.aWI);
            this.fjp.setOnClickListener(this.aWI);
            this.fju.setOnClickListener(this.aWI);
            this.fjo.setOnClickListener(this.aWI);
        }
    }

    public void ab(bd bdVar) {
        if (bdVar != null && bdVar.sA() != null && this.rootView != null) {
            this.boZ = bdVar.sA();
            this.fjr.setText(am.r(bdVar.getCreateTime()));
            this.fjs.setText(bdVar.getAddress());
            this.fjo.setText(this.boZ.channelName);
            this.fjn.startLoad(this.boZ.channelAvatar, 10, false);
            if (this.boZ.aaS == 1) {
                this.aaS = 0;
            } else {
                this.aaS = this.boZ.aaS;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aaS = 2;
            }
            l(this.aaS, this.boZ.channelId);
            AY();
        }
    }

    public void AY() {
        this.byB.getLayoutMode().t(this.rootView);
        if (this.aaS == 1) {
            this.fju.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fju, d.C0096d.cp_cont_d);
            this.fju.setText(d.j.has_ordered_channel);
            this.fju.setVisibility(0);
        } else if (this.aaS == 2) {
            this.fju.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fju, d.C0096d.btn_forum_focus_color);
            this.fju.setVisibility(0);
            this.fju.setText(d.j.order_video_channel);
        } else {
            this.fju.setVisibility(8);
        }
        aj.i(this.fjo, d.C0096d.cp_cont_f);
        aj.i(this.fjr, d.C0096d.cp_cont_f);
        aj.i(this.fjs, d.C0096d.cp_cont_f);
        aj.j(this.fjp, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.boZ != null && j > 0 && j == this.boZ.channelId) {
            if (i == 1) {
                this.fju.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.fju, d.C0096d.cp_cont_d);
                this.fju.setClickable(false);
                this.fju.setText(d.j.has_ordered_channel);
                return;
            }
            this.fju.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.fju, d.C0096d.btn_forum_focus_color);
            this.fju.setClickable(true);
            this.fju.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aYn() {
        return this.fju;
    }
}
