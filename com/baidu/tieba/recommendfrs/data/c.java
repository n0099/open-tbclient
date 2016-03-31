package com.baidu.tieba.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.z;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a.n implements z {
    private CardForum dWG;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x006a: IGET  (r5v1 java.lang.Long A[REMOVE]) = (r0v9 tbclient.Personalized.PersonalForum) tbclient.Personalized.PersonalForum.forum_id java.lang.Long)] */
    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.dWG = cardForum;
            this.aVn = cardForum.card_title;
            setYuelaouLocate(String.valueOf(LL()) + cardForum.position.intValue());
            if (y.p(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.a.f fVar = new com.baidu.tieba.card.a.f();
                        fVar.forumAvatar = personalForum.avatar;
                        fVar.forumName = personalForum.forum_name;
                        fVar.forumId = com.baidu.adp.lib.h.b.g(new StringBuilder().append(personalForum.forum_id).toString(), -1);
                        fVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(fVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.a.z
    public int getPosition() {
        if (this.dWG != null) {
            return this.dWG.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.a.z
    public boolean LE() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.z
    public void cd(boolean z) {
        this.aVr = z;
    }

    public boolean rk() {
        if (y.p(FZ()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean oB(int i) {
        return i == 1;
    }

    public static boolean oC(int i) {
        return i == 2;
    }
}
