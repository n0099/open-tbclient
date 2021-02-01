package com.baidu.tieba.newlist.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.newlist.b.b, a> {
    private f<com.baidu.tieba.newlist.b.b> kgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.newlist.b.a.lFE);
        this.kgb = new f<com.baidu.tieba.newlist.b.b>() { // from class: com.baidu.tieba.newlist.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, com.baidu.tieba.newlist.b.b bVar, int i, long j) {
                if (bVar != null) {
                    com.baidu.tieba.newlist.a.c("c13737", bVar, i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, com.baidu.tieba.newlist.b.b bVar, int i, long j) {
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cp */
    public a e(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.kgb);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a aVar = new a(hotTopicListInfoItem);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.newlist.b.b bVar, a aVar) {
        if (bVar == null || aVar == null) {
            return null;
        }
        aVar.a(bVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private HotTopicListInfoItem lFD;

        a(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.lFD = hotTopicListInfoItem;
        }

        void a(com.baidu.tieba.newlist.b.b bVar) {
            if (bVar != null) {
                this.lFD.a(bVar);
            }
        }

        void onChangeSkinType(int i) {
            this.lFD.onChangeSkinType(i);
        }
    }
}
