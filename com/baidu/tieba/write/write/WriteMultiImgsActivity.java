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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.nga;
import com.baidu.tieba.oga;
import com.baidu.tieba.rja;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nga a;
    public oga b;

    /* loaded from: classes8.dex */
    public class a implements rja {
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

        @Override // com.baidu.tieba.rja
        public boolean c(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                return this.a.b.p(bitmap);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.rja
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.r();
                this.a.b.q(false);
            }
        }

        @Override // com.baidu.tieba.rja
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b.z();
            }
        }

        @Override // com.baidu.tieba.rja
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
            oga ogaVar = this.b;
            if (ogaVar != null) {
                ogaVar.s();
            }
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            nga ngaVar = this.a;
            if (ngaVar != null) {
                ngaVar.o();
            }
            super.onDestroy();
        }
    }

    public void y1() {
        oga ogaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ogaVar = this.b) != null) {
            ogaVar.m();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            nga ngaVar = this.a;
            if (ngaVar != null) {
                ngaVar.h(i);
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
            nga ngaVar = new nga(getPageContext(), new a(this));
            this.a = ngaVar;
            setContentView(ngaVar.k);
            oga ogaVar = new oga(getPageContext(), this.a, bundle);
            this.b = ogaVar;
            if (ogaVar.j != TbadkCoreApplication.getInst().getSkinType()) {
                TbadkCoreApplication.getInst().setSkinType(this.b.j);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        MultiImagePagerAdapter multiImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            oga ogaVar = this.b;
            if (ogaVar != null && (multiImagePagerAdapter = ogaVar.c) != null) {
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

    public void z1(boolean z, WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, writeImagesInfo) == null) {
            oga ogaVar = this.b;
            if (ogaVar != null) {
                if (1 == ogaVar.t()) {
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
