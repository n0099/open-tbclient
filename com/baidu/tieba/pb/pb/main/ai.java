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
    View.OnClickListener aIs;
    public View devider;
    private a geH;
    public TextView geJ;
    public TextView geK;
    public TbImageView geL;
    public TextView geM;
    public TextView geN;
    public TextView geO;
    public TextView geP;
    public TbImageView geQ;
    public LinearLayout geR;
    private com.baidu.tbadk.core.data.ao geS;
    private TbPageContext mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.ao aoVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.aIs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll() && ai.this.geS != null && !StringUtils.isNull(ai.this.geS.arf)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), e.j.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.geH != null) {
                        ai.this.geH.a(ai.this.geS);
                    }
                    if (view2 == ai.this.geP) {
                        String str = ai.this.geS.arf;
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        akVar.arf = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aB("obj_locate", "0").aB("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aB(VideoPlayActivityConfig.OBJ_ID, ai.this.geS.arf).aB("obj_locate", "3"));
                    } else if (view2 == ai.this.geR) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.geS.arf)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aB(VideoPlayActivityConfig.OBJ_ID, ai.this.geS.arf).aB("obj_locate", "1"));
                    } else if (view2 == ai.this.geK && !StringUtils.isNull(ai.this.geS.asX)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.geS.asX});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").aB(VideoPlayActivityConfig.OBJ_ID, ai.this.geS.arf).aB("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.geH = aVar;
        this.geJ = (TextView) view.findViewById(e.g.textview_recommend_title);
        this.geK = (TextView) view.findViewById(e.g.textview_recommend_option_btn);
        this.geL = (TbImageView) view.findViewById(e.g.novel_cover);
        this.geM = (TextView) view.findViewById(e.g.novel_title);
        this.geN = (TextView) view.findViewById(e.g.novel_author);
        this.geO = (TextView) view.findViewById(e.g.novel_read_number);
        this.geP = (TextView) view.findViewById(e.g.novel_read_btn);
        this.geR = (LinearLayout) view.findViewById(e.g.novel_recommend_item_layout);
        this.geQ = (TbImageView) view.findViewById(e.g.novel_subscription);
        this.geQ.setDefaultResource(e.f.transparent_bg);
        this.geQ.setDefaultBgResource(e.f.transparent_bg);
        this.geQ.setDefaultErrorResource(e.f.transparent_bg);
        this.devider = view.findViewById(e.g.recommend_devider);
        this.geP.setOnClickListener(this.aIs);
        this.geR.setOnClickListener(this.aIs);
        this.geK.setOnClickListener(this.aIs);
    }

    public void b(com.baidu.tbadk.core.data.ao aoVar) {
        if (aoVar != null) {
            this.geS = aoVar;
            this.geJ.setText(aoVar.asV);
            this.geK.setText(aoVar.asW);
            this.geQ.startLoad(aoVar.ata, 10, false);
            this.geL.startLoad(aoVar.arh, 10, false);
            this.geP.setText(aoVar.asZ);
            this.geM.setText(aoVar.arg);
            List<String> list = aoVar.asY;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.geN.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.geN.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.geO.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.geJ, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.geK, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.geM, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.geN, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.geO, e.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.geP, e.d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, e.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.geP, e.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").aB(VideoPlayActivityConfig.OBJ_ID, this.geS.arf));
        }
    }
}
