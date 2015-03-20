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
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.e.c> {
    private View aDG;
    private TextView ahr;
    private TextView bGh;
    private TbImageView bXW;
    private TbImageView bXX;
    private TbImageView bXY;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bXW = (TbImageView) view.findViewById(v.img1);
        this.bXX = (TbImageView) view.findViewById(v.img2);
        this.bXY = (TbImageView) view.findViewById(v.img3);
        this.ahr = (TextView) view.findViewById(v.title);
        this.bGh = (TextView) view.findViewById(v.tag);
        this.aDG = view.findViewById(v.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.A(bVar);
        if (bVar != null) {
            if (bVar.afB() != null) {
                List<String> afB = bVar.afB();
                if (afB.size() > 0) {
                    this.bXW.c(afB.get(0), 10, false);
                }
                if (afB.size() > 1) {
                    this.bXX.c(afB.get(1), 10, false);
                }
                if (afB.size() > 2) {
                    this.bXY.c(afB.get(2), 10, false);
                }
            }
            this.ahr.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            if (StringUtils.isNull(bVar.getTag())) {
                this.bGh.setVisibility(8);
            } else {
                this.bGh.setVisibility(0);
                this.bGh.setText(UtilHelper.getFixedText(bVar.getTag(), 4, false));
            }
            this.aDG.setVisibility(bVar.afE() ? 0 : 4);
            l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.iO(String.valueOf(bVar.afA()))) {
                ba.b(this.ahr, s.cp_cont_c, 1);
            } else {
                ba.b(this.ahr, s.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
