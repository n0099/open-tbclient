package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
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
public class ag extends y.a {
    View.OnClickListener dFZ;
    public View devider;
    private TbPageContext duK;
    private a jyH;
    public TextView jyJ;
    public TextView jyK;
    public TbImageView jyL;
    public TextView jyM;
    public TextView jyN;
    public TextView jyO;
    public TextView jyP;
    public TbImageView jyQ;
    public LinearLayout jyR;
    private at jyS;

    /* loaded from: classes9.dex */
    public interface a {
        void a(at atVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dFZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.duK.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ag.this.jyS != null && !StringUtils.isNull(ag.this.jyS.dnK)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ag.this.duK.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ag.this.jyH != null) {
                        ag.this.jyH.a(ag.this.jyS);
                    }
                    if (view2 == ag.this.jyP) {
                        String str = ag.this.jyS.dnK;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.G(ag.this.duK.getPageActivity());
                        aoVar.dnK = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").af("obj_source", 6).cI("obj_locate", "0").cI("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cI("obj_id", ag.this.jyS.dnK).cI("obj_locate", "3"));
                    } else if (view2 == ag.this.jyR) {
                        ag.this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ag.this.duK.getPageActivity(), ag.this.jyS.dnK)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cI("obj_id", ag.this.jyS.dnK).cI("obj_locate", "1"));
                    } else if (view2 == ag.this.jyK && !StringUtils.isNull(ag.this.jyS.dpv)) {
                        ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(ag.this.duK.getPageActivity()), new String[]{ag.this.jyS.dpv});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cI("obj_id", ag.this.jyS.dnK).cI("obj_locate", "2"));
                    }
                }
            }
        };
        this.duK = tbPageContext;
        this.jyH = aVar;
        this.jyJ = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.jyK = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.jyL = (TbImageView) view.findViewById(R.id.novel_cover);
        this.jyM = (TextView) view.findViewById(R.id.novel_title);
        this.jyN = (TextView) view.findViewById(R.id.novel_author);
        this.jyO = (TextView) view.findViewById(R.id.novel_read_number);
        this.jyP = (TextView) view.findViewById(R.id.novel_read_btn);
        this.jyR = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.jyQ = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.jyQ.setDefaultResource(R.drawable.transparent_bg);
        this.jyQ.setDefaultBgResource(R.drawable.transparent_bg);
        this.jyQ.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.jyP.setOnClickListener(this.dFZ);
        this.jyR.setOnClickListener(this.dFZ);
        this.jyK.setOnClickListener(this.dFZ);
    }

    public void b(at atVar) {
        if (atVar != null) {
            this.jyS = atVar;
            this.jyJ.setText(atVar.dpt);
            this.jyK.setText(atVar.dpu);
            this.jyQ.startLoad(atVar.dpy, 10, false);
            this.jyL.startLoad(atVar.dnM, 10, false);
            this.jyP.setText(atVar.dpx);
            this.jyM.setText(atVar.dnL);
            List<String> list = atVar.dpw;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.jyN.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.jyN.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.jyO.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyJ, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyK, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyM, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyN, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyO, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyP, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jyP, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cI("obj_id", this.jyS.dnK));
        }
    }
}
