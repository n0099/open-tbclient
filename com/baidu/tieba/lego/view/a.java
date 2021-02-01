package com.baidu.tieba.lego.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.b<com.baidu.tbadk.core.view.viewpager.bannerflow.a, C0777a> {
    private Context mContext;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.viewpager.b
    public View a(ViewGroup viewGroup, C0777a c0777a, com.baidu.tbadk.core.view.viewpager.bannerflow.a aVar) {
        c0777a.feK.startLoad(aVar.getImageUrl(), 17, false);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.b
    /* renamed from: cl */
    public C0777a J(ViewGroup viewGroup) {
        TbImageView tbImageView = new TbImageView(this.mContext);
        tbImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return new C0777a(tbImageView);
    }

    /* renamed from: com.baidu.tieba.lego.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0777a extends BdBaseViewPagerAdapter.a {
        public TbImageView feK;

        public C0777a(View view) {
            super(view);
            if (view instanceof TbImageView) {
                this.feK = (TbImageView) view;
                this.feK.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }
}
