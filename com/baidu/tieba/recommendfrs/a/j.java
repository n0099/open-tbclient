package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import java.util.List;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.recommendfrs.data.b, com.baidu.tbadk.mvc.e.c> {
    private TextView aDk;
    private View aDn;
    private TextView aiA;
    private TbImageView ccv;
    private TbImageView ccw;
    private TbImageView ccx;

    public j(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ccv = (TbImageView) view.findViewById(q.img1);
        this.ccw = (TbImageView) view.findViewById(q.img2);
        this.ccx = (TbImageView) view.findViewById(q.img3);
        this.aiA = (TextView) view.findViewById(q.title);
        this.aDk = (TextView) view.findViewById(q.tag);
        this.aDn = view.findViewById(q.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(com.baidu.tieba.recommendfrs.data.b bVar) {
        super.z(bVar);
        if (bVar != null) {
            if (bVar.ahy() != null) {
                List<String> ahy = bVar.ahy();
                if (ahy.size() > 0) {
                    this.ccv.c(bVar.ahH() ? ahy.get(0) : null, 10, false);
                }
                if (ahy.size() > 1) {
                    this.ccw.c(bVar.ahH() ? ahy.get(1) : null, 10, false);
                }
                if (ahy.size() > 2) {
                    this.ccx.c(bVar.ahH() ? ahy.get(2) : null, 10, false);
                }
            }
            this.aiA.setText(UtilHelper.getFixedText(bVar.getTitle(), 14, true));
            if (StringUtils.isNull(bVar.getTag())) {
                this.aDk.setVisibility(8);
            } else {
                this.aDk.setVisibility(0);
                this.aDk.setText(UtilHelper.getFixedText(bVar.getTag(), 4, false));
            }
            this.aDn.setVisibility(bVar.ahA() ? 0 : 4);
            com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.jL(String.valueOf(bVar.ahx()))) {
                ay.b(this.aiA, n.cp_cont_c, 1);
            } else {
                ay.b(this.aiA, n.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
