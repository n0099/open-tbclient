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
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aKG;
    private TextView aKH;
    private TextView aKI;
    private TextView aKJ;
    private View aKK;
    private TextView aLO;
    private TextView anH;

    public h(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKG = (TbImageView) view.findViewById(i.f.img);
        this.anH = (TextView) view.findViewById(i.f.title);
        this.aLO = (TextView) view.findViewById(i.f.desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKH = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKI = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKJ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKK = view.findViewById(i.f.divider_line);
        this.aKK = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.A(bVar);
        if (bVar != null) {
            String str = (bVar.ajA() == null || bVar.ajA().size() <= 0) ? null : bVar.ajA().get(0);
            TbImageView tbImageView = this.aKG;
            if (!bVar.ajP()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.anH.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aLO.setText(UtilHelper.getFixedText(bVar.getDesc(), 24, true));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aKH.setVisibility(8);
            } else {
                this.aKH.setVisibility(0);
                this.aKH.setText(getContext().getString(i.C0057i.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aKH.setOnClickListener(new i(this, bVar));
            }
            this.aKI.setText(aq.o(bVar.ajx()));
            this.aKJ.setText(aq.o(bVar.ajy()));
            this.aKK.setVisibility(bVar.ajC() ? 0 : 4);
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.kE(String.valueOf(bVar.ajz()))) {
                al.b(this.anH, i.c.cp_cont_d, 1);
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
