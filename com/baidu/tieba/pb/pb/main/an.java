package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class an extends aa.a {
    private TbPageContext dIF;
    View.OnClickListener dUl;
    public View devider;
    private a jRc;
    public TextView jRe;
    public TextView jRf;
    public TbImageView jRg;
    public TextView jRh;
    public TextView jRi;
    public TextView jRj;
    public TextView jRk;
    public TbImageView jRl;
    public LinearLayout jRm;
    private com.baidu.tbadk.core.data.as jRn;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.as asVar);
    }

    public an(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dUl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(an.this.dIF.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && an.this.jRn != null && !StringUtils.isNull(an.this.jRn.dBL)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(an.this.dIF.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (an.this.jRc != null) {
                        an.this.jRc.a(an.this.jRn);
                    }
                    if (view2 == an.this.jRk) {
                        String str = an.this.jRn.dBL;
                        com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                        anVar.pageContext = (TbPageContext) com.baidu.adp.base.i.G(an.this.dIF.getPageActivity());
                        anVar.dBL = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").ag("obj_source", 6).dh("obj_locate", "0").dh("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").dh("obj_id", an.this.jRn.dBL).dh("obj_locate", "3"));
                    } else if (view2 == an.this.jRm) {
                        an.this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(an.this.dIF.getPageActivity(), an.this.jRn.dBL)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").dh("obj_id", an.this.jRn.dBL).dh("obj_locate", "1"));
                    } else if (view2 == an.this.jRf && !StringUtils.isNull(an.this.jRn.dDt)) {
                        com.baidu.tbadk.core.util.ba.aVa().b((TbPageContext) com.baidu.adp.base.i.G(an.this.dIF.getPageActivity()), new String[]{an.this.jRn.dDt});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").dh("obj_id", an.this.jRn.dBL).dh("obj_locate", "2"));
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.jRc = aVar;
        this.jRe = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.jRf = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.jRg = (TbImageView) view.findViewById(R.id.novel_cover);
        this.jRh = (TextView) view.findViewById(R.id.novel_title);
        this.jRi = (TextView) view.findViewById(R.id.novel_author);
        this.jRj = (TextView) view.findViewById(R.id.novel_read_number);
        this.jRk = (TextView) view.findViewById(R.id.novel_read_btn);
        this.jRm = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.jRl = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.jRl.setDefaultResource(R.drawable.transparent_bg);
        this.jRl.setDefaultBgResource(R.drawable.transparent_bg);
        this.jRl.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.jRk.setOnClickListener(this.dUl);
        this.jRm.setOnClickListener(this.dUl);
        this.jRf.setOnClickListener(this.dUl);
    }

    public void b(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null) {
            this.jRn = asVar;
            this.jRe.setText(asVar.dDr);
            this.jRf.setText(asVar.dDs);
            this.jRl.startLoad(asVar.dDw, 10, false);
            this.jRg.startLoad(asVar.dBN, 10, false);
            this.jRk.setText(asVar.dDv);
            this.jRh.setText(asVar.dBM);
            List<String> list = asVar.dDu;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.jRi.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.jRi.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.jRj.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRe, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRf, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRh, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRi, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRj, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jRk, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jRk, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").dh("obj_id", this.jRn.dBL));
        }
    }
}
