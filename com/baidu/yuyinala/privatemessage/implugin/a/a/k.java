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
/* loaded from: classes11.dex */
public class k extends c {
    public View ixm;
    private ImageView jRQ;
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    private int mPosition;
    public LinearLayout oYJ;
    private b.a oYS;
    private TextView oYT;
    private TextView oYU;
    private TextView oYV;
    private TextView oYW;
    public RelativeLayout oYX;
    private RelativeLayout oYY;
    private PopupWindow oYZ;
    private LinearLayout oZa;
    private TextView oZb;
    private TextView oZc;
    private TextView oZd;
    private TextView oZe;
    private TextView oZf;
    private TextView oZg;
    private RoundedImageView oZh;

    @SuppressLint({"InflateParams"})
    public k(Context context, LayoutInflater layoutInflater, int i, b.a aVar) {
        this.mContext = context;
        this.oYS = aVar;
        this.mPosition = i;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_smart_template, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.oYt = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oYu = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_smart_title);
        this.oZd = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_smart_reject_flag);
        this.ixm = this.mConvertView.findViewById(a.f.bd_im_template_sep_line);
        this.jRQ = (ImageView) this.mConvertView.findViewById(a.f.bd_im_arrow_right);
        this.oZh = (RoundedImageView) this.mConvertView.findViewById(a.f.bd_im_smart_headview);
        this.oZf = (TextView) this.mConvertView.findViewById(a.f.bd_im_menu_divider);
        this.oZg = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_smart_newest);
        this.oYT = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_time);
        this.oYU = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_first);
        this.oYV = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_remark);
        this.oYW = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_detail_more);
        this.oYY = (RelativeLayout) this.mConvertView.findViewById(a.f.bd_im_chating_smart_menu);
        this.oYX = (RelativeLayout) this.mConvertView.findViewById(a.f.bd_im_template_detail);
        this.oYJ = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_template_multi);
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
        r13.oYU.setTextColor(com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager.U(r13.mContext, com.baidu.live.sdk.a.c.send_text_item_color));
        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushSmartTemplateItem", "Error:" + r1.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0120, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0121, code lost:
        r13.oYV.setTextColor(com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager.U(r13.mContext, com.baidu.live.sdk.a.c.template_time_txt_color));
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
            this.oYu.setText(smartMsg.getName());
            this.oZg.setText(smartMsg.getTitle());
            this.oYT.setText(com.baidu.yuyinala.privatemessage.implugin.util.f.j(context, smartMsg.getMsgTime()));
            com.baidu.yuyinala.privatemessage.implugin.util.b.hF(context);
            ImageLoader.getInstance().displayImage(smartMsg.getIcon(), this.oZh, com.baidu.yuyinala.privatemessage.implugin.util.b.emz());
            int notifyCmd = chatMsg.getNotifyCmd();
            if (notifyCmd >= -1) {
                if (notifyCmd < 1) {
                    this.oZd.setVisibility(0);
                    this.oYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            k.this.a(z, chatMsg);
                        }
                    });
                    if (!TextUtils.isEmpty(smartMsg.getFirstName())) {
                        this.oYU.setVisibility(8);
                    } else {
                        this.oYU.setText(smartMsg.getFirstName());
                        this.oYU.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(smartMsg.getRemarkName())) {
                        this.oYV.setVisibility(8);
                    } else {
                        this.oYV.setText(smartMsg.getRemarkName());
                        this.oYV.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(smartMsg.getDetail()) && TextUtils.isEmpty(smartMsg.getSchema())) {
                        this.oYX.setVisibility(8);
                    } else {
                        this.oYX.setVisibility(0);
                    }
                    this.oYU.setTextColor(Color.parseColor(Ym(smartMsg.getFirstColor())));
                    this.oYV.setTextColor(Color.parseColor(ThemeManager.emw() != ThemeManager.ThemeMode.NIGHT ? "#666666" : "#999999"));
                    if (smartMsg.getCommodity() != null) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushSmartTemplateItem", "Error:getCommodity is null");
                        return;
                    }
                    this.oYJ.removeAllViews();
                    SmartMsg.Commodity[] commodity = smartMsg.getCommodity();
                    int length = commodity.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        SmartMsg.Commodity commodity2 = commodity[i3];
                        if (!TextUtils.isEmpty(commodity2.getName())) {
                            int i5 = (int) i(context, commodity2.getName(), 14);
                            int i6 = (int) i(context, context.getResources().getString(a.h.bd_im_space_comma), 14);
                            if (context.getResources().getDisplayMetrics().scaledDensity < 3.0f) {
                                i6 = (int) (i6 * 1.5d);
                            }
                            i = i6 + i5;
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
                        int i7 = i2;
                        if (i7 >= smartMsg.getCommodity().length) {
                            break;
                        }
                        SmartMsg.Commodity commodity3 = smartMsg.getCommodity()[i7];
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
                                    textView2.setTextColor(Color.parseColor(Ym(color)));
                                }
                            } catch (Exception e) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushSmartTemplateItem", "Error:color parse error");
                            }
                        }
                        this.oYJ.addView(inflate, i7);
                        i2 = i7 + 1;
                    }
                } else {
                    this.oZd.setVisibility(8);
                }
            }
            z = false;
            this.oYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.1
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
            this.oYX.setVisibility(0);
            this.oYU.setTextColor(Color.parseColor(Ym(smartMsg.getFirstColor())));
            this.oYV.setTextColor(Color.parseColor(ThemeManager.emw() != ThemeManager.ThemeMode.NIGHT ? "#666666" : "#999999"));
            if (smartMsg.getCommodity() != null) {
            }
        }
        ejM();
        super.b(context, chatMsg);
    }

    private String Ym(String str) {
        if (ThemeManager.emw() == ThemeManager.ThemeMode.NIGHT) {
            return "#555555";
        }
        return "#000000";
    }

    private float i(Context context, String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * i);
        return textPaint.measureText(str);
    }

    private void ejM() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ChatMsg chatMsg) {
        final SmartMsg smartMsg = (SmartMsg) chatMsg;
        View inflate = View.inflate(this.mContext, a.g.bd_im_smart_pop_win, null);
        this.oZb = (TextView) inflate.findViewById(a.f.bd_im_chating_smart_reject_menu);
        this.oZc = (TextView) inflate.findViewById(a.f.bd_im_chating_smart_receive_menu);
        this.oZe = (TextView) inflate.findViewById(a.f.bd_im_smart_pop_txt);
        this.oZa = (LinearLayout) inflate.findViewById(a.f.bd_im_pop_win);
        this.oYZ = new PopupWindow(inflate, -2, -2, true);
        this.oYZ.setTouchable(true);
        this.oYZ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.oYZ.setBackgroundDrawable(new ColorDrawable());
        this.oYZ.showAsDropDown(this.oZh, com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 162.0f), com.baidu.yuyinala.privatemessage.implugin.util.f.dip2px(this.mContext, 14.0f));
        this.oZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.oYZ != null && k.this.oYZ.isShowing()) {
                    k.this.oYZ.dismiss();
                }
                k.this.a(smartMsg);
            }
        });
        ejM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SmartMsg smartMsg) {
        com.baidu.yuyinala.privatemessage.implugin.f.h hW = com.baidu.yuyinala.privatemessage.implugin.f.k.hC(this.mContext).hW(smartMsg.getContacter());
        if (hW != null && !TextUtils.isEmpty(hW.getThirdId()) && !TextUtils.isEmpty(hW.getType())) {
            a(hW, smartMsg);
        } else {
            com.baidu.yuyinala.privatemessage.implugin.b.b.hw(this.mContext).x(new com.baidu.yuyinala.privatemessage.implugin.f.d(this.mContext, smartMsg.getContacter(), new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.4
                @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
                public void d(int i, String str, long j) {
                    if (i == 200) {
                        com.baidu.yuyinala.privatemessage.implugin.f.h hVar = new com.baidu.yuyinala.privatemessage.implugin.f.h();
                        hVar.setPaid(smartMsg.getContacter());
                        hVar.Yq(str);
                        if (hVar.isDataValid()) {
                            com.baidu.yuyinala.privatemessage.implugin.f.k.hC(k.this.mContext).a(smartMsg.getContacter(), hVar);
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
            com.baidu.yuyinala.privatemessage.implugin.b.b.hw(this.mContext).x(new com.baidu.yuyinala.privatemessage.implugin.f.a(this.mContext, Long.valueOf(hVar.ejY()).longValue(), hVar.getType(), hVar.ejX(), new com.baidu.yuyinala.privatemessage.implugin.f.g() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.k.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
                public void d(int i, String str, long j) {
                    if (i == 200) {
                        com.baidu.yuyinala.privatemessage.implugin.f.h hVar2 = new com.baidu.yuyinala.privatemessage.implugin.f.h();
                        hVar.setPaid(smartMsg.getContacter());
                        if (hVar.ejX() == 0) {
                            hVar.setNotify(1);
                        } else if (hVar.ejX() == 1) {
                            hVar.setNotify(0);
                        }
                        hVar2.Yq(str);
                        if (hVar2.isDataValid()) {
                            com.baidu.yuyinala.privatemessage.implugin.f.k.hC(k.this.mContext).a(smartMsg.getContacter(), hVar);
                            if (k.this.oYS != null) {
                                smartMsg.setNotifyCmd(hVar.ejX());
                                k.this.oYS.a(k.this.mConvertView, k.this.mPosition, smartMsg);
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
