package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class rx7 extends qx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout K;
    public TextView L;
    public TextView M;
    public TextView N;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c6 : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements mx5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx7 a;

        public a(rx7 rx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rx7Var;
        }

        @Override // com.baidu.tieba.mx5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                rx7 rx7Var = this.a;
                if (rx7Var.v != null && rx7Var.Q()) {
                    UrlManager urlManager = UrlManager.getInstance();
                    rx7 rx7Var2 = this.a;
                    urlManager.dealOneLink(rx7Var2.b, new String[]{rx7Var2.v.getActUrl()});
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View i3 = i();
        this.K = (RelativeLayout) i3.findViewById(R.id.obfuscated_res_0x7f091744);
        this.L = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f091747);
        this.M = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f091745);
        this.N = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09173b);
    }

    @Override // com.baidu.tieba.qx7
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.v != null && Q()) {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{this.v.getActUrl()});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: C */
    public void j(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || threadData == null) {
            return;
        }
        if (ListUtils.getCount(threadData.getMedias()) > 1) {
            ArrayList<MediaData> arrayList = new ArrayList<>();
            arrayList.add(threadData.getMedias().get(0));
            threadData.setMedias(arrayList);
        }
        super.C(threadData);
        this.z.setImageClickListener(new a(this));
        gw4 gw4Var = (gw4) ListUtils.getItem(threadData.getActDatas(), 0);
        if (gw4Var != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            this.L.setText(StringUtils.string(c().getResources().getString(R.string.obfuscated_res_0x7f0f0c6e), GlideException.IndentedAppendable.INDENT, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(gw4Var.b()))), "-", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(gw4Var.c())))));
            this.M.setText(String.format(c().getResources().getString(R.string.obfuscated_res_0x7f0f0c69), String.valueOf(gw4Var.f())));
            this.N.setText(R.string.obfuscated_res_0x7f0f0c68);
            this.k.setCommentNumEnable(false);
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            ViewHelper.skipToLoginActivity(this.b.getPageActivity());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qx7, com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            if (this.u != i) {
                SkinManager.setBackgroundColor(this.K, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.L, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.N, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.N, R.drawable.bg_card_frs_lottery_btn);
            }
            super.k(tbPageContext, i);
        }
    }
}
