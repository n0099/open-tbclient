package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CommonImageButton extends FrameLayout {
    private TbImageView iIW;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public CommonImageButton(Context context) {
        this(context, null, 0);
    }

    public CommonImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.lego_common_button, (ViewGroup) this, true);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.image_local);
        this.iIW = (TbImageView) this.mRootView.findViewById(R.id.image_net);
    }

    public void a(com.baidu.tieba.lego.card.model.a aVar) {
        if (aVar != null) {
            if (!aVar.cZF()) {
                com.baidu.tieba.lego.a.b.cZm().k(aVar, aVar.cZD());
            }
            if (aVar.cZH()) {
                c(aVar);
            } else {
                b(aVar);
            }
        }
    }

    private void b(com.baidu.tieba.lego.card.model.a aVar) {
        this.mTitle.setVisibility(8);
        this.iIW.setVisibility(0);
        this.iIW.startLoad(1 == TbadkCoreApplication.getInst().getSkinType() ? aVar.cZI() : aVar.getImageUrl(), 10, false);
    }

    private void c(com.baidu.tieba.lego.card.model.a aVar) {
        this.iIW.setVisibility(8);
        int cZJ = aVar.cZJ();
        if (cZJ != 0) {
            this.mTitle.setVisibility(0);
            ao.setBackgroundResource(this.mTitle, cZJ);
            return;
        }
        this.mTitle.setVisibility(8);
    }
}
