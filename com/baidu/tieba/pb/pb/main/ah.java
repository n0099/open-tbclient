package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ah extends q.a {
    View.OnClickListener avq;
    public View devider;
    public TextView fze;
    public TextView fzf;
    public TbImageView fzg;
    public TextView fzh;
    public TextView fzi;
    public TextView fzj;
    public TextView fzk;
    public TbImageView fzl;
    public LinearLayout fzm;
    private com.baidu.tbadk.core.data.ap fzn;
    private TbPageContext mContext;

    public ah(TbPageContext tbPageContext, View view) {
        super(view);
        this.avq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.aU(ah.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jU() && ah.this.fzn != null && !StringUtils.isNull(ah.this.fzn.afi)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ah.this.mContext.getPageActivity(), d.k.book_plugin_not_install_tip);
                    } else if (view2 == ah.this.fzk) {
                        String str = ah.this.fzn.afi;
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        alVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ad(ah.this.mContext.getPageActivity());
                        alVar.afi = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ah("obj_locate", "0").ah("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ah(VideoPlayActivityConfig.OBJ_ID, ah.this.fzn.afi).ah("obj_locate", "3"));
                    } else if (view2 == ah.this.fzm) {
                        ah.this.mContext.sendMessage(new CustomMessage(2002001, new BookCoverActivityConfig(ah.this.mContext.getPageActivity(), ah.this.fzn.afi)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ah(VideoPlayActivityConfig.OBJ_ID, ah.this.fzn.afi).ah("obj_locate", "1"));
                    } else if (view2 == ah.this.fzf && !StringUtils.isNull(ah.this.fzn.agZ)) {
                        ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(ah.this.mContext.getPageActivity()), new String[]{ah.this.fzn.agZ});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11442").ah(VideoPlayActivityConfig.OBJ_ID, ah.this.fzn.afi).ah("obj_locate", "2"));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fze = (TextView) view.findViewById(d.g.textview_recommend_title);
        this.fzf = (TextView) view.findViewById(d.g.textview_recommend_option_btn);
        this.fzg = (TbImageView) view.findViewById(d.g.novel_cover);
        this.fzh = (TextView) view.findViewById(d.g.novel_title);
        this.fzi = (TextView) view.findViewById(d.g.novel_author);
        this.fzj = (TextView) view.findViewById(d.g.novel_read_number);
        this.fzk = (TextView) view.findViewById(d.g.novel_read_btn);
        this.fzm = (LinearLayout) view.findViewById(d.g.novel_recommend_item_layout);
        this.fzl = (TbImageView) view.findViewById(d.g.novel_subscription);
        this.fzl.setDefaultResource(d.f.transparent_bg);
        this.fzl.setDefaultBgResource(d.f.transparent_bg);
        this.fzl.setDefaultErrorResource(d.f.transparent_bg);
        this.devider = view.findViewById(d.g.recommend_devider);
        this.fzk.setOnClickListener(this.avq);
        this.fzm.setOnClickListener(this.avq);
        this.fzf.setOnClickListener(this.avq);
    }

    public void a(com.baidu.tbadk.core.data.ap apVar) {
        if (apVar != null) {
            this.fzn = apVar;
            this.fze.setText(apVar.agX);
            this.fzf.setText(apVar.agY);
            this.fzl.startLoad(apVar.ahc, 10, false);
            this.fzg.startLoad(apVar.afk, 10, false);
            this.fzk.setText(apVar.ahb);
            this.fzh.setText(apVar.afj);
            List<String> list = apVar.aha;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.fzi.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.fzi.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.fzj.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.al.c(this.fze, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fzf, d.C0141d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.c(this.fzh, d.C0141d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.c(this.fzi, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fzj, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.al.c(this.fzk, d.C0141d.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.al.j(this.devider, d.C0141d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(this.fzk, d.f.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11441").ah(VideoPlayActivityConfig.OBJ_ID, this.fzn.afi));
        }
    }
}
