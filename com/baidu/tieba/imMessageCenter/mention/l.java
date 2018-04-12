package com.baidu.tieba.imMessageCenter.mention;

import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes2.dex */
public class l extends j implements com.baidu.tbadk.mvc.b.c {
    @Override // com.baidu.tbadk.mvc.b.b
    public boolean y(byte[] bArr) {
        try {
            a((ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Fz() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return "replyme_cache";
    }
}
