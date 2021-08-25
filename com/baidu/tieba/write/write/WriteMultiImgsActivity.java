package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import c.a.q0.b4.u.j;
import c.a.q0.b4.u.k;
import c.a.q0.b4.u.n.b.c;
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
import com.google.protobuf.CodedInputStream;
/* loaded from: classes7.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OUTSTATE_KEY_CURRENT_INDEX = "OutState_Current_Index";
    public static final String OUTSTATE_KEY_WRITE_ENTRANCE = "OutState_Write_Entrance";
    public static final String OUTSTATE_KEY_WRITE_IMG_INFO = "OutState_Write_Img_Info";
    public static final String OUTSTATE_KEY_WRITE_INFO_DATA = "OutState_Write_Info_Data";
    public transient /* synthetic */ FieldHolder $fh;
    public k mControler;
    public j mMainView;

    /* loaded from: classes7.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteMultiImgsActivity f58905a;

        public a(WriteMultiImgsActivity writeMultiImgsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeMultiImgsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58905a = writeMultiImgsActivity;
        }

        @Override // c.a.q0.b4.u.n.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58905a.mControler.s();
                this.f58905a.mControler.r(false);
            }
        }

        @Override // c.a.q0.b4.u.n.b.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f58905a.mControler.A();
            }
        }

        @Override // c.a.q0.b4.u.n.b.c
        public boolean c(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) ? this.f58905a.mControler.q(bitmap) : invokeL.booleanValue;
        }

        @Override // c.a.q0.b4.u.n.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f58905a.mControler.n();
                this.f58905a.mControler.r(true);
            }
        }
    }

    public WriteMultiImgsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void addAction() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (kVar = this.mControler) == null) {
            return;
        }
        kVar.n();
    }

    public void delAction() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (kVar = this.mControler) == null) {
            return;
        }
        kVar.s();
    }

    public void finishActivity(boolean z, WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, writeImagesInfo) == null) {
            k kVar = this.mControler;
            if (kVar != null) {
                if (1 == kVar.u()) {
                    ForumWriteData v = this.mControler.v();
                    if (v != null) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(v).setWriteImagesInfo(writeImagesInfo).send();
                    }
                } else if (2 == this.mControler.u()) {
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this);
                    newInstance.getIntent().setFlags(536870912);
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
                    intent.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).extra);
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            j jVar = this.mMainView;
            if (jVar != null) {
                jVar.h(i2);
            }
            this.mControler.f16465c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            j jVar = new j(getPageContext(), new a(this));
            this.mMainView = jVar;
            setContentView(jVar.k);
            k kVar = new k(getPageContext(), this.mMainView, bundle);
            this.mControler = kVar;
            if (kVar.f16472j != TbadkCoreApplication.getInst().getSkinType()) {
                TbadkCoreApplication.getInst().setSkinType(this.mControler.f16472j);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k kVar = this.mControler;
            if (kVar != null) {
                kVar.t();
            }
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            j jVar = this.mMainView;
            if (jVar != null) {
                jVar.o();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        MultiImagePagerAdapter multiImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            k kVar = this.mControler;
            if (kVar != null && (multiImagePagerAdapter = kVar.f16465c) != null) {
                bundle.putInt(OUTSTATE_KEY_CURRENT_INDEX, multiImagePagerAdapter.j());
                bundle.putInt(OUTSTATE_KEY_WRITE_ENTRANCE, this.mControler.u());
                bundle.putSerializable(OUTSTATE_KEY_WRITE_INFO_DATA, this.mControler.v());
                this.mControler.f16465c.g(true);
                if (this.mControler.w() != null) {
                    bundle.putString(OUTSTATE_KEY_WRITE_IMG_INFO, this.mControler.w().toJsonString());
                }
            }
            super.onSaveInstanceState(bundle);
        }
    }
}
