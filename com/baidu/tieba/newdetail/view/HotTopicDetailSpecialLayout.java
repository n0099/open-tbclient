package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.n0.y1.d.a;
import d.a.n0.y1.d.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class HotTopicDetailSpecialLayout extends BdTypeRecyclerView {
    public int A;

    public HotTopicDetailSpecialLayout(Context context) {
        super(context);
        this.A = 3;
        G();
    }

    public void F(TbPageContext tbPageContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(tbPageContext));
        arrayList.add(new b(tbPageContext));
        a(arrayList);
    }

    public final void G() {
        setLayoutManager(new LinearLayoutManager(getContext()));
        setOverScrollMode(2);
    }

    public void H(int i2) {
        if (this.A != i2) {
            getListAdapter().notifyDataSetChanged();
            this.A = i2;
        }
    }

    public HotTopicDetailSpecialLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = 3;
        G();
    }

    public HotTopicDetailSpecialLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = 3;
        G();
    }
}
