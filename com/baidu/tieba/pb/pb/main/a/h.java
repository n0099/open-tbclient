package com.baidu.tieba.pb.pb.main.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class h implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ g eDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.eDs = gVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        f fVar;
        TbPageContext tbPageContext;
        f fVar2;
        String str;
        f fVar3;
        TbPageContext tbPageContext2;
        f fVar4;
        TbPageContext tbPageContext3;
        f fVar5;
        TbPageContext tbPageContext4;
        f fVar6;
        TbPageContext tbPageContext5;
        f fVar7;
        TbPageContext tbPageContext6;
        f fVar8;
        TbPageContext tbPageContext7;
        fVar = this.eDs.eDr;
        tbPageContext = fVar.GO;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        fVar2 = this.eDs.eDr;
        str = fVar2.mMessage;
        textView.setText(str);
        textView.setGravity(17);
        at.j((View) textView, r.d.cp_cont_i);
        fVar3 = this.eDs.eDr;
        tbPageContext2 = fVar3.GO;
        textView.setTextSize(0, tbPageContext2.getResources().getDimensionPixelSize(r.e.fontsize28));
        fVar4 = this.eDs.eDr;
        tbPageContext3 = fVar4.GO;
        textView.setHeight(tbPageContext3.getResources().getDimensionPixelSize(r.e.ds76));
        fVar5 = this.eDs.eDr;
        tbPageContext4 = fVar5.GO;
        int dimensionPixelSize = tbPageContext4.getResources().getDimensionPixelSize(r.e.ds24);
        fVar6 = this.eDs.eDr;
        tbPageContext5 = fVar6.GO;
        int dimensionPixelSize2 = tbPageContext5.getResources().getDimensionPixelSize(r.e.ds24);
        fVar7 = this.eDs.eDr;
        tbPageContext6 = fVar7.GO;
        int dimensionPixelSize3 = tbPageContext6.getResources().getDimensionPixelSize(r.e.ds24);
        fVar8 = this.eDs.eDr;
        tbPageContext7 = fVar8.GO;
        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, tbPageContext7.getResources().getDimensionPixelSize(r.e.ds10));
        textView.setSingleLine(true);
        at.k(textView, r.f.pic_sign_tip);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
