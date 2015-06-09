package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.e.c> {
    private TextView aDk;
    private TextView aDl;
    private TextView aDm;
    private TextView aEp;
    private TextView aiA;

    public f(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aiA = (TextView) view.findViewById(q.hot_thread_item_text_title);
        this.aEp = (TextView) view.findViewById(q.hot_thread_item_text_desc);
        View findViewById = view.findViewById(q.hot_thread_comment);
        this.aDk = (TextView) findViewById.findViewById(q.hot_thread_line_tag);
        this.aDl = (TextView) findViewById.findViewById(q.hot_thread_line_praise);
        this.aDm = (TextView) findViewById.findViewById(q.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.z(cVar);
        if (cVar != null && cVar.ahB() != null) {
            Hot_Thread ahB = cVar.ahB();
            this.aiA.setText(UtilHelper.getFixedText(ahB.title, 14, true));
            this.aEp.setText(ahB._abstract);
            if (StringUtils.isNull(ahB.forum_name)) {
                this.aDk.setVisibility(8);
            } else {
                this.aDk.setVisibility(0);
                this.aDk.setText(getContext().getString(t.chosen_pb_original_bar, UtilHelper.getFixedText(ahB.forum_name, 7, false)));
                this.aDk.setOnClickListener(new g(this, ahB));
            }
            if (ahB.zan_num != null) {
                this.aDl.setText(String.valueOf(ahB.zan_num));
            }
            if (ahB.reply_num != null) {
                this.aDm.setText(String.valueOf(ahB.reply_num));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
