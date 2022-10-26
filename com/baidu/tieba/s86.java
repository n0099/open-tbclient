package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class s86 extends c65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105336, "Lcom/baidu/tieba/s86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105336, "Lcom/baidu/tieba/s86;");
                return;
            }
        }
        c65.a.put("video_icon", Integer.valueOf((int) R.drawable.ico_link_video));
        HashMap hashMap = c65.a;
        Integer valueOf = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bab);
        hashMap.put("image_emoticon34", valueOf);
        HashMap hashMap2 = c65.a;
        Integer valueOf2 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bac);
        hashMap2.put("image_emoticon35", valueOf2);
        HashMap hashMap3 = c65.a;
        Integer valueOf3 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bad);
        hashMap3.put("image_emoticon36", valueOf3);
        HashMap hashMap4 = c65.a;
        Integer valueOf4 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bae);
        hashMap4.put("image_emoticon37", valueOf4);
        HashMap hashMap5 = c65.a;
        Integer valueOf5 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080baf);
        hashMap5.put("image_emoticon38", valueOf5);
        HashMap hashMap6 = c65.a;
        Integer valueOf6 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb2);
        hashMap6.put("image_emoticon40", valueOf6);
        HashMap hashMap7 = c65.a;
        Integer valueOf7 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb0);
        hashMap7.put("image_emoticon39", valueOf7);
        HashMap hashMap8 = c65.a;
        Integer valueOf8 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb3);
        hashMap8.put("image_emoticon41", valueOf8);
        HashMap hashMap9 = c65.a;
        Integer valueOf9 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb4);
        hashMap9.put("image_emoticon42", valueOf9);
        HashMap hashMap10 = c65.a;
        Integer valueOf10 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb5);
        hashMap10.put("image_emoticon43", valueOf10);
        HashMap hashMap11 = c65.a;
        Integer valueOf11 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb6);
        hashMap11.put("image_emoticon44", valueOf11);
        HashMap hashMap12 = c65.a;
        Integer valueOf12 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb7);
        hashMap12.put("image_emoticon45", valueOf12);
        HashMap hashMap13 = c65.a;
        Integer valueOf13 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb8);
        hashMap13.put("image_emoticon46", valueOf13);
        HashMap hashMap14 = c65.a;
        Integer valueOf14 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bb9);
        hashMap14.put("image_emoticon47", valueOf14);
        HashMap hashMap15 = c65.a;
        Integer valueOf15 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bba);
        hashMap15.put("image_emoticon48", valueOf15);
        c65.a.put("image_emoticon49", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbb));
        c65.a.put("image_emoticon50", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbd));
        c65.a.put("image_emoticon77", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd0));
        c65.a.put("image_emoticon78", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd1));
        c65.a.put("image_emoticon79", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd2));
        c65.a.put("image_emoticon80", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd4));
        c65.a.put("image_emoticon81", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd5));
        c65.a.put("image_emoticon82", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd6));
        c65.a.put("image_emoticon83", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd7));
        c65.a.put("image_emoticon84", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd8));
        c65.a.put("image_emoticon101", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6d));
        c65.a.put("image_emoticon102", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6e));
        c65.a.put("image_emoticon103", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6f));
        c65.a.put("image_emoticon104", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b70));
        c65.a.put("image_emoticon105", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b71));
        c65.a.put("image_emoticon106", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b72));
        c65.a.put("image_emoticon107", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b73));
        c65.a.put("image_emoticon108", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b74));
        c65.a.put("image_emoticon109", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b75));
        c65.a.put("image_emoticon110", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b77));
        c65.a.put("image_emoticon111", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b78));
        c65.a.put("image_emoticon112", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b79));
        c65.a.put("image_emoticon113", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7a));
        c65.a.put("image_emoticon114", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7b));
        c65.a.put("image_emoticon115", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7c));
        c65.a.put("image_emoticon116", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7d));
        c65.a.put("image_emoticon117", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7e));
        c65.a.put("image_emoticon118", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7f));
        c65.a.put("image_emoticon119", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b80));
        c65.a.put("image_emoticon120", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b82));
        c65.a.put("image_emoticon121", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b83));
        c65.a.put("image_emoticon122", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b84));
        c65.a.put("image_emoticon123", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b85));
        c65.a.put("image_emoticon124", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b86));
        c65.b.add(valueOf);
        c65.b.add(valueOf2);
        c65.b.add(valueOf3);
        c65.b.add(valueOf4);
        c65.b.add(valueOf5);
        c65.b.add(valueOf6);
        c65.b.add(valueOf7);
        c65.b.add(valueOf8);
        c65.b.add(valueOf10);
        c65.b.add(valueOf11);
        c65.b.add(valueOf15);
        c65.b.add(valueOf14);
        c65.b.add(valueOf13);
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbd));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd0));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd1));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd2));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd4));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd5));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd6));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd7));
        c65.b.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd8));
        c65.b.add(valueOf12);
        c65.b.add(valueOf9);
        c65.c.put("#(爱心)", valueOf);
        c65.c.put("#(心碎)", valueOf2);
        c65.c.put("#(玫瑰)", valueOf3);
        c65.c.put("#(礼物)", valueOf4);
        c65.c.put("#(彩虹)", valueOf5);
        c65.c.put("#(星星月亮)", valueOf7);
        c65.c.put("#(太阳)", valueOf6);
        c65.c.put("#(钱币)", valueOf8);
        c65.c.put("#(灯泡)", valueOf9);
        c65.c.put("#(茶杯)", valueOf10);
        c65.c.put("#(蛋糕)", valueOf11);
        c65.c.put("#(音乐)", valueOf12);
        c65.c.put("#(haha)", valueOf13);
        c65.c.put("#(胜利)", valueOf14);
        c65.c.put("#(大拇指)", valueOf15);
        c65.c.put("#(弱)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbb));
        c65.c.put("#(OK)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bbd));
        c65.c.put("#(沙发)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd0));
        c65.c.put("#(手纸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd1));
        c65.c.put("#(香蕉)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd2));
        c65.c.put("#(便便)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd4));
        c65.c.put("#(药丸)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd5));
        c65.c.put("#(红领巾)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd6));
        c65.c.put("#(蜡烛)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd7));
        c65.c.put("#(三道杠)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080bd8));
        c65.c.put("#(不跟丑人说话)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6d));
        c65.c.put("#(么么哒)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6e));
        c65.c.put("#(亲亲才能起来)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b6f));
        c65.c.put("#(伦家只是宝宝)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b70));
        c65.c.put("#(你是我的人)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b71));
        c65.c.put("#(假装看不见)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b72));
        c65.c.put("#(单身等撩)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b73));
        c65.c.put("#(吓到宝宝了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b74));
        c65.c.put("#(哈哈哈)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b75));
        c65.c.put("#(嗯嗯)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b77));
        c65.c.put("#(好幸福)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b78));
        c65.c.put("#(宝宝不开心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b79));
        c65.c.put("#(小姐姐别走)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7a));
        c65.c.put("#(小姐姐在吗)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7b));
        c65.c.put("#(小姐姐来啦)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7c));
        c65.c.put("#(小姐姐来玩呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7d));
        c65.c.put("#(我养你)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7e));
        c65.c.put("#(我是不会骗你的)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b7f));
        c65.c.put("#(扎心了)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b80));
        c65.c.put("#(无聊)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b82));
        c65.c.put("#(月亮代表我的心)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b83));
        c65.c.put("#(来追我呀)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b84));
        c65.c.put("#(爱你的形状)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b85));
        c65.c.put("#(白眼)", Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080b86));
    }

    public s86() {
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
