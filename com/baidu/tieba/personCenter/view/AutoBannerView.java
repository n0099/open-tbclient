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
    private com.baidu.tbadk.f.a aOu;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> dpd;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.dpd = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.dpd = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e AF() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), e.C0175e.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView br(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.h(AutoBannerView.this.getContext(), e.C0175e.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c AE() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.cQ(e.f.icon_banner_gray_n);
                cVar.cR(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.cS(e.C0175e.tbds26);
                cVar.cT(e.C0175e.tbds44);
                cVar.setSpacing(e.C0175e.tbds10);
                return cVar;
            }
        };
        this.dpd.setIndicatorNoOffet(false);
        this.dpd.setDisableParentEvent(false);
        this.dpd.setCoverFlowFactory(bVar);
        this.dpd.setIndicatorVisible(0);
        this.dpd.setIsAutoPlayDragging(false);
        addView(this.dpd);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dpd;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.I(this.mData);
    }

    public void or(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.CU().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Eq() {
        if (this.dpd != null) {
            this.dpd.AI();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dpd != null) {
            this.dpd.setIndicatorVisible(i);
        }
    }

    public void bV(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.dpd.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aOu = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dpd != null) {
            this.dpd.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.dpd != null) {
            this.dpd.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aOu != null) {
            this.aOu.a(this, i == 0, null);
        }
    }
}
