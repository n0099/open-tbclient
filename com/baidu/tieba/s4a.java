package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h6a;
import com.baidu.tieba.i6a;
import com.baidu.tieba.t3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class s4a implements t3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x3a a;
    public PayFlowType b;
    public c5a c;
    public c5a d;

    /* loaded from: classes5.dex */
    public class a implements h6a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;

        public a(s4a s4aVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s4aVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dialog;
        }

        @Override // com.baidu.tieba.h6a.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u5a.a(this.a, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i6a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t3a.b a;
        public final /* synthetic */ Dialog b;

        public b(s4a s4aVar, t3a.b bVar, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s4aVar, bVar, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = dialog;
        }

        @Override // com.baidu.tieba.i6a.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t3a.b bVar = this.a;
                if (bVar != null) {
                    bVar.b();
                }
                u5a.a(this.b, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            }
        }
    }

    public s4a(PayFlowType payFlowType, x3a x3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payFlowType, x3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayCampaignManager", "create PayCampaignManager:" + this);
        this.b = payFlowType;
        this.a = x3aVar;
    }

    @Override // com.baidu.tieba.t3a
    public GiftBagsInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c5a c5aVar = this.c;
            if (c5aVar != null) {
                return c5aVar.a();
            }
            return null;
        }
        return (GiftBagsInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t3a
    public boolean b(Activity activity, t3a.b bVar, v3a v3aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bVar, v3aVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showPayGiftDialog mGiftPackageData:" + this.d + " mPayFlowType:" + this.b);
            if (this.b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (c5a.b(this.d)) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but giftbag empty");
                return false;
            } else if (this.d.c()) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but hasShow");
                return false;
            } else {
                x3a x3aVar = this.a;
                if (x3aVar == null) {
                    RLog.error("PayCampaignManager", "showPayGiftDialog error mPayView null", new Object[0]);
                    return false;
                }
                i6a d = x3aVar.d(activity);
                d.setGiftBagsInfo(this.d.a());
                d.refreshView();
                this.d.d(true);
                d.setCallback(new b(this, bVar, h(activity, "", d, bVar, v3aVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.t3a
    public boolean e(Activity activity, t3a.a aVar, v3a v3aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, aVar, v3aVar, absViewEventHandler)) == null) {
            RLog.info("PayCampaignManager", "showConfirmLeaveDialog mConfirmLeaveData:" + this.c + " mPayFlowType:" + this.b);
            if (this.b != PayFlowType.DIOALOG_PAY_FLOW) {
                RLog.info("PayCampaignManager", "showPayGiftDialog but not DIOALOG_PAY_FLOW ");
                return false;
            } else if (c5a.b(this.c)) {
                RLog.info("PayCampaignManager", "showConfirmLeaveDialog but giftbag empty");
                return false;
            } else if (this.c.c()) {
                RLog.info("PayCampaignManager", "showConfirmFinishDialog but hasShow");
                return false;
            } else {
                x3a x3aVar = this.a;
                if (x3aVar == null) {
                    RLog.error("PayCampaignManager", "showConfirmFinishDialog error mPayView null", new Object[0]);
                    return false;
                }
                h6a b2 = x3aVar.b(activity);
                b2.setGiftBagsInfo(this.c.a());
                b2.refreshView();
                this.c.d(true);
                b2.setCallback(new a(this, g(activity, "", b2, aVar, v3aVar, absViewEventHandler)));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.t3a
    public void c(ViewGroup viewGroup, Activity activity) {
        g6a c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, activity) != null) || viewGroup == null) {
            return;
        }
        if (c5a.b(this.c)) {
            viewGroup.removeAllViews();
            return;
        }
        x3a x3aVar = this.a;
        if (x3aVar != null && (c = x3aVar.c(activity)) != null) {
            viewGroup.removeAllViews();
            c.setGiftBagsInfo(this.c.a());
            viewGroup.addView(c.getContentView());
            c.refreshView();
        }
    }

    @Override // com.baidu.tieba.t3a
    public void d(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateConfirmLeaveData- confirmLeaveData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.c = new c5a(giftBagsInfo, false);
        }
    }

    @Override // com.baidu.tieba.t3a
    public void f(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("PayCampaignManager", "updateGiftPackageData packageData:" + giftBagsInfo + " mPayFlowType:" + this.b);
            this.d = new c5a(giftBagsInfo, false);
        }
    }

    public final Dialog g(Activity activity, String str, h6a h6aVar, t3a.a aVar, v3a v3aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, str, h6aVar, aVar, v3aVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createConfirmFinishDialog");
            v3aVar.h(absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG);
            return q6a.b.e(activity, str, h6aVar.getContentView(), new j4a(aVar), absViewEventHandler, PayDialogType.PAY_CONFIRM_FINISH_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }

    public final Dialog h(Activity activity, String str, i6a i6aVar, t3a.b bVar, v3a v3aVar, AbsViewEventHandler absViewEventHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, str, i6aVar, bVar, v3aVar, absViewEventHandler})) == null) {
            RLog.info("PayCampaignManager", "createPayGiftDialog");
            v3aVar.h(absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG);
            return q6a.b.e(activity, str, i6aVar.getContentView(), new l4a(bVar), absViewEventHandler, PayDialogType.PAY_SHOW_GIFT_DIALOG, this.b);
        }
        return (Dialog) invokeCommon.objValue;
    }
}
