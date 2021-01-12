package com.baidu.tieba.newdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.newdetail.a.b, C0801a> {
    private f<com.baidu.tieba.newdetail.a.b> jYy;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.newdetail.a.a.lqI);
        this.jYy = new f<com.baidu.tieba.newdetail.a.b>() { // from class: com.baidu.tieba.newdetail.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, com.baidu.tieba.newdetail.a.b bVar, int i, long j) {
                if (bVar != null) {
                    com.baidu.tieba.newdetail.b.c("c13820", bVar, i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, com.baidu.tieba.newdetail.a.b bVar, int i, long j) {
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cn */
    public C0801a e(ViewGroup viewGroup) {
        C0801a c0801a = new C0801a(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        c0801a.setOnItemCoverListener(this.jYy);
        c0801a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0801a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.newdetail.a.b bVar, C0801a c0801a) {
        if (bVar == null || c0801a == null) {
            return null;
        }
        c0801a.a(bVar);
        c0801a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0801a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.newdetail.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0801a extends TypeAdapter.ViewHolder {
        private HotTopicDetailSpecialItem lqk;

        C0801a(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.lqk = hotTopicDetailSpecialItem;
        }

        void a(com.baidu.tieba.newdetail.a.b bVar) {
            if (bVar != null) {
                this.lqk.a(bVar);
            }
        }

        public void setOnItemCoverListener(f<com.baidu.tieba.newdetail.a.b> fVar) {
            this.lqk.setOnItemCoverListener(fVar);
        }

        void onChangeSkinType(int i) {
            this.lqk.onChangeSkinType(i);
        }
    }
}
