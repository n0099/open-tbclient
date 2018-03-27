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
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e {
    public int aQH;
    private View.OnClickListener bML = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gbx || view == e.this.gby || view == e.this.gbz) {
                    if (e.this.che != null) {
                        e.this.bSF.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bSF.getActivity(), e.this.che.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").s("obj_id", 1));
                } else if (view == e.this.gbE) {
                    if (l.pa()) {
                        if (e.this.che != null && e.this.che.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ay.aZ(e.this.bSF.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0095a.a(e.this.che.channelId, e.this.bSF.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bSF.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public BaseActivity bSF;
    private bj che;
    public LinearLayout gbA;
    public TextView gbB;
    public TextView gbC;
    public LinearLayout gbD;
    public TextView gbE;
    public RelativeLayout gbF;
    public HeadImageView gbx;
    public TextView gby;
    public ImageView gbz;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bSF = baseActivity;
            this.rootView = view;
            this.gbx = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.gby = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.gbz = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.gbA = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.gbB = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.gbC = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.gbD = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.gbE = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.gbF = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.gbx.setImageDrawable(null);
            this.gbx.setRadius(l.t(baseActivity.getActivity(), d.e.ds40));
            this.gbx.setOnClickListener(this.bML);
            this.gbz.setOnClickListener(this.bML);
            this.gbE.setOnClickListener(this.bML);
            this.gby.setOnClickListener(this.bML);
        }
    }

    public void ad(bd bdVar) {
        if (bdVar != null && bdVar.Ao() != null && this.rootView != null) {
            this.che = bdVar.Ao();
            this.gbB.setText(am.z(bdVar.getCreateTime()));
            this.gbC.setText(bdVar.getAddress());
            this.gby.setText(this.che.channelName);
            this.gbx.startLoad(this.che.channelAvatar, 10, false);
            if (this.che.aQH == 1) {
                this.aQH = 0;
            } else {
                this.aQH = this.che.aQH;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aQH = 2;
            }
            i(this.aQH, this.che.channelId);
            Jb();
        }
    }

    public void Jb() {
        this.bSF.getLayoutMode().aM(this.rootView);
        if (this.aQH == 1) {
            this.gbE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbE, d.C0141d.cp_cont_d);
            this.gbE.setText(d.j.has_ordered_channel);
            this.gbE.setVisibility(0);
        } else if (this.aQH == 2) {
            this.gbE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbE, d.C0141d.btn_forum_focus_color);
            this.gbE.setVisibility(0);
            this.gbE.setText(d.j.order_video_channel);
        } else {
            this.gbE.setVisibility(8);
        }
        aj.r(this.gby, d.C0141d.cp_cont_f);
        aj.r(this.gbB, d.C0141d.cp_cont_f);
        aj.r(this.gbC, d.C0141d.cp_cont_f);
        aj.s(this.gbz, d.f.icon_weiba);
    }

    public void i(int i, long j) {
        if (this.che != null && j > 0 && j == this.che.channelId) {
            if (i == 1) {
                this.gbE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.gbE, d.C0141d.cp_cont_d);
                this.gbE.setClickable(false);
                this.gbE.setText(d.j.has_ordered_channel);
                return;
            }
            this.gbE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbE, d.C0141d.btn_forum_focus_color);
            this.gbE.setClickable(true);
            this.gbE.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bhk() {
        return this.gbE;
    }
}
