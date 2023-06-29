package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
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
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j6a implements NewWriteModel.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteModel a;
    public boolean b;
    public NewWriteModel.d c;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6a a;

        /* renamed from: com.baidu.tieba.j6a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0369a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteData a;
            public final /* synthetic */ PostWriteCallBackData b;
            public final /* synthetic */ a c;

            public RunnableC0369a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
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
                    if ((!wi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) || (this.a.getVideoInfo() != null && this.a.getVideoInfo().hasUpload())) {
                        new l6a().v(this.b);
                    } else {
                        new l6a().u(this.b, this.a);
                    }
                    q3a.j(this.c.a.l());
                    this.c.a.i();
                    if (!wi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) {
                        this.b.mVideoMd5 = this.a.getVideoInfo().getVideoMd5();
                        if (!wi.isEmpty(this.a.getForumName())) {
                            this.b.mFrom = 2;
                        }
                    }
                    this.c.a.t();
                }
            }
        }

        public a(j6a j6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j6aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, de5 de5Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, de5Var, writeData, antiData}) != null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData notifyFlutterPostSucc = WorkPostNotifyFlutterData.notifyFlutterPostSucc(postWriteCallBackData.getVideoid());
                notifyFlutterPostSucc.setForumId(writeData.getForumId());
                notifyFlutterPostSucc.setForumName(writeData.getForumName());
                notifyFlutterPostSucc.setThreadDataByWriteData(writeData);
                notifyFlutterPostSucc.setFlutterPageId(q6a.b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, notifyFlutterPostSucc));
                int i = 3;
                int q = r95.p().q("key_video_works_progress_bar_waiting_time", 3);
                if (q > 0) {
                    i = q;
                }
                yg.a().postDelayed(new RunnableC0369a(this, writeData, postWriteCallBackData), (i + 1) * 1000);
                q6a.h(null);
                this.a.t();
            } else if (!ry5.d(postWriteCallBackData, de5Var, writeData, antiData)) {
                if (postWriteCallBackData != null) {
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.notifyFlutterPostFail(str)));
                new l6a().s(postWriteCallBackData, de5Var, writeData, antiData);
                q6a.h(null);
                this.a.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ WriteData b;
        public final /* synthetic */ j6a c;

        public b(j6a j6aVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6aVar, postWriteCallBackData, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j6aVar;
            this.a = postWriteCallBackData;
            this.b = writeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((!wi.isEmpty(this.a.getVideoid()) && this.b.getVideoInfo() != null) || (this.b.getVideoInfo() != null && this.b.getVideoInfo().hasUpload())) {
                    new l6a().v(this.a);
                    return;
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(currentActivity).areNotificationsEnabled();
                    boolean z = se5.d().f;
                    boolean z2 = se5.d().g;
                    if (this.b.isShareThread()) {
                        return;
                    }
                    if (this.b.isQuestionThread()) {
                        this.c.q(areNotificationsEnabled, z, this.a, this.b);
                    } else {
                        this.c.r(areNotificationsEnabled, z, z2, this.a, this.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final j6a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-734760523, "Lcom/baidu/tieba/j6a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-734760523, "Lcom/baidu/tieba/j6a$c;");
                    return;
                }
            }
            a = new j6a(null);
        }
    }

    public j6a() {
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
        newWriteModel.s0(this);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return yf5.i(TbadkCoreApplication.getInst().getCurrentActivity(), 2);
            }
            return uq9.e().b("post_success");
        }
        return invokeV.booleanValue;
    }

    public WriteData l() {
        InterceptResult invokeV;
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            if (this.a.k0() == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = this.a.k0().toDraftString();
            }
            sb.append(draftString);
            k6a.a(sb.toString());
            return this.a.k0();
        }
        return (WriteData) invokeV.objValue;
    }

    public /* synthetic */ j6a(a aVar) {
        this();
    }

    public final boolean h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            tq9 g = uq9.e().g("post_question_success");
            if (g == null) {
                return false;
            }
            List<String> b2 = g.b();
            if (ListUtils.isEmpty(b2)) {
                return false;
            }
            return b2.contains(str);
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContextSupport) == null) {
            k6a.a("AsyncWriteHelper.initWriteStatus()");
            this.a.t0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.q0(false);
        }
    }

    public void o(@NonNull l9 l9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, l9Var) == null) {
            k6a.a("AsyncWriteHelper.onWriteActClose()");
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel.e == l9Var) {
                newWriteModel.t0(null);
            }
        }
    }

    public void p(@NonNull l9 l9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, l9Var) == null) {
            this.a.t0(l9Var);
        }
    }

    public final void u(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            k6a.a("AsyncWriteHelper.setHasImage = " + z);
            this.a.q0(z);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.a.p0(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.a.r0(z);
        }
    }

    public static j6a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            k6a.a("AsyncWriteHelper.getInstance()");
            return c.a;
        }
        return (j6a) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k6a.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            k6a.a("AsyncWriteHelper.checkImageNum = " + this.a.i0());
            return this.a.i0();
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FileHelper.deleteFileOrDir(new File(hda.f));
            q3a.y("");
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.b = false;
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            k6a.a("AsyncWriteHelper.startPostWrite()");
            boolean u0 = this.a.u0();
            this.b = u0;
            return u0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, de5 de5Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, de5Var, writeData, antiData}) == null) && writeData != null && postWriteCallBackData != null) {
            if (z) {
                PublishProgressData.valueOf(writeData, 100).send(true);
                if (writeData.isPutStorageTid()) {
                    s(postWriteCallBackData.getThreadId());
                }
                yg.a().postDelayed(new b(this, postWriteCallBackData, writeData), 200L);
                if (writeData.isRichTextEditorMode()) {
                    mb5.b(writeData.getRichContentData().toString(), "2");
                } else {
                    mb5.b(writeData.getToServerContent(), "2");
                }
                q3a.j(l());
                i();
                u(postWriteCallBackData);
                if (!wi.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                    postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                    if (!wi.isEmpty(writeData.getForumName())) {
                        postWriteCallBackData.mFrom = 2;
                    }
                }
                t6a.a(l(), postWriteCallBackData.getThreadId());
                PublishProgressData.valueOf(writeData, 100).send(false);
                q6a.h(null);
                t();
            } else if (!ry5.d(postWriteCallBackData, de5Var, writeData, antiData)) {
                PublishProgressData.valueOf(writeData, 100).send(false);
                new l6a().s(postWriteCallBackData, de5Var, writeData, antiData);
                q6a.h(null);
                t();
            }
        }
    }

    public void j(boolean z, PostWriteCallBackData postWriteCallBackData, de5 de5Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, de5Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && q6a.a() == null) {
                this.c.callback(z, postWriteCallBackData, de5Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, de5Var, writeData, antiData);
            }
        }
    }

    public final void q(boolean z, boolean z2, @NonNull PostWriteCallBackData postWriteCallBackData, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), postWriteCallBackData, writeData}) == null) {
            if (z && z2) {
                new l6a().u(postWriteCallBackData, writeData);
            } else if (postWriteCallBackData.getToast() != null) {
            } else {
                boolean b2 = uq9.e().b("post_question_success");
                String firstClass = writeData.getFirstClass();
                if (!TextUtils.isEmpty(firstClass) && h(firstClass) && b2) {
                    new l6a().t(vg.g(postWriteCallBackData.getPostId(), 0L), vg.g(postWriteCallBackData.getThreadId(), 0L), "post_question_success");
                } else {
                    new l6a().u(postWriteCallBackData, writeData);
                }
            }
        }
    }

    public final void r(boolean z, boolean z2, boolean z3, @NonNull PostWriteCallBackData postWriteCallBackData, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), postWriteCallBackData, writeData}) == null) {
            if (z && z2 && z3) {
                new l6a().u(postWriteCallBackData, writeData);
            } else if (postWriteCallBackData.getToast() != null) {
            } else {
                if (g()) {
                    new l6a().t(vg.g(postWriteCallBackData.getPostId(), 0L), vg.g(postWriteCallBackData.getThreadId(), 0L), "post_success");
                } else {
                    new l6a().u(postWriteCallBackData, writeData);
                }
            }
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", str);
                jSONObject.put("time", System.currentTimeMillis() + "");
                String jSONObject2 = jSONObject.toString();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONObject2.length(); i++) {
                    char charAt = jSONObject2.charAt(i);
                    if (charAt == '\"') {
                        sb.append("\\\"");
                    } else {
                        sb.append(charAt);
                    }
                }
                r95 p = r95.p();
                p.J("key_local_app_storage_fake_tid", sb.toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void y(WriteData writeData) {
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            if (writeData == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = writeData.toDraftString();
            }
            sb.append(draftString);
            k6a.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && q6a.a() == null) {
                this.a.s0(this.c);
            } else {
                this.a.s0(this);
            }
        }
    }
}
