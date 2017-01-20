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
    private TbPageContext Fp;
    View.OnClickListener aeY;
    public View devider;
    public TextView eni;
    public TextView enj;
    public TbImageView enk;
    public TextView enl;
    public TextView enm;
    public TextView enn;
    public TextView eno;
    public TbImageView enp;
    public LinearLayout enq;
    private com.baidu.tbadk.core.data.ar enr;

    public eo(TbPageContext tbPageContext, View view) {
        super(view);
        this.aeY = new ep(this);
        this.Fp = tbPageContext;
        this.eni = (TextView) view.findViewById(r.h.textview_recommend_title);
        this.enj = (TextView) view.findViewById(r.h.textview_recommend_option_btn);
        this.enk = (TbImageView) view.findViewById(r.h.novel_cover);
        this.enl = (TextView) view.findViewById(r.h.novel_title);
        this.enm = (TextView) view.findViewById(r.h.novel_author);
        this.enn = (TextView) view.findViewById(r.h.novel_read_number);
        this.eno = (TextView) view.findViewById(r.h.novel_read_btn);
        this.enq = (LinearLayout) view.findViewById(r.h.novel_recommend_item_layout);
        this.enp = (TbImageView) view.findViewById(r.h.novel_subscription);
        this.enp.setDefaultResource(r.g.transparent_bg);
        this.enp.setDefaultBgResource(r.g.transparent_bg);
        this.enp.setDefaultErrorResource(r.g.transparent_bg);
        this.devider = view.findViewById(r.h.recommend_devider);
        this.eno.setOnClickListener(this.aeY);
        this.enq.setOnClickListener(this.aeY);
        this.enj.setOnClickListener(this.aeY);
    }

    public void a(com.baidu.tbadk.core.data.ar arVar) {
        if (arVar != null) {
            this.enr = arVar;
            this.eni.setText(arVar.RE);
            this.enj.setText(arVar.RF);
            this.enp.c(arVar.RJ, 10, false);
            this.enk.c(arVar.PK, 10, false);
            this.eno.setText(arVar.RI);
            this.enl.setText(arVar.PJ);
            List<String> list = arVar.RH;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.enm.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.enm.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.enn.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.c(this.eni, r.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.c(this.enj, r.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.c(this.enl, r.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.c(this.enm, r.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.c(this.enn, r.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.c(this.eno, r.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.k(this.devider, r.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.ap.j((View) this.eno, r.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11441").ab("obj_id", this.enr.bookId));
        }
    }
}
