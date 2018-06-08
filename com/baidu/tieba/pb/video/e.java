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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e {
    public int akm;
    public BaseActivity bkU;
    private View.OnClickListener bnQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.fId || view == e.this.fIe || view == e.this.fIf) {
                    if (e.this.bzE != null) {
                        e.this.bkU.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bkU.getActivity(), e.this.bzE.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").r(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.fIk) {
                    if (l.jU()) {
                        if (e.this.bzE != null && e.this.bzE.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.aT(e.this.bkU.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0101a.a(e.this.bzE.channelId, e.this.bkU.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bkU.showToast(d.k.no_network_guide);
                }
            }
        }
    };
    private bj bzE;
    public HeadImageView fId;
    public TextView fIe;
    public ImageView fIf;
    public LinearLayout fIg;
    public TextView fIh;
    public TextView fIi;
    public LinearLayout fIj;
    public TextView fIk;
    public RelativeLayout fIl;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bkU = baseActivity;
            this.rootView = view;
            this.fId = (HeadImageView) this.rootView.findViewById(d.g.pb_video_channel_photo);
            this.fIe = (TextView) this.rootView.findViewById(d.g.pb_video_channel_name);
            this.fIf = (ImageView) this.rootView.findViewById(d.g.pb_video_channel_icon);
            this.fIg = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_panel);
            this.fIh = (TextView) this.rootView.findViewById(d.g.pb_video_channel_publish_time);
            this.fIi = (TextView) this.rootView.findViewById(d.g.pb_video_channel_location_address);
            this.fIj = (LinearLayout) this.rootView.findViewById(d.g.pb_video_channel_sub_panel);
            this.fIk = (TextView) this.rootView.findViewById(d.g.pb_video_order_button);
            this.fIl = (RelativeLayout) this.rootView.findViewById(d.g.video_pb_header_channel_info_root);
            this.fId.setImageDrawable(null);
            this.fId.setRadius(l.e(baseActivity.getActivity(), d.e.ds40));
            this.fId.setOnClickListener(this.bnQ);
            this.fIf.setOnClickListener(this.bnQ);
            this.fIk.setOnClickListener(this.bnQ);
            this.fIe.setOnClickListener(this.bnQ);
        }
    }

    public void ah(bd bdVar) {
        if (bdVar != null && bdVar.wm() != null && this.rootView != null) {
            this.bzE = bdVar.wm();
            this.fIh.setText(ao.v(bdVar.getCreateTime()));
            this.fIi.setText(bdVar.getAddress());
            this.fIe.setText(this.bzE.channelName);
            this.fId.startLoad(this.bzE.channelAvatar, 10, false);
            if (this.bzE.akm == 1) {
                this.akm = 0;
            } else {
                this.akm = this.bzE.akm;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.akm = 2;
            }
            l(this.akm, this.bzE.channelId);
            Fs();
        }
    }

    public void Fs() {
        this.bkU.getLayoutMode().onModeChanged(this.rootView);
        if (this.akm == 1) {
            this.fIk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fIk, d.C0141d.cp_cont_d);
            this.fIk.setText(d.k.has_ordered_channel);
            this.fIk.setVisibility(0);
        } else if (this.akm == 2) {
            this.fIk.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fIk, d.C0141d.btn_forum_focus_color);
            this.fIk.setVisibility(0);
            this.fIk.setText(d.k.order_video_channel);
        } else {
            this.fIk.setVisibility(8);
        }
        al.h(this.fIe, d.C0141d.cp_cont_f);
        al.h(this.fIh, d.C0141d.cp_cont_f);
        al.h(this.fIi, d.C0141d.cp_cont_f);
        al.i(this.fIf, d.f.icon_weiba);
    }

    public void l(int i, long j) {
        if (this.bzE != null && j > 0 && j == this.bzE.channelId) {
            if (i == 1) {
                this.fIk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.fIk, d.C0141d.cp_cont_d);
                this.fIk.setClickable(false);
                this.fIk.setText(d.k.has_ordered_channel);
                return;
            }
            this.fIk.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.fIk, d.C0141d.btn_forum_focus_color);
            this.fIk.setClickable(true);
            this.fIk.setText(d.k.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bhk() {
        return this.fIk;
    }
}
