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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class g extends BaseAdapter {
    private BdUniqueId XE;
    private TbPageContext<BaseFragmentActivity> ffP;
    private PersonPostModel.a iBq;
    private final PersonPostModel.a iBr = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.irn = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.irn.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.irn != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.irn.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.iBq != null) {
                g.this.iBq.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0394a iBs = new a.InterfaceC0394a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0394a
        public void cO(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.ffP.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.ffP.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.ffP.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.ffP.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String iql;
    private PersonPostModel irn;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.ffP = tbPageContext;
        this.mUid = str;
        this.XE = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.iBq = aVar;
    }

    public void qk(boolean z) {
        if (this.irn == null) {
            this.irn = new PersonPostModel(this.ffP, this.XE, null, true, PersonPostModel.FROM_PERSON_POST);
            this.irn.setUniqueId(this.XE);
        }
        this.irn.fetchPost(this.ffP, this.iBr, z, this.mUid, false, true, false);
    }

    public void boF() {
        if (this.irn != null) {
            this.irn.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.irn == null || this.irn.postList == null) {
            return 0;
        }
        return this.irn.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.ffP);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.isx.setVisibility(0);
        } else {
            aVar.isx.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList zh(int i) {
        return (PersonPostModel.PostInfoList) this.irn.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList zh = zh(i);
        if (this.iql == null) {
            this.iql = zh.user_portrait;
        }
        aVar.a(zh, false, this.iql);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = zh.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (zh.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!zh.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = zh.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(zh.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(zh.thread_id), String.valueOf(zh.content[i2].post_id), String.valueOf(zh.content[i2].post_type), aq.aD(zh.content[i2].create_time * 1000), String.valueOf(zh.thread_type)});
            }
        }
        aVar.iBu.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(zh.title).find()) {
            aVar.isq.setText(zh.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.isq.setText(zh.title);
        }
        if (zh.originalThreadInfo != null && !StringUtils.isNull(zh.originalThreadInfo.showText)) {
            aVar.isq.setText("分享：" + zh.originalThreadInfo.showText);
        }
        aVar.isq.setTag(new String[]{String.valueOf(zh.thread_id), null, null, String.valueOf(zh.thread_type)});
        if (zh.thread_type == 33) {
            aVar.isq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.isq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.k(aVar.isq, R.drawable.person_post_line);
        am.f(aVar.isq, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.isq.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.iBs);
        aVar.iV(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View eDo;
        private View ein;
        public ReplyLinearLayout iBu;
        public TextView isq;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.iBu = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.isq = (TextView) view.findViewById(R.id.original_post_title);
            this.eDo = view.findViewById(R.id.reply_top_line);
            this.ein = view.findViewById(R.id.reply_bottom_line);
            this.isq.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void iV(int i) {
            super.iV(i);
            am.k(this.isq, R.color.cp_bg_line_e);
            am.f(this.isq, R.color.cp_cont_b, 1);
            am.k(this.eDo, R.color.cp_bg_line_b);
            am.k(this.ein, R.color.cp_bg_line_b);
        }
    }
}
