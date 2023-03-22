package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class xd9 implements NewWriteModel.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteModel a;
    public boolean b;
    public NewWriteModel.d c;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd9 a;

        /* renamed from: com.baidu.tieba.xd9$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0475a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteData a;
            public final /* synthetic */ PostWriteCallBackData b;
            public final /* synthetic */ a c;

            public RunnableC0475a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, writeData, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = writeData;
                this.b = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    PublishProgressData.valueOf(this.a, 100).send(false);
                    if ((!gi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) || (this.a.getVideoInfo() != null && this.a.getVideoInfo().hasUpload())) {
                        new zd9().q(this.b);
                    } else {
                        new zd9().p(this.b, this.a);
                    }
                    eb9.j(this.c.a.h());
                    this.c.a.e();
                    if (!gi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) {
                        this.b.mVideoMd5 = this.a.getVideoInfo().getVideoMd5();
                        if (!gi.isEmpty(this.a.getForumName())) {
                            this.b.mFrom = 2;
                        }
                    }
                    this.c.a.m();
                }
            }
        }

        public a(xd9 xd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd9Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x75 x75Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, x75Var, writeData, antiData}) != null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData notifyFlutterPostSucc = WorkPostNotifyFlutterData.notifyFlutterPostSucc(postWriteCallBackData.getVideoid());
                notifyFlutterPostSucc.setForumId(writeData.getForumId());
                notifyFlutterPostSucc.setForumName(writeData.getForumName());
                notifyFlutterPostSucc.setThreadDataByWriteData(writeData);
                notifyFlutterPostSucc.setFlutterPageId(ee9.b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, notifyFlutterPostSucc));
                int i = 3;
                int n = m35.m().n("key_video_works_progress_bar_waiting_time", 3);
                if (n > 0) {
                    i = n;
                }
                jg.a().postDelayed(new RunnableC0475a(this, writeData, postWriteCallBackData), (i + 1) * 1000);
                ee9.h(null);
                this.a.m();
            } else if (!tq5.d(postWriteCallBackData, x75Var, writeData, antiData)) {
                if (postWriteCallBackData != null) {
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.notifyFlutterPostFail(str)));
                new zd9().n(postWriteCallBackData, x75Var, writeData, antiData);
                ee9.h(null);
                this.a.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ WriteData b;

        public b(xd9 xd9Var, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd9Var, postWriteCallBackData, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postWriteCallBackData;
            this.b = writeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((!gi.isEmpty(this.a.getVideoid()) && this.b.getVideoInfo() != null) || (this.b.getVideoInfo() != null && this.b.getVideoInfo().hasUpload())) {
                    new zd9().q(this.a);
                    return;
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(currentActivity).areNotificationsEnabled();
                    if (areNotificationsEnabled && k85.d().e && k85.d().f) {
                        new zd9().p(this.a, this.b);
                    } else if ((!areNotificationsEnabled || !k85.d().e || !k85.d().f) && this.a.getToast() == null && !this.b.isShareThread()) {
                        if (g95.i(TbadkCoreApplication.getInst().getCurrentActivity(), 2)) {
                            new zd9().o(this.a, 9);
                        } else {
                            new zd9().p(this.a, this.b);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final xd9 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-292662083, "Lcom/baidu/tieba/xd9$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-292662083, "Lcom/baidu/tieba/xd9$c;");
                    return;
                }
            }
            a = new xd9(null);
        }
    }

    public xd9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.a = newWriteModel;
        newWriteModel.p0(this);
    }

    public WriteData h() {
        InterceptResult invokeV;
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            if (this.a.h0() == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = this.a.h0().toDraftString();
            }
            sb.append(draftString);
            yd9.a(sb.toString());
            return this.a.h0();
        }
        return (WriteData) invokeV.objValue;
    }

    public /* synthetic */ xd9(a aVar) {
        this();
    }

    public void i(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContextSupport) == null) {
            yd9.a("AsyncWriteHelper.initWriteStatus()");
            this.a.q0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.n0(false);
        }
    }

    public void k(@NonNull a9 a9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a9Var) == null) {
            yd9.a("AsyncWriteHelper.onWriteActClose()");
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel.e == a9Var) {
                newWriteModel.q0(null);
            }
        }
    }

    public void l(@NonNull a9 a9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, a9Var) == null) {
            this.a.q0(a9Var);
        }
    }

    public final void n(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            yd9.a("AsyncWriteHelper.setHasImage = " + z);
            this.a.n0(z);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.a.m0(z);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.a.o0(z);
        }
    }

    public static xd9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            yd9.a("AsyncWriteHelper.getInstance()");
            return c.a;
        }
        return (xd9) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yd9.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            yd9.a("AsyncWriteHelper.checkImageNum = " + this.a.f0());
            return this.a.f0();
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FileHelper.deleteFileOrDir(new File(qk9.f));
            eb9.y("");
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.b = false;
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            yd9.a("AsyncWriteHelper.startPostWrite()");
            boolean r0 = this.a.r0();
            this.b = r0;
            return r0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x75 x75Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, x75Var, writeData, antiData}) != null) || writeData == null) {
            return;
        }
        if (z) {
            PublishProgressData.valueOf(writeData, 100).send(true);
            jg.a().postDelayed(new b(this, postWriteCallBackData, writeData), 200L);
            if (writeData.isRichTextEditorMode()) {
                h55.b(writeData.getRichContentData().toString(), "2");
            } else {
                h55.b(writeData.getToServerContent(), "2");
            }
            eb9.j(h());
            e();
            n(postWriteCallBackData);
            if (!gi.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!gi.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            he9.a(h(), postWriteCallBackData.getThreadId());
            PublishProgressData.valueOf(writeData, 100).send(false);
            ee9.h(null);
            m();
        } else if (!tq5.d(postWriteCallBackData, x75Var, writeData, antiData)) {
            PublishProgressData.valueOf(writeData, 100).send(false);
            new zd9().n(postWriteCallBackData, x75Var, writeData, antiData);
            ee9.h(null);
            m();
        }
    }

    public void f(boolean z, PostWriteCallBackData postWriteCallBackData, x75 x75Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, x75Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && ee9.a() == null) {
                this.c.callback(z, postWriteCallBackData, x75Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, x75Var, writeData, antiData);
            }
        }
    }

    public void r(WriteData writeData) {
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            if (writeData == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = writeData.toDraftString();
            }
            sb.append(draftString);
            yd9.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && ee9.a() == null) {
                this.a.p0(this.c);
            } else {
                this.a.p0(this);
            }
        }
    }
}
