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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes2.dex */
public class ai extends q.a {
    View.OnClickListener avD;
    public View devider;
    public TextView fDl;
    public TextView fDm;
    public TbImageView fDn;
    public TextView fDo;
    public TextView fDp;
    public TextView fDq;
    public TextView fDr;
    public TbImageView fDs;
    public LinearLayout fDt;
    private com.baidu.tbadk.core.data.ao fDu;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.avD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bb.aU(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jV() && ai.this.fDu != null && !StringUtils.isNull(ai.this.fDu.aeR)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), f.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fDr) {
                        String str = ai.this.fDu.aeR;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ad(ai.this.mContext.getPageActivity());
                        akVar.aeR = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ae("obj_locate", "0").ae("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").ae(VideoPlayActivityConfig.OBJ_ID, ai.this.fDu.aeR).ae("obj_locate", "3"));
                    } else if (view2 == ai.this.fDt) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.fDu.aeR)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").ae(VideoPlayActivityConfig.OBJ_ID, ai.this.fDu.aeR).ae("obj_locate", "1"));
                    } else if (view2 == ai.this.fDm && !StringUtils.isNull(ai.this.fDu.agL)) {
                        az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(ai.this.mContext.getPageActivity()), new String[]{ai.this.fDu.agL});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").ae(VideoPlayActivityConfig.OBJ_ID, ai.this.fDu.aeR).ae("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fDl = (TextView) view.findViewById(f.g.textview_recommend_title);
        this.fDm = (TextView) view.findViewById(f.g.textview_recommend_option_btn);
        this.fDn = (TbImageView) view.findViewById(f.g.novel_cover);
        this.fDo = (TextView) view.findViewById(f.g.novel_title);
        this.fDp = (TextView) view.findViewById(f.g.novel_author);
        this.fDq = (TextView) view.findViewById(f.g.novel_read_number);
        this.fDr = (TextView) view.findViewById(f.g.novel_read_btn);
        this.fDt = (LinearLayout) view.findViewById(f.g.novel_recommend_item_layout);
        this.fDs = (TbImageView) view.findViewById(f.g.novel_subscription);
        this.fDs.setDefaultResource(f.C0146f.transparent_bg);
        this.fDs.setDefaultBgResource(f.C0146f.transparent_bg);
        this.fDs.setDefaultErrorResource(f.C0146f.transparent_bg);
        this.devider = view.findViewById(f.g.recommend_devider);
        this.fDr.setOnClickListener(this.avD);
        this.fDt.setOnClickListener(this.avD);
        this.fDm.setOnClickListener(this.avD);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fDu = aoVar;
            this.fDl.setText(aoVar.agJ);
            this.fDm.setText(aoVar.agK);
            this.fDs.startLoad(aoVar.agO, 10, false);
            this.fDn.startLoad(aoVar.aeT, 10, false);
            this.fDr.setText(aoVar.agN);
            this.fDo.setText(aoVar.aeS);
            List<String> list = aoVar.agM;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fDp.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fDp.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fDq.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.c(this.fDl, f.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDm, f.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.c(this.fDo, f.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.c(this.fDp, f.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDq, f.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDr, f.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.j(this.devider, f.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.i(this.fDr, f.C0146f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").ae(VideoPlayActivityConfig.OBJ_ID, this.fDu.aeR));
        }
    }
}
