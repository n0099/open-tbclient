package com.baidu.tieba;

import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.d55;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ska {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final xha b;
    @NonNull
    public final uka c;
    @Nullable
    public EditText d;
    @Nullable
    public EditText e;
    public final Runnable f;
    public final NewWriteModel.d g;

    /* loaded from: classes7.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ska a;

        /* loaded from: classes7.dex */
        public class a implements d55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.d55.e
            public void onClick(d55 d55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                    d55Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.ska$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0444b implements d55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0444b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
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
            }

            @Override // com.baidu.tieba.d55.e
            public void onClick(d55 d55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                    d55Var.dismiss();
                    this.a.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.a.getPageActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public b(ska skaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {skaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = skaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) != null) || postWriteCallBackData == null) {
                return;
            }
            this.a.b.m(null);
            if (z) {
                return;
            }
            if (postWriteCallBackData.isSensitiveError()) {
                this.a.b.n(postWriteCallBackData.getErrorString());
                this.a.b.m(postWriteCallBackData.getSensitiveWords());
                this.a.b.h(this.a.d, this.a.e);
            } else if (postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (this.a.a.getPageActivity() == null) {
                    return;
                }
                if (vi.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(this.a.a.getPageActivity(), this.a.a.getPageActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(this.a.a.getPageActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                if (this.a.a.getPageActivity() == null) {
                    return;
                }
                d55 d55Var = new d55(this.a.a.getPageActivity());
                if (vi.isEmpty(postWriteCallBackData.getErrorString())) {
                    d55Var.setMessage(this.a.a.getPageActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    d55Var.setMessage(postWriteCallBackData.getErrorString());
                }
                d55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ca, new a(this));
                d55Var.setPositiveButton(R.string.open_now, new C0444b(this));
                d55Var.create(this.a.a).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
            } else if ((ae5Var == null || writeData == null || ae5Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && !s7a.d(postWriteCallBackData.getErrorCode())) {
                this.a.c.b(postWriteCallBackData);
            } else if (ae5Var != null && writeData != null && ae5Var.c() != null) {
                if (writeData.isCanNoForum()) {
                    writeData.setForumName("");
                    writeData.setForumId("0");
                }
                writeData.setVcodeMD5(ae5Var.b());
                writeData.setVcodeUrl(ae5Var.c());
                writeData.setVcodeExtra(ae5Var.a());
                if (my5.b(ae5Var.d())) {
                    this.a.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageActivity(), 12006, writeData, false, ae5Var.d())));
                } else {
                    this.a.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageActivity(), writeData, 12006)));
                }
            } else if (postWriteCallBackData.getErrorCode() == 227001) {
                this.a.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ska a;

        public a(ska skaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {skaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = skaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.callback(false, z1a.d, z1a.e, z1a.f, z1a.g);
            }
        }
    }

    public ska(@NonNull TbPageContext<?> tbPageContext, @NonNull xha xhaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xhaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.g = new b(this);
        this.a = tbPageContext;
        this.b = xhaVar;
        this.c = new uka(tbPageContext);
    }

    public void i(@Nullable EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editText) == null) {
            this.e = editText;
        }
    }

    public void j(@Nullable EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editText) == null) {
            this.d = editText;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xg.a().removeCallbacks(this.f);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xg.a().postDelayed(this.f, 500L);
        }
    }
}
