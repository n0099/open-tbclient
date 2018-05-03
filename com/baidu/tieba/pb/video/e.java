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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e {
    public int ach;
    public BaseActivity bcJ;
    private View.OnClickListener bfI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null) {
                if (view2 == e.this.fvD || view2 == e.this.fvE || view2 == e.this.fvF) {
                    if (e.this.brk != null) {
                        e.this.bcJ.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bcJ.getActivity(), e.this.brk.channelId, 2)));
                    }
                    TiebaStatic.log(new al("c11923").r(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view2 == e.this.fvK) {
                    if (l.hg()) {
                        if (e.this.brk != null && e.this.brk.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                az.aJ(e.this.bcJ.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0084a.a(e.this.brk.channelId, e.this.bcJ.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bcJ.showToast(d.k.no_network_guide);
                }
            }
        }
    };
    private bj brk;
    public HeadImageView fvD;
    public TextView fvE;
    public ImageView fvF;
    public LinearLayout fvG;
    public TextView fvH;
    public TextView fvI;
    public LinearLayout fvJ;
    public TextView fvK;
    public RelativeLayout fvL;
    public View rootView;

    public e(BaseActivity baseActivity, View view2) {
        if (baseActivity != null && view2 != null) {
            this.bcJ = baseActivity;
            this.rootView = view2;
            this.fvD = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fvE = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fvF = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fvG = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fvH = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fvI = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fvJ = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fvK = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fvL = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fvD.setImageDrawable(null);
            this.fvD.setRadius(l.e(baseActivity.getActivity(), d.e.ds40));
            this.fvD.setOnClickListener(this.bfI);
            this.fvF.setOnClickListener(this.bfI);
            this.fvK.setOnClickListener(this.bfI);
            this.fvE.setOnClickListener(this.bfI);
        }
    }

    public void af(bd bdVar) {
        if (bdVar != null && bdVar.sQ() != null && this.rootView != null) {
            this.brk = bdVar.sQ();
            this.fvH.setText(an.s(bdVar.getCreateTime()));
            this.fvI.setText(bdVar.getAddress());
            this.fvE.setText(this.brk.channelName);
            this.fvD.startLoad(this.brk.channelAvatar, 10, false);
            if (this.brk.ach == 1) {
                this.ach = 0;
            } else {
                this.ach = this.brk.ach;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.ach = 2;
            }
            n(this.ach, this.brk.channelId);
            BR();
        }
    }

    public void BR() {
        this.bcJ.getLayoutMode().u(this.rootView);
        if (this.ach == 1) {
            this.fvK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fvK, d.C0126d.cp_cont_d);
            this.fvK.setText(d.k.has_ordered_channel);
            this.fvK.setVisibility(0);
        } else if (this.ach == 2) {
            this.fvK.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fvK, d.C0126d.btn_forum_focus_color);
            this.fvK.setVisibility(0);
            this.fvK.setText(d.k.order_video_channel);
        } else {
            this.fvK.setVisibility(8);
        }
        ak.h(this.fvE, d.C0126d.cp_cont_f);
        ak.h(this.fvH, d.C0126d.cp_cont_f);
        ak.h(this.fvI, d.C0126d.cp_cont_f);
        ak.i(this.fvF, d.f.icon_weiba);
    }

    public void n(int i, long j) {
        if (this.brk != null && j > 0 && j == this.brk.channelId) {
            if (i == 1) {
                this.fvK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.fvK, d.C0126d.cp_cont_d);
                this.fvK.setClickable(false);
                this.fvK.setText(d.k.has_ordered_channel);
                return;
            }
            this.fvK.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fvK, d.C0126d.btn_forum_focus_color);
            this.fvK.setClickable(true);
            this.fvK.setText(d.k.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bck() {
        return this.fvK;
    }
}
