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
    private static TbPageContext<BaseFragmentActivity> XG;
    private bo bRA;
    private PersonPostModel bRB;
    private final bo bRC = new h(this);
    private final b bRD = new i(this);
    private String bRu;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        XG = tbPageContext;
        this.mUid = str;
    }

    public void a(bo boVar) {
        this.bRA = boVar;
    }

    public void ee(boolean z) {
        if (this.bRB == null) {
            this.bRB = new PersonPostModel(XG);
        }
        this.bRB.fetchPost(XG, this.bRC, z, this.mUid, false);
    }

    public void adH() {
        if (this.bRB != null) {
            this.bRB.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bRB == null || this.bRB.post_list == null) {
            return 0;
        }
        return this.bRB.post_list.size();
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
            jVar.bRq.setVisibility(0);
        } else {
            jVar.bRq.setVisibility(8);
        }
        a(i, jVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostList hE(int i) {
        return this.bRB.post_list.get(i);
    }

    private void a(int i, j jVar, ViewGroup viewGroup) {
        PersonPostModel.PostList hE = hE(i);
        if (this.bRu == null) {
            this.bRu = hE.user_portrait;
        }
        jVar.a(hE, false, this.bRu);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = hE.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (hE.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!hE.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = hE.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(hE.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(hE.thread_id), String.valueOf(hE.content[i2].post_id), String.valueOf(hE.content[i2].post_type), bd.n(hE.content[i2].create_time * 1000)});
            }
        }
        jVar.bRF.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(hE.title).find()) {
            jVar.bRG.setText(hE.title.replaceFirst("回复：", "原贴："));
        } else {
            jVar.bRG.setText(hE.title);
        }
        TextView textView = jVar.bRG;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(hE.thread_id);
        textView.setTag(strArr);
        ba.i((View) jVar.bRG, com.baidu.tieba.u.person_post_line);
        ba.b(jVar.bRG, com.baidu.tieba.s.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_post_reply_ori_padding);
        jVar.bRG.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        jVar.a(this.bRD);
        jVar.ct(TbadkCoreApplication.m411getInst().getSkinType());
    }
}
