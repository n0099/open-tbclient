package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.a.r;
import java.util.ArrayList;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.TopicInfo;
/* loaded from: classes.dex */
public class c extends r {
    public void a(CardTopic cardTopic) {
        if (cardTopic != null && !StringUtils.isNull(cardTopic.card_title) && y.l(cardTopic.topic_list) >= 4) {
            this.aQF = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.aQG = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    q qVar = new q();
                    qVar.aQA = topicInfo.topic_id.longValue();
                    qVar.aQB = topicInfo.topic_name;
                    qVar.desc = topicInfo.desc;
                    qVar.aQC = topicInfo.is_hot.intValue() == 1;
                    this.aQG.add(qVar);
                }
            }
        }
    }
}
