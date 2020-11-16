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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes21.dex */
public class b {
    private View.OnClickListener iKO;
    private RelativeLayout lEs;
    private HeadImageView lEt;
    private TextView lEu;
    private TextView lEv;
    private ImageView lEw;
    private PbFragment lpX;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.iKO = null;
        this.lpX = pbFragment;
        this.iKO = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lEs == null) {
            this.lEs = (RelativeLayout) LayoutInflater.from(this.lpX.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lEt = (HeadImageView) this.lEs.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lEt.setIsRound(true);
            this.lEt.setPlaceHolder(1);
            this.lEu = (TextView) this.lEs.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lEv = (TextView) this.lEs.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lEw = (ImageView) this.lEs.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lEs.setOnClickListener(this.iKO);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dhH().bki() && fVar.dhH().bmr() != null) {
                SmartApp bmr = fVar.dhH().bmr();
                this.lEs.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!au.isEmpty(bmr.avatar)) {
                    this.lEt.startLoad(bmr.avatar, 10, false, false);
                }
                if (!au.isEmpty(bmr.name)) {
                    charSequence = bmr.name + " " + ((Object) this.lpX.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lpX.getText(R.string.intelligent_smart_app).toString();
                }
                this.lEu.setText(charSequence);
                if (!au.isEmpty(bmr._abstract)) {
                    this.lEv.setText(bmr._abstract);
                } else {
                    this.lEv.setText(this.lpX.getText(R.string.smart_app_default_abstract));
                }
                this.lEs.setTag(bmr);
                return;
            }
            this.lEs.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lEs != null) {
            bdTypeListView.addHeaderView(this.lEs, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lEs != null) {
            bdTypeListView.removeHeaderView(this.lEs);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lEs != null) {
            ap.setBackgroundColor(this.lEs, R.color.CAM_X0204);
        }
        if (this.lEt != null) {
            this.lEt.setIsNight(i == 1);
        }
        if (this.lEu != null) {
            ap.setViewTextColor(this.lEu, R.color.CAM_X0105);
        }
        if (this.lEv != null) {
            ap.setViewTextColor(this.lEv, R.color.CAM_X0107);
        }
        if (this.lEw != null) {
            ap.setBackgroundResource(this.lEw, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
