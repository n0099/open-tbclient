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
    public int aQQ;
    private View.OnClickListener bMV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gbs || view == e.this.gbt || view == e.this.gbu) {
                    if (e.this.chn != null) {
                        e.this.bSO.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bSO.getActivity(), e.this.chn.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").s("obj_id", 1));
                } else if (view == e.this.gbz) {
                    if (l.pa()) {
                        if (e.this.chn != null && e.this.chn.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ay.aZ(e.this.bSO.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0094a.a(e.this.chn.channelId, e.this.bSO.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bSO.showToast(d.j.no_network_guide);
                }
            }
        }
    };
    public BaseActivity bSO;
    private bj chn;
    public RelativeLayout gbA;
    public HeadImageView gbs;
    public TextView gbt;
    public ImageView gbu;
    public LinearLayout gbv;
    public TextView gbw;
    public TextView gbx;
    public LinearLayout gby;
    public TextView gbz;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bSO = baseActivity;
            this.rootView = view;
            this.gbs = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.gbt = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.gbu = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.gbv = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.gbw = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.gbx = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.gby = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.gbz = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.gbA = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.gbs.setImageDrawable(null);
            this.gbs.setRadius(l.t(baseActivity.getActivity(), d.e.ds40));
            this.gbs.setOnClickListener(this.bMV);
            this.gbu.setOnClickListener(this.bMV);
            this.gbz.setOnClickListener(this.bMV);
            this.gbt.setOnClickListener(this.bMV);
        }
    }

    public void ad(bd bdVar) {
        if (bdVar != null && bdVar.Ao() != null && this.rootView != null) {
            this.chn = bdVar.Ao();
            this.gbw.setText(am.z(bdVar.getCreateTime()));
            this.gbx.setText(bdVar.getAddress());
            this.gbt.setText(this.chn.channelName);
            this.gbs.startLoad(this.chn.channelAvatar, 10, false);
            if (this.chn.aQQ == 1) {
                this.aQQ = 0;
            } else {
                this.aQQ = this.chn.aQQ;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aQQ = 2;
            }
            i(this.aQQ, this.chn.channelId);
            Jb();
        }
    }

    public void Jb() {
        this.bSO.getLayoutMode().aM(this.rootView);
        if (this.aQQ == 1) {
            this.gbz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbz, d.C0140d.cp_cont_d);
            this.gbz.setText(d.j.has_ordered_channel);
            this.gbz.setVisibility(0);
        } else if (this.aQQ == 2) {
            this.gbz.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbz, d.C0140d.btn_forum_focus_color);
            this.gbz.setVisibility(0);
            this.gbz.setText(d.j.order_video_channel);
        } else {
            this.gbz.setVisibility(8);
        }
        aj.r(this.gbt, d.C0140d.cp_cont_f);
        aj.r(this.gbw, d.C0140d.cp_cont_f);
        aj.r(this.gbx, d.C0140d.cp_cont_f);
        aj.s(this.gbu, d.f.icon_weiba);
    }

    public void i(int i, long j) {
        if (this.chn != null && j > 0 && j == this.chn.channelId) {
            if (i == 1) {
                this.gbz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(this.gbz, d.C0140d.cp_cont_d);
                this.gbz.setClickable(false);
                this.gbz.setText(d.j.has_ordered_channel);
                return;
            }
            this.gbz.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this.gbz, d.C0140d.btn_forum_focus_color);
            this.gbz.setClickable(true);
            this.gbz.setText(d.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bhk() {
        return this.gbz;
    }
}
