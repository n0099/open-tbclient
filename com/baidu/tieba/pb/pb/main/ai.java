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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ai extends q.a {
    View.OnClickListener avF;
    public View devider;
    public LinearLayout fDA;
    private com.baidu.tbadk.core.data.ao fDB;
    public TextView fDs;
    public TextView fDt;
    public TbImageView fDu;
    public TextView fDv;
    public TextView fDw;
    public TextView fDx;
    public TextView fDy;
    public TbImageView fDz;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.avF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.aV(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jV() && ai.this.fDB != null && !StringUtils.isNull(ai.this.fDB.aeR)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fDy) {
                        String str = ai.this.fDB.aeR;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ad(ai.this.mContext.getPageActivity());
                        akVar.aeR = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).af("obj_locate", "0").af("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").af(VideoPlayActivityConfig.OBJ_ID, ai.this.fDB.aeR).af("obj_locate", "3"));
                    } else if (view2 == ai.this.fDA) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.fDB.aeR)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").af(VideoPlayActivityConfig.OBJ_ID, ai.this.fDB.aeR).af("obj_locate", "1"));
                    } else if (view2 == ai.this.fDt && !StringUtils.isNull(ai.this.fDB.agL)) {
                        com.baidu.tbadk.core.util.ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(ai.this.mContext.getPageActivity()), new String[]{ai.this.fDB.agL});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").af(VideoPlayActivityConfig.OBJ_ID, ai.this.fDB.aeR).af("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fDs = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fDt = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fDu = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fDv = (TextView) view.findViewById(d.g.novel_title);
        this.fDw = (TextView) view.findViewById(d.g.novel_author);
        this.fDx = (TextView) view.findViewById(d.g.novel_read_number);
        this.fDy = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fDA = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fDz = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fDz.setDefaultResource(d.f.transparent_bg);
        this.fDz.setDefaultBgResource(d.f.transparent_bg);
        this.fDz.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fDy.setOnClickListener(this.avF);
        this.fDA.setOnClickListener(this.avF);
        this.fDt.setOnClickListener(this.avF);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fDB = aoVar;
            this.fDs.setText(aoVar.agJ);
            this.fDt.setText(aoVar.agK);
            this.fDz.startLoad(aoVar.agO, 10, false);
            this.fDu.startLoad(aoVar.aeT, 10, false);
            this.fDy.setText(aoVar.agN);
            this.fDv.setText(aoVar.aeS);
            List<String> list = aoVar.agM;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fDw.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fDw.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fDx.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.c(this.fDs, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDt, d.C0140d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.c(this.fDv, d.C0140d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.c(this.fDw, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDx, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDy, d.C0140d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.j(this.devider, d.C0140d.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.i(this.fDy, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").af(VideoPlayActivityConfig.OBJ_ID, this.fDB.aeR));
        }
    }
}
