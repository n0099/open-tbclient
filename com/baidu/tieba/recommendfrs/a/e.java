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
    private TextView aBD;
    private TextView aIR;
    private TextView aIS;
    private TextView aIT;
    private TextView alz;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.alz = (TextView) view.findViewById(i.f.hot_thread_item_text_title);
        this.aBD = (TextView) view.findViewById(i.f.hot_thread_item_text_desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aIR = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aIS = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aIT = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqJ() != null) {
            Hot_Thread aqJ = cVar.aqJ();
            this.alz.setText(UtilHelper.getFixedText(aqJ.title, 14, true));
            this.aBD.setText(aqJ._abstract);
            if (StringUtils.isNull(aqJ.forum_name)) {
                this.aIR.setVisibility(8);
            } else {
                this.aIR.setVisibility(0);
                this.aIR.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqJ.forum_name, 7, false)));
                this.aIR.setOnClickListener(new f(this, aqJ));
            }
            if (aqJ.zan_num != null) {
                this.aIS.setText(as.q(aqJ.zan_num.intValue()));
            }
            if (aqJ.reply_num != null) {
                this.aIT.setText(as.q(aqJ.reply_num.intValue()));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
