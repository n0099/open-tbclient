package com.baidu.tieba.qrcode.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes5.dex */
public class QRCodeStatic {
    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(QRCodeScanActivityConfig.class, QRCodeScanActivity.class);
        ceP();
        ceQ();
    }

    private static void ceP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921388, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.qrcode.activity.QRCodeStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Bitmap> run(CustomMessage<String> customMessage) {
                return new CustomResponsedMessage<>(2921388, com.baidu.tieba.qrcode.lib.zxing.b.bf(customMessage.getData(), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds247)));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void ceQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921403, new CustomMessageTask.CustomRunnable<n>() { // from class: com.baidu.tieba.qrcode.activity.QRCodeStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n> customMessage) {
                String str = null;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof n)) {
                    return null;
                }
                n data = customMessage.getData();
                if (data.type == 0) {
                    str = com.baidu.tieba.qrcode.lib.zxing.a.C(data.jiD);
                } else if (data.type == 1) {
                    str = com.baidu.tieba.qrcode.lib.zxing.a.Cp(data.jiE);
                }
                if (TextUtils.isEmpty(str)) {
                    data.jiF = "qr_none";
                } else {
                    data.jiF = str;
                }
                return new CustomResponsedMessage<>(2921403, data);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
