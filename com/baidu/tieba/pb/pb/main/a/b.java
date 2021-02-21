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
    private View.OnClickListener jjj;
    private PbFragment lNm;
    private RelativeLayout mci;
    private HeadImageView mcj;
    private TextView mck;
    private TextView mcl;
    private ImageView mcm;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.jjj = null;
        this.lNm = pbFragment;
        this.jjj = onClickListener;
        initView();
    }

    public void initView() {
        if (this.mci == null) {
            this.mci = (RelativeLayout) LayoutInflater.from(this.lNm.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.mcj = (HeadImageView) this.mci.findViewById(R.id.iv_pb_video_smart_app_head);
            this.mcj.setIsRound(true);
            this.mcj.setPlaceHolder(1);
            this.mck = (TextView) this.mci.findViewById(R.id.tv_pb_video_smart_app_title);
            this.mcl = (TextView) this.mci.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.mcm = (ImageView) this.mci.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.mci.setOnClickListener(this.jjj);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dlg().bmv() && fVar.dlg().boE() != null) {
                SmartApp boE = fVar.dlg().boE();
                this.mci.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!au.isEmpty(boE.avatar)) {
                    this.mcj.startLoad(boE.avatar, 10, false, false);
                }
                if (!au.isEmpty(boE.name)) {
                    charSequence = boE.name + " " + ((Object) this.lNm.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lNm.getText(R.string.intelligent_smart_app).toString();
                }
                this.mck.setText(charSequence);
                if (!au.isEmpty(boE._abstract)) {
                    this.mcl.setText(boE._abstract);
                } else {
                    this.mcl.setText(this.lNm.getText(R.string.smart_app_default_abstract));
                }
                this.mci.setTag(boE);
                return;
            }
            this.mci.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.mci != null) {
            bdTypeListView.addHeaderView(this.mci, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.mci != null) {
            bdTypeListView.removeHeaderView(this.mci);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mci != null) {
            ap.setBackgroundColor(this.mci, R.color.CAM_X0204);
        }
        if (this.mcj != null) {
            this.mcj.setIsNight(i == 1);
        }
        if (this.mck != null) {
            ap.setViewTextColor(this.mck, R.color.CAM_X0105);
        }
        if (this.mcl != null) {
            ap.setViewTextColor(this.mcl, R.color.CAM_X0107);
        }
        if (this.mcm != null) {
            ap.setBackgroundResource(this.mcm, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
