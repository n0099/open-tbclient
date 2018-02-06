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
    private TbPageContext aRR;
    View.OnClickListener bbY;
    public View devider;
    public TextView fSC;
    public TextView fSD;
    public TbImageView fSE;
    public TextView fSF;
    public TextView fSG;
    public TextView fSH;
    public TextView fSI;
    public TbImageView fSJ;
    public LinearLayout fSK;
    private com.baidu.tbadk.core.data.ao fSL;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.bbY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(ah.this.aRR.getPageActivity()) && com.baidu.adp.lib.util.l.pa() && ah.this.fSL != null && !StringUtils.isNull(ah.this.fSL.aLV)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.aRR.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.fSI) {
                        String str = ah.this.fSL.aLV;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ak(ah.this.aRR.getPageActivity());
                        akVar.aLV = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ab("obj_locate", "0").ab("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSL.aLV).ab("obj_locate", "3"));
                    } else if (view2 == ah.this.fSK) {
                        ah.this.aRR.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ah.this.aRR.getPageActivity(), ah.this.fSL.aLV)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSL.aLV).ab("obj_locate", "1"));
                    } else if (view2 == ah.this.fSD && !StringUtils.isNull(ah.this.fSL.aNG)) {
                        com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ah.this.aRR.getPageActivity()), new String[]{ah.this.fSL.aNG});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSL.aLV).ab("obj_locate", "2"));
                    }
                }
            }
        };
        this.aRR = tbPageContext;
        this.fSC = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fSD = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fSE = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fSF = (TextView) view.findViewById(d.g.novel_title);
        this.fSG = (TextView) view.findViewById(d.g.novel_author);
        this.fSH = (TextView) view.findViewById(d.g.novel_read_number);
        this.fSI = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fSK = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fSJ = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fSJ.setDefaultResource(d.f.transparent_bg);
        this.fSJ.setDefaultBgResource(d.f.transparent_bg);
        this.fSJ.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fSI.setOnClickListener(this.bbY);
        this.fSK.setOnClickListener(this.bbY);
        this.fSD.setOnClickListener(this.bbY);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fSL = aoVar;
            this.fSC.setText(aoVar.aNE);
            this.fSD.setText(aoVar.aNF);
            this.fSJ.startLoad(aoVar.aNJ, 10, false);
            this.fSE.startLoad(aoVar.aLX, 10, false);
            this.fSI.setText(aoVar.aNI);
            this.fSF.setText(aoVar.aLW);
            List<String> list = aoVar.aNH;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fSG.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fSG.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fSH.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.e(this.fSC, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSD, d.C0140d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSF, d.C0140d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSG, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSH, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSI, d.C0140d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.t(this.devider, d.C0140d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.s(this.fSI, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ab("obj_id", this.fSL.aLV));
        }
    }
}
