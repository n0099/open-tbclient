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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class ai extends v.a {
    View.OnClickListener bYE;
    public View devider;
    private a hMc;
    public TextView hMe;
    public TextView hMf;
    public TbImageView hMg;
    public TextView hMh;
    public TextView hMi;
    public TextView hMj;
    public TextView hMk;
    public TbImageView hMl;
    public LinearLayout hMm;
    private com.baidu.tbadk.core.data.aq hMn;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bYE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cE(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ki() && ai.this.hMn != null && !StringUtils.isNull(ai.this.hMn.bFk)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hMc != null) {
                        ai.this.hMc.a(ai.this.hMn);
                    }
                    if (view2 == ai.this.hMk) {
                        String str = ai.this.hMn.bFk;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity());
                        amVar.bFk = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bT("obj_locate", "0").bT("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMn.bFk).bT("obj_locate", "3"));
                    } else if (view2 == ai.this.hMm) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hMn.bFk)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMn.bFk).bT("obj_locate", "1"));
                    } else if (view2 == ai.this.hMf && !StringUtils.isNull(ai.this.hMn.bHb)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity()), new String[]{ai.this.hMn.bHb});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMn.bFk).bT("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hMc = aVar;
        this.hMe = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hMf = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hMg = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hMh = (TextView) view.findViewById(R.id.novel_title);
        this.hMi = (TextView) view.findViewById(R.id.novel_author);
        this.hMj = (TextView) view.findViewById(R.id.novel_read_number);
        this.hMk = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hMm = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hMl = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hMl.setDefaultResource(R.drawable.transparent_bg);
        this.hMl.setDefaultBgResource(R.drawable.transparent_bg);
        this.hMl.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hMk.setOnClickListener(this.bYE);
        this.hMm.setOnClickListener(this.bYE);
        this.hMf.setOnClickListener(this.bYE);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hMn = aqVar;
            this.hMe.setText(aqVar.bGZ);
            this.hMf.setText(aqVar.bHa);
            this.hMl.startLoad(aqVar.bHe, 10, false);
            this.hMg.startLoad(aqVar.bFm, 10, false);
            this.hMk.setText(aqVar.bHd);
            this.hMh.setText(aqVar.bFl);
            List<String> list = aqVar.bHc;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hMi.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hMi.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hMj.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.f(this.hMe, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMf, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.f(this.hMh, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.f(this.hMi, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMj, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMk, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.hMk, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bT(VideoPlayActivityConfig.OBJ_ID, this.hMn.bFk));
        }
    }
}
