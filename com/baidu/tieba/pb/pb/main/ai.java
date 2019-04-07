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
    View.OnClickListener bQM;
    public View devider;
    public TbImageView huA;
    public TextView huB;
    public TextView huC;
    public TextView huD;
    public TextView huE;
    public TbImageView huF;
    public LinearLayout huG;
    private com.baidu.tbadk.core.data.aq huH;
    private a huw;
    public TextView huy;
    public TextView huz;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bQM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo() && ai.this.huH != null && !StringUtils.isNull(ai.this.huH.bxY)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.huw != null) {
                        ai.this.huw.a(ai.this.huH);
                    }
                    if (view2 == ai.this.huE) {
                        String str = ai.this.huH.bxY;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        amVar.bxY = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bJ("obj_locate", "0").bJ("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huH.bxY).bJ("obj_locate", "3"));
                    } else if (view2 == ai.this.huG) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.huH.bxY)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huH.bxY).bJ("obj_locate", "1"));
                    } else if (view2 == ai.this.huz && !StringUtils.isNull(ai.this.huH.bzO)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.huH.bzO});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.huH.bxY).bJ("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huw = aVar;
        this.huy = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.huz = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.huA = (TbImageView) view.findViewById(d.g.novel_cover);
        this.huB = (TextView) view.findViewById(d.g.novel_title);
        this.huC = (TextView) view.findViewById(d.g.novel_author);
        this.huD = (TextView) view.findViewById(d.g.novel_read_number);
        this.huE = (TextView) view.findViewById(d.g.novel_read_btn);
        this.huG = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.huF = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.huF.setDefaultResource(d.f.transparent_bg);
        this.huF.setDefaultBgResource(d.f.transparent_bg);
        this.huF.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.huE.setOnClickListener(this.bQM);
        this.huG.setOnClickListener(this.bQM);
        this.huz.setOnClickListener(this.bQM);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.huH = aqVar;
            this.huy.setText(aqVar.bzM);
            this.huz.setText(aqVar.bzN);
            this.huF.startLoad(aqVar.bzR, 10, false);
            this.huA.startLoad(aqVar.bya, 10, false);
            this.huE.setText(aqVar.bzQ);
            this.huB.setText(aqVar.bxZ);
            List<String> list = aqVar.bzP;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.huC.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.huC.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.huD.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.d(this.huy, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huz, d.C0277d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.d(this.huB, d.C0277d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(this.huC, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huD, d.C0277d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huE, d.C0277d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, d.C0277d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.huE, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bJ(VideoPlayActivityConfig.OBJ_ID, this.huH.bxY));
        }
    }
}
