package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.tbadkCore.util.l;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.e.c> {
    private TextView aCm;
    private View aDO;
    private TextView ahz;
    private TextView bGu;
    private TbImageView bYk;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bYk = (TbImageView) view.findViewById(v.img);
        this.ahz = (TextView) view.findViewById(v.title);
        this.aCm = (TextView) view.findViewById(v.desc);
        this.bGu = (TextView) view.findViewById(v.tag);
        this.aDO = view.findViewById(v.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.A(bVar);
        if (bVar != null) {
            String str = null;
            if (bVar.afQ() != null && bVar.afQ().size() > 0) {
                str = bVar.afQ().get(0);
            }
            this.bYk.c(str, 10, false);
            this.ahz.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aCm.setText(UtilHelper.getFixedText(bVar.qa(), 24, true));
            if (StringUtils.isNull(bVar.getTag())) {
                this.bGu.setVisibility(8);
            } else {
                this.bGu.setVisibility(0);
                this.bGu.setText(UtilHelper.getFixedText(bVar.getTag(), 4, false));
            }
            this.aDO.setVisibility(bVar.afT() ? 0 : 4);
            l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.iR(String.valueOf(bVar.afP()))) {
                ba.b(this.ahz, s.cp_cont_d, 1);
            } else {
                ba.b(this.ahz, s.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
