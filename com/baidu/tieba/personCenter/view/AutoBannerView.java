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
    private com.baidu.tbadk.h.c dRx;
    private CoverFlowView<com.baidu.tieba.personCenter.c.a> gQp;
    private List<com.baidu.tieba.personCenter.c.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gQp = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.gQp = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e aNk() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView dk(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c aNj() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.kr(R.drawable.icon_banner_gray_n);
                cVar.ks(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.kt(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.gQp.setIndicatorNoOffet(false);
        this.gQp.setDisableParentEvent(false);
        this.gQp.setCoverFlowFactory(bVar);
        this.gQp.setIndicatorVisible(0);
        this.gQp.setIsAutoPlayDragging(false);
        addView(this.gQp);
    }

    public CoverFlowView getCoverFlowView() {
        return this.gQp;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.getCount(this.mData);
    }

    public void Ir(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ba.aOV().b((TbPageContext) i.G(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aQY() {
        if (this.gQp != null) {
            this.gQp.aNn();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.gQp != null) {
            this.gQp.setIndicatorVisible(i);
        }
    }

    public void dZ(List<com.baidu.tieba.personCenter.c.a> list) {
        this.mData = list;
        this.gQp.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.dRx = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.gQp != null) {
            this.gQp.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.gQp != null) {
            this.gQp.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.dRx != null) {
            this.dRx.a(this, i == 0, null);
        }
    }
}
