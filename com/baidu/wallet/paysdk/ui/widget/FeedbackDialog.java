package com.baidu.wallet.paysdk.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.FeedbackInfo;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.widget.GridLayout;
import com.dxmpay.wallet.base.widget.SimpleRatingBar;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class FeedbackDialog extends Dialog implements View.OnClickListener, SimpleRatingBar.OnSimpleRatingBarChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ICON_HEIGHT_DP = 12;
    public static final int ICON_PADDING_DP = 6;
    public static final int ICON_WIDTH_DP = 12;
    public static final int TAG_GROUP_GAP = 2;
    public static final float TAG_HEIGHT_DP = 34.0f;
    public static final int TAG_HOR_SPAC_DP = 9;
    public static final int TAG_MAX_COUNT = 6;
    public static final int TAG_VER_SPAC_DP = 10;
    public static final float TAG_WIDTH_DP = 130.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public String isEntryClicked;
    public ImageView mCloseButton;
    public FeedbackInfo mFeedbackInfo;
    public int mLastRating;
    public TextView mLink;
    public b mListener;
    public LinearLayout mPanel;
    public SimpleRatingBar mRatingBar;
    public TextView mRatingText;
    public Button mSubmit;
    public GridLayout mTagGroup;
    public ArrayList<TagButton> mTags;
    public TextView mTitle;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FeedbackInfo a;

        /* renamed from: b  reason: collision with root package name */
        public b f51064b;

        public a() {
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
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void a(c cVar);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f51065b;

        public c() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
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
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isEntryClicked = "0";
        this.mTags = new ArrayList<>();
        this.mLastRating = -1;
        initView();
    }

    public void fillTagGroup(FeedbackInfo.FeedbackTag[] feedbackTagArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, feedbackTagArr) == null) {
            int length = feedbackTagArr.length <= 6 ? feedbackTagArr.length : 6;
            this.mTagGroup.removeAllViews();
            this.mTags.clear();
            if (length <= 0) {
                this.mTagGroup.setVisibility(8);
                return;
            }
            this.mTagGroup.setVisibility(0);
            for (int i2 = 0; i2 < length; i2++) {
                TagButton tagButton = new TagButton(getContext());
                tagButton.setData(feedbackTagArr[i2].desc, feedbackTagArr[i2].key);
                this.mTagGroup.addView(tagButton, new ViewGroup.LayoutParams(DisplayUtils.dip2px(getContext(), 130.0f), DisplayUtils.dip2px(getContext(), 34.0f)));
                this.mTags.add(tagButton);
            }
        }
    }

    public void initDialog(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.mFeedbackInfo = aVar.a;
            this.mListener = aVar.f51064b;
            this.mCloseButton.setOnClickListener(this);
            this.mSubmit.setOnClickListener(this);
            FeedbackInfo feedbackInfo = this.mFeedbackInfo;
            if (feedbackInfo == null) {
                return;
            }
            this.mTitle.setText(feedbackInfo.question_desc);
            if (this.mFeedbackInfo.isEntryValid()) {
                this.mLink.setVisibility(0);
                this.mLink.setTextColor(ResUtils.getColor(getContext(), "dxm_ebpay_text_666666"));
                this.mLink.setText(this.mFeedbackInfo.entry_desc);
                Drawable drawable = ResUtils.getDrawable(getContext(), "wallet_cashdesk_go_icon");
                drawable.setBounds(0, 0, DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 12.0f));
                this.mLink.setCompoundDrawablePadding(DisplayUtils.dip2px(getContext(), 6.0f));
                this.mLink.setCompoundDrawables(null, null, drawable, null);
                this.mLink.setOnClickListener(this);
            }
            this.mTagGroup.setHorizontalSpacing(DisplayUtils.dip2px(getContext(), 9.0f));
            this.mTagGroup.setVerticalSpacing(DisplayUtils.dip2px(getContext(), 10.0f));
            this.mTagGroup.setColumnCount(2);
            this.mRatingBar.setOnChangeListener(this);
            this.mRatingBar.setRating(0);
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            requestWindowFeature(1);
            setContentView(ResUtils.layout(getContext(), "wallet_cashdesk_feedback_dialog"));
            Window window = getWindow();
            window.setWindowAnimations(ResUtils.style(getContext(), "dxm_wallet_base_bottom_dialog_anim"));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = window.getWindowManager().getDefaultDisplay().getHeight();
            attributes.width = -1;
            attributes.height = -2;
            onWindowAttributesChanged(attributes);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            this.mCloseButton = (ImageView) findViewById(ResUtils.id(getContext(), "feedback_close"));
            this.mTitle = (TextView) findViewById(ResUtils.id(getContext(), "feedback_title"));
            this.mRatingBar = (SimpleRatingBar) findViewById(ResUtils.id(getContext(), "feedback_ratingbar"));
            this.mRatingText = (TextView) findViewById(ResUtils.id(getContext(), "feedback_ratingtxt"));
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getContext(), "feedback_panel"));
            this.mPanel = linearLayout;
            linearLayout.setVisibility(8);
            this.mTagGroup = (GridLayout) findViewById(ResUtils.id(getContext(), "feedback_tags"));
            this.mSubmit = (Button) findViewById(ResUtils.id(getContext(), "feedback_submit"));
            this.mLink = (TextView) findViewById(ResUtils.id(getContext(), "feedback_link"));
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onBackPressed();
            StatisticManager.onEventWithValue("payFeedbackCloseClick", this.isEntryClicked);
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view == this.mCloseButton) {
                onBackPressed();
            } else if (view == this.mSubmit) {
                StatisticManager.onEventWithValue("payFeedbackSubmitClick", this.isEntryClicked);
                if (this.mListener != null) {
                    c cVar = new c();
                    cVar.a = this.mRatingBar.getRating();
                    ArrayList arrayList = new ArrayList();
                    Iterator<TagButton> it = this.mTags.iterator();
                    while (it.hasNext()) {
                        TagButton next = it.next();
                        if (next.getCheckState()) {
                            arrayList.add(next.getKey());
                        }
                    }
                    String[] strArr = new String[arrayList.size()];
                    cVar.f51065b = strArr;
                    arrayList.toArray(strArr);
                    this.mListener.a(cVar);
                }
                dismiss();
            } else if (view == this.mLink) {
                StatisticManager.onEvent("payFeedbackEntryClick");
                if (this.mFeedbackInfo != null) {
                    getWindow().setWindowAnimations(ResUtils.style(getContext(), "wallet_base_bottom_dialog_no_anim"));
                    this.isEntryClicked = "1";
                    BaiduWalletDelegate.getInstance().openH5Module(getContext(), this.mFeedbackInfo.entry_uri);
                }
            }
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SimpleRatingBar.OnSimpleRatingBarChangeListener
    public void onRatingChanged(SimpleRatingBar simpleRatingBar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{simpleRatingBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.mFeedbackInfo == null) {
            return;
        }
        if (z && this.mPanel.getVisibility() != 0) {
            this.mPanel.setVisibility(0);
        }
        if (z && i2 < 1) {
            simpleRatingBar.setRating(1);
            return;
        }
        int length = this.mFeedbackInfo.score_desc.length - 1;
        if (i2 <= length) {
            length = i2;
        }
        this.mRatingText.setText(this.mFeedbackInfo.score_desc[length]);
        if (i2 > 0) {
            this.mRatingText.setTextColor(ResUtils.getColor(getContext(), "wallet_base_color_fc985d"));
        }
        int i3 = this.mLastRating;
        if (i3 < 0) {
            fillTagGroup(this.mFeedbackInfo.negative);
        } else if (i3 <= 2 && i2 > 2) {
            fillTagGroup(this.mFeedbackInfo.positive);
        } else if (this.mLastRating > 2 && i2 <= 2) {
            fillTagGroup(this.mFeedbackInfo.negative);
        }
        this.mLastRating = i2;
    }

    /* loaded from: classes6.dex */
    public static class TagButton extends Button implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mChecked;
        public String mKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TagButton(Context context) {
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
            this.mChecked = false;
            initView();
        }

        public boolean getCheckState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mChecked : invokeV.booleanValue;
        }

        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mKey : (String) invokeV.objValue;
        }

        public void initView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                setTextSize(1, 13.0f);
                setGravity(17);
                setChecked(false);
                setOnClickListener(this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
                setChecked(!this.mChecked);
            }
        }

        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.mChecked = z;
                setBackgroundDrawable(ResUtils.getDrawable(getContext(), this.mChecked ? "wallet_cashdesk_feedbacktag_checked_shape" : "wallet_cashdesk_feedbacktag_uncheck_shape"));
                setTextColor(ResUtils.getColor(getContext(), this.mChecked ? "dxm_wallet_base_mainColor" : "dxm_ebpay_text_666666"));
            }
        }

        public void setData(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
                setText(str);
                this.mKey = str2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TagButton(Context context, AttributeSet attributeSet) {
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
            this.mChecked = false;
            initView();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isEntryClicked = "0";
        this.mTags = new ArrayList<>();
        this.mLastRating = -1;
        initView();
    }
}
