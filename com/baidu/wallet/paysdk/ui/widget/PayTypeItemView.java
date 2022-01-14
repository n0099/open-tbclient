package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.base.widget.BorderTipTextView;
import com.dxmpay.wallet.base.widget.LinkNoScrollMovementMethod;
import java.io.Serializable;
/* loaded from: classes13.dex */
public class PayTypeItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52451b;

    /* renamed from: c  reason: collision with root package name */
    public BorderTipTextView f52452c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52453d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52454e;
    public Context mContext;
    public PayTypeItemViewData mData;
    public ProgressBar mProgress;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class ItemViewType implements Serializable {
        public static final /* synthetic */ ItemViewType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ItemViewType ADD_NEWCARD;
        public static final ItemViewType BALANCE;
        public static final ItemViewType BANKCARD;
        public static final ItemViewType CREDIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1191004678, "Lcom/baidu/wallet/paysdk/ui/widget/PayTypeItemView$ItemViewType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1191004678, "Lcom/baidu/wallet/paysdk/ui/widget/PayTypeItemView$ItemViewType;");
                    return;
                }
            }
            BANKCARD = new ItemViewType("BANKCARD", 0);
            BALANCE = new ItemViewType("BALANCE", 1);
            CREDIT = new ItemViewType("CREDIT", 2);
            ItemViewType itemViewType = new ItemViewType("ADD_NEWCARD", 3);
            ADD_NEWCARD = itemViewType;
            $VALUES = new ItemViewType[]{BANKCARD, BALANCE, CREDIT, itemViewType};
        }

        public ItemViewType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ItemViewType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ItemViewType) Enum.valueOf(ItemViewType.class, str) : (ItemViewType) invokeL.objValue;
        }

        public static ItemViewType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ItemViewType[]) $VALUES.clone() : (ItemViewType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class PayTypeItemViewData implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String MASK_FLAG = "^";
        public transient /* synthetic */ FieldHolder $fh;
        public CardData.BondCard card;
        public boolean highlight;
        public String hintMsg;
        public String hintUrl;
        public boolean isAvaible;
        public boolean isChecked;
        public boolean isRecommended;
        public String jump_url;
        public String logoUrl;
        public String name;
        public String tips;
        public ItemViewType type;

        public PayTypeItemViewData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int getEndIndex(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return -1;
                }
                return str.lastIndexOf(MASK_FLAG);
            }
            return invokeL.intValue;
        }

        public int getStartIndex(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return -1;
                }
                return str.indexOf(MASK_FLAG);
            }
            return invokeL.intValue;
        }

        public boolean isNeedToColored() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int startIndex = getStartIndex(this.tips);
                int endIndex = getEndIndex(this.tips);
                return (-1 == startIndex || -1 == endIndex || startIndex >= endIndex) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public String removeSeparator(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                int startIndex = getStartIndex(str);
                int endIndex = getEndIndex(str);
                if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
                    return str;
                }
                return str.substring(0, startIndex) + str.substring(startIndex + 1, endIndex) + str.substring(endIndex + 1);
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayTypeItemView(Context context) {
        super(context.getApplicationContext());
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
        this.mContext = context.getApplicationContext();
    }

    private void a(PayTypeItemViewData payTypeItemViewData, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, payTypeItemViewData, onClickListener, onClickListener2) == null) {
            this.mData = payTypeItemViewData;
            View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_paytype_item_view"), this);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar"));
            this.mProgress = progressBar;
            progressBar.setVisibility(8);
            this.f52454e = (ImageView) inflate.findViewById(ResUtils.id(getContext(), "paytype_select"));
            this.a = (NetImageView) findViewById(ResUtils.id(this.mContext, "ebpay_paytype_logo"));
            this.f52451b = (TextView) findViewById(ResUtils.id(this.mContext, "paytype_name"));
            if (!TextUtils.isEmpty(payTypeItemViewData.name)) {
                this.f52451b.setText(payTypeItemViewData.name);
            }
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_free_amount"));
            if (ItemViewType.BANKCARD == payTypeItemViewData.type) {
                CardData.BondCard bondCard = payTypeItemViewData.card;
                z = (bondCard == null || TextUtils.isEmpty(bondCard.channelDiscountDesc)) ? false : true;
                if (z) {
                    textView.setVisibility(0);
                    textView.setText(payTypeItemViewData.card.channelDiscountDesc);
                }
            } else {
                z = false;
            }
            inflate.findViewById(ResUtils.id(getContext(), "paytype_recommended")).setVisibility(payTypeItemViewData.isRecommended ? 0 : 4);
            this.f52452c = (BorderTipTextView) findViewById(ResUtils.id(this.mContext, "paytype_tip"));
            if (!TextUtils.isEmpty(payTypeItemViewData.tips) && (!z || !payTypeItemViewData.tips.equals(textView.getText()))) {
                this.f52452c.setVisibility(0);
                if (payTypeItemViewData.isNeedToColored()) {
                    a(payTypeItemViewData, onClickListener);
                } else {
                    this.f52452c.setText(payTypeItemViewData.tips, payTypeItemViewData.highlight);
                }
            } else {
                this.f52452c.setVisibility(8);
            }
            this.f52453d = (TextView) findViewById(ResUtils.id(this.mContext, "paytype_hint"));
            if (!TextUtils.isEmpty(payTypeItemViewData.hintMsg)) {
                this.f52453d.setVisibility(0);
                this.f52453d.setText(payTypeItemViewData.hintMsg);
                LinearLayout linearLayout = (LinearLayout) this.f52453d.getParent();
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), 0);
                if (onClickListener2 != null) {
                    this.f52453d.setOnClickListener(onClickListener2);
                }
            } else {
                this.f52453d.setVisibility(8);
            }
            ItemViewType itemViewType = payTypeItemViewData.type;
            if (itemViewType == ItemViewType.ADD_NEWCARD) {
                this.f52454e.setImageDrawable(ResUtils.getDrawable(this.mContext, "dxm_wallet_base_paytype_item_right_arrow"));
                this.f52454e.setVisibility(0);
                this.a.setImageDrawable(ResUtils.getDrawable(this.mContext, "wallet_base_paytype_add_newcard"));
                this.f52452c.setVisibility(8);
            } else if (itemViewType == ItemViewType.BALANCE) {
                this.a.setImageDrawable(ResUtils.getDrawable(this.mContext, "dxm_wallet_base_paytype_balance"));
            } else if (itemViewType == ItemViewType.CREDIT) {
                this.a.setImageDrawable(ResUtils.getDrawable(this.mContext, "dxm_wallet_base_paytype_credit"));
            } else if (itemViewType == ItemViewType.BANKCARD && !TextUtils.isEmpty(payTypeItemViewData.logoUrl)) {
                this.a.setImageUrl(payTypeItemViewData.logoUrl);
            }
            if (payTypeItemViewData.isAvaible) {
                ViewHelper.setAlpha(inflate, 1.0f);
                if (payTypeItemViewData.type == ItemViewType.ADD_NEWCARD) {
                    this.f52454e.setVisibility(0);
                    return;
                } else if (payTypeItemViewData.isChecked) {
                    this.f52454e.setVisibility(0);
                    this.f52454e.setSelected(true);
                    return;
                } else {
                    this.f52454e.setSelected(false);
                    this.f52454e.setVisibility(4);
                    return;
                }
            }
            ViewHelper.setAlphaPartly(inflate, 0.4f, this.f52452c);
            if (payTypeItemViewData.isNeedToColored()) {
                inflate.setEnabled(false);
            } else {
                inflate.setEnabled(true);
            }
            this.f52454e.setVisibility(8);
        }
    }

    public static PayTypeItemView generateItemView(Context context, PayTypeItemViewData payTypeItemViewData, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, payTypeItemViewData, onClickListener, onClickListener2)) == null) {
            if (context == null) {
                return null;
            }
            PayTypeItemView payTypeItemView = new PayTypeItemView(context);
            payTypeItemView.a(payTypeItemViewData, onClickListener, onClickListener2);
            return payTypeItemView;
        }
        return (PayTypeItemView) invokeLLLL.objValue;
    }

    public void setItemState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f52454e.setVisibility(8);
            if (z) {
                this.mProgress.setVisibility(0);
            } else {
                this.mProgress.setVisibility(8);
            }
        }
    }

    private void a(PayTypeItemViewData payTypeItemViewData, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, payTypeItemViewData, onClickListener) == null) || payTypeItemViewData == null || TextUtils.isEmpty(payTypeItemViewData.tips) || !payTypeItemViewData.isNeedToColored()) {
            return;
        }
        int startIndex = payTypeItemViewData.getStartIndex(payTypeItemViewData.tips);
        int endIndex = payTypeItemViewData.getEndIndex(payTypeItemViewData.tips);
        SpannableString spannableString = new SpannableString(payTypeItemViewData.removeSeparator(payTypeItemViewData.tips));
        int i2 = endIndex - 1;
        spannableString.setSpan(new ClickableSpan(this, onClickListener) { // from class: com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PayTypeItemView f52455b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, onClickListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52455b = this;
                this.a = onClickListener;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.a.onClick(view);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }
        }, startIndex, i2, 18);
        spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.mContext, "dxm_wallet_base_mainColor")), startIndex, i2, 18);
        if (!TextUtils.isEmpty(payTypeItemViewData.jump_url)) {
            this.f52452c.setClickable(true);
            this.f52452c.setEnabled(true);
        } else {
            this.f52452c.setClickable(false);
            this.f52452c.setEnabled(false);
        }
        this.f52452c.setMovementMethod(new LinkNoScrollMovementMethod());
        this.f52452c.setText(spannableString);
    }
}
