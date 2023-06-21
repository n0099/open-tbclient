package com.baidu.tieba.personPolymeric.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hn;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonCommentHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static hn p;
    public static String q;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyLinearLayout a;
    public TextView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final ColumnLayout e;
    public final ColumnLayout f;
    public int g;
    public LinearLayout h;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TbPageContext<?> n;
    public boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCommentHolder(View view2, TbPageContext<?> tbPageContext, boolean z) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = tbPageContext;
        this.o = z;
        ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view2.findViewById(R.id.content_container);
        this.a = replyLinearLayout;
        replyLinearLayout.setIsHost(this.o);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091976);
        this.h = (LinearLayout) view2.findViewById(R.id.top_line);
        this.i = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c58);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927a8);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e37);
        this.l = (TextView) view2.findViewById(R.id.forum_name);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e28);
        this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091164);
        this.e = (ColumnLayout) view2.findViewById(R.id.obfuscated_res_0x7f091173);
        this.f = (ColumnLayout) view2.findViewById(R.id.obfuscated_res_0x7f09116e);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b2b);
        this.g = wi.d(view2.getContext(), 42.0f);
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x000d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Type inference failed for: r11v11, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v12, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v9, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        Object[] objArr;
        CharSequence charSequence;
        CharSequence charSequence2;
        ?? r12;
        CharSequence charSequence3;
        Object obj;
        CharSequence charSequence4;
        CharSequence charSequence5;
        boolean z2;
        ?? r3;
        CharSequence charSequence6;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            objArr = new Object[]{postInfoList, Boolean.valueOf(z), str};
            if (interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, objArr) != null) {
                return;
            }
        }
        String[] strArr = new String[4];
        ?? r2 = 1000;
        r2 = 1000;
        CharSequence charSequence7 = null;
        try {
            try {
                try {
                    try {
                        if (z) {
                            if (TextUtils.isEmpty(postInfoList.name_show)) {
                                z4 = postInfoList.user_name;
                            } else {
                                z4 = postInfoList.name_show;
                            }
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            ?? r32 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            r2 = formatTime;
                            objArr = r32;
                            z = z4;
                        } else {
                            if (TextUtils.isEmpty(postInfoList.name_show)) {
                                z3 = postInfoList.user_name;
                            } else {
                                z3 = postInfoList.name_show;
                            }
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content.get(0).post_id);
                            strArr[2] = String.valueOf(postInfoList.content.get(0).post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            ?? r33 = postInfoList.forum_name;
                            charSequence7 = String.valueOf(postInfoList.reply_num);
                            r2 = formatTime2;
                            objArr = r33;
                            z = z3;
                        }
                        z2 = true;
                        charSequence6 = r2;
                        r3 = objArr;
                        charSequence5 = z;
                    } catch (Exception unused) {
                        charSequence = null;
                        charSequence4 = null;
                        obj = null;
                        charSequence5 = charSequence7;
                        charSequence7 = charSequence;
                        z2 = false;
                        charSequence6 = charSequence4;
                        r3 = obj;
                        if (!z2) {
                        }
                    }
                } catch (Exception unused2) {
                    charSequence = charSequence7;
                    CharSequence charSequence8 = charSequence;
                    charSequence2 = charSequence8;
                    charSequence3 = charSequence8;
                    r12 = z;
                    charSequence7 = r12;
                    charSequence4 = charSequence3;
                    obj = charSequence2;
                    charSequence5 = charSequence7;
                    charSequence7 = charSequence;
                    z2 = false;
                    charSequence6 = charSequence4;
                    r3 = obj;
                    if (!z2) {
                    }
                }
            } catch (Exception unused3) {
                charSequence = charSequence7;
                charSequence2 = charSequence;
                charSequence3 = r2;
                r12 = z;
                charSequence7 = r12;
                charSequence4 = charSequence3;
                obj = charSequence2;
                charSequence5 = charSequence7;
                charSequence7 = charSequence;
                z2 = false;
                charSequence6 = charSequence4;
                r3 = obj;
                if (!z2) {
                }
            }
        } catch (Exception unused4) {
            charSequence = charSequence7;
            charSequence3 = r2;
            charSequence2 = objArr;
            r12 = z;
            charSequence7 = r12;
            charSequence4 = charSequence3;
            obj = charSequence2;
            charSequence5 = charSequence7;
            charSequence7 = charSequence;
            z2 = false;
            charSequence6 = charSequence4;
            r3 = obj;
            if (!z2) {
            }
        }
        if (!z2) {
            return;
        }
        this.j.setText(charSequence5);
        this.k.setText(charSequence6);
        this.l.setText(r3);
        this.l.setTag(r3);
        this.m.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), charSequence7));
        this.l.setOnClickListener(this);
        b(str);
        LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.setTag(strArr);
        }
        this.e.setTag(strArr);
        this.f.setTag(strArr);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            SkinManager.setBackgroundResource(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(getView(), R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.c, R.drawable.daily_recommend_item_selector);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = q;
            if (str2 != null && !str2.equals(str)) {
                p = null;
            }
            hn hnVar = p;
            if (hnVar != null) {
                this.i.setImageBitmap(hnVar.p());
                q = str;
                return;
            }
            HeadImageView headImageView = this.i;
            int i = this.g;
            headImageView.J(str, 12, i, i, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            StatisticItem statisticItem = new StatisticItem("c12043");
            if (this.o) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i));
            if (view2 == this.l) {
                if (this.n != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.n.getPageActivity()).createNormalCfg((String) view2.getTag(), "")));
                }
            } else if (view2 == this.b && (strArr = (String[]) view2.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.n.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                }
            }
        }
    }
}
