package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernNotificationViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wc6 extends ln<ad6, LiveTabConcernNotificationViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public boolean b;
    public up6<ad6> c;

    /* loaded from: classes8.dex */
    public class a extends up6<ad6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wc6 b;

        public a(wc6 wc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, ad6 ad6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ad6Var) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09101c) {
                    if (!this.b.b) {
                        this.b.b = true;
                        AlaSharedPrefHelper.getInstance().putLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, System.currentTimeMillis());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921421));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09101d) {
                    dd6.b(this.b.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wc6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), ad6.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new a(this);
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public LiveTabConcernNotificationViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            jd6 jd6Var = new jd6(this.a, viewGroup);
            jd6Var.k(this.c);
            return new LiveTabConcernNotificationViewHolder(jd6Var);
        }
        return (LiveTabConcernNotificationViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ad6 ad6Var, LiveTabConcernNotificationViewHolder liveTabConcernNotificationViewHolder) {
        InterceptResult invokeCommon;
        jd6 jd6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ad6Var, liveTabConcernNotificationViewHolder})) == null) {
            if (liveTabConcernNotificationViewHolder != null && (jd6Var = liveTabConcernNotificationViewHolder.a) != null) {
                this.b = false;
                jd6Var.i(ad6Var);
                return liveTabConcernNotificationViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
