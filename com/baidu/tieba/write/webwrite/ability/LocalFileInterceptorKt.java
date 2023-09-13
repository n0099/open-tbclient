package com.baidu.tieba.write.webwrite.ability;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.browser.core.webview.flyweight.loader.ImageLoader;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.bu6;
import com.baidu.tieba.cu6;
import com.baidu.tieba.l1b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.wb5;
import com.baidu.tieba.write.webwrite.ability.LocalFileInterceptorKt;
import com.baidu.tieba.xm5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a@\u0010\r\u001a\u0004\u0018\u00010\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a$\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"IMAGE_EXPIRES", "", "getIMAGE_EXPIRES", "()Ljava/lang/String;", "IMAGE_EXPIRES$delegate", "Lkotlin/Lazy;", "TAG", "localFace", "Landroid/webkit/WebResourceResponse;", "u", "Landroid/net/Uri;", "request", "Landroid/webkit/WebResourceRequest;", "localImage", "pathInfo", "", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "asyncLoader", "Lcom/baidu/tieba/write/webwrite/ability/LocalImageWithActionLoader;", "localPersistImage", "info", "Lcom/baidu/tbadk/img/ImageFileInfo;", "localPreviewImage", "localVoice", "write_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class LocalFileInterceptorKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Lazy a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(968755561, "Lcom/baidu/tieba/write/webwrite/ability/LocalFileInterceptorKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(968755561, "Lcom/baidu/tieba/write/webwrite/ability/LocalFileInterceptorKt;");
                return;
            }
        }
        a = LazyKt__LazyJVMKt.lazy(LocalFileInterceptorKt$IMAGE_EXPIRES$2.INSTANCE);
    }

    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Object value = a.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-IMAGE_EXPIRES>(...)");
            return (String) value;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.m1b.a(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse] */
    public static final /* synthetic */ WebResourceResponse a(Uri uri, WebResourceRequest webResourceRequest) {
        return e(uri, webResourceRequest);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.m1b.a(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse] */
    public static final /* synthetic */ WebResourceResponse c(Uri uri, WebResourceRequest webResourceRequest) {
        return j(uri, webResourceRequest);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.m1b.a(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse] */
    public static final /* synthetic */ WebResourceResponse b(Map map, WriteData writeData, n1b n1bVar, Uri uri, WebResourceRequest webResourceRequest) {
        return f(map, writeData, n1bVar, uri, webResourceRequest);
    }

    public static final WebResourceResponse e(Uri uri, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        BdImage k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, uri, webResourceRequest)) == null) {
            String queryParameter = uri.getQueryParameter("faceName");
            if (!TextUtils.isEmpty(queryParameter) && (k = TbFaceManager.i().k(queryParameter)) != null) {
                return ImageLoader.f(k.getImageByte(), WordCommandManager.IMAGE_PNG, webResourceRequest);
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public static final WebResourceResponse j(Uri uri, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, uri, webResourceRequest)) == null) {
            String queryParameter = uri.getQueryParameter("voiceId");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    return ImageLoader.f(FilesKt__FileReadWriteKt.readBytes(new File(wb5.b(queryParameter))), "audio/amr", webResourceRequest);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public static final WebResourceResponse f(Map<String, String> map, WriteData writeData, n1b n1bVar, Uri uri, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLLLLL;
        ImageFileInfo imageFileInfo;
        WebResourceResponse e;
        LinkedList<ImageFileInfo> chosedFiles;
        Object obj;
        Map<String, String> map2;
        ImageFileInfo imageFileInfo2;
        LinkedList<ImageFileInfo> chosedFiles2;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65542, null, map, writeData, n1bVar, uri, webResourceRequest)) == null) {
            String queryParameter = uri.getQueryParameter("ref");
            HashMap hashMap = null;
            if (queryParameter == null) {
                return null;
            }
            if (StringsKt__StringsKt.contains$default((CharSequence) queryParameter, (CharSequence) "?t=", false, 2, (Object) null)) {
                queryParameter = queryParameter.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) queryParameter, "?t=", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(queryParameter, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String str = map.get(queryParameter);
            HybridLog.getInstance().i("LocalFileInterceptor", "开始加载本地图片：refName:" + queryParameter + " localPath:" + str);
            if (str != null) {
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "u.toString()");
                Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                if (StringsKt__StringsJVMKt.startsWith$default(str, "persist_", false, 2, null)) {
                    WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
                    if (writeImagesInfo != null && (chosedFiles2 = writeImagesInfo.getChosedFiles()) != null) {
                        Iterator<T> it = chosedFiles2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj2 = it.next();
                                if (Intrinsics.areEqual(((ImageFileInfo) obj2).toCachedKey(true), str)) {
                                    break;
                                }
                            } else {
                                obj2 = null;
                                break;
                            }
                        }
                        imageFileInfo2 = (ImageFileInfo) obj2;
                    } else {
                        imageFileInfo2 = null;
                    }
                    if (imageFileInfo2 != null) {
                        e = g(imageFileInfo2, n1bVar, webResourceRequest);
                    } else {
                        HybridLog.getInstance().i("LocalFileInterceptor", "加载本地图片失败，writeImagesInfo中没有:" + queryParameter);
                        e = null;
                    }
                } else {
                    WriteImagesInfo writeImagesInfo2 = writeData.getWriteImagesInfo();
                    if (writeImagesInfo2 != null && (chosedFiles = writeImagesInfo2.getChosedFiles()) != null) {
                        Iterator<T> it2 = chosedFiles.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj = it2.next();
                                if (Intrinsics.areEqual(((ImageFileInfo) obj).getFilePath(), str)) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        imageFileInfo = (ImageFileInfo) obj;
                    } else {
                        imageFileInfo = null;
                    }
                    if (imageFileInfo != null && imageFileInfo.isHeif()) {
                        e = i(imageFileInfo);
                    } else {
                        e = ImageLoader.e(str, uri2, requestHeaders);
                    }
                }
                if (e != null) {
                    map2 = e.getResponseHeaders();
                } else {
                    map2 = null;
                }
                if (map2 instanceof HashMap) {
                    hashMap = map2;
                }
                if (hashMap != null) {
                    hashMap.remove(Headers.CACHE_CONTROL);
                    hashMap.put(Headers.EXPIRES, d());
                }
                return e;
            }
            HybridLog.getInstance().i("LocalFileInterceptor", "加载本地图片失败，找不到refName:" + queryParameter);
            return null;
        }
        return (WebResourceResponse) invokeLLLLL.objValue;
    }

    public static final WebResourceResponse g(ImageFileInfo imageFileInfo, n1b n1bVar, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, imageFileInfo, n1bVar, webResourceRequest)) == null) {
            final cu6 cu6Var = new cu6();
            xm5 xm5Var = new xm5() { // from class: com.baidu.tieba.j1b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.xm5
                public final void a(BdImage bdImage, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLZ(1048576, this, bdImage, str, z) == null) {
                        LocalFileInterceptorKt.h(cu6.this, bdImage, str, z);
                    }
                }
            };
            BdImage bdImage = null;
            if (imageFileInfo != null && n1bVar != null) {
                bdImage = n1b.d(n1bVar, imageFileInfo, xm5Var, true, false, 8, null);
            }
            if (bdImage != null) {
                WebResourceResponse f = ImageLoader.f(bdImage.getImageByte(), WordCommandManager.IMAGE_PNG, webResourceRequest);
                Intrinsics.checkNotNullExpressionValue(f, "{\n        ImageLoader.wr…mage/png\", request)\n    }");
                return f;
            }
            return new WebResourceResponse(WordCommandManager.IMAGE_PNG, "UTF-8", new bu6(cu6Var));
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public static final void h(cu6 future, BdImage bdImage, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{future, bdImage, str, Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(future, "$future");
            future.b(bdImage.getImageByte());
        }
    }

    public static final WebResourceResponse i(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, imageFileInfo)) == null) {
            cu6 cu6Var = new cu6();
            l1b.a aVar = l1b.a;
            String filePath = imageFileInfo.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "info.filePath");
            l1b.a.b(aVar, filePath, 0, 0, new Function1<BdImage, Unit>(imageFileInfo, cu6Var) { // from class: com.baidu.tieba.write.webwrite.ability.LocalFileInterceptorKt$localPreviewImage$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ cu6<byte[]> $future;
                public final /* synthetic */ ImageFileInfo $info;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {imageFileInfo, cu6Var};
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
                    this.$info = imageFileInfo;
                    this.$future = cu6Var;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BdImage bdImage) {
                    invoke2(bdImage);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(BdImage bdImage) {
                    byte[] bArr;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage) == null) {
                        cu6<byte[]> cu6Var2 = this.$future;
                        if (bdImage != null) {
                            bArr = bdImage.getImageByte();
                        } else {
                            bArr = null;
                        }
                        cu6Var2.b(bArr);
                    }
                }
            }, 6, null);
            return new WebResourceResponse(WordCommandManager.IMAGE_PNG, "UTF-8", new bu6(cu6Var));
        }
        return (WebResourceResponse) invokeL.objValue;
    }
}
