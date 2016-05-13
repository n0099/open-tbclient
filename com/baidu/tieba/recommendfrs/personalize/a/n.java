package com.baidu.tieba.recommendfrs.personalize.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.f.c<TbImageView> {
    final /* synthetic */ l ebq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.ebq = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: vx */
    public TbImageView dE() {
        TbPageContext tbPageContext;
        tbPageContext = this.ebq.DV;
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderColor(at.getColor(t.d.black_alpha4));
        tbImageView.setBorderWidth(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1));
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public TbImageView m(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public TbImageView n(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
        return tbImageView;
    }
}
