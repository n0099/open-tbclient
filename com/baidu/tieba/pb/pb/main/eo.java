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
public class eo extends y.a {
    private TbPageContext Gf;
    View.OnClickListener agt;
    public View devider;
    public TextView eAe;
    public TextView eAf;
    public TbImageView eAg;
    public TextView eAh;
    public TextView eAi;
    public TextView eAj;
    public TextView eAk;
    public TbImageView eAl;
    public LinearLayout eAm;
    private com.baidu.tbadk.core.data.ar eAn;

    public eo(TbPageContext tbPageContext, View view) {
        super(view);
        this.agt = new ep(this);
        this.Gf = tbPageContext;
        this.eAe = (TextView) view.findViewById(r.g.textview_recommend_title);
        this.eAf = (TextView) view.findViewById(r.g.textview_recommend_option_btn);
        this.eAg = (TbImageView) view.findViewById(r.g.novel_cover);
        this.eAh = (TextView) view.findViewById(r.g.novel_title);
        this.eAi = (TextView) view.findViewById(r.g.novel_author);
        this.eAj = (TextView) view.findViewById(r.g.novel_read_number);
        this.eAk = (TextView) view.findViewById(r.g.novel_read_btn);
        this.eAm = (LinearLayout) view.findViewById(r.g.novel_recommend_item_layout);
        this.eAl = (TbImageView) view.findViewById(r.g.novel_subscription);
        this.eAl.setDefaultResource(r.f.transparent_bg);
        this.eAl.setDefaultBgResource(r.f.transparent_bg);
        this.eAl.setDefaultErrorResource(r.f.transparent_bg);
        this.devider = view.findViewById(r.g.recommend_devider);
        this.eAk.setOnClickListener(this.agt);
        this.eAm.setOnClickListener(this.agt);
        this.eAf.setOnClickListener(this.agt);
    }

    public void a(com.baidu.tbadk.core.data.ar arVar) {
        if (arVar != null) {
            this.eAn = arVar;
            this.eAe.setText(arVar.SA);
            this.eAf.setText(arVar.SB);
            this.eAl.c(arVar.SF, 10, false);
            this.eAg.c(arVar.QD, 10, false);
            this.eAk.setText(arVar.SE);
            this.eAh.setText(arVar.QC);
            List<String> list = arVar.SD;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eAi.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eAi.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eAj.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.at.c(this.eAe, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.eAf, r.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.at.c(this.eAh, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.eAi, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.eAj, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.eAk, r.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.at.l(this.devider, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.eAk, r.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11441").ab("obj_id", this.eAn.bookId));
        }
    }
}
