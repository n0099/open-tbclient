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
    private View.OnClickListener aSZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.eYS || view == e.this.eYT || view == e.this.eYU) {
                    if (e.this.bfT != null) {
                        e.this.bmE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.bmE.getActivity(), e.this.bfT.channelId, 2)));
                    }
                    TiebaStatic.log(new aj("c11923").r("obj_id", 1));
                } else if (view == e.this.eYZ) {
                    if (com.baidu.adp.lib.util.k.hI()) {
                        if (e.this.bfT != null && e.this.bfT.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                aw.aN(e.this.bmE.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0041a.a(e.this.bfT.channelId, e.this.bmE.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bmE.showToast(d.l.no_network_guide);
                }
            }
        }
    };
    public int abn;
    private bq bfT;
    public BaseActivity bmE;
    public HeadImageView eYS;
    public TextView eYT;
    public ImageView eYU;
    public LinearLayout eYV;
    public TextView eYW;
    public TextView eYX;
    public LinearLayout eYY;
    public TextView eYZ;
    public RelativeLayout eZa;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bmE = baseActivity;
            this.rootView = view;
            this.eYS = (HeadImageView) this.rootView.findViewById(d.h.pb_video_channel_photo);
            this.eYT = (TextView) this.rootView.findViewById(d.h.pb_video_channel_name);
            this.eYU = (ImageView) this.rootView.findViewById(d.h.pb_video_channel_icon);
            this.eYV = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_panel);
            this.eYW = (TextView) this.rootView.findViewById(d.h.pb_video_channel_publish_time);
            this.eYX = (TextView) this.rootView.findViewById(d.h.pb_video_channel_location_address);
            this.eYY = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_sub_panel);
            this.eYZ = (TextView) this.rootView.findViewById(d.h.pb_video_order_button);
            this.eZa = (RelativeLayout) this.rootView.findViewById(d.h.video_pb_header_channel_info_root);
            this.eYS.setImageDrawable(null);
            this.eYS.setRadius(com.baidu.adp.lib.util.k.g(baseActivity.getActivity(), d.f.ds40));
            this.eYS.setOnClickListener(this.aSZ);
            this.eYU.setOnClickListener(this.aSZ);
            this.eYZ.setOnClickListener(this.aSZ);
            this.eYT.setOnClickListener(this.aSZ);
        }
    }

    public void X(bl blVar) {
        if (blVar != null && blVar.sJ() != null && this.rootView != null) {
            this.bfT = blVar.sJ();
            this.eYW.setText(al.r(blVar.getCreateTime()));
            this.eYX.setText(blVar.getAddress());
            this.eYT.setText(this.bfT.channelName);
            this.eYS.c(this.bfT.channelAvatar, 10, false);
            if (this.bfT.abn == 1) {
                this.abn = 0;
            } else {
                this.abn = this.bfT.abn;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.abn = 2;
            }
            j(this.abn, this.bfT.channelId);
            Bf();
        }
    }

    public void Bf() {
        this.bmE.getLayoutMode().t(this.rootView);
        if (this.abn == 1) {
            this.eYZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eYZ, d.e.cp_cont_d);
            this.eYZ.setText(d.l.has_ordered_channel);
            this.eYZ.setVisibility(0);
        } else if (this.abn == 2) {
            this.eYZ.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eYZ, d.e.btn_forum_focus_color);
            this.eYZ.setVisibility(0);
            this.eYZ.setText(d.l.order_video_channel);
        } else {
            this.eYZ.setVisibility(8);
        }
        ai.i(this.eYT, d.e.cp_cont_f);
        ai.i(this.eYW, d.e.cp_cont_f);
        ai.i(this.eYX, d.e.cp_cont_f);
        ai.j(this.eYU, d.g.icon_weiba);
    }

    public void j(int i, long j) {
        if (this.bfT != null && j > 0 && j == this.bfT.channelId) {
            if (i == 1) {
                this.eYZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                ai.i(this.eYZ, d.e.cp_cont_d);
                this.eYZ.setClickable(false);
                this.eYZ.setText(d.l.has_ordered_channel);
                return;
            }
            this.eYZ.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this.eYZ, d.e.btn_forum_focus_color);
            this.eYZ.setClickable(true);
            this.eYZ.setText(d.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aWz() {
        return this.eYZ;
    }
}
