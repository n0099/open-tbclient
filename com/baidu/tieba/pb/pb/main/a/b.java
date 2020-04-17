package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class b {
    private View.OnClickListener haA;
    private RelativeLayout jCC;
    private HeadImageView jCD;
    private TextView jCE;
    private TextView jCF;
    private ImageView jCG;
    private PbFragment jpS;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.haA = null;
        this.jpS = pbFragment;
        this.haA = onClickListener;
        initView();
    }

    public void initView() {
        if (this.jCC == null) {
            this.jCC = (RelativeLayout) LayoutInflater.from(this.jpS.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.jCD = (HeadImageView) this.jCC.findViewById(R.id.iv_pb_video_smart_app_head);
            this.jCD.setIsRound(true);
            this.jCD.setPlaceHolder(1);
            this.jCE = (TextView) this.jCC.findViewById(R.id.tv_pb_video_smart_app_title);
            this.jCF = (TextView) this.jCC.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.jCG = (ImageView) this.jCC.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.jCC.setOnClickListener(this.haA);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.cvu().aJr() && eVar.cvu().aLq() != null) {
                SmartApp aLq = eVar.cvu().aLq();
                this.jCC.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aLq.avatar)) {
                    this.jCD.startLoad(aLq.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aLq.name)) {
                    charSequence = aLq.name + " " + ((Object) this.jpS.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.jpS.getText(R.string.intelligent_smart_app).toString();
                }
                this.jCE.setText(charSequence);
                if (!aq.isEmpty(aLq._abstract)) {
                    this.jCF.setText(aLq._abstract);
                } else {
                    this.jCF.setText(this.jpS.getText(R.string.smart_app_default_abstract));
                }
                this.jCC.setTag(aLq);
                return;
            }
            this.jCC.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.jCC != null) {
            bdTypeListView.addHeaderView(this.jCC, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.jCC != null) {
            bdTypeListView.removeHeaderView(this.jCC);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCC != null) {
            am.setBackgroundColor(this.jCC, R.color.cp_bg_line_c);
        }
        if (this.jCD != null) {
            this.jCD.setIsNight(i == 1);
        }
        if (this.jCE != null) {
            am.setViewTextColor(this.jCE, (int) R.color.cp_cont_b);
        }
        if (this.jCF != null) {
            am.setViewTextColor(this.jCF, (int) R.color.cp_cont_j);
        }
        if (this.jCG != null) {
            am.setBackgroundResource(this.jCG, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
