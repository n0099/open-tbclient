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
import com.baidu.tieba.m45;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zna extends ph5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel b;
    public qsa c;
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
        public final /* synthetic */ zna a;

        public a(zna znaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {znaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = znaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) != null) || this.a.b == null) {
                return;
            }
            if (this.a.b() != null) {
                this.a.b().q();
            }
            if (this.a.j != null) {
                this.a.j.a(false);
            }
            if (writeData == null) {
                writeData = this.a.b.d0();
            }
            WriteData writeData2 = writeData;
            if (z) {
                String str2 = null;
                this.a.c.n(null);
                this.a.c.i(null);
                this.a.c.k(false);
                this.a.r();
                this.a.q();
                if (writeData2 != null) {
                    String string = this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1221);
                    if (postWriteCallBackData != null) {
                        str2 = postWriteCallBackData.getPreMsg();
                        String colorMsg = postWriteCallBackData.getColorMsg();
                        String errorString = postWriteCallBackData.getErrorString();
                        str = colorMsg;
                        string = errorString;
                    } else {
                        str = null;
                    }
                    wda.b(this.a.getContext().getPageActivity(), string, str2, str);
                }
            } else if (writeData2 != null && jd5Var != null && !TextUtils.isEmpty(jd5Var.d())) {
                writeData2.setVcodeMD5(jd5Var.b());
                writeData2.setVcodeUrl(jd5Var.c());
                writeData2.setVcodeExtra(jd5Var.a());
                if (VcodeTool.needVcode(jd5Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.e.getPageActivity(), 12006, writeData2, false, jd5Var.d())));
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
                    this.a.A(postWriteCallBackData.getErrorString());
                    return;
                }
                this.a.x(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
            } else {
                this.a.A(postWriteCallBackData.getErrorString());
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
    public class b implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(zna znaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {znaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zna a;

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

        public c(zna znaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {znaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = znaVar;
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
    public zna(EditorTools editorTools) {
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
        editorTools.F(true);
        qsa qsaVar = new qsa();
        this.c = qsaVar;
        qsaVar.h(R.color.cp_cont_h_alpha85);
        this.c.j(R.color.CAM_X0101);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.e != null && !StringUtils.isNull(str)) {
            this.e.showToast(str);
        }
    }

    public void s(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.e = tbPageContext;
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.d = str;
        }
    }

    public void w(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, videoItemData) == null) {
            this.i = videoItemData;
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public void o() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (newWriteModel = this.b) != null) {
            newWriteModel.cancelLoadData();
        }
    }

    public final void q() {
        NewWriteModel newWriteModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (newWriteModel = this.b) == null) {
            return;
        }
        newWriteModel.setWriteData(null);
        this.b.j0(false);
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13026");
            statisticItem.param("tid", this.f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.g);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && b() != null && (b().p(28) instanceof boa) && ((boa) b().p(28)).g() != null && ((boa) b().p(28)).g().getText() != null) {
            EditText g = ((boa) b().p(28)).g();
            int selectionEnd = g.getSelectionEnd();
            SpannableStringBuilder f = this.c.f(g.getText());
            if (f != null) {
                boolean z2 = true;
                this.c.l(true);
                g.setText(f);
                if (z && this.c.b() >= 0) {
                    g.requestFocus();
                    g.setSelection(this.c.b());
                } else {
                    g.setSelection(selectionEnd);
                }
                qsa qsaVar = this.c;
                if (qsaVar.b() < 0) {
                    z2 = false;
                }
                qsaVar.k(z2);
            }
        }
    }

    public void n(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) && i == 12006) {
            if (i2 == 0) {
                PostWriteCallBackData postWriteCallBackData = null;
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                this.k.callback(false, postWriteCallBackData, null, this.b.d0(), null);
            } else if (i2 == -1) {
                r();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.b == null) {
                NewWriteModel newWriteModel = new NewWriteModel(this.e);
                this.b = newWriteModel;
                newWriteModel.l0(this.k);
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
            this.b.o0();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (b() != null) {
                b().D(new lh5(9, -1, Boolean.TRUE));
                b().D(new lh5(4, -1, ""));
                b().q();
            }
            d dVar = this.j;
            if (dVar != null) {
                dVar.a(true);
            }
        }
    }

    public void t(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, str, str2, str3, str4) == null) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            if (b() != null && (b().p(28) instanceof boa) && ((boa) b().p(28)).g() != null) {
                EditText g = ((boa) b().p(28)).g();
                g.removeTextChangedListener(this.l);
                g.addTextChangedListener(this.l);
                g.setText(str4);
            }
        }
    }

    public final void x(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                AntiHelper.w(this.e.getPageActivity(), str, i, null);
            } else if (i != 230277 && i != 230278) {
                A(str);
            } else {
                y(str);
            }
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            m45 m45Var = new m45(getContext().getPageActivity());
            m45Var.setMessage(str);
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3e, new b(this));
            m45Var.create(getContext()).show();
        }
    }
}
