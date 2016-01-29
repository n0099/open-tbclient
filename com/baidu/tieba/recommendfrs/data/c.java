package com.baidu.tieba.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.a.w;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a.m implements w {
    private CardForum dEJ;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x006a: IGET  (r5v1 java.lang.Long A[REMOVE]) = (r0v9 tbclient.Personalized.PersonalForum) tbclient.Personalized.PersonalForum.forum_id java.lang.Long)] */
    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.dEJ = cardForum;
            this.aRF = cardForum.card_title;
            setYuelaouLocate(String.valueOf(Kr()) + cardForum.position.intValue());
            if (x.o(cardForum.forum_list) > 0) {
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

    @Override // com.baidu.tieba.card.a.w
    public int getPosition() {
        if (this.dEJ != null) {
            return this.dEJ.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.a.w
    public boolean Kk() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.w
    public void bT(boolean z) {
        this.aRJ = z;
    }

    public boolean rM() {
        if (x.o(Fm()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean nx(int i) {
        return i == 1;
    }

    public static boolean ny(int i) {
        return i == 2;
    }
}
