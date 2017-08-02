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
    private TbPageContext aaS;
    View.OnClickListener alj;
    public View devider;
    public TextView eMi;
    public TextView eMj;
    public TbImageView eMk;
    public TextView eMl;
    public TextView eMm;
    public TextView eMn;
    public TextView eMo;
    public TbImageView eMp;
    public LinearLayout eMq;
    private com.baidu.tbadk.core.data.au eMr;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.alj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aN(ah.this.aaS.getPageActivity()) && com.baidu.adp.lib.util.k.hy() && ah.this.eMr != null && !StringUtils.isNull(ah.this.eMr.bookId)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.k.showToast(ah.this.aaS.getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.eMo) {
                        String str = ah.this.eMr.bookId;
                        com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                        aqVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Z(ah.this.aaS.getPageActivity());
                        aqVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aa("obj_locate", "0").aa("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.eMr.bookId).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == ah.this.eMq) {
                        ah.this.aaS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ah.this.aaS.getPageActivity(), ah.this.eMr.bookId)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.eMr.bookId).aa("obj_locate", "1"));
                    } else if (view2 == ah.this.eMj && !StringUtils.isNull(ah.this.eMr.WN)) {
                        com.baidu.tbadk.core.util.at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(ah.this.aaS.getPageActivity()), new String[]{ah.this.eMr.WN});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.eMr.bookId).aa("obj_locate", "2"));
                    }
                }
            }
        };
        this.aaS = tbPageContext;
        this.eMi = (TextView) view.findViewById(d.h.textview_recommend_title);
        this.eMj = (TextView) view.findViewById(d.h.textview_recommend_option_btn);
        this.eMk = (TbImageView) view.findViewById(d.h.novel_cover);
        this.eMl = (TextView) view.findViewById(d.h.novel_title);
        this.eMm = (TextView) view.findViewById(d.h.novel_author);
        this.eMn = (TextView) view.findViewById(d.h.novel_read_number);
        this.eMo = (TextView) view.findViewById(d.h.novel_read_btn);
        this.eMq = (LinearLayout) view.findViewById(d.h.novel_recommend_item_layout);
        this.eMp = (TbImageView) view.findViewById(d.h.novel_subscription);
        this.eMp.setDefaultResource(d.g.transparent_bg);
        this.eMp.setDefaultBgResource(d.g.transparent_bg);
        this.eMp.setDefaultErrorResource(d.g.transparent_bg);
        this.devider = view.findViewById(d.h.recommend_devider);
        this.eMo.setOnClickListener(this.alj);
        this.eMq.setOnClickListener(this.alj);
        this.eMj.setOnClickListener(this.alj);
    }

    public void a(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null) {
            this.eMr = auVar;
            this.eMi.setText(auVar.WL);
            this.eMj.setText(auVar.WM);
            this.eMp.c(auVar.WQ, 10, false);
            this.eMk.c(auVar.UM, 10, false);
            this.eMo.setText(auVar.WP);
            this.eMl.setText(auVar.UL);
            List<String> list = auVar.WO;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eMm.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eMm.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eMn.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ai.c(this.eMi, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.eMj, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ai.c(this.eMl, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ai.c(this.eMm, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.eMn, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.eMo, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ai.k(this.devider, d.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.ai.j(this.eMo, d.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11441").aa("obj_id", this.eMr.bookId));
        }
    }
}
