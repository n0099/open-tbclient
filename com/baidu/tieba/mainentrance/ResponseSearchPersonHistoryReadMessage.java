package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ResponseSearchPersonHistoryReadMessage extends CustomResponsedMessage<Object> {
    public final ArrayList<String> datas;

    public ResponseSearchPersonHistoryReadMessage() {
        super(2001191);
        this.datas = new ArrayList<>(10);
    }
}
