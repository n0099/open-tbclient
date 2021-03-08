package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CommonImageButton extends FrameLayout {
    private TbImageView iQB;
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
        this.iQB = (TbImageView) this.mRootView.findViewById(R.id.image_net);
    }

    public void a(com.baidu.tieba.lego.card.model.a aVar) {
        if (aVar != null) {
            if (!aVar.dbT()) {
                com.baidu.tieba.lego.a.b.dbA().l(aVar, aVar.dbR());
            }
            if (aVar.dbV()) {
                c(aVar);
            } else {
                b(aVar);
            }
        }
    }

    private void b(com.baidu.tieba.lego.card.model.a aVar) {
        this.mTitle.setVisibility(8);
        this.iQB.setVisibility(0);
        this.iQB.startLoad(1 == TbadkCoreApplication.getInst().getSkinType() ? aVar.dbW() : aVar.getImageUrl(), 10, false);
    }

    private void c(com.baidu.tieba.lego.card.model.a aVar) {
        this.iQB.setVisibility(8);
        int dbX = aVar.dbX();
        if (dbX != 0) {
            this.mTitle.setVisibility(0);
            ap.setBackgroundResource(this.mTitle, dbX);
            return;
        }
        this.mTitle.setVisibility(8);
    }
}
