package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zu7 extends yu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext s0;
    public TextView t0;
    public EntelechyUserLikeButton u0;
    public w65 v0;
    public int w0;
    public ThreadData x0;
    public CommonUserLikeButton.a y0;
    public View.OnClickListener z0;

    /* loaded from: classes9.dex */
    public class a implements CommonUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu7 a;

        public a(zu7 zu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zu7Var;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.k0(i);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu7 a;

        public b(zu7 zu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zu7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.x0 != null && this.a.x0.getAuthor() != null && !StringUtils.isNull(this.a.x0.getAuthor().getName_show()) && !StringUtils.isNull(this.a.x0.getAuthor().getUserId()) && this.a.x0.getForum_name() != null) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.s0.getPageActivity(), this.a.x0.getAuthor().getUserId(), this.a.x0.getAuthor().getName_show(), this.a.x0.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                if (this.a.x0.getThreadVideoInfo() != null) {
                    z = true;
                } else {
                    z = false;
                }
                personInfoActivityConfig.setIsVideoThread(z);
                personInfoActivityConfig.setVideoPersonFrom("frs");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.w0 = 3;
        this.y0 = new a(this);
        this.z0 = new b(this);
        this.s0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.t0 = textView;
        textView.setIncludeFontPadding(false);
        this.t0.setTextSize(0, BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070400);
        this.t0.setLayoutParams(layoutParams);
        this.t0.setOnClickListener(this.z0);
        this.q.addView(this.t0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.u0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.y0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f0703f7));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.header_divider);
        layoutParams2.rightMargin = BdUtilHelper.getDimens(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
        layoutParams2.topMargin = BdUtilHelper.getDimens(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8);
        this.u0.setLayoutParams(layoutParams2);
        ((ViewGroup) i()).addView(this.u0);
        w65 w65Var = new w65(tbPageContext, this.u0);
        this.v0 = w65Var;
        w65Var.l("1");
        this.v0.k(bdUniqueId);
    }

    @Override // com.baidu.tieba.yu7, com.baidu.tieba.yk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            super.l(tbPageContext, i);
            if (this.w0 != i) {
                SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0109);
                this.u0.g(i);
            }
            this.w0 = i;
        }
    }

    @Override // com.baidu.tieba.yu7
    public void X(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.X(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yu7, com.baidu.tieba.yk6
    /* renamed from: V */
    public void k(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            super.k(threadData);
            if (threadData == null) {
                return;
            }
            this.x0 = threadData;
            if (threadData.getAuthor() != null) {
                this.v0.m(threadData.getAuthor());
                k0(threadData.getAuthor().getFansNum());
                if (!this.x0.isGodThread()) {
                    this.u0.setVisibility(8);
                } else if (this.x0.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.x0.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.u0.setVisibility(8);
                    return;
                } else if (this.x0.getAuthor().getGodUserData() != null && this.x0.getAuthor().getGodUserData().getIsLike()) {
                    if (this.x0.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.u0.setVisibility(8);
                    } else {
                        this.u0.setVisibility(0);
                        this.u0.d(true, 1);
                    }
                } else {
                    this.u0.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u0.getLayoutParams();
            if (threadData.getSkinInfoData() != null) {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f070224) + i;
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.s0.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8);
            }
        }
    }

    public final void k0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.t0 == null) {
            return;
        }
        String string = this.s0.getResources().getString(R.string.fans_default_name_god_user);
        ThreadData threadData = this.x0;
        if (threadData != null && !StringUtils.isNull(threadData.getForum_name()) && this.x0.getForum_name().equals(this.a0)) {
            if (this.x0.isGodThread()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i));
                this.t0.setVisibility(0);
                this.t0.setText(format);
                return;
            }
            this.t0.setVisibility(8);
            return;
        }
        this.t0.setText(this.s0.getResources().getString(R.string.default_personalized_name));
    }
}
