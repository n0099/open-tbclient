package com.baidu.tieba.pushdialog;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidReqNetMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a {
    private static a gkJ;
    private static final Runnable gkK = new Runnable() { // from class: com.baidu.tieba.pushdialog.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new PullTidReqNetMessage(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618));
            }
            a.bmk().bml();
        }
    };
    private static final Runnable gkL = new Runnable() { // from class: com.baidu.tieba.pushdialog.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.bmk().bbs();
        }
    };
    private String gkM;
    private boolean gkN = false;
    private Handler handler = new Handler(Looper.getMainLooper());

    private a() {
        this.gkM = "";
        this.handler.post(gkK);
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, 309618) { // from class: com.baidu.tieba.pushdialog.a.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof PullTidHttpRespMessage) {
                    str = ((PullTidHttpRespMessage) responsedMessage).getTid();
                } else if (responsedMessage instanceof PullTidSocketResponseMessage) {
                    str = ((PullTidSocketResponseMessage) responsedMessage).getTid();
                }
                if (!StringUtils.isNull(str) && responsedMessage.getError() == 0 && !a.this.gkM.equals(str) && !"0".equals(str)) {
                    a.this.gkM = str;
                    if (com.baidu.tieba.screenlocknotify.a.boJ().gwK.isScreenOn()) {
                        a.this.gkN = true;
                    } else {
                        a.this.su(str);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001371) { // from class: com.baidu.tieba.pushdialog.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bmm();
            }
        });
        this.gkM = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_push_dialog_last_show_tid", "0");
        TbadkCoreApplication.getInst().registerReceiver(new C0221a(), new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bmk() {
        if (gkJ == null) {
            synchronized (a.class) {
                if (gkJ == null) {
                    gkJ = new a();
                }
            }
        }
        return gkJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bml() {
        this.handler.postDelayed(gkK, TbSingleton.getInstance().getPushDialogLoopTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbs() {
        su(this.gkM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(String str) {
        if (!com.baidu.tieba.screenlocknotify.a.boJ().gwK.isScreenOn()) {
            Activity ex = com.baidu.adp.base.a.ew().ex();
            if (ex != null && ex.getClass() != null && ex.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                ex.finish();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(TbadkCoreApplication.getInst(), 0L, str)));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_push_dialog_last_show_tid", str);
            this.gkN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmm() {
        this.handler.removeCallbacks(gkK);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbSingleton.getInstance().getPushDialogLoopTime() > 0) {
            this.handler.postDelayed(gkK, TbSingleton.getInstance().getPushDialogLoopTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmn() {
        if (this.gkN && com.baidu.tieba.screenlocknotify.a.boJ().boN()) {
            this.handler.removeCallbacks(gkL);
            this.handler.postDelayed(gkL, 5 * ap.aqQ);
            TiebaStatic.log(new an("c13196").r("obj_type", 1).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).af("tid", this.gkM));
        }
    }

    /* renamed from: com.baidu.tieba.pushdialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0221a extends BroadcastReceiver {
        private C0221a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                a.bmk().bmn();
            }
        }
    }
}
