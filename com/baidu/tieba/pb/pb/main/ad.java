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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends j.a {
    private TbPageContext abm;
    View.OnClickListener alf;
    public View devider;
    public TextView eHP;
    public TextView eHQ;
    public TbImageView eHR;
    public TextView eHS;
    public TextView eHT;
    public TextView eHU;
    public TextView eHV;
    public TbImageView eHW;
    public LinearLayout eHX;
    private as eHY;

    public ad(TbPageContext tbPageContext, View view) {
        super(view);
        this.alf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(ad.this.abm.getPageActivity()) && com.baidu.adp.lib.util.l.hy() && ad.this.eHY != null && !StringUtils.isNull(ad.this.eHY.Vr)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ad.this.abm.getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else if (view2 == ad.this.eHV) {
                        String str = ad.this.eHY.Vr;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(ad.this.abm.getPageActivity());
                        aoVar.Vr = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ad.this.eHY.Vr).ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == ad.this.eHX) {
                        ad.this.abm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ad.this.abm.getPageActivity(), ad.this.eHY.Vr)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ad.this.eHY.Vr).ac("obj_locate", "1"));
                    } else if (view2 == ad.this.eHQ && !StringUtils.isNull(ad.this.eHY.Xj)) {
                        av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(ad.this.abm.getPageActivity()), new String[]{ad.this.eHY.Xj});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", ad.this.eHY.Vr).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.abm = tbPageContext;
        this.eHP = (TextView) view.findViewById(d.h.textview_recommend_title);
        this.eHQ = (TextView) view.findViewById(d.h.textview_recommend_option_btn);
        this.eHR = (TbImageView) view.findViewById(d.h.novel_cover);
        this.eHS = (TextView) view.findViewById(d.h.novel_title);
        this.eHT = (TextView) view.findViewById(d.h.novel_author);
        this.eHU = (TextView) view.findViewById(d.h.novel_read_number);
        this.eHV = (TextView) view.findViewById(d.h.novel_read_btn);
        this.eHX = (LinearLayout) view.findViewById(d.h.novel_recommend_item_layout);
        this.eHW = (TbImageView) view.findViewById(d.h.novel_subscription);
        this.eHW.setDefaultResource(d.g.transparent_bg);
        this.eHW.setDefaultBgResource(d.g.transparent_bg);
        this.eHW.setDefaultErrorResource(d.g.transparent_bg);
        this.devider = view.findViewById(d.h.recommend_devider);
        this.eHV.setOnClickListener(this.alf);
        this.eHX.setOnClickListener(this.alf);
        this.eHQ.setOnClickListener(this.alf);
    }

    public void a(as asVar) {
        if (asVar != null) {
            this.eHY = asVar;
            this.eHP.setText(asVar.Xh);
            this.eHQ.setText(asVar.Xi);
            this.eHW.c(asVar.Xm, 10, false);
            this.eHR.c(asVar.Vt, 10, false);
            this.eHV.setText(asVar.Xl);
            this.eHS.setText(asVar.Vs);
            List<String> list = asVar.Xk;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eHT.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eHT.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eHU.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.eHP, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eHQ, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.eHS, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.eHT, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eHU, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eHV, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.eHV, d.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ac("obj_id", this.eHY.Vr));
        }
    }
}
