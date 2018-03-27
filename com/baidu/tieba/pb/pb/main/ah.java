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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ah extends r.a {
    private TbPageContext aRI;
    View.OnClickListener bbO;
    public View devider;
    public TextView fSH;
    public TextView fSI;
    public TbImageView fSJ;
    public TextView fSK;
    public TextView fSL;
    public TextView fSM;
    public TextView fSN;
    public TbImageView fSO;
    public LinearLayout fSP;
    private com.baidu.tbadk.core.data.ao fSQ;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.bbO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(ah.this.aRI.getPageActivity()) && com.baidu.adp.lib.util.l.pa() && ah.this.fSQ != null && !StringUtils.isNull(ah.this.fSQ.aLL)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.aRI.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.fSN) {
                        String str = ah.this.fSQ.aLL;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ak(ah.this.aRI.getPageActivity());
                        akVar.aLL = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ab("obj_locate", "0").ab("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSQ.aLL).ab("obj_locate", "3"));
                    } else if (view2 == ah.this.fSP) {
                        ah.this.aRI.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ah.this.aRI.getPageActivity(), ah.this.fSQ.aLL)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSQ.aLL).ab("obj_locate", "1"));
                    } else if (view2 == ah.this.fSI && !StringUtils.isNull(ah.this.fSQ.aNw)) {
                        com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ah.this.aRI.getPageActivity()), new String[]{ah.this.fSQ.aNw});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSQ.aLL).ab("obj_locate", "2"));
                    }
                }
            }
        };
        this.aRI = tbPageContext;
        this.fSH = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fSI = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fSJ = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fSK = (TextView) view.findViewById(d.g.novel_title);
        this.fSL = (TextView) view.findViewById(d.g.novel_author);
        this.fSM = (TextView) view.findViewById(d.g.novel_read_number);
        this.fSN = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fSP = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fSO = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fSO.setDefaultResource(d.f.transparent_bg);
        this.fSO.setDefaultBgResource(d.f.transparent_bg);
        this.fSO.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fSN.setOnClickListener(this.bbO);
        this.fSP.setOnClickListener(this.bbO);
        this.fSI.setOnClickListener(this.bbO);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fSQ = aoVar;
            this.fSH.setText(aoVar.aNu);
            this.fSI.setText(aoVar.aNv);
            this.fSO.startLoad(aoVar.aNz, 10, false);
            this.fSJ.startLoad(aoVar.aLN, 10, false);
            this.fSN.setText(aoVar.aNy);
            this.fSK.setText(aoVar.aLM);
            List<String> list = aoVar.aNx;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fSL.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fSL.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fSM.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.e(this.fSH, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSI, d.C0141d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSK, d.C0141d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSL, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSM, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSN, d.C0141d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.t(this.devider, d.C0141d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.s(this.fSN, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ab("obj_id", this.fSQ.aLL));
        }
    }
}
