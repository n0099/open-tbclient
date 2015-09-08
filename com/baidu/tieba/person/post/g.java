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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<BaseFragmentActivity> adB;
    private String clC;
    private PersonPostModel.a clI;
    private PersonPostModel clJ;
    private final PersonPostModel.a clK = new h(this);
    private final a.InterfaceC0069a clL = new i(this);
    private final String wp;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.adB = tbPageContext;
        this.wp = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.clI = aVar;
    }

    public void eR(boolean z) {
        if (this.clJ == null) {
            this.clJ = new PersonPostModel(this.adB);
        }
        this.clJ.fetchPost(this.adB, this.clK, z, this.wp, false);
    }

    public void agX() {
        if (this.clJ != null) {
            this.clJ.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.clJ == null || this.clJ.post_list == null) {
            return 0;
        }
        return this.clJ.post_list.size();
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
            aVar = new a(view, this.adB);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.cly.setVisibility(0);
        } else {
            aVar.cly.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList iZ(int i) {
        return this.clJ.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList iZ = iZ(i);
        if (this.clC == null) {
            this.clC = iZ.user_portrait;
        }
        aVar.a(iZ, false, this.clC);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = iZ.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (iZ.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!iZ.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = iZ.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(iZ.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(iZ.thread_id), String.valueOf(iZ.content[i2].post_id), String.valueOf(iZ.content[i2].post_type), aq.m(iZ.content[i2].create_time * 1000), String.valueOf(iZ.thread_type)});
            }
        }
        aVar.clN.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(iZ.title).find()) {
            aVar.clO.setText(iZ.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.clO.setText(iZ.title);
        }
        TextView textView = aVar.clO;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(iZ.thread_id);
        strArr[3] = String.valueOf(iZ.thread_type);
        textView.setTag(strArr);
        if (iZ.thread_type == 33) {
            aVar.clO.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.clO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.h((View) aVar.clO, i.e.person_post_line);
        al.b(aVar.clO, i.c.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(i.d.person_post_reply_ori_padding);
        aVar.clO.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.clL);
        aVar.cM(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View can;
        public ReplyLinearLayout clN;
        public TextView clO;
        private View clP;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.clN = (ReplyLinearLayout) view.findViewById(i.f.content_container);
            this.clO = (TextView) view.findViewById(i.f.original_post_title);
            this.can = view.findViewById(i.f.reply_top_line);
            this.clP = view.findViewById(i.f.reply_bottom_line);
            this.clO.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cM(int i) {
            super.cM(i);
            al.h((View) this.clO, i.c.cp_bg_line_e);
            al.b(this.clO, i.c.cp_cont_b, 1);
            al.h(this.can, i.c.cp_bg_line_b);
            al.h(this.clP, i.c.cp_bg_line_b);
        }
    }
}
