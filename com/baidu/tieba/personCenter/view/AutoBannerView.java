package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.h.c dmL;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> ged;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ged = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.ged = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e aCI() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView dF(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setPlaceHolder(2);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c aCH() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.jT(R.drawable.icon_banner_gray_n);
                cVar.jU(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.jV(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.ged.setIndicatorNoOffet(false);
        this.ged.setDisableParentEvent(false);
        this.ged.setCoverFlowFactory(bVar);
        this.ged.setIndicatorVisible(0);
        this.ged.setIsAutoPlayDragging(false);
        addView(this.ged);
    }

    public CoverFlowView getCoverFlowView() {
        return this.ged;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.getCount(this.mData);
    }

    public void Gs(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ba.aEt().b((TbPageContext) i.ab(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aGj() {
        if (this.ged != null) {
            this.ged.aCL();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.ged != null) {
            this.ged.setIndicatorVisible(i);
        }
    }

    public void dS(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.ged.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.dmL = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.ged != null) {
            this.ged.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.ged != null) {
            this.ged.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.dmL != null) {
            this.dmL.a(this, i == 0, null);
        }
    }
}
