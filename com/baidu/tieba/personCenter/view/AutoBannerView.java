package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class AutoBannerView extends RelativeLayout {
    private CoverFlowView<com.baidu.tieba.personCenter.c.a> akS;
    private com.baidu.tbadk.h.c akT;
    private List<com.baidu.tieba.personCenter.c.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akS = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.akS = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e tt() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView U(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c tu() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.oq(R.drawable.icon_banner_gray_n);
                cVar.or(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.os(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.akS.setIndicatorNoOffet(false);
        this.akS.setDisableParentEvent(false);
        this.akS.setCoverFlowFactory(bVar);
        this.akS.setIndicatorVisible(0);
        this.akS.setIsAutoPlayDragging(false);
        addView(this.akS);
    }

    public CoverFlowView getCoverFlowView() {
        return this.akS;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= y.getCount(this.mData);
    }

    public void di(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bf.bsY().b((TbPageContext) j.J(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bvz() {
        if (this.akS != null) {
            this.akS.brk();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.akS != null) {
            this.akS.setIndicatorVisible(i);
        }
    }

    public void r(List<com.baidu.tieba.personCenter.c.a> list) {
        this.mData = list;
        this.akS.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.akT = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.akS != null) {
            this.akS.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.akS != null) {
            this.akS.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.akT != null) {
            this.akT.a(this, i == 0, null);
        }
    }
}
