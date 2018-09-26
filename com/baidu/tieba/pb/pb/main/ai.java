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
/* loaded from: classes2.dex */
public class ai extends q.a {
    View.OnClickListener ayP;
    public View devider;
    public TextView fKV;
    public TextView fKW;
    public TbImageView fKX;
    public TextView fKY;
    public TextView fKZ;
    public TextView fLa;
    public TextView fLb;
    public TbImageView fLc;
    public LinearLayout fLd;
    private com.baidu.tbadk.core.data.ao fLe;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.ayP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bA(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lb() && ai.this.fLe != null && !StringUtils.isNull(ai.this.fLe.ahs)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fLb) {
                        String str = ai.this.fLe.ahs;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        akVar.ahs = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).al("obj_locate", "0").al("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").al(VideoPlayActivityConfig.OBJ_ID, ai.this.fLe.ahs).al("obj_locate", "3"));
                    } else if (view2 == ai.this.fLd) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.fLe.ahs)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").al(VideoPlayActivityConfig.OBJ_ID, ai.this.fLe.ahs).al("obj_locate", "1"));
                    } else if (view2 == ai.this.fKW && !StringUtils.isNull(ai.this.fLe.ajl)) {
                        ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.fLe.ajl});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").al(VideoPlayActivityConfig.OBJ_ID, ai.this.fLe.ahs).al("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fKV = (TextView) view.findViewById(e.g.textview_recommend_title);
        this.fKW = (TextView) view.findViewById(e.g.textview_recommend_option_btn);
        this.fKX = (TbImageView) view.findViewById(e.g.novel_cover);
        this.fKY = (TextView) view.findViewById(e.g.novel_title);
        this.fKZ = (TextView) view.findViewById(e.g.novel_author);
        this.fLa = (TextView) view.findViewById(e.g.novel_read_number);
        this.fLb = (TextView) view.findViewById(e.g.novel_read_btn);
        this.fLd = (LinearLayout) view.findViewById(e.g.novel_recommend_item_layout);
        this.fLc = (TbImageView) view.findViewById(e.g.novel_subscription);
        this.fLc.setDefaultResource(e.f.transparent_bg);
        this.fLc.setDefaultBgResource(e.f.transparent_bg);
        this.fLc.setDefaultErrorResource(e.f.transparent_bg);
        this.devider = view.findViewById(e.g.recommend_devider);
        this.fLb.setOnClickListener(this.ayP);
        this.fLd.setOnClickListener(this.ayP);
        this.fKW.setOnClickListener(this.ayP);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fLe = aoVar;
            this.fKV.setText(aoVar.ajj);
            this.fKW.setText(aoVar.ajk);
            this.fLc.startLoad(aoVar.ajo, 10, false);
            this.fKX.startLoad(aoVar.ahu, 10, false);
            this.fLb.setText(aoVar.ajn);
            this.fKY.setText(aoVar.aht);
            List<String> list = aoVar.ajm;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fKZ.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fKZ.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fLa.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.fKV, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fKW, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.fKY, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.fKZ, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fLa, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fLb, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, e.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.fLb, e.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").al(VideoPlayActivityConfig.OBJ_ID, this.fLe.ahs));
        }
    }
}
