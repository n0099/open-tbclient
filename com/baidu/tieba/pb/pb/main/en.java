package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class en extends y.a {
    private TbPageContext Gd;
    View.OnClickListener aft;
    public View devider;
    public TextView erE;
    public TextView erF;
    public TbImageView erG;
    public TextView erH;
    public TextView erI;
    public TextView erJ;
    public TextView erK;
    public TbImageView erL;
    public LinearLayout erM;
    private com.baidu.tbadk.core.data.an erN;

    public en(TbPageContext tbPageContext, View view) {
        super(view);
        this.aft = new eo(this);
        this.Gd = tbPageContext;
        this.erE = (TextView) view.findViewById(t.g.textview_recommend_title);
        this.erF = (TextView) view.findViewById(t.g.textview_recommend_option_btn);
        this.erG = (TbImageView) view.findViewById(t.g.novel_cover);
        this.erH = (TextView) view.findViewById(t.g.novel_title);
        this.erI = (TextView) view.findViewById(t.g.novel_author);
        this.erJ = (TextView) view.findViewById(t.g.novel_read_number);
        this.erK = (TextView) view.findViewById(t.g.novel_read_btn);
        this.erM = (LinearLayout) view.findViewById(t.g.novel_recommend_item_layout);
        this.erL = (TbImageView) view.findViewById(t.g.novel_subscription);
        this.erL.setDefaultResource(t.f.transparent_bg);
        this.erL.setDefaultBgResource(t.f.transparent_bg);
        this.erL.setDefaultErrorResource(t.f.transparent_bg);
        this.devider = view.findViewById(t.g.recommend_devider);
        this.erK.setOnClickListener(this.aft);
        this.erM.setOnClickListener(this.aft);
        this.erF.setOnClickListener(this.aft);
    }

    public void a(com.baidu.tbadk.core.data.an anVar) {
        if (anVar != null) {
            this.erN = anVar;
            this.erE.setText(anVar.RZ);
            this.erF.setText(anVar.Sa);
            this.erL.c(anVar.Se, 10, false);
            this.erG.c(anVar.Qn, 10, false);
            this.erK.setText(anVar.Sd);
            this.erH.setText(anVar.Qm);
            List<String> list = anVar.Sc;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.erI.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.erI.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.erJ.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.av.c(this.erE, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.erF, t.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.av.c(this.erH, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.erI, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.erJ, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.erK, t.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.av.l(this.devider, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.erK, t.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11441").ab("obj_id", this.erN.bookId));
        }
    }
}
