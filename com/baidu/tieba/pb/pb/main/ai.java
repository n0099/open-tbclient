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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class ai extends v.a {
    View.OnClickListener caG;
    public View devider;
    private a hVi;
    public TextView hVk;
    public TextView hVl;
    public TbImageView hVm;
    public TextView hVn;
    public TextView hVo;
    public TextView hVp;
    public TextView hVq;
    public TbImageView hVr;
    public LinearLayout hVs;
    private com.baidu.tbadk.core.data.aq hVt;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.caG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cF(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.kt() && ai.this.hVt != null && !StringUtils.isNull(ai.this.hVt.bGL)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hVi != null) {
                        ai.this.hVi.a(ai.this.hVt);
                    }
                    if (view2 == ai.this.hVq) {
                        String str = ai.this.hVt.bGL;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity());
                        amVar.bGL = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bT("obj_locate", "0").bT("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hVt.bGL).bT("obj_locate", "3"));
                    } else if (view2 == ai.this.hVs) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hVt.bGL)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hVt.bGL).bT("obj_locate", "1"));
                    } else if (view2 == ai.this.hVl && !StringUtils.isNull(ai.this.hVt.bIB)) {
                        ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity()), new String[]{ai.this.hVt.bIB});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hVt.bGL).bT("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hVi = aVar;
        this.hVk = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hVl = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hVm = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hVn = (TextView) view.findViewById(R.id.novel_title);
        this.hVo = (TextView) view.findViewById(R.id.novel_author);
        this.hVp = (TextView) view.findViewById(R.id.novel_read_number);
        this.hVq = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hVs = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hVr = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hVr.setDefaultResource(R.drawable.transparent_bg);
        this.hVr.setDefaultBgResource(R.drawable.transparent_bg);
        this.hVr.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hVq.setOnClickListener(this.caG);
        this.hVs.setOnClickListener(this.caG);
        this.hVl.setOnClickListener(this.caG);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hVt = aqVar;
            this.hVk.setText(aqVar.bIz);
            this.hVl.setText(aqVar.bIA);
            this.hVr.startLoad(aqVar.bIE, 10, false);
            this.hVm.startLoad(aqVar.bGN, 10, false);
            this.hVq.setText(aqVar.bID);
            this.hVn.setText(aqVar.bGM);
            List<String> list = aqVar.bIC;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hVo.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hVo.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hVp.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.f(this.hVk, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hVl, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.f(this.hVn, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.f(this.hVo, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hVp, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hVq, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.l(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.k(this.hVq, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").bT(VideoPlayActivityConfig.OBJ_ID, this.hVt.bGL));
        }
    }
}
