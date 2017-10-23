package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
    private View.OnClickListener aTt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.eSt || view == e.this.eSu || view == e.this.eSv) {
                    if (e.this.bhr != null) {
                        e.this.boA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.boA.getActivity(), e.this.bhr.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.eSA) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        if (e.this.bhr != null && e.this.bhr.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aS(e.this.boA.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(e.this.bhr.channelId, e.this.boA.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.boA.showToast(d.l.no_network_guide);
                }
            }
        }
    };
    public int aag;
    private bm bhr;
    public BaseActivity boA;
    public TextView eSA;
    public RelativeLayout eSB;
    public HeadImageView eSt;
    public TextView eSu;
    public ImageView eSv;
    public LinearLayout eSw;
    public TextView eSx;
    public TextView eSy;
    public LinearLayout eSz;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.boA = baseActivity;
            this.rootView = view;
            this.eSt = (HeadImageView) this.rootView.findViewById(d.h.pb_video_channel_photo);
            this.eSu = (TextView) this.rootView.findViewById(d.h.pb_video_channel_name);
            this.eSv = (ImageView) this.rootView.findViewById(d.h.pb_video_channel_icon);
            this.eSw = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_panel);
            this.eSx = (TextView) this.rootView.findViewById(d.h.pb_video_channel_publish_time);
            this.eSy = (TextView) this.rootView.findViewById(d.h.pb_video_channel_location_address);
            this.eSz = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_sub_panel);
            this.eSA = (TextView) this.rootView.findViewById(d.h.pb_video_order_button);
            this.eSB = (RelativeLayout) this.rootView.findViewById(d.h.video_pb_header_channel_info_root);
            this.eSt.setImageDrawable(null);
            this.eSt.setRadius(com.baidu.adp.lib.util.l.f(baseActivity.getActivity(), d.f.ds40));
            this.eSt.setOnClickListener(this.aTt);
            this.eSv.setOnClickListener(this.aTt);
            this.eSA.setOnClickListener(this.aTt);
            this.eSu.setOnClickListener(this.aTt);
        }
    }

    public void Y(bh bhVar) {
        if (bhVar != null && bhVar.ss() != null && this.rootView != null) {
            this.bhr = bhVar.ss();
            this.eSx.setText(am.r(bhVar.getCreateTime()));
            this.eSy.setText(bhVar.getAddress());
            this.eSu.setText(this.bhr.channelName);
            this.eSt.c(this.bhr.channelAvatar, 10, false);
            if (this.bhr.aag == 1) {
                this.aag = 0;
            } else {
                this.aag = this.bhr.aag;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aag = 2;
            }
            k(this.aag, this.bhr.channelId);
            As();
        }
    }

    public void As() {
        this.boA.getLayoutMode().t(this.rootView);
        if (this.aag == 1) {
            this.eSA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSA, d.e.cp_cont_d);
            this.eSA.setText(d.l.has_ordered_channel);
            this.eSA.setVisibility(0);
        } else if (this.aag == 2) {
            this.eSA.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSA, d.e.btn_forum_focus_color);
            this.eSA.setVisibility(0);
            this.eSA.setText(d.l.order_video_channel);
        } else {
            this.eSA.setVisibility(8);
        }
        aj.i(this.eSu, d.e.cp_cont_f);
        aj.i(this.eSx, d.e.cp_cont_f);
        aj.i(this.eSy, d.e.cp_cont_f);
        aj.j(this.eSv, d.g.icon_weiba);
    }

    public void k(int i, long j) {
        if (this.bhr != null && j > 0 && j == this.bhr.channelId) {
            if (i == 1) {
                this.eSA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eSA, d.e.cp_cont_d);
                this.eSA.setClickable(false);
                this.eSA.setText(d.l.has_ordered_channel);
                return;
            }
            this.eSA.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSA, d.e.btn_forum_focus_color);
            this.eSA.setClickable(true);
            this.eSA.setText(d.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aTX() {
        return this.eSA;
    }
}
