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
                if (view == e.this.gbK || view == e.this.gbL || view == e.this.gbM) {
                    if (e.this.bQk != null) {
                        e.this.bwX.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bwX.getActivity(), e.this.bQk.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.gbR) {
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
    public HeadImageView gbK;
    public TextView gbL;
    public ImageView gbM;
    public LinearLayout gbN;
    public TextView gbO;
    public TextView gbP;
    public LinearLayout gbQ;
    public TextView gbR;
    public RelativeLayout gbS;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bwX = baseActivity;
            this.rootView = view;
            this.gbK = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.gbL = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.gbM = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.gbN = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.gbO = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.gbP = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.gbQ = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.gbR = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.gbS = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.gbK.setImageDrawable(null);
            this.gbK.setRadius(l.h(baseActivity.getActivity(), e.C0175e.ds40));
            this.gbK.setOnClickListener(this.bzR);
            this.gbM.setOnClickListener(this.bzR);
            this.gbR.setOnClickListener(this.bzR);
            this.gbL.setOnClickListener(this.bzR);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.zy() != null && this.rootView != null) {
            this.bQk = bbVar.zy();
            this.gbO.setText(ao.C(bbVar.getCreateTime()));
            this.gbP.setText(bbVar.getAddress());
            this.gbL.setText(this.bQk.channelName);
            this.gbK.startLoad(this.bQk.channelAvatar, 10, false);
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
            this.gbR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbR, e.d.cp_cont_d);
            this.gbR.setText(e.j.has_ordered_channel);
            this.gbR.setVisibility(0);
        } else if (this.arL == 2) {
            this.gbR.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbR, e.d.btn_forum_focus_color);
            this.gbR.setVisibility(0);
            this.gbR.setText(e.j.order_video_channel);
        } else {
            this.gbR.setVisibility(8);
        }
        al.h(this.gbL, e.d.cp_cont_f);
        al.h(this.gbO, e.d.cp_cont_f);
        al.h(this.gbP, e.d.cp_cont_f);
        al.i(this.gbM, e.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bQk != null && j > 0 && j == this.bQk.channelId) {
            if (i == 1) {
                this.gbR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gbR, e.d.cp_cont_d);
                this.gbR.setClickable(false);
                this.gbR.setText(e.j.has_ordered_channel);
                return;
            }
            this.gbR.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gbR, e.d.btn_forum_focus_color);
            this.gbR.setClickable(true);
            this.gbR.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View blT() {
        return this.gbR;
    }
}
