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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private BdUniqueId aBS;
    private TbPageContext<BaseFragmentActivity> dws;
    private PersonPostModel gAk;
    private PersonPostModel.a gIX;
    private final PersonPostModel.a gIY = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.gAk = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.gAk.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.gAk != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.gAk.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.gIX != null) {
                g.this.gIX.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0299a gIZ = new a.InterfaceC0299a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0299a
        public void bO(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == e.g.portrait) {
                ((BaseFragmentActivity) g.this.dws.getOrignalPage()).finish();
            } else if (id == e.g.username) {
                ((BaseFragmentActivity) g.this.dws.getOrignalPage()).finish();
            } else if ((id == e.g.item_header || id == e.g.original_post_title || id == e.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.dws.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.dws.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String gzi;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.dws = tbPageContext;
        this.mUid = str;
        this.aBS = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gIX = aVar;
    }

    public void mH(boolean z) {
        if (this.gAk == null) {
            this.gAk = new PersonPostModel(this.dws, this.aBS, null, true, PersonPostModel.FROM_PERSON_POST);
            this.gAk.setUniqueId(this.aBS);
        }
        this.gAk.fetchPost(this.dws, this.gIY, z, this.mUid, false, true, false);
    }

    public void aDS() {
        if (this.gAk != null) {
            this.gAk.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gAk == null || this.gAk.postList == null) {
            return 0;
        }
        return this.gAk.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.dws);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gBu.setVisibility(0);
        } else {
            aVar.gBu.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList tG(int i) {
        return (PersonPostModel.PostInfoList) this.gAk.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList tG = tG(i);
        if (this.gzi == null) {
            this.gzi = tG.user_portrait;
        }
        aVar.a(tG, false, this.gzi);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = tG.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (tG.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!tG.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = tG.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(tG.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(tG.thread_id), String.valueOf(tG.content[i2].post_id), String.valueOf(tG.content[i2].post_type), ao.M(tG.content[i2].create_time * 1000), String.valueOf(tG.thread_type)});
            }
        }
        aVar.gJb.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(tG.title).find()) {
            aVar.gBn.setText(tG.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gBn.setText(tG.title);
        }
        if (tG.originalThreadInfo != null && !StringUtils.isNull(tG.originalThreadInfo.showText)) {
            aVar.gBn.setText("分享：" + tG.originalThreadInfo.showText);
        }
        aVar.gBn.setTag(new String[]{String.valueOf(tG.thread_id), null, null, String.valueOf(tG.thread_type)});
        if (tG.thread_type == 33) {
            aVar.gBn.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gBn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.gBn, e.f.person_post_line);
        al.c(aVar.gBn, e.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(e.C0210e.ds20);
        aVar.gBn.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gIZ);
        aVar.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cFB;
        private View cYj;
        public TextView gBn;
        public ReplyLinearLayout gJb;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gJb = (ReplyLinearLayout) view.findViewById(e.g.content_container);
            this.gBn = (TextView) view.findViewById(e.g.original_post_title);
            this.cYj = view.findViewById(e.g.reply_top_line);
            this.cFB = view.findViewById(e.g.reply_bottom_line);
            this.gBn.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void ey(int i) {
            super.ey(i);
            al.i(this.gBn, e.d.cp_bg_line_e);
            al.c(this.gBn, e.d.cp_cont_b, 1);
            al.i(this.cYj, e.d.cp_bg_line_b);
            al.i(this.cFB, e.d.cp_bg_line_b);
        }
    }
}
