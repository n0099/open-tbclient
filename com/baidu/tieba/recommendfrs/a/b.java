package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.p;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aNr;
    private TextView aNs;
    private TextView aNt;
    private TextView aNu;
    private TextView agd;
    private int djB;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.djB = 0;
        this.aNr = (TbImageView) view.findViewById(n.f.img);
        this.agd = (TextView) view.findViewById(n.f.title);
        View findViewById = view.findViewById(n.f.hot_thread_comment);
        this.aNs = (TextView) findViewById.findViewById(n.f.hot_thread_line_tag);
        this.aNt = (TextView) findViewById.findViewById(n.f.hot_thread_line_praise);
        this.aNu = (TextView) findViewById.findViewById(n.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.e eVar) {
        super.B(eVar);
        if (eVar != null) {
            String str = (eVar.aws() == null || eVar.aws().size() <= 0) ? null : eVar.aws().get(0);
            TbImageView tbImageView = this.aNr;
            if (!eVar.awl()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.agd.setText(eVar.getTitle());
            if (StringUtils.isNull(eVar.getForumName())) {
                this.aNs.setVisibility(8);
            } else {
                this.aNs.setVisibility(0);
                this.aNs.setText(getContext().getString(n.i.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.aNs.setOnClickListener(new c(this, eVar));
            }
            this.aNt.setText(ax.v(eVar.awp()));
            this.aNu.setText(ax.v(eVar.awq()));
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mF(String.valueOf(eVar.getThreadId()))) {
                this.djB = n.c.cp_cont_c;
            } else {
                this.djB = n.c.cp_cont_b;
            }
            as.b(this.agd, this.djB, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        if (this.djB != 0 && this.agd != null) {
            as.b(this.agd, this.djB, 1);
        }
        return true;
    }
}
