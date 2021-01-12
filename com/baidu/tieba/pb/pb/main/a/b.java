package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes2.dex */
public class b {
    private View.OnClickListener jdo;
    private PbFragment lEi;
    private RelativeLayout lSS;
    private HeadImageView lST;
    private TextView lSU;
    private TextView lSV;
    private ImageView lSW;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.jdo = null;
        this.lEi = pbFragment;
        this.jdo = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lSS == null) {
            this.lSS = (RelativeLayout) LayoutInflater.from(this.lEi.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lST = (HeadImageView) this.lSS.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lST.setIsRound(true);
            this.lST.setPlaceHolder(1);
            this.lSU = (TextView) this.lSS.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lSV = (TextView) this.lSS.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lSW = (ImageView) this.lSS.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lSS.setOnClickListener(this.jdo);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.diN().bmc() && fVar.diN().bom() != null) {
                SmartApp bom = fVar.diN().bom();
                this.lSS.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bom.avatar)) {
                    this.lST.startLoad(bom.avatar, 10, false, false);
                }
                if (!at.isEmpty(bom.name)) {
                    charSequence = bom.name + " " + ((Object) this.lEi.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lEi.getText(R.string.intelligent_smart_app).toString();
                }
                this.lSU.setText(charSequence);
                if (!at.isEmpty(bom._abstract)) {
                    this.lSV.setText(bom._abstract);
                } else {
                    this.lSV.setText(this.lEi.getText(R.string.smart_app_default_abstract));
                }
                this.lSS.setTag(bom);
                return;
            }
            this.lSS.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lSS != null) {
            bdTypeListView.addHeaderView(this.lSS, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lSS != null) {
            bdTypeListView.removeHeaderView(this.lSS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSS != null) {
            ao.setBackgroundColor(this.lSS, R.color.CAM_X0204);
        }
        if (this.lST != null) {
            this.lST.setIsNight(i == 1);
        }
        if (this.lSU != null) {
            ao.setViewTextColor(this.lSU, R.color.CAM_X0105);
        }
        if (this.lSV != null) {
            ao.setViewTextColor(this.lSV, R.color.CAM_X0107);
        }
        if (this.lSW != null) {
            ao.setBackgroundResource(this.lSW, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
