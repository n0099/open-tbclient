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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e {
    public int bMG;
    public BaseActivity cWM;
    private View.OnClickListener cZG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.icd || view == e.this.ice || view == e.this.icf) {
                    if (e.this.dxr != null) {
                        e.this.cWM.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cWM.getActivity(), e.this.dxr.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").P(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.ick) {
                    if (l.kt()) {
                        if (e.this.dxr != null && e.this.dxr.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bd.cE(e.this.cWM.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0235a.a(e.this.dxr.channelId, e.this.cWM.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cWM.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    private bm dxr;
    public HeadImageView icd;
    public TextView ice;
    public ImageView icf;
    public LinearLayout icg;
    public TextView ich;
    public TextView ici;
    public LinearLayout icj;
    public TextView ick;
    public RelativeLayout icl;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cWM = baseActivity;
            this.rootView = view;
            this.icd = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.ice = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.icf = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.icg = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.ich = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.ici = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.icj = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.ick = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.icl = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.icd.setImageDrawable(null);
            this.icd.setRadius(l.g(baseActivity.getActivity(), R.dimen.ds40));
            this.icd.setOnClickListener(this.cZG);
            this.icf.setOnClickListener(this.cZG);
            this.ick.setOnClickListener(this.cZG);
            this.ice.setOnClickListener(this.cZG);
        }
    }

    public void ax(bg bgVar) {
        if (bgVar != null && bgVar.afH() != null && this.rootView != null) {
            this.dxr = bgVar.afH();
            this.ich.setText(aq.aD(bgVar.getCreateTime()));
            this.ici.setText(bgVar.getAddress());
            this.ice.setText(this.dxr.channelName);
            this.icd.startLoad(this.dxr.channelAvatar, 10, false);
            if (this.dxr.bMG == 1) {
                this.bMG = 0;
            } else {
                this.bMG = this.dxr.bMG;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bMG = 2;
            }
            w(this.bMG, this.dxr.channelId);
            aqe();
        }
    }

    public void aqe() {
        this.cWM.getLayoutMode().onModeChanged(this.rootView);
        if (this.bMG == 1) {
            this.ick.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ick, R.color.cp_cont_d);
            this.ick.setText(R.string.has_ordered_channel);
            this.ick.setVisibility(0);
        } else if (this.bMG == 2) {
            this.ick.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ick, R.color.btn_forum_focus_color);
            this.ick.setVisibility(0);
            this.ick.setText(R.string.order_video_channel);
        } else {
            this.ick.setVisibility(8);
        }
        am.j(this.ice, R.color.cp_cont_f);
        am.j(this.ich, R.color.cp_cont_f);
        am.j(this.ici, R.color.cp_cont_f);
        am.k(this.icf, R.drawable.icon_weiba);
    }

    public void w(int i, long j) {
        if (this.dxr != null && j > 0 && j == this.dxr.channelId) {
            if (i == 1) {
                this.ick.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.ick, R.color.cp_cont_d);
                this.ick.setClickable(false);
                this.ick.setText(R.string.has_ordered_channel);
                return;
            }
            this.ick.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ick, R.color.btn_forum_focus_color);
            this.ick.setClickable(true);
            this.ick.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bZH() {
        return this.ick;
    }
}
