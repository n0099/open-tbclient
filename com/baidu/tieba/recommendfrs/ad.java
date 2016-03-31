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
public class ad extends CustomMessageListener {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(q qVar, int i) {
        super(i);
        this.dVL = qVar;
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
        list = this.dVL.aTc;
        if (list.size() > 0) {
            list2 = this.dVL.aTc;
            if (list2.get(0) instanceof com.baidu.tieba.recommendfrs.data.k) {
                list5 = this.dVL.aTc;
                com.baidu.tieba.recommendfrs.data.k kVar = (com.baidu.tieba.recommendfrs.data.k) list5.get(0);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (kVar.dWQ != null) {
                    for (com.baidu.tieba.recommendfrs.data.j jVar : kVar.dWQ) {
                        if (jVar != null) {
                            TagStruct.Builder builder4 = new TagStruct.Builder();
                            builder4.tag_name = jVar.dWN;
                            builder4.selected = Integer.valueOf(jVar.dWO ? 1 : 0);
                            linkedList.add(builder4.build(false));
                        }
                    }
                }
                if (kVar.dWR != null) {
                    for (com.baidu.tieba.recommendfrs.data.j jVar2 : kVar.dWR) {
                        if (jVar2 != null) {
                            TagStruct.Builder builder5 = new TagStruct.Builder();
                            builder5.tag_name = jVar2.dWN;
                            builder5.selected = Integer.valueOf(jVar2.dWO ? 1 : 0);
                            linkedList2.add(builder5.build(false));
                        }
                    }
                }
                builder2 = this.dVL.dVs;
                if (builder2 != null) {
                    AgeSexModule.Builder builder6 = new AgeSexModule.Builder();
                    builder6.sex_tag = linkedList;
                    builder6.age_tag = linkedList2;
                    builder3 = this.dVL.dVs;
                    builder3.age_sex = builder6.build(false);
                }
            } else {
                list3 = this.dVL.aTc;
                if (list3.get(0) instanceof com.baidu.tieba.recommendfrs.data.i) {
                    list4 = this.dVL.aTc;
                    com.baidu.tieba.recommendfrs.data.i iVar = (com.baidu.tieba.recommendfrs.data.i) list4.get(0);
                    if (iVar.dWL != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (com.baidu.tieba.recommendfrs.data.j jVar3 : iVar.dWL) {
                            if (jVar3 != null) {
                                TagStruct.Builder builder7 = new TagStruct.Builder();
                                builder7.tag_name = jVar3.dWN;
                                builder7.selected = Integer.valueOf(jVar3.dWO ? 1 : 0);
                                linkedList3.add(builder7.build(false));
                            }
                        }
                        builder = this.dVL.dVs;
                        builder.interestion = linkedList3;
                    }
                }
            }
            this.dVL.aLW();
        }
    }
}
