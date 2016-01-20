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
import com.baidu.tieba.recommendfrs.data.j;
import com.baidu.tieba.tbadkCore.util.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<j, com.baidu.tbadk.mvc.d.b> {
    private TextView aRl;
    private TextView aRm;
    private TextView aRn;
    private TextView ahk;
    private int dqG;
    private TbImageView dqM;
    private TbImageView dqN;
    private TbImageView dqO;
    private List<TbImageView> dqP;
    private final int dqQ;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.dqQ = 3;
        this.dqG = 0;
        this.dqM = (TbImageView) view.findViewById(n.g.img1);
        this.dqN = (TbImageView) view.findViewById(n.g.img2);
        this.dqO = (TbImageView) view.findViewById(n.g.img3);
        this.ahk = (TextView) view.findViewById(n.g.title);
        View findViewById = view.findViewById(n.g.hot_thread_comment);
        this.aRl = (TextView) findViewById.findViewById(n.g.hot_thread_line_tag);
        this.aRm = (TextView) findViewById.findViewById(n.g.hot_thread_line_praise);
        this.aRn = (TextView) findViewById.findViewById(n.g.hot_thread_line_comment);
        this.dqP = new ArrayList();
        this.dqP.add(this.dqM);
        this.dqP.add(this.dqN);
        this.dqP.add(this.dqO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(j jVar) {
        super.B(jVar);
        if (jVar != null) {
            if (jVar.ayw() != null) {
                List<String> ayw = jVar.ayw();
                if (ayw.size() > 3) {
                    ayw.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.b(ayw, i);
                    TbImageView tbImageView = this.dqP.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!jVar.ayq()) {
                            str = null;
                        }
                        tbImageView.d(str, 10, false);
                    }
                }
            }
            this.ahk.setText(jVar.getTitle());
            this.aRm.setText(ax.w(jVar.ayt()));
            this.aRn.setText(ax.w(jVar.ayu()));
            if (StringUtils.isNull(jVar.getForumName())) {
                this.aRl.setVisibility(8);
            } else {
                this.aRl.setVisibility(0);
                this.aRl.setText(getContext().getString(n.j.chosen_pb_original_bar, UtilHelper.getFixedText(jVar.getForumName(), 7, false)));
                this.aRl.setOnClickListener(new f(this, jVar));
            }
            q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mD(String.valueOf(jVar.getThreadId()))) {
                this.dqG = n.d.cp_cont_c;
            } else {
                this.dqG = n.d.cp_cont_b;
            }
            as.b(this.ahk, this.dqG, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.dqG != 0 && this.ahk != null) {
                as.b(this.ahk, this.dqG, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
