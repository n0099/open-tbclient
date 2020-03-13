package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class b {
    private View.OnClickListener gqD;
    private PbFragment iEk;
    private RelativeLayout iQS;
    private HeadImageView iQT;
    private TextView iQU;
    private TextView iQV;
    private ImageView iQW;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.gqD = null;
        this.iEk = pbFragment;
        this.gqD = onClickListener;
        initView();
    }

    public void initView() {
        if (this.iQS == null) {
            this.iQS = (RelativeLayout) LayoutInflater.from(this.iEk.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.iQT = (HeadImageView) this.iQS.findViewById(R.id.iv_pb_video_smart_app_head);
            this.iQT.setIsRound(true);
            this.iQT.setPlaceHolder(1);
            this.iQU = (TextView) this.iQS.findViewById(R.id.tv_pb_video_smart_app_title);
            this.iQV = (TextView) this.iQS.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.iQW = (ImageView) this.iQS.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.iQS.setOnClickListener(this.gqD);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.ckv().aBb() && eVar.ckv().aDa() != null) {
                SmartApp aDa = eVar.ckv().aDa();
                this.iQS.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aDa.avatar)) {
                    this.iQT.startLoad(aDa.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aDa.name)) {
                    charSequence = aDa.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.iEk.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.iEk.getText(R.string.intelligent_smart_app).toString();
                }
                this.iQU.setText(charSequence);
                if (!aq.isEmpty(aDa._abstract)) {
                    this.iQV.setText(aDa._abstract);
                } else {
                    this.iQV.setText(this.iEk.getText(R.string.smart_app_default_abstract));
                }
                this.iQS.setTag(aDa);
                return;
            }
            this.iQS.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.iQS != null) {
            bdTypeListView.addHeaderView(this.iQS, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.iQS != null) {
            bdTypeListView.removeHeaderView(this.iQS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQS != null) {
            am.setBackgroundColor(this.iQS, R.color.cp_bg_line_c);
        }
        if (this.iQT != null) {
            this.iQT.setIsNight(i == 1);
        }
        if (this.iQU != null) {
            am.setViewTextColor(this.iQU, (int) R.color.cp_cont_b);
        }
        if (this.iQV != null) {
            am.setViewTextColor(this.iQV, (int) R.color.cp_cont_j);
        }
        if (this.iQW != null) {
            am.setBackgroundResource(this.iQW, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
