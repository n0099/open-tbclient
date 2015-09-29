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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private TbPageContext<BaseFragmentActivity> aPb;
    private String crg;
    private PersonPostModel.a crm;
    private PersonPostModel crn;
    private final PersonPostModel.a cro = new h(this);
    private final a.InterfaceC0072a crp = new i(this);
    private final String wq;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2) {
        this.aPb = tbPageContext;
        this.wq = str;
    }

    public void a(PersonPostModel.a aVar) {
        this.crm = aVar;
    }

    public void eX(boolean z) {
        if (this.crn == null) {
            this.crn = new PersonPostModel(this.aPb);
        }
        this.crn.fetchPost(this.aPb, this.cro, z, this.wq, false);
    }

    public void aiX() {
        if (this.crn != null) {
            this.crn.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.crn == null || this.crn.post_list == null) {
            return 0;
        }
        return this.crn.post_list.size();
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
            aVar = new a(view, this.aPb);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.crc.setVisibility(0);
        } else {
            aVar.crc.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList jj(int i) {
        return this.crn.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList jj = jj(i);
        if (this.crg == null) {
            this.crg = jj.user_portrait;
        }
        aVar.a(jj, false, this.crg);
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
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(jj.thread_id), String.valueOf(jj.content[i2].post_id), String.valueOf(jj.content[i2].post_type), ar.o(jj.content[i2].create_time * 1000), String.valueOf(jj.thread_type)});
            }
        }
        aVar.crr.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(jj.title).find()) {
            aVar.crs.setText(jj.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.crs.setText(jj.title);
        }
        TextView textView = aVar.crs;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(jj.thread_id);
        strArr[3] = String.valueOf(jj.thread_type);
        textView.setTag(strArr);
        if (jj.thread_type == 33) {
            aVar.crs.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.crs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.i((View) aVar.crs, i.e.person_post_line);
        am.b(aVar.crs, i.c.person_post_content_ori, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(i.d.person_post_reply_ori_padding);
        aVar.crs.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.crp);
        aVar.cN(TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View cfs;
        public ReplyLinearLayout crr;
        public TextView crs;
        private View crt;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.crr = (ReplyLinearLayout) view.findViewById(i.f.content_container);
            this.crs = (TextView) view.findViewById(i.f.original_post_title);
            this.cfs = view.findViewById(i.f.reply_top_line);
            this.crt = view.findViewById(i.f.reply_bottom_line);
            this.crs.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cN(int i) {
            super.cN(i);
            am.i((View) this.crs, i.c.cp_bg_line_e);
            am.b(this.crs, i.c.cp_cont_b, 1);
            am.i(this.cfs, i.c.cp_bg_line_b);
            am.i(this.crt, i.c.cp_bg_line_b);
        }
    }
}
