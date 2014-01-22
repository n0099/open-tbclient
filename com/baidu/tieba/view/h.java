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
public class h extends Dialog implements View.OnClickListener {
    private LinearLayout a;
    private Button b;
    private Context c;
    private List<j> d;
    private l e;
    private k f;
    private String g;
    private String h;

    public void a(String str) {
        this.g = str;
    }

    public void b(String str) {
        this.h = str;
    }

    public h(Context context, int i) {
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
        setContentView(R.layout.chatterbox_dialog);
        this.g = this.c.getResources().getString(R.string.chat_default_tip);
        this.h = null;
        this.b = (Button) findViewById(R.id.chatterbox_custom);
        this.b.setOnClickListener(new i(this));
        this.a = (LinearLayout) findViewById(R.id.chatterbox_layout);
        this.e = new l(this.c, R.style.NobackDialog);
    }

    public void a(k kVar) {
        this.f = kVar;
        this.e.a(kVar);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void a(List<ChatRoomTopicData> list) {
        LayoutInflater layoutInflater = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.a.removeAllViews();
        this.d.clear();
        j jVar = new j(this, layoutInflater);
        jVar.b(this.c.getResources().getString(R.string.chat_default_tip));
        jVar.a(this);
        this.d.add(jVar);
        this.a.addView(jVar.c());
        if (list != null) {
            int i = 0;
            Iterator<ChatRoomTopicData> it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    ChatRoomTopicData next = it.next();
                    j jVar2 = new j(this, layoutInflater);
                    jVar2.b(next.getTitle());
                    jVar2.a(next.getContent());
                    jVar2.a(this);
                    this.d.add(jVar2);
                    this.a.addView(jVar2.c());
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
        for (j jVar : this.d) {
            if (jVar.b() != null && jVar.b().equals(this.g)) {
                jVar.a(true);
            } else {
                jVar.a(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (j jVar : this.d) {
            if (jVar.a(view)) {
                jVar.a(true);
                this.g = jVar.b();
                this.h = jVar.a();
                i = i3;
            } else {
                jVar.a(false);
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
