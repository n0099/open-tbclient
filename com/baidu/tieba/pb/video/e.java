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
    public int avZ;
    public BaseActivity bBi;
    private View.OnClickListener bEc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.gmQ || view == e.this.gmR || view == e.this.gmS) {
                    if (e.this.bUO != null) {
                        e.this.bBi.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.bBi.getActivity(), e.this.bUO.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").x(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.gmX) {
                    if (l.ll()) {
                        if (e.this.bUO != null && e.this.bUO.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ba.bI(e.this.bBi.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0156a.a(e.this.bUO.channelId, e.this.bBi.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.bBi.showToast(e.j.no_network_guide);
                }
            }
        }
    };
    private bh bUO;
    public HeadImageView gmQ;
    public TextView gmR;
    public ImageView gmS;
    public LinearLayout gmT;
    public TextView gmU;
    public TextView gmV;
    public LinearLayout gmW;
    public TextView gmX;
    public RelativeLayout gmY;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.bBi = baseActivity;
            this.rootView = view;
            this.gmQ = (HeadImageView) this.rootView.findViewById(e.g.pb_video_channel_photo);
            this.gmR = (TextView) this.rootView.findViewById(e.g.pb_video_channel_name);
            this.gmS = (ImageView) this.rootView.findViewById(e.g.pb_video_channel_icon);
            this.gmT = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_panel);
            this.gmU = (TextView) this.rootView.findViewById(e.g.pb_video_channel_publish_time);
            this.gmV = (TextView) this.rootView.findViewById(e.g.pb_video_channel_location_address);
            this.gmW = (LinearLayout) this.rootView.findViewById(e.g.pb_video_channel_sub_panel);
            this.gmX = (TextView) this.rootView.findViewById(e.g.pb_video_order_button);
            this.gmY = (RelativeLayout) this.rootView.findViewById(e.g.video_pb_header_channel_info_root);
            this.gmQ.setImageDrawable(null);
            this.gmQ.setRadius(l.h(baseActivity.getActivity(), e.C0210e.ds40));
            this.gmQ.setOnClickListener(this.bEc);
            this.gmS.setOnClickListener(this.bEc);
            this.gmX.setOnClickListener(this.bEc);
            this.gmR.setOnClickListener(this.bEc);
        }
    }

    public void ao(bb bbVar) {
        if (bbVar != null && bbVar.AJ() != null && this.rootView != null) {
            this.bUO = bbVar.AJ();
            this.gmU.setText(ao.M(bbVar.getCreateTime()));
            this.gmV.setText(bbVar.getAddress());
            this.gmR.setText(this.bUO.channelName);
            this.gmQ.startLoad(this.bUO.channelAvatar, 10, false);
            if (this.bUO.avZ == 1) {
                this.avZ = 0;
            } else {
                this.avZ = this.bUO.avZ;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.avZ = 2;
            }
            o(this.avZ, this.bUO.channelId);
            Ko();
        }
    }

    public void Ko() {
        this.bBi.getLayoutMode().onModeChanged(this.rootView);
        if (this.avZ == 1) {
            this.gmX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gmX, e.d.cp_cont_d);
            this.gmX.setText(e.j.has_ordered_channel);
            this.gmX.setVisibility(0);
        } else if (this.avZ == 2) {
            this.gmX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gmX, e.d.btn_forum_focus_color);
            this.gmX.setVisibility(0);
            this.gmX.setText(e.j.order_video_channel);
        } else {
            this.gmX.setVisibility(8);
        }
        al.h(this.gmR, e.d.cp_cont_f);
        al.h(this.gmU, e.d.cp_cont_f);
        al.h(this.gmV, e.d.cp_cont_f);
        al.i(this.gmS, e.f.icon_weiba);
    }

    public void o(int i, long j) {
        if (this.bUO != null && j > 0 && j == this.bUO.channelId) {
            if (i == 1) {
                this.gmX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(this.gmX, e.d.cp_cont_d);
                this.gmX.setClickable(false);
                this.gmX.setText(e.j.has_ordered_channel);
                return;
            }
            this.gmX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this.gmX, e.d.btn_forum_focus_color);
            this.gmX.setClickable(true);
            this.gmX.setText(e.j.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bnT() {
        return this.gmX;
    }
}
