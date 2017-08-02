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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    public int ZP;
    private View.OnClickListener aRM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.eVN || view == e.this.eVO || view == e.this.eVP) {
                    if (e.this.beI != null) {
                        e.this.bll.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.bll.getActivity(), e.this.beI.channelId, 2)));
                    }
                    TiebaStatic.log(new aj("c11923").r("obj_id", 1));
                } else if (view == e.this.eVU) {
                    if (com.baidu.adp.lib.util.k.hy()) {
                        if (e.this.beI != null && e.this.beI.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                aw.aM(e.this.bll.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0041a.a(e.this.beI.channelId, e.this.bll.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bll.showToast(d.l.no_network_guide);
                }
            }
        }
    };
    private bq beI;
    public BaseActivity bll;
    public HeadImageView eVN;
    public TextView eVO;
    public ImageView eVP;
    public LinearLayout eVQ;
    public TextView eVR;
    public TextView eVS;
    public LinearLayout eVT;
    public TextView eVU;
    public RelativeLayout eVV;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bll = baseActivity;
            this.rootView = view;
            this.eVN = (HeadImageView) this.rootView.findViewById(d.h.pb_video_channel_photo);
            this.eVO = (TextView) this.rootView.findViewById(d.h.pb_video_channel_name);
            this.eVP = (ImageView) this.rootView.findViewById(d.h.pb_video_channel_icon);
            this.eVQ = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_panel);
            this.eVR = (TextView) this.rootView.findViewById(d.h.pb_video_channel_publish_time);
            this.eVS = (TextView) this.rootView.findViewById(d.h.pb_video_channel_location_address);
            this.eVT = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_sub_panel);
            this.eVU = (TextView) this.rootView.findViewById(d.h.pb_video_order_button);
            this.eVV = (RelativeLayout) this.rootView.findViewById(d.h.video_pb_header_channel_info_root);
            this.eVN.setImageDrawable(null);
            this.eVN.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), d.f.ds40));
            this.eVN.setOnClickListener(this.aRM);
            this.eVP.setOnClickListener(this.aRM);
            this.eVU.setOnClickListener(this.aRM);
            this.eVO.setOnClickListener(this.aRM);
        }
    }

    public void X(bl blVar) {
        if (blVar != null && blVar.sz() != null && this.rootView != null) {
            this.beI = blVar.sz();
            this.eVR.setText(al.r(blVar.getCreateTime()));
            this.eVS.setText(blVar.getAddress());
            this.eVO.setText(this.beI.channelName);
            this.eVN.c(this.beI.channelAvatar, 10, false);
            if (this.beI.ZP == 1) {
                this.ZP = 0;
            } else {
                this.ZP = this.beI.ZP;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.ZP = 2;
            }
            j(this.ZP, this.beI.channelId);
            AX();
        }
    }

    public void AX() {
        this.bll.getLayoutMode().t(this.rootView);
        if (this.ZP == 1) {
            this.eVU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eVU, d.e.cp_cont_d);
            this.eVU.setText(d.l.has_ordered_channel);
            this.eVU.setVisibility(0);
        } else if (this.ZP == 2) {
            this.eVU.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eVU, d.e.btn_forum_focus_color);
            this.eVU.setVisibility(0);
            this.eVU.setText(d.l.order_video_channel);
        } else {
            this.eVU.setVisibility(8);
        }
        ai.i(this.eVO, d.e.cp_cont_f);
        ai.i(this.eVR, d.e.cp_cont_f);
        ai.i(this.eVS, d.e.cp_cont_f);
        ai.j(this.eVP, d.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.beI != null && j > 0 && j == this.beI.channelId) {
            if (i == 1) {
                this.eVU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ai.i(this.eVU, d.e.cp_cont_d);
                this.eVU.setClickable(false);
                this.eVU.setText(d.l.has_ordered_channel);
                return;
            }
            this.eVU.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eVU, d.e.btn_forum_focus_color);
            this.eVU.setClickable(true);
            this.eVU.setText(d.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aVH() {
        return this.eVU;
    }
}
