package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.n;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements n.a {
    final /* synthetic */ e doc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.doc = eVar;
    }

    @Override // com.baidu.tieba.recommendfrs.n.a
    public void aT(int i, int i2) {
        b bVar;
        boolean axV;
        TagInfo tagInfo;
        b bVar2;
        TagInfo tagInfo2;
        b bVar3;
        TagInfo tagInfo3;
        bVar = this.doc.dnY;
        if (bVar == null) {
            this.doc.showNetRefreshView(this.doc, TbadkCoreApplication.m411getInst().getString(n.j.neterror), true);
            this.doc.auH();
            return;
        }
        axV = this.doc.axV();
        this.doc.aqe();
        if (axV) {
            this.doc.g(true, 0);
        }
        tagInfo = this.doc.dnV;
        if (tagInfo != null) {
            tagInfo2 = this.doc.dnV;
            if (tagInfo2.tag_code != null) {
                bVar3 = this.doc.dnY;
                tagInfo3 = this.doc.dnV;
                bVar3.J(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        bVar2 = this.doc.dnY;
        bVar2.J(0, i, i2);
    }

    @Override // com.baidu.tieba.recommendfrs.n.a
    public void K(int i, int i2, int i3) {
        b bVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        b bVar2;
        TagInfo tagInfo3;
        bVar = this.doc.dnY;
        if (bVar != null) {
            tagInfo = this.doc.dnV;
            if (tagInfo != null) {
                tagInfo2 = this.doc.dnV;
                if (tagInfo2.tag_code != null) {
                    bVar2 = this.doc.dnY;
                    tagInfo3 = this.doc.dnV;
                    bVar2.p(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recommendfrs.n.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.doc.auH();
        if (i != 1) {
            bdTypeListView = this.doc.dnW;
            bdTypeListView.setVisibility(8);
            this.doc.showNetRefreshView(this.doc, str, true);
        } else if (com.baidu.adp.lib.util.i.iQ()) {
            tbPageContext = this.doc.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.n.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.doc.auH();
        this.doc.aqe();
        bdTypeListView = this.doc.dnW;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.recommendfrs.n.a
    public void bD(List<TagInfo> list) {
        b bVar;
        b bVar2;
        bVar = this.doc.dnY;
        if (bVar != null) {
            bVar2 = this.doc.dnY;
            bVar2.bC(list);
        }
    }
}
