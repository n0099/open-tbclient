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
    private BdUniqueId aCv;
    private TbPageContext<BaseFragmentActivity> dxc;
    private String gAn;
    private PersonPostModel gBp;
    private PersonPostModel.a gKc;
    private final PersonPostModel.a gKd = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.gBp = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.gBp.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.gBp != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.gBp.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.gKc != null) {
                g.this.gKc.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0299a gKe = new a.InterfaceC0299a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0299a
        public void bO(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == e.g.portrait) {
                ((BaseFragmentActivity) g.this.dxc.getOrignalPage()).finish();
            } else if (id == e.g.username) {
                ((BaseFragmentActivity) g.this.dxc.getOrignalPage()).finish();
            } else if ((id == e.g.item_header || id == e.g.original_post_title || id == e.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.dxc.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.dxc.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.dxc = tbPageContext;
        this.mUid = str;
        this.aCv = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gKc = aVar;
    }

    public void mH(boolean z) {
        if (this.gBp == null) {
            this.gBp = new PersonPostModel(this.dxc, this.aCv, null, true, PersonPostModel.FROM_PERSON_POST);
            this.gBp.setUniqueId(this.aCv);
        }
        this.gBp.fetchPost(this.dxc, this.gKd, z, this.mUid, false, true, false);
    }

    public void aEp() {
        if (this.gBp != null) {
            this.gBp.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gBp == null || this.gBp.postList == null) {
            return 0;
        }
        return this.gBp.postList.size();
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
            aVar = new a(view, this.dxc);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gCz.setVisibility(0);
        } else {
            aVar.gCz.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList tK(int i) {
        return (PersonPostModel.PostInfoList) this.gBp.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList tK = tK(i);
        if (this.gAn == null) {
            this.gAn = tK.user_portrait;
        }
        aVar.a(tK, false, this.gAn);
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
        aVar.gKg.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(tK.title).find()) {
            aVar.gCs.setText(tK.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gCs.setText(tK.title);
        }
        if (tK.originalThreadInfo != null && !StringUtils.isNull(tK.originalThreadInfo.showText)) {
            aVar.gCs.setText("分享：" + tK.originalThreadInfo.showText);
        }
        aVar.gCs.setTag(new String[]{String.valueOf(tK.thread_id), null, null, String.valueOf(tK.thread_type)});
        if (tK.thread_type == 33) {
            aVar.gCs.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gCs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.gCs, e.f.person_post_line);
        al.c(aVar.gCs, e.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(e.C0210e.ds20);
        aVar.gCs.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gKe);
        aVar.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cGn;
        private View cYV;
        public TextView gCs;
        public ReplyLinearLayout gKg;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gKg = (ReplyLinearLayout) view.findViewById(e.g.content_container);
            this.gCs = (TextView) view.findViewById(e.g.original_post_title);
            this.cYV = view.findViewById(e.g.reply_top_line);
            this.cGn = view.findViewById(e.g.reply_bottom_line);
            this.gCs.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void ey(int i) {
            super.ey(i);
            al.i(this.gCs, e.d.cp_bg_line_e);
            al.c(this.gCs, e.d.cp_cont_b, 1);
            al.i(this.cYV, e.d.cp_bg_line_b);
            al.i(this.cGn, e.d.cp_bg_line_b);
        }
    }
}
