package com.baidu.tieba.lego.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.g0.m;
import c.a.t0.g0.v;
import c.a.t0.x3.w;
import c.a.t0.y1.o.a;
import c.a.t0.y1.o.c;
import c.a.t0.y1.o.k.b;
import c.a.t0.y1.o.l.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes12.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a afterClickSchemeListener;
    public c downloadAppCallback;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45561e;
    public int mBusinessType;
    public TbPageContext mContext;
    public String mFrom;
    public boolean mIsFromCDN;
    public int mPosition;
    public int mSkinType;
    public View vCard;
    public View vCover;
    public ImageView vLine;
    public View vSpaceDown;
    public View vSpaceUp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.mSkinType = 3;
        this.f45561e = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.vLine, R.color.CAM_X0201);
            SkinManager.setImageResource(this.vLine, R.color.CAM_X0204);
            int i2 = this.mBusinessType;
            if (i2 == 1) {
                this.vSpaceUp.setBackgroundColor(getResources().getColor(17170445));
                this.vSpaceDown.setBackgroundColor(getResources().getColor(17170445));
            } else if (i2 != 2 && i2 != 3) {
                this.vSpaceUp.setBackgroundColor(getResources().getColor(17170445));
                this.vSpaceDown.setBackgroundColor(getResources().getColor(17170445));
            } else {
                SkinManager.setBackgroundColor(this.vSpaceUp, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.vSpaceDown, R.color.CAM_X0204);
            }
        }
    }

    public final void adjustBackground(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.vCover.setVisibility(t.isShowCover() ? 0 : 8);
            int showSpace = t.getShowSpace();
            showLine(showSpace != 0 ? -1 : t.getShowLine());
            if (showSpace == 0) {
                this.vSpaceUp.setVisibility(8);
                this.vSpaceDown.setVisibility(8);
            } else if (showSpace == 1) {
                this.vSpaceUp.setVisibility(8);
                this.vSpaceDown.setVisibility(0);
            } else if (showSpace == 2) {
                this.vSpaceUp.setVisibility(0);
                this.vSpaceDown.setVisibility(8);
            } else if (showSpace != 3) {
            } else {
                this.vSpaceUp.setVisibility(0);
                this.vSpaceDown.setVisibility(0);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            initCardView();
            postInit();
            this.f45561e = false;
        }
    }

    public final SpannableString changeParamsColor(String str, List<String> list, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, str, list, i2, i3)) == null) {
            if (TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
                return null;
            }
            int indexOf = str.indexOf("{%s}", 0);
            if (indexOf >= 0) {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                int i5 = 0;
                while (indexOf >= 0) {
                    sb.append(str.substring(i4, indexOf));
                    if (i5 < list.size()) {
                        arrayList.add(Integer.valueOf(sb.length()));
                        sb.append(list.get(i5));
                        int i6 = indexOf + 4;
                        i4 = i6;
                        indexOf = str.indexOf("{%s}", i6);
                        i5++;
                    } else {
                        indexOf = -1;
                    }
                }
                if (i4 < str.length()) {
                    sb.append(str.substring(i4));
                }
                SpannableString spannableString = new SpannableString(sb.toString());
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    int intValue = ((Integer) arrayList.get(i7)).intValue();
                    spannableString.setSpan(new ForegroundColorSpan(isNightMode() ? i3 : i2), intValue, list.get(i7).length() + intValue, 33);
                }
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeLLII.objValue;
    }

    public final String changeParamsCount(String str, HashMap<String, Integer> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, hashMap)) == null) {
            Matcher matcher = Pattern.compile("\\{(\\w+)\\}").matcher(str);
            while (matcher.find()) {
                String group = matcher.group(1);
                str = str.replace(matcher.group(0), (hashMap == null || hashMap.get(group) == null) ? "" : StringHelper.numFormatOver10000(hashMap.get(group).intValue()));
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public final <S> S findViewById(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, view, i2)) == null) ? (S) view.findViewById(i2) : (S) invokeLI.objValue;
    }

    public final int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mBusinessType : invokeV.intValue;
    }

    public final int getStatPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPosition + 1 : invokeV.intValue;
    }

    public final void handleClickEvent(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            v.b().d(true);
            openCardScheme(t);
        }
    }

    public final ViewGroup.LayoutParams initCardLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new ViewGroup.LayoutParams(-1, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public final void initCardView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (this.mBusinessType == 4) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
            }
            View initLayout = initLayout();
            this.vCard = initLayout;
            frameLayout.addView(initLayout, initCardLayoutParams());
            View view = new View(getContext());
            this.vCover = view;
            SkinManager.setBackgroundColor(view, R.color.common_color_10205);
            frameLayout.addView(this.vCover, new ViewGroup.LayoutParams(-1, -1));
            this.vLine = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
            SkinManager.setBackgroundColor(this.vLine, R.color.CAM_X0201);
            SkinManager.setImageResource(this.vLine, R.color.CAM_X0204);
            this.vSpaceUp = new View(getContext());
            this.vSpaceDown = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
            int i2 = this.mBusinessType;
            if (i2 != 1) {
                if (i2 == 2) {
                    SkinManager.setBackgroundColor(this.vSpaceUp, R.color.CAM_X0204);
                    addView(this.vSpaceUp, layoutParams3);
                    addView(this.vLine, layoutParams2);
                    addView(frameLayout, layoutParams);
                    SkinManager.setBackgroundColor(this.vSpaceDown, R.color.CAM_X0204);
                    addView(this.vSpaceDown, layoutParams3);
                    return;
                } else if (i2 == 3) {
                    SkinManager.setBackgroundColor(this.vSpaceUp, R.color.CAM_X0204);
                    addView(this.vSpaceUp, layoutParams3);
                    addView(frameLayout, layoutParams);
                    layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                    addView(this.vLine, layoutParams2);
                    SkinManager.setBackgroundColor(this.vSpaceDown, R.color.CAM_X0204);
                    addView(this.vSpaceDown, layoutParams3);
                    return;
                } else if (i2 != 4) {
                    if (i2 != 5) {
                        this.vSpaceUp.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.vSpaceUp, layoutParams3);
                        layoutParams2.bottomMargin = 0;
                        addView(frameLayout, layoutParams);
                        addView(this.vLine, layoutParams2);
                        this.vSpaceDown.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.vSpaceDown, layoutParams3);
                        return;
                    }
                    addView(frameLayout, layoutParams);
                    return;
                }
            }
            this.vSpaceUp.setBackgroundColor(getResources().getColor(17170445));
            addView(this.vSpaceUp, layoutParams3);
            layoutParams2.bottomMargin = 0;
            addView(this.vLine, layoutParams2);
            addView(frameLayout, layoutParams);
            this.vSpaceDown.setBackgroundColor(getResources().getColor(17170445));
            addView(this.vSpaceDown, layoutParams3);
        }
    }

    public abstract View initLayout();

    public final boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? 1 == TbadkCoreApplication.getInst().getSkinType() : invokeV.booleanValue;
    }

    public final void logClickStatistics(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        for (String str3 : str2.split("&")) {
            String[] split = str3.split("=");
            if (split.length == 2) {
                statisticItem.param(split[0], split[1]);
            }
        }
        statisticItem.param("obj_locate", getStatPosition());
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, m.e());
        TiebaStatic.log(statisticItem);
    }

    public final void logShowStatistics(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, t) == null) || t == null || TextUtils.isEmpty(t.getShowKey()) || TextUtils.isEmpty(t.getShowExtra())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(t.getShowKey());
        for (String str : t.getShowExtra().split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                statisticItem.param(split[0], split[1]);
            }
        }
        statisticItem.param("obj_locate", getStatPosition());
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, m.e());
        v.b().a(statisticItem);
    }

    public abstract void onChangeSkinType(T t, int i2);

    @Override // c.a.t0.y1.o.l.e
    public void onScrollIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public abstract void onUpdateCardView(T t);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ void onUpdateCardView(ICardInfo iCardInfo) {
        onUpdateCardView((BaseLegoCardView<T>) ((BaseLegoCardInfo) iCardInfo));
    }

    @Override // c.a.t0.y1.o.l.e
    public void onViewBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // c.a.t0.y1.o.l.e
    public void onViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void openCardScheme(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, t) == null) {
            int c2 = w.c(this.mContext, t.getScheme());
            a aVar = this.afterClickSchemeListener;
            if (aVar != null) {
                aVar.a(c2, null);
            }
        }
    }

    public void postInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // c.a.t0.y1.o.l.e
    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
        }
    }

    @Override // c.a.t0.y1.o.l.e
    public final void setAfterClickSchemeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.afterClickSchemeListener = aVar;
        }
    }

    public final void setBackgroundColor(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048601, this, view, i2, i3, i4) == null) {
            if (!b.a(i2) && !b.a(i3)) {
                if (isNightMode()) {
                    i2 = i3;
                }
                view.setBackgroundColor(i2);
                return;
            }
            SkinManager.setBackgroundColor(view, i4);
        }
    }

    @Override // c.a.t0.y1.o.l.e
    public final void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mBusinessType = i2;
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onLongClickListener) == null) {
            setOnLongClickListener(onLongClickListener);
        }
    }

    @Override // c.a.t0.y1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            this.downloadAppCallback = cVar;
        }
    }

    @Override // c.a.t0.y1.o.l.e
    public final void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mIsFromCDN = z;
        }
    }

    @Override // c.a.t0.y1.o.l.e
    public final void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.mPosition = i2;
        }
    }

    public final void setTextColor(TextView textView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048608, this, textView, i2, i3, i4) == null) {
            if (!b.a(i2) && !b.a(i3)) {
                if (isNightMode()) {
                    i2 = i3;
                }
                textView.setTextColor(i2);
                return;
            }
            SkinManager.setViewTextColor(textView, i4);
        }
    }

    public final void showCardView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.vCard.setVisibility(0);
        }
    }

    public final void showIsDone(TextView textView, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{textView, Boolean.valueOf(z), str, str2}) == null) {
            if (z) {
                textView.setEnabled(false);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
                textView.setText(str2);
                textView.setBackgroundDrawable(null);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setPadding(0, 0, 0, 0);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
            textView.setText(str);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setEnabled(true);
            textView.setPadding(getResources().getDimensionPixelSize(R.dimen.ds18), 0, getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
    }

    public final void showLine(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            if (i2 == -1 || i2 == 0) {
                this.vLine.setVisibility(8);
            } else if (i2 == 1) {
                this.vLine.setPadding(0, 0, 0, 0);
                this.vLine.setVisibility(0);
            } else if (i2 == 2) {
                this.vLine.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.vLine.setVisibility(0);
            } else if (i2 != 3) {
                this.vLine.setVisibility(8);
            } else {
                this.vLine.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.vLine.setVisibility(0);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.a.t0.y1.o.l.e
    public final void update(Object obj) {
        ICardInfo iCardInfo;
        ICardInfo updateCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, obj) == null) || (iCardInfo = (ICardInfo) obj) == null || (updateCard = iCardInfo.getUpdateCard()) == null) {
            return;
        }
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) updateCard;
        logShowStatistics(baseLegoCardInfo);
        if (this.f45561e) {
            b();
        }
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            a();
            onChangeSkinType(baseLegoCardInfo, this.mSkinType);
        }
        showCardView();
        onUpdateCardView((BaseLegoCardView<T>) baseLegoCardInfo);
        adjustBackground(baseLegoCardInfo);
    }

    @Override // c.a.t0.y1.o.l.e
    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }
}
