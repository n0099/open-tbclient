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
    private View.OnClickListener iVH;
    private PbFragment lDG;
    private RelativeLayout lSj;
    private HeadImageView lSk;
    private TextView lSl;
    private TextView lSm;
    private ImageView lSn;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.iVH = null;
        this.lDG = pbFragment;
        this.iVH = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lSj == null) {
            this.lSj = (RelativeLayout) LayoutInflater.from(this.lDG.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lSk = (HeadImageView) this.lSj.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lSk.setIsRound(true);
            this.lSk.setPlaceHolder(1);
            this.lSl = (TextView) this.lSj.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lSm = (TextView) this.lSj.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lSn = (ImageView) this.lSj.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lSj.setOnClickListener(this.iVH);
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dmT().bnv() && fVar.dmT().bpE() != null) {
                SmartApp bpE = fVar.dmT().bpE();
                this.lSj.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!au.isEmpty(bpE.avatar)) {
                    this.lSk.startLoad(bpE.avatar, 10, false, false);
                }
                if (!au.isEmpty(bpE.name)) {
                    charSequence = bpE.name + " " + ((Object) this.lDG.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lDG.getText(R.string.intelligent_smart_app).toString();
                }
                this.lSl.setText(charSequence);
                if (!au.isEmpty(bpE._abstract)) {
                    this.lSm.setText(bpE._abstract);
                } else {
                    this.lSm.setText(this.lDG.getText(R.string.smart_app_default_abstract));
                }
                this.lSj.setTag(bpE);
                return;
            }
            this.lSj.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lSj != null) {
            bdTypeListView.addHeaderView(this.lSj, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lSj != null) {
            bdTypeListView.removeHeaderView(this.lSj);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSj != null) {
            ap.setBackgroundColor(this.lSj, R.color.CAM_X0204);
        }
        if (this.lSk != null) {
            this.lSk.setIsNight(i == 1);
        }
        if (this.lSl != null) {
            ap.setViewTextColor(this.lSl, R.color.CAM_X0105);
        }
        if (this.lSm != null) {
            ap.setViewTextColor(this.lSm, R.color.CAM_X0107);
        }
        if (this.lSn != null) {
            ap.setBackgroundResource(this.lSn, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
