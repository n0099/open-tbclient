package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class kx6 extends mi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947928512, "Lcom/baidu/tieba/kx6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947928512, "Lcom/baidu/tieba/kx6;");
                return;
            }
        }
        mi5.a.put("video_icon", Integer.valueOf((int) R.drawable.ico_link_video));
        HashMap<String, Integer> hashMap = mi5.a;
        Integer valueOf = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d84);
        hashMap.put("image_emoticon34", valueOf);
        HashMap<String, Integer> hashMap2 = mi5.a;
        Integer valueOf2 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d85);
        hashMap2.put("image_emoticon35", valueOf2);
        HashMap<String, Integer> hashMap3 = mi5.a;
        Integer valueOf3 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d86);
        hashMap3.put("image_emoticon36", valueOf3);
        HashMap<String, Integer> hashMap4 = mi5.a;
        Integer valueOf4 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d87);
        hashMap4.put("image_emoticon37", valueOf4);
        HashMap<String, Integer> hashMap5 = mi5.a;
        Integer valueOf5 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d88);
        hashMap5.put("image_emoticon38", valueOf5);
        HashMap<String, Integer> hashMap6 = mi5.a;
        Integer valueOf6 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d8b);
        hashMap6.put("image_emoticon40", valueOf6);
        HashMap<String, Integer> hashMap7 = mi5.a;
        Integer valueOf7 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d89);
        hashMap7.put("image_emoticon39", valueOf7);
        HashMap<String, Integer> hashMap8 = mi5.a;
        Integer valueOf8 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d8c);
        hashMap8.put("image_emoticon41", valueOf8);
        HashMap<String, Integer> hashMap9 = mi5.a;
        Integer valueOf9 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d8d);
        hashMap9.put("image_emoticon42", valueOf9);
        HashMap<String, Integer> hashMap10 = mi5.a;
        Integer valueOf10 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d8e);
        hashMap10.put("image_emoticon43", valueOf10);
        HashMap<String, Integer> hashMap11 = mi5.a;
        Integer valueOf11 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d8f);
        hashMap11.put("image_emoticon44", valueOf11);
        HashMap<String, Integer> hashMap12 = mi5.a;
        Integer valueOf12 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d90);
        hashMap12.put("image_emoticon45", valueOf12);
        HashMap<String, Integer> hashMap13 = mi5.a;
        Integer valueOf13 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d91);
        hashMap13.put("image_emoticon46", valueOf13);
        HashMap<String, Integer> hashMap14 = mi5.a;
        Integer valueOf14 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d92);
        hashMap14.put("image_emoticon47", valueOf14);
        HashMap<String, Integer> hashMap15 = mi5.a;
        Integer valueOf15 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d93);
        hashMap15.put("image_emoticon48", valueOf15);
        mi5.a.put("image_emoticon49", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d94));
        mi5.a.put("image_emoticon50", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d96));
        mi5.a.put("image_emoticon77", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080da9));
        mi5.a.put("image_emoticon78", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080daa));
        mi5.a.put("image_emoticon79", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dab));
        mi5.a.put("image_emoticon80", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dad));
        mi5.a.put("image_emoticon81", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dae));
        mi5.a.put("image_emoticon82", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080daf));
        mi5.a.put("image_emoticon83", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080db0));
        mi5.a.put("image_emoticon84", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080db1));
        mi5.a.put("image_emoticon101", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d46));
        mi5.a.put("image_emoticon102", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d47));
        mi5.a.put("image_emoticon103", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d48));
        mi5.a.put("image_emoticon104", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d49));
        mi5.a.put("image_emoticon105", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4a));
        mi5.a.put("image_emoticon106", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4b));
        mi5.a.put("image_emoticon107", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4c));
        mi5.a.put("image_emoticon108", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4d));
        mi5.a.put("image_emoticon109", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4e));
        mi5.a.put("image_emoticon110", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d50));
        mi5.a.put("image_emoticon111", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d51));
        mi5.a.put("image_emoticon112", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d52));
        mi5.a.put("image_emoticon113", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d53));
        mi5.a.put("image_emoticon114", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d54));
        mi5.a.put("image_emoticon115", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d55));
        mi5.a.put("image_emoticon116", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d56));
        mi5.a.put("image_emoticon117", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d57));
        mi5.a.put("image_emoticon118", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d58));
        mi5.a.put("image_emoticon119", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d59));
        mi5.a.put("image_emoticon120", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5b));
        mi5.a.put("image_emoticon121", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5c));
        mi5.a.put("image_emoticon122", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5d));
        mi5.a.put("image_emoticon123", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5e));
        mi5.a.put("image_emoticon124", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5f));
        mi5.b.add(valueOf);
        mi5.b.add(valueOf2);
        mi5.b.add(valueOf3);
        mi5.b.add(valueOf4);
        mi5.b.add(valueOf5);
        mi5.b.add(valueOf6);
        mi5.b.add(valueOf7);
        mi5.b.add(valueOf8);
        mi5.b.add(valueOf10);
        mi5.b.add(valueOf11);
        mi5.b.add(valueOf15);
        mi5.b.add(valueOf14);
        mi5.b.add(valueOf13);
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d96));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080da9));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080daa));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dab));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dad));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dae));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080daf));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080db0));
        mi5.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080db1));
        mi5.b.add(valueOf12);
        mi5.b.add(valueOf9);
        mi5.c.put("#(爱心)", valueOf);
        mi5.c.put("#(心碎)", valueOf2);
        mi5.c.put("#(玫瑰)", valueOf3);
        mi5.c.put("#(礼物)", valueOf4);
        mi5.c.put("#(彩虹)", valueOf5);
        mi5.c.put("#(星星月亮)", valueOf7);
        mi5.c.put("#(太阳)", valueOf6);
        mi5.c.put("#(钱币)", valueOf8);
        mi5.c.put("#(灯泡)", valueOf9);
        mi5.c.put("#(茶杯)", valueOf10);
        mi5.c.put("#(蛋糕)", valueOf11);
        mi5.c.put("#(音乐)", valueOf12);
        mi5.c.put("#(haha)", valueOf13);
        mi5.c.put("#(胜利)", valueOf14);
        mi5.c.put("#(大拇指)", valueOf15);
        mi5.c.put("#(弱)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d94));
        mi5.c.put("#(OK)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d96));
        mi5.c.put("#(沙发)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080da9));
        mi5.c.put("#(手纸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080daa));
        mi5.c.put("#(香蕉)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dab));
        mi5.c.put("#(便便)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dad));
        mi5.c.put("#(药丸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080dae));
        mi5.c.put("#(红领巾)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080daf));
        mi5.c.put("#(蜡烛)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080db0));
        mi5.c.put("#(三道杠)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080db1));
        mi5.c.put("#(不跟丑人说话)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d46));
        mi5.c.put("#(么么哒)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d47));
        mi5.c.put("#(亲亲才能起来)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d48));
        mi5.c.put("#(伦家只是宝宝)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d49));
        mi5.c.put("#(你是我的人)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4a));
        mi5.c.put("#(假装看不见)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4b));
        mi5.c.put("#(单身等撩)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4c));
        mi5.c.put("#(吓到宝宝了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4d));
        mi5.c.put("#(哈哈哈)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d4e));
        mi5.c.put("#(嗯嗯)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d50));
        mi5.c.put("#(好幸福)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d51));
        mi5.c.put("#(宝宝不开心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d52));
        mi5.c.put("#(小姐姐别走)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d53));
        mi5.c.put("#(小姐姐在吗)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d54));
        mi5.c.put("#(小姐姐来啦)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d55));
        mi5.c.put("#(小姐姐来玩呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d56));
        mi5.c.put("#(我养你)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d57));
        mi5.c.put("#(我是不会骗你的)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d58));
        mi5.c.put("#(扎心了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d59));
        mi5.c.put("#(无聊)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5b));
        mi5.c.put("#(月亮代表我的心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5c));
        mi5.c.put("#(来追我呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5d));
        mi5.c.put("#(爱你的形状)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5e));
        mi5.c.put("#(白眼)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d5f));
    }

    public kx6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
