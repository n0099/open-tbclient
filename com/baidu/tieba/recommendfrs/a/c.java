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
    private TextView aJX;
    private TextView aJY;
    private TextView aJZ;
    private TextView alu;
    private TbImageView cJH;
    private TbImageView cJI;
    private TbImageView cJJ;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cJH = (TbImageView) view.findViewById(i.f.img1);
        this.cJI = (TbImageView) view.findViewById(i.f.img2);
        this.cJJ = (TbImageView) view.findViewById(i.f.img3);
        this.alu = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJX = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJY = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJZ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqd() != null) {
            Hot_Thread aqd = cVar.aqd();
            if (aqd.pics != null && aqd.pics.size() > 0) {
                int size = aqd.pics.size();
                if (size > 0 && aqd.pics.get(0) != null) {
                    this.cJH.d(cVar.aqp() ? aqd.pics.get(0).small_pic : null, 10, false);
                }
                if (size > 1 && aqd.pics.get(1) != null) {
                    this.cJI.d(cVar.aqp() ? aqd.pics.get(1).small_pic : null, 10, false);
                }
                if (size > 2 && aqd.pics.get(2) != null) {
                    this.cJJ.d(cVar.aqp() ? aqd.pics.get(2).small_pic : null, 10, false);
                }
            }
            this.alu.setText(UtilHelper.getFixedText(aqd.title, 14, true));
            if (StringUtils.isNull(aqd.forum_name)) {
                this.aJX.setVisibility(8);
            } else {
                this.aJX.setVisibility(0);
                this.aJX.setText(getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqd.forum_name, 7, false)));
                this.aJX.setOnClickListener(new d(this, aqd));
            }
            if (aqd.zan_num != null) {
                this.aJY.setText(as.q(aqd.zan_num.intValue()));
            }
            if (aqd.reply_num != null) {
                this.aJZ.setText(as.q(aqd.reply_num.intValue()));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lL(String.valueOf(aqd.forum_id))) {
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
