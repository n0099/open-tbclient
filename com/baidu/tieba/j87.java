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
import com.baidu.tieba.lv4;
import com.baidu.tieba.or8;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class j87 extends q65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public String c;
    public long d;
    public NewWriteModel e;
    public m85 f;
    public l85 g;
    public NewWriteModel.d h;
    public String i;
    public l87 j;
    public WriteImagesInfo k;
    public ImageModel l;
    public String m;
    public NewWriteModel.d n;
    public AntiHelper.k o;
    public final q9 p;

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j87 a;

        public a(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j87Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) == null) {
                if (this.a.h != null) {
                    this.a.h.callback(z, postWriteCallBackData, d35Var, writeData, antiData);
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
                    this.a.e.f0(false);
                    this.a.k.clear();
                    this.a.k();
                    this.a.b().B(new m65(2, 10, null));
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (d35Var != null && writeData != null && !StringUtils.isNull(d35Var.c())) {
                        writeData.setVcodeMD5(d35Var.b());
                        writeData.setVcodeUrl(d35Var.c());
                        writeData.setVcodeExtra(d35Var.a());
                        if (dl5.b(d35Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, d35Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                        }
                    } else if (postWriteCallBackData != null && i == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    } else if (i != 238010 && !oz8.d(i)) {
                        this.a.getContext().showToast(str);
                    }
                } else {
                    this.a.K(i, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
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
        public void onNavigationButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j87 a;

        public d(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j87Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.e.f0(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements or8.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j87 a;

        public e(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j87Var;
        }

        @Override // com.baidu.tieba.or8.g
        public void a(WriteData writeData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, writeData) != null) || writeData == null) {
                return;
            }
            if (writeData.getWriteImagesInfo() != null && this.a.k.size() == 0) {
                this.a.k.copyFrom(writeData.getWriteImagesInfo());
                if (this.a.k != null && this.a.k.getChosedFiles() != null && this.a.k.getChosedFiles().size() > 0) {
                    EditorTools b = this.a.b();
                    b.B(new m65(2, 10, this.a.k.getChosedFiles().size() + ""));
                }
            }
            if (this.a.k == null || this.a.k.size() == 0) {
                this.a.b().B(new m65(2, 10, null));
            }
            if (!xi.isEmpty(writeData.getContent()) && xi.isEmpty(this.a.c)) {
                this.a.c = writeData.getContent();
                j87 j87Var = this.a;
                j87Var.D(j87Var.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j87(EditorTools editorTools) {
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
            b().B(new m65(17, 29, arrayList));
        }
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && b() != null) {
            b().B(new m65(9, -1, Boolean.valueOf(z)));
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b() != null) {
            b().B(new m65(6, 29, str));
        }
    }

    public void E(l85 l85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l85Var) == null) {
            this.g = l85Var;
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
            b().B(new m65(13, -1, null));
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
            or8.B(String.valueOf(this.d), null);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            or8.r(String.valueOf(this.d), new e(this));
        }
    }

    public l87 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.j == null && b() != null) {
                this.j = (l87) b().o(29);
            }
            return this.j;
        }
        return (l87) invokeV.objValue;
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
            b().p();
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
            or8.B(String.valueOf(this.d), writeData);
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
            lv4 lv4Var = new lv4(getContext().getPageActivity());
            lv4Var.setMessage(str);
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a07, new c(this));
            lv4Var.create(getContext()).show();
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
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, yi.d(this.b.getPageActivity(), yi.l(this.b.getPageActivity())), yi.d(this.b.getPageActivity(), yi.j(this.b.getPageActivity())));
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
        newWriteModel.h0(this.n);
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
            b2.B(new m65(2, 10, this.k.getChosedFiles().size() + ""));
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
                                                this.e.f0(false);
                                                return;
                                            }
                                            this.l.L(intent.getStringExtra("file_name"));
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
                    this.e.f0(false);
                    this.k.clear();
                    k();
                    b().B(new m65(2, 10, null));
                    this.h.callback(true, postWriteCallBackData, null, this.e.Y(), null);
                }
            } else if (i2 == 0 && i == 12006) {
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData3 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                PostWriteCallBackData postWriteCallBackData4 = postWriteCallBackData3;
                NewWriteModel.d dVar = this.h;
                if (dVar != null) {
                    dVar.callback(false, postWriteCallBackData4, null, this.e.Y(), null);
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.e.Y() == null) {
                this.e.setWriteData(new WriteData());
            }
            if (this.e.Y() == null) {
                return;
            }
            this.e.Y().setForumId("0");
            this.e.Y().setType(9);
            this.e.Y().setEntranceType(1);
            this.e.Y().setCanNoForum(true);
            this.e.Y().setTransmitForumData("[]");
            this.e.Y().setCallFrom("1");
            this.e.Y().setTopicId(String.valueOf(this.d));
            this.e.Y().setContent(this.c);
            this.e.Y().setIsNoTitle(true);
            this.e.Y().setTitle("");
            this.e.Y().setVoice(null);
            this.e.Y().setVoiceDuringTime(-1);
            if (!this.e.W()) {
                getContext().showToast((int) R.string.write_img_limit);
                return;
            }
            l85 l85Var = this.g;
            if (l85Var != null && l85Var.a()) {
                return;
            }
            m85 m85Var = this.f;
            if (m85Var != null) {
                m85Var.a();
            }
            if (!this.e.k0()) {
            }
        }
    }
}
