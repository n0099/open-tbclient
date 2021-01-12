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
/* loaded from: classes10.dex */
public class l extends com.baidu.yuyinala.privatemessage.implugin.a.a.c {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public LinearLayout oNY;
    private LinearLayout oOB;
    private LinearLayout oOC;
    private TempletMsg oOD;
    private TextView oOi;
    private TextView oOj;
    private TextView oOk;

    @SuppressLint({"InflateParams"})
    public l(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_template, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.oOB = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_push_content_item_view);
        this.oNI = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oNJ = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_title);
        this.oOi = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_time);
        this.oOj = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_first);
        this.oOk = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_remark);
        this.oNY = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_template_multi);
        this.oOC = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_template_footer);
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
            this.oOD = (TempletMsg) chatMsg;
            this.oNJ.setText(this.oOD.getTitle());
            this.oOi.setText(com.baidu.yuyinala.privatemessage.implugin.util.f.j(context, this.oOD.getMsgTime()));
            if (TextUtils.isEmpty(this.oOD.getFirstName())) {
                this.oOj.setVisibility(8);
            } else {
                this.oOj.setText(this.oOD.getFirstName());
                this.oOj.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.oOD.getRemarkName())) {
                this.oOk.setVisibility(8);
            } else {
                this.oOk.setText(this.oOD.getRemarkName());
                this.oOk.setVisibility(0);
            }
            try {
                this.oOj.setTextColor(Color.parseColor(WY(this.oOD.getFirstColor())));
            } catch (Exception e) {
                this.oOj.setTextColor(ThemeManager.U(this.mContext, a.c.send_text_item_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e.getMessage());
            }
            try {
                this.oOk.setTextColor(Color.parseColor(WY(this.oOD.getRemarkColor())));
            } catch (Exception e2) {
                this.oOk.setTextColor(ThemeManager.U(this.mContext, a.c.template_time_txt_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e2.getMessage());
            }
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String detail = l.this.oOD.getDetail();
                    if (!TextUtils.isEmpty(detail)) {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().h(l.this.mContext, detail, false);
                        com.baidu.yuyinala.privatemessage.implugin.util.c.i("PushTemplateItem", "click is template");
                        l.this.WZ("mainpart");
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
            if (this.oOD.getCommodity() == null) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:getCommodity is null");
                return;
            }
            this.oNY.removeAllViews();
            TempletMsg.Commodity[] commodity = this.oOD.getCommodity();
            int length = commodity.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                TempletMsg.Commodity commodity2 = commodity[i3];
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
            for (int i7 = 0; i7 < this.oOD.getCommodity().length; i7++) {
                TempletMsg.Commodity commodity3 = this.oOD.getCommodity()[i7];
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
                        if (ThemeManager.ejW() == ThemeManager.ThemeMode.NIGHT) {
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
                            textView2.setTextColor(Color.parseColor(WY(color)));
                        }
                    } catch (Exception e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:color parse error");
                    }
                }
                this.oNY.addView(inflate, i7);
            }
            this.oOC.removeAllViews();
            switch (this.oOD.getMode()) {
                case 1:
                    while (true) {
                        int i8 = i2;
                        if (i8 >= this.oOD.getLinks().size()) {
                            break;
                        } else {
                            this.oOC.addView(new b(LayoutInflater.from(context), this.oOD.getLinks().get(i8), this.oOC, String.valueOf(i8 + 1)).mContentView);
                            i2 = i8 + 1;
                        }
                    }
                case 2:
                    a aVar = new a(LayoutInflater.from(context), this.oOC);
                    aVar.a(this.oOD.getImage());
                    this.oOC.addView(aVar.getContentView());
                    break;
                case 3:
                    c cVar = new c(LayoutInflater.from(context), this.oOC);
                    cVar.a(this.oOD.getVideo());
                    this.oOC.addView(cVar.getContentView());
                    break;
                default:
                    LogUtils.d("PushTemplateItem", "no foot");
                    break;
            }
        }
        ehk();
        super.b(context, chatMsg);
    }

    private String WY(String str) {
        if (ThemeManager.ejW() == ThemeManager.ThemeMode.NIGHT) {
            return "#555555";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ(String str) {
        new HashMap().put("subchain", str);
    }

    private float i(Context context, String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * i);
        return textPaint.measureText(str);
    }

    private void ehk() {
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
                com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c Xl = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.eiJ().Xl(com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.eiJ().eiK());
                if (Xl != null) {
                    Xl.gz(arrayList);
                }
            }
        });
    }

    /* loaded from: classes10.dex */
    private class b {
        private TextView hvC;
        private ImageView mArrow;
        private View mContentView;
        private View oOF;
        private LinearLayout oOG;
        private TextView oOJ;

        public b(LayoutInflater layoutInflater, TempletMsg.Link link, ViewGroup viewGroup, String str) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_label, viewGroup, false);
            this.oOF = this.mContentView.findViewById(a.f.bd_im_chating_template_link_dividing);
            this.hvC = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_title);
            this.oOJ = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_detail);
            this.mArrow = (ImageView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_arrow);
            this.oOG = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_link_item);
            ehk();
            a(link, str);
        }

        private void ehk() {
        }

        private void a(final TempletMsg.Link link, final String str) {
            this.hvC.setText(link.getContent());
            if (TextUtils.isEmpty(link.getTitle())) {
                this.oOJ.setVisibility(8);
            } else {
                this.oOJ.setText(link.getTitle());
            }
            this.oOG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().h(l.this.mContext, link.getUrl(), false);
                    l.this.WZ("text" + str);
                }
            });
            this.oOG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.oOD);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        View epI;
        TextView gAC;
        View mContentView;
        ImageView mImageView;
        TextView mTitle;
        View oOF;
        LinearLayout oOG;

        public a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_media, viewGroup, false);
            this.mImageView = (ImageView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_display);
            this.mTitle = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_title);
            this.gAC = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_description);
            this.oOF = this.mContentView.findViewById(a.f.bd_im_chat_template_media_dividing);
            this.oOG = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_media_item);
            this.epI = this.mContentView.findViewById(a.f.bd_im_chat_template_media_display_cover);
            ehk();
        }

        protected void ehk() {
        }

        public void a(final TempletMsg.Image image) {
            this.mTitle.setText(image.getTitle());
            this.gAC.setText(image.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.hC(l.this.mContext);
            ImageLoader.getInstance().displayImage(image.getImage(), this.mImageView);
            this.oOG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().h(l.this.mContext, image.getUrl(), false);
                    l.this.WZ("image");
                }
            });
            this.oOG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.oOD);
                    return true;
                }
            });
        }

        public View getContentView() {
            return this.mContentView;
        }
    }

    /* loaded from: classes10.dex */
    private class c extends a {
        private TextView gAE;

        public c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater, viewGroup);
            this.gAE = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_video_time);
            this.gAE.setVisibility(0);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.l.a
        protected void ehk() {
            super.ehk();
            if (this.gAE != null) {
            }
        }

        public void a(final TempletMsg.Video video) {
            ehk();
            this.mTitle.setText(video.getTitle());
            this.gAC.setText(video.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.hC(l.this.mContext);
            ImageLoader.getInstance().displayImage(video.getCover(), this.mImageView);
            this.gAE.setText(video.getDuration());
            this.oOG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().h(l.this.mContext, video.getUrl(), false);
                    l.this.WZ("video");
                }
            });
            this.oOG.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.oOD);
                    return true;
                }
            });
        }
    }
}
