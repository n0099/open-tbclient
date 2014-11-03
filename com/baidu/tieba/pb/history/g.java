package com.baidu.tieba.pb.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.i.a<ai, com.baidu.tbadk.mvc.e.c> {
    private View HT;
    private View ML;
    private TextView buB;
    private TextView buC;
    private TextView buD;

    public g(View view, ViewEventCenter viewEventCenter) {
        super(view, viewEventCenter);
        this.HT = view;
        this.buB = (TextView) view.findViewById(v.title);
        this.buC = (TextView) view.findViewById(v.content);
        this.buD = (TextView) view.findViewById(v.time);
        this.ML = view.findViewById(v.line);
        dg(TbadkApplication.m251getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.i.d
    /* renamed from: a */
    public void r(ai aiVar) {
        if (aiVar != null) {
            if (this.buB != null && aiVar.zW() != null) {
                this.buB.setText(aiVar.zW());
            }
            if (this.buC != null && aiVar.getForumName() != null) {
                this.buC.setText(aiVar.getForumName());
            }
            if (this.buD != null) {
                String f = az.f(new Date(aiVar.getTime()));
                if (f == null) {
                    f = "";
                }
                this.buD.setText(f);
            }
        }
    }

    @Override // com.baidu.tbadk.e.a
    public boolean dg(int i) {
        aw.h(this.HT, u.list_item_selector);
        aw.h(this.ML, s.cp_bg_line_b);
        aw.b(this.buB, s.cp_cont_b, 1);
        aw.b(this.buC, s.cp_cont_d, 1);
        aw.b(this.buD, s.cp_cont_d, 1);
        return true;
    }
}
