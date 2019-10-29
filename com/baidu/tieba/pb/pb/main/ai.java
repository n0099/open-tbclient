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
    private TbPageContext cfl;
    View.OnClickListener cpk;
    public View devider;
    private a hTQ;
    public TextView hTS;
    public TextView hTT;
    public TbImageView hTU;
    public TextView hTV;
    public TextView hTW;
    public TextView hTX;
    public TextView hTY;
    public TbImageView hTZ;
    public LinearLayout hUa;
    private com.baidu.tbadk.core.data.aq hUb;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.cpk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ai.this.cfl.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ai.this.hUb != null && !StringUtils.isNull(ai.this.hUb.bYw)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.cfl.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hTQ != null) {
                        ai.this.hTQ.a(ai.this.hUb);
                    }
                    if (view2 == ai.this.hTY) {
                        String str = ai.this.hUb.bYw;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.cfl.getPageActivity());
                        amVar.bYw = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").O("obj_source", 6).bS("obj_locate", "0").bS("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bS("obj_id", ai.this.hUb.bYw).bS("obj_locate", "3"));
                    } else if (view2 == ai.this.hUa) {
                        ai.this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ai.this.cfl.getPageActivity(), ai.this.hUb.bYw)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bS("obj_id", ai.this.hUb.bYw).bS("obj_locate", "1"));
                    } else if (view2 == ai.this.hTT && !StringUtils.isNull(ai.this.hUb.cai)) {
                        ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(ai.this.cfl.getPageActivity()), new String[]{ai.this.hUb.cai});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bS("obj_id", ai.this.hUb.bYw).bS("obj_locate", "2"));
                    }
                }
            }
        };
        this.cfl = tbPageContext;
        this.hTQ = aVar;
        this.hTS = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hTT = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hTU = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hTV = (TextView) view.findViewById(R.id.novel_title);
        this.hTW = (TextView) view.findViewById(R.id.novel_author);
        this.hTX = (TextView) view.findViewById(R.id.novel_read_number);
        this.hTY = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hUa = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hTZ = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hTZ.setDefaultResource(R.drawable.transparent_bg);
        this.hTZ.setDefaultBgResource(R.drawable.transparent_bg);
        this.hTZ.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hTY.setOnClickListener(this.cpk);
        this.hUa.setOnClickListener(this.cpk);
        this.hTT.setOnClickListener(this.cpk);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hUb = aqVar;
            this.hTS.setText(aqVar.cag);
            this.hTT.setText(aqVar.cah);
            this.hTZ.startLoad(aqVar.cal, 10, false);
            this.hTU.startLoad(aqVar.bYy, 10, false);
            this.hTY.setText(aqVar.cak);
            this.hTV.setText(aqVar.bYx);
            List<String> list = aqVar.caj;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hTW.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hTW.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hTX.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTS, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTT, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTV, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTW, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTX, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hTY, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.hTY, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").bS("obj_id", this.hUb.bYw));
        }
    }
}
