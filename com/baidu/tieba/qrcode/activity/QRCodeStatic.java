package com.baidu.tieba.qrcode.activity;

import android.graphics.Bitmap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class QRCodeStatic {
    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(QRCodeScanActivityConfig.class, QRCodeScanActivity.class);
        bVT();
    }

    private static void bVT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921388, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.qrcode.activity.QRCodeStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Bitmap> run(CustomMessage<String> customMessage) {
                return new CustomResponsedMessage<>(2921388, com.baidu.tieba.qrcode.lib.zxing.b.bl(customMessage.getData(), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds247)));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
