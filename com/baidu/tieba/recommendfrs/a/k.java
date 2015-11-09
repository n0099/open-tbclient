package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.List;
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private TextView aIR;
    private TextView aIS;
    private TextView aIT;
    private View aIU;
    private TextView alz;
    private TbImageView cLd;
    private TbImageView cLe;
    private TbImageView cLf;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cLd = (TbImageView) view.findViewById(i.f.img1);
        this.cLe = (TbImageView) view.findViewById(i.f.img2);
        this.cLf = (TbImageView) view.findViewById(i.f.img3);
        this.alz = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aIR = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aIS = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aIT = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aIU = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (bVar.aqE() != null) {
                List<String> aqE = bVar.aqE();
                if (aqE.size() > 0) {
                    this.cLd.d(bVar.aqV() ? aqE.get(0) : null, 10, false);
                }
                if (aqE.size() > 1) {
                    this.cLe.d(bVar.aqV() ? aqE.get(1) : null, 10, false);
                }
                if (aqE.size() > 2) {
                    this.cLf.d(bVar.aqV() ? aqE.get(2) : null, 10, false);
                }
            }
            this.alz.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aIS.setText(as.q(bVar.aqB()));
            this.aIT.setText(as.q(bVar.aqC()));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aIR.setVisibility(8);
            } else {
                this.aIR.setVisibility(0);
                this.aIR.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aIR.setOnClickListener(new l(this, bVar));
            }
            this.aIU.setVisibility(bVar.aqG() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lR(String.valueOf(bVar.aqD()))) {
                an.b(this.alz, i.c.cp_cont_c, 1);
            } else {
                an.b(this.alz, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
