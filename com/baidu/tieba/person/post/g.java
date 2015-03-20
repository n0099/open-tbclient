package com.baidu.tieba.person.post;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bo;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private static TbPageContext<BaseFragmentActivity> XE;
    private String bRe;
    private bo bRk;
    private PersonPostModel bRl;
    private final bo bRm = new h(this);
    private final b bRn = new i(this);
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        XE = tbPageContext;
        this.mUid = str;
    }

    public void a(bo boVar) {
        this.bRk = boVar;
    }

    public void eg(boolean z) {
        if (this.bRl == null) {
            this.bRl = new PersonPostModel(XE);
        }
        this.bRl.fetchPost(XE, this.bRm, z, this.mUid, false);
    }

    public void ads() {
        if (this.bRl != null) {
            this.bRl.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bRl == null || this.bRl.post_list == null) {
            return 0;
        }
        return this.bRl.post_list.size();
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
            view = com.baidu.adp.lib.g.b.hH().a(viewGroup.getContext(), com.baidu.tieba.w.person_post_item_reply, viewGroup, false);
            jVar = new j(view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        if (i == 0) {
            jVar.bRa.setVisibility(0);
        } else {
            jVar.bRa.setVisibility(8);
        }
        a(i, jVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostList hB(int i) {
        return this.bRl.post_list.get(i);
    }

    private void a(int i, j jVar, ViewGroup viewGroup) {
        PersonPostModel.PostList hB = hB(i);
        if (this.bRe == null) {
            this.bRe = hB.user_portrait;
        }
        jVar.a(hB, false, this.bRe);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = hB.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (hB.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!hB.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = hB.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(hB.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(hB.thread_id), String.valueOf(hB.content[i2].post_id), String.valueOf(hB.content[i2].post_type), bd.n(hB.content[i2].create_time * 1000)});
            }
        }
        jVar.bRp.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(hB.title).find()) {
            jVar.bRq.setText(hB.title.replaceFirst("回复：", "原贴："));
        } else {
            jVar.bRq.setText(hB.title);
        }
        TextView textView = jVar.bRq;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(hB.thread_id);
        textView.setTag(strArr);
        ba.i((View) jVar.bRq, com.baidu.tieba.u.person_post_line);
        ba.b(jVar.bRq, com.baidu.tieba.s.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_post_reply_ori_padding);
        jVar.bRq.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        jVar.a(this.bRn);
        jVar.ct(TbadkCoreApplication.m411getInst().getSkinType());
    }
}
