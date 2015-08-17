package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TextView aKH;
    private TextView aKI;
    private TextView aKJ;
    private TextView aLO;
    private TextView anH;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.anH = (TextView) view.findViewById(i.f.hot_thread_item_text_title);
        this.aLO = (TextView) view.findViewById(i.f.hot_thread_item_text_desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKH = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKI = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKJ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.A(cVar);
        if (cVar != null && cVar.ajD() != null) {
            Hot_Thread ajD = cVar.ajD();
            this.anH.setText(UtilHelper.getFixedText(ajD.title, 14, true));
            this.aLO.setText(ajD._abstract);
            if (StringUtils.isNull(ajD.forum_name)) {
                this.aKH.setVisibility(8);
            } else {
                this.aKH.setVisibility(0);
                this.aKH.setText(getContext().getString(i.C0057i.chosen_pb_original_bar, UtilHelper.getFixedText(ajD.forum_name, 7, false)));
                this.aKH.setOnClickListener(new f(this, ajD));
            }
            if (ajD.zan_num != null) {
                this.aKI.setText(aq.o(ajD.zan_num.intValue()));
            }
            if (ajD.reply_num != null) {
                this.aKJ.setText(aq.o(ajD.reply_num.intValue()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
