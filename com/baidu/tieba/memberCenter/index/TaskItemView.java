package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.r0.w0.a;
import c.a.s0.f2.c.k.r;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes12.dex */
public class TaskItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47444e;

    /* renamed from: f  reason: collision with root package name */
    public View f47445f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f47446g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47447h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47448i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47449j;

    /* renamed from: k  reason: collision with root package name */
    public View f47450k;
    public View l;
    public View.OnClickListener m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskItemView(Context context, View.OnClickListener onClickListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47444e = context;
        this.m = onClickListener;
        b();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            Pattern compile = Pattern.compile("\\{\\{");
            Pattern compile2 = Pattern.compile("\\}\\}");
            String[] split = compile.split(str);
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    if (str2 != null) {
                        if (str2.contains("}}")) {
                            String[] split2 = compile2.split(str2);
                            if (split2 != null && split2.length > 0) {
                                for (String str3 : split2) {
                                    if (str3 != null) {
                                        arrayList.add(str3);
                                    }
                                }
                            }
                        } else {
                            arrayList.add(str2);
                        }
                    }
                }
            }
            int size = arrayList.size();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) arrayList.get(i2));
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                if (arrayList.get(i5) != null) {
                    i3 += ((String) arrayList.get(i5)).length();
                    if (i5 % 2 == 0) {
                        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), i4, i3, 33);
                    } else {
                        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), i4, i3, 33);
                    }
                    i4 = i3;
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.f47444e).inflate(R.layout.index_task_item, this);
            this.f47445f = inflate;
            this.l = inflate.findViewById(R.id.ly_desc);
            this.f47446g = (TbImageView) this.f47445f.findViewById(R.id.task_icon);
            this.f47447h = (TextView) this.f47445f.findViewById(R.id.txt_title);
            this.f47448i = (TextView) this.f47445f.findViewById(R.id.txt_desc);
            TextView textView = (TextView) this.f47445f.findViewById(R.id.txt_status);
            this.f47449j = textView;
            textView.setOnClickListener(this.m);
            this.l.setOnClickListener(this.m);
            this.f47450k = this.f47445f.findViewById(R.id.divider_line);
        }
    }

    public void hideDivideLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f47450k.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.a((TbPageContext) j.a(this.f47444e), this.f47445f);
        }
    }

    public void renderView(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, rVar) == null) || rVar == null) {
            return;
        }
        this.l.setTag(rVar);
        this.f47449j.setTag(rVar);
        this.f47446g.startLoad(rVar.d(), 10, false);
        String b2 = rVar.b();
        if (!StringUtils.isNull(b2) && b2.contains("\\n")) {
            b2 = rVar.b().replace("\\n", org.apache.commons.lang3.StringUtils.LF);
        }
        this.f47448i.setText(b2);
        this.f47449j.setText(this.f47444e.getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
        this.f47447h.setText(a(rVar.g()));
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.m = onClickListener;
            this.f47449j.setOnClickListener(onClickListener);
            this.l.setOnClickListener(this.m);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47444e = context;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47444e = context;
        b();
    }
}
