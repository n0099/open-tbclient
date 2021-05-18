package com.baidu.tieba.tblauncher;

import android.os.SystemClock;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* loaded from: classes5.dex */
public class ClientStartStatic {

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public long f21016a;

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    this.f21016a = SystemClock.elapsedRealtime();
                    return;
                }
                if (SystemClock.elapsedRealtime() - this.f21016a > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
                    new b(null).execute(new Void[0]);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOST_START).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {
        public /* synthetic */ b(a aVar) {
            this();
        }

        public b() {
            setPriority(1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return null;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.STAT_CLIENT_START);
            netWork.addPostData("type", "1");
            netWork.postNetData();
            if (TbSingleton.getInstance().getBaiduIdForAnti() == null && netWork.getNetContext() != null && netWork.getNetContext().getResponse() != null && netWork.getNetContext().getResponse().mHeader != null) {
                List<String> list = netWork.getNetContext().getResponse().mHeader.get("Set-Cookie");
                if (!ListUtils.isEmpty(list)) {
                    boolean z = false;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (list.get(i2) != null && list.get(i2).contains("BAIDUID=")) {
                            String[] split = list.get(i2).split(";");
                            if (split != null) {
                                int length = split.length;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= length) {
                                        break;
                                    }
                                    String str = split[i3];
                                    if (str != null && str.contains("BAIDUID=")) {
                                        TbSingleton.getInstance().setBaiduIdForAnti(str.trim().substring(8));
                                        z = true;
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    static {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            new b(null).execute(new Void[0]);
            MessageManager.getInstance().registerListener(new a(2001011));
        }
    }
}
