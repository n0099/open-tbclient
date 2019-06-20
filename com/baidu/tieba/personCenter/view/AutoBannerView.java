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
/* loaded from: classes4.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.h.c ckt;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> fdq;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdq = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.fdq = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e agc() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.g(AutoBannerView.this.getContext(), R.dimen.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView cl(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setDefaultResource(R.drawable.img_default_100);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.g(AutoBannerView.this.getContext(), R.dimen.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c agb() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.hH(R.drawable.icon_banner_gray_n);
                cVar.hI(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.hJ(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.fdq.setIndicatorNoOffet(false);
        this.fdq.setDisableParentEvent(false);
        this.fdq.setCoverFlowFactory(bVar);
        this.fdq.setIndicatorVisible(0);
        this.fdq.setIsAutoPlayDragging(false);
        addView(this.fdq);
    }

    public CoverFlowView getCoverFlowView() {
        return this.fdq;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.Z(this.mData);
    }

    public void xx(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ba.aiz().c((TbPageContext) i.ab(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aki() {
        if (this.fdq != null) {
            this.fdq.agf();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.fdq != null) {
            this.fdq.setIndicatorVisible(i);
        }
    }

    public void cC(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.fdq.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.ckt = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.fdq != null) {
            this.fdq.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.fdq != null) {
            this.fdq.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.ckt != null) {
            this.ckt.a(this, i == 0, null);
        }
    }
}
