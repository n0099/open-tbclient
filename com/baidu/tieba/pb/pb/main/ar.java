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
/* loaded from: classes22.dex */
public class ar extends af.a {
    public View devider;
    private TbPageContext eCn;
    View.OnClickListener eOs;
    private a ltV;
    public TextView ltX;
    public TextView ltY;
    public TbImageView ltZ;
    public TextView lua;
    public TextView lub;
    public TextView luc;
    public TextView lud;
    public TbImageView lue;
    public LinearLayout luf;
    private com.baidu.tbadk.core.data.az lug;

    /* loaded from: classes22.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.az azVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.eOs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ar.this.eCn.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.lug != null && !StringUtils.isNull(ar.this.lug.euA)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.eCn.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.ltV != null) {
                        ar.this.ltV.a(ar.this.lug);
                    }
                    if (view2 == ar.this.lud) {
                        String str = ar.this.lug.euA;
                        com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
                        auVar.pageContext = (TbPageContext) com.baidu.adp.base.i.I(ar.this.eCn.getPageActivity());
                        auVar.euA = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").aj("obj_source", 6).dR("obj_locate", "0").dR("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dR("obj_id", ar.this.lug.euA).dR("obj_locate", "3"));
                    } else if (view2 == ar.this.luf) {
                        ar.this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.eCn.getPageActivity(), ar.this.lug.euA)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dR("obj_id", ar.this.lug.euA).dR("obj_locate", "1"));
                    } else if (view2 == ar.this.ltY && !StringUtils.isNull(ar.this.lug.ewk)) {
                        com.baidu.tbadk.core.util.be.boR().b((TbPageContext) com.baidu.adp.base.i.I(ar.this.eCn.getPageActivity()), new String[]{ar.this.lug.ewk});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dR("obj_id", ar.this.lug.euA).dR("obj_locate", "2"));
                    }
                }
            }
        };
        this.eCn = tbPageContext;
        this.ltV = aVar;
        this.ltX = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.ltY = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.ltZ = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lua = (TextView) view.findViewById(R.id.novel_title);
        this.lub = (TextView) view.findViewById(R.id.novel_author);
        this.luc = (TextView) view.findViewById(R.id.novel_read_number);
        this.lud = (TextView) view.findViewById(R.id.novel_read_btn);
        this.luf = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lue = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lue.setDefaultResource(R.drawable.transparent_bg);
        this.lue.setDefaultBgResource(R.drawable.transparent_bg);
        this.lue.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lud.setOnClickListener(this.eOs);
        this.luf.setOnClickListener(this.eOs);
        this.ltY.setOnClickListener(this.eOs);
    }

    public void b(com.baidu.tbadk.core.data.az azVar) {
        if (azVar != null) {
            this.lug = azVar;
            this.ltX.setText(azVar.ewi);
            this.ltY.setText(azVar.ewj);
            this.lue.startLoad(azVar.ewn, 10, false);
            this.ltZ.startLoad(azVar.euC, 10, false);
            this.lud.setText(azVar.ewm);
            this.lua.setText(azVar.euB);
            List<String> list = azVar.ewl;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lub.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lub.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.luc.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ltX, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ltY, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lua, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lub, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.luc, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lud, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lud, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dR("obj_id", this.lug.euA));
        }
    }
}
