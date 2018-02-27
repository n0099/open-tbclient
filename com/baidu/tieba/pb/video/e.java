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
    public int aQF;
    private View.OnClickListener bMI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gbh || view == e.this.gbi || view == e.this.gbj) {
                    if (e.this.chb != null) {
                        e.this.bSC.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bSC.getActivity(), e.this.chb.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").s("obj_id", 1));
                } else if (view == e.this.gbo) {
                    if (l.pa()) {
                        if (e.this.chb != null && e.this.chb.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ay.aZ(e.this.bSC.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0095a.a(e.this.chb.channelId, e.this.bSC.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bSC.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public BaseActivity bSC;
    private bj chb;
    public HeadImageView gbh;
    public TextView gbi;
    public ImageView gbj;
    public LinearLayout gbk;
    public TextView gbl;
    public TextView gbm;
    public LinearLayout gbn;
    public TextView gbo;
    public RelativeLayout gbp;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bSC = baseActivity;
            this.rootView = view;
            this.gbh = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.gbi = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.gbj = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.gbk = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.gbl = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.gbm = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.gbn = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.gbo = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.gbp = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.gbh.setImageDrawable(null);
            this.gbh.setRadius(l.t(baseActivity.getActivity(), d.e.ds40));
            this.gbh.setOnClickListener(this.bMI);
            this.gbj.setOnClickListener(this.bMI);
            this.gbo.setOnClickListener(this.bMI);
            this.gbi.setOnClickListener(this.bMI);
        }
    }

    public void ad(bd bdVar) {
        if (bdVar != null && bdVar.Ao() != null && this.rootView != null) {
            this.chb = bdVar.Ao();
            this.gbl.setText(am.z(bdVar.getCreateTime()));
            this.gbm.setText(bdVar.getAddress());
            this.gbi.setText(this.chb.channelName);
            this.gbh.startLoad(this.chb.channelAvatar, 10, false);
            if (this.chb.aQF == 1) {
                this.aQF = 0;
            } else {
                this.aQF = this.chb.aQF;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aQF = 2;
            }
            i(this.aQF, this.chb.channelId);
            Ja();
        }
    }

    public void Ja() {
        this.bSC.getLayoutMode().aM(this.rootView);
        if (this.aQF == 1) {
            this.gbo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbo, d.C0141d.cp_cont_d);
            this.gbo.setText(d.j.has_ordered_channel);
            this.gbo.setVisibility(0);
        } else if (this.aQF == 2) {
            this.gbo.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbo, d.C0141d.btn_forum_focus_color);
            this.gbo.setVisibility(0);
            this.gbo.setText(d.j.order_video_channel);
        } else {
            this.gbo.setVisibility(8);
        }
        aj.r(this.gbi, d.C0141d.cp_cont_f);
        aj.r(this.gbl, d.C0141d.cp_cont_f);
        aj.r(this.gbm, d.C0141d.cp_cont_f);
        aj.s(this.gbj, d.f.icon_weiba);
    }

    public void i(int i, long j) {
        if (this.chb != null && j > 0 && j == this.chb.channelId) {
            if (i == 1) {
                this.gbo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.gbo, d.C0141d.cp_cont_d);
                this.gbo.setClickable(false);
                this.gbo.setText(d.j.has_ordered_channel);
                return;
            }
            this.gbo.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbo, d.C0141d.btn_forum_focus_color);
            this.gbo.setClickable(true);
            this.gbo.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bhj() {
        return this.gbo;
    }
}
