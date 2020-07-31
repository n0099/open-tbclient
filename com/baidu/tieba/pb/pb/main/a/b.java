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
    private PbFragment kjZ;
    private RelativeLayout kxZ;
    private HeadImageView kya;
    private TextView kyb;
    private TextView kyc;
    private ImageView kyd;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.hIl = null;
        this.kjZ = pbFragment;
        this.hIl = onClickListener;
        initView();
    }

    public void initView() {
        if (this.kxZ == null) {
            this.kxZ = (RelativeLayout) LayoutInflater.from(this.kjZ.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.kya = (HeadImageView) this.kxZ.findViewById(R.id.iv_pb_video_smart_app_head);
            this.kya.setIsRound(true);
            this.kya.setPlaceHolder(1);
            this.kyb = (TextView) this.kxZ.findViewById(R.id.tv_pb_video_smart_app_title);
            this.kyc = (TextView) this.kxZ.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.kyd = (ImageView) this.kxZ.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.kxZ.setOnClickListener(this.hIl);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.cKx().aUR() && fVar.cKx().aXa() != null) {
                SmartApp aXa = fVar.cKx().aXa();
                this.kxZ.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!as.isEmpty(aXa.avatar)) {
                    this.kya.startLoad(aXa.avatar, 10, false, false);
                }
                if (!as.isEmpty(aXa.name)) {
                    charSequence = aXa.name + " " + ((Object) this.kjZ.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.kjZ.getText(R.string.intelligent_smart_app).toString();
                }
                this.kyb.setText(charSequence);
                if (!as.isEmpty(aXa._abstract)) {
                    this.kyc.setText(aXa._abstract);
                } else {
                    this.kyc.setText(this.kjZ.getText(R.string.smart_app_default_abstract));
                }
                this.kxZ.setTag(aXa);
                return;
            }
            this.kxZ.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.kxZ != null) {
            bdTypeListView.addHeaderView(this.kxZ, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.kxZ != null) {
            bdTypeListView.removeHeaderView(this.kxZ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kxZ != null) {
            ao.setBackgroundColor(this.kxZ, R.color.cp_bg_line_c);
        }
        if (this.kya != null) {
            this.kya.setIsNight(i == 1);
        }
        if (this.kyb != null) {
            ao.setViewTextColor(this.kyb, R.color.cp_cont_b);
        }
        if (this.kyc != null) {
            ao.setViewTextColor(this.kyc, R.color.cp_cont_j);
        }
        if (this.kyd != null) {
            ao.setBackgroundResource(this.kyd, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
