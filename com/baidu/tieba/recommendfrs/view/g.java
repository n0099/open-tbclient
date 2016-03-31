package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendfrs.data.p;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<p, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> MX;
    private TextView aXe;
    private TextView aXf;
    private TextView aXg;
    private TextView apE;
    private int cHk;
    private p dZf;
    private View.OnClickListener dZg;
    private TbImageView dZk;
    private TbImageView dZl;
    private TbImageView dZm;
    private List<TbImageView> dZn;
    private final int dZo;
    private int mSkinType;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.dZo = 3;
        this.cHk = 0;
        this.dZg = new h(this);
        this.MX = tbPageContext;
        view.setOnClickListener(this.dZg);
        this.dZk = (TbImageView) view.findViewById(t.g.img1);
        this.dZl = (TbImageView) view.findViewById(t.g.img2);
        this.dZm = (TbImageView) view.findViewById(t.g.img3);
        this.apE = (TextView) view.findViewById(t.g.title);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.aXe = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.aXf = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.aXg = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
        this.dZn = new ArrayList();
        this.dZn.add(this.dZk);
        this.dZn.add(this.dZl);
        this.dZn.add(this.dZm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(p pVar) {
        super.B(pVar);
        if (pVar != null) {
            this.dZf = pVar;
            if (pVar.aMp() != null) {
                List<String> aMp = pVar.aMp();
                if (aMp.size() > 3) {
                    aMp.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.b(aMp, i);
                    TbImageView tbImageView = this.dZn.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!pVar.aMj()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.apE.setText(pVar.getTitle());
            this.aXf.setVisibility(0);
            String z = ay.z(pVar.aMm());
            this.aXf.setText(z);
            this.aXf.setContentDescription(String.valueOf(this.MX.getString(t.j.zan_num)) + z);
            com.baidu.tieba.graffiti.d.af(this.aXf);
            String z2 = ay.z(pVar.aMn());
            this.aXg.setText(z2);
            this.aXg.setContentDescription(String.valueOf(this.MX.getString(t.j.reply_num)) + z2);
            if (StringUtils.isNull(pVar.getForumName())) {
                this.aXe.setVisibility(8);
            } else {
                this.aXe.setVisibility(0);
                this.aXe.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(pVar.getForumName(), 7, false)));
                this.aXe.setOnClickListener(new i(this, pVar));
            }
            s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.oh(String.valueOf(pVar.getThreadId()))) {
                this.cHk = t.d.cp_cont_c;
            } else {
                this.cHk = t.d.cp_cont_b;
            }
            at.b(this.apE, this.cHk, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cHk != 0 && this.apE != null) {
                at.b(this.apE, this.cHk, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
