package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.frs.model.AiCreateForumBgLoopModel;
import com.baidu.tieba.frs.model.AiCreateForumBgQueryIdModel;
import com.baidu.tieba.j28;
import com.baidu.tieba.k28;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/baidu/tieba/personExtra/EditHeadController;", "", "activity", "Lcom/baidu/tieba/personExtra/EditHeadActivity;", "(Lcom/baidu/tieba/personExtra/EditHeadActivity;)V", "getActivity", "()Lcom/baidu/tieba/personExtra/EditHeadActivity;", "generateLoopModel", "Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel;", "getGenerateLoopModel", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopModel;", "generateLoopModel$delegate", "Lkotlin/Lazy;", "generateQueryIdModel", "Lcom/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel;", "getGenerateQueryIdModel", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel;", "generateQueryIdModel$delegate", MissionEvent.MESSAGE_DESTROY, "", "startLoop", "taskId", "", "needStatistic", "", "startRequestIdForAiPic", "style", "prompt", "styleName", "fid", "", "Companion", "personExtra_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class EditHeadController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditHeadActivity a;
    public final Lazy b;
    public final Lazy c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1565234355, "Lcom/baidu/tieba/personExtra/EditHeadController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1565234355, "Lcom/baidu/tieba/personExtra/EditHeadController;");
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements AiCreateForumBgLoopModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadController a;
        public final /* synthetic */ boolean b;

        /* renamed from: com.baidu.tieba.personExtra.EditHeadController$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0439a extends BdResourceCallback<BdImage> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EditHeadController a;
            public final /* synthetic */ String b;

            public C0439a(EditHeadController editHeadController, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {editHeadController, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = editHeadController;
                this.b = str;
            }

            @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
            public void onCancelled(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    TiebaPrepareImageService.StartService(this.a.a().A1(), TbImageHelper.getInstance().getPostImageSize(), this.b);
                    this.a.a().D1();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String key, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, key, i) == null) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    super.onLoaded((C0439a) bdImage, key, i);
                    TiebaPrepareImageService.StartService(this.a.a().A1(), TbImageHelper.getInstance().getPostImageSize(), this.b);
                    this.a.a().D1();
                }
            }
        }

        public a(EditHeadController editHeadController, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadController, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadController;
            this.b = z;
        }

        @Override // com.baidu.tieba.frs.model.AiCreateForumBgLoopModel.a
        public void a(j28 loopData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, loopData) == null) {
                Intrinsics.checkNotNullParameter(loopData, "loopData");
                AiCreateForumBgLoopModel.a.C0287a.b(this, loopData);
                List<String> a = loopData.a();
                if (!a.isEmpty()) {
                    String str = a.get(0);
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("EditHeadController", "当前吧：" + this.a.a().v() + "ai生成吧背景返回的url" + str);
                    BdResourceLoader.getInstance().loadResource(str, 10, new C0439a(this.a, str), null);
                    if (this.b) {
                        this.a.a().R1(1, 0);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.frs.model.AiCreateForumBgLoopModel.a
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                AiCreateForumBgLoopModel.a.C0287a.a(this);
                this.a.a().P1();
                this.a.a().M1(true);
                this.a.a().K1();
                this.a.a().I1(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements AiCreateForumBgQueryIdModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditHeadController a;

        public b(EditHeadController editHeadController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editHeadController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editHeadController;
        }

        @Override // com.baidu.tieba.frs.model.AiCreateForumBgQueryIdModel.a
        public void a(k28 queryIdData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, queryIdData) == null) {
                Intrinsics.checkNotNullParameter(queryIdData, "queryIdData");
                this.a.d(String.valueOf(queryIdData.a()), false);
            }
        }

        @Override // com.baidu.tieba.frs.model.AiCreateForumBgQueryIdModel.a
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a().P1();
                this.a.a().M1(true);
            }
        }
    }

    public EditHeadController(EditHeadActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.b = LazyKt__LazyJVMKt.lazy(EditHeadController$generateQueryIdModel$2.INSTANCE);
        this.c = LazyKt__LazyJVMKt.lazy(EditHeadController$generateLoopModel$2.INSTANCE);
    }

    public final EditHeadActivity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (EditHeadActivity) invokeV.objValue;
    }

    public final AiCreateForumBgLoopModel b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (AiCreateForumBgLoopModel) this.c.getValue();
        }
        return (AiCreateForumBgLoopModel) invokeV.objValue;
    }

    public final AiCreateForumBgQueryIdModel c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (AiCreateForumBgQueryIdModel) this.b.getValue();
        }
        return (AiCreateForumBgQueryIdModel) invokeV.objValue;
    }

    public final void d(String taskId, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, taskId, z) == null) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            if (taskId.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                b().j(null);
                AiCreateForumBgLoopModel.m(b(), false, 1, null);
                this.a.P1();
                this.a.M1(true);
                return;
            }
            b().j(new a(this, z));
            b().k(taskId);
        }
    }

    public final void e(String style, String prompt, String styleName, int i) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, style, prompt, styleName, i) == null) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(prompt, "prompt");
            Intrinsics.checkNotNullParameter(styleName, "styleName");
            boolean z3 = false;
            if (style.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (prompt.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (styleName.length() == 0) {
                        z3 = true;
                    }
                    if (!z3 && i != 0) {
                        c().f(new b(this));
                        c().e(style, prompt, styleName, i);
                        return;
                    }
                }
            }
            c().f(null);
            this.a.P1();
            this.a.M1(true);
        }
    }
}
