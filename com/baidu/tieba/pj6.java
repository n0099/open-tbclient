package com.baidu.tieba;

import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public pj6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public final SpannableString d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), 0, spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final SpannableStringBuilder a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, str5, str6, str7})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) ("忍不住想告诉你个好消息，" + str + "吧的成员数量突破了"));
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("人");
            spannableStringBuilder.append((CharSequence) d(sb.toString()));
            spannableStringBuilder.append((CharSequence) ("！作为吧主，我邀请你加入" + str + "吧！\n\n"));
            spannableStringBuilder.append((CharSequence) "在我担任吧主的这");
            spannableStringBuilder.append((CharSequence) d(str3 + "天"));
            spannableStringBuilder.append((CharSequence) ("，为" + str + "吧创造了良好的社区氛围，近期发现了"));
            spannableStringBuilder.append((CharSequence) i(str4));
            spannableStringBuilder.append((CharSequence) "篇优质贴子，最火热的一篇");
            spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
            spannableStringBuilder.append((CharSequence) "竟然盖了");
            spannableStringBuilder.append((CharSequence) d(str7 + "层"));
            spannableStringBuilder.append((CharSequence) "楼。\n\n");
            spannableStringBuilder.append((CharSequence) "我很喜欢");
            spannableStringBuilder.append((CharSequence) i(str));
            spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final SpannableStringBuilder g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, str5, str6, str7})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) ("恭喜！" + str + "吧成员数突破"));
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("人");
            spannableStringBuilder.append((CharSequence) d(sb.toString()));
            spannableStringBuilder.append((CharSequence) "！\n\n");
            spannableStringBuilder.append((CharSequence) "感谢你在过去");
            spannableStringBuilder.append((CharSequence) d(str3 + "天"));
            spannableStringBuilder.append((CharSequence) "的辛勤付出，火眼金睛的你最近挑选出了");
            spannableStringBuilder.append((CharSequence) i(str4));
            spannableStringBuilder.append((CharSequence) "篇精品贴子，处理了大量违规内容。\n\n衷心感谢你为吧友提供了和谐快乐的社区氛围。截止目前");
            spannableStringBuilder.append((CharSequence) i(str));
            spannableStringBuilder.append((CharSequence) "吧共有");
            spannableStringBuilder.append((CharSequence) d(str5 + "篇"));
            spannableStringBuilder.append((CharSequence) "贴子，最火热的一篇贴子");
            spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
            spannableStringBuilder.append((CharSequence) "竟然盖了");
            spannableStringBuilder.append((CharSequence) d(str7 + "层"));
            spannableStringBuilder.append((CharSequence) "楼。\n\n继续加油吧！期望你能带领");
            spannableStringBuilder.append((CharSequence) i(str));
            spannableStringBuilder.append((CharSequence) "吧走得更远！");
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final SpannableStringBuilder b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
            spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
            spannableStringBuilder.append((CharSequence) d(str2 + "人"));
            spannableStringBuilder.append((CharSequence) "了！\n\n");
            spannableStringBuilder.append((CharSequence) "我加入");
            spannableStringBuilder.append((CharSequence) (str + "吧已经"));
            spannableStringBuilder.append((CharSequence) d(str3 + "天"));
            spannableStringBuilder.append((CharSequence) "了，近期发表了");
            spannableStringBuilder.append((CharSequence) i(str4));
            spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
            spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
            spannableStringBuilder.append((CharSequence) "收到了");
            spannableStringBuilder.append((CharSequence) d(str7 + "条"));
            spannableStringBuilder.append((CharSequence) "回复、");
            spannableStringBuilder.append((CharSequence) d(str8 + "个"));
            spannableStringBuilder.append((CharSequence) "赞！\n\n");
            spannableStringBuilder.append((CharSequence) "我很喜欢");
            spannableStringBuilder.append((CharSequence) i(str));
            spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final SpannableStringBuilder c(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "给你安利一个有趣的社区——");
            spannableStringBuilder.append((CharSequence) (str + "吧！现在成员数已经突破"));
            spannableStringBuilder.append((CharSequence) d(str2 + "人"));
            spannableStringBuilder.append((CharSequence) "了！\n\n");
            spannableStringBuilder.append((CharSequence) "我加入");
            spannableStringBuilder.append((CharSequence) (str + "吧已经"));
            spannableStringBuilder.append((CharSequence) d(str3 + "天"));
            spannableStringBuilder.append((CharSequence) "了，近期参与了");
            spannableStringBuilder.append((CharSequence) i(str4));
            spannableStringBuilder.append((CharSequence) "主题贴的讨论，写了");
            spannableStringBuilder.append((CharSequence) d(str5 + "条"));
            spannableStringBuilder.append((CharSequence) "评论。\n\n");
            spannableStringBuilder.append((CharSequence) "我很喜欢");
            spannableStringBuilder.append((CharSequence) i(str));
            spannableStringBuilder.append((CharSequence) "吧，我觉得你也会喜欢！加入我们吧，有你一定更精彩！");
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final SpannableStringBuilder f(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
            spannableStringBuilder.append((CharSequence) d(str2 + "人"));
            spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
            spannableStringBuilder.append((CharSequence) (str + "吧已经"));
            spannableStringBuilder.append((CharSequence) d(str3 + "天"));
            spannableStringBuilder.append((CharSequence) "了，近期参与了");
            spannableStringBuilder.append((CharSequence) i(str4));
            spannableStringBuilder.append((CharSequence) "个主题贴的讨论，写了");
            spannableStringBuilder.append((CharSequence) d(str5 + "条"));
            spannableStringBuilder.append((CharSequence) "评论。近一个月累计签到了");
            spannableStringBuilder.append((CharSequence) (str6 + "天。\n\n"));
            spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final SpannableStringBuilder e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9})) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) (str + "吧成员数突破了"));
            spannableStringBuilder.append((CharSequence) d(str2 + "人"));
            spannableStringBuilder.append((CharSequence) "！感谢你的一路相伴，见证了这个特别的时刻。\n\n你加入");
            spannableStringBuilder.append((CharSequence) (str + "吧已经"));
            spannableStringBuilder.append((CharSequence) d(str3 + "天"));
            spannableStringBuilder.append((CharSequence) "了，最近发表了");
            spannableStringBuilder.append((CharSequence) i(str4));
            spannableStringBuilder.append((CharSequence) "篇贴子，最火的一篇");
            spannableStringBuilder.append((CharSequence) d("《" + str6 + "》"));
            spannableStringBuilder.append((CharSequence) "收到了");
            spannableStringBuilder.append((CharSequence) d(str7 + "条"));
            spannableStringBuilder.append((CharSequence) "回复、");
            spannableStringBuilder.append((CharSequence) d(str8 + "个"));
            spannableStringBuilder.append((CharSequence) "赞！近一个月累计签到了");
            spannableStringBuilder.append((CharSequence) (str9 + "天"));
            spannableStringBuilder.append((CharSequence) "。\n\n");
            spannableStringBuilder.append((CharSequence) (str + "吧因为有你而精彩！"));
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public SpannableStringBuilder h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.m;
            if (str == null) {
                return null;
            }
            if (str.equals("bazhu")) {
                return a(this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            }
            if (this.m.equals("active-a")) {
                return b(this.f, this.g, this.n, this.o, this.j, this.k, this.p, this.q, this.r);
            }
            if (!this.m.equals("active-b")) {
                return null;
            }
            return c(this.f, this.g, this.n, this.s, this.t, this.r);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public SpannableStringBuilder j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.m;
            if (str == null) {
                return null;
            }
            if (str.equals("bazhu")) {
                return g(this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            }
            if (this.m.equals("active-a")) {
                return e(this.f, this.g, this.n, this.o, this.j, this.k, this.p, this.q, this.r);
            }
            if (!this.m.equals("active-b")) {
                return null;
            }
            return f(this.f, this.g, this.n, this.s, this.t, this.r);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void k() {
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a.getPageActivity() != null && this.a.getPageActivity().getIntent() != null) {
            this.b = this.a.getPageActivity().getIntent().getStringExtra("key_url");
            this.c = this.a.getPageActivity().getIntent().getStringExtra(AchievementActivityConfig.KEY_SHARE_URL);
            if (TextUtils.isEmpty(this.b) || (parse = Uri.parse(this.b)) == null) {
                return;
            }
            this.d = parse.getQueryParameter("nickname");
            this.e = parse.getQueryParameter("fid");
            this.f = parse.getQueryParameter("fname");
            this.g = parse.getQueryParameter("subcribe-num");
            this.h = parse.getQueryParameter("bazhu-days");
            this.i = parse.getQueryParameter("goods-num");
            this.j = parse.getQueryParameter("tid-num");
            String queryParameter = parse.getQueryParameter("most-hot-name");
            this.k = queryParameter;
            this.k = StringHelper.cutStringWithSuffix(queryParameter, 20, StringHelper.STRING_MORE);
            this.l = parse.getQueryParameter("most-hot-floors");
            this.m = parse.getQueryParameter("achievement");
            this.n = parse.getQueryParameter("join-days");
            this.o = parse.getQueryParameter("send-tids");
            this.p = parse.getQueryParameter("reply-num");
            this.q = parse.getQueryParameter("zan-num");
            this.r = parse.getQueryParameter("sign-days");
            this.s = parse.getQueryParameter("join-topicnum");
            this.t = parse.getQueryParameter("write-num");
        }
    }
}
