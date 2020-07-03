package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class b {
    private View.OnClickListener hCn;
    private PbFragment kbv;
    private RelativeLayout kpb;
    private HeadImageView kpc;
    private TextView kpd;
    private TextView kpe;
    private ImageView kpf;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.hCn = null;
        this.kbv = pbFragment;
        this.hCn = onClickListener;
        initView();
    }

    public void initView() {
        if (this.kpb == null) {
            this.kpb = (RelativeLayout) LayoutInflater.from(this.kbv.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.kpc = (HeadImageView) this.kpb.findViewById(R.id.iv_pb_video_smart_app_head);
            this.kpc.setIsRound(true);
            this.kpc.setPlaceHolder(1);
            this.kpd = (TextView) this.kpb.findViewById(R.id.tv_pb_video_smart_app_title);
            this.kpe = (TextView) this.kpb.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.kpf = (ImageView) this.kpb.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.kpb.setOnClickListener(this.hCn);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.cGN().aQV() && eVar.cGN().aTe() != null) {
                SmartApp aTe = eVar.cGN().aTe();
                this.kpb.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!ar.isEmpty(aTe.avatar)) {
                    this.kpc.startLoad(aTe.avatar, 10, false, false);
                }
                if (!ar.isEmpty(aTe.name)) {
                    charSequence = aTe.name + " " + ((Object) this.kbv.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.kbv.getText(R.string.intelligent_smart_app).toString();
                }
                this.kpd.setText(charSequence);
                if (!ar.isEmpty(aTe._abstract)) {
                    this.kpe.setText(aTe._abstract);
                } else {
                    this.kpe.setText(this.kbv.getText(R.string.smart_app_default_abstract));
                }
                this.kpb.setTag(aTe);
                return;
            }
            this.kpb.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.kpb != null) {
            bdTypeListView.addHeaderView(this.kpb, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.kpb != null) {
            bdTypeListView.removeHeaderView(this.kpb);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kpb != null) {
            an.setBackgroundColor(this.kpb, R.color.cp_bg_line_c);
        }
        if (this.kpc != null) {
            this.kpc.setIsNight(i == 1);
        }
        if (this.kpd != null) {
            an.setViewTextColor(this.kpd, (int) R.color.cp_cont_b);
        }
        if (this.kpe != null) {
            an.setViewTextColor(this.kpe, (int) R.color.cp_cont_j);
        }
        if (this.kpf != null) {
            an.setBackgroundResource(this.kpf, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
