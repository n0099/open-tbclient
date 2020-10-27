package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes22.dex */
public class b {
    private View.OnClickListener iEe;
    private PbFragment ljH;
    private RelativeLayout lyd;
    private HeadImageView lye;
    private TextView lyf;
    private TextView lyg;
    private ImageView lyh;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.iEe = null;
        this.ljH = pbFragment;
        this.iEe = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lyd == null) {
            this.lyd = (RelativeLayout) LayoutInflater.from(this.ljH.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lye = (HeadImageView) this.lyd.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lye.setIsRound(true);
            this.lye.setPlaceHolder(1);
            this.lyf = (TextView) this.lyd.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lyg = (TextView) this.lyd.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lyh = (ImageView) this.lyd.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lyd.setOnClickListener(this.iEe);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dfI().biG() && fVar.dfI().bkP() != null) {
                SmartApp bkP = fVar.dfI().bkP();
                this.lyd.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bkP.avatar)) {
                    this.lye.startLoad(bkP.avatar, 10, false, false);
                }
                if (!at.isEmpty(bkP.name)) {
                    charSequence = bkP.name + " " + ((Object) this.ljH.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.ljH.getText(R.string.intelligent_smart_app).toString();
                }
                this.lyf.setText(charSequence);
                if (!at.isEmpty(bkP._abstract)) {
                    this.lyg.setText(bkP._abstract);
                } else {
                    this.lyg.setText(this.ljH.getText(R.string.smart_app_default_abstract));
                }
                this.lyd.setTag(bkP);
                return;
            }
            this.lyd.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lyd != null) {
            bdTypeListView.addHeaderView(this.lyd, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lyd != null) {
            bdTypeListView.removeHeaderView(this.lyd);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lyd != null) {
            ap.setBackgroundColor(this.lyd, R.color.cp_bg_line_c);
        }
        if (this.lye != null) {
            this.lye.setIsNight(i == 1);
        }
        if (this.lyf != null) {
            ap.setViewTextColor(this.lyf, R.color.cp_cont_b);
        }
        if (this.lyg != null) {
            ap.setViewTextColor(this.lyg, R.color.cp_cont_j);
        }
        if (this.lyh != null) {
            ap.setBackgroundResource(this.lyh, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
