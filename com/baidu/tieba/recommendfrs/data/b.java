package com.baidu.tieba.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.t;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a.j implements t {
    private CardForum dpd;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x006a: IGET  (r5v1 java.lang.Long A[REMOVE]) = (r0v9 tbclient.Personalized.PersonalForum) tbclient.Personalized.PersonalForum.forum_id java.lang.Long)] */
    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.dpd = cardForum;
            this.aPH = cardForum.card_title;
            setYuelaouLocate(String.valueOf(Iy()) + cardForum.position.intValue());
            if (y.l(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.a.e eVar = new com.baidu.tieba.card.a.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.h.b.g(new StringBuilder().append(personalForum.forum_id).toString(), -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.a.t
    public int getPosition() {
        if (this.dpd != null) {
            return this.dpd.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.a.t
    public boolean IM() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.t
    public void bO(boolean z) {
        this.aPL = z;
    }

    public boolean rk() {
        if (y.l(DS()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean mm(int i) {
        return i == 1;
    }

    public static boolean mn(int i) {
        return i == 2;
    }
}
