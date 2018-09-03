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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class e {
    public int akk;
    private bh bBS;
    public BaseActivity bnc;
    private View.OnClickListener bpZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fMm || view == e.this.fMn || view == e.this.fMo) {
                    if (e.this.bBS != null) {
                        e.this.bnc.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bnc.getActivity(), e.this.bBS.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").r(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.fMt) {
                    if (l.jV()) {
                        if (e.this.bBS != null && e.this.bBS.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bb.aT(e.this.bnc.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0099a.a(e.this.bBS.channelId, e.this.bnc.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bnc.showToast(f.j.no_network_guide);
                }
            }
        }
    };
    public HeadImageView fMm;
    public TextView fMn;
    public ImageView fMo;
    public LinearLayout fMp;
    public TextView fMq;
    public TextView fMr;
    public LinearLayout fMs;
    public TextView fMt;
    public RelativeLayout fMu;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bnc = baseActivity;
            this.rootView = view;
            this.fMm = (HeadImageView) this.rootView.findViewById(f.g.pb_video_channel_photo);
            this.fMn = (TextView) this.rootView.findViewById(f.g.pb_video_channel_name);
            this.fMo = (ImageView) this.rootView.findViewById(f.g.pb_video_channel_icon);
            this.fMp = (LinearLayout) this.rootView.findViewById(f.g.pb_video_channel_panel);
            this.fMq = (TextView) this.rootView.findViewById(f.g.pb_video_channel_publish_time);
            this.fMr = (TextView) this.rootView.findViewById(f.g.pb_video_channel_location_address);
            this.fMs = (LinearLayout) this.rootView.findViewById(f.g.pb_video_channel_sub_panel);
            this.fMt = (TextView) this.rootView.findViewById(f.g.pb_video_order_button);
            this.fMu = (RelativeLayout) this.rootView.findViewById(f.g.video_pb_header_channel_info_root);
            this.fMm.setImageDrawable(null);
            this.fMm.setRadius(l.f(baseActivity.getActivity(), f.e.ds40));
            this.fMm.setOnClickListener(this.bpZ);
            this.fMo.setOnClickListener(this.bpZ);
            this.fMt.setOnClickListener(this.bpZ);
            this.fMn.setOnClickListener(this.bpZ);
        }
    }

    public void an(com.baidu.tbadk.core.data.bb bbVar) {
        if (bbVar != null && bbVar.wk() != null && this.rootView != null) {
            this.bBS = bbVar.wk();
            this.fMq.setText(ap.w(bbVar.getCreateTime()));
            this.fMr.setText(bbVar.getAddress());
            this.fMn.setText(this.bBS.channelName);
            this.fMm.startLoad(this.bBS.channelAvatar, 10, false);
            if (this.bBS.akk == 1) {
                this.akk = 0;
            } else {
                this.akk = this.bBS.akk;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.akk = 2;
            }
            l(this.akk, this.bBS.channelId);
            FG();
        }
    }

    public void FG() {
        this.bnc.getLayoutMode().onModeChanged(this.rootView);
        if (this.akk == 1) {
            this.fMt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMt, f.d.cp_cont_d);
            this.fMt.setText(f.j.has_ordered_channel);
            this.fMt.setVisibility(0);
        } else if (this.akk == 2) {
            this.fMt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMt, f.d.btn_forum_focus_color);
            this.fMt.setVisibility(0);
            this.fMt.setText(f.j.order_video_channel);
        } else {
            this.fMt.setVisibility(8);
        }
        am.h(this.fMn, f.d.cp_cont_f);
        am.h(this.fMq, f.d.cp_cont_f);
        am.h(this.fMr, f.d.cp_cont_f);
        am.i(this.fMo, f.C0146f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bBS != null && j > 0 && j == this.bBS.channelId) {
            if (i == 1) {
                this.fMt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.fMt, f.d.cp_cont_d);
                this.fMt.setClickable(false);
                this.fMt.setText(f.j.has_ordered_channel);
                return;
            }
            this.fMt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMt, f.d.btn_forum_focus_color);
            this.fMt.setClickable(true);
            this.fMt.setText(f.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bge() {
        return this.fMt;
    }
}
