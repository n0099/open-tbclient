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
    private a hLZ;
    public TextView hMb;
    public TextView hMc;
    public TbImageView hMd;
    public TextView hMe;
    public TextView hMf;
    public TextView hMg;
    public TextView hMh;
    public TbImageView hMi;
    public LinearLayout hMj;
    private com.baidu.tbadk.core.data.aq hMk;
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
                if (bc.cE(ai.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ki() && ai.this.hMk != null && !StringUtils.isNull(ai.this.hMk.bFk)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ai.this.mContext.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ai.this.hLZ != null) {
                        ai.this.hLZ.a(ai.this.hMk);
                    }
                    if (view2 == ai.this.hMh) {
                        String str = ai.this.hMk.bFk;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity());
                        amVar.bFk = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).bT("obj_locate", "0").bT("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMk.bFk).bT("obj_locate", "3"));
                    } else if (view2 == ai.this.hMj) {
                        ai.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ai.this.mContext.getPageActivity(), ai.this.hMk.bFk)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMk.bFk).bT("obj_locate", "1"));
                    } else if (view2 == ai.this.hMc && !StringUtils.isNull(ai.this.hMk.bHb)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ai.this.mContext.getPageActivity()), new String[]{ai.this.hMk.bHb});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").bT(VideoPlayActivityConfig.OBJ_ID, ai.this.hMk.bFk).bT("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hLZ = aVar;
        this.hMb = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.hMc = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.hMd = (TbImageView) view.findViewById(R.id.novel_cover);
        this.hMe = (TextView) view.findViewById(R.id.novel_title);
        this.hMf = (TextView) view.findViewById(R.id.novel_author);
        this.hMg = (TextView) view.findViewById(R.id.novel_read_number);
        this.hMh = (TextView) view.findViewById(R.id.novel_read_btn);
        this.hMj = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.hMi = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.hMi.setDefaultResource(R.drawable.transparent_bg);
        this.hMi.setDefaultBgResource(R.drawable.transparent_bg);
        this.hMi.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.hMh.setOnClickListener(this.bYE);
        this.hMj.setOnClickListener(this.bYE);
        this.hMc.setOnClickListener(this.bYE);
    }

    public void b(com.baidu.tbadk.core.data.aq aqVar) {
        if (aqVar != null) {
            this.hMk = aqVar;
            this.hMb.setText(aqVar.bGZ);
            this.hMc.setText(aqVar.bHa);
            this.hMi.startLoad(aqVar.bHe, 10, false);
            this.hMd.startLoad(aqVar.bFm, 10, false);
            this.hMh.setText(aqVar.bHd);
            this.hMe.setText(aqVar.bFl);
            List<String> list = aqVar.bHc;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.hMf.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.hMf.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.hMg.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.f(this.hMb, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMc, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.f(this.hMe, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.f(this.hMf, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMg, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.f(this.hMh, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.l(this.devider, R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.k(this.hMh, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").bT(VideoPlayActivityConfig.OBJ_ID, this.hMk.bFk));
        }
    }
}
