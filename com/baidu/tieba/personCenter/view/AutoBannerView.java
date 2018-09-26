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
/* loaded from: classes2.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aJS;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> dgZ;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.dgZ = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.dgZ = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e yx() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.h(AutoBannerView.this.getContext(), e.C0141e.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView bi(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setDefaultResource(e.f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.h(AutoBannerView.this.getContext(), e.C0141e.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c yw() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.cG(e.f.icon_banner_gray_n);
                cVar.cH(e.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.cI(e.C0141e.tbds26);
                cVar.cJ(e.C0141e.tbds44);
                cVar.setSpacing(e.C0141e.tbds10);
                return cVar;
            }
        };
        this.dgZ.setIndicatorNoOffet(false);
        this.dgZ.setDisableParentEvent(false);
        this.dgZ.setCoverFlowFactory(bVar);
        this.dgZ.setIndicatorVisible(0);
        this.dgZ.setIsAutoPlayDragging(false);
        addView(this.dgZ);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dgZ;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.y(this.mData);
    }

    public void nN(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ay.AN().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Cl() {
        if (this.dgZ != null) {
            this.dgZ.yA();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dgZ != null) {
            this.dgZ.setIndicatorVisible(i);
        }
    }

    public void bF(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.dgZ.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aJS = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dgZ != null) {
            this.dgZ.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.dgZ != null) {
            this.dgZ.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aJS != null) {
            this.aJS.a(this, i == 0, null);
        }
    }
}
