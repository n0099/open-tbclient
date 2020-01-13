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
/* loaded from: classes7.dex */
public class b {
    private View.OnClickListener gon;
    private PbFragment iCe;
    private RelativeLayout iPj;
    private HeadImageView iPk;
    private TextView iPl;
    private TextView iPm;
    private ImageView iPn;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.gon = null;
        this.iCe = pbFragment;
        this.gon = onClickListener;
        initView();
    }

    public void initView() {
        if (this.iPj == null) {
            this.iPj = (RelativeLayout) LayoutInflater.from(this.iCe.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.iPk = (HeadImageView) this.iPj.findViewById(R.id.iv_pb_video_smart_app_head);
            this.iPk.setIsRound(true);
            this.iPk.setPlaceHolder(1);
            this.iPl = (TextView) this.iPj.findViewById(R.id.tv_pb_video_smart_app_title);
            this.iPm = (TextView) this.iPj.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.iPn = (ImageView) this.iPj.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.iPj.setOnClickListener(this.gon);
        }
    }

    public void a(f fVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (fVar != null && bdTypeListView != null) {
            if (fVar.ciS().aAX() && fVar.ciS().aAJ() != null) {
                SmartApp aAJ = fVar.ciS().aAJ();
                this.iPj.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aAJ.avatar)) {
                    this.iPk.startLoad(aAJ.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aAJ.name)) {
                    charSequence = aAJ.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.iCe.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.iCe.getText(R.string.intelligent_smart_app).toString();
                }
                this.iPl.setText(charSequence);
                if (!aq.isEmpty(aAJ._abstract)) {
                    this.iPm.setText(aAJ._abstract);
                } else {
                    this.iPm.setText(this.iCe.getText(R.string.smart_app_default_abstract));
                }
                this.iPj.setTag(aAJ);
                return;
            }
            this.iPj.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.iPj != null) {
            bdTypeListView.addHeaderView(this.iPj, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.iPj != null) {
            bdTypeListView.removeHeaderView(this.iPj);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iPj != null) {
            am.setBackgroundColor(this.iPj, R.color.cp_bg_line_c);
        }
        if (this.iPk != null) {
            this.iPk.setIsNight(i == 1);
        }
        if (this.iPl != null) {
            am.setViewTextColor(this.iPl, (int) R.color.cp_cont_b);
        }
        if (this.iPm != null) {
            am.setViewTextColor(this.iPm, (int) R.color.cp_cont_j);
        }
        if (this.iPn != null) {
            am.setBackgroundResource(this.iPn, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
