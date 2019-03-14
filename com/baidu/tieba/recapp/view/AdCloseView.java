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
    private PopupWindow aMJ;
    private long cIH;
    private RotateAnimation cIJ;
    private RotateAnimation cIK;
    private View.OnClickListener cIL;
    private int cIP;
    private int cIR;
    private PopupWindow cIU;
    private PopupWindow.OnDismissListener cJb;
    private int dXv;
    private ImageView dtj;
    private RelativeLayout efu;
    private TextView flw;
    private LinearLayout imY;
    private TextView imZ;
    private ImageView ina;
    private List<CheckBox> inb;
    private AdvertAppInfo inc;
    private ActionControl ind;
    private List<String> ine;
    private String inf;
    private boolean ing;
    private View.OnClickListener inh;
    private View.OnClickListener ini;
    private final CustomMessageListener inj;
    private View.OnClickListener ink;
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
        this.aMJ = null;
        this.cIU = null;
        this.inb = null;
        this.inc = null;
        this.ine = new ArrayList();
        this.cIH = 0L;
        this.ing = false;
        this.cIL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIH > 500) {
                    AdCloseView.this.boJ();
                    AdCloseView.this.cIH = currentTimeMillis;
                }
            }
        };
        this.inh = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXN = AdCloseView.this.bXN();
                if (bXN > 0) {
                    AdCloseView.this.flw.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0277d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.flw.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.ini = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.inc != null && AdCloseView.this.aMJ != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.inc.bwD));
                    AdCloseView.this.auU();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dXv) {
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
                    httpMessage.addParam("ext", AdCloseView.this.inc.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJb = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIU != null) {
                    AdCloseView.this.cIU.dismiss();
                    AdCloseView.this.cIU = null;
                }
            }
        };
        this.inj = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auU();
            }
        };
        this.ink = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXL();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.aMJ = null;
        this.cIU = null;
        this.inb = null;
        this.inc = null;
        this.ine = new ArrayList();
        this.cIH = 0L;
        this.ing = false;
        this.cIL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIH > 500) {
                    AdCloseView.this.boJ();
                    AdCloseView.this.cIH = currentTimeMillis;
                }
            }
        };
        this.inh = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXN = AdCloseView.this.bXN();
                if (bXN > 0) {
                    AdCloseView.this.flw.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0277d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.flw.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.ini = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.inc != null && AdCloseView.this.aMJ != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.inc.bwD));
                    AdCloseView.this.auU();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dXv) {
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
                    httpMessage.addParam("ext", AdCloseView.this.inc.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJb = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIU != null) {
                    AdCloseView.this.cIU.dismiss();
                    AdCloseView.this.cIU = null;
                }
            }
        };
        this.inj = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auU();
            }
        };
        this.ink = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXL();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.aMJ = null;
        this.cIU = null;
        this.inb = null;
        this.inc = null;
        this.ine = new ArrayList();
        this.cIH = 0L;
        this.ing = false;
        this.cIL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIH > 500) {
                    AdCloseView.this.boJ();
                    AdCloseView.this.cIH = currentTimeMillis;
                }
            }
        };
        this.inh = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXN = AdCloseView.this.bXN();
                if (bXN > 0) {
                    AdCloseView.this.flw.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0277d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXN));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.flw.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.ini = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.inc != null && AdCloseView.this.aMJ != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.inc.bwD));
                    AdCloseView.this.auU();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dXv) {
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
                    httpMessage.addParam("ext", AdCloseView.this.inc.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJb = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIU != null) {
                    AdCloseView.this.cIU.dismiss();
                    AdCloseView.this.cIU = null;
                }
            }
        };
        this.inj = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auU();
            }
        };
        this.ink = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXL();
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.dtj = new ImageView(getContext());
        this.dtj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(d.e.tbds31), getContext().getResources().getDimensionPixelSize(d.e.tbds31));
        layoutParams.gravity = 21;
        addView(this.dtj, layoutParams);
        this.mXOffset = l.h(this.mContext, d.e.ds32);
        this.mYOffset = l.h(this.mContext, d.e.ds10);
        this.mWindowHeight = l.h(this.mContext, d.e.ds278);
        this.cIP = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cIR = l.h(this.mContext, d.e.ds120);
        setOnClickListener(this.cIL);
        al.c(this.dtj, d.f.icon_home_card_delete);
        auV();
    }

    private void auV() {
        this.cIJ = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cIJ.setInterpolator(overshootInterpolator);
        this.cIJ.setDuration(250L);
        this.cIJ.setFillAfter(true);
        this.cIK = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cIK.setInterpolator(overshootInterpolator);
        this.cIK.setDuration(250L);
        this.cIK.setFillAfter(true);
    }

    private void setCWRotateAnimation() {
        if (this.dtj != null) {
            this.dtj.clearAnimation();
            this.dtj.startAnimation(this.cIJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setACRotateAnimation() {
        if (this.dtj != null) {
            this.dtj.clearAnimation();
            this.dtj.startAnimation(this.cIK);
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(d.g.head_text);
        this.efu = (RelativeLayout) inflate.findViewById(d.g.top_area);
        View findViewById = inflate.findViewById(d.g.ad_show_reason_wrapper);
        this.imZ = (TextView) inflate.findViewById(d.g.ad_show_reason);
        this.ina = (ImageView) inflate.findViewById(d.g.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.flw = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.inf)) {
            this.flw.setText(this.inf);
        }
        this.flw.setOnClickListener(this.ini);
        if (bXM()) {
            this.imZ.setText(this.ind.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.ink);
        }
        al.d(this.mTitleTextView, d.C0277d.cp_cont_b, 1);
        al.d(this.flw, d.C0277d.cp_btn_a, 1);
        al.d(this.imZ, d.C0277d.cp_other_i, 1);
        al.k(this.flw, d.f.bg_blue_rec_n);
        this.ina.setImageDrawable(al.getDrawable(d.f.icon_ad_dislike_arrow20_right_n));
        this.imY = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.inb = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boJ() {
        if (this.mContext != null) {
            auU();
            setCWRotateAnimation();
            View contentView = getContentView();
            bXK();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aMJ = new PopupWindow(contentView, this.cIP, this.mWindowHeight);
            this.aMJ.setFocusable(true);
            this.aMJ.setTouchable(true);
            this.aMJ.setOnDismissListener(this.cJb);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aMJ.setAttachedInDecor(false);
            }
            if (!this.ing) {
                MessageManager.getInstance().registerListener(this.inj);
                this.ing = true;
            }
            this.cIU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.cIU.setFocusable(false);
            this.cIU.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIU.setAttachedInDecor(false);
            }
            this.cIU.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.cIP, this.cIR, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aMJ.setAnimationStyle(d.k.scale_rb2lt_anim);
                    al.a(this.aMJ, d.f.bg_tost_feedback_down);
                    if (this.efu != null && this.efu.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.efu.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                    }
                } else {
                    this.aMJ.setAnimationStyle(d.k.scale_rt2lb_anim);
                    al.a(this.aMJ, d.f.bg_tost_feedback_up);
                    if (this.efu != null && this.efu.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.efu.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds84);
                    }
                }
                this.aMJ.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
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

    private void bXK() {
        if (this.ine != null && this.ine.size() > 0) {
            int size = this.ine.size();
            this.imY.setVisibility(0);
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
                this.imY.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.inh);
                    checkBox.setVisibility(0);
                    this.inb.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.ine.size(); i5++) {
                this.inb.get(i5).setText(this.ine.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auU() {
        if (this.aMJ != null) {
            this.aMJ.dismiss();
            this.aMJ = null;
        }
        if (this.cIU != null) {
            this.cIU.dismiss();
            this.cIU = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ing) {
            MessageManager.getInstance().unRegisterListener(this.inj);
            this.ing = false;
        }
        if (this.cIU != null) {
            if (this.aMJ == null || !this.aMJ.isShowing()) {
                this.cIU.dismiss();
                this.cIU = null;
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
            this.inc = advertAppInfo;
            this.ine.clear();
            if (this.inc.bwN != null && this.inc.bwN.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.inc.bwN.adCloseInfo;
                this.ind = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.ine.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.j.tell_us_reason);
                }
                this.inf = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXL() {
        if (bXM()) {
            a.awE().d(getContext(), new String[]{this.ind.url});
        }
    }

    private boolean bXM() {
        return (this.ind == null || TextUtils.isEmpty(this.ind.url) || TextUtils.isEmpty(this.ind.name)) ? false : true;
    }

    public void setPage(int i) {
        this.dXv = i;
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
        al.c(this.dtj, d.f.icon_home_card_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedResultJsonObj() {
        if (this.inc == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.T(this.inb)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.inb.size()) {
                    break;
                }
                CheckBox checkBox = this.inb.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.ine != null && this.ine.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.ine.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bXN() {
        if (v.T(this.inb)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.inb.size(); i2++) {
            CheckBox checkBox = this.inb.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
