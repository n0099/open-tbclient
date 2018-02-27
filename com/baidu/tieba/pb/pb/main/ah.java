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
    private TbPageContext aRG;
    View.OnClickListener bbM;
    public View devider;
    private com.baidu.tbadk.core.data.ao fSA;
    public TextView fSr;
    public TextView fSs;
    public TbImageView fSt;
    public TextView fSu;
    public TextView fSv;
    public TextView fSw;
    public TextView fSx;
    public TbImageView fSy;
    public LinearLayout fSz;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.bbM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(ah.this.aRG.getPageActivity()) && com.baidu.adp.lib.util.l.pa() && ah.this.fSA != null && !StringUtils.isNull(ah.this.fSA.aLK)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.aRG.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.fSx) {
                        String str = ah.this.fSA.aLK;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ak(ah.this.aRG.getPageActivity());
                        akVar.aLK = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ab("obj_locate", "0").ab("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSA.aLK).ab("obj_locate", "3"));
                    } else if (view2 == ah.this.fSz) {
                        ah.this.aRG.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ah.this.aRG.getPageActivity(), ah.this.fSA.aLK)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSA.aLK).ab("obj_locate", "1"));
                    } else if (view2 == ah.this.fSs && !StringUtils.isNull(ah.this.fSA.aNv)) {
                        com.baidu.tbadk.core.util.aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(ah.this.aRG.getPageActivity()), new String[]{ah.this.fSA.aNv});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11442").ab("obj_id", ah.this.fSA.aLK).ab("obj_locate", "2"));
                    }
                }
            }
        };
        this.aRG = tbPageContext;
        this.fSr = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fSs = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fSt = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fSu = (TextView) view.findViewById(d.g.novel_title);
        this.fSv = (TextView) view.findViewById(d.g.novel_author);
        this.fSw = (TextView) view.findViewById(d.g.novel_read_number);
        this.fSx = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fSz = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fSy = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fSy.setDefaultResource(d.f.transparent_bg);
        this.fSy.setDefaultBgResource(d.f.transparent_bg);
        this.fSy.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fSx.setOnClickListener(this.bbM);
        this.fSz.setOnClickListener(this.bbM);
        this.fSs.setOnClickListener(this.bbM);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fSA = aoVar;
            this.fSr.setText(aoVar.aNt);
            this.fSs.setText(aoVar.aNu);
            this.fSy.startLoad(aoVar.aNy, 10, false);
            this.fSt.startLoad(aoVar.aLM, 10, false);
            this.fSx.setText(aoVar.aNx);
            this.fSu.setText(aoVar.aLL);
            List<String> list = aoVar.aNw;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fSv.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fSv.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fSw.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.aj.e(this.fSr, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSs, d.C0141d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSu, d.C0141d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSv, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSw, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aj.e(this.fSx, d.C0141d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.aj.t(this.devider, d.C0141d.cp_bg_line_b);
            com.baidu.tbadk.core.util.aj.s(this.fSx, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11441").ab("obj_id", this.fSA.aLK));
        }
    }
}
