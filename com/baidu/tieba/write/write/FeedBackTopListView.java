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
    private TbPageContext<?> GM;
    private ArrayList<com.baidu.tbadk.core.data.bg> gdX;
    private Context mContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gdX = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<com.baidu.tbadk.core.data.bg> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.GM = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.gdX = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.gdX = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.gdX.size()) {
                addView(d(this.gdX.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View d(com.baidu.tbadk.core.data.bg bgVar, int i) {
        if (bgVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(t.g.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(t.g.frs_top_title);
        inflate.findViewById(t.g.frs_top_divider);
        String tid = bgVar.getTid();
        textView.setText(bgVar.getTitle());
        this.GM.getLayoutMode().ah(this.mSkinType == 1);
        this.GM.getLayoutMode().x(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_notice);
        com.baidu.tbadk.core.util.av.k(linearLayout, t.f.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new q(this, bgVar, tid));
        return inflate;
    }
}
