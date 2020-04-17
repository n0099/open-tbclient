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
/* loaded from: classes9.dex */
public class AutoBannerView extends RelativeLayout {
    private com.baidu.tbadk.h.c dRs;
    private CoverFlowView<com.baidu.tieba.personCenter.c.a> gQj;
    private List<com.baidu.tieba.personCenter.c.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gQj = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.gQj = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e aNm() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView dw(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c aNl() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.kr(R.drawable.icon_banner_gray_n);
                cVar.ks(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.kt(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.gQj.setIndicatorNoOffet(false);
        this.gQj.setDisableParentEvent(false);
        this.gQj.setCoverFlowFactory(bVar);
        this.gQj.setIndicatorVisible(0);
        this.gQj.setIsAutoPlayDragging(false);
        addView(this.gQj);
    }

    public CoverFlowView getCoverFlowView() {
        return this.gQj;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.getCount(this.mData);
    }

    public void Io(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ba.aOY().b((TbPageContext) i.T(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aRb() {
        if (this.gQj != null) {
            this.gQj.aNp();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.gQj != null) {
            this.gQj.setIndicatorVisible(i);
        }
    }

    public void dZ(List<com.baidu.tieba.personCenter.c.a> list) {
        this.mData = list;
        this.gQj.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.dRs = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.gQj != null) {
            this.gQj.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.gQj != null) {
            this.gQj.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.dRs != null) {
            this.dRs.a(this, i == 0, null);
        }
    }
}
