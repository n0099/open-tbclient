package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TextView aNs;
    private TextView aNt;
    private TextView aNu;
    private TextView agd;
    private int djB;
    private TbImageView djE;
    private TbImageView djF;
    private TbImageView djG;
    private List<TbImageView> djH;
    private final int djI;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.djI = 3;
        this.djB = 0;
        this.djE = (TbImageView) view.findViewById(n.f.img1);
        this.djF = (TbImageView) view.findViewById(n.f.img2);
        this.djG = (TbImageView) view.findViewById(n.f.img3);
        this.agd = (TextView) view.findViewById(n.f.title);
        View findViewById = view.findViewById(n.f.hot_thread_comment);
        this.aNs = (TextView) findViewById.findViewById(n.f.hot_thread_line_tag);
        this.aNt = (TextView) findViewById.findViewById(n.f.hot_thread_line_praise);
        this.aNu = (TextView) findViewById.findViewById(n.f.hot_thread_line_comment);
        this.djH = new ArrayList();
        this.djH.add(this.djE);
        this.djH.add(this.djF);
        this.djH.add(this.djG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.e eVar) {
        super.B(eVar);
        if (eVar != null) {
            if (eVar.aws() != null) {
                List<String> aws = eVar.aws();
                if (aws.size() > 3) {
                    aws.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.b(aws, i);
                    TbImageView tbImageView = this.djH.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.awl()) {
                            str = null;
                        }
                        tbImageView.d(str, 10, false);
                    }
                }
            }
            this.agd.setText(eVar.getTitle());
            this.aNt.setText(ax.v(eVar.awp()));
            this.aNu.setText(ax.v(eVar.awq()));
            if (StringUtils.isNull(eVar.getForumName())) {
                this.aNs.setVisibility(8);
            } else {
                this.aNs.setVisibility(0);
                this.aNs.setText(getContext().getString(n.i.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.aNs.setOnClickListener(new e(this, eVar));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mF(String.valueOf(eVar.getThreadId()))) {
                this.djB = n.c.cp_cont_c;
            } else {
                this.djB = n.c.cp_cont_b;
            }
            as.b(this.agd, this.djB, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        if (this.djB != 0 && this.agd != null) {
            as.b(this.agd, this.djB, 1);
        }
        return true;
    }
}
