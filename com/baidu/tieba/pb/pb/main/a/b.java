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
    private View.OnClickListener hpu;
    private PbFragment jGF;
    private RelativeLayout jUf;
    private HeadImageView jUg;
    private TextView jUh;
    private TextView jUi;
    private ImageView jUj;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.hpu = null;
        this.jGF = pbFragment;
        this.hpu = onClickListener;
        initView();
    }

    public void initView() {
        if (this.jUf == null) {
            this.jUf = (RelativeLayout) LayoutInflater.from(this.jGF.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.jUg = (HeadImageView) this.jUf.findViewById(R.id.iv_pb_video_smart_app_head);
            this.jUg.setIsRound(true);
            this.jUg.setPlaceHolder(1);
            this.jUh = (TextView) this.jUf.findViewById(R.id.tv_pb_video_smart_app_title);
            this.jUi = (TextView) this.jUf.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.jUj = (ImageView) this.jUf.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.jUf.setOnClickListener(this.hpu);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.cCi().aPk() && eVar.cCi().aRn() != null) {
                SmartApp aRn = eVar.cCi().aRn();
                this.jUf.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aRn.avatar)) {
                    this.jUg.startLoad(aRn.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aRn.name)) {
                    charSequence = aRn.name + " " + ((Object) this.jGF.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.jGF.getText(R.string.intelligent_smart_app).toString();
                }
                this.jUh.setText(charSequence);
                if (!aq.isEmpty(aRn._abstract)) {
                    this.jUi.setText(aRn._abstract);
                } else {
                    this.jUi.setText(this.jGF.getText(R.string.smart_app_default_abstract));
                }
                this.jUf.setTag(aRn);
                return;
            }
            this.jUf.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.jUf != null) {
            bdTypeListView.addHeaderView(this.jUf, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.jUf != null) {
            bdTypeListView.removeHeaderView(this.jUf);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jUf != null) {
            am.setBackgroundColor(this.jUf, R.color.cp_bg_line_c);
        }
        if (this.jUg != null) {
            this.jUg.setIsNight(i == 1);
        }
        if (this.jUh != null) {
            am.setViewTextColor(this.jUh, (int) R.color.cp_cont_b);
        }
        if (this.jUi != null) {
            am.setViewTextColor(this.jUi, (int) R.color.cp_cont_j);
        }
        if (this.jUj != null) {
            am.setBackgroundResource(this.jUj, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
