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
    private BdUniqueId aCu;
    private TbPageContext<BaseFragmentActivity> dxb;
    private String gAm;
    private PersonPostModel gBo;
    private PersonPostModel.a gKb;
    private final PersonPostModel.a gKc = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.gBo = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.gBo.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.gBo != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.gBo.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.gKb != null) {
                g.this.gKb.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0299a gKd = new a.InterfaceC0299a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0299a
        public void bO(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == e.g.portrait) {
                ((BaseFragmentActivity) g.this.dxb.getOrignalPage()).finish();
            } else if (id == e.g.username) {
                ((BaseFragmentActivity) g.this.dxb.getOrignalPage()).finish();
            } else if ((id == e.g.item_header || id == e.g.original_post_title || id == e.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.dxb.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.dxb.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.dxb = tbPageContext;
        this.mUid = str;
        this.aCu = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gKb = aVar;
    }

    public void mH(boolean z) {
        if (this.gBo == null) {
            this.gBo = new PersonPostModel(this.dxb, this.aCu, null, true, PersonPostModel.FROM_PERSON_POST);
            this.gBo.setUniqueId(this.aCu);
        }
        this.gBo.fetchPost(this.dxb, this.gKc, z, this.mUid, false, true, false);
    }

    public void aEp() {
        if (this.gBo != null) {
            this.gBo.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gBo == null || this.gBo.postList == null) {
            return 0;
        }
        return this.gBo.postList.size();
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
            aVar = new a(view, this.dxb);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gCy.setVisibility(0);
        } else {
            aVar.gCy.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList tK(int i) {
        return (PersonPostModel.PostInfoList) this.gBo.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList tK = tK(i);
        if (this.gAm == null) {
            this.gAm = tK.user_portrait;
        }
        aVar.a(tK, false, this.gAm);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = tK.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (tK.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!tK.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = tK.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(tK.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(tK.thread_id), String.valueOf(tK.content[i2].post_id), String.valueOf(tK.content[i2].post_type), ao.M(tK.content[i2].create_time * 1000), String.valueOf(tK.thread_type)});
            }
        }
        aVar.gKf.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(tK.title).find()) {
            aVar.gCr.setText(tK.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gCr.setText(tK.title);
        }
        if (tK.originalThreadInfo != null && !StringUtils.isNull(tK.originalThreadInfo.showText)) {
            aVar.gCr.setText("分享：" + tK.originalThreadInfo.showText);
        }
        aVar.gCr.setTag(new String[]{String.valueOf(tK.thread_id), null, null, String.valueOf(tK.thread_type)});
        if (tK.thread_type == 33) {
            aVar.gCr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gCr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.gCr, e.f.person_post_line);
        al.c(aVar.gCr, e.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(e.C0210e.ds20);
        aVar.gCr.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gKd);
        aVar.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cGm;
        private View cYU;
        public TextView gCr;
        public ReplyLinearLayout gKf;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gKf = (ReplyLinearLayout) view.findViewById(e.g.content_container);
            this.gCr = (TextView) view.findViewById(e.g.original_post_title);
            this.cYU = view.findViewById(e.g.reply_top_line);
            this.cGm = view.findViewById(e.g.reply_bottom_line);
            this.gCr.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void ey(int i) {
            super.ey(i);
            al.i(this.gCr, e.d.cp_bg_line_e);
            al.c(this.gCr, e.d.cp_cont_b, 1);
            al.i(this.cYU, e.d.cp_bg_line_b);
            al.i(this.cGm, e.d.cp_bg_line_b);
        }
    }
}
