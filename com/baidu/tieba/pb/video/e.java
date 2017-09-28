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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private View.OnClickListener aTG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.eSH || view == e.this.eSI || view == e.this.eSJ) {
                    if (e.this.bhF != null) {
                        e.this.boM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(e.this.boM.getActivity(), e.this.bhF.channelId, 2)));
                    }
                    TiebaStatic.log(new ak("c11923").r("obj_id", 1));
                } else if (view == e.this.eSO) {
                    if (com.baidu.adp.lib.util.l.hy()) {
                        if (e.this.bhF != null && e.this.bhF.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                ax.aT(e.this.boM.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.C0045a.a(e.this.bhF.channelId, e.this.boM.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.boM.showToast(d.l.no_network_guide);
                }
            }
        }
    };
    public int aas;
    private bm bhF;
    public BaseActivity boM;
    public HeadImageView eSH;
    public TextView eSI;
    public ImageView eSJ;
    public LinearLayout eSK;
    public TextView eSL;
    public TextView eSM;
    public LinearLayout eSN;
    public TextView eSO;
    public RelativeLayout eSP;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.boM = baseActivity;
            this.rootView = view;
            this.eSH = (HeadImageView) this.rootView.findViewById(d.h.pb_video_channel_photo);
            this.eSI = (TextView) this.rootView.findViewById(d.h.pb_video_channel_name);
            this.eSJ = (ImageView) this.rootView.findViewById(d.h.pb_video_channel_icon);
            this.eSK = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_panel);
            this.eSL = (TextView) this.rootView.findViewById(d.h.pb_video_channel_publish_time);
            this.eSM = (TextView) this.rootView.findViewById(d.h.pb_video_channel_location_address);
            this.eSN = (LinearLayout) this.rootView.findViewById(d.h.pb_video_channel_sub_panel);
            this.eSO = (TextView) this.rootView.findViewById(d.h.pb_video_order_button);
            this.eSP = (RelativeLayout) this.rootView.findViewById(d.h.video_pb_header_channel_info_root);
            this.eSH.setImageDrawable(null);
            this.eSH.setRadius(com.baidu.adp.lib.util.l.f(baseActivity.getActivity(), d.f.ds40));
            this.eSH.setOnClickListener(this.aTG);
            this.eSJ.setOnClickListener(this.aTG);
            this.eSO.setOnClickListener(this.aTG);
            this.eSI.setOnClickListener(this.aTG);
        }
    }

    public void Y(bh bhVar) {
        if (bhVar != null && bhVar.sz() != null && this.rootView != null) {
            this.bhF = bhVar.sz();
            this.eSL.setText(am.q(bhVar.getCreateTime()));
            this.eSM.setText(bhVar.getAddress());
            this.eSI.setText(this.bhF.channelName);
            this.eSH.c(this.bhF.channelAvatar, 10, false);
            if (this.bhF.aas == 1) {
                this.aas = 0;
            } else {
                this.aas = this.bhF.aas;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.aas = 2;
            }
            k(this.aas, this.bhF.channelId);
            Ay();
        }
    }

    public void Ay() {
        this.boM.getLayoutMode().t(this.rootView);
        if (this.aas == 1) {
            this.eSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSO, d.e.cp_cont_d);
            this.eSO.setText(d.l.has_ordered_channel);
            this.eSO.setVisibility(0);
        } else if (this.aas == 2) {
            this.eSO.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSO, d.e.btn_forum_focus_color);
            this.eSO.setVisibility(0);
            this.eSO.setText(d.l.order_video_channel);
        } else {
            this.eSO.setVisibility(8);
        }
        aj.i(this.eSI, d.e.cp_cont_f);
        aj.i(this.eSL, d.e.cp_cont_f);
        aj.i(this.eSM, d.e.cp_cont_f);
        aj.j(this.eSJ, d.g.icon_weiba);
    }

    public void k(int i, long j) {
        if (this.bhF != null && j > 0 && j == this.bhF.channelId) {
            if (i == 1) {
                this.eSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(this.eSO, d.e.cp_cont_d);
                this.eSO.setClickable(false);
                this.eSO.setText(d.l.has_ordered_channel);
                return;
            }
            this.eSO.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this.eSO, d.e.btn_forum_focus_color);
            this.eSO.setClickable(true);
            this.eSO.setText(d.l.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View aUc() {
        return this.eSO;
    }
}
