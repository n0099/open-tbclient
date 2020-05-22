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
    private a jPW;
    public TextView jPY;
    public TextView jPZ;
    public TbImageView jQa;
    public TextView jQb;
    public TextView jQc;
    public TextView jQd;
    public TextView jQe;
    public TbImageView jQf;
    public LinearLayout jQg;
    private com.baidu.tbadk.core.data.as jQh;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.as asVar);
    }

    public an(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dUl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(an.this.dIF.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && an.this.jQh != null && !StringUtils.isNull(an.this.jQh.dBL)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(an.this.dIF.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (an.this.jPW != null) {
                        an.this.jPW.a(an.this.jQh);
                    }
                    if (view2 == an.this.jQe) {
                        String str = an.this.jQh.dBL;
                        com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                        anVar.pageContext = (TbPageContext) com.baidu.adp.base.i.G(an.this.dIF.getPageActivity());
                        anVar.dBL = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").ag("obj_source", 6).dh("obj_locate", "0").dh("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").dh("obj_id", an.this.jQh.dBL).dh("obj_locate", "3"));
                    } else if (view2 == an.this.jQg) {
                        an.this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(an.this.dIF.getPageActivity(), an.this.jQh.dBL)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").dh("obj_id", an.this.jQh.dBL).dh("obj_locate", "1"));
                    } else if (view2 == an.this.jPZ && !StringUtils.isNull(an.this.jQh.dDt)) {
                        com.baidu.tbadk.core.util.ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(an.this.dIF.getPageActivity()), new String[]{an.this.jQh.dDt});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").dh("obj_id", an.this.jQh.dBL).dh("obj_locate", "2"));
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.jPW = aVar;
        this.jPY = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.jPZ = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.jQa = (TbImageView) view.findViewById(R.id.novel_cover);
        this.jQb = (TextView) view.findViewById(R.id.novel_title);
        this.jQc = (TextView) view.findViewById(R.id.novel_author);
        this.jQd = (TextView) view.findViewById(R.id.novel_read_number);
        this.jQe = (TextView) view.findViewById(R.id.novel_read_btn);
        this.jQg = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.jQf = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.jQf.setDefaultResource(R.drawable.transparent_bg);
        this.jQf.setDefaultBgResource(R.drawable.transparent_bg);
        this.jQf.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.jQe.setOnClickListener(this.dUl);
        this.jQg.setOnClickListener(this.dUl);
        this.jPZ.setOnClickListener(this.dUl);
    }

    public void b(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null) {
            this.jQh = asVar;
            this.jPY.setText(asVar.dDr);
            this.jPZ.setText(asVar.dDs);
            this.jQf.startLoad(asVar.dDw, 10, false);
            this.jQa.startLoad(asVar.dBN, 10, false);
            this.jQe.setText(asVar.dDv);
            this.jQb.setText(asVar.dBM);
            List<String> list = asVar.dDu;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.jQc.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.jQc.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.jQd.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jPY, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jPZ, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jQb, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jQc, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jQd, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jQe, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jQe, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").dh("obj_id", this.jQh.dBL));
        }
    }
}
