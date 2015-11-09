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
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.d.b> {
    private TextView aBD;
    private TbImageView aIQ;
    private TextView aIR;
    private TextView aIS;
    private TextView aIT;
    private View aIU;
    private TextView alz;

    public i(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aIQ = (TbImageView) view.findViewById(i.f.img);
        this.alz = (TextView) view.findViewById(i.f.title);
        this.aBD = (TextView) view.findViewById(i.f.desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aIR = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aIS = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aIT = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aIU = view.findViewById(i.f.divider_line);
        this.aIU = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            String str = (bVar.aqE() == null || bVar.aqE().size() <= 0) ? null : bVar.aqE().get(0);
            TbImageView tbImageView = this.aIQ;
            if (!bVar.aqV()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.alz.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aBD.setText(UtilHelper.getFixedText(bVar.getDesc(), 24, true));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aIR.setVisibility(8);
            } else {
                this.aIR.setVisibility(0);
                this.aIR.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aIR.setOnClickListener(new j(this, bVar));
            }
            this.aIS.setText(as.q(bVar.aqB()));
            this.aIT.setText(as.q(bVar.aqC()));
            this.aIU.setVisibility(bVar.aqG() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lR(String.valueOf(bVar.aqD()))) {
                an.b(this.alz, i.c.cp_cont_d, 1);
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
