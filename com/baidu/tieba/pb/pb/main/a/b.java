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
    private View.OnClickListener jhV;
    private PbFragment lIO;
    private TextView lXA;
    private ImageView lXB;
    private RelativeLayout lXx;
    private HeadImageView lXy;
    private TextView lXz;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.jhV = null;
        this.lIO = pbFragment;
        this.jhV = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lXx == null) {
            this.lXx = (RelativeLayout) LayoutInflater.from(this.lIO.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lXy = (HeadImageView) this.lXx.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lXy.setIsRound(true);
            this.lXy.setPlaceHolder(1);
            this.lXz = (TextView) this.lXx.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lXA = (TextView) this.lXx.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lXB = (ImageView) this.lXx.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lXx.setOnClickListener(this.jhV);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dmE().bpV() && fVar.dmE().bsf() != null) {
                SmartApp bsf = fVar.dmE().bsf();
                this.lXx.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bsf.avatar)) {
                    this.lXy.startLoad(bsf.avatar, 10, false, false);
                }
                if (!at.isEmpty(bsf.name)) {
                    charSequence = bsf.name + " " + ((Object) this.lIO.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lIO.getText(R.string.intelligent_smart_app).toString();
                }
                this.lXz.setText(charSequence);
                if (!at.isEmpty(bsf._abstract)) {
                    this.lXA.setText(bsf._abstract);
                } else {
                    this.lXA.setText(this.lIO.getText(R.string.smart_app_default_abstract));
                }
                this.lXx.setTag(bsf);
                return;
            }
            this.lXx.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lXx != null) {
            bdTypeListView.addHeaderView(this.lXx, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lXx != null) {
            bdTypeListView.removeHeaderView(this.lXx);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lXx != null) {
            ao.setBackgroundColor(this.lXx, R.color.CAM_X0204);
        }
        if (this.lXy != null) {
            this.lXy.setIsNight(i == 1);
        }
        if (this.lXz != null) {
            ao.setViewTextColor(this.lXz, R.color.CAM_X0105);
        }
        if (this.lXA != null) {
            ao.setViewTextColor(this.lXA, R.color.CAM_X0107);
        }
        if (this.lXB != null) {
            ao.setBackgroundResource(this.lXB, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
