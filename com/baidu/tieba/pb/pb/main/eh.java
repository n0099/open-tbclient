package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class eh extends y.a {
    private TbPageContext Gf;
    View.OnClickListener afL;
    public View devider;
    public TextView een;
    public TextView eeo;
    public TbImageView eep;
    public TextView eeq;
    public TextView eer;
    public TextView ees;
    public TextView eet;
    public TbImageView eeu;
    public LinearLayout eev;
    private com.baidu.tbadk.core.data.aq eew;

    public eh(TbPageContext tbPageContext, View view) {
        super(view);
        this.afL = new ei(this);
        this.Gf = tbPageContext;
        this.een = (TextView) view.findViewById(r.g.textview_recommend_title);
        this.eeo = (TextView) view.findViewById(r.g.textview_recommend_option_btn);
        this.eep = (TbImageView) view.findViewById(r.g.novel_cover);
        this.eeq = (TextView) view.findViewById(r.g.novel_title);
        this.eer = (TextView) view.findViewById(r.g.novel_author);
        this.ees = (TextView) view.findViewById(r.g.novel_read_number);
        this.eet = (TextView) view.findViewById(r.g.novel_read_btn);
        this.eev = (LinearLayout) view.findViewById(r.g.novel_recommend_item_layout);
        this.eeu = (TbImageView) view.findViewById(r.g.novel_subscription);
        this.eeu.setDefaultResource(r.f.transparent_bg);
        this.eeu.setDefaultBgResource(r.f.transparent_bg);
        this.eeu.setDefaultErrorResource(r.f.transparent_bg);
        this.devider = view.findViewById(r.g.recommend_devider);
        this.eet.setOnClickListener(this.afL);
        this.eev.setOnClickListener(this.afL);
        this.eeo.setOnClickListener(this.afL);
    }

    public void a(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.eew = aqVar;
            this.een.setText(aqVar.Sv);
            this.eeo.setText(aqVar.Sw);
            this.eeu.c(aqVar.SA, 10, false);
            this.eep.c(aqVar.QA, 10, false);
            this.eet.setText(aqVar.Sz);
            this.eeq.setText(aqVar.Qz);
            List<String> list = aqVar.Sy;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eer.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eer.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.ees.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ar.c(this.een, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.c(this.eeo, r.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ar.c(this.eeq, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.c(this.eer, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.c(this.ees, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.c(this.eet, r.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ar.l(this.devider, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.k(this.eet, r.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11441").ab("obj_id", this.eew.bookId));
        }
    }
}
