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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e {
    public int bEl;
    public BaseActivity cNc;
    private View.OnClickListener cPW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.hDL || view == e.this.hDM || view == e.this.hDN) {
                    if (e.this.dkB != null) {
                        e.this.cNc.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cNc.getActivity(), e.this.dkB.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.hDS) {
                    if (l.lo()) {
                        if (e.this.dkB != null && e.this.dkB.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cY(e.this.cNc.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0223a.a(e.this.dkB.channelId, e.this.cNc.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cNc.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    private bm dkB;
    public HeadImageView hDL;
    public TextView hDM;
    public ImageView hDN;
    public LinearLayout hDO;
    public TextView hDP;
    public TextView hDQ;
    public LinearLayout hDR;
    public TextView hDS;
    public RelativeLayout hDT;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cNc = baseActivity;
            this.rootView = view;
            this.hDL = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.hDM = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.hDN = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.hDO = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.hDP = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.hDQ = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.hDR = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.hDS = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.hDT = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.hDL.setImageDrawable(null);
            this.hDL.setRadius(l.h(baseActivity.getActivity(), d.e.ds40));
            this.hDL.setOnClickListener(this.cPW);
            this.hDN.setOnClickListener(this.cPW);
            this.hDS.setOnClickListener(this.cPW);
            this.hDM.setOnClickListener(this.cPW);
        }
    }

    public void az(bg bgVar) {
        if (bgVar != null && bgVar.ZY() != null && this.rootView != null) {
            this.dkB = bgVar.ZY();
            this.hDP.setText(ap.ao(bgVar.getCreateTime()));
            this.hDQ.setText(bgVar.getAddress());
            this.hDM.setText(this.dkB.channelName);
            this.hDL.startLoad(this.dkB.channelAvatar, 10, false);
            if (this.dkB.bEl == 1) {
                this.bEl = 0;
            } else {
                this.bEl = this.dkB.bEl;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bEl = 2;
            }
            o(this.bEl, this.dkB.channelId);
            ajX();
        }
    }

    public void ajX() {
        this.cNc.getLayoutMode().onModeChanged(this.rootView);
        if (this.bEl == 1) {
            this.hDS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDS, d.C0277d.cp_cont_d);
            this.hDS.setText(d.j.has_ordered_channel);
            this.hDS.setVisibility(0);
        } else if (this.bEl == 2) {
            this.hDS.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDS, d.C0277d.btn_forum_focus_color);
            this.hDS.setVisibility(0);
            this.hDS.setText(d.j.order_video_channel);
        } else {
            this.hDS.setVisibility(8);
        }
        al.j(this.hDM, d.C0277d.cp_cont_f);
        al.j(this.hDP, d.C0277d.cp_cont_f);
        al.j(this.hDQ, d.C0277d.cp_cont_f);
        al.k(this.hDN, d.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.dkB != null && j > 0 && j == this.dkB.channelId) {
            if (i == 1) {
                this.hDS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hDS, d.C0277d.cp_cont_d);
                this.hDS.setClickable(false);
                this.hDS.setText(d.j.has_ordered_channel);
                return;
            }
            this.hDS.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDS, d.C0277d.btn_forum_focus_color);
            this.hDS.setClickable(true);
            this.hDS.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bOV() {
        return this.hDS;
    }
}
