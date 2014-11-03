package com.baidu.tieba.person.post;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.person.post.PersonPostModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private String bDG;
    private g bDO;
    private PersonPostModel bDP;
    private final g bDQ = new i(this);
    private final b bDR = new j(this);
    private final Activity mActivity;
    private final String mUid;

    public h(Context context, String str, String str2) {
        this.mActivity = (Activity) context;
        this.mUid = str;
    }

    public void a(g gVar) {
        this.bDO = gVar;
    }

    public void ew(boolean z) {
        if (this.bDP == null) {
            this.bDP = new PersonPostModel(this.mActivity);
        }
        this.bDP.fetchPost(this.mActivity, this.bDQ, z, this.mUid, false);
    }

    public void aao() {
        if (this.bDP != null) {
            this.bDP.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bDP == null || this.bDP.post_list == null) {
            return 0;
        }
        return this.bDP.post_list.size();
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
            kVar.bDC.setVisibility(0);
        } else {
            kVar.bDC.setVisibility(8);
        }
        a(i, kVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostList ha(int i) {
        return this.bDP.post_list.get(i);
    }

    private void a(int i, k kVar, ViewGroup viewGroup) {
        PersonPostModel.PostList ha = ha(i);
        if (this.bDG == null) {
            this.bDG = ha.user_portrait;
        }
        kVar.a(ha, false, this.bDG);
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
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(ha.thread_id), String.valueOf(ha.content[i2].post_id), String.valueOf(ha.content[i2].post_type), az.j(ha.content[i2].create_time * 1000)});
            }
        }
        kVar.bDT.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(ha.title).find()) {
            kVar.bDU.setText(ha.title.replaceFirst("回复：", "原贴："));
        } else {
            kVar.bDU.setText(ha.title);
        }
        TextView textView = kVar.bDU;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(ha.thread_id);
        textView.setTag(strArr);
        aw.h((View) kVar.bDU, com.baidu.tieba.u.person_post_line);
        aw.b(kVar.bDU, com.baidu.tieba.s.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_post_reply_ori_padding);
        kVar.bDU.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        kVar.a(this.bDR);
        kVar.bM(TbadkApplication.m251getInst().getSkinType());
    }
}
