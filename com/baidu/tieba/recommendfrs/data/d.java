package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.TopicInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a.p {
    public void a(CardTopic cardTopic) {
        if (cardTopic != null && !StringUtils.isNull(cardTopic.card_title) && y.r(cardTopic.topic_list) >= 4) {
            this.aSo = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.aSp = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    com.baidu.tieba.card.a.o oVar = new com.baidu.tieba.card.a.o();
                    oVar.Pt = topicInfo.topic_id.longValue();
                    oVar.Pu = topicInfo.topic_name;
                    oVar.desc = topicInfo.desc;
                    oVar.aSm = topicInfo.is_hot.intValue() == 1;
                    oVar.tag = topicInfo.tag.intValue();
                    this.aSp.add(oVar);
                }
            }
        }
    }
}
