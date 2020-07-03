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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class AutoBannerView extends RelativeLayout {
    private CoverFlowView<com.baidu.tieba.personCenter.c.a> ahg;
    private com.baidu.tbadk.h.c ahh;
    private List<com.baidu.tieba.personCenter.c.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahg = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.ahg = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e sm() {
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
            public com.baidu.tbadk.core.flow.a.c sn() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.lh(R.drawable.icon_banner_gray_n);
                cVar.li(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.lj(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.ahg.setIndicatorNoOffet(false);
        this.ahg.setDisableParentEvent(false);
        this.ahg.setCoverFlowFactory(bVar);
        this.ahg.setIndicatorVisible(0);
        this.ahg.setIsAutoPlayDragging(false);
        addView(this.ahg);
    }

    public CoverFlowView getCoverFlowView() {
        return this.ahg;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= w.getCount(this.mData);
    }

    public void cZ(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bc.aWU().b((TbPageContext) i.G(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aZm() {
        if (this.ahg != null) {
            this.ahg.aVj();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.ahg != null) {
            this.ahg.setIndicatorVisible(i);
        }
    }

    public void q(List<com.baidu.tieba.personCenter.c.a> list) {
        this.mData = list;
        this.ahg.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.ahh = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.ahg != null) {
            this.ahg.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.ahg != null) {
            this.ahg.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.ahh != null) {
            this.ahh.a(this, i == 0, null);
        }
    }
}
