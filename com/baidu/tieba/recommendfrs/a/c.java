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
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TextView aIR;
    private TextView aIS;
    private TextView aIT;
    private TextView alz;
    private TbImageView cLd;
    private TbImageView cLe;
    private TbImageView cLf;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cLd = (TbImageView) view.findViewById(i.f.img1);
        this.cLe = (TbImageView) view.findViewById(i.f.img2);
        this.cLf = (TbImageView) view.findViewById(i.f.img3);
        this.alz = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aIR = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aIS = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aIT = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqJ() != null) {
            Hot_Thread aqJ = cVar.aqJ();
            if (aqJ.pics != null && aqJ.pics.size() > 0) {
                int size = aqJ.pics.size();
                if (size > 0 && aqJ.pics.get(0) != null) {
                    this.cLd.d(cVar.aqV() ? aqJ.pics.get(0).small_pic : null, 10, false);
                }
                if (size > 1 && aqJ.pics.get(1) != null) {
                    this.cLe.d(cVar.aqV() ? aqJ.pics.get(1).small_pic : null, 10, false);
                }
                if (size > 2 && aqJ.pics.get(2) != null) {
                    this.cLf.d(cVar.aqV() ? aqJ.pics.get(2).small_pic : null, 10, false);
                }
            }
            this.alz.setText(UtilHelper.getFixedText(aqJ.title, 14, true));
            if (StringUtils.isNull(aqJ.forum_name)) {
                this.aIR.setVisibility(8);
            } else {
                this.aIR.setVisibility(0);
                this.aIR.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqJ.forum_name, 7, false)));
                this.aIR.setOnClickListener(new d(this, aqJ));
            }
            if (aqJ.zan_num != null) {
                this.aIS.setText(as.q(aqJ.zan_num.intValue()));
            }
            if (aqJ.reply_num != null) {
                this.aIT.setText(as.q(aqJ.reply_num.intValue()));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lR(String.valueOf(aqJ.forum_id))) {
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
