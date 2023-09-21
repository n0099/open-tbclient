package com.baidu.tieba.write.webwrite.hybirdlistener.image;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.a1b;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.c4b;
import com.baidu.tieba.e3b;
import com.baidu.tieba.f3b;
import com.baidu.tieba.h3b;
import com.baidu.tieba.i3b;
import com.baidu.tieba.l3b;
import com.baidu.tieba.m3b;
import com.baidu.tieba.p3b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q3b;
import com.baidu.tieba.vb;
import com.baidu.tieba.wi5;
import com.baidu.tieba.wq6;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.x4b;
import com.baidu.tieba.xq6;
import com.baidu.tieba.z7b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B9\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0004J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0013\u0010-\u001a\b\u0012\u0004\u0012\u00020.0%H\u0016¢\u0006\u0002\u0010/J\u001a\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010,H\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u00103\u001a\u00020\u001aH\u0016J\u0010\u00104\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020#H\u0002J\u0010\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020<H\u0016J\u0018\u0010:\u001a\u00020\u001a2\u0006\u00109\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010=\u001a\u00020\u001a2\u0006\u00109\u001a\u00020#H\u0016J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020\u001aH\u0002J\u0010\u0010C\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010D\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010E\u001a\b\u0012\u0004\u0012\u00020F0%H\u0016¢\u0006\u0002\u0010GR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/image/BaseImageRelatedListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "Lcom/baidu/tieba/write/webwrite/data/Clean;", "Lcom/baidu/tieba/write/webwrite/data/HandleIntent;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "fileInterceptor", "Lcom/baidu/tieba/write/webwrite/ability/LocalFileInterceptor;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "editor", "Lcom/baidu/tbadk/editortools/EditorTools;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/ability/LocalFileInterceptor;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;Lcom/baidu/tbadk/editortools/EditorTools;)V", "getEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "getFileInterceptor", "()Lcom/baidu/tieba/write/webwrite/ability/LocalFileInterceptor;", "mAsyncLocalImageLoader", "Lcom/baidu/tieba/write/webwrite/ability/LocalImageWithActionLoader;", "addDraftData", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "buildImages", "writeImagesInfo", "Lcom/baidu/tbadk/img/WriteImagesInfo;", MiPushMessage.KEY_NOTIFY_TYPE, "", "canEditImage", "", "data", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "initFromIntent", "savedInstanceState", "Landroid/os/Bundle;", "intent", "Landroid/content/Intent;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "onActivityResult", "requestCode", "onDeleteImageListener", MissionEvent.MESSAGE_DESTROY, "onEditImageListener", "onEditorAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "onImageAddResult", "json", "onImageAdded", "info", "Lcom/baidu/tbadk/img/ImageFileInfo;", "onImageEditResult", "onNewIntent", "onSaveInstanceState", "openAlbum", "from", "openAlbumActivity", "rearrangeListener", "refreshLocalFilesAndNotifyH5", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public class BaseImageRelatedListener extends BizBase implements l3b, m3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e3b g;
    public final EditorTools h;
    public final f3b i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseImageRelatedListener(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, e3b fileInterceptor, c4b writePageState, EditorTools editor) {
        super(pageContext, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, writeData, fileInterceptor, writePageState, editor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (c4b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(fileInterceptor, "fileInterceptor");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.g = fileInterceptor;
        this.h = editor;
        this.i = new f3b();
        writePageState.v(new Function1<ImageFileInfo, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseImageRelatedListener this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImageFileInfo imageFileInfo) {
                invoke2(imageFileInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ImageFileInfo info) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info) == null) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    this.this$0.F(info);
                }
            }
        });
        this.g.c(this.i);
        if (writeData.getWriteImagesInfo() == null) {
            writeData.setWriteImagesInfo(new WriteImagesInfo(9));
        }
    }

    public static /* synthetic */ void M(BaseImageRelatedListener baseImageRelatedListener, WriteImagesInfo writeImagesInfo, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            baseImageRelatedListener.L(writeImagesInfo, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshLocalFilesAndNotifyH5");
    }

    public final void L(WriteImagesInfo writeImagesInfo, int i) {
        LinkedList<ImageFileInfo> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, writeImagesInfo, i) == null) {
            if (writeImagesInfo != null) {
                linkedList = writeImagesInfo.getChosedFiles();
            } else {
                linkedList = null;
            }
            if (ListUtils.isNotEmpty(linkedList)) {
                Function2<String, JSONObject, Unit> g = g();
                Intrinsics.checkNotNull(writeImagesInfo);
                g.invoke("writePageNa.onImageResult", x(writeImagesInfo, i));
            }
        }
    }

    @Override // com.baidu.tieba.m3b
    public void a(Bundle bundle, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bundle, intent) == null) {
            if (bundle != null) {
                str = bundle.getString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
            } else if (intent != null) {
                str = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                intent.putExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, "");
            } else {
                str = null;
            }
            if (str != null) {
                E(str);
            }
        }
    }

    public final void A(int i, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, intent) == null) {
            if (intent != null) {
                str = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            } else {
                str = null;
            }
            if (str == null) {
                return;
            }
            if (i != 12002) {
                if (i == 12012) {
                    H(str);
                    return;
                }
                throw new IllegalStateException("怎么回事小老弟，来了个不认识的case " + i);
            }
            E(str);
        }
    }

    public void G(String json, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, json, i) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            k().getWriteImagesInfo().parseJson(json);
            k().getWriteImagesInfo().updateQuality();
            L(k().getWriteImagesInfo(), i);
            q();
        }
    }

    public final void B(String str) {
        JSONObject a;
        ImageFileInfo b;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (a = wq6.a.a(str)) != null && (b = a1b.a.b(k(), a)) != null) {
            WriteImagesInfo writeImagesInfo = k().getWriteImagesInfo();
            if (writeImagesInfo != null && (chosedFiles = writeImagesInfo.getChosedFiles()) != null) {
                chosedFiles.remove(b);
            }
            if (b.isTempFile()) {
                vb.f().a(new DiskFileOperate(b.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            q();
        }
    }

    public void C(String data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (!y(data)) {
                return;
            }
            i().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i().getPageActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, k().getWriteImagesInfo(), new JSONObject(data).optInt("imageIndex", -1))));
        }
    }

    public final boolean y(String data) {
        InterceptResult invokeL;
        int count;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            JSONObject a = wq6.a.a(data);
            if (a == null || (count = ListUtils.getCount(k().getWriteImagesInfo().getChosedFiles())) == 0 || (optInt = a.optInt("imageIndex", -1)) < 0 || optInt >= count) {
                return false;
            }
            ImageFileInfo imageInfoAt = k().getWriteImagesInfo().getImageInfoAt(optInt);
            Intrinsics.checkNotNullExpressionValue(imageInfoAt, "writeData.writeImagesInfo.getImageInfoAt(position)");
            if (imageInfoAt.getImageType() == 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void D(wi5 wi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wi5Var) == null) {
            int i = wi5Var.a;
            if (i != 14 && i != 48) {
                throw new IllegalStateException("怎么回事小老弟？有没处理的action code:" + wi5Var.a);
            }
            I(0);
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            G(str, 0);
        }
    }

    public void H(String json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            G(json, 1);
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            p5b.b(i().getPageActivity(), 1);
            J();
        }
    }

    @Override // com.baidu.tieba.m3b
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            String stringExtra = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
            if (stringExtra != null) {
                E(stringExtra);
            }
        }
    }

    @Override // com.baidu.tieba.m3b
    public void onSaveInstanceState(Bundle savedInstanceState) {
        String jsonString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, savedInstanceState) == null) {
            Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
            WriteImagesInfo writeImagesInfo = k().getWriteImagesInfo();
            if (writeImagesInfo != null && (jsonString = writeImagesInfo.toJsonString()) != null) {
                savedInstanceState.putString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, jsonString);
            }
        }
    }

    public void F(ImageFileInfo info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, info) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (k().getWriteImagesInfo().size() >= k().getWriteImagesInfo().getMaxImagesAllowed()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = i().getString(R.string.max_choose_image_count);
                Intrinsics.checkNotNullExpressionValue(string, "pageContext.getString(R.…g.max_choose_image_count)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(k().getWriteImagesInfo().getMaxImagesAllowed())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                i().showToast(format);
                return;
            }
            k().getWriteImagesInfo().addChooseFile(info);
            k().getWriteImagesInfo().updateQuality();
            M(this, k().getWriteImagesInfo(), 0, 2, null);
            q();
        }
    }

    public final void K(String str) {
        JSONObject a;
        JSONArray optJSONArray;
        WriteImagesInfo writeImagesInfo;
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && (a = wq6.a.a(str)) != null && (optJSONArray = a.optJSONArray("imgList")) != null && (writeImagesInfo = k().getWriteImagesInfo()) != null && (count = ListUtils.getCount(writeImagesInfo.getChosedFiles())) == optJSONArray.length() && count != 0) {
            new ArrayList();
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    ImageFileInfo b = a1b.a.b(k(), jSONObject);
                    if (b == null) {
                        return;
                    }
                    linkedList.add(b);
                }
            }
            if (linkedList.size() == count) {
                writeImagesInfo.setChosedFiles(linkedList);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.t();
            if (k().getWriteImagesInfo() == null) {
                k().setWriteImagesInfo(new WriteImagesInfo(9));
            }
            z7b.b(i(), k(), k().getWriteImagesInfo(), k().getFrom(), k().getDisableAudioMessage(), k().isVoiceEnable(), k().getPrefixData());
        }
    }

    @Override // com.baidu.tieba.k3b
    public h3b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new h3b[]{new p3b(new Integer[]{14, 48, 12, 13, 46, 49}, new BaseImageRelatedListener$editorActionHandlers$1(this))} : (h3b[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.webwrite.data.BizBase, com.baidu.tieba.k3b
    public Function1<JSONObject, Unit> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new Function1<JSONObject, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener$addDraftData$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseImageRelatedListener this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject json) {
                    JSONObject x;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, json) == null) {
                        Intrinsics.checkNotNullParameter(json, "json");
                        String E = this.this$0.l().E();
                        int hashCode = E.hashCode();
                        LinkedList<ImageFileInfo> linkedList = null;
                        if (hashCode != -1039745817) {
                            if (hashCode != -732377866) {
                                if (hashCode != 3198785 || !E.equals("help")) {
                                    return;
                                }
                            } else if (E.equals("article")) {
                                WriteImagesInfo writeImagesInfo = this.this$0.k().getWriteImagesInfo();
                                if (writeImagesInfo != null) {
                                    linkedList = writeImagesInfo.getChosedFiles();
                                }
                                if (ListUtils.isNotEmpty(linkedList)) {
                                    BaseImageRelatedListener baseImageRelatedListener = this.this$0;
                                    WriteImagesInfo writeImagesInfo2 = baseImageRelatedListener.k().getWriteImagesInfo();
                                    Intrinsics.checkNotNullExpressionValue(writeImagesInfo2, "writeData.writeImagesInfo");
                                    baseImageRelatedListener.x(writeImagesInfo2, 0);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (!E.equals("normal")) {
                            return;
                        }
                        WriteImagesInfo writeImagesInfo3 = this.this$0.k().getWriteImagesInfo();
                        if (writeImagesInfo3 != null) {
                            linkedList = writeImagesInfo3.getChosedFiles();
                        }
                        if (ListUtils.isNotEmpty(linkedList)) {
                            BaseImageRelatedListener baseImageRelatedListener2 = this.this$0;
                            WriteImagesInfo writeImagesInfo4 = baseImageRelatedListener2.k().getWriteImagesInfo();
                            Intrinsics.checkNotNullExpressionValue(writeImagesInfo4, "writeData.writeImagesInfo");
                            x = baseImageRelatedListener2.x(writeImagesInfo4, 0);
                            Iterator<String> keys = x.keys();
                            Intrinsics.checkNotNullExpressionValue(keys, "i.keys()");
                            while (keys.hasNext()) {
                                String key = keys.next();
                                Intrinsics.checkNotNullExpressionValue(key, "key");
                                xq6.a(json, key, x.get(key));
                            }
                        }
                    }
                }
            };
        }
        return (Function1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l3b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.i.a();
        }
    }

    public final e3b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g;
        }
        return (e3b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k3b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new WrapListener[]{h().invoke("writePage.addImage", new Function1<String, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener$keyListeners$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseImageRelatedListener this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.I(1);
                }
            }
        }), h().invoke("writePage.deleteImage", new BaseImageRelatedListener$keyListeners$2(this)), h().invoke("writePage.editImage", new BaseImageRelatedListener$keyListeners$3(this)), h().invoke("writePage.rearrange", new BaseImageRelatedListener$keyListeners$4(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k3b
    public i3b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new i3b[]{new q3b(new Integer[]{Integer.valueOf((int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03), Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH)}, new BaseImageRelatedListener$requestCodeHandlers$1(this))} : (i3b[]) invokeV.objValue;
    }

    public final JSONObject x(WriteImagesInfo writeImagesInfo, int i) {
        InterceptResult invokeLI;
        int i2;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, writeImagesInfo, i)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (ListUtils.isNotEmpty(writeImagesInfo.getChosedFiles())) {
                LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo.getChosedFiles();
                Intrinsics.checkNotNull(chosedFiles2);
                Iterator<ImageFileInfo> it = chosedFiles2.iterator();
                while (it.hasNext()) {
                    ImageFileInfo info = it.next();
                    this.g.b(info);
                    WriteImagesInfo writeImagesInfo2 = k().getWriteImagesInfo();
                    if (writeImagesInfo2 != null && (chosedFiles = writeImagesInfo2.getChosedFiles()) != null) {
                        i2 = chosedFiles.lastIndexOf(info);
                    } else {
                        i2 = 0;
                    }
                    x4b.a aVar = x4b.a;
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    jSONArray.put(aVar.a(info, i2));
                }
            }
            xq6.a(jSONObject, "imgList", jSONArray);
            xq6.a(jSONObject, MiPushMessage.KEY_NOTIFY_TYPE, Integer.valueOf(i));
            return jSONObject;
        }
        return (JSONObject) invokeLI.objValue;
    }
}
