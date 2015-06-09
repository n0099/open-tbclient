package com.baidu.tieba.person.post;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.ch;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private static TbPageContext<BaseFragmentActivity> Yt;
    private String bUa;
    private ch bUg;
    private PersonPostModel bUh;
    private final ch bUi = new h(this);
    private final b bUj = new i(this);
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        Yt = tbPageContext;
        this.mUid = str;
    }

    public void a(ch chVar) {
        this.bUg = chVar;
    }

    public void eq(boolean z) {
        if (this.bUh == null) {
            this.bUh = new PersonPostModel(Yt);
        }
        this.bUh.fetchPost(Yt, this.bUi, z, this.mUid, false);
    }

    public void aeP() {
        if (this.bUh != null) {
            this.bUh.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bUh == null || this.bUh.post_list == null) {
            return 0;
        }
        return this.bUh.post_list.size();
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
        j jVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().a(viewGroup.getContext(), com.baidu.tieba.r.person_post_item_reply, viewGroup, false);
            jVar = new j(view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        if (i == 0) {
            jVar.bTW.setVisibility(0);
        } else {
            jVar.bTW.setVisibility(8);
        }
        a(i, jVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostList hT(int i) {
        return this.bUh.post_list.get(i);
    }

    private void a(int i, j jVar, ViewGroup viewGroup) {
        PersonPostModel.PostList hT = hT(i);
        if (this.bUa == null) {
            this.bUa = hT.user_portrait;
        }
        jVar.a(hT, false, this.bUa);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = hT.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (hT.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!hT.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = hT.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(hT.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(hT.thread_id), String.valueOf(hT.content[i2].post_id), String.valueOf(hT.content[i2].post_type), bb.o(hT.content[i2].create_time * 1000)});
            }
        }
        jVar.bUl.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(hT.title).find()) {
            jVar.bUm.setText(hT.title.replaceFirst("回复：", "原贴："));
        } else {
            jVar.bUm.setText(hT.title);
        }
        TextView textView = jVar.bUm;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(hT.thread_id);
        textView.setTag(strArr);
        ay.i((View) jVar.bUm, com.baidu.tieba.p.person_post_line);
        ay.b(jVar.bUm, com.baidu.tieba.n.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.o.person_post_reply_ori_padding);
        jVar.bUm.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        jVar.a(this.bUj);
        jVar.cy(TbadkCoreApplication.m411getInst().getSkinType());
    }
}
