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
/* loaded from: classes4.dex */
public class lk6 extends kk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout K;
    public TextView L;
    public TextView M;
    public TextView N;

    /* loaded from: classes4.dex */
    public class a implements ih5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lk6 a;

        public a(lk6 lk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lk6Var;
        }

        @Override // com.baidu.tieba.ih5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                lk6 lk6Var = this.a;
                if (lk6Var.v == null || !lk6Var.O()) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                lk6 lk6Var2 = this.a;
                urlManager.dealOneLink(lk6Var2.b, new String[]{lk6Var2.v.getActUrl()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lk6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        View h = h();
        this.K = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f09142c);
        this.L = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091431);
        this.M = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09142d);
        this.N = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091423);
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            ViewHelper.skipToLoginActivity(this.b.getPageActivity());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kk6, com.baidu.tieba.jz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d018e : invokeV.intValue;
    }

    @Override // com.baidu.tieba.kk6, com.baidu.tieba.jz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            if (this.u != i) {
                SkinManager.setBackgroundColor(this.K, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.L, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.N, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.N, R.drawable.bg_card_frs_lottery_btn);
            }
            super.j(tbPageContext, i);
        }
    }

    @Override // com.baidu.tieba.kk6
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.v != null && O()) {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{this.v.getActUrl()});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kk6, com.baidu.tieba.jz5
    /* renamed from: z */
    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) || threadData == null) {
            return;
        }
        if (ListUtils.getCount(threadData.getMedias()) > 1) {
            ArrayList<MediaData> arrayList = new ArrayList<>();
            arrayList.add(threadData.getMedias().get(0));
            threadData.setMedias(arrayList);
        }
        super.i(threadData);
        this.z.setImageClickListener(new a(this));
        io4 io4Var = (io4) ListUtils.getItem(threadData.getActDatas(), 0);
        if (io4Var != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            this.L.setText(StringUtils.string(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a7c), GlideException.IndentedAppendable.INDENT, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(io4Var.b()))), "-", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(io4Var.c())))));
            this.M.setText(String.format(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a77), String.valueOf(io4Var.f())));
            this.N.setText(R.string.obfuscated_res_0x7f0f0a76);
            this.k.setCommentNumEnable(false);
        }
    }
}
