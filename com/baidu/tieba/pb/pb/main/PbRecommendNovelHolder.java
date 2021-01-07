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
    private TbPageContext eXu;
    View.OnClickListener fko;
    private a lTl;
    public TextView lTn;
    public TextView lTo;
    public TbImageView lTp;
    public TextView lTq;
    public TextView lTr;
    public TextView lTs;
    public TextView lTt;
    public TbImageView lTu;
    public LinearLayout lTv;
    private bb lTw;

    /* loaded from: classes2.dex */
    public interface a {
        void a(bb bbVar);
    }

    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.fko = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(PbRecommendNovelHolder.this.eXu.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && PbRecommendNovelHolder.this.lTw != null && !StringUtils.isNull(PbRecommendNovelHolder.this.lTw.ePz)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(PbRecommendNovelHolder.this.eXu.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (PbRecommendNovelHolder.this.lTl != null) {
                        PbRecommendNovelHolder.this.lTl.a(PbRecommendNovelHolder.this.lTw);
                    }
                    if (view2 == PbRecommendNovelHolder.this.lTt) {
                        String str = PbRecommendNovelHolder.this.lTw.ePz;
                        aw awVar = new aw();
                        awVar.pageContext = (TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eXu.getPageActivity());
                        awVar.ePz = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, awVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").an("obj_source", 6).dX("obj_locate", "0").dX("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dX("obj_id", PbRecommendNovelHolder.this.lTw.ePz).dX("obj_locate", "3"));
                    } else if (view2 == PbRecommendNovelHolder.this.lTv) {
                        PbRecommendNovelHolder.this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(PbRecommendNovelHolder.this.eXu.getPageActivity(), PbRecommendNovelHolder.this.lTw.ePz)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dX("obj_id", PbRecommendNovelHolder.this.lTw.ePz).dX("obj_locate", "1"));
                    } else if (view2 == PbRecommendNovelHolder.this.lTo && !StringUtils.isNull(PbRecommendNovelHolder.this.lTw.eRk)) {
                        be.bwv().b((TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eXu.getPageActivity()), new String[]{PbRecommendNovelHolder.this.lTw.eRk});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dX("obj_id", PbRecommendNovelHolder.this.lTw.ePz).dX("obj_locate", "2"));
                    }
                }
            }
        };
        this.eXu = tbPageContext;
        this.lTl = aVar;
        this.lTn = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lTo = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lTp = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lTq = (TextView) view.findViewById(R.id.novel_title);
        this.lTr = (TextView) view.findViewById(R.id.novel_author);
        this.lTs = (TextView) view.findViewById(R.id.novel_read_number);
        this.lTt = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lTv = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lTu = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lTu.setDefaultResource(R.drawable.transparent_bg);
        this.lTu.setDefaultBgResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lTt.setOnClickListener(this.fko);
        this.lTv.setOnClickListener(this.fko);
        this.lTo.setOnClickListener(this.fko);
    }

    public void b(bb bbVar) {
        if (bbVar != null) {
            this.lTw = bbVar;
            this.lTn.setText(bbVar.eRi);
            this.lTo.setText(bbVar.eRj);
            this.lTu.startLoad(bbVar.eRn, 10, false);
            this.lTp.startLoad(bbVar.ePB, 10, false);
            this.lTt.setText(bbVar.eRm);
            this.lTq.setText(bbVar.ePA);
            List<String> list = bbVar.eRl;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lTr.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lTr.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lTs.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTn, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTo, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTq, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTr, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTs, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lTt, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.devider, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lTt, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dX("obj_id", this.lTw.ePz));
        }
    }
}
