package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private ArrayList<com.baidu.tbadk.core.data.q> bSM;
    private Context mContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.bSM = null;
        this.mSkinType = -1;
        this.mContext = context;
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(ArrayList<com.baidu.tbadk.core.data.q> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.bSM = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.bSM = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.bSM.size()) {
                addView(b(this.bSM.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View b(com.baidu.tbadk.core.data.q qVar, int i) {
        if (qVar == null) {
            return null;
        }
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_top_item, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_top_title);
        inflate.findViewById(com.baidu.tieba.v.frs_top_divider);
        String tid = qVar.getTid();
        textView.setText(qVar.getTitle());
        ((BaseActivity) this.mContext).getLayoutMode().L(this.mSkinType == 1);
        ((BaseActivity) this.mContext).getLayoutMode().h(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_notice);
        com.baidu.tbadk.core.util.aw.h(linearLayout, com.baidu.tieba.u.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new q(this, tid));
        return inflate;
    }
}
