package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pn4 {
    public static /* synthetic */ Interceptable $ic;
    public static View.OnClickListener a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || view2.getTag() == null || !(view2.getTag() instanceof nn4)) {
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ej.M(view2.getContext(), R.string.obfuscated_res_0x7f0f0c92);
                return;
            }
            nn4 nn4Var = (nn4) view2.getTag();
            AlaUserInfoData alaUserInfoData = nn4Var.a;
            if (alaUserInfoData == null) {
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            long j = alaUserInfoData.anchor_live;
            if (j != 0) {
                alaLiveInfoCoreData.liveID = j;
            } else {
                long j2 = alaUserInfoData.enter_live;
                if (j2 != 0) {
                    alaLiveInfoCoreData.liveID = j2;
                } else {
                    long j3 = alaUserInfoData.live_id;
                    if (j3 == 0) {
                        return;
                    }
                    alaLiveInfoCoreData.liveID = j3;
                }
            }
            int i = nn4Var.b;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                TiebaStatic.log(new StatisticItem("c11850").param("uid", currentAccount));
            } else if (i == 2 || i == 3 || i == 4) {
                TiebaStatic.log(new StatisticItem("c11851").param("uid", currentAccount));
            } else if (i == 5) {
                TiebaStatic.log(new StatisticItem("c11852").param("uid", currentAccount));
            } else if (i == 7) {
                if (alaUserInfoData.ala_id != 0) {
                    TiebaStatic.log(new StatisticItem("c11855").param("uid", currentAccount).param("click_uid", alaUserInfoData.ala_id).param(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfoData.live_status));
                }
                TiebaStatic.log(new StatisticItem("c12542"));
                if (nn4Var.c && !StringUtils.isNull(alaUserInfoData.sex)) {
                    BdToast b = BdToast.b(view2.getContext(), String.format(view2.getContext().getString(R.string.obfuscated_res_0x7f0f0e83), alaUserInfoData.sex));
                    b.f(BdToast.ToastIcon.FAILURE);
                    b.i();
                    return;
                }
            }
            int i2 = nn4Var.b;
            MessageManager.getInstance().sendMessage(new CustomMessage(2911003, new AlaLiveRoomActivityConfig(view2.getContext(), alaLiveInfoCoreData, i2 == 5 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION : i2 == 7 ? AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY : AlaLiveRoomActivityConfig.FROM_TYPE_TAIL_LIGHT, null, false, "")));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067795, "Lcom/baidu/tieba/pn4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067795, "Lcom/baidu/tieba/pn4;");
                return;
            }
        }
        a = new a();
    }

    public static TextView a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null || MessageManager.getInstance().findTask(2911003) == null) {
                return null;
            }
            TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0111, (ViewGroup) null);
            textView.setOnClickListener(a);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }
}
