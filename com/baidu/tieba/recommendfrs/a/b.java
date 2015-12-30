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
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.data.j;
import com.baidu.tieba.tbadkCore.util.q;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<j, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aRk;
    private TextView aRl;
    private TextView aRm;
    private TextView aRn;
    private int dqG;
    private int dqH;
    private LineCountNotifyTextView dqI;
    private TextView dqJ;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.dqH = -1;
        this.dqG = 0;
        this.aRk = (TbImageView) view.findViewById(n.g.img);
        this.dqI = (LineCountNotifyTextView) view.findViewById(n.g.title);
        this.dqJ = (TextView) view.findViewById(n.g.discription);
        View findViewById = view.findViewById(n.g.hot_thread_comment);
        this.aRl = (TextView) findViewById.findViewById(n.g.hot_thread_line_tag);
        this.aRm = (TextView) findViewById.findViewById(n.g.hot_thread_line_praise);
        this.aRn = (TextView) findViewById.findViewById(n.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(j jVar) {
        super.B(jVar);
        if (jVar != null) {
            String str = (jVar.ayw() == null || jVar.ayw().size() <= 0) ? null : jVar.ayw().get(0);
            TbImageView tbImageView = this.aRk;
            if (!jVar.ayq()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            if (!StringUtils.isNull(jVar.getTitle())) {
                this.dqI.setText(jVar.getTitle());
                this.dqI.setGetLineCountCallback(new c(this, jVar));
            }
            if (StringUtils.isNull(jVar.getForumName())) {
                this.aRl.setVisibility(8);
            } else {
                this.aRl.setVisibility(0);
                this.aRl.setText(getContext().getString(n.j.chosen_pb_original_bar, UtilHelper.getFixedText(jVar.getForumName(), 7, false)));
                this.aRl.setOnClickListener(new d(this, jVar));
            }
            this.aRm.setText(ax.w(jVar.ayt()));
            this.aRn.setText(ax.w(jVar.ayu()));
            q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mC(String.valueOf(jVar.getThreadId()))) {
                this.dqG = n.d.cp_cont_c;
            } else {
                this.dqG = n.d.cp_cont_b;
            }
            as.b(this.dqI, this.dqG, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.dqG != 0 && this.dqI != null) {
                as.b(this.dqI, this.dqG, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
