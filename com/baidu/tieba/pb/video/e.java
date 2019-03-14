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
    public int bEi;
    public BaseActivity cNa;
    private View.OnClickListener cPU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.hDZ || view == e.this.hEa || view == e.this.hEb) {
                    if (e.this.dky != null) {
                        e.this.cNa.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cNa.getActivity(), e.this.dky.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.hEg) {
                    if (l.lo()) {
                        if (e.this.dky != null && e.this.dky.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cY(e.this.cNa.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0223a.a(e.this.dky.channelId, e.this.cNa.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cNa.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    private bm dky;
    public HeadImageView hDZ;
    public TextView hEa;
    public ImageView hEb;
    public LinearLayout hEc;
    public TextView hEd;
    public TextView hEe;
    public LinearLayout hEf;
    public TextView hEg;
    public RelativeLayout hEh;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cNa = baseActivity;
            this.rootView = view;
            this.hDZ = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.hEa = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.hEb = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.hEc = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.hEd = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.hEe = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.hEf = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.hEg = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.hEh = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.hDZ.setImageDrawable(null);
            this.hDZ.setRadius(l.h(baseActivity.getActivity(), d.e.ds40));
            this.hDZ.setOnClickListener(this.cPU);
            this.hEb.setOnClickListener(this.cPU);
            this.hEg.setOnClickListener(this.cPU);
            this.hEa.setOnClickListener(this.cPU);
        }
    }

    public void aA(bg bgVar) {
        if (bgVar != null && bgVar.aab() != null && this.rootView != null) {
            this.dky = bgVar.aab();
            this.hEd.setText(ap.ao(bgVar.getCreateTime()));
            this.hEe.setText(bgVar.getAddress());
            this.hEa.setText(this.dky.channelName);
            this.hDZ.startLoad(this.dky.channelAvatar, 10, false);
            if (this.dky.bEi == 1) {
                this.bEi = 0;
            } else {
                this.bEi = this.dky.bEi;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bEi = 2;
            }
            o(this.bEi, this.dky.channelId);
            aka();
        }
    }

    public void aka() {
        this.cNa.getLayoutMode().onModeChanged(this.rootView);
        if (this.bEi == 1) {
            this.hEg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEg, d.C0277d.cp_cont_d);
            this.hEg.setText(d.j.has_ordered_channel);
            this.hEg.setVisibility(0);
        } else if (this.bEi == 2) {
            this.hEg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEg, d.C0277d.btn_forum_focus_color);
            this.hEg.setVisibility(0);
            this.hEg.setText(d.j.order_video_channel);
        } else {
            this.hEg.setVisibility(8);
        }
        al.j(this.hEa, d.C0277d.cp_cont_f);
        al.j(this.hEd, d.C0277d.cp_cont_f);
        al.j(this.hEe, d.C0277d.cp_cont_f);
        al.k(this.hEb, d.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.dky != null && j > 0 && j == this.dky.channelId) {
            if (i == 1) {
                this.hEg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hEg, d.C0277d.cp_cont_d);
                this.hEg.setClickable(false);
                this.hEg.setText(d.j.has_ordered_channel);
                return;
            }
            this.hEg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEg, d.C0277d.btn_forum_focus_color);
            this.hEg.setClickable(true);
            this.hEg.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bOY() {
        return this.hEg;
    }
}
