package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendfrs.data.p;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<p, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aXd;
    private TextView aXe;
    private TextView aXf;
    private TextView aXg;
    private LineCountNotifyTextView cHe;
    private TextView cHf;
    private int cHk;
    private int cHl;
    private p dZf;
    private View.OnClickListener dZg;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cHl = -1;
        this.cHk = 0;
        this.dZg = new d(this);
        view.setOnClickListener(this.dZg);
        this.aXd = (TbImageView) view.findViewById(t.g.img);
        this.cHe = (LineCountNotifyTextView) view.findViewById(t.g.title);
        this.cHf = (TextView) view.findViewById(t.g.discription);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.aXe = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.aXf = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.aXg = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(p pVar) {
        super.B(pVar);
        if (pVar != null) {
            this.dZf = pVar;
            String str = (pVar.aMp() == null || pVar.aMp().size() <= 0) ? null : pVar.aMp().get(0);
            TbImageView tbImageView = this.aXd;
            if (!pVar.aMj()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(pVar.getTitle())) {
                this.cHe.setText(pVar.getTitle());
                this.cHe.setGetLineCountCallback(new e(this, pVar));
            }
            if (StringUtils.isNull(pVar.getForumName())) {
                this.aXe.setVisibility(8);
            } else {
                this.aXe.setVisibility(0);
                this.aXe.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(pVar.getForumName(), 7, false)));
                this.aXe.setOnClickListener(new f(this, pVar));
            }
            this.aXf.setVisibility(0);
            this.aXf.setText(ay.z(pVar.aMm()));
            com.baidu.tieba.graffiti.d.af(this.aXf);
            this.aXg.setText(ay.z(pVar.aMn()));
            s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.oh(String.valueOf(pVar.getThreadId()))) {
                this.cHk = t.d.cp_cont_c;
            } else {
                this.cHk = t.d.cp_cont_b;
            }
            at.b(this.cHe, this.cHk, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cHk != 0 && this.cHe != null) {
                at.b(this.cHe, this.cHk, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
