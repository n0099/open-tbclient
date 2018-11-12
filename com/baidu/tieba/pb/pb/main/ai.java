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
    View.OnClickListener aEo;
    public View devider;
    public TextView fTW;
    public TextView fTX;
    public TbImageView fTY;
    public TextView fTZ;
    public TextView fUa;
    public TextView fUb;
    public TextView fUc;
    public TbImageView fUd;
    public LinearLayout fUe;
    private com.baidu.tbadk.core.data.ao fUf;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.aEo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bG(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lm() && ai.this.fUf != null && !StringUtils.isNull(ai.this.fUf.anb)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fUc) {
                        String str = ai.this.fUf.anb;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        akVar.anb = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ax("obj_locate", "0").ax("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ax(VideoPlayActivityConfig.OBJ_ID, ai.this.fUf.anb).ax("obj_locate", "3"));
                    } else if (view2 == ai.this.fUe) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.fUf.anb)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ax(VideoPlayActivityConfig.OBJ_ID, ai.this.fUf.anb).ax("obj_locate", "1"));
                    } else if (view2 == ai.this.fTX && !StringUtils.isNull(ai.this.fUf.aoT)) {
                        ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.fUf.aoT});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ax(VideoPlayActivityConfig.OBJ_ID, ai.this.fUf.anb).ax("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fTW = (TextView) view.findViewById(e.g.textview_recommend_title);
        this.fTX = (TextView) view.findViewById(e.g.textview_recommend_option_btn);
        this.fTY = (TbImageView) view.findViewById(e.g.novel_cover);
        this.fTZ = (TextView) view.findViewById(e.g.novel_title);
        this.fUa = (TextView) view.findViewById(e.g.novel_author);
        this.fUb = (TextView) view.findViewById(e.g.novel_read_number);
        this.fUc = (TextView) view.findViewById(e.g.novel_read_btn);
        this.fUe = (LinearLayout) view.findViewById(e.g.novel_recommend_item_layout);
        this.fUd = (TbImageView) view.findViewById(e.g.novel_subscription);
        this.fUd.setDefaultResource(e.f.transparent_bg);
        this.fUd.setDefaultBgResource(e.f.transparent_bg);
        this.fUd.setDefaultErrorResource(e.f.transparent_bg);
        this.devider = view.findViewById(e.g.recommend_devider);
        this.fUc.setOnClickListener(this.aEo);
        this.fUe.setOnClickListener(this.aEo);
        this.fTX.setOnClickListener(this.aEo);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fUf = aoVar;
            this.fTW.setText(aoVar.aoR);
            this.fTX.setText(aoVar.aoS);
            this.fUd.startLoad(aoVar.aoW, 10, false);
            this.fTY.startLoad(aoVar.and, 10, false);
            this.fUc.setText(aoVar.aoV);
            this.fTZ.setText(aoVar.anc);
            List<String> list = aoVar.aoU;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fUa.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fUa.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fUb.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.fTW, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fTX, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.fTZ, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.fUa, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fUb, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fUc, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, e.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.fUc, e.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").ax(VideoPlayActivityConfig.OBJ_ID, this.fUf.anb));
        }
    }
}
