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
    public TextView fmG;
    public TextView fmH;
    public TbImageView fmI;
    public TextView fmJ;
    public TextView fmK;
    public TextView fmL;
    public TextView fmM;
    public TbImageView fmN;
    public LinearLayout fmO;
    private com.baidu.tbadk.core.data.ap fmP;

    public ah(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.ani = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(ah.this.adf.getPageActivity()) && com.baidu.adp.lib.util.l.hg() && ah.this.fmP != null && !StringUtils.isNull(ah.this.fmP.Xg)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.adf.getPageActivity(), d.k.book_plugin_not_install_tip);
                    } else if (view3 == ah.this.fmM) {
                        String str = ah.this.fmP.Xg;
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        alVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ah.this.adf.getPageActivity());
                        alVar.Xg = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fmP.Xg).ac("obj_locate", "3"));
                    } else if (view3 == ah.this.fmO) {
                        ah.this.adf.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ah.this.adf.getPageActivity(), ah.this.fmP.Xg)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fmP.Xg).ac("obj_locate", "1"));
                    } else if (view3 == ah.this.fmH && !StringUtils.isNull(ah.this.fmP.YX)) {
                        com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ah.this.adf.getPageActivity()), new String[]{ah.this.fmP.YX});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fmP.Xg).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.fmG = (TextView) view2.findViewById(d.g.textview_recommend_title);
        this.fmH = (TextView) view2.findViewById(d.g.textview_recommend_option_btn);
        this.fmI = (TbImageView) view2.findViewById(d.g.novel_cover);
        this.fmJ = (TextView) view2.findViewById(d.g.novel_title);
        this.fmK = (TextView) view2.findViewById(d.g.novel_author);
        this.fmL = (TextView) view2.findViewById(d.g.novel_read_number);
        this.fmM = (TextView) view2.findViewById(d.g.novel_read_btn);
        this.fmO = (LinearLayout) view2.findViewById(d.g.novel_recommend_item_layout);
        this.fmN = (TbImageView) view2.findViewById(d.g.novel_subscription);
        this.fmN.setDefaultResource(d.f.transparent_bg);
        this.fmN.setDefaultBgResource(d.f.transparent_bg);
        this.fmN.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view2.findViewById(d.g.recommend_devider);
        this.fmM.setOnClickListener(this.ani);
        this.fmO.setOnClickListener(this.ani);
        this.fmH.setOnClickListener(this.ani);
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null) {
            this.fmP = apVar;
            this.fmG.setText(apVar.YV);
            this.fmH.setText(apVar.YW);
            this.fmN.startLoad(apVar.Za, 10, false);
            this.fmI.startLoad(apVar.Xi, 10, false);
            this.fmM.setText(apVar.YZ);
            this.fmJ.setText(apVar.Xh);
            List<String> list = apVar.YY;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fmK.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fmK.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fmL.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ak.c(this.fmG, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmH, d.C0126d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmJ, d.C0126d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmK, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmL, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fmM, d.C0126d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ak.j(this.devider, d.C0126d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ak.i(this.fmM, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11441").ac(VideoPlayActivityConfig.OBJ_ID, this.fmP.Xg));
        }
    }
}
