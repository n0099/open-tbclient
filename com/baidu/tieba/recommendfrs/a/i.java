package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private TextView aCy;
    private TbImageView aJL;
    private TextView aJM;
    private TextView aJN;
    private TextView aJO;
    private View aJP;
    private TextView alt;

    public i(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aJL = (TbImageView) view.findViewById(i.f.img);
        this.alt = (TextView) view.findViewById(i.f.title);
        this.aCy = (TextView) view.findViewById(i.f.desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJM = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJN = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJO = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aJP = view.findViewById(i.f.divider_line);
        this.aJP = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            String str = (bVar.apW() == null || bVar.apW().size() <= 0) ? null : bVar.apW().get(0);
            TbImageView tbImageView = this.aJL;
            if (!bVar.aqn()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.alt.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aCy.setText(UtilHelper.getFixedText(bVar.getDesc(), 24, true));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aJM.setVisibility(8);
            } else {
                this.aJM.setVisibility(0);
                this.aJM.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aJM.setOnClickListener(new j(this, bVar));
            }
            this.aJN.setText(ar.s(bVar.apT()));
            this.aJO.setText(ar.s(bVar.apU()));
            this.aJP.setVisibility(bVar.apY() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lI(String.valueOf(bVar.apV()))) {
                am.b(this.alt, i.c.cp_cont_d, 1);
            } else {
                am.b(this.alt, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
