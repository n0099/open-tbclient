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
    private TbPageContext<BaseFragmentActivity> dtE;
    private PersonPostModel.a gGg;
    private final PersonPostModel.a gGh = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.gxt = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.gxt.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.gxt != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.gxt.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.gGg != null) {
                g.this.gGg.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0299a gGi = new a.InterfaceC0299a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0299a
        public void bL(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == e.g.portrait) {
                ((BaseFragmentActivity) g.this.dtE.getOrignalPage()).finish();
            } else if (id == e.g.username) {
                ((BaseFragmentActivity) g.this.dtE.getOrignalPage()).finish();
            } else if ((id == e.g.item_header || id == e.g.original_post_title || id == e.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.dtE.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.dtE.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String gwr;
    private PersonPostModel gxt;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.dtE = tbPageContext;
        this.mUid = str;
        this.aBS = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gGg = aVar;
    }

    public void mE(boolean z) {
        if (this.gxt == null) {
            this.gxt = new PersonPostModel(this.dtE, this.aBS, null, true, PersonPostModel.FROM_PERSON_POST);
            this.gxt.setUniqueId(this.aBS);
        }
        this.gxt.fetchPost(this.dtE, this.gGh, z, this.mUid, false, true, false);
    }

    public void aDd() {
        if (this.gxt != null) {
            this.gxt.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gxt == null || this.gxt.postList == null) {
            return 0;
        }
        return this.gxt.postList.size();
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
            aVar = new a(view, this.dtE);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gyD.setVisibility(0);
        } else {
            aVar.gyD.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList tt(int i) {
        return (PersonPostModel.PostInfoList) this.gxt.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList tt = tt(i);
        if (this.gwr == null) {
            this.gwr = tt.user_portrait;
        }
        aVar.a(tt, false, this.gwr);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = tt.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (tt.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!tt.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = tt.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(tt.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(tt.thread_id), String.valueOf(tt.content[i2].post_id), String.valueOf(tt.content[i2].post_type), ao.L(tt.content[i2].create_time * 1000), String.valueOf(tt.thread_type)});
            }
        }
        aVar.gGk.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(tt.title).find()) {
            aVar.gyw.setText(tt.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gyw.setText(tt.title);
        }
        if (tt.originalThreadInfo != null && !StringUtils.isNull(tt.originalThreadInfo.showText)) {
            aVar.gyw.setText("分享：" + tt.originalThreadInfo.showText);
        }
        aVar.gyw.setTag(new String[]{String.valueOf(tt.thread_id), null, null, String.valueOf(tt.thread_type)});
        if (tt.thread_type == 33) {
            aVar.gyw.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gyw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.gyw, e.f.person_post_line);
        al.c(aVar.gyw, e.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(e.C0210e.ds20);
        aVar.gyw.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gGi);
        aVar.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cEB;
        private View cVt;
        public ReplyLinearLayout gGk;
        public TextView gyw;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gGk = (ReplyLinearLayout) view.findViewById(e.g.content_container);
            this.gyw = (TextView) view.findViewById(e.g.original_post_title);
            this.cVt = view.findViewById(e.g.reply_top_line);
            this.cEB = view.findViewById(e.g.reply_bottom_line);
            this.gyw.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void ey(int i) {
            super.ey(i);
            al.i(this.gyw, e.d.cp_bg_line_e);
            al.c(this.gyw, e.d.cp_cont_b, 1);
            al.i(this.cVt, e.d.cp_bg_line_b);
            al.i(this.cEB, e.d.cp_bg_line_b);
        }
    }
}
