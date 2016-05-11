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
    private TbPageContext<?> Do;
    private TextView aSY;
    private TextView aSZ;
    private TextView aTa;
    private int cHv;
    private p ecm;
    private View.OnClickListener ecn;
    private TbImageView ecr;
    private TbImageView ecs;
    private TbImageView ect;
    private List<TbImageView> ecu;
    private final int ecv;
    private int mSkinType;
    private TextView title;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.ecv = 3;
        this.cHv = 0;
        this.ecn = new h(this);
        this.Do = tbPageContext;
        view.setOnClickListener(this.ecn);
        this.ecr = (TbImageView) view.findViewById(t.g.img1);
        this.ecs = (TbImageView) view.findViewById(t.g.img2);
        this.ect = (TbImageView) view.findViewById(t.g.img3);
        this.title = (TextView) view.findViewById(t.g.title);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.aSY = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.aSZ = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.aTa = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
        this.ecu = new ArrayList();
        this.ecu.add(this.ecr);
        this.ecu.add(this.ecs);
        this.ecu.add(this.ect);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(p pVar) {
        super.B(pVar);
        if (pVar != null) {
            this.ecm = pVar;
            if (pVar.aMA() != null) {
                List<String> aMA = pVar.aMA();
                if (aMA.size() > 3) {
                    aMA.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.c(aMA, i);
                    TbImageView tbImageView = this.ecu.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!pVar.aMu()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.title.setText(pVar.getTitle());
            this.aSZ.setVisibility(0);
            String A = ay.A(pVar.aMx());
            this.aSZ.setText(A);
            this.aSZ.setContentDescription(String.valueOf(this.Do.getString(t.j.zan_num)) + A);
            com.baidu.tieba.graffiti.d.aj(this.aSZ);
            String A2 = ay.A(pVar.aMy());
            this.aTa.setText(A2);
            this.aTa.setContentDescription(String.valueOf(this.Do.getString(t.j.reply_num)) + A2);
            if (StringUtils.isNull(pVar.getForumName())) {
                this.aSY.setVisibility(8);
            } else {
                this.aSY.setVisibility(0);
                this.aSY.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(pVar.getForumName(), 7, false)));
                this.aSY.setOnClickListener(new i(this, pVar));
            }
            s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.od(String.valueOf(pVar.getThreadId()))) {
                this.cHv = t.d.cp_cont_c;
            } else {
                this.cHv = t.d.cp_cont_b;
            }
            at.c(this.title, this.cHv, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cHv != 0 && this.title != null) {
                at.c(this.title, this.cHv, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
