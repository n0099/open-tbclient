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
/* loaded from: classes2.dex */
public class e {
    public int amQ;
    private bh bHH;
    public BaseActivity bsQ;
    private View.OnClickListener bvP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fUj || view == e.this.fUk || view == e.this.fUl) {
                    if (e.this.bHH != null) {
                        e.this.bsQ.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bsQ.getActivity(), e.this.bHH.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").w(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.fUq) {
                    if (l.lb()) {
                        if (e.this.bHH != null && e.this.bHH.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.bz(e.this.bsQ.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0098a.a(e.this.bHH.channelId, e.this.bsQ.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bsQ.showToast(e.j.no_network_guide);
                }
            }
        }
    };
    public HeadImageView fUj;
    public TextView fUk;
    public ImageView fUl;
    public LinearLayout fUm;
    public TextView fUn;
    public TextView fUo;
    public LinearLayout fUp;
    public TextView fUq;
    public RelativeLayout fUr;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bsQ = baseActivity;
            this.rootView = view;
            this.fUj = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.fUk = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.fUl = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.fUm = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.fUn = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.fUo = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.fUp = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.fUq = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.fUr = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.fUj.setImageDrawable(null);
            this.fUj.setRadius(l.h(baseActivity.getActivity(), e.C0141e.ds40));
            this.fUj.setOnClickListener(this.bvP);
            this.fUl.setOnClickListener(this.bvP);
            this.fUq.setOnClickListener(this.bvP);
            this.fUk.setOnClickListener(this.bvP);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.xp() != null && this.rootView != null) {
            this.bHH = bbVar.xp();
            this.fUn.setText(ao.A(bbVar.getCreateTime()));
            this.fUo.setText(bbVar.getAddress());
            this.fUk.setText(this.bHH.channelName);
            this.fUj.startLoad(this.bHH.channelAvatar, 10, false);
            if (this.bHH.amQ == 1) {
                this.amQ = 0;
            } else {
                this.amQ = this.bHH.amQ;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.amQ = 2;
            }
            l(this.amQ, this.bHH.channelId);
            GW();
        }
    }

    public void GW() {
        this.bsQ.getLayoutMode().onModeChanged(this.rootView);
        if (this.amQ == 1) {
            this.fUq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fUq, e.d.cp_cont_d);
            this.fUq.setText(e.j.has_ordered_channel);
            this.fUq.setVisibility(0);
        } else if (this.amQ == 2) {
            this.fUq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fUq, e.d.btn_forum_focus_color);
            this.fUq.setVisibility(0);
            this.fUq.setText(e.j.order_video_channel);
        } else {
            this.fUq.setVisibility(8);
        }
        al.h(this.fUk, e.d.cp_cont_f);
        al.h(this.fUn, e.d.cp_cont_f);
        al.h(this.fUo, e.d.cp_cont_f);
        al.i(this.fUl, e.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bHH != null && j > 0 && j == this.bHH.channelId) {
            if (i == 1) {
                this.fUq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.fUq, e.d.cp_cont_d);
                this.fUq.setClickable(false);
                this.fUq.setText(e.j.has_ordered_channel);
                return;
            }
            this.fUq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fUq, e.d.btn_forum_focus_color);
            this.fUq.setClickable(true);
            this.fUq.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View biH() {
        return this.fUq;
    }
}
