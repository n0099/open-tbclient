package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes22.dex */
public class b {
    private View.OnClickListener iKb;
    private RelativeLayout lEa;
    private HeadImageView lEb;
    private TextView lEc;
    private TextView lEd;
    private ImageView lEe;
    private PbFragment lpI;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.iKb = null;
        this.lpI = pbFragment;
        this.iKb = onClickListener;
        initView();
    }

    public void initView() {
        if (this.lEa == null) {
            this.lEa = (RelativeLayout) LayoutInflater.from(this.lpI.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.lEb = (HeadImageView) this.lEa.findViewById(R.id.iv_pb_video_smart_app_head);
            this.lEb.setIsRound(true);
            this.lEb.setPlaceHolder(1);
            this.lEc = (TextView) this.lEa.findViewById(R.id.tv_pb_video_smart_app_title);
            this.lEd = (TextView) this.lEa.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.lEe = (ImageView) this.lEa.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.lEa.setOnClickListener(this.iKb);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.dik().blg() && fVar.dik().bnp() != null) {
                SmartApp bnp = fVar.dik().bnp();
                this.lEa.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bnp.avatar)) {
                    this.lEb.startLoad(bnp.avatar, 10, false, false);
                }
                if (!at.isEmpty(bnp.name)) {
                    charSequence = bnp.name + " " + ((Object) this.lpI.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.lpI.getText(R.string.intelligent_smart_app).toString();
                }
                this.lEc.setText(charSequence);
                if (!at.isEmpty(bnp._abstract)) {
                    this.lEd.setText(bnp._abstract);
                } else {
                    this.lEd.setText(this.lpI.getText(R.string.smart_app_default_abstract));
                }
                this.lEa.setTag(bnp);
                return;
            }
            this.lEa.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.lEa != null) {
            bdTypeListView.addHeaderView(this.lEa, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.lEa != null) {
            bdTypeListView.removeHeaderView(this.lEa);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lEa != null) {
            ap.setBackgroundColor(this.lEa, R.color.cp_bg_line_c);
        }
        if (this.lEb != null) {
            this.lEb.setIsNight(i == 1);
        }
        if (this.lEc != null) {
            ap.setViewTextColor(this.lEc, R.color.cp_cont_b);
        }
        if (this.lEd != null) {
            ap.setViewTextColor(this.lEd, R.color.cp_cont_j);
        }
        if (this.lEe != null) {
            ap.setBackgroundResource(this.lEe, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
