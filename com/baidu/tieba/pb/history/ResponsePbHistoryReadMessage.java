package com.baidu.tieba.pb.history;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.aj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ResponsePbHistoryReadMessage extends CustomResponsedMessage<Object> {
    public final List<aj> datas;

    public ResponsePbHistoryReadMessage() {
        super(2001190);
        this.datas = new ArrayList((int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
    }
}
