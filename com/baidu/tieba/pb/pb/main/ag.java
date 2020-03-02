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
    private TbPageContext cVh;
    public View devider;
    View.OnClickListener dfY;
    private a iMH;
    public TextView iMJ;
    public TextView iMK;
    public TbImageView iML;
    public TextView iMM;
    public TextView iMN;
    public TextView iMO;
    public TextView iMP;
    public TbImageView iMQ;
    public LinearLayout iMR;
    private at iMS;

    /* loaded from: classes9.dex */
    public interface a {
        void a(at atVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dfY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.cVh.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ag.this.iMS != null && !StringUtils.isNull(ag.this.iMS.cOn)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ag.this.cVh.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ag.this.iMH != null) {
                        ag.this.iMH.a(ag.this.iMS);
                    }
                    if (view2 == ag.this.iMP) {
                        String str = ag.this.iMS.cOn;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVh.getPageActivity());
                        aoVar.cOn = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").X("obj_source", 6).cy("obj_locate", "0").cy("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iMS.cOn).cy("obj_locate", "3"));
                    } else if (view2 == ag.this.iMR) {
                        ag.this.cVh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ag.this.cVh.getPageActivity(), ag.this.iMS.cOn)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iMS.cOn).cy("obj_locate", "1"));
                    } else if (view2 == ag.this.iMK && !StringUtils.isNull(ag.this.iMS.cPX)) {
                        ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVh.getPageActivity()), new String[]{ag.this.iMS.cPX});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iMS.cOn).cy("obj_locate", "2"));
                    }
                }
            }
        };
        this.cVh = tbPageContext;
        this.iMH = aVar;
        this.iMJ = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.iMK = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.iML = (TbImageView) view.findViewById(R.id.novel_cover);
        this.iMM = (TextView) view.findViewById(R.id.novel_title);
        this.iMN = (TextView) view.findViewById(R.id.novel_author);
        this.iMO = (TextView) view.findViewById(R.id.novel_read_number);
        this.iMP = (TextView) view.findViewById(R.id.novel_read_btn);
        this.iMR = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.iMQ = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.iMQ.setDefaultResource(R.drawable.transparent_bg);
        this.iMQ.setDefaultBgResource(R.drawable.transparent_bg);
        this.iMQ.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.iMP.setOnClickListener(this.dfY);
        this.iMR.setOnClickListener(this.dfY);
        this.iMK.setOnClickListener(this.dfY);
    }

    public void b(at atVar) {
        if (atVar != null) {
            this.iMS = atVar;
            this.iMJ.setText(atVar.cPV);
            this.iMK.setText(atVar.cPW);
            this.iMQ.startLoad(atVar.cQa, 10, false);
            this.iML.startLoad(atVar.cOp, 10, false);
            this.iMP.setText(atVar.cPZ);
            this.iMM.setText(atVar.cOo);
            List<String> list = atVar.cPY;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.iMN.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.iMN.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.iMO.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMJ, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMK, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMM, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMN, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMO, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMP, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMP, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cy("obj_id", this.iMS.cOn));
        }
    }
}
