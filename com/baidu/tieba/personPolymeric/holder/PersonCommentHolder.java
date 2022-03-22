package com.baidu.tieba.personPolymeric.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.d.o.d.a;
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
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonCommentHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static a p;
    public static String q;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyLinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35464b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f35465c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f35466d;

    /* renamed from: e  reason: collision with root package name */
    public final ColumnLayout f35467e;

    /* renamed from: f  reason: collision with root package name */
    public final ColumnLayout f35468f;

    /* renamed from: g  reason: collision with root package name */
    public int f35469g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f35470h;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TbPageContext<?> n;
    public boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCommentHolder(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, Boolean.valueOf(z)};
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
        ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0906df);
        this.a = replyLinearLayout;
        replyLinearLayout.setIsHost(this.o);
        this.f35464b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09161e);
        this.f35470h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0920c0);
        this.i = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f0918a4);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922e5);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091a6c);
        this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a67);
        this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091a5c);
        this.f35466d = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090f62);
        this.f35467e = (ColumnLayout) view.findViewById(R.id.obfuscated_res_0x7f090f77);
        this.f35468f = (ColumnLayout) view.findViewById(R.id.obfuscated_res_0x7f090f6d);
        this.f35465c = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0917a3);
        this.f35469g = n.d(view.getContext(), 42.0f);
        LinearLayout linearLayout = this.f35466d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.f35467e.setOnClickListener(this);
        this.f35468f.setOnClickListener(this);
        this.f35464b.setOnClickListener(this);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            SkinManager.setBackgroundResource(this.f35464b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(b(), R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f35465c, R.drawable.daily_recommend_item_selector);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = q;
            if (str2 != null && !str2.equals(str)) {
                p = null;
            }
            a aVar = p;
            if (aVar != null) {
                this.i.setImageBitmap(aVar.p());
                q = str;
                return;
            }
            HeadImageView headImageView = this.i;
            int i = this.f35469g;
            headImageView.G(str, 12, i, i, false);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x000d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.widget.TextView] */
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
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        Object[] objArr;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        ?? r12;
        boolean z2;
        ?? r122;
        Object obj5;
        ?? r3;
        ?? r2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            objArr = new Object[]{postInfoList, Boolean.valueOf(z), str};
            if (interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, objArr) != null) {
                return;
            }
        }
        String[] strArr = new String[4];
        ?? r22 = 1000;
        r22 = 1000;
        Object obj6 = null;
        try {
            try {
                try {
                    try {
                        if (z) {
                            boolean z3 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            ?? r32 = postInfoList.forum_name;
                            obj6 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            r22 = formatTime;
                            objArr = r32;
                            z = z3;
                        } else {
                            boolean z4 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            ?? r33 = postInfoList.forum_name;
                            obj6 = String.valueOf(postInfoList.reply_num);
                            r22 = formatTime2;
                            objArr = r33;
                            z = z4;
                        }
                        z2 = true;
                        r2 = r22;
                        r3 = objArr;
                        r12 = z;
                    } catch (Exception unused) {
                        obj = obj6;
                        obj2 = obj;
                        obj5 = r22;
                        r122 = z;
                        obj6 = r122;
                        obj3 = obj5;
                        obj4 = obj2;
                        r12 = obj6;
                        obj6 = obj;
                        z2 = false;
                        r2 = obj3;
                        r3 = obj4;
                        if (z2) {
                        }
                    }
                } catch (Exception unused2) {
                    obj = null;
                    obj3 = null;
                    obj4 = null;
                    r12 = obj6;
                    obj6 = obj;
                    z2 = false;
                    r2 = obj3;
                    r3 = obj4;
                    if (z2) {
                    }
                }
            } catch (Exception unused3) {
                obj = obj6;
                obj5 = r22;
                obj2 = objArr;
                r122 = z;
                obj6 = r122;
                obj3 = obj5;
                obj4 = obj2;
                r12 = obj6;
                obj6 = obj;
                z2 = false;
                r2 = obj3;
                r3 = obj4;
                if (z2) {
                }
            }
        } catch (Exception unused4) {
            obj = obj6;
            Object obj7 = obj;
            obj2 = obj7;
            obj5 = obj7;
            r122 = z;
            obj6 = r122;
            obj3 = obj5;
            obj4 = obj2;
            r12 = obj6;
            obj6 = obj;
            z2 = false;
            r2 = obj3;
            r3 = obj4;
            if (z2) {
            }
        }
        if (z2) {
            this.j.setText(r12);
            this.k.setText(r2);
            this.l.setText(r3);
            this.l.setTag(r3);
            this.m.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f03f9), new Object[]{obj6}));
            this.l.setOnClickListener(this);
            d(str);
            LinearLayout linearLayout = this.f35466d;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.f35467e.setTag(strArr);
            this.f35468f.setTag(strArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            TiebaStatic.log(new StatisticItem("c12043").param("obj_type", this.o ? 1 : 2));
            if (view == this.l) {
                if (this.n != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.n.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
                }
            } else if (view != this.f35464b || (strArr = (String[]) view.getTag()) == null || strArr.length < 4 || strArr[3] == null) {
            } else {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.n.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                }
            }
        }
    }
}
