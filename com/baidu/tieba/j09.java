package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public VlogEditManager b;
    public int c;
    public int d;
    public TextWordsEntity.TextStyleEntity e;
    public TextWordsEntity.TextFontEntity f;
    public int g;
    public String h;

    public j09(Context context, VlogEditManager vlogEditManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vlogEditManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = -1;
        this.h = "";
        this.a = context;
        this.b = vlogEditManager;
    }

    public void a(int i, String str, MultiMediaData multiMediaData, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextFontEntity textFontEntity) {
        TextWordsEntity.TextStyleEntity textStyleEntity2;
        TextWordsEntity.TextFontEntity textFontEntity2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, multiMediaData, textStyleEntity, textFontEntity}) != null) || multiMediaData == null) {
            return;
        }
        if (108 == i && TextUtils.isEmpty(str)) {
            multiMediaData.setExt("text", en9.l(R.string.obfuscated_res_0x7f0f1533));
        }
        if (this.g != -1 && !TextUtils.isEmpty(str)) {
            multiMediaData.setExt("text", str);
        }
        if (textStyleEntity != null) {
            multiMediaData.setExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_STYLE, TextWordsEntity.TextStyleEntity.toJson(textStyleEntity).toString());
        } else {
            try {
                String ext = multiMediaData.getExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_STYLE);
                if (!TextUtils.isEmpty(ext)) {
                    textStyleEntity2 = TextWordsEntity.TextStyleEntity.parse(new JSONObject(ext));
                } else {
                    textStyleEntity2 = this.e;
                }
                textStyleEntity = textStyleEntity2;
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        if (textFontEntity != null) {
            multiMediaData.setExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_FONT, TextWordsEntity.TextFontEntity.toJson(textFontEntity).toString());
        } else {
            try {
                String ext2 = multiMediaData.getExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_FONT);
                if (!TextUtils.isEmpty(ext2)) {
                    textFontEntity2 = TextWordsEntity.TextFontEntity.parse(new JSONObject(ext2));
                } else {
                    textFontEntity2 = this.f;
                }
                textFontEntity = textFontEntity2;
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        String ext3 = multiMediaData.getExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_TEMP_PATH);
        String videoTmpDir = FileHelper.getVideoTmpDir();
        String str2 = System.currentTimeMillis() + ".jpg";
        Bitmap h = f09.d().h(this.a, multiMediaData.getExt("text"), textStyleEntity, textFontEntity);
        if (!TextUtils.isEmpty(multiMediaData.path) && !multiMediaData.path.equals(ext3)) {
            FileUtils.delete(new File(multiMediaData.path));
        }
        FileUtils.saveBitmap2PNG(videoTmpDir, str2, h, 100);
        multiMediaData.path = videoTmpDir + File.separator + str2;
        int i2 = multiMediaData.width;
        int i3 = multiMediaData.height;
        multiMediaData.width = h.getWidth();
        int height = h.getHeight();
        multiMediaData.height = height;
        if (this.g == -1) {
            multiMediaData.scaleType = "adaptive";
            multiMediaData.type = 0;
            multiMediaData.start = this.b.getCurrentPlayTime();
            multiMediaData.end = this.b.getCurrentPlayTime() + 3000;
            multiMediaData.x = (this.c - multiMediaData.width) / 2.0f;
            multiMediaData.y = (this.d - multiMediaData.height) / 2.0f;
            if (TextUtils.equals(this.h, "cover_sticker")) {
                this.b.addCoverStickerData(multiMediaData);
            } else {
                this.b.addStickerData(multiMediaData, this.h);
            }
        } else {
            float f = multiMediaData.x + (i2 / 2.0f);
            float f2 = multiMediaData.y + (i3 / 2.0f);
            multiMediaData.x = f - (multiMediaData.width / 2.0f);
            multiMediaData.y = f2 - (height / 2.0f);
            if (TextUtils.equals(this.h, "cover_sticker")) {
                this.b.replaceCoverStickerData(multiMediaData);
            } else {
                this.b.replaceStickerData(this.g, multiMediaData, this.h);
            }
        }
        h.recycle();
    }

    public void b(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiMediaData) == null) && multiMediaData != null && !TextUtils.isEmpty(multiMediaData.path)) {
            FileUtils.delete(new File(multiMediaData.path));
        }
    }

    public boolean d(MultiMediaData multiMediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, multiMediaData)) == null) {
            if (multiMediaData == null) {
                return false;
            }
            String ext = multiMediaData.getExt("text");
            if (TextUtils.isEmpty(ext)) {
                return false;
            }
            return ext.equals(en9.l(R.string.obfuscated_res_0x7f0f1533));
        }
        return invokeL.booleanValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.g = i;
        }
    }

    public void g(TextWordsEntity.TextFontEntity textFontEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, textFontEntity) == null) {
            this.f = textFontEntity;
        }
    }

    public void h(TextWordsEntity.TextStyleEntity textStyleEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textStyleEntity) == null) {
            this.e = textStyleEntity;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.h = str;
        }
    }

    public void c(@NonNull List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b.setUpEditLayer("cover_sticker");
            this.b.addCoverStickerDataList(list);
            for (MultiMediaData multiMediaData : list) {
                f(0);
                a(116, null, multiMediaData, null, null);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = f09.d().getContext();
            Context context2 = this.a;
            if (context == context2 && context2 != null) {
                f09.d().i(null);
                this.a = null;
            }
        }
    }

    public void j(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            this.c = i;
            this.d = i2;
        }
    }
}
