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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<BaseFragmentActivity> aUx;
    private String cQA;
    private PersonPostModel.a cQG;
    private PersonPostModel cQH;
    private final PersonPostModel.a cQI = new h(this);
    private final a.InterfaceC0082a cQJ = new i(this);
    private final String ww;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.aUx = tbPageContext;
        this.ww = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.cQG = aVar;
    }

    public void fH(boolean z) {
        if (this.cQH == null) {
            this.cQH = new PersonPostModel(this.aUx);
        }
        this.cQH.fetchPost(this.aUx, this.cQI, z, this.ww, false);
    }

    public void aov() {
        if (this.cQH != null) {
            this.cQH.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cQH == null || this.cQH.post_list == null) {
            return 0;
        }
        return this.cQH.post_list.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.g.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.aUx);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.cQw.setVisibility(0);
        } else {
            aVar.cQw.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList ku(int i) {
        return this.cQH.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList ku = ku(i);
        if (this.cQA == null) {
            this.cQA = ku.user_portrait;
        }
        aVar.a(ku, false, this.cQA);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = ku.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (ku.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!ku.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = ku.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(ku.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(ku.thread_id), String.valueOf(ku.content[i2].post_id), String.valueOf(ku.content[i2].post_type), ax.s(ku.content[i2].create_time * 1000), String.valueOf(ku.thread_type)});
            }
        }
        aVar.cQL.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(ku.title).find()) {
            aVar.cQM.setText(ku.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.cQM.setText(ku.title);
        }
        TextView textView = aVar.cQM;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(ku.thread_id);
        strArr[3] = String.valueOf(ku.thread_type);
        textView.setTag(strArr);
        if (ku.thread_type == 33) {
            aVar.cQM.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.cQM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        as.i((View) aVar.cQM, n.e.person_post_line);
        as.b(aVar.cQM, n.c.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(n.d.person_post_reply_ori_padding);
        aVar.cQM.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.cQJ);
        aVar.cV(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View bBj;
        public ReplyLinearLayout cQL;
        public TextView cQM;
        private View cyG;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.cQL = (ReplyLinearLayout) view.findViewById(n.f.content_container);
            this.cQM = (TextView) view.findViewById(n.f.original_post_title);
            this.cyG = view.findViewById(n.f.reply_top_line);
            this.bBj = view.findViewById(n.f.reply_bottom_line);
            this.cQM.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cV(int i) {
            super.cV(i);
            as.i((View) this.cQM, n.c.cp_bg_line_e);
            as.b(this.cQM, n.c.cp_cont_b, 1);
            as.i(this.cyG, n.c.cp_bg_line_b);
            as.i(this.bBj, n.c.cp_bg_line_b);
        }
    }
}
