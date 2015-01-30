package com.baidu.tieba.person.post;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bq;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private static TbPageContext<BaseFragmentActivity> MA;
    private String bIT;
    private bq bIZ;
    private PersonPostModel bJa;
    private final bq bJb = new g(this);
    private final b bJc = new h(this);
    private final String mUid;

    public f(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        MA = tbPageContext;
        this.mUid = str;
    }

    public void a(bq bqVar) {
        this.bIZ = bqVar;
    }

    public void ej(boolean z) {
        if (this.bJa == null) {
            this.bJa = new PersonPostModel(MA);
        }
        this.bJa.fetchPost(MA, this.bJb, z, this.mUid, false);
    }

    public void abk() {
        if (this.bJa != null) {
            this.bJa.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bJa == null || this.bJa.post_list == null) {
            return 0;
        }
        return this.bJa.post_list.size();
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
        i iVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().a(viewGroup.getContext(), com.baidu.tieba.x.person_post_item_reply, viewGroup, false);
            iVar = new i(view);
            view.setTag(iVar);
        } else {
            iVar = (i) view.getTag();
        }
        if (i == 0) {
            iVar.bIP.setVisibility(0);
        } else {
            iVar.bIP.setVisibility(8);
        }
        a(i, iVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostList hs(int i) {
        return this.bJa.post_list.get(i);
    }

    private void a(int i, i iVar, ViewGroup viewGroup) {
        PersonPostModel.PostList hs = hs(i);
        if (this.bIT == null) {
            this.bIT = hs.user_portrait;
        }
        iVar.a(hs, false, this.bIT);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = hs.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (hs.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!hs.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = hs.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(hs.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(hs.thread_id), String.valueOf(hs.content[i2].post_id), String.valueOf(hs.content[i2].post_type), bf.n(hs.content[i2].create_time * 1000)});
            }
        }
        iVar.bJe.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(hs.title).find()) {
            iVar.bJf.setText(hs.title.replaceFirst("回复：", "原贴："));
        } else {
            iVar.bJf.setText(hs.title);
        }
        TextView textView = iVar.bJf;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(hs.thread_id);
        textView.setTag(strArr);
        bc.i((View) iVar.bJf, com.baidu.tieba.v.person_post_line);
        bc.b(iVar.bJf, com.baidu.tieba.t.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_post_reply_ori_padding);
        iVar.bJf.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        iVar.a(this.bJc);
        iVar.cs(TbadkCoreApplication.m255getInst().getSkinType());
    }
}
