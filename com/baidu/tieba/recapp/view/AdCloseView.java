package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.d.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes20.dex */
public class AdCloseView extends FrameLayout {
    private long aPS;
    protected View.OnClickListener flB;
    protected int flH;
    protected PopupWindow flK;
    private PopupWindow.OnDismissListener flT;
    private int ghF;
    protected RelativeLayout hhi;
    protected TextView iiO;
    protected LinearLayout lIl;
    protected TextView lIm;
    protected ImageView lIn;
    public ImageView lIo;
    public int lIp;
    private List<CheckBox> lIq;
    private AdvertAppInfo lIr;
    private ActionControl lIs;
    private List<String> lIt;
    private String lIu;
    private boolean lIv;
    private View.OnClickListener lIw;
    private View.OnClickListener lIx;
    private final CustomMessageListener lIy;
    private View.OnClickListener lIz;
    private View mContentView;
    protected Context mContext;
    protected PopupWindow mPopupWindow;
    private String mTitle;
    protected TextView mTitleTextView;
    protected int mWindowHeight;
    protected int mWindowWidth;
    protected int mXOffset;
    protected int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.mPopupWindow = null;
        this.flK = null;
        this.lIp = R.drawable.ic_icon_pure_card_delete_svg;
        this.lIq = null;
        this.lIr = null;
        this.lIt = new ArrayList();
        this.aPS = 0L;
        this.lIv = false;
        this.flB = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aPS > 500) {
                    AdCloseView.this.cAn();
                    AdCloseView.this.aPS = currentTimeMillis;
                }
            }
        };
        this.lIw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dou = AdCloseView.this.dou();
                if (dou > 0) {
                    AdCloseView.this.iiO.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dou));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.iiO.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.lIx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.lIr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.lIr.dWf));
                    AdCloseView.this.bAi();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.ghF) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                        case 4:
                            httpMessage.addParam("pi", "1527489263072");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.lIr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.flT = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.flK != null) {
                    AdCloseView.this.flK.dismiss();
                    AdCloseView.this.flK = null;
                }
            }
        };
        this.lIy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bAi();
            }
        };
        this.lIz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dos();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.flK = null;
        this.lIp = R.drawable.ic_icon_pure_card_delete_svg;
        this.lIq = null;
        this.lIr = null;
        this.lIt = new ArrayList();
        this.aPS = 0L;
        this.lIv = false;
        this.flB = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aPS > 500) {
                    AdCloseView.this.cAn();
                    AdCloseView.this.aPS = currentTimeMillis;
                }
            }
        };
        this.lIw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dou = AdCloseView.this.dou();
                if (dou > 0) {
                    AdCloseView.this.iiO.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dou));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.iiO.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.lIx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.lIr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.lIr.dWf));
                    AdCloseView.this.bAi();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.ghF) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                        case 4:
                            httpMessage.addParam("pi", "1527489263072");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.lIr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.flT = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.flK != null) {
                    AdCloseView.this.flK.dismiss();
                    AdCloseView.this.flK = null;
                }
            }
        };
        this.lIy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bAi();
            }
        };
        this.lIz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dos();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.flK = null;
        this.lIp = R.drawable.ic_icon_pure_card_delete_svg;
        this.lIq = null;
        this.lIr = null;
        this.lIt = new ArrayList();
        this.aPS = 0L;
        this.lIv = false;
        this.flB = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aPS > 500) {
                    AdCloseView.this.cAn();
                    AdCloseView.this.aPS = currentTimeMillis;
                }
            }
        };
        this.lIw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dou = AdCloseView.this.dou();
                if (dou > 0) {
                    AdCloseView.this.iiO.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dou));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.iiO.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.lIx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.lIr != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.lIr.dWf));
                    AdCloseView.this.bAi();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.ghF) {
                        case 1:
                            httpMessage.addParam("pi", "0005");
                            break;
                        case 2:
                        case 3:
                            httpMessage.addParam("pi", "1453093728320");
                            break;
                        case 4:
                            httpMessage.addParam("pi", "1527489263072");
                            break;
                    }
                    httpMessage.addParam("cr", selectedResultJsonObj);
                    httpMessage.addParam("ext", AdCloseView.this.lIr.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.flT = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.flK != null) {
                    AdCloseView.this.flK.dismiss();
                    AdCloseView.this.flK = null;
                }
            }
        };
        this.lIy = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bAi();
            }
        };
        this.lIz = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dos();
            }
        };
        this.mContext = context;
        init();
    }

    protected void init() {
        this.lIo = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
        layoutParams.setMargins(0, 0, (int) getContext().getResources().getDimension(R.dimen.tbds8), 0);
        layoutParams.gravity = 21;
        addView(this.lIo, layoutParams);
        this.mXOffset = l.getDimens(this.mContext, R.dimen.ds32);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.getDimens(this.mContext, R.dimen.ds278);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.flH = l.getDimens(this.mContext, R.dimen.ds120);
        setOnClickListener(this.flB);
        SvgManager.bjq().a(this.lIo, this.lIp, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.hhi = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.lIm = (TextView) inflate.findViewById(R.id.ad_show_reason);
        this.lIn = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.iiO = (TextView) inflate.findViewById(R.id.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.lIu)) {
            this.iiO.setText(this.lIu);
        }
        this.iiO.setOnClickListener(this.lIx);
        if (dot()) {
            this.lIm.setText(this.lIs.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.lIz);
        }
        ap.setViewTextColor(this.mTitleTextView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iiO, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.lIm, R.color.cp_cont_j, 1);
        ap.setBackgroundResource(this.iiO, R.drawable.bg_blue_rec_n);
        this.lIn.setImageDrawable(ap.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.lIl = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.lIq = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAn() {
        if (this.mContext != null) {
            bAi();
            View contentView = getContentView();
            dor();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.flT);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.lIv) {
                MessageManager.getInstance().registerListener(this.lIy);
                this.lIv = true;
            }
            this.flK = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.flK.setFocusable(false);
            this.flK.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.flK.setAttachedInDecor(false);
            }
            this.flK.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.mWindowWidth, this.flH, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    if (this.hhi != null && this.hhi.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.hhi.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                    }
                } else {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    if (this.hhi != null && this.hhi.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.hhi.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds84);
                    }
                }
                this.mPopupWindow.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        try {
            this.mContentView.measure(0, 0);
            return this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void dor() {
        if (!a.isEmpty(this.lIt)) {
            int ea = a.ea(this.lIt);
            this.lIl.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(ea / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.lIl.addView(linearLayout);
                int i3 = 0;
                while (true) {
                    if (i3 >= linearLayout.getChildCount()) {
                        break;
                    }
                    int i4 = i + 1;
                    if (i4 > ea) {
                        i = i4;
                        break;
                    }
                    CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3);
                    checkBox.setOnClickListener(this.lIw);
                    checkBox.setVisibility(0);
                    a.a(this.lIq, checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < a.ea(this.lIt); i5++) {
                String str = (String) a.l(this.lIt, i5);
                CheckBox checkBox2 = (CheckBox) a.l(this.lIq, i5);
                if (checkBox2 != null) {
                    checkBox2.setText(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAi() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.flK != null) {
            this.flK.dismiss();
            this.flK = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.lIv) {
            MessageManager.getInstance().unRegisterListener(this.lIy);
            this.lIv = false;
        }
        if (this.flK != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.flK.dismiss();
                this.flK = null;
            }
        }
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int equipmentHeight = l.getEquipmentHeight(context);
        int equipmentWidth = l.getEquipmentWidth(context);
        boolean z = ((equipmentHeight - iArr2[1]) - height) - i3 < i;
        iArr[0] = equipmentWidth - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            this.lIr = advertAppInfo;
            a.clear(this.lIt);
            if (this.lIr.dWo != null && this.lIr.dWo.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.lIr.dWo.adCloseInfo;
                this.lIs = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    a.a(this.lIt, str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.lIu = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dos() {
        if (dot()) {
            com.baidu.tieba.ad.a.bAT().c(getContext(), new String[]{this.lIs.url});
        }
    }

    private boolean dot() {
        return (this.lIs == null || TextUtils.isEmpty(this.lIs.url) || TextUtils.isEmpty(this.lIs.name)) ? false : true;
    }

    public void setPage(int i) {
        this.ghF = i;
    }

    public int getCloseViewWidth() {
        return l.getDimens(this.mContext, R.dimen.tbds72);
    }

    public int getCloseViewHeight() {
        return l.getDimens(this.mContext, R.dimen.tbds72);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        SvgManager.bjq().a(this.lIo, this.lIp, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.lIr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!a.isEmpty(this.lIq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.ea(this.lIq)) {
                    break;
                }
                CheckBox checkBox = (CheckBox) a.l(this.lIq, i2);
                if (checkBox != null && checkBox.isChecked() && a.ea(this.lIt) > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append((String) a.l(this.lIt, i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dou() {
        if (a.isEmpty(this.lIq)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < a.ea(this.lIq); i2++) {
            CheckBox checkBox = (CheckBox) a.l(this.lIq, i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
