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
    private View.OnClickListener aSK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.eXE || view == e.this.eXF || view == e.this.eXG) {
                    if (e.this.bfV != null) {
                        e.this.bnd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.bnd.getActivity(), e.this.bfV.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.eXL) {
                    if (com.baidu.adp.lib.util.k.hz()) {
                        if (e.this.bfV != null && e.this.bfV.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aS(e.this.bnd.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(e.this.bfV.channelId, e.this.bnd.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bnd.showToast(d.l.no_network_guide);
                }
            }
        }
    };
    public int aas;
    private bo bfV;
    public BaseActivity bnd;
    public HeadImageView eXE;
    public TextView eXF;
    public ImageView eXG;
    public LinearLayout eXH;
    public TextView eXI;
    public TextView eXJ;
    public LinearLayout eXK;
    public TextView eXL;
    public RelativeLayout eXM;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bnd = baseActivity;
            this.rootView = view;
            this.eXE = (HeadImageView) this.rootView.findViewById(d.h.pb_video_channel_photo);
            this.eXF = (TextView) this.rootView.findViewById(d.h.pb_video_channel_name);
            this.eXG = (ImageView) this.rootView.findViewById(d.h.pb_video_channel_icon);
            this.eXH = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_panel);
            this.eXI = (TextView) this.rootView.findViewById(d.h.pb_video_channel_publish_time);
            this.eXJ = (TextView) this.rootView.findViewById(d.h.pb_video_channel_location_address);
            this.eXK = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_sub_panel);
            this.eXL = (TextView) this.rootView.findViewById(d.h.pb_video_order_button);
            this.eXM = (RelativeLayout) this.rootView.findViewById(d.h.video_pb_header_channel_info_root);
            this.eXE.setImageDrawable(null);
            this.eXE.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), d.f.ds40));
            this.eXE.setOnClickListener(this.aSK);
            this.eXG.setOnClickListener(this.aSK);
            this.eXL.setOnClickListener(this.aSK);
            this.eXF.setOnClickListener(this.aSK);
        }
    }

    public void ad(bj bjVar) {
        if (bjVar != null && bjVar.sF() != null && this.rootView != null) {
            this.bfV = bjVar.sF();
            this.eXI.setText(am.r(bjVar.getCreateTime()));
            this.eXJ.setText(bjVar.getAddress());
            this.eXF.setText(this.bfV.channelName);
            this.eXE.c(this.bfV.channelAvatar, 10, false);
            if (this.bfV.aas == 1) {
                this.aas = 0;
            } else {
                this.aas = this.bfV.aas;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aas = 2;
            }
            k(this.aas, this.bfV.channelId);
            Ba();
        }
    }

    public void Ba() {
        this.bnd.getLayoutMode().t(this.rootView);
        if (this.aas == 1) {
            this.eXL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eXL, d.e.cp_cont_d);
            this.eXL.setText(d.l.has_ordered_channel);
            this.eXL.setVisibility(0);
        } else if (this.aas == 2) {
            this.eXL.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eXL, d.e.btn_forum_focus_color);
            this.eXL.setVisibility(0);
            this.eXL.setText(d.l.order_video_channel);
        } else {
            this.eXL.setVisibility(8);
        }
        aj.i(this.eXF, d.e.cp_cont_f);
        aj.i(this.eXI, d.e.cp_cont_f);
        aj.i(this.eXJ, d.e.cp_cont_f);
        aj.j(this.eXG, d.g.icon_weiba);
    }

    public void k(int i, long j) {
        if (this.bfV != null && j > 0 && j == this.bfV.channelId) {
            if (i == 1) {
                this.eXL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eXL, d.e.cp_cont_d);
                this.eXL.setClickable(false);
                this.eXL.setText(d.l.has_ordered_channel);
                return;
            }
            this.eXL.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eXL, d.e.btn_forum_focus_color);
            this.eXL.setClickable(true);
            this.eXL.setText(d.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aVI() {
        return this.eXL;
    }
}
