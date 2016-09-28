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
public class en extends y.a {
    private TbPageContext Gd;
    View.OnClickListener afS;
    public View devider;
    public TextView etN;
    public TextView etO;
    public TbImageView etP;
    public TextView etQ;
    public TextView etR;
    public TextView etS;
    public TextView etT;
    public TbImageView etU;
    public LinearLayout etV;
    private com.baidu.tbadk.core.data.ap etW;

    public en(TbPageContext tbPageContext, View view) {
        super(view);
        this.afS = new eo(this);
        this.Gd = tbPageContext;
        this.etN = (TextView) view.findViewById(r.g.textview_recommend_title);
        this.etO = (TextView) view.findViewById(r.g.textview_recommend_option_btn);
        this.etP = (TbImageView) view.findViewById(r.g.novel_cover);
        this.etQ = (TextView) view.findViewById(r.g.novel_title);
        this.etR = (TextView) view.findViewById(r.g.novel_author);
        this.etS = (TextView) view.findViewById(r.g.novel_read_number);
        this.etT = (TextView) view.findViewById(r.g.novel_read_btn);
        this.etV = (LinearLayout) view.findViewById(r.g.novel_recommend_item_layout);
        this.etU = (TbImageView) view.findViewById(r.g.novel_subscription);
        this.etU.setDefaultResource(r.f.transparent_bg);
        this.etU.setDefaultBgResource(r.f.transparent_bg);
        this.etU.setDefaultErrorResource(r.f.transparent_bg);
        this.devider = view.findViewById(r.g.recommend_devider);
        this.etT.setOnClickListener(this.afS);
        this.etV.setOnClickListener(this.afS);
        this.etO.setOnClickListener(this.afS);
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null) {
            this.etW = apVar;
            this.etN.setText(apVar.Sf);
            this.etO.setText(apVar.Sg);
            this.etU.c(apVar.Sk, 10, false);
            this.etP.c(apVar.Ql, 10, false);
            this.etT.setText(apVar.Sj);
            this.etQ.setText(apVar.Qk);
            List<String> list = apVar.Si;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.etR.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.etR.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.etS.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.av.c(this.etN, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.etO, r.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.av.c(this.etQ, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.etR, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.etS, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.etT, r.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.av.l(this.devider, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.etT, r.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11441").ab("obj_id", this.etW.bookId));
        }
    }
}
