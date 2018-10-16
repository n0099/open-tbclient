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
    View.OnClickListener aDy;
    public View devider;
    public TextView fSA;
    public TextView fSB;
    public TextView fSC;
    public TbImageView fSD;
    public LinearLayout fSE;
    private com.baidu.tbadk.core.data.ao fSF;
    public TextView fSw;
    public TextView fSx;
    public TbImageView fSy;
    public TextView fSz;
    private TbPageContext mContext;

    public ai(TbPageContext tbPageContext, View view) {
        super(view);
        this.aDy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bI(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo() && ai.this.fSF != null && !StringUtils.isNull(ai.this.fSF.amo)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                    } else if (view2 == ai.this.fSC) {
                        String str = ai.this.fSF.amo;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        akVar.amo = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ax("obj_locate", "0").ax("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ax(VideoPlayActivityConfig.OBJ_ID, ai.this.fSF.amo).ax("obj_locate", "3"));
                    } else if (view2 == ai.this.fSE) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.fSF.amo)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ax(VideoPlayActivityConfig.OBJ_ID, ai.this.fSF.amo).ax("obj_locate", "1"));
                    } else if (view2 == ai.this.fSx && !StringUtils.isNull(ai.this.fSF.aog)) {
                        ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.fSF.aog});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ax(VideoPlayActivityConfig.OBJ_ID, ai.this.fSF.amo).ax("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fSw = (TextView) view.findViewById(e.g.textview_recommend_title);
        this.fSx = (TextView) view.findViewById(e.g.textview_recommend_option_btn);
        this.fSy = (TbImageView) view.findViewById(e.g.novel_cover);
        this.fSz = (TextView) view.findViewById(e.g.novel_title);
        this.fSA = (TextView) view.findViewById(e.g.novel_author);
        this.fSB = (TextView) view.findViewById(e.g.novel_read_number);
        this.fSC = (TextView) view.findViewById(e.g.novel_read_btn);
        this.fSE = (LinearLayout) view.findViewById(e.g.novel_recommend_item_layout);
        this.fSD = (TbImageView) view.findViewById(e.g.novel_subscription);
        this.fSD.setDefaultResource(e.f.transparent_bg);
        this.fSD.setDefaultBgResource(e.f.transparent_bg);
        this.fSD.setDefaultErrorResource(e.f.transparent_bg);
        this.devider = view.findViewById(e.g.recommend_devider);
        this.fSC.setOnClickListener(this.aDy);
        this.fSE.setOnClickListener(this.aDy);
        this.fSx.setOnClickListener(this.aDy);
    }

    public void a(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.fSF = aoVar;
            this.fSw.setText(aoVar.aoe);
            this.fSx.setText(aoVar.aof);
            this.fSD.startLoad(aoVar.aoj, 10, false);
            this.fSy.startLoad(aoVar.amq, 10, false);
            this.fSC.setText(aoVar.aoi);
            this.fSz.setText(aoVar.amp);
            List<String> list = aoVar.aoh;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fSA.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fSA.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fSB.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.fSw, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fSx, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.fSz, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.fSA, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fSB, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fSC, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, e.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.fSC, e.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").ax(VideoPlayActivityConfig.OBJ_ID, this.fSF.amo));
        }
    }
}
