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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private TbPageContext<?> ajU;
    private ArrayList<com.baidu.tbadk.core.data.bi> fTi;
    private Context mContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fTi = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<com.baidu.tbadk.core.data.bi> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.ajU = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.fTi = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.fTi = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.fTi.size()) {
                addView(d(this.fTi.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View d(com.baidu.tbadk.core.data.bi biVar, int i) {
        if (biVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(w.h.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(w.h.frs_top_title);
        inflate.findViewById(w.h.frs_top_divider);
        String tid = biVar.getTid();
        textView.setText(biVar.getTitle());
        this.ajU.getLayoutMode().aj(this.mSkinType == 1);
        this.ajU.getLayoutMode().t(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_notice);
        com.baidu.tbadk.core.util.aq.j(linearLayout, w.g.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new p(this, biVar, tid));
        return inflate;
    }
}
