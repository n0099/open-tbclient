package com.baidu.tieba;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class s48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TbImageView g;
    public ThreadAgreeAndShareLayout h;
    public boolean i;
    public boolean j;
    public boolean k;
    public e05 l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public xm5 q;
    public View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s48 a;

        public a(s48 s48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s48Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s48 s48Var = this.a;
                if (s48Var.b == null || s48Var.m == null || this.a.k || (layout = this.a.b.getLayout()) == null) {
                    return;
                }
                if (!this.a.i) {
                    int lineCount = layout.getLineCount();
                    if (lineCount < 2 || (ellipsisCount = layout.getEllipsisCount(lineCount - 1)) == 0) {
                        return;
                    }
                    if (this.a.n == null) {
                        String spannableStringBuilder = this.a.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.a.n = new SpannableStringBuilder();
                        this.a.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.a.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.a.m.getSpanStart(obj);
                            int spanEnd = this.a.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.a.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.a.q, 0, spannableString.length(), 17);
                        this.a.n.insert(length, (CharSequence) spannableString);
                        s48 s48Var2 = this.a;
                        s48Var2.p = new j19(s48Var2.n);
                    }
                    this.a.e.setVisibility(8);
                    s48 s48Var3 = this.a;
                    s48Var3.b.setOnTouchListener(s48Var3.p);
                    s48 s48Var4 = this.a;
                    s48Var4.b.setText(s48Var4.n);
                } else if (!this.a.j) {
                    int lineCount2 = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.e.getLayoutParams();
                    if (this.a.e.getWidth() + layout.getLineWidth(lineCount2 - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, R.id.obfuscated_res_0x7f092625);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, R.id.obfuscated_res_0x7f092625);
                        layoutParams.addRule(3, 0);
                    }
                    this.a.e.setLayoutParams(layoutParams);
                    this.a.j = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends xm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s48 s48Var, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s48Var, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = str2;
        }

        @Override // com.baidu.tieba.xm5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sp4.x(TbadkCoreApplication.getInst().getApplicationContext(), false, this.h);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // com.baidu.tieba.xm5, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends xm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s48 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s48 s48Var, int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s48Var, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = s48Var;
        }

        @Override // com.baidu.tieba.xm5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.h.i = true;
            this.h.b.setMaxLines(10);
            s48 s48Var = this.h;
            s48Var.b.setOnTouchListener(new j19(s48Var.m));
            s48 s48Var2 = this.h;
            s48Var2.b.setText(s48Var2.m);
            this.h.e.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s48 a;

        public d(s48 s48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.f) {
                    Object tag = this.a.f.getTag();
                    Context context = view2.getContext();
                    if ((tag instanceof String) && context != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                        return;
                    }
                    return;
                }
                s48 s48Var = this.a;
                if (view2 != s48Var.e) {
                    return;
                }
                s48Var.i = false;
                s48 s48Var2 = this.a;
                s48Var2.b.setOnTouchListener(s48Var2.p);
                s48 s48Var3 = this.a;
                s48Var3.b.setText(s48Var3.n);
                this.a.e.setVisibility(8);
            }
        }
    }

    public s48(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new c(this, 2, null);
        this.r = new d(this);
        if (view2 == null) {
            return;
        }
        this.a = view2;
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092625);
        this.b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.b.getPaint().setFakeBoldText(true);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0918e3);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0918e1);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092626);
        this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0918d7);
        this.h = (ThreadAgreeAndShareLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0918cd);
        this.g = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0902d0);
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(ox7 ox7Var, String str) {
        ThreadData Q;
        su4 su4Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout E;
        SpannableString h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, ox7Var, str) == null) && ox7Var != null && (Q = ox7Var.Q()) != null && Q.getThreadVideoInfo() != null) {
            Q.parserTitleFrsForTop();
            this.m = new SpannableStringBuilder(Q.getSpan_str());
            boolean n = n(Q);
            VideoInfo threadVideoInfo = Q.getThreadVideoInfo();
            if (!StringUtils.isNull(threadVideoInfo.mcn_lead_page) && !n) {
                this.k = true;
            } else {
                this.k = false;
            }
            if (this.m != null && !this.k && !n && (h = q18.h(Q)) != null) {
                e05[] e05VarArr = (e05[]) h.getSpans(0, h.length(), e05.class);
                if (e05VarArr != null && e05VarArr.length > 0) {
                    this.l = e05VarArr[0];
                }
                this.m.append((CharSequence) h);
            }
            if (this.l != null && (spannableStringBuilder = this.m) != null && (E = q18.E(spannableStringBuilder)) != null && E.getLineCount() > 10) {
                int spanStart = this.m.getSpanStart(this.l);
                int spanEnd = this.m.getSpanEnd(this.l);
                if (spanStart > 0) {
                    this.m.delete(spanStart, spanEnd);
                }
            }
            if (this.k) {
                x48.a(TbadkCoreApplication.getInst().getApplicationContext(), this.b, Q.getSpan_str().toString(), threadVideoInfo.mcn_lead_page, Q.getTid());
            } else {
                this.b.setText(this.m);
            }
            this.b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            j19 j19Var = new j19(this.m);
            this.o = j19Var;
            this.b.setOnTouchListener(j19Var);
            this.e.setOnClickListener(this.r);
            this.d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e42), StringHelper.numberUniformFormatExtra(threadVideoInfo.play_count.intValue())));
            if (ox7Var.l0() && ox7Var.y0()) {
                if (TextUtils.isEmpty(str)) {
                    str = Q.getForum_name();
                }
                if (TextUtils.isEmpty(str) && (su4Var = (su4) ListUtils.getItem(ox7Var.p(), 0)) != null) {
                    str = su4Var.b;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.g.setVisibility(0);
                    this.f.setVisibility(0);
                    this.f.setOnClickListener(this.r);
                    this.f.setText(q18.j(str));
                    this.f.setTag(str);
                } else {
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                }
                this.c.setVisibility(8);
                this.h.setData(ox7Var, Q.getAgreeData());
            } else {
                this.g.setVisibility(8);
                this.f.setVisibility(8);
                this.c.setVisibility(0);
                this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e43), StringHelper.numberUniformFormatExtra(Q.getReply_num())));
                this.h.setVisibility(8);
            }
            o();
        }
    }

    public final boolean n(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null || this.m == null || !threadData.canShowNaniTail() || StringUtils.isNull(threadData.getTid())) {
                return false;
            }
            String str = py4.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + threadData.getTid();
            this.m.append((CharSequence) threadData.generateNaniTail(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(this.g, R.drawable.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.j();
            }
        }
    }
}
