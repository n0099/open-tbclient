package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import com.repackage.h19;
import com.repackage.i19;
import com.repackage.o19;
/* loaded from: classes4.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OUTSTATE_KEY_CURRENT_INDEX = "OutState_Current_Index";
    public static final String OUTSTATE_KEY_WRITE_ENTRANCE = "OutState_Write_Entrance";
    public static final String OUTSTATE_KEY_WRITE_IMG_INFO = "OutState_Write_Img_Info";
    public static final String OUTSTATE_KEY_WRITE_INFO_DATA = "OutState_Write_Info_Data";
    public transient /* synthetic */ FieldHolder $fh;
    public i19 mControler;
    public h19 mMainView;

    /* loaded from: classes4.dex */
    public class a implements o19 {
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

        @Override // com.repackage.o19
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mControler.s();
                this.a.mControler.r(false);
            }
        }

        @Override // com.repackage.o19
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mControler.A();
            }
        }

        @Override // com.repackage.o19
        public boolean c(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) ? this.a.mControler.q(bitmap) : invokeL.booleanValue;
        }

        @Override // com.repackage.o19
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.mControler.n();
                this.a.mControler.r(true);
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

    public void addAction() {
        i19 i19Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i19Var = this.mControler) == null) {
            return;
        }
        i19Var.n();
    }

    public void delAction() {
        i19 i19Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i19Var = this.mControler) == null) {
            return;
        }
        i19Var.s();
    }

    public void finishActivity(boolean z, WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, writeImagesInfo) == null) {
            i19 i19Var = this.mControler;
            if (i19Var != null) {
                if (1 == i19Var.u()) {
                    ForumWriteData v = this.mControler.v();
                    if (v != null) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(v).setWriteImagesInfo(writeImagesInfo).send();
                    }
                } else if (2 == this.mControler.u()) {
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this);
                    newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    newInstance.getIntent().putExtras(getIntent());
                    newInstance.setType(9).setWriteImagesInfo(writeImagesInfo).setNeedClosePrePage(true);
                    newInstance.getIntent().putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
                    newInstance.send();
                    finish();
                    return;
                }
            }
            if (!z) {
                setResult(0);
            } else if (writeImagesInfo == null) {
                return;
            } else {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
                if (!ListUtils.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                    intent.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).getExtra());
                }
                setResult(-1, intent);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            setResult(0);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            h19 h19Var = this.mMainView;
            if (h19Var != null) {
                h19Var.h(i);
            }
            this.mControler.c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            h19 h19Var = new h19(getPageContext(), new a(this));
            this.mMainView = h19Var;
            setContentView(h19Var.k);
            i19 i19Var = new i19(getPageContext(), this.mMainView, bundle);
            this.mControler = i19Var;
            if (i19Var.j != TbadkCoreApplication.getInst().getSkinType()) {
                TbadkCoreApplication.getInst().setSkinType(this.mControler.j);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i19 i19Var = this.mControler;
            if (i19Var != null) {
                i19Var.t();
            }
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            h19 h19Var = this.mMainView;
            if (h19Var != null) {
                h19Var.o();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        MultiImagePagerAdapter multiImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            i19 i19Var = this.mControler;
            if (i19Var != null && (multiImagePagerAdapter = i19Var.c) != null) {
                bundle.putInt(OUTSTATE_KEY_CURRENT_INDEX, multiImagePagerAdapter.k());
                bundle.putInt(OUTSTATE_KEY_WRITE_ENTRANCE, this.mControler.u());
                bundle.putSerializable(OUTSTATE_KEY_WRITE_INFO_DATA, this.mControler.v());
                this.mControler.c.h(true);
                if (this.mControler.w() != null) {
                    bundle.putString(OUTSTATE_KEY_WRITE_IMG_INFO, this.mControler.w().toJsonString());
                }
            }
            super.onSaveInstanceState(bundle);
        }
    }
}
