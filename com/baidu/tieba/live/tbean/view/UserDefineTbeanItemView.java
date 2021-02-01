package com.baidu.tieba.live.tbean.view;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.b.a;
import com.baidu.tieba.live.tbean.TBeanUtil;
import com.baidu.tieba.live.tbean.TbeanStatisticKey;
import com.baidu.tieba.live.tbean.data.UserDefineTbeanWrapperData;
/* loaded from: classes11.dex */
public class UserDefineTbeanItemView extends a<UserDefineTbeanWrapperData> {
    private EditText mEtUserDefine;
    private boolean mIsFromAlaLiveRoom;
    private boolean mIsShowMemberTbeanExtraInfo;
    private TbImageView mIvIcon;
    private boolean mKeyBoardVisiblity;
    private View.OnClickListener mOnClickListener;
    private OnPayListener mOnPayListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private View mRoot;
    private TbPageContext mTbPageContext;
    private TextWatcher mTextWatcher;
    private TextView mTvIconInfo;
    private TextView mTvLable;
    private TextView mTvMember;
    private TextView mTvMemberLead;
    private LinearLayout mTvMemberWrapper;
    private TextView mTvNum;
    private UserDefineConfirmBottomView mUserDefineConfirmBottomView;
    private UserDefineTbeanWrapperData mWrapperData;

    /* loaded from: classes11.dex */
    public interface OnPayListener {
        void onPayBySdk(String str, int i, int i2, int i3, String str2, int i4, String str3);
    }

    public UserDefineTbeanItemView(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mKeyBoardVisiblity = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.live.tbean.view.UserDefineTbeanItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (view.getId() == a.f.user_define_confirm_tv && (i = JavaTypesHelper.toInt(UserDefineTbeanItemView.this.mEtUserDefine.getText().toString(), 0)) > 0 && UserDefineTbeanItemView.this.mOnPayListener != null && UserDefineTbeanItemView.this.mWrapperData != null && UserDefineTbeanItemView.this.mWrapperData.userInfo != null && UserDefineTbeanItemView.this.mWrapperData.mData != null) {
                    UserDefineTbeanItemView.this.mOnPayListener.onPayBySdk(UserDefineTbeanItemView.this.mWrapperData.mData.icon_id, i, i, TBeanUtil.getTBeanNum(UserDefineTbeanItemView.this.mWrapperData.userInfo, i * 1000, UserDefineTbeanItemView.this.mWrapperData.mSetting) * 1, UserDefineTbeanItemView.this.mWrapperData.mData.pic_url, UserDefineTbeanItemView.this.mWrapperData.mData.duration, UserDefineTbeanItemView.this.mWrapperData.mData.name);
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.live.tbean.view.UserDefineTbeanItemView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                long j = JavaTypesHelper.toLong(UserDefineTbeanItemView.this.mEtUserDefine.getText().toString(), 0L);
                if (editable.toString().startsWith("0")) {
                    UserDefineTbeanItemView.this.mEtUserDefine.setText("");
                }
                if (j > 200000) {
                    if (UserDefineTbeanItemView.this.mUserDefineConfirmBottomView != null) {
                        UserDefineTbeanItemView.this.mUserDefineConfirmBottomView.setPayEnabled(false);
                        return;
                    }
                    return;
                }
                if (UserDefineTbeanItemView.this.mUserDefineConfirmBottomView != null) {
                    UserDefineTbeanItemView.this.mUserDefineConfirmBottomView.setPayEnabled(true);
                }
                if (j <= 0) {
                    UserDefineTbeanItemView.this.mTvNum.setText(a.h.sdk_tbn_user_define_init_value);
                    if (UserDefineTbeanItemView.this.mIsShowMemberTbeanExtraInfo) {
                        UserDefineTbeanItemView.this.mTvMember.setVisibility(8);
                        UserDefineTbeanItemView.this.mTvMemberLead.setText(String.format(UserDefineTbeanItemView.this.mTbPageContext.getString(a.h.sdk_tbn_user_define_member_tbean_extra), Integer.valueOf(UserDefineTbeanItemView.this.mWrapperData.mSetting.vip_extra_percent)));
                        return;
                    }
                    return;
                }
                if (UserDefineTbeanItemView.this.mWrapperData != null && UserDefineTbeanItemView.this.mWrapperData.mSetting != null && UserDefineTbeanItemView.this.mIsShowMemberTbeanExtraInfo) {
                    UserDefineTbeanItemView.this.mTvMember.setVisibility(0);
                    UserDefineTbeanItemView.this.mTvMemberLead.setText(UserDefineTbeanItemView.this.mTbPageContext.getString(a.h.sdk_tbn_super_mem_tbean_tip));
                    UserDefineTbeanItemView.this.mTvMember.setText(TBeanUtil.formatTBeanNum(((j * 1000) * UserDefineTbeanItemView.this.mWrapperData.mSetting.vip_extra_percent) / 100));
                }
                UserDefineTbeanItemView.this.mTvNum.setText(StringHelper.formatTosepara(j * 1000));
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.live.tbean.view.UserDefineTbeanItemView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && UserDefineTbeanItemView.this.mKeyBoardVisiblity) {
                    UserDefineTbeanItemView.this.mEtUserDefine.requestFocus();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        };
        this.mRoot = getView();
        this.mTbPageContext = tbPageContext;
        this.mIsFromAlaLiveRoom = z;
        getView().setOnClickListener(this);
        this.mEtUserDefine = (EditText) getView().findViewById(a.f.user_define_tbean_et);
        this.mTvNum = (TextView) getView().findViewById(a.f.tbean_num_tv);
        this.mTvMemberWrapper = (LinearLayout) getView().findViewById(a.f.tbean_member_wrapper);
        this.mTvMemberLead = (TextView) this.mRoot.findViewById(a.f.tbean_member_tv_lead);
        this.mTvMember = (TextView) getView().findViewById(a.f.tbean_member_tv);
        this.mTvMember.setVisibility(8);
        this.mIvIcon = (TbImageView) getView().findViewById(a.f.icon_iv);
        this.mTvIconInfo = (TextView) getView().findViewById(a.f.icon_info_tv);
        this.mTvLable = (TextView) getView().findViewById(a.f.tbean_label_tv);
        this.mTvLable.setVisibility(8);
        this.mTvNum.setText(a.h.sdk_tbn_user_define_init_value);
        this.mEtUserDefine.setFocusable(true);
        this.mEtUserDefine.addTextChangedListener(this.mTextWatcher);
        this.mUserDefineConfirmBottomView = new UserDefineConfirmBottomView(tbPageContext.getPageActivity());
        this.mUserDefineConfirmBottomView.setClickListener(this.mOnClickListener);
        if (this.mIsFromAlaLiveRoom) {
            this.mRoot.setBackgroundColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_bg_ala));
            this.mTvNum.setTextColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_tbean_num_ala));
            this.mTvMember.setTextColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_tbean_member_extra_ala));
            this.mTvMemberLead.setTextColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_tbean_member_extra_ala));
            this.mTvIconInfo.setTextColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_tbean_icon_info_text_ala));
            this.mTvIconInfo.setBackgroundColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_tbean_icon_info_bg_ala));
            this.mEtUserDefine.setTextColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_tbean_price_ala));
            this.mEtUserDefine.setHintTextColor(this.mTbPageContext.getPageActivity().getColor(a.c.sdk_tbn_item_tbean_user_define_hint_ala));
        }
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.sdk_tbn_buy_tbean_user_define_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    public void onBindDataToView(UserDefineTbeanWrapperData userDefineTbeanWrapperData) {
        if (userDefineTbeanWrapperData != null && userDefineTbeanWrapperData.mData != null) {
            this.mWrapperData = userDefineTbeanWrapperData;
            if (userDefineTbeanWrapperData.mSetting != null) {
                if (userDefineTbeanWrapperData.mSetting.vip_extra_switch == 1 && userDefineTbeanWrapperData.mSetting.vip_extra_percent > 0) {
                    this.mIsShowMemberTbeanExtraInfo = true;
                    this.mTvMemberWrapper.setVisibility(0);
                    this.mTvMemberLead.setText(String.format(this.mTbPageContext.getString(a.h.sdk_tbn_user_define_member_tbean_extra), Integer.valueOf(this.mWrapperData.mSetting.vip_extra_percent)));
                } else {
                    this.mIsShowMemberTbeanExtraInfo = false;
                    this.mTvMemberWrapper.setVisibility(8);
                }
            } else {
                this.mIsShowMemberTbeanExtraInfo = false;
                this.mTvMemberWrapper.setVisibility(8);
            }
            this.mIvIcon.startLoad(userDefineTbeanWrapperData.mData.pic_url, 10, false);
            this.mTvIconInfo.setText(this.mTbPageContext.getPageActivity().getString(a.h.sdk_tbn_icon_name_valid_day, new Object[]{userDefineTbeanWrapperData.mData.name, Integer.valueOf(userDefineTbeanWrapperData.mData.duration)}));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mKeyBoardVisiblity = z;
        if (z) {
            if (this.mUserDefineConfirmBottomView != null) {
                Rect rect = new Rect();
                this.mUserDefineConfirmBottomView.getWindowVisibleDisplayFrame(rect);
                int dimensionPixelSize = (rect.bottom - (this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds88) * 2)) - UtilHelper.getStatusBarHeight();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUserDefineConfirmBottomView.getLayoutParams();
                layoutParams.topMargin = dimensionPixelSize;
                this.mUserDefineConfirmBottomView.setLayoutParams(layoutParams);
                this.mUserDefineConfirmBottomView.setVisibility(0);
                TiebaInitialize.log(TbeanStatisticKey.BUY_TBEAN_USER_DEFINE);
            }
            this.mEtUserDefine.requestFocus();
        } else if (this.mUserDefineConfirmBottomView != null) {
            this.mUserDefineConfirmBottomView.setVisibility(8);
        }
    }

    public void attachConfirmViewToRoot(RelativeLayout relativeLayout) {
        if (relativeLayout != null && this.mUserDefineConfirmBottomView.getParent() != relativeLayout) {
            if (this.mUserDefineConfirmBottomView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mUserDefineConfirmBottomView.getParent()).removeView(this.mUserDefineConfirmBottomView);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = BdUtilHelper.getScreenDimensions(this.mTbPageContext.getPageActivity())[1];
            relativeLayout.addView(this.mUserDefineConfirmBottomView, layoutParams);
        }
    }

    public void hideSoftKeyPad() {
        this.mEtUserDefine.clearFocus();
        BdUtilHelper.hideSoftKeyPad(this.mTbPageContext.getPageActivity(), this.mEtUserDefine);
    }

    public void setOnPayListener(OnPayListener onPayListener) {
        this.mOnPayListener = onPayListener;
    }

    public AbsListView.OnScrollListener getOnScrollListener() {
        return this.mOnScrollListener;
    }
}
