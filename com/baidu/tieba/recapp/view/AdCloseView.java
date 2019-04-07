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
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes3.dex */
public class AdCloseView extends FrameLayout {
    private PopupWindow aMM;
    private long cIJ;
    private RotateAnimation cIL;
    private RotateAnimation cIM;
    private View.OnClickListener cIN;
    private int cIR;
    private int cIT;
    private PopupWindow cIW;
    private PopupWindow.OnDismissListener cJd;
    private int dWT;
    private ImageView dtn;
    private RelativeLayout efg;
    private TextView fli;
    private LinearLayout imK;
    private TextView imL;
    private ImageView imM;
    private List<CheckBox> imN;
    private AdvertAppInfo imO;
    private ActionControl imP;
    private List<String> imQ;
    private String imR;
    private boolean imS;
    private View.OnClickListener imT;
    private View.OnClickListener imU;
    private final CustomMessageListener imV;
    private View.OnClickListener imW;
    private View mContentView;
    private Context mContext;
    private String mTitle;
    private TextView mTitleTextView;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;

    public AdCloseView(Context context) {
        super(context);
        this.mContext = null;
        this.aMM = null;
        this.cIW = null;
        this.imN = null;
        this.imO = null;
        this.imQ = new ArrayList();
        this.cIJ = 0L;
        this.imS = false;
        this.cIN = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIJ > 500) {
                    AdCloseView.this.boG();
                    AdCloseView.this.cIJ = currentTimeMillis;
                }
            }
        };
        this.imT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXJ = AdCloseView.this.bXJ();
                if (bXJ > 0) {
                    AdCloseView.this.fli.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0277d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXJ));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fli.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.imU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.imO != null && AdCloseView.this.aMM != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.imO.bwG));
                    AdCloseView.this.auR();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dWT) {
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
                    httpMessage.addParam("ext", AdCloseView.this.imO.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIW != null) {
                    AdCloseView.this.cIW.dismiss();
                    AdCloseView.this.cIW = null;
                }
            }
        };
        this.imV = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auR();
            }
        };
        this.imW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXH();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.aMM = null;
        this.cIW = null;
        this.imN = null;
        this.imO = null;
        this.imQ = new ArrayList();
        this.cIJ = 0L;
        this.imS = false;
        this.cIN = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIJ > 500) {
                    AdCloseView.this.boG();
                    AdCloseView.this.cIJ = currentTimeMillis;
                }
            }
        };
        this.imT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXJ = AdCloseView.this.bXJ();
                if (bXJ > 0) {
                    AdCloseView.this.fli.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0277d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXJ));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fli.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.imU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.imO != null && AdCloseView.this.aMM != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.imO.bwG));
                    AdCloseView.this.auR();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dWT) {
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
                    httpMessage.addParam("ext", AdCloseView.this.imO.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIW != null) {
                    AdCloseView.this.cIW.dismiss();
                    AdCloseView.this.cIW = null;
                }
            }
        };
        this.imV = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auR();
            }
        };
        this.imW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXH();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.aMM = null;
        this.cIW = null;
        this.imN = null;
        this.imO = null;
        this.imQ = new ArrayList();
        this.cIJ = 0L;
        this.imS = false;
        this.cIN = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIJ > 500) {
                    AdCloseView.this.boG();
                    AdCloseView.this.cIJ = currentTimeMillis;
                }
            }
        };
        this.imT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXJ = AdCloseView.this.bXJ();
                if (bXJ > 0) {
                    AdCloseView.this.fli.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0277d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXJ));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.fli.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.imU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.imO != null && AdCloseView.this.aMM != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.imO.bwG));
                    AdCloseView.this.auR();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dWT) {
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
                    httpMessage.addParam("ext", AdCloseView.this.imO.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIW != null) {
                    AdCloseView.this.cIW.dismiss();
                    AdCloseView.this.cIW = null;
                }
            }
        };
        this.imV = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auR();
            }
        };
        this.imW = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXH();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.dtn = new ImageView(getContext());
        this.dtn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(d.e.tbds31), getContext().getResources().getDimensionPixelSize(d.e.tbds31));
        layoutParams.gravity = 21;
        addView(this.dtn, layoutParams);
        this.mXOffset = l.h(this.mContext, d.e.ds32);
        this.mYOffset = l.h(this.mContext, d.e.ds10);
        this.mWindowHeight = l.h(this.mContext, d.e.ds278);
        this.cIR = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cIT = l.h(this.mContext, d.e.ds120);
        setOnClickListener(this.cIN);
        al.c(this.dtn, d.f.icon_home_card_delete);
        auS();
    }

    private void auS() {
        this.cIL = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cIL.setInterpolator(overshootInterpolator);
        this.cIL.setDuration(250L);
        this.cIL.setFillAfter(true);
        this.cIM = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cIM.setInterpolator(overshootInterpolator);
        this.cIM.setDuration(250L);
        this.cIM.setFillAfter(true);
    }

    private void setCWRotateAnimation() {
        if (this.dtn != null) {
            this.dtn.clearAnimation();
            this.dtn.startAnimation(this.cIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setACRotateAnimation() {
        if (this.dtn != null) {
            this.dtn.clearAnimation();
            this.dtn.startAnimation(this.cIM);
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(d.g.head_text);
        this.efg = (RelativeLayout) inflate.findViewById(d.g.top_area);
        View findViewById = inflate.findViewById(d.g.ad_show_reason_wrapper);
        this.imL = (TextView) inflate.findViewById(d.g.ad_show_reason);
        this.imM = (ImageView) inflate.findViewById(d.g.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.fli = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.imR)) {
            this.fli.setText(this.imR);
        }
        this.fli.setOnClickListener(this.imU);
        if (bXI()) {
            this.imL.setText(this.imP.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.imW);
        }
        al.d(this.mTitleTextView, d.C0277d.cp_cont_b, 1);
        al.d(this.fli, d.C0277d.cp_btn_a, 1);
        al.d(this.imL, d.C0277d.cp_other_i, 1);
        al.k(this.fli, d.f.bg_blue_rec_n);
        this.imM.setImageDrawable(al.getDrawable(d.f.icon_ad_dislike_arrow20_right_n));
        this.imK = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.imN = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boG() {
        if (this.mContext != null) {
            auR();
            setCWRotateAnimation();
            View contentView = getContentView();
            bXG();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aMM = new PopupWindow(contentView, this.cIR, this.mWindowHeight);
            this.aMM.setFocusable(true);
            this.aMM.setTouchable(true);
            this.aMM.setOnDismissListener(this.cJd);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aMM.setAttachedInDecor(false);
            }
            if (!this.imS) {
                MessageManager.getInstance().registerListener(this.imV);
                this.imS = true;
            }
            this.cIW = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.cIW.setFocusable(false);
            this.cIW.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIW.setAttachedInDecor(false);
            }
            this.cIW.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.cIR, this.cIT, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aMM.setAnimationStyle(d.k.scale_rb2lt_anim);
                    al.a(this.aMM, d.f.bg_tost_feedback_down);
                    if (this.efg != null && this.efg.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.efg.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                    }
                } else {
                    this.aMM.setAnimationStyle(d.k.scale_rt2lb_anim);
                    al.a(this.aMM, d.f.bg_tost_feedback_up);
                    if (this.efg != null && this.efg.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.efg.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds84);
                    }
                }
                this.aMM.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        try {
            this.mContentView.measure(0, 0);
            return this.mContentView.getMeasuredHeight() + l.h(this.mContext, d.e.ds12);
        } catch (Exception e) {
            return 0;
        }
    }

    private void bXG() {
        if (this.imQ != null && this.imQ.size() > 0) {
            int size = this.imQ.size();
            this.imK.setVisibility(0);
            int i = 0;
            for (int i2 = 0; i2 < Math.ceil(size / 2.0d); i2++) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.ad_close_row_view, (ViewGroup) null);
                linearLayout.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 1;
                if (i2 != 0) {
                    layoutParams.topMargin = l.h(this.mContext, d.e.tbds20);
                }
                linearLayout.setLayoutParams(layoutParams);
                this.imK.addView(linearLayout);
                int i3 = 0;
                while (true) {
                    if (i3 >= linearLayout.getChildCount()) {
                        break;
                    }
                    int i4 = i + 1;
                    if (i4 > size) {
                        i = i4;
                        break;
                    }
                    CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i3);
                    checkBox.setOnClickListener(this.imT);
                    checkBox.setVisibility(0);
                    this.imN.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.imQ.size(); i5++) {
                this.imN.get(i5).setText(this.imQ.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auR() {
        if (this.aMM != null) {
            this.aMM.dismiss();
            this.aMM = null;
        }
        if (this.cIW != null) {
            this.cIW.dismiss();
            this.cIW = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.imS) {
            MessageManager.getInstance().unRegisterListener(this.imV);
            this.imS = false;
        }
        if (this.cIW != null) {
            if (this.aMM == null || !this.aMM.isShowing()) {
                this.cIW.dismiss();
                this.cIW = null;
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
        int aQ = l.aQ(context);
        int aO = l.aO(context);
        boolean z = ((aQ - iArr2[1]) - height) - i3 < i;
        iArr[0] = aO - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    public void setData(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null) {
            this.imO = advertAppInfo;
            this.imQ.clear();
            if (this.imO.bwQ != null && this.imO.bwQ.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.imO.bwQ.adCloseInfo;
                this.imP = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.imQ.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.j.tell_us_reason);
                }
                this.imR = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXH() {
        if (bXI()) {
            a.awB().d(getContext(), new String[]{this.imP.url});
        }
    }

    private boolean bXI() {
        return (this.imP == null || TextUtils.isEmpty(this.imP.url) || TextUtils.isEmpty(this.imP.name)) ? false : true;
    }

    public void setPage(int i) {
        this.dWT = i;
    }

    public int getCloseViewWidth() {
        return l.h(this.mContext, d.e.ds96);
    }

    public int getCloseViewHeight() {
        return l.h(this.mContext, d.e.ds26);
    }

    public View getAdCloseView() {
        return this;
    }

    public void onChangeSkinType() {
        al.c(this.dtn, d.f.icon_home_card_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.imO == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.T(this.imN)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.imN.size()) {
                    break;
                }
                CheckBox checkBox = this.imN.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.imQ != null && this.imQ.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.imQ.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bXJ() {
        if (v.T(this.imN)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.imN.size(); i2++) {
            CheckBox checkBox = this.imN.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
