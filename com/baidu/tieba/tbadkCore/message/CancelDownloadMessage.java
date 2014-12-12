package com.baidu.tieba.tbadkCore.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class CancelDownloadMessage extends CustomResponsedMessage<Boolean> {
    public CancelDownloadMessage(Boolean bool) {
        super(2001144, bool);
    }
}
