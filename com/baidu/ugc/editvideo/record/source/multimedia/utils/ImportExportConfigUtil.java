package com.baidu.ugc.editvideo.record.source.multimedia.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.entity.TemplateInfo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;
/* loaded from: classes8.dex */
public class ImportExportConfigUtil {

    /* loaded from: classes8.dex */
    public interface OnExportListener {
        void onExportFail(String str);

        void onExportSuccess(String str);
    }

    public static MediaTrackConfig exportConfigJson(Map<String, ShaderConfig> map, List<MediaTrack> list, MultiMediaDataTrack multiMediaDataTrack, MediaTrackConfig mediaTrackConfig, String str) {
        return InnerImportExportConfigUtil.exportConfigJson(map, list, multiMediaDataTrack, mediaTrackConfig, str);
    }

    public static String exportEffectsWithShader(Context context, String str, MediaAEffect mediaAEffect, ShaderConfig shaderConfig) {
        return InnerImportExportConfigUtil.exportEffectsWithShader(context, str, mediaAEffect, shaderConfig);
    }

    public static String exportTempInfoZip(Context context, String str, TemplateInfo templateInfo, MediaTrackConfig mediaTrackConfig, OnExportListener onExportListener) {
        return InnerImportExportConfigUtil.exportTempInfoZip(context, str, templateInfo, mediaTrackConfig, onExportListener);
    }

    public static String exportTransitionWithShader(Context context, String str, MediaTransition mediaTransition, String str2, ShaderConfig shaderConfig) {
        return InnerImportExportConfigUtil.exportTransitionWithShader(context, str, mediaTransition, str2, shaderConfig);
    }

    @NonNull
    public static List<MediaTextureData> getMediaTextureDates(Context context, ShaderConfig shaderConfig, File file, String str, OnExportListener onExportListener) throws IOException {
        return InnerImportExportConfigUtil.getMediaTextureDates(context, shaderConfig, file, str, onExportListener);
    }

    @NonNull
    public static Map<String, String> getShaderResourceMap(Context context, String str, File file, MediaTrackConfig mediaTrackConfig, OnExportListener onExportListener) {
        return InnerImportExportConfigUtil.getShaderResourceMap(context, str, file, mediaTrackConfig, onExportListener);
    }

    public static List<String> getTransitionResourceList(File file, MediaTrackConfig mediaTrackConfig, OnExportListener onExportListener) {
        return InnerImportExportConfigUtil.getTransitionResourceList(file, mediaTrackConfig, onExportListener);
    }

    public static void zipFile(File file, String str, ZipOutputStream zipOutputStream, String str2) throws IOException {
        InnerImportExportConfigUtil.zipFile(file, str, zipOutputStream, str2);
    }
}
