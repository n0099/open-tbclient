package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ah extends q.a {
    private TbPageContext adf;
    View.OnClickListener ani;
    public View devider;
    public TextView fmD;
    public TextView fmE;
    public TbImageView fmF;
    public TextView fmG;
    public TextView fmH;
    public TextView fmI;
    public TextView fmJ;
    public TbImageView fmK;
    public LinearLayout fmL;
    private com.baidu.tbadk.core.data.ap fmM;

    public ah(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.ani = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(ah.this.adf.getPageActivity()) && com.baidu.adp.lib.util.l.hg() && ah.this.fmM != null && !StringUtils.isNull(ah.this.fmM.Xg)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.adf.getPageActivity(), d.k.book_plugin_not_install_tip);
                    } else if (view3 == ah.this.fmJ) {
                        String str = ah.this.fmM.Xg;
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        alVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ah.this.adf.getPageActivity());
                        alVar.Xg = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fmM.Xg).ac("obj_locate", "3"));
                    } else if (view3 == ah.this.fmL) {
                        ah.this.adf.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ah.this.adf.getPageActivity(), ah.this.fmM.Xg)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fmM.Xg).ac("obj_locate", "1"));
                    } else if (view3 == ah.this.fmE && !StringUtils.isNull(ah.this.fmM.YX)) {
                        com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ah.this.adf.getPageActivity()), new String[]{ah.this.fmM.YX});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fmM.Xg).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.fmD = (TextView) view2.findViewById(d.g.textview_recommend_title);
        this.fmE = (TextView) view2.findViewById(d.g.textview_recommend_option_btn);
        this.fmF = (TbImageView) view2.findViewById(d.g.novel_cover);
        this.fmG = (TextView) view2.findViewById(d.g.novel_title);
        this.fmH = (TextView) view2.findViewById(d.g.novel_author);
        this.fmI = (TextView) view2.findViewById(d.g.novel_read_number);
        this.fmJ = (TextView) view2.findViewById(d.g.novel_read_btn);
        this.fmL = (LinearLayout) view2.findViewById(d.g.novel_recommend_item_layout);
        this.fmK = (TbImageView) view2.findViewById(d.g.novel_subscription);
        this.fmK.setDefaultResource(d.f.transparent_bg);
        this.fmK.setDefaultBgResource(d.f.transparent_bg);
        this.fmK.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view2.findViewById(d.g.recommend_devider);
        this.fmJ.setOnClickListener(this.ani);
        this.fmL.setOnClickListener(this.ani);
        this.fmE.setOnClickListener(this.ani);
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null) {
            this.fmM = apVar;
            this.fmD.setText(apVar.YV);
            this.fmE.setText(apVar.YW);
            this.fmK.startLoad(apVar.Za, 10, false);
            this.fmF.startLoad(apVar.Xi, 10, false);
            this.fmJ.setText(apVar.YZ);
            this.fmG.setText(apVar.Xh);
            List<String> list = apVar.YY;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fmH.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fmH.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fmI.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ak.c(this.fmD, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmE, d.C0126d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmG, d.C0126d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmH, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmI, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmJ, d.C0126d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ak.j(this.devider, d.C0126d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ak.i(this.fmJ, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11441").ac(VideoPlayActivityConfig.OBJ_ID, this.fmM.Xg));
        }
    }
}
