package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.person.post.PersonPostReplyModel;
import com.baidu.tieba.util.bu;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private m a;
    private PersonPostReplyModel b;
    private String c;
    private String d;
    private Activity e;
    private e f = new k(this);
    private c g = new l(this);

    public j(Context context, String str, String str2) {
        this.e = (Activity) context;
        this.c = str;
    }

    public void a(m mVar) {
        this.a = mVar;
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
        n nVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
            nVar = new n(view);
            view.setTag(nVar);
        } else {
            nVar = (n) view.getTag();
        }
        if (i == 0) {
            nVar.a.setVisibility(0);
        } else {
            nVar.a.setVisibility(8);
        }
        a(i, nVar, viewGroup);
        return view;
    }

    private PersonPostReplyModel.Post a(int i) {
        return this.b.post_list.get(i);
    }

    private void a(int i, n nVar, ViewGroup viewGroup) {
        PersonPostReplyModel.Post a = a(i);
        if (this.d == null) {
            this.d = a.user_portrait;
        }
        nVar.a(a, this.d);
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
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(a.thread_id), String.valueOf(a.content[i2].post_id), String.valueOf(a.content[i2].post_type), bu.a(a.content[i2].create_time * 1000)});
            }
        }
        nVar.g.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(a.title).find()) {
            nVar.h.setText(a.title.replaceFirst("回复：", "原贴："));
        } else {
            nVar.h.setText(a.title);
        }
        nVar.h.setTag(new String[]{String.valueOf(a.thread_id), null, null});
        if (TiebaApplication.h().al() == 1) {
            nVar.h.setTextColor(viewGroup.getResources().getColor(R.color.person_post_content_ori_1));
            nVar.h.setBackgroundResource(R.drawable.person_post_line_1);
        } else {
            nVar.h.setTextColor(viewGroup.getResources().getColor(R.color.person_post_content_ori));
            nVar.h.setBackgroundResource(R.drawable.person_post_line);
        }
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.person_post_reply_ori_padding);
        nVar.h.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        nVar.a(this.g);
        nVar.a(TiebaApplication.h().al());
    }
}
