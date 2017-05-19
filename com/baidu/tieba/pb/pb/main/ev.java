package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ev extends y.a {
    private TbPageContext aat;
    View.OnClickListener akc;
    public View devider;
    public TextView emc;
    public TextView emd;
    public TbImageView eme;
    public TextView emf;
    public TextView emg;
    public TextView emh;
    public TextView emi;
    public TbImageView emj;
    public LinearLayout emk;
    private com.baidu.tbadk.core.data.at eml;

    public ev(TbPageContext tbPageContext, View view) {
        super(view);
        this.akc = new ew(this);
        this.aat = tbPageContext;
        this.emc = (TextView) view.findViewById(w.h.textview_recommend_title);
        this.emd = (TextView) view.findViewById(w.h.textview_recommend_option_btn);
        this.eme = (TbImageView) view.findViewById(w.h.novel_cover);
        this.emf = (TextView) view.findViewById(w.h.novel_title);
        this.emg = (TextView) view.findViewById(w.h.novel_author);
        this.emh = (TextView) view.findViewById(w.h.novel_read_number);
        this.emi = (TextView) view.findViewById(w.h.novel_read_btn);
        this.emk = (LinearLayout) view.findViewById(w.h.novel_recommend_item_layout);
        this.emj = (TbImageView) view.findViewById(w.h.novel_subscription);
        this.emj.setDefaultResource(w.g.transparent_bg);
        this.emj.setDefaultBgResource(w.g.transparent_bg);
        this.emj.setDefaultErrorResource(w.g.transparent_bg);
        this.devider = view.findViewById(w.h.recommend_devider);
        this.emi.setOnClickListener(this.akc);
        this.emk.setOnClickListener(this.akc);
        this.emd.setOnClickListener(this.akc);
    }

    public void a(com.baidu.tbadk.core.data.at atVar) {
        if (atVar != null) {
            this.eml = atVar;
            this.emc.setText(atVar.WA);
            this.emd.setText(atVar.WB);
            this.emj.c(atVar.WF, 10, false);
            this.eme.c(atVar.UK, 10, false);
            this.emi.setText(atVar.WE);
            this.emf.setText(atVar.UJ);
            List<String> list = atVar.WD;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.emg.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.emg.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.emh.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aq.c(this.emc, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.emd, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.c(this.emf, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.emg, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.emh, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.emi, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.k(this.devider, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.j(this.emi, w.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11441").aa("obj_id", this.eml.bookId));
        }
    }
}
