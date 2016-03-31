package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recommendfrs.q;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements q.a {
    final /* synthetic */ f dVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dVf = fVar;
    }

    @Override // com.baidu.tieba.recommendfrs.q.a
    public void aS(int i, int i2) {
        c cVar;
        boolean anA;
        TagInfo tagInfo;
        c cVar2;
        TagInfo tagInfo2;
        c cVar3;
        TagInfo tagInfo3;
        cVar = this.dVf.dVa;
        if (cVar == null) {
            this.dVf.showNetRefreshView(this.dVf, TbadkCoreApplication.m411getInst().getString(t.j.neterror), true);
            this.dVf.XX();
            return;
        }
        anA = this.dVf.anA();
        this.dVf.XY();
        if (anA) {
            this.dVf.e(true, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds120));
        }
        tagInfo = this.dVf.dUX;
        if (tagInfo != null) {
            tagInfo2 = this.dVf.dUX;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.dVf.dVa;
                tagInfo3 = this.dVf.dUX;
                cVar3.I(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.dVf.dVa;
        cVar2.I(0, i, i2);
    }

    @Override // com.baidu.tieba.recommendfrs.q.a
    public void J(int i, int i2, int i3) {
        c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        c cVar2;
        TagInfo tagInfo3;
        cVar = this.dVf.dVa;
        if (cVar != null) {
            tagInfo = this.dVf.dUX;
            if (tagInfo != null) {
                tagInfo2 = this.dVf.dUX;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.dVf.dVa;
                    tagInfo3 = this.dVf.dUX;
                    cVar2.o(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recommendfrs.q.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.dVf.XX();
        if (i != 1) {
            bdTypeListView = this.dVf.dUY;
            bdTypeListView.setVisibility(8);
            this.dVf.showNetRefreshView(this.dVf, str, true);
        } else if (com.baidu.adp.lib.util.i.jf()) {
            tbPageContext = this.dVf.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.q.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.dVf.XX();
        this.dVf.XY();
        bdTypeListView = this.dVf.dUY;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.recommendfrs.q.a
    public void cg(List<TagInfo> list) {
        c cVar;
        c cVar2;
        cVar = this.dVf.dVa;
        if (cVar != null) {
            cVar2 = this.dVf.dVa;
            cVar2.cf(list);
        }
    }
}
