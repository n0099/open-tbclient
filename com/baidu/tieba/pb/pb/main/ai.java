package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class ai extends v.a {
    private TbPageContext ceu;
    View.OnClickListener cot;
    public View devider;
    private a hSZ;
    public TextView hTb;
    public TextView hTc;
    public TbImageView hTd;
    public TextView hTe;
    public TextView hTf;
    public TextView hTg;
    public TextView hTh;
    public TbImageView hTi;
    public LinearLayout hTj;
    private com.baidu.tbadk.core.data.aq hTk;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.cot = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ai.this.ceu.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ai.this.hTk != null && !StringUtils.isNull(ai.this.hTk.bXF)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.ceu.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hSZ != null) {
                        ai.this.hSZ.a(ai.this.hTk);
                    }
                    if (view2 == ai.this.hTh) {
                        String str = ai.this.hTk.bXF;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.ceu.getPageActivity());
                        amVar.bXF = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").O("obj_source", 6).bS("obj_locate", "0").bS("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bS("obj_id", ai.this.hTk.bXF).bS("obj_locate", "3"));
                    } else if (view2 == ai.this.hTj) {
                        ai.this.ceu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ai.this.ceu.getPageActivity(), ai.this.hTk.bXF)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bS("obj_id", ai.this.hTk.bXF).bS("obj_locate", "1"));
                    } else if (view2 == ai.this.hTc && !StringUtils.isNull(ai.this.hTk.bZr)) {
                        ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(ai.this.ceu.getPageActivity()), new String[]{ai.this.hTk.bZr});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bS("obj_id", ai.this.hTk.bXF).bS("obj_locate", "2"));
                    }
                }
            }
        };
        this.ceu = tbPageContext;
        this.hSZ = aVar;
        this.hTb = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hTc = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hTd = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hTe = (TextView) view.findViewById(R.id.novel_title);
        this.hTf = (TextView) view.findViewById(R.id.novel_author);
        this.hTg = (TextView) view.findViewById(R.id.novel_read_number);
        this.hTh = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hTj = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hTi = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hTi.setDefaultResource(R.drawable.transparent_bg);
        this.hTi.setDefaultBgResource(R.drawable.transparent_bg);
        this.hTi.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hTh.setOnClickListener(this.cot);
        this.hTj.setOnClickListener(this.cot);
        this.hTc.setOnClickListener(this.cot);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hTk = aqVar;
            this.hTb.setText(aqVar.bZp);
            this.hTc.setText(aqVar.bZq);
            this.hTi.startLoad(aqVar.bZu, 10, false);
            this.hTd.startLoad(aqVar.bXH, 10, false);
            this.hTh.setText(aqVar.bZt);
            this.hTe.setText(aqVar.bXG);
            List<String> list = aqVar.bZs;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hTf.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hTf.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hTg.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTb, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTc, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTe, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTf, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTg, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTh, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.hTh, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").bS("obj_id", this.hTk.bXF));
        }
    }
}
