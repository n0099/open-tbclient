package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class en extends y.a {
    private TbPageContext DQ;
    View.OnClickListener acD;
    public View devider;
    public TextView efA;
    public TbImageView efB;
    public TextView efC;
    public TextView efD;
    public TextView efE;
    public TextView efF;
    public TbImageView efG;
    public LinearLayout efH;
    private com.baidu.tbadk.core.data.am efI;
    public TextView efz;

    public en(TbPageContext tbPageContext, View view) {
        super(view);
        this.acD = new eo(this);
        this.DQ = tbPageContext;
        this.efz = (TextView) view.findViewById(u.g.textview_recommend_title);
        this.efA = (TextView) view.findViewById(u.g.textview_recommend_option_btn);
        this.efB = (TbImageView) view.findViewById(u.g.novel_cover);
        this.efC = (TextView) view.findViewById(u.g.novel_title);
        this.efD = (TextView) view.findViewById(u.g.novel_author);
        this.efE = (TextView) view.findViewById(u.g.novel_read_number);
        this.efF = (TextView) view.findViewById(u.g.novel_read_btn);
        this.efH = (LinearLayout) view.findViewById(u.g.novel_recommend_item_layout);
        this.efG = (TbImageView) view.findViewById(u.g.novel_subscription);
        this.efG.setDefaultResource(u.f.transparent_bg);
        this.efG.setDefaultBgResource(u.f.transparent_bg);
        this.efG.setDefaultErrorResource(u.f.transparent_bg);
        this.devider = view.findViewById(u.g.recommend_devider);
        this.efF.setOnClickListener(this.acD);
        this.efH.setOnClickListener(this.acD);
        this.efA.setOnClickListener(this.acD);
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null) {
            this.efI = amVar;
            this.efz.setText(amVar.Pn);
            this.efA.setText(amVar.Po);
            this.efG.c(amVar.Pu, 10, false);
            this.efB.c(amVar.Pq, 10, false);
            this.efF.setText(amVar.Pt);
            this.efC.setText(amVar.Pr);
            List<String> list = amVar.Ps;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.efD.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.efD.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.efE.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.av.c(this.efz, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.efA, u.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.av.c(this.efC, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.efD, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.efE, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.efF, u.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.av.l(this.devider, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.efF, u.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11441").ab("obj_id", this.efI.bookId));
        }
    }
}
