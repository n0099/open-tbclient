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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
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
    private View.OnClickListener aSH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.eYy || view == e.this.eYz || view == e.this.eYA) {
                    if (e.this.bfS != null) {
                        e.this.bnc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.bnc.getActivity(), e.this.bfS.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.eYF) {
                    if (com.baidu.adp.lib.util.k.hz()) {
                        if (e.this.bfS != null && e.this.bfS.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aT(e.this.bnc.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0044a.a(e.this.bfS.channelId, e.this.bnc.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bnc.showToast(d.l.no_network_guide);
                }
            }
        }
    };
    public int aas;
    private bo bfS;
    public BaseActivity bnc;
    public ImageView eYA;
    public LinearLayout eYB;
    public TextView eYC;
    public TextView eYD;
    public LinearLayout eYE;
    public TextView eYF;
    public RelativeLayout eYG;
    public HeadImageView eYy;
    public TextView eYz;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bnc = baseActivity;
            this.rootView = view;
            this.eYy = (HeadImageView) this.rootView.findViewById(d.h.pb_video_channel_photo);
            this.eYz = (TextView) this.rootView.findViewById(d.h.pb_video_channel_name);
            this.eYA = (ImageView) this.rootView.findViewById(d.h.pb_video_channel_icon);
            this.eYB = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_panel);
            this.eYC = (TextView) this.rootView.findViewById(d.h.pb_video_channel_publish_time);
            this.eYD = (TextView) this.rootView.findViewById(d.h.pb_video_channel_location_address);
            this.eYE = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_sub_panel);
            this.eYF = (TextView) this.rootView.findViewById(d.h.pb_video_order_button);
            this.eYG = (RelativeLayout) this.rootView.findViewById(d.h.video_pb_header_channel_info_root);
            this.eYy.setImageDrawable(null);
            this.eYy.setRadius(com.baidu.adp.lib.util.k.f(baseActivity.getActivity(), d.f.ds40));
            this.eYy.setOnClickListener(this.aSH);
            this.eYA.setOnClickListener(this.aSH);
            this.eYF.setOnClickListener(this.aSH);
            this.eYz.setOnClickListener(this.aSH);
        }
    }

    public void ad(bj bjVar) {
        if (bjVar != null && bjVar.sF() != null && this.rootView != null) {
            this.bfS = bjVar.sF();
            this.eYC.setText(am.r(bjVar.getCreateTime()));
            this.eYD.setText(bjVar.getAddress());
            this.eYz.setText(this.bfS.channelName);
            this.eYy.c(this.bfS.channelAvatar, 10, false);
            if (this.bfS.aas == 1) {
                this.aas = 0;
            } else {
                this.aas = this.bfS.aas;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aas = 2;
            }
            k(this.aas, this.bfS.channelId);
            Ba();
        }
    }

    public void Ba() {
        this.bnc.getLayoutMode().t(this.rootView);
        if (this.aas == 1) {
            this.eYF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eYF, d.e.cp_cont_d);
            this.eYF.setText(d.l.has_ordered_channel);
            this.eYF.setVisibility(0);
        } else if (this.aas == 2) {
            this.eYF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eYF, d.e.btn_forum_focus_color);
            this.eYF.setVisibility(0);
            this.eYF.setText(d.l.order_video_channel);
        } else {
            this.eYF.setVisibility(8);
        }
        aj.i(this.eYz, d.e.cp_cont_f);
        aj.i(this.eYC, d.e.cp_cont_f);
        aj.i(this.eYD, d.e.cp_cont_f);
        aj.j(this.eYA, d.g.icon_weiba);
    }

    public void k(int i, long j) {
        if (this.bfS != null && j > 0 && j == this.bfS.channelId) {
            if (i == 1) {
                this.eYF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eYF, d.e.cp_cont_d);
                this.eYF.setClickable(false);
                this.eYF.setText(d.l.has_ordered_channel);
                return;
            }
            this.eYF.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eYF, d.e.btn_forum_focus_color);
            this.eYF.setClickable(true);
            this.eYF.setText(d.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aVT() {
        return this.eYF;
    }
}
