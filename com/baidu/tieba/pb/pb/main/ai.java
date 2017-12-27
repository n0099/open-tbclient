package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ai extends r.a {
    private TbPageContext aQq;
    View.OnClickListener aZY;
    public View devider;
    public TextView fNA;
    public TbImageView fNB;
    public TextView fNC;
    public TextView fND;
    public TextView fNE;
    public TextView fNF;
    public TbImageView fNG;
    public LinearLayout fNH;
    private com.baidu.tbadk.core.data.ap fNI;
    public TextView fNz;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.aZY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.tbadk.core.util.ax.be(ai.this.aQq.getPageActivity()) && com.baidu.adp.lib.util.l.oZ() && ai.this.fNI != null && !StringUtils.isNull(ai.this.fNI.aKA)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.aQq.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fNF) {
                        String str = ai.this.fNI.aKA;
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        alVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ak(ai.this.aQq.getPageActivity());
                        alVar.aKA = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, alVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ab("obj_locate", "0").ab("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ai.this.fNI.aKA).ab("obj_locate", "3"));
                    } else if (view2 == ai.this.fNH) {
                        ai.this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ai.this.aQq.getPageActivity(), ai.this.fNI.aKA)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ai.this.fNI.aKA).ab("obj_locate", "1"));
                    } else if (view2 == ai.this.fNA && !StringUtils.isNull(ai.this.fNI.aMo)) {
                        com.baidu.tbadk.core.util.av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(ai.this.aQq.getPageActivity()), new String[]{ai.this.fNI.aMo});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ai.this.fNI.aKA).ab("obj_locate", "2"));
                    }
                }
            }
        };
        this.aQq = tbPageContext;
        this.fNz = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fNA = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fNB = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fNC = (TextView) view.findViewById(d.g.novel_title);
        this.fND = (TextView) view.findViewById(d.g.novel_author);
        this.fNE = (TextView) view.findViewById(d.g.novel_read_number);
        this.fNF = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fNH = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fNG = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fNG.setDefaultResource(d.f.transparent_bg);
        this.fNG.setDefaultBgResource(d.f.transparent_bg);
        this.fNG.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fNF.setOnClickListener(this.aZY);
        this.fNH.setOnClickListener(this.aZY);
        this.fNA.setOnClickListener(this.aZY);
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null) {
            this.fNI = apVar;
            this.fNz.setText(apVar.aMm);
            this.fNA.setText(apVar.aMn);
            this.fNG.startLoad(apVar.aMr, 10, false);
            this.fNB.startLoad(apVar.aKC, 10, false);
            this.fNF.setText(apVar.aMq);
            this.fNC.setText(apVar.aKB);
            List<String> list = apVar.aMp;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fND.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fND.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fNE.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.e(this.fNz, d.C0108d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fNA, d.C0108d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.e(this.fNC, d.C0108d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.e(this.fND, d.C0108d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fNE, d.C0108d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fNF, d.C0108d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.t(this.devider, d.C0108d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.s(this.fNF, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ab("obj_id", this.fNI.aKA));
        }
    }
}
