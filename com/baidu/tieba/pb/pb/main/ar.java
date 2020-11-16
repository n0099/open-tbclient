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
/* loaded from: classes21.dex */
public class ar extends af.a {
    public View devider;
    private TbPageContext eGu;
    View.OnClickListener eTp;
    private a lAk;
    public TextView lAm;
    public TextView lAn;
    public TbImageView lAo;
    public TextView lAp;
    public TextView lAq;
    public TextView lAr;
    public TextView lAs;
    public TbImageView lAt;
    public LinearLayout lAu;
    private com.baidu.tbadk.core.data.ba lAv;

    /* loaded from: classes21.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.ba baVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.eTp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(ar.this.eGu.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.lAv != null && !StringUtils.isNull(ar.this.lAv.eyK)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.eGu.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.lAk != null) {
                        ar.this.lAk.a(ar.this.lAv);
                    }
                    if (view2 == ar.this.lAs) {
                        String str = ar.this.lAv.eyK;
                        com.baidu.tbadk.core.data.av avVar = new com.baidu.tbadk.core.data.av();
                        avVar.pageContext = (TbPageContext) com.baidu.adp.base.i.I(ar.this.eGu.getPageActivity());
                        avVar.eyK = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, avVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11387").ak("obj_source", 6).dR("obj_locate", "0").dR("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", ar.this.lAv.eyK).dR("obj_locate", "3"));
                    } else if (view2 == ar.this.lAu) {
                        ar.this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.eGu.getPageActivity(), ar.this.lAv.eyK)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", ar.this.lAv.eyK).dR("obj_locate", "1"));
                    } else if (view2 == ar.this.lAn && !StringUtils.isNull(ar.this.lAv.eAu)) {
                        bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(ar.this.eGu.getPageActivity()), new String[]{ar.this.lAv.eAu});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", ar.this.lAv.eyK).dR("obj_locate", "2"));
                    }
                }
            }
        };
        this.eGu = tbPageContext;
        this.lAk = aVar;
        this.lAm = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lAn = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lAo = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lAp = (TextView) view.findViewById(R.id.novel_title);
        this.lAq = (TextView) view.findViewById(R.id.novel_author);
        this.lAr = (TextView) view.findViewById(R.id.novel_read_number);
        this.lAs = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lAu = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lAt = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lAt.setDefaultResource(R.drawable.transparent_bg);
        this.lAt.setDefaultBgResource(R.drawable.transparent_bg);
        this.lAt.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lAs.setOnClickListener(this.eTp);
        this.lAu.setOnClickListener(this.eTp);
        this.lAn.setOnClickListener(this.eTp);
    }

    public void b(com.baidu.tbadk.core.data.ba baVar) {
        if (baVar != null) {
            this.lAv = baVar;
            this.lAm.setText(baVar.eAs);
            this.lAn.setText(baVar.eAt);
            this.lAt.startLoad(baVar.eAx, 10, false);
            this.lAo.startLoad(baVar.eyM, 10, false);
            this.lAs.setText(baVar.eAw);
            this.lAp.setText(baVar.eyL);
            List<String> list = baVar.eAv;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lAq.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lAq.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lAr.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAm, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAn, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAp, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAq, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAr, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAs, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lAs, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11441").dR("obj_id", this.lAv.eyK));
        }
    }
}
