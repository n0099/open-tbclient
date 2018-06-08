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
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private BdUniqueId aKh;
    private TbPageContext<BaseFragmentActivity> cXj;
    private PersonPostModel fVS;
    private PersonPostModel.a geu;
    private final PersonPostModel.a gev = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.fVS = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.fVS.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.fVS != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.fVS.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.geu != null) {
                g.this.geu.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0219a gew = new a.InterfaceC0219a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0219a
        public void bs(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) g.this.cXj.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) g.this.cXj.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.cXj.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.cXj.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String mPortraitUrl;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.cXj = tbPageContext;
        this.mUid = str;
        this.aKh = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.geu = aVar;
    }

    public void lE(boolean z) {
        if (this.fVS == null) {
            this.fVS = new PersonPostModel(this.cXj, this.aKh, null, true, PersonPostModel.FROM_PERSON_POST);
            this.fVS.setUniqueId(this.aKh);
        }
        this.fVS.fetchPost(this.cXj, this.gev, z, this.mUid, false, true, false);
    }

    public void avk() {
        if (this.fVS != null) {
            this.fVS.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fVS == null || this.fVS.postList == null) {
            return 0;
        }
        return this.fVS.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.cXj);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.fXe.setVisibility(0);
        } else {
            aVar.fXe.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList rG(int i) {
        return (PersonPostModel.PostInfoList) this.fVS.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList rG = rG(i);
        if (this.mPortraitUrl == null) {
            this.mPortraitUrl = rG.user_portrait;
        }
        aVar.a(rG, false, this.mPortraitUrl);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = rG.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (rG.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!rG.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = rG.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(rG.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(rG.thread_id), String.valueOf(rG.content[i2].post_id), String.valueOf(rG.content[i2].post_type), ao.v(rG.content[i2].create_time * 1000), String.valueOf(rG.thread_type)});
            }
        }
        aVar.gey.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(rG.title).find()) {
            aVar.fWX.setText(rG.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.fWX.setText(rG.title);
        }
        if (rG.originalThreadInfo != null && !StringUtils.isNull(rG.originalThreadInfo.showText)) {
            aVar.fWX.setText("分享：" + rG.originalThreadInfo.showText);
        }
        aVar.fWX.setTag(new String[]{String.valueOf(rG.thread_id), null, null, String.valueOf(rG.thread_type)});
        if (rG.thread_type == 33) {
            aVar.fWX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.fWX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.fWX, d.f.person_post_line);
        al.c(aVar.fWX, d.C0141d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.fWX.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gew);
        aVar.dy(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View chp;
        private View cza;
        public TextView fWX;
        public ReplyLinearLayout gey;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gey = (ReplyLinearLayout) view.findViewById(d.g.content_container);
            this.fWX = (TextView) view.findViewById(d.g.original_post_title);
            this.cza = view.findViewById(d.g.reply_top_line);
            this.chp = view.findViewById(d.g.reply_bottom_line);
            this.fWX.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void dy(int i) {
            super.dy(i);
            al.i(this.fWX, d.C0141d.cp_bg_line_e);
            al.c(this.fWX, d.C0141d.cp_cont_b, 1);
            al.i(this.cza, d.C0141d.cp_bg_line_b);
            al.i(this.chp, d.C0141d.cp_bg_line_b);
        }
    }
}
