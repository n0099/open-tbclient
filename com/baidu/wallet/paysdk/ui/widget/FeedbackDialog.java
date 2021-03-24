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
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.base.widget.SimpleRatingBar;
import com.baidu.wallet.paysdk.datamodel.FeedbackInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class FeedbackDialog extends Dialog implements View.OnClickListener, SimpleRatingBar.OnSimpleRatingBarChangeListener {
    public static final int ICON_HEIGHT_DP = 12;
    public static final int ICON_PADDING_DP = 6;
    public static final int ICON_WIDTH_DP = 12;
    public static final int TAG_GROUP_GAP = 2;
    public static final float TAG_HEIGHT_DP = 34.0f;
    public static final int TAG_HOR_SPAC_DP = 9;
    public static final int TAG_MAX_COUNT = 6;
    public static final int TAG_VER_SPAC_DP = 10;
    public static final float TAG_WIDTH_DP = 130.0f;
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

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public FeedbackInfo f26386a;

        /* renamed from: b  reason: collision with root package name */
        public b f26387b;
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void a(c cVar);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f26388a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f26389b;
    }

    public FeedbackDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.isEntryClicked = "0";
        this.mTags = new ArrayList<>();
        this.mLastRating = -1;
        initView();
    }

    public void fillTagGroup(FeedbackInfo.FeedbackTag[] feedbackTagArr) {
        int length = feedbackTagArr.length <= 6 ? feedbackTagArr.length : 6;
        this.mTagGroup.removeAllViews();
        this.mTags.clear();
        if (length <= 0) {
            this.mTagGroup.setVisibility(8);
            return;
        }
        this.mTagGroup.setVisibility(0);
        for (int i = 0; i < length; i++) {
            TagButton tagButton = new TagButton(getContext());
            tagButton.setData(feedbackTagArr[i].desc, feedbackTagArr[i].key);
            this.mTagGroup.addView(tagButton, new ViewGroup.LayoutParams(DisplayUtils.dip2px(getContext(), 130.0f), DisplayUtils.dip2px(getContext(), 34.0f)));
            this.mTags.add(tagButton);
        }
    }

    public void initDialog(a aVar) {
        this.mFeedbackInfo = aVar.f26386a;
        this.mListener = aVar.f26387b;
        this.mCloseButton.setOnClickListener(this);
        this.mSubmit.setOnClickListener(this);
        FeedbackInfo feedbackInfo = this.mFeedbackInfo;
        if (feedbackInfo == null) {
            return;
        }
        this.mTitle.setText(feedbackInfo.question_desc);
        if (this.mFeedbackInfo.isEntryValid()) {
            this.mLink.setVisibility(0);
            this.mLink.setTextColor(ResUtils.getColor(getContext(), "ebpay_text_666666"));
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

    public void initView() {
        requestWindowFeature(1);
        setContentView(ResUtils.layout(getContext(), "wallet_cashdesk_feedback_dialog"));
        Window window = getWindow();
        window.setWindowAnimations(ResUtils.style(getContext(), "wallet_base_bottom_dialog_anim"));
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

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_PAY_FEEDBACK_CLOSE_CLICK, this.isEntryClicked);
        b bVar = this.mListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCloseButton) {
            onBackPressed();
        } else if (view == this.mSubmit) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_PAY_FEEDBACK_SUBMIT_CLICK, this.isEntryClicked);
            if (this.mListener != null) {
                c cVar = new c();
                cVar.f26388a = this.mRatingBar.getRating();
                ArrayList arrayList = new ArrayList();
                Iterator<TagButton> it = this.mTags.iterator();
                while (it.hasNext()) {
                    TagButton next = it.next();
                    if (next.getCheckState()) {
                        arrayList.add(next.getKey());
                    }
                }
                String[] strArr = new String[arrayList.size()];
                cVar.f26389b = strArr;
                arrayList.toArray(strArr);
                this.mListener.a(cVar);
            }
            dismiss();
        } else if (view == this.mLink) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_PAY_FEEDBACK_ENTRY_CLICK);
            if (this.mFeedbackInfo != null) {
                getWindow().setWindowAnimations(ResUtils.style(getContext(), "wallet_base_bottom_dialog_no_anim"));
                this.isEntryClicked = "1";
                BaiduWalletDelegate.getInstance().openH5Module(getContext(), this.mFeedbackInfo.entry_uri);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.SimpleRatingBar.OnSimpleRatingBarChangeListener
    public void onRatingChanged(SimpleRatingBar simpleRatingBar, int i, boolean z) {
        if (this.mFeedbackInfo == null) {
            return;
        }
        if (z && this.mPanel.getVisibility() != 0) {
            this.mPanel.setVisibility(0);
        }
        if (z && i < 1) {
            simpleRatingBar.setRating(1);
            return;
        }
        int length = this.mFeedbackInfo.score_desc.length - 1;
        if (i <= length) {
            length = i;
        }
        this.mRatingText.setText(this.mFeedbackInfo.score_desc[length]);
        if (i > 0) {
            this.mRatingText.setTextColor(ResUtils.getColor(getContext(), "wallet_base_color_fc985d"));
        }
        int i2 = this.mLastRating;
        if (i2 < 0) {
            fillTagGroup(this.mFeedbackInfo.negative);
        } else if (i2 <= 2 && i > 2) {
            fillTagGroup(this.mFeedbackInfo.positive);
        } else if (this.mLastRating > 2 && i <= 2) {
            fillTagGroup(this.mFeedbackInfo.negative);
        }
        this.mLastRating = i;
    }

    /* loaded from: classes5.dex */
    public static class TagButton extends Button implements View.OnClickListener {
        public boolean mChecked;
        public String mKey;

        public TagButton(Context context) {
            super(context);
            this.mChecked = false;
            initView();
        }

        public boolean getCheckState() {
            return this.mChecked;
        }

        public String getKey() {
            return this.mKey;
        }

        public void initView() {
            setTextSize(1, 13.0f);
            setGravity(17);
            setChecked(false);
            setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            setChecked(!this.mChecked);
        }

        public void setChecked(boolean z) {
            this.mChecked = z;
            setBackgroundDrawable(ResUtils.getDrawable(getContext(), this.mChecked ? "wallet_cashdesk_feedbacktag_checked_shape" : "wallet_cashdesk_feedbacktag_uncheck_shape"));
            setTextColor(ResUtils.getColor(getContext(), this.mChecked ? "wallet_base_mainColor" : "ebpay_text_666666"));
        }

        public void setData(String str, String str2) {
            setText(str);
            this.mKey = str2;
        }

        public TagButton(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mChecked = false;
            initView();
        }
    }

    public FeedbackDialog(Context context, int i) {
        super(context, i);
        this.isEntryClicked = "0";
        this.mTags = new ArrayList<>();
        this.mLastRating = -1;
        initView();
    }
}
