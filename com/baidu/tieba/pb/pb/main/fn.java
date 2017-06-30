package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class fn extends z.a {
    private TbPageContext aat;
    View.OnClickListener akF;
    public View devider;
    public TextView eBa;
    public TextView eBb;
    public TbImageView eBc;
    public TextView eBd;
    public TextView eBe;
    public TextView eBf;
    public TextView eBg;
    public TbImageView eBh;
    public LinearLayout eBi;
    private com.baidu.tbadk.core.data.av eBj;

    public fn(TbPageContext tbPageContext, View view) {
        super(view);
        this.akF = new fo(this);
        this.aat = tbPageContext;
        this.eBa = (TextView) view.findViewById(w.h.textview_recommend_title);
        this.eBb = (TextView) view.findViewById(w.h.textview_recommend_option_btn);
        this.eBc = (TbImageView) view.findViewById(w.h.novel_cover);
        this.eBd = (TextView) view.findViewById(w.h.novel_title);
        this.eBe = (TextView) view.findViewById(w.h.novel_author);
        this.eBf = (TextView) view.findViewById(w.h.novel_read_number);
        this.eBg = (TextView) view.findViewById(w.h.novel_read_btn);
        this.eBi = (LinearLayout) view.findViewById(w.h.novel_recommend_item_layout);
        this.eBh = (TbImageView) view.findViewById(w.h.novel_subscription);
        this.eBh.setDefaultResource(w.g.transparent_bg);
        this.eBh.setDefaultBgResource(w.g.transparent_bg);
        this.eBh.setDefaultErrorResource(w.g.transparent_bg);
        this.devider = view.findViewById(w.h.recommend_devider);
        this.eBg.setOnClickListener(this.akF);
        this.eBi.setOnClickListener(this.akF);
        this.eBb.setOnClickListener(this.akF);
    }

    public void a(com.baidu.tbadk.core.data.av avVar) {
        if (avVar != null) {
            this.eBj = avVar;
            this.eBa.setText(avVar.Wv);
            this.eBb.setText(avVar.Ww);
            this.eBh.c(avVar.WA, 10, false);
            this.eBc.c(avVar.Uv, 10, false);
            this.eBg.setText(avVar.Wz);
            this.eBd.setText(avVar.Uu);
            List<String> list = avVar.Wy;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eBe.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eBe.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eBf.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.as.c(this.eBa, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.as.c(this.eBb, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.as.c(this.eBd, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.c(this.eBe, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.as.c(this.eBf, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.as.c(this.eBg, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.as.k(this.devider, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.j(this.eBg, w.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11441").Z("obj_id", this.eBj.bookId));
        }
    }
}
