package com.baidu.tieba.personPolymeric.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.widget.ListView.a<PersonPostModel.PostInfoList, com.baidu.tieba.personCenter.d.b> {
    private TbPageContext<PersonPolymericActivity> aat;
    private boolean boT;
    private String eUQ;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.TbPageContext<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aat = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public com.baidu.tieba.personCenter.d.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.d.b(LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.person_polymeric_item_reply, viewGroup, false), this.aat, this.boT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, com.baidu.tieba.personCenter.d.b bVar) {
        if (postInfoList != null && bVar != null) {
            if (this.eUQ == null) {
                this.eUQ = postInfoList.user_portrait;
            }
            bVar.a(postInfoList, false, this.eUQ);
            ArrayList<String[]> arrayList = new ArrayList<>();
            int length = postInfoList.content.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (postInfoList.content[i2].post_content.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (!postInfoList.content[i2].post_content[0].text.startsWith("回复 ")) {
                        stringBuffer.append("回复：");
                    }
                    int length2 = postInfoList.content[i2].post_content.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        stringBuffer.append(postInfoList.content[i2].post_content[i3].text);
                    }
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.content[i2].post_id), String.valueOf(postInfoList.content[i2].post_type), aw.q(postInfoList.content[i2].create_time * 1000), String.valueOf(postInfoList.thread_type)});
                }
            }
            bVar.eRh.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(postInfoList.title).find()) {
                bVar.eRi.setText(postInfoList.title.replaceFirst("回复：", "原贴："));
            } else {
                bVar.eRi.setText(postInfoList.title);
            }
            TextView textView = bVar.eRi;
            String[] strArr = new String[4];
            strArr[0] = String.valueOf(postInfoList.thread_id);
            strArr[3] = String.valueOf(postInfoList.thread_type);
            textView.setTag(strArr);
            if (postInfoList.thread_type == 33) {
                bVar.eRi.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                bVar.eRi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            as.j(bVar.eRi, w.g.person_post_line);
            as.c(bVar.eRi, w.e.common_color_10039, 1);
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds20);
            bVar.eRi.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            bVar.dl(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    public void setIsHost(boolean z) {
        this.boT = z;
    }
}
