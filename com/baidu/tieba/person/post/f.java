package com.baidu.tieba.person.post;

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
public class f extends BaseAdapter {
    private TbPageContext<BaseFragmentActivity> adr;
    private String ckH;
    private PersonPostModel.a ckN;
    private PersonPostModel ckO;
    private final PersonPostModel.a ckP = new g(this);
    private final a.InterfaceC0067a ckQ = new h(this);
    private final String wr;

    public f(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.adr = tbPageContext;
        this.wr = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.ckN = aVar;
    }

    public void eI(boolean z) {
        if (this.ckO == null) {
            this.ckO = new PersonPostModel(this.adr);
        }
        this.ckO.fetchPost(this.adr, this.ckP, z, this.wr, false);
    }

    public void agH() {
        if (this.ckO != null) {
            this.ckO.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ckO == null || this.ckO.post_list == null) {
            return 0;
        }
        return this.ckO.post_list.size();
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
            aVar = new a(view, this.adr);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.ckD.setVisibility(0);
        } else {
            aVar.ckD.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList iN(int i) {
        return this.ckO.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList iN = iN(i);
        if (this.ckH == null) {
            this.ckH = iN.user_portrait;
        }
        aVar.a(iN, false, this.ckH);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = iN.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (iN.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!iN.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = iN.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(iN.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(iN.thread_id), String.valueOf(iN.content[i2].post_id), String.valueOf(iN.content[i2].post_type), aq.m(iN.content[i2].create_time * 1000)});
            }
        }
        aVar.ckS.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(iN.title).find()) {
            aVar.ckT.setText(iN.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.ckT.setText(iN.title);
        }
        TextView textView = aVar.ckT;
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(iN.thread_id);
        textView.setTag(strArr);
        al.i((View) aVar.ckT, i.e.person_post_line);
        al.b(aVar.ckT, i.c.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(i.d.person_post_reply_ori_padding);
        aVar.ckT.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.ckQ);
        aVar.cG(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View bZt;
        public ReplyLinearLayout ckS;
        public TextView ckT;
        private View ckU;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.ckS = (ReplyLinearLayout) view.findViewById(i.f.content_container);
            this.ckT = (TextView) view.findViewById(i.f.original_post_title);
            this.bZt = view.findViewById(i.f.reply_top_line);
            this.ckU = view.findViewById(i.f.reply_bottom_line);
            this.ckT.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cG(int i) {
            super.cG(i);
            al.i((View) this.ckT, i.c.cp_bg_line_e);
            al.b(this.ckT, i.c.cp_cont_b, 1);
            al.i(this.bZt, i.c.cp_bg_line_b);
            al.i(this.ckU, i.c.cp_bg_line_b);
        }
    }
}
