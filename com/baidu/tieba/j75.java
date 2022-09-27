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
import com.baidu.tieba.nm8;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class j75 extends l55 implements nm8.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public EditorTools B;
    public boolean C;
    public final NewWriteModel.d D;
    public final q9 E;
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
    public h75 v;
    public g75 w;
    public boolean x;
    public TextWatcher y;
    public k75 z;

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j75 a;

        public a(j75 j75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j75Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.g.S();
                }
                if (z) {
                    this.a.R(true);
                    WriteData S = this.a.g.S();
                    this.a.L();
                    nm8.y(this.a.l, null);
                    if (S == null) {
                        return;
                    }
                    if (S.getType() == 2) {
                        nm8.o(S.getThreadId(), this.a);
                    }
                } else if (writeData != null && y15Var != null && !TextUtils.isEmpty(y15Var.d())) {
                    writeData.setVcodeMD5(y15Var.b());
                    writeData.setVcodeUrl(y15Var.c());
                    writeData.setVcodeExtra(y15Var.a());
                    if (this.a.k != null) {
                        writeData.setBaijiahaoData(this.a.k.getBaijiahaoData());
                    }
                    if (vi5.b(y15Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.m.getPageActivity(), 12006, writeData, false, y15Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.m.getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.m.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
                j75 j75Var = this.a;
                j75Var.B(j75Var.g.S());
                NewWriteModel.d dVar = this.a.u;
                if (dVar != null) {
                    dVar.callback(z, postWriteCallBackData, y15Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j75 a;

        public b(j75 j75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j75Var;
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

    /* loaded from: classes4.dex */
    public class c extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j75 a;

        public c(j75 j75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j75Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.g.Z(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j75(EditorTools editorTools) {
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

    public void A(TbPageContext tbPageContext, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.g = newWriteModel;
            newWriteModel.b0(this.D);
            ImageModel imageModel = new ImageModel(tbPageContext);
            this.h = imageModel;
            imageModel.setLoadDataCallBack(this.E);
            if (bundle != null) {
                this.b.parseJson(bundle.getString("write_images"));
                this.f = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null) {
                writeImagesInfo.setMaxImagesAllowed(this.t ? 1 : 9);
            }
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().A(new h55(2, 12, " "));
            }
            WriteImagesInfo writeImagesInfo2 = this.b;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.b.getChosedFiles().size() <= 0) {
                return;
            }
            EditorTools a2 = a();
            a2.A(new h55(2, 10, this.b.getChosedFiles().size() + ""));
        }
    }

    public void B(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) || writeData == null) {
            return;
        }
        this.b = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new h55(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new h55(2, 10, null));
        }
        String content = writeData.getContent();
        this.c = content;
        T(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void C(int i, int i2, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i2 != -1) {
                if (i == 12001) {
                    l();
                } else if (i == 12002) {
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return;
                    }
                    this.b.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                } else if (i != 12006) {
                } else {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.d dVar = this.u;
                    if (dVar != null) {
                        dVar.callback(false, postWriteCallBackData2, null, this.g.S(), null);
                    }
                }
            } else if (i == 11001) {
                G(null, null);
            } else if (i == 12006) {
                WriteData S = this.g.S();
                PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (S != null) {
                    S.deleteUploadedTempImages();
                }
                this.g.setWriteData(null);
                this.g.Z(false);
                this.e = null;
                this.s = null;
                if (!TextUtils.isEmpty(this.l)) {
                    nm8.y(this.l, null);
                }
                R(true);
                NewWriteModel.d dVar2 = this.u;
                if (dVar2 != null) {
                    dVar2.callback(true, postWriteCallBackData3, null, S, null);
                }
            } else if (i == 12012) {
                r(intent);
            } else if (i == 13010) {
                if (a() == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.parseFromIntent(intent);
                if (videoInfo.isAvaliable()) {
                    this.s = videoInfo;
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.XIAOYING_DURATION);
                    statisticItem.param("duration", this.s.getVideoDuration());
                    TiebaStatic.log(statisticItem);
                    U();
                    a().A(new h55(28, 20, this.s));
                    a().A(new h55(28, -1, this.s));
                }
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            } else if (i == 25004) {
                if (intent != null) {
                    P(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                }
            } else if (i == 11025) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.m.getPageActivity(), 12004, true);
                if (u() != null) {
                    atListActivityConfig.setSelectedAtList(u().w());
                }
                ThreadData threadData = this.k;
                if (threadData != null) {
                    atListActivityConfig.setFromTid(threadData.getTid());
                    atListActivityConfig.setFromFid(String.valueOf(this.k.getFid()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                ThreadData threadData2 = this.k;
                if (threadData2 != null) {
                    statisticItem2.addParam("tid", threadData2.getTid());
                    statisticItem2.addParam("fid", this.k.getFid());
                }
                TiebaStatic.log(statisticItem2);
            } else if (i == 11026) {
                AtListActivityConfig atListActivityConfig2 = new AtListActivityConfig(this.m.getPageActivity(), 12005, true);
                if (u() != null) {
                    atListActivityConfig2.setSelectedAtList(u().w());
                }
                ThreadData threadData3 = this.k;
                if (threadData3 != null) {
                    atListActivityConfig2.setFromTid(threadData3.getTid());
                    atListActivityConfig2.setFromFid(String.valueOf(this.k.getFid()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig2));
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                ThreadData threadData4 = this.k;
                if (threadData4 != null) {
                    statisticItem3.addParam("tid", threadData4.getTid());
                    statisticItem3.addParam("fid", this.k.getFid());
                }
                TiebaStatic.log(statisticItem3);
            } else if (i == 12009 || i == 12010) {
                if (i == 12010) {
                    p(intent);
                }
            } else {
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
                        a().invalidate();
                        return;
                    case 12003:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra("delete", false)) {
                            Q();
                            this.g.Z(false);
                            return;
                        }
                        this.h.E(intent.getStringExtra("file_name"));
                        return;
                    case 12004:
                        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                            return;
                        }
                        O(parcelableArrayListExtra);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.cancelLoadData();
            this.h.cancelLoadData();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.z == null && a() != null) {
                this.z = (k75) a().n(27);
            }
            k75 k75Var = this.z;
            if (k75Var != null) {
                k75Var.j();
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

    public void G(String str, WriteData writeData) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, writeData) == null) {
            if (this.g.S() == null) {
                WriteData G = this.i.G(str);
                if (G != null && (threadData = this.k) != null) {
                    G.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.g.setWriteData(G);
            }
            if (this.g.S() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            this.g.setSpanGroupManager(this.d);
            this.g.S().setShowCustomFigure(this.C);
            if (this.x) {
                this.g.S().setCanNoForum(true);
                if (this.j != null) {
                    this.g.S().setVForumId(this.j.getId());
                    this.g.S().setVForumName(this.j.getName());
                }
            } else {
                this.g.S().setCanNoForum(false);
                this.g.S().setVForumId("");
                this.g.S().setVForumName("");
            }
            this.g.S().setIsBJHPost(this.t);
            this.g.S().setWriteImagesInfo(this.b);
            this.g.S().setVideoInfo(this.s);
            this.g.Z(this.b.size() > 0);
            if (str == null) {
                this.g.S().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.g.S().setVoice(this.e.getId());
                    this.g.S().setVoiceDuringTime(this.e.duration);
                } else {
                    this.g.S().setVoice(null);
                    this.g.S().setVoiceDuringTime(-1);
                }
            } else {
                this.g.S().setVoice(null);
                this.g.S().setVoiceDuringTime(-1);
            }
            if (!this.g.Q()) {
                this.m.showToast(R.string.obfuscated_res_0x7f0f15f3);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12).param("obj_type", this.g.S() != null ? this.g.S().getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            g75 g75Var = this.w;
            if (g75Var != null && g75Var.a()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13).param("obj_type", this.g.S() != null ? this.g.S().getType() : -1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            h75 h75Var = this.v;
            if (h75Var != null) {
                h75Var.a();
            }
            n(this.g.S());
            m();
            if (!this.g.e0()) {
            }
        }
    }

    public void H(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, antiData) == null) || antiData == null) {
            return;
        }
        this.n = antiData.getVoice_message();
    }

    public void I(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumData, userData) == null) {
            this.j = forumData;
        }
    }

    public void J(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, metaData, str, str2) == null) || a() == null || metaData == null) {
            return;
        }
        this.q = metaData.getUserIdLong();
        this.o = metaData.getUserName();
        this.p = metaData.getName_show();
        this.l = str;
        this.r = str2;
    }

    public void K() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (editorTools = this.B) == null) {
            return;
        }
        editorTools.y();
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.g.setWriteData(null);
            this.g.Z(false);
            this.e = null;
            this.s = null;
            this.b.clear();
        }
    }

    public void M() {
        k75 k75Var;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (k75Var = this.z) == null || (textWatcher = this.y) == null) {
            return;
        }
        k75Var.k(textWatcher);
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            WriteData S = this.g.S();
            if (S == null) {
                S = new WriteData(1);
                S.setThreadId(str);
                S.setWriteImagesInfo(this.b);
            }
            S.setContent(this.c);
            S.setVideoInfo(this.s);
            S.setVoiceModel(this.e);
            nm8.y(str, S);
        }
    }

    public final void O(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new h55(17, 27, arrayList));
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || a() == null) {
            return;
        }
        a().A(new h55(44, 27, str));
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || a() == null) {
            return;
        }
        a().A(new h55(13, -1, null));
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || a() == null) {
            return;
        }
        if (z) {
            a().A(new h55(2, 10, null));
            a().A(new h55(2, 6, null));
        }
        a().A(new h55(9, -1, Boolean.valueOf(z)));
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || StringUtils.isNull(this.o)) {
            return;
        }
        long j = this.q;
        if (j <= 0) {
            return;
        }
        if (String.valueOf(j).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            ej.M(this.m.getPageActivity(), R.string.obfuscated_res_0x7f0f0372);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.m.getPageActivity(), this.q, this.o, this.p, GiftTabActivityConfig.FROM_PB, dh.g(this.l, 0L), dh.g(this.r, 0L))));
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || a() == null) {
            return;
        }
        a().A(new h55(6, 27, str));
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || a() == null) {
            return;
        }
        a().A(new h55(2, 19, " "));
    }

    public void V(g75 g75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, g75Var) == null) {
            this.w = g75Var;
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
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(5)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
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
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(23)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void b0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, dataModel) == null) {
            this.i = dataModel;
        }
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (this.z == null && a() != null) {
                this.z = (k75) a().n(27);
            }
            k75 k75Var = this.z;
            if (k75Var != null) {
                k75Var.m(str);
            }
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (this.z == null && a() != null) {
                this.z = (k75) a().n(27);
            }
            k75 k75Var = this.z;
            if (k75Var != null) {
                k75Var.n(i);
            }
        }
    }

    public void e(e15 e15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, e15Var) == null) && e15Var != null && EmotionGroupType.isSendAsPic(e15Var.getType())) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(e15Var.d());
            imageFileInfo.width = e15Var.h();
            imageFileInfo.height = e15Var.b();
            this.b.addChooseFile(imageFileInfo);
            this.b.updateQuality();
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.c = str;
        }
    }

    public void f(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, textWatcher) == null) {
            h();
            k75 k75Var = this.z;
            if (k75Var == null || textWatcher == null) {
                return;
            }
            k75Var.g(textWatcher);
        }
    }

    public void f0(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dVar) == null) {
            this.u = dVar;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            if (this.z == null && a() != null) {
                this.z = (k75) a().n(27);
            }
            k75 k75Var = this.z;
            if (k75Var != null) {
                k75Var.h(i);
            }
        }
    }

    public void g0(h75 h75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, h75Var) == null) {
            this.v = h75Var;
        }
    }

    public TbPageContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.m : (TbPageContext) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.z == null && a() != null) {
            this.z = (k75) a().n(27);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.C = z;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.b.clear();
            }
            VideoInfo videoInfo = this.s;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                this.s = null;
            }
            a().A(new h55(2, 19, null));
            m0(null);
            a().A(new h55(2, 6, null));
            a().A(new h55(33, 6, null));
            if (!StringUtils.isNull(this.c)) {
                this.c = "";
            }
            T("");
            this.g.setWriteData(null);
            this.g.Z(false);
        }
    }

    public void i0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048616, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(2)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.s = null;
        }
    }

    public void j0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, spanGroupManager) == null) {
            this.d = spanGroupManager;
        }
    }

    @Override // com.baidu.tieba.nm8.g
    public void k(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, writeData) == null) || writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.s == null) {
                this.s = new VideoInfo();
            }
            this.s.copy(writeData.getVideoInfo());
            U();
            a().A(new h55(39, -1, this.s));
        }
        if (writeData.getWriteImagesInfo() != null && this.b.size() == 0) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new h55(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new h55(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
            if (this.e == null) {
                this.e = new VoiceData.VoiceModel();
            }
            this.e.copy(writeData.getVoiceModel());
        }
        if (!dj.isEmpty(writeData.getContent()) && dj.isEmpty(this.c)) {
            String content = writeData.getContent();
            this.c = content;
            T(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void k0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, threadData) == null) {
            this.k = threadData;
            if (a() == null || this.k == null) {
                return;
            }
            a().setFid(this.k.getFid());
            a().setTid(this.k.getTid());
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            new b(this).execute(new Void[0]);
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.l = str;
        }
    }

    public final void m() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.k == null || (dataModel = this.i) == null || !dataModel.I()) {
            return;
        }
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
        statisticItem.addParam("order_id", this.i.E());
        TiebaStatic.log(statisticItem);
        vn4.a(vn4.f, vn4.c, this.i.E(), this.i.F(), this.i.D(), this.k.statFloor);
    }

    public void m0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, voiceModel) == null) {
            this.e = voiceModel;
        }
    }

    public void n(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, writeData) == null) || writeData == null) {
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
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i++;
            }
        }
        if (i <= 0 || this.A <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i);
        statisticItem2.param("obj_source", this.A);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            a().k(false, false);
            a().x((View) a().m(5));
        }
    }

    public final void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, intent) == null) {
            t(intent, true);
        }
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, intent) == null) {
            this.f = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.f;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, ej.d(this.m.getPageActivity(), ej.k(this.m.getPageActivity())), ej.d(this.m.getPageActivity(), ej.i(this.m.getPageActivity())));
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

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            nm8.o(str, this);
        }
    }

    public final void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, intent) == null) {
            t(intent, false);
        }
    }

    public k75 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.z == null && a() != null) {
                this.z = (k75) a().n(27);
            }
            return this.z;
        }
        return (k75) invokeV.objValue;
    }

    public final void t(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048632, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.b.parseJson(stringExtra);
        this.b.updateQuality();
        if (this.b.getChosedFiles() != null) {
            w(false, null);
        }
    }

    public SpanGroupManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.d : (SpanGroupManager) invokeV.objValue;
    }

    public WriteImagesInfo v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.b : (WriteImagesInfo) invokeV.objValue;
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

    public boolean x() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            return (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (StringUtils.isNull(this.c)) {
                WriteImagesInfo writeImagesInfo = this.b;
                if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                    VoiceData.VoiceModel voiceModel = this.e;
                    if (voiceModel == null || StringUtils.isNull(voiceModel.getId())) {
                        VideoInfo videoInfo = this.s;
                        return videoInfo != null && videoInfo.isAvaliable();
                    }
                    return true;
                }
                return true;
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
            return (voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || this.e.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
