package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.a.t;
import com.baidu.tieba.card.a.u;
import java.util.ArrayList;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.TopicInfo;
/* loaded from: classes.dex */
public class d extends u {
    public void a(CardTopic cardTopic) {
        if (cardTopic != null && !StringUtils.isNull(cardTopic.card_title) && x.o(cardTopic.topic_list) >= 4) {
            this.aSI = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.aSJ = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    t tVar = new t();
                    tVar.Wl = topicInfo.topic_id.longValue();
                    tVar.Wm = topicInfo.topic_name;
                    tVar.desc = topicInfo.desc;
                    tVar.aSG = topicInfo.is_hot.intValue() == 1;
                    this.aSJ.add(tVar);
                }
            }
        }
    }
}
