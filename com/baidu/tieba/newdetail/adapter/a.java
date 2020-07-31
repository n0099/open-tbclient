package com.baidu.tieba.newdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
/* loaded from: classes15.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.newdetail.a.b, C0701a> {
    private f<com.baidu.tieba.newdetail.a.b> iwR;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.newdetail.a.a.jWC);
        this.iwR = new f<com.baidu.tieba.newdetail.a.b>() { // from class: com.baidu.tieba.newdetail.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, com.baidu.tieba.newdetail.a.b bVar, int i, long j) {
                if (bVar != null) {
                    com.baidu.tieba.newdetail.b.b("c13820", bVar, i);
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
    /* renamed from: ca */
    public C0701a b(ViewGroup viewGroup) {
        C0701a c0701a = new C0701a(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        c0701a.setOnItemCoverListener(this.iwR);
        c0701a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0701a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.newdetail.a.b bVar, C0701a c0701a) {
        if (bVar == null || c0701a == null) {
            return null;
        }
        c0701a.a(bVar);
        c0701a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0701a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.newdetail.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0701a extends ad.a {
        private HotTopicDetailSpecialItem jWe;

        C0701a(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.jWe = hotTopicDetailSpecialItem;
        }

        void a(com.baidu.tieba.newdetail.a.b bVar) {
            if (bVar != null) {
                this.jWe.a(bVar);
            }
        }

        public void setOnItemCoverListener(f<com.baidu.tieba.newdetail.a.b> fVar) {
            this.jWe.setOnItemCoverListener(fVar);
        }

        void onChangeSkinType(int i) {
            this.jWe.onChangeSkinType(i);
        }
    }
}
