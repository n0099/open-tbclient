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
    private View.OnClickListener gqo;
    private PbFragment iDW;
    private RelativeLayout iQE;
    private HeadImageView iQF;
    private TextView iQG;
    private TextView iQH;
    private ImageView iQI;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.gqo = null;
        this.iDW = pbFragment;
        this.gqo = onClickListener;
        initView();
    }

    public void initView() {
        if (this.iQE == null) {
            this.iQE = (RelativeLayout) LayoutInflater.from(this.iDW.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.iQF = (HeadImageView) this.iQE.findViewById(R.id.iv_pb_video_smart_app_head);
            this.iQF.setIsRound(true);
            this.iQF.setPlaceHolder(1);
            this.iQG = (TextView) this.iQE.findViewById(R.id.tv_pb_video_smart_app_title);
            this.iQH = (TextView) this.iQE.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.iQI = (ImageView) this.iQE.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.iQE.setOnClickListener(this.gqo);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.cks().aAZ() && eVar.cks().aCY() != null) {
                SmartApp aCY = eVar.cks().aCY();
                this.iQE.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aCY.avatar)) {
                    this.iQF.startLoad(aCY.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aCY.name)) {
                    charSequence = aCY.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.iDW.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.iDW.getText(R.string.intelligent_smart_app).toString();
                }
                this.iQG.setText(charSequence);
                if (!aq.isEmpty(aCY._abstract)) {
                    this.iQH.setText(aCY._abstract);
                } else {
                    this.iQH.setText(this.iDW.getText(R.string.smart_app_default_abstract));
                }
                this.iQE.setTag(aCY);
                return;
            }
            this.iQE.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.iQE != null) {
            bdTypeListView.addHeaderView(this.iQE, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.iQE != null) {
            bdTypeListView.removeHeaderView(this.iQE);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQE != null) {
            am.setBackgroundColor(this.iQE, R.color.cp_bg_line_c);
        }
        if (this.iQF != null) {
            this.iQF.setIsNight(i == 1);
        }
        if (this.iQG != null) {
            am.setViewTextColor(this.iQG, (int) R.color.cp_cont_b);
        }
        if (this.iQH != null) {
            am.setViewTextColor(this.iQH, (int) R.color.cp_cont_j);
        }
        if (this.iQI != null) {
            am.setBackgroundResource(this.iQI, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
