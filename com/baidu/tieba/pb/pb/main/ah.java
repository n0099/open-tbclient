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
    private TbPageContext aca;
    View.OnClickListener alY;
    public View devider;
    public TextView faH;
    public TextView faI;
    public TbImageView faJ;
    public TextView faK;
    public TextView faL;
    public TextView faM;
    public TextView faN;
    public TbImageView faO;
    public LinearLayout faP;
    private com.baidu.tbadk.core.data.ao faQ;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.alY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aS(ah.this.aca.getPageActivity()) && com.baidu.adp.lib.util.l.hy() && ah.this.faQ != null && !StringUtils.isNull(ah.this.faQ.Wd)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.aca.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.faN) {
                        String str = ah.this.faQ.Wd;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(ah.this.aca.getPageActivity());
                        akVar.Wd = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.faQ.Wd).ac("obj_locate", "3"));
                    } else if (view2 == ah.this.faP) {
                        ah.this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ah.this.aca.getPageActivity(), ah.this.faQ.Wd)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.faQ.Wd).ac("obj_locate", "1"));
                    } else if (view2 == ah.this.faI && !StringUtils.isNull(ah.this.faQ.XQ)) {
                        com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ah.this.aca.getPageActivity()), new String[]{ah.this.faQ.XQ});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.faQ.Wd).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.aca = tbPageContext;
        this.faH = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.faI = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.faJ = (TbImageView) view.findViewById(d.g.novel_cover);
        this.faK = (TextView) view.findViewById(d.g.novel_title);
        this.faL = (TextView) view.findViewById(d.g.novel_author);
        this.faM = (TextView) view.findViewById(d.g.novel_read_number);
        this.faN = (TextView) view.findViewById(d.g.novel_read_btn);
        this.faP = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.faO = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.faO.setDefaultResource(d.f.transparent_bg);
        this.faO.setDefaultBgResource(d.f.transparent_bg);
        this.faO.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.faN.setOnClickListener(this.alY);
        this.faP.setOnClickListener(this.alY);
        this.faI.setOnClickListener(this.alY);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.faQ = aoVar;
            this.faH.setText(aoVar.XO);
            this.faI.setText(aoVar.XP);
            this.faO.startLoad(aoVar.XT, 10, false);
            this.faJ.startLoad(aoVar.Wf, 10, false);
            this.faN.setText(aoVar.XS);
            this.faK.setText(aoVar.We);
            List<String> list = aoVar.XR;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.faL.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.faL.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.faM.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.faH, d.C0095d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.faI, d.C0095d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.faK, d.C0095d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.faL, d.C0095d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.faM, d.C0095d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.faN, d.C0095d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.C0095d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.faN, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ac("obj_id", this.faQ.Wd));
        }
    }
}
