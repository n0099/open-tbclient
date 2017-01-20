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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private TbPageContext<?> FY;
    private ArrayList<com.baidu.tbadk.core.data.bh> fKJ;
    private Context mContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fKJ = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<com.baidu.tbadk.core.data.bh> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.FY = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.fKJ = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.fKJ = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.fKJ.size()) {
                addView(d(this.fKJ.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View d(com.baidu.tbadk.core.data.bh bhVar, int i) {
        if (bhVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(r.j.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(r.h.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(r.h.frs_top_title);
        inflate.findViewById(r.h.frs_top_divider);
        String tid = bhVar.getTid();
        textView.setText(bhVar.getTitle());
        this.FY.getLayoutMode().ai(this.mSkinType == 1);
        this.FY.getLayoutMode().v(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_notice);
        com.baidu.tbadk.core.util.ap.j(linearLayout, r.g.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new p(this, bhVar, tid));
        return inflate;
    }
}
