package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class BuyTBeanGiftBagView extends LinearLayout {
    private LinkedList<com.baidu.tieba.tbean.b.a> nxp;
    private a nxq;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.tbean.b.a aVar);
    }

    public BuyTBeanGiftBagView(Context context) {
        super(context);
        this.nxp = new LinkedList<>();
        init();
    }

    public BuyTBeanGiftBagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nxp = new LinkedList<>();
        init();
    }

    public BuyTBeanGiftBagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nxp = new LinkedList<>();
        init();
    }

    private void init() {
        setOrientation(1);
    }

    public void setClickListener(a aVar) {
        this.nxq = aVar;
    }

    private void b(final com.baidu.tieba.tbean.b.a aVar) {
        if (aVar != null) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setDrawerType(1);
            tbImageView.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds10));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.tbds182));
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
            addView(tbImageView, layoutParams);
            if (aVar.nxm != null && !StringUtils.isNull(aVar.nxm.package_pic)) {
                tbImageView.startLoad(aVar.nxm.package_pic, 10, false);
            }
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BuyTBeanGiftBagView.this.nxq != null) {
                        BuyTBeanGiftBagView.this.nxq.a(aVar);
                    }
                }
            });
        }
    }

    public void fU(List<com.baidu.tieba.tbean.b.a> list) {
        if (!x.isEmpty(list)) {
            this.nxp.clear();
            this.nxp.addAll(list);
            removeAllViews();
            Iterator<com.baidu.tieba.tbean.b.a> it = this.nxp.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }
}
