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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e {
    public int bML;
    public BaseActivity cWT;
    private View.OnClickListener cZN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.ida || view == e.this.idb || view == e.this.idc) {
                    if (e.this.dxy != null) {
                        e.this.cWT.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cWT.getActivity(), e.this.dxy.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").P(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.idh) {
                    if (l.kt()) {
                        if (e.this.dxy != null && e.this.dxy.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bd.cE(e.this.cWT.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0240a.a(e.this.dxy.channelId, e.this.cWT.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cWT.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    private bn dxy;
    public HeadImageView ida;
    public TextView idb;
    public ImageView idc;
    public LinearLayout idd;
    public TextView ide;
    public TextView idf;
    public LinearLayout idg;
    public TextView idh;
    public RelativeLayout idi;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cWT = baseActivity;
            this.rootView = view;
            this.ida = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.idb = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.idc = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.idd = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.ide = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.idf = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.idg = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.idh = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.idi = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.ida.setImageDrawable(null);
            this.ida.setRadius(l.g(baseActivity.getActivity(), R.dimen.ds40));
            this.ida.setOnClickListener(this.cZN);
            this.idc.setOnClickListener(this.cZN);
            this.idh.setOnClickListener(this.cZN);
            this.idb.setOnClickListener(this.cZN);
        }
    }

    public void ay(bh bhVar) {
        if (bhVar != null && bhVar.afI() != null && this.rootView != null) {
            this.dxy = bhVar.afI();
            this.ide.setText(aq.aD(bhVar.getCreateTime()));
            this.idf.setText(bhVar.getAddress());
            this.idb.setText(this.dxy.channelName);
            this.ida.startLoad(this.dxy.channelAvatar, 10, false);
            if (this.dxy.bML == 1) {
                this.bML = 0;
            } else {
                this.bML = this.dxy.bML;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bML = 2;
            }
            w(this.bML, this.dxy.channelId);
            aqg();
        }
    }

    public void aqg() {
        this.cWT.getLayoutMode().onModeChanged(this.rootView);
        if (this.bML == 1) {
            this.idh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.idh, R.color.cp_cont_d);
            this.idh.setText(R.string.has_ordered_channel);
            this.idh.setVisibility(0);
        } else if (this.bML == 2) {
            this.idh.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.idh, R.color.btn_forum_focus_color);
            this.idh.setVisibility(0);
            this.idh.setText(R.string.order_video_channel);
        } else {
            this.idh.setVisibility(8);
        }
        am.j(this.idb, R.color.cp_cont_f);
        am.j(this.ide, R.color.cp_cont_f);
        am.j(this.idf, R.color.cp_cont_f);
        am.k(this.idc, R.drawable.icon_weiba);
    }

    public void w(int i, long j) {
        if (this.dxy != null && j > 0 && j == this.dxy.channelId) {
            if (i == 1) {
                this.idh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.idh, R.color.cp_cont_d);
                this.idh.setClickable(false);
                this.idh.setText(R.string.has_ordered_channel);
                return;
            }
            this.idh.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.idh, R.color.btn_forum_focus_color);
            this.idh.setClickable(true);
            this.idh.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bZY() {
        return this.idh;
    }
}
