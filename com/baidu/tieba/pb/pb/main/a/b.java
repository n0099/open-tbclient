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
    private View.OnClickListener haG;
    private RelativeLayout jCG;
    private HeadImageView jCH;
    private TextView jCI;
    private TextView jCJ;
    private ImageView jCK;
    private PbFragment jpW;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.haG = null;
        this.jpW = pbFragment;
        this.haG = onClickListener;
        initView();
    }

    public void initView() {
        if (this.jCG == null) {
            this.jCG = (RelativeLayout) LayoutInflater.from(this.jpW.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.jCH = (HeadImageView) this.jCG.findViewById(R.id.iv_pb_video_smart_app_head);
            this.jCH.setIsRound(true);
            this.jCH.setPlaceHolder(1);
            this.jCI = (TextView) this.jCG.findViewById(R.id.tv_pb_video_smart_app_title);
            this.jCJ = (TextView) this.jCG.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.jCK = (ImageView) this.jCG.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.jCG.setOnClickListener(this.haG);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.cvr().aJp() && eVar.cvr().aLo() != null) {
                SmartApp aLo = eVar.cvr().aLo();
                this.jCG.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aLo.avatar)) {
                    this.jCH.startLoad(aLo.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aLo.name)) {
                    charSequence = aLo.name + " " + ((Object) this.jpW.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.jpW.getText(R.string.intelligent_smart_app).toString();
                }
                this.jCI.setText(charSequence);
                if (!aq.isEmpty(aLo._abstract)) {
                    this.jCJ.setText(aLo._abstract);
                } else {
                    this.jCJ.setText(this.jpW.getText(R.string.smart_app_default_abstract));
                }
                this.jCG.setTag(aLo);
                return;
            }
            this.jCG.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.jCG != null) {
            bdTypeListView.addHeaderView(this.jCG, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.jCG != null) {
            bdTypeListView.removeHeaderView(this.jCG);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCG != null) {
            am.setBackgroundColor(this.jCG, R.color.cp_bg_line_c);
        }
        if (this.jCH != null) {
            this.jCH.setIsNight(i == 1);
        }
        if (this.jCI != null) {
            am.setViewTextColor(this.jCI, (int) R.color.cp_cont_b);
        }
        if (this.jCJ != null) {
            am.setViewTextColor(this.jCJ, (int) R.color.cp_cont_j);
        }
        if (this.jCK != null) {
            am.setBackgroundResource(this.jCK, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
