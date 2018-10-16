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
    public int arL;
    private bh bQk;
    public BaseActivity bwX;
    private View.OnClickListener bzR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gbJ || view == e.this.gbK || view == e.this.gbL) {
                    if (e.this.bQk != null) {
                        e.this.bwX.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bwX.getActivity(), e.this.bQk.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.gbQ) {
                    if (l.lo()) {
                        if (e.this.bQk != null && e.this.bQk.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.bH(e.this.bwX.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0122a.a(e.this.bQk.channelId, e.this.bwX.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bwX.showToast(e.j.no_network_guide);
                }
            }
        }
    };
    public HeadImageView gbJ;
    public TextView gbK;
    public ImageView gbL;
    public LinearLayout gbM;
    public TextView gbN;
    public TextView gbO;
    public LinearLayout gbP;
    public TextView gbQ;
    public RelativeLayout gbR;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bwX = baseActivity;
            this.rootView = view;
            this.gbJ = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.gbK = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.gbL = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.gbM = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.gbN = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.gbO = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.gbP = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.gbQ = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.gbR = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.gbJ.setImageDrawable(null);
            this.gbJ.setRadius(l.h(baseActivity.getActivity(), e.C0175e.ds40));
            this.gbJ.setOnClickListener(this.bzR);
            this.gbL.setOnClickListener(this.bzR);
            this.gbQ.setOnClickListener(this.bzR);
            this.gbK.setOnClickListener(this.bzR);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.zy() != null && this.rootView != null) {
            this.bQk = bbVar.zy();
            this.gbN.setText(ao.C(bbVar.getCreateTime()));
            this.gbO.setText(bbVar.getAddress());
            this.gbK.setText(this.bQk.channelName);
            this.gbJ.startLoad(this.bQk.channelAvatar, 10, false);
            if (this.bQk.arL == 1) {
                this.arL = 0;
            } else {
                this.arL = this.bQk.arL;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.arL = 2;
            }
            l(this.arL, this.bQk.channelId);
            IX();
        }
    }

    public void IX() {
        this.bwX.getLayoutMode().onModeChanged(this.rootView);
        if (this.arL == 1) {
            this.gbQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbQ, e.d.cp_cont_d);
            this.gbQ.setText(e.j.has_ordered_channel);
            this.gbQ.setVisibility(0);
        } else if (this.arL == 2) {
            this.gbQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbQ, e.d.btn_forum_focus_color);
            this.gbQ.setVisibility(0);
            this.gbQ.setText(e.j.order_video_channel);
        } else {
            this.gbQ.setVisibility(8);
        }
        al.h(this.gbK, e.d.cp_cont_f);
        al.h(this.gbN, e.d.cp_cont_f);
        al.h(this.gbO, e.d.cp_cont_f);
        al.i(this.gbL, e.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bQk != null && j > 0 && j == this.bQk.channelId) {
            if (i == 1) {
                this.gbQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gbQ, e.d.cp_cont_d);
                this.gbQ.setClickable(false);
                this.gbQ.setText(e.j.has_ordered_channel);
                return;
            }
            this.gbQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbQ, e.d.btn_forum_focus_color);
            this.gbQ.setClickable(true);
            this.gbQ.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View blT() {
        return this.gbQ;
    }
}
