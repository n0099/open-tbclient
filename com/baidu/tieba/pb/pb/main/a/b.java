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
    private View.OnClickListener jkS;
    private PbFragment lPo;
    private RelativeLayout mek;
    private HeadImageView mel;
    private TextView men;
    private TextView meo;
    private ImageView mep;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.jkS = null;
        this.lPo = pbFragment;
        this.jkS = onClickListener;
        initView();
    }

    public void initView() {
        if (this.mek == null) {
            this.mek = (RelativeLayout) LayoutInflater.from(this.lPo.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.mel = (HeadImageView) this.mek.findViewById(R.id.iv_pb_video_smart_app_head);
            this.mel.setIsRound(true);
            this.mel.setPlaceHolder(1);
            this.men = (TextView) this.mek.findViewById(R.id.tv_pb_video_smart_app_title);
            this.meo = (TextView) this.mek.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.mep = (ImageView) this.mek.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.mek.setOnClickListener(this.jkS);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dlp().bmx() && fVar.dlp().boG() != null) {
                SmartApp boG = fVar.dlp().boG();
                this.mek.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!au.isEmpty(boG.avatar)) {
                    this.mel.startLoad(boG.avatar, 10, false, false);
                }
                if (!au.isEmpty(boG.name)) {
                    charSequence = boG.name + " " + ((Object) this.lPo.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lPo.getText(R.string.intelligent_smart_app).toString();
                }
                this.men.setText(charSequence);
                if (!au.isEmpty(boG._abstract)) {
                    this.meo.setText(boG._abstract);
                } else {
                    this.meo.setText(this.lPo.getText(R.string.smart_app_default_abstract));
                }
                this.mek.setTag(boG);
                return;
            }
            this.mek.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.mek != null) {
            bdTypeListView.addHeaderView(this.mek, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.mek != null) {
            bdTypeListView.removeHeaderView(this.mek);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mek != null) {
            ap.setBackgroundColor(this.mek, R.color.CAM_X0204);
        }
        if (this.mel != null) {
            this.mel.setIsNight(i == 1);
        }
        if (this.men != null) {
            ap.setViewTextColor(this.men, R.color.CAM_X0105);
        }
        if (this.meo != null) {
            ap.setViewTextColor(this.meo, R.color.CAM_X0107);
        }
        if (this.mep != null) {
            ap.setBackgroundResource(this.mep, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
