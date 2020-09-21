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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes21.dex */
public class AutoBannerView extends RelativeLayout {
    private CoverFlowView<com.baidu.tieba.personCenter.c.a> aiD;
    private com.baidu.tbadk.h.c aiE;
    private List<com.baidu.tieba.personCenter.c.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiD = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.aiD = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e uf() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView V(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c ug() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.nT(R.drawable.icon_banner_gray_n);
                cVar.nU(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.nV(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.aiD.setIndicatorNoOffet(false);
        this.aiD.setDisableParentEvent(false);
        this.aiD.setCoverFlowFactory(bVar);
        this.aiD.setIndicatorVisible(0);
        this.aiD.setIsAutoPlayDragging(false);
        addView(this.aiD);
    }

    public CoverFlowView getCoverFlowView() {
        return this.aiD;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= y.getCount(this.mData);
    }

    public void dl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                be.bkp().b((TbPageContext) i.I(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bmJ() {
        if (this.aiD != null) {
            this.aiD.biy();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.aiD != null) {
            this.aiD.setIndicatorVisible(i);
        }
    }

    public void r(List<com.baidu.tieba.personCenter.c.a> list) {
        this.mData = list;
        this.aiD.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.aiE = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.aiD != null) {
            this.aiD.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.aiD != null) {
            this.aiD.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aiE != null) {
            this.aiE.a(this, i == 0, null);
        }
    }
}
