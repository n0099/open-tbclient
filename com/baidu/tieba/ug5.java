package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.editortools.meme.list.MemeData;
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
import com.baidu.tieba.xqa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import tbclient.SpriteMemeInfo;
/* loaded from: classes8.dex */
public class ug5 extends be5 implements xqa.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public EditorTools B;
    public boolean C;
    public MemeData D;
    public pq6<rf5> E;
    public BdUniqueId F;
    public boolean G;
    public String H;
    public int I;
    public final NewWriteModel.d J;
    public final w4 K;
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
    public rg5 v;
    public qg5 w;
    public boolean x;
    public TextWatcher y;
    public PbNewEditorTool z;

    /* loaded from: classes8.dex */
    public class a extends pq6<rf5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ug5 ug5Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug5Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ug5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull rf5 rf5Var) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rf5Var) == null) && (tbPageContext = this.b.m) != null && tbPageContext.getUniqueId() == rf5Var.c()) {
                this.b.D = rf5Var.a();
                this.b.h(rf5Var.a(), rf5Var.b());
                this.b.z(false, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug5 a;

        public b(ug5 ug5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ug5Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, g95 g95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, g95Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.g.e0();
                }
                if (!z) {
                    if (writeData != null && g95Var != null && !TextUtils.isEmpty(g95Var.d())) {
                        writeData.setVcodeMD5(g95Var.b());
                        writeData.setVcodeUrl(g95Var.c());
                        writeData.setVcodeExtra(g95Var.a());
                        if (this.a.k != null) {
                            writeData.setBaijiahaoData(this.a.k.getBaijiahaoData());
                        }
                        if (VcodeTool.needVcode(g95Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.m.getPageActivity(), 12006, writeData, false, g95Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.m.getPageActivity(), writeData, 12006)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.m.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    }
                } else {
                    this.a.V(true);
                    WriteData e0 = this.a.g.e0();
                    this.a.P();
                    xqa.C(this.a.l, null);
                    if (e0 == null) {
                        return;
                    }
                    if (e0.getType() == 2) {
                        xqa.r(e0.getThreadId(), this.a);
                    }
                }
                ug5 ug5Var = this.a;
                ug5Var.F(ug5Var.g.e0());
                NewWriteModel.d dVar = this.a.u;
                if (dVar != null) {
                    dVar.callback(z, postWriteCallBackData, g95Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug5 a;

        public c(ug5 ug5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ug5Var;
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

    /* loaded from: classes8.dex */
    public class d extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug5 a;

        public d(ug5 ug5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ug5Var;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.g.k0(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ug5(EditorTools editorTools) {
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
        this.E = new a(this, rf5.class);
        this.F = BdUniqueId.gen();
        this.J = new b(this);
        this.K = new d(this);
        this.B = editorTools;
        mq6.b().b(this.F, this.E);
    }

    public void o0(ThreadData threadData) {
        String forum_name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, threadData) == null) {
            this.k = threadData;
            if (a() != null && this.k != null) {
                a().setFid(this.k.getFid());
                EditorTools a2 = a();
                String str = "";
                if (StringUtils.isNull(this.k.getForum_name())) {
                    forum_name = "";
                } else {
                    forum_name = this.k.getForum_name();
                }
                a2.setFname(forum_name);
                EditorTools a3 = a();
                if (!StringUtils.isNull(this.k.getId())) {
                    str = this.k.getId();
                }
                a3.setTid(str);
                a().K(new xd5(70, -1, String.valueOf(this.k.getFid())));
            }
        }
    }

    public void N(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, metaData, str, str2) == null) && a() != null && metaData != null) {
            this.q = metaData.getUserIdLong();
            this.o = metaData.getUserName();
            this.p = metaData.getName_show();
            this.l = str;
            this.r = str2;
        }
    }

    public void M(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, forumData, userData) == null) {
            this.j = forumData;
        }
    }

    public final void w(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048638, this, intent, z) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.b.parseJson(stringExtra);
            this.b.updateQuality();
            if (this.b.getChosedFiles() != null) {
                z(false, null);
            }
        }
    }

    public void J(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null) {
                bundle.putString("write_images", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.f);
        }
    }

    public void L(AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, antiData) == null) && antiData != null) {
            this.n = antiData.getVoice_message();
        }
    }

    public final void S(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) && a() != null) {
            a().K(new xd5(17, 27, arrayList));
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && a() != null) {
            a().K(new xd5(44, 27, str));
        }
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && a() != null) {
            a().K(new xd5(6, 27, str));
        }
    }

    public void Z(qg5 qg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, qg5Var) == null) {
            this.w = qg5Var;
        }
    }

    public void a0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, tbPageContext) == null) {
            this.m = tbPageContext;
        }
    }

    public void b0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && a() != null && (bLauncher = (BLauncher) a().t(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.A = i;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.x = z;
        }
    }

    public void e0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048607, this, z) == null) && a() != null && (bLauncher = (BLauncher) a().t(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void f0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, dataModel) == null) {
            this.i = dataModel;
        }
    }

    public void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            if (this.z == null && a() != null) {
                this.z = (PbNewEditorTool) a().u(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.p(str);
            }
        }
    }

    public void h0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            if (this.z == null && a() != null) {
                this.z = (PbNewEditorTool) a().u(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.q(i);
            }
        }
    }

    public void i(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, textWatcher) == null) {
            k();
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null && textWatcher != null) {
                pbNewEditorTool.i(textWatcher);
            }
        }
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.c = str;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            if (this.z == null && a() != null) {
                this.z = (PbNewEditorTool) a().u(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.j(i);
            }
        }
    }

    public void j0(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, dVar) == null) {
            this.u = dVar;
        }
    }

    public void k0(rg5 rg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, rg5Var) == null) {
            this.v = rg5Var;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.C = z;
        }
    }

    public void m0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && a() != null && (bLauncher = (BLauncher) a().t(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void n0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, spanGroupManager) == null) {
            this.d = spanGroupManager;
        }
    }

    public void p0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.l = str;
        }
    }

    public final void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, intent) == null) {
            w(intent, true);
        }
    }

    public void q0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, voiceModel) == null) {
            this.e = voiceModel;
        }
    }

    public void s0(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, spriteMemeInfo) == null) && spriteMemeInfo != null && spriteMemeInfo.meme_id.longValue() > 0) {
            l();
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            xqa.r(str, this);
        }
    }

    public final void u(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, intent) == null) {
            w(intent, false);
        }
    }

    public void A() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str2 = this.c;
            ThreadData threadData = this.k;
            if (threadData != null) {
                str = String.valueOf(threadData.getFid());
            } else {
                str = "";
            }
            de5.e(str2, str);
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel == null || TextUtils.isEmpty(voiceModel.getVoiceId()) || this.e.getDuration() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g.cancelLoadData();
            this.h.cancelLoadData();
            this.g.n0(null);
            a().x(27);
            mq6.b().a(this.F);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.z == null && a() != null) {
                this.z = (PbNewEditorTool) a().u(27);
            }
            PbNewEditorTool pbNewEditorTool = this.z;
            if (pbNewEditorTool != null) {
                pbNewEditorTool.l();
            }
        }
    }

    public void O() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (editorTools = this.B) != null) {
            editorTools.I();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.g.setWriteData(null);
            this.g.k0(false);
            this.e = null;
            this.s = null;
            this.b.clear();
        }
    }

    public void Q() {
        PbNewEditorTool pbNewEditorTool;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (pbNewEditorTool = this.z) != null && (textWatcher = this.y) != null) {
            pbNewEditorTool.m(textWatcher);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && a() != null) {
            a().K(new xd5(13, -1, null));
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && a() != null) {
            a().K(new xd5(2, 19, " "));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.z == null && a() != null) {
            this.z = (PbNewEditorTool) a().u(27);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.s = null;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            new c(this).execute(new Void[0]);
        }
    }

    public TbPageContext s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.m;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public PbNewEditorTool v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (this.z == null && a() != null) {
                this.z = (PbNewEditorTool) a().u(27);
            }
            return this.z;
        }
        return (PbNewEditorTool) invokeV.objValue;
    }

    public SpanGroupManager x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.d;
        }
        return (SpanGroupManager) invokeV.objValue;
    }

    public WriteImagesInfo y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.b;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public void E(TbPageContext tbPageContext, Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.g = newWriteModel;
            newWriteModel.m0(this.J);
            ImageModel imageModel = new ImageModel(tbPageContext);
            this.h = imageModel;
            imageModel.setLoadDataCallBack(this.K);
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
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().K(new xd5(2, 12, " "));
            }
            WriteImagesInfo writeImagesInfo2 = this.b;
            if (writeImagesInfo2 != null && writeImagesInfo2.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.K(new xd5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
    }

    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048641, this, z, postWriteCallBackData) == null) {
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
            MemeData memeData = this.D;
            if (memeData != null) {
                pbEditorData.setMemeQuery(memeData.getRequestQuery());
                pbEditorData.setMemeId((int) this.D.getId());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.m.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public void F(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, writeData) != null) || writeData == null) {
            return;
        }
        this.b = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.K(new xd5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().K(new xd5(2, 10, null));
        }
        String content = writeData.getContent();
        this.c = content;
        X(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void p(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, writeData) != null) || writeData == null) {
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

    public final void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, intent) == null) {
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
                z(false, null);
            }
        }
    }

    public void G(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
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
                                                                r(intent);
                                                            } else {
                                                                q(intent);
                                                            }
                                                            a().invalidate();
                                                            return;
                                                        case 12003:
                                                            if (intent == null) {
                                                                return;
                                                            }
                                                            if (intent.getBooleanExtra("delete", false)) {
                                                                U();
                                                                this.g.k0(false);
                                                                return;
                                                            }
                                                            this.h.T(intent.getStringExtra("file_name"));
                                                            return;
                                                        case 12004:
                                                            if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) != null) {
                                                                S(parcelableArrayListExtra);
                                                                return;
                                                            }
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                                } else if (i == 12010) {
                                                    r(intent);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.m.getPageActivity(), 12005, true);
                                            if (x() != null) {
                                                atListActivityConfig.setSelectedAtList(x().x());
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
                                        if (x() != null) {
                                            atListActivityConfig2.setSelectedAtList(x().x());
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
                                        T(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                                return;
                            } else if (a() == null) {
                                return;
                            } else {
                                VideoInfo videoInfo = new VideoInfo();
                                videoInfo.parseFromIntent(intent);
                                if (videoInfo.isAvaliable()) {
                                    this.s = videoInfo;
                                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.XIAOYING_DURATION);
                                    statisticItem3.param("duration", this.s.getVideoDuration());
                                    TiebaStatic.log(statisticItem3);
                                    Y();
                                    a().K(new xd5(28, 20, this.s));
                                    a().K(new xd5(28, -1, this.s));
                                    return;
                                }
                                return;
                            }
                        }
                        u(intent);
                        return;
                    }
                    WriteData e0 = this.g.e0();
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } else {
                        postWriteCallBackData = null;
                    }
                    if (e0 != null) {
                        e0.deleteUploadedTempImages();
                    }
                    this.g.setWriteData(null);
                    this.g.k0(false);
                    this.e = null;
                    this.s = null;
                    if (!TextUtils.isEmpty(this.l)) {
                        xqa.C(this.l, null);
                    }
                    V(true);
                    NewWriteModel.d dVar = this.u;
                    if (dVar != null) {
                        dVar.callback(true, postWriteCallBackData, null, e0, null);
                        return;
                    }
                    return;
                }
                K(null, null);
            } else if (i != 12001) {
                if (i != 12002) {
                    if (i == 12006) {
                        if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        }
                        PostWriteCallBackData postWriteCallBackData3 = postWriteCallBackData2;
                        NewWriteModel.d dVar2 = this.u;
                        if (dVar2 != null) {
                            dVar2.callback(false, postWriteCallBackData3, null, this.g.e0(), null);
                        }
                    }
                } else if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.b.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                }
            } else {
                n();
            }
        }
    }

    public void K(String str, WriteData writeData) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, writeData) == null) {
            if (this.g.e0() == null) {
                WriteData V = this.i.V(str);
                if (V != null && (threadData = this.k) != null) {
                    V.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.g.setWriteData(V);
            }
            if (this.G) {
                this.g.e0().setSpriteMemeQuery(this.H);
                this.g.e0().setSpriteMemeId(String.valueOf(this.I));
            }
            boolean z = true;
            if (this.g.e0() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            this.g.e0().setBotConfig(BotEntranceManager.h().i());
            this.g.e0().setShowCustomFigure(this.C);
            if (sg5.a()) {
                this.g.e0().setShowBless(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reply_add_bless_enable"), true));
            }
            if (this.x) {
                this.g.e0().setCanNoForum(true);
                if (this.j != null) {
                    this.g.e0().setVForumId(this.j.getId());
                    this.g.e0().setVForumName(this.j.getName());
                }
            } else {
                this.g.e0().setCanNoForum(false);
                this.g.e0().setVForumId("");
                this.g.e0().setVForumName("");
            }
            this.g.e0().setIsBJHPost(this.t);
            this.g.e0().setWriteImagesInfo(this.b);
            this.g.e0().setVideoInfo(this.s);
            NewWriteModel newWriteModel = this.g;
            if (this.b.size() <= 0) {
                z = false;
            }
            newWriteModel.k0(z);
            if (str == null) {
                this.g.e0().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            int i = -1;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.g.e0().setVoice(this.e.getId());
                    this.g.e0().setVoiceDuringTime(this.e.getDuration());
                } else {
                    this.g.e0().setVoice(null);
                    this.g.e0().setVoiceDuringTime(-1);
                }
            } else {
                this.g.e0().setVoice(null);
                this.g.e0().setVoiceDuringTime(-1);
            }
            if (!this.g.c0()) {
                this.m.showToast(R.string.write_img_limit);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12);
                if (this.g.e0() != null) {
                    i = this.g.e0().getType();
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            qg5 qg5Var = this.w;
            if (qg5Var != null && qg5Var.a()) {
                StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13);
                if (this.g.e0() != null) {
                    i = this.g.e0().getType();
                }
                TiebaStatic.log(param2.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            rg5 rg5Var = this.v;
            if (rg5Var != null) {
                rg5Var.a();
            }
            p(this.g.e0());
            o();
            this.g.e0().onPostDataParse(this.d);
            if (!this.g.p0()) {
            }
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            WriteData e0 = this.g.e0();
            if (e0 == null) {
                e0 = new WriteData(1);
                e0.setThreadId(str);
                e0.setWriteImagesInfo(this.b);
            }
            e0.onSaveDrafDataParse(this.d);
            e0.setContent(this.c);
            e0.setVideoInfo(this.s);
            e0.setVoiceModel(this.e);
            xqa.C(str, e0);
        }
    }

    public void g(l85 l85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, l85Var) == null) && l85Var != null && EmotionGroupType.isSendAsPic(l85Var.g())) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(l85Var.d());
            imageFileInfo.width = l85Var.i();
            imageFileInfo.height = l85Var.b();
            this.b.addChooseFile(imageFileInfo);
            this.b.updateQuality();
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && a() != null) {
            if (z) {
                a().K(new xd5(2, 10, null));
                a().K(new xd5(2, 6, null));
            }
            a().K(new xd5(9, -1, Boolean.valueOf(z)));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !StringUtils.isNull(this.o)) {
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

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.b.clear();
            }
            VideoInfo videoInfo = this.s;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                this.s = null;
            }
            a().K(new xd5(2, 19, null));
            q0(null);
            a().K(new xd5(2, 6, null));
            if (!StringUtils.isNull(this.c)) {
                this.c = "";
            }
            X("");
            this.g.setWriteData(null);
            this.g.k0(false);
            a().K(new xd5(2, 10, null));
        }
    }

    public final void o() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.k != null && (dataModel = this.i) != null && dataModel.X()) {
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
            statisticItem.addParam("order_id", this.i.T());
            TiebaStatic.log(statisticItem);
            lq4.a(lq4.f, lq4.c, this.i.T(), this.i.U(), this.i.S(), this.k.statFloor);
        }
    }

    @Override // com.baidu.tieba.xqa.h
    public void d(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, writeData) != null) || writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.s == null) {
                this.s = new VideoInfo();
            }
            this.s.copy(writeData.getVideoInfo());
            Y();
            a().K(new xd5(39, -1, this.s));
        }
        if (writeData.getWriteImagesInfo() != null && this.b.size() == 0) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.K(new xd5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().K(new xd5(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().getVoiceId() != null && writeData.getVoiceModel().getDuration() != -1) {
            if (this.e == null) {
                this.e = new VoiceData.VoiceModel();
            }
            this.e.copy(writeData.getVoiceModel());
        }
        if (!qd.isEmpty(writeData.getContent()) && qd.isEmpty(this.c)) {
            String content = writeData.getContent();
            this.c = content;
            X(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public final void h(MemeData memeData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, memeData, str) != null) || TextUtils.isEmpty(memeData.getImgUrl())) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setImageType(0);
        imageFileInfo.setFilePath(str);
        imageFileInfo.setContentUriStr(Uri.fromFile(new File(str)).toString());
        this.b.addChooseFile(imageFileInfo);
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            a().o(false, false);
            a().G((View) a().t(5));
        }
    }
}
