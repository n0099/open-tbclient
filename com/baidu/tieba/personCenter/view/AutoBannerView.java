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
    private com.baidu.tbadk.h.c cmI;
    private CoverFlowView<com.baidu.tieba.personCenter.data.a> fkF;
    private List<com.baidu.tieba.personCenter.data.a> mData;

    public AutoBannerView(Context context) {
        this(context, null);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkF = null;
        this.mData = null;
        initUI();
    }

    private void initUI() {
        this.fkF = new CoverFlowView<>(getContext());
        com.baidu.tbadk.core.flow.a.b bVar = new com.baidu.tbadk.core.flow.a.b() { // from class: com.baidu.tieba.personCenter.view.AutoBannerView.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.e ahk() {
                com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
                eVar.setHeight(l.g(AutoBannerView.this.getContext(), R.dimen.tbds260));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView cm(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c ahj() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.hN(R.drawable.icon_banner_gray_n);
                cVar.hO(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.hP(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.fkF.setIndicatorNoOffet(false);
        this.fkF.setDisableParentEvent(false);
        this.fkF.setCoverFlowFactory(bVar);
        this.fkF.setIndicatorVisible(0);
        this.fkF.setIsAutoPlayDragging(false);
        addView(this.fkF);
    }

    public CoverFlowView getCoverFlowView() {
        return this.fkF;
    }

    public boolean checkIndex(int i) {
        return i > 0 && i <= v.Z(this.mData);
    }

    public void yC(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ba.ajK().c((TbPageContext) i.ab(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alB() {
        if (this.fkF != null) {
            this.fkF.ahn();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.fkF != null) {
            this.fkF.setIndicatorVisible(i);
        }
    }

    public void cC(List<com.baidu.tieba.personCenter.data.a> list) {
        this.mData = list;
        this.fkF.setData(list);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.cmI = cVar;
    }

    public void onChangeSkinType(int i) {
        if (this.fkF != null) {
            this.fkF.onChangeSkinType();
        }
    }

    public void setMarqueenTime(long j) {
        if (this.fkF != null) {
            this.fkF.setMarqueenTime(j);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.cmI != null) {
            this.cmI.a(this, i == 0, null);
        }
    }
}
