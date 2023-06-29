package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.mutiprocess.event.CollectEmotionEvent;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.g55;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.r55;
import com.baidu.tieba.tba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class yc8 implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageViewerActivity a;
    public MultiImageView b;
    public PermissionJudgePolicy c;
    public k d;
    public String e;
    public tba f;
    public p55 g;
    public r55 h;
    public List<n55> i;
    public n55 j;
    public n55 k;
    public n55 l;
    public n55 m;
    public n55 n;
    public n55 o;
    public vc8 p;
    public HashMap<String, Boolean> q;
    public CustomMessageListener r;
    public tp5 s;
    public r55.e t;
    public r55.e u;
    public r55.e v;
    public r55.e w;
    public r55.e x;
    public r55.e y;
    public View.OnClickListener z;

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class j implements r55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        /* loaded from: classes8.dex */
        public class a implements tba.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ j b;

            /* renamed from: com.baidu.tieba.yc8$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0537a implements g55.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0537a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.baidu.tieba.g55.e
                public void onClick(g55 g55Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                        g55Var.dismiss();
                        a aVar = this.a;
                        aVar.b.a.B(aVar.a);
                    }
                }
            }

            /* loaded from: classes8.dex */
            public class b implements g55.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.g55.e
                public void onClick(g55 g55Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                        g55Var.dismiss();
                    }
                }
            }

            /* loaded from: classes8.dex */
            public class c implements g55.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public c(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.g55.e
                public void onClick(g55 g55Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                        g55Var.dismiss();
                    }
                }
            }

            public a(j jVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = str;
            }

            @Override // com.baidu.tieba.tba.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g55 g55Var = new g55(this.b.a.a.getPageContext().getPageActivity());
                    g55Var.setTitle((String) null);
                    g55Var.setMessageShowCenter(true);
                    g55Var.setMessage(this.b.a.v(R.string.qr_url_risk_forbid));
                    g55Var.setPositiveButton(this.b.a.v(R.string.qr_url_risk_forbid_button), new c(this));
                    g55Var.setCancelable(false);
                    g55Var.setCanceledOnTouchOutside(false);
                    g55Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.baidu.tieba.tba.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    g55 g55Var = new g55(this.b.a.a.getPageContext().getPageActivity());
                    g55Var.setTitleShowCenter(true);
                    g55Var.setTitle(this.b.a.v(R.string.qr_url_jump_external_title));
                    g55Var.setMessageShowCenter(true);
                    g55Var.setMessage(this.b.a.v(R.string.qr_url_jump_external_message));
                    g55Var.setPositiveButton(this.b.a.v(R.string.obfuscated_res_0x7f0f04be), new C0537a(this));
                    g55Var.setNegativeButton(this.b.a.v(R.string.obfuscated_res_0x7f0f03cc), new b(this));
                    g55Var.setCancelable(false);
                    g55Var.setCanceledOnTouchOutside(false);
                    g55Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.baidu.tieba.tba.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.b.a.B(this.a);
                }
            }

            @Override // com.baidu.tieba.tba.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    xi.Q(this.b.a.a.getPageContext().getPageActivity(), this.b.a.v(R.string.qr_scan_error));
                }
            }
        }

        public j(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // com.baidu.tieba.r55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.a.b.getCurrentImageQRInfo();
                if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                    if (!xi.F()) {
                        xi.Q(this.a.a.getPageContext().getPageActivity(), this.a.v(R.string.network_not_available));
                        return;
                    }
                    if (this.a.f != null && !this.a.f.isCancelled()) {
                        this.a.f.cancel();
                    }
                    this.a.f = new tba(currentImageQRInfo, new a(this, currentImageQRInfo));
                    this.a.f.setPriority(3);
                    this.a.f.execute(new String[0]);
                    this.a.w();
                    this.a.t(5);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public a(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.b == null || (currentUrlDragImageView = this.a.b.getCurrentUrlDragImageView()) == null) {
                return;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str2 = "";
            if (imageUrlData == null) {
                str = "";
            } else {
                str2 = imageUrlData.imageUrl;
                str = BigImageLoaderProc.getNameMd5FromUrl(str2);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.a.b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.x = TbConfig.HTTPS_PB_PREFIX + j + "?fr=share";
                }
            }
            if (!wi.isEmpty(str2)) {
                shareItem.z = Uri.parse(str2);
                shareItem.k0 = 2;
                shareItem.v = this.a.v(R.string.save_to_emotion);
                shareItem.w = this.a.v(R.string.save_to_emotion);
                shareItem.A = str2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.E = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new wf5(this.a.a, null).r(shareItem);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yc8 yc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var, Integer.valueOf(i)};
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
            this.a = yc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            p4a p4aVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof p4a) || this.a.a.isFinishing() || (p4aVar = (p4a) customResponsedMessage.getData()) == null) {
                return;
            }
            p4aVar.c = null;
            if (!TextUtils.isEmpty(p4aVar.e) && !TextUtils.isEmpty(p4aVar.b) && p4aVar.b.equals(this.a.e)) {
                this.a.b.setCurrentImageQRInfo(p4aVar.e);
                this.a.u(p4aVar.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends tp5<CollectEmotionEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 c;

        public c(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp5
        /* renamed from: a */
        public boolean onEvent(CollectEmotionEvent collectEmotionEvent) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collectEmotionEvent)) == null) {
                String picId = collectEmotionEvent.getPicId();
                if (!TextUtils.isEmpty(picId)) {
                    this.c.q.put(picId, Boolean.TRUE);
                }
                if (this.c.a != null && (imageView = (ImageView) this.c.a.findViewById(R.id.share_icon)) != null) {
                    WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_expression22, R.color.CAM_X0104, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements r55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public d(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // com.baidu.tieba.r55.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements r55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public e(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // com.baidu.tieba.r55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.m(this.a.a.M2());
                this.a.w();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements r55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public f(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // com.baidu.tieba.r55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sc8.a(this.a.a.getPageContext().getPageActivity(), this.a.b.getCurrentImageUrl());
                this.a.w();
                this.a.t(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements r55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public g(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // com.baidu.tieba.r55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentOriginalUrl = this.a.b.getCurrentOriginalUrl();
                String currentImageUrl = this.a.b.getCurrentImageUrl();
                String currentPicId = this.a.b.getCurrentPicId();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
                } else {
                    Intent intent = new Intent(gm5.a);
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra(gm5.b, currentOriginalUrl);
                    intent.putExtra(gm5.c, currentImageUrl);
                    intent.putExtra(gm5.d, currentPicId);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.a.w();
                this.a.t(2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements r55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public h(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // com.baidu.tieba.r55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.a.a.getPageContext().getPageActivity();
                if (this.a.c == null) {
                    this.a.c = new PermissionJudgePolicy();
                }
                this.a.c.clearRequestPermissionList();
                this.a.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.a.c.startRequestPermission(pageActivity)) {
                    this.a.E();
                    this.a.w();
                    this.a.t(3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements r55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public i(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        @Override // com.baidu.tieba.r55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
                this.a.w();
                this.a.t(4);
                this.a.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ yc8 c;

        public k(yc8 yc8Var, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yc8Var;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.d = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            byte[] bArr;
            String nameMd5FromUrl;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                Map<String, ImageUrlData> U2 = this.c.a.U2();
                if (this.a != null && U2 != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = U2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, ImageUrlData> next = it.next();
                        if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.a)) {
                            imageUrlData = next.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.a, this.c.a.getPageContext().getPageActivity()) == 0) {
                            return this.c.a.getPageContext().getString(R.string.save_image_to_album);
                        }
                    }
                }
                String str2 = this.a;
                if (str2 != null && (bArr = this.b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.c.a.getPageContext().getPageActivity());
                    if (saveImageFileByUser != -2) {
                        if (saveImageFileByUser == 0) {
                            return this.c.v(R.string.save_image_to_album);
                        }
                    } else {
                        return FileHelper.getSdErrorString();
                    }
                }
                return this.c.v(R.string.save_fail);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((k) str);
                if (UbsABTestHelper.isImageViewerTestB() && !this.c.v(R.string.save_fail).equals(str)) {
                    if (this.c.p != null) {
                        this.c.p.g(this.c.b, this.c.b.getBottomHeight(), this.c.z);
                    }
                } else {
                    this.c.a.showToast(str);
                }
                this.c.d = null;
            }
        }
    }

    public yc8(@Nullable ImageViewerActivity imageViewerActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageViewerActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.i = null;
        this.q = new HashMap<>();
        this.r = new b(this, 2921403);
        this.s = new c(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new i(this);
        this.y = new j(this);
        this.z = new a(this);
        this.a = imageViewerActivity;
        imageViewerActivity.registerListener(this.r);
        this.p = new vc8(imageViewerActivity);
        this.a.registerResponsedEventListener(CollectEmotionEvent.class, this.s);
    }

    public void u(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.g != null && !this.a.isFinishing() && this.g.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            n55 n55Var = new n55(v(R.string.image_qr_code), this.h);
            this.o = n55Var;
            n55Var.m(this.y);
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 < this.i.size()) {
                    if (this.k != null && this.i.get(i3) == this.k && (i2 = i3 + 1) <= this.i.size()) {
                        this.i.add(i2, this.o);
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (!z) {
                this.i.add(this.o);
            }
            this.h.l(this.i);
        }
    }

    public void y(View view2) {
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, view2) != null) || view2 == null || !(view2 instanceof DragImageView)) {
            return;
        }
        DragImageView dragImageView = (DragImageView) view2;
        ImageUrlData imageUrlData = dragImageView.getImageUrlData();
        if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
            p4a p4aVar = new p4a();
            p4aVar.a = 0;
            p4aVar.c = imageBitmap;
            String currentImageUrl = this.b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                p4aVar.b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                p4aVar.b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.e = p4aVar.b;
            this.a.sendMessage(new CustomMessage(2921403, p4aVar));
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            ux4.v(this.a.getPageContext().getPageActivity(), null, str, false);
        }
    }

    public final String v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return this.a.getString(i2);
        }
        return (String) invokeI.objValue;
    }

    public void A() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (multiImageView = this.b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
            return;
        }
        ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
        String str2 = "";
        if (imageUrlData == null) {
            str = "";
        } else {
            str2 = imageUrlData.imageUrl;
            str = BigImageLoaderProc.getNameMd5FromUrl(str2);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.b.getCurrentImageUrl();
            str = TbMd5.getNameMd5FromUrl(str2);
        }
        ShareItem shareItem = new ShareItem();
        if (imageUrlData != null) {
            long j2 = imageUrlData.threadId;
            if (j2 > 0) {
                shareItem.x = TbConfig.HTTPS_PB_PREFIX + j2 + "?fr=share";
                shareItem.Y = String.valueOf(j2);
            }
            shareItem.P = imageUrlData.userId;
        }
        boolean z2 = false;
        if (!wi.isEmpty(str2)) {
            shareItem.z = Uri.parse(str2);
            shareItem.k0 = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.E = bundle;
        }
        shareItem.Z = "share_aigc_pic";
        shareItem.j = true;
        shareItem.I = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, false);
        if (UbsABTestHelper.isImageViewerTestA()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.b.o(this.a.M2());
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.m3()) {
                z = true;
            } else {
                z = false;
            }
            shareDialogConfig.showAddEmotion = z;
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                z2 = true;
            }
            shareDialogConfig.showQRCode = z2;
            shareDialogConfig.dialogSaveToDiskListener = this.w;
            shareDialogConfig.dialogAddToExpressionListener = this.v;
            shareDialogConfig.dialogDownloadOriginListener = this.t;
            shareDialogConfig.dialogRecognizePicListener = this.u;
            shareDialogConfig.qrCodeClickListener = this.y;
            shareDialogConfig.onWeChatEmotionShareListener = this.z;
        }
        ImageViewerActivity imageViewerActivity2 = this.a;
        if (imageViewerActivity2 != null) {
            imageViewerActivity2.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i.clear();
            String o = this.b.o(this.a.M2());
            if (o != null) {
                n55 n55Var = new n55(o, this.h);
                this.j = n55Var;
                n55Var.m(this.t);
                this.i.add(this.j);
            }
            n55 n55Var2 = new n55(v(R.string.save_to_local), this.h);
            this.l = n55Var2;
            n55Var2.m(this.w);
            this.i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.m3()) {
                n55 n55Var3 = new n55(v(R.string.save_to_emotion), this.h);
                this.m = n55Var3;
                n55Var3.m(this.v);
                this.i.add(this.m);
            }
            n55 n55Var4 = new n55(v(R.string.identify_image), this.h);
            this.k = n55Var4;
            n55Var4.m(this.u);
            this.i.add(this.k);
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                n55 n55Var5 = new n55(v(R.string.image_qr_code), this.h);
                this.o = n55Var5;
                n55Var5.m(this.y);
                this.i.add(this.o);
            }
            n55 n55Var6 = new n55(v(R.string.image_share), this.h);
            this.n = n55Var6;
            n55Var6.m(this.x);
            this.i.add(this.n);
            this.h.o(new d(this));
            this.h.l(this.i);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k kVar = this.d;
            if (kVar != null) {
                kVar.cancel();
                this.d = null;
            }
            tba tbaVar = this.f;
            if (tbaVar != null) {
                tbaVar.cancel();
                this.f = null;
            }
            vc8 vc8Var = this.p;
            if (vc8Var != null) {
                vc8Var.f();
            }
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null) {
                imageViewerActivity.unRegisterResponsedEventListener();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = null;
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.g != null && !this.a.isFinishing()) {
            this.g.l();
        }
    }

    public void w() {
        p55 p55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (p55Var = this.g) != null && p55Var.isShowing()) {
            this.g.dismiss();
        }
    }

    public void z() {
        r55 r55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (r55Var = this.h) != null) {
            r55Var.j();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                k kVar = new k(this, this.b.getCurrentImageUrl(), this.b.getCurrentImageData());
                this.d = kVar;
                kVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.a.getFrom())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String currentOriginalUrl = this.b.getCurrentOriginalUrl();
            String currentImageUrl = this.b.getCurrentImageUrl();
            String currentPicId = this.b.getCurrentPicId();
            if (this.q.containsKey(currentPicId) && this.q.get(currentPicId).booleanValue()) {
                xi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_duplicate);
                return;
            }
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext())) {
                return;
            } else {
                Intent intent = new Intent(gm5.a);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra(gm5.b, currentOriginalUrl);
                intent.putExtra(gm5.c, currentImageUrl);
                intent.putExtra(gm5.d, currentPicId);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            t(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext())) {
            return;
        }
        Activity pageActivity = this.a.getPageContext().getPageActivity();
        if (this.c == null) {
            this.c = new PermissionJudgePolicy();
        }
        this.c.clearRequestPermissionList();
        this.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.c.startRequestPermission(pageActivity)) {
            return;
        }
        E();
    }

    public final void t(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.a.X2()).param("obj_type", i2));
            if (i2 == 1) {
                i3 = 22;
            } else if (i2 == 2) {
                i3 = 21;
            } else if (i2 == 3) {
                i3 = 20;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void x(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, multiImageView) == null) {
            this.b = multiImageView;
            if (this.g == null) {
                this.h = new r55(this.a);
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            F();
            this.g = new p55(this.a.getPageContext(), this.h);
        }
    }
}
