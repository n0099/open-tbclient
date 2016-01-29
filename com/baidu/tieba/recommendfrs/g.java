package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recommendfrs.p;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements p.a {
    final /* synthetic */ f dDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dDl = fVar;
    }

    @Override // com.baidu.tieba.recommendfrs.p.a
    public void aS(int i, int i2) {
        c cVar;
        boolean aET;
        TagInfo tagInfo;
        c cVar2;
        TagInfo tagInfo2;
        c cVar3;
        TagInfo tagInfo3;
        cVar = this.dDl.dDg;
        if (cVar == null) {
            this.dDl.showNetRefreshView(this.dDl, TbadkCoreApplication.m411getInst().getString(t.j.neterror), true);
            this.dDl.aAV();
            return;
        }
        aET = this.dDl.aET();
        this.dDl.avv();
        if (aET) {
            this.dDl.j(true, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds120));
        }
        tagInfo = this.dDl.dDd;
        if (tagInfo != null) {
            tagInfo2 = this.dDl.dDd;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.dDl.dDg;
                tagInfo3 = this.dDl.dDd;
                cVar3.I(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.dDl.dDg;
        cVar2.I(0, i, i2);
    }

    @Override // com.baidu.tieba.recommendfrs.p.a
    public void J(int i, int i2, int i3) {
        c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        c cVar2;
        TagInfo tagInfo3;
        cVar = this.dDl.dDg;
        if (cVar != null) {
            tagInfo = this.dDl.dDd;
            if (tagInfo != null) {
                tagInfo2 = this.dDl.dDd;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.dDl.dDg;
                    tagInfo3 = this.dDl.dDd;
                    cVar2.o(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recommendfrs.p.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.dDl.aAV();
        if (i != 1) {
            bdTypeListView = this.dDl.dDe;
            bdTypeListView.setVisibility(8);
            this.dDl.showNetRefreshView(this.dDl, str, true);
        } else if (com.baidu.adp.lib.util.i.iZ()) {
            tbPageContext = this.dDl.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.p.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.dDl.aAV();
        this.dDl.avv();
        bdTypeListView = this.dDl.dDe;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.recommendfrs.p.a
    public void bN(List<TagInfo> list) {
        c cVar;
        c cVar2;
        cVar = this.dDl.dDg;
        if (cVar != null) {
            cVar2 = this.dDl.dDg;
            cVar2.bM(list);
        }
    }
}
