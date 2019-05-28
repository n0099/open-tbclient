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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e {
    public int bLF;
    public BaseActivity cVp;
    private View.OnClickListener cYj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.hVP || view == e.this.hVQ || view == e.this.hVR) {
                    if (e.this.dvj != null) {
                        e.this.cVp.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cVp.getActivity(), e.this.dvj.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").P(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.hVW) {
                    if (l.ki()) {
                        if (e.this.dvj != null && e.this.dvj.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cD(e.this.cVp.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0238a.a(e.this.dvj.channelId, e.this.cVp.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cVp.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    private bm dvj;
    public HeadImageView hVP;
    public TextView hVQ;
    public ImageView hVR;
    public LinearLayout hVS;
    public TextView hVT;
    public TextView hVU;
    public LinearLayout hVV;
    public TextView hVW;
    public RelativeLayout hVX;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cVp = baseActivity;
            this.rootView = view;
            this.hVP = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.hVQ = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.hVR = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.hVS = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.hVT = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.hVU = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.hVV = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.hVW = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.hVX = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.hVP.setImageDrawable(null);
            this.hVP.setRadius(l.g(baseActivity.getActivity(), R.dimen.ds40));
            this.hVP.setOnClickListener(this.cYj);
            this.hVR.setOnClickListener(this.cYj);
            this.hVW.setOnClickListener(this.cYj);
            this.hVQ.setOnClickListener(this.cYj);
        }
    }

    public void ax(bg bgVar) {
        if (bgVar != null && bgVar.aeF() != null && this.rootView != null) {
            this.dvj = bgVar.aeF();
            this.hVT.setText(ap.aC(bgVar.getCreateTime()));
            this.hVU.setText(bgVar.getAddress());
            this.hVQ.setText(this.dvj.channelName);
            this.hVP.startLoad(this.dvj.channelAvatar, 10, false);
            if (this.dvj.bLF == 1) {
                this.bLF = 0;
            } else {
                this.bLF = this.dvj.bLF;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bLF = 2;
            }
            w(this.bLF, this.dvj.channelId);
            aoY();
        }
    }

    public void aoY() {
        this.cVp.getLayoutMode().onModeChanged(this.rootView);
        if (this.bLF == 1) {
            this.hVW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVW, R.color.cp_cont_d);
            this.hVW.setText(R.string.has_ordered_channel);
            this.hVW.setVisibility(0);
        } else if (this.bLF == 2) {
            this.hVW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVW, R.color.btn_forum_focus_color);
            this.hVW.setVisibility(0);
            this.hVW.setText(R.string.order_video_channel);
        } else {
            this.hVW.setVisibility(8);
        }
        al.j(this.hVQ, R.color.cp_cont_f);
        al.j(this.hVT, R.color.cp_cont_f);
        al.j(this.hVU, R.color.cp_cont_f);
        al.k(this.hVR, R.drawable.icon_weiba);
    }

    public void w(int i, long j) {
        if (this.dvj != null && j > 0 && j == this.dvj.channelId) {
            if (i == 1) {
                this.hVW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hVW, R.color.cp_cont_d);
                this.hVW.setClickable(false);
                this.hVW.setText(R.string.has_ordered_channel);
                return;
            }
            this.hVW.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVW, R.color.btn_forum_focus_color);
            this.hVW.setClickable(true);
            this.hVW.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bWR() {
        return this.hVW;
    }
}
