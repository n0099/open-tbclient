package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.b7b;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.v3b;
import com.baidu.tieba.w3b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v3b a;
    public w3b b;

    /* loaded from: classes8.dex */
    public class a implements b7b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteMultiImgsActivity a;

        public a(WriteMultiImgsActivity writeMultiImgsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeMultiImgsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeMultiImgsActivity;
        }

        @Override // com.baidu.tieba.b7b
        public boolean c(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                return this.a.b.p(bitmap);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.b7b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.r();
                this.a.b.q(false);
            }
        }

        @Override // com.baidu.tieba.b7b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b.z();
            }
        }

        @Override // com.baidu.tieba.b7b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.b.m();
                this.a.b.q(true);
            }
        }
    }

    public WriteMultiImgsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onBackPressed();
            setResult(0);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w3b w3bVar = this.b;
            if (w3bVar != null) {
                w3bVar.s();
            }
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            v3b v3bVar = this.a;
            if (v3bVar != null) {
                v3bVar.o();
            }
            super.onDestroy();
        }
    }

    public void p1() {
        w3b w3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (w3bVar = this.b) != null) {
            w3bVar.m();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            v3b v3bVar = this.a;
            if (v3bVar != null) {
                v3bVar.h(i);
            }
            this.b.c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            v3b v3bVar = new v3b(getPageContext(), new a(this));
            this.a = v3bVar;
            setContentView(v3bVar.k);
            w3b w3bVar = new w3b(getPageContext(), this.a, bundle);
            this.b = w3bVar;
            if (w3bVar.j != TbadkCoreApplication.getInst().getSkinType()) {
                TbadkCoreApplication.getInst().setSkinType(this.b.j);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        MultiImagePagerAdapter multiImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            w3b w3bVar = this.b;
            if (w3bVar != null && (multiImagePagerAdapter = w3bVar.c) != null) {
                bundle.putInt("OutState_Current_Index", multiImagePagerAdapter.j());
                bundle.putInt("OutState_Write_Entrance", this.b.t());
                bundle.putSerializable("OutState_Write_Info_Data", this.b.u());
                this.b.c.g(true);
                if (this.b.v() != null) {
                    bundle.putString("OutState_Write_Img_Info", this.b.v().toJsonString());
                }
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void q1(boolean z, WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, writeImagesInfo) == null) {
            if (writeImagesInfo != null && ListUtils.isNotEmpty(writeImagesInfo.getChosedFiles())) {
                Iterator<ImageFileInfo> it = writeImagesInfo.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    next.setIsHeif(FileHelper.detectHeifHeader(next.getFilePath()));
                }
            }
            w3b w3bVar = this.b;
            if (w3bVar != null) {
                if (1 == w3bVar.t()) {
                    ForumWriteData u = this.b.u();
                    if (u != null) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(u).setWriteImagesInfo(writeImagesInfo).send();
                    }
                } else if (2 == this.b.t()) {
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this);
                    newInstance.getIntent().setFlags(603979776);
                    newInstance.getIntent().putExtras(getIntent());
                    newInstance.setType(9).setWriteImagesInfo(writeImagesInfo).setNeedClosePrePage(true);
                    newInstance.getIntent().putExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, writeImagesInfo.toJsonString());
                    newInstance.send();
                    finish();
                    return;
                }
            }
            if (z) {
                if (writeImagesInfo == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
                if (!ListUtils.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                    intent.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).getExtra());
                }
                setResult(-1, intent);
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
