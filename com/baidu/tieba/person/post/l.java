package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.person.post.PersonPostReplyModel;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private o a;
    private PersonPostReplyModel b;
    private String c;
    private String d;
    private Activity e;
    private f f = new m(this);
    private c g = new n(this);

    public l(Context context, String str, String str2) {
        this.e = (Activity) context;
        this.c = str;
    }

    public void a(o oVar) {
        this.a = oVar;
    }

    public void a(boolean z) {
        PersonPostReplyModel.fetchReply(this.f, z, this.c);
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
        p pVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
            pVar = new p(view);
            view.setTag(pVar);
        } else {
            pVar = (p) view.getTag();
        }
        if (i == 0) {
            pVar.a.setVisibility(0);
        } else {
            pVar.a.setVisibility(8);
        }
        a(i, pVar, viewGroup);
        return view;
    }

    private PersonPostReplyModel.Post a(int i) {
        return this.b.post_list.get(i);
    }

    private void a(int i, p pVar, ViewGroup viewGroup) {
        PersonPostReplyModel.Post a = a(i);
        if (this.d == null) {
            this.d = a.user_portrait;
        }
        pVar.a(a, this.d);
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
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(a.thread_id), String.valueOf(a.content[i2].post_id), String.valueOf(a.content[i2].post_type), bs.a(a.content[i2].create_time * 1000)});
            }
        }
        pVar.g.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(a.title).find()) {
            pVar.h.setText(a.title.replaceFirst("回复：", "原贴："));
        } else {
            pVar.h.setText(a.title);
        }
        TextView textView = pVar.h;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(a.thread_id);
        textView.setTag(strArr);
        if (TiebaApplication.g().al() == 1) {
            pVar.h.setTextColor(viewGroup.getResources().getColor(R.color.person_post_content_ori_1));
            pVar.h.setBackgroundResource(R.drawable.person_post_line_1);
        } else {
            pVar.h.setTextColor(viewGroup.getResources().getColor(R.color.person_post_content_ori));
            pVar.h.setBackgroundResource(R.drawable.person_post_line);
        }
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.person_post_reply_ori_padding);
        pVar.h.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        pVar.a(this.g);
        pVar.a(TiebaApplication.g().al());
    }
}
