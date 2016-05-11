package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private BdUniqueId aoj;
    private TbPageContext<BaseFragmentActivity> bbm;
    private String dEi;
    private PersonPostModel.a dEr;
    private PersonPostModel dEs;
    private final PersonPostModel.a dEt = new i(this);
    private final a.InterfaceC0070a dEu = new j(this);
    private final String mV;

    public h(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.bbm = tbPageContext;
        this.mV = str;
        this.aoj = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.dEr = aVar;
    }

    public void hr(boolean z) {
        if (this.dEs == null) {
            this.dEs = new PersonPostModel(this.bbm);
            this.dEs.setUniqueId(this.aoj);
        }
        this.dEs.fetchPost(this.bbm, this.dEt, z, this.mV, false);
    }

    public void aCR() {
        if (this.dEs != null) {
            this.dEs.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dEs == null || this.dEs.post_list == null) {
            return 0;
        }
        return this.dEs.post_list.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.bbm);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.dEf.setVisibility(0);
        } else {
            aVar.dEf.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList mA(int i) {
        return this.dEs.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList mA = mA(i);
        if (this.dEi == null) {
            this.dEi = mA.user_portrait;
        }
        aVar.a(mA, false, this.dEi);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = mA.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (mA.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!mA.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = mA.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(mA.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(mA.thread_id), String.valueOf(mA.content[i2].post_id), String.valueOf(mA.content[i2].post_type), ay.x(mA.content[i2].create_time * 1000), String.valueOf(mA.thread_type)});
            }
        }
        aVar.dEw.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(mA.title).find()) {
            aVar.dEx.setText(mA.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.dEx.setText(mA.title);
        }
        TextView textView = aVar.dEx;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(mA.thread_id);
        strArr[3] = String.valueOf(mA.thread_type);
        textView.setTag(strArr);
        if (mA.thread_type == 33) {
            aVar.dEx.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.dEx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        at.k(aVar.dEx, t.f.person_post_line);
        at.c(aVar.dEx, t.d.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(t.e.person_post_reply_ori_padding);
        aVar.dEx.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.dEu);
        aVar.cS(TbadkCoreApplication.m11getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View aOf;
        private View bottomLine;
        public ReplyLinearLayout dEw;
        public TextView dEx;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.dEw = (ReplyLinearLayout) view.findViewById(t.g.content_container);
            this.dEx = (TextView) view.findViewById(t.g.original_post_title);
            this.aOf = view.findViewById(t.g.reply_top_line);
            this.bottomLine = view.findViewById(t.g.reply_bottom_line);
            this.dEx.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cS(int i) {
            super.cS(i);
            at.k(this.dEx, t.d.cp_bg_line_e);
            at.c(this.dEx, t.d.cp_cont_b, 1);
            at.k(this.aOf, t.d.cp_bg_line_b);
            at.k(this.bottomLine, t.d.cp_bg_line_b);
        }
    }
}
