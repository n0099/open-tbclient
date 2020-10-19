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
    private View.OnClickListener irI;
    private PbFragment kXi;
    private RelativeLayout llA;
    private HeadImageView llB;
    private TextView llC;
    private TextView llD;
    private ImageView llE;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.irI = null;
        this.kXi = pbFragment;
        this.irI = onClickListener;
        initView();
    }

    public void initView() {
        if (this.llA == null) {
            this.llA = (RelativeLayout) LayoutInflater.from(this.kXi.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.llB = (HeadImageView) this.llA.findViewById(R.id.iv_pb_video_smart_app_head);
            this.llB.setIsRound(true);
            this.llB.setPlaceHolder(1);
            this.llC = (TextView) this.llA.findViewById(R.id.tv_pb_video_smart_app_title);
            this.llD = (TextView) this.llA.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.llE = (ImageView) this.llA.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.llA.setOnClickListener(this.irI);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dcA().bgN() && fVar.dcA().biW() != null) {
                SmartApp biW = fVar.dcA().biW();
                this.llA.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(biW.avatar)) {
                    this.llB.startLoad(biW.avatar, 10, false, false);
                }
                if (!at.isEmpty(biW.name)) {
                    charSequence = biW.name + " " + ((Object) this.kXi.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.kXi.getText(R.string.intelligent_smart_app).toString();
                }
                this.llC.setText(charSequence);
                if (!at.isEmpty(biW._abstract)) {
                    this.llD.setText(biW._abstract);
                } else {
                    this.llD.setText(this.kXi.getText(R.string.smart_app_default_abstract));
                }
                this.llA.setTag(biW);
                return;
            }
            this.llA.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.llA != null) {
            bdTypeListView.addHeaderView(this.llA, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.llA != null) {
            bdTypeListView.removeHeaderView(this.llA);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.llA != null) {
            ap.setBackgroundColor(this.llA, R.color.cp_bg_line_c);
        }
        if (this.llB != null) {
            this.llB.setIsNight(i == 1);
        }
        if (this.llC != null) {
            ap.setViewTextColor(this.llC, R.color.cp_cont_b);
        }
        if (this.llD != null) {
            ap.setViewTextColor(this.llD, R.color.cp_cont_j);
        }
        if (this.llE != null) {
            ap.setBackgroundResource(this.llE, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
