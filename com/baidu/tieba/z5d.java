package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GraffitiInfo;
import tbclient.Item;
import tbclient.MemeInfo;
import tbclient.NativeApp;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
import tbclient.TogetherHi;
/* loaded from: classes9.dex */
public class z5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", pbContent.type);
            ktc.a(jSONObject, "text", pbContent.text);
            ktc.a(jSONObject, "link", pbContent.link);
            ktc.a(jSONObject, "src", pbContent.src);
            ktc.a(jSONObject, "bsize", pbContent.bsize);
            ktc.a(jSONObject, "big_src", pbContent.big_src);
            ktc.a(jSONObject, "big_size", pbContent.big_size);
            ktc.a(jSONObject, "cdn_src", pbContent.cdn_src);
            ktc.a(jSONObject, "big_cdn_src", pbContent.big_cdn_src);
            ktc.a(jSONObject, "imgtype", pbContent.imgtype);
            ktc.a(jSONObject, "c", pbContent.c);
            ktc.a(jSONObject, "voice_md5", pbContent.voice_md5);
            ktc.a(jSONObject, "during_time", pbContent.during_time);
            ktc.a(jSONObject, "is_sub", pbContent.is_sub);
            ktc.a(jSONObject, "uid", pbContent.uid);
            ktc.a(jSONObject, PraiseUBCHelper.SOURCE_DYNAMIC, pbContent.dynamic);
            ktc.a(jSONObject, "static", pbContent._static);
            ktc.a(jSONObject, "width", pbContent.width);
            ktc.a(jSONObject, "height", pbContent.height);
            ktc.a(jSONObject, "packet_name", pbContent.packet_name);
            ktc.a(jSONObject, "phonetype", pbContent.phonetype);
            ktc.a(jSONObject, "is_native_app", pbContent.is_native_app);
            NativeApp nativeApp = pbContent.native_app;
            if (nativeApp != null) {
                ktc.a(jSONObject, "native_app", j5d.b(nativeApp));
            }
            ktc.a(jSONObject, "e_type", pbContent.e_type);
            ktc.a(jSONObject, "origin_src", pbContent.origin_src);
            ktc.a(jSONObject, "btn_type", pbContent.btn_type);
            ktc.a(jSONObject, "origin_size", pbContent.origin_size);
            ktc.a(jSONObject, "count", pbContent.count);
            GraffitiInfo graffitiInfo = pbContent.graffiti_info;
            if (graffitiInfo != null) {
                ktc.a(jSONObject, "graffiti_info", s3d.b(graffitiInfo));
            }
            TogetherHi togetherHi = pbContent.high_together;
            if (togetherHi != null) {
                ktc.a(jSONObject, "high_together", iad.b(togetherHi));
            }
            ktc.a(jSONObject, "media_subtitle", pbContent.media_subtitle);
            ktc.a(jSONObject, "url_type", pbContent.url_type);
            MemeInfo memeInfo = pbContent.meme_info;
            if (memeInfo != null) {
                ktc.a(jSONObject, "meme_info", d5d.b(memeInfo));
            }
            ktc.a(jSONObject, "is_long_pic", pbContent.is_long_pic);
            ktc.a(jSONObject, "show_original_btn", pbContent.show_original_btn);
            ktc.a(jSONObject, "cdn_src_active", pbContent.cdn_src_active);
            ktc.a(jSONObject, "topic_special_icon", pbContent.topic_special_icon);
            ktc.a(jSONObject, "item_id", pbContent.item_id);
            ktc.a(jSONObject, "item_forum_name", pbContent.item_forum_name);
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            if (tiebaPlusInfo != null) {
                ktc.a(jSONObject, "tiebaplus_info", dad.b(tiebaPlusInfo));
            }
            Item item = pbContent.item;
            if (item != null) {
                ktc.a(jSONObject, "item", b4d.b(item));
            }
            ktc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, pbContent.pic_id);
            ktc.a(jSONObject, "link_type", pbContent.link_type);
            ktc.a(jSONObject, "target_scheme", pbContent.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
