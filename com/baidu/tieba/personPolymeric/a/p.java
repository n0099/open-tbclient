package com.baidu.tieba.personPolymeric.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<PersonPostModel.PostInfoList, com.baidu.tieba.personCenter.d.b> {
    private TbPageContext<PersonPolymericActivity> acr;
    private boolean buA;
    private String fkw;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.TbPageContext<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public com.baidu.tieba.personCenter.d.b onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personCenter.d.b(LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.person_polymeric_item_reply, viewGroup, false), this.acr, this.buA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, com.baidu.tieba.personCenter.d.b bVar) {
        if (postInfoList != null && bVar != null) {
            if (this.fkw == null) {
                this.fkw = postInfoList.user_portrait;
            }
            bVar.a(postInfoList, false, this.fkw);
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
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.content[i2].post_id), String.valueOf(postInfoList.content[i2].post_type), al.r(postInfoList.content[i2].create_time * 1000), String.valueOf(postInfoList.thread_type)});
                }
            }
            bVar.fgL.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(postInfoList.title).find()) {
                bVar.fgM.setText(postInfoList.title.replaceFirst("回复：", "原贴："));
            } else {
                bVar.fgM.setText(postInfoList.title);
            }
            bVar.fgM.setTag(new String[]{String.valueOf(postInfoList.thread_id), null, null, String.valueOf(postInfoList.thread_type)});
            if (postInfoList.thread_type == 33) {
                bVar.fgM.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                bVar.fgM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            ai.j(bVar.fgM, d.g.person_post_line);
            ai.c(bVar.fgM, d.e.common_color_10039, 1);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds20);
            bVar.fgM.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            bVar.dp(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setIsHost(boolean z) {
        this.buA = z;
    }
}
