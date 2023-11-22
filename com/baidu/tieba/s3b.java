package com.baidu.tieba;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class s3b extends ce5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel b;
    public t8b c;
    public String d;
    public TbPageContext<?> e;
    public String f;
    public String g;
    public String h;
    public VideoItemData i;
    public d j;
    public final NewWriteModel.d k;
    public TextWatcher l;

    /* loaded from: classes8.dex */
    public interface d {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s3b a;

        public a(s3b s3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s3bVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h95 h95Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, h95Var, writeData, antiData}) != null) || this.a.b == null) {
                return;
            }
            if (this.a.a() != null) {
                this.a.a().v();
            }
            if (this.a.j != null) {
                this.a.j.a(false);
            }
            if (writeData == null) {
                writeData = this.a.b.e0();
            }
            WriteData writeData2 = writeData;
            if (z) {
                String str2 = null;
                this.a.c.n(null);
                this.a.c.i(null);
                this.a.c.k(false);
                this.a.s();
                this.a.r();
                if (writeData2 != null) {
                    String string = this.a.m().getResources().getString(R.string.obfuscated_res_0x7f0f126a);
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        String colorMsg = postWriteCallBackData.getColorMsg();
                        String errorString = postWriteCallBackData.getErrorString();
                        str = colorMsg;
                        string = errorString;
                    } else {
                        str = null;
                    }
                    aua.b(this.a.m().getPageActivity(), string, str2, str);
                }
            } else if (writeData2 != null && h95Var != null && !TextUtils.isEmpty(h95Var.d())) {
                writeData2.setVcodeMD5(h95Var.b());
                writeData2.setVcodeUrl(h95Var.c());
                writeData2.setVcodeExtra(h95Var.a());
                if (VcodeTool.needVcode(h95Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.e.getPageActivity(), 12006, writeData2, false, h95Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.e.getPageActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.e.getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 220015) {
                if (postWriteCallBackData == null || (postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278 && postWriteCallBackData.getErrorCode() != 340016 && postWriteCallBackData.getErrorCode() != 1990032 && !AntiHelper.l(postWriteCallBackData.getErrorCode()))) {
                    if (postWriteCallBackData == null) {
                        return;
                    }
                    this.a.B(postWriteCallBackData.getErrorString());
                    return;
                }
                this.a.y(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
            } else {
                this.a.B(postWriteCallBackData.getErrorString());
                this.a.c.i(postWriteCallBackData.getSensitiveWords());
                this.a.c.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(this.a.c.a())) {
                    return;
                }
                this.a.l(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(s3b s3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s3b a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public c(s3b s3bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s3bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s3bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || this.a.c == null) {
                return;
            }
            if (!this.a.c.e()) {
                this.a.l(false);
            }
            this.a.c.l(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s3b(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.f = null;
        this.k = new a(this);
        this.l = new c(this);
        editorTools.M(true);
        t8b t8bVar = new t8b();
        this.c = t8bVar;
        t8bVar.h(R.color.cp_cont_h_alpha85);
        this.c.j(R.color.CAM_X0101);
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.e != null && !StringUtils.isNull(str)) {
            this.e.showToast(str);
        }
    }

    public void t(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.e = tbPageContext;
        }
    }

    public void v(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.d = str;
        }
    }

    public void x(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoItemData) == null) {
            this.i = videoItemData;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13026");
            statisticItem.param("tid", this.f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.g);
            TiebaStatic.log(statisticItem);
        }
    }

    public TbPageContext<?> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public void p() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (newWriteModel = this.b) != null) {
            newWriteModel.cancelLoadData();
        }
    }

    public final void r() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (newWriteModel = this.b) == null) {
            return;
        }
        newWriteModel.setWriteData(null);
        this.b.k0(false);
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && a() != null && (a().u(28) instanceof u3b) && ((u3b) a().u(28)).i() != null && ((u3b) a().u(28)).i().getText() != null) {
            EditText i = ((u3b) a().u(28)).i();
            int selectionEnd = i.getSelectionEnd();
            SpannableStringBuilder f = this.c.f(i.getText());
            if (f != null) {
                boolean z2 = true;
                this.c.l(true);
                i.setText(f);
                if (z && this.c.b() >= 0) {
                    i.requestFocus();
                    i.setSelection(this.c.b());
                } else {
                    i.setSelection(selectionEnd);
                }
                t8b t8bVar = this.c;
                if (t8bVar.b() < 0) {
                    z2 = false;
                }
                t8bVar.k(z2);
            }
        }
    }

    public void o(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) && i == 12006) {
            if (i2 == 0) {
                PostWriteCallBackData postWriteCallBackData = null;
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                this.k.callback(false, postWriteCallBackData, null, this.b.e0(), null);
            } else if (i2 == -1) {
                s();
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.b == null) {
                NewWriteModel newWriteModel = new NewWriteModel(this.e);
                this.b = newWriteModel;
                newWriteModel.m0(this.k);
            }
            WriteData writeData = new WriteData();
            writeData.setType(1);
            writeData.setThreadId(this.f);
            writeData.setForumId(this.g);
            writeData.setForumName(this.h);
            writeData.setContent(this.d);
            VideoItemData videoItemData = this.i;
            if (videoItemData != null && videoItemData.baijiahaoData != null) {
                writeData.setIsBJHPost(true);
                writeData.setBaijiahaoData(this.i.baijiahaoData);
            }
            this.b.setWriteData(writeData);
            this.b.p0();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (a() != null) {
                a().K(new yd5(9, -1, Boolean.TRUE));
                a().K(new yd5(4, -1, ""));
                a().v();
            }
            d dVar = this.j;
            if (dVar != null) {
                dVar.a(true);
            }
        }
    }

    public void u(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, str3, str4) == null) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            if (a() != null && (a().u(28) instanceof u3b) && ((u3b) a().u(28)).i() != null) {
                EditText i = ((u3b) a().u(28)).i();
                i.removeTextChangedListener(this.l);
                i.addTextChangedListener(this.l);
                i.setText(str4);
            }
        }
    }

    public final void y(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                AntiHelper.w(this.e.getPageActivity(), str, i, null);
            } else if (i != 230277 && i != 230278) {
                B(str);
            } else {
                z(str);
            }
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            zz4 zz4Var = new zz4(m().getPageActivity());
            zz4Var.setMessage(str);
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b79, new b(this));
            zz4Var.create(m()).show();
        }
    }
}
