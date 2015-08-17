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
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TextView aKH;
    private TextView aKI;
    private TextView aKJ;
    private TextView anH;
    private TbImageView ctP;
    private TbImageView ctQ;
    private TbImageView ctR;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ctP = (TbImageView) view.findViewById(i.f.img1);
        this.ctQ = (TbImageView) view.findViewById(i.f.img2);
        this.ctR = (TbImageView) view.findViewById(i.f.img3);
        this.anH = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKH = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKI = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKJ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.A(cVar);
        if (cVar != null && cVar.ajD() != null) {
            Hot_Thread ajD = cVar.ajD();
            if (ajD.pics != null && ajD.pics.size() > 0) {
                int size = ajD.pics.size();
                if (size > 0 && ajD.pics.get(0) != null) {
                    this.ctP.d(cVar.ajP() ? ajD.pics.get(0).small_pic : null, 10, false);
                }
                if (size > 1 && ajD.pics.get(1) != null) {
                    this.ctQ.d(cVar.ajP() ? ajD.pics.get(1).small_pic : null, 10, false);
                }
                if (size > 2 && ajD.pics.get(2) != null) {
                    this.ctR.d(cVar.ajP() ? ajD.pics.get(2).small_pic : null, 10, false);
                }
            }
            this.anH.setText(UtilHelper.getFixedText(ajD.title, 14, true));
            if (StringUtils.isNull(ajD.forum_name)) {
                this.aKH.setVisibility(8);
            } else {
                this.aKH.setVisibility(0);
                this.aKH.setText(getContext().getString(i.C0057i.chosen_pb_original_bar, UtilHelper.getFixedText(ajD.forum_name, 7, false)));
                this.aKH.setOnClickListener(new d(this, ajD));
            }
            if (ajD.zan_num != null) {
                this.aKI.setText(aq.o(ajD.zan_num.intValue()));
            }
            if (ajD.reply_num != null) {
                this.aKJ.setText(aq.o(ajD.reply_num.intValue()));
            }
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.kE(String.valueOf(ajD.forum_id))) {
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
