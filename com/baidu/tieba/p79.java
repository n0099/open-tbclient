package com.baidu.tieba;

import android.app.Activity;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.u79;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class p79 implements kg5, View.OnClickListener, u79.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int M = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTabInfoData A;
    public int B;
    public int C;
    public int D;
    public Intent E;
    public boolean F;
    public PostPrefixData G;
    public AntiData H;
    public String I;
    public String J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public BaseFragmentActivity f;
    public n79 g;
    public l79 h;
    public q79 i;
    public u79 j;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948015095, "Lcom/baidu/tieba/p79;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948015095, "Lcom/baidu/tieba/p79;");
        }
    }

    @Override // com.baidu.tieba.kg5
    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kg5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p79 p79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p79Var, Integer.valueOf(i)};
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
            this.a = p79Var;
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

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p79 p79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p79Var, Integer.valueOf(i)};
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
            this.a = p79Var;
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

    /* loaded from: classes5.dex */
    public class c implements q79 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p79 a;

        public c(p79 p79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p79Var;
        }

        @Override // com.baidu.tieba.q79
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
                BdToast b = BdToast.b(this.a.f, this.a.f.getString(R.string.uploade_attation));
                b.f(BdToast.ToastIcon.FAILURE);
                b.i();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p79 a;

        public d(p79 p79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p79Var;
        }

        public /* synthetic */ d(p79 p79Var, a aVar) {
            this(p79Var);
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

    public p79(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
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
        this.D = -1;
        this.G = null;
        this.H = null;
        this.I = "";
        this.J = "";
        this.K = new a(this, 2921583);
        this.L = new b(this, 2921614);
        v(baseFragmentActivity, i, i2);
        if (bundle == null) {
            w(this.f.getIntent());
        } else {
            x(bundle);
        }
        U(0, this.a);
        BaseFragmentActivity baseFragmentActivity2 = this.f;
        if (baseFragmentActivity2 != null) {
            baseFragmentActivity2.registerListener(this.K);
            this.f.registerListener(this.L);
        }
    }

    public void S(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, navigationBar) == null) && navigationBar != null) {
            this.h.y(navigationBar);
        }
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i == 1) {
                U(i, this.b);
            } else {
                U(i, this.a);
            }
        }
    }

    public final void W(int i) {
        n79 n79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && this.h != null && (n79Var = this.g) != null) {
            n79Var.B(!n79Var.s());
            P();
            e(i);
        }
    }

    public boolean k(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            this.g.w(null);
            this.g.c(imageFileInfo);
            P();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kg5
    public void o(int i) {
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && (l79Var = this.h) != null) {
            l79Var.onChangeSkinType(i);
        }
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, intent) == null) {
            q(intent, "", null);
        }
    }

    public final void A() {
        n79 n79Var;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (n79Var = this.g) != null && (m = n79Var.m()) != null && m.getChosedFiles() != null && m.getChosedFiles().size() >= 1) {
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
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.d = true;
            V();
            this.f.closeLoadingDialog();
            this.f.dismissAllDialog();
            o79.f().e();
            l79 l79Var = this.h;
            if (l79Var != null) {
                l79Var.u();
            }
            u79 u79Var = this.j;
            if (u79Var != null) {
                u79Var.m();
            }
            Intent intent = new Intent();
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.g.m().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            intent.putExtra("from_type", this.C);
            Intent intent2 = this.E;
            if (intent2 != null && !StringUtils.isNull(intent2.getStringExtra("file_name"))) {
                intent.putExtra("file_name", this.E.getStringExtra("file_name"));
            }
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    public final void B() {
        n79 n79Var;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (n79Var = this.g) == null || (m = n79Var.m()) == null) {
            return;
        }
        this.f.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f, 12012, m, r())));
    }

    public final boolean Q() {
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
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n79 n79Var = this.g;
            if (n79Var == null || ListUtils.getCount(n79Var.g()) == 0) {
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

    public final boolean l() {
        InterceptResult invokeV;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.f.getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false) && this.g.D() == (l = this.g.l()) && l == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.g.g(), 0);
                    if (k(imageFileInfo)) {
                        O(imageFileInfo, false);
                        N(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            n79 n79Var = this.g;
            if (n79Var != null && ListUtils.getCount(n79Var.g()) != 0) {
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

    @Override // com.baidu.tieba.kg5
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            l79 l79Var = this.h;
            if (l79Var == null || l79Var.q() == null || this.h.q().Y1() == null) {
                return true;
            }
            if (this.h.q().Y1().getFirstVisiblePosition() == 0 && !this.h.q().Y1().canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.closeLoadingDialog();
            int i = this.c;
            if (i == 0) {
                n79 n79Var = this.g;
                if (n79Var != null) {
                    n79Var.A(null);
                }
                m();
            } else if (i == 1) {
                T(0);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            V();
        }
    }

    public void H() {
        u79 u79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (u79Var = this.j) != null) {
            u79Var.o();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            u79 u79Var = this.j;
            if (u79Var != null) {
                u79Var.p();
            }
            if (this.e) {
                this.f.finish();
            }
        }
    }

    public final void K() {
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (l79Var = this.h) != null) {
            l79Var.v();
        }
    }

    public void P() {
        n79 n79Var;
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (n79Var = this.g) != null && (l79Var = this.h) != null) {
            l79Var.x(n79Var.s());
        }
    }

    public final boolean R() {
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

    public final void V() {
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (l79Var = this.h) != null) {
            l79Var.A();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.p == 2) {
            this.i = new c(this);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            K();
            u79 u79Var = this.j;
            if (u79Var != null) {
                u79Var.n();
            }
            this.e = false;
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public n79 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.g;
        }
        return (n79) invokeV.objValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public void F(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        l79 l79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048581, this, i, strArr, iArr) == null) && (l79Var = this.h) != null) {
            l79Var.w();
        }
    }

    public final void v(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048622, this, baseFragmentActivity, i, i2) == null) {
            this.f = baseFragmentActivity;
            this.a = i;
            this.b = i2;
            l79 l79Var = new l79(baseFragmentActivity.getPageContext(), this);
            this.h = l79Var;
            l79Var.t();
        }
    }

    public void G(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
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
            bundle.putSerializable("anti_data", this.H);
            bundle.putSerializable(BaseWriteConfig.PREFIX_DATA, this.G);
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.I);
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.J);
        }
    }

    public boolean d(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            int l = this.g.l();
            if (this.g.D() < l) {
                q79 q79Var = this.i;
                if (q79Var != null && !q79Var.a(imageFileInfo)) {
                    return false;
                }
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.g.w(null);
                this.g.a(imageFileInfo2);
                P();
                return true;
            } else if (l()) {
                return d(imageFileInfo);
            } else {
                String format = String.format(this.f.getString(R.string.max_choose_image_count), Integer.valueOf(l));
                if (l == M) {
                    BdTopToast bdTopToast = new BdTopToast(this.f);
                    bdTopToast.h(false);
                    bdTopToast.g(format);
                    bdTopToast.i((ViewGroup) this.f.findViewById(R.id.suspend_root_view));
                } else {
                    this.f.showToast(format);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void M(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            this.E = intent;
            if (intent != null && this.g != null) {
                String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                if (stringExtra != null) {
                    WriteImagesInfo m = this.g.m();
                    m.parseJson(stringExtra);
                    m.updateQuality();
                    p(intent);
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
            p(null);
        }
    }

    public final void e(int i) {
        n79 n79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i) == null) && (n79Var = this.g) != null && n79Var.s() && !StringUtils.isNull(this.m, true) && !StringUtils.isNull(this.o, true)) {
            TiebaStatic.log(new StatisticItem("c10349").param("fid", this.o).param("obj_type", this.m).param("obj_locate", i));
        }
    }

    public void n(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, imageFileInfo) != null) || imageFileInfo == null) {
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
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            if (view2 == this.h.m()) {
                j();
            } else if (view2 == this.h.l()) {
                j();
            } else if (view2 == this.h.k()) {
                n79 n79Var = this.g;
                if (n79Var != null) {
                    n79Var.A(null);
                }
                m();
            } else if (view2 == this.h.g()) {
                U(0, this.a);
            } else if (view2 == this.h.s()) {
                W(2);
            } else if (view2 == this.h.r()) {
                W(1);
            }
        }
    }

    public final void N(ImageFileInfo imageFileInfo, boolean z) {
        l79 l79Var;
        Fragment o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, imageFileInfo, z) == null) && (l79Var = this.h) != null && (o = l79Var.o(1)) != null && (o instanceof AlbumImageBrowseFragment)) {
            ((AlbumImageBrowseFragment) o).O1(imageFileInfo, z);
        }
    }

    public void O(ImageFileInfo imageFileInfo, boolean z) {
        l79 l79Var;
        Fragment o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, imageFileInfo, z) == null) && (l79Var = this.h) != null && (o = l79Var.o(0)) != null && (o instanceof ImageListFragment)) {
            ((ImageListFragment) o).d2(imageFileInfo, z);
        }
    }

    @Override // com.baidu.tieba.u79.d
    public void a(String str, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, videoInfo) == null) {
            q(null, str, videoInfo);
        }
    }

    public final void U(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048595, this, i, i2) != null) || this.d) {
            return;
        }
        FragmentTransaction beginTransaction = this.f.getSupportFragmentManager().beginTransaction();
        Fragment findFragmentByTag = this.f.getSupportFragmentManager().findFragmentByTag(this.h.p(this.c));
        if (findFragmentByTag != null) {
            beginTransaction.hide(findFragmentByTag);
        }
        this.c = i;
        if (this.f.getSupportFragmentManager().findFragmentByTag(this.h.p(i)) != null) {
            beginTransaction.show(this.h.o(i));
        } else {
            beginTransaction.add(i2, this.h.o(i), this.h.p(i));
        }
        beginTransaction.commitAllowingStateLoss();
        this.f.getSupportFragmentManager().executePendingTransactions();
    }

    public void X(TbPageContext tbPageContext) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, tbPageContext) == null) {
            int i2 = 2;
            if (this.r && this.s) {
                if (Q()) {
                    return;
                }
                this.f.showLoadingDialog(null);
                TbCaptureActivityConfig tbCaptureActivityConfig = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                tbCaptureActivityConfig.getIntent().putExtras(this.f.getIntent());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig));
                this.e = true;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
                if (WorkPublishManager.isWorkPublishLocate()) {
                    if (!WorkPublishManager.isWorkPublishLocateVideoCenter()) {
                        i2 = 1;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 1).param("obj_source", i2));
                }
            } else if (!i79.d() || R()) {
            } else {
                ForumWriteData forumWriteData = new ForumWriteData(this.o, this.n, null, null);
                forumWriteData.statisticFrom = this.l;
                this.f.showLoadingDialog(null);
                Activity pageActivity = tbPageContext.getPageActivity();
                if (this.B != 5) {
                    i = 2;
                } else {
                    i = 3;
                }
                RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(pageActivity, i, forumWriteData, this.g.m(), "", this.C);
                recordVideoActivityConfig.getIntent().putExtras(this.f.getIntent());
                recordVideoActivityConfig.setShowType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
                this.e = false;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
            }
        }
    }

    public final void w(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, intent) == null) {
            this.g = new n79(this.f.getPageContext());
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
                this.D = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializableExtra = intent.getSerializableExtra("anti_data");
                if (serializableExtra instanceof AntiData) {
                    this.H = (AntiData) serializableExtra;
                }
                Serializable serializableExtra2 = intent.getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
                if (serializableExtra2 instanceof PostPrefixData) {
                    this.G = (PostPrefixData) serializableExtra2;
                }
                this.I = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                this.J = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                this.F = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            i();
        }
    }

    public final void x(Bundle bundle) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) {
            this.g = new n79(this.f.getPageContext());
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
                this.D = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializable = bundle.getSerializable("anti_data");
                if (serializable instanceof AntiData) {
                    this.H = (AntiData) serializable;
                }
                Serializable serializable2 = bundle.getSerializable(BaseWriteConfig.PREFIX_DATA);
                if (serializable2 instanceof PostPrefixData) {
                    this.G = (PostPrefixData) serializable2;
                }
                this.I = bundle.getString(IntentConfig.FORUM_FIRST_DIR, "");
                this.J = bundle.getString(IntentConfig.FORUM_SECOND_DIR, "");
                this.F = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            i();
        }
    }

    public void j() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.p == 3) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
            }
            int i = this.p;
            if (i != 5 && i != 6) {
                if (this.g == null) {
                    return;
                }
                u79 u79Var = this.j;
                if (u79Var != null && u79Var.l()) {
                    return;
                }
                if (this.g.p()) {
                    VideoFileInfo f = this.g.f();
                    if (this.j == null) {
                        u79 u79Var2 = new u79(this.f, this.n, this.o, "");
                        this.j = u79Var2;
                        u79Var2.s(this.A);
                        this.j.r(this.H, this.G, this.I, this.J);
                        l79 l79Var = this.h;
                        if (l79Var != null) {
                            l79Var.z(this.j);
                        }
                    }
                    this.j.u(this.D);
                    this.j.v(this.l);
                    this.j.t(this);
                    this.j.j(f, this.k, this.m);
                    return;
                } else if (this.u && C()) {
                    B();
                    return;
                } else if (this.B == 4) {
                    if (WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f);
                    newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    newInstance.getIntent().putExtras(this.f.getIntent());
                    WriteActivityConfig type = newInstance.setType(9);
                    if (TextUtils.isEmpty(this.o)) {
                        str = "0";
                    } else {
                        str = this.o;
                    }
                    type.setForumId(str).setWriteImagesInfo(this.g.m()).send();
                    newInstance.setRichModeEnable(this.F);
                    this.f.finish();
                    return;
                } else if (this.v) {
                    A();
                    return;
                } else {
                    p(null);
                    return;
                }
            }
            this.f.showLoadingDialog("正在上传");
            new d(this, null).execute(new String[0]);
        }
    }

    public final void q(Intent intent, String str, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, intent, str, videoInfo) == null) {
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
}
