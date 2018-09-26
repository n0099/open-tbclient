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
    private BdUniqueId asU;
    private TbPageContext<BaseFragmentActivity> ddS;
    private String ggA;
    private PersonPostModel ghC;
    private PersonPostModel.a gqn;
    private final PersonPostModel.a gqo = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.ghC = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.ghC.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.ghC != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.ghC.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.gqn != null) {
                g.this.gqn.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0226a gqp = new a.InterfaceC0226a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0226a
        public void bJ(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == e.g.portrait) {
                ((BaseFragmentActivity) g.this.ddS.getOrignalPage()).finish();
            } else if (id == e.g.username) {
                ((BaseFragmentActivity) g.this.ddS.getOrignalPage()).finish();
            } else if ((id == e.g.item_header || id == e.g.original_post_title || id == e.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.ddS.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.ddS.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.ddS = tbPageContext;
        this.mUid = str;
        this.asU = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gqn = aVar;
    }

    public void lY(boolean z) {
        if (this.ghC == null) {
            this.ghC = new PersonPostModel(this.ddS, this.asU, null, true, PersonPostModel.FROM_PERSON_POST);
            this.ghC.setUniqueId(this.asU);
        }
        this.ghC.fetchPost(this.ddS, this.gqo, z, this.mUid, false, true, false);
    }

    public void ayC() {
        if (this.ghC != null) {
            this.ghC.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ghC == null || this.ghC.postList == null) {
            return 0;
        }
        return this.ghC.postList.size();
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
            aVar = new a(view, this.ddS);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.giN.setVisibility(0);
        } else {
            aVar.giN.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList sj(int i) {
        return (PersonPostModel.PostInfoList) this.ghC.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList sj = sj(i);
        if (this.ggA == null) {
            this.ggA = sj.user_portrait;
        }
        aVar.a(sj, false, this.ggA);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = sj.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (sj.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!sj.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = sj.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(sj.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(sj.thread_id), String.valueOf(sj.content[i2].post_id), String.valueOf(sj.content[i2].post_type), ao.A(sj.content[i2].create_time * 1000), String.valueOf(sj.thread_type)});
            }
        }
        aVar.gqr.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(sj.title).find()) {
            aVar.giG.setText(sj.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.giG.setText(sj.title);
        }
        if (sj.originalThreadInfo != null && !StringUtils.isNull(sj.originalThreadInfo.showText)) {
            aVar.giG.setText("分享：" + sj.originalThreadInfo.showText);
        }
        aVar.giG.setTag(new String[]{String.valueOf(sj.thread_id), null, null, String.valueOf(sj.thread_type)});
        if (sj.thread_type == 33) {
            aVar.giG.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.giG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.giG, e.f.person_post_line);
        al.c(aVar.giG, e.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(e.C0141e.ds20);
        aVar.giG.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gqp);
        aVar.dM(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cFm;
        private View cqY;
        public TextView giG;
        public ReplyLinearLayout gqr;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gqr = (ReplyLinearLayout) view.findViewById(e.g.content_container);
            this.giG = (TextView) view.findViewById(e.g.original_post_title);
            this.cFm = view.findViewById(e.g.reply_top_line);
            this.cqY = view.findViewById(e.g.reply_bottom_line);
            this.giG.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void dM(int i) {
            super.dM(i);
            al.i(this.giG, e.d.cp_bg_line_e);
            al.c(this.giG, e.d.cp_cont_b, 1);
            al.i(this.cFm, e.d.cp_bg_line_b);
            al.i(this.cqY, e.d.cp_bg_line_b);
        }
    }
}
