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
import com.baidu.tieba.nu4;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final m39 b;
    @NonNull
    public final y59 c;
    @Nullable
    public EditText d;
    @Nullable
    public EditText e;
    public final Runnable f;
    public final NewWriteModel.d g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w59 a;

        public a(w59 w59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w59Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.callback(false, gp8.d, gp8.e, gp8.f, gp8.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w59 a;

        /* loaded from: classes6.dex */
        public class a implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.w59$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0453b implements nu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0453b(b bVar) {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                    this.a.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.a.getPageActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public b(w59 w59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w59Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) || postWriteCallBackData == null) {
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
                if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.t(this.a.a.getPageActivity(), this.a.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                } else {
                    DefaultNavigationBarCoverTip.t(this.a.a.getPageActivity(), postWriteCallBackData.getErrorString(), null).v();
                }
            } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                if (this.a.a.getPageActivity() == null) {
                    return;
                }
                nu4 nu4Var = new nu4(this.a.a.getPageActivity());
                if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                    nu4Var.setMessage(this.a.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                } else {
                    nu4Var.setMessage(postWriteCallBackData.getErrorString());
                }
                nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new a(this));
                nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new C0453b(this));
                nu4Var.create(this.a.a).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
            } else if ((y15Var == null || writeData == null || y15Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && !hu8.d(postWriteCallBackData.getErrorCode())) {
                this.a.c.b(postWriteCallBackData);
            } else if (y15Var != null && writeData != null && y15Var.c() != null) {
                if (writeData.isCanNoForum()) {
                    writeData.setForumName("");
                    writeData.setForumId("0");
                }
                writeData.setVcodeMD5(y15Var.b());
                writeData.setVcodeUrl(y15Var.c());
                writeData.setVcodeExtra(y15Var.a());
                if (vi5.b(y15Var.d())) {
                    this.a.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageActivity(), 12006, writeData, false, y15Var.d())));
                } else {
                    this.a.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageActivity(), writeData, 12006)));
                }
            } else if (postWriteCallBackData.getErrorCode() == 227001) {
                this.a.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }

    public w59(@NonNull TbPageContext<?> tbPageContext, @NonNull m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, m39Var};
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
        this.b = m39Var;
        this.c = new y59(tbPageContext);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gh.a().removeCallbacks(this.f);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gh.a().postDelayed(this.f, 500L);
        }
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
}
