package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.w;
import com.baidu.tieba.card.a.x;
import java.util.ArrayList;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.TopicInfo;
/* loaded from: classes.dex */
public class d extends x {
    public void a(CardTopic cardTopic) {
        if (cardTopic != null && !StringUtils.isNull(cardTopic.card_title) && y.p(cardTopic.topic_list) >= 4) {
            this.aWu = cardTopic.card_title;
            this.position = cardTopic.position.intValue();
            this.aWv = new ArrayList();
            for (TopicInfo topicInfo : cardTopic.topic_list) {
                if (!StringUtils.isNull(topicInfo.topic_name)) {
                    w wVar = new w();
                    wVar.Uu = topicInfo.topic_id.longValue();
                    wVar.Uv = topicInfo.topic_name;
                    wVar.desc = topicInfo.desc;
                    wVar.aWs = topicInfo.is_hot.intValue() == 1;
                    wVar.tag = topicInfo.tag.intValue();
                    this.aWv.add(wVar);
                }
            }
        }
    }
}
