package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aPk;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> dqh;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.dqh = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.dqh = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e AM() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), e.C0200e.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bp(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.h(AutoBannerView.this.getContext(), e.C0200e.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c AL() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.de(e.f.icon_banner_gray_n);
                cVar.df(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.dg(e.C0200e.tbds26);
                cVar.dh(e.C0200e.tbds44);
                cVar.setSpacing(e.C0200e.tbds10);
                return cVar;
            }
        };
        this.dqh.setIndicatorNoOffet(false);
        this.dqh.setDisableParentEvent(false);
        this.dqh.setCoverFlowFactory(bVar);
        this.dqh.setIndicatorVisible(0);
        this.dqh.setIsAutoPlayDragging(false);
        addView(this.dqh);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dqh;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.H(this.mData);
    }

    public void os(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.Db().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EA() {
        if (this.dqh != null) {
            this.dqh.AP();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dqh != null) {
            this.dqh.setIndicatorVisible(i);
        }
    }

    public void bT(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.dqh.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aPk = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dqh != null) {
            this.dqh.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.dqh != null) {
            this.dqh.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aPk != null) {
            this.aPk.a(this, i == 0, null);
        }
    }
}
