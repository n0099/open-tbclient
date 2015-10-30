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
    private TextView aJX;
    private TextView aJY;
    private TextView aJZ;
    private View aKa;
    private TextView alu;
    private TbImageView cJH;
    private TbImageView cJI;
    private TbImageView cJJ;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cJH = (TbImageView) view.findViewById(i.f.img1);
        this.cJI = (TbImageView) view.findViewById(i.f.img2);
        this.cJJ = (TbImageView) view.findViewById(i.f.img3);
        this.alu = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJX = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJY = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJZ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.aKa = view.findViewById(i.f.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.B(bVar);
        if (bVar != null) {
            if (bVar.apY() != null) {
                List<String> apY = bVar.apY();
                if (apY.size() > 0) {
                    this.cJH.d(bVar.aqp() ? apY.get(0) : null, 10, false);
                }
                if (apY.size() > 1) {
                    this.cJI.d(bVar.aqp() ? apY.get(1) : null, 10, false);
                }
                if (apY.size() > 2) {
                    this.cJJ.d(bVar.aqp() ? apY.get(2) : null, 10, false);
                }
            }
            this.alu.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            this.aJY.setText(as.q(bVar.apV()));
            this.aJZ.setText(as.q(bVar.apW()));
            if (StringUtils.isNull(bVar.getForumName())) {
                this.aJX.setVisibility(8);
            } else {
                this.aJX.setVisibility(0);
                this.aJX.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(bVar.getForumName(), 7, false)));
                this.aJX.setOnClickListener(new l(this, bVar));
            }
            this.aKa.setVisibility(bVar.aqa() ? 0 : 4);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lL(String.valueOf(bVar.apX()))) {
                an.b(this.alu, i.c.cp_cont_c, 1);
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
