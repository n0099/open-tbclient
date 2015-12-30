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
    private TbPageContext<BaseFragmentActivity> aYy;
    private String cVc;
    private PersonPostModel.a cVi;
    private PersonPostModel cVj;
    private final PersonPostModel.a cVk = new h(this);
    private final a.InterfaceC0077a cVl = new i(this);
    private final String wy;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.aYy = tbPageContext;
        this.wy = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.cVi = aVar;
    }

    public void fG(boolean z) {
        if (this.cVj == null) {
            this.cVj = new PersonPostModel(this.aYy);
        }
        this.cVj.fetchPost(this.aYy, this.cVk, z, this.wy, false);
    }

    public void apF() {
        if (this.cVj != null) {
            this.cVj.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVj == null || this.cVj.post_list == null) {
            return 0;
        }
        return this.cVj.post_list.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.aYy);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.cUY.setVisibility(0);
        } else {
            aVar.cUY.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList kR(int i) {
        return this.cVj.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList kR = kR(i);
        if (this.cVc == null) {
            this.cVc = kR.user_portrait;
        }
        aVar.a(kR, false, this.cVc);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = kR.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (kR.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!kR.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = kR.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(kR.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(kR.thread_id), String.valueOf(kR.content[i2].post_id), String.valueOf(kR.content[i2].post_type), ax.s(kR.content[i2].create_time * 1000), String.valueOf(kR.thread_type)});
            }
        }
        aVar.cVn.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(kR.title).find()) {
            aVar.cVo.setText(kR.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.cVo.setText(kR.title);
        }
        TextView textView = aVar.cVo;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(kR.thread_id);
        strArr[3] = String.valueOf(kR.thread_type);
        textView.setTag(strArr);
        if (kR.thread_type == 33) {
            aVar.cVo.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.cVo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        as.i((View) aVar.cVo, n.f.person_post_line);
        as.b(aVar.cVo, n.d.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(n.e.person_post_reply_ori_padding);
        aVar.cVo.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.cVl);
        aVar.cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View aPe;
        private View aPf;
        public ReplyLinearLayout cVn;
        public TextView cVo;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.cVn = (ReplyLinearLayout) view.findViewById(n.g.content_container);
            this.cVo = (TextView) view.findViewById(n.g.original_post_title);
            this.aPe = view.findViewById(n.g.reply_top_line);
            this.aPf = view.findViewById(n.g.reply_bottom_line);
            this.cVo.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cP(int i) {
            super.cP(i);
            as.i((View) this.cVo, n.d.cp_bg_line_e);
            as.b(this.cVo, n.d.cp_cont_b, 1);
            as.i(this.aPe, n.d.cp_bg_line_b);
            as.i(this.aPf, n.d.cp_bg_line_b);
        }
    }
}
