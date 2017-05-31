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
public class fe extends z.a {
    private TbPageContext aas;
    View.OnClickListener ajS;
    public View devider;
    public TextView erP;
    public TextView erQ;
    public TbImageView erR;
    public TextView erS;
    public TextView erT;
    public TextView erU;
    public TextView erV;
    public TbImageView erW;
    public LinearLayout erX;
    private com.baidu.tbadk.core.data.au erY;

    public fe(TbPageContext tbPageContext, View view) {
        super(view);
        this.ajS = new ff(this);
        this.aas = tbPageContext;
        this.erP = (TextView) view.findViewById(w.h.textview_recommend_title);
        this.erQ = (TextView) view.findViewById(w.h.textview_recommend_option_btn);
        this.erR = (TbImageView) view.findViewById(w.h.novel_cover);
        this.erS = (TextView) view.findViewById(w.h.novel_title);
        this.erT = (TextView) view.findViewById(w.h.novel_author);
        this.erU = (TextView) view.findViewById(w.h.novel_read_number);
        this.erV = (TextView) view.findViewById(w.h.novel_read_btn);
        this.erX = (LinearLayout) view.findViewById(w.h.novel_recommend_item_layout);
        this.erW = (TbImageView) view.findViewById(w.h.novel_subscription);
        this.erW.setDefaultResource(w.g.transparent_bg);
        this.erW.setDefaultBgResource(w.g.transparent_bg);
        this.erW.setDefaultErrorResource(w.g.transparent_bg);
        this.devider = view.findViewById(w.h.recommend_devider);
        this.erV.setOnClickListener(this.ajS);
        this.erX.setOnClickListener(this.ajS);
        this.erQ.setOnClickListener(this.ajS);
    }

    public void a(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null) {
            this.erY = auVar;
            this.erP.setText(auVar.Wv);
            this.erQ.setText(auVar.Ww);
            this.erW.c(auVar.WA, 10, false);
            this.erR.c(auVar.Uw, 10, false);
            this.erV.setText(auVar.Wz);
            this.erS.setText(auVar.Uv);
            List<String> list = auVar.Wy;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.erT.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.erT.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.erU.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aq.c(this.erP, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.erQ, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.c(this.erS, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.erT, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.erU, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.erV, w.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aq.k(this.devider, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.j(this.erV, w.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11441").Z("obj_id", this.erY.bookId));
        }
    }
}
