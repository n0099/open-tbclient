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
import c.a.e.e.p.l;
import c.a.p0.n.f;
import c.a.q0.f2.d.b;
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
/* loaded from: classes7.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f54667e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f54668f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54669g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54670h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54671i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f54672j;
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
        this.f54667e = 3;
        b();
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.o) == null) {
            return;
        }
        int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(bVar.k);
        Drawable background = this.f54671i.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
        this.f54671i.setBackgroundDrawable(background);
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.o.f18087f);
        Drawable background2 = this.f54669g.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.f54669g.setBackgroundDrawable(background2);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
            this.n = findViewById(R.id.rootLayout);
            this.f54668f = (TbImageView) findViewById(R.id.coverView);
            this.f54669g = (TextView) findViewById(R.id.indexView);
            this.f54670h = (TextView) findViewById(R.id.titleView);
            this.f54671i = (TextView) findViewById(R.id.tagView);
            this.f54672j = (TextView) findViewById(R.id.numView);
            this.k = (TextView) findViewById(R.id.descView);
            this.l = (TextView) findViewById(R.id.titlePre);
            this.m = (TextView) findViewById(R.id.titleNext);
            this.f54668f.setPlaceHolder(1);
            this.f54668f.setRadius(l.g(getContext(), R.dimen.tbds10));
            this.f54668f.setConrers(15);
            findViewById(R.id.rootLayout).setOnClickListener(this);
        }
    }

    public void bindData(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.o = bVar;
        this.f54668f.startLoad(bVar.f18091j, 10, false);
        this.f54670h.setText(bVar.f18088g);
        this.k.setText(bVar.f18089h);
        String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f54671i.getContext(), bVar.k);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f54670h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        if (TextUtils.isEmpty(hotTopicTagStr)) {
            this.f54671i.setVisibility(8);
            layoutParams.rightMargin = l.g(this.f54671i.getContext(), R.dimen.tbds42);
            this.f54670h.setLayoutParams(layoutParams);
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.m.setLayoutParams(layoutParams2);
        } else {
            layoutParams.rightMargin = l.g(this.f54671i.getContext(), R.dimen.tbds100);
            this.f54670h.setLayoutParams(layoutParams);
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.m.setLayoutParams(layoutParams2);
            this.f54671i.setVisibility(0);
            this.f54671i.setText(hotTopicTagStr);
        }
        a();
        if (bVar.f18090i > 0) {
            this.f54672j.setVisibility(0);
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(bVar.f18090i);
            TextView textView = this.f54672j;
            textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, numberUniformFormatExtraWithRoundInt));
        } else {
            this.f54672j.setVisibility(4);
        }
        TextView textView2 = this.f54669g;
        textView2.setText("" + bVar.f18087f);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f54667e == i2) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f54671i, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f54669g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54672j, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54670h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        a();
        this.f54667e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (bVar = this.o) == null) {
            return;
        }
        long j2 = bVar.f18086e;
        if (j2 <= 0) {
            return;
        }
        f<b> fVar = this.p;
        if (fVar != null) {
            fVar.a(view, bVar, bVar.f18087f, j2);
        }
        HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
        hotTopicActivityConfig.createNormalConfig("" + this.o.f18086e, null, "5").start();
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
        this.f54667e = 3;
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
        this.f54667e = 3;
        b();
    }
}
