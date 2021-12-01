package com.baidu.tieba.wallet.pay;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.tieba.wallet.pay.data.PayChannelInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetOrder.DataRes;
/* loaded from: classes11.dex */
public class WalletPayViewController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEF_CHANNEL_TITLE = "NaN";
    public static final int tbds26;
    public static final int tbds29;
    public static final int tbds32;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isPaying;
    public WalletPayActivity mActivity;
    public ClickCallback mCallback;
    public View mChannelLayout;
    public LinearLayout mChannelList;
    public String mChosenChannel;
    public ImageView mCloseBtn;
    public List<PayChannelInfo> mCommonList;
    public FrameLayout mContentLayout;
    public Context mContext;
    public JSONObject mDataJsonObject;
    public DataRes mDataRes;
    public List<PayChannelInfo> mFoldList;
    public TextView mGoodCount;
    public TextView mGoodDesc;
    public View mGoodDivider;
    public TextView mGoodName;
    public TextView mMoneyTv;
    public TBLottieAnimationView mPayAnimView;
    public TextView mPayBtn;
    public LinearLayout mPayBtnLayout;
    public String mPayBtnStr;
    public PayConfig mPayConfig;
    public LinearLayout mRootView;
    public List<View> mShowedItemViewList;
    public TextView mTitle;
    public View mTopSpaceView;
    public TextView mUnfoldTv;

    /* loaded from: classes11.dex */
    public class ChannelItemViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String curChannel;
        public HeadImageView iconImg;
        public boolean mChosen;
        public TextView promptTv;
        public View rootView;
        public ImageView selectorImg;
        public TextView tagTv;
        public final /* synthetic */ WalletPayViewController this$0;
        public TextView titleTv;

        public ChannelItemViewHolder(WalletPayViewController walletPayViewController, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {walletPayViewController, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = walletPayViewController;
            this.rootView = view;
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.channel_icon);
            this.iconImg = headImageView;
            headImageView.setIsRound(true);
            this.iconImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iconImg.setDefaultResource(R.color.CAM_X0110);
            this.iconImg.setAutoChangeStyle(false);
            this.titleTv = (TextView) view.findViewById(R.id.channel_title);
            this.promptTv = (TextView) view.findViewById(R.id.channel_prompt);
            this.tagTv = (TextView) view.findViewById(R.id.channel_tag);
            this.selectorImg = (ImageView) view.findViewById(R.id.channel_selector_img);
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundResource(this.rootView, R.drawable.list_item_selector);
                SkinManager.setViewTextColor(this.titleTv, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.promptTv, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.tagTv, R.color.CAM_X0109);
            }
        }

        public void setData(PayChannelInfo payChannelInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payChannelInfo) == null) {
                this.curChannel = payChannelInfo.channel;
                this.iconImg.startLoad(payChannelInfo.iconUrl, 10, false);
                this.titleTv.setText(payChannelInfo.title);
                if (!StringUtils.isNull(payChannelInfo.prompt)) {
                    this.promptTv.setVisibility(0);
                    this.promptTv.setText(payChannelInfo.prompt);
                } else {
                    this.promptTv.setVisibility(8);
                }
                this.tagTv.setText(payChannelInfo.tag);
                boolean z = payChannelInfo.isDefault;
                this.mChosen = z;
                if (z) {
                    this.this$0.mChosenChannel = this.curChannel;
                }
                updateSelectorIcon(this.mChosen);
                this.rootView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayViewController.ChannelItemViewHolder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChannelItemViewHolder this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$1.mChosen || this.this$1.this$0.isPaying) {
                            return;
                        }
                        ChannelItemViewHolder channelItemViewHolder = this.this$1;
                        channelItemViewHolder.mChosen = !channelItemViewHolder.mChosen;
                        ChannelItemViewHolder channelItemViewHolder2 = this.this$1;
                        channelItemViewHolder2.updateSelectorIcon(channelItemViewHolder2.mChosen);
                        ChannelItemViewHolder channelItemViewHolder3 = this.this$1;
                        channelItemViewHolder3.this$0.mChosenChannel = channelItemViewHolder3.curChannel;
                        this.this$1.this$0.refreshChannelListView();
                    }
                });
            }
        }

        public void updateSelectorIcon(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.mChosen = z;
                SkinManager.setImageResource(this.selectorImg, z ? R.drawable.icon_selection : R.drawable.icon_dissselection);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface ClickCallback {
        void doFinish();

        void doPay(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(191100858, "Lcom/baidu/tieba/wallet/pay/WalletPayViewController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(191100858, "Lcom/baidu/tieba/wallet/pay/WalletPayViewController;");
                return;
            }
        }
        tbds32 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
        tbds26 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);
        tbds29 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds29);
    }

    public WalletPayViewController(WalletPayActivity walletPayActivity, ClickCallback clickCallback, PayConfig payConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {walletPayActivity, clickCallback, payConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mChosenChannel = DEF_CHANNEL_TITLE;
        this.mActivity = walletPayActivity;
        this.mContext = walletPayActivity.getPageContext().getPageActivity();
        this.mCallback = clickCallback;
        this.mPayConfig = payConfig;
        initView();
    }

    private void addChannelItemView(PayChannelInfo payChannelInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, payChannelInfo) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.wallet_channel_item_view, (ViewGroup) null);
            ChannelItemViewHolder channelItemViewHolder = new ChannelItemViewHolder(this, inflate);
            channelItemViewHolder.setData(payChannelInfo);
            inflate.setTag(channelItemViewHolder);
            this.mChannelList.addView(inflate, new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds158)));
            this.mShowedItemViewList.add(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendChannelItemView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || ListUtils.isEmpty(this.mFoldList)) {
            return;
        }
        for (PayChannelInfo payChannelInfo : this.mFoldList) {
            if (payChannelInfo != null) {
                addChannelItemView(payChannelInfo);
            }
        }
    }

    private void handleChannelListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (ListUtils.isEmpty(this.mCommonList) && ListUtils.isEmpty(this.mFoldList)) {
                return;
            }
            this.mUnfoldTv.setVisibility(!ListUtils.isEmpty(this.mCommonList) && !ListUtils.isEmpty(this.mFoldList) ? 0 : 8);
            ArrayList<PayChannelInfo> arrayList = null;
            if (!ListUtils.isEmpty(this.mCommonList)) {
                arrayList = new ArrayList(this.mCommonList);
            } else if (!ListUtils.isEmpty(this.mFoldList)) {
                arrayList = new ArrayList(this.mFoldList);
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            this.mShowedItemViewList = new ArrayList();
            for (PayChannelInfo payChannelInfo : arrayList) {
                if (payChannelInfo != null) {
                    addChannelItemView(payChannelInfo);
                }
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.wallet_pay_layout, (ViewGroup) null);
            this.mRootView = linearLayout;
            this.mActivity.setContentView(linearLayout);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.pay_channel_title);
            this.mChannelLayout = this.mRootView.findViewById(R.id.pay_channel_layout);
            View findViewById = this.mRootView.findViewById(R.id.pay_channel_top_space_view);
            this.mTopSpaceView = findViewById;
            findViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayViewController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayViewController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.mCallback == null) {
                        return;
                    }
                    this.this$0.mCallback.doFinish();
                }
            });
            this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.pay_channel_content_layout);
            ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.pay_channel_close_btn);
            this.mCloseBtn = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayViewController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayViewController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.mCallback == null) {
                        return;
                    }
                    this.this$0.mCallback.doFinish();
                }
            });
            this.mMoneyTv = (TextView) this.mRootView.findViewById(R.id.pay_channel_total_money);
            this.mGoodDesc = (TextView) this.mRootView.findViewById(R.id.pay_channel_good_desc);
            this.mGoodCount = (TextView) this.mRootView.findViewById(R.id.pay_channel_good_count);
            this.mGoodDivider = this.mRootView.findViewById(R.id.pay_channel_good_divider);
            this.mGoodDesc.setVisibility(8);
            this.mGoodCount.setVisibility(8);
            this.mGoodDivider.setVisibility(8);
            this.mGoodName = (TextView) this.mRootView.findViewById(R.id.pay_channel_good_name);
            this.mChannelList = (LinearLayout) this.mRootView.findViewById(R.id.pay_channel_list_layout);
            this.mUnfoldTv = (TextView) this.mRootView.findViewById(R.id.pay_channel_unfold_tv);
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_common_arrow20_down);
            int i2 = tbds32;
            drawable.setBounds(0, 0, i2, i2);
            this.mUnfoldTv.setCompoundDrawables(null, null, drawable, null);
            this.mUnfoldTv.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayViewController.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayViewController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.isPaying) {
                        return;
                    }
                    this.this$0.appendChannelItemView();
                    this.this$0.mUnfoldTv.setVisibility(8);
                }
            });
            this.mPayBtnLayout = (LinearLayout) this.mRootView.findViewById(R.id.pay_channel_pay_btn_layout);
            this.mPayBtn = (TextView) this.mRootView.findViewById(R.id.pay_channel_pay_btn_tv);
            this.mPayBtnLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.wallet.pay.WalletPayViewController.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletPayViewController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!j.z()) {
                            this.this$0.mActivity.showToast(R.string.tb_shake_no_network);
                        } else if (StringUtils.isNull(this.this$0.mChosenChannel) || WalletPayViewController.DEF_CHANNEL_TITLE.equals(this.this$0.mChosenChannel)) {
                            this.this$0.mActivity.showToast(R.string.pay_choose_one_channel_tip);
                        } else if (this.this$0.isPaying) {
                        } else {
                            this.this$0.mPayAnimView.setVisibility(0);
                            this.this$0.mPayAnimView.playAnimation();
                            WalletPayViewController walletPayViewController = this.this$0;
                            walletPayViewController.updatePayBtnText(walletPayViewController.mContext.getString(R.string.pay_loading));
                            if (this.this$0.mCallback != null) {
                                this.this$0.mCallback.doPay(this.this$0.mChosenChannel);
                                this.this$0.isPaying = true;
                            }
                        }
                    }
                }
            });
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.mRootView.findViewById(R.id.pay_channel_pay_anim_view);
            this.mPayAnimView = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation("wallet_pay_anim.json");
            this.mPayAnimView.loop(true);
            onChangeSkinType();
        }
    }

    private void parserJson() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            JSONArray optJSONArray = this.mDataJsonObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                this.mCommonList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        PayChannelInfo payChannelInfo = new PayChannelInfo();
                        payChannelInfo.parserJson(optJSONObject);
                        this.mCommonList.add(payChannelInfo);
                    }
                }
            }
            JSONArray optJSONArray2 = this.mDataJsonObject.optJSONArray("fold");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return;
            }
            int length2 = optJSONArray2.length();
            this.mFoldList = new ArrayList(length2);
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    PayChannelInfo payChannelInfo2 = new PayChannelInfo();
                    payChannelInfo2.parserJson(optJSONObject2);
                    this.mFoldList.add(payChannelInfo2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshChannelListView() {
        ChannelItemViewHolder channelItemViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || ListUtils.isEmpty(this.mShowedItemViewList)) {
            return;
        }
        for (View view : this.mShowedItemViewList) {
            if (view != null && (channelItemViewHolder = (ChannelItemViewHolder) view.getTag()) != null && !StringUtils.isNull(channelItemViewHolder.curChannel)) {
                channelItemViewHolder.updateSelectorIcon(channelItemViewHolder.curChannel.equals(this.mChosenChannel));
            }
        }
    }

    private void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            String format = String.format("%.2f", Double.valueOf(this.mDataRes.payAmount.longValue() / 100.0d));
            this.mMoneyTv.setText(this.mContext.getString(R.string.pay_money, format));
            boolean z = this.mPayConfig.getPayType() == 2;
            if (z) {
                this.mGoodDesc.setVisibility(0);
                this.mGoodCount.setVisibility(0);
                this.mGoodDivider.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                normalSkinMoneyIcon.setBounds(0, 0, tbds29, tbds26);
                this.mGoodCount.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                TextView textView = this.mGoodCount;
                textView.setText(this.mPayConfig.getTBeanNum() + "");
            }
            String str = this.mDataRes.title;
            if (z && !StringUtils.isNull(str)) {
                int i2 = -1;
                if (str.contains("（")) {
                    i2 = str.indexOf("（");
                } else if (str.contains("(")) {
                    i2 = str.indexOf("(");
                }
                if (i2 > 0 && i2 <= str.length() - 1) {
                    str = (String) str.subSequence(0, i2);
                }
            }
            this.mGoodName.setText(str);
            handleChannelListView();
            String format2 = String.format(this.mContext.getResources().getString(R.string.pay_total_pay_confirm_tip), format);
            this.mPayBtnStr = format2;
            updatePayBtnText(format2);
        }
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            List<PayChannelInfo> list = this.mCommonList;
            if (list != null) {
                list.clear();
            }
            List<PayChannelInfo> list2 = this.mFoldList;
            if (list2 != null) {
                list2.clear();
            }
            LinearLayout linearLayout = this.mChannelList;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            List<View> list3 = this.mShowedItemViewList;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePayBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, str) == null) {
            this.mPayBtn.setText(str);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            release();
            TBLottieAnimationView tBLottieAnimationView = this.mPayAnimView;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }

    public void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mActivity.hideLoadingView(this.mContentLayout);
        }
    }

    public boolean isPaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isPaying : invokeV.booleanValue;
    }

    public boolean isValidData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                this.mDataJsonObject = new JSONObject(str);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setImageResource(this.mCloseBtn, R.drawable.icon_topbar_close_n);
            SkinManager.setBackgroundResource(this.mChannelLayout, R.drawable.wallet_pay_content_bg);
            SkinManager.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mMoneyTv, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mGoodDesc, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.mGoodCount, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.mGoodName, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.mGoodDivider, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.mUnfoldTv, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mPayBtn, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.mPayBtnLayout, R.drawable.wallet_go_pay_btn_bg);
        }
    }

    public void payResult(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            resetPayStatus();
            if (z) {
                updatePayBtnText(this.mContext.getString(R.string.pay_succ));
            }
        }
    }

    public void resetPayStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.isPaying = false;
            this.mPayAnimView.cancelAnimation();
            this.mPayAnimView.setVisibility(8);
            updatePayBtnText(this.mPayBtnStr);
        }
    }

    public void setData(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            release();
            this.mDataRes = dataRes;
            parserJson();
            refreshView();
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mActivity.showLoadingView(this.mContentLayout, false, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds624));
        }
    }

    public void showPayingStatus() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.mActivity.getLoadingView() == null) {
            return;
        }
        this.mActivity.getLoadingView().j().setVisibility(0);
        this.mActivity.getLoadingView().j().setText(R.string.pay_loading);
    }
}
