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
    private TbPageContext cVi;
    public View devider;
    View.OnClickListener dgl;
    private a iMT;
    public TextView iMV;
    public TextView iMW;
    public TbImageView iMX;
    public TextView iMY;
    public TextView iMZ;
    public TextView iNa;
    public TextView iNb;
    public TbImageView iNc;
    public LinearLayout iNd;
    private at iNe;

    /* loaded from: classes9.dex */
    public interface a {
        void a(at atVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dgl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.cVi.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ag.this.iNe != null && !StringUtils.isNull(ag.this.iNe.cOo)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ag.this.cVi.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ag.this.iMT != null) {
                        ag.this.iMT.a(ag.this.iNe);
                    }
                    if (view2 == ag.this.iNb) {
                        String str = ag.this.iNe.cOo;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVi.getPageActivity());
                        aoVar.cOo = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").X("obj_source", 6).cy("obj_locate", "0").cy("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iNe.cOo).cy("obj_locate", "3"));
                    } else if (view2 == ag.this.iNd) {
                        ag.this.cVi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ag.this.cVi.getPageActivity(), ag.this.iNe.cOo)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iNe.cOo).cy("obj_locate", "1"));
                    } else if (view2 == ag.this.iMW && !StringUtils.isNull(ag.this.iNe.cPY)) {
                        ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVi.getPageActivity()), new String[]{ag.this.iNe.cPY});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cy("obj_id", ag.this.iNe.cOo).cy("obj_locate", "2"));
                    }
                }
            }
        };
        this.cVi = tbPageContext;
        this.iMT = aVar;
        this.iMV = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.iMW = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.iMX = (TbImageView) view.findViewById(R.id.novel_cover);
        this.iMY = (TextView) view.findViewById(R.id.novel_title);
        this.iMZ = (TextView) view.findViewById(R.id.novel_author);
        this.iNa = (TextView) view.findViewById(R.id.novel_read_number);
        this.iNb = (TextView) view.findViewById(R.id.novel_read_btn);
        this.iNd = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.iNc = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.iNc.setDefaultResource(R.drawable.transparent_bg);
        this.iNc.setDefaultBgResource(R.drawable.transparent_bg);
        this.iNc.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.iNb.setOnClickListener(this.dgl);
        this.iNd.setOnClickListener(this.dgl);
        this.iMW.setOnClickListener(this.dgl);
    }

    public void b(at atVar) {
        if (atVar != null) {
            this.iNe = atVar;
            this.iMV.setText(atVar.cPW);
            this.iMW.setText(atVar.cPX);
            this.iNc.startLoad(atVar.cQb, 10, false);
            this.iMX.startLoad(atVar.cOq, 10, false);
            this.iNb.setText(atVar.cQa);
            this.iMY.setText(atVar.cOp);
            List<String> list = atVar.cPZ;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.iMZ.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.iMZ.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.iNa.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMV, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMW, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMY, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iMZ, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNa, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNb, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iNb, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cy("obj_id", this.iNe.cOo));
        }
    }
}
