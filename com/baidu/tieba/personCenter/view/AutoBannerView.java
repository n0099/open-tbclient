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
    private com.baidu.tbadk.f.a aTu;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> dAe;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.dAe = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.dAe = new CoverFlowView<>(getContext());
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
        this.dAe.setIndicatorNoOffet(false);
        this.dAe.setDisableParentEvent(false);
        this.dAe.setCoverFlowFactory(bVar);
        this.dAe.setIndicatorVisible(0);
        this.dAe.setIsAutoPlayDragging(false);
        addView(this.dAe);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dAe;
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
        if (this.dAe != null) {
            this.dAe.Cg();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dAe != null) {
            this.dAe.setIndicatorVisible(i);
        }
    }

    public void bX(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.dAe.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aTu = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dAe != null) {
            this.dAe.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.dAe != null) {
            this.dAe.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aTu != null) {
            this.aTu.a(this, i == 0, null);
        }
    }
}
