package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class of6 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public RelativeLayout b;
    public ThreadUserInfoLayout c;
    public TextView d;
    public ThreadCommentAndPraiseInfoLayout e;
    public View f;
    public AlaVideoContainer g;
    public View h;
    public ThreadData i;
    public String j;
    public sf6 k;
    public final View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of6 a;

        public a(of6 of6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null) {
                this.a.k.b(view2, this.a.i);
            }
        }
    }

    public of6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d034f, (ViewGroup) null);
        this.a = inflate;
        this.b = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0905b5);
        this.c = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092502);
        this.g = (AlaVideoContainer) this.a.findViewById(R.id.obfuscated_res_0x7f090246);
        this.f = this.a.findViewById(R.id.divider_below_reply_number_layout);
        this.e = (ThreadCommentAndPraiseInfoLayout) this.a.findViewById(R.id.text_bottom);
        this.h = this.a.findViewById(R.id.obfuscated_res_0x7f090905);
        this.b.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.e.getCommentContainer().setOnClickListener(this);
        this.g.setOnVideoClickListener(this);
    }

    public void f(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, threadData, str) == null) && threadData != null && threadData.getAuthor() != null) {
            this.i = threadData;
            this.j = str;
            this.b.setVisibility(0);
            this.c.j(threadData);
            if (this.c.getHeaderImg() != null) {
                this.c.getHeaderImg().setData(threadData);
            }
            this.c.setUserAfterClickListener(this.l);
            threadData.parserSpecTitleForFrsAndPb(false, true);
            this.d.setText(threadData.getSpan_str());
            this.g.getController().d(threadData, str, "", false);
            this.g.getController().c();
            this.e.setReplyTimeVisible(false);
            this.e.setNeedAddReplyIcon(true);
            this.e.setIsBarViewVisible(false);
            this.e.setCommentNumEnable(false);
            this.e.setOnClickListener(this);
            this.e.setLiveShareEnable(false);
            this.e.setShareVisible(true);
            this.e.setShowPraiseNum(true);
            this.e.setNeedAddPraiseIcon(true);
            this.e.setFrom(2);
            if (this.e.setData(threadData)) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
            }
            d(threadData);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) && bdUniqueId != null && this.e != null && (threadUserInfoLayout = this.c) != null) {
            threadUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
    }

    public void h(sf6 sf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sf6Var) == null) {
            this.k = sf6Var;
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void e() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (threadData = this.i) != null && threadData.getAuthor() != null) {
            f(this.i, this.j);
        }
    }

    public final void d(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            this.e.onChangeSkinType();
            this.c.h();
            this.g.o(TbadkCoreApplication.getInst().getSkinType());
            this.b.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
            if (threadData != null && xo6.k(threadData.getId())) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        sf6 sf6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2 != this.b && view2 != this.e.getCommentContainer()) {
                if (view2.getId() == R.id.video_container && (sf6Var = this.k) != null) {
                    sf6Var.a(view2, this.i);
                    return;
                }
                return;
            }
            ThreadData threadData = this.i;
            if (threadData != null) {
                xo6.a(threadData.getId());
            }
            sf6 sf6Var2 = this.k;
            if (sf6Var2 != null) {
                sf6Var2.a(view2, this.i);
            }
        }
    }
}
