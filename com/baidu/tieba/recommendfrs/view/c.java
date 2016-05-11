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
    private TbImageView aSX;
    private TextView aSY;
    private TextView aSZ;
    private TextView aTa;
    private LineCountNotifyTextView cHp;
    private TextView cHq;
    private int cHv;
    private int cHw;
    private p ecm;
    private View.OnClickListener ecn;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cHw = -1;
        this.cHv = 0;
        this.ecn = new d(this);
        view.setOnClickListener(this.ecn);
        this.aSX = (TbImageView) view.findViewById(t.g.img);
        this.cHp = (LineCountNotifyTextView) view.findViewById(t.g.title);
        this.cHq = (TextView) view.findViewById(t.g.discription);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.aSY = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.aSZ = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.aTa = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(p pVar) {
        super.B(pVar);
        if (pVar != null) {
            this.ecm = pVar;
            String str = (pVar.aMA() == null || pVar.aMA().size() <= 0) ? null : pVar.aMA().get(0);
            TbImageView tbImageView = this.aSX;
            if (!pVar.aMu()) {
                str = null;
            }
            tbImageView.c(str, 10, false);
            if (!StringUtils.isNull(pVar.getTitle())) {
                this.cHp.setText(pVar.getTitle());
                this.cHp.setGetLineCountCallback(new e(this, pVar));
            }
            if (StringUtils.isNull(pVar.getForumName())) {
                this.aSY.setVisibility(8);
            } else {
                this.aSY.setVisibility(0);
                this.aSY.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(pVar.getForumName(), 7, false)));
                this.aSY.setOnClickListener(new f(this, pVar));
            }
            this.aSZ.setVisibility(0);
            this.aSZ.setText(ay.A(pVar.aMx()));
            com.baidu.tieba.graffiti.d.aj(this.aSZ);
            this.aTa.setText(ay.A(pVar.aMy()));
            s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.od(String.valueOf(pVar.getThreadId()))) {
                this.cHv = t.d.cp_cont_c;
            } else {
                this.cHv = t.d.cp_cont_b;
            }
            at.c(this.cHp, this.cHv, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cHv != 0 && this.cHp != null) {
                at.c(this.cHp, this.cHv, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
