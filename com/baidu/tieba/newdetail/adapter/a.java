package com.baidu.tieba.newdetail.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.newdetail.a.b, C0803a> {
    private f<com.baidu.tieba.newdetail.a.b> kgp;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.newdetail.a.a.lzb);
        this.kgp = new f<com.baidu.tieba.newdetail.a.b>() { // from class: com.baidu.tieba.newdetail.adapter.a.1
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
    public C0803a e(ViewGroup viewGroup) {
        C0803a c0803a = new C0803a(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        c0803a.setOnItemCoverListener(this.kgp);
        c0803a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0803a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.newdetail.a.b bVar, C0803a c0803a) {
        if (bVar == null || c0803a == null) {
            return null;
        }
        c0803a.a(bVar);
        c0803a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return c0803a.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.newdetail.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0803a extends TypeAdapter.ViewHolder {
        private HotTopicDetailSpecialItem lyD;

        C0803a(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.lyD = hotTopicDetailSpecialItem;
        }

        void a(com.baidu.tieba.newdetail.a.b bVar) {
            if (bVar != null) {
                this.lyD.a(bVar);
            }
        }

        public void setOnItemCoverListener(f<com.baidu.tieba.newdetail.a.b> fVar) {
            this.lyD.setOnItemCoverListener(fVar);
        }

        void onChangeSkinType(int i) {
            this.lyD.onChangeSkinType(i);
        }
    }
}
