package com.baidu.tieba.model;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.message.ResponseBubbleListMessage;
import com.baidu.tieba.message.ResponseSetBubbleMessage;
import java.util.List;
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.a.e {
    private i a;
    private j b;
    private int c;
    private int d;
    private com.baidu.adp.framework.c.b e = new g(this, 1006000);
    private com.baidu.adp.framework.c.b f = new h(this, 1006001);

    public final void a(i iVar) {
        this.a = iVar;
    }

    public final void a(j jVar) {
        this.b = jVar;
    }

    public final int a() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final int b() {
        return this.d;
    }

    public final void b(int i) {
        this.d = i;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public static boolean a(List<BubbleListData.BubbleData> list) {
        if (list != null && list.size() > 0) {
            for (BubbleListData.BubbleData bubbleData : list) {
                if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void c() {
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1006000, String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/bu/getbubblelist");
        bVar.a(ResponseBubbleListMessage.class);
        a.a(bVar);
        a.a(this.e);
    }

    public static void a(int i, int i2, int i3, int i4) {
        HttpMessage httpMessage = new HttpMessage(1006000);
        httpMessage.b(1006000);
        httpMessage.a("pn", String.valueOf(0));
        httpMessage.a("rn", String.valueOf(50));
        httpMessage.a("scr_w", String.valueOf(i3));
        httpMessage.a("scr_h", String.valueOf(i4));
        com.baidu.adp.framework.c.a().a(httpMessage);
    }

    public static void a(int i, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(1006001);
        httpMessage.b(1006001);
        httpMessage.a("bcode", String.valueOf(i));
        httpMessage.a("scr_w", String.valueOf(i2));
        httpMessage.a("scr_h", String.valueOf(i3));
        com.baidu.adp.framework.c.a().a(httpMessage);
    }

    public final void d() {
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1006001, String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/bu/setbubble");
        bVar.a(ResponseSetBubbleMessage.class);
        a.a(bVar);
        a.a(this.f);
    }

    public final void e() {
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        a.b(this.f);
        a.b(this.e);
    }
}
