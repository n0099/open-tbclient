package com.baidu.tieba.person;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.JSONLikeSerializable;
import com.baidu.tieba.ku4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/tieba/person/PersonCenterH5Helper;", "", "()V", "PERSON_CENTER_MAIN_URL", "", "PERSON_CENTER_PAGE_KEY", "tryGotoH5PersonCenter", "", "uid", "portrait", "personCenterPageKey", "currentPageKey", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PersonCenterH5Helper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final PersonCenterH5Helper INSTANCE;
    public static final String PERSON_CENTER_MAIN_URL;
    public static final String PERSON_CENTER_PAGE_KEY = "&page_key=a028";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1280045750, "Lcom/baidu/tieba/person/PersonCenterH5Helper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1280045750, "Lcom/baidu/tieba/person/PersonCenterH5Helper;");
                return;
            }
        }
        INSTANCE = new PersonCenterH5Helper();
        PERSON_CENTER_MAIN_URL = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-main-usercenter/userCenter?customfullscreen=1&nonavigationbar=1&user_skin_overlay=0&loadingSignal=1&page_key=a028";
    }

    public PersonCenterH5Helper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean tryGotoH5PersonCenter(String uid, String portrait, String personCenterPageKey, String currentPageKey) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, uid, portrait, personCenterPageKey, currentPageKey)) == null) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(portrait, "portrait");
            Intrinsics.checkNotNullParameter(personCenterPageKey, "personCenterPageKey");
            Intrinsics.checkNotNullParameter(currentPageKey, "currentPageKey");
            if (!Intrinsics.areEqual(uid, TbadkCoreApplication.getCurrentAccount()) && !Intrinsics.areEqual(portrait, TbadkCoreApplication.getCurrentPortrait())) {
                z = false;
            } else {
                z = true;
            }
            if (!TbadkCoreApplication.isLogin() || z || !Intrinsics.areEqual(personCenterPageKey, currentPageKey) || !UbsABTestHelper.isPersonCenterWebView()) {
                return false;
            }
            HashMap<String, Serializable> hashMap = new HashMap<>();
            hashMap.put(TiebaStatic.Params.FRIEND_UID, uid);
            hashMap.put("friend_uid_portrait", portrait);
            String currentAccountNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
            Intrinsics.checkNotNullExpressionValue(currentAccountNameShow, "getCurrentAccountNameShow()");
            hashMap.put("current_logged_username", currentAccountNameShow);
            JSONLikeSerializable lightEmotionJsonStr = TbSingleton.getInstance().getLightEmotionJsonStr();
            Intrinsics.checkNotNullExpressionValue(lightEmotionJsonStr, "getInstance().lightEmotionJsonStr");
            hashMap.put("interact_memes", lightEmotionJsonStr);
            ku4 j = ku4.j(TbadkCoreApplication.getInst(), PERSON_CENTER_MAIN_URL);
            j.f(hashMap);
            j.p();
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
