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
    public LinearLayout paQ;
    private TextView pba;
    private TextView pbb;
    private TextView pbc;
    private LinearLayout pbt;
    private LinearLayout pbu;
    private TempletMsg pbv;

    @SuppressLint({"InflateParams"})
    public l(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_template, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.pbt = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_push_content_item_view);
        this.paA = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.paB = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_title);
        this.pba = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_time);
        this.pbb = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_template_first);
        this.pbc = (TextView) this.mConvertView.findViewById(a.f.bd_im_template_remark);
        this.paQ = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_template_multi);
        this.pbu = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_template_footer);
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
            this.pbv = (TempletMsg) chatMsg;
            this.paB.setText(this.pbv.getTitle());
            this.pba.setText(com.baidu.yuyinala.privatemessage.implugin.util.f.h(context, this.pbv.getMsgTime()));
            if (TextUtils.isEmpty(this.pbv.getFirstName())) {
                this.pbb.setVisibility(8);
            } else {
                this.pbb.setText(this.pbv.getFirstName());
                this.pbb.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.pbv.getRemarkName())) {
                this.pbc.setVisibility(8);
            } else {
                this.pbc.setText(this.pbv.getRemarkName());
                this.pbc.setVisibility(0);
            }
            try {
                this.pbb.setTextColor(Color.parseColor(Yt(this.pbv.getFirstColor())));
            } catch (Exception e) {
                this.pbb.setTextColor(ThemeManager.U(this.mContext, a.c.send_text_item_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e.getMessage());
            }
            try {
                this.pbc.setTextColor(Color.parseColor(Yt(this.pbv.getRemarkColor())));
            } catch (Exception e2) {
                this.pbc.setTextColor(ThemeManager.U(this.mContext, a.c.template_time_txt_color));
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:" + e2.getMessage());
            }
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String detail = l.this.pbv.getDetail();
                    if (!TextUtils.isEmpty(detail)) {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().h(l.this.mContext, detail, false);
                        com.baidu.yuyinala.privatemessage.implugin.util.c.i("PushTemplateItem", "click is template");
                        l.this.Yu("mainpart");
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
            if (this.pbv.getCommodity() == null) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:getCommodity is null");
                return;
            }
            this.paQ.removeAllViews();
            TempletMsg.Commodity[] commodity = this.pbv.getCommodity();
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
            for (int i5 = 0; i5 < this.pbv.getCommodity().length; i5++) {
                TempletMsg.Commodity commodity3 = this.pbv.getCommodity()[i5];
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
                        if (ThemeManager.emG() == ThemeManager.ThemeMode.NIGHT) {
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
                            textView2.setTextColor(Color.parseColor(Yt(color)));
                        }
                    } catch (Exception e3) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushTemplate", "Error:color parse error");
                    }
                }
                this.paQ.addView(inflate, i5);
            }
            this.pbu.removeAllViews();
            switch (this.pbv.getMode()) {
                case 1:
                    while (true) {
                        int i6 = i2;
                        if (i6 >= this.pbv.getLinks().size()) {
                            break;
                        } else {
                            this.pbu.addView(new b(LayoutInflater.from(context), this.pbv.getLinks().get(i6), this.pbu, String.valueOf(i6 + 1)).mContentView);
                            i2 = i6 + 1;
                        }
                    }
                case 2:
                    a aVar = new a(LayoutInflater.from(context), this.pbu);
                    aVar.a(this.pbv.getImage());
                    this.pbu.addView(aVar.getContentView());
                    break;
                case 3:
                    c cVar = new c(LayoutInflater.from(context), this.pbu);
                    cVar.a(this.pbv.getVideo());
                    this.pbu.addView(cVar.getContentView());
                    break;
                default:
                    LogUtils.d("PushTemplateItem", "no foot");
                    break;
            }
        }
        ejW();
        super.b(context, chatMsg);
    }

    private String Yt(String str) {
        if (ThemeManager.emG() == ThemeManager.ThemeMode.NIGHT) {
            return "#555555";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yu(String str) {
        new HashMap().put("subchain", str);
    }

    private float h(Context context, String str, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * i);
        return textPaint.measureText(str);
    }

    private void ejW() {
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
                com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c YG = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.elv().YG(com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.elv().elw());
                if (YG != null) {
                    YG.gx(arrayList);
                }
            }
        });
    }

    /* loaded from: classes10.dex */
    private class b {
        private TextView hBJ;
        private ImageView mArrow;
        private View mContentView;
        private TextView pbB;
        private View pbx;
        private LinearLayout pby;

        public b(LayoutInflater layoutInflater, TempletMsg.Link link, ViewGroup viewGroup, String str) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_label, viewGroup, false);
            this.pbx = this.mContentView.findViewById(a.f.bd_im_chating_template_link_dividing);
            this.hBJ = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_title);
            this.pbB = (TextView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_detail);
            this.mArrow = (ImageView) this.mContentView.findViewById(a.f.bd_im_chating_template_link_arrow);
            this.pby = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_link_item);
            ejW();
            a(link, str);
        }

        private void ejW() {
        }

        private void a(final TempletMsg.Link link, final String str) {
            this.hBJ.setText(link.getContent());
            if (TextUtils.isEmpty(link.getTitle())) {
                this.pbB.setVisibility(8);
            } else {
                this.pbB.setText(link.getTitle());
            }
            this.pby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().h(l.this.mContext, link.getUrl(), false);
                    l.this.Yu("text" + str);
                }
            });
            this.pby.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.b.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.pbv);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        View etr;
        TextView gFj;
        View mContentView;
        ImageView mImageView;
        TextView mTitle;
        View pbx;
        LinearLayout pby;

        public a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            this.mContentView = layoutInflater.inflate(a.g.bd_im_chating_push_template_media, viewGroup, false);
            this.mImageView = (ImageView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_display);
            this.mTitle = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_title);
            this.gFj = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_media_description);
            this.pbx = this.mContentView.findViewById(a.f.bd_im_chat_template_media_dividing);
            this.pby = (LinearLayout) this.mContentView.findViewById(a.f.bd_im_chat_template_media_item);
            this.etr = this.mContentView.findViewById(a.f.bd_im_chat_template_media_display_cover);
            ejW();
        }

        protected void ejW() {
        }

        public void a(final TempletMsg.Image image) {
            this.mTitle.setText(image.getTitle());
            this.gFj.setText(image.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.hE(l.this.mContext);
            ImageLoader.getInstance().displayImage(image.getImage(), this.mImageView);
            this.pby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().h(l.this.mContext, image.getUrl(), false);
                    l.this.Yu("image");
                }
            });
            this.pby.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.a.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.pbv);
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
        private TextView gFl;

        public c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater, viewGroup);
            this.gFl = (TextView) this.mContentView.findViewById(a.f.bd_im_chat_template_video_time);
            this.gFl.setVisibility(0);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.l.a
        protected void ejW() {
            super.ejW();
            if (this.gFl != null) {
            }
        }

        public void a(final TempletMsg.Video video) {
            ejW();
            this.mTitle.setText(video.getTitle());
            this.gFj.setText(video.getDescription());
            com.baidu.yuyinala.privatemessage.implugin.util.b.hE(l.this.mContext);
            ImageLoader.getInstance().displayImage(video.getCover(), this.mImageView);
            this.gFl.setText(video.getDuration());
            this.pby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().h(l.this.mContext, video.getUrl(), false);
                    l.this.Yu("video");
                }
            });
            this.pby.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.l.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    l.this.a(l.this.mContext, l.this.mContentView, l.this.pbv);
                    return true;
                }
            });
        }
    }
}
