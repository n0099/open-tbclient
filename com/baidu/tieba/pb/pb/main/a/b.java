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
/* loaded from: classes16.dex */
public class b {
    private View.OnClickListener hVB;
    private RelativeLayout kNG;
    private HeadImageView kNH;
    private TextView kNI;
    private TextView kNJ;
    private ImageView kNK;
    private PbFragment kzt;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.hVB = null;
        this.kzt = pbFragment;
        this.hVB = onClickListener;
        initView();
    }

    public void initView() {
        if (this.kNG == null) {
            this.kNG = (RelativeLayout) LayoutInflater.from(this.kzt.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.kNH = (HeadImageView) this.kNG.findViewById(R.id.iv_pb_video_smart_app_head);
            this.kNH.setIsRound(true);
            this.kNH.setPlaceHolder(1);
            this.kNI = (TextView) this.kNG.findViewById(R.id.tv_pb_video_smart_app_title);
            this.kNJ = (TextView) this.kNG.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.kNK = (ImageView) this.kNG.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.kNG.setOnClickListener(this.hVB);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.cVl().bdk() && fVar.cVl().bft() != null) {
                SmartApp bft = fVar.cVl().bft();
                this.kNG.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!at.isEmpty(bft.avatar)) {
                    this.kNH.startLoad(bft.avatar, 10, false, false);
                }
                if (!at.isEmpty(bft.name)) {
                    charSequence = bft.name + " " + ((Object) this.kzt.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.kzt.getText(R.string.intelligent_smart_app).toString();
                }
                this.kNI.setText(charSequence);
                if (!at.isEmpty(bft._abstract)) {
                    this.kNJ.setText(bft._abstract);
                } else {
                    this.kNJ.setText(this.kzt.getText(R.string.smart_app_default_abstract));
                }
                this.kNG.setTag(bft);
                return;
            }
            this.kNG.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.kNG != null) {
            bdTypeListView.addHeaderView(this.kNG, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.kNG != null) {
            bdTypeListView.removeHeaderView(this.kNG);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kNG != null) {
            ap.setBackgroundColor(this.kNG, R.color.cp_bg_line_c);
        }
        if (this.kNH != null) {
            this.kNH.setIsNight(i == 1);
        }
        if (this.kNI != null) {
            ap.setViewTextColor(this.kNI, R.color.cp_cont_b);
        }
        if (this.kNJ != null) {
            ap.setViewTextColor(this.kNJ, R.color.cp_cont_j);
        }
        if (this.kNK != null) {
            ap.setBackgroundResource(this.kNK, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
