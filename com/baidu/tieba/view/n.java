package com.baidu.tieba.view;

import android.content.Context;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.d.c<TbImageView> {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public TbImageView a() {
        return new TbImageView(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(TbImageView tbImageView) {
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public TbImageView b(TbImageView tbImageView) {
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public TbImageView c(TbImageView tbImageView) {
        tbImageView.setBackgroundResource(0);
        tbImageView.setImageDrawable(null);
        tbImageView.setTag(null);
        tbImageView.setOnClickListener(null);
        return tbImageView;
    }
}
