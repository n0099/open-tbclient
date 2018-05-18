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
    public int aci;
    public BaseActivity bcK;
    private View.OnClickListener bfJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null) {
                if (view2 == e.this.fwJ || view2 == e.this.fwK || view2 == e.this.fwL) {
                    if (e.this.brz != null) {
                        e.this.bcK.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bcK.getActivity(), e.this.brz.channelId, 2)));
                    }
                    TiebaStatic.log(new al("c11923").r(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view2 == e.this.fwQ) {
                    if (l.hg()) {
                        if (e.this.brz != null && e.this.brz.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                az.aJ(e.this.bcK.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0084a.a(e.this.brz.channelId, e.this.bcK.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bcK.showToast(d.k.no_network_guide);
                }
            }
        }
    };
    private bj brz;
    public HeadImageView fwJ;
    public TextView fwK;
    public ImageView fwL;
    public LinearLayout fwM;
    public TextView fwN;
    public TextView fwO;
    public LinearLayout fwP;
    public TextView fwQ;
    public RelativeLayout fwR;
    public View rootView;

    public e(BaseActivity baseActivity, View view2) {
        if (baseActivity != null && view2 != null) {
            this.bcK = baseActivity;
            this.rootView = view2;
            this.fwJ = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fwK = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fwL = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fwM = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fwN = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fwO = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fwP = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fwQ = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fwR = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fwJ.setImageDrawable(null);
            this.fwJ.setRadius(l.e(baseActivity.getActivity(), d.e.ds40));
            this.fwJ.setOnClickListener(this.bfJ);
            this.fwL.setOnClickListener(this.bfJ);
            this.fwQ.setOnClickListener(this.bfJ);
            this.fwK.setOnClickListener(this.bfJ);
        }
    }

    public void af(bd bdVar) {
        if (bdVar != null && bdVar.sP() != null && this.rootView != null) {
            this.brz = bdVar.sP();
            this.fwN.setText(an.s(bdVar.getCreateTime()));
            this.fwO.setText(bdVar.getAddress());
            this.fwK.setText(this.brz.channelName);
            this.fwJ.startLoad(this.brz.channelAvatar, 10, false);
            if (this.brz.aci == 1) {
                this.aci = 0;
            } else {
                this.aci = this.brz.aci;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aci = 2;
            }
            l(this.aci, this.brz.channelId);
            BP();
        }
    }

    public void BP() {
        this.bcK.getLayoutMode().u(this.rootView);
        if (this.aci == 1) {
            this.fwQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fwQ, d.C0126d.cp_cont_d);
            this.fwQ.setText(d.k.has_ordered_channel);
            this.fwQ.setVisibility(0);
        } else if (this.aci == 2) {
            this.fwQ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fwQ, d.C0126d.btn_forum_focus_color);
            this.fwQ.setVisibility(0);
            this.fwQ.setText(d.k.order_video_channel);
        } else {
            this.fwQ.setVisibility(8);
        }
        ak.h(this.fwK, d.C0126d.cp_cont_f);
        ak.h(this.fwN, d.C0126d.cp_cont_f);
        ak.h(this.fwO, d.C0126d.cp_cont_f);
        ak.i(this.fwL, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.brz != null && j > 0 && j == this.brz.channelId) {
            if (i == 1) {
                this.fwQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(this.fwQ, d.C0126d.cp_cont_d);
                this.fwQ.setClickable(false);
                this.fwQ.setText(d.k.has_ordered_channel);
                return;
            }
            this.fwQ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this.fwQ, d.C0126d.btn_forum_focus_color);
            this.fwQ.setClickable(true);
            this.fwQ.setText(d.k.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bck() {
        return this.fwQ;
    }
}
