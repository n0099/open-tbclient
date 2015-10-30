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
    private TextView aCJ;
    private TbImageView aJW;
    private TextView aJX;
    private TextView aJY;
    private TextView aJZ;
    private View aKa;
    private TextView alu;

    public i(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aJW = (TbImageView) view.findViewById(i.f.img);
        this.alu = (TextView) view.findViewById(i.f.title);
        this.aCJ = (TextView) view.findViewById(i.f.desc);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJX = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJY = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJZ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKa = view.findViewById(i.f.divider_line);
        this.aKa = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            String str = (bVar.apY() == null || bVar.apY().size() <= 0) ? null : bVar.apY().get(0);
            TbImageView tbImageView = this.aJW;
            if (!bVar.aqp()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.alu.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aCJ.setText(UtilHelper.getFixedText(bVar.getDesc(), 24, true));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aJX.setVisibility(8);
            } else {
                this.aJX.setVisibility(0);
                this.aJX.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aJX.setOnClickListener(new j(this, bVar));
            }
            this.aJY.setText(as.q(bVar.apV()));
            this.aJZ.setText(as.q(bVar.apW()));
            this.aKa.setVisibility(bVar.aqa() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lL(String.valueOf(bVar.apX()))) {
                an.b(this.alu, i.c.cp_cont_d, 1);
            } else {
                an.b(this.alu, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
