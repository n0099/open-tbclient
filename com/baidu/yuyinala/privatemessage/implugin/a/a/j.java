package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.MultiGraphicTextMsg;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.DarkImageView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class j extends c {
    public View mContentView;
    public Context mContext;
    public View mConvertView;
    private TextView oMp;
    public LinearLayout oMs;

    @SuppressLint({"InflateParams"})
    public j(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_graphic_multi, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.oMc = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMd = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_title);
        this.oMp = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_content);
        this.oMe = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chating_push_image);
        this.oMs = (LinearLayout) this.mConvertView.findViewById(a.f.bd_im_chating_push_graph_multi);
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

    public static c f(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof j)) ? new j(context, layoutInflater) : (j) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(final Context context, final ChatMsg chatMsg) {
        Rect rect;
        final JSONArray jSONArray;
        if (chatMsg instanceof MultiGraphicTextMsg) {
            final MultiGraphicTextMsg multiGraphicTextMsg = (MultiGraphicTextMsg) chatMsg;
            this.oMe.getWindowVisibleDisplayFrame(new Rect());
            int width = (int) (rect.width() - (4.0f * context.getResources().getDimension(a.d.bd_im_push_lf)));
            ViewGroup.LayoutParams layoutParams = this.oMe.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) (width / com.baidu.yuyinala.privatemessage.implugin.util.a.b.oVA);
            this.oMe.setLayoutParams(layoutParams);
            this.oMd.setText(multiGraphicTextMsg.getArticles()[0].getTitle());
            this.oMp.setText(multiGraphicTextMsg.getArticles()[0].getDigest());
            String cover = multiGraphicTextMsg.getArticles()[0].getCover();
            com.baidu.yuyinala.privatemessage.implugin.util.b.hr(context);
            ImageLoader.getInstance().displayImage(cover, this.oMe, com.baidu.yuyinala.privatemessage.implugin.util.b.enR());
            try {
                jSONArray = new JSONArray(multiGraphicTextMsg.getExtLog());
            } catch (JSONException e) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushGraphicMultiItem", "getExtLog json error: " + e.getMessage());
                jSONArray = null;
            }
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("PushGraphicMultiItem", "mContentView is click");
                    if (!TextUtils.isEmpty(multiGraphicTextMsg.getArticles()[0].getSchema())) {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().g(context, Uri.parse(multiGraphicTextMsg.getArticles()[0].getSchema()));
                    } else if (!TextUtils.isEmpty(multiGraphicTextMsg.getArticles()[0].getArticleUrl())) {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().h(context, multiGraphicTextMsg.getArticles()[0].getArticleUrl(), false);
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        try {
                            jSONArray.get(0).toString();
                        } catch (JSONException e2) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushGraphicMultiItem", "getExtLog json error: " + e2.getMessage());
                        }
                    }
                }
            });
            this.mContentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.j.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    j.this.a(context, j.this.mContentView, chatMsg);
                    return true;
                }
            });
            MultiGraphicTextMsg.Article[] articleArr = new MultiGraphicTextMsg.Article[multiGraphicTextMsg.getArticles().length - 1];
            for (int i = 0; i < multiGraphicTextMsg.getArticles().length - 1; i++) {
                articleArr[i] = multiGraphicTextMsg.getArticles()[i + 1];
            }
            if (this.oMs != null && multiGraphicTextMsg.getArticles() != null) {
                this.oMs.removeAllViews();
                for (final int i2 = 0; i2 < articleArr.length; i2++) {
                    final MultiGraphicTextMsg.Article article = articleArr[i2];
                    boolean z = !TextUtils.isEmpty(article.getCover());
                    View inflate = View.inflate(context, z ? a.g.bd_im_chating_cell_push_graphic : a.g.bd_im_chating_cell_push_txt, null);
                    a aVar = new a();
                    aVar.title = (TextView) inflate.findViewById(a.f.bd_im_chating_push_text);
                    if (z) {
                        aVar.oMy = (DarkImageView) inflate.findViewById(a.f.bd_im_chating_push_image);
                    }
                    aVar.haY = (TextView) inflate.findViewById(a.f.bd_im_chating_push_image_content);
                    aVar.oMz = (RelativeLayout) inflate.findViewById(a.f.bd_im_chating_push_txt);
                    aVar.oMA = inflate.findViewById(a.f.bd_im_cell_seperator);
                    if (aVar != null && article != null) {
                        aVar.title.setText(article.getTitle());
                        aVar.haY.setText(article.getDigest());
                        if (z) {
                            com.baidu.yuyinala.privatemessage.implugin.util.b.hr(context);
                            ImageLoader.getInstance().displayImage(article.getCover(), aVar.oMy, com.baidu.yuyinala.privatemessage.implugin.util.b.enR());
                        }
                    }
                    this.oMs.addView(inflate, i2);
                    inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.j.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.i("PushGraphicMultiItem", i2 + "mContentView item is click");
                            if (!TextUtils.isEmpty(article.getSchema())) {
                                com.baidu.yuyinala.privatemessage.implugin.d.b.elh().g(context, Uri.parse(article.getSchema()));
                            } else if (!TextUtils.isEmpty(article.getArticleUrl())) {
                                com.baidu.yuyinala.privatemessage.implugin.d.b.elh().h(context, article.getArticleUrl(), false);
                            }
                            String str = "";
                            if (jSONArray != null && jSONArray.length() > i2 + 1) {
                                try {
                                    str = jSONArray.get(i2 + 1).toString();
                                } catch (JSONException e2) {
                                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("PushGraphicMultiItem", "getExtLog json error: " + e2.getMessage());
                                }
                            }
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hl(context.getApplicationContext()).e("416", "mutable_imageText_click", -1, str);
                        }
                    });
                    inflate.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.j.4
                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view) {
                            j.this.a(context, j.this.mContentView, chatMsg);
                            return true;
                        }
                    });
                }
            }
        }
        ekZ();
        super.b(context, chatMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, View view, ChatMsg chatMsg) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(chatMsg.getMsgId()));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(1, "删除"));
        com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
        bVar.a(context, view, arrayList2, 1);
        bVar.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.j.5
            @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
            public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar2, int i, int i2) {
                com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c YK = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emA().YK(com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emA().emB());
                if (YK != null) {
                    YK.gH(arrayList);
                }
            }
        });
    }

    /* loaded from: classes4.dex */
    private class a {
        TextView haY;
        View oMA;
        DarkImageView oMy;
        RelativeLayout oMz;
        TextView title;

        private a() {
        }
    }

    private void ekZ() {
    }
}
