package com.baidu.tieba.qrcode.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.o;
import java.net.URISyntaxException;
/* loaded from: classes23.dex */
public class QRCodeStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(QRCodeScanActivityConfig.class, QRCodeScanActivity.class);
        dEg();
        dEh();
        dkg();
    }

    private static void dEg() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921388, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.qrcode.activity.QRCodeStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Bitmap> run(CustomMessage<String> customMessage) {
                return new CustomResponsedMessage<>(2921388, com.baidu.tieba.qrcode.lib.zxing.b.bF(customMessage.getData(), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds247)));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void dEh() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921403, new CustomMessageTask.CustomRunnable<o>() { // from class: com.baidu.tieba.qrcode.activity.QRCodeStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<o> customMessage) {
                String str = null;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof o)) {
                    return null;
                }
                o data = customMessage.getData();
                if (data.type == 0) {
                    str = com.baidu.tieba.qrcode.lib.zxing.a.J(data.nmQ);
                } else if (data.type == 1) {
                    str = com.baidu.tieba.qrcode.lib.zxing.a.RJ(data.nmR);
                }
                if (TextUtils.isEmpty(str)) {
                    data.nmS = "qr_none";
                } else {
                    data.nmS = str;
                }
                return new CustomResponsedMessage<>(2921403, data);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void dkg() {
        bf.bua().a(new bf.a() { // from class: com.baidu.tieba.qrcode.activity.QRCodeStatic.3
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                if (TextUtils.isEmpty(str)) {
                    return 3;
                }
                Uri parse = Uri.parse(str);
                if (parse.isHierarchical()) {
                    String queryParameter = parse.getQueryParameter("tb_jp");
                    if (TextUtils.isEmpty(queryParameter)) {
                        return 3;
                    }
                    try {
                        tbPageContext.getPageActivity().startActivity(Intent.parseUri(queryParameter, 1));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
                return 3;
            }
        });
    }
}
