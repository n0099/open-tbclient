package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.e.c> {
    private TbImageView aDj;
    private TextView aDk;
    private TextView aDl;
    private TextView aDm;
    private View aDn;
    private TextView aiA;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aDj = (TbImageView) view.findViewById(q.img);
        this.aiA = (TextView) view.findViewById(q.title);
        this.aDn = view.findViewById(q.divider_line);
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
            String str = (ahB.pics == null || ahB.pics.size() <= 0) ? null : ahB.pics.get(0).small_pic;
            TbImageView tbImageView = this.aDj;
            if (!cVar.ahH()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            this.aiA.setText(ahB.title);
            if (StringUtils.isNull(ahB.forum_name)) {
                this.aDk.setVisibility(8);
            } else {
                this.aDk.setVisibility(0);
                this.aDk.setText(getContext().getString(t.chosen_pb_original_bar, UtilHelper.getFixedText(ahB.forum_name, 7, false)));
                this.aDk.setOnClickListener(new c(this, ahB));
            }
            if (ahB.zan_num != null) {
                this.aDl.setText(String.valueOf(ahB.zan_num));
            }
            if (ahB.reply_num != null) {
                this.aDm.setText(String.valueOf(ahB.reply_num));
            }
            this.aDn.setVisibility(0);
            com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.jL(String.valueOf(ahB.forum_id))) {
                ay.b(this.aiA, n.cp_cont_d, 1);
            } else {
                ay.b(this.aiA, n.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
