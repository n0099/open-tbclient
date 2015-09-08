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
public class k extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private TextView aKU;
    private TextView aKV;
    private TextView aKW;
    private View aKX;
    private TextView amV;
    private TbImageView cCh;
    private TbImageView cCi;
    private TbImageView cCj;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cCh = (TbImageView) view.findViewById(i.f.img1);
        this.cCi = (TbImageView) view.findViewById(i.f.img2);
        this.cCj = (TbImageView) view.findViewById(i.f.img3);
        this.amV = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKU = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKV = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKW = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKX = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (bVar.anE() != null) {
                List<String> anE = bVar.anE();
                if (anE.size() > 0) {
                    this.cCh.d(bVar.anV() ? anE.get(0) : null, 10, false);
                }
                if (anE.size() > 1) {
                    this.cCi.d(bVar.anV() ? anE.get(1) : null, 10, false);
                }
                if (anE.size() > 2) {
                    this.cCj.d(bVar.anV() ? anE.get(2) : null, 10, false);
                }
            }
            this.amV.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aKV.setText(aq.o(bVar.anB()));
            this.aKW.setText(aq.o(bVar.anC()));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aKU.setVisibility(8);
            } else {
                this.aKU.setVisibility(0);
                this.aKU.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aKU.setOnClickListener(new l(this, bVar));
            }
            this.aKX.setVisibility(bVar.anG() ? 0 : 4);
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lj(String.valueOf(bVar.anD()))) {
                al.b(this.amV, i.c.cp_cont_c, 1);
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
