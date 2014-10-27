package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.person.post.PersonPostModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private g bDA;
    private PersonPostModel bDB;
    private final g bDC = new i(this);
    private final b bDD = new j(this);
    private String bDs;
    private final Activity mActivity;
    private final String mUid;

    public h(Context context, String str, String str2) {
        this.mActivity = (Activity) context;
        this.mUid = str;
    }

    public void a(g gVar) {
        this.bDA = gVar;
    }

    public void ew(boolean z) {
        if (this.bDB == null) {
            this.bDB = new PersonPostModel(this.mActivity);
        }
        this.bDB.fetchPost(this.mActivity, this.bDC, z, this.mUid, false);
    }

    public void aam() {
        if (this.bDB != null) {
            this.bDB.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bDB == null || this.bDB.post_list == null) {
            return 0;
        }
        return this.bDB.post_list.size();
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
            view = com.baidu.adp.lib.g.b.ek().a(viewGroup.getContext(), com.baidu.tieba.w.person_post_item_reply, viewGroup, false);
            kVar = new k(view);
            view.setTag(kVar);
        } else {
            kVar = (k) view.getTag();
        }
        if (i == 0) {
            kVar.bDo.setVisibility(0);
        } else {
            kVar.bDo.setVisibility(8);
        }
        a(i, kVar, viewGroup);
        return view;
    }

    private PersonPostModel.PostList ha(int i) {
        return this.bDB.post_list.get(i);
    }

    private void a(int i, k kVar, ViewGroup viewGroup) {
        PersonPostModel.PostList ha = ha(i);
        if (this.bDs == null) {
            this.bDs = ha.user_portrait;
        }
        kVar.a(ha, false, this.bDs);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = ha.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (ha.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!ha.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = ha.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(ha.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(ha.thread_id), String.valueOf(ha.content[i2].post_id), String.valueOf(ha.content[i2].post_type), ay.j(ha.content[i2].create_time * 1000)});
            }
        }
        kVar.bDF.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(ha.title).find()) {
            kVar.bDG.setText(ha.title.replaceFirst("回复：", "原贴："));
        } else {
            kVar.bDG.setText(ha.title);
        }
        TextView textView = kVar.bDG;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(ha.thread_id);
        textView.setTag(strArr);
        aw.h((View) kVar.bDG, com.baidu.tieba.u.person_post_line);
        aw.b(kVar.bDG, com.baidu.tieba.s.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_post_reply_ori_padding);
        kVar.bDG.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        kVar.a(this.bDD);
        kVar.bM(TbadkApplication.m251getInst().getSkinType());
    }
}
