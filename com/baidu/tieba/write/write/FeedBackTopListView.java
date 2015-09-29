package com.baidu.tieba.write.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private ArrayList<com.baidu.tbadk.core.data.v> doh;
    private Context mContext;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.doh = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<com.baidu.tbadk.core.data.v> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.mPageContext = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.doh = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.doh = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.doh.size()) {
                addView(c(this.doh.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View c(com.baidu.tbadk.core.data.v vVar, int i) {
        if (vVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(i.f.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(i.f.frs_top_title);
        inflate.findViewById(i.f.frs_top_divider);
        String tid = vVar.getTid();
        textView.setText(vVar.getTitle());
        this.mPageContext.getLayoutMode().ad(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().k(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_notice);
        com.baidu.tbadk.core.util.am.i(linearLayout, i.e.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new p(this, vVar, tid));
        return inflate;
    }
}
