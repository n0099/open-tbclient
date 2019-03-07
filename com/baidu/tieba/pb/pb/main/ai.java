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
    View.OnClickListener bQJ;
    public View devider;
    private a huP;
    public TextView huR;
    public TextView huS;
    public TbImageView huT;
    public TextView huU;
    public TextView huV;
    public TextView huW;
    public TextView huX;
    public TbImageView huY;
    public LinearLayout huZ;
    private com.baidu.tbadk.core.data.aq hva;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bQJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo() && ai.this.hva != null && !StringUtils.isNull(ai.this.hva.bxT)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.huP != null) {
                        ai.this.huP.a(ai.this.hva);
                    }
                    if (view2 == ai.this.huX) {
                        String str = ai.this.hva.bxT;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        amVar.bxT = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bJ("obj_locate", "0").bJ("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.hva.bxT).bJ("obj_locate", "3"));
                    } else if (view2 == ai.this.huZ) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hva.bxT)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.hva.bxT).bJ("obj_locate", "1"));
                    } else if (view2 == ai.this.huS && !StringUtils.isNull(ai.this.hva.bzJ)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.hva.bzJ});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.hva.bxT).bJ("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huP = aVar;
        this.huR = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.huS = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.huT = (TbImageView) view.findViewById(d.g.novel_cover);
        this.huU = (TextView) view.findViewById(d.g.novel_title);
        this.huV = (TextView) view.findViewById(d.g.novel_author);
        this.huW = (TextView) view.findViewById(d.g.novel_read_number);
        this.huX = (TextView) view.findViewById(d.g.novel_read_btn);
        this.huZ = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.huY = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.huY.setDefaultResource(d.f.transparent_bg);
        this.huY.setDefaultBgResource(d.f.transparent_bg);
        this.huY.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.huX.setOnClickListener(this.bQJ);
        this.huZ.setOnClickListener(this.bQJ);
        this.huS.setOnClickListener(this.bQJ);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hva = aqVar;
            this.huR.setText(aqVar.bzH);
            this.huS.setText(aqVar.bzI);
            this.huY.startLoad(aqVar.bzM, 10, false);
            this.huT.startLoad(aqVar.bxV, 10, false);
            this.huX.setText(aqVar.bzL);
            this.huU.setText(aqVar.bxU);
            List<String> list = aqVar.bzK;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.huV.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.huV.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.huW.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.d(this.huR, d.C0236d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huS, d.C0236d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.d(this.huU, d.C0236d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(this.huV, d.C0236d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huW, d.C0236d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huX, d.C0236d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, d.C0236d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.huX, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bJ(VideoPlayActivityConfig.OBJ_ID, this.hva.bxT));
        }
    }
}
