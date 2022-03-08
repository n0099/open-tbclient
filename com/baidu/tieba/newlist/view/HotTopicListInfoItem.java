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
import c.a.d.f.p.n;
import c.a.q0.m.f;
import c.a.r0.r2.d.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44908e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f44909f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44910g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44911h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44912i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f44913j;
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
        this.f44908e = 3;
        b();
    }

    public final void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.m) == null) {
            return;
        }
        int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(bVar.k);
        Drawable background = this.f44912i.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
        this.f44912i.setBackgroundDrawable(background);
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.m.f21599f);
        Drawable background2 = this.f44910g.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.f44910g.setBackgroundDrawable(background2);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
            this.l = findViewById(R.id.rootLayout);
            this.f44909f = (TbImageView) findViewById(R.id.coverView);
            this.f44910g = (TextView) findViewById(R.id.indexView);
            this.f44911h = (TextView) findViewById(R.id.titleView);
            this.f44912i = (TextView) findViewById(R.id.tagView);
            this.f44913j = (TextView) findViewById(R.id.numView);
            this.k = (TextView) findViewById(R.id.descView);
            this.f44909f.setPlaceHolder(1);
            this.f44909f.setRadius(n.f(getContext(), R.dimen.tbds10));
            this.f44909f.setConrers(15);
            findViewById(R.id.rootLayout).setOnClickListener(this);
        }
    }

    public void bindData(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.m = bVar;
        this.f44909f.startLoad(bVar.f21603j, 10, false);
        this.f44911h.setCompoundDrawablesWithIntrinsicBounds(bVar.d() ? WebPManager.getPureDrawable(R.drawable.icon_pure_videotopic48, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL) : null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f44911h.setText(bVar.f21600g);
        this.k.setText(bVar.f21601h);
        String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f44912i.getContext(), bVar.k);
        if (TextUtils.isEmpty(hotTopicTagStr)) {
            this.f44912i.setVisibility(8);
        } else {
            this.f44912i.setVisibility(0);
            this.f44912i.setText(hotTopicTagStr);
        }
        a();
        if (bVar.f21602i > 0) {
            this.f44913j.setVisibility(0);
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(bVar.f21602i);
            TextView textView = this.f44913j;
            textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, numberUniformFormatExtraWithRoundInt));
        } else {
            this.f44913j.setVisibility(4);
        }
        TextView textView2 = this.f44910g;
        textView2.setText("" + bVar.f21599f);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f44908e == i2) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.l, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f44912i, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f44910g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f44913j, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f44911h, (int) R.color.CAM_X0105);
        a();
        this.f44908e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (bVar = this.m) == null) {
            return;
        }
        long j2 = bVar.f21598e;
        if (j2 <= 0) {
            return;
        }
        f<b> fVar = this.n;
        if (fVar != null) {
            fVar.a(view, bVar, bVar.f21599f, j2);
        }
        String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.m.f21598e));
        String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.m.f21600g);
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
        this.f44908e = 3;
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
        this.f44908e = 3;
        b();
    }
}
