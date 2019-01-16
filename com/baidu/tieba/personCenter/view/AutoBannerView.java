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
    private com.baidu.tbadk.f.a aTt;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> dAd;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.dAd = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.dAd = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e Cd() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), e.C0210e.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bs(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.h(AutoBannerView.this.getContext(), e.C0210e.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c Cc() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.ds(e.f.icon_banner_gray_n);
                cVar.dt(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.du(e.C0210e.tbds26);
                cVar.dv(e.C0210e.tbds44);
                cVar.setSpacing(e.C0210e.tbds10);
                return cVar;
            }
        };
        this.dAd.setIndicatorNoOffet(false);
        this.dAd.setDisableParentEvent(false);
        this.dAd.setCoverFlowFactory(bVar);
        this.dAd.setIndicatorVisible(0);
        this.dAd.setIsAutoPlayDragging(false);
        addView(this.dAd);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dAd;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.H(this.mData);
    }

    public void pk(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.Es().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FS() {
        if (this.dAd != null) {
            this.dAd.Cg();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dAd != null) {
            this.dAd.setIndicatorVisible(i);
        }
    }

    public void bX(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.dAd.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aTt = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dAd != null) {
            this.dAd.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.dAd != null) {
            this.dAd.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aTt != null) {
            this.aTt.a(this, i == 0, null);
        }
    }
}
