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
    public int awC;
    public BaseActivity bBW;
    private View.OnClickListener bEQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gnU || view == e.this.gnV || view == e.this.gnW) {
                    if (e.this.bVA != null) {
                        e.this.bBW.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bBW.getActivity(), e.this.bVA.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").y(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.gob) {
                    if (l.ll()) {
                        if (e.this.bVA != null && e.this.bVA.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.bI(e.this.bBW.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(e.this.bVA.channelId, e.this.bBW.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bBW.showToast(e.j.no_network_guide);
                }
            }
        }
    };
    private bh bVA;
    public HeadImageView gnU;
    public TextView gnV;
    public ImageView gnW;
    public LinearLayout gnX;
    public TextView gnY;
    public TextView gnZ;
    public LinearLayout goa;
    public TextView gob;
    public RelativeLayout goc;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bBW = baseActivity;
            this.rootView = view;
            this.gnU = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.gnV = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.gnW = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.gnX = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.gnY = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.gnZ = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.goa = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.gob = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.goc = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.gnU.setImageDrawable(null);
            this.gnU.setRadius(l.h(baseActivity.getActivity(), e.C0210e.ds40));
            this.gnU.setOnClickListener(this.bEQ);
            this.gnW.setOnClickListener(this.bEQ);
            this.gob.setOnClickListener(this.bEQ);
            this.gnV.setOnClickListener(this.bEQ);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.AW() != null && this.rootView != null) {
            this.bVA = bbVar.AW();
            this.gnY.setText(ao.M(bbVar.getCreateTime()));
            this.gnZ.setText(bbVar.getAddress());
            this.gnV.setText(this.bVA.channelName);
            this.gnU.startLoad(this.bVA.channelAvatar, 10, false);
            if (this.bVA.awC == 1) {
                this.awC = 0;
            } else {
                this.awC = this.bVA.awC;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.awC = 2;
            }
            o(this.awC, this.bVA.channelId);
            KD();
        }
    }

    public void KD() {
        this.bBW.getLayoutMode().onModeChanged(this.rootView);
        if (this.awC == 1) {
            this.gob.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gob, e.d.cp_cont_d);
            this.gob.setText(e.j.has_ordered_channel);
            this.gob.setVisibility(0);
        } else if (this.awC == 2) {
            this.gob.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gob, e.d.btn_forum_focus_color);
            this.gob.setVisibility(0);
            this.gob.setText(e.j.order_video_channel);
        } else {
            this.gob.setVisibility(8);
        }
        al.h(this.gnV, e.d.cp_cont_f);
        al.h(this.gnY, e.d.cp_cont_f);
        al.h(this.gnZ, e.d.cp_cont_f);
        al.i(this.gnW, e.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.bVA != null && j > 0 && j == this.bVA.channelId) {
            if (i == 1) {
                this.gob.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gob, e.d.cp_cont_d);
                this.gob.setClickable(false);
                this.gob.setText(e.j.has_ordered_channel);
                return;
            }
            this.gob.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gob, e.d.btn_forum_focus_color);
            this.gob.setClickable(true);
            this.gob.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View boB() {
        return this.gob;
    }
}
