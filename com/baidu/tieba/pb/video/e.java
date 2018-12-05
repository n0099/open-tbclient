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
    public int avY;
    public BaseActivity bBf;
    private View.OnClickListener bDZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gjZ || view == e.this.gka || view == e.this.gkb) {
                    if (e.this.bUL != null) {
                        e.this.bBf.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bBf.getActivity(), e.this.bUL.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.gkg) {
                    if (l.ll()) {
                        if (e.this.bUL != null && e.this.bUL.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.bI(e.this.bBf.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(e.this.bUL.channelId, e.this.bBf.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bBf.showToast(e.j.no_network_guide);
                }
            }
        }
    };
    private bh bUL;
    public HeadImageView gjZ;
    public TextView gka;
    public ImageView gkb;
    public LinearLayout gkc;
    public TextView gkd;
    public TextView gke;
    public LinearLayout gkf;
    public TextView gkg;
    public RelativeLayout gkh;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bBf = baseActivity;
            this.rootView = view;
            this.gjZ = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.gka = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.gkb = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.gkc = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.gkd = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.gke = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.gkf = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.gkg = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.gkh = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.gjZ.setImageDrawable(null);
            this.gjZ.setRadius(l.h(baseActivity.getActivity(), e.C0210e.ds40));
            this.gjZ.setOnClickListener(this.bDZ);
            this.gkb.setOnClickListener(this.bDZ);
            this.gkg.setOnClickListener(this.bDZ);
            this.gka.setOnClickListener(this.bDZ);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.AJ() != null && this.rootView != null) {
            this.bUL = bbVar.AJ();
            this.gkd.setText(ao.L(bbVar.getCreateTime()));
            this.gke.setText(bbVar.getAddress());
            this.gka.setText(this.bUL.channelName);
            this.gjZ.startLoad(this.bUL.channelAvatar, 10, false);
            if (this.bUL.avY == 1) {
                this.avY = 0;
            } else {
                this.avY = this.bUL.avY;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.avY = 2;
            }
            o(this.avY, this.bUL.channelId);
            Kn();
        }
    }

    public void Kn() {
        this.bBf.getLayoutMode().onModeChanged(this.rootView);
        if (this.avY == 1) {
            this.gkg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gkg, e.d.cp_cont_d);
            this.gkg.setText(e.j.has_ordered_channel);
            this.gkg.setVisibility(0);
        } else if (this.avY == 2) {
            this.gkg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gkg, e.d.btn_forum_focus_color);
            this.gkg.setVisibility(0);
            this.gkg.setText(e.j.order_video_channel);
        } else {
            this.gkg.setVisibility(8);
        }
        al.h(this.gka, e.d.cp_cont_f);
        al.h(this.gkd, e.d.cp_cont_f);
        al.h(this.gke, e.d.cp_cont_f);
        al.i(this.gkb, e.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.bUL != null && j > 0 && j == this.bUL.channelId) {
            if (i == 1) {
                this.gkg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gkg, e.d.cp_cont_d);
                this.gkg.setClickable(false);
                this.gkg.setText(e.j.has_ordered_channel);
                return;
            }
            this.gkg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gkg, e.d.btn_forum_focus_color);
            this.gkg.setClickable(true);
            this.gkg.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bni() {
        return this.gkg;
    }
}
