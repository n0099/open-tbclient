package com.baidu.tieba.personPolymeric.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class p extends com.baidu.adp.widget.ListView.a<PersonPostModel.PostInfoList, com.baidu.tieba.personPolymeric.d.a> {
    private TbPageContext<PersonPolymericActivity> dPv;
    private boolean isHost;
    private String kLQ;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.TbPageContext<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dPv = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cA */
    public com.baidu.tieba.personPolymeric.d.a b(ViewGroup viewGroup) {
        return new com.baidu.tieba.personPolymeric.d.a(LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.person_polymeric_item_reply, viewGroup, false), this.dPv, this.isHost);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, com.baidu.tieba.personPolymeric.d.a aVar) {
        if (postInfoList != null && aVar != null) {
            if (this.kLQ == null) {
                this.kLQ = postInfoList.user_portrait;
            }
            aVar.a(postInfoList, false, this.kLQ);
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
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.content[i2].post_id), String.valueOf(postInfoList.content[i2].post_type), ar.getFormatTime(postInfoList.content[i2].create_time * 1000), String.valueOf(postInfoList.thread_type)});
                }
            }
            aVar.kOM.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(postInfoList.title).find()) {
                aVar.kON.setText(postInfoList.title.replaceFirst("回复：", "原贴："));
            } else {
                aVar.kON.setText(postInfoList.title);
            }
            aVar.kON.setTag(new String[]{String.valueOf(postInfoList.thread_id), null, null, String.valueOf(postInfoList.thread_type)});
            if (postInfoList.thread_type == 33) {
                aVar.kON.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.kON.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            an.setBackgroundResource(aVar.kON, R.drawable.person_post_line);
            an.setViewTextColor(aVar.kON, R.color.common_color_10039, 1);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
            aVar.kON.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }
}
