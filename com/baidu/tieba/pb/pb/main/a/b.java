package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes16.dex */
public class b {
    private View.OnClickListener hIl;
    private PbFragment kkb;
    private RelativeLayout kyb;
    private HeadImageView kyc;
    private TextView kyd;
    private TextView kye;
    private ImageView kyf;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.hIl = null;
        this.kkb = pbFragment;
        this.hIl = onClickListener;
        initView();
    }

    public void initView() {
        if (this.kyb == null) {
            this.kyb = (RelativeLayout) LayoutInflater.from(this.kkb.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.kyc = (HeadImageView) this.kyb.findViewById(R.id.iv_pb_video_smart_app_head);
            this.kyc.setIsRound(true);
            this.kyc.setPlaceHolder(1);
            this.kyd = (TextView) this.kyb.findViewById(R.id.tv_pb_video_smart_app_title);
            this.kye = (TextView) this.kyb.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.kyf = (ImageView) this.kyb.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.kyb.setOnClickListener(this.hIl);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.cKx().aUR() && fVar.cKx().aXa() != null) {
                SmartApp aXa = fVar.cKx().aXa();
                this.kyb.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!as.isEmpty(aXa.avatar)) {
                    this.kyc.startLoad(aXa.avatar, 10, false, false);
                }
                if (!as.isEmpty(aXa.name)) {
                    charSequence = aXa.name + " " + ((Object) this.kkb.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.kkb.getText(R.string.intelligent_smart_app).toString();
                }
                this.kyd.setText(charSequence);
                if (!as.isEmpty(aXa._abstract)) {
                    this.kye.setText(aXa._abstract);
                } else {
                    this.kye.setText(this.kkb.getText(R.string.smart_app_default_abstract));
                }
                this.kyb.setTag(aXa);
                return;
            }
            this.kyb.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.kyb != null) {
            bdTypeListView.addHeaderView(this.kyb, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.kyb != null) {
            bdTypeListView.removeHeaderView(this.kyb);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kyb != null) {
            ao.setBackgroundColor(this.kyb, R.color.cp_bg_line_c);
        }
        if (this.kyc != null) {
            this.kyc.setIsNight(i == 1);
        }
        if (this.kyd != null) {
            ao.setViewTextColor(this.kyd, R.color.cp_cont_b);
        }
        if (this.kye != null) {
            ao.setViewTextColor(this.kye, R.color.cp_cont_j);
        }
        if (this.kyf != null) {
            ao.setBackgroundResource(this.kyf, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
