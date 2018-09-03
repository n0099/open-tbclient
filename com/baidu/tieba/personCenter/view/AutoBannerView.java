package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes2.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.f.a aGE;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> dbe;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.dbe = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.dbe = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e xq() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.f(AutoBannerView.this.getContext(), f.e.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView aC(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setDefaultResource(f.C0146f.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.f(AutoBannerView.this.getContext(), f.e.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c xp() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.cw(f.C0146f.icon_banner_gray_n);
                cVar.cx(f.C0146f.icon_banner_s);
                cVar.setGravity(81);
                cVar.cy(f.e.tbds26);
                cVar.cz(f.e.tbds44);
                cVar.setSpacing(f.e.tbds10);
                return cVar;
            }
        };
        this.dbe.setIndicatorNoOffet(false);
        this.dbe.setDisableParentEvent(false);
        this.dbe.setCoverFlowFactory(bVar);
        this.dbe.setIndicatorVisible(0);
        this.dbe.setIsAutoPlayDragging(false);
        addView(this.dbe);
    }

    public CoverFlowView getCoverFlowView() {
        return this.dbe;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= w.y(this.mData);
    }

    public void ni(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                az.zI().c((TbPageContext) i.ad(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AZ() {
        if (this.dbe != null) {
            this.dbe.xt();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.dbe != null) {
            this.dbe.setIndicatorVisible(i);
        }
    }

    public void bE(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.dbe.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aGE = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.dbe != null) {
            this.dbe.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.dbe != null) {
            this.dbe.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aGE != null) {
            this.aGE.a(this, i == 0, null);
        }
    }
}
