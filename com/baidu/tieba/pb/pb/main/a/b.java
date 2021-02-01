package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes2.dex */
public class b {
    private View.OnClickListener jiV;
    private PbFragment lMX;
    private RelativeLayout mbT;
    private HeadImageView mbU;
    private TextView mbV;
    private TextView mbW;
    private ImageView mbX;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.jiV = null;
        this.lMX = pbFragment;
        this.jiV = onClickListener;
        initView();
    }

    public void initView() {
        if (this.mbT == null) {
            this.mbT = (RelativeLayout) LayoutInflater.from(this.lMX.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.mbU = (HeadImageView) this.mbT.findViewById(R.id.iv_pb_video_smart_app_head);
            this.mbU.setIsRound(true);
            this.mbU.setPlaceHolder(1);
            this.mbV = (TextView) this.mbT.findViewById(R.id.tv_pb_video_smart_app_title);
            this.mbW = (TextView) this.mbT.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.mbX = (ImageView) this.mbT.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.mbT.setOnClickListener(this.jiV);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dkZ().bmv() && fVar.dkZ().boE() != null) {
                SmartApp boE = fVar.dkZ().boE();
                this.mbT.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!au.isEmpty(boE.avatar)) {
                    this.mbU.startLoad(boE.avatar, 10, false, false);
                }
                if (!au.isEmpty(boE.name)) {
                    charSequence = boE.name + " " + ((Object) this.lMX.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lMX.getText(R.string.intelligent_smart_app).toString();
                }
                this.mbV.setText(charSequence);
                if (!au.isEmpty(boE._abstract)) {
                    this.mbW.setText(boE._abstract);
                } else {
                    this.mbW.setText(this.lMX.getText(R.string.smart_app_default_abstract));
                }
                this.mbT.setTag(boE);
                return;
            }
            this.mbT.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.mbT != null) {
            bdTypeListView.addHeaderView(this.mbT, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.mbT != null) {
            bdTypeListView.removeHeaderView(this.mbT);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mbT != null) {
            ap.setBackgroundColor(this.mbT, R.color.CAM_X0204);
        }
        if (this.mbU != null) {
            this.mbU.setIsNight(i == 1);
        }
        if (this.mbV != null) {
            ap.setViewTextColor(this.mbV, R.color.CAM_X0105);
        }
        if (this.mbW != null) {
            ap.setViewTextColor(this.mbW, R.color.CAM_X0107);
        }
        if (this.mbX != null) {
            ap.setBackgroundResource(this.mbX, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
