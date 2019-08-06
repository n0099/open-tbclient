package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class ai extends v.a {
    View.OnClickListener bZN;
    public View devider;
    private a hTl;
    public TextView hTn;
    public TextView hTo;
    public TbImageView hTp;
    public TextView hTq;
    public TextView hTr;
    public TextView hTs;
    public TextView hTt;
    public TbImageView hTu;
    public LinearLayout hTv;
    private com.baidu.tbadk.core.data.aq hTw;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bZN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bd.cF(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.kt() && ai.this.hTw != null && !StringUtils.isNull(ai.this.hTw.bGn)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hTl != null) {
                        ai.this.hTl.a(ai.this.hTw);
                    }
                    if (view2 == ai.this.hTt) {
                        String str = ai.this.hTw.bGn;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity());
                        amVar.bGn = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bT("obj_locate", "0").bT("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hTw.bGn).bT("obj_locate", "3"));
                    } else if (view2 == ai.this.hTv) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hTw.bGn)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hTw.bGn).bT("obj_locate", "1"));
                    } else if (view2 == ai.this.hTo && !StringUtils.isNull(ai.this.hTw.bId)) {
                        bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity()), new String[]{ai.this.hTw.bId});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hTw.bGn).bT("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hTl = aVar;
        this.hTn = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hTo = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hTp = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hTq = (TextView) view.findViewById(R.id.novel_title);
        this.hTr = (TextView) view.findViewById(R.id.novel_author);
        this.hTs = (TextView) view.findViewById(R.id.novel_read_number);
        this.hTt = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hTv = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hTu = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hTu.setDefaultResource(R.drawable.transparent_bg);
        this.hTu.setDefaultBgResource(R.drawable.transparent_bg);
        this.hTu.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hTt.setOnClickListener(this.bZN);
        this.hTv.setOnClickListener(this.bZN);
        this.hTo.setOnClickListener(this.bZN);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hTw = aqVar;
            this.hTn.setText(aqVar.bIb);
            this.hTo.setText(aqVar.bIc);
            this.hTu.startLoad(aqVar.bIg, 10, false);
            this.hTp.startLoad(aqVar.bGp, 10, false);
            this.hTt.setText(aqVar.bIf);
            this.hTq.setText(aqVar.bGo);
            List<String> list = aqVar.bIe;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hTr.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hTr.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hTs.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.f(this.hTn, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hTo, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.f(this.hTq, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.f(this.hTr, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hTs, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.f(this.hTt, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.l(this.devider, R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.k(this.hTt, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").bT(VideoPlayActivityConfig.OBJ_ID, this.hTw.bGn));
        }
    }
}
