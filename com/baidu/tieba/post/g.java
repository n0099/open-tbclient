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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class g extends BaseAdapter {
    private BdUniqueId Zr;
    private TbPageContext<BaseFragmentActivity> eKd;
    private String hPY;
    private PersonPostModel hRa;
    private PersonPostModel.a ibm;
    private final PersonPostModel.a ibn = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.hRa = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.hRa.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.hRa != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.hRa.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.ibm != null) {
                g.this.ibm.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0370a ibo = new a.InterfaceC0370a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0370a
        public void cB(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) g.this.eKd.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) g.this.eKd.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.eKd.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.eKd.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.eKd = tbPageContext;
        this.mUid = str;
        this.Zr = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.ibm = aVar;
    }

    public void pg(boolean z) {
        if (this.hRa == null) {
            this.hRa = new PersonPostModel(this.eKd, this.Zr, null, true, PersonPostModel.FROM_PERSON_POST);
            this.hRa.setUniqueId(this.Zr);
        }
        this.hRa.fetchPost(this.eKd, this.ibn, z, this.mUid, false, true, false);
    }

    public void beW() {
        if (this.hRa != null) {
            this.hRa.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hRa == null || this.hRa.postList == null) {
            return 0;
        }
        return this.hRa.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.eKd);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.hSk.setVisibility(0);
        } else {
            aVar.hSk.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList xt(int i) {
        return (PersonPostModel.PostInfoList) this.hRa.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList xt = xt(i);
        if (this.hPY == null) {
            this.hPY = xt.user_portrait;
        }
        aVar.a(xt, false, this.hPY);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = xt.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (xt.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!xt.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = xt.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(xt.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(xt.thread_id), String.valueOf(xt.content[i2].post_id), String.valueOf(xt.content[i2].post_type), ap.ao(xt.content[i2].create_time * 1000), String.valueOf(xt.thread_type)});
            }
        }
        aVar.ibq.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(xt.title).find()) {
            aVar.hSd.setText(xt.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.hSd.setText(xt.title);
        }
        if (xt.originalThreadInfo != null && !StringUtils.isNull(xt.originalThreadInfo.showText)) {
            aVar.hSd.setText("分享：" + xt.originalThreadInfo.showText);
        }
        aVar.hSd.setTag(new String[]{String.valueOf(xt.thread_id), null, null, String.valueOf(xt.thread_type)});
        if (xt.thread_type == 33) {
            aVar.hSd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.hSd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.k(aVar.hSd, d.f.person_post_line);
        al.d(aVar.hSd, d.C0277d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.hSd.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.ibo);
        aVar.ib(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View dTd;
        private View eiu;
        public TextView hSd;
        public ReplyLinearLayout ibq;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.ibq = (ReplyLinearLayout) view.findViewById(d.g.content_container);
            this.hSd = (TextView) view.findViewById(d.g.original_post_title);
            this.eiu = view.findViewById(d.g.reply_top_line);
            this.dTd = view.findViewById(d.g.reply_bottom_line);
            this.hSd.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void ib(int i) {
            super.ib(i);
            al.k(this.hSd, d.C0277d.cp_bg_line_e);
            al.d(this.hSd, d.C0277d.cp_cont_b, 1);
            al.k(this.eiu, d.C0277d.cp_bg_line_b);
            al.k(this.dTd, d.C0277d.cp_bg_line_b);
        }
    }
}
