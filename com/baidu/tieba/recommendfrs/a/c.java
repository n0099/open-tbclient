package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TextView aJM;
    private TextView aJN;
    private TextView aJO;
    private TextView alt;
    private TbImageView cJi;
    private TbImageView cJj;
    private TbImageView cJk;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cJi = (TbImageView) view.findViewById(i.f.img1);
        this.cJj = (TbImageView) view.findViewById(i.f.img2);
        this.cJk = (TbImageView) view.findViewById(i.f.img3);
        this.alt = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJM = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJN = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJO = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqb() != null) {
            Hot_Thread aqb = cVar.aqb();
            if (aqb.pics != null && aqb.pics.size() > 0) {
                int size = aqb.pics.size();
                if (size > 0 && aqb.pics.get(0) != null) {
                    this.cJi.d(cVar.aqn() ? aqb.pics.get(0).small_pic : null, 10, false);
                }
                if (size > 1 && aqb.pics.get(1) != null) {
                    this.cJj.d(cVar.aqn() ? aqb.pics.get(1).small_pic : null, 10, false);
                }
                if (size > 2 && aqb.pics.get(2) != null) {
                    this.cJk.d(cVar.aqn() ? aqb.pics.get(2).small_pic : null, 10, false);
                }
            }
            this.alt.setText(UtilHelper.getFixedText(aqb.title, 14, true));
            if (StringUtils.isNull(aqb.forum_name)) {
                this.aJM.setVisibility(8);
            } else {
                this.aJM.setVisibility(0);
                this.aJM.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqb.forum_name, 7, false)));
                this.aJM.setOnClickListener(new d(this, aqb));
            }
            if (aqb.zan_num != null) {
                this.aJN.setText(ar.s(aqb.zan_num.intValue()));
            }
            if (aqb.reply_num != null) {
                this.aJO.setText(ar.s(aqb.reply_num.intValue()));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lI(String.valueOf(aqb.forum_id))) {
                am.b(this.alt, i.c.cp_cont_c, 1);
            } else {
                am.b(this.alt, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
