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
    public int bLG;
    public BaseActivity cVq;
    private View.OnClickListener cYk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.hVQ || view == e.this.hVR || view == e.this.hVS) {
                    if (e.this.dvj != null) {
                        e.this.cVq.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cVq.getActivity(), e.this.dvj.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").P(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.hVX) {
                    if (l.ki()) {
                        if (e.this.dvj != null && e.this.dvj.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cD(e.this.cVq.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0238a.a(e.this.dvj.channelId, e.this.cVq.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cVq.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    private bm dvj;
    public HeadImageView hVQ;
    public TextView hVR;
    public ImageView hVS;
    public LinearLayout hVT;
    public TextView hVU;
    public TextView hVV;
    public LinearLayout hVW;
    public TextView hVX;
    public RelativeLayout hVY;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cVq = baseActivity;
            this.rootView = view;
            this.hVQ = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.hVR = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.hVS = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.hVT = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.hVU = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.hVV = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.hVW = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.hVX = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.hVY = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.hVQ.setImageDrawable(null);
            this.hVQ.setRadius(l.g(baseActivity.getActivity(), R.dimen.ds40));
            this.hVQ.setOnClickListener(this.cYk);
            this.hVS.setOnClickListener(this.cYk);
            this.hVX.setOnClickListener(this.cYk);
            this.hVR.setOnClickListener(this.cYk);
        }
    }

    public void ax(bg bgVar) {
        if (bgVar != null && bgVar.aeF() != null && this.rootView != null) {
            this.dvj = bgVar.aeF();
            this.hVU.setText(ap.aC(bgVar.getCreateTime()));
            this.hVV.setText(bgVar.getAddress());
            this.hVR.setText(this.dvj.channelName);
            this.hVQ.startLoad(this.dvj.channelAvatar, 10, false);
            if (this.dvj.bLG == 1) {
                this.bLG = 0;
            } else {
                this.bLG = this.dvj.bLG;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bLG = 2;
            }
            w(this.bLG, this.dvj.channelId);
            aoY();
        }
    }

    public void aoY() {
        this.cVq.getLayoutMode().onModeChanged(this.rootView);
        if (this.bLG == 1) {
            this.hVX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVX, R.color.cp_cont_d);
            this.hVX.setText(R.string.has_ordered_channel);
            this.hVX.setVisibility(0);
        } else if (this.bLG == 2) {
            this.hVX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVX, R.color.btn_forum_focus_color);
            this.hVX.setVisibility(0);
            this.hVX.setText(R.string.order_video_channel);
        } else {
            this.hVX.setVisibility(8);
        }
        al.j(this.hVR, R.color.cp_cont_f);
        al.j(this.hVU, R.color.cp_cont_f);
        al.j(this.hVV, R.color.cp_cont_f);
        al.k(this.hVS, R.drawable.icon_weiba);
    }

    public void w(int i, long j) {
        if (this.dvj != null && j > 0 && j == this.dvj.channelId) {
            if (i == 1) {
                this.hVX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hVX, R.color.cp_cont_d);
                this.hVX.setClickable(false);
                this.hVX.setText(R.string.has_ordered_channel);
                return;
            }
            this.hVX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVX, R.color.btn_forum_focus_color);
            this.hVX.setClickable(true);
            this.hVX.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bWS() {
        return this.hVX;
    }
}
