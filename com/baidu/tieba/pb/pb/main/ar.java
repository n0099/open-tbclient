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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class ar extends af.a {
    public View devider;
    private TbPageContext eNx;
    View.OnClickListener faK;
    private a lNZ;
    public TextView lOb;
    public TextView lOc;
    public TbImageView lOd;
    public TextView lOe;
    public TextView lOf;
    public TextView lOg;
    public TextView lOh;
    public TbImageView lOi;
    public LinearLayout lOj;
    private com.baidu.tbadk.core.data.bb lOk;

    /* loaded from: classes22.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.bb bbVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.faK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(ar.this.eNx.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.lOk != null && !StringUtils.isNull(ar.this.lOk.eFJ)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.eNx.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.lNZ != null) {
                        ar.this.lNZ.a(ar.this.lOk);
                    }
                    if (view2 == ar.this.lOh) {
                        String str = ar.this.lOk.eFJ;
                        com.baidu.tbadk.core.data.aw awVar = new com.baidu.tbadk.core.data.aw();
                        awVar.pageContext = (TbPageContext) com.baidu.adp.base.i.J(ar.this.eNx.getPageActivity());
                        awVar.eFJ = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, awVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11387").al("obj_source", 6).dY("obj_locate", "0").dY("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dY("obj_id", ar.this.lOk.eFJ).dY("obj_locate", "3"));
                    } else if (view2 == ar.this.lOj) {
                        ar.this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.eNx.getPageActivity(), ar.this.lOk.eFJ)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dY("obj_id", ar.this.lOk.eFJ).dY("obj_locate", "1"));
                    } else if (view2 == ar.this.lOc && !StringUtils.isNull(ar.this.lOk.eHt)) {
                        bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ar.this.eNx.getPageActivity()), new String[]{ar.this.lOk.eHt});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dY("obj_id", ar.this.lOk.eFJ).dY("obj_locate", "2"));
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.lNZ = aVar;
        this.lOb = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lOc = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lOd = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lOe = (TextView) view.findViewById(R.id.novel_title);
        this.lOf = (TextView) view.findViewById(R.id.novel_author);
        this.lOg = (TextView) view.findViewById(R.id.novel_read_number);
        this.lOh = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lOj = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lOi = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lOi.setDefaultResource(R.drawable.transparent_bg);
        this.lOi.setDefaultBgResource(R.drawable.transparent_bg);
        this.lOi.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lOh.setOnClickListener(this.faK);
        this.lOj.setOnClickListener(this.faK);
        this.lOc.setOnClickListener(this.faK);
    }

    public void b(com.baidu.tbadk.core.data.bb bbVar) {
        if (bbVar != null) {
            this.lOk = bbVar;
            this.lOb.setText(bbVar.eHr);
            this.lOc.setText(bbVar.eHs);
            this.lOi.startLoad(bbVar.eHw, 10, false);
            this.lOd.startLoad(bbVar.eFL, 10, false);
            this.lOh.setText(bbVar.eHv);
            this.lOe.setText(bbVar.eFK);
            List<String> list = bbVar.eHu;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lOf.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lOf.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lOg.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOb, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOc, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOe, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOf, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOg, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lOh, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lOh, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11441").dY("obj_id", this.lOk.eFJ));
        }
    }
}
