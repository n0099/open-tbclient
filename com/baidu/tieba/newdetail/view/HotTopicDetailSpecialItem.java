package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.o0.m.f;
import c.a.p0.q2.e.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes5.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34647b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f34648c;

    /* renamed from: d  reason: collision with root package name */
    public View f34649d;

    /* renamed from: e  reason: collision with root package name */
    public View f34650e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f34651f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34652g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34653h;
    public TextView i;
    public b j;
    public f<b> k;
    public String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        b();
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        this.j = bVar;
        if (TextUtils.isEmpty(bVar.f17661d)) {
            this.f34648c.setVisibility(8);
            this.f34649d.setVisibility(8);
            this.f34650e.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.addRule(8, 0);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f09077a);
            this.i.setLayoutParams(layoutParams);
        } else {
            this.f34648c.J(bVar.f17661d, 10, false);
            this.f34648c.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f090707);
            layoutParams2.addRule(3, 0);
            this.i.setLayoutParams(layoutParams2);
            if (bVar.f17662e > 0) {
                this.f34650e.setVisibility(0);
                this.f34649d.setVisibility(0);
                this.f34652g.setText(StringUtils.translateSecondsToString(bVar.f17662e));
            } else {
                this.f34650e.setVisibility(8);
                this.f34649d.setVisibility(8);
            }
        }
        this.f34653h.setText(bVar.a);
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(bVar.f17659b);
        String str = "" + this.i.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f087e, numberUniformFormatExtra);
        String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(bVar.f17660c);
        if (str.length() > 0) {
            str = str + GlideException.IndentedAppendable.INDENT;
        }
        this.i.setText(str + this.i.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f087d, numberUniformFormatExtra2));
        setPadding(0, 0, 0, bVar.f17664g ? n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b4, (ViewGroup) this, true);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091ad8);
            this.f34647b = viewGroup;
            viewGroup.setOnClickListener(this);
            this.f34648c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090707);
            this.f34649d = findViewById(R.id.obfuscated_res_0x7f090706);
            this.f34650e = findViewById(R.id.obfuscated_res_0x7f0922fb);
            this.f34651f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0922f9);
            this.f34652g = (TextView) findViewById(R.id.obfuscated_res_0x7f0922fa);
            this.f34653h = (TextView) findViewById(R.id.obfuscated_res_0x7f09077a);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091e60);
            this.f34648c.setPlaceHolder(2);
            this.f34648c.setRadius(n.f(getContext(), R.dimen.tbds10));
            this.f34648c.setConrers(15);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == i) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.f34647b, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f34653h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f34652g, (int) R.color.CAM_X0101);
        this.f34651f.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (bVar = this.j) == null || bVar.f17665h == null) {
            return;
        }
        f<b> fVar = this.k;
        if (fVar != null) {
            fVar.a(view, bVar, 0, 0L);
        }
        ThreadCardUtils.jumpToPB(this.j.f17665h, view.getContext(), 17, false, this.l, "1");
    }

    public void setCurrentTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public void setOnItemCoverListener(f<b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.k = fVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        b();
    }
}
