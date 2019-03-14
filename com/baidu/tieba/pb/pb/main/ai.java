package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class ai extends v.a {
    View.OnClickListener bQK;
    public View devider;
    private a huJ;
    public TextView huL;
    public TextView huM;
    public TbImageView huN;
    public TextView huO;
    public TextView huP;
    public TextView huQ;
    public TextView huR;
    public TbImageView huS;
    public LinearLayout huT;
    private com.baidu.tbadk.core.data.aq huU;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bQK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo() && ai.this.huU != null && !StringUtils.isNull(ai.this.huU.bxV)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.huJ != null) {
                        ai.this.huJ.a(ai.this.huU);
                    }
                    if (view2 == ai.this.huR) {
                        String str = ai.this.huU.bxV;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        amVar.bxV = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bJ("obj_locate", "0").bJ("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huU.bxV).bJ("obj_locate", "3"));
                    } else if (view2 == ai.this.huT) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.huU.bxV)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huU.bxV).bJ("obj_locate", "1"));
                    } else if (view2 == ai.this.huM && !StringUtils.isNull(ai.this.huU.bzL)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.huU.bzL});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huU.bxV).bJ("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huJ = aVar;
        this.huL = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.huM = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.huN = (TbImageView) view.findViewById(d.g.novel_cover);
        this.huO = (TextView) view.findViewById(d.g.novel_title);
        this.huP = (TextView) view.findViewById(d.g.novel_author);
        this.huQ = (TextView) view.findViewById(d.g.novel_read_number);
        this.huR = (TextView) view.findViewById(d.g.novel_read_btn);
        this.huT = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.huS = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.huS.setDefaultResource(d.f.transparent_bg);
        this.huS.setDefaultBgResource(d.f.transparent_bg);
        this.huS.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.huR.setOnClickListener(this.bQK);
        this.huT.setOnClickListener(this.bQK);
        this.huM.setOnClickListener(this.bQK);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.huU = aqVar;
            this.huL.setText(aqVar.bzJ);
            this.huM.setText(aqVar.bzK);
            this.huS.startLoad(aqVar.bzO, 10, false);
            this.huN.startLoad(aqVar.bxX, 10, false);
            this.huR.setText(aqVar.bzN);
            this.huO.setText(aqVar.bxW);
            List<String> list = aqVar.bzM;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.huP.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.huP.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.huQ.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.d(this.huL, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huM, d.C0277d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.d(this.huO, d.C0277d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(this.huP, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huQ, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huR, d.C0277d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, d.C0277d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.huR, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bJ(VideoPlayActivityConfig.OBJ_ID, this.huU.bxV));
        }
    }
}
