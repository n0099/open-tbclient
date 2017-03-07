package com.baidu.tieba.personPolymeric.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.e.c<TbImageView> {
    final /* synthetic */ k eGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.eGq = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: wW */
    public TbImageView fF() {
        TbPageContext tbPageContext;
        tbPageContext = this.eGq.ajF;
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderColor(aq.getColor(w.e.common_color_10043));
        tbImageView.setBorderWidth(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void o(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public TbImageView p(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public TbImageView q(TbImageView tbImageView) {
        tbImageView.setOnClickListener(null);
        tbImageView.setForegroundColor(0);
        return tbImageView;
    }
}
