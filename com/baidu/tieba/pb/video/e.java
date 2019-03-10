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
    public int bEg;
    public BaseActivity cNd;
    private View.OnClickListener cPX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.hEf || view == e.this.hEg || view == e.this.hEh) {
                    if (e.this.dkC != null) {
                        e.this.cNd.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cNd.getActivity(), e.this.dkC.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").T(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.hEm) {
                    if (l.lo()) {
                        if (e.this.dkC != null && e.this.dkC.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cY(e.this.cNd.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0189a.a(e.this.dkC.channelId, e.this.cNd.getUniqueId())));
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
    public HeadImageView hEf;
    public TextView hEg;
    public ImageView hEh;
    public LinearLayout hEi;
    public TextView hEj;
    public TextView hEk;
    public LinearLayout hEl;
    public TextView hEm;
    public RelativeLayout hEn;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cNd = baseActivity;
            this.rootView = view;
            this.hEf = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.hEg = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.hEh = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.hEi = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.hEj = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.hEk = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.hEl = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.hEm = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.hEn = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.hEf.setImageDrawable(null);
            this.hEf.setRadius(l.h(baseActivity.getActivity(), d.e.ds40));
            this.hEf.setOnClickListener(this.cPX);
            this.hEh.setOnClickListener(this.cPX);
            this.hEm.setOnClickListener(this.cPX);
            this.hEg.setOnClickListener(this.cPX);
        }
    }

    public void aA(bg bgVar) {
        if (bgVar != null && bgVar.aab() != null && this.rootView != null) {
            this.dkC = bgVar.aab();
            this.hEj.setText(ap.ao(bgVar.getCreateTime()));
            this.hEk.setText(bgVar.getAddress());
            this.hEg.setText(this.dkC.channelName);
            this.hEf.startLoad(this.dkC.channelAvatar, 10, false);
            if (this.dkC.bEg == 1) {
                this.bEg = 0;
            } else {
                this.bEg = this.dkC.bEg;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bEg = 2;
            }
            o(this.bEg, this.dkC.channelId);
            akb();
        }
    }

    public void akb() {
        this.cNd.getLayoutMode().onModeChanged(this.rootView);
        if (this.bEg == 1) {
            this.hEm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEm, d.C0236d.cp_cont_d);
            this.hEm.setText(d.j.has_ordered_channel);
            this.hEm.setVisibility(0);
        } else if (this.bEg == 2) {
            this.hEm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEm, d.C0236d.btn_forum_focus_color);
            this.hEm.setVisibility(0);
            this.hEm.setText(d.j.order_video_channel);
        } else {
            this.hEm.setVisibility(8);
        }
        al.j(this.hEg, d.C0236d.cp_cont_f);
        al.j(this.hEj, d.C0236d.cp_cont_f);
        al.j(this.hEk, d.C0236d.cp_cont_f);
        al.k(this.hEh, d.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.dkC != null && j > 0 && j == this.dkC.channelId) {
            if (i == 1) {
                this.hEm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hEm, d.C0236d.cp_cont_d);
                this.hEm.setClickable(false);
                this.hEm.setText(d.j.has_ordered_channel);
                return;
            }
            this.hEm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hEm, d.C0236d.btn_forum_focus_color);
            this.hEm.setClickable(true);
            this.hEm.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bOY() {
        return this.hEm;
    }
}
