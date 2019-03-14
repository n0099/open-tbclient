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
    private com.baidu.tbadk.h.a cck;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> eNu;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        super(context);
        this.eNu = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.eNu = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e abn() {
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
            public com.baidu.tbadk.core.flow.a.c abm() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.gU(d.f.icon_banner_gray_n);
                cVar.gV(d.f.icon_banner_s);
                cVar.setGravity(81);
                cVar.gW(d.e.tbds26);
                cVar.setSpacing(d.e.tbds10);
                return cVar;
            }
        };
        this.eNu.setIndicatorNoOffet(false);
        this.eNu.setDisableParentEvent(false);
        this.eNu.setCoverFlowFactory(bVar);
        this.eNu.setIndicatorVisible(0);
        this.eNu.setIsAutoPlayDragging(false);
        addView(this.eNu);
    }

    public CoverFlowView getCoverFlowView() {
        return this.eNu;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.S(this.mData);
    }

    public void wh(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ba.adD().c((TbPageContext) i.aK(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afm() {
        if (this.eNu != null) {
            this.eNu.abq();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.eNu != null) {
            this.eNu.setIndicatorVisible(i);
        }
    }

    public void cx(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.eNu.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.a aVar) {
        this.cck = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.eNu != null) {
            this.eNu.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.eNu != null) {
            this.eNu.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.cck != null) {
            this.cck.a(this, i == 0, null);
        }
    }
}
