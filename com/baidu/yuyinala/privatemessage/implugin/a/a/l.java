package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TempletMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class l extends com.baidu.yuyinala.privatemessage.implugin.a.a.c {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    private TextView oMA;
    private TextView oMB;
    private TextView oMC;
    private LinearLayout oMT;
    private LinearLayout oMU;
    private TempletMsg oMV;
    public LinearLayout oMq;

    @SuppressLint({"InflateParams"})
    public l(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_template, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.oMT = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_push_content_item_view);
        this.oMa = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMb = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_title);
        this.oMA = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_time);
        this.oMB = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_first);
        this.oMC = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_remark);
        this.oMq = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_template_multi);
        this.oMU = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_template_footer);
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

    public static com.baidu.yuyinala.privatemessage.implugin.a.a.c g(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof l)) ? new l(context, layoutInflater) : (l) view.getTag();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(Context context, final ChatMsg chatMsg) {
        int i;
        int i2 = 0;
        if (chatMsg instanceof TempletMsg) {
            this.oMV = (TempletMsg) chatMsg;
            this.oMb.setText(this.oMV.getTitle());
            this.oMA.setText(com.baidu.yuyinala.privatemessage.implugin.util.f.i(context, this.oMV.getMsgTime()));
            if (TextUtils.isEmpty(this.oMV.getFirstName())) {
                this.oMB.setVisibility(8);
            } else {
                this.oMB.setText(this.oMV.getFirstName());
                this.oMB.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.oMV.getRemarkName())) {
                this.oMC.setVisibility(8);
            } else {
                this.oMC.setText(this.oMV.getRemarkName());
                this.oMC.setVisibility(0);
            }
            try {
                this.oMB.setTextColor(Color.parseColor(Yx(this.oMV.getFirstColor())));
            } catch (Exception e) {
                this.oMB.setTextColor(ThemeManager.U(this.mContext, a.c.send_text_item_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e.getMessage());
            }
            try {
                this.oMC.setTextColor(Color.parseColor(Yx(this.oMV.getRemarkColor())));
            } catch (Exception e2) {
                this.oMC.setTextColor(ThemeManager.U(this.mContext, a.c.template_time_txt_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e2.getMessage());
            }
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String detail = l.this.oMV.getDetail();
                    if (!TextUtils.isEmpty(detail)) {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().h(l.this.mContext, detail, false);
                        com.baidu.yuyinala.privatemessage.implugin.util.c.i("PushTemplateItem", "click is template");
                        l.this.Yy("mainpart");
                    }
                }
            });
            this.mContentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, chatMsg);
                    return true;
                }
            });
            if (this.oMV.getCommodity() == null) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:getCommodity is null");
                return;
            }
            this.oMq.removeAllViews();
            TempletMsg.Commodity[] commodity = this.oMV.getCommodity();
            int length = commodity.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                TempletMsg.Commodity commodity2 = commodity[i3];
                if (!TextUtils.isEmpty(commodity2.getName())) {
                    int h = (int) h(context, commodity2.getName(), 14);
                    int h2 = (int) h(context, context.getResources().getString(a.h.bd_im_space_comma), 14);
                    if (context.getResources().getDisplayMetrics().scaledDensity < 3.0f) {
                        h2 = (int) (h2 * 1.5d);
                    }
                    i = h2 + h;
                    if (i > i4) {
                        i3++;
                        i4 = i;
                    }
                }
                i = i4;
                i3++;
                i4 = i;
            }
            for (int i5 = 0; i5 < this.oMV.getCommodity().length; i5++) {
                TempletMsg.Commodity commodity3 = this.oMV.getCommodity()[i5];
                View inflate = View.inflate(context, a.g.bd_im_chating_cell_push_template, null);
                TextView textView = (TextView) inflate.findViewById(a.f.bd_im_chating_cell_template_name);
                TextView textView2 = (TextView) inflate.findViewById(a.f.bd_im_chating_cell_template_value);
                if (textView != null && textView2 != null && commodity3 != null) {
                    String str = commodity3.getName() + context.getResources().getString(a.h.bd_im_space_comma);
                    String value = commodity3.getValue();
                    String color = commodity3.getColor();
                    if (!TextUtils.isEmpty(commodity3.getName())) {
                        textView.setText(str);
                        String str2 = "#000000";
                        if (ThemeManager.enN() == ThemeManager.ThemeMode.NIGHT) {
                            str2 = "#666666";
                        }
                        textView.setTextColor(Color.parseColor(str2));
                        if (i4 > 0) {
                            textView.setWidth(i4);
                        }
                    }
                    if (!TextUtils.isEmpty(value)) {
                        textView2.setText(value);
                    }
                    try {
                        if (!TextUtils.isEmpty(color)) {
                            textView2.setTextColor(Color.parseColor(Yx(color)));
                        }
                    } catch (Exception e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:color parse error");
                    }
                }
                this.oMq.addView(inflate, i5);
            }
            this.oMU.removeAllViews();
            switch (this.oMV.getMode()) {
                case 1:
                    while (true) {
                        int i6 = i2;
                        if (i6 >= this.oMV.getLinks().size()) {
                            break;
                        } else {
                            this.oMU.addView(new b(LayoutInflater.from(context), this.oMV.getLinks().get(i6), this.oMU, String.valueOf(i6 + 1)).mContentView);
                            i2 = i6 + 1;
                        }
                    }
                case 2:
                    a aVar = new a(LayoutInflater.from(context), this.oMU);
                    aVar.a(this.oMV.getImage());
                    this.oMU.addView(aVar.getContentView());
                    break;
                case 3:
                    c cVar = new c(LayoutInflater.from(context), this.oMU);
                    cVar.a(this.oMV.getVideo());
                    this.oMU.addView(cVar.getContentView());
                    break;
                default:
                    LogUtils.d("PushTemplateItem", "no foot");
                    break;
            }
        }
        ekY();
        super.b(context, chatMsg);
    }

    private String Yx(String str) {
        if (ThemeManager.enN() == ThemeManager.ThemeMode.NIGHT) {
            return "#555555";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yy(String str) {
        new HashMap().put("subchain", str);
    }

    private float h(Context context, String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * i);
        return textPaint.measureText(str);
    }

    private void ekY() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, View view, ChatMsg chatMsg) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(chatMsg.getMsgId()));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(1, "删除"));
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
        bVar.a(context, view, arrayList2, 1);
        bVar.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.3
            @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
            public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar2, int i, int i2) {
                com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c YK = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emz().YK(com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emz().emA());
                if (YK != null) {
                    YK.gH(arrayList);
                }
            }
        });
    }

    /* loaded from: classes4.dex */
    private class b {
        private ImageView mArrow;
        private TextView mContentText;
        private View mContentView;
        private View oMX;
        private LinearLayout oMY;
        private TextView oNb;

        public b(LayoutInflater layoutInflater, TempletMsg.Link link, ViewGroup viewGroup, String str) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_label, viewGroup, false);
            this.oMX = this.mContentView.findViewById(a.f.bd_im_chating_template_link_dividing);
            this.mContentText = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_title);
            this.oNb = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_detail);
            this.mArrow = (ImageView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_arrow);
            this.oMY = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_link_item);
            ekY();
            a(link, str);
        }

        private void ekY() {
        }

        private void a(final TempletMsg.Link link, final String str) {
            this.mContentText.setText(link.getContent());
            if (TextUtils.isEmpty(link.getTitle())) {
                this.oNb.setVisibility(8);
            } else {
                this.oNb.setText(link.getTitle());
            }
            this.oMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().h(l.this.mContext, link.getUrl(), false);
                    l.this.Yy("text" + str);
                }
            });
            this.oMY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.oMV);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        View elr;
        TextView guh;
        View mContentView;
        ImageView mImageView;
        TextView mTitle;
        View oMX;
        LinearLayout oMY;

        public a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_media, viewGroup, false);
            this.mImageView = (ImageView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_display);
            this.mTitle = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_title);
            this.guh = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_description);
            this.oMX = this.mContentView.findViewById(a.f.bd_im_chat_template_media_dividing);
            this.oMY = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_media_item);
            this.elr = this.mContentView.findViewById(a.f.bd_im_chat_template_media_display_cover);
            ekY();
        }

        protected void ekY() {
        }

        public void a(final TempletMsg.Image image) {
            this.mTitle.setText(image.getTitle());
            this.guh.setText(image.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.hr(l.this.mContext);
            ImageLoader.getInstance().displayImage(image.getImage(), this.mImageView);
            this.oMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().h(l.this.mContext, image.getUrl(), false);
                    l.this.Yy("image");
                }
            });
            this.oMY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.oMV);
                    return true;
                }
            });
        }

        public View getContentView() {
            return this.mContentView;
        }
    }

    /* loaded from: classes4.dex */
    private class c extends a {
        private TextView guj;

        public c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater, viewGroup);
            this.guj = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_video_time);
            this.guj.setVisibility(0);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.l.a
        protected void ekY() {
            super.ekY();
            if (this.guj != null) {
            }
        }

        public void a(final TempletMsg.Video video) {
            ekY();
            this.mTitle.setText(video.getTitle());
            this.guh.setText(video.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.hr(l.this.mContext);
            ImageLoader.getInstance().displayImage(video.getCover(), this.mImageView);
            this.guj.setText(video.getDuration());
            this.oMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().h(l.this.mContext, video.getUrl(), false);
                    l.this.Yy("video");
                }
            });
            this.oMY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.oMV);
                    return true;
                }
            });
        }
    }
}
