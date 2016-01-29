package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendfrs.data.l;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.r;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<l, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aTr;
    private TextView aTs;
    private TextView aTt;
    private TextView aTu;
    private int dGH;
    private l dGI;
    private View.OnClickListener dGJ;
    private int dGL;
    private LineCountNotifyTextView dGM;
    private TextView dGN;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.dGL = -1;
        this.dGH = 0;
        this.dGJ = new d(this);
        view.setOnClickListener(this.dGJ);
        this.aTr = (TbImageView) view.findViewById(t.g.img);
        this.dGM = (LineCountNotifyTextView) view.findViewById(t.g.title);
        this.dGN = (TextView) view.findViewById(t.g.discription);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.aTs = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.aTt = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.aTu = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(l lVar) {
        super.B(lVar);
        if (lVar != null) {
            this.dGI = lVar;
            String str = (lVar.aFB() == null || lVar.aFB().size() <= 0) ? null : lVar.aFB().get(0);
            TbImageView tbImageView = this.aTr;
            if (!lVar.aFv()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            if (!StringUtils.isNull(lVar.getTitle())) {
                this.dGM.setText(lVar.getTitle());
                this.dGM.setGetLineCountCallback(new e(this, lVar));
            }
            if (StringUtils.isNull(lVar.getForumName())) {
                this.aTs.setVisibility(8);
            } else {
                this.aTs.setVisibility(0);
                this.aTs.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(lVar.getForumName(), 7, false)));
                this.aTs.setOnClickListener(new f(this, lVar));
            }
            this.aTt.setText(aw.x(lVar.aFy()));
            this.aTu.setText(aw.x(lVar.aFz()));
            r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mU(String.valueOf(lVar.getThreadId()))) {
                this.dGH = t.d.cp_cont_c;
            } else {
                this.dGH = t.d.cp_cont_b;
            }
            ar.b(this.dGM, this.dGH, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.dGH != 0 && this.dGM != null) {
                ar.b(this.dGM, this.dGH, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
