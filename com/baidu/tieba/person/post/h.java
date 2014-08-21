package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.person.post.PersonPostModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private g a;
    private PersonPostModel b;
    private final String c;
    private String d;
    private final Activity e;
    private final g f = new i(this);
    private final b g = new j(this);

    public h(Context context, String str, String str2) {
        this.e = (Activity) context;
        this.c = str;
    }

    public void a(g gVar) {
        this.a = gVar;
    }

    public void a(boolean z) {
        if (this.b == null) {
            this.b = new PersonPostModel();
        }
        this.b.fetchPost(this.e, this.f, z, this.c, false);
    }

    public void a() {
        if (this.b != null) {
            this.b.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.post_list == null) {
            return 0;
        }
        return this.b.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        if (view == null) {
            view = com.baidu.adp.lib.e.b.a().a(viewGroup.getContext(), com.baidu.tieba.v.person_post_item_reply, viewGroup, false);
            kVar = new k(view);
            view.setTag(kVar);
        } else {
            kVar = (k) view.getTag();
        }
        if (i == 0) {
            kVar.a.setVisibility(0);
        } else {
            kVar.a.setVisibility(8);
        }
        a(i, kVar, viewGroup);
        return view;
    }

    private PersonPostModel.PostList a(int i) {
        return this.b.post_list.get(i);
    }

    private void a(int i, k kVar, ViewGroup viewGroup) {
        PersonPostModel.PostList a = a(i);
        if (this.d == null) {
            this.d = a.user_portrait;
        }
        kVar.a(a, false, this.d);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = a.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (a.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!a.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = a.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(a.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(a.thread_id), String.valueOf(a.content[i2].post_id), String.valueOf(a.content[i2].post_type), ba.a(a.content[i2].create_time * 1000)});
            }
        }
        kVar.g.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(a.title).find()) {
            kVar.h.setText(a.title.replaceFirst("回复：", "原贴："));
        } else {
            kVar.h.setText(a.title);
        }
        TextView textView = kVar.h;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(a.thread_id);
        textView.setTag(strArr);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            kVar.h.setTextColor(viewGroup.getResources().getColor(com.baidu.tieba.r.person_post_content_ori_1));
            kVar.h.setBackgroundResource(com.baidu.tieba.t.person_post_line_1);
        } else {
            kVar.h.setTextColor(viewGroup.getResources().getColor(com.baidu.tieba.r.person_post_content_ori));
            kVar.h.setBackgroundResource(com.baidu.tieba.t.person_post_line);
        }
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.s.person_post_reply_ori_padding);
        kVar.h.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        kVar.a(this.g);
        kVar.a(TbadkApplication.m252getInst().getSkinType());
    }
}
