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
    View.OnClickListener ani;
    public View devider;
    public TextView fnK;
    public TextView fnL;
    public TbImageView fnM;
    public TextView fnN;
    public TextView fnO;
    public TextView fnP;
    public TextView fnQ;
    public TbImageView fnR;
    public LinearLayout fnS;
    private com.baidu.tbadk.core.data.ap fnT;
    private TbPageContext mContext;

    public ah(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.ani = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(ah.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.hg() && ah.this.fnT != null && !StringUtils.isNull(ah.this.fnT.Xh)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.mContext.getPageActivity(), d.k.book_plugin_not_install_tip);
                    } else if (view3 == ah.this.fnQ) {
                        String str = ah.this.fnT.Xh;
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        alVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ah.this.mContext.getPageActivity());
                        alVar.Xh = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ac("obj_locate", "0").ac("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fnT.Xh).ac("obj_locate", "3"));
                    } else if (view3 == ah.this.fnS) {
                        ah.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ah.this.mContext.getPageActivity(), ah.this.fnT.Xh)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fnT.Xh).ac("obj_locate", "1"));
                    } else if (view3 == ah.this.fnL && !StringUtils.isNull(ah.this.fnT.YX)) {
                        com.baidu.tbadk.core.util.ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(ah.this.mContext.getPageActivity()), new String[]{ah.this.fnT.YX});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11442").ac(VideoPlayActivityConfig.OBJ_ID, ah.this.fnT.Xh).ac("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fnK = (TextView) view2.findViewById(d.g.textview_recommend_title);
        this.fnL = (TextView) view2.findViewById(d.g.textview_recommend_option_btn);
        this.fnM = (TbImageView) view2.findViewById(d.g.novel_cover);
        this.fnN = (TextView) view2.findViewById(d.g.novel_title);
        this.fnO = (TextView) view2.findViewById(d.g.novel_author);
        this.fnP = (TextView) view2.findViewById(d.g.novel_read_number);
        this.fnQ = (TextView) view2.findViewById(d.g.novel_read_btn);
        this.fnS = (LinearLayout) view2.findViewById(d.g.novel_recommend_item_layout);
        this.fnR = (TbImageView) view2.findViewById(d.g.novel_subscription);
        this.fnR.setDefaultResource(d.f.transparent_bg);
        this.fnR.setDefaultBgResource(d.f.transparent_bg);
        this.fnR.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view2.findViewById(d.g.recommend_devider);
        this.fnQ.setOnClickListener(this.ani);
        this.fnS.setOnClickListener(this.ani);
        this.fnL.setOnClickListener(this.ani);
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null) {
            this.fnT = apVar;
            this.fnK.setText(apVar.YV);
            this.fnL.setText(apVar.YW);
            this.fnR.startLoad(apVar.Za, 10, false);
            this.fnM.startLoad(apVar.Xj, 10, false);
            this.fnQ.setText(apVar.YZ);
            this.fnN.setText(apVar.Xi);
            List<String> list = apVar.YY;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fnO.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fnO.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fnP.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ak.c(this.fnK, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fnL, d.C0126d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ak.c(this.fnN, d.C0126d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ak.c(this.fnO, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fnP, d.C0126d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ak.c(this.fnQ, d.C0126d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ak.j(this.devider, d.C0126d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ak.i(this.fnQ, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11441").ac(VideoPlayActivityConfig.OBJ_ID, this.fnT.Xh));
        }
    }
}
