package com.baidu.tieba.personPolymeric.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class p extends com.baidu.adp.widget.ListView.a<PersonPostModel.PostInfoList, com.baidu.tieba.personPolymeric.d.a> {
    private TbPageContext<PersonPolymericActivity> aRR;
    private String gnP;
    private boolean isHost;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.TbPageContext<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aRR = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public com.baidu.tieba.personPolymeric.d.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.personPolymeric.d.a(LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.person_polymeric_item_reply, viewGroup, false), this.aRR, this.isHost);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, com.baidu.tieba.personPolymeric.d.a aVar) {
        if (postInfoList != null && aVar != null) {
            if (this.gnP == null) {
                this.gnP = postInfoList.user_portrait;
            }
            aVar.a(postInfoList, false, this.gnP);
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
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.content[i2].post_id), String.valueOf(postInfoList.content[i2].post_type), am.z(postInfoList.content[i2].create_time * 1000), String.valueOf(postInfoList.thread_type)});
                }
            }
            aVar.gqb.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(postInfoList.title).find()) {
                aVar.gqc.setText(postInfoList.title.replaceFirst("回复：", "原贴："));
            } else {
                aVar.gqc.setText(postInfoList.title);
            }
            aVar.gqc.setTag(new String[]{String.valueOf(postInfoList.thread_id), null, null, String.valueOf(postInfoList.thread_type)});
            if (postInfoList.thread_type == 33) {
                aVar.gqc.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.gqc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            aj.s(aVar.gqc, d.f.person_post_line);
            aj.e(aVar.gqc, d.C0140d.common_color_10039, 1);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
            aVar.gqc.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            aVar.gx(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }
}
