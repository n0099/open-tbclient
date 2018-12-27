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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes6.dex */
public class ai extends q.a {
    View.OnClickListener aHP;
    public View devider;
    public TextView gdE;
    public TextView gdF;
    public TbImageView gdG;
    public TextView gdH;
    public TextView gdI;
    public TextView gdJ;
    public TextView gdK;
    public TbImageView gdL;
    public LinearLayout gdM;
    private com.baidu.tbadk.core.data.ao gdN;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.aHP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll() && ai.this.gdN != null && !StringUtils.isNull(ai.this.gdN.aqC)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.gdK) {
                        String str = ai.this.gdN.aqC;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        akVar.aqC = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aA("obj_locate", "0").aA("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aA(VideoPlayActivityConfig.OBJ_ID, ai.this.gdN.aqC).aA("obj_locate", "3"));
                    } else if (view2 == ai.this.gdM) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.gdN.aqC)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aA(VideoPlayActivityConfig.OBJ_ID, ai.this.gdN.aqC).aA("obj_locate", "1"));
                    } else if (view2 == ai.this.gdF && !StringUtils.isNull(ai.this.gdN.asu)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.gdN.asu});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aA(VideoPlayActivityConfig.OBJ_ID, ai.this.gdN.aqC).aA("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gdE = (TextView) view.findViewById(e.g.textview_recommend_title);
        this.gdF = (TextView) view.findViewById(e.g.textview_recommend_option_btn);
        this.gdG = (TbImageView) view.findViewById(e.g.novel_cover);
        this.gdH = (TextView) view.findViewById(e.g.novel_title);
        this.gdI = (TextView) view.findViewById(e.g.novel_author);
        this.gdJ = (TextView) view.findViewById(e.g.novel_read_number);
        this.gdK = (TextView) view.findViewById(e.g.novel_read_btn);
        this.gdM = (LinearLayout) view.findViewById(e.g.novel_recommend_item_layout);
        this.gdL = (TbImageView) view.findViewById(e.g.novel_subscription);
        this.gdL.setDefaultResource(e.f.transparent_bg);
        this.gdL.setDefaultBgResource(e.f.transparent_bg);
        this.gdL.setDefaultErrorResource(e.f.transparent_bg);
        this.devider = view.findViewById(e.g.recommend_devider);
        this.gdK.setOnClickListener(this.aHP);
        this.gdM.setOnClickListener(this.aHP);
        this.gdF.setOnClickListener(this.aHP);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.gdN = aoVar;
            this.gdE.setText(aoVar.ass);
            this.gdF.setText(aoVar.ast);
            this.gdL.startLoad(aoVar.asx, 10, false);
            this.gdG.startLoad(aoVar.aqE, 10, false);
            this.gdK.setText(aoVar.asw);
            this.gdH.setText(aoVar.aqD);
            List<String> list = aoVar.asv;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.gdI.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.gdI.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.gdJ.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.gdE, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.gdF, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.gdH, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.gdI, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.gdJ, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.gdK, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, e.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.gdK, e.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").aA(VideoPlayActivityConfig.OBJ_ID, this.gdN.aqC));
        }
    }
}
