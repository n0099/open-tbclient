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
    private View.OnClickListener gqq;
    private PbFragment iDY;
    private RelativeLayout iQG;
    private HeadImageView iQH;
    private TextView iQI;
    private TextView iQJ;
    private ImageView iQK;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.gqq = null;
        this.iDY = pbFragment;
        this.gqq = onClickListener;
        initView();
    }

    public void initView() {
        if (this.iQG == null) {
            this.iQG = (RelativeLayout) LayoutInflater.from(this.iDY.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.iQH = (HeadImageView) this.iQG.findViewById(R.id.iv_pb_video_smart_app_head);
            this.iQH.setIsRound(true);
            this.iQH.setPlaceHolder(1);
            this.iQI = (TextView) this.iQG.findViewById(R.id.tv_pb_video_smart_app_title);
            this.iQJ = (TextView) this.iQG.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.iQK = (ImageView) this.iQG.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.iQG.setOnClickListener(this.gqq);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.cku().aBb() && eVar.cku().aDa() != null) {
                SmartApp aDa = eVar.cku().aDa();
                this.iQG.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aDa.avatar)) {
                    this.iQH.startLoad(aDa.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aDa.name)) {
                    charSequence = aDa.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.iDY.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.iDY.getText(R.string.intelligent_smart_app).toString();
                }
                this.iQI.setText(charSequence);
                if (!aq.isEmpty(aDa._abstract)) {
                    this.iQJ.setText(aDa._abstract);
                } else {
                    this.iQJ.setText(this.iDY.getText(R.string.smart_app_default_abstract));
                }
                this.iQG.setTag(aDa);
                return;
            }
            this.iQG.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.iQG != null) {
            bdTypeListView.addHeaderView(this.iQG, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.iQG != null) {
            bdTypeListView.removeHeaderView(this.iQG);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQG != null) {
            am.setBackgroundColor(this.iQG, R.color.cp_bg_line_c);
        }
        if (this.iQH != null) {
            this.iQH.setIsNight(i == 1);
        }
        if (this.iQI != null) {
            am.setViewTextColor(this.iQI, (int) R.color.cp_cont_b);
        }
        if (this.iQJ != null) {
            am.setViewTextColor(this.iQJ, (int) R.color.cp_cont_j);
        }
        if (this.iQK != null) {
            am.setBackgroundResource(this.iQK, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
