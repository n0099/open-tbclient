package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TextView aKU;
    private TextView aKV;
    private TextView aKW;
    private TextView amV;
    private TbImageView cCh;
    private TbImageView cCi;
    private TbImageView cCj;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cCh = (TbImageView) view.findViewById(i.f.img1);
        this.cCi = (TbImageView) view.findViewById(i.f.img2);
        this.cCj = (TbImageView) view.findViewById(i.f.img3);
        this.amV = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKU = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKV = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKW = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.anJ() != null) {
            Hot_Thread anJ = cVar.anJ();
            if (anJ.pics != null && anJ.pics.size() > 0) {
                int size = anJ.pics.size();
                if (size > 0 && anJ.pics.get(0) != null) {
                    this.cCh.d(cVar.anV() ? anJ.pics.get(0).small_pic : null, 10, false);
                }
                if (size > 1 && anJ.pics.get(1) != null) {
                    this.cCi.d(cVar.anV() ? anJ.pics.get(1).small_pic : null, 10, false);
                }
                if (size > 2 && anJ.pics.get(2) != null) {
                    this.cCj.d(cVar.anV() ? anJ.pics.get(2).small_pic : null, 10, false);
                }
            }
            this.amV.setText(UtilHelper.getFixedText(anJ.title, 14, true));
            if (StringUtils.isNull(anJ.forum_name)) {
                this.aKU.setVisibility(8);
            } else {
                this.aKU.setVisibility(0);
                this.aKU.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(anJ.forum_name, 7, false)));
                this.aKU.setOnClickListener(new d(this, anJ));
            }
            if (anJ.zan_num != null) {
                this.aKV.setText(aq.o(anJ.zan_num.intValue()));
            }
            if (anJ.reply_num != null) {
                this.aKW.setText(aq.o(anJ.reply_num.intValue()));
            }
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lj(String.valueOf(anJ.forum_id))) {
                al.b(this.amV, i.c.cp_cont_c, 1);
            } else {
                al.b(this.amV, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
