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
    private View.OnClickListener grn;
    private PbFragment iFL;
    private RelativeLayout iSt;
    private HeadImageView iSu;
    private TextView iSv;
    private TextView iSw;
    private ImageView iSx;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.grn = null;
        this.iFL = pbFragment;
        this.grn = onClickListener;
        initView();
    }

    public void initView() {
        if (this.iSt == null) {
            this.iSt = (RelativeLayout) LayoutInflater.from(this.iFL.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.iSu = (HeadImageView) this.iSt.findViewById(R.id.iv_pb_video_smart_app_head);
            this.iSu.setIsRound(true);
            this.iSu.setPlaceHolder(1);
            this.iSv = (TextView) this.iSt.findViewById(R.id.tv_pb_video_smart_app_title);
            this.iSw = (TextView) this.iSt.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.iSx = (ImageView) this.iSt.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.iSt.setOnClickListener(this.grn);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.ckP().aBe() && eVar.ckP().aDd() != null) {
                SmartApp aDd = eVar.ckP().aDd();
                this.iSt.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aDd.avatar)) {
                    this.iSu.startLoad(aDd.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aDd.name)) {
                    charSequence = aDd.name + HanziToPinyin.Token.SEPARATOR + ((Object) this.iFL.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.iFL.getText(R.string.intelligent_smart_app).toString();
                }
                this.iSv.setText(charSequence);
                if (!aq.isEmpty(aDd._abstract)) {
                    this.iSw.setText(aDd._abstract);
                } else {
                    this.iSw.setText(this.iFL.getText(R.string.smart_app_default_abstract));
                }
                this.iSt.setTag(aDd);
                return;
            }
            this.iSt.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.iSt != null) {
            bdTypeListView.addHeaderView(this.iSt, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.iSt != null) {
            bdTypeListView.removeHeaderView(this.iSt);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iSt != null) {
            am.setBackgroundColor(this.iSt, R.color.cp_bg_line_c);
        }
        if (this.iSu != null) {
            this.iSu.setIsNight(i == 1);
        }
        if (this.iSv != null) {
            am.setViewTextColor(this.iSv, (int) R.color.cp_cont_b);
        }
        if (this.iSw != null) {
            am.setViewTextColor(this.iSw, (int) R.color.cp_cont_j);
        }
        if (this.iSx != null) {
            am.setBackgroundResource(this.iSx, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
