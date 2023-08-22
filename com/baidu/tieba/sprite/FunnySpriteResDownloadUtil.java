package com.baidu.tieba.sprite;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tieba.k85;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pl;
import com.baidu.tieba.ql;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.yy.hiidostatis.inner.util.log.ActLog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u000200H\u0002\u001a\u0006\u00101\u001a\u00020'\u001a&\u00102\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u00104\u001a\u00020#H\u0007\u001a\u001a\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b!\u0010$\"J\u0010%\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0\"¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0\"¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"APPEAR_DARK", "", "APPEAR_DAY", "DARK_DISAPPEAR", "DARK_NORMAL", "DARK_STAND", "DAY_DISAPPEAR", "DAY_NORMAL", "DAY_STAND", "DEFAULT_LOW_END_DEVICE_SCORE", "", "EXIT_DARK", "EXIT_DAY", "FUNNY_SPRITE_CHAT_BASEBOARD", "FUNNY_SPRITE_CHAT_LIGHT", "FUNNY_SPRITE_CHAT_STAGE", "FUNNY_SPRITE_CHAT_STATIC_RES", "FUNNY_SPRITE_CHAT_WALL", "FUNNY_SPRITE_RES_AFX", "FUNNY_SPRITE_RES_WEBP", "LOG_TAG", "MP4", "NEW_USER_GUIDE_RES", "RES_FILE_PATH", "RUSH_RES", "SEE_RES", "SHOW_DARK", "SHOW_DAY", "TEMP_FOLDER", "WEBP", "ZIP", "chatStaticResList", "", "isAllResExist", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "judgeDeviceScore", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "highEnd", "lowEnd", "notificationResList", "resList", "deleteFiles", "file", "Ljava/io/File;", "downloadRes", "getResPathByName", "notificationPath", "isNameNeedPrefix", "unzipResFile", "resFileName", "resZip", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "FunnySpriteResDownloadUtil")
/* loaded from: classes8.dex */
public final class FunnySpriteResDownloadUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final List<String> b;
    public static final List<String> c;
    public static final List<String> d;
    public static final Function0<Boolean> e;
    public static final Function2<Function0<Unit>, Function0<Unit>, Unit> f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a extends DefaultDownloadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, packageInfo, errorInfo) == null) {
                super.onDownloadError(packageInfo, errorInfo);
                TbLog defaultLog = DefaultLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("Sprite Res Download Fail! Error Msg: ");
                if (errorInfo != null) {
                    str = errorInfo.toString();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append(". Duration: ");
                sb.append(System.currentTimeMillis() - this.a);
                defaultLog.i("SpriteResDownload", sb.toString());
            }
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) {
                super.onDownloadSuccess(packageInfo, errorInfo);
                if (packageInfo != null) {
                    long j = this.a;
                    String resZip = packageInfo.name;
                    Intrinsics.checkNotNullExpressionValue(resZip, "resZip");
                    String replace$default = StringsKt__StringsJVMKt.replace$default(resZip, ".zip", "", false, 4, (Object) null);
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("SpriteResDownload", "Sprite Res Download Success! Res Name: " + resZip + ". Duration: " + (System.currentTimeMillis() - j));
                    boolean l = FunnySpriteResDownloadUtil.l(replace$default, resZip);
                    TbLog defaultLog2 = DefaultLog.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Sprite Res UnZip ");
                    if (l) {
                        str = "Success";
                    } else {
                        str = ActLog.TYPE_FAIL;
                    }
                    sb.append(str);
                    sb.append("! Res Name: ");
                    sb.append(resZip);
                    defaultLog2.i("SpriteResDownload", sb.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1526030588, "Lcom/baidu/tieba/sprite/FunnySpriteResDownloadUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1526030588, "Lcom/baidu/tieba/sprite/FunnySpriteResDownloadUtil;");
                return;
            }
        }
        a = BdBaseApplication.getInst().getFilesDir().toString() + File.separator + "res_cache";
        b = CollectionsKt__CollectionsKt.mutableListOf("day_stand", "dark_stand", "day_normal", "dark_normal", "day_disappear", "dark_disappear", "personal_chat_sprite_stage");
        c = CollectionsKt__CollectionsKt.mutableListOf("funny_sprite_chat_wall", "funny_sprite_chat_baseboard", "funny_sprite_chat_light");
        d = CollectionsKt__CollectionsKt.mutableListOf("funny_sprite_appear_day", "funny_sprite_appear_dark", "funny_sprite_show_day", "funny_sprite_show_dark", "funny_sprite_show_dark", "funny_sprite_exit_day", "funny_sprite_exit_dark");
        e = FunnySpriteResDownloadUtil$isAllResExist$1.INSTANCE;
        f = FunnySpriteResDownloadUtil$judgeDeviceScore$1.INSTANCE;
    }

    public static final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            f.invoke(new Function0<Unit>(objectRef) { // from class: com.baidu.tieba.sprite.FunnySpriteResDownloadUtil$downloadRes$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.ObjectRef<String> $resType;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {objectRef};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$resType = objectRef;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.$resType.element = "funny_sprite_res_afx";
                    }
                }
            }, new Function0<Unit>(objectRef) { // from class: com.baidu.tieba.sprite.FunnySpriteResDownloadUtil$downloadRes$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.ObjectRef<String> $resType;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {objectRef};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$resType = objectRef;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.$resType.element = "funny_sprite_res_webp";
                    }
                }
            });
            String str = "com.baidu.tieba.resloader." + ((String) objectRef.element) + ".zip";
            DefaultLog.getInstance().i("SpriteResDownload", "Sprite Res download start. Res : " + str);
            pl plVar = new pl(str, new a(System.currentTimeMillis()));
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(ql.a);
            requestParams.setRunNode("aps");
            requestParams.addChannel(plVar);
            PmsManager.getInstance().execute(requestParams);
        }
    }

    public static final Function0<Boolean> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return e;
        }
        return (Function0) invokeV.objValue;
    }

    public static final void g(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, file) == null) {
            if (file.isDirectory()) {
                DefaultLog.getInstance().i("SpriteResDownload", "Sprite delete Res Directory " + file);
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File singleFile : listFiles) {
                        Intrinsics.checkNotNullExpressionValue(singleFile, "singleFile");
                        g(singleFile);
                    }
                }
                file.delete();
                return;
            }
            DefaultLog.getInstance().i("SpriteResDownload", "Sprite delete Res File " + file);
            file.delete();
        }
    }

    @JvmOverloads
    public static final String i(String name, String str, boolean z) {
        InterceptResult invokeLLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, name, str, z)) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String str3 = "";
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            f.invoke(new Function0<Unit>(objectRef, objectRef2) { // from class: com.baidu.tieba.sprite.FunnySpriteResDownloadUtil$getResPathByName$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.ObjectRef<String> $resExtension;
                public final /* synthetic */ Ref.ObjectRef<String> $resFolderName;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {objectRef, objectRef2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$resFolderName = objectRef;
                    this.$resExtension = objectRef2;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.$resFolderName.element = "funny_sprite_res_afx";
                        this.$resExtension.element = DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                    }
                }
            }, new Function0<Unit>(objectRef, objectRef2) { // from class: com.baidu.tieba.sprite.FunnySpriteResDownloadUtil$getResPathByName$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.ObjectRef<String> $resExtension;
                public final /* synthetic */ Ref.ObjectRef<String> $resFolderName;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {objectRef, objectRef2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$resFolderName = objectRef;
                    this.$resExtension = objectRef2;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.$resFolderName.element = "funny_sprite_res_webp";
                        this.$resExtension.element = ".webp";
                    }
                }
            });
            if (!c.contains(name)) {
                str2 = "";
            } else {
                str2 = "funny_sprite_chat_static_res" + File.separator;
                objectRef2.element = ".webp";
            }
            if (str != null) {
                if (d.contains(name)) {
                    str3 = str + File.separator;
                }
                if (z) {
                    name = str + '_' + name;
                }
            }
            return a + File.separator + ((String) objectRef.element) + File.separator + str2 + str3 + name + ((String) objectRef2.element);
        }
        return (String) invokeLLZ.objValue;
    }

    public static /* synthetic */ String j(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return i(str, str2, z);
    }

    public static final boolean l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            String str3 = a + File.separator + str;
            boolean b2 = k85.b(a + File.separator + str2, str3 + "_temp");
            DefaultLog.getInstance().i("SpriteResDownload", "Sprite Res UnZip State in unzipResFile: " + b2);
            if (b2) {
                File file = new File(str3);
                g(file);
                boolean renameTo = new File(str3 + "_temp").renameTo(file);
                DefaultLog.getInstance().i("SpriteResDownload", "Sprite Res Rename " + renameTo);
                return renameTo;
            }
            return b2;
        }
        return invokeLL.booleanValue;
    }
}
