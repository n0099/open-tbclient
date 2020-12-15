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
/* loaded from: classes22.dex */
public class b {
    private View.OnClickListener iVJ;
    private PbFragment lDI;
    private RelativeLayout lSl;
    private HeadImageView lSm;
    private TextView lSn;
    private TextView lSo;
    private ImageView lSp;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.iVJ = null;
        this.lDI = pbFragment;
        this.iVJ = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lSl == null) {
            this.lSl = (RelativeLayout) LayoutInflater.from(this.lDI.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lSm = (HeadImageView) this.lSl.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lSm.setIsRound(true);
            this.lSm.setPlaceHolder(1);
            this.lSn = (TextView) this.lSl.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lSo = (TextView) this.lSl.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lSp = (ImageView) this.lSl.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lSl.setOnClickListener(this.iVJ);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dmU().bnv() && fVar.dmU().bpE() != null) {
                SmartApp bpE = fVar.dmU().bpE();
                this.lSl.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!au.isEmpty(bpE.avatar)) {
                    this.lSm.startLoad(bpE.avatar, 10, false, false);
                }
                if (!au.isEmpty(bpE.name)) {
                    charSequence = bpE.name + " " + ((Object) this.lDI.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lDI.getText(R.string.intelligent_smart_app).toString();
                }
                this.lSn.setText(charSequence);
                if (!au.isEmpty(bpE._abstract)) {
                    this.lSo.setText(bpE._abstract);
                } else {
                    this.lSo.setText(this.lDI.getText(R.string.smart_app_default_abstract));
                }
                this.lSl.setTag(bpE);
                return;
            }
            this.lSl.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lSl != null) {
            bdTypeListView.addHeaderView(this.lSl, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lSl != null) {
            bdTypeListView.removeHeaderView(this.lSl);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSl != null) {
            ap.setBackgroundColor(this.lSl, R.color.CAM_X0204);
        }
        if (this.lSm != null) {
            this.lSm.setIsNight(i == 1);
        }
        if (this.lSn != null) {
            ap.setViewTextColor(this.lSn, R.color.CAM_X0105);
        }
        if (this.lSo != null) {
            ap.setViewTextColor(this.lSo, R.color.CAM_X0107);
        }
        if (this.lSp != null) {
            ap.setBackgroundResource(this.lSp, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
