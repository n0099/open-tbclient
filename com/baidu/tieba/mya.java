package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.push.PushSceneItem;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mya implements NewWriteModel.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteModel a;
    public boolean b;
    public NewWriteModel.d c;

    /* loaded from: classes7.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mya a;

        /* renamed from: com.baidu.tieba.mya$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0399a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteData a;
            public final /* synthetic */ PostWriteCallBackData b;
            public final /* synthetic */ a c;

            public RunnableC0399a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
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
                    if ((!rd.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) || (this.a.getVideoInfo() != null && this.a.getVideoInfo().hasUpload())) {
                        new oya().w(this.b);
                    } else {
                        new oya().v(this.b, this.a);
                    }
                    rva.k(this.c.a.m());
                    this.c.a.j();
                    if (!rd.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) {
                        this.b.mVideoMd5 = this.a.getVideoInfo().getVideoMd5();
                        if (!rd.isEmpty(this.a.getForumName())) {
                            this.b.mFrom = 2;
                        }
                    }
                    this.c.a.u();
                }
            }
        }

        public a(mya myaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) != null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData notifyFlutterPostSucc = WorkPostNotifyFlutterData.notifyFlutterPostSucc(postWriteCallBackData.getVideoid());
                notifyFlutterPostSucc.setForumId(writeData.getForumId());
                notifyFlutterPostSucc.setForumName(writeData.getForumName());
                notifyFlutterPostSucc.setThreadDataByWriteData(writeData);
                notifyFlutterPostSucc.setFlutterPageId(WriteMsgHolder.getFlutterPageId());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, notifyFlutterPostSucc));
                int i = 3;
                int i2 = SharedPrefHelper.getInstance().getInt("key_video_works_progress_bar_waiting_time", 3);
                if (i2 > 0) {
                    i = i2;
                }
                SafeHandler.getInst().postDelayed(new RunnableC0399a(this, writeData, postWriteCallBackData), (i + 1) * 1000);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                this.a.u();
                return;
            }
            if (!VcodeTool.tryShowOnWriteScene(postWriteCallBackData, o95Var, writeData, antiData)) {
                if (postWriteCallBackData != null) {
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.notifyFlutterPostFail(str)));
                new oya().t(postWriteCallBackData, o95Var, writeData, antiData);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                this.a.u();
            }
            this.a.b = false;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ WriteData b;
        public final /* synthetic */ mya c;

        public b(mya myaVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myaVar, postWriteCallBackData, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = myaVar;
            this.a = postWriteCallBackData;
            this.b = writeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((!rd.isEmpty(this.a.getVideoid()) && this.b.getVideoInfo() != null) || (this.b.getVideoInfo() != null && this.b.getVideoInfo().hasUpload())) {
                    new oya().w(this.a);
                    return;
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(currentActivity).areNotificationsEnabled();
                    boolean z = ia5.e().f;
                    boolean z2 = ia5.e().g;
                    if (this.b.isShareThread()) {
                        return;
                    }
                    if (this.b.isQuestionThread()) {
                        this.c.r(areNotificationsEnabled, z, this.a, this.b);
                    } else {
                        this.c.s(areNotificationsEnabled, z, z2, this.a, this.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;

        public c(mya myaVar, PostWriteCallBackData postWriteCallBackData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myaVar, postWriteCallBackData};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                new oya().u(JavaTypesHelper.toLong(this.a.getPostId(), 0L), JavaTypesHelper.toLong(this.a.getThreadId(), 0L), "post_success");
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;

        public d(mya myaVar, PostWriteCallBackData postWriteCallBackData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myaVar, postWriteCallBackData};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                new oya().u(JavaTypesHelper.toLong(this.a.getPostId(), 0L), JavaTypesHelper.toLong(this.a.getThreadId(), 0L), "post_question_success");
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static final mya a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-586997101, "Lcom/baidu/tieba/mya$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-586997101, "Lcom/baidu/tieba/mya$e;");
                    return;
                }
            }
            a = new mya(null);
        }
    }

    public mya() {
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
        newWriteModel.m0(this);
    }

    public WriteData m() {
        InterceptResult invokeV;
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            if (this.a.e0() == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = this.a.e0().toDraftString();
            }
            sb.append(draftString);
            nya.a(sb.toString());
            return this.a.e0();
        }
        return (WriteData) invokeV.objValue;
    }

    public /* synthetic */ mya(a aVar) {
        this();
    }

    public final boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PushSceneItem l = PushGuideManager.l("post_question_success");
            if (l == null) {
                return false;
            }
            List<String> sceneClass = l.getSceneClass();
            if (ListUtils.isEmpty(sceneClass)) {
                return false;
            }
            return sceneClass.contains(str);
        }
        return invokeL.booleanValue;
    }

    public void n(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContextSupport) == null) {
            nya.a("AsyncWriteHelper.initWriteStatus()");
            this.a.n0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.k0(false);
        }
    }

    public void p(@NonNull BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdPageContext) == null) {
            nya.a("AsyncWriteHelper.onWriteActClose()");
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel.e == bdPageContext) {
                newWriteModel.n0(null);
            }
        }
    }

    public void q(@NonNull BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdPageContext) == null) {
            this.a.n0(bdPageContext);
        }
    }

    public final void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            nya.a("AsyncWriteHelper.setHasImage = " + z);
            this.a.k0(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.a.j0(z);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.a.l0(z);
        }
    }

    public static mya l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            nya.a("AsyncWriteHelper.getInstance()");
            return e.a;
        }
        return (mya) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nya.a("AsyncWriteHelper.startPostWrite()");
            boolean o0 = this.a.o0();
            this.b = o0;
            return o0;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nya.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            nya.a("AsyncWriteHelper.checkImageNum = " + this.a.c0());
            return this.a.c0();
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return PushGuideManager.e("post_success");
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FileHelper.deleteFileOrDir(new File(g6b.f));
            rva.B("");
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.b = false;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) && writeData != null && postWriteCallBackData != null) {
            if (z) {
                PublishProgressData.valueOf(writeData, 100).send(true);
                if (writeData.isPutStorageTid()) {
                    t(postWriteCallBackData.getThreadId());
                }
                SafeHandler.getInst().postDelayed(new b(this, postWriteCallBackData, writeData), 200L);
                if (writeData.isRichTextEditorMode()) {
                    if (writeData.getRichContentData() != null) {
                        a75.b(writeData.getRichContentData().toString(), "2");
                    }
                } else {
                    a75.b(writeData.getToServerContent(), "2");
                }
                rva.k(m());
                j();
                v(postWriteCallBackData);
                if (!rd.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                    postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                    if (!rd.isEmpty(writeData.getForumName())) {
                        postWriteCallBackData.mFrom = 2;
                    }
                }
                uya.a(m(), postWriteCallBackData.getThreadId());
                PublishProgressData.valueOf(writeData, 100).send(false);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                u();
                return;
            }
            PublishProgressData.valueOf(writeData, 100).send(false);
            if (!VcodeTool.tryShowOnWriteScene(postWriteCallBackData, o95Var, writeData, antiData)) {
                new oya().t(postWriteCallBackData, o95Var, writeData, antiData);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                u();
            }
            this.b = false;
        }
    }

    public void k(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && WriteMsgHolder.getCurrentWriteActivityFromTag() == null) {
                this.c.callback(z, postWriteCallBackData, o95Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, o95Var, writeData, antiData);
            }
        }
    }

    public final void r(boolean z, boolean z2, @NonNull PostWriteCallBackData postWriteCallBackData, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), postWriteCallBackData, writeData}) == null) {
            if (z && z2) {
                new oya().v(postWriteCallBackData, writeData);
            } else if (postWriteCallBackData.getToast() != null) {
            } else {
                boolean e2 = PushGuideManager.e("post_question_success");
                String firstClass = writeData.getFirstClass();
                if (!TextUtils.isEmpty(firstClass) && i(firstClass) && e2) {
                    dga j = PushGuideManager.j("post_question_success");
                    TbPageContext currentPageContext = TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity());
                    if (j != null && currentPageContext != null) {
                        j.e(writeData);
                        j.k(currentPageContext, new d(this, postWriteCallBackData));
                        return;
                    }
                    return;
                }
                new oya().v(postWriteCallBackData, writeData);
            }
        }
    }

    public final void s(boolean z, boolean z2, boolean z3, @NonNull PostWriteCallBackData postWriteCallBackData, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), postWriteCallBackData, writeData}) == null) {
            if (z && z2 && z3) {
                new oya().v(postWriteCallBackData, writeData);
            } else if (postWriteCallBackData.getToast() != null) {
            } else {
                if (h()) {
                    dga j = PushGuideManager.j("post_success");
                    TbPageContext currentPageContext = TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity());
                    if (j != null && currentPageContext != null) {
                        j.e(writeData);
                        j.k(currentPageContext, new c(this, postWriteCallBackData));
                        return;
                    }
                    return;
                }
                new oya().v(postWriteCallBackData, writeData);
            }
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
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
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putString("key_local_app_storage_fake_tid", sb.toString());
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public void z(WriteData writeData) {
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            if (writeData == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = writeData.toDraftString();
            }
            sb.append(draftString);
            nya.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && WriteMsgHolder.getCurrentWriteActivityFromTag() == null) {
                this.a.m0(this.c);
            } else {
                this.a.m0(this);
            }
        }
    }
}
