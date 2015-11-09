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
    private TbPageContext<BaseFragmentActivity> aPu;
    private String csN;
    private PersonPostModel.a csT;
    private PersonPostModel csU;
    private final PersonPostModel.a csV = new h(this);
    private final a.InterfaceC0073a csW = new i(this);
    private final String wq;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.aPu = tbPageContext;
        this.wq = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.csT = aVar;
    }

    public void fa(boolean z) {
        if (this.csU == null) {
            this.csU = new PersonPostModel(this.aPu);
        }
        this.csU.fetchPost(this.aPu, this.csV, z, this.wq, false);
    }

    public void ajz() {
        if (this.csU != null) {
            this.csU.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.csU == null || this.csU.post_list == null) {
            return 0;
        }
        return this.csU.post_list.size();
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
            aVar = new a(view, this.aPu);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.csJ.setVisibility(0);
        } else {
            aVar.csJ.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList jx(int i) {
        return this.csU.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList jx = jx(i);
        if (this.csN == null) {
            this.csN = jx.user_portrait;
        }
        aVar.a(jx, false, this.csN);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = jx.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (jx.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!jx.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = jx.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(jx.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(jx.thread_id), String.valueOf(jx.content[i2].post_id), String.valueOf(jx.content[i2].post_type), as.m(jx.content[i2].create_time * 1000), String.valueOf(jx.thread_type)});
            }
        }
        aVar.csY.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(jx.title).find()) {
            aVar.csZ.setText(jx.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.csZ.setText(jx.title);
        }
        TextView textView = aVar.csZ;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(jx.thread_id);
        strArr[3] = String.valueOf(jx.thread_type);
        textView.setTag(strArr);
        if (jx.thread_type == 33) {
            aVar.csZ.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.csZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        an.i((View) aVar.csZ, i.e.person_post_line);
        an.b(aVar.csZ, i.c.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(i.d.person_post_reply_ori_padding);
        aVar.csZ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.csW);
        aVar.cN(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View cge;
        public ReplyLinearLayout csY;
        public TextView csZ;
        private View cta;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.csY = (ReplyLinearLayout) view.findViewById(i.f.content_container);
            this.csZ = (TextView) view.findViewById(i.f.original_post_title);
            this.cge = view.findViewById(i.f.reply_top_line);
            this.cta = view.findViewById(i.f.reply_bottom_line);
            this.csZ.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cN(int i) {
            super.cN(i);
            an.i((View) this.csZ, i.c.cp_bg_line_e);
            an.b(this.csZ, i.c.cp_cont_b, 1);
            an.i(this.cge, i.c.cp_bg_line_b);
            an.i(this.cta, i.c.cp_bg_line_b);
        }
    }
}
