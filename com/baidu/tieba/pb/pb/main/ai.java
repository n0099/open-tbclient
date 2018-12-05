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
    View.OnClickListener aHO;
    public View devider;
    public TextView gaM;
    public TextView gaN;
    public TbImageView gaO;
    public TextView gaP;
    public TextView gaQ;
    public TextView gaR;
    public TextView gaS;
    public TbImageView gaT;
    public LinearLayout gaU;
    private com.baidu.tbadk.core.data.ao gaV;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.aHO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll() && ai.this.gaV != null && !StringUtils.isNull(ai.this.gaV.aqC)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.gaS) {
                        String str = ai.this.gaV.aqC;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        akVar.aqC = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aA("obj_locate", "0").aA("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aA(VideoPlayActivityConfig.OBJ_ID, ai.this.gaV.aqC).aA("obj_locate", "3"));
                    } else if (view2 == ai.this.gaU) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.gaV.aqC)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aA(VideoPlayActivityConfig.OBJ_ID, ai.this.gaV.aqC).aA("obj_locate", "1"));
                    } else if (view2 == ai.this.gaN && !StringUtils.isNull(ai.this.gaV.asu)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.gaV.asu});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aA(VideoPlayActivityConfig.OBJ_ID, ai.this.gaV.aqC).aA("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gaM = (TextView) view.findViewById(e.g.textview_recommend_title);
        this.gaN = (TextView) view.findViewById(e.g.textview_recommend_option_btn);
        this.gaO = (TbImageView) view.findViewById(e.g.novel_cover);
        this.gaP = (TextView) view.findViewById(e.g.novel_title);
        this.gaQ = (TextView) view.findViewById(e.g.novel_author);
        this.gaR = (TextView) view.findViewById(e.g.novel_read_number);
        this.gaS = (TextView) view.findViewById(e.g.novel_read_btn);
        this.gaU = (LinearLayout) view.findViewById(e.g.novel_recommend_item_layout);
        this.gaT = (TbImageView) view.findViewById(e.g.novel_subscription);
        this.gaT.setDefaultResource(e.f.transparent_bg);
        this.gaT.setDefaultBgResource(e.f.transparent_bg);
        this.gaT.setDefaultErrorResource(e.f.transparent_bg);
        this.devider = view.findViewById(e.g.recommend_devider);
        this.gaS.setOnClickListener(this.aHO);
        this.gaU.setOnClickListener(this.aHO);
        this.gaN.setOnClickListener(this.aHO);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.gaV = aoVar;
            this.gaM.setText(aoVar.ass);
            this.gaN.setText(aoVar.ast);
            this.gaT.startLoad(aoVar.asx, 10, false);
            this.gaO.startLoad(aoVar.aqE, 10, false);
            this.gaS.setText(aoVar.asw);
            this.gaP.setText(aoVar.aqD);
            List<String> list = aoVar.asv;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.gaQ.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.gaQ.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.gaR.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.gaM, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.gaN, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.gaP, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.gaQ, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.gaR, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.gaS, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, e.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.gaS, e.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").aA(VideoPlayActivityConfig.OBJ_ID, this.gaV.aqC));
        }
    }
}
