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
    private PbFragment lIN;
    private ImageView lXA;
    private RelativeLayout lXw;
    private HeadImageView lXx;
    private TextView lXy;
    private TextView lXz;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.jhV = null;
        this.lIN = pbFragment;
        this.jhV = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lXw == null) {
            this.lXw = (RelativeLayout) LayoutInflater.from(this.lIN.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lXx = (HeadImageView) this.lXw.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lXx.setIsRound(true);
            this.lXx.setPlaceHolder(1);
            this.lXy = (TextView) this.lXw.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lXz = (TextView) this.lXw.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lXA = (ImageView) this.lXw.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lXw.setOnClickListener(this.jhV);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dmF().bpW() && fVar.dmF().bsg() != null) {
                SmartApp bsg = fVar.dmF().bsg();
                this.lXw.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bsg.avatar)) {
                    this.lXx.startLoad(bsg.avatar, 10, false, false);
                }
                if (!at.isEmpty(bsg.name)) {
                    charSequence = bsg.name + " " + ((Object) this.lIN.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lIN.getText(R.string.intelligent_smart_app).toString();
                }
                this.lXy.setText(charSequence);
                if (!at.isEmpty(bsg._abstract)) {
                    this.lXz.setText(bsg._abstract);
                } else {
                    this.lXz.setText(this.lIN.getText(R.string.smart_app_default_abstract));
                }
                this.lXw.setTag(bsg);
                return;
            }
            this.lXw.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lXw != null) {
            bdTypeListView.addHeaderView(this.lXw, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lXw != null) {
            bdTypeListView.removeHeaderView(this.lXw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lXw != null) {
            ao.setBackgroundColor(this.lXw, R.color.CAM_X0204);
        }
        if (this.lXx != null) {
            this.lXx.setIsNight(i == 1);
        }
        if (this.lXy != null) {
            ao.setViewTextColor(this.lXy, R.color.CAM_X0105);
        }
        if (this.lXz != null) {
            ao.setViewTextColor(this.lXz, R.color.CAM_X0107);
        }
        if (this.lXA != null) {
            ao.setBackgroundResource(this.lXA, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
