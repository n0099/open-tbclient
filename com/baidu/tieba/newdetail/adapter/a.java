package com.baidu.tieba.newdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
/* loaded from: classes21.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.newdetail.a.b, C0815a> {
    private f<com.baidu.tieba.newdetail.a.b> jPP;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.newdetail.a.a.lqg);
        this.jPP = new f<com.baidu.tieba.newdetail.a.b>() { // from class: com.baidu.tieba.newdetail.adapter.a.1
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
    /* renamed from: cb */
    public C0815a c(ViewGroup viewGroup) {
        C0815a c0815a = new C0815a(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        c0815a.setOnItemCoverListener(this.jPP);
        c0815a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0815a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.newdetail.a.b bVar, C0815a c0815a) {
        if (bVar == null || c0815a == null) {
            return null;
        }
        c0815a.a(bVar);
        c0815a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0815a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.newdetail.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C0815a extends af.a {
        private HotTopicDetailSpecialItem lpI;

        C0815a(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.lpI = hotTopicDetailSpecialItem;
        }

        void a(com.baidu.tieba.newdetail.a.b bVar) {
            if (bVar != null) {
                this.lpI.a(bVar);
            }
        }

        public void setOnItemCoverListener(f<com.baidu.tieba.newdetail.a.b> fVar) {
            this.lpI.setOnItemCoverListener(fVar);
        }

        void onChangeSkinType(int i) {
            this.lpI.onChangeSkinType(i);
        }
    }
}
