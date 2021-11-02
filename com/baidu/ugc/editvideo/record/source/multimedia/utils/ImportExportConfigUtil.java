package com.baidu.ugc.editvideo.record.source.multimedia.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.entity.TemplateInfo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;
/* loaded from: classes10.dex */
public class ImportExportConfigUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface OnExportListener {
        void onExportFail(String str);

        void onExportSuccess(String str);
    }

    public ImportExportConfigUtil() {
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

    public static MediaTrackConfig exportConfigJson(Map<String, ShaderConfig> map, List<MediaTrack> list, MultiMediaDataTrack multiMediaDataTrack, MediaTrackConfig mediaTrackConfig, String str) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, map, list, multiMediaDataTrack, mediaTrackConfig, str)) == null) ? InnerImportExportConfigUtil.exportConfigJson(map, list, multiMediaDataTrack, mediaTrackConfig, str) : (MediaTrackConfig) invokeLLLLL.objValue;
    }

    public static String exportEffectsWithShader(Context context, String str, MediaAEffect mediaAEffect, ShaderConfig shaderConfig) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, mediaAEffect, shaderConfig)) == null) ? InnerImportExportConfigUtil.exportEffectsWithShader(context, str, mediaAEffect, shaderConfig) : (String) invokeLLLL.objValue;
    }

    public static String exportTempInfoZip(Context context, String str, TemplateInfo templateInfo, MediaTrackConfig mediaTrackConfig, OnExportListener onExportListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, context, str, templateInfo, mediaTrackConfig, onExportListener)) == null) ? InnerImportExportConfigUtil.exportTempInfoZip(context, str, templateInfo, mediaTrackConfig, onExportListener) : (String) invokeLLLLL.objValue;
    }

    public static String exportTransitionWithShader(Context context, String str, MediaTransition mediaTransition, String str2, ShaderConfig shaderConfig) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, mediaTransition, str2, shaderConfig)) == null) ? InnerImportExportConfigUtil.exportTransitionWithShader(context, str, mediaTransition, str2, shaderConfig) : (String) invokeLLLLL.objValue;
    }

    @NonNull
    public static List<MediaTextureData> getMediaTextureDates(Context context, ShaderConfig shaderConfig, File file, String str, OnExportListener onExportListener) throws IOException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, context, shaderConfig, file, str, onExportListener)) == null) ? InnerImportExportConfigUtil.getMediaTextureDates(context, shaderConfig, file, str, onExportListener) : (List) invokeLLLLL.objValue;
    }

    @NonNull
    public static Map<String, String> getShaderResourceMap(Context context, String str, File file, MediaTrackConfig mediaTrackConfig, OnExportListener onExportListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, file, mediaTrackConfig, onExportListener)) == null) ? InnerImportExportConfigUtil.getShaderResourceMap(context, str, file, mediaTrackConfig, onExportListener) : (Map) invokeLLLLL.objValue;
    }

    public static List<String> getTransitionResourceList(File file, MediaTrackConfig mediaTrackConfig, OnExportListener onExportListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, file, mediaTrackConfig, onExportListener)) == null) ? InnerImportExportConfigUtil.getTransitionResourceList(file, mediaTrackConfig, onExportListener) : (List) invokeLLL.objValue;
    }

    public static void zipFile(File file, String str, ZipOutputStream zipOutputStream, String str2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, file, str, zipOutputStream, str2) == null) {
            InnerImportExportConfigUtil.zipFile(file, str, zipOutputStream, str2);
        }
    }
}
