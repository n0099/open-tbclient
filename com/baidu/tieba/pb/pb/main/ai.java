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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class ai extends v.a {
    View.OnClickListener bZH;
    public View devider;
    public LinearLayout hSA;
    private com.baidu.tbadk.core.data.aq hSB;
    private a hSq;
    public TextView hSs;
    public TextView hSt;
    public TbImageView hSu;
    public TextView hSv;
    public TextView hSw;
    public TextView hSx;
    public TextView hSy;
    public TbImageView hSz;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bZH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bd.cF(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.kt() && ai.this.hSB != null && !StringUtils.isNull(ai.this.hSB.bGm)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hSq != null) {
                        ai.this.hSq.a(ai.this.hSB);
                    }
                    if (view2 == ai.this.hSy) {
                        String str = ai.this.hSB.bGm;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity());
                        amVar.bGm = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bT("obj_locate", "0").bT("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hSB.bGm).bT("obj_locate", "3"));
                    } else if (view2 == ai.this.hSA) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hSB.bGm)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hSB.bGm).bT("obj_locate", "1"));
                    } else if (view2 == ai.this.hSt && !StringUtils.isNull(ai.this.hSB.bIc)) {
                        bb.ajC().c((TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity()), new String[]{ai.this.hSB.bIc});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hSB.bGm).bT("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hSq = aVar;
        this.hSs = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hSt = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hSu = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hSv = (TextView) view.findViewById(R.id.novel_title);
        this.hSw = (TextView) view.findViewById(R.id.novel_author);
        this.hSx = (TextView) view.findViewById(R.id.novel_read_number);
        this.hSy = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hSA = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hSz = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hSz.setDefaultResource(R.drawable.transparent_bg);
        this.hSz.setDefaultBgResource(R.drawable.transparent_bg);
        this.hSz.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hSy.setOnClickListener(this.bZH);
        this.hSA.setOnClickListener(this.bZH);
        this.hSt.setOnClickListener(this.bZH);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hSB = aqVar;
            this.hSs.setText(aqVar.bIa);
            this.hSt.setText(aqVar.bIb);
            this.hSz.startLoad(aqVar.bIf, 10, false);
            this.hSu.startLoad(aqVar.bGo, 10, false);
            this.hSy.setText(aqVar.bIe);
            this.hSv.setText(aqVar.bGn);
            List<String> list = aqVar.bId;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hSw.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hSw.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hSx.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.f(this.hSs, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hSt, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.f(this.hSv, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.f(this.hSw, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hSx, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hSy, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.l(this.devider, R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.k(this.hSy, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").bT(VideoPlayActivityConfig.OBJ_ID, this.hSB.bGm));
        }
    }
}
