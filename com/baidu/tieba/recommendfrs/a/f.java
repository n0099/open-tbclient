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
    private TextView aDj;
    private TextView aDk;
    private TextView aDl;
    private TextView aEo;
    private TextView aiA;

    public f(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aiA = (TextView) view.findViewById(q.hot_thread_item_text_title);
        this.aEo = (TextView) view.findViewById(q.hot_thread_item_text_desc);
        View findViewById = view.findViewById(q.hot_thread_comment);
        this.aDj = (TextView) findViewById.findViewById(q.hot_thread_line_tag);
        this.aDk = (TextView) findViewById.findViewById(q.hot_thread_line_praise);
        this.aDl = (TextView) findViewById.findViewById(q.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.z(cVar);
        if (cVar != null && cVar.ahA() != null) {
            Hot_Thread ahA = cVar.ahA();
            this.aiA.setText(UtilHelper.getFixedText(ahA.title, 14, true));
            this.aEo.setText(ahA._abstract);
            if (StringUtils.isNull(ahA.forum_name)) {
                this.aDj.setVisibility(8);
            } else {
                this.aDj.setVisibility(0);
                this.aDj.setText(getContext().getString(t.chosen_pb_original_bar, UtilHelper.getFixedText(ahA.forum_name, 7, false)));
                this.aDj.setOnClickListener(new g(this, ahA));
            }
            if (ahA.zan_num != null) {
                this.aDk.setText(String.valueOf(ahA.zan_num));
            }
            if (ahA.reply_num != null) {
                this.aDl.setText(String.valueOf(ahA.reply_num));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
