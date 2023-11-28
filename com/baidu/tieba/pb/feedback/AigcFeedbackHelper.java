package com.baidu.tieba.pb.feedback;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.mu4;
import com.baidu.tieba.nwa;
import com.baidu.tieba.r45;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.to5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tbclient.AigcFeedbackInfo;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J$\u0010\u0010\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/pb/feedback/AigcFeedbackHelper;", "", "()V", "messageHelper", "Lcom/baidu/tbadk/core/message/AgreeMessageHelper;", "getMessageHelper", "()Lcom/baidu/tbadk/core/message/AgreeMessageHelper;", "messageHelper$delegate", "Lkotlin/Lazy;", "agree", "", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "agreeData", "Lcom/baidu/tieba/tbadkCore/data/AgreeData;", "disagree", "openUrl", "postData", "Lcom/baidu/tieba/tbadkCore/data/PostData;", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AigcFeedbackHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final AigcFeedbackHelper a;
    public static final Lazy b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1755092265, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1755092265, "Lcom/baidu/tieba/pb/feedback/AigcFeedbackHelper;");
                return;
            }
        }
        a = new AigcFeedbackHelper();
        b = LazyKt__LazyJVMKt.lazy(AigcFeedbackHelper$messageHelper$2.INSTANCE);
    }

    public AigcFeedbackHelper() {
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

    public final r45 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (r45) b.getValue();
        }
        return (r45) invokeV.objValue;
    }

    @JvmStatic
    public static final void a(TbPageContext<BaseFragmentActivity> tbPageContext, AgreeData agreeData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, agreeData) == null) && agreeData != null) {
            int i = 1;
            long j = 0;
            if (agreeData.isSelectAgree()) {
                long j2 = agreeData.agreeNum;
                if (j2 > 0) {
                    j = j2 - 1;
                }
                agreeData.agreeNum = j;
                agreeData.hasAgree = false;
            } else {
                if (agreeData.isDisagreeType()) {
                    long j3 = agreeData.disAgreeNum;
                    if (j3 > 0) {
                        j = j3 - 1;
                    }
                    agreeData.disAgreeNum = j;
                }
                agreeData.agreeType = 2;
                agreeData.agreeNum++;
                agreeData.hasAgree = true;
                i = 0;
            }
            BdUniqueId bdUniqueId = null;
            if (tbPageContext != null) {
                activity = tbPageContext.getPageActivity();
            } else {
                activity = null;
            }
            to5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(activity);
            if (currentVisiblePageExtra != null) {
                agreeData.objSource = currentVisiblePageExtra.a();
            }
            r45 c = a.c();
            if (tbPageContext != null) {
                bdUniqueId = tbPageContext.getUniqueId();
            }
            c.c(agreeData, i, bdUniqueId, false);
        }
    }

    @JvmStatic
    public static final void b(TbPageContext<BaseFragmentActivity> tbPageContext, AgreeData agreeData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, tbPageContext, agreeData) == null) && agreeData != null) {
            int i = 1;
            long j = 0;
            if (agreeData.isSelectDisagree()) {
                long j2 = agreeData.disAgreeNum;
                if (j2 > 0) {
                    j = j2 - 1;
                }
                agreeData.disAgreeNum = j;
                agreeData.hasAgree = false;
            } else {
                if (agreeData.isAgreeType()) {
                    long j3 = agreeData.agreeNum;
                    if (j3 > 0) {
                        j = j3 - 1;
                    }
                    agreeData.agreeNum = j;
                }
                agreeData.agreeType = 5;
                agreeData.disAgreeNum++;
                agreeData.hasAgree = true;
                i = 0;
            }
            BdUniqueId bdUniqueId = null;
            if (tbPageContext != null) {
                activity = tbPageContext.getPageActivity();
            } else {
                activity = null;
            }
            to5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(activity);
            if (currentVisiblePageExtra != null) {
                agreeData.objSource = currentVisiblePageExtra.a();
            }
            r45 c = a.c();
            if (tbPageContext != null) {
                bdUniqueId = tbPageContext.getUniqueId();
            }
            c.c(agreeData, i, bdUniqueId, false);
        }
    }

    @JvmStatic
    public static final void d(nwa nwaVar) {
        String str;
        AigcFeedbackInfo t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nwaVar) == null) {
            if (nwaVar != null && (t = nwaVar.t()) != null) {
                str = t.feedback_url;
            } else {
                str = null;
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                HashMap<String, Serializable> hashMap = new HashMap<>();
                String U = nwaVar.U();
                String str2 = "0";
                if (U == null) {
                    U = "0";
                }
                hashMap.put("post_id", U);
                String v = nwaVar.v();
                if (v != null) {
                    str2 = v;
                }
                hashMap.put("bot_uid", str2);
                Bundle bundle = new Bundle();
                bundle.putString(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT, TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                mu4 j = mu4.j(TbadkCoreApplication.getInst(), str);
                j.f(hashMap);
                j.a(bundle);
                j.p();
            }
        }
    }
}
