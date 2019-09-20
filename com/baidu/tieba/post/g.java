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
    private BdUniqueId XD;
    private TbPageContext<BaseFragmentActivity> fhC;
    private PersonPostModel.a iDI;
    private final PersonPostModel.a iDJ = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.itm = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.itm.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.itm != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.itm.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.iDI != null) {
                g.this.iDI.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0405a iDK = new a.InterfaceC0405a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0405a
        public void cO(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.fhC.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.fhC.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.fhC.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.fhC.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String isk;
    private PersonPostModel itm;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.fhC = tbPageContext;
        this.mUid = str;
        this.XD = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.iDI = aVar;
    }

    public void qn(boolean z) {
        if (this.itm == null) {
            this.itm = new PersonPostModel(this.fhC, this.XD, null, true, PersonPostModel.FROM_PERSON_POST);
            this.itm.setUniqueId(this.XD);
        }
        this.itm.fetchPost(this.fhC, this.iDJ, z, this.mUid, false, true, false);
    }

    public void bpq() {
        if (this.itm != null) {
            this.itm.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.itm == null || this.itm.postList == null) {
            return 0;
        }
        return this.itm.postList.size();
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
            aVar = new a(view, this.fhC);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.iuw.setVisibility(0);
        } else {
            aVar.iuw.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList zk(int i) {
        return (PersonPostModel.PostInfoList) this.itm.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList zk = zk(i);
        if (this.isk == null) {
            this.isk = zk.user_portrait;
        }
        aVar.a(zk, false, this.isk);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = zk.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (zk.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!zk.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = zk.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(zk.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(zk.thread_id), String.valueOf(zk.content[i2].post_id), String.valueOf(zk.content[i2].post_type), aq.aD(zk.content[i2].create_time * 1000), String.valueOf(zk.thread_type)});
            }
        }
        aVar.iDM.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(zk.title).find()) {
            aVar.iup.setText(zk.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.iup.setText(zk.title);
        }
        if (zk.originalThreadInfo != null && !StringUtils.isNull(zk.originalThreadInfo.showText)) {
            aVar.iup.setText("分享：" + zk.originalThreadInfo.showText);
        }
        aVar.iup.setTag(new String[]{String.valueOf(zk.thread_id), null, null, String.valueOf(zk.thread_type)});
        if (zk.thread_type == 33) {
            aVar.iup.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.iup.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.k(aVar.iup, R.drawable.person_post_line);
        am.f(aVar.iup, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.iup.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.iDK);
        aVar.iY(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View eEX;
        private View ejX;
        public ReplyLinearLayout iDM;
        public TextView iup;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.iDM = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.iup = (TextView) view.findViewById(R.id.original_post_title);
            this.eEX = view.findViewById(R.id.reply_top_line);
            this.ejX = view.findViewById(R.id.reply_bottom_line);
            this.iup.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void iY(int i) {
            super.iY(i);
            am.k(this.iup, R.color.cp_bg_line_e);
            am.f(this.iup, R.color.cp_cont_b, 1);
            am.k(this.eEX, R.color.cp_bg_line_c);
            am.k(this.ejX, R.color.cp_bg_line_c);
        }
    }
}
