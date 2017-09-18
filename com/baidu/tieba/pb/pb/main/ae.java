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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends j.a {
    private TbPageContext aby;
    View.OnClickListener alW;
    public View devider;
    public TextView eOq;
    public TextView eOr;
    public TbImageView eOs;
    public TextView eOt;
    public TextView eOu;
    public TextView eOv;
    public TextView eOw;
    public TbImageView eOx;
    public LinearLayout eOy;
    private au eOz;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.alW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aU(ae.this.aby.getPageActivity()) && com.baidu.adp.lib.util.k.hz() && ae.this.eOz != null && !StringUtils.isNull(ae.this.eOz.Vp)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.k.showToast(ae.this.aby.getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else if (view2 == ae.this.eOw) {
                        String str = ae.this.eOz.Vp;
                        com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                        aqVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(ae.this.aby.getPageActivity());
                        aqVar.Vp = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ad("obj_locate", "0").ad("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ae.this.eOz.Vp).ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == ae.this.eOy) {
                        ae.this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ae.this.aby.getPageActivity(), ae.this.eOz.Vp)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ae.this.eOz.Vp).ad("obj_locate", "1"));
                    } else if (view2 == ae.this.eOr && !StringUtils.isNull(ae.this.eOz.Xu)) {
                        com.baidu.tbadk.core.util.au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.aby.getPageActivity()), new String[]{ae.this.eOz.Xu});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ae.this.eOz.Vp).ad("obj_locate", "2"));
                    }
                }
            }
        };
        this.aby = tbPageContext;
        this.eOq = (TextView) view.findViewById(d.h.textview_recommend_title);
        this.eOr = (TextView) view.findViewById(d.h.textview_recommend_option_btn);
        this.eOs = (TbImageView) view.findViewById(d.h.novel_cover);
        this.eOt = (TextView) view.findViewById(d.h.novel_title);
        this.eOu = (TextView) view.findViewById(d.h.novel_author);
        this.eOv = (TextView) view.findViewById(d.h.novel_read_number);
        this.eOw = (TextView) view.findViewById(d.h.novel_read_btn);
        this.eOy = (LinearLayout) view.findViewById(d.h.novel_recommend_item_layout);
        this.eOx = (TbImageView) view.findViewById(d.h.novel_subscription);
        this.eOx.setDefaultResource(d.g.transparent_bg);
        this.eOx.setDefaultBgResource(d.g.transparent_bg);
        this.eOx.setDefaultErrorResource(d.g.transparent_bg);
        this.devider = view.findViewById(d.h.recommend_devider);
        this.eOw.setOnClickListener(this.alW);
        this.eOy.setOnClickListener(this.alW);
        this.eOr.setOnClickListener(this.alW);
    }

    public void a(au auVar) {
        if (auVar != null) {
            this.eOz = auVar;
            this.eOq.setText(auVar.Xs);
            this.eOr.setText(auVar.Xt);
            this.eOx.c(auVar.Xx, 10, false);
            this.eOs.c(auVar.Vr, 10, false);
            this.eOw.setText(auVar.Xw);
            this.eOt.setText(auVar.Vq);
            List<String> list = auVar.Xv;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eOu.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eOu.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eOv.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.eOq, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eOr, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.eOt, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.eOu, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eOv, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eOw, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.eOw, d.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ad("obj_id", this.eOz.Vp));
        }
    }
}
