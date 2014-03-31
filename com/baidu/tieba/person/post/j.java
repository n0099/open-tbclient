package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.person.post.PersonPostReplyModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class j extends BaseAdapter {
    private m a;
    private PersonPostReplyModel b;
    private final String c;
    private String d;
    private final Activity e;
    private final f f = new k(this);
    private final c g = new l(this);

    public j(Context context, String str) {
        this.e = (Activity) context;
        this.c = str;
    }

    public final void a(m mVar) {
        this.a = mVar;
    }

    public final void a(boolean z) {
        PersonPostReplyModel.fetchReply(this.f, z, this.c);
    }

    public final void a() {
        if (this.b != null) {
            this.b.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null || this.b.post_list == null) {
            return 0;
        }
        return this.b.post_list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.a.i.person_post_item_reply, viewGroup, false);
            n nVar2 = new n(view);
            view.setTag(nVar2);
            nVar = nVar2;
        } else {
            nVar = (n) view.getTag();
        }
        if (i == 0) {
            nVar.a.setVisibility(0);
        } else {
            nVar.a.setVisibility(8);
        }
        PersonPostReplyModel.Post post = this.b.post_list.get(i);
        if (this.d == null) {
            this.d = post.user_portrait;
        }
        nVar.a(post, this.d);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = post.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (post.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!post.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = post.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(post.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(post.thread_id), String.valueOf(post.content[i2].post_id), String.valueOf(post.content[i2].post_type), bc.a(post.content[i2].create_time * 1000)});
            }
        }
        nVar.g.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(post.title).find()) {
            nVar.h.setText(post.title.replaceFirst("回复：", "原贴："));
        } else {
            nVar.h.setText(post.title);
        }
        TextView textView = nVar.h;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(post.thread_id);
        textView.setTag(strArr);
        if (TbadkApplication.j().l() == 1) {
            nVar.h.setTextColor(viewGroup.getResources().getColor(com.baidu.tieba.a.e.person_post_content_ori_1));
            nVar.h.setBackgroundResource(com.baidu.tieba.a.g.person_post_line_1);
        } else {
            nVar.h.setTextColor(viewGroup.getResources().getColor(com.baidu.tieba.a.e.person_post_content_ori));
            nVar.h.setBackgroundResource(com.baidu.tieba.a.g.person_post_line);
        }
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.person_post_reply_ori_padding);
        nVar.h.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        nVar.a(this.g);
        nVar.a(TbadkApplication.j().l());
        return view;
    }
}
