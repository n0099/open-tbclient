package com.baidu.tieba.pb.video;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private View.OnClickListener aTa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.eYU || view == e.this.eYV || view == e.this.eYW) {
                    if (e.this.bfU != null) {
                        e.this.bmG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.bmG.getActivity(), e.this.bfU.channelId, 2)));
                    }
                    TiebaStatic.log(new aj("c11923").r("obj_id", 1));
                } else if (view == e.this.eZb) {
                    if (com.baidu.adp.lib.util.k.hI()) {
                        if (e.this.bfU != null && e.this.bfU.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                aw.aN(e.this.bmG.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0041a.a(e.this.bfU.channelId, e.this.bmG.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bmG.showToast(d.l.no_network_guide);
                }
            }
        }
    };
    public int abn;
    private bq bfU;
    public BaseActivity bmG;
    public HeadImageView eYU;
    public TextView eYV;
    public ImageView eYW;
    public LinearLayout eYX;
    public TextView eYY;
    public TextView eYZ;
    public LinearLayout eZa;
    public TextView eZb;
    public RelativeLayout eZc;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bmG = baseActivity;
            this.rootView = view;
            this.eYU = (HeadImageView) this.rootView.findViewById(d.h.pb_video_channel_photo);
            this.eYV = (TextView) this.rootView.findViewById(d.h.pb_video_channel_name);
            this.eYW = (ImageView) this.rootView.findViewById(d.h.pb_video_channel_icon);
            this.eYX = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_panel);
            this.eYY = (TextView) this.rootView.findViewById(d.h.pb_video_channel_publish_time);
            this.eYZ = (TextView) this.rootView.findViewById(d.h.pb_video_channel_location_address);
            this.eZa = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_sub_panel);
            this.eZb = (TextView) this.rootView.findViewById(d.h.pb_video_order_button);
            this.eZc = (RelativeLayout) this.rootView.findViewById(d.h.video_pb_header_channel_info_root);
            this.eYU.setImageDrawable(null);
            this.eYU.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), d.f.ds40));
            this.eYU.setOnClickListener(this.aTa);
            this.eYW.setOnClickListener(this.aTa);
            this.eZb.setOnClickListener(this.aTa);
            this.eYV.setOnClickListener(this.aTa);
        }
    }

    public void X(bl blVar) {
        if (blVar != null && blVar.sK() != null && this.rootView != null) {
            this.bfU = blVar.sK();
            this.eYY.setText(al.r(blVar.getCreateTime()));
            this.eYZ.setText(blVar.getAddress());
            this.eYV.setText(this.bfU.channelName);
            this.eYU.c(this.bfU.channelAvatar, 10, false);
            if (this.bfU.abn == 1) {
                this.abn = 0;
            } else {
                this.abn = this.bfU.abn;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.abn = 2;
            }
            j(this.abn, this.bfU.channelId);
            Bf();
        }
    }

    public void Bf() {
        this.bmG.getLayoutMode().t(this.rootView);
        if (this.abn == 1) {
            this.eZb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eZb, d.e.cp_cont_d);
            this.eZb.setText(d.l.has_ordered_channel);
            this.eZb.setVisibility(0);
        } else if (this.abn == 2) {
            this.eZb.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eZb, d.e.btn_forum_focus_color);
            this.eZb.setVisibility(0);
            this.eZb.setText(d.l.order_video_channel);
        } else {
            this.eZb.setVisibility(8);
        }
        ai.i(this.eYV, d.e.cp_cont_f);
        ai.i(this.eYY, d.e.cp_cont_f);
        ai.i(this.eYZ, d.e.cp_cont_f);
        ai.j(this.eYW, d.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.bfU != null && j > 0 && j == this.bfU.channelId) {
            if (i == 1) {
                this.eZb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ai.i(this.eZb, d.e.cp_cont_d);
                this.eZb.setClickable(false);
                this.eZb.setText(d.l.has_ordered_channel);
                return;
            }
            this.eZb.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eZb, d.e.btn_forum_focus_color);
            this.eZb.setClickable(true);
            this.eZb.setText(d.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aWu() {
        return this.eZb;
    }
}
