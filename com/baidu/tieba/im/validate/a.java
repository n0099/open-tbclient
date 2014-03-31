package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ak;
import com.baidu.tieba.im.groupInfo.al;
import java.util.List;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.g {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ValidateActivity validateActivity, int i) {
        super(0);
        this.a = validateActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        t tVar;
        ValidateItemData validateItemData;
        com.baidu.tieba.im.a aVar;
        int i;
        int i2;
        t tVar2;
        ValidateItemData validateItemData2;
        com.baidu.tieba.im.a aVar2;
        t tVar3;
        com.baidu.tieba.im.a aVar3;
        t tVar4;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        tVar = this.a.b;
        tVar.a(false);
        this.a.i = false;
        if (socketResponsedMessage2 == null || !(socketResponsedMessage2 instanceof com.baidu.adp.framework.message.f)) {
            return;
        }
        int g = socketResponsedMessage2.g();
        if (g != 103111) {
            if (202004 == g) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage2;
                al alVar = (al) responseDelSystemMessage.h();
                if (responseDelSystemMessage.e() != 0) {
                    com.baidu.adp.lib.util.f.b("del group info err:" + responseDelSystemMessage.f());
                    return;
                }
                com.baidu.adp.lib.util.f.e("del group info: gid" + alVar.i() + " msgid:" + alVar.j());
                validateItemData = this.a.f;
                aVar = this.a.d;
                if (validateItemData != null) {
                    com.baidu.adp.lib.util.f.e("lastmid:" + validateItemData.getNotice_id());
                    com.baidu.tieba.im.s.a(new q(validateItemData), aVar);
                }
                ValidateActivity validateActivity = this.a;
                i = validateActivity.l;
                validateActivity.l = i - 1;
                ValidateActivity validateActivity2 = this.a;
                i2 = validateActivity2.j;
                validateActivity2.j = i2 - 1;
                tVar2 = this.a.b;
                h e = tVar2.e();
                List<ValidateItemData> b = e.b();
                validateItemData2 = this.a.f;
                b.remove(validateItemData2);
                e.notifyDataSetChanged();
                com.baidu.tieba.im.pushNotify.a.a((com.baidu.tieba.im.a<Void>) null);
                return;
            }
            return;
        }
        ak akVar = (ak) socketResponsedMessage2.h();
        if (socketResponsedMessage2.e() == 0) {
            ValidateItemData a = ValidateActivity.a(this.a, akVar.l());
            if (a != null) {
                a.setPass(true);
                a.setShown(true);
                aVar2 = this.a.d;
                n.a(aVar2, a);
                if (TextUtils.isEmpty(socketResponsedMessage2.f())) {
                    this.a.showToast(com.baidu.tieba.im.j.validate_succ);
                } else {
                    this.a.showToast(socketResponsedMessage2.f());
                }
                tVar3 = this.a.b;
                tVar3.e().notifyDataSetChanged();
                com.baidu.adp.lib.util.f.e("apply add group" + socketResponsedMessage2.toString());
            }
        } else if (akVar != null) {
            int e2 = socketResponsedMessage2.e();
            String f = socketResponsedMessage2.f();
            if (TextUtils.isEmpty(f)) {
                this.a.showToast(com.baidu.tieba.im.j.validate_fail);
            } else {
                this.a.showToast(f);
            }
            com.baidu.adp.lib.util.f.e("errCode:" + e2 + "errMsg:" + f);
            ValidateItemData a2 = ValidateActivity.a(this.a, akVar.l());
            if (a2 != null) {
                a2.setPass(false);
                a2.setShown(true);
                aVar3 = this.a.d;
                n.a(aVar3, a2);
                tVar4 = this.a.b;
                tVar4.e().notifyDataSetChanged();
                com.baidu.adp.lib.util.f.e("apply add group" + socketResponsedMessage2.toString() + "err:" + e2 + " " + f);
            }
        }
    }
}
