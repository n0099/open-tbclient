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
    private TbPageContext abz;
    View.OnClickListener als;
    public View devider;
    public TextView eId;
    public TextView eIe;
    public TbImageView eIf;
    public TextView eIg;
    public TextView eIh;
    public TextView eIi;
    public TextView eIj;
    public TbImageView eIk;
    public LinearLayout eIl;
    private as eIm;

    public ad(TbPageContext tbPageContext, View view) {
        super(view);
        this.als = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aU(ad.this.abz.getPageActivity()) && com.baidu.adp.lib.util.l.hy() && ad.this.eIm != null && !StringUtils.isNull(ad.this.eIm.VD)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ad.this.abz.getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else if (view2 == ad.this.eIj) {
                        String str = ad.this.eIm.VD;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.Y(ad.this.abz.getPageActivity());
                        aoVar.VD = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ad("obj_locate", "0").ad("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ad.this.eIm.VD).ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view2 == ad.this.eIl) {
                        ad.this.abz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ad.this.abz.getPageActivity(), ad.this.eIm.VD)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ad.this.eIm.VD).ad("obj_locate", "1"));
                    } else if (view2 == ad.this.eIe && !StringUtils.isNull(ad.this.eIm.Xv)) {
                        av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(ad.this.abz.getPageActivity()), new String[]{ad.this.eIm.Xv});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ad("obj_id", ad.this.eIm.VD).ad("obj_locate", "2"));
                    }
                }
            }
        };
        this.abz = tbPageContext;
        this.eId = (TextView) view.findViewById(d.h.textview_recommend_title);
        this.eIe = (TextView) view.findViewById(d.h.textview_recommend_option_btn);
        this.eIf = (TbImageView) view.findViewById(d.h.novel_cover);
        this.eIg = (TextView) view.findViewById(d.h.novel_title);
        this.eIh = (TextView) view.findViewById(d.h.novel_author);
        this.eIi = (TextView) view.findViewById(d.h.novel_read_number);
        this.eIj = (TextView) view.findViewById(d.h.novel_read_btn);
        this.eIl = (LinearLayout) view.findViewById(d.h.novel_recommend_item_layout);
        this.eIk = (TbImageView) view.findViewById(d.h.novel_subscription);
        this.eIk.setDefaultResource(d.g.transparent_bg);
        this.eIk.setDefaultBgResource(d.g.transparent_bg);
        this.eIk.setDefaultErrorResource(d.g.transparent_bg);
        this.devider = view.findViewById(d.h.recommend_devider);
        this.eIj.setOnClickListener(this.als);
        this.eIl.setOnClickListener(this.als);
        this.eIe.setOnClickListener(this.als);
    }

    public void a(as asVar) {
        if (asVar != null) {
            this.eIm = asVar;
            this.eId.setText(asVar.Xt);
            this.eIe.setText(asVar.Xu);
            this.eIk.c(asVar.Xy, 10, false);
            this.eIf.c(asVar.VF, 10, false);
            this.eIj.setText(asVar.Xx);
            this.eIg.setText(asVar.VE);
            List<String> list = asVar.Xw;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.eIh.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.eIh.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.eIi.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.c(this.eId, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eIe, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.c(this.eIg, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.c(this.eIh, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eIi, d.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.c(this.eIj, d.e.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.k(this.devider, d.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.j(this.eIj, d.g.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ad("obj_id", this.eIm.VD));
        }
    }
}
