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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import d.a.j0.d3.h0.q;
import java.net.URISyntaxException;
/* loaded from: classes3.dex */
public class QRCodeStatic {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Bitmap> run(CustomMessage<String> customMessage) {
            return new CustomResponsedMessage<>(2921388, d.a.j0.p2.b.b.b.b(customMessage.getData(), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds247)));
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements CustomMessageTask.CustomRunnable<q> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<q> customMessage) {
            String str = null;
            if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof q)) {
                return null;
            }
            q data = customMessage.getData();
            int i2 = data.f53116a;
            if (i2 == 0) {
                str = d.a.j0.p2.b.b.a.b(data.f53118c);
            } else if (i2 == 1) {
                str = d.a.j0.p2.b.b.a.c(data.f53119d);
            }
            if (TextUtils.isEmpty(str)) {
                data.f53120e = "qr_none";
            } else {
                data.f53120e = str;
            }
            return new CustomResponsedMessage<>(2921403, data);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                String str = strArr[0];
                if (!TextUtils.isEmpty(str)) {
                    Uri parse = Uri.parse(str);
                    if (!parse.isHierarchical()) {
                        return 3;
                    }
                    String queryParameter = parse.getQueryParameter("tb_jp");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        try {
                            tbPageContext.getPageActivity().startActivity(Intent.parseUri(queryParameter, 1));
                        } catch (URISyntaxException e2) {
                            e2.printStackTrace();
                        }
                        return 0;
                    }
                }
            }
            return 3;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(QRCodeScanActivityConfig.class, QRCodeScanActivity.class);
        b();
        a();
        c();
    }

    public static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921403, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921388, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void c() {
        UrlManager.getInstance().addListener(new c());
    }
}
