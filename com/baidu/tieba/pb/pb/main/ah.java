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
    private TbPageContext abX;
    View.OnClickListener alV;
    public View devider;
    public TextView faC;
    public TextView faD;
    public TbImageView faE;
    public TextView faF;
    public TextView faG;
    public TextView faH;
    public TextView faI;
    public TbImageView faJ;
    public LinearLayout faK;
    private com.baidu.tbadk.core.data.ao faL;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.alV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aS(ah.this.abX.getPageActivity()) && com.baidu.adp.lib.util.l.hy() && ah.this.faL != null && !StringUtils.isNull(ah.this.faL.Wa)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.abX.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.faI) {
                        String str = ah.this.faL.Wa;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(ah.this.abX.getPageActivity());
                        akVar.Wa = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.faL.Wa).ac("obj_locate", "3"));
                    } else if (view2 == ah.this.faK) {
                        ah.this.abX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ah.this.abX.getPageActivity(), ah.this.faL.Wa)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.faL.Wa).ac("obj_locate", "1"));
                    } else if (view2 == ah.this.faD && !StringUtils.isNull(ah.this.faL.XN)) {
                        com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ah.this.abX.getPageActivity()), new String[]{ah.this.faL.XN});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ah.this.faL.Wa).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.abX = tbPageContext;
        this.faC = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.faD = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.faE = (TbImageView) view.findViewById(d.g.novel_cover);
        this.faF = (TextView) view.findViewById(d.g.novel_title);
        this.faG = (TextView) view.findViewById(d.g.novel_author);
        this.faH = (TextView) view.findViewById(d.g.novel_read_number);
        this.faI = (TextView) view.findViewById(d.g.novel_read_btn);
        this.faK = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.faJ = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.faJ.setDefaultResource(d.f.transparent_bg);
        this.faJ.setDefaultBgResource(d.f.transparent_bg);
        this.faJ.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.faI.setOnClickListener(this.alV);
        this.faK.setOnClickListener(this.alV);
        this.faD.setOnClickListener(this.alV);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.faL = aoVar;
            this.faC.setText(aoVar.XL);
            this.faD.setText(aoVar.XM);
            this.faJ.startLoad(aoVar.XQ, 10, false);
            this.faE.startLoad(aoVar.Wc, 10, false);
            this.faI.setText(aoVar.XP);
            this.faF.setText(aoVar.Wb);
            List<String> list = aoVar.XO;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.faG.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.faG.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.faH.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.faC, d.C0096d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.faD, d.C0096d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.faF, d.C0096d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.faG, d.C0096d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.faH, d.C0096d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.faI, d.C0096d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.C0096d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.faI, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ac("obj_id", this.faL.Wa));
        }
    }
}
