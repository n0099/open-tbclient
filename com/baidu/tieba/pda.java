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
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.vcode.VcodeTool;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pda implements NewWriteModel.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteModel a;
    public boolean b;
    public NewWriteModel.d c;

    /* loaded from: classes7.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pda a;

        /* renamed from: com.baidu.tieba.pda$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0439a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteData a;
            public final /* synthetic */ PostWriteCallBackData b;
            public final /* synthetic */ a c;

            public RunnableC0439a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
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
                    if ((!bi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) || (this.a.getVideoInfo() != null && this.a.getVideoInfo().hasUpload())) {
                        new rda().v(this.b);
                    } else {
                        new rda().u(this.b, this.a);
                    }
                    vaa.j(this.c.a.l());
                    this.c.a.i();
                    if (!bi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) {
                        this.b.mVideoMd5 = this.a.getVideoInfo().getVideoMd5();
                        if (!bi.isEmpty(this.a.getForumName())) {
                            this.b.mFrom = 2;
                        }
                    }
                    this.c.a.t();
                }
            }
        }

        public a(pda pdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pdaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) != null) || writeData == null) {
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
                SafeHandler.getInst().postDelayed(new RunnableC0439a(this, writeData, postWriteCallBackData), (i + 1) * 1000);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                this.a.t();
            } else if (!VcodeTool.tryShowOnWriteScene(postWriteCallBackData, jd5Var, writeData, antiData)) {
                if (postWriteCallBackData != null) {
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.notifyFlutterPostFail(str)));
                new rda().s(postWriteCallBackData, jd5Var, writeData, antiData);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                this.a.t();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ WriteData b;
        public final /* synthetic */ pda c;

        public b(pda pdaVar, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pdaVar, postWriteCallBackData, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pdaVar;
            this.a = postWriteCallBackData;
            this.b = writeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((!bi.isEmpty(this.a.getVideoid()) && this.b.getVideoInfo() != null) || (this.b.getVideoInfo() != null && this.b.getVideoInfo().hasUpload())) {
                    new rda().v(this.a);
                    return;
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(currentActivity).areNotificationsEnabled();
                    boolean z = de5.d().f;
                    boolean z2 = de5.d().g;
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

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final pda a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-520503651, "Lcom/baidu/tieba/pda$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-520503651, "Lcom/baidu/tieba/pda$c;");
                    return;
                }
            }
            a = new pda(null);
        }
    }

    public pda() {
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
        newWriteModel.l0(this);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return DialogUtil.showPushPermissionDialog(TbadkCoreApplication.getInst().getCurrentActivity(), 2);
            }
            return uv9.e().b("post_success");
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
            if (this.a.d0() == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = this.a.d0().toDraftString();
            }
            sb.append(draftString);
            qda.a(sb.toString());
            return this.a.d0();
        }
        return (WriteData) invokeV.objValue;
    }

    public /* synthetic */ pda(a aVar) {
        this();
    }

    public final boolean h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            tv9 g = uv9.e().g("post_question_success");
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
            qda.a("AsyncWriteHelper.initWriteStatus()");
            this.a.m0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.j0(false);
        }
    }

    public void o(@NonNull BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdPageContext) == null) {
            qda.a("AsyncWriteHelper.onWriteActClose()");
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel.e == bdPageContext) {
                newWriteModel.m0(null);
            }
        }
    }

    public void p(@NonNull BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdPageContext) == null) {
            this.a.m0(bdPageContext);
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
            qda.a("AsyncWriteHelper.setHasImage = " + z);
            this.a.j0(z);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.a.i0(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.a.k0(z);
        }
    }

    public static pda k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            qda.a("AsyncWriteHelper.getInstance()");
            return c.a;
        }
        return (pda) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            qda.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            qda.a("AsyncWriteHelper.checkImageNum = " + this.a.b0());
            return this.a.b0();
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FileHelper.deleteFileOrDir(new File(dla.f));
            vaa.y("");
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
            qda.a("AsyncWriteHelper.startPostWrite()");
            boolean n0 = this.a.n0();
            this.b = n0;
            return n0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) && writeData != null && postWriteCallBackData != null) {
            if (z) {
                PublishProgressData.valueOf(writeData, 100).send(true);
                if (writeData.isPutStorageTid()) {
                    s(postWriteCallBackData.getThreadId());
                }
                SafeHandler.getInst().postDelayed(new b(this, postWriteCallBackData, writeData), 200L);
                if (writeData.isRichTextEditorMode()) {
                    ta5.b(writeData.getRichContentData().toString(), "2");
                } else {
                    ta5.b(writeData.getToServerContent(), "2");
                }
                vaa.j(l());
                i();
                u(postWriteCallBackData);
                if (!bi.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                    postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                    if (!bi.isEmpty(writeData.getForumName())) {
                        postWriteCallBackData.mFrom = 2;
                    }
                }
                xda.a(l(), postWriteCallBackData.getThreadId());
                PublishProgressData.valueOf(writeData, 100).send(false);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                t();
            } else if (!VcodeTool.tryShowOnWriteScene(postWriteCallBackData, jd5Var, writeData, antiData)) {
                PublishProgressData.valueOf(writeData, 100).send(false);
                new rda().s(postWriteCallBackData, jd5Var, writeData, antiData);
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                t();
            }
        }
    }

    public void j(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && WriteMsgHolder.getCurrentWriteActivityFromTag() == null) {
                this.c.callback(z, postWriteCallBackData, jd5Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, jd5Var, writeData, antiData);
            }
        }
    }

    public final void q(boolean z, boolean z2, @NonNull PostWriteCallBackData postWriteCallBackData, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), postWriteCallBackData, writeData}) == null) {
            if (z && z2) {
                new rda().u(postWriteCallBackData, writeData);
            } else if (postWriteCallBackData.getToast() != null) {
            } else {
                boolean b2 = uv9.e().b("post_question_success");
                String firstClass = writeData.getFirstClass();
                if (!TextUtils.isEmpty(firstClass) && h(firstClass) && b2) {
                    new rda().t(JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L), JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L), "post_question_success");
                } else {
                    new rda().u(postWriteCallBackData, writeData);
                }
            }
        }
    }

    public final void r(boolean z, boolean z2, boolean z3, @NonNull PostWriteCallBackData postWriteCallBackData, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), postWriteCallBackData, writeData}) == null) {
            if (z && z2 && z3) {
                new rda().u(postWriteCallBackData, writeData);
            } else if (postWriteCallBackData.getToast() != null) {
            } else {
                if (g()) {
                    new rda().t(JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L), JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L), "post_success");
                } else {
                    new rda().u(postWriteCallBackData, writeData);
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
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putString("key_local_app_storage_fake_tid", sb.toString());
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
            qda.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && WriteMsgHolder.getCurrentWriteActivityFromTag() == null) {
                this.a.l0(this.c);
            } else {
                this.a.l0(this);
            }
        }
    }
}
