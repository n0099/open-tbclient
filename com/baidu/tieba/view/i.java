package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.im.data.ChatRoomTopicData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class i extends Dialog implements View.OnClickListener {
    private LinearLayout a;
    private Button b;
    private Context c;
    private List<k> d;
    private m e;
    private l f;
    private String g;
    private String h;

    public final void a(String str) {
        this.g = str;
    }

    public final void b(String str) {
        this.h = str;
    }

    public i(Context context, int i) {
        super(context, R.style.NobackDialog);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = new ArrayList();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.c = context;
        setContentView(R.layout.chatterbox_dialog);
        this.g = this.c.getResources().getString(R.string.chat_default_tip);
        this.h = null;
        this.b = (Button) findViewById(R.id.chatterbox_custom);
        this.b.setOnClickListener(new j(this));
        this.a = (LinearLayout) findViewById(R.id.chatterbox_layout);
        this.e = new m(this.c, R.style.NobackDialog);
    }

    public final void a(l lVar) {
        this.f = lVar;
        this.e.a(lVar);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void a(List<ChatRoomTopicData> list) {
        LayoutInflater layoutInflater = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.a.removeAllViews();
        this.d.clear();
        k kVar = new k(this, layoutInflater);
        kVar.b(this.c.getResources().getString(R.string.chat_default_tip));
        kVar.a(this);
        this.d.add(kVar);
        this.a.addView(kVar.c());
        if (list != null) {
            int i = 0;
            Iterator<ChatRoomTopicData> it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    ChatRoomTopicData next = it.next();
                    k kVar2 = new k(this, layoutInflater);
                    kVar2.b(next.getTitle());
                    kVar2.a(next.getContent());
                    kVar2.a(this);
                    this.d.add(kVar2);
                    this.a.addView(kVar2.c());
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
    public final void show() {
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
        for (k kVar : this.d) {
            if (kVar.b() != null && kVar.b().equals(this.g)) {
                kVar.a(true);
            } else {
                kVar.a(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (k kVar : this.d) {
            if (kVar.a(view)) {
                kVar.a(true);
                this.g = kVar.b();
                this.h = kVar.a();
                i = i3;
            } else {
                kVar.a(false);
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
