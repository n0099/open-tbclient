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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ai extends q.a {
    View.OnClickListener avZ;
    public View devider;
    public TextView fDf;
    public TextView fDg;
    public TbImageView fDh;
    public TextView fDi;
    public TextView fDj;
    public TextView fDk;
    public TextView fDl;
    public TbImageView fDm;
    public LinearLayout fDn;
    private com.baidu.tbadk.core.data.ap fDo;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.avZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bb.aU(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jU() && ai.this.fDo != null && !StringUtils.isNull(ai.this.fDo.afx)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), d.k.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fDl) {
                        String str = ai.this.fDo.afx;
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        alVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ad(ai.this.mContext.getPageActivity());
                        alVar.afx = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ah("obj_locate", "0").ah("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").ah(VideoPlayActivityConfig.OBJ_ID, ai.this.fDo.afx).ah("obj_locate", "3"));
                    } else if (view2 == ai.this.fDn) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.fDo.afx)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").ah(VideoPlayActivityConfig.OBJ_ID, ai.this.fDo.afx).ah("obj_locate", "1"));
                    } else if (view2 == ai.this.fDg && !StringUtils.isNull(ai.this.fDo.ahr)) {
                        az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(ai.this.mContext.getPageActivity()), new String[]{ai.this.fDo.ahr});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").ah(VideoPlayActivityConfig.OBJ_ID, ai.this.fDo.afx).ah("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fDf = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fDg = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fDh = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fDi = (TextView) view.findViewById(d.g.novel_title);
        this.fDj = (TextView) view.findViewById(d.g.novel_author);
        this.fDk = (TextView) view.findViewById(d.g.novel_read_number);
        this.fDl = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fDn = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fDm = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fDm.setDefaultResource(d.f.transparent_bg);
        this.fDm.setDefaultBgResource(d.f.transparent_bg);
        this.fDm.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fDl.setOnClickListener(this.avZ);
        this.fDn.setOnClickListener(this.avZ);
        this.fDg.setOnClickListener(this.avZ);
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null) {
            this.fDo = apVar;
            this.fDf.setText(apVar.ahp);
            this.fDg.setText(apVar.ahq);
            this.fDm.startLoad(apVar.ahu, 10, false);
            this.fDh.startLoad(apVar.afz, 10, false);
            this.fDl.setText(apVar.aht);
            this.fDi.setText(apVar.afy);
            List<String> list = apVar.ahs;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fDj.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fDj.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fDk.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.c(this.fDf, d.C0142d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDg, d.C0142d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.c(this.fDi, d.C0142d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.c(this.fDj, d.C0142d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDk, d.C0142d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fDl, d.C0142d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.j(this.devider, d.C0142d.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.i(this.fDl, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").ah(VideoPlayActivityConfig.OBJ_ID, this.fDo.afx));
        }
    }
}
