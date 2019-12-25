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
/* loaded from: classes6.dex */
public class aj extends v.a {
    private TbPageContext cQU;
    View.OnClickListener dbH;
    public View devider;
    private a iHG;
    public TextView iHI;
    public TextView iHJ;
    public TbImageView iHK;
    public TextView iHL;
    public TextView iHM;
    public TextView iHN;
    public TextView iHO;
    public TbImageView iHP;
    public LinearLayout iHQ;
    private com.baidu.tbadk.core.data.at iHR;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.at atVar);
    }

    public aj(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dbH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(aj.this.cQU.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && aj.this.iHR != null && !StringUtils.isNull(aj.this.iHR.cJY)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(aj.this.cQU.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (aj.this.iHG != null) {
                        aj.this.iHG.a(aj.this.iHR);
                    }
                    if (view2 == aj.this.iHO) {
                        String str = aj.this.iHR.cJY;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(aj.this.cQU.getPageActivity());
                        aoVar.cJY = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").Z("obj_source", 6).cp("obj_locate", "0").cp("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cp("obj_id", aj.this.iHR.cJY).cp("obj_locate", "3"));
                    } else if (view2 == aj.this.iHQ) {
                        aj.this.cQU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(aj.this.cQU.getPageActivity(), aj.this.iHR.cJY)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cp("obj_id", aj.this.iHR.cJY).cp("obj_locate", "1"));
                    } else if (view2 == aj.this.iHJ && !StringUtils.isNull(aj.this.iHR.cLJ)) {
                        ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(aj.this.cQU.getPageActivity()), new String[]{aj.this.iHR.cLJ});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cp("obj_id", aj.this.iHR.cJY).cp("obj_locate", "2"));
                    }
                }
            }
        };
        this.cQU = tbPageContext;
        this.iHG = aVar;
        this.iHI = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.iHJ = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.iHK = (TbImageView) view.findViewById(R.id.novel_cover);
        this.iHL = (TextView) view.findViewById(R.id.novel_title);
        this.iHM = (TextView) view.findViewById(R.id.novel_author);
        this.iHN = (TextView) view.findViewById(R.id.novel_read_number);
        this.iHO = (TextView) view.findViewById(R.id.novel_read_btn);
        this.iHQ = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.iHP = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.iHP.setDefaultResource(R.drawable.transparent_bg);
        this.iHP.setDefaultBgResource(R.drawable.transparent_bg);
        this.iHP.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.iHO.setOnClickListener(this.dbH);
        this.iHQ.setOnClickListener(this.dbH);
        this.iHJ.setOnClickListener(this.dbH);
    }

    public void b(com.baidu.tbadk.core.data.at atVar) {
        if (atVar != null) {
            this.iHR = atVar;
            this.iHI.setText(atVar.cLH);
            this.iHJ.setText(atVar.cLI);
            this.iHP.startLoad(atVar.cLM, 10, false);
            this.iHK.startLoad(atVar.cKa, 10, false);
            this.iHO.setText(atVar.cLL);
            this.iHL.setText(atVar.cJZ);
            List<String> list = atVar.cLK;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.iHM.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.iHM.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.iHN.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iHI, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iHJ, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iHL, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iHM, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iHN, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iHO, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iHO, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cp("obj_id", this.iHR.cJY));
        }
    }
}
