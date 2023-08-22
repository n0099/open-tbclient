package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class my9 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static BdImage p;
    public static String q;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final ColumnLayout d;
    public final ColumnLayout e;
    public a f;
    public int g;
    public LinearLayout h;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public TbPageContext<?> o;

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view2);
    }

    public my9(View view2, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = tbPageContext;
        this.h = (LinearLayout) view2.findViewById(R.id.top_line);
        this.i = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d0c);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092891);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f00);
        this.l = (TextView) view2.findViewById(R.id.forum_name);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ef1);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911ab);
        this.d = (ColumnLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911ba);
        this.e = (ColumnLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911b5);
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c4f);
        this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091bd8);
        this.n = (ImageView) view2.findViewById(R.id.comment_icon);
        this.g = BdUtilHelper.dip2px(view2.getContext(), 42.0f);
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.m.setText(R.string.reply_me);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.b, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_comment22, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.forum_name) {
                TbPageContext<?> tbPageContext = this.o;
                if (tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.o.getPageActivity()).createNormalCfg((String) view2.getTag(), "")));
                    return;
                }
                return;
            }
            a aVar = this.f;
            if (aVar != null) {
                aVar.a(view2);
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = q;
            if (str2 != null && !str2.equals(str)) {
                p = null;
            }
            BdImage bdImage = p;
            if (bdImage != null) {
                this.i.setImageBitmap(bdImage.getRawBitmap());
                q = str;
                return;
            }
            HeadImageView headImageView = this.i;
            int i = this.g;
            headImageView.startLoad(str, 12, i, i, false);
        }
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f = aVar;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(PersonPostModel.PostInfoList postInfoList, boolean z, String str, int i) {
        ?? r1;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        CharSequence charSequence6;
        CharSequence charSequence7;
        CharSequence charSequence8;
        CharSequence charSequence9;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r1 = 1048579;
            if (interceptable.invokeCommon(1048579, this, new Object[]{postInfoList, Boolean.valueOf((boolean) z), str, Integer.valueOf(i)}) != null) {
                return;
            }
        }
        ?? r0 = 1000;
        r0 = 1000;
        boolean z2 = false;
        CharSequence charSequence10 = null;
        try {
            try {
                try {
                    try {
                        if (z != 0) {
                            if (StringUtils.isNull(postInfoList.name_show)) {
                                str3 = postInfoList.user_name;
                            } else {
                                str3 = postInfoList.name_show;
                            }
                            String.valueOf(postInfoList.thread_id);
                            String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str4 = postInfoList.forum_name;
                            charSequence10 = String.valueOf(postInfoList.reply_num);
                            String.valueOf(postInfoList.thread_type);
                            r0 = formatTime;
                            r1 = str4;
                            z = str3;
                        } else {
                            if (StringUtils.isNull(postInfoList.name_show)) {
                                str2 = postInfoList.user_name;
                            } else {
                                str2 = postInfoList.name_show;
                            }
                            String.valueOf(postInfoList.thread_id);
                            String.valueOf(postInfoList.content.get(0).post_id);
                            String.valueOf(postInfoList.content.get(0).post_type);
                            String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str5 = postInfoList.forum_name;
                            charSequence10 = String.valueOf(postInfoList.reply_num);
                            r0 = formatTime2;
                            r1 = str5;
                            z = str2;
                        }
                        z2 = true;
                        charSequence9 = r0;
                        charSequence8 = r1;
                        charSequence5 = z;
                    } catch (Exception e) {
                        e = e;
                        charSequence = charSequence10;
                        charSequence7 = r0;
                        charSequence6 = z;
                        charSequence10 = charSequence6;
                        charSequence2 = charSequence;
                        charSequence3 = charSequence7;
                        charSequence4 = charSequence;
                        BdLog.e(e);
                        CharSequence charSequence11 = charSequence10;
                        charSequence10 = charSequence2;
                        charSequence5 = charSequence11;
                        charSequence9 = charSequence3;
                        charSequence8 = charSequence4;
                        if (!z2) {
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    charSequence2 = null;
                    charSequence3 = null;
                    charSequence4 = null;
                    BdLog.e(e);
                    CharSequence charSequence112 = charSequence10;
                    charSequence10 = charSequence2;
                    charSequence5 = charSequence112;
                    charSequence9 = charSequence3;
                    charSequence8 = charSequence4;
                    if (!z2) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                CharSequence charSequence12 = charSequence10;
                charSequence10 = z;
                charSequence2 = charSequence12;
                charSequence3 = r0;
                charSequence4 = r1;
                BdLog.e(e);
                CharSequence charSequence1122 = charSequence10;
                charSequence10 = charSequence2;
                charSequence5 = charSequence1122;
                charSequence9 = charSequence3;
                charSequence8 = charSequence4;
                if (!z2) {
                }
            }
        } catch (Exception e4) {
            e = e4;
            CharSequence charSequence13 = charSequence10;
            charSequence = charSequence13;
            charSequence7 = charSequence13;
            charSequence6 = z;
            charSequence10 = charSequence6;
            charSequence2 = charSequence;
            charSequence3 = charSequence7;
            charSequence4 = charSequence;
            BdLog.e(e);
            CharSequence charSequence11222 = charSequence10;
            charSequence10 = charSequence2;
            charSequence5 = charSequence11222;
            charSequence9 = charSequence3;
            charSequence8 = charSequence4;
            if (!z2) {
            }
        }
        if (!z2) {
            return;
        }
        this.j.setText(charSequence5);
        this.k.setText(charSequence9);
        this.l.setText(charSequence8);
        this.l.setTag(charSequence8);
        this.m.setText(charSequence10);
        this.m.setTag(Integer.valueOf(i));
        this.l.setOnClickListener(this);
        b(str);
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.setTag(Integer.valueOf(i));
        }
        this.d.setTag(Integer.valueOf(i));
        this.e.setTag(Integer.valueOf(i));
    }
}
