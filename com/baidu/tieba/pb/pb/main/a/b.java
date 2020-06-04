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
    private View.OnClickListener hpF;
    private PbFragment jHL;
    private RelativeLayout jVl;
    private HeadImageView jVm;
    private TextView jVn;
    private TextView jVo;
    private ImageView jVp;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.hpF = null;
        this.jHL = pbFragment;
        this.hpF = onClickListener;
        initView();
    }

    public void initView() {
        if (this.jVl == null) {
            this.jVl = (RelativeLayout) LayoutInflater.from(this.jHL.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
            this.jVm = (HeadImageView) this.jVl.findViewById(R.id.iv_pb_video_smart_app_head);
            this.jVm.setIsRound(true);
            this.jVm.setPlaceHolder(1);
            this.jVn = (TextView) this.jVl.findViewById(R.id.tv_pb_video_smart_app_title);
            this.jVo = (TextView) this.jVl.findViewById(R.id.tv_pb_video_smart_app_abstract);
            this.jVp = (ImageView) this.jVl.findViewById(R.id.iv_pb_video_smart_app_arrow);
            this.jVl.setOnClickListener(this.hpF);
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar != null && bdTypeListView != null) {
            if (eVar.cCy().aPk() && eVar.cCy().aRn() != null) {
                SmartApp aRn = eVar.cCy().aRn();
                this.jVl.setVisibility(0);
                c(bdTypeListView);
                a(bdTypeListView, 1);
                if (!aq.isEmpty(aRn.avatar)) {
                    this.jVm.startLoad(aRn.avatar, 10, false, false);
                }
                if (!aq.isEmpty(aRn.name)) {
                    charSequence = aRn.name + " " + ((Object) this.jHL.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.jHL.getText(R.string.intelligent_smart_app).toString();
                }
                this.jVn.setText(charSequence);
                if (!aq.isEmpty(aRn._abstract)) {
                    this.jVo.setText(aRn._abstract);
                } else {
                    this.jVo.setText(this.jHL.getText(R.string.smart_app_default_abstract));
                }
                this.jVl.setTag(aRn);
                return;
            }
            this.jVl.setVisibility(8);
            c(bdTypeListView);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null && this.jVl != null) {
            bdTypeListView.addHeaderView(this.jVl, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null && this.jVl != null) {
            bdTypeListView.removeHeaderView(this.jVl);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jVl != null) {
            am.setBackgroundColor(this.jVl, R.color.cp_bg_line_c);
        }
        if (this.jVm != null) {
            this.jVm.setIsNight(i == 1);
        }
        if (this.jVn != null) {
            am.setViewTextColor(this.jVn, (int) R.color.cp_cont_b);
        }
        if (this.jVo != null) {
            am.setViewTextColor(this.jVo, (int) R.color.cp_cont_j);
        }
        if (this.jVp != null) {
            am.setBackgroundResource(this.jVp, R.drawable.icon_common_arrow16_right_n);
        }
    }
}
