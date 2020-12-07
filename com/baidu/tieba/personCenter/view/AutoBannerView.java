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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class AutoBannerView extends RelativeLayout {
    private CoverFlowView<com.baidu.tieba.personCenter.c.a> aka;
    private com.baidu.tbadk.h.c akb;
    private List<com.baidu.tieba.personCenter.c.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aka = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.aka = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e ui() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView W(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c uj() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.pH(R.drawable.icon_banner_gray_n);
                cVar.pI(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.pJ(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.aka.setIndicatorNoOffet(false);
        this.aka.setDisableParentEvent(false);
        this.aka.setCoverFlowFactory(bVar);
        this.aka.setIndicatorVisible(0);
        this.aka.setIsAutoPlayDragging(false);
        addView(this.aka);
    }

    public CoverFlowView getCoverFlowView() {
        return this.aka;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= y.getCount(this.mData);
    }

    public void dq(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bf.bua().b((TbPageContext) i.J(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bwC() {
        if (this.aka != null) {
            this.aka.bsh();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.aka != null) {
            this.aka.setIndicatorVisible(i);
        }
    }

    public void r(List<com.baidu.tieba.personCenter.c.a> list) {
        this.mData = list;
        this.aka.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.akb = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.aka != null) {
            this.aka.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.aka != null) {
            this.aka.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.akb != null) {
            this.akb.a(this, i == 0, null);
        }
    }
}
