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
/* loaded from: classes16.dex */
public class b {
    private View.OnClickListener hVH;
    private RelativeLayout kNN;
    private HeadImageView kNO;
    private TextView kNP;
    private TextView kNQ;
    private ImageView kNR;
    private PbFragment kzA;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.hVH = null;
        this.kzA = pbFragment;
        this.hVH = onClickListener;
        initView();
    }

    public void initView() {
        if (this.kNN == null) {
            this.kNN = (RelativeLayout) LayoutInflater.from(this.kzA.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.kNO = (HeadImageView) this.kNN.findViewById(R.id.iv_pb_video_smart_app_head);
            this.kNO.setIsRound(true);
            this.kNO.setPlaceHolder(1);
            this.kNP = (TextView) this.kNN.findViewById(R.id.tv_pb_video_smart_app_title);
            this.kNQ = (TextView) this.kNN.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.kNR = (ImageView) this.kNN.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.kNN.setOnClickListener(this.hVH);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.cVm().bdk() && fVar.cVm().bft() != null) {
                SmartApp bft = fVar.cVm().bft();
                this.kNN.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bft.avatar)) {
                    this.kNO.startLoad(bft.avatar, 10, false, false);
                }
                if (!at.isEmpty(bft.name)) {
                    charSequence = bft.name + " " + ((Object) this.kzA.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.kzA.getText(R.string.intelligent_smart_app).toString();
                }
                this.kNP.setText(charSequence);
                if (!at.isEmpty(bft._abstract)) {
                    this.kNQ.setText(bft._abstract);
                } else {
                    this.kNQ.setText(this.kzA.getText(R.string.smart_app_default_abstract));
                }
                this.kNN.setTag(bft);
                return;
            }
            this.kNN.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.kNN != null) {
            bdTypeListView.addHeaderView(this.kNN, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.kNN != null) {
            bdTypeListView.removeHeaderView(this.kNN);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kNN != null) {
            ap.setBackgroundColor(this.kNN, R.color.cp_bg_line_c);
        }
        if (this.kNO != null) {
            this.kNO.setIsNight(i == 1);
        }
        if (this.kNP != null) {
            ap.setViewTextColor(this.kNP, R.color.cp_cont_b);
        }
        if (this.kNQ != null) {
            ap.setViewTextColor(this.kNQ, R.color.cp_cont_j);
        }
        if (this.kNR != null) {
            ap.setBackgroundResource(this.kNR, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
