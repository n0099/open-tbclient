package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.f.c<TbImageView> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: vT */
    public TbImageView hc() {
        TbImageView tbImageView = new TbImageView(this.val$context);
        tbImageView.setSupportNoImage(true);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setDrawBorder(true);
        tbImageView.setBorderWidth(1);
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(TbImageView tbImageView) {
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
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
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
        return tbImageView;
    }
}
