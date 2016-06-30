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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.post.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private BdUniqueId aoZ;
    private TbPageContext<BaseFragmentActivity> bxh;
    private String enb;
    private PersonPostModel.a enl;
    private PersonPostModel enm;
    private final PersonPostModel.a enn = new i(this);
    private final a.InterfaceC0074a eno = new j(this);
    private final String mV;

    public h(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.bxh = tbPageContext;
        this.mV = str;
        this.aoZ = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.enl = aVar;
    }

    public void im(boolean z) {
        if (this.enm == null) {
            this.enm = new PersonPostModel(this.bxh);
            this.enm.setUniqueId(this.aoZ);
        }
        this.enm.fetchPost(this.bxh, this.enn, z, this.mV, false);
    }

    public void aLP() {
        if (this.enm != null) {
            this.enm.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.enm == null || this.enm.post_list == null) {
            return 0;
        }
        return this.enm.post_list.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(u.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.bxh);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.emY.setVisibility(0);
        } else {
            aVar.emY.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList ob(int i) {
        return this.enm.post_list.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList ob = ob(i);
        if (this.enb == null) {
            this.enb = ob.user_portrait;
        }
        aVar.a(ob, false, this.enb);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = ob.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (ob.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!ob.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = ob.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(ob.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(ob.thread_id), String.valueOf(ob.content[i2].post_id), String.valueOf(ob.content[i2].post_type), ba.y(ob.content[i2].create_time * 1000), String.valueOf(ob.thread_type)});
            }
        }
        aVar.enq.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(ob.title).find()) {
            aVar.enr.setText(ob.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.enr.setText(ob.title);
        }
        TextView textView = aVar.enr;
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(ob.thread_id);
        strArr[3] = String.valueOf(ob.thread_type);
        textView.setTag(strArr);
        if (ob.thread_type == 33) {
            aVar.enr.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.enr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        av.k(aVar.enr, u.f.person_post_line);
        av.c(aVar.enr, u.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(u.e.ds20);
        aVar.enr.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.eno);
        aVar.cT(TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tieba.person.post.a {
        private View aRC;
        private View bottomLine;
        public ReplyLinearLayout enq;
        public TextView enr;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.enq = (ReplyLinearLayout) view.findViewById(u.g.content_container);
            this.enr = (TextView) view.findViewById(u.g.original_post_title);
            this.aRC = view.findViewById(u.g.reply_top_line);
            this.bottomLine = view.findViewById(u.g.reply_bottom_line);
            this.enr.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.person.post.a
        public void cT(int i) {
            super.cT(i);
            av.k(this.enr, u.d.cp_bg_line_e);
            av.c(this.enr, u.d.cp_cont_b, 1);
            av.k(this.aRC, u.d.cp_bg_line_b);
            av.k(this.bottomLine, u.d.cp_bg_line_b);
        }
    }
}
