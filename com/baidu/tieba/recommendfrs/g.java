package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recommendfrs.r;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements r.a {
    final /* synthetic */ f dXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dXY = fVar;
    }

    @Override // com.baidu.tieba.recommendfrs.r.a
    public void aT(int i, int i2) {
        c cVar;
        boolean anx;
        TagInfo tagInfo;
        c cVar2;
        TagInfo tagInfo2;
        c cVar3;
        TagInfo tagInfo3;
        cVar = this.dXY.dXS;
        if (cVar == null) {
            this.dXY.showNetRefreshView(this.dXY, TbadkCoreApplication.m11getInst().getString(t.j.neterror), true);
            this.dXY.Pd();
            return;
        }
        anx = this.dXY.anx();
        this.dXY.Pe();
        if (anx) {
            this.dXY.g(true, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds520));
        }
        tagInfo = this.dXY.dXP;
        if (tagInfo != null) {
            tagInfo2 = this.dXY.dXP;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.dXY.dXS;
                tagInfo3 = this.dXY.dXP;
                cVar3.H(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.dXY.dXS;
        cVar2.H(0, i, i2);
    }

    @Override // com.baidu.tieba.recommendfrs.r.a
    public void I(int i, int i2, int i3) {
        c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        c cVar2;
        TagInfo tagInfo3;
        cVar = this.dXY.dXS;
        if (cVar != null) {
            tagInfo = this.dXY.dXP;
            if (tagInfo != null) {
                tagInfo2 = this.dXY.dXP;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.dXY.dXS;
                    tagInfo3 = this.dXY.dXP;
                    cVar2.p(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.recommendfrs.r.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.dXY.Pd();
        if (i != 1) {
            bdTypeListView = this.dXY.dXQ;
            bdTypeListView.setVisibility(8);
            this.dXY.showNetRefreshView(this.dXY, str, true);
        } else if (com.baidu.adp.lib.util.i.fq()) {
            tbPageContext = this.dXY.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.r.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.dXY.Pd();
        this.dXY.Pe();
        bdTypeListView = this.dXY.dXQ;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.recommendfrs.r.a
    public void ci(List<TagInfo> list) {
        c cVar;
        c cVar2;
        cVar = this.dXY.dXS;
        if (cVar != null) {
            cVar2 = this.dXY.dXS;
            cVar2.ch(list);
        }
    }
}
