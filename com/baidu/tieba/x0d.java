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
public class x0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", pbContent.type);
            qoc.a(jSONObject, "text", pbContent.text);
            qoc.a(jSONObject, "link", pbContent.link);
            qoc.a(jSONObject, "src", pbContent.src);
            qoc.a(jSONObject, "bsize", pbContent.bsize);
            qoc.a(jSONObject, "big_src", pbContent.big_src);
            qoc.a(jSONObject, "big_size", pbContent.big_size);
            qoc.a(jSONObject, "cdn_src", pbContent.cdn_src);
            qoc.a(jSONObject, "big_cdn_src", pbContent.big_cdn_src);
            qoc.a(jSONObject, "imgtype", pbContent.imgtype);
            qoc.a(jSONObject, "c", pbContent.c);
            qoc.a(jSONObject, "voice_md5", pbContent.voice_md5);
            qoc.a(jSONObject, "during_time", pbContent.during_time);
            qoc.a(jSONObject, "is_sub", pbContent.is_sub);
            qoc.a(jSONObject, "uid", pbContent.uid);
            qoc.a(jSONObject, PraiseUBCHelper.SOURCE_DYNAMIC, pbContent.dynamic);
            qoc.a(jSONObject, "static", pbContent._static);
            qoc.a(jSONObject, "width", pbContent.width);
            qoc.a(jSONObject, "height", pbContent.height);
            qoc.a(jSONObject, "packet_name", pbContent.packet_name);
            qoc.a(jSONObject, "phonetype", pbContent.phonetype);
            qoc.a(jSONObject, "is_native_app", pbContent.is_native_app);
            NativeApp nativeApp = pbContent.native_app;
            if (nativeApp != null) {
                qoc.a(jSONObject, "native_app", h0d.b(nativeApp));
            }
            qoc.a(jSONObject, "e_type", pbContent.e_type);
            qoc.a(jSONObject, "origin_src", pbContent.origin_src);
            qoc.a(jSONObject, "btn_type", pbContent.btn_type);
            qoc.a(jSONObject, "origin_size", pbContent.origin_size);
            qoc.a(jSONObject, "count", pbContent.count);
            GraffitiInfo graffitiInfo = pbContent.graffiti_info;
            if (graffitiInfo != null) {
                qoc.a(jSONObject, "graffiti_info", qyc.b(graffitiInfo));
            }
            TogetherHi togetherHi = pbContent.high_together;
            if (togetherHi != null) {
                qoc.a(jSONObject, "high_together", g5d.b(togetherHi));
            }
            qoc.a(jSONObject, "media_subtitle", pbContent.media_subtitle);
            qoc.a(jSONObject, "url_type", pbContent.url_type);
            MemeInfo memeInfo = pbContent.meme_info;
            if (memeInfo != null) {
                qoc.a(jSONObject, "meme_info", b0d.b(memeInfo));
            }
            qoc.a(jSONObject, "is_long_pic", pbContent.is_long_pic);
            qoc.a(jSONObject, "show_original_btn", pbContent.show_original_btn);
            qoc.a(jSONObject, "cdn_src_active", pbContent.cdn_src_active);
            qoc.a(jSONObject, "topic_special_icon", pbContent.topic_special_icon);
            qoc.a(jSONObject, "item_id", pbContent.item_id);
            qoc.a(jSONObject, "item_forum_name", pbContent.item_forum_name);
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            if (tiebaPlusInfo != null) {
                qoc.a(jSONObject, "tiebaplus_info", b5d.b(tiebaPlusInfo));
            }
            Item item = pbContent.item;
            if (item != null) {
                qoc.a(jSONObject, "item", zyc.b(item));
            }
            qoc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, pbContent.pic_id);
            qoc.a(jSONObject, "link_type", pbContent.link_type);
            qoc.a(jSONObject, "target_scheme", pbContent.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
