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
    private a huQ;
    public TextView huS;
    public TextView huT;
    public TbImageView huU;
    public TextView huV;
    public TextView huW;
    public TextView huX;
    public TextView huY;
    public TbImageView huZ;
    public LinearLayout hva;
    private com.baidu.tbadk.core.data.aq hvb;
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
                if (bc.cZ(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo() && ai.this.hvb != null && !StringUtils.isNull(ai.this.hvb.bxT)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), d.j.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.huQ != null) {
                        ai.this.huQ.a(ai.this.hvb);
                    }
                    if (view2 == ai.this.huY) {
                        String str = ai.this.hvb.bxT;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity());
                        amVar.bxT = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bJ("obj_locate", "0").bJ("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.hvb.bxT).bJ("obj_locate", "3"));
                    } else if (view2 == ai.this.hva) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hvb.bxT)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.hvb.bxT).bJ("obj_locate", "1"));
                    } else if (view2 == ai.this.huT && !StringUtils.isNull(ai.this.hvb.bzJ)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(ai.this.mContext.getPageActivity()), new String[]{ai.this.hvb.bzJ});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bJ(VideoPlayActivityConfig.OBJ_ID, ai.this.hvb.bxT).bJ("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huQ = aVar;
        this.huS = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.huT = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.huU = (TbImageView) view.findViewById(d.g.novel_cover);
        this.huV = (TextView) view.findViewById(d.g.novel_title);
        this.huW = (TextView) view.findViewById(d.g.novel_author);
        this.huX = (TextView) view.findViewById(d.g.novel_read_number);
        this.huY = (TextView) view.findViewById(d.g.novel_read_btn);
        this.hva = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.huZ = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.huZ.setDefaultResource(d.f.transparent_bg);
        this.huZ.setDefaultBgResource(d.f.transparent_bg);
        this.huZ.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.huY.setOnClickListener(this.bQJ);
        this.hva.setOnClickListener(this.bQJ);
        this.huT.setOnClickListener(this.bQJ);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hvb = aqVar;
            this.huS.setText(aqVar.bzH);
            this.huT.setText(aqVar.bzI);
            this.huZ.startLoad(aqVar.bzM, 10, false);
            this.huU.startLoad(aqVar.bxV, 10, false);
            this.huY.setText(aqVar.bzL);
            this.huV.setText(aqVar.bxU);
            List<String> list = aqVar.bzK;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.huW.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.huW.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.huX.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.d(this.huS, d.C0236d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huT, d.C0236d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.d(this.huV, d.C0236d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(this.huW, d.C0236d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huX, d.C0236d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.d(this.huY, d.C0236d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, d.C0236d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.huY, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bJ(VideoPlayActivityConfig.OBJ_ID, this.hvb.bxT));
        }
    }
}
