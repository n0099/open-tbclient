package com.baidu.tieba.recommendfrs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.AgeSexModule;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.dYM = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        List list3;
        List list4;
        DataRes.Builder builder;
        List list5;
        DataRes.Builder builder2;
        DataRes.Builder builder3;
        list = this.dYM.aZH;
        if (list.size() > 0) {
            list2 = this.dYM.aZH;
            if (list2.get(0) instanceof com.baidu.tieba.recommendfrs.data.k) {
                list5 = this.dYM.aZH;
                com.baidu.tieba.recommendfrs.data.k kVar = (com.baidu.tieba.recommendfrs.data.k) list5.get(0);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (kVar.eaa != null) {
                    for (com.baidu.tieba.recommendfrs.data.j jVar : kVar.eaa) {
                        if (jVar != null) {
                            TagStruct.Builder builder4 = new TagStruct.Builder();
                            builder4.tag_name = jVar.dZX;
                            builder4.selected = Integer.valueOf(jVar.dZY ? 1 : 0);
                            linkedList.add(builder4.build(false));
                        }
                    }
                }
                if (kVar.eab != null) {
                    for (com.baidu.tieba.recommendfrs.data.j jVar2 : kVar.eab) {
                        if (jVar2 != null) {
                            TagStruct.Builder builder5 = new TagStruct.Builder();
                            builder5.tag_name = jVar2.dZX;
                            builder5.selected = Integer.valueOf(jVar2.dZY ? 1 : 0);
                            linkedList2.add(builder5.build(false));
                        }
                    }
                }
                builder2 = this.dYM.dYn;
                if (builder2 != null) {
                    AgeSexModule.Builder builder6 = new AgeSexModule.Builder();
                    builder6.sex_tag = linkedList;
                    builder6.age_tag = linkedList2;
                    builder3 = this.dYM.dYn;
                    builder3.age_sex = builder6.build(false);
                }
            } else {
                list3 = this.dYM.aZH;
                if (list3.get(0) instanceof com.baidu.tieba.recommendfrs.data.i) {
                    list4 = this.dYM.aZH;
                    com.baidu.tieba.recommendfrs.data.i iVar = (com.baidu.tieba.recommendfrs.data.i) list4.get(0);
                    if (iVar.dZV != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (com.baidu.tieba.recommendfrs.data.j jVar3 : iVar.dZV) {
                            if (jVar3 != null) {
                                TagStruct.Builder builder7 = new TagStruct.Builder();
                                builder7.tag_name = jVar3.dZX;
                                builder7.selected = Integer.valueOf(jVar3.dZY ? 1 : 0);
                                linkedList3.add(builder7.build(false));
                            }
                        }
                        builder = this.dYM.dYn;
                        builder.interestion = linkedList3;
                    }
                }
            }
            this.dYM.aMb();
        }
    }
}
