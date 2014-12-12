package com.baidu.tieba.person.post;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.br;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private static TbPageContext<BaseFragmentActivity> Me;
    private String bHh;
    private br bHn;
    private PersonPostModel bHo;
    private final br bHp = new h(this);
    private final b bHq = new i(this);
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        Me = tbPageContext;
        this.mUid = str;
    }

    public void a(br brVar) {
        this.bHn = brVar;
    }

    public void ed(boolean z) {
        if (this.bHo == null) {
            this.bHo = new PersonPostModel(Me);
        }
        this.bHo.fetchPost(Me, this.bHp, z, this.mUid, false);
    }

    public void aaF() {
        if (this.bHo != null) {
            this.bHo.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHo == null || this.bHo.post_list == null) {
            return 0;
        }
        return this.bHo.post_list.size();
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
            view = com.baidu.adp.lib.g.b.ek().a(viewGroup.getContext(), com.baidu.tieba.x.person_post_item_reply, viewGroup, false);
            jVar = new j(view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        if (i == 0) {
            jVar.bHd.setVisibility(0);
        } else {
            jVar.bHd.setVisibility(8);
        }
        a(i, jVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostList hj(int i) {
        return this.bHo.post_list.get(i);
    }

    private void a(int i, j jVar, ViewGroup viewGroup) {
        PersonPostModel.PostList hj = hj(i);
        if (this.bHh == null) {
            this.bHh = hj.user_portrait;
        }
        jVar.a(hj, false, this.bHh);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = hj.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (hj.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!hj.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = hj.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(hj.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(hj.thread_id), String.valueOf(hj.content[i2].post_id), String.valueOf(hj.content[i2].post_type), ba.n(hj.content[i2].create_time * 1000)});
            }
        }
        jVar.bHs.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(hj.title).find()) {
            jVar.bHt.setText(hj.title.replaceFirst("回复：", "原贴："));
        } else {
            jVar.bHt.setText(hj.title);
        }
        TextView textView = jVar.bHt;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(hj.thread_id);
        textView.setTag(strArr);
        ax.i((View) jVar.bHt, com.baidu.tieba.v.person_post_line);
        ax.b(jVar.bHt, com.baidu.tieba.t.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_post_reply_ori_padding);
        jVar.bHt.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        jVar.a(this.bHq);
        jVar.cl(TbadkCoreApplication.m255getInst().getSkinType());
    }
}
