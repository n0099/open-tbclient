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
    private TbPageContext aQp;
    View.OnClickListener aZX;
    public View devider;
    public TextView fOZ;
    public TextView fPa;
    public TbImageView fPb;
    public TextView fPc;
    public TextView fPd;
    public TextView fPe;
    public TextView fPf;
    public TbImageView fPg;
    public LinearLayout fPh;
    private com.baidu.tbadk.core.data.ao fPi;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.aZX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.tbadk.core.util.ax.be(ai.this.aQp.getPageActivity()) && com.baidu.adp.lib.util.l.oZ() && ai.this.fPi != null && !StringUtils.isNull(ai.this.fPi.aKy)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.aQp.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fPf) {
                        String str = ai.this.fPi.aKy;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ak(ai.this.aQp.getPageActivity());
                        akVar.aKy = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ab("obj_locate", "0").ab("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ai.this.fPi.aKy).ab("obj_locate", "3"));
                    } else if (view2 == ai.this.fPh) {
                        ai.this.aQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ai.this.aQp.getPageActivity(), ai.this.fPi.aKy)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ai.this.fPi.aKy).ab("obj_locate", "1"));
                    } else if (view2 == ai.this.fPa && !StringUtils.isNull(ai.this.fPi.aMk)) {
                        com.baidu.tbadk.core.util.av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(ai.this.aQp.getPageActivity()), new String[]{ai.this.fPi.aMk});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ai.this.fPi.aKy).ab("obj_locate", "2"));
                    }
                }
            }
        };
        this.aQp = tbPageContext;
        this.fOZ = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fPa = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fPb = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fPc = (TextView) view.findViewById(d.g.novel_title);
        this.fPd = (TextView) view.findViewById(d.g.novel_author);
        this.fPe = (TextView) view.findViewById(d.g.novel_read_number);
        this.fPf = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fPh = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fPg = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fPg.setDefaultResource(d.f.transparent_bg);
        this.fPg.setDefaultBgResource(d.f.transparent_bg);
        this.fPg.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fPf.setOnClickListener(this.aZX);
        this.fPh.setOnClickListener(this.aZX);
        this.fPa.setOnClickListener(this.aZX);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fPi = aoVar;
            this.fOZ.setText(aoVar.aMi);
            this.fPa.setText(aoVar.aMj);
            this.fPg.startLoad(aoVar.aMn, 10, false);
            this.fPb.startLoad(aoVar.aKA, 10, false);
            this.fPf.setText(aoVar.aMm);
            this.fPc.setText(aoVar.aKz);
            List<String> list = aoVar.aMl;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fPd.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fPd.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fPe.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.e(this.fOZ, d.C0107d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPa, d.C0107d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPc, d.C0107d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPd, d.C0107d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPe, d.C0107d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fPf, d.C0107d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.t(this.devider, d.C0107d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.s(this.fPf, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ab("obj_id", this.fPi.aKy));
        }
    }
}
