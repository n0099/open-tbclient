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
    public BaseActivity cVo;
    private View.OnClickListener cYi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.hVM || view == e.this.hVN || view == e.this.hVO) {
                    if (e.this.dvi != null) {
                        e.this.cVo.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cVo.getActivity(), e.this.dvi.channelId, 2)));
                    }
                    TiebaStatic.log(new am("c11923").P(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.hVT) {
                    if (l.ki()) {
                        if (e.this.dvi != null && e.this.dvi.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cD(e.this.cVo.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0238a.a(e.this.dvi.channelId, e.this.cVo.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cVo.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    private bm dvi;
    public HeadImageView hVM;
    public TextView hVN;
    public ImageView hVO;
    public LinearLayout hVP;
    public TextView hVQ;
    public TextView hVR;
    public LinearLayout hVS;
    public TextView hVT;
    public RelativeLayout hVU;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cVo = baseActivity;
            this.rootView = view;
            this.hVM = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.hVN = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.hVO = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.hVP = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.hVQ = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.hVR = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.hVS = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.hVT = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.hVU = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.hVM.setImageDrawable(null);
            this.hVM.setRadius(l.g(baseActivity.getActivity(), R.dimen.ds40));
            this.hVM.setOnClickListener(this.cYi);
            this.hVO.setOnClickListener(this.cYi);
            this.hVT.setOnClickListener(this.cYi);
            this.hVN.setOnClickListener(this.cYi);
        }
    }

    public void ax(bg bgVar) {
        if (bgVar != null && bgVar.aeF() != null && this.rootView != null) {
            this.dvi = bgVar.aeF();
            this.hVQ.setText(ap.aC(bgVar.getCreateTime()));
            this.hVR.setText(bgVar.getAddress());
            this.hVN.setText(this.dvi.channelName);
            this.hVM.startLoad(this.dvi.channelAvatar, 10, false);
            if (this.dvi.bLF == 1) {
                this.bLF = 0;
            } else {
                this.bLF = this.dvi.bLF;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bLF = 2;
            }
            w(this.bLF, this.dvi.channelId);
            aoY();
        }
    }

    public void aoY() {
        this.cVo.getLayoutMode().onModeChanged(this.rootView);
        if (this.bLF == 1) {
            this.hVT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVT, R.color.cp_cont_d);
            this.hVT.setText(R.string.has_ordered_channel);
            this.hVT.setVisibility(0);
        } else if (this.bLF == 2) {
            this.hVT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVT, R.color.btn_forum_focus_color);
            this.hVT.setVisibility(0);
            this.hVT.setText(R.string.order_video_channel);
        } else {
            this.hVT.setVisibility(8);
        }
        al.j(this.hVN, R.color.cp_cont_f);
        al.j(this.hVQ, R.color.cp_cont_f);
        al.j(this.hVR, R.color.cp_cont_f);
        al.k(this.hVO, R.drawable.icon_weiba);
    }

    public void w(int i, long j) {
        if (this.dvi != null && j > 0 && j == this.dvi.channelId) {
            if (i == 1) {
                this.hVT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(this.hVT, R.color.cp_cont_d);
                this.hVT.setClickable(false);
                this.hVT.setText(R.string.has_ordered_channel);
                return;
            }
            this.hVT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this.hVT, R.color.btn_forum_focus_color);
            this.hVT.setClickable(true);
            this.hVT.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View bWO() {
        return this.hVT;
    }
}
