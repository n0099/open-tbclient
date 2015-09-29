package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TextView aCy;
    private TextView aJM;
    private TextView aJN;
    private TextView aJO;
    private TextView alt;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.alt = (TextView) view.findViewById(i.f.hot_thread_item_text_title);
        this.aCy = (TextView) view.findViewById(i.f.hot_thread_item_text_desc);
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
            this.alt.setText(UtilHelper.getFixedText(aqb.title, 14, true));
            this.aCy.setText(aqb._abstract);
            if (StringUtils.isNull(aqb.forum_name)) {
                this.aJM.setVisibility(8);
            } else {
                this.aJM.setVisibility(0);
                this.aJM.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqb.forum_name, 7, false)));
                this.aJM.setOnClickListener(new f(this, aqb));
            }
            if (aqb.zan_num != null) {
                this.aJN.setText(ar.s(aqb.zan_num.intValue()));
            }
            if (aqb.reply_num != null) {
                this.aJO.setText(ar.s(aqb.reply_num.intValue()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
