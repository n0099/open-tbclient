package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.o55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class vn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public m55 b;
    public PermissionJudgePolicy c;
    public final int d;
    public final int e;
    public final int f;
    public c g;

    /* loaded from: classes8.dex */
    public final class a implements o55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ vn8 c;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(vn8 vn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vn8Var;
        }

        @Override // com.baidu.tieba.o55.f
        public void M0(o55 mPopupDialogView, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, mPopupDialogView, i, view2) == null) {
                Intrinsics.checkNotNullParameter(mPopupDialogView, "mPopupDialogView");
                Intrinsics.checkNotNullParameter(view2, "view");
                if (!(view2 instanceof TextView)) {
                    return;
                }
                String obj = ((TextView) view2).getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                this.c.j(mPopupDialogView, obj, this.a, this.b);
                m55 m55Var = this.c.b;
                if (m55Var != null) {
                    m55Var.dismiss();
                }
            }
        }

        public final void a(String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
                this.a = str;
                this.b = bArr;
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class b extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public final /* synthetic */ vn8 d;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(vn8 vn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vn8Var;
        }

        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    this.c = new JSONObject(str).optString("pid");
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    Intrinsics.checkNotNull(netWork);
                    netWork.cancelNetConnect();
                }
                this.d.a = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... params) {
            InterceptResult invokeL;
            boolean z;
            HttpNetContext netContext;
            HttpResponse response;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                NetWork netWork = new NetWork(TbConfig.URL_REQUEST_PID);
                this.a = netWork;
                String str = null;
                boolean z2 = false;
                try {
                    String str2 = params[0];
                    this.b = str2;
                    if (netWork != null) {
                        netWork.addPostData("pic_url", str2);
                    }
                    NetWork netWork2 = this.a;
                    if (netWork2 != null) {
                        str = netWork2.postMultiNetData();
                    }
                    NetWork netWork3 = this.a;
                    if (netWork3 != null && (netContext = netWork3.getNetContext()) != null && (response = netContext.getResponse()) != null && response.isRequestSuccess()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (!((str == null || str.length() == 0) ? true : true)) {
                            b(str);
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                super.onPostExecute((b) str);
                PersonalMsgImageActivityConfig personalMsgImageActivityConfig = new PersonalMsgImageActivityConfig(TbadkApplication.getInst(), this.b, TbadkCoreApplication.getCurrentAccountId(), "");
                personalMsgImageActivityConfig.isFromGroupChat(true);
                personalMsgImageActivityConfig.setPid(this.c);
                personalMsgImageActivityConfig.isShieldLongClickViewTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalMsgImageActivityConfig));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final byte[] b;
        public final /* synthetic */ vn8 c;

        public c(vn8 vn8Var, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn8Var, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vn8Var;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.g = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... arg0) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arg0)) == null) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.a, this.b, TbadkApplication.getInst());
                if (saveImageFileByUser == this.c.d) {
                    String string = TbadkCoreApplication.getInst().getString(R.string.save_image_to_album);
                    Intrinsics.checkNotNullExpressionValue(string, "getInst()\n              …ring.save_image_to_album)");
                    return string;
                } else if (saveImageFileByUser == this.c.f) {
                    String sdErrorString = FileHelper.getSdErrorString();
                    Intrinsics.checkNotNullExpressionValue(sdErrorString, "getSdErrorString()");
                    return sdErrorString;
                } else if (saveImageFileByUser == this.c.e) {
                    String string2 = TbadkCoreApplication.getInst().getString(R.string.save_fail);
                    Intrinsics.checkNotNullExpressionValue(string2, "getInst()\n              …kcore.R.string.save_fail)");
                    return string2;
                } else {
                    String string3 = TbadkCoreApplication.getInst().getString(R.string.save_fail);
                    Intrinsics.checkNotNullExpressionValue(string3, "getInst()\n              …kcore.R.string.save_fail)");
                    return string3;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onPostExecute((c) result);
                this.c.g = null;
                wi.Q(TbadkCoreApplication.getInst(), result);
            }
        }
    }

    public vn8() {
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
        this.e = -1;
        this.f = -2;
    }

    public final String[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1297);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(com.….tbadkcore.R.string.save)");
            return new String[]{string};
        }
        return (String[]) invokeV.objValue;
    }

    public final void i(String mImgUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mImgUrl) == null) {
            Intrinsics.checkNotNullParameter(mImgUrl, "mImgUrl");
            b bVar = new b(this);
            this.a = bVar;
            if (bVar != null) {
                bVar.execute(mImgUrl);
            }
        }
    }

    public final void j(o55 o55Var, String str, String str2, byte[] bArr) {
        TbPageContextSupport tbPageContextSupport;
        TbPageContext pageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, o55Var, str, str2, bArr) == null) {
            Context context = o55Var.getContext();
            Activity activity = null;
            if (context instanceof TbPageContextSupport) {
                tbPageContextSupport = (TbPageContextSupport) context;
            } else {
                tbPageContextSupport = null;
            }
            if (Intrinsics.areEqual(str, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1297))) {
                if (tbPageContextSupport != null && (pageContext = tbPageContextSupport.getPageContext()) != null) {
                    activity = pageContext.getPageActivity();
                }
                if (this.c == null) {
                    this.c = new PermissionJudgePolicy();
                }
                PermissionJudgePolicy permissionJudgePolicy = this.c;
                if (permissionJudgePolicy != null) {
                    permissionJudgePolicy.clearRequestPermissionList();
                }
                PermissionJudgePolicy permissionJudgePolicy2 = this.c;
                if (permissionJudgePolicy2 != null) {
                    permissionJudgePolicy2.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                }
                PermissionJudgePolicy permissionJudgePolicy3 = this.c;
                boolean z = true;
                if ((permissionJudgePolicy3 == null || !permissionJudgePolicy3.startRequestPermission(activity)) ? false : false) {
                    return;
                }
                c cVar = new c(this, str2, bArr);
                this.g = cVar;
                if (cVar != null) {
                    cVar.execute(new String[0]);
                }
            }
        }
    }

    public final void k(Context mContext, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mContext, str, bArr) == null) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            TbPageContext currentPageContext = TbadkApplication.getInst().getCurrentPageContext(mContext);
            if (currentPageContext != null) {
                m55 m55Var = new m55(currentPageContext);
                a aVar = new a(this);
                aVar.a(str, bArr);
                m55Var.i(null, h(), aVar);
                this.b = m55Var;
                if (m55Var != null) {
                    m55Var.l();
                }
            }
        }
    }
}
