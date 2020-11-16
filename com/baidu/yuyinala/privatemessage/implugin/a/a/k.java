package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SmartMsg;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.yuyinala.privatemessage.implugin.a.a.b;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.RoundedImageView;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes4.dex */
public class k extends c {
    public View hYH;
    private ImageView jpf;
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    private int mPosition;
    private PopupWindow oxA;
    private LinearLayout oxB;
    private TextView oxC;
    private TextView oxD;
    private TextView oxE;
    private TextView oxF;
    private TextView oxG;
    private TextView oxH;
    private RoundedImageView oxI;
    public LinearLayout oxk;
    private b.a oxt;
    private TextView oxu;
    private TextView oxv;
    private TextView oxw;
    private TextView oxx;
    public RelativeLayout oxy;
    private RelativeLayout oxz;

    @SuppressLint({"InflateParams"})
    public k(Context context, LayoutInflater layoutInflater, int i, b.a aVar) {
        this.mContext = context;
        this.oxt = aVar;
        this.mPosition = i;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_smart_template, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.owU = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.owV = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_smart_title);
        this.oxE = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_smart_reject_flag);
        this.hYH = this.mConvertView.findViewById(a.f.bd_im_template_sep_line);
        this.jpf = (ImageView) this.mConvertView.findViewById(a.f.bd_im_arrow_right);
        this.oxI = (RoundedImageView) this.mConvertView.findViewById(a.f.bd_im_smart_headview);
        this.oxG = (TextView) this.mConvertView.findViewById(a.f.bd_im_menu_divider);
        this.oxH = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_smart_newest);
        this.oxu = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_time);
        this.oxv = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_first);
        this.oxw = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_remark);
        this.oxx = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_detail_more);
        this.oxz = (RelativeLayout) this.mConvertView.findViewById(a.f.bd_im_chating_smart_menu);
        this.oxy = (RelativeLayout) this.mConvertView.findViewById(a.f.bd_im_template_detail);
        this.oxk = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_template_multi);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public View getContentView() {
        return this.mContentView;
    }

    public static c a(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view, int i, b.a aVar) {
        return (view == null || !(view.getTag() instanceof k)) ? new k(context, layoutInflater, i, aVar) : (k) view.getTag();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:3|(1:(15:6|7|(1:9)(1:82)|10|(1:12)(1:81)|13|(1:80)(1:17)|18|19|20|21|(1:23)(1:74)|24|25|(2:27|28)(4:30|(5:32|(4:34|(1:36)|37|(2:39|40))|41|42|40)|43|(2:44|(3:46|(7:50|(2:52|(1:54))|55|(1:57)|58|59|(2:61|62)(1:64))|63)(1:72))))(1:83))|84|7|(0)(0)|10|(0)(0)|13|(1:15)|80|18|19|20|21|(0)(0)|24|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ef, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f0, code lost:
        r13.oxv.setTextColor(com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager.L(r13.mContext, com.baidu.live.sdk.a.c.send_text_item_color));
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushSmartTemplateItem", "Error:" + r1.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0120, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0121, code lost:
        r13.oxw.setTextColor(com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager.L(r13.mContext, com.baidu.live.sdk.a.c.template_time_txt_color));
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushSmartTemplateItem", "Error:" + r1.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014e  */
    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, final ChatMsg chatMsg) {
        int i;
        final boolean z = true;
        int i2 = 0;
        if (chatMsg instanceof SmartMsg) {
            SmartMsg smartMsg = (SmartMsg) chatMsg;
            this.owV.setText(smartMsg.getName());
            this.oxH.setText(smartMsg.getTitle());
            this.oxu.setText(com.baidu.yuyinala.privatemessage.implugin.util.f.g(context, smartMsg.getMsgTime()));
            com.baidu.yuyinala.privatemessage.implugin.util.b.gI(context);
            ImageLoader.getInstance().displayImage(smartMsg.getIcon(), this.oxI, com.baidu.yuyinala.privatemessage.implugin.util.b.eib());
            int notifyCmd = chatMsg.getNotifyCmd();
            if (notifyCmd >= -1) {
                if (notifyCmd < 1) {
                    this.oxE.setVisibility(0);
                    this.oxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            k.this.a(z, chatMsg);
                        }
                    });
                    if (!TextUtils.isEmpty(smartMsg.getFirstName())) {
                        this.oxv.setVisibility(8);
                    } else {
                        this.oxv.setText(smartMsg.getFirstName());
                        this.oxv.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(smartMsg.getRemarkName())) {
                        this.oxw.setVisibility(8);
                    } else {
                        this.oxw.setText(smartMsg.getRemarkName());
                        this.oxw.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(smartMsg.getDetail()) && TextUtils.isEmpty(smartMsg.getSchema())) {
                        this.oxy.setVisibility(8);
                    } else {
                        this.oxy.setVisibility(0);
                    }
                    this.oxv.setTextColor(Color.parseColor(Xc(smartMsg.getFirstColor())));
                    this.oxw.setTextColor(Color.parseColor(ThemeManager.ehY() != ThemeManager.ThemeMode.NIGHT ? "#666666" : "#999999"));
                    if (smartMsg.getCommodity() != null) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushSmartTemplateItem", "Error:getCommodity is null");
                        return;
                    }
                    this.oxk.removeAllViews();
                    SmartMsg.Commodity[] commodity = smartMsg.getCommodity();
                    int length = commodity.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        SmartMsg.Commodity commodity2 = commodity[i3];
                        if (!TextUtils.isEmpty(commodity2.getName())) {
                            int g = (int) g(context, commodity2.getName(), 14);
                            int g2 = (int) g(context, context.getResources().getString(a.h.bd_im_space_comma), 14);
                            if (context.getResources().getDisplayMetrics().scaledDensity < 3.0f) {
                                g2 = (int) (g2 * 1.5d);
                            }
                            i = g2 + g;
                            if (i > i4) {
                                i3++;
                                i4 = i;
                            }
                        }
                        i = i4;
                        i3++;
                        i4 = i;
                    }
                    while (true) {
                        int i5 = i2;
                        if (i5 >= smartMsg.getCommodity().length) {
                            break;
                        }
                        SmartMsg.Commodity commodity3 = smartMsg.getCommodity()[i5];
                        View inflate = View.inflate(context, a.g.bd_im_chating_cell_push_template, null);
                        TextView textView = (TextView) inflate.findViewById(a.f.bd_im_chating_cell_template_name);
                        TextView textView2 = (TextView) inflate.findViewById(a.f.bd_im_chating_cell_template_value);
                        if (textView != null && textView2 != null && commodity3 != null) {
                            String str = commodity3.getName() + "";
                            String value = commodity3.getValue();
                            String color = commodity3.getColor();
                            if (!TextUtils.isEmpty(commodity3.getName())) {
                                textView.setText(str);
                                textView.setTextColor(Color.parseColor("#666666"));
                                if (i4 > 0) {
                                    textView.setWidth(i4);
                                }
                            }
                            if (!TextUtils.isEmpty(value)) {
                                textView2.setText(value);
                            }
                            try {
                                if (!TextUtils.isEmpty(color)) {
                                    textView2.setTextColor(Color.parseColor(Xc(color)));
                                }
                            } catch (Exception e) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushSmartTemplateItem", "Error:color parse error");
                            }
                        }
                        this.oxk.addView(inflate, i5);
                        i2 = i5 + 1;
                    }
                } else {
                    this.oxE.setVisibility(8);
                }
            }
            z = false;
            this.oxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.this.a(z, chatMsg);
                }
            });
            if (!TextUtils.isEmpty(smartMsg.getFirstName())) {
            }
            if (!TextUtils.isEmpty(smartMsg.getRemarkName())) {
            }
            if (!TextUtils.isEmpty(smartMsg.getDetail())) {
            }
            this.oxy.setVisibility(0);
            this.oxv.setTextColor(Color.parseColor(Xc(smartMsg.getFirstColor())));
            this.oxw.setTextColor(Color.parseColor(ThemeManager.ehY() != ThemeManager.ThemeMode.NIGHT ? "#666666" : "#999999"));
            if (smartMsg.getCommodity() != null) {
            }
        }
        efl();
        super.b(context, chatMsg);
    }

    private String Xc(String str) {
        if (ThemeManager.ehY() == ThemeManager.ThemeMode.NIGHT) {
            return "#555555";
        }
        return "#000000";
    }

    private float g(Context context, String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * i);
        return textPaint.measureText(str);
    }

    private void efl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ChatMsg chatMsg) {
        final SmartMsg smartMsg = (SmartMsg) chatMsg;
        View inflate = View.inflate(this.mContext, a.g.bd_im_smart_pop_win, null);
        this.oxC = (TextView) inflate.findViewById(a.f.bd_im_chating_smart_reject_menu);
        this.oxD = (TextView) inflate.findViewById(a.f.bd_im_chating_smart_receive_menu);
        this.oxF = (TextView) inflate.findViewById(a.f.bd_im_smart_pop_txt);
        this.oxB = (LinearLayout) inflate.findViewById(a.f.bd_im_pop_win);
        this.oxA = new PopupWindow(inflate, -2, -2, true);
        this.oxA.setTouchable(true);
        this.oxA.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.oxA.setBackgroundDrawable(new ColorDrawable());
        this.oxA.showAsDropDown(this.oxI, com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 162.0f), com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 14.0f));
        this.oxB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.oxA != null && k.this.oxA.isShowing()) {
                    k.this.oxA.dismiss();
                }
                k.this.a(smartMsg);
            }
        });
        efl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SmartMsg smartMsg) {
        com.baidu.yuyinala.privatemessage.implugin.f.h hu = com.baidu.yuyinala.privatemessage.implugin.f.k.gD(this.mContext).hu(smartMsg.getContacter());
        if (hu != null && !TextUtils.isEmpty(hu.getThirdId()) && !TextUtils.isEmpty(hu.getType())) {
            a(hu, smartMsg);
        } else {
            com.baidu.yuyinala.privatemessage.implugin.b.b.gw(this.mContext).C(new com.baidu.yuyinala.privatemessage.implugin.f.d(this.mContext, smartMsg.getContacter(), new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.4
                @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
                public void d(int i, String str, long j) {
                    if (i == 200) {
                        com.baidu.yuyinala.privatemessage.implugin.f.h hVar = new com.baidu.yuyinala.privatemessage.implugin.f.h();
                        hVar.setPaid(smartMsg.getContacter());
                        hVar.Xg(str);
                        if (hVar.isDataValid()) {
                            com.baidu.yuyinala.privatemessage.implugin.f.k.gD(k.this.mContext).a(smartMsg.getContacter(), hVar);
                            k.this.a(hVar, smartMsg);
                        }
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.yuyinala.privatemessage.implugin.f.h hVar, final SmartMsg smartMsg) {
        try {
            com.baidu.yuyinala.privatemessage.implugin.b.b.gw(this.mContext).C(new com.baidu.yuyinala.privatemessage.implugin.f.a(this.mContext, Long.valueOf(hVar.efx()).longValue(), hVar.getType(), hVar.efw(), new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
                public void d(int i, String str, long j) {
                    if (i == 200) {
                        com.baidu.yuyinala.privatemessage.implugin.f.h hVar2 = new com.baidu.yuyinala.privatemessage.implugin.f.h();
                        hVar.setPaid(smartMsg.getContacter());
                        if (hVar.efw() == 0) {
                            hVar.Ob(1);
                        } else if (hVar.efw() == 1) {
                            hVar.Ob(0);
                        }
                        hVar2.Xg(str);
                        if (hVar2.isDataValid()) {
                            com.baidu.yuyinala.privatemessage.implugin.f.k.gD(k.this.mContext).a(smartMsg.getContacter(), hVar);
                            if (k.this.oxt != null) {
                                smartMsg.setNotifyCmd(hVar.efw());
                                k.this.oxt.a(k.this.mConvertView, k.this.mPosition, smartMsg);
                            }
                        }
                    }
                }
            }));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
