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
    private TbImageView aDi;
    private TextView aDj;
    private TextView aDk;
    private TextView aDl;
    private View aDm;
    private TextView aiA;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aDi = (TbImageView) view.findViewById(q.img);
        this.aiA = (TextView) view.findViewById(q.title);
        this.aDm = view.findViewById(q.divider_line);
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
            String str = (ahA.pics == null || ahA.pics.size() <= 0) ? null : ahA.pics.get(0).small_pic;
            TbImageView tbImageView = this.aDi;
            if (!cVar.ahG()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            this.aiA.setText(ahA.title);
            if (StringUtils.isNull(ahA.forum_name)) {
                this.aDj.setVisibility(8);
            } else {
                this.aDj.setVisibility(0);
                this.aDj.setText(getContext().getString(t.chosen_pb_original_bar, UtilHelper.getFixedText(ahA.forum_name, 7, false)));
                this.aDj.setOnClickListener(new c(this, ahA));
            }
            if (ahA.zan_num != null) {
                this.aDk.setText(String.valueOf(ahA.zan_num));
            }
            if (ahA.reply_num != null) {
                this.aDl.setText(String.valueOf(ahA.reply_num));
            }
            this.aDm.setVisibility(0);
            com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.jL(String.valueOf(ahA.forum_id))) {
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
