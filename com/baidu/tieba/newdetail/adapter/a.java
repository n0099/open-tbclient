package com.baidu.tieba.newdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.newdetail.a.b, C0689a> {
    private f<com.baidu.tieba.newdetail.a.b> iqN;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.newdetail.a.a.jOe);
        this.iqN = new f<com.baidu.tieba.newdetail.a.b>() { // from class: com.baidu.tieba.newdetail.adapter.a.1
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
    /* renamed from: bZ */
    public C0689a b(ViewGroup viewGroup) {
        C0689a c0689a = new C0689a(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        c0689a.setOnItemCoverListener(this.iqN);
        c0689a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0689a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.newdetail.a.b bVar, C0689a c0689a) {
        if (bVar == null || c0689a == null) {
            return null;
        }
        c0689a.a(bVar);
        c0689a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0689a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.newdetail.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0689a extends ad.a {
        private HotTopicDetailSpecialItem jNG;

        C0689a(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.jNG = hotTopicDetailSpecialItem;
        }

        void a(com.baidu.tieba.newdetail.a.b bVar) {
            if (bVar != null) {
                this.jNG.a(bVar);
            }
        }

        public void setOnItemCoverListener(f<com.baidu.tieba.newdetail.a.b> fVar) {
            this.jNG.setOnItemCoverListener(fVar);
        }

        void onChangeSkinType(int i) {
            this.jNG.onChangeSkinType(i);
        }
    }
}
