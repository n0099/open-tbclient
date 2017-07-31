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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends j.a {
    private TbPageContext acp;
    View.OnClickListener amD;
    public View devider;
    public TextView eNA;
    public TextView eNB;
    public TbImageView eNC;
    public LinearLayout eND;
    private com.baidu.tbadk.core.data.au eNE;
    public TextView eNv;
    public TextView eNw;
    public TbImageView eNx;
    public TextView eNy;
    public TextView eNz;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.amD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(ah.this.acp.getPageActivity()) && com.baidu.adp.lib.util.k.hI() && ah.this.eNE != null && !StringUtils.isNull(ah.this.eNE.bookId)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.k.showToast(ah.this.acp.getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.eNB) {
                        String str = ah.this.eNE.bookId;
                        com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                        aqVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aa(ah.this.acp.getPageActivity());
                        aqVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aa("obj_locate", "0").aa("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.eNE.bookId).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == ah.this.eND) {
                        ah.this.acp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ah.this.acp.getPageActivity(), ah.this.eNE.bookId)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.eNE.bookId).aa("obj_locate", "1"));
                    } else if (view2 == ah.this.eNw && !StringUtils.isNull(ah.this.eNE.Yj)) {
                        com.baidu.tbadk.core.util.at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ah.this.acp.getPageActivity()), new String[]{ah.this.eNE.Yj});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.eNE.bookId).aa("obj_locate", "2"));
                    }
                }
            }
        };
        this.acp = tbPageContext;
        this.eNv = (TextView) view.findViewById(d.h.textview_recommend_title);
        this.eNw = (TextView) view.findViewById(d.h.textview_recommend_option_btn);
        this.eNx = (TbImageView) view.findViewById(d.h.novel_cover);
        this.eNy = (TextView) view.findViewById(d.h.novel_title);
        this.eNz = (TextView) view.findViewById(d.h.novel_author);
        this.eNA = (TextView) view.findViewById(d.h.novel_read_number);
        this.eNB = (TextView) view.findViewById(d.h.novel_read_btn);
        this.eND = (LinearLayout) view.findViewById(d.h.novel_recommend_item_layout);
        this.eNC = (TbImageView) view.findViewById(d.h.novel_subscription);
        this.eNC.setDefaultResource(d.g.transparent_bg);
        this.eNC.setDefaultBgResource(d.g.transparent_bg);
        this.eNC.setDefaultErrorResource(d.g.transparent_bg);
        this.devider = view.findViewById(d.h.recommend_devider);
        this.eNB.setOnClickListener(this.amD);
        this.eND.setOnClickListener(this.amD);
        this.eNw.setOnClickListener(this.amD);
    }

    public void a(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null) {
            this.eNE = auVar;
            this.eNv.setText(auVar.Yh);
            this.eNw.setText(auVar.Yi);
            this.eNC.c(auVar.Ym, 10, false);
            this.eNx.c(auVar.Wj, 10, false);
            this.eNB.setText(auVar.Yl);
            this.eNy.setText(auVar.Wi);
            List<String> list = auVar.Yk;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eNz.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eNz.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eNA.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ai.c(this.eNv, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.eNw, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ai.c(this.eNy, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ai.c(this.eNz, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.eNA, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.eNB, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ai.k(this.devider, d.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.ai.j(this.eNB, d.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11441").aa("obj_id", this.eNE.bookId));
        }
    }
}
