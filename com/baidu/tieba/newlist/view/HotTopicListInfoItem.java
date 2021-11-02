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
import b.a.e.e.p.l;
import b.a.q0.n.f;
import b.a.r0.h2.d.b;
import b.a.r0.j1.c;
import b.a.r0.j1.d;
import b.a.r0.j1.e;
import b.a.r0.j1.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52025e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52026f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52027g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52028h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52029i;
    public TextView j;
    public TextView k;
    public View l;
    public b m;
    public f<b> n;

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
        this.f52025e = 3;
        b();
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.m) == null) {
            return;
        }
        int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(bVar.k);
        Drawable background = this.f52029i.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
        this.f52029i.setBackgroundDrawable(background);
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.m.f17726f);
        Drawable background2 = this.f52027g.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.f52027g.setBackgroundDrawable(background2);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(b.a.r0.j1.f.hot_topic_list_info_item, (ViewGroup) this, true);
            this.l = findViewById(e.rootLayout);
            this.f52026f = (TbImageView) findViewById(e.coverView);
            this.f52027g = (TextView) findViewById(e.indexView);
            this.f52028h = (TextView) findViewById(e.titleView);
            this.f52029i = (TextView) findViewById(e.tagView);
            this.j = (TextView) findViewById(e.numView);
            this.k = (TextView) findViewById(e.descView);
            this.f52026f.setPlaceHolder(1);
            this.f52026f.setRadius(l.g(getContext(), c.tbds10));
            this.f52026f.setConrers(15);
            findViewById(e.rootLayout).setOnClickListener(this);
        }
    }

    public void bindData(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.m = bVar;
        this.f52026f.startLoad(bVar.j, 10, false);
        this.f52028h.setCompoundDrawablesWithIntrinsicBounds(bVar.d() ? SkinManager.getDrawable(d.icon_pure_videotopic48) : null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f52028h.setText(bVar.f17727g);
        this.k.setText(bVar.f17728h);
        String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f52029i.getContext(), bVar.k);
        if (TextUtils.isEmpty(hotTopicTagStr)) {
            this.f52029i.setVisibility(8);
        } else {
            this.f52029i.setVisibility(0);
            this.f52029i.setText(hotTopicTagStr);
        }
        a();
        if (bVar.f17729i > 0) {
            this.j.setVisibility(0);
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(bVar.f17729i);
            TextView textView = this.j;
            textView.setText(textView.getContext().getResources().getString(h.hot_topic_rank_item_tag, numberUniformFormatExtraWithRoundInt));
        } else {
            this.j.setVisibility(4);
        }
        TextView textView2 = this.f52027g;
        textView2.setText("" + bVar.f17726f);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f52025e == i2) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.l, b.a.r0.j1.b.CAM_X0205, b.a.r0.j1.b.CAM_X0204);
        SkinManager.setViewTextColor(this.f52029i, b.a.r0.j1.b.CAM_X0101);
        SkinManager.setViewTextColor(this.f52027g, b.a.r0.j1.b.CAM_X0101);
        SkinManager.setViewTextColor(this.k, b.a.r0.j1.b.CAM_X0109);
        SkinManager.setViewTextColor(this.j, b.a.r0.j1.b.CAM_X0109);
        SkinManager.setViewTextColor(this.f52028h, b.a.r0.j1.b.CAM_X0105);
        a();
        this.f52025e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (bVar = this.m) == null) {
            return;
        }
        long j = bVar.f17725e;
        if (j <= 0) {
            return;
        }
        f<b> fVar = this.n;
        if (fVar != null) {
            fVar.a(view, bVar, bVar.f17726f, j);
        }
        String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.m.f17725e));
        String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.m.f17727g);
        HotTopicStat.Locate locate = HotTopicStat.Locate.TOPIC_RANK;
        if (this.m.d()) {
            HotTopicStat.a(tryFixDefaultValue, tryFixDefaultValue2, locate, null, null);
        }
        new HotTopicActivityConfig(getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.m.a()), "5", locate).start();
    }

    public void setOnItemCoverListener(f<b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.n = fVar;
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
        this.f52025e = 3;
        b();
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
        this.f52025e = 3;
        b();
    }
}
