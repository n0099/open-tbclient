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
    View.OnClickListener bYF;
    public View devider;
    private a hMd;
    public TextView hMf;
    public TextView hMg;
    public TbImageView hMh;
    public TextView hMi;
    public TextView hMj;
    public TextView hMk;
    public TextView hMl;
    public TbImageView hMm;
    public LinearLayout hMn;
    private com.baidu.tbadk.core.data.aq hMo;
    private TbPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.aq aqVar);
    }

    public ai(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.bYF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ai.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cE(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ki() && ai.this.hMo != null && !StringUtils.isNull(ai.this.hMo.bFl)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hMd != null) {
                        ai.this.hMd.a(ai.this.hMo);
                    }
                    if (view2 == ai.this.hMl) {
                        String str = ai.this.hMo.bFl;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity());
                        amVar.bFl = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bT("obj_locate", "0").bT("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMo.bFl).bT("obj_locate", "3"));
                    } else if (view2 == ai.this.hMn) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hMo.bFl)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMo.bFl).bT("obj_locate", "1"));
                    } else if (view2 == ai.this.hMg && !StringUtils.isNull(ai.this.hMo.bHc)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity()), new String[]{ai.this.hMo.bHc});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMo.bFl).bT("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hMd = aVar;
        this.hMf = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hMg = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hMh = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hMi = (TextView) view.findViewById(R.id.novel_title);
        this.hMj = (TextView) view.findViewById(R.id.novel_author);
        this.hMk = (TextView) view.findViewById(R.id.novel_read_number);
        this.hMl = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hMn = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hMm = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hMm.setDefaultResource(R.drawable.transparent_bg);
        this.hMm.setDefaultBgResource(R.drawable.transparent_bg);
        this.hMm.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hMl.setOnClickListener(this.bYF);
        this.hMn.setOnClickListener(this.bYF);
        this.hMg.setOnClickListener(this.bYF);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hMo = aqVar;
            this.hMf.setText(aqVar.bHa);
            this.hMg.setText(aqVar.bHb);
            this.hMm.startLoad(aqVar.bHf, 10, false);
            this.hMh.startLoad(aqVar.bFn, 10, false);
            this.hMl.setText(aqVar.bHe);
            this.hMi.setText(aqVar.bFm);
            List<String> list = aqVar.bHd;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hMj.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hMj.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hMk.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.f(this.hMf, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMg, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.f(this.hMi, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.f(this.hMj, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMk, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMl, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.hMl, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bT(VideoPlayActivityConfig.OBJ_ID, this.hMo.bFl));
        }
    }
}
