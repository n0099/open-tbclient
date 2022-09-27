package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class l86 extends y55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896799, "Lcom/baidu/tieba/l86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896799, "Lcom/baidu/tieba/l86;");
                return;
            }
        }
        y55.a.put("video_icon", Integer.valueOf((int) R.drawable.ico_link_video));
        HashMap<String, Integer> hashMap = y55.a;
        Integer valueOf = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b9a);
        hashMap.put("image_emoticon34", valueOf);
        HashMap<String, Integer> hashMap2 = y55.a;
        Integer valueOf2 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b9b);
        hashMap2.put("image_emoticon35", valueOf2);
        HashMap<String, Integer> hashMap3 = y55.a;
        Integer valueOf3 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b9c);
        hashMap3.put("image_emoticon36", valueOf3);
        HashMap<String, Integer> hashMap4 = y55.a;
        Integer valueOf4 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b9d);
        hashMap4.put("image_emoticon37", valueOf4);
        HashMap<String, Integer> hashMap5 = y55.a;
        Integer valueOf5 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b9e);
        hashMap5.put("image_emoticon38", valueOf5);
        HashMap<String, Integer> hashMap6 = y55.a;
        Integer valueOf6 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba1);
        hashMap6.put("image_emoticon40", valueOf6);
        HashMap<String, Integer> hashMap7 = y55.a;
        Integer valueOf7 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b9f);
        hashMap7.put("image_emoticon39", valueOf7);
        HashMap<String, Integer> hashMap8 = y55.a;
        Integer valueOf8 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba2);
        hashMap8.put("image_emoticon41", valueOf8);
        HashMap<String, Integer> hashMap9 = y55.a;
        Integer valueOf9 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba3);
        hashMap9.put("image_emoticon42", valueOf9);
        HashMap<String, Integer> hashMap10 = y55.a;
        Integer valueOf10 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba4);
        hashMap10.put("image_emoticon43", valueOf10);
        HashMap<String, Integer> hashMap11 = y55.a;
        Integer valueOf11 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba5);
        hashMap11.put("image_emoticon44", valueOf11);
        HashMap<String, Integer> hashMap12 = y55.a;
        Integer valueOf12 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba6);
        hashMap12.put("image_emoticon45", valueOf12);
        HashMap<String, Integer> hashMap13 = y55.a;
        Integer valueOf13 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba7);
        hashMap13.put("image_emoticon46", valueOf13);
        HashMap<String, Integer> hashMap14 = y55.a;
        Integer valueOf14 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba8);
        hashMap14.put("image_emoticon47", valueOf14);
        HashMap<String, Integer> hashMap15 = y55.a;
        Integer valueOf15 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ba9);
        hashMap15.put("image_emoticon48", valueOf15);
        y55.a.put("image_emoticon49", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080baa));
        y55.a.put("image_emoticon50", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bac));
        y55.a.put("image_emoticon77", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbf));
        y55.a.put("image_emoticon78", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc0));
        y55.a.put("image_emoticon79", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc1));
        y55.a.put("image_emoticon80", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc3));
        y55.a.put("image_emoticon81", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc4));
        y55.a.put("image_emoticon82", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc5));
        y55.a.put("image_emoticon83", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc6));
        y55.a.put("image_emoticon84", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc7));
        y55.a.put("image_emoticon101", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5c));
        y55.a.put("image_emoticon102", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5d));
        y55.a.put("image_emoticon103", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5e));
        y55.a.put("image_emoticon104", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5f));
        y55.a.put("image_emoticon105", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b60));
        y55.a.put("image_emoticon106", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b61));
        y55.a.put("image_emoticon107", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b62));
        y55.a.put("image_emoticon108", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b63));
        y55.a.put("image_emoticon109", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b64));
        y55.a.put("image_emoticon110", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b66));
        y55.a.put("image_emoticon111", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b67));
        y55.a.put("image_emoticon112", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b68));
        y55.a.put("image_emoticon113", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b69));
        y55.a.put("image_emoticon114", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6a));
        y55.a.put("image_emoticon115", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6b));
        y55.a.put("image_emoticon116", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6c));
        y55.a.put("image_emoticon117", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6d));
        y55.a.put("image_emoticon118", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6e));
        y55.a.put("image_emoticon119", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6f));
        y55.a.put("image_emoticon120", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b71));
        y55.a.put("image_emoticon121", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b72));
        y55.a.put("image_emoticon122", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b73));
        y55.a.put("image_emoticon123", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b74));
        y55.a.put("image_emoticon124", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b75));
        y55.b.add(valueOf);
        y55.b.add(valueOf2);
        y55.b.add(valueOf3);
        y55.b.add(valueOf4);
        y55.b.add(valueOf5);
        y55.b.add(valueOf6);
        y55.b.add(valueOf7);
        y55.b.add(valueOf8);
        y55.b.add(valueOf10);
        y55.b.add(valueOf11);
        y55.b.add(valueOf15);
        y55.b.add(valueOf14);
        y55.b.add(valueOf13);
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bac));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbf));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc0));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc1));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc3));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc4));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc5));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc6));
        y55.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc7));
        y55.b.add(valueOf12);
        y55.b.add(valueOf9);
        y55.c.put("#(爱心)", valueOf);
        y55.c.put("#(心碎)", valueOf2);
        y55.c.put("#(玫瑰)", valueOf3);
        y55.c.put("#(礼物)", valueOf4);
        y55.c.put("#(彩虹)", valueOf5);
        y55.c.put("#(星星月亮)", valueOf7);
        y55.c.put("#(太阳)", valueOf6);
        y55.c.put("#(钱币)", valueOf8);
        y55.c.put("#(灯泡)", valueOf9);
        y55.c.put("#(茶杯)", valueOf10);
        y55.c.put("#(蛋糕)", valueOf11);
        y55.c.put("#(音乐)", valueOf12);
        y55.c.put("#(haha)", valueOf13);
        y55.c.put("#(胜利)", valueOf14);
        y55.c.put("#(大拇指)", valueOf15);
        y55.c.put("#(弱)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080baa));
        y55.c.put("#(OK)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bac));
        y55.c.put("#(沙发)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbf));
        y55.c.put("#(手纸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc0));
        y55.c.put("#(香蕉)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc1));
        y55.c.put("#(便便)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc3));
        y55.c.put("#(药丸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc4));
        y55.c.put("#(红领巾)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc5));
        y55.c.put("#(蜡烛)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc6));
        y55.c.put("#(三道杠)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bc7));
        y55.c.put("#(不跟丑人说话)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5c));
        y55.c.put("#(么么哒)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5d));
        y55.c.put("#(亲亲才能起来)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5e));
        y55.c.put("#(伦家只是宝宝)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b5f));
        y55.c.put("#(你是我的人)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b60));
        y55.c.put("#(假装看不见)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b61));
        y55.c.put("#(单身等撩)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b62));
        y55.c.put("#(吓到宝宝了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b63));
        y55.c.put("#(哈哈哈)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b64));
        y55.c.put("#(嗯嗯)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b66));
        y55.c.put("#(好幸福)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b67));
        y55.c.put("#(宝宝不开心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b68));
        y55.c.put("#(小姐姐别走)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b69));
        y55.c.put("#(小姐姐在吗)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6a));
        y55.c.put("#(小姐姐来啦)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6b));
        y55.c.put("#(小姐姐来玩呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6c));
        y55.c.put("#(我养你)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6d));
        y55.c.put("#(我是不会骗你的)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6e));
        y55.c.put("#(扎心了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6f));
        y55.c.put("#(无聊)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b71));
        y55.c.put("#(月亮代表我的心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b72));
        y55.c.put("#(来追我呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b73));
        y55.c.put("#(爱你的形状)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b74));
        y55.c.put("#(白眼)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b75));
    }

    public l86() {
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
