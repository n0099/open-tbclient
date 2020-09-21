package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes21.dex */
public class ar extends af.a {
    public View devider;
    private TbPageContext ehG;
    View.OnClickListener etM;
    private a kSf;
    public TextView kSh;
    public TextView kSi;
    public TbImageView kSj;
    public TextView kSk;
    public TextView kSl;
    public TextView kSm;
    public TextView kSn;
    public TbImageView kSo;
    public LinearLayout kSp;
    private com.baidu.tbadk.core.data.az kSq;

    /* loaded from: classes21.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.az azVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.etM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ar.this.ehG.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.kSq != null && !StringUtils.isNull(ar.this.kSq.dZY)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.ehG.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.kSf != null) {
                        ar.this.kSf.a(ar.this.kSq);
                    }
                    if (view2 == ar.this.kSn) {
                        String str = ar.this.kSq.dZY;
                        com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
                        auVar.pageContext = (TbPageContext) com.baidu.adp.base.i.I(ar.this.ehG.getPageActivity());
                        auVar.dZY = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").ai("obj_source", 6).dF("obj_locate", "0").dF("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dF("obj_id", ar.this.kSq.dZY).dF("obj_locate", "3"));
                    } else if (view2 == ar.this.kSp) {
                        ar.this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.ehG.getPageActivity(), ar.this.kSq.dZY)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dF("obj_id", ar.this.kSq.dZY).dF("obj_locate", "1"));
                    } else if (view2 == ar.this.kSi && !StringUtils.isNull(ar.this.kSq.ebI)) {
                        com.baidu.tbadk.core.util.be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(ar.this.ehG.getPageActivity()), new String[]{ar.this.kSq.ebI});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dF("obj_id", ar.this.kSq.dZY).dF("obj_locate", "2"));
                    }
                }
            }
        };
        this.ehG = tbPageContext;
        this.kSf = aVar;
        this.kSh = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.kSi = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.kSj = (TbImageView) view.findViewById(R.id.novel_cover);
        this.kSk = (TextView) view.findViewById(R.id.novel_title);
        this.kSl = (TextView) view.findViewById(R.id.novel_author);
        this.kSm = (TextView) view.findViewById(R.id.novel_read_number);
        this.kSn = (TextView) view.findViewById(R.id.novel_read_btn);
        this.kSp = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.kSo = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.kSo.setDefaultResource(R.drawable.transparent_bg);
        this.kSo.setDefaultBgResource(R.drawable.transparent_bg);
        this.kSo.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.kSn.setOnClickListener(this.etM);
        this.kSp.setOnClickListener(this.etM);
        this.kSi.setOnClickListener(this.etM);
    }

    public void b(com.baidu.tbadk.core.data.az azVar) {
        if (azVar != null) {
            this.kSq = azVar;
            this.kSh.setText(azVar.ebG);
            this.kSi.setText(azVar.ebH);
            this.kSo.startLoad(azVar.ebL, 10, false);
            this.kSj.startLoad(azVar.eaa, 10, false);
            this.kSn.setText(azVar.ebK);
            this.kSk.setText(azVar.dZZ);
            List<String> list = azVar.ebJ;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.kSl.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.kSl.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.kSm.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSh, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSi, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSk, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSl, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSm, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kSn, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kSn, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dF("obj_id", this.kSq.dZY));
        }
    }
}
