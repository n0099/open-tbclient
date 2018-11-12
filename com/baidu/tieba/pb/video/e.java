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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e {
    public int asy;
    private View.OnClickListener bAC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gdh || view == e.this.gdi || view == e.this.gdj) {
                    if (e.this.bQU != null) {
                        e.this.bxI.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bxI.getActivity(), e.this.bQU.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.gdo) {
                    if (l.lm()) {
                        if (e.this.bQU != null && e.this.bQU.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.bF(e.this.bxI.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0146a.a(e.this.bQU.channelId, e.this.bxI.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bxI.showToast(e.j.no_network_guide);
                }
            }
        }
    };
    private bh bQU;
    public BaseActivity bxI;
    public HeadImageView gdh;
    public TextView gdi;
    public ImageView gdj;
    public LinearLayout gdk;
    public TextView gdl;
    public TextView gdm;
    public LinearLayout gdn;
    public TextView gdo;
    public RelativeLayout gdp;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bxI = baseActivity;
            this.rootView = view;
            this.gdh = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.gdi = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.gdj = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.gdk = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.gdl = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.gdm = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.gdn = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.gdo = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.gdp = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.gdh.setImageDrawable(null);
            this.gdh.setRadius(l.h(baseActivity.getActivity(), e.C0200e.ds40));
            this.gdh.setOnClickListener(this.bAC);
            this.gdj.setOnClickListener(this.bAC);
            this.gdo.setOnClickListener(this.bAC);
            this.gdi.setOnClickListener(this.bAC);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.zF() != null && this.rootView != null) {
            this.bQU = bbVar.zF();
            this.gdl.setText(ao.E(bbVar.getCreateTime()));
            this.gdm.setText(bbVar.getAddress());
            this.gdi.setText(this.bQU.channelName);
            this.gdh.startLoad(this.bQU.channelAvatar, 10, false);
            if (this.bQU.asy == 1) {
                this.asy = 0;
            } else {
                this.asy = this.bQU.asy;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.asy = 2;
            }
            l(this.asy, this.bQU.channelId);
            Jj();
        }
    }

    public void Jj() {
        this.bxI.getLayoutMode().onModeChanged(this.rootView);
        if (this.asy == 1) {
            this.gdo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gdo, e.d.cp_cont_d);
            this.gdo.setText(e.j.has_ordered_channel);
            this.gdo.setVisibility(0);
        } else if (this.asy == 2) {
            this.gdo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gdo, e.d.btn_forum_focus_color);
            this.gdo.setVisibility(0);
            this.gdo.setText(e.j.order_video_channel);
        } else {
            this.gdo.setVisibility(8);
        }
        al.h(this.gdi, e.d.cp_cont_f);
        al.h(this.gdl, e.d.cp_cont_f);
        al.h(this.gdm, e.d.cp_cont_f);
        al.i(this.gdj, e.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bQU != null && j > 0 && j == this.bQU.channelId) {
            if (i == 1) {
                this.gdo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gdo, e.d.cp_cont_d);
                this.gdo.setClickable(false);
                this.gdo.setText(e.j.has_ordered_channel);
                return;
            }
            this.gdo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gdo, e.d.btn_forum_focus_color);
            this.gdo.setClickable(true);
            this.gdo.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View blp() {
        return this.gdo;
    }
}
