package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ohb extends BaseImageRelatedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ohb(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, wfb fileInterceptor, ugb writePageState, EditorTools editor) {
        super(pageContext, webView, writeData, fileInterceptor, writePageState, editor);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {pageContext, webView, writeData, fileInterceptor, writePageState, editor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (wfb) objArr2[3], (ugb) objArr2[4], (EditorTools) objArr2[5]);
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
    }

    @Override // com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener
    public void C(String data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (!y(data)) {
                return;
            }
            int optInt = new JSONObject(data).optInt("imageIndex", -1);
            ImageFileInfo imageInfoAt = k().getWriteImagesInfo().getImageInfoAt(optInt);
            Intrinsics.checkNotNullExpressionValue(imageInfoAt, "writeData.writeImagesInfo.getImageInfoAt(position)");
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo(9);
            writeImagesInfo.copyFrom(k().getWriteImagesInfo());
            LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
            linkedList.add(imageInfoAt);
            writeImagesInfo.setChosedFiles(linkedList);
            writeImagesInfo.setOriginalImgIndex(optInt);
            i().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i().getPageActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, writeImagesInfo, 0)));
        }
    }

    @Override // com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener
    public void F(ImageFileInfo info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            WriteImagesInfo writeImagesInfo = k().getWriteImagesInfo();
            if (writeImagesInfo.size() >= writeImagesInfo.getMaxImagesAllowed()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = i().getString(R.string.max_choose_image_count);
                Intrinsics.checkNotNullExpressionValue(string, "pageContext.getString(R.…g.max_choose_image_count)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(writeImagesInfo.getMaxImagesAllowed())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                i().showToast(format);
                return;
            }
            writeImagesInfo.addChooseFile(info);
            writeImagesInfo.updateQuality();
            WriteImagesInfo writeImagesInfo2 = new WriteImagesInfo();
            writeImagesInfo2.addChooseFile(info);
            BaseImageRelatedListener.M(this, writeImagesInfo2, 0, 2, null);
            q();
        }
    }

    @Override // com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener
    public void G(String json, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, json, i) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(json);
            writeImagesInfo.updateQuality();
            if (ListUtils.isNotEmpty(writeImagesInfo.getChosedFiles())) {
                LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                Intrinsics.checkNotNull(chosedFiles);
                Iterator<ImageFileInfo> it = chosedFiles.iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    WriteImagesInfo writeImagesInfo2 = k().getWriteImagesInfo();
                    if (writeImagesInfo2 != null) {
                        writeImagesInfo2.addChooseFile(next);
                    }
                }
                L(writeImagesInfo, i);
            }
            q();
        }
    }

    @Override // com.baidu.tieba.write.webwrite.hybirdlistener.image.BaseImageRelatedListener
    public void H(String json) {
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(json);
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            ImageFileInfo imageFileInfo2 = null;
            if (chosedFiles != null) {
                imageFileInfo = (ImageFileInfo) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) chosedFiles);
            } else {
                imageFileInfo = null;
            }
            LinkedList<ImageFileInfo> chosedFiles2 = k().getWriteImagesInfo().getChosedFiles();
            if (chosedFiles2 != null) {
                imageFileInfo2 = (ImageFileInfo) CollectionsKt___CollectionsKt.getOrNull(chosedFiles2, writeImagesInfo.getOriginalImgIndex());
            }
            if (imageFileInfo != null && imageFileInfo2 != null) {
                LinkedList<ImageFileInfo> chosedFiles3 = k().getWriteImagesInfo().getChosedFiles();
                Intrinsics.checkNotNull(chosedFiles3);
                chosedFiles3.set(writeImagesInfo.getOriginalImgIndex(), imageFileInfo);
                k().getWriteImagesInfo().updateQuality();
                Function2<String, JSONObject, Unit> g = g();
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                z().b(imageFileInfo);
                jSONArray.put(phb.a.a(imageFileInfo, writeImagesInfo.getOriginalImgIndex()));
                Unit unit = Unit.INSTANCE;
                JSONKt.c(jSONObject, "imgList", jSONArray);
                JSONKt.c(jSONObject, MiPushMessage.KEY_NOTIFY_TYPE, 1);
                Unit unit2 = Unit.INSTANCE;
                g.invoke("writePageNa.onImageResult", jSONObject);
            }
        }
    }
}
