package com.baidu.tieba.onlineDebugger;

import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.message.TbDebugOnlineMessage;
import com.baidu.tieba.onlineDebugger.command.d;
/* loaded from: classes.dex */
public class OnlineDebuggerStatic {
    static {
        MessageManager.getInstance().registerListener(new b(202006));
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(205102);
        bVar.h(false);
        MessageManager.getInstance().registerTask(bVar);
    }

    /* loaded from: classes.dex */
    public static final class a extends BdAsyncTask<com.baidu.tieba.onlineDebugger.d.a, Void, com.baidu.tieba.onlineDebugger.d.b> {
        private static BdUniqueId uniqueId = BdUniqueId.gen();
        private Object dbq;

        public a() {
            setPriority(4);
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, uniqueId));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public com.baidu.tieba.onlineDebugger.d.b doInBackground(com.baidu.tieba.onlineDebugger.d.a... aVarArr) {
            if (aVarArr != null) {
                try {
                    if (aVarArr[0] != null) {
                        d b = com.baidu.tieba.onlineDebugger.e.b.b(aVarArr[0]);
                        com.baidu.tieba.onlineDebugger.d.b bVar = new com.baidu.tieba.onlineDebugger.d.b(aVarArr[0]);
                        if (b != null) {
                            if (!b.auB()) {
                                throw new IllegalAccessError("Illeagl Command: " + aVarArr[0].getMsgContent());
                            }
                            Object c = com.baidu.adp.lib.a.a.a.c(Looper.getMainLooper(), "sThreadLocal");
                            if (c instanceof ThreadLocal) {
                                ThreadLocal threadLocal = (ThreadLocal) c;
                                this.dbq = threadLocal.get();
                                threadLocal.set(Looper.getMainLooper());
                            }
                            Object auA = b.auA();
                            if (c instanceof ThreadLocal) {
                                ((ThreadLocal) c).set(this.dbq);
                            }
                            if (auA != null) {
                                bVar.setMsgContent(c.K(auA));
                            } else {
                                bVar.setMsgContent("null");
                            }
                            return bVar;
                        }
                    }
                } catch (Throwable th) {
                    com.baidu.tieba.onlineDebugger.d.b bVar2 = new com.baidu.tieba.onlineDebugger.d.b(aVarArr[0]);
                    bVar2.setMsgContent(th.getMessage());
                    BdLog.detailException(th);
                    return bVar2;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.onlineDebugger.d.b bVar) {
            if (bVar != null) {
                BdLog.i("Result:" + bVar.getMsgContent());
            }
            if (bVar != null && bVar.getToUid() != null) {
                MessageManager.getInstance().sendMessage(new TbDebugOnlineMessage(false, bVar.auF(), bVar.getToUid(), bVar.getMsgContent()));
            }
        }
    }
}
