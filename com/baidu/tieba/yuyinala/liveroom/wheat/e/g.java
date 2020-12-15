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
    public static String Zc() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    public static int ao(w wVar) {
        if (wVar == null || wVar.aKQ == null) {
            return 0;
        }
        return wVar.aKQ.getRoomMode();
    }

    public static int ap(w wVar) {
        if (wVar == null || wVar.aKQ == null) {
            return 0;
        }
        return wVar.aKQ.getActivityStage();
    }

    public static boolean efZ() {
        String Zc = Zc();
        return Zc != null && com.baidu.live.ap.b.YX().jv(Zc);
    }

    public static String d(w wVar, int i) {
        switch (i) {
            case 0:
                if (wVar != null && wVar.aKM != null && wVar.aKM.aTS != null && wVar.aKM.aTS.size() >= 5) {
                    return wVar.aKM.aTS.get(0);
                }
                return "欢迎来到约会现场，快来上麦寻找心动的TA吧~";
            case 1:
                if (wVar != null && wVar.aKM != null && wVar.aKM.aTS != null && wVar.aKM.aTS.size() >= 5) {
                    return wVar.aKM.aTS.get(1);
                }
                return "约会开始，和你心仪的TA甜蜜互动吧~";
            case 2:
                if (wVar != null && wVar.aKM != null && wVar.aKM.aTS != null && wVar.aKM.aTS.size() >= 5) {
                    return wVar.aKM.aTS.get(2);
                }
                return "等待麦上用户选择心动嘉宾...";
            case 3:
                if (wVar != null && wVar.aKM != null && wVar.aKM.aTS != null && wVar.aKM.aTS.size() >= 5) {
                    return wVar.aKM.aTS.get(3);
                }
                return "等待主持公布匹配结果...";
            case 4:
                if (wVar != null && wVar.aKM != null && wVar.aKM.aTS != null && wVar.aKM.aTS.size() >= 5) {
                    return wVar.aKM.aTS.get(4);
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
        gVar.Wn(PayHelper.STATUS_CANCEL_DESC);
        gVar.bV("确认", a.c.sdk_black_alpha100);
        gVar.efA();
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

    public static int aq(w wVar) {
        if (wVar == null || wVar.aKM == null) {
            return 0;
        }
        return wVar.aKM.aTQ;
    }

    public static String ar(w wVar) {
        if (wVar == null || wVar.aKL == null) {
            return "";
        }
        return wVar.aKL.aUg;
    }

    public static void f(TextView textView, boolean z) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(z);
        }
    }
}
