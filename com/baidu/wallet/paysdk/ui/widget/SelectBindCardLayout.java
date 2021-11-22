package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.base.widget.BorderTipTextView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class SelectBindCardLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BindFastRequest f61409a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61410b;

    /* renamed from: c  reason: collision with root package name */
    public b f61411c;

    /* loaded from: classes10.dex */
    public class BindCardItemView extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectBindCardLayout f61417a;

        /* renamed from: b  reason: collision with root package name */
        public NetImageView f61418b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61419c;

        /* renamed from: d  reason: collision with root package name */
        public BorderTipTextView f61420d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f61421e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BindCardItemView(SelectBindCardLayout selectBindCardLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectBindCardLayout, context};
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
            this.f61417a = selectBindCardLayout;
            View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_select_bindcard_list_item_view"), this);
            this.f61418b = (NetImageView) inflate.findViewById(ResUtils.id(getContext(), "ebpay_paytype_logo"));
            this.f61419c = (TextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_name"));
            this.f61420d = (BorderTipTextView) inflate.findViewById(ResUtils.id(getContext(), "paytype_tip"));
            ProgressBar progressBar = (ProgressBar) findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar"));
            this.f61421e = progressBar;
            progressBar.setVisibility(8);
        }

        public void setData(CardData.BondCard bondCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bondCard) == null) {
                this.f61418b.setImageUrl(bondCard.bank_url);
                findViewById(ResUtils.id(getContext(), "paytype_recommended")).setVisibility(bondCard != null && "1".equals(bondCard.is_recommended) ? 0 : 4);
                this.f61419c.setText(bondCard.getCardDesc(getContext(), true));
                if (this.f61417a.f61409a.mBindFrom != 4 && this.f61417a.f61409a.mBindFrom != 5) {
                    if ("1".equals(bondCard.card_state) && !TextUtils.isEmpty(bondCard.channelDiscountDesc)) {
                        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "paytype_free_amount"));
                        textView.setVisibility(0);
                        textView.setText(bondCard.channelDiscountDesc);
                    }
                    if (!TextUtils.isEmpty(bondCard.bank_card_msg)) {
                        this.f61420d.setVisibility(0);
                        this.f61420d.setText(bondCard.bank_card_msg);
                        this.f61420d.setVisibility(0);
                        return;
                    }
                    this.f61420d.setVisibility(8);
                } else if (!bondCard.getCanFindPWDBySms() && !TextUtils.isEmpty(bondCard.unsupport_find_pwd_msg)) {
                    this.f61420d.setVisibility(0);
                    this.f61420d.setText(bondCard.unsupport_find_pwd_msg);
                } else {
                    this.f61420d.setVisibility(8);
                }
            }
        }

        public void setProgressBarVisible(boolean z) {
            ProgressBar progressBar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (progressBar = this.f61421e) == null) {
                return;
            }
            progressBar.setVisibility(z ? 0 : 8);
        }
    }

    /* loaded from: classes10.dex */
    public class a extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectBindCardLayout f61422a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectBindCardLayout selectBindCardLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectBindCardLayout, context};
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
            this.f61422a = selectBindCardLayout;
            a(context);
        }

        private void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
                LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_cashdesk_select_bindcard_list_item_view"), this);
                ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "paytype_select"));
                imageView.setImageDrawable(ResUtils.getDrawable(context, "dxm_wallet_base_paytype_item_right_arrow"));
                imageView.setVisibility(0);
                ((NetImageView) findViewById(ResUtils.id(getContext(), "ebpay_paytype_logo"))).setImageDrawable(ResUtils.getDrawable(context, "wallet_base_paytype_add_newcard"));
                ((TextView) findViewById(ResUtils.id(getContext(), "paytype_tip"))).setVisibility(8);
                ((TextView) findViewById(ResUtils.id(getContext(), "paytype_name"))).setText(ResUtils.getString(getContext(), "wallet_bindcard_usenewcard_tip"));
                findViewById(ResUtils.id(getContext(), "ebpay_mini_progress_bar")).setVisibility(8);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void addNewCardClick();

        void enableCardClick(BindCardItemView bindCardItemView, CardData.BondCard bondCard);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBindCardLayout(Context context, AttributeSet attributeSet) {
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
    }

    public void setAdaptetr(CardData.BondCard[] bondCardArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, bondCardArr, z) == null) {
            CardData.BondCard[] a2 = a(bondCardArr);
            this.f61410b = false;
            removeAllViews();
            if (a2 == null || a2.length <= 0) {
                return;
            }
            if (this.f61409a.mBindFrom == 2) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_title_left"), (ViewGroup) null);
                textView.setText(ResUtils.getString(getContext(), "wallet_bindcard_selectcard_tip"));
                int dimension = (int) ResUtils.getDimension(getContext(), "dxm_wallet_base_margin");
                textView.setPadding(dimension, (int) ResUtils.getDimension(getContext(), "dxm_wallet_base_margin"), dimension, 0);
                addView(textView);
            }
            ScrollView scrollView = new ScrollView(getContext());
            addView(scrollView);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            scrollView.addView(linearLayout);
            for (int i2 = 0; i2 < a2.length; i2++) {
                CardData.BondCard bondCard = a2[i2];
                if (a(bondCard)) {
                    BindCardItemView bindCardItemView = new BindCardItemView(this, getContext());
                    bindCardItemView.setData(a2[i2]);
                    bindCardItemView.setOnClickListener(new View.OnClickListener(this, bindCardItemView, bondCard) { // from class: com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ BindCardItemView f61412a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ CardData.BondCard f61413b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SelectBindCardLayout f61414c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bindCardItemView, bondCard};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61414c = this;
                            this.f61412a = bindCardItemView;
                            this.f61413b = bondCard;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f61414c.f61411c == null) {
                                return;
                            }
                            this.f61414c.f61411c.enableCardClick(this.f61412a, this.f61413b);
                        }
                    });
                    linearLayout.addView(bindCardItemView);
                } else {
                    a(linearLayout, z);
                    BindCardItemView bindCardItemView2 = new BindCardItemView(this, getContext());
                    bindCardItemView2.setData(a2[i2]);
                    ViewHelper.setAlpha(bindCardItemView2, 0.4f);
                    bindCardItemView2.setEnabled(false);
                    bindCardItemView2.setClickable(false);
                    linearLayout.addView(bindCardItemView2);
                }
            }
            a(linearLayout, z);
        }
    }

    public void setBindCardItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f61411c = bVar;
        }
    }

    public void setBindFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f61409a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BindFastRequest.categoryToId(BindFastRequest.getCategory(i2)));
        }
    }

    private void a(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, this, viewGroup, z) == null) || this.f61410b) {
            return;
        }
        a aVar = new a(this, getContext());
        aVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (!z) {
            ViewHelper.setAlpha(aVar, 0.4f);
        }
        aVar.setOnClickListener(new View.OnClickListener(this, z) { // from class: com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f61415a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SelectBindCardLayout f61416b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61416b = this;
                this.f61415a = z;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (this.f61415a) {
                        if (this.f61416b.f61411c != null) {
                            this.f61416b.f61411c.addNewCardClick();
                            return;
                        }
                        return;
                    }
                    GlobalUtils.toast(this.f61416b.getContext(), ResUtils.getString(this.f61416b.getContext(), "ebpay_bank_count_beyond"));
                }
            }
        });
        viewGroup.addView(aVar);
        this.f61410b = true;
    }

    private CardData.BondCard[] a(CardData.BondCard[] bondCardArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bondCardArr)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (bondCardArr == null || bondCardArr.length <= 0) {
                return null;
            }
            for (CardData.BondCard bondCard : bondCardArr) {
                if (a(bondCard)) {
                    arrayList.add(bondCard);
                } else {
                    arrayList2.add(bondCard);
                }
            }
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            return (CardData.BondCard[]) arrayList3.toArray(new CardData.BondCard[arrayList3.size()]);
        }
        return (CardData.BondCard[]) invokeL.objValue;
    }

    private boolean a(CardData.BondCard bondCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bondCard)) == null) {
            int i2 = this.f61409a.mBindFrom;
            if (i2 != 4 && i2 != 5) {
                if ("1".equals(bondCard.card_state)) {
                    return true;
                }
            } else if (bondCard.getCanFindPWDBySms()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
