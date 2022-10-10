package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes5.dex */
public class nb8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static on p;
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

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view2);
    }

    public nb8(View view2, TbPageContext<?> tbPageContext) {
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
        this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922aa);
        this.i = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a34);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924e1);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bfc);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a8e);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bed);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f96);
        this.d = (ColumnLayout) view2.findViewById(R.id.obfuscated_res_0x7f090faa);
        this.e = (ColumnLayout) view2.findViewById(R.id.obfuscated_res_0x7f090fa0);
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09198b);
        this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091916);
        this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090685);
        this.g = ej.d(view2.getContext(), 42.0f);
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
        this.m.setText(R.string.obfuscated_res_0x7f0f1001);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.b, R.color.CAM_X0201);
            TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.n, R.drawable.obfuscated_res_0x7f080934, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = q;
            if (str2 != null && !str2.equals(str)) {
                p = null;
            }
            on onVar = p;
            if (onVar != null) {
                this.i.setImageBitmap(onVar.p());
                q = str;
                return;
            }
            HeadImageView headImageView = this.i;
            int i = this.g;
            headImageView.G(str, 12, i, i, false);
        }
    }

    public void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f = aVar;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x000d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x009c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v9, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r12v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        ?? r0 = $ic;
        if (r0 != 0) {
            charSequence = new Object[]{postInfoList, Boolean.valueOf((boolean) z), str};
            if (r0.invokeCommon(1048579, this, charSequence) != null) {
                return;
            }
        }
        String[] strArr = new String[4];
        CharSequence charSequence6 = 1000;
        charSequence6 = 1000;
        boolean z2 = true;
        CharSequence charSequence7 = null;
        try {
            try {
                try {
                    try {
                        if (z != 0) {
                            String str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str3 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            charSequence6 = formatTime;
                            charSequence = str3;
                            z = str2;
                        } else {
                            String str4 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            String str5 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            charSequence6 = formatTime2;
                            charSequence = str5;
                            z = str4;
                        }
                    } catch (Exception unused) {
                        charSequence2 = charSequence7;
                        charSequence3 = charSequence2;
                        charSequence5 = charSequence6;
                        charSequence4 = z;
                        charSequence7 = charSequence4;
                        charSequence6 = charSequence5;
                        charSequence = charSequence3;
                        z = charSequence7;
                        z2 = false;
                        charSequence7 = charSequence2;
                        if (z2) {
                        }
                    }
                } catch (Exception unused2) {
                    charSequence2 = null;
                    charSequence6 = null;
                    charSequence = null;
                    z = charSequence7;
                    z2 = false;
                    charSequence7 = charSequence2;
                    if (z2) {
                    }
                }
            } catch (Exception unused3) {
                charSequence2 = charSequence7;
                charSequence5 = charSequence6;
                charSequence3 = charSequence;
                charSequence4 = z;
                charSequence7 = charSequence4;
                charSequence6 = charSequence5;
                charSequence = charSequence3;
                z = charSequence7;
                z2 = false;
                charSequence7 = charSequence2;
                if (z2) {
                }
            }
        } catch (Exception unused4) {
            charSequence2 = charSequence7;
            CharSequence charSequence8 = charSequence2;
            charSequence3 = charSequence8;
            charSequence5 = charSequence8;
            charSequence4 = z;
            charSequence7 = charSequence4;
            charSequence6 = charSequence5;
            charSequence = charSequence3;
            z = charSequence7;
            z2 = false;
            charSequence7 = charSequence2;
            if (z2) {
            }
        }
        if (z2) {
            this.j.setText(z);
            this.k.setText(charSequence6);
            this.l.setText(charSequence);
            this.l.setTag(charSequence);
            this.m.setText(charSequence7);
            this.m.setTag(strArr);
            this.l.setOnClickListener(this);
            b(str);
            LinearLayout linearLayout = this.c;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.d.setTag(strArr);
            this.e.setTag(strArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090a8e) {
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
}
