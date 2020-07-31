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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class AutoBannerView extends RelativeLayout {
    private CoverFlowView<com.baidu.tieba.personCenter.c.a> agX;
    private com.baidu.tbadk.h.c agY;
    private List<com.baidu.tieba.personCenter.c.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agX = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.agX = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e so() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.getDimens(AutoBannerView.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView S(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c sp() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.lB(R.drawable.icon_banner_gray_n);
                cVar.lC(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.lD(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.agX.setIndicatorNoOffet(false);
        this.agX.setDisableParentEvent(false);
        this.agX.setCoverFlowFactory(bVar);
        this.agX.setIndicatorVisible(0);
        this.agX.setIsAutoPlayDragging(false);
        addView(this.agX);
    }

    public CoverFlowView getCoverFlowView() {
        return this.agX;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= x.getCount(this.mData);
    }

    public void cY(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bd.baV().b((TbPageContext) i.G(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bdj() {
        if (this.agX != null) {
            this.agX.aZj();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.agX != null) {
            this.agX.setIndicatorVisible(i);
        }
    }

    public void q(List<com.baidu.tieba.personCenter.c.a> list) {
        this.mData = list;
        this.agX.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.agY = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.agX != null) {
            this.agX.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.agX != null) {
            this.agX.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.agY != null) {
            this.agY.a(this, i == 0, null);
        }
    }
}
