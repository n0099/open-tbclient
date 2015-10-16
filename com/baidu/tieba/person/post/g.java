package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<BaseFragmentActivity> aPm;
    private String crr;
    private PersonPostModel.a crx;
    private PersonPostModel cry;
    private final String wq;
    private final PersonPostModel.a crz = new h(this);
    private final a.InterfaceC0072a crA = new i(this);

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.aPm = tbPageContext;
        this.wq = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.crx = aVar;
    }

    public void eX(boolean z) {
        if (this.cry == null) {
            this.cry = new PersonPostModel(this.aPm);
        }
        this.cry.fetchPost(this.aPm, this.crz, z, this.wq, false);
    }

    public void aiX() {
        if (this.cry != null) {
            this.cry.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cry == null || this.cry.post_list == null) {
            return 0;
        }
        return this.cry.post_list.size();
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
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(i.g.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.aPm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.crn.setVisibility(0);
        } else {
            aVar.crn.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList jj(int i) {
        return this.cry.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList jj = jj(i);
        if (this.crr == null) {
            this.crr = jj.user_portrait;
        }
        aVar.a(jj, false, this.crr);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = jj.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (jj.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!jj.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = jj.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(jj.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(jj.thread_id), String.valueOf(jj.content[i2].post_id), String.valueOf(jj.content[i2].post_type), as.o(jj.content[i2].create_time * 1000), String.valueOf(jj.thread_type)});
            }
        }
        aVar.crC.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(jj.title).find()) {
            aVar.crD.setText(jj.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.crD.setText(jj.title);
        }
        TextView textView = aVar.crD;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(jj.thread_id);
        strArr[3] = String.valueOf(jj.thread_type);
        textView.setTag(strArr);
        if (jj.thread_type == 33) {
            aVar.crD.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.crD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        an.i((View) aVar.crD, i.e.person_post_line);
        an.b(aVar.crD, i.c.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(i.d.person_post_reply_ori_padding);
        aVar.crD.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.crA);
        aVar.cN(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View cfD;
        public ReplyLinearLayout crC;
        public TextView crD;
        private View crE;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.crC = (ReplyLinearLayout) view.findViewById(i.f.content_container);
            this.crD = (TextView) view.findViewById(i.f.original_post_title);
            this.cfD = view.findViewById(i.f.reply_top_line);
            this.crE = view.findViewById(i.f.reply_bottom_line);
            this.crD.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cN(int i) {
            super.cN(i);
            an.i((View) this.crD, i.c.cp_bg_line_e);
            an.b(this.crD, i.c.cp_cont_b, 1);
            an.i(this.cfD, i.c.cp_bg_line_b);
            an.i(this.crE, i.c.cp_bg_line_b);
        }
    }
}
