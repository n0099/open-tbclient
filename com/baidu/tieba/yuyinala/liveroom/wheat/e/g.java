package com.baidu.tieba.yuyinala.liveroom.wheat.e;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.data.db;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
/* loaded from: classes11.dex */
public class g {
    public static String aar() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    public static int as(x xVar) {
        if (xVar == null || xVar.aLq == null) {
            return 0;
        }
        return xVar.aLq.getRoomMode();
    }

    public static int at(x xVar) {
        if (xVar == null || xVar.aLq == null) {
            return 0;
        }
        return xVar.aLq.getActivityStage();
    }

    public static boolean egj() {
        String aar = aar();
        return aar != null && com.baidu.live.aq.a.aam().jo(aar);
    }

    public static String d(x xVar, int i) {
        switch (i) {
            case 0:
                if (xVar != null && xVar.aLm != null && xVar.aLm.aUQ != null && xVar.aLm.aUQ.size() >= 5) {
                    return xVar.aLm.aUQ.get(0);
                }
                return "欢迎来到约会现场，快来上麦寻找心动的TA吧~";
            case 1:
                if (xVar != null && xVar.aLm != null && xVar.aLm.aUQ != null && xVar.aLm.aUQ.size() >= 5) {
                    return xVar.aLm.aUQ.get(1);
                }
                return "约会开始，和你心仪的TA甜蜜互动吧~";
            case 2:
                if (xVar != null && xVar.aLm != null && xVar.aLm.aUQ != null && xVar.aLm.aUQ.size() >= 5) {
                    return xVar.aLm.aUQ.get(2);
                }
                return "等待麦上用户选择心动嘉宾...";
            case 3:
                if (xVar != null && xVar.aLm != null && xVar.aLm.aUQ != null && xVar.aLm.aUQ.size() >= 5) {
                    return xVar.aLm.aUQ.get(3);
                }
                return "等待主持公布匹配结果...";
            case 4:
                if (xVar != null && xVar.aLm != null && xVar.aLm.aUQ != null && xVar.aLm.aUQ.size() >= 5) {
                    return xVar.aLm.aUQ.get(4);
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
        gVar.VN(PayHelper.STATUS_CANCEL_DESC);
        gVar.cd("确认", a.c.sdk_black_alpha100);
        gVar.efG();
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

    public static int au(x xVar) {
        if (xVar == null || xVar.aLm == null) {
            return 0;
        }
        return xVar.aLm.aUO;
    }

    public static String av(x xVar) {
        if (xVar == null || xVar.aLl == null) {
            return "";
        }
        return xVar.aLl.aVu;
    }

    public static String aw(x xVar) {
        if (xVar == null || xVar.aLl == null) {
            return "";
        }
        return xVar.aLl.croom_id;
    }

    public static long ax(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            return 0L;
        }
        return xVar.mLiveInfo.live_id;
    }

    public static void f(TextView textView, boolean z) {
        if (textView != null) {
            textView.getPaint().setFakeBoldText(z);
        }
    }

    public static int ay(x xVar) {
        db dbVar;
        if (xVar == null || (dbVar = (db) ListUtils.getItem(xVar.aLG, xVar.aLq.getRoomMode())) == null || dbVar.aVl <= 0) {
            return 5;
        }
        return dbVar.aVl;
    }

    public static int az(x xVar) {
        db dbVar;
        if (xVar == null || (dbVar = (db) ListUtils.getItem(xVar.aLG, xVar.aLq.getRoomMode())) == null || dbVar.aVk <= 0) {
            return 30;
        }
        return dbVar.aVk;
    }

    public static int aA(x xVar) {
        int i;
        if (xVar == null) {
            return 20;
        }
        db dbVar = (db) ListUtils.getItem(xVar.aLG, xVar.aLq.getRoomMode());
        if (dbVar == null || dbVar.aVj <= 0) {
            i = 20;
        } else {
            i = dbVar.aVj;
        }
        int i2 = com.baidu.live.d.Ba().getInt("audio_live_pk_time", 0);
        return (i2 == 0 || i2 < ay(xVar) || i2 > az(xVar)) ? i : i2;
    }

    public static int aB(x xVar) {
        db dbVar;
        if (xVar == null || (dbVar = (db) ListUtils.getItem(xVar.aLG, xVar.aLq.getRoomMode())) == null || dbVar.aVq <= 0) {
            return 5;
        }
        return dbVar.aVq;
    }

    public static int aC(x xVar) {
        db dbVar;
        if (xVar == null || (dbVar = (db) ListUtils.getItem(xVar.aLG, xVar.aLq.getRoomMode())) == null || dbVar.aVp <= 0) {
            return 20;
        }
        return dbVar.aVp;
    }

    public static int aD(x xVar) {
        int i;
        if (xVar == null) {
            return 10;
        }
        db dbVar = (db) ListUtils.getItem(xVar.aLG, xVar.aLq.getRoomMode());
        if (dbVar == null || dbVar.aVo <= 0) {
            i = 10;
        } else {
            i = dbVar.aVo;
        }
        int i2 = com.baidu.live.d.Ba().getInt("audio_live_punish_time", 0);
        return (i2 == 0 || i2 < aB(xVar) || i2 > aC(xVar)) ? i : i2;
    }
}
