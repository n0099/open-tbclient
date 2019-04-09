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
    View.OnClickListener bQN;
    public View devider;
    public TextView huA;
    public TbImageView huB;
    public TextView huC;
    public TextView huD;
    public TextView huE;
    public TextView huF;
    public TbImageView huG;
    public LinearLayout huH;
    private com.baidu.tbadk.core.data.aq huI;
    private a hux;
    public TextView huz;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bQN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo() && ai.this.huI != null && !StringUtils.isNull(ai.this.huI.bxZ)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hux != null) {
                        ai.this.hux.a(ai.this.huI);
                    }
                    if (view2 == ai.this.huF) {
                        String str = ai.this.huI.bxZ;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        amVar.bxZ = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bJ("obj_locate", "0").bJ("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huI.bxZ).bJ("obj_locate", "3"));
                    } else if (view2 == ai.this.huH) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.huI.bxZ)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huI.bxZ).bJ("obj_locate", "1"));
                    } else if (view2 == ai.this.huA && !StringUtils.isNull(ai.this.huI.bzP)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.huI.bzP});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huI.bxZ).bJ("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hux = aVar;
        this.huz = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.huA = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.huB = (TbImageView) view.findViewById(d.g.novel_cover);
        this.huC = (TextView) view.findViewById(d.g.novel_title);
        this.huD = (TextView) view.findViewById(d.g.novel_author);
        this.huE = (TextView) view.findViewById(d.g.novel_read_number);
        this.huF = (TextView) view.findViewById(d.g.novel_read_btn);
        this.huH = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.huG = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.huG.setDefaultResource(d.f.transparent_bg);
        this.huG.setDefaultBgResource(d.f.transparent_bg);
        this.huG.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.huF.setOnClickListener(this.bQN);
        this.huH.setOnClickListener(this.bQN);
        this.huA.setOnClickListener(this.bQN);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.huI = aqVar;
            this.huz.setText(aqVar.bzN);
            this.huA.setText(aqVar.bzO);
            this.huG.startLoad(aqVar.bzS, 10, false);
            this.huB.startLoad(aqVar.byb, 10, false);
            this.huF.setText(aqVar.bzR);
            this.huC.setText(aqVar.bya);
            List<String> list = aqVar.bzQ;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.huD.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.huD.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.huE.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.d(this.huz, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huA, d.C0277d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.d(this.huC, d.C0277d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(this.huD, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huE, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huF, d.C0277d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, d.C0277d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.huF, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bJ(VideoPlayActivityConfig.OBJ_ID, this.huI.bxZ));
        }
    }
}
