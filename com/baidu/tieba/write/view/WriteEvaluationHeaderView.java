package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.p4.d;
import c.a.t0.p4.e;
import c.a.t0.p4.f;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import c.a.t0.p4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49755e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f49756f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f49757g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f49758h;

    /* renamed from: i  reason: collision with root package name */
    public View f49759i;

    /* renamed from: j  reason: collision with root package name */
    public View f49760j;
    public ItemCardView k;
    public RankStarView l;
    public c m;
    public b n;
    public TbRichTextEvaluateItemInfo o;
    public boolean p;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteEvaluationHeaderView f49761e;

        public a(WriteEvaluationHeaderView writeEvaluationHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeEvaluationHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49761e = writeEvaluationHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49761e.gotoItemSearch();
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        void onStarChange(float f2);
    }

    /* loaded from: classes13.dex */
    public interface c {
        void onClose();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WriteEvaluationHeaderView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(h.write_evaluation_header_view, (ViewGroup) this, true);
            this.f49757g = (EMTextView) findViewById(g.item_relevance_desc);
            this.f49756f = (EMTextView) findViewById(g.item_relevance_tip);
            this.f49759i = findViewById(g.write_select_item_relevance);
            this.f49758h = (ImageView) findViewById(g.item_relevance_arrow);
            this.f49760j = findViewById(g.item_relevance_line);
            this.k = (ItemCardView) findViewById(g.item_star_info);
            RankStarView rankStarView = (RankStarView) findViewById(g.item_set_new_star);
            this.l = rankStarView;
            rankStarView.setStarSpacing(n.f(getContext(), e.tbds30));
            this.l.setClickable(true);
            this.l.setStarChangListener(this);
            this.k.showCloseButton();
            this.k.setOnCloseListener(this);
            this.k.setSizeStyle(1);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49759i.setOnClickListener(new a(this));
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public ItemCardView getItemStarInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (ItemCardView) invokeV.objValue;
    }

    public int getStarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l.getStarCount() : invokeV.intValue;
    }

    public void gotoItemSearch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RelevanceItemSearchActivityConfig(getContext(), 25048)));
        }
    }

    public boolean isAllFillIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l.hasStarSelected() : invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f49755e) {
            return;
        }
        this.f49755e = skinType;
        EMTextView eMTextView = this.f49756f;
        if (eMTextView != null) {
            SkinManager.setViewTextColor(eMTextView, d.CAM_X0109);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f49756f);
            d2.n(j.J_X06);
            d2.f(d.CAM_X0206);
        }
        if (this.f49758h != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f49758h, f.icon_pure_list_arrow16_right_svg, d.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
        View view = this.f49760j;
        if (view != null) {
            SkinManager.setBackgroundColor(view, d.CAM_X0210);
        }
        ItemCardView itemCardView = this.k;
        if (itemCardView != null) {
            SkinManager.setBackgroundColor(itemCardView, d.CAM_X0206);
        }
        EMTextView eMTextView2 = this.f49757g;
        if (eMTextView2 != null) {
            SkinManager.setViewTextColor(eMTextView2, d.CAM_X0105);
        }
        RankStarView rankStarView = this.l;
        if (rankStarView != null) {
            rankStarView.onChangeSkinType(skinType);
        }
        RankStarView rankStarView2 = this.l;
        if (rankStarView2 != null) {
            rankStarView2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            this.k.setVisibility(8);
            this.f49760j.setVisibility(0);
            this.l.setVisibility(8);
            this.f49756f.setVisibility(0);
            c cVar = this.m;
            if (cVar != null) {
                cVar.onClose();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void onStarChange(float f2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.onStarChange(f2);
    }

    public void setItemCloseListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbRichTextEvaluateItemInfo) == null) {
            this.o = tbRichTextEvaluateItemInfo;
            if (this.p) {
                this.k.setVisibility(0);
                this.f49760j.setVisibility(8);
            }
            this.l.setVisibility(0);
            this.l.setStarCount(0.0f);
            this.f49756f.setVisibility(8);
            this.k.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    public void setShowItemInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.p = z;
            this.k.setVisibility(8);
            this.f49760j.setVisibility(0);
            this.f49759i.setVisibility(8);
        }
    }

    public void setStarChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void setStarCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l.setStarCount(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f49755e = 3;
        this.p = true;
        a();
    }
}
