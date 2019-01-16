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
    View.OnClickListener aIr;
    public View devider;
    private a geG;
    public TextView geI;
    public TextView geJ;
    public TbImageView geK;
    public TextView geL;
    public TextView geM;
    public TextView geN;
    public TextView geO;
    public TbImageView geP;
    public LinearLayout geQ;
    private com.baidu.tbadk.core.data.ao geR;
    private TbPageContext mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.ao aoVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.aIr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll() && ai.this.geR != null && !StringUtils.isNull(ai.this.geR.are)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.geG != null) {
                        ai.this.geG.a(ai.this.geR);
                    }
                    if (view2 == ai.this.geO) {
                        String str = ai.this.geR.are;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        akVar.are = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aB("obj_locate", "0").aB("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aB(VideoPlayActivityConfig.OBJ_ID, ai.this.geR.are).aB("obj_locate", "3"));
                    } else if (view2 == ai.this.geQ) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.geR.are)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aB(VideoPlayActivityConfig.OBJ_ID, ai.this.geR.are).aB("obj_locate", "1"));
                    } else if (view2 == ai.this.geJ && !StringUtils.isNull(ai.this.geR.asW)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.geR.asW});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aB(VideoPlayActivityConfig.OBJ_ID, ai.this.geR.are).aB("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.geG = aVar;
        this.geI = (TextView) view.findViewById(e.g.textview_recommend_title);
        this.geJ = (TextView) view.findViewById(e.g.textview_recommend_option_btn);
        this.geK = (TbImageView) view.findViewById(e.g.novel_cover);
        this.geL = (TextView) view.findViewById(e.g.novel_title);
        this.geM = (TextView) view.findViewById(e.g.novel_author);
        this.geN = (TextView) view.findViewById(e.g.novel_read_number);
        this.geO = (TextView) view.findViewById(e.g.novel_read_btn);
        this.geQ = (LinearLayout) view.findViewById(e.g.novel_recommend_item_layout);
        this.geP = (TbImageView) view.findViewById(e.g.novel_subscription);
        this.geP.setDefaultResource(e.f.transparent_bg);
        this.geP.setDefaultBgResource(e.f.transparent_bg);
        this.geP.setDefaultErrorResource(e.f.transparent_bg);
        this.devider = view.findViewById(e.g.recommend_devider);
        this.geO.setOnClickListener(this.aIr);
        this.geQ.setOnClickListener(this.aIr);
        this.geJ.setOnClickListener(this.aIr);
    }

    public void b(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.geR = aoVar;
            this.geI.setText(aoVar.asU);
            this.geJ.setText(aoVar.asV);
            this.geP.startLoad(aoVar.asZ, 10, false);
            this.geK.startLoad(aoVar.arg, 10, false);
            this.geO.setText(aoVar.asY);
            this.geL.setText(aoVar.arf);
            List<String> list = aoVar.asX;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.geM.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.geM.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.geN.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.geI, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.geJ, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.geL, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.geM, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.geN, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.geO, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, e.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.geO, e.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").aB(VideoPlayActivityConfig.OBJ_ID, this.geR.are));
        }
    }
}
