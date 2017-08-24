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
    private TbPageContext acr;
    View.OnClickListener amE;
    public View devider;
    private com.baidu.tbadk.core.data.au ePA;
    public TextView ePr;
    public TextView ePs;
    public TbImageView ePt;
    public TextView ePu;
    public TextView ePv;
    public TextView ePw;
    public TextView ePx;
    public TbImageView ePy;
    public LinearLayout ePz;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.amE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(ah.this.acr.getPageActivity()) && com.baidu.adp.lib.util.k.hI() && ah.this.ePA != null && !StringUtils.isNull(ah.this.ePA.bookId)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.k.showToast(ah.this.acr.getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.ePx) {
                        String str = ah.this.ePA.bookId;
                        com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                        aqVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aa(ah.this.acr.getPageActivity());
                        aqVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aa("obj_locate", "0").aa("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.ePA.bookId).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == ah.this.ePz) {
                        ah.this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ah.this.acr.getPageActivity(), ah.this.ePA.bookId)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.ePA.bookId).aa("obj_locate", "1"));
                    } else if (view2 == ah.this.ePs && !StringUtils.isNull(ah.this.ePA.Ym)) {
                        com.baidu.tbadk.core.util.at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(ah.this.acr.getPageActivity()), new String[]{ah.this.ePA.Ym});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11442").aa("obj_id", ah.this.ePA.bookId).aa("obj_locate", "2"));
                    }
                }
            }
        };
        this.acr = tbPageContext;
        this.ePr = (TextView) view.findViewById(d.h.textview_recommend_title);
        this.ePs = (TextView) view.findViewById(d.h.textview_recommend_option_btn);
        this.ePt = (TbImageView) view.findViewById(d.h.novel_cover);
        this.ePu = (TextView) view.findViewById(d.h.novel_title);
        this.ePv = (TextView) view.findViewById(d.h.novel_author);
        this.ePw = (TextView) view.findViewById(d.h.novel_read_number);
        this.ePx = (TextView) view.findViewById(d.h.novel_read_btn);
        this.ePz = (LinearLayout) view.findViewById(d.h.novel_recommend_item_layout);
        this.ePy = (TbImageView) view.findViewById(d.h.novel_subscription);
        this.ePy.setDefaultResource(d.g.transparent_bg);
        this.ePy.setDefaultBgResource(d.g.transparent_bg);
        this.ePy.setDefaultErrorResource(d.g.transparent_bg);
        this.devider = view.findViewById(d.h.recommend_devider);
        this.ePx.setOnClickListener(this.amE);
        this.ePz.setOnClickListener(this.amE);
        this.ePs.setOnClickListener(this.amE);
    }

    public void a(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null) {
            this.ePA = auVar;
            this.ePr.setText(auVar.Yk);
            this.ePs.setText(auVar.Yl);
            this.ePy.c(auVar.Yp, 10, false);
            this.ePt.c(auVar.Wm, 10, false);
            this.ePx.setText(auVar.Yo);
            this.ePu.setText(auVar.Wl);
            List<String> list = auVar.Yn;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.ePv.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.ePv.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.ePw.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ai.c(this.ePr, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.ePs, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ai.c(this.ePu, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ai.c(this.ePv, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.ePw, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ai.c(this.ePx, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ai.k(this.devider, d.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.ai.j(this.ePx, d.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11441").aa("obj_id", this.ePA.bookId));
        }
    }
}
