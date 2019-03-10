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
    private PopupWindow aMI;
    private long cIK;
    private RotateAnimation cIM;
    private RotateAnimation cIN;
    private View.OnClickListener cIO;
    private int cIS;
    private int cIU;
    private PopupWindow cIX;
    private PopupWindow.OnDismissListener cJe;
    private int dXz;
    private ImageView dtn;
    private RelativeLayout efy;
    private TextView flx;
    private LinearLayout inf;
    private TextView ing;
    private ImageView inh;
    private List<CheckBox> ini;
    private AdvertAppInfo inj;
    private ActionControl ink;
    private List<String> inl;
    private String inm;
    private boolean inn;
    private View.OnClickListener ino;
    private View.OnClickListener inp;
    private final CustomMessageListener inq;
    private View.OnClickListener inr;
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
        this.aMI = null;
        this.cIX = null;
        this.ini = null;
        this.inj = null;
        this.inl = new ArrayList();
        this.cIK = 0L;
        this.inn = false;
        this.cIO = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIK > 500) {
                    AdCloseView.this.boK();
                    AdCloseView.this.cIK = currentTimeMillis;
                }
            }
        };
        this.ino = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXL = AdCloseView.this.bXL();
                if (bXL > 0) {
                    AdCloseView.this.flx.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0236d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXL));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0236d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.flx.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.inp = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.inj != null && AdCloseView.this.aMI != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.inj.bwB));
                    AdCloseView.this.auV();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dXz) {
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
                    httpMessage.addParam("ext", AdCloseView.this.inj.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJe = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIX != null) {
                    AdCloseView.this.cIX.dismiss();
                    AdCloseView.this.cIX = null;
                }
            }
        };
        this.inq = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auV();
            }
        };
        this.inr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXJ();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.aMI = null;
        this.cIX = null;
        this.ini = null;
        this.inj = null;
        this.inl = new ArrayList();
        this.cIK = 0L;
        this.inn = false;
        this.cIO = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIK > 500) {
                    AdCloseView.this.boK();
                    AdCloseView.this.cIK = currentTimeMillis;
                }
            }
        };
        this.ino = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXL = AdCloseView.this.bXL();
                if (bXL > 0) {
                    AdCloseView.this.flx.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0236d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXL));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0236d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.flx.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.inp = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.inj != null && AdCloseView.this.aMI != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.inj.bwB));
                    AdCloseView.this.auV();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dXz) {
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
                    httpMessage.addParam("ext", AdCloseView.this.inj.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJe = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIX != null) {
                    AdCloseView.this.cIX.dismiss();
                    AdCloseView.this.cIX = null;
                }
            }
        };
        this.inq = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auV();
            }
        };
        this.inr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXJ();
            }
        };
        this.mContext = context;
        init();
    }

    public AdCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.aMI = null;
        this.cIX = null;
        this.ini = null;
        this.inj = null;
        this.inl = new ArrayList();
        this.cIK = 0L;
        this.inn = false;
        this.cIO = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - AdCloseView.this.cIK > 500) {
                    AdCloseView.this.boK();
                    AdCloseView.this.cIK = currentTimeMillis;
                }
            }
        };
        this.ino = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int bXL = AdCloseView.this.bXL();
                if (bXL > 0) {
                    AdCloseView.this.flx.setText(d.j.confirm);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_prefix));
                    int color = al.getColor(d.C0236d.cp_cont_b);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(bXL));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0236d.cp_link_tip_a)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) AdCloseView.this.mContext.getString(d.j.ad_close_title_postfix));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    AdCloseView.this.mTitleTextView.setText(spannableStringBuilder);
                    return;
                }
                AdCloseView.this.flx.setText(d.j.ad_no_interest);
                AdCloseView.this.mTitleTextView.setText(AdCloseView.this.mTitle);
            }
        };
        this.inp = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdCloseView.this.inj != null && AdCloseView.this.aMI != null) {
                    String selectedResultJsonObj = AdCloseView.this.getSelectedResultJsonObj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, AdCloseView.this.inj.bwB));
                    AdCloseView.this.auV();
                    TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                    tbHttpMessageTask.setIsNeedAddCommenParam(true);
                    tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
                    switch (AdCloseView.this.dXz) {
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
                    httpMessage.addParam("ext", AdCloseView.this.inj.extensionInfo);
                    httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
                    MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
                }
            }
        };
        this.cJe = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                AdCloseView.this.setACRotateAnimation();
                if (AdCloseView.this.cIX != null) {
                    AdCloseView.this.cIX.dismiss();
                    AdCloseView.this.cIX = null;
                }
            }
        };
        this.inq = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.recapp.view.AdCloseView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AdCloseView.this.auV();
            }
        };
        this.inr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdCloseView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdCloseView.this.bXJ();
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
        this.cIS = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cIU = l.h(this.mContext, d.e.ds120);
        setOnClickListener(this.cIO);
        al.c(this.dtn, d.f.icon_home_card_delete);
        auW();
    }

    private void auW() {
        this.cIM = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cIM.setInterpolator(overshootInterpolator);
        this.cIM.setDuration(250L);
        this.cIM.setFillAfter(true);
        this.cIN = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cIN.setInterpolator(overshootInterpolator);
        this.cIN.setDuration(250L);
        this.cIN.setFillAfter(true);
    }

    private void setCWRotateAnimation() {
        if (this.dtn != null) {
            this.dtn.clearAnimation();
            this.dtn.startAnimation(this.cIM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setACRotateAnimation() {
        if (this.dtn != null) {
            this.dtn.clearAnimation();
            this.dtn.startAnimation(this.cIN);
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.ad_close_popupwindow, (ViewGroup) null);
        this.mTitleTextView = (TextView) inflate.findViewById(d.g.head_text);
        this.efy = (RelativeLayout) inflate.findViewById(d.g.top_area);
        View findViewById = inflate.findViewById(d.g.ad_show_reason_wrapper);
        this.ing = (TextView) inflate.findViewById(d.g.ad_show_reason);
        this.inh = (ImageView) inflate.findViewById(d.g.arrow_right);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
        }
        this.flx = (TextView) inflate.findViewById(d.g.forbid_thread_btn);
        if (!TextUtils.isEmpty(this.inm)) {
            this.flx.setText(this.inm);
        }
        this.flx.setOnClickListener(this.inp);
        if (bXK()) {
            this.ing.setText(this.ink.name);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this.inr);
        }
        al.d(this.mTitleTextView, d.C0236d.cp_cont_b, 1);
        al.d(this.flx, d.C0236d.cp_btn_a, 1);
        al.d(this.ing, d.C0236d.cp_other_i, 1);
        al.k(this.flx, d.f.bg_blue_rec_n);
        this.inh.setImageDrawable(al.getDrawable(d.f.icon_ad_dislike_arrow20_right_n));
        this.inf = (LinearLayout) inflate.findViewById(d.g.reason_root_container);
        this.ini = new ArrayList();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boK() {
        if (this.mContext != null) {
            auV();
            setCWRotateAnimation();
            View contentView = getContentView();
            bXI();
            this.mContentView = contentView;
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aMI = new PopupWindow(contentView, this.cIS, this.mWindowHeight);
            this.aMI.setFocusable(true);
            this.aMI.setTouchable(true);
            this.aMI.setOnDismissListener(this.cJe);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aMI.setAttachedInDecor(false);
            }
            if (!this.inn) {
                MessageManager.getInstance().registerListener(this.inq);
                this.inn = true;
            }
            this.cIX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.cIX.setFocusable(false);
            this.cIX.setTouchable(false);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIX.setAttachedInDecor(false);
            }
            this.cIX.showAtLocation(this, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this, this.mWindowHeight, this.cIS, this.cIU, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aMI.setAnimationStyle(d.k.scale_rb2lt_anim);
                    al.a(this.aMI, d.f.bg_tost_feedback_down);
                    if (this.efy != null && this.efy.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.efy.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                    }
                } else {
                    this.aMI.setAnimationStyle(d.k.scale_rt2lb_anim);
                    al.a(this.aMI, d.f.bg_tost_feedback_up);
                    if (this.efy != null && this.efy.getLayoutParams() != null) {
                        ((ViewGroup.MarginLayoutParams) this.efy.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds84);
                    }
                }
                this.aMI.showAtLocation(getRootView(), 0, iArr[0] - this.mXOffset, iArr[1]);
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

    private void bXI() {
        if (this.inl != null && this.inl.size() > 0) {
            int size = this.inl.size();
            this.inf.setVisibility(0);
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
                this.inf.addView(linearLayout);
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
                    checkBox.setOnClickListener(this.ino);
                    checkBox.setVisibility(0);
                    this.ini.add(checkBox);
                    i3++;
                    i = i4;
                }
            }
            for (int i5 = 0; i5 < this.inl.size(); i5++) {
                this.ini.get(i5).setText(this.inl.get(i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auV() {
        if (this.aMI != null) {
            this.aMI.dismiss();
            this.aMI = null;
        }
        if (this.cIX != null) {
            this.cIX.dismiss();
            this.cIX = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.inn) {
            MessageManager.getInstance().unRegisterListener(this.inq);
            this.inn = false;
        }
        if (this.cIX != null) {
            if (this.aMI == null || !this.aMI.isShowing()) {
                this.cIX.dismiss();
                this.cIX = null;
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
            this.inj = advertAppInfo;
            this.inl.clear();
            if (this.inj.bwL != null && this.inj.bwL.adCloseInfo != null) {
                AdCloseInfo adCloseInfo = this.inj.bwL.adCloseInfo;
                this.ink = adCloseInfo.action_control;
                for (String str : adCloseInfo.reasons) {
                    this.inl.add(str);
                }
                this.mTitle = adCloseInfo.title;
                if (TextUtils.isEmpty(adCloseInfo.title)) {
                    this.mTitle = this.mContext.getString(d.j.tell_us_reason);
                }
                this.inm = adCloseInfo.confirm_title;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXJ() {
        if (bXK()) {
            a.awF().d(getContext(), new String[]{this.ink.url});
        }
    }

    private boolean bXK() {
        return (this.ink == null || TextUtils.isEmpty(this.ink.url) || TextUtils.isEmpty(this.ink.name)) ? false : true;
    }

    public void setPage(int i) {
        this.dXz = i;
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
        if (this.inj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.T(this.ini)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ini.size()) {
                    break;
                }
                CheckBox checkBox = this.ini.get(i2);
                if (checkBox != null && checkBox.isChecked() && this.inl != null && this.inl.size() > i2) {
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(this.inl.get(i2));
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bXL() {
        if (v.T(this.ini)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.ini.size(); i2++) {
            CheckBox checkBox = this.ini.get(i2);
            if (checkBox != null && checkBox.isChecked()) {
                i++;
            }
        }
        return i;
    }
}
