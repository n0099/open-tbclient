package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private BdUniqueId aBK;
    private TbPageContext<BaseFragmentActivity> cNa;
    private PersonPostModel fJu;
    private PersonPostModel.a fSc;
    private final PersonPostModel.a fSd = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.fJu = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.fJu.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.fJu != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.fJu.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.fSc != null) {
                g.this.fSc.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0203a fSe = new a.InterfaceC0203a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0203a
        public void bp(View view2) {
            String[] strArr;
            int id = view2.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) g.this.cNa.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) g.this.cNa.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view2.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.cNa.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.cNa.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String mPortraitUrl;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.cNa = tbPageContext;
        this.mUid = str;
        this.aBK = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.fSc = aVar;
    }

    public void lx(boolean z) {
        if (this.fJu == null) {
            this.fJu = new PersonPostModel(this.cNa, this.aBK, null, true, PersonPostModel.FROM_PERSON_POST);
            this.fJu.setUniqueId(this.aBK);
        }
        this.fJu.fetchPost(this.cNa, this.fSd, z, this.mUid, false, true, false);
    }

    public void arg() {
        if (this.fJu != null) {
            this.fJu.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJu == null || this.fJu.postList == null) {
            return 0;
        }
        return this.fJu.postList.size();
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.person_post_item_reply, viewGroup, false);
            aVar = new a(view2, this.cNa);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        if (i == 0) {
            aVar.fKP.setVisibility(0);
        } else {
            aVar.fKP.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view2;
    }

    public PersonPostModel.PostInfoList rw(int i) {
        return (PersonPostModel.PostInfoList) this.fJu.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList rw = rw(i);
        if (this.mPortraitUrl == null) {
            this.mPortraitUrl = rw.user_portrait;
        }
        aVar.a(rw, false, this.mPortraitUrl);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = rw.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (rw.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!rw.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = rw.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(rw.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(rw.thread_id), String.valueOf(rw.content[i2].post_id), String.valueOf(rw.content[i2].post_type), an.s(rw.content[i2].create_time * 1000), String.valueOf(rw.thread_type)});
            }
        }
        aVar.fSg.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(rw.title).find()) {
            aVar.fKI.setText(rw.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.fKI.setText(rw.title);
        }
        if (rw.originalThreadInfo != null && !StringUtils.isNull(rw.originalThreadInfo.showText)) {
            aVar.fKI.setText("分享：" + rw.originalThreadInfo.showText);
        }
        aVar.fKI.setTag(new String[]{String.valueOf(rw.thread_id), null, null, String.valueOf(rw.thread_type)});
        if (rw.thread_type == 33) {
            aVar.fKI.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.fKI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ak.i(aVar.fKI, d.f.person_post_line);
        ak.c(aVar.fKI, d.C0126d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.fKI.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.fSe);
        aVar.dw(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View bYq;
        private View cpq;
        public TextView fKI;
        public ReplyLinearLayout fSg;

        public a(View view2, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view2, tbPageContext);
            this.fSg = (ReplyLinearLayout) view2.findViewById(d.g.content_container);
            this.fKI = (TextView) view2.findViewById(d.g.original_post_title);
            this.cpq = view2.findViewById(d.g.reply_top_line);
            this.bYq = view2.findViewById(d.g.reply_bottom_line);
            this.fKI.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void dw(int i) {
            super.dw(i);
            ak.i(this.fKI, d.C0126d.cp_bg_line_e);
            ak.c(this.fKI, d.C0126d.cp_cont_b, 1);
            ak.i(this.cpq, d.C0126d.cp_bg_line_b);
            ak.i(this.bYq, d.C0126d.cp_bg_line_b);
        }
    }
}
