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
/* loaded from: classes26.dex */
public class AdCloseView extends FrameLayout {
    private long aXU;
    protected View.OnClickListener fOX;
    protected int fPd;
    protected PopupWindow fPg;
    private PopupWindow.OnDismissListener fPp;
    private int gQL;
    protected RelativeLayout hVD;
    protected TextView iXi;
    private View mContentView;
    protected Context mContext;
    protected PopupWindow mPopupWindow;
    private String mTitle;
    protected TextView mTitleTextView;
    protected int mWindowHeight;
    protected int mWindowWidth;
    protected int mXOffset;
    protected int mYOffset;
    protected LinearLayout mzf;
    protected TextView mzg;
    protected ImageView mzh;
    public ImageView mzi;
    public int mzj;
    private List<CheckBox> mzk;
    private AdvertAppInfo mzl;
    private ActionControl mzm;
    private List<String> mzn;
    private String mzo;
    private boolean mzp;
    private View.OnClickListener mzq;
    private View.OnClickListener mzr;
    private final CustomMessageListener mzs;
    private View.OnClickListener mzt;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.mPopupWindow = null;
        this.fPg = null;
        this.mzj = R.drawable.ic_icon_pure_card_delete_svg;
        this.mzk = null;
        this.mzl = null;
        this.mzn = new ArrayList();
        this.aXU = 0L;
        this.mzp = false;
        this.fOX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aXU > 500) {
                    AdCloseView.this.cNm();
                    AdCloseView.this.aXU = currentTimeMillis;
                }
            }
        };
        this.mzq = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dBB = AdCloseView.this.dBB();
                if (dBB > 0) {
                    AdCloseView.this.iXi.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dBB));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.iXi.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mzr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mzl != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mzl.eyO));
                    AdCloseView.this.bIw();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.gQL) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mzl.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.fPp = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.fPg != null) {
                    AdCloseView.this.fPg.dismiss();
                    AdCloseView.this.fPg = null;
                }
            }
        };
        this.mzs = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bIw();
            }
        };
        this.mzt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dBz();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPopupWindow = null;
        this.fPg = null;
        this.mzj = R.drawable.ic_icon_pure_card_delete_svg;
        this.mzk = null;
        this.mzl = null;
        this.mzn = new ArrayList();
        this.aXU = 0L;
        this.mzp = false;
        this.fOX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aXU > 500) {
                    AdCloseView.this.cNm();
                    AdCloseView.this.aXU = currentTimeMillis;
                }
            }
        };
        this.mzq = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dBB = AdCloseView.this.dBB();
                if (dBB > 0) {
                    AdCloseView.this.iXi.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dBB));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.iXi.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mzr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mzl != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mzl.eyO));
                    AdCloseView.this.bIw();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.gQL) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mzl.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.fPp = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.fPg != null) {
                    AdCloseView.this.fPg.dismiss();
                    AdCloseView.this.fPg = null;
                }
            }
        };
        this.mzs = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bIw();
            }
        };
        this.mzt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dBz();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mPopupWindow = null;
        this.fPg = null;
        this.mzj = R.drawable.ic_icon_pure_card_delete_svg;
        this.mzk = null;
        this.mzl = null;
        this.mzn = new ArrayList();
        this.aXU = 0L;
        this.mzp = false;
        this.fOX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.aXU > 500) {
                    AdCloseView.this.cNm();
                    AdCloseView.this.aXU = currentTimeMillis;
                }
            }
        };
        this.mzq = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dBB = AdCloseView.this.dBB();
                if (dBB > 0) {
                    AdCloseView.this.iXi.setText(R.string.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_prefix));
                    int color = ap.getColor(R.color.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(dBB));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(R.string.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.iXi.setText(R.string.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.mzr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.mzl != null && AdCloseView.this.mPopupWindow != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DELETE_AD_FROM_FEED, AdCloseView.this.mzl.eyO));
                    AdCloseView.this.bIw();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003322, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(1003322);
                    switch (AdCloseView.this.gQL) {
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
                    httpMessage.addParam("ext", AdCloseView.this.mzl.extensionInfo);
                    httpMessage.addParam(BdStatsConstant.StatsKey.CRASH_INFO, TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.fPp = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AdCloseView.this.fPg != null) {
                    AdCloseView.this.fPg.dismiss();
                    AdCloseView.this.fPg = null;
                }
            }
        };
        this.mzs = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.bIw();
            }
        };
        this.mzt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.dBz();
            }
        };
        this.mContext = context;
        init();
    }

    protected void init() {
        this.mzi = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds72), getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
        layoutParams.setMargins(0, 0, (int) getContext().getResources().getDimension(R.dimen.tbds8), 0);
        layoutParams.gravity = 21;
        addView(this.mzi, layoutParams);
        this.mXOffset = l.getDimens(this.mContext, R.dimen.ds32);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.getDimens(this.mContext, R.dimen.ds278);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fPd = l.getDimens(this.mContext, R.dimen.ds120);
        setOnClickListener(this.fOX);
        SvgManager.brn().a(this.mzi, this.mzj, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.head_text);
        this.hVD = (RelativeLayout) inflate.findViewById(R.id.top_area);
        View findViewById = inflate.findViewById(R.id.ad_show_reason_wrapper);
        this.mzg = (TextView) inflate.findViewById(R.id.ad_show_reason);
        this.mzh = (ImageView) inflate.findViewById(R.id.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.iXi = (TextView) inflate.findViewById(R.id.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.mzo)) {
            this.iXi.setText(this.mzo);
        }
        this.iXi.setOnClickListener(this.mzr);
        if (dBA()) {
            this.mzg.setText(this.mzm.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.mzt);
        }
        ap.setViewTextColor(this.mTitleTextView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iXi, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.mzg, R.color.cp_cont_j, 1);
        ap.setBackgroundResource(this.iXi, R.drawable.bg_blue_rec_n);
        this.mzh.setImageDrawable(ap.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
        this.mzf = (LinearLayout) inflate.findViewById(R.id.reason_root_container);
        this.mzk = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNm() {
        if (this.mContext != null) {
            bIw();
            View contentView = getContentView();
            dBy();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.fPp);
            if (Build.VERSION.SDK_INT >= 22) {
                this.mPopupWindow.setAttachedInDecor(false);
            }
            if (!this.mzp) {
                MessageManager.getInstance().registerListener(this.mzs);
                this.mzp = true;
            }
            this.fPg = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.fPg.setFocusable(false);
            this.fPg.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fPg.setAttachedInDecor(false);
            }
            this.fPg.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a2 = a(this.mContext, this, this.mWindowHeight, this.mWindowWidth, this.fPd, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a2) {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    if (this.hVD != null && this.hVD.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.hVD.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                    }
                } else {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    if (this.hVD != null && this.hVD.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.hVD.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds84);
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

    private void dBy() {
        if (!a.isEmpty(this.mzn)) {
            int eC = a.eC(this.mzn);
            this.mzf.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(eC / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.mzf.addView(linearLayout);
                int i3 = 0;
                while (true) {
                    if (i3 >= linearLayout.getChildCount()) {
                        break;
                    }
                    int i4 = i + 1;
                    if (i4 > eC) {
                        i = i4;
                        break;
                    }
                    CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3);
                    checkBox.setOnClickListener(this.mzq);
                    checkBox.setVisibility(0);
                    a.a(this.mzk, checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < a.eC(this.mzn); i5++) {
                String str = (String) a.l(this.mzn, i5);
                CheckBox checkBox2 = (CheckBox) a.l(this.mzk, i5);
                if (checkBox2 != null) {
                    checkBox2.setText(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIw() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fPg != null) {
            this.fPg.dismiss();
            this.fPg = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mzp) {
            MessageManager.getInstance().unRegisterListener(this.mzs);
            this.mzp = false;
        }
        if (this.fPg != null) {
            if (this.mPopupWindow == null || !this.mPopupWindow.isShowing()) {
                this.fPg.dismiss();
                this.fPg = null;
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
            this.mzl = advertAppInfo;
            a.clear(this.mzn);
            if (this.mzl.eyX != null && this.mzl.eyX.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.mzl.eyX.adCloseInfo;
                this.mzm = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    a.a(this.mzn, str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(R.string.tell_us_reason);
                }
                this.mzo = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBz() {
        if (dBA()) {
            com.baidu.tieba.ad.a.bJk().c(getContext(), new String[]{this.mzm.url});
        }
    }

    private boolean dBA() {
        return (this.mzm == null || TextUtils.isEmpty(this.mzm.url) || TextUtils.isEmpty(this.mzm.name)) ? false : true;
    }

    public void setPage(int i) {
        this.gQL = i;
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
        SvgManager.brn().a(this.mzi, this.mzj, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.mzl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!a.isEmpty(this.mzk)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.eC(this.mzk)) {
                    break;
                }
                CheckBox checkBox = (CheckBox) a.l(this.mzk, i2);
                if (checkBox != null && checkBox.isChecked() && a.eC(this.mzn) > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append((String) a.l(this.mzn, i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dBB() {
        if (a.isEmpty(this.mzk)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < a.eC(this.mzk); i2++) {
            CheckBox checkBox = (CheckBox) a.l(this.mzk, i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
