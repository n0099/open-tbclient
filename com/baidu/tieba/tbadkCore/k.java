package com.baidu.tieba.tbadkCore;

import android.content.Context;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.e.c<TbImageView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: tR */
    public TbImageView hA() {
        return new TbImageView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(TbImageView tbImageView) {
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public TbImageView l(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public TbImageView m(TbImageView tbImageView) {
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
        return tbImageView;
    }
}
