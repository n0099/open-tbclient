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
    public LinearLayout ovG;
    private TextView ovQ;
    private TextView ovR;
    private TextView ovS;
    private LinearLayout owj;
    private LinearLayout owk;
    private TempletMsg owl;

    @SuppressLint({"InflateParams"})
    public l(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_template, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.owj = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_push_content_item_view);
        this.ovq = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.ovr = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_title);
        this.ovQ = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_time);
        this.ovR = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_first);
        this.ovS = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_remark);
        this.ovG = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_template_multi);
        this.owk = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_template_footer);
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
            this.owl = (TempletMsg) chatMsg;
            this.ovr.setText(this.owl.getTitle());
            this.ovQ.setText(com.baidu.yuyinala.privatemessage.implugin.util.f.g(context, this.owl.getMsgTime()));
            if (TextUtils.isEmpty(this.owl.getFirstName())) {
                this.ovR.setVisibility(8);
            } else {
                this.ovR.setText(this.owl.getFirstName());
                this.ovR.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.owl.getRemarkName())) {
                this.ovS.setVisibility(8);
            } else {
                this.ovS.setText(this.owl.getRemarkName());
                this.ovS.setVisibility(0);
            }
            try {
                this.ovR.setTextColor(Color.parseColor(Xr(this.owl.getFirstColor())));
            } catch (Exception e) {
                this.ovR.setTextColor(ThemeManager.L(this.mContext, a.c.send_text_item_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e.getMessage());
            }
            try {
                this.ovS.setTextColor(Color.parseColor(Xr(this.owl.getRemarkColor())));
            } catch (Exception e2) {
                this.ovS.setTextColor(ThemeManager.L(this.mContext, a.c.template_time_txt_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e2.getMessage());
            }
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String detail = l.this.owl.getDetail();
                    if (!TextUtils.isEmpty(detail)) {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().g(l.this.mContext, detail, false);
                        com.baidu.yuyinala.privatemessage.implugin.util.c.i("PushTemplateItem", "click is template");
                        l.this.Xs("mainpart");
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
            if (this.owl.getCommodity() == null) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:getCommodity is null");
                return;
            }
            this.ovG.removeAllViews();
            TempletMsg.Commodity[] commodity = this.owl.getCommodity();
            int length = commodity.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                TempletMsg.Commodity commodity2 = commodity[i3];
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
            for (int i5 = 0; i5 < this.owl.getCommodity().length; i5++) {
                TempletMsg.Commodity commodity3 = this.owl.getCommodity()[i5];
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
                        if (ThemeManager.eia() == ThemeManager.ThemeMode.NIGHT) {
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
                            textView2.setTextColor(Color.parseColor(Xr(color)));
                        }
                    } catch (Exception e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:color parse error");
                    }
                }
                this.ovG.addView(inflate, i5);
            }
            this.owk.removeAllViews();
            switch (this.owl.getMode()) {
                case 1:
                    while (true) {
                        int i6 = i2;
                        if (i6 >= this.owl.getLinks().size()) {
                            break;
                        } else {
                            this.owk.addView(new b(LayoutInflater.from(context), this.owl.getLinks().get(i6), this.owk, String.valueOf(i6 + 1)).mContentView);
                            i2 = i6 + 1;
                        }
                    }
                case 2:
                    a aVar = new a(LayoutInflater.from(context), this.owk);
                    aVar.a(this.owl.getImage());
                    this.owk.addView(aVar.getContentView());
                    break;
                case 3:
                    c cVar = new c(LayoutInflater.from(context), this.owk);
                    cVar.a(this.owl.getVideo());
                    this.owk.addView(cVar.getContentView());
                    break;
                default:
                    LogUtils.d("PushTemplateItem", "no foot");
                    break;
            }
        }
        efn();
        super.b(context, chatMsg);
    }

    private String Xr(String str) {
        if (ThemeManager.eia() == ThemeManager.ThemeMode.NIGHT) {
            return "#555555";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xs(String str) {
        new HashMap().put("subchain", str);
    }

    private float g(Context context, String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * i);
        return textPaint.measureText(str);
    }

    private void efn() {
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
                com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c XE = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egN().XE(com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egN().egO());
                if (XE != null) {
                    XE.gs(arrayList);
                }
            }
        });
    }

    /* loaded from: classes4.dex */
    private class b {
        private ImageView mArrow;
        private TextView mContentText;
        private View mContentView;
        private View own;
        private LinearLayout owo;
        private TextView owr;

        public b(LayoutInflater layoutInflater, TempletMsg.Link link, ViewGroup viewGroup, String str) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_label, viewGroup, false);
            this.own = this.mContentView.findViewById(a.f.bd_im_chating_template_link_dividing);
            this.mContentText = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_title);
            this.owr = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_detail);
            this.mArrow = (ImageView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_arrow);
            this.owo = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_link_item);
            efn();
            a(link, str);
        }

        private void efn() {
        }

        private void a(final TempletMsg.Link link, final String str) {
            this.mContentText.setText(link.getContent());
            if (TextUtils.isEmpty(link.getTitle())) {
                this.owr.setVisibility(8);
            } else {
                this.owr.setText(link.getTitle());
            }
            this.owo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().g(l.this.mContext, link.getUrl(), false);
                    l.this.Xs("text" + str);
                }
            });
            this.owo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.owl);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {
        View efX;
        TextView gmr;
        View mContentView;
        ImageView mImageView;
        TextView mTitle;
        View own;
        LinearLayout owo;

        public a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_media, viewGroup, false);
            this.mImageView = (ImageView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_display);
            this.mTitle = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_title);
            this.gmr = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_description);
            this.own = this.mContentView.findViewById(a.f.bd_im_chat_template_media_dividing);
            this.owo = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_media_item);
            this.efX = this.mContentView.findViewById(a.f.bd_im_chat_template_media_display_cover);
            efn();
        }

        protected void efn() {
        }

        public void a(final TempletMsg.Image image) {
            this.mTitle.setText(image.getTitle());
            this.gmr.setText(image.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.gK(l.this.mContext);
            ImageLoader.getInstance().displayImage(image.getImage(), this.mImageView);
            this.owo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().g(l.this.mContext, image.getUrl(), false);
                    l.this.Xs("image");
                }
            });
            this.owo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.owl);
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
        private TextView gmt;

        public c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater, viewGroup);
            this.gmt = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_video_time);
            this.gmt.setVisibility(0);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.l.a
        protected void efn() {
            super.efn();
            if (this.gmt != null) {
            }
        }

        public void a(final TempletMsg.Video video) {
            efn();
            this.mTitle.setText(video.getTitle());
            this.gmr.setText(video.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.gK(l.this.mContext);
            ImageLoader.getInstance().displayImage(video.getCover(), this.mImageView);
            this.gmt.setText(video.getDuration());
            this.owo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().g(l.this.mContext, video.getUrl(), false);
                    l.this.Xs("video");
                }
            });
            this.owo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.owl);
                    return true;
                }
            });
        }
    }
}
