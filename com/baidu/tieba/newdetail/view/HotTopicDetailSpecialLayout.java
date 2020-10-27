package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.newdetail.adapter.a;
import com.baidu.tieba.newdetail.adapter.b;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class HotTopicDetailSpecialLayout extends BdTypeRecyclerView {
    private int jvY;

    public HotTopicDetailSpecialLayout(Context context) {
        super(context);
        this.jvY = 3;
        initView();
    }

    public HotTopicDetailSpecialLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvY = 3;
        initView();
    }

    public HotTopicDetailSpecialLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvY = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new LinearLayoutManager(getContext()));
        setOverScrollMode(2);
    }

    public void x(TbPageContext tbPageContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(tbPageContext));
        arrayList.add(new b(tbPageContext));
        addAdapters(arrayList);
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            getListAdapter().notifyDataSetChanged();
            this.jvY = i;
        }
    }
}
