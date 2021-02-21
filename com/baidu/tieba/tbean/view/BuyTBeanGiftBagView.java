package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class BuyTBeanGiftBagView extends LinearLayout {
    private LinkedList<com.baidu.tieba.tbean.b.a> nCT;
    private a nCU;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.tbean.b.a aVar);
    }

    public BuyTBeanGiftBagView(Context context) {
        super(context);
        this.nCT = new LinkedList<>();
        init();
    }

    public BuyTBeanGiftBagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nCT = new LinkedList<>();
        init();
    }

    public BuyTBeanGiftBagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nCT = new LinkedList<>();
        init();
    }

    private void init() {
        setOrientation(1);
    }

    public void setClickListener(a aVar) {
        this.nCU = aVar;
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
            if (aVar.nCQ != null && !StringUtils.isNull(aVar.nCQ.package_pic)) {
                tbImageView.startLoad(aVar.nCQ.package_pic, 10, false);
            }
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BuyTBeanGiftBagView.this.nCU != null) {
                        BuyTBeanGiftBagView.this.nCU.a(aVar);
                    }
                }
            });
        }
    }

    public void fS(List<com.baidu.tieba.tbean.b.a> list) {
        if (!y.isEmpty(list)) {
            this.nCT.clear();
            this.nCT.addAll(list);
            removeAllViews();
            Iterator<com.baidu.tieba.tbean.b.a> it = this.nCT.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }
}
