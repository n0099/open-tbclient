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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private TbPageContext<?> DV;
    private ArrayList<com.baidu.tbadk.core.data.ax> fcz;
    private Context mContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fcz = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<com.baidu.tbadk.core.data.ax> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.DV = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.fcz = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.fcz = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.fcz.size()) {
                addView(d(this.fcz.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View d(com.baidu.tbadk.core.data.ax axVar, int i) {
        if (axVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(t.g.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(t.g.frs_top_title);
        inflate.findViewById(t.g.frs_top_divider);
        String tid = axVar.getTid();
        textView.setText(axVar.getTitle());
        this.DV.getLayoutMode().ae(this.mSkinType == 1);
        this.DV.getLayoutMode().x(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_notice);
        com.baidu.tbadk.core.util.at.k(linearLayout, t.f.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new q(this, axVar, tid));
        return inflate;
    }
}
