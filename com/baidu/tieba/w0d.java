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
/* loaded from: classes8.dex */
public class w0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", pbContent.type);
            poc.a(jSONObject, "text", pbContent.text);
            poc.a(jSONObject, "link", pbContent.link);
            poc.a(jSONObject, "src", pbContent.src);
            poc.a(jSONObject, "bsize", pbContent.bsize);
            poc.a(jSONObject, "big_src", pbContent.big_src);
            poc.a(jSONObject, "big_size", pbContent.big_size);
            poc.a(jSONObject, "cdn_src", pbContent.cdn_src);
            poc.a(jSONObject, "big_cdn_src", pbContent.big_cdn_src);
            poc.a(jSONObject, "imgtype", pbContent.imgtype);
            poc.a(jSONObject, "c", pbContent.c);
            poc.a(jSONObject, "voice_md5", pbContent.voice_md5);
            poc.a(jSONObject, "during_time", pbContent.during_time);
            poc.a(jSONObject, "is_sub", pbContent.is_sub);
            poc.a(jSONObject, "uid", pbContent.uid);
            poc.a(jSONObject, PraiseUBCHelper.SOURCE_DYNAMIC, pbContent.dynamic);
            poc.a(jSONObject, "static", pbContent._static);
            poc.a(jSONObject, "width", pbContent.width);
            poc.a(jSONObject, "height", pbContent.height);
            poc.a(jSONObject, "packet_name", pbContent.packet_name);
            poc.a(jSONObject, "phonetype", pbContent.phonetype);
            poc.a(jSONObject, "is_native_app", pbContent.is_native_app);
            NativeApp nativeApp = pbContent.native_app;
            if (nativeApp != null) {
                poc.a(jSONObject, "native_app", g0d.b(nativeApp));
            }
            poc.a(jSONObject, "e_type", pbContent.e_type);
            poc.a(jSONObject, "origin_src", pbContent.origin_src);
            poc.a(jSONObject, "btn_type", pbContent.btn_type);
            poc.a(jSONObject, "origin_size", pbContent.origin_size);
            poc.a(jSONObject, "count", pbContent.count);
            GraffitiInfo graffitiInfo = pbContent.graffiti_info;
            if (graffitiInfo != null) {
                poc.a(jSONObject, "graffiti_info", pyc.b(graffitiInfo));
            }
            TogetherHi togetherHi = pbContent.high_together;
            if (togetherHi != null) {
                poc.a(jSONObject, "high_together", f5d.b(togetherHi));
            }
            poc.a(jSONObject, "media_subtitle", pbContent.media_subtitle);
            poc.a(jSONObject, "url_type", pbContent.url_type);
            MemeInfo memeInfo = pbContent.meme_info;
            if (memeInfo != null) {
                poc.a(jSONObject, "meme_info", a0d.b(memeInfo));
            }
            poc.a(jSONObject, "is_long_pic", pbContent.is_long_pic);
            poc.a(jSONObject, "show_original_btn", pbContent.show_original_btn);
            poc.a(jSONObject, "cdn_src_active", pbContent.cdn_src_active);
            poc.a(jSONObject, "topic_special_icon", pbContent.topic_special_icon);
            poc.a(jSONObject, "item_id", pbContent.item_id);
            poc.a(jSONObject, "item_forum_name", pbContent.item_forum_name);
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            if (tiebaPlusInfo != null) {
                poc.a(jSONObject, "tiebaplus_info", a5d.b(tiebaPlusInfo));
            }
            Item item = pbContent.item;
            if (item != null) {
                poc.a(jSONObject, "item", yyc.b(item));
            }
            poc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, pbContent.pic_id);
            poc.a(jSONObject, "link_type", pbContent.link_type);
            poc.a(jSONObject, "target_scheme", pbContent.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
