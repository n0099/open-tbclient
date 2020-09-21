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
/* loaded from: classes21.dex */
public class b {
    private View.OnClickListener icH;
    private PbFragment kHX;
    private RelativeLayout kWn;
    private HeadImageView kWo;
    private TextView kWp;
    private TextView kWq;
    private ImageView kWr;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.icH = null;
        this.kHX = pbFragment;
        this.icH = onClickListener;
        initView();
    }

    public void initView() {
        if (this.kWn == null) {
            this.kWn = (RelativeLayout) LayoutInflater.from(this.kHX.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.kWo = (HeadImageView) this.kWn.findViewById(R.id.iv_pb_video_smart_app_head);
            this.kWo.setIsRound(true);
            this.kWo.setPlaceHolder(1);
            this.kWp = (TextView) this.kWn.findViewById(R.id.tv_pb_video_smart_app_title);
            this.kWq = (TextView) this.kWn.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.kWr = (ImageView) this.kWn.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.kWn.setOnClickListener(this.icH);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.cYR().bee() && fVar.cYR().bgn() != null) {
                SmartApp bgn = fVar.cYR().bgn();
                this.kWn.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bgn.avatar)) {
                    this.kWo.startLoad(bgn.avatar, 10, false, false);
                }
                if (!at.isEmpty(bgn.name)) {
                    charSequence = bgn.name + " " + ((Object) this.kHX.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.kHX.getText(R.string.intelligent_smart_app).toString();
                }
                this.kWp.setText(charSequence);
                if (!at.isEmpty(bgn._abstract)) {
                    this.kWq.setText(bgn._abstract);
                } else {
                    this.kWq.setText(this.kHX.getText(R.string.smart_app_default_abstract));
                }
                this.kWn.setTag(bgn);
                return;
            }
            this.kWn.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.kWn != null) {
            bdTypeListView.addHeaderView(this.kWn, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.kWn != null) {
            bdTypeListView.removeHeaderView(this.kWn);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kWn != null) {
            ap.setBackgroundColor(this.kWn, R.color.cp_bg_line_c);
        }
        if (this.kWo != null) {
            this.kWo.setIsNight(i == 1);
        }
        if (this.kWp != null) {
            ap.setViewTextColor(this.kWp, R.color.cp_cont_b);
        }
        if (this.kWq != null) {
            ap.setViewTextColor(this.kWq, R.color.cp_cont_j);
        }
        if (this.kWr != null) {
            ap.setBackgroundResource(this.kWr, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
