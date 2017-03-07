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
public class ep extends y.a {
    private TbPageContext aaI;
    View.OnClickListener akq;
    public View devider;
    public TextView eqh;
    public TextView eqi;
    public TbImageView eqj;
    public TextView eqk;
    public TextView eql;
    public TextView eqm;
    public TextView eqn;
    public TbImageView eqo;
    public LinearLayout eqp;
    private com.baidu.tbadk.core.data.at eqq;

    public ep(TbPageContext tbPageContext, View view) {
        super(view);
        this.akq = new eq(this);
        this.aaI = tbPageContext;
        this.eqh = (TextView) view.findViewById(w.h.textview_recommend_title);
        this.eqi = (TextView) view.findViewById(w.h.textview_recommend_option_btn);
        this.eqj = (TbImageView) view.findViewById(w.h.novel_cover);
        this.eqk = (TextView) view.findViewById(w.h.novel_title);
        this.eql = (TextView) view.findViewById(w.h.novel_author);
        this.eqm = (TextView) view.findViewById(w.h.novel_read_number);
        this.eqn = (TextView) view.findViewById(w.h.novel_read_btn);
        this.eqp = (LinearLayout) view.findViewById(w.h.novel_recommend_item_layout);
        this.eqo = (TbImageView) view.findViewById(w.h.novel_subscription);
        this.eqo.setDefaultResource(w.g.transparent_bg);
        this.eqo.setDefaultBgResource(w.g.transparent_bg);
        this.eqo.setDefaultErrorResource(w.g.transparent_bg);
        this.devider = view.findViewById(w.h.recommend_devider);
        this.eqn.setOnClickListener(this.akq);
        this.eqp.setOnClickListener(this.akq);
        this.eqi.setOnClickListener(this.akq);
    }

    public void a(com.baidu.tbadk.core.data.at atVar) {
        if (atVar != null) {
            this.eqq = atVar;
            this.eqh.setText(atVar.WS);
            this.eqi.setText(atVar.WT);
            this.eqo.c(atVar.WX, 10, false);
            this.eqj.c(atVar.UX, 10, false);
            this.eqn.setText(atVar.WW);
            this.eqk.setText(atVar.UW);
            List<String> list = atVar.WV;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eql.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eql.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eqm.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aq.c(this.eqh, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqi, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqk, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.eql, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqm, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqn, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.k(this.devider, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.j(this.eqn, w.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11441").Z("obj_id", this.eqq.bookId));
        }
    }
}
