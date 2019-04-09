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
    public int bEm;
    public BaseActivity cNd;
    private View.OnClickListener cPX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.hDM || view == e.this.hDN || view == e.this.hDO) {
                    if (e.this.dkC != null) {
                        e.this.cNd.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cNd.getActivity(), e.this.dkC.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.hDT) {
                    if (l.lo()) {
                        if (e.this.dkC != null && e.this.dkC.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cY(e.this.cNd.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0223a.a(e.this.dkC.channelId, e.this.cNd.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cNd.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    private bm dkC;
    public HeadImageView hDM;
    public TextView hDN;
    public ImageView hDO;
    public LinearLayout hDP;
    public TextView hDQ;
    public TextView hDR;
    public LinearLayout hDS;
    public TextView hDT;
    public RelativeLayout hDU;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cNd = baseActivity;
            this.rootView = view;
            this.hDM = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.hDN = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.hDO = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.hDP = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.hDQ = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.hDR = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.hDS = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.hDT = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.hDU = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.hDM.setImageDrawable(null);
            this.hDM.setRadius(l.h(baseActivity.getActivity(), d.e.ds40));
            this.hDM.setOnClickListener(this.cPX);
            this.hDO.setOnClickListener(this.cPX);
            this.hDT.setOnClickListener(this.cPX);
            this.hDN.setOnClickListener(this.cPX);
        }
    }

    public void az(bg bgVar) {
        if (bgVar != null && bgVar.ZY() != null && this.rootView != null) {
            this.dkC = bgVar.ZY();
            this.hDQ.setText(ap.ao(bgVar.getCreateTime()));
            this.hDR.setText(bgVar.getAddress());
            this.hDN.setText(this.dkC.channelName);
            this.hDM.startLoad(this.dkC.channelAvatar, 10, false);
            if (this.dkC.bEm == 1) {
                this.bEm = 0;
            } else {
                this.bEm = this.dkC.bEm;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bEm = 2;
            }
            o(this.bEm, this.dkC.channelId);
            ajX();
        }
    }

    public void ajX() {
        this.cNd.getLayoutMode().onModeChanged(this.rootView);
        if (this.bEm == 1) {
            this.hDT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDT, d.C0277d.cp_cont_d);
            this.hDT.setText(d.j.has_ordered_channel);
            this.hDT.setVisibility(0);
        } else if (this.bEm == 2) {
            this.hDT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDT, d.C0277d.btn_forum_focus_color);
            this.hDT.setVisibility(0);
            this.hDT.setText(d.j.order_video_channel);
        } else {
            this.hDT.setVisibility(8);
        }
        al.j(this.hDN, d.C0277d.cp_cont_f);
        al.j(this.hDQ, d.C0277d.cp_cont_f);
        al.j(this.hDR, d.C0277d.cp_cont_f);
        al.k(this.hDO, d.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.dkC != null && j > 0 && j == this.dkC.channelId) {
            if (i == 1) {
                this.hDT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hDT, d.C0277d.cp_cont_d);
                this.hDT.setClickable(false);
                this.hDT.setText(d.j.has_ordered_channel);
                return;
            }
            this.hDT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hDT, d.C0277d.btn_forum_focus_color);
            this.hDT.setClickable(true);
            this.hDT.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bOV() {
        return this.hDT;
    }
}
