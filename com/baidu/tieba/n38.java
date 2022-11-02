package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class n38 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View.OnClickListener b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public ThreadData g;
    public boolean h;
    public boolean i;
    public String j;
    public int k;
    public View.OnLongClickListener l;
    public View.OnClickListener m;

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public View d;

        public a(Context context, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.d = view2;
            this.b = view2.findViewById(R.id.divider_line);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905fc);
            this.c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != this.a) {
                    SkinManager.setBackgroundColor(this.b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
                    this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
                }
                this.a = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public LinearLayout c;
        public TextView d;
        public TbRichTextView e;
        public View f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
        }
    }

    public n38(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = false;
        this.e = false;
        this.f = true;
        this.h = false;
        this.i = false;
        this.j = "";
        this.k = -1;
        this.l = null;
        this.m = null;
        this.a = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0664, (ViewGroup) null);
            inflate.setTag(new a(this.a, inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0665, (ViewGroup) null);
            bVar.b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091fe9);
            bVar.c = linearLayout;
            if (this.h) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                layoutParams.bottomMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                bVar.c.setLayoutParams(layoutParams);
            }
            bVar.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914ca);
            bVar.e = (TbRichTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916cf);
            bVar.f = inflate.findViewById(R.id.obfuscated_res_0x7f09080a);
            bVar.e.getLayoutStrategy().t();
            if (!this.h) {
                bVar.e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                bVar.e.getLayoutStrategy().j(0);
                bVar.e.getLayoutStrategy().l(xi.g(this.a, R.dimen.tbds20));
                bVar.e.getLayoutStrategy().m(xi.g(this.a, R.dimen.tbds14));
                bVar.e.setMaxLines(4);
                bVar.e.setTextEllipsize(TextUtils.TruncateAt.END);
                bVar.e.setAddTruncateListener(true);
                bVar.e.setTextSize(TbConfig.getOutterSubpbContentSize());
            } else {
                bVar.e.setTextSize(TbConfig.getContentSizeOfLzl());
            }
            bVar.e.setSubPbPost(true);
            bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            bVar.e.setIsNeedResizeEmotion(true);
            bVar.e.setTextCenter(true);
            bVar.e.setOnClickListener(this.m);
            bVar.d.setOnClickListener(this.b);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09209c, bVar);
            inflate.setTag(sparseArray);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        boolean z7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && bVar != null && postData != null) {
            boolean z8 = true;
            boolean z9 = false;
            if (!postData.Z) {
                Context context = this.a;
                if (context instanceof qy7) {
                    qy7 qy7Var = (qy7) context;
                    TbPageContext pageContext = qy7Var.getPageContext();
                    if (postData.s() != null && qy7Var.F(postData.s().getUserId())) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    postData.i1(pageContext, z7);
                }
            }
            if (z3) {
                SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0204);
            } else {
                bVar.b.setBackgroundResource(0);
            }
            if (postData.u0()) {
                bVar.f.setVisibility(0);
            } else {
                bVar.f.setVisibility(8);
            }
            bVar.e.setPadding(0, 0, 0, 0);
            if (postData.s() != null) {
                String name_show = postData.s().getName_show();
                String userId = postData.s().getUserId();
                String portrait = postData.s().getPortrait();
                SparseArray sparseArray2 = (SparseArray) bVar.b.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.b.setTag(sparseArray2);
                    bVar.e.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.obfuscated_res_0x7f0920bd, name_show);
                sparseArray2.put(R.id.obfuscated_res_0x7f0920bc, userId);
                sparseArray2.put(R.id.obfuscated_res_0x7f0920bb, portrait);
                sparseArray2.put(R.id.obfuscated_res_0x7f092087, postData);
                sparseArray2.put(R.id.obfuscated_res_0x7f0920a0, Boolean.TRUE);
            }
            bVar.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
            bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            d(postData, this.h);
            TbRichText X = postData.X();
            if (X != null) {
                bVar.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d091b);
                bVar.e.setIsFromCDN(this.f);
                if (bVar.a != TbadkCoreApplication.getInst().getSkinType()) {
                    X.isChanged = true;
                }
                bVar.e.setText(X);
            }
            String userId2 = postData.s().getUserId();
            int i = this.c;
            if (i != 0) {
                if (i != 1002 && i != 3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (this.c != 3 && !this.g.isBjh()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z4 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z4 = false;
                }
            } else {
                z4 = false;
                z5 = false;
            }
            if (this.d) {
                if (!this.g.isBjh()) {
                    z5 = true;
                }
                if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = true;
                    if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z9 = true;
                    } else {
                        z8 = z5;
                    }
                    bVar.d.setVisibility(8);
                    sparseArray = (SparseArray) bVar.b.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.b.setTag(sparseArray);
                        bVar.e.setTag(sparseArray);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920d5, this.j);
                    if (!z4) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920d0, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(this.c));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getName_show());
                            sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.s().getPortrait());
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.M());
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920d0, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.M());
                    sparseArray.put(R.id.obfuscated_res_0x7f092087, postData);
                    if (!z6) {
                        if (this.g != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.TRUE);
                            sparseArray.put(R.id.obfuscated_res_0x7f09209e, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.s() != null) {
                                sparseArray.put(R.id.obfuscated_res_0x7f0920e0, postData.s().getUserId());
                                sparseArray.put(R.id.obfuscated_res_0x7f0920e1, postData.s().getUserName());
                                sparseArray.put(R.id.obfuscated_res_0x7f0920df, postData.s().getName_show());
                            }
                            if (this.g.getId() != null) {
                                sparseArray.put(R.id.obfuscated_res_0x7f0920e3, this.g.getId());
                            }
                            sparseArray.put(R.id.obfuscated_res_0x7f0920e2, postData.M());
                        }
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.FALSE);
                    }
                    if (!z8) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ce, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(this.c));
                        sparseArray.put(R.id.obfuscated_res_0x7f09208a, Boolean.valueOf(z9));
                        sparseArray.put(R.id.obfuscated_res_0x7f09208b, 2);
                        sparseArray.put(R.id.obfuscated_res_0x7f092089, postData.M());
                        sparseArray.put(R.id.obfuscated_res_0x7f09209b, Boolean.valueOf(postData.q0()));
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ce, Boolean.FALSE);
                    }
                    if (this.h && z2 && this.i) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                        layoutParams.topMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070207);
                        layoutParams.bottomMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                        bVar.c.setLayoutParams(layoutParams);
                    }
                    if (this.h && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                        layoutParams2.topMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                        layoutParams2.bottomMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                        bVar.c.setLayoutParams(layoutParams2);
                    }
                    bVar.d.setTag(sparseArray);
                    bVar.e.setTag(sparseArray);
                    bVar.a = TbadkCoreApplication.getInst().getSkinType();
                    bVar.e.setOnLongClickListener(this.l);
                    if (postData == null && postData.s() != null && postData.q() != null) {
                        q38.b("1", String.valueOf(postData.q().threadId), TbadkCoreApplication.getCurrentAccount(), postData.M(), postData.I(), postData.J());
                        return;
                    }
                    return;
                }
            }
            z6 = false;
            if (userId2 == null) {
            }
            z8 = z5;
            bVar.d.setVisibility(8);
            sparseArray = (SparseArray) bVar.b.getTag();
            if (sparseArray == null) {
            }
            sparseArray.put(R.id.obfuscated_res_0x7f0920d5, this.j);
            if (!z4) {
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.M());
            sparseArray.put(R.id.obfuscated_res_0x7f092087, postData);
            if (!z6) {
            }
            if (!z8) {
            }
            if (this.h) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                layoutParams3.topMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070207);
                layoutParams3.bottomMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                bVar.c.setLayoutParams(layoutParams3);
            }
            if (this.h) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                layoutParams22.topMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                layoutParams22.bottomMargin = xi.g(this.a, R.dimen.obfuscated_res_0x7f070302);
                bVar.c.setLayoutParams(layoutParams22);
            }
            bVar.d.setTag(sparseArray);
            bVar.e.setTag(sparseArray);
            bVar.a = TbadkCoreApplication.getInst().getSkinType();
            bVar.e.setOnLongClickListener(this.l);
            if (postData == null) {
            }
        }
    }

    public final void d(PostData postData, boolean z) {
        TbRichText X;
        SpannableStringBuilder J;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, postData, z) != null) || postData == null || (X = postData.X()) == null) {
            return;
        }
        ArrayList<TbRichTextData> B = X.B();
        if (ListUtils.isEmpty(B)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = B.get(B.size() - 1);
            int i2 = -1;
            if (tbRichTextData != null) {
                i = tbRichTextData.getType();
            } else {
                i = -1;
            }
            if (i == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.h0());
                if (B.size() > 1) {
                    if (B.get(B.size() - 2) != null) {
                        i2 = B.get(B.size() - 2).getType();
                    }
                    if (i2 != i) {
                        str2 = StringHelper.getFormatTime(postData.h0());
                    }
                }
                SpannableStringBuilder J2 = tbRichTextData.J();
                if (X.hasAppendTime && J2 != 0 && X.appendLength <= J2.length()) {
                    J2.delete(J2.length() - X.appendLength, J2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (J2 != null) {
                    J2.append((CharSequence) str);
                }
                X.hasAppendTime = true;
                X.appendLength = str.length();
            } else if (!X.hasAppendTime) {
                String formatTime = StringHelper.getFormatTime(postData.h0());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.A(forceLToR);
                X.hasAppendTime = true;
                X.appendLength = forceLToR.length();
                B.add(tbRichTextData);
                str = forceLToR;
            } else {
                str = "";
            }
            SpannableStringBuilder J3 = tbRichTextData.J();
            if (J3 != null && str.length() <= J3.length()) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
                J3.setSpan(absoluteSizeSpan, J3.length() - str.length(), J3.length(), 33);
                J3.setSpan(foregroundColorSpan, J3.length() - str.length(), J3.length(), 33);
                return;
            }
            return;
        }
        TbRichTextData tbRichTextData2 = B.get(B.size() - 1);
        if (X.hasAppendTime && tbRichTextData2 != null && (J = tbRichTextData2.J()) != null && X.appendLength <= J.length()) {
            J.delete(J.length() - X.appendLength, J.length());
        }
        X.hasAppendTime = false;
        X.appendLength = 0;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f = z;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.b = onClickListener;
        }
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            this.g = threadData;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        PostData postData;
        b bVar;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (getItem(i) instanceof PostData) {
                postData = (PostData) getItem(i);
            } else {
                postData = null;
            }
            PostData postData2 = postData;
            if (view2 == null) {
                if (postData2.getType() == PostData.S0) {
                    view2 = a();
                } else {
                    view2 = b();
                }
            }
            if ((view2.getTag() instanceof a) && postData2.getType() != PostData.S0) {
                view2 = b();
            }
            if ((view2.getTag() instanceof SparseArray) && postData2.getType() == PostData.S0) {
                view2 = a();
            }
            if ((view2.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09209c)) != null && postData2 != null) {
                if (!this.e && i + 1 >= getCount()) {
                    z = true;
                } else {
                    z = false;
                }
                if (i == this.k) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = !z;
                if (i == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                c(bVar, postData2, z4, z3, z2);
                if (z2) {
                    this.k = -1;
                }
            }
            if (view2.getTag() instanceof a) {
                ((a) view2.getTag()).a(TbadkCoreApplication.getInst().getSkinType());
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void j(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.c = i;
            this.d = z;
        }
    }
}
