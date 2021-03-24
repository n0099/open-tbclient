package com.baidu.tieba.pushdialog;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.data.PullTidHttpRespMessage;
import com.baidu.tieba.pushdialog.data.PullTidSocketResponseMessage;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
import com.squareup.wire.Wire;
import d.b.h0.r.s.a;
/* loaded from: classes5.dex */
public class PushDialogStatic {

    /* renamed from: a  reason: collision with root package name */
    public static Wire f20620a = new Wire(new Class[0]);

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage customMessage) {
            PushDialogLoopManager.i();
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable {

        /* loaded from: classes5.dex */
        public class a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContextSupport f20621e;

            public a(b bVar, TbPageContextSupport tbPageContextSupport) {
                this.f20621e = tbPageContextSupport;
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.setAction("miui.intent.action.APP_PERM_EDITOR_PRIVATE");
                intent.putExtra("extra_pkgname", this.f20621e.getPageContext().getPageActivity().getPackageName());
                intent.setFlags(268435456);
                try {
                    this.f20621e.getPageContext().getPageActivity().startActivity(intent);
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: com.baidu.tieba.pushdialog.PushDialogStatic$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0221b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContextSupport f20622e;

            public C0221b(b bVar, TbPageContextSupport tbPageContextSupport) {
                this.f20622e = tbPageContextSupport;
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.setAction("com.iqoo.secure.PERMISSION_MANAGER");
                intent.setFlags(268435456);
                try {
                    this.f20622e.getPageContext().getPageActivity().startActivity(intent);
                } catch (Exception unused) {
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public c(b bVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage customMessage) {
            a.e eVar;
            int i;
            if (customMessage != null && (customMessage.getData() instanceof TbPageContextSupport)) {
                int j = d.b.h0.r.d0.b.i().j("lock_permission_guide_set", 0);
                if (!(j >= 2) && TbSingleton.getInstance().canShowPermDialog()) {
                    TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) customMessage.getData();
                    if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                        if (d.b.i0.n2.b.a()) {
                            eVar = new a(this, tbPageContextSupport);
                            i = R.string.push_dialog_guide_content_miui;
                        } else if (d.b.i0.n2.b.b()) {
                            eVar = new C0221b(this, tbPageContextSupport);
                            i = R.string.push_dialog_guide_content_vivo;
                        } else {
                            eVar = null;
                            i = 0;
                        }
                        if (eVar != null) {
                            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContextSupport.getPageContext().getPageActivity());
                            aVar.setTitle(R.string.push_dialog_guide_title);
                            aVar.setMessageId(i);
                            aVar.setPositiveButton(R.string.go_setting, eVar);
                            aVar.setNegativeButton(R.string.has_set, new c(this));
                            aVar.create(tbPageContextSupport.getPageContext());
                            aVar.show();
                            TbSingleton.getInstance().setHasShowPermDlg(true);
                        }
                        d.b.h0.r.d0.b.i().u("lock_permission_guide_set", j + 1);
                    }
                }
            }
            return null;
        }
    }

    static {
        TbadkApplication.getInst().RegisterIntent(PushDialogActivityConfig.class, PushDialogActivity.class);
        a();
    }

    public static void a() {
        d.b.i0.c3.d0.a.h(309614, PushDialogSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, d.b.i0.c3.d0.a.a(TbConfig.GET_PUSH_DIALOG_DETAIL, 309614));
        tbHttpMessageTask.setResponsedClass(PushDialogHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.b.i0.c3.d0.a.h(309618, PullTidSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PUSH_DIALOG_TID, d.b.i0.c3.d0.a.a(TbConfig.GET_PUSH_DIALOG_TID, 309618));
        tbHttpMessageTask2.setResponsedClass(PullTidHttpRespMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921359, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921360, new b());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
