package com.baidu.tieba;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbCaptureActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.PicCaptureModeSwitch;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.tieba.yza;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidubce.auth.NTLMEngineImpl;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class tza implements xt5, View.OnClickListener, yza.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int L = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTabInfoData A;
    public int B;
    public int C;
    public Intent D;
    public boolean E;
    public PostPrefixData F;
    public AntiData G;
    public String H;
    public String I;
    public CustomMessageListener J;
    public CustomMessageListener K;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public BaseFragmentActivity f;
    public rza g;
    public pza h;
    public uza i;
    public yza j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948199886, "Lcom/baidu/tieba/tza;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948199886, "Lcom/baidu/tieba/tza;");
        }
    }

    @Override // com.baidu.tieba.xt5
    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xt5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tza a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tza tzaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tzaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tzaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.f != null) {
                this.a.f.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tza a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tza tzaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tzaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tzaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.f != null) {
                this.a.f.closeLoadingDialog();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements uza {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tza a;

        public c(tza tzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tzaVar;
        }

        @Override // com.baidu.tieba.uza
        public boolean a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo != null) {
                    String filePath = imageFileInfo.getFilePath();
                    if (!StringUtils.isNULL(filePath)) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(filePath, options);
                        int i = options.outWidth;
                        if (options.outHeight >= 200 && i >= 200) {
                            return true;
                        }
                    }
                }
                BdToast.makeText(this.a.f, this.a.f.getString(R.string.uploade_attation)).setIcon(BdToast.ToastIcon.FAILURE).show();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tza a;

        public d(tza tzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tzaVar;
        }

        public /* synthetic */ d(tza tzaVar, a aVar) {
            this(tzaVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(this.a.g.m(), true);
                return this.a.g.m().toJsonString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
                this.a.f.setResult(-1, intent);
                this.a.f.finish();
            }
        }
    }

    public tza(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bundle, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = false;
        this.e = false;
        this.k = "";
        this.m = "";
        this.n = "";
        this.o = "0";
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = false;
        this.x = false;
        this.y = true;
        this.z = false;
        this.B = 5;
        this.C = 0;
        this.F = null;
        this.G = null;
        this.H = "";
        this.I = "";
        this.J = new a(this, 2921583);
        this.K = new b(this, 2921614);
        u(baseFragmentActivity, i, i2);
        if (bundle == null) {
            x(this.f.getIntent());
        } else {
            y(bundle);
        }
        T(0, this.a);
        BaseFragmentActivity baseFragmentActivity2 = this.f;
        if (baseFragmentActivity2 != null) {
            baseFragmentActivity2.registerListener(this.J);
            this.f.registerListener(this.K);
        }
    }

    public void R(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, navigationBar) == null) && navigationBar != null) {
            this.h.L(navigationBar);
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i == 1) {
                T(i, this.b);
            } else {
                T(i, this.a);
            }
        }
    }

    public final void X(int i) {
        rza rzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && this.h != null && (rzaVar = this.g) != null) {
            rzaVar.B(!rzaVar.s());
            O();
            e(i);
        }
    }

    public boolean k(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            this.g.w(null);
            this.g.c(imageFileInfo);
            O();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, intent) == null) {
            p(intent, "", null);
        }
    }

    @Override // com.baidu.tieba.xt5
    public void r(int i) {
        pza pzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && (pzaVar = this.h) != null) {
            pzaVar.onChangeSkinType(i);
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.closeLoadingDialog();
            int i = this.c;
            if (i == 0) {
                rza rzaVar = this.g;
                if (rzaVar != null) {
                    rzaVar.A(null);
                }
                m();
            } else if (i == 1) {
                S(0);
            }
        }
    }

    public void I() {
        yza yzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (yzaVar = this.j) != null) {
            yzaVar.o();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            yza yzaVar = this.j;
            if (yzaVar != null) {
                yzaVar.p();
            }
            if (this.e) {
                this.f.finish();
            }
        }
    }

    public final void K() {
        pza pzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (pzaVar = this.h) != null) {
            pzaVar.I();
        }
    }

    public void O() {
        rza rzaVar;
        pza pzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (rzaVar = this.g) != null && (pzaVar = this.h) != null) {
            pzaVar.K(rzaVar.s());
        }
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.f, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f);
        }
        return invokeV.booleanValue;
    }

    public final void U() {
        pza pzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (pzaVar = this.h) != null) {
            pzaVar.N();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.p == 2) {
            this.i = new c(this);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            U();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            K();
            yza yzaVar = this.j;
            if (yzaVar != null) {
                yzaVar.n();
            }
            this.e = false;
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public rza t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.g;
        }
        return (rza) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public final void B() {
        rza rzaVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (rzaVar = this.g) != null && (m = rzaVar.m()) != null && m.getChosedFiles() != null && m.getChosedFiles().size() >= 1) {
            boolean booleanExtra = this.f.getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            VideoCoverSelectActivityConfig videoCoverSelectActivityConfig = new VideoCoverSelectActivityConfig(this.f);
            videoCoverSelectActivityConfig.setImagePath(m.getChosedFiles().getFirst().getFilePath());
            videoCoverSelectActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
            videoCoverSelectActivityConfig.setVideoType(this.w);
            this.f.sendMessage(new CustomMessage(2002001, videoCoverSelectActivityConfig));
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.d = true;
            U();
            this.f.closeLoadingDialog();
            this.f.dismissAllDialog();
            sza.f().e();
            pza pzaVar = this.h;
            if (pzaVar != null) {
                pzaVar.onDestroy();
            }
            yza yzaVar = this.j;
            if (yzaVar != null) {
                yzaVar.m();
            }
            Intent intent = new Intent();
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.g.m().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            intent.putExtra("from_type", this.C);
            Intent intent2 = this.D;
            if (intent2 != null && !StringUtils.isNull(intent2.getStringExtra("file_name"))) {
                intent.putExtra("file_name", this.D.getStringExtra("file_name"));
            }
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    public final void C() {
        rza rzaVar;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (rzaVar = this.g) == null || (m = rzaVar.m()) == null) {
            return;
        }
        this.f.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f, CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, m, q())));
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.f, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(this.f, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f);
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Intent intent = new Intent();
            String k = this.g.k();
            if (TextUtils.isEmpty(k)) {
                k = "";
            }
            intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, k);
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            this.f.setResult(0, intent);
            this.f.finish();
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            rza rzaVar = this.g;
            if (rzaVar == null || ListUtils.getCount(rzaVar.g()) == 0) {
                return false;
            }
            int i = 0;
            for (ImageFileInfo imageFileInfo : this.g.g()) {
                if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                    return false;
                }
            }
            if (i != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xt5
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            pza pzaVar = this.h;
            if (pzaVar == null || pzaVar.E() == null || this.h.E().x2() == null) {
                return true;
            }
            if (this.h.E().x2().getFirstVisiblePosition() == 0 && !this.h.E().x2().canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.f.getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false) && this.g.D() == (l = this.g.l()) && l == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.g.g(), 0);
                    if (k(imageFileInfo)) {
                        N(imageFileInfo, false);
                        M(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            rza rzaVar = this.g;
            if (rzaVar != null && ListUtils.getCount(rzaVar.g()) != 0) {
                for (int i = 0; i < ListUtils.getCount(this.g.g()); i++) {
                    ImageFileInfo imageFileInfo = this.g.g().get(i);
                    if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                        return i;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void G(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        pza pzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048582, this, i, strArr, iArr) == null) && (pzaVar = this.h) != null) {
            pzaVar.J();
        }
    }

    public final void u(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048623, this, baseFragmentActivity, i, i2) == null) {
            this.f = baseFragmentActivity;
            this.a = i;
            this.b = i2;
            pza pzaVar = new pza(baseFragmentActivity.getPageContext(), this);
            this.h = pzaVar;
            pzaVar.H();
        }
    }

    public void H(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.g.m().toJsonString());
            bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.x);
            bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            bundle.putString("forum_id", this.o);
            bundle.putString("forum_name", this.n);
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.q);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, this.y);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, this.z);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.r);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, this.s);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_GIF, this.t);
            bundle.putBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, this.v);
            bundle.putInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, this.w);
            bundle.putInt(IntentConfig.KEY_FROM_WRITE_TYPE, this.B);
            bundle.putSerializable("tab_list", this.A);
            bundle.putSerializable("anti_data", this.G);
            bundle.putSerializable(BaseWriteConfig.PREFIX_DATA, this.F);
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.H);
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.I);
        }
    }

    public boolean d(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            int l = this.g.l();
            if (this.g.D() < l) {
                uza uzaVar = this.i;
                if (uzaVar != null && !uzaVar.a(imageFileInfo)) {
                    return false;
                }
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                imageFileInfo2.setIsHeif(imageFileInfo.isHeif());
                this.g.w(null);
                this.g.a(imageFileInfo2);
                O();
                return true;
            } else if (l()) {
                return d(imageFileInfo);
            } else {
                String format = String.format(this.f.getString(R.string.max_choose_image_count), Integer.valueOf(l));
                if (l == L) {
                    new BdTopToast(this.f).setIcon(false).setContent(format).show((ViewGroup) this.f.findViewById(R.id.suspend_root_view));
                } else {
                    this.f.showToast(format);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void L(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            this.D = intent;
            if (intent != null && this.g != null) {
                String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                if (stringExtra != null) {
                    WriteImagesInfo m = this.g.m();
                    m.parseJson(stringExtra);
                    m.updateQuality();
                    o(intent);
                    return;
                } else if (intent != null && !StringUtils.isNull(intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH))) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH, intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH));
                    this.f.setResult(-1, intent2);
                    this.f.finish();
                    return;
                } else {
                    return;
                }
            }
            o(null);
        }
    }

    public final void e(int i) {
        rza rzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && (rzaVar = this.g) != null && rzaVar.s() && !StringUtils.isNull(this.m, true) && !StringUtils.isNull(this.o, true)) {
            TiebaStatic.log(new StatisticItem("c10349").param("fid", this.o).param("obj_type", this.m).param("obj_locate", i));
        }
    }

    public void n(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, imageFileInfo) != null) || imageFileInfo == null) {
            return;
        }
        Intent intent = new Intent();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        linkedList.add(imageFileInfo);
        this.g.m().setChosedFiles(linkedList);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.g.m().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
        intent.putExtra("from_type", this.C);
        this.f.setResult(-1, intent);
        this.f.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
            if (view2 == this.h.y()) {
                j();
            } else if (view2 == this.h.x()) {
                j();
            } else if (view2 == this.h.u()) {
                rza rzaVar = this.g;
                if (rzaVar != null) {
                    rzaVar.A(null);
                }
                m();
            } else if (view2 == this.h.t()) {
                T(0, this.a);
            } else if (view2 == this.h.G()) {
                X(2);
            } else if (view2 == this.h.F()) {
                X(1);
            }
        }
    }

    public final void M(ImageFileInfo imageFileInfo, boolean z) {
        pza pzaVar;
        Fragment C;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, imageFileInfo, z) == null) && (pzaVar = this.h) != null && (C = pzaVar.C(1)) != null && (C instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) C).n2(imageFileInfo, z);
        }
    }

    public void N(ImageFileInfo imageFileInfo, boolean z) {
        pza pzaVar;
        Fragment C;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, imageFileInfo, z) == null) && (pzaVar = this.h) != null && (C = pzaVar.C(0)) != null && (C instanceof ImageListFragment)) {
            ((ImageListFragment) C).C2(imageFileInfo, z);
        }
    }

    @Override // com.baidu.tieba.yza.d
    public void a(String str, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, videoInfo) == null) {
            p(null, str, videoInfo);
        }
    }

    public final void T(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048595, this, i, i2) != null) || this.d) {
            return;
        }
        FragmentTransaction beginTransaction = this.f.getSupportFragmentManager().beginTransaction();
        Fragment findFragmentByTag = this.f.getSupportFragmentManager().findFragmentByTag(this.h.D(this.c));
        if (findFragmentByTag != null) {
            beginTransaction.hide(findFragmentByTag);
        }
        this.c = i;
        if (this.f.getSupportFragmentManager().findFragmentByTag(this.h.D(i)) != null) {
            beginTransaction.show(this.h.C(i));
        } else {
            beginTransaction.add(i2, this.h.C(i), this.h.D(i));
        }
        beginTransaction.commitAllowingStateLoss();
        this.f.getSupportFragmentManager().executePendingTransactions();
    }

    public void Y(TbPageContext tbPageContext) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, tbPageContext) == null) {
            int i2 = 2;
            if (this.r && this.s) {
                if (P()) {
                    return;
                }
                this.f.showLoadingDialog(null);
                TbCaptureActivityConfig tbCaptureActivityConfig = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                tbCaptureActivityConfig.getIntent().putExtras(this.f.getIntent());
                tbCaptureActivityConfig.setCaptureType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig));
                this.e = true;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
                if (WorkPublishManager.isWorkPublishLocate()) {
                    if (!WorkPublishManager.isWorkPublishLocateVideoCenter()) {
                        i2 = 1;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 1).param("obj_source", i2));
                }
            } else if (!WriteVideoUtil.isTbVideoAviable() || Q()) {
            } else {
                ForumWriteData forumWriteData = new ForumWriteData(this.o, this.n, null, null);
                forumWriteData.statisticFrom = this.l;
                this.f.showLoadingDialog(null);
                int i3 = 3;
                if (PicCaptureModeSwitch.Companion.isOn()) {
                    TbCaptureActivityConfig tbCaptureActivityConfig2 = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                    Intent intent = tbCaptureActivityConfig2.getIntent();
                    if (this.B != 5) {
                        i3 = 2;
                    }
                    intent.putExtra("entrance_flag", i3);
                    tbCaptureActivityConfig2.getIntent().putExtra("forum_write_data", forumWriteData);
                    tbCaptureActivityConfig2.getIntent().putExtras(this.f.getIntent());
                    tbCaptureActivityConfig2.getIntent().putExtra("write_image_info", this.g.m());
                    tbCaptureActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
                    tbCaptureActivityConfig2.setCaptureType(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig2));
                } else {
                    if (this.B != 5) {
                        i = 2;
                    } else {
                        i = 3;
                    }
                    RecordVideoActivityConfig.b bVar = new RecordVideoActivityConfig.b(i, forumWriteData, this.g.m(), "", this.C);
                    bVar.b(this.f.getIntent());
                    bVar.d(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, bVar));
                    this.e = false;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
            }
        }
    }

    public void j() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.p == 3) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
            }
            int i = this.p;
            if (i != 5 && i != 6) {
                if (this.g == null) {
                    return;
                }
                yza yzaVar = this.j;
                if (yzaVar != null && yzaVar.l()) {
                    return;
                }
                if (this.g.p()) {
                    VideoFileInfo f = this.g.f();
                    if (this.j == null) {
                        yza yzaVar2 = new yza(this.f, this.n, this.o, "");
                        this.j = yzaVar2;
                        yzaVar2.s(this.A);
                        this.j.r(this.G, this.F, this.H, this.I);
                        pza pzaVar = this.h;
                        if (pzaVar != null) {
                            pzaVar.M(this.j);
                        }
                    }
                    this.j.u(this.l);
                    this.j.t(this);
                    this.j.j(f, this.k, this.m);
                    return;
                }
                if (this.g.m() != null && ListUtils.isNotEmpty(this.g.m().getChosedFiles())) {
                    Iterator<ImageFileInfo> it = this.g.m().getChosedFiles().iterator();
                    while (it.hasNext()) {
                        ImageFileInfo next = it.next();
                        next.setIsHeif(FileHelper.detectHeifHeader(next.getFilePath()));
                    }
                }
                if (this.u && D()) {
                    C();
                    return;
                } else if (this.B == 4) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f);
                    newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    newInstance.getIntent().setFlags(67108864);
                    newInstance.getIntent().putExtras(this.f.getIntent());
                    WriteActivityConfig type = newInstance.setType(9);
                    if (TextUtils.isEmpty(this.o)) {
                        str = "0";
                    } else {
                        str = this.o;
                    }
                    type.setForumId(str).setWriteImagesInfo(this.g.m()).send();
                    newInstance.setRichModeEnable(this.E);
                    this.f.finish();
                    return;
                } else if (this.v) {
                    B();
                    return;
                } else {
                    o(null);
                    return;
                }
            }
            this.f.showLoadingDialog("正在上传");
            new d(this, null).execute(new String[0]);
        }
    }

    public final void p(Intent intent, String str, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048618, this, intent, str, videoInfo) == null) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.g.m().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            intent2.putExtra("from_type", this.C);
            if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
                intent2.putExtra("file_name", intent.getStringExtra("file_name"));
            }
            intent2.putExtra(IntentConfig.KEY_COVER_PATH, str);
            if (videoInfo != null) {
                intent2.putExtra(IntentConfig.KEY_VIDEO_INFO, videoInfo);
            }
            this.f.setResult(-1, intent2);
            this.f.finish();
            if (AlbumActivityConfig.FROM_FLUTTER.equals(this.m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921464, intent2));
            } else if (AlbumActivityConfig.FROM_FLUTTER_MULTI.equals(this.m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921714, intent2));
            } else if (AlbumActivityConfig.FROM_FLUTTER_GAME_VIDEO.equals(this.m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921737, intent2));
            }
        }
    }

    public final void x(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, intent) == null) {
            this.g = new rza(this.f.getPageContext());
            if (intent != null) {
                this.r = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
                this.s = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, false);
                this.t = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_GIF, true);
                if (this.r && this.s) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.g.C(writeImagesInfo);
                this.g.B(writeImagesInfo.isOriginalImg());
                this.x = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.p = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.m = intent.getStringExtra("from");
                this.o = intent.getStringExtra("forum_id");
                this.n = intent.getStringExtra("forum_name");
                this.q = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.y = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, true);
                this.z = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, false);
                this.u = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
                this.v = intent.getBooleanExtra(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.w = intent.getIntExtra(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                this.B = intent.getIntExtra(IntentConfig.KEY_FROM_WRITE_TYPE, 5);
                this.k = intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM);
                this.l = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
                this.C = intent.getIntExtra("from_type", 0);
                this.A = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
                Serializable serializableExtra = intent.getSerializableExtra("anti_data");
                if (serializableExtra instanceof AntiData) {
                    this.G = (AntiData) serializableExtra;
                }
                Serializable serializableExtra2 = intent.getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
                if (serializableExtra2 instanceof PostPrefixData) {
                    this.F = (PostPrefixData) serializableExtra2;
                }
                this.H = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                this.I = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                this.E = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            i();
        }
    }

    public final void y(Bundle bundle) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            this.g = new rza(this.f.getPageContext());
            if (bundle != null) {
                this.r = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
                this.s = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO);
                this.t = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_GIF);
                this.v = bundle.getBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.w = bundle.getInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                if (this.r && this.s) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.g.C(writeImagesInfo);
                this.x = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.p = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.o = bundle.getString("forum_id");
                this.n = bundle.getString("forum_name");
                this.q = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.B = bundle.getInt(IntentConfig.KEY_FROM_WRITE_TYPE);
                this.y = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE);
                this.z = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE);
                this.k = bundle.getString(BaseWriteConfig.KEY_CALL_FROM);
                this.l = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
                this.C = bundle.getInt("from_type");
                this.A = (FrsTabInfoData) bundle.getSerializable("tab_list");
                this.m = bundle.getString("from");
                Serializable serializable = bundle.getSerializable("anti_data");
                if (serializable instanceof AntiData) {
                    this.G = (AntiData) serializable;
                }
                Serializable serializable2 = bundle.getSerializable(BaseWriteConfig.PREFIX_DATA);
                if (serializable2 instanceof PostPrefixData) {
                    this.F = (PostPrefixData) serializable2;
                }
                this.H = bundle.getString(IntentConfig.FORUM_FIRST_DIR, "");
                this.I = bundle.getString(IntentConfig.FORUM_SECOND_DIR, "");
                this.E = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            i();
        }
    }
}
