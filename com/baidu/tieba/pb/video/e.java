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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e {
    public int akL;
    private bi bBj;
    public BaseActivity bmt;
    private View.OnClickListener bpq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fMf || view == e.this.fMg || view == e.this.fMh) {
                    if (e.this.bBj != null) {
                        e.this.bmt.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bmt.getActivity(), e.this.bBj.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").r(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.fMm) {
                    if (l.jU()) {
                        if (e.this.bBj != null && e.this.bBj.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bb.aT(e.this.bmt.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0102a.a(e.this.bBj.channelId, e.this.bmt.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bmt.showToast(d.k.no_network_guide);
                }
            }
        }
    };
    public HeadImageView fMf;
    public TextView fMg;
    public ImageView fMh;
    public LinearLayout fMi;
    public TextView fMj;
    public TextView fMk;
    public LinearLayout fMl;
    public TextView fMm;
    public RelativeLayout fMn;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bmt = baseActivity;
            this.rootView = view;
            this.fMf = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fMg = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fMh = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fMi = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fMj = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fMk = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fMl = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fMm = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fMn = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fMf.setImageDrawable(null);
            this.fMf.setRadius(l.e(baseActivity.getActivity(), d.e.ds40));
            this.fMf.setOnClickListener(this.bpq);
            this.fMh.setOnClickListener(this.bpq);
            this.fMm.setOnClickListener(this.bpq);
            this.fMg.setOnClickListener(this.bpq);
        }
    }

    public void am(bc bcVar) {
        if (bcVar != null && bcVar.ww() != null && this.rootView != null) {
            this.bBj = bcVar.ww();
            this.fMj.setText(ap.w(bcVar.getCreateTime()));
            this.fMk.setText(bcVar.getAddress());
            this.fMg.setText(this.bBj.channelName);
            this.fMf.startLoad(this.bBj.channelAvatar, 10, false);
            if (this.bBj.akL == 1) {
                this.akL = 0;
            } else {
                this.akL = this.bBj.akL;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.akL = 2;
            }
            l(this.akL, this.bBj.channelId);
            FK();
        }
    }

    public void FK() {
        this.bmt.getLayoutMode().onModeChanged(this.rootView);
        if (this.akL == 1) {
            this.fMm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMm, d.C0142d.cp_cont_d);
            this.fMm.setText(d.k.has_ordered_channel);
            this.fMm.setVisibility(0);
        } else if (this.akL == 2) {
            this.fMm.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMm, d.C0142d.btn_forum_focus_color);
            this.fMm.setVisibility(0);
            this.fMm.setText(d.k.order_video_channel);
        } else {
            this.fMm.setVisibility(8);
        }
        am.h(this.fMg, d.C0142d.cp_cont_f);
        am.h(this.fMj, d.C0142d.cp_cont_f);
        am.h(this.fMk, d.C0142d.cp_cont_f);
        am.i(this.fMh, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bBj != null && j > 0 && j == this.bBj.channelId) {
            if (i == 1) {
                this.fMm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.fMm, d.C0142d.cp_cont_d);
                this.fMm.setClickable(false);
                this.fMm.setText(d.k.has_ordered_channel);
                return;
            }
            this.fMm.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMm, d.C0142d.btn_forum_focus_color);
            this.fMm.setClickable(true);
            this.fMm.setText(d.k.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bhQ() {
        return this.fMm;
    }
}
