package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private TextView aKH;
    private TextView aKI;
    private TextView aKJ;
    private View aKK;
    private TextView anH;
    private TbImageView ctP;
    private TbImageView ctQ;
    private TbImageView ctR;

    public j(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ctP = (TbImageView) view.findViewById(i.f.img1);
        this.ctQ = (TbImageView) view.findViewById(i.f.img2);
        this.ctR = (TbImageView) view.findViewById(i.f.img3);
        this.anH = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKH = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKI = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKJ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKK = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.A(bVar);
        if (bVar != null) {
            if (bVar.ajA() != null) {
                List<String> ajA = bVar.ajA();
                if (ajA.size() > 0) {
                    this.ctP.d(bVar.ajP() ? ajA.get(0) : null, 10, false);
                }
                if (ajA.size() > 1) {
                    this.ctQ.d(bVar.ajP() ? ajA.get(1) : null, 10, false);
                }
                if (ajA.size() > 2) {
                    this.ctR.d(bVar.ajP() ? ajA.get(2) : null, 10, false);
                }
            }
            this.anH.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aKI.setText(aq.o(bVar.ajx()));
            this.aKJ.setText(aq.o(bVar.ajy()));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aKH.setVisibility(8);
            } else {
                this.aKH.setVisibility(0);
                this.aKH.setText(getContext().getString(i.C0057i.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aKH.setOnClickListener(new k(this, bVar));
            }
            this.aKK.setVisibility(bVar.ajC() ? 0 : 4);
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.kE(String.valueOf(bVar.ajz()))) {
                al.b(this.anH, i.c.cp_cont_c, 1);
            } else {
                al.b(this.anH, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
