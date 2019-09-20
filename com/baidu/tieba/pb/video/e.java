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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e {
    public int bNk;
    public BaseActivity cXM;
    private View.OnClickListener dbz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view == e.this.ifc || view == e.this.ifd || view == e.this.ife) {
                    if (e.this.dzj != null) {
                        e.this.cXM.sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(e.this.cXM.getActivity(), e.this.dzj.channelId, 2)));
                    }
                    TiebaStatic.log(new an("c11923").P(VideoPlayActivityConfig.OBJ_ID, 1));
                } else if (view == e.this.ifj) {
                    if (l.kt()) {
                        if (e.this.dzj != null && e.this.dzj.channelId > 0) {
                            if (!TbadkCoreApplication.isLogin()) {
                                bc.cE(e.this.cXM.getActivity());
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.C0249a.a(e.this.dzj.channelId, e.this.cXM.getUniqueId())));
                            return;
                        }
                        return;
                    }
                    e.this.cXM.showToast(R.string.no_network_guide);
                }
            }
        }
    };
    private bn dzj;
    public HeadImageView ifc;
    public TextView ifd;
    public ImageView ife;
    public LinearLayout iff;
    public TextView ifg;
    public TextView ifh;
    public LinearLayout ifi;
    public TextView ifj;
    public RelativeLayout ifk;
    public View rootView;

    public e(BaseActivity baseActivity, View view) {
        if (baseActivity != null && view != null) {
            this.cXM = baseActivity;
            this.rootView = view;
            this.ifc = (HeadImageView) this.rootView.findViewById(R.id.pb_video_channel_photo);
            this.ifd = (TextView) this.rootView.findViewById(R.id.pb_video_channel_name);
            this.ife = (ImageView) this.rootView.findViewById(R.id.pb_video_channel_icon);
            this.iff = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_panel);
            this.ifg = (TextView) this.rootView.findViewById(R.id.pb_video_channel_publish_time);
            this.ifh = (TextView) this.rootView.findViewById(R.id.pb_video_channel_location_address);
            this.ifi = (LinearLayout) this.rootView.findViewById(R.id.pb_video_channel_sub_panel);
            this.ifj = (TextView) this.rootView.findViewById(R.id.pb_video_order_button);
            this.ifk = (RelativeLayout) this.rootView.findViewById(R.id.video_pb_header_channel_info_root);
            this.ifc.setImageDrawable(null);
            this.ifc.setRadius(l.g(baseActivity.getActivity(), R.dimen.ds40));
            this.ifc.setOnClickListener(this.dbz);
            this.ife.setOnClickListener(this.dbz);
            this.ifj.setOnClickListener(this.dbz);
            this.ifd.setOnClickListener(this.dbz);
        }
    }

    public void az(bh bhVar) {
        if (bhVar != null && bhVar.afM() != null && this.rootView != null) {
            this.dzj = bhVar.afM();
            this.ifg.setText(aq.aD(bhVar.getCreateTime()));
            this.ifh.setText(bhVar.getAddress());
            this.ifd.setText(this.dzj.channelName);
            this.ifc.startLoad(this.dzj.channelAvatar, 10, false);
            if (this.dzj.bNk == 1) {
                this.bNk = 0;
            } else {
                this.bNk = this.dzj.bNk;
            }
            if (!TbadkCoreApplication.isLogin()) {
                this.bNk = 2;
            }
            w(this.bNk, this.dzj.channelId);
            aqs();
        }
    }

    public void aqs() {
        this.cXM.getLayoutMode().onModeChanged(this.rootView);
        if (this.bNk == 1) {
            this.ifj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ifj, R.color.cp_cont_d);
            this.ifj.setText(R.string.has_ordered_channel);
            this.ifj.setVisibility(0);
        } else if (this.bNk == 2) {
            this.ifj.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ifj, R.color.btn_forum_focus_color);
            this.ifj.setVisibility(0);
            this.ifj.setText(R.string.order_video_channel);
        } else {
            this.ifj.setVisibility(8);
        }
        am.j(this.ifd, R.color.cp_cont_f);
        am.j(this.ifg, R.color.cp_cont_f);
        am.j(this.ifh, R.color.cp_cont_f);
        am.k(this.ife, R.drawable.icon_weiba);
    }

    public void w(int i, long j) {
        if (this.dzj != null && j > 0 && j == this.dzj.channelId) {
            if (i == 1) {
                this.ifj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(this.ifj, R.color.cp_cont_d);
                this.ifj.setClickable(false);
                this.ifj.setText(R.string.has_ordered_channel);
                return;
            }
            this.ifj.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this.ifj, R.color.btn_forum_focus_color);
            this.ifj.setClickable(true);
            this.ifj.setText(R.string.order_video_channel);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public View caM() {
        return this.ifj;
    }
}
