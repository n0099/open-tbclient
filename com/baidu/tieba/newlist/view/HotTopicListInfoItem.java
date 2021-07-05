package com.baidu.tieba.newlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.m.f;
import d.a.s0.e2.d.b;
/* loaded from: classes5.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f19013e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f19014f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19015g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19016h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19017i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public b o;
    public f<b> p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListInfoItem(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19013e = 3;
        c();
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        this.o = bVar;
        this.f19014f.M(bVar.j, 10, false);
        this.f19016h.setText(bVar.f59152g);
        this.k.setText(bVar.f59153h);
        String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f19017i.getContext(), bVar.k);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19016h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        if (TextUtils.isEmpty(hotTopicTagStr)) {
            this.f19017i.setVisibility(8);
            layoutParams.rightMargin = l.g(this.f19017i.getContext(), R.dimen.tbds42);
            this.f19016h.setLayoutParams(layoutParams);
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.m.setLayoutParams(layoutParams2);
        } else {
            layoutParams.rightMargin = l.g(this.f19017i.getContext(), R.dimen.tbds100);
            this.f19016h.setLayoutParams(layoutParams);
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.m.setLayoutParams(layoutParams2);
            this.f19017i.setVisibility(0);
            this.f19017i.setText(hotTopicTagStr);
        }
        b();
        if (bVar.f59154i > 0) {
            this.j.setVisibility(0);
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(bVar.f59154i);
            TextView textView = this.j;
            textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, numberUniformFormatExtraWithRoundInt));
        } else {
            this.j.setVisibility(4);
        }
        TextView textView2 = this.f19015g;
        textView2.setText("" + bVar.f59151f);
    }

    public final void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.o) == null) {
            return;
        }
        int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(bVar.k);
        Drawable background = this.f19017i.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
        this.f19017i.setBackgroundDrawable(background);
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.o.f59151f);
        Drawable background2 = this.f19015g.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.f19015g.setBackgroundDrawable(background2);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
            this.n = findViewById(R.id.rootLayout);
            this.f19014f = (TbImageView) findViewById(R.id.coverView);
            this.f19015g = (TextView) findViewById(R.id.indexView);
            this.f19016h = (TextView) findViewById(R.id.titleView);
            this.f19017i = (TextView) findViewById(R.id.tagView);
            this.j = (TextView) findViewById(R.id.numView);
            this.k = (TextView) findViewById(R.id.descView);
            this.l = (TextView) findViewById(R.id.titlePre);
            this.m = (TextView) findViewById(R.id.titleNext);
            this.f19014f.setPlaceHolder(1);
            this.f19014f.setRadius(l.g(getContext(), R.dimen.tbds10));
            this.f19014f.setConrers(15);
            findViewById(R.id.rootLayout).setOnClickListener(this);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f19013e == i2) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f19017i, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f19015g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f19016h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        b();
        this.f19013e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (bVar = this.o) == null) {
            return;
        }
        long j = bVar.f59150e;
        if (j <= 0) {
            return;
        }
        f<b> fVar = this.p;
        if (fVar != null) {
            fVar.a(view, bVar, bVar.f59151f, j);
        }
        HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
        hotTopicActivityConfig.createNormalConfig("" + this.o.f59150e, null, "5").start();
    }

    public void setOnItemCoverListener(f<b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.p = fVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19013e = 3;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f19013e = 3;
        c();
    }
}
