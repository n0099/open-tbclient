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
    private BdUniqueId ays;
    private TbPageContext<BaseFragmentActivity> dnc;
    private String gpB;
    private PersonPostModel gqD;
    private PersonPostModel.a gzq;
    private final PersonPostModel.a gzr = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.gqD = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.gqD.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.gqD != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.gqD.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.gzq != null) {
                g.this.gzq.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0288a gzs = new a.InterfaceC0288a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0288a
        public void bL(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == e.g.portrait) {
                ((BaseFragmentActivity) g.this.dnc.getOrignalPage()).finish();
            } else if (id == e.g.username) {
                ((BaseFragmentActivity) g.this.dnc.getOrignalPage()).finish();
            } else if ((id == e.g.item_header || id == e.g.original_post_title || id == e.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.dnc.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.dnc.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.dnc = tbPageContext;
        this.mUid = str;
        this.ays = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gzq = aVar;
    }

    public void mB(boolean z) {
        if (this.gqD == null) {
            this.gqD = new PersonPostModel(this.dnc, this.ays, null, true, PersonPostModel.FROM_PERSON_POST);
            this.gqD.setUniqueId(this.ays);
        }
        this.gqD.fetchPost(this.dnc, this.gzr, z, this.mUid, false, true, false);
    }

    public void aBt() {
        if (this.gqD != null) {
            this.gqD.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gqD == null || this.gqD.postList == null) {
            return 0;
        }
        return this.gqD.postList.size();
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
            aVar = new a(view, this.dnc);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.grN.setVisibility(0);
        } else {
            aVar.grN.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList sZ(int i) {
        return (PersonPostModel.PostInfoList) this.gqD.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList sZ = sZ(i);
        if (this.gpB == null) {
            this.gpB = sZ.user_portrait;
        }
        aVar.a(sZ, false, this.gpB);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = sZ.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (sZ.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!sZ.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = sZ.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(sZ.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(sZ.thread_id), String.valueOf(sZ.content[i2].post_id), String.valueOf(sZ.content[i2].post_type), ao.E(sZ.content[i2].create_time * 1000), String.valueOf(sZ.thread_type)});
            }
        }
        aVar.gzu.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(sZ.title).find()) {
            aVar.grG.setText(sZ.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.grG.setText(sZ.title);
        }
        if (sZ.originalThreadInfo != null && !StringUtils.isNull(sZ.originalThreadInfo.showText)) {
            aVar.grG.setText("分享：" + sZ.originalThreadInfo.showText);
        }
        aVar.grG.setTag(new String[]{String.valueOf(sZ.thread_id), null, null, String.valueOf(sZ.thread_type)});
        if (sZ.thread_type == 33) {
            aVar.grG.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.grG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.grG, e.f.person_post_line);
        al.c(aVar.grG, e.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(e.C0200e.ds20);
        aVar.grG.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gzs);
        aVar.ek(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cAJ;
        private View cOM;
        public TextView grG;
        public ReplyLinearLayout gzu;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gzu = (ReplyLinearLayout) view.findViewById(e.g.content_container);
            this.grG = (TextView) view.findViewById(e.g.original_post_title);
            this.cOM = view.findViewById(e.g.reply_top_line);
            this.cAJ = view.findViewById(e.g.reply_bottom_line);
            this.grG.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void ek(int i) {
            super.ek(i);
            al.i(this.grG, e.d.cp_bg_line_e);
            al.c(this.grG, e.d.cp_cont_b, 1);
            al.i(this.cOM, e.d.cp_bg_line_b);
            al.i(this.cAJ, e.d.cp_bg_line_b);
        }
    }
}
