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
    private static TbPageContext<BaseFragmentActivity> Mx;
    private String bIS;
    private bq bIY;
    private PersonPostModel bIZ;
    private final bq bJa = new g(this);
    private final b bJb = new h(this);
    private final String mUid;

    public f(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        Mx = tbPageContext;
        this.mUid = str;
    }

    public void a(bq bqVar) {
        this.bIY = bqVar;
    }

    public void ej(boolean z) {
        if (this.bIZ == null) {
            this.bIZ = new PersonPostModel(Mx);
        }
        this.bIZ.fetchPost(Mx, this.bJa, z, this.mUid, false);
    }

    public void abf() {
        if (this.bIZ != null) {
            this.bIZ.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bIZ == null || this.bIZ.post_list == null) {
            return 0;
        }
        return this.bIZ.post_list.size();
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
            iVar.bIO.setVisibility(0);
        } else {
            iVar.bIO.setVisibility(8);
        }
        a(i, iVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostList hs(int i) {
        return this.bIZ.post_list.get(i);
    }

    private void a(int i, i iVar, ViewGroup viewGroup) {
        PersonPostModel.PostList hs = hs(i);
        if (this.bIS == null) {
            this.bIS = hs.user_portrait;
        }
        iVar.a(hs, false, this.bIS);
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
        iVar.bJd.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(hs.title).find()) {
            iVar.bJe.setText(hs.title.replaceFirst("回复：", "原贴："));
        } else {
            iVar.bJe.setText(hs.title);
        }
        TextView textView = iVar.bJe;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(hs.thread_id);
        textView.setTag(strArr);
        bc.i((View) iVar.bJe, com.baidu.tieba.v.person_post_line);
        bc.b(iVar.bJe, com.baidu.tieba.t.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_post_reply_ori_padding);
        iVar.bJe.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        iVar.a(this.bJb);
        iVar.cs(TbadkCoreApplication.m255getInst().getSkinType());
    }
}
