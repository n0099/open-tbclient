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
    private TbPageContext<BaseFragmentActivity> eKr;
    private String hQm;
    private PersonPostModel hRo;
    private PersonPostModel.a ibA;
    private final PersonPostModel.a ibB = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.hRo = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.hRo.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.hRo != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.hRo.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.ibA != null) {
                g.this.ibA.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0370a ibC = new a.InterfaceC0370a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0370a
        public void cB(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) g.this.eKr.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) g.this.eKr.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.eKr.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.eKr.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.eKr = tbPageContext;
        this.mUid = str;
        this.Zr = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.ibA = aVar;
    }

    public void pg(boolean z) {
        if (this.hRo == null) {
            this.hRo = new PersonPostModel(this.eKr, this.Zr, null, true, PersonPostModel.FROM_PERSON_POST);
            this.hRo.setUniqueId(this.Zr);
        }
        this.hRo.fetchPost(this.eKr, this.ibB, z, this.mUid, false, true, false);
    }

    public void beY() {
        if (this.hRo != null) {
            this.hRo.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hRo == null || this.hRo.postList == null) {
            return 0;
        }
        return this.hRo.postList.size();
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
            aVar = new a(view, this.eKr);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.hSy.setVisibility(0);
        } else {
            aVar.hSy.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList xx(int i) {
        return (PersonPostModel.PostInfoList) this.hRo.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList xx = xx(i);
        if (this.hQm == null) {
            this.hQm = xx.user_portrait;
        }
        aVar.a(xx, false, this.hQm);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = xx.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (xx.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!xx.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = xx.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(xx.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(xx.thread_id), String.valueOf(xx.content[i2].post_id), String.valueOf(xx.content[i2].post_type), ap.ao(xx.content[i2].create_time * 1000), String.valueOf(xx.thread_type)});
            }
        }
        aVar.ibE.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(xx.title).find()) {
            aVar.hSr.setText(xx.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.hSr.setText(xx.title);
        }
        if (xx.originalThreadInfo != null && !StringUtils.isNull(xx.originalThreadInfo.showText)) {
            aVar.hSr.setText("分享：" + xx.originalThreadInfo.showText);
        }
        aVar.hSr.setTag(new String[]{String.valueOf(xx.thread_id), null, null, String.valueOf(xx.thread_type)});
        if (xx.thread_type == 33) {
            aVar.hSr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.hSr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.k(aVar.hSr, d.f.person_post_line);
        al.d(aVar.hSr, d.C0277d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.hSr.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.ibC);
        aVar.ic(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View dTL;
        private View eiI;
        public TextView hSr;
        public ReplyLinearLayout ibE;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.ibE = (ReplyLinearLayout) view.findViewById(d.g.content_container);
            this.hSr = (TextView) view.findViewById(d.g.original_post_title);
            this.eiI = view.findViewById(d.g.reply_top_line);
            this.dTL = view.findViewById(d.g.reply_bottom_line);
            this.hSr.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void ic(int i) {
            super.ic(i);
            al.k(this.hSr, d.C0277d.cp_bg_line_e);
            al.d(this.hSr, d.C0277d.cp_cont_b, 1);
            al.k(this.eiI, d.C0277d.cp_bg_line_b);
            al.k(this.dTL, d.C0277d.cp_bg_line_b);
        }
    }
}
