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
    private TbPageContext aQs;
    View.OnClickListener baf;
    public View devider;
    public TextView fPA;
    public TbImageView fPB;
    public LinearLayout fPC;
    private com.baidu.tbadk.core.data.ao fPD;
    public TextView fPu;
    public TextView fPv;
    public TbImageView fPw;
    public TextView fPx;
    public TextView fPy;
    public TextView fPz;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.baf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.tbadk.core.util.ax.bb(ai.this.aQs.getPageActivity()) && com.baidu.adp.lib.util.l.pa() && ai.this.fPD != null && !StringUtils.isNull(ai.this.fPD.aKB)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.aQs.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fPA) {
                        String str = ai.this.fPD.aKB;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ak(ai.this.aQs.getPageActivity());
                        akVar.aKB = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aa("obj_locate", "0").aa("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").aa("obj_id", ai.this.fPD.aKB).aa("obj_locate", "3"));
                    } else if (view2 == ai.this.fPC) {
                        ai.this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ai.this.aQs.getPageActivity(), ai.this.fPD.aKB)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").aa("obj_id", ai.this.fPD.aKB).aa("obj_locate", "1"));
                    } else if (view2 == ai.this.fPv && !StringUtils.isNull(ai.this.fPD.aMn)) {
                        com.baidu.tbadk.core.util.av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(ai.this.aQs.getPageActivity()), new String[]{ai.this.fPD.aMn});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").aa("obj_id", ai.this.fPD.aKB).aa("obj_locate", "2"));
                    }
                }
            }
        };
        this.aQs = tbPageContext;
        this.fPu = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fPv = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fPw = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fPx = (TextView) view.findViewById(d.g.novel_title);
        this.fPy = (TextView) view.findViewById(d.g.novel_author);
        this.fPz = (TextView) view.findViewById(d.g.novel_read_number);
        this.fPA = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fPC = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fPB = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fPB.setDefaultResource(d.f.transparent_bg);
        this.fPB.setDefaultBgResource(d.f.transparent_bg);
        this.fPB.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fPA.setOnClickListener(this.baf);
        this.fPC.setOnClickListener(this.baf);
        this.fPv.setOnClickListener(this.baf);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fPD = aoVar;
            this.fPu.setText(aoVar.aMl);
            this.fPv.setText(aoVar.aMm);
            this.fPB.startLoad(aoVar.aMq, 10, false);
            this.fPw.startLoad(aoVar.aKD, 10, false);
            this.fPA.setText(aoVar.aMp);
            this.fPx.setText(aoVar.aKC);
            List<String> list = aoVar.aMo;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fPy.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fPy.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fPz.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.e(this.fPu, d.C0108d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPv, d.C0108d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPx, d.C0108d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPy, d.C0108d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPz, d.C0108d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPA, d.C0108d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.t(this.devider, d.C0108d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.s(this.fPA, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").aa("obj_id", this.fPD.aKB));
        }
    }
}
