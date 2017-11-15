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
    public TextView eQT;
    public TextView eQU;
    public TbImageView eQV;
    public TextView eQW;
    public TextView eQX;
    public TextView eQY;
    public TextView eQZ;
    public TbImageView eRa;
    public LinearLayout eRb;
    private com.baidu.tbadk.core.data.as eRc;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.alC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(af.this.abI.getPageActivity()) && com.baidu.adp.lib.util.l.hy() && af.this.eRc != null && !StringUtils.isNull(af.this.eRc.VJ)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(af.this.abI.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == af.this.eQZ) {
                        String str = af.this.eRc.VJ;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(af.this.abI.getPageActivity());
                        aoVar.VJ = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", af.this.eRc.VJ).ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == af.this.eRb) {
                        af.this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(af.this.abI.getPageActivity(), af.this.eRc.VJ)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", af.this.eRc.VJ).ac("obj_locate", "1"));
                    } else if (view2 == af.this.eQU && !StringUtils.isNull(af.this.eRc.XB)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(af.this.abI.getPageActivity()), new String[]{af.this.eRc.XB});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ac("obj_id", af.this.eRc.VJ).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.abI = tbPageContext;
        this.eQT = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.eQU = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.eQV = (TbImageView) view.findViewById(d.g.novel_cover);
        this.eQW = (TextView) view.findViewById(d.g.novel_title);
        this.eQX = (TextView) view.findViewById(d.g.novel_author);
        this.eQY = (TextView) view.findViewById(d.g.novel_read_number);
        this.eQZ = (TextView) view.findViewById(d.g.novel_read_btn);
        this.eRb = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.eRa = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.eRa.setDefaultResource(d.f.transparent_bg);
        this.eRa.setDefaultBgResource(d.f.transparent_bg);
        this.eRa.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.eQZ.setOnClickListener(this.alC);
        this.eRb.setOnClickListener(this.alC);
        this.eQU.setOnClickListener(this.alC);
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null) {
            this.eRc = asVar;
            this.eQT.setText(asVar.Xz);
            this.eQU.setText(asVar.XA);
            this.eRa.startLoad(asVar.XE, 10, false);
            this.eQV.startLoad(asVar.VL, 10, false);
            this.eQZ.setText(asVar.XD);
            this.eQW.setText(asVar.VK);
            List<String> list = asVar.XC;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eQX.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eQX.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eQY.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.eQT, d.C0080d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQU, d.C0080d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQW, d.C0080d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQX, d.C0080d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQY, d.C0080d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eQZ, d.C0080d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.C0080d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.eQZ, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ac("obj_id", this.eRc.VJ));
        }
    }
}
