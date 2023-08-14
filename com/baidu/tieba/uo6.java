package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.k37;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class uo6 implements k37.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uo6() {
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

    @Override // com.baidu.tieba.k37.r
    public void a(ViewGroup view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof AgreeView) {
                ((AgreeView) view2).Q(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.k37.e
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AgreeView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k37.e
    public void update(ViewGroup view2, z57 feedAgreeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, feedAgreeData) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(feedAgreeData, "feedAgreeData");
            if (view2 instanceof AgreeView) {
                AgreeView agreeView = (AgreeView) view2;
                agreeView.setAgreeAlone(true);
                agreeView.z(false);
                Map<String, String> a = feedAgreeData.b().a();
                AgreeData agreeData = new AgreeData();
                agreeData.agreeNum = feedAgreeData.a();
                agreeData.hasAgree = feedAgreeData.c();
                String str = a.get("thread_id");
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                agreeData.threadId = str;
                String str3 = a.get("forum_id");
                if (str3 == null) {
                    str3 = "";
                }
                agreeData.forumId = str3;
                String str4 = a.get("reply_id");
                if (str4 != null) {
                    str2 = str4;
                }
                agreeData.postId = str2;
                agreeData.isInPost = true;
                agreeView.setData(agreeData);
            }
        }
    }
}
