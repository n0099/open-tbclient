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
    private TextView aKU;
    private TextView aKV;
    private TextView aKW;
    private TextView aMb;
    private TextView amV;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.amV = (TextView) view.findViewById(i.f.hot_thread_item_text_title);
        this.aMb = (TextView) view.findViewById(i.f.hot_thread_item_text_desc);
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
            this.amV.setText(UtilHelper.getFixedText(anJ.title, 14, true));
            this.aMb.setText(anJ._abstract);
            if (StringUtils.isNull(anJ.forum_name)) {
                this.aKU.setVisibility(8);
            } else {
                this.aKU.setVisibility(0);
                this.aKU.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(anJ.forum_name, 7, false)));
                this.aKU.setOnClickListener(new f(this, anJ));
            }
            if (anJ.zan_num != null) {
                this.aKV.setText(aq.o(anJ.zan_num.intValue()));
            }
            if (anJ.reply_num != null) {
                this.aKW.setText(aq.o(anJ.reply_num.intValue()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
