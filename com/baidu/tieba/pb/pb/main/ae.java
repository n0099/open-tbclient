package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends j.a {
    private TbPageContext aby;
    View.OnClickListener alY;
    public View devider;
    public TextView eNA;
    public TextView eNB;
    public TextView eNC;
    public TbImageView eND;
    public LinearLayout eNE;
    private au eNF;
    public TextView eNw;
    public TextView eNx;
    public TbImageView eNy;
    public TextView eNz;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.alY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(ae.this.aby.getPageActivity()) && com.baidu.adp.lib.util.k.hz() && ae.this.eNF != null && !StringUtils.isNull(ae.this.eNF.Vp)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.k.showToast(ae.this.aby.getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else if (view2 == ae.this.eNC) {
                        String str = ae.this.eNF.Vp;
                        com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                        aqVar.pageContext = (TbPageContext) com.baidu.adp.base.i.X(ae.this.aby.getPageActivity());
                        aqVar.Vp = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ad("obj_locate", "0").ad("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ae.this.eNF.Vp).ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == ae.this.eNE) {
                        ae.this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ae.this.aby.getPageActivity(), ae.this.eNF.Vp)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ae.this.eNF.Vp).ad("obj_locate", "1"));
                    } else if (view2 == ae.this.eNx && !StringUtils.isNull(ae.this.eNF.Xu)) {
                        com.baidu.tbadk.core.util.au.wd().c((TbPageContext) com.baidu.adp.base.i.X(ae.this.aby.getPageActivity()), new String[]{ae.this.eNF.Xu});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ae.this.eNF.Vp).ad("obj_locate", "2"));
                    }
                }
            }
        };
        this.aby = tbPageContext;
        this.eNw = (TextView) view.findViewById(d.h.textview_recommend_title);
        this.eNx = (TextView) view.findViewById(d.h.textview_recommend_option_btn);
        this.eNy = (TbImageView) view.findViewById(d.h.novel_cover);
        this.eNz = (TextView) view.findViewById(d.h.novel_title);
        this.eNA = (TextView) view.findViewById(d.h.novel_author);
        this.eNB = (TextView) view.findViewById(d.h.novel_read_number);
        this.eNC = (TextView) view.findViewById(d.h.novel_read_btn);
        this.eNE = (LinearLayout) view.findViewById(d.h.novel_recommend_item_layout);
        this.eND = (TbImageView) view.findViewById(d.h.novel_subscription);
        this.eND.setDefaultResource(d.g.transparent_bg);
        this.eND.setDefaultBgResource(d.g.transparent_bg);
        this.eND.setDefaultErrorResource(d.g.transparent_bg);
        this.devider = view.findViewById(d.h.recommend_devider);
        this.eNC.setOnClickListener(this.alY);
        this.eNE.setOnClickListener(this.alY);
        this.eNx.setOnClickListener(this.alY);
    }

    public void a(au auVar) {
        if (auVar != null) {
            this.eNF = auVar;
            this.eNw.setText(auVar.Xs);
            this.eNx.setText(auVar.Xt);
            this.eND.c(auVar.Xx, 10, false);
            this.eNy.c(auVar.Vr, 10, false);
            this.eNC.setText(auVar.Xw);
            this.eNz.setText(auVar.Vq);
            List<String> list = auVar.Xv;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eNA.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eNA.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eNB.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.eNw, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eNx, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.eNz, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.eNA, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eNB, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eNC, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.eNC, d.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ad("obj_id", this.eNF.Vp));
        }
    }
}
