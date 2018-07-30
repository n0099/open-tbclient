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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e {
    public int akk;
    private bh bBQ;
    public BaseActivity bmZ;
    private View.OnClickListener bpX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fMt || view == e.this.fMu || view == e.this.fMv) {
                    if (e.this.bBQ != null) {
                        e.this.bmZ.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bmZ.getActivity(), e.this.bBQ.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").r(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.fMA) {
                    if (l.jV()) {
                        if (e.this.bBQ != null && e.this.bBQ.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.aU(e.this.bmZ.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0099a.a(e.this.bBQ.channelId, e.this.bmZ.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bmZ.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public TextView fMA;
    public RelativeLayout fMB;
    public HeadImageView fMt;
    public TextView fMu;
    public ImageView fMv;
    public LinearLayout fMw;
    public TextView fMx;
    public TextView fMy;
    public LinearLayout fMz;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bmZ = baseActivity;
            this.rootView = view;
            this.fMt = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fMu = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fMv = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fMw = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fMx = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fMy = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fMz = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fMA = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fMB = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fMt.setImageDrawable(null);
            this.fMt.setRadius(l.f(baseActivity.getActivity(), d.e.ds40));
            this.fMt.setOnClickListener(this.bpX);
            this.fMv.setOnClickListener(this.bpX);
            this.fMA.setOnClickListener(this.bpX);
            this.fMu.setOnClickListener(this.bpX);
        }
    }

    public void an(bb bbVar) {
        if (bbVar != null && bbVar.wl() != null && this.rootView != null) {
            this.bBQ = bbVar.wl();
            this.fMx.setText(ap.w(bbVar.getCreateTime()));
            this.fMy.setText(bbVar.getAddress());
            this.fMu.setText(this.bBQ.channelName);
            this.fMt.startLoad(this.bBQ.channelAvatar, 10, false);
            if (this.bBQ.akk == 1) {
                this.akk = 0;
            } else {
                this.akk = this.bBQ.akk;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.akk = 2;
            }
            l(this.akk, this.bBQ.channelId);
            FG();
        }
    }

    public void FG() {
        this.bmZ.getLayoutMode().onModeChanged(this.rootView);
        if (this.akk == 1) {
            this.fMA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMA, d.C0140d.cp_cont_d);
            this.fMA.setText(d.j.has_ordered_channel);
            this.fMA.setVisibility(0);
        } else if (this.akk == 2) {
            this.fMA.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMA, d.C0140d.btn_forum_focus_color);
            this.fMA.setVisibility(0);
            this.fMA.setText(d.j.order_video_channel);
        } else {
            this.fMA.setVisibility(8);
        }
        am.h(this.fMu, d.C0140d.cp_cont_f);
        am.h(this.fMx, d.C0140d.cp_cont_f);
        am.h(this.fMy, d.C0140d.cp_cont_f);
        am.i(this.fMv, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bBQ != null && j > 0 && j == this.bBQ.channelId) {
            if (i == 1) {
                this.fMA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(this.fMA, d.C0140d.cp_cont_d);
                this.fMA.setClickable(false);
                this.fMA.setText(d.j.has_ordered_channel);
                return;
            }
            this.fMA.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this.fMA, d.C0140d.btn_forum_focus_color);
            this.fMA.setClickable(true);
            this.fMA.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bgj() {
        return this.fMA;
    }
}
