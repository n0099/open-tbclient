package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.personPolymeric.c.c, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.a>> {
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> iiw;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.personPolymeric.c.c.ikA);
        this.iiw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bZK */
            public PersonCommonForumItemView makeObject() {
                return new PersonCommonForumItemView(b.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView activateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView passivateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.personPolymeric.view.a aVar = new com.baidu.tieba.personPolymeric.view.a(this.mPageContext);
        aVar.a(this.iiw);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.personPolymeric.c.c cVar, com.baidu.tieba.card.a.a<com.baidu.tieba.personPolymeric.view.a> aVar) {
        aVar.aYs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.aYs().a(cVar);
        return aVar.getView();
    }
}
