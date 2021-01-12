package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {
    public View devider;
    private TbPageContext eSJ;
    View.OnClickListener ffD;
    private a lOH;
    public TextView lOJ;
    public TextView lOK;
    public TbImageView lOL;
    public TextView lOM;
    public TextView lON;
    public TextView lOO;
    public TextView lOP;
    public TbImageView lOQ;
    public LinearLayout lOR;
    private bb lOS;

    /* loaded from: classes2.dex */
    public interface a {
        void a(bb bbVar);
    }

    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.ffD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(PbRecommendNovelHolder.this.eSJ.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && PbRecommendNovelHolder.this.lOS != null && !StringUtils.isNull(PbRecommendNovelHolder.this.lOS.eKO)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(PbRecommendNovelHolder.this.eSJ.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (PbRecommendNovelHolder.this.lOH != null) {
                        PbRecommendNovelHolder.this.lOH.a(PbRecommendNovelHolder.this.lOS);
                    }
                    if (view2 == PbRecommendNovelHolder.this.lOP) {
                        String str = PbRecommendNovelHolder.this.lOS.eKO;
                        aw awVar = new aw();
                        awVar.pageContext = (TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eSJ.getPageActivity());
                        awVar.eKO = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, awVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").an("obj_source", 6).dW("obj_locate", "0").dW("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dW("obj_id", PbRecommendNovelHolder.this.lOS.eKO).dW("obj_locate", "3"));
                    } else if (view2 == PbRecommendNovelHolder.this.lOR) {
                        PbRecommendNovelHolder.this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(PbRecommendNovelHolder.this.eSJ.getPageActivity(), PbRecommendNovelHolder.this.lOS.eKO)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dW("obj_id", PbRecommendNovelHolder.this.lOS.eKO).dW("obj_locate", "1"));
                    } else if (view2 == PbRecommendNovelHolder.this.lOK && !StringUtils.isNull(PbRecommendNovelHolder.this.lOS.eMz)) {
                        be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eSJ.getPageActivity()), new String[]{PbRecommendNovelHolder.this.lOS.eMz});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dW("obj_id", PbRecommendNovelHolder.this.lOS.eKO).dW("obj_locate", "2"));
                    }
                }
            }
        };
        this.eSJ = tbPageContext;
        this.lOH = aVar;
        this.lOJ = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lOK = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lOL = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lOM = (TextView) view.findViewById(R.id.novel_title);
        this.lON = (TextView) view.findViewById(R.id.novel_author);
        this.lOO = (TextView) view.findViewById(R.id.novel_read_number);
        this.lOP = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lOR = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lOQ = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lOQ.setDefaultResource(R.drawable.transparent_bg);
        this.lOQ.setDefaultBgResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lOP.setOnClickListener(this.ffD);
        this.lOR.setOnClickListener(this.ffD);
        this.lOK.setOnClickListener(this.ffD);
    }

    public void b(bb bbVar) {
        if (bbVar != null) {
            this.lOS = bbVar;
            this.lOJ.setText(bbVar.eMx);
            this.lOK.setText(bbVar.eMy);
            this.lOQ.startLoad(bbVar.eMC, 10, false);
            this.lOL.startLoad(bbVar.eKQ, 10, false);
            this.lOP.setText(bbVar.eMB);
            this.lOM.setText(bbVar.eKP);
            List<String> list = bbVar.eMA;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lON.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lON.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lOO.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lOJ, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lOK, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lOM, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lON, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lOO, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lOP, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.devider, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lOP, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dW("obj_id", this.lOS.eKO));
        }
    }
}
