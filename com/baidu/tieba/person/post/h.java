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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<BaseFragmentActivity> baN;
    private String dgC;
    private PersonPostModel.a dgJ;
    private PersonPostModel dgK;
    private final PersonPostModel.a dgL = new i(this);
    private final a.InterfaceC0080a dgM = new j(this);
    private final String wH;

    public h(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.baN = tbPageContext;
        this.wH = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.dgJ = aVar;
    }

    public void fY(boolean z) {
        if (this.dgK == null) {
            this.dgK = new PersonPostModel(this.baN);
        }
        this.dgK.fetchPost(this.baN, this.dgL, z, this.wH, false);
    }

    public void auS() {
        if (this.dgK != null) {
            this.dgK.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dgK == null || this.dgK.post_list == null) {
            return 0;
        }
        return this.dgK.post_list.size();
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
            aVar = new a(view, this.baN);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.dgy.setVisibility(0);
        } else {
            aVar.dgy.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList lA(int i) {
        return this.dgK.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList lA = lA(i);
        if (this.dgC == null) {
            this.dgC = lA.user_portrait;
        }
        aVar.a(lA, false, this.dgC);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = lA.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (lA.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!lA.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = lA.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(lA.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(lA.thread_id), String.valueOf(lA.content[i2].post_id), String.valueOf(lA.content[i2].post_type), aw.t(lA.content[i2].create_time * 1000), String.valueOf(lA.thread_type)});
            }
        }
        aVar.dgO.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(lA.title).find()) {
            aVar.dgP.setText(lA.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.dgP.setText(lA.title);
        }
        TextView textView = aVar.dgP;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(lA.thread_id);
        strArr[3] = String.valueOf(lA.thread_type);
        textView.setTag(strArr);
        if (lA.thread_type == 33) {
            aVar.dgP.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.dgP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ar.k(aVar.dgP, t.f.person_post_line);
        ar.b(aVar.dgP, t.d.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(t.e.person_post_reply_ori_padding);
        aVar.dgP.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.dgM);
        aVar.dg(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View aOS;
        private View aRd;
        public ReplyLinearLayout dgO;
        public TextView dgP;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.dgO = (ReplyLinearLayout) view.findViewById(t.g.content_container);
            this.dgP = (TextView) view.findViewById(t.g.original_post_title);
            this.aOS = view.findViewById(t.g.reply_top_line);
            this.aRd = view.findViewById(t.g.reply_bottom_line);
            this.dgP.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void dg(int i) {
            super.dg(i);
            ar.k(this.dgP, t.d.cp_bg_line_e);
            ar.b(this.dgP, t.d.cp_cont_b, 1);
            ar.k(this.aOS, t.d.cp_bg_line_b);
            ar.k(this.aRd, t.d.cp_bg_line_b);
        }
    }
}
