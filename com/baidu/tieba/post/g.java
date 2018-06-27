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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private BdUniqueId aqU;
    private TbPageContext<BaseFragmentActivity> cVl;
    private PersonPostModel fZU;
    private PersonPostModel.a giv;
    private final PersonPostModel.a giw = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.fZU = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.fZU.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.fZU != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.fZU.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.giv != null) {
                g.this.giv.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0221a gix = new a.InterfaceC0221a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0221a
        public void bt(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) g.this.cVl.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) g.this.cVl.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.cVl.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.cVl.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String mPortraitUrl;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.cVl = tbPageContext;
        this.mUid = str;
        this.aqU = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.giv = aVar;
    }

    public void lO(boolean z) {
        if (this.fZU == null) {
            this.fZU = new PersonPostModel(this.cVl, this.aqU, null, true, PersonPostModel.FROM_PERSON_POST);
            this.fZU.setUniqueId(this.aqU);
        }
        this.fZU.fetchPost(this.cVl, this.giw, z, this.mUid, false, true, false);
    }

    public void avN() {
        if (this.fZU != null) {
            this.fZU.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fZU == null || this.fZU.postList == null) {
            return 0;
        }
        return this.fZU.postList.size();
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
            aVar = new a(view, this.cVl);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gbe.setVisibility(0);
        } else {
            aVar.gbe.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList rP(int i) {
        return (PersonPostModel.PostInfoList) this.fZU.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList rP = rP(i);
        if (this.mPortraitUrl == null) {
            this.mPortraitUrl = rP.user_portrait;
        }
        aVar.a(rP, false, this.mPortraitUrl);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = rP.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (rP.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!rP.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = rP.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(rP.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(rP.thread_id), String.valueOf(rP.content[i2].post_id), String.valueOf(rP.content[i2].post_type), ap.w(rP.content[i2].create_time * 1000), String.valueOf(rP.thread_type)});
            }
        }
        aVar.giz.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(rP.title).find()) {
            aVar.gaX.setText(rP.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gaX.setText(rP.title);
        }
        if (rP.originalThreadInfo != null && !StringUtils.isNull(rP.originalThreadInfo.showText)) {
            aVar.gaX.setText("分享：" + rP.originalThreadInfo.showText);
        }
        aVar.gaX.setTag(new String[]{String.valueOf(rP.thread_id), null, null, String.valueOf(rP.thread_type)});
        if (rP.thread_type == 33) {
            aVar.gaX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gaX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.i(aVar.gaX, d.f.person_post_line);
        am.c(aVar.gaX, d.C0142d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.gaX.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gix);
        aVar.dz(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cjz;
        private View cwU;
        public TextView gaX;
        public ReplyLinearLayout giz;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.giz = (ReplyLinearLayout) view.findViewById(d.g.content_container);
            this.gaX = (TextView) view.findViewById(d.g.original_post_title);
            this.cwU = view.findViewById(d.g.reply_top_line);
            this.cjz = view.findViewById(d.g.reply_bottom_line);
            this.gaX.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void dz(int i) {
            super.dz(i);
            am.i(this.gaX, d.C0142d.cp_bg_line_e);
            am.c(this.gaX, d.C0142d.cp_cont_b, 1);
            am.i(this.cwU, d.C0142d.cp_bg_line_b);
            am.i(this.cjz, d.C0142d.cp_bg_line_b);
        }
    }
}
