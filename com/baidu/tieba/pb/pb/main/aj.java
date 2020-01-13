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
/* loaded from: classes7.dex */
public class aj extends v.a {
    private TbPageContext cRe;
    View.OnClickListener dbS;
    public View devider;
    private a iLk;
    public TextView iLm;
    public TextView iLn;
    public TbImageView iLo;
    public TextView iLp;
    public TextView iLq;
    public TextView iLr;
    public TextView iLs;
    public TbImageView iLt;
    public LinearLayout iLu;
    private com.baidu.tbadk.core.data.at iLv;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.at atVar);
    }

    public aj(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dbS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(aj.this.cRe.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && aj.this.iLv != null && !StringUtils.isNull(aj.this.iLv.cKj)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(aj.this.cRe.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (aj.this.iLk != null) {
                        aj.this.iLk.a(aj.this.iLv);
                    }
                    if (view2 == aj.this.iLs) {
                        String str = aj.this.iLv.cKj;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(aj.this.cRe.getPageActivity());
                        aoVar.cKj = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").Z("obj_source", 6).cp("obj_locate", "0").cp("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cp("obj_id", aj.this.iLv.cKj).cp("obj_locate", "3"));
                    } else if (view2 == aj.this.iLu) {
                        aj.this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(aj.this.cRe.getPageActivity(), aj.this.iLv.cKj)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cp("obj_id", aj.this.iLv.cKj).cp("obj_locate", "1"));
                    } else if (view2 == aj.this.iLn && !StringUtils.isNull(aj.this.iLv.cLT)) {
                        ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(aj.this.cRe.getPageActivity()), new String[]{aj.this.iLv.cLT});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cp("obj_id", aj.this.iLv.cKj).cp("obj_locate", "2"));
                    }
                }
            }
        };
        this.cRe = tbPageContext;
        this.iLk = aVar;
        this.iLm = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.iLn = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.iLo = (TbImageView) view.findViewById(R.id.novel_cover);
        this.iLp = (TextView) view.findViewById(R.id.novel_title);
        this.iLq = (TextView) view.findViewById(R.id.novel_author);
        this.iLr = (TextView) view.findViewById(R.id.novel_read_number);
        this.iLs = (TextView) view.findViewById(R.id.novel_read_btn);
        this.iLu = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.iLt = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.iLt.setDefaultResource(R.drawable.transparent_bg);
        this.iLt.setDefaultBgResource(R.drawable.transparent_bg);
        this.iLt.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.iLs.setOnClickListener(this.dbS);
        this.iLu.setOnClickListener(this.dbS);
        this.iLn.setOnClickListener(this.dbS);
    }

    public void b(com.baidu.tbadk.core.data.at atVar) {
        if (atVar != null) {
            this.iLv = atVar;
            this.iLm.setText(atVar.cLR);
            this.iLn.setText(atVar.cLS);
            this.iLt.startLoad(atVar.cLW, 10, false);
            this.iLo.startLoad(atVar.cKl, 10, false);
            this.iLs.setText(atVar.cLV);
            this.iLp.setText(atVar.cKk);
            List<String> list = atVar.cLU;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.iLq.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.iLq.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.iLr.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLm, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLn, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLp, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLq, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLr, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iLs, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iLs, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cp("obj_id", this.iLv.cKj));
        }
    }
}
