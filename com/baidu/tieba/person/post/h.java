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
    private TbPageContext<BaseFragmentActivity> bfx;
    private String dBb;
    private PersonPostModel.a dBi;
    private PersonPostModel dBj;
    private BdUniqueId dBk;
    private final PersonPostModel.a dBl = new i(this);
    private final a.InterfaceC0077a dBm = new j(this);
    private final String wY;

    public h(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.bfx = tbPageContext;
        this.wY = str;
        this.dBk = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.dBi = aVar;
    }

    public void gL(boolean z) {
        if (this.dBj == null) {
            this.dBj = new PersonPostModel(this.bfx);
            this.dBj.setUniqueId(this.dBk);
        }
        this.dBj.fetchPost(this.bfx, this.dBl, z, this.wY, false);
    }

    public void aCy() {
        if (this.dBj != null) {
            this.dBj.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dBj == null || this.dBj.post_list == null) {
            return 0;
        }
        return this.dBj.post_list.size();
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
            aVar = new a(view, this.bfx);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.dAY.setVisibility(0);
        } else {
            aVar.dAY.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList mJ(int i) {
        return this.dBj.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList mJ = mJ(i);
        if (this.dBb == null) {
            this.dBb = mJ.user_portrait;
        }
        aVar.a(mJ, false, this.dBb);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = mJ.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (mJ.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!mJ.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = mJ.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(mJ.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(mJ.thread_id), String.valueOf(mJ.content[i2].post_id), String.valueOf(mJ.content[i2].post_type), ay.w(mJ.content[i2].create_time * 1000), String.valueOf(mJ.thread_type)});
            }
        }
        aVar.dBo.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(mJ.title).find()) {
            aVar.dBp.setText(mJ.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.dBp.setText(mJ.title);
        }
        TextView textView = aVar.dBp;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(mJ.thread_id);
        strArr[3] = String.valueOf(mJ.thread_type);
        textView.setTag(strArr);
        if (mJ.thread_type == 33) {
            aVar.dBp.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.dBp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        at.k(aVar.dBp, t.f.person_post_line);
        at.b(aVar.dBp, t.d.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(t.e.person_post_reply_ori_padding);
        aVar.dBp.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.dBm);
        aVar.dj(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View aRI;
        private View aUK;
        public ReplyLinearLayout dBo;
        public TextView dBp;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.dBo = (ReplyLinearLayout) view.findViewById(t.g.content_container);
            this.dBp = (TextView) view.findViewById(t.g.original_post_title);
            this.aRI = view.findViewById(t.g.reply_top_line);
            this.aUK = view.findViewById(t.g.reply_bottom_line);
            this.dBp.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void dj(int i) {
            super.dj(i);
            at.k(this.dBp, t.d.cp_bg_line_e);
            at.b(this.dBp, t.d.cp_cont_b, 1);
            at.k(this.aRI, t.d.cp_bg_line_b);
            at.k(this.aUK, t.d.cp_bg_line_b);
        }
    }
}
