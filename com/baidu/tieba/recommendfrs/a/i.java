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
public class i extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aKT;
    private TextView aKU;
    private TextView aKV;
    private TextView aKW;
    private View aKX;
    private TextView aMb;
    private TextView amV;

    public i(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKT = (TbImageView) view.findViewById(i.f.img);
        this.amV = (TextView) view.findViewById(i.f.title);
        this.aMb = (TextView) view.findViewById(i.f.desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKU = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKV = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKW = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKX = view.findViewById(i.f.divider_line);
        this.aKX = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            String str = (bVar.anE() == null || bVar.anE().size() <= 0) ? null : bVar.anE().get(0);
            TbImageView tbImageView = this.aKT;
            if (!bVar.anV()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.amV.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aMb.setText(UtilHelper.getFixedText(bVar.getDesc(), 24, true));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aKU.setVisibility(8);
            } else {
                this.aKU.setVisibility(0);
                this.aKU.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aKU.setOnClickListener(new j(this, bVar));
            }
            this.aKV.setText(aq.o(bVar.anB()));
            this.aKW.setText(aq.o(bVar.anC()));
            this.aKX.setVisibility(bVar.anG() ? 0 : 4);
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lj(String.valueOf(bVar.anD()))) {
                al.b(this.amV, i.c.cp_cont_d, 1);
            } else {
                al.b(this.amV, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
