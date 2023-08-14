package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.vaa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class qj5 extends ph5 implements vaa.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public EditorTools B;
    public boolean C;
    public final NewWriteModel.d D;
    public final h9 E;
    public WriteImagesInfo b;
    public String c;
    public SpanGroupManager d;
    public VoiceData.VoiceModel e;
    public String f;
    public NewWriteModel g;
    public ImageModel h;
    public DataModel<?> i;
    public ForumData j;
    public ThreadData k;
    public String l;
    public TbPageContext m;
    public String n;
    public String o;
    public String p;
    public long q;
    public String r;
    public VideoInfo s;
    public boolean t;
    public NewWriteModel.d u;
    public nj5 v;
    public mj5 w;
    public boolean x;
    public TextWatcher y;
    public PbNewEditorTool z;

    /* loaded from: classes7.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj5 a;

        public a(qj5 qj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj5Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.g.d0();
                }
                if (z) {
                    this.a.S(true);
                    WriteData d0 = this.a.g.d0();
                    this.a.M();
                    vaa.z(this.a.l, null);
                    if (d0 == null) {
                        return;
                    }
                    if (d0.getType() == 2) {
                        vaa.p(d0.getThreadId(), this.a);
                    }
                } else if (writeData != null && jd5Var != null && !TextUtils.isEmpty(jd5Var.d())) {
                    writeData.setVcodeMD5(jd5Var.b());
                    writeData.setVcodeUrl(jd5Var.c());
                    writeData.setVcodeExtra(jd5Var.a());
                    if (this.a.k != null) {
                        writeData.setBaijiahaoData(this.a.k.getBaijiahaoData());
                    }
                    if (VcodeTool.needVcode(jd5Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.m.getPageActivity(), 12006, writeData, false, jd5Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.m.getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.m.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
                qj5 qj5Var = this.a;
                qj5Var.C(qj5Var.g.d0());
                NewWriteModel.d dVar = this.a.u;
                if (dVar != null) {
                    dVar.callback(z, postWriteCallBackData, jd5Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj5 a;

        public b(qj5 qj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.f));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj5 a;

        public c(qj5 qj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj5Var;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.g.j0(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj5(EditorTools editorTools) {
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
        this.b = new WriteImagesInfo();
        this.c = "";
        this.g = null;
        this.h = null;
        this.l = null;
        this.n = null;
        this.x = false;
        this.A = 0;
        this.D = new a(this);
        this.E = new c(this);
        this.B = editorTools;
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && b() != null) {
            if (z) {
                b().D(new lh5(2, 10, null));
                b().D(new lh5(2, 6, null));
            }
            b().D(new lh5(9, -1, Boolean.valueOf(z)));
        }
    }

    public void l0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, threadData) == null) {
            this.k = threadData;
            if (b() != null && this.k != null) {
                b().setFid(this.k.getFid());
                b().setTid(this.k.getTid());
                b().D(new lh5(70, -1, String.valueOf(this.k.getFid())));
            }
        }
    }

    public void J(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, forumData, userData) == null) {
            this.j = forumData;
        }
    }

    public final void t(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048633, this, intent, z) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.b.parseJson(stringExtra);
            this.b.updateQuality();
            if (this.b.getChosedFiles() != null) {
                w(false, null);
            }
        }
    }

    public void G(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null) {
                bundle.putString("write_images", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.f);
        }
    }

    public void I(AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, antiData) == null) && antiData != null) {
            this.n = antiData.getVoice_message();
        }
    }

    public final void P(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) && b() != null) {
            b().D(new lh5(17, 27, arrayList));
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && b() != null) {
            b().D(new lh5(44, 27, str));
        }
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && b() != null) {
            b().D(new lh5(6, 27, str));
        }
    }

    public void W(mj5 mj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mj5Var) == null) {
            this.w = mj5Var;
        }
    }

    public void X(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, tbPageContext) == null) {
            this.m = tbPageContext;
        }
    }

    public void Y(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && b() != null && (bLauncher = (BLauncher) b().o(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.A = i;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.x = z;
        }
    }

    public void b0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && b() != null && (bLauncher = (BLauncher) b().o(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void c0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, dataModel) == null) {
            this.i = dataModel;
        }
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            if (this.z == null && b() != null) {
                this.z = (PbNewEditorTool) b().p(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.n(str);
            }
        }
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (this.z == null && b() != null) {
                this.z = (PbNewEditorTool) b().p(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.o(i);
            }
        }
    }

    public void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.c = str;
        }
    }

    public void g(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, textWatcher) == null) {
            i();
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null && textWatcher != null) {
                pbNewEditorTool.g(textWatcher);
            }
        }
    }

    public void g0(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, dVar) == null) {
            this.u = dVar;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            if (this.z == null && b() != null) {
                this.z = (PbNewEditorTool) b().p(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.h(i);
            }
        }
    }

    public void h0(nj5 nj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, nj5Var) == null) {
            this.v = nj5Var;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.C = z;
        }
    }

    public void j0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && b() != null && (bLauncher = (BLauncher) b().o(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void k0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, spanGroupManager) == null) {
            this.d = spanGroupManager;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.l = str;
        }
    }

    public void n0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, voiceModel) == null) {
            this.e = voiceModel;
        }
    }

    public final void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, intent) == null) {
            t(intent, true);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            vaa.p(str, this);
        }
    }

    public final void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, intent) == null) {
            t(intent, false);
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel == null || TextUtils.isEmpty(voiceModel.getVoiceId()) || this.e.getDuration() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g.cancelLoadData();
            this.h.cancelLoadData();
            this.g.m0(null);
            b().s(27);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.z == null && b() != null) {
                this.z = (PbNewEditorTool) b().p(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.j();
            }
        }
    }

    public void L() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (editorTools = this.B) != null) {
            editorTools.B();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g.setWriteData(null);
            this.g.j0(false);
            this.e = null;
            this.s = null;
            this.b.clear();
        }
    }

    public void N() {
        PbNewEditorTool pbNewEditorTool;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (pbNewEditorTool = this.z) != null && (textWatcher = this.y) != null) {
            pbNewEditorTool.k(textWatcher);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && b() != null) {
            b().D(new lh5(13, -1, null));
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && b() != null) {
            b().D(new lh5(2, 19, " "));
        }
    }

    public TbPageContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.m;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.z == null && b() != null) {
            this.z = (PbNewEditorTool) b().p(27);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.s = null;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            new b(this).execute(new Void[0]);
        }
    }

    public PbNewEditorTool s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.z == null && b() != null) {
                this.z = (PbNewEditorTool) b().p(27);
            }
            return this.z;
        }
        return (PbNewEditorTool) invokeV.objValue;
    }

    public SpanGroupManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.d;
        }
        return (SpanGroupManager) invokeV.objValue;
    }

    public WriteImagesInfo v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.b;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public void x() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            String str2 = this.c;
            ThreadData threadData = this.k;
            if (threadData != null) {
                str = String.valueOf(threadData.getFid());
            } else {
                str = "";
            }
            qh5.e(str2, str);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B(TbPageContext tbPageContext, Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.g = newWriteModel;
            newWriteModel.l0(this.D);
            ImageModel imageModel = new ImageModel(tbPageContext);
            this.h = imageModel;
            imageModel.setLoadDataCallBack(this.E);
            if (bundle != null) {
                this.b.parseJson(bundle.getString("write_images"));
                this.f = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null) {
                if (this.t) {
                    i = 1;
                } else {
                    i = 9;
                }
                writeImagesInfo.setMaxImagesAllowed(i);
            }
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && b() != null) {
                b().D(new lh5(2, 12, " "));
            }
            WriteImagesInfo writeImagesInfo2 = this.b;
            if (writeImagesInfo2 != null && writeImagesInfo2.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools b2 = b();
                b2.D(new lh5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
    }

    public void w(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048636, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(0);
            pbEditorData.setContent(this.c);
            pbEditorData.setWriteImagesInfo(this.b);
            pbEditorData.setVoiceModel(this.e);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.j;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.j.getName());
                threadData.setFirstDir(this.j.getFirst_class());
                threadData.setSecondDir(this.j.getSecond_class());
            }
            threadData.setAuthorId(this.q);
            threadData.setAuthorName(this.o);
            threadData.setAuthorNameShow(this.p);
            threadData.setPostId(this.r);
            threadData.setThreadId(this.l);
            threadData.isBJH = this.t;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.n);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.m.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public void C(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) != null) || writeData == null) {
            return;
        }
        this.b = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools b2 = b();
                b2.D(new lh5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            b().D(new lh5(2, 10, null));
        }
        String content = writeData.getContent();
        this.c = content;
        U(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void n(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048625, this, writeData) != null) || writeData == null) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i2 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i2++;
            }
            if (i2 > 0 && this.A > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_source", this.A);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() != null && !ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                if (imageFileInfo.getImageType() == 1) {
                    i++;
                }
            }
            if (i > 0 && this.A > 0) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
                statisticItem2.param("obj_type", i);
                statisticItem2.param("obj_source", this.A);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, intent) == null) {
            this.f = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.f;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, BdUtilHelper.dip2px(this.m.getPageActivity(), BdUtilHelper.getEquipmentWidth(this.m.getPageActivity())), BdUtilHelper.dip2px(this.m.getPageActivity(), BdUtilHelper.getEquipmentHeight(this.m.getPageActivity())));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.f, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception unused) {
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                this.b.addChooseFile(imageFileInfo);
                this.b.updateQuality();
                w(false, null);
            }
        }
    }

    public void D(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData2 = null;
            if (i2 == -1) {
                if (i != 11001) {
                    if (i != 12006) {
                        if (i != 12012) {
                            if (i != 13010) {
                                if (i != 23004) {
                                    if (i != 25004) {
                                        if (i != 11025) {
                                            if (i != 11026) {
                                                if (i != 12009 && i != 12010) {
                                                    switch (i) {
                                                        case TaskResponseData.ERROR_NO_TASK_OFFLINE_03 /* 12002 */:
                                                            if (intent == null) {
                                                                return;
                                                            }
                                                            if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                                                                p(intent);
                                                            } else {
                                                                o(intent);
                                                            }
                                                            b().invalidate();
                                                            return;
                                                        case 12003:
                                                            if (intent == null) {
                                                                return;
                                                            }
                                                            if (intent.getBooleanExtra("delete", false)) {
                                                                R();
                                                                this.g.j0(false);
                                                                return;
                                                            }
                                                            this.h.S(intent.getStringExtra("file_name"));
                                                            return;
                                                        case 12004:
                                                            if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) != null) {
                                                                P(parcelableArrayListExtra);
                                                                return;
                                                            }
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                                } else if (i == 12010) {
                                                    p(intent);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.m.getPageActivity(), 12005, true);
                                            if (u() != null) {
                                                atListActivityConfig.setSelectedAtList(u().w());
                                            }
                                            ThreadData threadData = this.k;
                                            if (threadData != null) {
                                                atListActivityConfig.setFromTid(threadData.getTid());
                                                atListActivityConfig.setFromFid(String.valueOf(this.k.getFid()));
                                            }
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                                            ThreadData threadData2 = this.k;
                                            if (threadData2 != null) {
                                                statisticItem.addParam("tid", threadData2.getTid());
                                                statisticItem.addParam("fid", this.k.getFid());
                                            }
                                            TiebaStatic.log(statisticItem);
                                            return;
                                        }
                                        AtListActivityConfig atListActivityConfig2 = new AtListActivityConfig(this.m.getPageActivity(), 12004, true);
                                        if (u() != null) {
                                            atListActivityConfig2.setSelectedAtList(u().w());
                                        }
                                        ThreadData threadData3 = this.k;
                                        if (threadData3 != null) {
                                            atListActivityConfig2.setFromTid(threadData3.getTid());
                                            atListActivityConfig2.setFromFid(String.valueOf(this.k.getFid()));
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig2));
                                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                                        statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                                        ThreadData threadData4 = this.k;
                                        if (threadData4 != null) {
                                            statisticItem2.addParam("tid", threadData4.getTid());
                                            statisticItem2.addParam("fid", this.k.getFid());
                                        }
                                        TiebaStatic.log(statisticItem2);
                                        return;
                                    } else if (intent != null) {
                                        Q(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                                return;
                            } else if (b() == null) {
                                return;
                            } else {
                                VideoInfo videoInfo = new VideoInfo();
                                videoInfo.parseFromIntent(intent);
                                if (videoInfo.isAvaliable()) {
                                    this.s = videoInfo;
                                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.XIAOYING_DURATION);
                                    statisticItem3.param("duration", this.s.getVideoDuration());
                                    TiebaStatic.log(statisticItem3);
                                    V();
                                    b().D(new lh5(28, 20, this.s));
                                    b().D(new lh5(28, -1, this.s));
                                    return;
                                }
                                return;
                            }
                        }
                        r(intent);
                        return;
                    }
                    WriteData d0 = this.g.d0();
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } else {
                        postWriteCallBackData = null;
                    }
                    if (d0 != null) {
                        d0.deleteUploadedTempImages();
                    }
                    this.g.setWriteData(null);
                    this.g.j0(false);
                    this.e = null;
                    this.s = null;
                    if (!TextUtils.isEmpty(this.l)) {
                        vaa.z(this.l, null);
                    }
                    S(true);
                    NewWriteModel.d dVar = this.u;
                    if (dVar != null) {
                        dVar.callback(true, postWriteCallBackData, null, d0, null);
                        return;
                    }
                    return;
                }
                H(null, null);
            } else if (i != 12001) {
                if (i != 12002) {
                    if (i == 12006) {
                        if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        }
                        PostWriteCallBackData postWriteCallBackData3 = postWriteCallBackData2;
                        NewWriteModel.d dVar2 = this.u;
                        if (dVar2 != null) {
                            dVar2.callback(false, postWriteCallBackData3, null, this.g.d0(), null);
                        }
                    }
                } else if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.b.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                }
            } else {
                l();
            }
        }
    }

    public void H(String str, WriteData writeData) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, writeData) == null) {
            if (this.g.d0() == null) {
                WriteData U = this.i.U(str);
                if (U != null && (threadData = this.k) != null) {
                    U.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.g.setWriteData(U);
            }
            boolean z = true;
            if (this.g.d0() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            this.g.d0().setBotConfig(BotEntranceManager.h().i());
            this.g.d0().setShowCustomFigure(this.C);
            if (oj5.a()) {
                this.g.d0().setShowBless(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reply_add_bless_enable"), true));
            }
            if (this.x) {
                this.g.d0().setCanNoForum(true);
                if (this.j != null) {
                    this.g.d0().setVForumId(this.j.getId());
                    this.g.d0().setVForumName(this.j.getName());
                }
            } else {
                this.g.d0().setCanNoForum(false);
                this.g.d0().setVForumId("");
                this.g.d0().setVForumName("");
            }
            this.g.d0().setIsBJHPost(this.t);
            this.g.d0().setWriteImagesInfo(this.b);
            this.g.d0().setVideoInfo(this.s);
            NewWriteModel newWriteModel = this.g;
            if (this.b.size() <= 0) {
                z = false;
            }
            newWriteModel.j0(z);
            if (str == null) {
                this.g.d0().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            int i = -1;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.g.d0().setVoice(this.e.getId());
                    this.g.d0().setVoiceDuringTime(this.e.getDuration());
                } else {
                    this.g.d0().setVoice(null);
                    this.g.d0().setVoiceDuringTime(-1);
                }
            } else {
                this.g.d0().setVoice(null);
                this.g.d0().setVoiceDuringTime(-1);
            }
            if (!this.g.b0()) {
                this.m.showToast(R.string.write_img_limit);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12);
                if (this.g.d0() != null) {
                    i = this.g.d0().getType();
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            mj5 mj5Var = this.w;
            if (mj5Var != null && mj5Var.a()) {
                StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13);
                if (this.g.d0() != null) {
                    i = this.g.d0().getType();
                }
                TiebaStatic.log(param2.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            nj5 nj5Var = this.v;
            if (nj5Var != null) {
                nj5Var.a();
            }
            n(this.g.d0());
            m();
            this.g.d0().onPostDataParse(this.d);
            if (!this.g.o0()) {
            }
        }
    }

    public void K(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, metaData, str, str2) == null) && b() != null && metaData != null) {
            this.q = metaData.getUserIdLong();
            this.o = metaData.getUserName();
            this.p = metaData.getName_show();
            this.l = str;
            this.r = str2;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            WriteData d0 = this.g.d0();
            if (d0 == null) {
                d0 = new WriteData(1);
                d0.setThreadId(str);
                d0.setWriteImagesInfo(this.b);
            }
            d0.onSaveDrafDataParse(this.d);
            d0.setContent(this.c);
            d0.setVideoInfo(this.s);
            d0.setVoiceModel(this.e);
            vaa.z(str, d0);
        }
    }

    public void f(nc5 nc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, nc5Var) == null) && nc5Var != null && EmotionGroupType.isSendAsPic(nc5Var.getType())) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(nc5Var.d());
            imageFileInfo.width = nc5Var.h();
            imageFileInfo.height = nc5Var.b();
            this.b.addChooseFile(imageFileInfo);
            this.b.updateQuality();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && !StringUtils.isNull(this.o)) {
            long j = this.q;
            if (j > 0) {
                if (String.valueOf(j).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(this.m.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.m.getPageActivity(), this.q, this.o, this.p, GiftTabActivityConfig.FROM_PB, JavaTypesHelper.toLong(this.l, 0L), JavaTypesHelper.toLong(this.r, 0L))));
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.b.clear();
            }
            VideoInfo videoInfo = this.s;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                this.s = null;
            }
            b().D(new lh5(2, 19, null));
            n0(null);
            b().D(new lh5(2, 6, null));
            if (!StringUtils.isNull(this.c)) {
                this.c = "";
            }
            U("");
            this.g.setWriteData(null);
            this.g.j0(false);
        }
    }

    public final void m() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.k != null && (dataModel = this.i) != null && dataModel.W()) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
            statisticItem.addParam("obj_locate", 1);
            if (this.k.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (this.k.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", this.k.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, this.k.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.i.getFromForumId());
            statisticItem.addParam("order_id", this.i.S());
            TiebaStatic.log(statisticItem);
            hv4.a(hv4.f, hv4.c, this.i.S(), this.i.T(), this.i.R(), this.k.statFloor);
        }
    }

    @Override // com.baidu.tieba.vaa.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, writeData) != null) || writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.s == null) {
                this.s = new VideoInfo();
            }
            this.s.copy(writeData.getVideoInfo());
            V();
            b().D(new lh5(39, -1, this.s));
        }
        if (writeData.getWriteImagesInfo() != null && this.b.size() == 0) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools b2 = b();
                b2.D(new lh5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            b().D(new lh5(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().getVoiceId() != null && writeData.getVoiceModel().getDuration() != -1) {
            if (this.e == null) {
                this.e = new VoiceData.VoiceModel();
            }
            this.e.copy(writeData.getVoiceModel());
        }
        if (!bi.isEmpty(writeData.getContent()) && bi.isEmpty(this.c)) {
            String content = writeData.getContent();
            this.c = content;
            U(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            b().k(false, false);
            b().A((View) b().o(5));
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (!StringUtils.isNull(this.c)) {
                return true;
            }
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                return true;
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null && !StringUtils.isNull(voiceModel.getId())) {
                return true;
            }
            VideoInfo videoInfo = this.s;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
