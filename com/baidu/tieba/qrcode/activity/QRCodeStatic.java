package com.baidu.tieba.qrcode.activity;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeLoginConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tieba.qrlogin.QRCodeLoginConfirmActivity;
/* loaded from: classes3.dex */
public class QRCodeStatic {
    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(QRCodeLoginConfirmActivityConfig.class, QRCodeLoginConfirmActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(QRCodeScanActivityConfig.class, QRCodeScanActivity.class);
    }
}
