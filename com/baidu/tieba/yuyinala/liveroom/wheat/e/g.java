package com.baidu.tieba.yuyinala.liveroom.wheat.e;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.data.ab;
import com.baidu.live.data.dh;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
/* loaded from: classes11.dex */
public class g {
    public static String Yp() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    public static int as(ab abVar) {
        if (abVar == null || abVar.aIY == null) {
            return 0;
        }
        return abVar.aIY.getRoomMode();
    }

    public static int at(ab abVar) {
        if (abVar == null || abVar.aIY == null) {
            return 0;
        }
        return abVar.aIY.getActivityStage();
    }

    public static boolean eeO() {
        String Yp = Yp();
        return Yp != null && com.baidu.live.ao.a.Yj().iJ(Yp);
    }

    public static String d(ab abVar, int i) {
        switch (i) {
            case 0:
                if (abVar != null && abVar.aIV != null && abVar.aIV.aTg != null && abVar.aIV.aTg.size() >= 5) {
                    return abVar.aIV.aTg.get(0);
                }
                return "欢迎来到约会现场，快来上麦寻找心动的TA吧~";
            case 1:
                if (abVar != null && abVar.aIV != null && abVar.aIV.aTg != null && abVar.aIV.aTg.size() >= 5) {
                    return abVar.aIV.aTg.get(1);
                }
                return "约会开始，和你心仪的TA甜蜜互动吧~";
            case 2:
                if (abVar != null && abVar.aIV != null && abVar.aIV.aTg != null && abVar.aIV.aTg.size() >= 5) {
                    return abVar.aIV.aTg.get(2);
                }
                return "等待麦上用户选择心动嘉宾...";
            case 3:
                if (abVar != null && abVar.aIV != null && abVar.aIV.aTg != null && abVar.aIV.aTg.size() >= 5) {
                    return abVar.aIV.aTg.get(3);
                }
                return "等待主持公布匹配结果...";
            case 4:
                if (abVar != null && abVar.aIV != null && abVar.aIV.aTg != null && abVar.aIV.aTg.size() >= 5) {
                    return abVar.aIV.aTg.get(4);
                }
                return "甜蜜值达到3399时将触发甜蜜时刻，跟你心仪的TA甜蜜告白吧";
            default:
                return "";
        }
    }

    public static com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g a(Activity activity, String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(activity);
        gVar.show();
        gVar.setText(str);
        gVar.VP(PayHelper.STATUS_CANCEL_DESC);
        gVar.cf("确认", a.c.sdk_black_alpha100);
        gVar.eel();
        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.g.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(null);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                if (onClickListener != null) {
                    onClickListener.onClick(null);
                }
            }
        });
        return gVar;
    }

    public static int au(ab abVar) {
        if (abVar == null || abVar.aIV == null) {
            return 0;
        }
        return abVar.aIV.aTe;
    }

    public static String av(ab abVar) {
        if (abVar == null || abVar.aIU == null) {
            return "";
        }
        return abVar.aIU.aTK;
    }

    public static String aw(ab abVar) {
        if (abVar == null || abVar.aIU == null) {
            return "";
        }
        return abVar.aIU.croom_id;
    }

    public static long ax(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            return 0L;
        }
        return abVar.mLiveInfo.live_id;
    }

    public static void g(TextView textView, boolean z) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(z);
        }
    }

    public static int ay(ab abVar) {
        dh dhVar;
        if (abVar == null || (dhVar = (dh) ListUtils.getItem(abVar.aJr, abVar.aIY.getRoomMode())) == null || dhVar.aTB <= 0) {
            return 5;
        }
        return dhVar.aTB;
    }

    public static int az(ab abVar) {
        dh dhVar;
        if (abVar == null || (dhVar = (dh) ListUtils.getItem(abVar.aJr, abVar.aIY.getRoomMode())) == null || dhVar.aTA <= 0) {
            return 30;
        }
        return dhVar.aTA;
    }

    public static int aA(ab abVar) {
        int i;
        if (abVar == null) {
            return 20;
        }
        dh dhVar = (dh) ListUtils.getItem(abVar.aJr, abVar.aIY.getRoomMode());
        if (dhVar == null || dhVar.aTz <= 0) {
            i = 20;
        } else {
            i = dhVar.aTz;
        }
        int i2 = com.baidu.live.d.xc().getInt("audio_live_pk_time", 0);
        return (i2 == 0 || i2 < ay(abVar) || i2 > az(abVar)) ? i : i2;
    }

    public static int aB(ab abVar) {
        dh dhVar;
        if (abVar == null || (dhVar = (dh) ListUtils.getItem(abVar.aJr, abVar.aIY.getRoomMode())) == null || dhVar.aTG <= 0) {
            return 5;
        }
        return dhVar.aTG;
    }

    public static int aC(ab abVar) {
        dh dhVar;
        if (abVar == null || (dhVar = (dh) ListUtils.getItem(abVar.aJr, abVar.aIY.getRoomMode())) == null || dhVar.aTF <= 0) {
            return 20;
        }
        return dhVar.aTF;
    }

    public static int aD(ab abVar) {
        int i;
        if (abVar == null) {
            return 10;
        }
        dh dhVar = (dh) ListUtils.getItem(abVar.aJr, abVar.aIY.getRoomMode());
        if (dhVar == null || dhVar.aTE <= 0) {
            i = 10;
        } else {
            i = dhVar.aTE;
        }
        int i2 = com.baidu.live.d.xc().getInt("audio_live_punish_time", 0);
        return (i2 == 0 || i2 < aB(abVar) || i2 > aC(abVar)) ? i : i2;
    }
}
