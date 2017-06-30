package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    public int Zu;
    private View.OnClickListener aQD = new f(this);
    private bt bcX;
    public BaseActivity bhX;
    public HeadImageView eJn;
    public TextView eJo;
    public ImageView eJp;
    public LinearLayout eJq;
    public TextView eJr;
    public TextView eJs;
    public LinearLayout eJt;
    public TextView eJu;
    public RelativeLayout eJv;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bhX = baseActivity;
            this.rootView = view;
            this.eJn = (HeadImageView) this.rootView.findViewById(w.h.pb_video_channel_photo);
            this.eJo = (TextView) this.rootView.findViewById(w.h.pb_video_channel_name);
            this.eJp = (ImageView) this.rootView.findViewById(w.h.pb_video_channel_icon);
            this.eJq = (LinearLayout) this.rootView.findViewById(w.h.pb_video_channel_panel);
            this.eJr = (TextView) this.rootView.findViewById(w.h.pb_video_channel_publish_time);
            this.eJs = (TextView) this.rootView.findViewById(w.h.pb_video_channel_location_address);
            this.eJt = (LinearLayout) this.rootView.findViewById(w.h.pb_video_channel_sub_panel);
            this.eJu = (TextView) this.rootView.findViewById(w.h.pb_video_order_button);
            this.eJv = (RelativeLayout) this.rootView.findViewById(w.h.video_pb_header_channel_info_root);
            this.eJn.setImageDrawable(null);
            this.eJn.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), w.f.ds40));
            this.eJn.setOnClickListener(this.aQD);
            this.eJp.setOnClickListener(this.aQD);
            this.eJu.setOnClickListener(this.aQD);
            this.eJo.setOnClickListener(this.aQD);
        }
    }

    public void R(bm bmVar) {
        if (bmVar != null && bmVar.sv() != null && this.rootView != null) {
            this.bcX = bmVar.sv();
            this.eJr.setText(aw.q(bmVar.getCreateTime()));
            this.eJs.setText(bmVar.getAddress());
            this.eJo.setText(this.bcX.channelName);
            this.eJn.c(this.bcX.channelAvatar, 10, false);
            if (this.bcX.Zu == 1) {
                this.Zu = 0;
            } else {
                this.Zu = this.bcX.Zu;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.Zu = 2;
            }
            j(this.Zu, this.bcX.channelId);
            AM();
        }
    }

    public void AM() {
        this.bhX.getLayoutMode().t(this.rootView);
        if (this.Zu == 1) {
            this.eJu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            as.i(this.eJu, w.e.cp_cont_d);
            this.eJu.setText(w.l.has_ordered_channel);
            this.eJu.setVisibility(0);
        } else if (this.Zu == 2) {
            this.eJu.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            as.i(this.eJu, w.e.btn_forum_focus_color);
            this.eJu.setVisibility(0);
            this.eJu.setText(w.l.order_video_channel);
        } else {
            this.eJu.setVisibility(8);
        }
        as.i(this.eJo, w.e.cp_cont_f);
        as.i(this.eJr, w.e.cp_cont_f);
        as.i(this.eJs, w.e.cp_cont_f);
        as.j(this.eJp, w.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.bcX != null && j > 0 && j == this.bcX.channelId) {
            if (i == 1) {
                this.eJu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                as.i(this.eJu, w.e.cp_cont_d);
                this.eJu.setClickable(false);
                this.eJu.setText(w.l.has_ordered_channel);
                return;
            }
            this.eJu.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            as.i(this.eJu, w.e.btn_forum_focus_color);
            this.eJu.setClickable(true);
            this.eJu.setText(w.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aSK() {
        return this.eJu;
    }
}
