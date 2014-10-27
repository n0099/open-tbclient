package com.baidu.tieba.pb.history;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.Date;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.i.a<ai, com.baidu.tbadk.mvc.e.c> {
    private View HS;
    private View MI;
    private TextView bun;
    private TextView buo;
    private TextView bup;

    public g(View view, ViewEventCenter viewEventCenter) {
        super(view, viewEventCenter);
        this.HS = view;
        this.bun = (TextView) view.findViewById(v.title);
        this.buo = (TextView) view.findViewById(v.content);
        this.bup = (TextView) view.findViewById(v.time);
        this.MI = view.findViewById(v.line);
        dg(TbadkApplication.m251getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.i.d
    /* renamed from: a */
    public void r(ai aiVar) {
        if (aiVar != null) {
            if (this.bun != null && aiVar.zU() != null) {
                this.bun.setText(aiVar.zU());
            }
            if (this.buo != null && aiVar.getForumName() != null) {
                this.buo.setText(aiVar.getForumName());
            }
            if (this.bup != null) {
                String f = ay.f(new Date(aiVar.getTime()));
                if (f == null) {
                    f = "";
                }
                this.bup.setText(f);
            }
        }
    }

    @Override // com.baidu.tbadk.e.a
    public boolean dg(int i) {
        aw.h(this.HS, u.list_item_selector);
        aw.h(this.MI, s.cp_bg_line_b);
        aw.b(this.bun, s.cp_cont_b, 1);
        aw.b(this.buo, s.cp_cont_d, 1);
        aw.b(this.bup, s.cp_cont_d, 1);
        return true;
    }
}
