package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.ShareService;
import com.baidu.searchbox.live.shell.list.basic.MixYYFakeShell;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ml7 implements ShareService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareService.IOnSocialListener a;
    public CustomMessageListener b;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ml7 ml7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) customResponsedMessage.getData();
            if (this.a.a != null) {
                if (num.intValue() == 1) {
                    this.a.a.onComplete("");
                } else if (num.intValue() == 2) {
                    this.a.a.onError("");
                } else if (num.intValue() == 3) {
                    this.a.a.onCancel("");
                }
                this.a.a = null;
            }
            MessageManager.getInstance().unRegisterListener(this.a.b);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947976593, "Lcom/baidu/tieba/ml7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947976593, "Lcom/baidu/tieba/ml7;");
        }
    }

    public ml7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new a(this, 2921550);
    }

    public final void a(Context context, View view2, String str, String str2, String str3, String str4, String str5, ShareService.IOnSocialListener iOnSocialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, view2, str, str2, str3, str4, str5, iOnSocialListener}) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.v = str;
            shareItem.w = str2;
            shareItem.A = str4;
            shareItem.x = str3;
            try {
                JSONObject jSONObject = new JSONObject(str5);
                String optString = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
                shareItem.Y = jSONObject.optLong(MixYYFakeShell.ROOM_ID_YY);
                shareItem.Z = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_VOICE_ROOM_TYPE);
                if (TextUtils.isEmpty(optString)) {
                    String optString2 = jSONObject.optString("liveId");
                    String optString3 = jSONObject.optString("userId");
                    shareItem.u = optString2;
                    shareItem.x0 = optString3;
                } else {
                    if (jSONObject.optInt("yy_show_tieba_entrance", 1) == 1) {
                        shareItem.D = optString;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.a = iOnSocialListener;
            MessageManager.getInstance().registerListener(this.b);
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaSDKShareEmptyActivityConfig(context, shareItem, 0, 1)));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public boolean canShareInLandScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public void clean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public void startShare(Context context, View view2, String str, String str2, String str3, String str4, String str5, ShareService.IOnSocialListener iOnSocialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, view2, str, str2, str3, str4, str5, iOnSocialListener}) == null) {
            a(context, view2, str, str2, str3, str4, str5, iOnSocialListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public void startShare(Context context, View view2, String str, String str2, String str3, String str4, String str5, String str6, ShareService.IOnSocialListener iOnSocialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, view2, str, str2, str3, str4, str5, str6, iOnSocialListener}) == null) {
            startShare(context, view2, str, str2, str3, str4, str5, iOnSocialListener);
        }
    }
}
