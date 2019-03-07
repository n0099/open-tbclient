package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class CommonImageButton extends FrameLayout {
    private TbImageView eKV;
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
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.lego_common_button, (ViewGroup) this, true);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.image_local);
        this.eKV = (TbImageView) this.mRootView.findViewById(d.g.image_net);
    }

    public void a(com.baidu.tieba.lego.card.model.a aVar) {
        if (aVar != null) {
            if (!aVar.bzS()) {
                com.baidu.tieba.lego.a.b.bzz().g(aVar, aVar.bzQ());
            }
            if (aVar.bzU()) {
                c(aVar);
            } else {
                b(aVar);
            }
        }
    }

    private void b(com.baidu.tieba.lego.card.model.a aVar) {
        this.mTitle.setVisibility(8);
        this.eKV.setVisibility(0);
        this.eKV.startLoad(1 == TbadkCoreApplication.getInst().getSkinType() ? aVar.bzV() : aVar.getImageUrl(), 10, false);
    }

    private void c(com.baidu.tieba.lego.card.model.a aVar) {
        this.eKV.setVisibility(8);
        int bzW = aVar.bzW();
        if (bzW != 0) {
            this.mTitle.setVisibility(0);
            al.k(this.mTitle, bzW);
            return;
        }
        this.mTitle.setVisibility(8);
    }
}
