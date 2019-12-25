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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class b {
    private View.OnClickListener gle;
    private RelativeLayout iLF;
    private HeadImageView iLG;
    private TextView iLH;
    private TextView iLI;
    private ImageView iLJ;
    private PbFragment iyA;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.gle = null;
        this.iyA = pbFragment;
        this.gle = onClickListener;
        initView();
    }

    public void initView() {
        if (this.iLF == null) {
            this.iLF = (RelativeLayout) LayoutInflater.from(this.iyA.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.iLG = (HeadImageView) this.iLF.findViewById(R.id.iv_pb_video_smart_app_head);
            this.iLG.setIsRound(true);
            this.iLG.setPlaceHolder(1);
            this.iLH = (TextView) this.iLF.findViewById(R.id.tv_pb_video_smart_app_title);
            this.iLI = (TextView) this.iLF.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.iLJ = (ImageView) this.iLF.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.iLF.setOnClickListener(this.gle);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.chK().aAE() && fVar.chK().aAq() != null) {
                SmartApp aAq = fVar.chK().aAq();
                this.iLF.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aAq.avatar)) {
                    this.iLG.startLoad(aAq.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aAq.name)) {
                    charSequence = aAq.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.iyA.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.iyA.getText(R.string.intelligent_smart_app).toString();
                }
                this.iLH.setText(charSequence);
                if (!aq.isEmpty(aAq._abstract)) {
                    this.iLI.setText(aAq._abstract);
                } else {
                    this.iLI.setText(this.iyA.getText(R.string.smart_app_default_abstract));
                }
                this.iLF.setTag(aAq);
                return;
            }
            this.iLF.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.iLF != null) {
            bdTypeListView.addHeaderView(this.iLF, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.iLF != null) {
            bdTypeListView.removeHeaderView(this.iLF);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLF != null) {
            am.setBackgroundColor(this.iLF, R.color.cp_bg_line_c);
        }
        if (this.iLG != null) {
            this.iLG.setIsNight(i == 1);
        }
        if (this.iLH != null) {
            am.setViewTextColor(this.iLH, (int) R.color.cp_cont_b);
        }
        if (this.iLI != null) {
            am.setViewTextColor(this.iLI, (int) R.color.cp_cont_j);
        }
        if (this.iLJ != null) {
            am.setBackgroundResource(this.iLJ, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
