package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.h.a ccm;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> eNg;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.eNg = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.eNg = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e abk() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), d.e.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView cG(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setDefaultResource(d.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.h(AutoBannerView.this.getContext(), d.e.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c abj() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.gT(d.f.icon_banner_gray_n);
                cVar.gU(d.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.gV(d.e.tbds26);
                cVar.setSpacing(d.e.tbds10);
                return cVar;
            }
        };
        this.eNg.setIndicatorNoOffet(false);
        this.eNg.setDisableParentEvent(false);
        this.eNg.setCoverFlowFactory(bVar);
        this.eNg.setIndicatorVisible(0);
        this.eNg.setIsAutoPlayDragging(false);
        addView(this.eNg);
    }

    public CoverFlowView getCoverFlowView() {
        return this.eNg;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.S(this.mData);
    }

    public void wg(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ba.adA().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afj() {
        if (this.eNg != null) {
            this.eNg.abn();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.eNg != null) {
            this.eNg.setIndicatorVisible(i);
        }
    }

    public void cu(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.eNg.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.a aVar) {
        this.ccm = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.eNg != null) {
            this.eNg.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.eNg != null) {
            this.eNg.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.ccm != null) {
            this.ccm.a(this, i == 0, null);
        }
    }
}
