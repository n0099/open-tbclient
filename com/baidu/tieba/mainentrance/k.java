package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ArrayList<String>> run(CustomMessage customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2009002, com.baidu.tieba.tbadkCore.util.j.aip());
    }
}
