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
public class en extends y.a {
    private TbPageContext aaY;
    View.OnClickListener akF;
    public View devider;
    public TextView eqH;
    public TextView eqI;
    public TbImageView eqJ;
    public TextView eqK;
    public TextView eqL;
    public TextView eqM;
    public TextView eqN;
    public TbImageView eqO;
    public LinearLayout eqP;
    private com.baidu.tbadk.core.data.as eqQ;

    public en(TbPageContext tbPageContext, View view) {
        super(view);
        this.akF = new eo(this);
        this.aaY = tbPageContext;
        this.eqH = (TextView) view.findViewById(w.h.textview_recommend_title);
        this.eqI = (TextView) view.findViewById(w.h.textview_recommend_option_btn);
        this.eqJ = (TbImageView) view.findViewById(w.h.novel_cover);
        this.eqK = (TextView) view.findViewById(w.h.novel_title);
        this.eqL = (TextView) view.findViewById(w.h.novel_author);
        this.eqM = (TextView) view.findViewById(w.h.novel_read_number);
        this.eqN = (TextView) view.findViewById(w.h.novel_read_btn);
        this.eqP = (LinearLayout) view.findViewById(w.h.novel_recommend_item_layout);
        this.eqO = (TbImageView) view.findViewById(w.h.novel_subscription);
        this.eqO.setDefaultResource(w.g.transparent_bg);
        this.eqO.setDefaultBgResource(w.g.transparent_bg);
        this.eqO.setDefaultErrorResource(w.g.transparent_bg);
        this.devider = view.findViewById(w.h.recommend_devider);
        this.eqN.setOnClickListener(this.akF);
        this.eqP.setOnClickListener(this.akF);
        this.eqI.setOnClickListener(this.akF);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null) {
            this.eqQ = asVar;
            this.eqH.setText(asVar.Xi);
            this.eqI.setText(asVar.Xj);
            this.eqO.c(asVar.Xn, 10, false);
            this.eqJ.c(asVar.Vs, 10, false);
            this.eqN.setText(asVar.Xm);
            this.eqK.setText(asVar.Vr);
            List<String> list = asVar.Xl;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eqL.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eqL.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eqM.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aq.c(this.eqH, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqI, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqK, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqL, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqM, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eqN, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.k(this.devider, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.j(this.eqN, w.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11441").aa("obj_id", this.eqQ.bookId));
        }
    }
}
