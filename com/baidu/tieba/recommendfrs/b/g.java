package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendfrs.data.l;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<l, com.baidu.tbadk.mvc.d.b> {
    private TextView aTs;
    private TextView aTt;
    private TextView aTu;
    private TextView apm;
    private int dGH;
    private l dGI;
    private View.OnClickListener dGJ;
    private TbImageView dGQ;
    private TbImageView dGR;
    private TbImageView dGS;
    private List<TbImageView> dGT;
    private final int dGU;
    private int mSkinType;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.dGU = 3;
        this.dGH = 0;
        this.dGJ = new h(this);
        view.setOnClickListener(this.dGJ);
        this.dGQ = (TbImageView) view.findViewById(t.g.img1);
        this.dGR = (TbImageView) view.findViewById(t.g.img2);
        this.dGS = (TbImageView) view.findViewById(t.g.img3);
        this.apm = (TextView) view.findViewById(t.g.title);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.aTs = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.aTt = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.aTu = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
        this.dGT = new ArrayList();
        this.dGT.add(this.dGQ);
        this.dGT.add(this.dGR);
        this.dGT.add(this.dGS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(l lVar) {
        super.B(lVar);
        if (lVar != null) {
            this.dGI = lVar;
            if (lVar.aFB() != null) {
                List<String> aFB = lVar.aFB();
                if (aFB.size() > 3) {
                    aFB.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) x.b(aFB, i);
                    TbImageView tbImageView = this.dGT.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!lVar.aFv()) {
                            str = null;
                        }
                        tbImageView.d(str, 10, false);
                    }
                }
            }
            this.apm.setText(lVar.getTitle());
            this.aTt.setText(aw.x(lVar.aFy()));
            this.aTu.setText(aw.x(lVar.aFz()));
            if (StringUtils.isNull(lVar.getForumName())) {
                this.aTs.setVisibility(8);
            } else {
                this.aTs.setVisibility(0);
                this.aTs.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(lVar.getForumName(), 7, false)));
                this.aTs.setOnClickListener(new i(this, lVar));
            }
            r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mU(String.valueOf(lVar.getThreadId()))) {
                this.dGH = t.d.cp_cont_c;
            } else {
                this.dGH = t.d.cp_cont_b;
            }
            ar.b(this.apm, this.dGH, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.dGH != 0 && this.apm != null) {
                ar.b(this.apm, this.dGH, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
