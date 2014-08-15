package com.baidu.tieba.im.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.im.data.ChatRoomTopicData;
import com.baidu.tieba.x;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends Dialog implements View.OnClickListener {
    private LinearLayout a;
    private Button b;
    private Context c;
    private List<c> d;
    private e e;
    private d f;
    private String g;
    private String h;

    public void a(String str) {
        this.g = str;
    }

    public void b(String str) {
        this.h = str;
    }

    public a(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = new ArrayList();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.c = context;
        a();
    }

    private void a() {
        setContentView(com.baidu.tieba.v.chatterbox_dialog);
        this.g = this.c.getResources().getString(x.chat_default_tip);
        this.h = null;
        this.b = (Button) findViewById(com.baidu.tieba.u.chatterbox_custom);
        this.b.setOnClickListener(new b(this));
        this.a = (LinearLayout) findViewById(com.baidu.tieba.u.chatterbox_layout);
        this.e = new e(this.c, y.NobackDialog);
    }

    public void a(d dVar) {
        this.f = dVar;
        this.e.a(dVar);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void a(List<ChatRoomTopicData> list) {
        LayoutInflater layoutInflater = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.a.removeAllViews();
        this.d.clear();
        c cVar = new c(this, layoutInflater);
        cVar.b(this.c.getResources().getString(x.chat_default_tip));
        cVar.a(this);
        this.d.add(cVar);
        this.a.addView(cVar.c());
        if (list != null) {
            int i = 0;
            Iterator<ChatRoomTopicData> it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    ChatRoomTopicData next = it.next();
                    c cVar2 = new c(this, layoutInflater);
                    cVar2.b(next.getTitle());
                    cVar2.a(next.getContent());
                    cVar2.a(this);
                    this.d.add(cVar2);
                    this.a.addView(cVar2.c());
                    i = i2 + 1;
                    if (i >= 4) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (!(this.c instanceof Activity) || com.baidu.adp.lib.e.d.a((Activity) this.c)) {
            super.show();
            if (TextUtils.isEmpty(this.g)) {
                if (this.d != null && this.d.size() > 0) {
                    this.d.get(0).a(true);
                    for (int i = 1; i < this.d.size(); i++) {
                        this.d.get(i).a(false);
                    }
                    return;
                }
                return;
            }
            for (c cVar : this.d) {
                if (cVar.b() != null && cVar.b().equals(this.g)) {
                    cVar.a(true);
                } else {
                    cVar.a(false);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (c cVar : this.d) {
            if (cVar.a(view)) {
                cVar.a(true);
                this.g = cVar.b();
                this.h = cVar.a();
                i = i3;
            } else {
                cVar.a(false);
                i = i2;
            }
            i3++;
            i2 = i;
        }
        if (this.f != null) {
            this.f.a(this.g, this.h, i2 == 0);
        }
        cancel();
    }
}
