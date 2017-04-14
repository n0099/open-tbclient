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
    private TbPageContext aaX;
    View.OnClickListener akE;
    public View devider;
    public TextView eoq;
    public TextView eor;
    public TbImageView eos;
    public TextView eot;
    public TextView eou;
    public TextView eov;
    public TextView eow;
    public TbImageView eox;
    public LinearLayout eoy;
    private com.baidu.tbadk.core.data.as eoz;

    public en(TbPageContext tbPageContext, View view) {
        super(view);
        this.akE = new eo(this);
        this.aaX = tbPageContext;
        this.eoq = (TextView) view.findViewById(w.h.textview_recommend_title);
        this.eor = (TextView) view.findViewById(w.h.textview_recommend_option_btn);
        this.eos = (TbImageView) view.findViewById(w.h.novel_cover);
        this.eot = (TextView) view.findViewById(w.h.novel_title);
        this.eou = (TextView) view.findViewById(w.h.novel_author);
        this.eov = (TextView) view.findViewById(w.h.novel_read_number);
        this.eow = (TextView) view.findViewById(w.h.novel_read_btn);
        this.eoy = (LinearLayout) view.findViewById(w.h.novel_recommend_item_layout);
        this.eox = (TbImageView) view.findViewById(w.h.novel_subscription);
        this.eox.setDefaultResource(w.g.transparent_bg);
        this.eox.setDefaultBgResource(w.g.transparent_bg);
        this.eox.setDefaultErrorResource(w.g.transparent_bg);
        this.devider = view.findViewById(w.h.recommend_devider);
        this.eow.setOnClickListener(this.akE);
        this.eoy.setOnClickListener(this.akE);
        this.eor.setOnClickListener(this.akE);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null) {
            this.eoz = asVar;
            this.eoq.setText(asVar.Xh);
            this.eor.setText(asVar.Xi);
            this.eox.c(asVar.Xm, 10, false);
            this.eos.c(asVar.Vq, 10, false);
            this.eow.setText(asVar.Xl);
            this.eot.setText(asVar.Vp);
            List<String> list = asVar.Xk;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eou.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eou.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eov.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aq.c(this.eoq, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eor, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.c(this.eot, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.eou, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eov, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.eow, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.k(this.devider, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.j(this.eow, w.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11441").aa("obj_id", this.eoz.bookId));
        }
    }
}
