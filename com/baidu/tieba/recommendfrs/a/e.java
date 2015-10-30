package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TextView aCJ;
    private TextView aJX;
    private TextView aJY;
    private TextView aJZ;
    private TextView alu;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.alu = (TextView) view.findViewById(i.f.hot_thread_item_text_title);
        this.aCJ = (TextView) view.findViewById(i.f.hot_thread_item_text_desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJX = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJY = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJZ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqd() != null) {
            Hot_Thread aqd = cVar.aqd();
            this.alu.setText(UtilHelper.getFixedText(aqd.title, 14, true));
            this.aCJ.setText(aqd._abstract);
            if (StringUtils.isNull(aqd.forum_name)) {
                this.aJX.setVisibility(8);
            } else {
                this.aJX.setVisibility(0);
                this.aJX.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqd.forum_name, 7, false)));
                this.aJX.setOnClickListener(new f(this, aqd));
            }
            if (aqd.zan_num != null) {
                this.aJY.setText(as.q(aqd.zan_num.intValue()));
            }
            if (aqd.reply_num != null) {
                this.aJZ.setText(as.q(aqd.reply_num.intValue()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
