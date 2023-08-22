package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p96 extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p96 a;

        public a(p96 p96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p96Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.f(true);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p96 a;

        public b(p96 p96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p96Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.f(false);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public c(p96 p96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public p96() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e();
            g(getAgent(), this.mParams.getString("options"));
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            h();
        }
    }

    public final int d(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            if (str.equals(Share.WEIXIN_FRIEND)) {
                return 3;
            }
            if (str.equals(Share.WEIXIN_TIMELINE)) {
                return 2;
            }
            if (str.equals(Share.QQFRIEND)) {
                return 8;
            }
            if (str.equals(Share.QQDENGLU)) {
                return 4;
            }
            if (str.equals(Share.SINAWEIBO)) {
                return 6;
            }
            return i;
        }
        return invokeIL.intValue;
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mResult.putBoolean("share_result", z);
            h();
            finish();
        }
    }

    public final void g(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, activity, str) == null) {
            if (activity == null) {
                f(false);
                return;
            }
            o96 o96Var = new o96();
            try {
                o96Var.e(new JSONObject(str));
                TbadkCoreApplication.getInst().setCurAiAppid(o96Var.aiAppId);
                if (!TextUtils.isEmpty(o96Var.c())) {
                    int d = d(-1, o96Var.c());
                    if (!TextUtils.isEmpty(o96Var.b()) && !TextUtils.isEmpty(o96Var.a())) {
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                        httpMessage.addParam("scheme", o96Var.b());
                        httpMessage.setExtra(new o05(o96Var, activity, d, new a(this)));
                        MessageManager.getInstance().sendMessage(httpMessage);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, d, o96Var, true));
                    f(gf5.b(activity, d));
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13530").param("obj_id", o96Var.aiAppId).param("obj_type", o96Var.aiAppType).param("obj_source", o96Var.aiAppSource));
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, o96Var, false);
                shareDialogConfig.onCancelListener = new b(this);
                shareDialogConfig.onDismissListener = new c(this);
                JSONArray d2 = o96Var.d();
                if (d2 != null && !TextUtils.isEmpty(o96Var.b()) && !TextUtils.isEmpty(o96Var.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < d2.length(); i++) {
                        try {
                            arrayList.add(Integer.valueOf(d(-1, d2.getString(i))));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!ListUtils.isEmpty(arrayList)) {
                        o96Var.setCommandChannelArray(arrayList);
                    }
                    HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage2.addParam("scheme", o96Var.b());
                    httpMessage2.setExtra(new o05(o96Var, activity, shareDialogConfig.onCancelListener));
                    MessageManager.getInstance().sendMessage(httpMessage2);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            } catch (JSONException unused) {
                f(false);
            }
        }
    }
}
