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
    private TbPageContext<BaseFragmentActivity> ffp;
    private PersonPostModel.a iAm;
    private final PersonPostModel.a iAn = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.iqj = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.iqj.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.iqj != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.iqj.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.iAm != null) {
                g.this.iAm.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0388a iAo = new a.InterfaceC0388a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0388a
        public void cM(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.ffp.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.ffp.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.ffp.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.ffp.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String iph;
    private PersonPostModel iqj;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.ffp = tbPageContext;
        this.mUid = str;
        this.XE = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.iAm = aVar;
    }

    public void qj(boolean z) {
        if (this.iqj == null) {
            this.iqj = new PersonPostModel(this.ffp, this.XE, null, true, PersonPostModel.FROM_PERSON_POST);
            this.iqj.setUniqueId(this.XE);
        }
        this.iqj.fetchPost(this.ffp, this.iAn, z, this.mUid, false, true, false);
    }

    public void bos() {
        if (this.iqj != null) {
            this.iqj.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iqj == null || this.iqj.postList == null) {
            return 0;
        }
        return this.iqj.postList.size();
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
            aVar = new a(view, this.ffp);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.irt.setVisibility(0);
        } else {
            aVar.irt.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList zf(int i) {
        return (PersonPostModel.PostInfoList) this.iqj.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList zf = zf(i);
        if (this.iph == null) {
            this.iph = zf.user_portrait;
        }
        aVar.a(zf, false, this.iph);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = zf.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (zf.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!zf.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = zf.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(zf.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(zf.thread_id), String.valueOf(zf.content[i2].post_id), String.valueOf(zf.content[i2].post_type), aq.aD(zf.content[i2].create_time * 1000), String.valueOf(zf.thread_type)});
            }
        }
        aVar.iAq.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(zf.title).find()) {
            aVar.irm.setText(zf.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.irm.setText(zf.title);
        }
        if (zf.originalThreadInfo != null && !StringUtils.isNull(zf.originalThreadInfo.showText)) {
            aVar.irm.setText("分享：" + zf.originalThreadInfo.showText);
        }
        aVar.irm.setTag(new String[]{String.valueOf(zf.thread_id), null, null, String.valueOf(zf.thread_type)});
        if (zf.thread_type == 33) {
            aVar.irm.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.irm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.k(aVar.irm, R.drawable.person_post_line);
        am.f(aVar.irm, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.irm.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.iAo);
        aVar.iV(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View eDh;
        private View eig;
        public ReplyLinearLayout iAq;
        public TextView irm;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.iAq = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.irm = (TextView) view.findViewById(R.id.original_post_title);
            this.eDh = view.findViewById(R.id.reply_top_line);
            this.eig = view.findViewById(R.id.reply_bottom_line);
            this.irm.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void iV(int i) {
            super.iV(i);
            am.k(this.irm, R.color.cp_bg_line_e);
            am.f(this.irm, R.color.cp_cont_b, 1);
            am.k(this.eDh, R.color.cp_bg_line_b);
            am.k(this.eig, R.color.cp_bg_line_b);
        }
    }
}
