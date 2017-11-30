package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends j.a {
    private TbPageContext acd;
    View.OnClickListener alY;
    public View devider;
    public TextView eZA;
    public TbImageView eZB;
    public TextView eZC;
    public TextView eZD;
    public TextView eZE;
    public TextView eZF;
    public TbImageView eZG;
    public LinearLayout eZH;
    private com.baidu.tbadk.core.data.ao eZI;
    public TextView eZz;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.alY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aV(ah.this.acd.getPageActivity()) && com.baidu.adp.lib.util.l.hy() && ah.this.eZI != null && !StringUtils.isNull(ah.this.eZI.Wg)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.acd.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.eZF) {
                        String str = ah.this.eZI.Wg;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(ah.this.acd.getPageActivity());
                        akVar.Wg = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.eZI.Wg).ac("obj_locate", "3"));
                    } else if (view2 == ah.this.eZH) {
                        ah.this.acd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ah.this.acd.getPageActivity(), ah.this.eZI.Wg)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.eZI.Wg).ac("obj_locate", "1"));
                    } else if (view2 == ah.this.eZA && !StringUtils.isNull(ah.this.eZI.XT)) {
                        com.baidu.tbadk.core.util.av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(ah.this.acd.getPageActivity()), new String[]{ah.this.eZI.XT});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.eZI.Wg).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.acd = tbPageContext;
        this.eZz = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.eZA = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.eZB = (TbImageView) view.findViewById(d.g.novel_cover);
        this.eZC = (TextView) view.findViewById(d.g.novel_title);
        this.eZD = (TextView) view.findViewById(d.g.novel_author);
        this.eZE = (TextView) view.findViewById(d.g.novel_read_number);
        this.eZF = (TextView) view.findViewById(d.g.novel_read_btn);
        this.eZH = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.eZG = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.eZG.setDefaultResource(d.f.transparent_bg);
        this.eZG.setDefaultBgResource(d.f.transparent_bg);
        this.eZG.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.eZF.setOnClickListener(this.alY);
        this.eZH.setOnClickListener(this.alY);
        this.eZA.setOnClickListener(this.alY);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.eZI = aoVar;
            this.eZz.setText(aoVar.XR);
            this.eZA.setText(aoVar.XS);
            this.eZG.startLoad(aoVar.XW, 10, false);
            this.eZB.startLoad(aoVar.Wi, 10, false);
            this.eZF.setText(aoVar.XV);
            this.eZC.setText(aoVar.Wh);
            List<String> list = aoVar.XU;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eZD.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eZD.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eZE.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.eZz, d.C0082d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eZA, d.C0082d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.eZC, d.C0082d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.eZD, d.C0082d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eZE, d.C0082d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eZF, d.C0082d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.C0082d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.eZF, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ac("obj_id", this.eZI.Wg));
        }
    }
}
