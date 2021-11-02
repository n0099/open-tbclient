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
import b.a.e.e.p.l;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55928e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f55929f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f55930g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55931h;

    /* renamed from: i  reason: collision with root package name */
    public View f55932i;
    public View j;
    public ItemCardView k;
    public RankStarView l;
    public c m;
    public b n;
    public TbRichTextEvaluateItemInfo o;
    public boolean p;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteEvaluationHeaderView f55933e;

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
            this.f55933e = writeEvaluationHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55933e.gotoItemSearch();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onStarChange(float f2);
    }

    /* loaded from: classes9.dex */
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
            LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
            this.f55930g = (EMTextView) findViewById(R.id.item_relevance_desc);
            this.f55929f = (EMTextView) findViewById(R.id.item_relevance_tip);
            this.f55932i = findViewById(R.id.write_select_item_relevance);
            this.f55931h = (ImageView) findViewById(R.id.item_relevance_arrow);
            this.j = findViewById(R.id.item_relevance_line);
            this.k = (ItemCardView) findViewById(R.id.item_star_info);
            RankStarView rankStarView = (RankStarView) findViewById(R.id.item_set_new_star);
            this.l = rankStarView;
            rankStarView.setStarSpacing(l.g(getContext(), R.dimen.tbds30));
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
            this.f55932i.setOnClickListener(new a(this));
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f55928e) {
            return;
        }
        this.f55928e = skinType;
        EMTextView eMTextView = this.f55929f;
        if (eMTextView != null) {
            SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0109);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f55929f);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
        }
        if (this.f55931h != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55931h, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
        View view = this.j;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0210);
        }
        ItemCardView itemCardView = this.k;
        if (itemCardView != null) {
            SkinManager.setBackgroundColor(itemCardView, R.color.CAM_X0206);
        }
        EMTextView eMTextView2 = this.f55930g;
        if (eMTextView2 != null) {
            SkinManager.setViewTextColor(eMTextView2, R.color.CAM_X0105);
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
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.f55929f.setVisibility(0);
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
                this.j.setVisibility(8);
            }
            this.l.setVisibility(0);
            this.l.setStarCount(0.0f);
            this.f55929f.setVisibility(8);
            this.k.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    public void setShowItemInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.p = z;
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.f55932i.setVisibility(8);
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
        this.f55928e = 3;
        this.p = true;
        a();
    }
}
