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
/* loaded from: classes6.dex */
public class e {
    public int awB;
    public BaseActivity bBV;
    private View.OnClickListener bEP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gnT || view == e.this.gnU || view == e.this.gnV) {
                    if (e.this.bVz != null) {
                        e.this.bBV.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bBV.getActivity(), e.this.bVz.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").y(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.goa) {
                    if (l.ll()) {
                        if (e.this.bVz != null && e.this.bVz.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.bI(e.this.bBV.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(e.this.bVz.channelId, e.this.bBV.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bBV.showToast(e.j.no_network_guide);
                }
            }
        }
    };
    private bh bVz;
    public HeadImageView gnT;
    public TextView gnU;
    public ImageView gnV;
    public LinearLayout gnW;
    public TextView gnX;
    public TextView gnY;
    public LinearLayout gnZ;
    public TextView goa;
    public RelativeLayout gob;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bBV = baseActivity;
            this.rootView = view;
            this.gnT = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.gnU = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.gnV = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.gnW = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.gnX = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.gnY = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.gnZ = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.goa = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.gob = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.gnT.setImageDrawable(null);
            this.gnT.setRadius(l.h(baseActivity.getActivity(), e.C0210e.ds40));
            this.gnT.setOnClickListener(this.bEP);
            this.gnV.setOnClickListener(this.bEP);
            this.goa.setOnClickListener(this.bEP);
            this.gnU.setOnClickListener(this.bEP);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.AW() != null && this.rootView != null) {
            this.bVz = bbVar.AW();
            this.gnX.setText(ao.M(bbVar.getCreateTime()));
            this.gnY.setText(bbVar.getAddress());
            this.gnU.setText(this.bVz.channelName);
            this.gnT.startLoad(this.bVz.channelAvatar, 10, false);
            if (this.bVz.awB == 1) {
                this.awB = 0;
            } else {
                this.awB = this.bVz.awB;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.awB = 2;
            }
            o(this.awB, this.bVz.channelId);
            KD();
        }
    }

    public void KD() {
        this.bBV.getLayoutMode().onModeChanged(this.rootView);
        if (this.awB == 1) {
            this.goa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.goa, e.d.cp_cont_d);
            this.goa.setText(e.j.has_ordered_channel);
            this.goa.setVisibility(0);
        } else if (this.awB == 2) {
            this.goa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.goa, e.d.btn_forum_focus_color);
            this.goa.setVisibility(0);
            this.goa.setText(e.j.order_video_channel);
        } else {
            this.goa.setVisibility(8);
        }
        al.h(this.gnU, e.d.cp_cont_f);
        al.h(this.gnX, e.d.cp_cont_f);
        al.h(this.gnY, e.d.cp_cont_f);
        al.i(this.gnV, e.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.bVz != null && j > 0 && j == this.bVz.channelId) {
            if (i == 1) {
                this.goa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.goa, e.d.cp_cont_d);
                this.goa.setClickable(false);
                this.goa.setText(e.j.has_ordered_channel);
                return;
            }
            this.goa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.goa, e.d.btn_forum_focus_color);
            this.goa.setClickable(true);
            this.goa.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View boB() {
        return this.goa;
    }
}
