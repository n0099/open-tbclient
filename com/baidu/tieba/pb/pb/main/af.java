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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class af extends j.a {
    private TbPageContext abI;
    View.OnClickListener alC;
    public View devider;
    public TextView eQA;
    public TbImageView eQB;
    public TextView eQC;
    public TextView eQD;
    public TextView eQE;
    public TextView eQF;
    public TbImageView eQG;
    public LinearLayout eQH;
    private com.baidu.tbadk.core.data.as eQI;
    public TextView eQz;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.alC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(af.this.abI.getPageActivity()) && com.baidu.adp.lib.util.l.hy() && af.this.eQI != null && !StringUtils.isNull(af.this.eQI.VJ)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(af.this.abI.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == af.this.eQF) {
                        String str = af.this.eQI.VJ;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(af.this.abI.getPageActivity());
                        aoVar.VJ = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", af.this.eQI.VJ).ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == af.this.eQH) {
                        af.this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(af.this.abI.getPageActivity(), af.this.eQI.VJ)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", af.this.eQI.VJ).ac("obj_locate", "1"));
                    } else if (view2 == af.this.eQA && !StringUtils.isNull(af.this.eQI.XB)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(af.this.abI.getPageActivity()), new String[]{af.this.eQI.XB});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", af.this.eQI.VJ).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.abI = tbPageContext;
        this.eQz = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.eQA = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.eQB = (TbImageView) view.findViewById(d.g.novel_cover);
        this.eQC = (TextView) view.findViewById(d.g.novel_title);
        this.eQD = (TextView) view.findViewById(d.g.novel_author);
        this.eQE = (TextView) view.findViewById(d.g.novel_read_number);
        this.eQF = (TextView) view.findViewById(d.g.novel_read_btn);
        this.eQH = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.eQG = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.eQG.setDefaultResource(d.f.transparent_bg);
        this.eQG.setDefaultBgResource(d.f.transparent_bg);
        this.eQG.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.eQF.setOnClickListener(this.alC);
        this.eQH.setOnClickListener(this.alC);
        this.eQA.setOnClickListener(this.alC);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null) {
            this.eQI = asVar;
            this.eQz.setText(asVar.Xz);
            this.eQA.setText(asVar.XA);
            this.eQG.startLoad(asVar.XE, 10, false);
            this.eQB.startLoad(asVar.VL, 10, false);
            this.eQF.setText(asVar.XD);
            this.eQC.setText(asVar.VK);
            List<String> list = asVar.XC;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eQD.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eQD.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eQE.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.eQz, d.C0080d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQA, d.C0080d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQC, d.C0080d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQD, d.C0080d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQE, d.C0080d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQF, d.C0080d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.C0080d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.eQF, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ac("obj_id", this.eQI.VJ));
        }
    }
}
