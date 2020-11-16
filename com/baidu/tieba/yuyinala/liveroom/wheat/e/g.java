package com.baidu.tieba.yuyinala.liveroom.wheat.e;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
/* loaded from: classes4.dex */
public class g {
    public static String WD() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    public static int aj(w wVar) {
        if (wVar == null || wVar.aIe == null) {
            return 0;
        }
        return wVar.aIe.getRoomMode();
    }

    public static int ak(w wVar) {
        if (wVar == null || wVar.aIe == null) {
            return 0;
        }
        return wVar.aIe.getActivityStage();
    }

    public static boolean eat() {
        String WD = WD();
        return WD != null && com.baidu.live.al.b.Wy().iR(WD);
    }

    public static String d(w wVar, int i) {
        switch (i) {
            case 0:
                if (wVar != null && wVar.aIa != null && wVar.aIa.aQQ != null && wVar.aIa.aQQ.size() >= 5) {
                    return wVar.aIa.aQQ.get(0);
                }
                return "欢迎来到约会现场，快来上麦寻找心动的TA吧~";
            case 1:
                if (wVar != null && wVar.aIa != null && wVar.aIa.aQQ != null && wVar.aIa.aQQ.size() >= 5) {
                    return wVar.aIa.aQQ.get(1);
                }
                return "约会开始，和你心仪的TA甜蜜互动吧~";
            case 2:
                if (wVar != null && wVar.aIa != null && wVar.aIa.aQQ != null && wVar.aIa.aQQ.size() >= 5) {
                    return wVar.aIa.aQQ.get(2);
                }
                return "等待麦上用户选择心动嘉宾...";
            case 3:
                if (wVar != null && wVar.aIa != null && wVar.aIa.aQQ != null && wVar.aIa.aQQ.size() >= 5) {
                    return wVar.aIa.aQQ.get(3);
                }
                return "等待主持公布匹配结果...";
            case 4:
                if (wVar != null && wVar.aIa != null && wVar.aIa.aQQ != null && wVar.aIa.aQQ.size() >= 5) {
                    return wVar.aIa.aQQ.get(4);
                }
                return "甜蜜值达到3399时将触发甜蜜时刻，跟你心仪的TA甜蜜告白吧";
            default:
                return "";
        }
    }

    public static void a(Activity activity, String str, final View.OnClickListener onClickListener) {
        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
        gVar.show();
        gVar.setText(str);
        gVar.UY(PayHelper.STATUS_CANCEL_DESC);
        gVar.bS("确认", a.c.sdk_black_alpha100);
        gVar.dZU();
        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.g.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                onClickListener.onClick(null);
            }
        });
    }

    public static int al(w wVar) {
        if (wVar == null || wVar.aIa == null) {
            return 0;
        }
        return wVar.aIa.aQO;
    }

    public static String am(w wVar) {
        if (wVar == null || wVar.aHZ == null) {
            return "";
        }
        return wVar.aHZ.aRe;
    }

    public static void f(TextView textView, boolean z) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(z);
        }
    }
}
