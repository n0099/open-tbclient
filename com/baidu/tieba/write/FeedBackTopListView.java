package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private ArrayList<com.baidu.tbadk.core.data.w> ceh;
    private Context mContext;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.ceh = null;
        this.mSkinType = -1;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.m255getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<com.baidu.tbadk.core.data.w> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.mPageContext = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.ceh = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.ceh = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.ceh.size()) {
                addView(b(this.ceh.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View b(com.baidu.tbadk.core.data.w wVar, int i) {
        if (wVar == null) {
            return null;
        }
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_top_item, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_top_title);
        inflate.findViewById(com.baidu.tieba.w.frs_top_divider);
        String tid = wVar.getTid();
        textView.setText(wVar.getTitle());
        this.mPageContext.getLayoutMode().ab(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().h(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_notice);
        com.baidu.tbadk.core.util.ax.i(linearLayout, com.baidu.tieba.v.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new q(this, tid));
        return inflate;
    }
}
