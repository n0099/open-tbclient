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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class ag extends v.a {
    private TbPageContext cVg;
    public View devider;
    View.OnClickListener dfX;
    private a iMF;
    public TextView iMH;
    public TextView iMI;
    public TbImageView iMJ;
    public TextView iMK;
    public TextView iML;
    public TextView iMM;
    public TextView iMN;
    public TbImageView iMO;
    public LinearLayout iMP;
    private at iMQ;

    /* loaded from: classes9.dex */
    public interface a {
        void a(at atVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dfX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.cVg.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ag.this.iMQ != null && !StringUtils.isNull(ag.this.iMQ.cOm)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ag.this.cVg.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ag.this.iMF != null) {
                        ag.this.iMF.a(ag.this.iMQ);
                    }
                    if (view2 == ag.this.iMN) {
                        String str = ag.this.iMQ.cOm;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVg.getPageActivity());
                        aoVar.cOm = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").X("obj_source", 6).cy("obj_locate", "0").cy("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iMQ.cOm).cy("obj_locate", "3"));
                    } else if (view2 == ag.this.iMP) {
                        ag.this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ag.this.cVg.getPageActivity(), ag.this.iMQ.cOm)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iMQ.cOm).cy("obj_locate", "1"));
                    } else if (view2 == ag.this.iMI && !StringUtils.isNull(ag.this.iMQ.cPW)) {
                        ba.aGE().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVg.getPageActivity()), new String[]{ag.this.iMQ.cPW});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iMQ.cOm).cy("obj_locate", "2"));
                    }
                }
            }
        };
        this.cVg = tbPageContext;
        this.iMF = aVar;
        this.iMH = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.iMI = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.iMJ = (TbImageView) view.findViewById(R.id.novel_cover);
        this.iMK = (TextView) view.findViewById(R.id.novel_title);
        this.iML = (TextView) view.findViewById(R.id.novel_author);
        this.iMM = (TextView) view.findViewById(R.id.novel_read_number);
        this.iMN = (TextView) view.findViewById(R.id.novel_read_btn);
        this.iMP = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.iMO = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.iMO.setDefaultResource(R.drawable.transparent_bg);
        this.iMO.setDefaultBgResource(R.drawable.transparent_bg);
        this.iMO.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.iMN.setOnClickListener(this.dfX);
        this.iMP.setOnClickListener(this.dfX);
        this.iMI.setOnClickListener(this.dfX);
    }

    public void b(at atVar) {
        if (atVar != null) {
            this.iMQ = atVar;
            this.iMH.setText(atVar.cPU);
            this.iMI.setText(atVar.cPV);
            this.iMO.startLoad(atVar.cPZ, 10, false);
            this.iMJ.startLoad(atVar.cOo, 10, false);
            this.iMN.setText(atVar.cPY);
            this.iMK.setText(atVar.cOn);
            List<String> list = atVar.cPX;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.iML.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.iML.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.iMM.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMH, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMI, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMK, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iML, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMM, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMN, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMN, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cy("obj_id", this.iMQ.cOm));
        }
    }
}
