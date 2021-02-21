package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.newdetail.adapter.a;
import com.baidu.tieba.newdetail.adapter.b;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class HotTopicDetailSpecialLayout extends BdTypeRecyclerView {
    private int kgW;

    public HotTopicDetailSpecialLayout(Context context) {
        super(context);
        this.kgW = 3;
        initView();
    }

    public HotTopicDetailSpecialLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        initView();
    }

    public HotTopicDetailSpecialLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        initView();
    }

    private void initView() {
        setLayoutManager(new LinearLayoutManager(getContext()));
        setOverScrollMode(2);
    }

    public void y(TbPageContext tbPageContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(tbPageContext));
        arrayList.add(new b(tbPageContext));
        addAdapters(arrayList);
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            getListAdapter().notifyDataSetChanged();
            this.kgW = i;
        }
    }
}
