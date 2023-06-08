package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.c55;
import com.baidu.tieba.mx9;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class v38 extends yh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public String c;
    public long d;
    public NewWriteModel e;
    public vj5 f;
    public uj5 g;
    public NewWriteModel.d h;
    public String i;
    public x38 j;
    public WriteImagesInfo k;
    public ImageModel l;
    public String m;
    public NewWriteModel.d n;
    public AntiHelper.k o;
    public final j9 p;

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v38 a;

        public a(v38 v38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v38Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, zd5 zd5Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, zd5Var, writeData, antiData}) == null) {
                if (this.a.h != null) {
                    this.a.h.callback(z, postWriteCallBackData, zd5Var, writeData, antiData);
                }
                if (z) {
                    this.a.c = null;
                    this.a.C(true);
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z) {
                    this.a.e.setWriteData(null);
                    this.a.e.q0(false);
                    this.a.k.clear();
                    this.a.k();
                    this.a.b().C(new uh5(2, 10, null));
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (zd5Var != null && writeData != null && !StringUtils.isNull(zd5Var.c())) {
                        writeData.setVcodeMD5(zd5Var.b());
                        writeData.setVcodeUrl(zd5Var.c());
                        writeData.setVcodeExtra(zd5Var.a());
                        if (hy5.b(zd5Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, zd5Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                        }
                    } else if (postWriteCallBackData != null && i == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    } else if (i != 238010 && !b6a.d(i)) {
                        this.a.getContext().showToast(str);
                    }
                } else {
                    this.a.K(i, str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(v38 v38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(v38 v38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends j9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v38 a;

        public d(v38 v38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v38Var;
        }

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.e.q0(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements mx9.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v38 a;

        public e(v38 v38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v38Var;
        }

        @Override // com.baidu.tieba.mx9.g
        public void a(WriteData writeData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, writeData) != null) || writeData == null) {
                return;
            }
            if (writeData.getWriteImagesInfo() != null && this.a.k.size() == 0) {
                this.a.k.copyFrom(writeData.getWriteImagesInfo());
                if (this.a.k != null && this.a.k.getChosedFiles() != null && this.a.k.getChosedFiles().size() > 0) {
                    EditorTools b = this.a.b();
                    b.C(new uh5(2, 10, this.a.k.getChosedFiles().size() + ""));
                }
            }
            if (this.a.k == null || this.a.k.size() == 0) {
                this.a.b().C(new uh5(2, 10, null));
            }
            if (!ui.isEmpty(writeData.getContent()) && ui.isEmpty(this.a.c)) {
                this.a.c = writeData.getContent();
                v38 v38Var = this.a;
                v38Var.D(v38Var.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v38(EditorTools editorTools) {
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
        this.c = "";
        this.i = null;
        this.k = new WriteImagesInfo();
        this.l = null;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new d(this);
    }

    public final void A(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) && b() != null) {
            b().C(new uh5(17, 29, arrayList));
        }
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && b() != null) {
            b().C(new uh5(9, -1, Boolean.valueOf(z)));
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b() != null) {
            b().C(new uh5(6, 29, str));
        }
    }

    public void E(uj5 uj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uj5Var) == null) {
            this.g = uj5Var;
        }
    }

    public void F(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void G(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.h = dVar;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.c = str;
        }
    }

    public void J(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.d = j;
        }
    }

    public final void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            q(intent, true);
        }
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, intent) == null) {
            q(intent, false);
        }
    }

    public final void q(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048596, this, intent, z) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.k.parseJson(stringExtra);
            this.k.updateQuality();
            if (this.k.getChosedFiles() != null) {
                t();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && b() != null) {
            b().C(new uh5(13, -1, null));
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            I(true);
            b().j();
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            mx9.C(String.valueOf(this.d), null);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            mx9.s(String.valueOf(this.d), new e(this));
        }
    }

    public x38 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.j == null && b() != null) {
                this.j = (x38) b().p(29);
            }
            return this.j;
        }
        return (x38) invokeV.objValue;
    }

    public WriteImagesInfo r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.k;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            I(false);
            b().q();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.e.cancelLoadData();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            WriteData writeData = new WriteData(2);
            writeData.setContent(this.c);
            writeData.setTopicId(String.valueOf(this.d));
            writeData.setWriteImagesInfo(this.k);
            mx9.C(String.valueOf(this.d), writeData);
        }
    }

    public void K(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                if (AntiHelper.w(this.b.getPageActivity(), str, i, this.o) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i != 230277 && i != 230278) {
                getContext().showToast(str);
            } else {
                L(str);
            }
        }
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c55 c55Var = new c55(getContext().getPageActivity());
            c55Var.setMessage(str);
            c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b29, new c(this));
            c55Var.create(getContext()).show();
        }
    }

    public final void m(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            this.m = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.m;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, vi.d(this.b.getPageActivity(), vi.l(this.b.getPageActivity())), vi.d(this.b.getPageActivity(), vi.j(this.b.getPageActivity())));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.m, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception unused) {
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                this.k.addChooseFile(imageFileInfo);
                this.k.updateQuality();
                if (this.k.getChosedFiles() != null) {
                    t();
                }
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (WriteActivityConfig.isAsyncWriting() && this.d > 0) {
                return;
            }
            WriteActivityConfig.newInstance(this.b.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.d)).setFrom("topic_detail").setCallFrom("1").setContent(this.c).setWriteImagesInfo(this.k).send();
        }
    }

    public void v(BaseActivity baseActivity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048601, this, baseActivity, bundle) != null) || baseActivity == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(baseActivity);
        this.e = newWriteModel;
        newWriteModel.s0(this.n);
        ImageModel imageModel = new ImageModel(baseActivity.getPageContext());
        this.l = imageModel;
        imageModel.setLoadDataCallBack(this.p);
        if (bundle != null) {
            this.k.parseJson(bundle.getString("write_images"));
            this.m = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        WriteImagesInfo writeImagesInfo = this.k;
        if (writeImagesInfo != null) {
            writeImagesInfo.setMaxImagesAllowed(9);
        }
        WriteImagesInfo writeImagesInfo2 = this.k;
        if (writeImagesInfo2 != null && writeImagesInfo2.getChosedFiles() != null && this.k.getChosedFiles().size() > 0) {
            EditorTools b2 = b();
            b2.C(new uh5(2, 10, this.k.getChosedFiles().size() + ""));
        }
    }

    public void w(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        PostWriteCallBackData postWriteCallBackData2;
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData3 = null;
            if (i2 == -1) {
                if (i != 12006) {
                    if (i != 12012) {
                        if (i != 13003) {
                            if (i != 24007) {
                                if (i != 12009 && i != 12010) {
                                    switch (i) {
                                        case TaskResponseData.ERROR_NO_TASK_OFFLINE_03 /* 12002 */:
                                            if (intent == null) {
                                                return;
                                            }
                                            if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                                                m(intent);
                                            } else {
                                                l(intent);
                                            }
                                            b().invalidate();
                                            return;
                                        case 12003:
                                            if (intent == null) {
                                                return;
                                            }
                                            if (intent.getBooleanExtra("delete", false)) {
                                                B();
                                                this.e.q0(false);
                                                return;
                                            }
                                            this.l.Z(intent.getStringExtra("file_name"));
                                            return;
                                        case 12004:
                                            if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) != null) {
                                                A(parcelableArrayListExtra);
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (i == 12010) {
                                    m(intent);
                                    return;
                                } else {
                                    return;
                                }
                            } else if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                                statisticItem.param("obj_locate", 6);
                                if (shareItem != null) {
                                    statisticItem.param("tid", shareItem.O);
                                }
                                statisticItem.param("pid", intent.getStringExtra("pid"));
                                TiebaStatic.log(statisticItem);
                                return;
                            } else {
                                return;
                            }
                        } else if (intent != null) {
                            try {
                                postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                            } catch (Exception e2) {
                                BdLog.e(e2);
                                postWriteCallBackData2 = null;
                            }
                            this.n.callback(true, postWriteCallBackData2, null, null, null);
                            return;
                        } else {
                            return;
                        }
                    }
                    p(intent);
                    return;
                }
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                } else {
                    postWriteCallBackData = null;
                }
                if (this.h != null) {
                    this.c = null;
                    C(true);
                    this.e.setWriteData(null);
                    this.e.q0(false);
                    this.k.clear();
                    k();
                    b().C(new uh5(2, 10, null));
                    this.h.callback(true, postWriteCallBackData, null, this.e.k0(), null);
                }
            } else if (i2 == 0 && i == 12006) {
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData3 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                PostWriteCallBackData postWriteCallBackData4 = postWriteCallBackData3;
                NewWriteModel.d dVar = this.h;
                if (dVar != null) {
                    dVar.callback(false, postWriteCallBackData4, null, this.e.k0(), null);
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.e.k0() == null) {
                this.e.setWriteData(new WriteData());
            }
            if (this.e.k0() == null) {
                return;
            }
            this.e.k0().setForumId("0");
            this.e.k0().setType(9);
            this.e.k0().setEntranceType(1);
            this.e.k0().setCanNoForum(true);
            this.e.k0().setTransmitForumData("[]");
            this.e.k0().setCallFrom("1");
            this.e.k0().setTopicId(String.valueOf(this.d));
            this.e.k0().setContent(this.c);
            this.e.k0().setIsNoTitle(true);
            this.e.k0().setTitle("");
            this.e.k0().setVoice(null);
            this.e.k0().setVoiceDuringTime(-1);
            if (!this.e.i0()) {
                getContext().showToast((int) R.string.write_img_limit);
                return;
            }
            uj5 uj5Var = this.g;
            if (uj5Var != null && uj5Var.a()) {
                return;
            }
            vj5 vj5Var = this.f;
            if (vj5Var != null) {
                vj5Var.a();
            }
            if (!this.e.v0()) {
            }
        }
    }
}
