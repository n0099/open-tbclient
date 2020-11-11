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
    public static String Xm() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    public static int aj(w wVar) {
        if (wVar == null || wVar.aJP == null) {
            return 0;
        }
        return wVar.aJP.getRoomMode();
    }

    public static int ak(w wVar) {
        if (wVar == null || wVar.aJP == null) {
            return 0;
        }
        return wVar.aJP.getActivityStage();
    }

    public static boolean eau() {
        String Xm = Xm();
        return Xm != null && com.baidu.live.al.b.Xh().iX(Xm);
    }

    public static String d(w wVar, int i) {
        switch (i) {
            case 0:
                if (wVar != null && wVar.aJL != null && wVar.aJL.aSB != null && wVar.aJL.aSB.size() >= 5) {
                    return wVar.aJL.aSB.get(0);
                }
                return "欢迎来到约会现场，快来上麦寻找心动的TA吧~";
            case 1:
                if (wVar != null && wVar.aJL != null && wVar.aJL.aSB != null && wVar.aJL.aSB.size() >= 5) {
                    return wVar.aJL.aSB.get(1);
                }
                return "约会开始，和你心仪的TA甜蜜互动吧~";
            case 2:
                if (wVar != null && wVar.aJL != null && wVar.aJL.aSB != null && wVar.aJL.aSB.size() >= 5) {
                    return wVar.aJL.aSB.get(2);
                }
                return "等待麦上用户选择心动嘉宾...";
            case 3:
                if (wVar != null && wVar.aJL != null && wVar.aJL.aSB != null && wVar.aJL.aSB.size() >= 5) {
                    return wVar.aJL.aSB.get(3);
                }
                return "等待主持公布匹配结果...";
            case 4:
                if (wVar != null && wVar.aJL != null && wVar.aJL.aSB != null && wVar.aJL.aSB.size() >= 5) {
                    return wVar.aJL.aSB.get(4);
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
        gVar.Vn(PayHelper.STATUS_CANCEL_DESC);
        gVar.bT("确认", a.c.sdk_black_alpha100);
        gVar.dZV();
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
        if (wVar == null || wVar.aJL == null) {
            return 0;
        }
        return wVar.aJL.aSz;
    }

    public static String am(w wVar) {
        if (wVar == null || wVar.aJK == null) {
            return "";
        }
        return wVar.aJK.aSP;
    }

    public static void f(TextView textView, boolean z) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(z);
        }
    }
}
