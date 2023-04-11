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
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.vk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class se5 extends tc5 implements vk9.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public EditorTools B;
    public boolean C;
    public final NewWriteModel.d D;
    public final z8 E;
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
    public pe5 v;
    public oe5 w;
    public boolean x;
    public TextWatcher y;
    public te5 z;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se5 a;

        public a(se5 se5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se5Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a95 a95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a95Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.g.g0();
                }
                if (z) {
                    this.a.R(true);
                    WriteData g0 = this.a.g.g0();
                    this.a.L();
                    vk9.z(this.a.l, null);
                    if (g0 == null) {
                        return;
                    }
                    if (g0.getType() == 2) {
                        vk9.p(g0.getThreadId(), this.a);
                    }
                } else if (writeData != null && a95Var != null && !TextUtils.isEmpty(a95Var.d())) {
                    writeData.setVcodeMD5(a95Var.b());
                    writeData.setVcodeUrl(a95Var.c());
                    writeData.setVcodeExtra(a95Var.a());
                    if (this.a.k != null) {
                        writeData.setBaijiahaoData(this.a.k.getBaijiahaoData());
                    }
                    if (zr5.b(a95Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.m.getPageActivity(), 12006, writeData, false, a95Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.m.getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.m.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
                se5 se5Var = this.a;
                se5Var.B(se5Var.g.g0());
                NewWriteModel.d dVar = this.a.u;
                if (dVar != null) {
                    dVar.callback(z, postWriteCallBackData, a95Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se5 a;

        public b(se5 se5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se5Var;
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

    /* loaded from: classes6.dex */
    public class c extends z8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se5 a;

        public c(se5 se5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se5Var;
        }

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.g.m0(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se5(EditorTools editorTools) {
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

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && b() != null) {
            if (z) {
                b().C(new pc5(2, 10, null));
                b().C(new pc5(2, 6, null));
            }
            b().C(new pc5(9, -1, Boolean.valueOf(z)));
        }
    }

    public void k0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, threadData) == null) {
            this.k = threadData;
            if (b() != null && this.k != null) {
                b().setFid(this.k.getFid());
                b().setTid(this.k.getTid());
                b().C(new pc5(70, -1, String.valueOf(this.k.getFid())));
            }
        }
    }

    public void I(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumData, userData) == null) {
            this.j = forumData;
        }
    }

    public final void t(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048632, this, intent, z) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.b.parseJson(stringExtra);
            this.b.updateQuality();
            if (this.b.getChosedFiles() != null) {
                w(false, null);
            }
        }
    }

    public void F(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null) {
                bundle.putString("write_images", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.f);
        }
    }

    public void H(AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, antiData) == null) && antiData != null) {
            this.n = antiData.getVoice_message();
        }
    }

    public final void O(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) && b() != null) {
            b().C(new pc5(17, 27, arrayList));
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && b() != null) {
            b().C(new pc5(44, 27, str));
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && b() != null) {
            b().C(new pc5(6, 27, str));
        }
    }

    public void V(oe5 oe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, oe5Var) == null) {
            this.w = oe5Var;
        }
    }

    public void W(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, tbPageContext) == null) {
            this.m = tbPageContext;
        }
    }

    public void X(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z) == null) && b() != null && (bLauncher = (BLauncher) b().o(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.A = i;
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.x = z;
        }
    }

    public void a0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && b() != null && (bLauncher = (BLauncher) b().o(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void b0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, dataModel) == null) {
            this.i = dataModel;
        }
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (this.z == null && b() != null) {
                this.z = (te5) b().p(27);
            }
            te5 te5Var = this.z;
            if (te5Var != null) {
                te5Var.m(str);
            }
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            if (this.z == null && b() != null) {
                this.z = (te5) b().p(27);
            }
            te5 te5Var = this.z;
            if (te5Var != null) {
                te5Var.n(i);
            }
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.c = str;
        }
    }

    public void f0(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dVar) == null) {
            this.u = dVar;
        }
    }

    public void g(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, textWatcher) == null) {
            i();
            te5 te5Var = this.z;
            if (te5Var != null && textWatcher != null) {
                te5Var.g(textWatcher);
            }
        }
    }

    public void g0(pe5 pe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pe5Var) == null) {
            this.v = pe5Var;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            if (this.z == null && b() != null) {
                this.z = (te5) b().p(27);
            }
            te5 te5Var = this.z;
            if (te5Var != null) {
                te5Var.h(i);
            }
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.C = z;
        }
    }

    public void i0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && b() != null && (bLauncher = (BLauncher) b().o(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void j0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, spanGroupManager) == null) {
            this.d = spanGroupManager;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.l = str;
        }
    }

    public void m0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, voiceModel) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            vk9.p(str, this);
        }
    }

    public final void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, intent) == null) {
            t(intent, false);
        }
    }

    public void A(TbPageContext tbPageContext, Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.g = newWriteModel;
            newWriteModel.o0(this.D);
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
                b().C(new pc5(2, 12, " "));
            }
            WriteImagesInfo writeImagesInfo2 = this.b;
            if (writeImagesInfo2 != null && writeImagesInfo2.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools b2 = b();
                b2.C(new pc5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
    }

    public void w(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048635, this, z, postWriteCallBackData) == null) {
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

    public void B(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) != null) || writeData == null) {
            return;
        }
        this.b = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools b2 = b();
                b2.C(new pc5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            b().C(new pc5(2, 10, null));
        }
        String content = writeData.getContent();
        this.c = content;
        T(content);
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
        if (interceptable == null || interceptable.invokeL(1048628, this, intent) == null) {
            this.f = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.f;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, ii.d(this.m.getPageActivity(), ii.l(this.m.getPageActivity())), ii.d(this.m.getPageActivity(), ii.j(this.m.getPageActivity())));
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

    public void C(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
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
                                                                Q();
                                                                this.g.m0(false);
                                                                return;
                                                            }
                                                            this.h.V(intent.getStringExtra("file_name"));
                                                            return;
                                                        case 12004:
                                                            if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) != null) {
                                                                O(parcelableArrayListExtra);
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
                                        P(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
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
                                    U();
                                    b().C(new pc5(28, 20, this.s));
                                    b().C(new pc5(28, -1, this.s));
                                    return;
                                }
                                return;
                            }
                        }
                        r(intent);
                        return;
                    }
                    WriteData g0 = this.g.g0();
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } else {
                        postWriteCallBackData = null;
                    }
                    if (g0 != null) {
                        g0.deleteUploadedTempImages();
                    }
                    this.g.setWriteData(null);
                    this.g.m0(false);
                    this.e = null;
                    this.s = null;
                    if (!TextUtils.isEmpty(this.l)) {
                        vk9.z(this.l, null);
                    }
                    R(true);
                    NewWriteModel.d dVar = this.u;
                    if (dVar != null) {
                        dVar.callback(true, postWriteCallBackData, null, g0, null);
                        return;
                    }
                    return;
                }
                G(null, null);
            } else if (i != 12001) {
                if (i != 12002) {
                    if (i == 12006) {
                        if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        }
                        PostWriteCallBackData postWriteCallBackData3 = postWriteCallBackData2;
                        NewWriteModel.d dVar2 = this.u;
                        if (dVar2 != null) {
                            dVar2.callback(false, postWriteCallBackData3, null, this.g.g0(), null);
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

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.cancelLoadData();
            this.h.cancelLoadData();
            this.g.p0(null);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.z == null && b() != null) {
                this.z = (te5) b().p(27);
            }
            te5 te5Var = this.z;
            if (te5Var != null) {
                te5Var.j();
            }
        }
    }

    public void K() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (editorTools = this.B) != null) {
            editorTools.A();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.g.setWriteData(null);
            this.g.m0(false);
            this.e = null;
            this.s = null;
            this.b.clear();
        }
    }

    public void M() {
        te5 te5Var;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (te5Var = this.z) != null && (textWatcher = this.y) != null) {
            te5Var.k(textWatcher);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && b() != null) {
            b().C(new pc5(13, -1, null));
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && b() != null) {
            b().C(new pc5(2, 19, " "));
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
            this.z = (te5) b().p(27);
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

    public te5 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.z == null && b() != null) {
                this.z = (te5) b().p(27);
            }
            return this.z;
        }
        return (te5) invokeV.objValue;
    }

    public SpanGroupManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.d;
        }
        return (SpanGroupManager) invokeV.objValue;
    }

    public WriteImagesInfo v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.b;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel == null || TextUtils.isEmpty(voiceModel.getVoiceId()) || this.e.getDuration() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void G(String str, WriteData writeData) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, writeData) == null) {
            if (this.g.g0() == null) {
                WriteData X = this.i.X(str);
                if (X != null && (threadData = this.k) != null) {
                    X.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.g.setWriteData(X);
            }
            boolean z = true;
            if (this.g.g0() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            this.g.g0().setShowCustomFigure(this.C);
            if (qe5.a()) {
                this.g.g0().setShowBless(p45.m().i(p45.q("key_reply_add_bless_enable"), true));
            }
            if (this.x) {
                this.g.g0().setCanNoForum(true);
                if (this.j != null) {
                    this.g.g0().setVForumId(this.j.getId());
                    this.g.g0().setVForumName(this.j.getName());
                }
            } else {
                this.g.g0().setCanNoForum(false);
                this.g.g0().setVForumId("");
                this.g.g0().setVForumName("");
            }
            this.g.g0().setIsBJHPost(this.t);
            this.g.g0().setWriteImagesInfo(this.b);
            this.g.g0().setVideoInfo(this.s);
            NewWriteModel newWriteModel = this.g;
            if (this.b.size() <= 0) {
                z = false;
            }
            newWriteModel.m0(z);
            if (str == null) {
                this.g.g0().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            int i = -1;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.g.g0().setVoice(this.e.getId());
                    this.g.g0().setVoiceDuringTime(this.e.getDuration());
                } else {
                    this.g.g0().setVoice(null);
                    this.g.g0().setVoiceDuringTime(-1);
                }
            } else {
                this.g.g0().setVoice(null);
                this.g.g0().setVoiceDuringTime(-1);
            }
            if (!this.g.e0()) {
                this.m.showToast(R.string.write_img_limit);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12);
                if (this.g.g0() != null) {
                    i = this.g.g0().getType();
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            oe5 oe5Var = this.w;
            if (oe5Var != null && oe5Var.a()) {
                StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13);
                if (this.g.g0() != null) {
                    i = this.g.g0().getType();
                }
                TiebaStatic.log(param2.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            pe5 pe5Var = this.v;
            if (pe5Var != null) {
                pe5Var.a();
            }
            n(this.g.g0());
            m();
            this.g.g0().onPostDataParse(this.d);
            if (!this.g.r0()) {
            }
        }
    }

    public void J(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, metaData, str, str2) == null) && b() != null && metaData != null) {
            this.q = metaData.getUserIdLong();
            this.o = metaData.getUserName();
            this.p = metaData.getName_show();
            this.l = str;
            this.r = str2;
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            WriteData g0 = this.g.g0();
            if (g0 == null) {
                g0 = new WriteData(1);
                g0.setThreadId(str);
                g0.setWriteImagesInfo(this.b);
            }
            g0.onSaveDrafDataParse(this.d);
            g0.setContent(this.c);
            g0.setVideoInfo(this.s);
            g0.setVoiceModel(this.e);
            vk9.z(str, g0);
        }
    }

    public void f(e85 e85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, e85Var) == null) && e85Var != null && EmotionGroupType.isSendAsPic(e85Var.getType())) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(e85Var.d());
            imageFileInfo.width = e85Var.h();
            imageFileInfo.height = e85Var.b();
            this.b.addChooseFile(imageFileInfo);
            this.b.updateQuality();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && !StringUtils.isNull(this.o)) {
            long j = this.q;
            if (j > 0) {
                if (String.valueOf(j).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                    ii.P(this.m.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.m.getPageActivity(), this.q, this.o, this.p, GiftTabActivityConfig.FROM_PB, gg.g(this.l, 0L), gg.g(this.r, 0L))));
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
            b().C(new pc5(2, 19, null));
            m0(null);
            b().C(new pc5(2, 6, null));
            if (!StringUtils.isNull(this.c)) {
                this.c = "";
            }
            T("");
            this.g.setWriteData(null);
            this.g.m0(false);
        }
    }

    public final void m() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.k != null && (dataModel = this.i) != null && dataModel.Z()) {
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
            statisticItem.addParam("order_id", this.i.V());
            TiebaStatic.log(statisticItem);
            es4.a(es4.f, es4.c, this.i.V(), this.i.W(), this.i.U(), this.k.statFloor);
        }
    }

    @Override // com.baidu.tieba.vk9.g
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
            U();
            b().C(new pc5(39, -1, this.s));
        }
        if (writeData.getWriteImagesInfo() != null && this.b.size() == 0) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools b2 = b();
                b2.C(new pc5(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            b().C(new pc5(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().getVoiceId() != null && writeData.getVoiceModel().getDuration() != -1) {
            if (this.e == null) {
                this.e = new VoiceData.VoiceModel();
            }
            this.e.copy(writeData.getVoiceModel());
        }
        if (!hi.isEmpty(writeData.getContent()) && hi.isEmpty(this.c)) {
            String content = writeData.getContent();
            this.c = content;
            T(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            b().k(false, false);
            b().z((View) b().o(5));
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
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
